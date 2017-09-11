package com.liferay.suez.synch.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;

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

	public void importUsers(ActionRequest actionRequest, ActionResponse actionResponse){
		
		MessageBusUtil.sendMessage(SynchSuezUsersKeys.DESTINATION_NAME, actionRequest);
	}
}