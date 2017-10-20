package com.liferay.suez.synch.users.adapter;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ContactConstants;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ContactLocalService;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ResourceLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.users.admin.kernel.util.UsersAdminUtil;

/**
 * Class that adapts an ExtUser to Liferay's User.
 * @author ibairuiz
 *
 */
@Component(
		immediate = true,
		properties = {}
	)
public class ExtUserToUserAdapter {
	
	/** ExtUser instance to adapt.**/
	private ExtUser extUser;

	/**
	 * Default public constructor
	 */
	public ExtUserToUserAdapter() {
		super();
	}
	
	/**
	 * Constructor based on an external User.
	 * @param externalUser the external user to adapt.
	 */
	public ExtUserToUserAdapter(final ExtUser externalUser) {
		this.extUser = externalUser;
	}

	/**
	 * Method that adapts an ExtUser to User
	 * @param extUser Original 6.1 User
	 * @param user DXP User created beforehand
	 * @return updated User instance.
	 * @throws PortalException 
	 * @throws ParseException 
	 */
	public final User adaptExternalUsertoUser(long[] groupIds, long[] roleIds, ServiceContext serviceContext) 
			throws PortalException, ParseException {
		
		long companyId = serviceContext.getCompanyId();
		long creatorUserId = serviceContext.getUserId();
		String destinationGroupId = !ArrayUtil.isEmpty(groupIds) ? String.valueOf(groupIds[0]) : StringPool.BLANK;
		User user = userLocService.createUser(counterLoService.increment());
		user.setAgreedToTermsOfUse(this.extUser.getAgreedToTermsOfUse());
		user.setPasswordEncrypted(this.extUser.getPasswordEncrypted());
		user.setPassword(this.extUser.getPassword());
		user.setCompanyId(companyId);
		user.setReminderQueryQuestion(this.extUser.getReminderQueryQuestion());
		user.setReminderQueryAnswer(this.extUser.getReminderQueryAnswer());
		user.setComments(this.extUser.getComments());
		user.setLastFailedLoginDate(this.extUser.getLastFailedLoginDate());
		user.setLastLoginDate(this.extUser.getLastLoginDate());
		user.setLastLoginIP(this.extUser.getLastLoginIP());
		user.setLastFailedLoginDate(this.extUser.getLastFailedLoginDate());
		
		Company company = companyLocService.fetchCompany(companyId);
		// PLACEHOLDER 01
		User defltUser = userLocService.getDefaultUser(companyId);
		user.setDefaultUser(this.extUser.getDefaultUser() );
		user.setContactId(counterLoService.increment());
		user.setPasswordReset(this.extUser.getPasswordReset());
		user.setDigest(this.extUser.getDigest());
		user.setScreenName(this.extUser.getScreenName()+"#"+destinationGroupId);
		user.setEmailAddress(destinationGroupId+"#"+this.extUser.getEmailAddress());
		user.setFacebookId(this.extUser.getFacebookId());
		user.setLdapServerId(-1);
		user.setOpenId(this.extUser.getOpenId());
		user.setLanguageId(this.extUser.getLanguageId());
		user.setTimeZoneId(this.extUser.getTimeZoneId());
		user.setGreeting(this.extUser.getGreeting());
		user.setFirstName(this.extUser.getFirstName());
		user.setMiddleName(this.extUser.getMiddleName());
		user.setLastName(this.extUser.getLastName());
		user.setJobTitle(this.extUser.getJobTitle());
		user.setStatus(this.extUser.getStatus());
		user = userLocService.updateUser(user);
		// Contact
		String creatorUserName = StringPool.BLANK;
		if (creatorUserId <= 0) {
			creatorUserId = user.getUserId();
		}
		else {
			User creatorUser = UserLocalServiceUtil.fetchUser(creatorUserId);
			if(creatorUser != null)
				creatorUserName = creatorUser.getFullName();
		}

		Contact contact = ContactLocalServiceUtil.createContact(user.getContactId());
		contact.setCompanyId(user.getCompanyId());
		contact.setUserId(creatorUserId);
		contact.setUserName(creatorUserName);
		contact.setClassName(User.class.getName());
		contact.setClassPK(user.getUserId());
		contact.setAccountId(company.getAccountId());
		contact.setParentContactId(ContactConstants.DEFAULT_PARENT_CONTACT_ID);
		contact.setEmailAddress(user.getEmailAddress());
		contact.setFirstName(this.extUser.getFirstName());
		contact.setMiddleName(this.extUser.getMiddleName());
		contact.setLastName(this.extUser.getLastName());
		contact.setBirthday(DateUtil.parseDate("ddMMyyyy", "0101970", serviceContext.getLocale()));
		contact.setJobTitle(this.extUser.getJobTitle());
		contactLocService.updateContact(contact);
		// Group

		groupLocService.addGroup(
			user.getUserId(), GroupConstants.DEFAULT_PARENT_GROUP_ID,
			User.class.getName(), user.getUserId(),
			GroupConstants.DEFAULT_LIVE_GROUP_ID, (Map<Locale, String>)null,
			null, 0, true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION,
			StringPool.SLASH + user.getScreenName(), false, true, null);

		// Groups
		
		if (!ArrayUtil.isEmpty(groupIds)) {
			List<Group> groups = new ArrayList<>();

			for (long groupId : groupIds) {
				Group group = groupLocService.fetchGroup(groupId);

				if (group != null) {
					groups.add(group);
				}
				
			}
			groupLocService.addUserGroups(user.getUserId(), groups);
		}

		userLocService.addDefaultGroups(user.getUserId());
		// Roles
		
		if (roleIds != null) {
			UsersAdminUtil.addRequiredRoles(user, roleIds);

			
		}
		
		userLocService.addDefaultRoles(user.getUserId());
		// Resources

		resourceLocService.addResources(
			companyId, 0, creatorUserId, User.class.getName(), user.getUserId(),
			false, false, false);
		
		// Indexer

		reindex(user);

		// Workflow

		long workflowUserId = creatorUserId;

			if (workflowUserId == user.getUserId()) {
				workflowUserId = defltUser.getUserId();
			}
	
			ServiceContext	workflowServiceContext = new ServiceContext();
	
			workflowServiceContext.setAttribute("autoPassword", false);
			workflowServiceContext.setAttribute("sendEmail", null);
	
			WorkflowHandlerRegistryUtil.startWorkflowInstance(
				companyId, workflowUserId, User.class.getName(), user.getUserId(), user,
				workflowServiceContext);
		 
		return user;
	}

	/**
	 * Setter for extUser 
	 * @return extUser
	 */
	public ExtUser getExtUser() {
		return extUser;
	}

	/**
	 * Getter for extUser
	 * @param externalUser
	 */
	public void setExtUser(final ExtUser externalUser) {
		this.extUser = externalUser;
	}

	@Reference(unbind = "-")
	protected static UserLocalService userLocService;
	
	@Reference(unbind = "-")
	protected static CounterLocalService counterLoService;
	
	@Reference(unbind = "-")
	protected static CompanyLocalService companyLocService;
	
	@Reference(unbind = "-")
	protected static ContactLocalService contactLocService;
	
	@Reference(unbind = "-")
	protected static GroupLocalService groupLocService;
	
	@Reference(unbind = "-")
	protected static ResourceLocalService resourceLocService;

	public void reindex(User user) throws SearchException {
		Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			User.class);
		indexer.reindex(user);
	}
	
	private static final Log _log = LogFactoryUtil.getLog(
			ExtUserToUserAdapter.class);

}
