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

import com.liferay.suez.user.synch.model.ExtRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ExtRole in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ExtRole
 * @generated
 */
@ProviderType
public class ExtRoleCacheModel implements CacheModel<ExtRole>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtRoleCacheModel)) {
			return false;
		}

		ExtRoleCacheModel extRoleCacheModel = (ExtRoleCacheModel)obj;

		if (roleId == extRoleCacheModel.roleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{roleId=");
		sb.append(roleId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", type=");
		sb.append(type);
		sb.append(", subtype=");
		sb.append(subtype);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExtRole toEntityModel() {
		ExtRoleImpl extRoleImpl = new ExtRoleImpl();

		extRoleImpl.setRoleId(roleId);
		extRoleImpl.setCompanyId(companyId);
		extRoleImpl.setClassNameId(classNameId);
		extRoleImpl.setClassPK(classPK);

		if (name == null) {
			extRoleImpl.setName(StringPool.BLANK);
		}
		else {
			extRoleImpl.setName(name);
		}

		if (title == null) {
			extRoleImpl.setTitle(StringPool.BLANK);
		}
		else {
			extRoleImpl.setTitle(title);
		}

		if (description == null) {
			extRoleImpl.setDescription(StringPool.BLANK);
		}
		else {
			extRoleImpl.setDescription(description);
		}

		extRoleImpl.setType(type);

		if (subtype == null) {
			extRoleImpl.setSubtype(StringPool.BLANK);
		}
		else {
			extRoleImpl.setSubtype(subtype);
		}

		extRoleImpl.resetOriginalValues();

		return extRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		roleId = objectInput.readLong();

		companyId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();

		type = objectInput.readInt();
		subtype = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(roleId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(type);

		if (subtype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subtype);
		}
	}

	public long roleId;
	public long companyId;
	public long classNameId;
	public long classPK;
	public String name;
	public String title;
	public String description;
	public int type;
	public String subtype;
}