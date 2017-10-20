package com.liferay.suez.synch.users;


import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
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
		
		
		confguration =
			Configurable.createConfigurable(
					SynchSuezUsersConfiguration.class, properties);

	}
	

	@Override
	protected void doReceive(Message message) throws Exception {
		try {
			_log.debug("Start Migration date "+ new Date());
			SuezMigrationRequest suezMigrationRequest = (SuezMigrationRequest) message.getPayload();
			int take = confguration.itemsPerPage();
			int end = take;
			int start  = 0;
			int count = 0;
			int total = 0;
			long extCompanyId = suezMigrationRequest.getExtCompanyId();
			long extRoleId = 0;
			long newRoleId = 0;
			List<ExtUser> extUsers = null;
			
			_log.debug("Migration request");
			_log.debug("External Company Id: "+suezMigrationRequest.getExtCompanyId());
			_log.debug("Destination site Id: "+suezMigrationRequest.getDestinationGroupId());
			_log.debug("Start Date: "+suezMigrationRequest.getStartDate());
			_log.debug("End Date: "+suezMigrationRequest.getEndDate());
			
			//Just to import at most take users
			//final version will provide a cycle to get all users
			Iterator<Long> mapRolesIterator = suezMigrationRequest.getExtRoleNewRoleMap().keySet().iterator();
			int i = 1;
			while(mapRolesIterator.hasNext()){
				extRoleId = mapRolesIterator.next();
				newRoleId = suezMigrationRequest.getExtRoleNewRoleMap().get(extRoleId);
				_log.debug("External Role_"+i+": "+extRoleId);
				_log.debug("Destination Role_"+ i++ +": "+newRoleId);
				count = extUserLocService.countExtUsersByCompanyAndRole(extCompanyId, extRoleId, 
							suezMigrationRequest.getStartDate(),
							suezMigrationRequest.getEndDate());
				
				extUsers = extUserLocService.findExtUsersByCompanyAndRole(extCompanyId, extRoleId, 
						suezMigrationRequest.getStartDate(),
						suezMigrationRequest.getEndDate(), start, count < end ? count:end);
				while(extUsers != null && !extUsers.isEmpty() )
				{
					
					total += importUsers(newRoleId, extUsers, suezMigrationRequest);
				
					start = end;
					end+=take;
					extUsers = extUserLocService.findExtUsersByCompanyAndRole(extCompanyId, extRoleId, 
							suezMigrationRequest.getStartDate(),
							suezMigrationRequest.getEndDate(), start, count < end ? count:end);
						
				}
				start = 0;
				end = take;
			}
			
			_log.debug("Total new users "+ total);
			_log.debug("End Migration date "+ new Date());
		} catch (Exception e) {
			_log.debug(e);
		}
		
	}

	/**
	 * Business method to import user and group/role association
	 * 
	 * @return number of users created
	 * 
	 * @param newRoleId
	 * @param extUsers
	 * @param suezMigrationRequest
	 * @throws PortalException
	 * @throws ParseException
	 */
	private int  importUsers(long newRoleId, final List<ExtUser> extUsers, SuezMigrationRequest suezMigrationRequest ) 
			throws PortalException, ParseException{
		
		
		User user = null;
		int total = 0;
		long destinationGroupId = suezMigrationRequest.getDestinationGroupId();
		String email2Check = "";
		String screenName2Check = "";
		ServiceContext serviceContext = suezMigrationRequest.getServiceContext() ;
		ExtUserToUserAdapter userAdapter = new ExtUserToUserAdapter();
		
		for(ExtUser extUser : extUsers){
			email2Check = destinationGroupId +"#"+extUser.getEmailAddress();
			screenName2Check = extUser.getScreenName()+"#"+destinationGroupId;
			
			if(email2Check.length() > 75 || 
					screenName2Check.length() > 75){
				_log.debug("Email: "+email2Check+ " or screenName: " + screenName2Check +" can't be imported because it's too long");
				continue;
			}
			
			if(extUser.isDefaultUser()){
				_log.debug("External user: "+extUser.getEmailAddress()+" is default user and can't be migrated");
			}

			
			user =userLocService.fetchUserByEmailAddress(serviceContext.getCompanyId(), email2Check);
			//Also find if screenName is already used
			if(user == null)
				user = userLocService.fetchUserByScreenName(serviceContext.getCompanyId(), screenName2Check);
			
			if(user == null){
				
				userAdapter.setExtUser(extUser);
				try {
					user = 
							userAdapter.adaptExternalUsertoUser(new long[]{suezMigrationRequest.getDestinationGroupId()},
									new long[]{newRoleId}, serviceContext);
					
					userGroupRoleLocService.addUserGroupRoles(user.getUserId(),suezMigrationRequest.getDestinationGroupId(), new long[]{newRoleId});
					userLocService.addGroupUser(suezMigrationRequest.getDestinationGroupId(), user.getUserId());
					total +=1;
				} catch (Exception e) {
					_log.debug("Error importing user: "+extUser.getEmailAddress() + "Cause: "+e.getMessage());
					_log.debug(e);
				}
				
			}
			 
			else{

				if( !userGroupRoleLocService.hasUserGroupRole(user.getUserId(),
						suezMigrationRequest.getDestinationGroupId(), newRoleId))
				{
					
					userGroupRoleLocService.addUserGroupRoles(user.getUserId(),suezMigrationRequest.getDestinationGroupId(), new long[]{newRoleId});
					userAdapter.reindex(user);
					_log.debug("Associated existing user: "+user.getEmailAddress()+" to roleId "+newRoleId);
				}
			}
			
		}
		return total;
	}
	
	
	
	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
			SchedulerEngineHelper schedulerEngineHelper) {
		schedulrEngineHelper = schedulerEngineHelper;
	}
	
	protected SchedulerEngineHelper schedulrEngineHelper;
	
	@Reference(unbind = "-")
	protected void setTriggerFactory(
			TriggerFactory triggerFactory) {
		triggrFactory = triggerFactory;
	}
	
	protected TriggerFactory triggrFactory;
	
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
	protected void setExtUserLocalService(
			ExtUserLocalService extUserLocalService) {
		extUserLocService = extUserLocalService;
	}
	
	protected ExtUserLocalService extUserLocService;
	
	@Reference(unbind = "-")
	protected void setUserLocalService(
			UserLocalService userLocalService) {
		userLocService = userLocalService;
	}
	
	protected UserLocalService userLocService;
	
	
	@Reference(unbind = "-")
	protected void setRoleLocalService(
			RoleLocalService roleLocalService) {
		roleLocService = roleLocalService;
	}
	
	protected RoleLocalService roleLocService;
	
	
	@Reference(unbind = "-")
	protected void setSiteLocalService(
			GroupLocalService groupLocalService) {
		groupLocService = groupLocalService;
	}
	
	protected GroupLocalService groupLocService;
	
	@Reference(unbind = "-")
	protected void setUserGroupRoleLocalService(
			UserGroupRoleLocalService userGroupRoleLocalService) {
		userGroupRoleLocService = userGroupRoleLocalService;
	}
	protected UserGroupRoleLocalService userGroupRoleLocService;
	
	private volatile SynchSuezUsersConfiguration confguration;
	
	private static final Log _log = LogFactoryUtil.getLog(
			SynchSuezUsersMessageListener.class);
	
}