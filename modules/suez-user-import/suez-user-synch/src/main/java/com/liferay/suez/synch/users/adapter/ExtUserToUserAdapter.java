package com.liferay.suez.synch.users.adapter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ContactConstants;
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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.suez.user.synch.model.ExtUser;

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
	public final User adaptExternalUsertoUser(long companyId, long creatorUserId) 
			throws PortalException, ParseException {
		
		User user = _userLocalService.createUser(_counterLocalService.increment());
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
		user.setEmailAddressVerified(this.extUser.getEmailAddressVerified());
		
		Company company = _companyLocalService.fetchCompany(companyId);
		
		
		// PLACEHOLDER 01
		
				
		User defltUser = _userLocalService.getDefaultUser(companyId);

		


		user.setDefaultUser(this.extUser.getDefaultUser() );
		user.setContactId(_counterLocalService.increment());

		user.setPasswordReset(this.extUser.getPasswordReset());
		

		user.setDigest(this.extUser.getDigest());
		user.setScreenName(this.extUser.getScreenName());
		user.setEmailAddress(this.extUser.getEmailAddress());
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
		//user.setExpandoBridgeAttributes(null);

		_userLocalService.updateUser(user);

		// Contact

		String creatorUserName = StringPool.BLANK;

		if (creatorUserId <= 0) {
			creatorUserId = user.getUserId();

			// Don't grab the full name from the User object because it doesn't
			// have a corresponding Contact object yet

			//creatorUserName = user.getFullName();
		}
		else {
			User creatorUser = UserLocalServiceUtil.fetchUser(creatorUserId);
			if(creatorUser != null)
				creatorUserName = creatorUser.getFullName();
		}

		//Date birthday = getBirthday(birthdayMonth, birthdayDay, birthdayYear);

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
		//contact.setPrefixId(prefixId);
		//contact.setSuffixId(suffixId);
		//contact.setMale(male);
		contact.setBirthday(DateUtil.parseDate("ddMMyyyy", "0101970", new Locale("en_US")));
		contact.setJobTitle(this.extUser.getJobTitle());

		_contactLocalService.updateContact(contact);

		// Group

		_groupLocalService.addGroup(
			user.getUserId(), GroupConstants.DEFAULT_PARENT_GROUP_ID,
			User.class.getName(), user.getUserId(),
			GroupConstants.DEFAULT_LIVE_GROUP_ID, (Map<Locale, String>)null,
			null, 0, true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION,
			StringPool.SLASH + this.extUser.getScreenName(), false, true, null);

		// Groups
		/*
		if (!ArrayUtil.isEmpty(groupIds)) {
			List<Group> groups = new ArrayList<>();

			for (long groupId : groupIds) {
				Group group = groupLocalService.fetchGroup(groupId);

				if (group != null) {
					groups.add(group);
				}
				else {
					if (_log.isWarnEnabled()) {
						_log.warn("Group " + groupId + " does not exist");
					}
				}
			}

			groupLocalService.addUserGroups(userId, groups);
		}*/

		_userLocalService.addDefaultGroups(user.getUserId());

		// Organizations

		//updateOrganizations(userId, organizationIds, false);

		// Roles
		/*
		if (roleIds != null) {
			roleIds = UsersAdminUtil.addRequiredRoles(user, roleIds);

			userPersistence.setRoles(userId, roleIds);
		}
		*/
		_userLocalService.addDefaultRoles(user.getUserId());

		// User groups

		/*
		if (userGroupIds != null) {
			if (PropsValues.USER_GROUPS_COPY_LAYOUTS_TO_USER_PERSONAL_SITE) {
				for (long userGroupId : userGroupIds) {
					userGroupLocalService.copyUserGroupLayouts(
						userGroupId, new long[] {userId});
				}
			}

			userPersistence.setUserGroups(userId, userGroupIds);
		}
		 */
		_userLocalService.addDefaultUserGroups(user.getUserId());

		// Resources

		_resourceLocalService.addResources(
			companyId, 0, creatorUserId, User.class.getName(), user.getUserId(),
			false, false, false);

		// Asset


		// Indexer

		reindex(user);

		// Workflow

		long workflowUserId = creatorUserId;

		if (workflowUserId == user.getUserId()) {
			workflowUserId = defltUser.getUserId();
		}

		ServiceContext	workflowServiceContext = new ServiceContext();

		workflowServiceContext.setAttribute("autoPassword", false);
		//workflowServiceContext.setAttribute("passwordUnencrypted", password1);
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

	@Reference
	public void setUserLocalService(UserLocalService userLocalService){
		_userLocalService = userLocalService;
	}
	protected static UserLocalService _userLocalService;
	
	@Reference
	public void setCounterLocalService(CounterLocalService counterLocalService){
		_counterLocalService = counterLocalService;
	}
	protected static CounterLocalService _counterLocalService;
	
	@Reference
	public void setCompanyLocalService(CompanyLocalService companyLocalService){
		_companyLocalService = companyLocalService;
	}
	protected static CompanyLocalService _companyLocalService;
	
	@Reference
	public void setContactLocalService(ContactLocalService contactLocalService){
		_contactLocalService = contactLocalService;
	}
	protected static ContactLocalService _contactLocalService;
	
	@Reference
	public void setGroupLocalService(GroupLocalService groupLocalService){
		_groupLocalService = groupLocalService;
	}
	protected static GroupLocalService _groupLocalService;
	
	@Reference
	public void resourceLocalService(ResourceLocalService resourceLocalService){
		_resourceLocalService = resourceLocalService;
	}
	protected static ResourceLocalService _resourceLocalService;

	protected void reindex(User user) throws SearchException {
		Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			User.class);
		indexer.reindex(user);
	}
}
