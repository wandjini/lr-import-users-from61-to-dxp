package com.liferay.suez.synch.users;


import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.suez.synch.users.adapter.ExtUserToUserAdapter;
import com.liferay.suez.synch.users.configuration.SynchSuezUsersConfiguration;
import com.liferay.suez.synch.users.util.SuezMigrationRequest;
import com.liferay.suez.synch.users.util.SynchSuezUsersKeys;
import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.suez.user.synch.service.ExtCompanyLocalService;
import com.liferay.suez.user.synch.service.ExtRoleLocalService;
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

	}
	@Deactivate
	protected void deactivate() {
		//_schedulerEngineHelper.unregister(this);
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		try {
			SuezMigrationRequest suezMigrationRequest = (SuezMigrationRequest) message.getPayload();
			int take = _configuration.itemsPerPage();
			int end = take;
			int start  = 0;
			int count = 0;
			long extCompanyId = suezMigrationRequest.getExtCompanyId();
			long extRoleId = 0;
			long newRoleId = 0;
			List<ExtUser> extUsers = null;
			
			//Just to import at most take users
			//final version will provide a cycle to get all users
			Iterator<Long> mapRolesIterator = suezMigrationRequest.getExtRoleNewRoleMap().keySet().iterator();
			
			while(mapRolesIterator.hasNext()){
				extRoleId = mapRolesIterator.next();
				newRoleId = suezMigrationRequest.getExtRoleNewRoleMap().get(extRoleId);
				count = _extUserLocalService.countExtUsersByCompanyAndRole(extCompanyId, extRoleId, 
							suezMigrationRequest.getStartDate(),
							suezMigrationRequest.getEndDate());
				
				do {
					extUsers = _extUserLocalService.findExtUsersByCompanyAndRole(extCompanyId, extRoleId, 
							suezMigrationRequest.getStartDate(),
							suezMigrationRequest.getEndDate(), start, count < end ? count:end);
					if(extUsers != null && !extUsers.isEmpty()){
						importUsers(newRoleId, extUsers, suezMigrationRequest);
					}
					start = end;
					end+=take;
				}while(count < end);
				
				
			}
			
			
		} catch (Exception e) {
			_log.debug(e);
		}
		
	}

	/**
	 * Business method to import user and group/role association
	 * @param newRoleId
	 * @param extUsers
	 * @param suezMigrationRequest
	 * @throws PortalException
	 * @throws ParseException
	 */
	private void importUsers(long newRoleId, final List<ExtUser> extUsers, SuezMigrationRequest suezMigrationRequest ) 
			throws PortalException, ParseException{
		
		long[] userIds = null;
		long[] groupIds = null;
		User user = null;
		
		ServiceContext serviceContext = suezMigrationRequest.getServiceContext() ;

		_log.info("Found ["+extUsers.size()+"] users");
		ExtUserToUserAdapter userAdapter = new ExtUserToUserAdapter();
		for(ExtUser extUser : extUsers){
			user =_userLocalService.fetchUserByEmailAddress(suezMigrationRequest.getExtCompanyId(), extUser.getEmailAddress());
			if(user == null){
				//addUser(companyId, creatorUserId, extUser);
				userAdapter.setExtUser(extUser);
				user = _userLocalService.addUser(
						userAdapter.adaptExternalUsertoUser(new long[]{suezMigrationRequest.getDestinationGroupId()},
								new long[]{newRoleId}, serviceContext));
				
				_roleLocalService.addUserRole(user.getUserId(), newRoleId);
				_userLocalService.addGroupUser(suezMigrationRequest.getDestinationGroupId(), user.getUserId());
			}
			else{
				//Associate user to destination group with new role
				groupIds = _userLocalService.getGroupPrimaryKeys(user.getUserId());
				if( groupIds != null && 
						!ArrayUtil.contains(groupIds, suezMigrationRequest.getDestinationGroupId())){
					
					_groupLocalService.addUserGroup(user.getUserId(), suezMigrationRequest.getDestinationGroupId());
					userAdapter.reindex(user);
				}
				
				userIds = _roleLocalService.getUserPrimaryKeys(newRoleId);
				if( userIds != null && 
						!ArrayUtil.contains(userIds, user.getUserId())){
					_userLocalService.addRoleUser(newRoleId, user);
					userAdapter.reindex(user);
				}
			}
			
		}
		
	}
	
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
	protected void setRoleLocalService(
			RoleLocalService roleLocalService) {
		_roleLocalService = roleLocalService;
	}
	
	protected RoleLocalService _roleLocalService;
	
	
	@Reference(unbind = "-")
	protected void setSiteLocalService(
			GroupLocalService groupLocalService) {
		_groupLocalService = groupLocalService;
	}
	
	protected GroupLocalService _groupLocalService;
	
	
	private volatile SynchSuezUsersConfiguration _configuration;
	
	private static final Log _log = LogFactoryUtil.getLog(
			SynchSuezUsersMessageListener.class);
	
}