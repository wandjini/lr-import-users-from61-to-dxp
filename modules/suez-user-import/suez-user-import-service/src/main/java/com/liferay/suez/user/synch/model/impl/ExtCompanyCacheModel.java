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

import com.liferay.suez.user.synch.model.ExtCompany;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ExtCompany in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExtCompany
 * @generated
 */
@ProviderType
public class ExtCompanyCacheModel implements CacheModel<ExtCompany>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtCompanyCacheModel)) {
			return false;
		}

		ExtCompanyCacheModel extCompanyCacheModel = (ExtCompanyCacheModel)obj;

		if (companyId == extCompanyCacheModel.companyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, companyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", webId=");
		sb.append(webId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", mx=");
		sb.append(mx);
		sb.append(", homeURL=");
		sb.append(homeURL);
		sb.append(", logoId=");
		sb.append(logoId);
		sb.append(", system=");
		sb.append(system);
		sb.append(", maxUsers=");
		sb.append(maxUsers);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExtCompany toEntityModel() {
		ExtCompanyImpl extCompanyImpl = new ExtCompanyImpl();

		extCompanyImpl.setCompanyId(companyId);
		extCompanyImpl.setAccountId(accountId);

		if (webId == null) {
			extCompanyImpl.setWebId(StringPool.BLANK);
		}
		else {
			extCompanyImpl.setWebId(webId);
		}

		if (key == null) {
			extCompanyImpl.setKey(StringPool.BLANK);
		}
		else {
			extCompanyImpl.setKey(key);
		}

		if (mx == null) {
			extCompanyImpl.setMx(StringPool.BLANK);
		}
		else {
			extCompanyImpl.setMx(mx);
		}

		if (homeURL == null) {
			extCompanyImpl.setHomeURL(StringPool.BLANK);
		}
		else {
			extCompanyImpl.setHomeURL(homeURL);
		}

		extCompanyImpl.setLogoId(logoId);
		extCompanyImpl.setSystem(system);
		extCompanyImpl.setMaxUsers(maxUsers);

		extCompanyImpl.resetOriginalValues();

		return extCompanyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		accountId = objectInput.readLong();
		webId = objectInput.readUTF();
		key = objectInput.readUTF();
		mx = objectInput.readUTF();
		homeURL = objectInput.readUTF();

		logoId = objectInput.readLong();

		system = objectInput.readBoolean();

		maxUsers = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(accountId);

		if (webId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(webId);
		}

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (mx == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mx);
		}

		if (homeURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homeURL);
		}

		objectOutput.writeLong(logoId);

		objectOutput.writeBoolean(system);

		objectOutput.writeInt(maxUsers);
	}

	public long companyId;
	public long accountId;
	public String webId;
	public String key;
	public String mx;
	public String homeURL;
	public long logoId;
	public boolean system;
	public int maxUsers;
}