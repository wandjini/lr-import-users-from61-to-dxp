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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ExtCompany}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtCompany
 * @generated
 */
@ProviderType
public class ExtCompanyWrapper implements ExtCompany, ModelWrapper<ExtCompany> {
	public ExtCompanyWrapper(ExtCompany extCompany) {
		_extCompany = extCompany;
	}

	@Override
	public Class<?> getModelClass() {
		return ExtCompany.class;
	}

	@Override
	public String getModelClassName() {
		return ExtCompany.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("accountId", getAccountId());
		attributes.put("webId", getWebId());
		attributes.put("key", getKey());
		attributes.put("mx", getMx());
		attributes.put("homeURL", getHomeURL());
		attributes.put("logoId", getLogoId());
		attributes.put("system", getSystem());
		attributes.put("maxUsers", getMaxUsers());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		String webId = (String)attributes.get("webId");

		if (webId != null) {
			setWebId(webId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String mx = (String)attributes.get("mx");

		if (mx != null) {
			setMx(mx);
		}

		String homeURL = (String)attributes.get("homeURL");

		if (homeURL != null) {
			setHomeURL(homeURL);
		}

		Long logoId = (Long)attributes.get("logoId");

		if (logoId != null) {
			setLogoId(logoId);
		}

		Boolean system = (Boolean)attributes.get("system");

		if (system != null) {
			setSystem(system);
		}

		Integer maxUsers = (Integer)attributes.get("maxUsers");

		if (maxUsers != null) {
			setMaxUsers(maxUsers);
		}
	}

	@Override
	public ExtCompany toEscapedModel() {
		return new ExtCompanyWrapper(_extCompany.toEscapedModel());
	}

	@Override
	public ExtCompany toUnescapedModel() {
		return new ExtCompanyWrapper(_extCompany.toUnescapedModel());
	}

	/**
	* Returns the system of this ext company.
	*
	* @return the system of this ext company
	*/
	@Override
	public boolean getSystem() {
		return _extCompany.getSystem();
	}

	@Override
	public boolean isCachedModel() {
		return _extCompany.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _extCompany.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _extCompany.isNew();
	}

	/**
	* Returns <code>true</code> if this ext company is system.
	*
	* @return <code>true</code> if this ext company is system; <code>false</code> otherwise
	*/
	@Override
	public boolean isSystem() {
		return _extCompany.isSystem();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _extCompany.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExtCompany> toCacheModel() {
		return _extCompany.toCacheModel();
	}

	@Override
	public int compareTo(ExtCompany extCompany) {
		return _extCompany.compareTo(extCompany);
	}

	/**
	* Returns the max users of this ext company.
	*
	* @return the max users of this ext company
	*/
	@Override
	public int getMaxUsers() {
		return _extCompany.getMaxUsers();
	}

	@Override
	public int hashCode() {
		return _extCompany.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _extCompany.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ExtCompanyWrapper((ExtCompany)_extCompany.clone());
	}

	/**
	* Returns the home u r l of this ext company.
	*
	* @return the home u r l of this ext company
	*/
	@Override
	public java.lang.String getHomeURL() {
		return _extCompany.getHomeURL();
	}

	/**
	* Returns the key of this ext company.
	*
	* @return the key of this ext company
	*/
	@Override
	public java.lang.String getKey() {
		return _extCompany.getKey();
	}

	/**
	* Returns the mx of this ext company.
	*
	* @return the mx of this ext company
	*/
	@Override
	public java.lang.String getMx() {
		return _extCompany.getMx();
	}

	/**
	* Returns the web ID of this ext company.
	*
	* @return the web ID of this ext company
	*/
	@Override
	public java.lang.String getWebId() {
		return _extCompany.getWebId();
	}

	@Override
	public java.lang.String toString() {
		return _extCompany.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _extCompany.toXmlString();
	}

	/**
	* Returns the account ID of this ext company.
	*
	* @return the account ID of this ext company
	*/
	@Override
	public long getAccountId() {
		return _extCompany.getAccountId();
	}

	/**
	* Returns the company ID of this ext company.
	*
	* @return the company ID of this ext company
	*/
	@Override
	public long getCompanyId() {
		return _extCompany.getCompanyId();
	}

	/**
	* Returns the logo ID of this ext company.
	*
	* @return the logo ID of this ext company
	*/
	@Override
	public long getLogoId() {
		return _extCompany.getLogoId();
	}

	/**
	* Returns the primary key of this ext company.
	*
	* @return the primary key of this ext company
	*/
	@Override
	public long getPrimaryKey() {
		return _extCompany.getPrimaryKey();
	}

	@Override
	public void persist() {
		_extCompany.persist();
	}

	/**
	* Sets the account ID of this ext company.
	*
	* @param accountId the account ID of this ext company
	*/
	@Override
	public void setAccountId(long accountId) {
		_extCompany.setAccountId(accountId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_extCompany.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this ext company.
	*
	* @param companyId the company ID of this ext company
	*/
	@Override
	public void setCompanyId(long companyId) {
		_extCompany.setCompanyId(companyId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_extCompany.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_extCompany.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_extCompany.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the home u r l of this ext company.
	*
	* @param homeURL the home u r l of this ext company
	*/
	@Override
	public void setHomeURL(java.lang.String homeURL) {
		_extCompany.setHomeURL(homeURL);
	}

	/**
	* Sets the key of this ext company.
	*
	* @param key the key of this ext company
	*/
	@Override
	public void setKey(java.lang.String key) {
		_extCompany.setKey(key);
	}

	/**
	* Sets the logo ID of this ext company.
	*
	* @param logoId the logo ID of this ext company
	*/
	@Override
	public void setLogoId(long logoId) {
		_extCompany.setLogoId(logoId);
	}

	/**
	* Sets the max users of this ext company.
	*
	* @param maxUsers the max users of this ext company
	*/
	@Override
	public void setMaxUsers(int maxUsers) {
		_extCompany.setMaxUsers(maxUsers);
	}

	/**
	* Sets the mx of this ext company.
	*
	* @param mx the mx of this ext company
	*/
	@Override
	public void setMx(java.lang.String mx) {
		_extCompany.setMx(mx);
	}

	@Override
	public void setNew(boolean n) {
		_extCompany.setNew(n);
	}

	/**
	* Sets the primary key of this ext company.
	*
	* @param primaryKey the primary key of this ext company
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_extCompany.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_extCompany.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this ext company is system.
	*
	* @param system the system of this ext company
	*/
	@Override
	public void setSystem(boolean system) {
		_extCompany.setSystem(system);
	}

	/**
	* Sets the web ID of this ext company.
	*
	* @param webId the web ID of this ext company
	*/
	@Override
	public void setWebId(java.lang.String webId) {
		_extCompany.setWebId(webId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtCompanyWrapper)) {
			return false;
		}

		ExtCompanyWrapper extCompanyWrapper = (ExtCompanyWrapper)obj;

		if (Objects.equals(_extCompany, extCompanyWrapper._extCompany)) {
			return true;
		}

		return false;
	}

	@Override
	public ExtCompany getWrappedModel() {
		return _extCompany;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _extCompany.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _extCompany.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_extCompany.resetOriginalValues();
	}

	private final ExtCompany _extCompany;
}