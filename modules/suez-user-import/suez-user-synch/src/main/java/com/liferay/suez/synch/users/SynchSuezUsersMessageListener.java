package com.liferay.suez.synch.users;


import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.suez.synch.users.adapter.ExtUserToUserAdapter;
import com.liferay.suez.synch.users.configuration.SynchSuezUsersConfiguration;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;
import com.liferay.suez.user.management.service.UserManagementLocalService;
import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.suez.user.synch.service.ExtUserLocalService;

import aQute.bnd.annotation.metatype.Configurable;

/**
 * 
 * @author guy
 *
 */
@Component(
	immediate = true,
	property = {"destination.name=" + SynchSuezUsersKeys.DESTINATION_NAME},
	configurationPid = "com.liferay.suez.synch.users.configuration.SynchSuezUsersConfiguration",
	configurationPolicy = ConfigurationPolicy.OPTIONAL,
	service = MessageListener.class
)
public class SynchSuezUsersMessageListener extends BaseMessageListener {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		
		
		_configuration =
			Configurable.createConfigurable(
					SynchSuezUsersConfiguration.class, properties);

	/*		schedulerEntryImpl.setTrigger(TriggerFactoryUtil.createTrigger(getEventListenerClass(), getEventListenerClass(),
				_configuration.synchSuezUsersInterval(), TimeUnit.MINUTE));

			_schedulerEngineHelper.register(
				this, schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);
	*/		
	}
	@Deactivate
	protected void deactivate() {
		//_schedulerEngineHelper.unregister(this);
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		try {
			int take = _configuration.itemsPerPage();
			int start  = 0;
			int count = _extUserLocalService.countExtUsers();
			List<ExtUser> extUsers = null; 
			long creatorUserId = _configuration.creatorUserId();
			long companyId = _configuration.companyId();
			User user = null;
			//Just to import at most take users
			//final version will provide a cycle to get all users
			extUsers = _extUserLocalService.findExtUsers(start ,count < take ? count:take);
			
			
			//while(start )
			if(extUsers != null && !extUsers.isEmpty()){
				_log.info("Found ["+extUsers.size()+"] users");
				ExtUserToUserAdapter userAdapter = new ExtUserToUserAdapter();
				for(ExtUser extUser : extUsers){
					user =_userLocalService.fetchUserByEmailAddress(companyId, extUser.getEmailAddress());
					if(user == null){
						//addUser(companyId, creatorUserId, extUser);
						userAdapter.setExtUser(extUser);
						_userLocalService.addUser(userAdapter.adaptExternalUsertoUser(companyId, creatorUserId));
					}
					
				}
			}
			else
				_log.info("No Ext users found");
			
		} catch (Exception e) {
			_log.debug(e);
		}
	}

	/*
	private void addUser(long companyId, long creatorUserId, ExtUser extUser) throws PortalException, ParseException{
		_userManagementLocalService.addExtUser(companyId, 
				extUser.getCreateDate(), creatorUserId, extUser.getModifiedDate(), 
				false, 
				extUser.getPassword(), 
				extUser.getPasswordEncrypted(), 
				extUser.getPasswordReset(), 
				extUser.getPasswordModifiedDate(), 
				extUser.getDigest(), 
				extUser.getReminderQueryQuestion(), 
				extUser.getReminderQueryAnswer(), 
				extUser.getGraceLoginCount(), 
				extUser.getScreenName(),
				extUser.getEmailAddress(), 
				extUser.getFacebookId(), 
				extUser.getOpenId(), 
				0, 
				extUser.getLanguageId(), 
				extUser.getTimeZoneId(), 
				extUser.getGreeting(), 
				extUser.getComments(), 
				extUser.getFirstName(), 
				extUser.getMiddleName(), 
				extUser.getLastName(), 
				extUser.getJobTitle(), 
				extUser.getLoginDate(), 
				extUser.getLoginIP(), 
				extUser.getLastLoginDate(), 
				extUser.getLastLoginIP(), 
				extUser.getLastFailedLoginDate(),
				extUser.getFailedLoginAttempts(), 
				new Locale("en"), 
				extUser.getLockout(), 
				extUser.getLockoutDate(), 
				extUser.getAgreedToTermsOfUse(), 
				extUser.getEmailAddressVerified(), 
				extUser.getStatus(), null);

	}
	
	*/
	@Modified
	protected void modified(Map<String, Object> properties) {
		deactivate();

		activate(properties);
	}

	
	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(
		ModuleServiceLifecycle moduleServiceLifecycle) {
	}
	
	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
			SchedulerEngineHelper schedulerEngineHelper) {
		_schedulerEngineHelper = schedulerEngineHelper;
	}
	
	protected SchedulerEngineHelper _schedulerEngineHelper;
	
	@Reference(unbind = "-")
	protected void setTriggerFactory(
			TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}
	
	protected TriggerFactory _triggerFactory;
	
	@Reference(unbind = "-")
	protected void setExtUserLocalService(
			ExtUserLocalService extUserLocalService) {
		_extUserLocalService = extUserLocalService;
	}
	
	protected ExtUserLocalService _extUserLocalService;
	
	@Reference(unbind = "-")
	protected void setUserLocalService(
			UserLocalService userLocalService) {
		_userLocalService = userLocalService;
	}
	
	protected UserLocalService _userLocalService;
	
	@Reference(unbind = "-")
	protected void setUserManagementLocalService(
			UserManagementLocalService userManagementLocalService) {
		_userManagementLocalService = userManagementLocalService;
	}
	
	protected UserManagementLocalService _userManagementLocalService;
	
	
	private volatile SynchSuezUsersConfiguration _configuration;
	
	private static final Log _log = LogFactoryUtil.getLog(
			SynchSuezUsersMessageListener.class);
	
}