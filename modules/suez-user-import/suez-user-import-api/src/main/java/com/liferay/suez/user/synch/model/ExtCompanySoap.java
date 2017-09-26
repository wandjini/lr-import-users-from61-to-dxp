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
 * This class is used by SOAP remote services, specifically {@link com.liferay.suez.user.synch.service.http.ExtCompanyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.suez.user.synch.service.http.ExtCompanyServiceSoap
 * @generated
 */
@ProviderType
public class ExtCompanySoap implements Serializable {
	public static ExtCompanySoap toSoapModel(ExtCompany model) {
		ExtCompanySoap soapModel = new ExtCompanySoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setWebId(model.getWebId());
		soapModel.setKey(model.getKey());
		soapModel.setMx(model.getMx());
		soapModel.setHomeURL(model.getHomeURL());
		soapModel.setLogoId(model.getLogoId());
		soapModel.setSystem(model.getSystem());
		soapModel.setMaxUsers(model.getMaxUsers());

		return soapModel;
	}

	public static ExtCompanySoap[] toSoapModels(ExtCompany[] models) {
		ExtCompanySoap[] soapModels = new ExtCompanySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExtCompanySoap[][] toSoapModels(ExtCompany[][] models) {
		ExtCompanySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExtCompanySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExtCompanySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExtCompanySoap[] toSoapModels(List<ExtCompany> models) {
		List<ExtCompanySoap> soapModels = new ArrayList<ExtCompanySoap>(models.size());

		for (ExtCompany model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExtCompanySoap[soapModels.size()]);
	}

	public ExtCompanySoap() {
	}

	public long getPrimaryKey() {
		return _companyId;
	}

	public void setPrimaryKey(long pk) {
		setCompanyId(pk);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getAccountId() {
		return _accountId;
	}

	public void setAccountId(long accountId) {
		_accountId = accountId;
	}

	public String getWebId() {
		return _webId;
	}

	public void setWebId(String webId) {
		_webId = webId;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getMx() {
		return _mx;
	}

	public void setMx(String mx) {
		_mx = mx;
	}

	public String getHomeURL() {
		return _homeURL;
	}

	public void setHomeURL(String homeURL) {
		_homeURL = homeURL;
	}

	public long getLogoId() {
		return _logoId;
	}

	public void setLogoId(long logoId) {
		_logoId = logoId;
	}

	public boolean getSystem() {
		return _system;
	}

	public boolean isSystem() {
		return _system;
	}

	public void setSystem(boolean system) {
		_system = system;
	}

	public int getMaxUsers() {
		return _maxUsers;
	}

	public void setMaxUsers(int maxUsers) {
		_maxUsers = maxUsers;
	}

	private long _companyId;
	private long _accountId;
	private String _webId;
	private String _key;
	private String _mx;
	private String _homeURL;
	private long _logoId;
	private boolean _system;
	private int _maxUsers;
}