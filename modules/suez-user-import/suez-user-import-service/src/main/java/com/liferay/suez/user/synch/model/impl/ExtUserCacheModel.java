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

package com.liferay.suez.user.synch.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.suez.user.synch.model.ExtUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExtUser in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExtUser
 * @generated
 */
@ProviderType
public class ExtUserCacheModel implements CacheModel<ExtUser>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtUserCacheModel)) {
			return false;
		}

		ExtUserCacheModel extUserCacheModel = (ExtUserCacheModel)obj;

		if (userId == extUserCacheModel.userId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, userId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(77);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", defaultUser=");
		sb.append(defaultUser);
		sb.append(", contactId=");
		sb.append(contactId);
		sb.append(", password=");
		sb.append(password);
		sb.append(", passwordEncrypted=");
		sb.append(passwordEncrypted);
		sb.append(", passwordReset=");
		sb.append(passwordReset);
		sb.append(", passwordModifiedDate=");
		sb.append(passwordModifiedDate);
		sb.append(", digest=");
		sb.append(digest);
		sb.append(", reminderQueryQuestion=");
		sb.append(reminderQueryQuestion);
		sb.append(", reminderQueryAnswer=");
		sb.append(reminderQueryAnswer);
		sb.append(", graceLoginCount=");
		sb.append(graceLoginCount);
		sb.append(", screenName=");
		sb.append(screenName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", facebookId=");
		sb.append(facebookId);
		sb.append(", openId=");
		sb.append(openId);
		sb.append(", portraitId=");
		sb.append(portraitId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", timeZoneId=");
		sb.append(timeZoneId);
		sb.append(", greeting=");
		sb.append(greeting);
		sb.append(", comments=");
		sb.append(comments);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", loginDate=");
		sb.append(loginDate);
		sb.append(", loginIP=");
		sb.append(loginIP);
		sb.append(", lastLoginDate=");
		sb.append(lastLoginDate);
		sb.append(", lastLoginIP=");
		sb.append(lastLoginIP);
		sb.append(", lastFailedLoginDate=");
		sb.append(lastFailedLoginDate);
		sb.append(", failedLoginAttempts=");
		sb.append(failedLoginAttempts);
		sb.append(", lockout=");
		sb.append(lockout);
		sb.append(", lockoutDate=");
		sb.append(lockoutDate);
		sb.append(", agreedToTermsOfUse=");
		sb.append(agreedToTermsOfUse);
		sb.append(", emailAddressVerified=");
		sb.append(emailAddressVerified);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExtUser toEntityModel() {
		ExtUserImpl extUserImpl = new ExtUserImpl();

		extUserImpl.setUserId(userId);
		extUserImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			extUserImpl.setCreateDate(null);
		}
		else {
			extUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			extUserImpl.setModifiedDate(null);
		}
		else {
			extUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		extUserImpl.setDefaultUser(defaultUser);
		extUserImpl.setContactId(contactId);

		if (password == null) {
			extUserImpl.setPassword(StringPool.BLANK);
		}
		else {
			extUserImpl.setPassword(password);
		}

		extUserImpl.setPasswordEncrypted(passwordEncrypted);
		extUserImpl.setPasswordReset(passwordReset);

		if (passwordModifiedDate == Long.MIN_VALUE) {
			extUserImpl.setPasswordModifiedDate(null);
		}
		else {
			extUserImpl.setPasswordModifiedDate(new Date(passwordModifiedDate));
		}

		if (digest == null) {
			extUserImpl.setDigest(StringPool.BLANK);
		}
		else {
			extUserImpl.setDigest(digest);
		}

		if (reminderQueryQuestion == null) {
			extUserImpl.setReminderQueryQuestion(StringPool.BLANK);
		}
		else {
			extUserImpl.setReminderQueryQuestion(reminderQueryQuestion);
		}

		if (reminderQueryAnswer == null) {
			extUserImpl.setReminderQueryAnswer(StringPool.BLANK);
		}
		else {
			extUserImpl.setReminderQueryAnswer(reminderQueryAnswer);
		}

		extUserImpl.setGraceLoginCount(graceLoginCount);

		if (screenName == null) {
			extUserImpl.setScreenName(StringPool.BLANK);
		}
		else {
			extUserImpl.setScreenName(screenName);
		}

		if (emailAddress == null) {
			extUserImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			extUserImpl.setEmailAddress(emailAddress);
		}

		extUserImpl.setFacebookId(facebookId);

		if (openId == null) {
			extUserImpl.setOpenId(StringPool.BLANK);
		}
		else {
			extUserImpl.setOpenId(openId);
		}

		extUserImpl.setPortraitId(portraitId);

		if (languageId == null) {
			extUserImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			extUserImpl.setLanguageId(languageId);
		}

		if (timeZoneId == null) {
			extUserImpl.setTimeZoneId(StringPool.BLANK);
		}
		else {
			extUserImpl.setTimeZoneId(timeZoneId);
		}

		if (greeting == null) {
			extUserImpl.setGreeting(StringPool.BLANK);
		}
		else {
			extUserImpl.setGreeting(greeting);
		}

		if (comments == null) {
			extUserImpl.setComments(StringPool.BLANK);
		}
		else {
			extUserImpl.setComments(comments);
		}

		if (firstName == null) {
			extUserImpl.setFirstName(StringPool.BLANK);
		}
		else {
			extUserImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			extUserImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			extUserImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			extUserImpl.setLastName(StringPool.BLANK);
		}
		else {
			extUserImpl.setLastName(lastName);
		}

		if (jobTitle == null) {
			extUserImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			extUserImpl.setJobTitle(jobTitle);
		}

		if (loginDate == Long.MIN_VALUE) {
			extUserImpl.setLoginDate(null);
		}
		else {
			extUserImpl.setLoginDate(new Date(loginDate));
		}

		if (loginIP == null) {
			extUserImpl.setLoginIP(StringPool.BLANK);
		}
		else {
			extUserImpl.setLoginIP(loginIP);
		}

		if (lastLoginDate == Long.MIN_VALUE) {
			extUserImpl.setLastLoginDate(null);
		}
		else {
			extUserImpl.setLastLoginDate(new Date(lastLoginDate));
		}

		if (lastLoginIP == null) {
			extUserImpl.setLastLoginIP(StringPool.BLANK);
		}
		else {
			extUserImpl.setLastLoginIP(lastLoginIP);
		}

		if (lastFailedLoginDate == Long.MIN_VALUE) {
			extUserImpl.setLastFailedLoginDate(null);
		}
		else {
			extUserImpl.setLastFailedLoginDate(new Date(lastFailedLoginDate));
		}

		extUserImpl.setFailedLoginAttempts(failedLoginAttempts);
		extUserImpl.setLockout(lockout);

		if (lockoutDate == Long.MIN_VALUE) {
			extUserImpl.setLockoutDate(null);
		}
		else {
			extUserImpl.setLockoutDate(new Date(lockoutDate));
		}

		extUserImpl.setAgreedToTermsOfUse(agreedToTermsOfUse);
		extUserImpl.setEmailAddressVerified(emailAddressVerified);
		extUserImpl.setStatus(status);

		extUserImpl.resetOriginalValues();

		return extUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		defaultUser = objectInput.readBoolean();

		contactId = objectInput.readLong();
		password = objectInput.readUTF();

		passwordEncrypted = objectInput.readBoolean();

		passwordReset = objectInput.readBoolean();
		passwordModifiedDate = objectInput.readLong();
		digest = objectInput.readUTF();
		reminderQueryQuestion = objectInput.readUTF();
		reminderQueryAnswer = objectInput.readUTF();

		graceLoginCount = objectInput.readInt();
		screenName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		facebookId = objectInput.readLong();
		openId = objectInput.readUTF();

		portraitId = objectInput.readLong();
		languageId = objectInput.readUTF();
		timeZoneId = objectInput.readUTF();
		greeting = objectInput.readUTF();
		comments = objectInput.readUTF();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		loginDate = objectInput.readLong();
		loginIP = objectInput.readUTF();
		lastLoginDate = objectInput.readLong();
		lastLoginIP = objectInput.readUTF();
		lastFailedLoginDate = objectInput.readLong();

		failedLoginAttempts = objectInput.readInt();

		lockout = objectInput.readBoolean();
		lockoutDate = objectInput.readLong();

		agreedToTermsOfUse = objectInput.readBoolean();

		emailAddressVerified = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(defaultUser);

		objectOutput.writeLong(contactId);

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeBoolean(passwordEncrypted);

		objectOutput.writeBoolean(passwordReset);
		objectOutput.writeLong(passwordModifiedDate);

		if (digest == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(digest);
		}

		if (reminderQueryQuestion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reminderQueryQuestion);
		}

		if (reminderQueryAnswer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reminderQueryAnswer);
		}

		objectOutput.writeInt(graceLoginCount);

		if (screenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(screenName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(facebookId);

		if (openId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(openId);
		}

		objectOutput.writeLong(portraitId);

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (timeZoneId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timeZoneId);
		}

		if (greeting == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(greeting);
		}

		if (comments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comments);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		objectOutput.writeLong(loginDate);

		if (loginIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(loginIP);
		}

		objectOutput.writeLong(lastLoginDate);

		if (lastLoginIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastLoginIP);
		}

		objectOutput.writeLong(lastFailedLoginDate);

		objectOutput.writeInt(failedLoginAttempts);

		objectOutput.writeBoolean(lockout);
		objectOutput.writeLong(lockoutDate);

		objectOutput.writeBoolean(agreedToTermsOfUse);

		objectOutput.writeBoolean(emailAddressVerified);

		objectOutput.writeInt(status);
	}

	public long userId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public boolean defaultUser;
	public long contactId;
	public String password;
	public boolean passwordEncrypted;
	public boolean passwordReset;
	public long passwordModifiedDate;
	public String digest;
	public String reminderQueryQuestion;
	public String reminderQueryAnswer;
	public int graceLoginCount;
	public String screenName;
	public String emailAddress;
	public long facebookId;
	public String openId;
	public long portraitId;
	public String languageId;
	public String timeZoneId;
	public String greeting;
	public String comments;
	public String firstName;
	public String middleName;
	public String lastName;
	public String jobTitle;
	public long loginDate;
	public String loginIP;
	public long lastLoginDate;
	public String lastLoginIP;
	public long lastFailedLoginDate;
	public int failedLoginAttempts;
	public boolean lockout;
	public long lockoutDate;
	public boolean agreedToTermsOfUse;
	public boolean emailAddressVerified;
	public int status;
}