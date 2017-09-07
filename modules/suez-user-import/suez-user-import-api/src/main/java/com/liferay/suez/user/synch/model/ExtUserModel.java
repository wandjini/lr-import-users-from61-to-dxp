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

package com.liferay.suez.user.synch.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ExtUser service. Represents a row in the &quot;user_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.suez.user.synch.model.impl.ExtUserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.suez.user.synch.model.impl.ExtUserImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtUser
 * @see com.liferay.suez.user.synch.model.impl.ExtUserImpl
 * @see com.liferay.suez.user.synch.model.impl.ExtUserModelImpl
 * @generated
 */
@ProviderType
public interface ExtUserModel extends BaseModel<ExtUser>, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ext user model instance should use the {@link ExtUser} interface instead.
	 */

	/**
	 * Returns the primary key of this ext user.
	 *
	 * @return the primary key of this ext user
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ext user.
	 *
	 * @param primaryKey the primary key of this ext user
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the user ID of this ext user.
	 *
	 * @return the user ID of this ext user
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ext user.
	 *
	 * @param userId the user ID of this ext user
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ext user.
	 *
	 * @return the user uuid of this ext user
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ext user.
	 *
	 * @param userUuid the user uuid of this ext user
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the company ID of this ext user.
	 *
	 * @return the company ID of this ext user
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ext user.
	 *
	 * @param companyId the company ID of this ext user
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this ext user.
	 *
	 * @return the create date of this ext user
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ext user.
	 *
	 * @param createDate the create date of this ext user
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ext user.
	 *
	 * @return the modified date of this ext user
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ext user.
	 *
	 * @param modifiedDate the modified date of this ext user
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the default user of this ext user.
	 *
	 * @return the default user of this ext user
	 */
	public boolean getDefaultUser();

	/**
	 * Returns <code>true</code> if this ext user is default user.
	 *
	 * @return <code>true</code> if this ext user is default user; <code>false</code> otherwise
	 */
	public boolean isDefaultUser();

	/**
	 * Sets whether this ext user is default user.
	 *
	 * @param defaultUser the default user of this ext user
	 */
	public void setDefaultUser(boolean defaultUser);

	/**
	 * Returns the contact ID of this ext user.
	 *
	 * @return the contact ID of this ext user
	 */
	public long getContactId();

	/**
	 * Sets the contact ID of this ext user.
	 *
	 * @param contactId the contact ID of this ext user
	 */
	public void setContactId(long contactId);

	/**
	 * Returns the password of this ext user.
	 *
	 * @return the password of this ext user
	 */
	@AutoEscape
	public String getPassword();

	/**
	 * Sets the password of this ext user.
	 *
	 * @param password the password of this ext user
	 */
	public void setPassword(String password);

	/**
	 * Returns the password encrypted of this ext user.
	 *
	 * @return the password encrypted of this ext user
	 */
	public boolean getPasswordEncrypted();

	/**
	 * Returns <code>true</code> if this ext user is password encrypted.
	 *
	 * @return <code>true</code> if this ext user is password encrypted; <code>false</code> otherwise
	 */
	public boolean isPasswordEncrypted();

	/**
	 * Sets whether this ext user is password encrypted.
	 *
	 * @param passwordEncrypted the password encrypted of this ext user
	 */
	public void setPasswordEncrypted(boolean passwordEncrypted);

	/**
	 * Returns the password reset of this ext user.
	 *
	 * @return the password reset of this ext user
	 */
	public boolean getPasswordReset();

	/**
	 * Returns <code>true</code> if this ext user is password reset.
	 *
	 * @return <code>true</code> if this ext user is password reset; <code>false</code> otherwise
	 */
	public boolean isPasswordReset();

	/**
	 * Sets whether this ext user is password reset.
	 *
	 * @param passwordReset the password reset of this ext user
	 */
	public void setPasswordReset(boolean passwordReset);

	/**
	 * Returns the password modified date of this ext user.
	 *
	 * @return the password modified date of this ext user
	 */
	public Date getPasswordModifiedDate();

	/**
	 * Sets the password modified date of this ext user.
	 *
	 * @param passwordModifiedDate the password modified date of this ext user
	 */
	public void setPasswordModifiedDate(Date passwordModifiedDate);

	/**
	 * Returns the digest of this ext user.
	 *
	 * @return the digest of this ext user
	 */
	@AutoEscape
	public String getDigest();

	/**
	 * Sets the digest of this ext user.
	 *
	 * @param digest the digest of this ext user
	 */
	public void setDigest(String digest);

	/**
	 * Returns the reminder query question of this ext user.
	 *
	 * @return the reminder query question of this ext user
	 */
	@AutoEscape
	public String getReminderQueryQuestion();

	/**
	 * Sets the reminder query question of this ext user.
	 *
	 * @param reminderQueryQuestion the reminder query question of this ext user
	 */
	public void setReminderQueryQuestion(String reminderQueryQuestion);

	/**
	 * Returns the reminder query answer of this ext user.
	 *
	 * @return the reminder query answer of this ext user
	 */
	@AutoEscape
	public String getReminderQueryAnswer();

	/**
	 * Sets the reminder query answer of this ext user.
	 *
	 * @param reminderQueryAnswer the reminder query answer of this ext user
	 */
	public void setReminderQueryAnswer(String reminderQueryAnswer);

	/**
	 * Returns the grace login count of this ext user.
	 *
	 * @return the grace login count of this ext user
	 */
	public int getGraceLoginCount();

	/**
	 * Sets the grace login count of this ext user.
	 *
	 * @param graceLoginCount the grace login count of this ext user
	 */
	public void setGraceLoginCount(int graceLoginCount);

	/**
	 * Returns the screen name of this ext user.
	 *
	 * @return the screen name of this ext user
	 */
	@AutoEscape
	public String getScreenName();

	/**
	 * Sets the screen name of this ext user.
	 *
	 * @param screenName the screen name of this ext user
	 */
	public void setScreenName(String screenName);

	/**
	 * Returns the email address of this ext user.
	 *
	 * @return the email address of this ext user
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this ext user.
	 *
	 * @param emailAddress the email address of this ext user
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the facebook ID of this ext user.
	 *
	 * @return the facebook ID of this ext user
	 */
	public long getFacebookId();

	/**
	 * Sets the facebook ID of this ext user.
	 *
	 * @param facebookId the facebook ID of this ext user
	 */
	public void setFacebookId(long facebookId);

	/**
	 * Returns the open ID of this ext user.
	 *
	 * @return the open ID of this ext user
	 */
	@AutoEscape
	public String getOpenId();

	/**
	 * Sets the open ID of this ext user.
	 *
	 * @param openId the open ID of this ext user
	 */
	public void setOpenId(String openId);

	/**
	 * Returns the portrait ID of this ext user.
	 *
	 * @return the portrait ID of this ext user
	 */
	public long getPortraitId();

	/**
	 * Sets the portrait ID of this ext user.
	 *
	 * @param portraitId the portrait ID of this ext user
	 */
	public void setPortraitId(long portraitId);

	/**
	 * Returns the language ID of this ext user.
	 *
	 * @return the language ID of this ext user
	 */
	@AutoEscape
	public String getLanguageId();

	/**
	 * Sets the language ID of this ext user.
	 *
	 * @param languageId the language ID of this ext user
	 */
	public void setLanguageId(String languageId);

	/**
	 * Returns the time zone ID of this ext user.
	 *
	 * @return the time zone ID of this ext user
	 */
	@AutoEscape
	public String getTimeZoneId();

	/**
	 * Sets the time zone ID of this ext user.
	 *
	 * @param timeZoneId the time zone ID of this ext user
	 */
	public void setTimeZoneId(String timeZoneId);

	/**
	 * Returns the greeting of this ext user.
	 *
	 * @return the greeting of this ext user
	 */
	@AutoEscape
	public String getGreeting();

	/**
	 * Sets the greeting of this ext user.
	 *
	 * @param greeting the greeting of this ext user
	 */
	public void setGreeting(String greeting);

	/**
	 * Returns the comments of this ext user.
	 *
	 * @return the comments of this ext user
	 */
	@AutoEscape
	public String getComments();

	/**
	 * Sets the comments of this ext user.
	 *
	 * @param comments the comments of this ext user
	 */
	public void setComments(String comments);

	/**
	 * Returns the first name of this ext user.
	 *
	 * @return the first name of this ext user
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this ext user.
	 *
	 * @param firstName the first name of this ext user
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the middle name of this ext user.
	 *
	 * @return the middle name of this ext user
	 */
	@AutoEscape
	public String getMiddleName();

	/**
	 * Sets the middle name of this ext user.
	 *
	 * @param middleName the middle name of this ext user
	 */
	public void setMiddleName(String middleName);

	/**
	 * Returns the last name of this ext user.
	 *
	 * @return the last name of this ext user
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this ext user.
	 *
	 * @param lastName the last name of this ext user
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the job title of this ext user.
	 *
	 * @return the job title of this ext user
	 */
	@AutoEscape
	public String getJobTitle();

	/**
	 * Sets the job title of this ext user.
	 *
	 * @param jobTitle the job title of this ext user
	 */
	public void setJobTitle(String jobTitle);

	/**
	 * Returns the login date of this ext user.
	 *
	 * @return the login date of this ext user
	 */
	public Date getLoginDate();

	/**
	 * Sets the login date of this ext user.
	 *
	 * @param loginDate the login date of this ext user
	 */
	public void setLoginDate(Date loginDate);

	/**
	 * Returns the login i p of this ext user.
	 *
	 * @return the login i p of this ext user
	 */
	@AutoEscape
	public String getLoginIP();

	/**
	 * Sets the login i p of this ext user.
	 *
	 * @param loginIP the login i p of this ext user
	 */
	public void setLoginIP(String loginIP);

	/**
	 * Returns the last login date of this ext user.
	 *
	 * @return the last login date of this ext user
	 */
	public Date getLastLoginDate();

	/**
	 * Sets the last login date of this ext user.
	 *
	 * @param lastLoginDate the last login date of this ext user
	 */
	public void setLastLoginDate(Date lastLoginDate);

	/**
	 * Returns the last login i p of this ext user.
	 *
	 * @return the last login i p of this ext user
	 */
	@AutoEscape
	public String getLastLoginIP();

	/**
	 * Sets the last login i p of this ext user.
	 *
	 * @param lastLoginIP the last login i p of this ext user
	 */
	public void setLastLoginIP(String lastLoginIP);

	/**
	 * Returns the last failed login date of this ext user.
	 *
	 * @return the last failed login date of this ext user
	 */
	public Date getLastFailedLoginDate();

	/**
	 * Sets the last failed login date of this ext user.
	 *
	 * @param lastFailedLoginDate the last failed login date of this ext user
	 */
	public void setLastFailedLoginDate(Date lastFailedLoginDate);

	/**
	 * Returns the failed login attempts of this ext user.
	 *
	 * @return the failed login attempts of this ext user
	 */
	public int getFailedLoginAttempts();

	/**
	 * Sets the failed login attempts of this ext user.
	 *
	 * @param failedLoginAttempts the failed login attempts of this ext user
	 */
	public void setFailedLoginAttempts(int failedLoginAttempts);

	/**
	 * Returns the lockout of this ext user.
	 *
	 * @return the lockout of this ext user
	 */
	public boolean getLockout();

	/**
	 * Returns <code>true</code> if this ext user is lockout.
	 *
	 * @return <code>true</code> if this ext user is lockout; <code>false</code> otherwise
	 */
	public boolean isLockout();

	/**
	 * Sets whether this ext user is lockout.
	 *
	 * @param lockout the lockout of this ext user
	 */
	public void setLockout(boolean lockout);

	/**
	 * Returns the lockout date of this ext user.
	 *
	 * @return the lockout date of this ext user
	 */
	public Date getLockoutDate();

	/**
	 * Sets the lockout date of this ext user.
	 *
	 * @param lockoutDate the lockout date of this ext user
	 */
	public void setLockoutDate(Date lockoutDate);

	/**
	 * Returns the agreed to terms of use of this ext user.
	 *
	 * @return the agreed to terms of use of this ext user
	 */
	public boolean getAgreedToTermsOfUse();

	/**
	 * Returns <code>true</code> if this ext user is agreed to terms of use.
	 *
	 * @return <code>true</code> if this ext user is agreed to terms of use; <code>false</code> otherwise
	 */
	public boolean isAgreedToTermsOfUse();

	/**
	 * Sets whether this ext user is agreed to terms of use.
	 *
	 * @param agreedToTermsOfUse the agreed to terms of use of this ext user
	 */
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse);

	/**
	 * Returns the email address verified of this ext user.
	 *
	 * @return the email address verified of this ext user
	 */
	public boolean getEmailAddressVerified();

	/**
	 * Returns <code>true</code> if this ext user is email address verified.
	 *
	 * @return <code>true</code> if this ext user is email address verified; <code>false</code> otherwise
	 */
	public boolean isEmailAddressVerified();

	/**
	 * Sets whether this ext user is email address verified.
	 *
	 * @param emailAddressVerified the email address verified of this ext user
	 */
	public void setEmailAddressVerified(boolean emailAddressVerified);

	/**
	 * Returns the status of this ext user.
	 *
	 * @return the status of this ext user
	 */
	public int getStatus();

	/**
	 * Sets the status of this ext user.
	 *
	 * @param status the status of this ext user
	 */
	public void setStatus(int status);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(ExtUser extUser);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ExtUser> toCacheModel();

	@Override
	public ExtUser toEscapedModel();

	@Override
	public ExtUser toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}