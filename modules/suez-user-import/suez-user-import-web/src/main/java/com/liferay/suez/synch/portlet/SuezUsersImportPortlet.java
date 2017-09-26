package com.liferay.suez.synch.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			long extCompanyId = ParamUtil.getLong(renderRequest, "extCompanyId");
			long destinationGroupId = ParamUtil.getLong(renderRequest, "destinationGroupId");
			extCompanies = _extCompanyLocalService.getExtCompanies(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(extCompanyId > 0){
				extRoles = _extRoleLocalService.getExtRolesByCompanyAndName(extCompanyId, "OVS");
				
				
			}
			if(destinationGroupId > 0){
				newRoles = _roleLocalService.getGroupRelatedRoles(destinationGroupId);
			}
			Company company = themeDisplay.getCompany();
			List<Group> allGroups = _groupLocalService.getActiveGroups(company.getCompanyId(), true);
			if(allGroups != null && !allGroups.isEmpty()){
				//Stream<Group> streamGroup = allGroups.stream().filter(group -> (group.isSite() && !group.isUserPersonalSite()));
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
			renderRequest.setAttribute("extCompanyId", extCompanyId);
			renderRequest.setAttribute("destinationGroupId", destinationGroupId);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		super.doView(renderRequest, renderResponse);
	}

	public void importUsers(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		
		
		SuezMigrationRequest suezMigrationRequest = new SuezMigrationRequest();
		setMigrationRequest(actionRequest, suezMigrationRequest);
		int extRolesSize  = ParamUtil.getInteger(actionRequest, "extRolesSize");
		List<String> errors = new ArrayList<>();
		if(SuezMigrationsRequestValidator.isSuezMigrationRequestValid(suezMigrationRequest, extRolesSize, errors)){
			Message message = new Message();
			message.setPayload(suezMigrationRequest);
			MessageBusUtil.sendMessage(SynchSuezUsersKeys.DESTINATION_NAME, message);
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
	
	private void setMigrationRequest(ActionRequest actionRequest, 
			SuezMigrationRequest  suezMigrationRequest) throws PortalException{
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		suezMigrationRequest.setDestinationGroupId(ParamUtil.getLong(actionRequest, "destinationGroupId"));
		suezMigrationRequest.setExtCompanyId(ParamUtil.getLong(actionRequest, "extCompanyId"));
		suezMigrationRequest.setServiceContext(ServiceContextFactory.getInstance(actionRequest));
		Long extRoleId_1 = ParamUtil.getLong(actionRequest, "extRoleId_1");
		Long extRoleId_2 = ParamUtil.getLong(actionRequest, "extRoleId_2");
		Long extRoleId_3 = ParamUtil.getLong(actionRequest, "extRoleId_3");
		Long extRoleId_4 = ParamUtil.getLong(actionRequest, "extRoleId_4");
		Long destRoleId_1 = ParamUtil.getLong(actionRequest, "destRoleId_1");
		Long destRoleId_2 = ParamUtil.getLong(actionRequest, "destRoleId_2");
		Long destRoleId_3 = ParamUtil.getLong(actionRequest, "destRoleId_3");
		Long destRoleId_4 = ParamUtil.getLong(actionRequest, "destRoleId_4");
		Map<Long, Long> extRoleNewRoleMap = new HashMap<>();
		int extRolesSize  = ParamUtil.getInteger(actionRequest, "extRolesSize");
		
		if(extRoleId_1 > 0)
			extRoleNewRoleMap.put(extRoleId_1, destRoleId_1);
		if(extRolesSize > 1)
			extRoleNewRoleMap.put(extRoleId_2, destRoleId_2);
		if(extRolesSize > 2)
			extRoleNewRoleMap.put(extRoleId_3, destRoleId_3);
		if(extRolesSize > 3)
			extRoleNewRoleMap.put(extRoleId_4, destRoleId_4);
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
	
	@Reference
	public void setGroupLocalService(GroupLocalService groupLocalService){
		_groupLocalService = groupLocalService;
	}
	private GroupLocalService _groupLocalService;
	
	@Reference
	public void setRoleLocalService(RoleLocalService roleLocalService){
		_roleLocalService = roleLocalService;
	}
	private RoleLocalService _roleLocalService;
	
	@Reference(unbind = "-")
	protected void setExtCompanyLocalService(
			ExtCompanyLocalService extCompanyLocalService) {
		_extCompanyLocalService = extCompanyLocalService;
	}
	
	protected ExtCompanyLocalService _extCompanyLocalService;
	
	@Reference(unbind = "-")
	protected void setExtRoleLocalService(
			ExtRoleLocalService extRoleLocalService) {
		_extRoleLocalService = extRoleLocalService;
	}
	
	protected ExtRoleLocalService _extRoleLocalService;
	
}