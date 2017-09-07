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

package com.liferay.suez.user.management.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for UserManagement. This utility wraps
 * {@link com.liferay.suez.user.management.service.impl.UserManagementLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserManagementLocalService
 * @see com.liferay.suez.user.management.service.base.UserManagementLocalServiceBaseImpl
 * @see com.liferay.suez.user.management.service.impl.UserManagementLocalServiceImpl
 * @generated
 */
@ProviderType
public class UserManagementLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.suez.user.management.service.impl.UserManagementLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.model.User addExtUser(
		long companyId, java.util.Date createDate, long creatorUserId,
		java.util.Date modifiedDate, java.lang.Boolean defaultUser,
		java.lang.String password, boolean passwordEncrypted,
		boolean passwordReset, java.util.Date passwordModifiedDate,
		java.lang.String digest, java.lang.String reminderQueryQuestion,
		java.lang.String reminderQueryAnswer, int graceLoginCount,
		java.lang.String screenName, java.lang.String emailAddress,
		long facebookId, java.lang.String openId, long portraitId,
		java.lang.String languageId, java.lang.String timeZoneId,
		java.lang.String greeting, java.lang.String comments,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String jobTitle,
		java.util.Date loginDate, java.lang.String loginIP,
		java.util.Date lastLoginDate, java.lang.String lastLoginIP,
		java.util.Date lastFailedLoginDate, int failedLoginAttempts,
		java.util.Locale locale, boolean lockout, java.util.Date lockoutDate,
		boolean agreedToTermsOfUse, boolean emailAddressVerified, int status,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			java.text.ParseException {
		return getService()
				   .addExtUser(companyId, createDate, creatorUserId,
			modifiedDate, defaultUser, password, passwordEncrypted,
			passwordReset, passwordModifiedDate, digest, reminderQueryQuestion,
			reminderQueryAnswer, graceLoginCount, screenName, emailAddress,
			facebookId, openId, portraitId, languageId, timeZoneId, greeting,
			comments, firstName, middleName, lastName, jobTitle, loginDate,
			loginIP, lastLoginDate, lastLoginIP, lastFailedLoginDate,
			failedLoginAttempts, locale, lockout, lockoutDate,
			agreedToTermsOfUse, emailAddressVerified, status, serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static UserManagementLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserManagementLocalService, UserManagementLocalService> _serviceTracker =
		ServiceTrackerFactory.open(UserManagementLocalService.class);
}