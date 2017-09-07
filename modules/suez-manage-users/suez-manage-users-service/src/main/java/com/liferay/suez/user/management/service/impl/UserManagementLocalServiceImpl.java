/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.suez.user.management.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ContactConstants;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.PasswordPolicy;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ContactLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.suez.user.management.service.base.UserManagementLocalServiceBaseImpl;

import aQute.bnd.annotation.ProviderType;

/**
 * The implementation of the user management local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.suez.user.management.service.UserManagementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserManagementLocalServiceBaseImpl
 * @see com.liferay.suez.user.management.service.UserManagementLocalServiceUtil
 */
@ProviderType
public class UserManagementLocalServiceImpl
	extends UserManagementLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.suez.user.management.service.UserManagementLocalServiceUtil} to access the user management local service.
	 */
	public User addExtUser(
			long companyId, Date createDate, long creatorUserId, Date modifiedDate, Boolean defaultUser,
			String password, boolean passwordEncrypted, boolean passwordReset,	Date passwordModifiedDate,
			String digest, String reminderQueryQuestion, String reminderQueryAnswer, int graceLoginCount,
			String screenName,
			String emailAddress, long facebookId, String openId, long portraitId, String languageId,
			String timeZoneId, String greeting, String comments, String firstName, String middleName,
			String lastName, String jobTitle, Date loginDate, String loginIP, Date lastLoginDate, String lastLoginIP,
			Date lastFailedLoginDate, int failedLoginAttempts, Locale locale, boolean lockout, Date lockoutDate,
			boolean agreedToTermsOfUse, boolean emailAddressVerified, int status, ServiceContext serviceContext ) throws PortalException, ParseException
	{
		
		
		Company company = CompanyLocalServiceUtil.fetchCompany(companyId);
		openId = StringUtil.trim(openId);

		
		// PLACEHOLDER 01

		long userId = counterLocalService.increment();

		emailAddress = StringUtil.toLowerCase(emailAddress.trim());
		
		User defltUser = userLocalService.getDefaultUser(companyId);

		
		User user = userPersistence.create(userId);

		if (serviceContext != null) {
			String uuid = serviceContext.getUuid();

			if (Validator.isNotNull(uuid)) {
				user.setUuid(uuid);
			}
		}

		user.setCompanyId(companyId);
		user.setDefaultUser(defaultUser );
		user.setContactId(counterLocalService.increment());

		
		user.setPassword(password);
		//user.setPasswordUnencrypted(password1);
		

		user.setPasswordEncrypted(true);

		user.setPasswordReset(false);
		

		user.setDigest(StringPool.BLANK);
		user.setScreenName(screenName);
		user.setEmailAddress(emailAddress);
		user.setFacebookId(facebookId);

		Long ldapServerId = null;

		if (serviceContext != null) {
			ldapServerId = (Long)serviceContext.getAttribute("ldapServerId");
		}

		if (ldapServerId != null) {
			user.setLdapServerId(ldapServerId);
		}
		else {
			user.setLdapServerId(-1);
		}

		user.setOpenId(openId);
		user.setLanguageId(LocaleUtil.toLanguageId(locale));
		user.setTimeZoneId(defltUser.getTimeZoneId());
		user.setGreeting(greeting);
		user.setFirstName(firstName);
		user.setMiddleName(middleName);
		user.setLastName(lastName);
		user.setJobTitle(jobTitle);
		user.setStatus(WorkflowConstants.STATUS_DRAFT);
		user.setExpandoBridgeAttributes(serviceContext);

		userLocalService.updateUser(user);

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
		contact.setFirstName(firstName);
		contact.setMiddleName(middleName);
		contact.setLastName(lastName);
		//contact.setPrefixId(prefixId);
		//contact.setSuffixId(suffixId);
		//contact.setMale(male);
		contact.setBirthday(DateUtil.parseDate("ddMMyyyy", "0101970", locale));
		contact.setJobTitle(jobTitle);

		ContactLocalServiceUtil.updateContact(contact);

		// Group

		GroupLocalServiceUtil.addGroup(
			user.getUserId(), GroupConstants.DEFAULT_PARENT_GROUP_ID,
			User.class.getName(), user.getUserId(),
			GroupConstants.DEFAULT_LIVE_GROUP_ID, (Map<Locale, String>)null,
			null, 0, true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION,
			StringPool.SLASH + screenName, false, true, null);

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

		userLocalService.addDefaultGroups(userId);

		// Organizations

		//updateOrganizations(userId, organizationIds, false);

		// Roles
		/*
		if (roleIds != null) {
			roleIds = UsersAdminUtil.addRequiredRoles(user, roleIds);

			userPersistence.setRoles(userId, roleIds);
		}
		*/
		userLocalService.addDefaultRoles(userId);

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
		userLocalService.addDefaultUserGroups(userId);

		// Resources

		resourceLocalService.addResources(
			companyId, 0, creatorUserId, User.class.getName(), user.getUserId(),
			false, false, false);

		// Asset

		if (serviceContext != null) {
			userLocalService.updateAsset(
				creatorUserId, user, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames());
		}

		// Indexer

		if ((serviceContext == null) || serviceContext.isIndexingEnabled()) {
			reindex(user);
		}

		// Workflow

		long workflowUserId = creatorUserId;

		if (workflowUserId == userId) {
			workflowUserId = defltUser.getUserId();
		}

		ServiceContext workflowServiceContext = serviceContext;

		if (workflowServiceContext == null) {
			workflowServiceContext = new ServiceContext();
		}

		workflowServiceContext.setAttribute("autoPassword", false);
		//workflowServiceContext.setAttribute("passwordUnencrypted", password1);
		workflowServiceContext.setAttribute("sendEmail", null);

		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			companyId, workflowUserId, User.class.getName(), userId, user,
			workflowServiceContext);

		if (serviceContext != null) {
			String passwordUnencrypted = (String)serviceContext.getAttribute(
				"passwordUnencrypted");

			if (Validator.isNotNull(passwordUnencrypted)) {
				user.setPasswordUnencrypted(passwordUnencrypted);
			}
		}

		return user;


	}
	
	
	protected void reindex(User user) throws SearchException {
		Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(
			User.class);
		indexer.reindex(user);
	}
	private static final Log _log = LogFactoryUtil.getLog(
			UserManagementLocalServiceImpl.class);
}