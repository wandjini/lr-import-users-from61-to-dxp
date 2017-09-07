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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.text.ParseException;

import java.util.Date;
import java.util.Locale;

/**
 * Provides the local service interface for UserManagement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see UserManagementLocalServiceUtil
 * @see com.liferay.suez.user.management.service.base.UserManagementLocalServiceBaseImpl
 * @see com.liferay.suez.user.management.service.impl.UserManagementLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface UserManagementLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserManagementLocalServiceUtil} to access the user management local service. Add custom service methods to {@link com.liferay.suez.user.management.service.impl.UserManagementLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public User addExtUser(long companyId, Date createDate, long creatorUserId,
		Date modifiedDate, java.lang.Boolean defaultUser,
		java.lang.String password, boolean passwordEncrypted,
		boolean passwordReset, Date passwordModifiedDate,
		java.lang.String digest, java.lang.String reminderQueryQuestion,
		java.lang.String reminderQueryAnswer, int graceLoginCount,
		java.lang.String screenName, java.lang.String emailAddress,
		long facebookId, java.lang.String openId, long portraitId,
		java.lang.String languageId, java.lang.String timeZoneId,
		java.lang.String greeting, java.lang.String comments,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String jobTitle, Date loginDate,
		java.lang.String loginIP, Date lastLoginDate,
		java.lang.String lastLoginIP, Date lastFailedLoginDate,
		int failedLoginAttempts, Locale locale, boolean lockout,
		Date lockoutDate, boolean agreedToTermsOfUse,
		boolean emailAddressVerified, int status, ServiceContext serviceContext)
		throws PortalException, ParseException;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();
}