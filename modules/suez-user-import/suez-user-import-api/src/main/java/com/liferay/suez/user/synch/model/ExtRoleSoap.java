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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.suez.user.synch.service.http.ExtRoleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.suez.user.synch.service.http.ExtRoleServiceSoap
 * @generated
 */
@ProviderType
public class ExtRoleSoap implements Serializable {
	public static ExtRoleSoap toSoapModel(ExtRole model) {
		ExtRoleSoap soapModel = new ExtRoleSoap();

		soapModel.setRoleId(model.getRoleId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setSubtype(model.getSubtype());

		return soapModel;
	}

	public static ExtRoleSoap[] toSoapModels(ExtRole[] models) {
		ExtRoleSoap[] soapModels = new ExtRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExtRoleSoap[][] toSoapModels(ExtRole[][] models) {
		ExtRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExtRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExtRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExtRoleSoap[] toSoapModels(List<ExtRole> models) {
		List<ExtRoleSoap> soapModels = new ArrayList<ExtRoleSoap>(models.size());

		for (ExtRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExtRoleSoap[soapModels.size()]);
	}

	public ExtRoleSoap() {
	}

	public long getPrimaryKey() {
		return _roleId;
	}

	public void setPrimaryKey(long pk) {
		setRoleId(pk);
	}

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public String getSubtype() {
		return _subtype;
	}

	public void setSubtype(String subtype) {
		_subtype = subtype;
	}

	private long _roleId;
	private long _companyId;
	private long _classNameId;
	private long _classPK;
	private String _name;
	private String _title;
	private String _description;
	private int _type;
	private String _subtype;
}