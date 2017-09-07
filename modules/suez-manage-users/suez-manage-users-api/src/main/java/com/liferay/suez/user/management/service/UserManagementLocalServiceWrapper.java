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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserManagementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserManagementLocalService
 * @generated
 */
@ProviderType
public class UserManagementLocalServiceWrapper
	implements UserManagementLocalService,
		ServiceWrapper<UserManagementLocalService> {
	public UserManagementLocalServiceWrapper(
		UserManagementLocalService userManagementLocalService) {
		_userManagementLocalService = userManagementLocalService;
	}

	@Override
	public com.liferay.portal.kernel.model.User addExtUser(long companyId,
		java.util.Date createDate, long creatorUserId,
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
		return _userManagementLocalService.addExtUser(companyId, createDate,
			creatorUserId, modifiedDate, defaultUser, password,
			passwordEncrypted, passwordReset, passwordModifiedDate, digest,
			reminderQueryQuestion, reminderQueryAnswer, graceLoginCount,
			screenName, emailAddress, facebookId, openId, portraitId,
			languageId, timeZoneId, greeting, comments, firstName, middleName,
			lastName, jobTitle, loginDate, loginIP, lastLoginDate, lastLoginIP,
			lastFailedLoginDate, failedLoginAttempts, locale, lockout,
			lockoutDate, agreedToTermsOfUse, emailAddressVerified, status,
			serviceContext);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _userManagementLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public UserManagementLocalService getWrappedService() {
		return _userManagementLocalService;
	}

	@Override
	public void setWrappedService(
		UserManagementLocalService userManagementLocalService) {
		_userManagementLocalService = userManagementLocalService;
	}

	private UserManagementLocalService _userManagementLocalService;
}