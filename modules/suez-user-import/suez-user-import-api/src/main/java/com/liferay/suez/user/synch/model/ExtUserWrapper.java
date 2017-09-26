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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ExtUser}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtUser
 * @generated
 */
@ProviderType
public class ExtUserWrapper implements ExtUser, ModelWrapper<ExtUser> {
	public ExtUserWrapper(ExtUser extUser) {
		_extUser = extUser;
	}

	@Override
	public Class<?> getModelClass() {
		return ExtUser.class;
	}

	@Override
	public String getModelClassName() {
		return ExtUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("defaultUser", getDefaultUser());
		attributes.put("contactId", getContactId());
		attributes.put("password", getPassword());
		attributes.put("passwordEncrypted", getPasswordEncrypted());
		attributes.put("passwordReset", getPasswordReset());
		attributes.put("passwordModifiedDate", getPasswordModifiedDate());
		attributes.put("digest", getDigest());
		attributes.put("reminderQueryQuestion", getReminderQueryQuestion());
		attributes.put("reminderQueryAnswer", getReminderQueryAnswer());
		attributes.put("graceLoginCount", getGraceLoginCount());
		attributes.put("screenName", getScreenName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("facebookId", getFacebookId());
		attributes.put("openId", getOpenId());
		attributes.put("portraitId", getPortraitId());
		attributes.put("languageId", getLanguageId());
		attributes.put("timeZoneId", getTimeZoneId());
		attributes.put("greeting", getGreeting());
		attributes.put("comments", getComments());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("loginDate", getLoginDate());
		attributes.put("loginIP", getLoginIP());
		attributes.put("lastLoginDate", getLastLoginDate());
		attributes.put("lastLoginIP", getLastLoginIP());
		attributes.put("lastFailedLoginDate", getLastFailedLoginDate());
		attributes.put("failedLoginAttempts", getFailedLoginAttempts());
		attributes.put("lockout", getLockout());
		attributes.put("lockoutDate", getLockoutDate());
		attributes.put("agreedToTermsOfUse", getAgreedToTermsOfUse());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean defaultUser = (Boolean)attributes.get("defaultUser");

		if (defaultUser != null) {
			setDefaultUser(defaultUser);
		}

		Long contactId = (Long)attributes.get("contactId");

		if (contactId != null) {
			setContactId(contactId);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Boolean passwordEncrypted = (Boolean)attributes.get("passwordEncrypted");

		if (passwordEncrypted != null) {
			setPasswordEncrypted(passwordEncrypted);
		}

		Boolean passwordReset = (Boolean)attributes.get("passwordReset");

		if (passwordReset != null) {
			setPasswordReset(passwordReset);
		}

		Date passwordModifiedDate = (Date)attributes.get("passwordModifiedDate");

		if (passwordModifiedDate != null) {
			setPasswordModifiedDate(passwordModifiedDate);
		}

		String digest = (String)attributes.get("digest");

		if (digest != null) {
			setDigest(digest);
		}

		String reminderQueryQuestion = (String)attributes.get(
				"reminderQueryQuestion");

		if (reminderQueryQuestion != null) {
			setReminderQueryQuestion(reminderQueryQuestion);
		}

		String reminderQueryAnswer = (String)attributes.get(
				"reminderQueryAnswer");

		if (reminderQueryAnswer != null) {
			setReminderQueryAnswer(reminderQueryAnswer);
		}

		Integer graceLoginCount = (Integer)attributes.get("graceLoginCount");

		if (graceLoginCount != null) {
			setGraceLoginCount(graceLoginCount);
		}

		String screenName = (String)attributes.get("screenName");

		if (screenName != null) {
			setScreenName(screenName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long facebookId = (Long)attributes.get("facebookId");

		if (facebookId != null) {
			setFacebookId(facebookId);
		}

		String openId = (String)attributes.get("openId");

		if (openId != null) {
			setOpenId(openId);
		}

		Long portraitId = (Long)attributes.get("portraitId");

		if (portraitId != null) {
			setPortraitId(portraitId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String timeZoneId = (String)attributes.get("timeZoneId");

		if (timeZoneId != null) {
			setTimeZoneId(timeZoneId);
		}

		String greeting = (String)attributes.get("greeting");

		if (greeting != null) {
			setGreeting(greeting);
		}

		String comments = (String)attributes.get("comments");

		if (comments != null) {
			setComments(comments);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		Date loginDate = (Date)attributes.get("loginDate");

		if (loginDate != null) {
			setLoginDate(loginDate);
		}

		String loginIP = (String)attributes.get("loginIP");

		if (loginIP != null) {
			setLoginIP(loginIP);
		}

		Date lastLoginDate = (Date)attributes.get("lastLoginDate");

		if (lastLoginDate != null) {
			setLastLoginDate(lastLoginDate);
		}

		String lastLoginIP = (String)attributes.get("lastLoginIP");

		if (lastLoginIP != null) {
			setLastLoginIP(lastLoginIP);
		}

		Date lastFailedLoginDate = (Date)attributes.get("lastFailedLoginDate");

		if (lastFailedLoginDate != null) {
			setLastFailedLoginDate(lastFailedLoginDate);
		}

		Integer failedLoginAttempts = (Integer)attributes.get(
				"failedLoginAttempts");

		if (failedLoginAttempts != null) {
			setFailedLoginAttempts(failedLoginAttempts);
		}

		Boolean lockout = (Boolean)attributes.get("lockout");

		if (lockout != null) {
			setLockout(lockout);
		}

		Date lockoutDate = (Date)attributes.get("lockoutDate");

		if (lockoutDate != null) {
			setLockoutDate(lockoutDate);
		}

		Boolean agreedToTermsOfUse = (Boolean)attributes.get(
				"agreedToTermsOfUse");

		if (agreedToTermsOfUse != null) {
			setAgreedToTermsOfUse(agreedToTermsOfUse);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public ExtUser toEscapedModel() {
		return new ExtUserWrapper(_extUser.toEscapedModel());
	}

	@Override
	public ExtUser toUnescapedModel() {
		return new ExtUserWrapper(_extUser.toUnescapedModel());
	}

	/**
	* Returns the agreed to terms of use of this ext user.
	*
	* @return the agreed to terms of use of this ext user
	*/
	@Override
	public boolean getAgreedToTermsOfUse() {
		return _extUser.getAgreedToTermsOfUse();
	}

	/**
	* Returns the default user of this ext user.
	*
	* @return the default user of this ext user
	*/
	@Override
	public boolean getDefaultUser() {
		return _extUser.getDefaultUser();
	}

	/**
	* Returns the lockout of this ext user.
	*
	* @return the lockout of this ext user
	*/
	@Override
	public boolean getLockout() {
		return _extUser.getLockout();
	}

	/**
	* Returns the password encrypted of this ext user.
	*
	* @return the password encrypted of this ext user
	*/
	@Override
	public boolean getPasswordEncrypted() {
		return _extUser.getPasswordEncrypted();
	}

	/**
	* Returns the password reset of this ext user.
	*
	* @return the password reset of this ext user
	*/
	@Override
	public boolean getPasswordReset() {
		return _extUser.getPasswordReset();
	}

	/**
	* Returns <code>true</code> if this ext user is agreed to terms of use.
	*
	* @return <code>true</code> if this ext user is agreed to terms of use; <code>false</code> otherwise
	*/
	@Override
	public boolean isAgreedToTermsOfUse() {
		return _extUser.isAgreedToTermsOfUse();
	}

	@Override
	public boolean isCachedModel() {
		return _extUser.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this ext user is default user.
	*
	* @return <code>true</code> if this ext user is default user; <code>false</code> otherwise
	*/
	@Override
	public boolean isDefaultUser() {
		return _extUser.isDefaultUser();
	}

	@Override
	public boolean isEscapedModel() {
		return _extUser.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this ext user is lockout.
	*
	* @return <code>true</code> if this ext user is lockout; <code>false</code> otherwise
	*/
	@Override
	public boolean isLockout() {
		return _extUser.isLockout();
	}

	@Override
	public boolean isNew() {
		return _extUser.isNew();
	}

	/**
	* Returns <code>true</code> if this ext user is password encrypted.
	*
	* @return <code>true</code> if this ext user is password encrypted; <code>false</code> otherwise
	*/
	@Override
	public boolean isPasswordEncrypted() {
		return _extUser.isPasswordEncrypted();
	}

	/**
	* Returns <code>true</code> if this ext user is password reset.
	*
	* @return <code>true</code> if this ext user is password reset; <code>false</code> otherwise
	*/
	@Override
	public boolean isPasswordReset() {
		return _extUser.isPasswordReset();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _extUser.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExtUser> toCacheModel() {
		return _extUser.toCacheModel();
	}

	@Override
	public int compareTo(ExtUser extUser) {
		return _extUser.compareTo(extUser);
	}

	/**
	* Returns the failed login attempts of this ext user.
	*
	* @return the failed login attempts of this ext user
	*/
	@Override
	public int getFailedLoginAttempts() {
		return _extUser.getFailedLoginAttempts();
	}

	/**
	* Returns the grace login count of this ext user.
	*
	* @return the grace login count of this ext user
	*/
	@Override
	public int getGraceLoginCount() {
		return _extUser.getGraceLoginCount();
	}

	/**
	* Returns the status of this ext user.
	*
	* @return the status of this ext user
	*/
	@Override
	public int getStatus() {
		return _extUser.getStatus();
	}

	@Override
	public int hashCode() {
		return _extUser.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _extUser.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ExtUserWrapper((ExtUser)_extUser.clone());
	}

	/**
	* Returns the comments of this ext user.
	*
	* @return the comments of this ext user
	*/
	@Override
	public java.lang.String getComments() {
		return _extUser.getComments();
	}

	/**
	* Returns the digest of this ext user.
	*
	* @return the digest of this ext user
	*/
	@Override
	public java.lang.String getDigest() {
		return _extUser.getDigest();
	}

	/**
	* Returns the email address of this ext user.
	*
	* @return the email address of this ext user
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _extUser.getEmailAddress();
	}

	/**
	* Returns the first name of this ext user.
	*
	* @return the first name of this ext user
	*/
	@Override
	public java.lang.String getFirstName() {
		return _extUser.getFirstName();
	}

	/**
	* Returns the greeting of this ext user.
	*
	* @return the greeting of this ext user
	*/
	@Override
	public java.lang.String getGreeting() {
		return _extUser.getGreeting();
	}

	/**
	* Returns the job title of this ext user.
	*
	* @return the job title of this ext user
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _extUser.getJobTitle();
	}

	/**
	* Returns the language ID of this ext user.
	*
	* @return the language ID of this ext user
	*/
	@Override
	public java.lang.String getLanguageId() {
		return _extUser.getLanguageId();
	}

	/**
	* Returns the last login i p of this ext user.
	*
	* @return the last login i p of this ext user
	*/
	@Override
	public java.lang.String getLastLoginIP() {
		return _extUser.getLastLoginIP();
	}

	/**
	* Returns the last name of this ext user.
	*
	* @return the last name of this ext user
	*/
	@Override
	public java.lang.String getLastName() {
		return _extUser.getLastName();
	}

	/**
	* Returns the login i p of this ext user.
	*
	* @return the login i p of this ext user
	*/
	@Override
	public java.lang.String getLoginIP() {
		return _extUser.getLoginIP();
	}

	/**
	* Returns the middle name of this ext user.
	*
	* @return the middle name of this ext user
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _extUser.getMiddleName();
	}

	/**
	* Returns the open ID of this ext user.
	*
	* @return the open ID of this ext user
	*/
	@Override
	public java.lang.String getOpenId() {
		return _extUser.getOpenId();
	}

	/**
	* Returns the password of this ext user.
	*
	* @return the password of this ext user
	*/
	@Override
	public java.lang.String getPassword() {
		return _extUser.getPassword();
	}

	/**
	* Returns the reminder query answer of this ext user.
	*
	* @return the reminder query answer of this ext user
	*/
	@Override
	public java.lang.String getReminderQueryAnswer() {
		return _extUser.getReminderQueryAnswer();
	}

	/**
	* Returns the reminder query question of this ext user.
	*
	* @return the reminder query question of this ext user
	*/
	@Override
	public java.lang.String getReminderQueryQuestion() {
		return _extUser.getReminderQueryQuestion();
	}

	/**
	* Returns the screen name of this ext user.
	*
	* @return the screen name of this ext user
	*/
	@Override
	public java.lang.String getScreenName() {
		return _extUser.getScreenName();
	}

	/**
	* Returns the time zone ID of this ext user.
	*
	* @return the time zone ID of this ext user
	*/
	@Override
	public java.lang.String getTimeZoneId() {
		return _extUser.getTimeZoneId();
	}

	/**
	* Returns the user uuid of this ext user.
	*
	* @return the user uuid of this ext user
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _extUser.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _extUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _extUser.toXmlString();
	}

	/**
	* Returns the create date of this ext user.
	*
	* @return the create date of this ext user
	*/
	@Override
	public Date getCreateDate() {
		return _extUser.getCreateDate();
	}

	/**
	* Returns the last failed login date of this ext user.
	*
	* @return the last failed login date of this ext user
	*/
	@Override
	public Date getLastFailedLoginDate() {
		return _extUser.getLastFailedLoginDate();
	}

	/**
	* Returns the last login date of this ext user.
	*
	* @return the last login date of this ext user
	*/
	@Override
	public Date getLastLoginDate() {
		return _extUser.getLastLoginDate();
	}

	/**
	* Returns the lockout date of this ext user.
	*
	* @return the lockout date of this ext user
	*/
	@Override
	public Date getLockoutDate() {
		return _extUser.getLockoutDate();
	}

	/**
	* Returns the login date of this ext user.
	*
	* @return the login date of this ext user
	*/
	@Override
	public Date getLoginDate() {
		return _extUser.getLoginDate();
	}

	/**
	* Returns the modified date of this ext user.
	*
	* @return the modified date of this ext user
	*/
	@Override
	public Date getModifiedDate() {
		return _extUser.getModifiedDate();
	}

	/**
	* Returns the password modified date of this ext user.
	*
	* @return the password modified date of this ext user
	*/
	@Override
	public Date getPasswordModifiedDate() {
		return _extUser.getPasswordModifiedDate();
	}

	/**
	* Returns the company ID of this ext user.
	*
	* @return the company ID of this ext user
	*/
	@Override
	public long getCompanyId() {
		return _extUser.getCompanyId();
	}

	/**
	* Returns the contact ID of this ext user.
	*
	* @return the contact ID of this ext user
	*/
	@Override
	public long getContactId() {
		return _extUser.getContactId();
	}

	/**
	* Returns the facebook ID of this ext user.
	*
	* @return the facebook ID of this ext user
	*/
	@Override
	public long getFacebookId() {
		return _extUser.getFacebookId();
	}

	/**
	* Returns the portrait ID of this ext user.
	*
	* @return the portrait ID of this ext user
	*/
	@Override
	public long getPortraitId() {
		return _extUser.getPortraitId();
	}

	/**
	* Returns the primary key of this ext user.
	*
	* @return the primary key of this ext user
	*/
	@Override
	public long getPrimaryKey() {
		return _extUser.getPrimaryKey();
	}

	/**
	* Returns the user ID of this ext user.
	*
	* @return the user ID of this ext user
	*/
	@Override
	public long getUserId() {
		return _extUser.getUserId();
	}

	@Override
	public void persist() {
		_extUser.persist();
	}

	/**
	* Sets whether this ext user is agreed to terms of use.
	*
	* @param agreedToTermsOfUse the agreed to terms of use of this ext user
	*/
	@Override
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_extUser.setAgreedToTermsOfUse(agreedToTermsOfUse);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_extUser.setCachedModel(cachedModel);
	}

	/**
	* Sets the comments of this ext user.
	*
	* @param comments the comments of this ext user
	*/
	@Override
	public void setComments(java.lang.String comments) {
		_extUser.setComments(comments);
	}

	/**
	* Sets the company ID of this ext user.
	*
	* @param companyId the company ID of this ext user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_extUser.setCompanyId(companyId);
	}

	/**
	* Sets the contact ID of this ext user.
	*
	* @param contactId the contact ID of this ext user
	*/
	@Override
	public void setContactId(long contactId) {
		_extUser.setContactId(contactId);
	}

	/**
	* Sets the create date of this ext user.
	*
	* @param createDate the create date of this ext user
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_extUser.setCreateDate(createDate);
	}

	/**
	* Sets whether this ext user is default user.
	*
	* @param defaultUser the default user of this ext user
	*/
	@Override
	public void setDefaultUser(boolean defaultUser) {
		_extUser.setDefaultUser(defaultUser);
	}

	/**
	* Sets the digest of this ext user.
	*
	* @param digest the digest of this ext user
	*/
	@Override
	public void setDigest(java.lang.String digest) {
		_extUser.setDigest(digest);
	}

	/**
	* Sets the email address of this ext user.
	*
	* @param emailAddress the email address of this ext user
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_extUser.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_extUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_extUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_extUser.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the facebook ID of this ext user.
	*
	* @param facebookId the facebook ID of this ext user
	*/
	@Override
	public void setFacebookId(long facebookId) {
		_extUser.setFacebookId(facebookId);
	}

	/**
	* Sets the failed login attempts of this ext user.
	*
	* @param failedLoginAttempts the failed login attempts of this ext user
	*/
	@Override
	public void setFailedLoginAttempts(int failedLoginAttempts) {
		_extUser.setFailedLoginAttempts(failedLoginAttempts);
	}

	/**
	* Sets the first name of this ext user.
	*
	* @param firstName the first name of this ext user
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_extUser.setFirstName(firstName);
	}

	/**
	* Sets the grace login count of this ext user.
	*
	* @param graceLoginCount the grace login count of this ext user
	*/
	@Override
	public void setGraceLoginCount(int graceLoginCount) {
		_extUser.setGraceLoginCount(graceLoginCount);
	}

	/**
	* Sets the greeting of this ext user.
	*
	* @param greeting the greeting of this ext user
	*/
	@Override
	public void setGreeting(java.lang.String greeting) {
		_extUser.setGreeting(greeting);
	}

	/**
	* Sets the job title of this ext user.
	*
	* @param jobTitle the job title of this ext user
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_extUser.setJobTitle(jobTitle);
	}

	/**
	* Sets the language ID of this ext user.
	*
	* @param languageId the language ID of this ext user
	*/
	@Override
	public void setLanguageId(java.lang.String languageId) {
		_extUser.setLanguageId(languageId);
	}

	/**
	* Sets the last failed login date of this ext user.
	*
	* @param lastFailedLoginDate the last failed login date of this ext user
	*/
	@Override
	public void setLastFailedLoginDate(Date lastFailedLoginDate) {
		_extUser.setLastFailedLoginDate(lastFailedLoginDate);
	}

	/**
	* Sets the last login date of this ext user.
	*
	* @param lastLoginDate the last login date of this ext user
	*/
	@Override
	public void setLastLoginDate(Date lastLoginDate) {
		_extUser.setLastLoginDate(lastLoginDate);
	}

	/**
	* Sets the last login i p of this ext user.
	*
	* @param lastLoginIP the last login i p of this ext user
	*/
	@Override
	public void setLastLoginIP(java.lang.String lastLoginIP) {
		_extUser.setLastLoginIP(lastLoginIP);
	}

	/**
	* Sets the last name of this ext user.
	*
	* @param lastName the last name of this ext user
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_extUser.setLastName(lastName);
	}

	/**
	* Sets whether this ext user is lockout.
	*
	* @param lockout the lockout of this ext user
	*/
	@Override
	public void setLockout(boolean lockout) {
		_extUser.setLockout(lockout);
	}

	/**
	* Sets the lockout date of this ext user.
	*
	* @param lockoutDate the lockout date of this ext user
	*/
	@Override
	public void setLockoutDate(Date lockoutDate) {
		_extUser.setLockoutDate(lockoutDate);
	}

	/**
	* Sets the login date of this ext user.
	*
	* @param loginDate the login date of this ext user
	*/
	@Override
	public void setLoginDate(Date loginDate) {
		_extUser.setLoginDate(loginDate);
	}

	/**
	* Sets the login i p of this ext user.
	*
	* @param loginIP the login i p of this ext user
	*/
	@Override
	public void setLoginIP(java.lang.String loginIP) {
		_extUser.setLoginIP(loginIP);
	}

	/**
	* Sets the middle name of this ext user.
	*
	* @param middleName the middle name of this ext user
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_extUser.setMiddleName(middleName);
	}

	/**
	* Sets the modified date of this ext user.
	*
	* @param modifiedDate the modified date of this ext user
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_extUser.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_extUser.setNew(n);
	}

	/**
	* Sets the open ID of this ext user.
	*
	* @param openId the open ID of this ext user
	*/
	@Override
	public void setOpenId(java.lang.String openId) {
		_extUser.setOpenId(openId);
	}

	/**
	* Sets the password of this ext user.
	*
	* @param password the password of this ext user
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_extUser.setPassword(password);
	}

	/**
	* Sets whether this ext user is password encrypted.
	*
	* @param passwordEncrypted the password encrypted of this ext user
	*/
	@Override
	public void setPasswordEncrypted(boolean passwordEncrypted) {
		_extUser.setPasswordEncrypted(passwordEncrypted);
	}

	/**
	* Sets the password modified date of this ext user.
	*
	* @param passwordModifiedDate the password modified date of this ext user
	*/
	@Override
	public void setPasswordModifiedDate(Date passwordModifiedDate) {
		_extUser.setPasswordModifiedDate(passwordModifiedDate);
	}

	/**
	* Sets whether this ext user is password reset.
	*
	* @param passwordReset the password reset of this ext user
	*/
	@Override
	public void setPasswordReset(boolean passwordReset) {
		_extUser.setPasswordReset(passwordReset);
	}

	/**
	* Sets the portrait ID of this ext user.
	*
	* @param portraitId the portrait ID of this ext user
	*/
	@Override
	public void setPortraitId(long portraitId) {
		_extUser.setPortraitId(portraitId);
	}

	/**
	* Sets the primary key of this ext user.
	*
	* @param primaryKey the primary key of this ext user
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_extUser.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_extUser.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the reminder query answer of this ext user.
	*
	* @param reminderQueryAnswer the reminder query answer of this ext user
	*/
	@Override
	public void setReminderQueryAnswer(java.lang.String reminderQueryAnswer) {
		_extUser.setReminderQueryAnswer(reminderQueryAnswer);
	}

	/**
	* Sets the reminder query question of this ext user.
	*
	* @param reminderQueryQuestion the reminder query question of this ext user
	*/
	@Override
	public void setReminderQueryQuestion(java.lang.String reminderQueryQuestion) {
		_extUser.setReminderQueryQuestion(reminderQueryQuestion);
	}

	/**
	* Sets the screen name of this ext user.
	*
	* @param screenName the screen name of this ext user
	*/
	@Override
	public void setScreenName(java.lang.String screenName) {
		_extUser.setScreenName(screenName);
	}

	/**
	* Sets the status of this ext user.
	*
	* @param status the status of this ext user
	*/
	@Override
	public void setStatus(int status) {
		_extUser.setStatus(status);
	}

	/**
	* Sets the time zone ID of this ext user.
	*
	* @param timeZoneId the time zone ID of this ext user
	*/
	@Override
	public void setTimeZoneId(java.lang.String timeZoneId) {
		_extUser.setTimeZoneId(timeZoneId);
	}

	/**
	* Sets the user ID of this ext user.
	*
	* @param userId the user ID of this ext user
	*/
	@Override
	public void setUserId(long userId) {
		_extUser.setUserId(userId);
	}

	/**
	* Sets the user uuid of this ext user.
	*
	* @param userUuid the user uuid of this ext user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_extUser.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtUserWrapper)) {
			return false;
		}

		ExtUserWrapper extUserWrapper = (ExtUserWrapper)obj;

		if (Objects.equals(_extUser, extUserWrapper._extUser)) {
			return true;
		}

		return false;
	}

	@Override
	public ExtUser getWrappedModel() {
		return _extUser;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _extUser.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _extUser.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_extUser.resetOriginalValues();
	}

	private final ExtUser _extUser;
}