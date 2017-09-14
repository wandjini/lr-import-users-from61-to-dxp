package com.liferay.suez.synch.portlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.suez.synch.users.util.SuezMigrationRequest;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;
import com.liferay.suez.synch.validation.SuezMigrationsRequestValidator;

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

	public void importUsers(ActionRequest actionRequest, ActionResponse actionResponse) throws PortalException{
		
		
		SuezMigrationRequest suezMigrationRequest = new SuezMigrationRequest();
		setMigrationRequest(actionRequest, suezMigrationRequest);
		List<String> errors = new ArrayList<>();
		if(SuezMigrationsRequestValidator.isSuezMigrationRequestValid(suezMigrationRequest, errors)){
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
		Long destRoleId_1 = ParamUtil.getLong(actionRequest, "destRoleId_1");
		Long destRoleId_2 = ParamUtil.getLong(actionRequest, "destRoleId_2");
		Long destRoleId_3 = ParamUtil.getLong(actionRequest, "destRoleId_3");
		Map<Long, Long> extRoleNewRoleMap = new HashMap<>();
		extRoleNewRoleMap.put(extRoleId_1, destRoleId_1);
		extRoleNewRoleMap.put(extRoleId_2, destRoleId_2);
		extRoleNewRoleMap.put(extRoleId_3, destRoleId_3);
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
	
}