package com.liferay.suez.synch.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.suez.synch.users.util.SuezMigrationRequest;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;
import com.liferay.suez.synch.validation.SuezMigrationsRequestValidator;
import com.liferay.suez.user.synch.model.ExtCompany;
import com.liferay.suez.user.synch.model.ExtRole;
import com.liferay.suez.user.synch.service.ExtCompanyLocalService;
import com.liferay.suez.user.synch.service.ExtRoleLocalService;
import com.liferay.suez.user.synch.service.ExtUserLocalService;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=suez-user-import-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SuezUsersImportPortlet extends MVCPortlet {

	
	
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		try {
			List<ExtCompany> extCompanies = null;
			List<ExtRole> extRoles = null;
			List<Group> sites = null;
			List<Role> newRoles = null;
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long extCompanyId = ParamUtil.getLong(renderRequest, EXT_COMPANY_ID);
			long destinationGroupId = ParamUtil.getLong(renderRequest, DESTINATION_GROUP_ID);
			extCompanies = extCompanyLocService.getExtCompanies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(extCompanyId > 0){
				extRoles = extRoleLocService.getExtRolesByCompanyAndName(extCompanyId, "OVS");
				
				
			}
			if(destinationGroupId > 0){
				newRoles = roleLocService.getGroupRelatedRoles(destinationGroupId);
			}
			Company company = themeDisplay.getCompany();
			List<Group> allGroups = groupLocService.getActiveGroups(company.getCompanyId(), true);
			if(allGroups != null && !allGroups.isEmpty()){
				sites = new ArrayList<>();
				for(Group group : allGroups){
					if(!group.isUser() && group.isSite())
						sites.add(group);
				}
			}
			
			renderRequest.setAttribute("ExtCompanies", extCompanies);
			renderRequest.setAttribute("ExtRoles", extRoles);
			renderRequest.setAttribute("NewRoles", newRoles);
			renderRequest.setAttribute("Sites", sites);
			renderRequest.setAttribute(EXT_COMPANY_ID, extCompanyId);
			renderRequest.setAttribute(DESTINATION_GROUP_ID, destinationGroupId);
			
		} catch (Exception e) {
			log.debug(e);
		}
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * <p>This method trigger import process </p>
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 */
	public void importUsers(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		
		
		SuezMigrationRequest suezMigrationRequest = new SuezMigrationRequest();
		setMigrationRequest(actionRequest, suezMigrationRequest);
		int extRolesSize  = ParamUtil.getInteger(actionRequest, "extRolesSize");
		Long[] externalRoleIds = null;
		List<String> errors = new ArrayList<>();
		if(SuezMigrationsRequestValidator.isSuezMigrationRequestValid(suezMigrationRequest, extRolesSize, errors)){
			Message message = new Message();
			message.setPayload(suezMigrationRequest);
			MessageBusUtil.sendMessage(SynchSuezUsersKeys.DESTINATION_NAME, message);
			externalRoleIds = getLongArray(suezMigrationRequest.getExtRoleNewRoleMap().keySet());
			int totalUsersToProcess = extUserLocService.countExtUsersByCompanyAndRoleIds(suezMigrationRequest.getExtCompanyId(), 
					externalRoleIds, suezMigrationRequest.getStartDate(),
					suezMigrationRequest.getEndDate());
			//actionRequest.setAttribute("totalUsersToProcess", totalUsersToProcess);
		}
		else{
			if(!errors.isEmpty()){
				for(String error:errors){
					SessionErrors.add(actionRequest, error);
					
				}
			}
		}
		Map <String,String[] > parameters = actionRequest.getParameterMap();
		
		actionResponse.setRenderParameters(parameters);
		actionResponse.setRenderParameter("jspPath", "/view.jsp");
		
	}
	
	/**
	 * 
	 * <p>This method checks the migration request data </p>
	 * 
	 * @param actionRequest
	 * @param suezMigrationRequest
	 * @throws PortalException
	 */
	private void setMigrationRequest(ActionRequest actionRequest, 
			SuezMigrationRequest  suezMigrationRequest) throws PortalException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		suezMigrationRequest.setDestinationGroupId(ParamUtil.getLong(actionRequest, "destinationGroupId"));
		suezMigrationRequest.setExtCompanyId(ParamUtil.getLong(actionRequest, "extCompanyId"));
		suezMigrationRequest.setServiceContext(ServiceContextFactory.getInstance(actionRequest));
		Long extRoleId1 = ParamUtil.getLong(actionRequest, "extRoleId1");
		Long extRoleId2 = ParamUtil.getLong(actionRequest, "extRoleId2");
		Long extRoleId3 = ParamUtil.getLong(actionRequest, "extRoleId3");
		Long extRoleId4 = ParamUtil.getLong(actionRequest, "extRoleId4");
		Long destRoleId1 = ParamUtil.getLong(actionRequest, "destRoleId1");
		Long destRoleId2 = ParamUtil.getLong(actionRequest, "destRoleId2");
		Long destRoleId3 = ParamUtil.getLong(actionRequest, "destRoleId3");
		Long destRoleId4 = ParamUtil.getLong(actionRequest, "destRoleId4");
		Map<Long, Long> extRoleNewRoleMap = new HashMap<>();
		int extRolesSize  = ParamUtil.getInteger(actionRequest, "extRolesSize");
		
		if(extRoleId1 > 0)
			extRoleNewRoleMap.put(extRoleId1, destRoleId1);
		if(extRolesSize > 1)
			extRoleNewRoleMap.put(extRoleId2, destRoleId2);
		if(extRolesSize > 2)
			extRoleNewRoleMap.put(extRoleId3, destRoleId3);
		if(extRolesSize > 3)
			extRoleNewRoleMap.put(extRoleId4, destRoleId4);
		suezMigrationRequest.setExtRoleNewRoleMap(extRoleNewRoleMap);
		
		int fDay = ParamUtil.getInteger(actionRequest, "f_day");
		int fMonth = ParamUtil.getInteger(actionRequest, "f_month");
		int fYear = ParamUtil.getInteger(actionRequest, "f_year");
		
		int tDay = ParamUtil.getInteger(actionRequest, "t_day");
		int tMonth = ParamUtil.getInteger(actionRequest, "t_month");
		int tYear = ParamUtil.getInteger(actionRequest, "t_year");
		
		
		Date startDate = PortalUtil.getDate(
				fMonth, fDay, fYear, 0, 0,
				themeDisplay.getTimeZone(), PortalException.class);
		Date endDate = PortalUtil.getDate(
				tMonth, tDay, tYear, 0, 0,
				themeDisplay.getTimeZone(), PortalException.class);
		suezMigrationRequest.setEndDate(endDate);
		suezMigrationRequest.setStartDate(startDate);
		
	}
	
	/**
	 * Util method to get external roleids as array
	 * 
	 * @param ids
	 * @return
	 */
	protected Long [] getLongArray(Set<Long> ids) {
		  return  ids.toArray(new Long[0]);  
	}
	
	@Reference
	public void setGroupLocalService(GroupLocalService groupLocalService){
		groupLocService = groupLocalService;
	}
	private GroupLocalService groupLocService;
	
	@Reference
	public void setRoleLocalService(RoleLocalService roleLocalService){
		roleLocService = roleLocalService;
	}
	private RoleLocalService roleLocService;
	
	@Reference(unbind = "-")
	protected void setExtCompanyLocalService(
			ExtCompanyLocalService extCompanyLocalService) {
		extCompanyLocService = extCompanyLocalService;
	}
	
	protected ExtCompanyLocalService extCompanyLocService;
	
	@Reference(unbind = "-")
	protected void setExtRoleLocalService(
			ExtRoleLocalService extRoleLocalService) {
		extRoleLocService = extRoleLocalService;
	}
	
	protected ExtRoleLocalService extRoleLocService;
	
	@Reference(unbind = "-")
	protected void setUserLocalService(
			ExtUserLocalService extUserLocalService) {
		extUserLocService = extUserLocalService;
	}
	
	protected ExtUserLocalService extUserLocService;
	
	private static Log log = LogFactoryUtil.getLog(SuezUsersImportPortlet.class);
	private static final String DESTINATION_GROUP_ID = "destinationGroupId";
	private static final String EXT_COMPANY_ID = "extCompanyId";
	
}