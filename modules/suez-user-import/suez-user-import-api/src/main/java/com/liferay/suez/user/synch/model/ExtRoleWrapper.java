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
 * This class is a wrapper for {@link ExtRole}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtRole
 * @generated
 */
@ProviderType
public class ExtRoleWrapper implements ExtRole, ModelWrapper<ExtRole> {
	public ExtRoleWrapper(ExtRole extRole) {
		_extRole = extRole;
	}

	@Override
	public Class<?> getModelClass() {
		return ExtRole.class;
	}

	@Override
	public String getModelClassName() {
		return ExtRole.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("roleId", getRoleId());
		attributes.put("companyId", getCompanyId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("type", getType());
		attributes.put("subtype", getSubtype());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String subtype = (String)attributes.get("subtype");

		if (subtype != null) {
			setSubtype(subtype);
		}
	}

	@Override
	public ExtRole toEscapedModel() {
		return new ExtRoleWrapper(_extRole.toEscapedModel());
	}

	@Override
	public ExtRole toUnescapedModel() {
		return new ExtRoleWrapper(_extRole.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _extRole.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _extRole.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _extRole.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _extRole.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ExtRole> toCacheModel() {
		return _extRole.toCacheModel();
	}

	@Override
	public int compareTo(ExtRole extRole) {
		return _extRole.compareTo(extRole);
	}

	/**
	* Returns the type of this ext role.
	*
	* @return the type of this ext role
	*/
	@Override
	public int getType() {
		return _extRole.getType();
	}

	@Override
	public int hashCode() {
		return _extRole.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _extRole.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new ExtRoleWrapper((ExtRole)_extRole.clone());
	}

	/**
	* Returns the fully qualified class name of this ext role.
	*
	* @return the fully qualified class name of this ext role
	*/
	@Override
	public java.lang.String getClassName() {
		return _extRole.getClassName();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _extRole.getDefaultLanguageId();
	}

	/**
	* Returns the description of this ext role.
	*
	* @return the description of this ext role
	*/
	@Override
	public java.lang.String getDescription() {
		return _extRole.getDescription();
	}

	/**
	* Returns the localized description of this ext role in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized description of this ext role
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId) {
		return _extRole.getDescription(languageId);
	}

	/**
	* Returns the localized description of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this ext role
	*/
	@Override
	public java.lang.String getDescription(java.lang.String languageId,
		boolean useDefault) {
		return _extRole.getDescription(languageId, useDefault);
	}

	/**
	* Returns the localized description of this ext role in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized description of this ext role
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale) {
		return _extRole.getDescription(locale);
	}

	/**
	* Returns the localized description of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized description of this ext role. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getDescription(java.util.Locale locale,
		boolean useDefault) {
		return _extRole.getDescription(locale, useDefault);
	}

	@Override
	public java.lang.String getDescriptionCurrentLanguageId() {
		return _extRole.getDescriptionCurrentLanguageId();
	}

	@Override
	public java.lang.String getDescriptionCurrentValue() {
		return _extRole.getDescriptionCurrentValue();
	}

	/**
	* Returns the name of this ext role.
	*
	* @return the name of this ext role
	*/
	@Override
	public java.lang.String getName() {
		return _extRole.getName();
	}

	/**
	* Returns the subtype of this ext role.
	*
	* @return the subtype of this ext role
	*/
	@Override
	public java.lang.String getSubtype() {
		return _extRole.getSubtype();
	}

	/**
	* Returns the title of this ext role.
	*
	* @return the title of this ext role
	*/
	@Override
	public java.lang.String getTitle() {
		return _extRole.getTitle();
	}

	/**
	* Returns the localized title of this ext role in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this ext role
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _extRole.getTitle(languageId);
	}

	/**
	* Returns the localized title of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this ext role
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _extRole.getTitle(languageId, useDefault);
	}

	/**
	* Returns the localized title of this ext role in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this ext role
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _extRole.getTitle(locale);
	}

	/**
	* Returns the localized title of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this ext role. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _extRole.getTitle(locale, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _extRole.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _extRole.getTitleCurrentValue();
	}

	@Override
	public java.lang.String toString() {
		return _extRole.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _extRole.toXmlString();
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _extRole.getAvailableLanguageIds();
	}

	/**
	* Returns a map of the locales and localized descriptions of this ext role.
	*
	* @return the locales and localized descriptions of this ext role
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getDescriptionMap() {
		return _extRole.getDescriptionMap();
	}

	/**
	* Returns a map of the locales and localized titles of this ext role.
	*
	* @return the locales and localized titles of this ext role
	*/
	@Override
	public Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _extRole.getTitleMap();
	}

	/**
	* Returns the class name ID of this ext role.
	*
	* @return the class name ID of this ext role
	*/
	@Override
	public long getClassNameId() {
		return _extRole.getClassNameId();
	}

	/**
	* Returns the class p k of this ext role.
	*
	* @return the class p k of this ext role
	*/
	@Override
	public long getClassPK() {
		return _extRole.getClassPK();
	}

	/**
	* Returns the company ID of this ext role.
	*
	* @return the company ID of this ext role
	*/
	@Override
	public long getCompanyId() {
		return _extRole.getCompanyId();
	}

	/**
	* Returns the primary key of this ext role.
	*
	* @return the primary key of this ext role
	*/
	@Override
	public long getPrimaryKey() {
		return _extRole.getPrimaryKey();
	}

	/**
	* Returns the role ID of this ext role.
	*
	* @return the role ID of this ext role
	*/
	@Override
	public long getRoleId() {
		return _extRole.getRoleId();
	}

	@Override
	public void persist() {
		_extRole.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {
		_extRole.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {
		_extRole.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_extRole.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(java.lang.String className) {
		_extRole.setClassName(className);
	}

	/**
	* Sets the class name ID of this ext role.
	*
	* @param classNameId the class name ID of this ext role
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_extRole.setClassNameId(classNameId);
	}

	/**
	* Sets the class p k of this ext role.
	*
	* @param classPK the class p k of this ext role
	*/
	@Override
	public void setClassPK(long classPK) {
		_extRole.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this ext role.
	*
	* @param companyId the company ID of this ext role
	*/
	@Override
	public void setCompanyId(long companyId) {
		_extRole.setCompanyId(companyId);
	}

	/**
	* Sets the description of this ext role.
	*
	* @param description the description of this ext role
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_extRole.setDescription(description);
	}

	/**
	* Sets the localized description of this ext role in the language.
	*
	* @param description the localized description of this ext role
	* @param locale the locale of the language
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale) {
		_extRole.setDescription(description, locale);
	}

	/**
	* Sets the localized description of this ext role in the language, and sets the default locale.
	*
	* @param description the localized description of this ext role
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescription(java.lang.String description,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_extRole.setDescription(description, locale, defaultLocale);
	}

	@Override
	public void setDescriptionCurrentLanguageId(java.lang.String languageId) {
		_extRole.setDescriptionCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized descriptions of this ext role from the map of locales and localized descriptions.
	*
	* @param descriptionMap the locales and localized descriptions of this ext role
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap) {
		_extRole.setDescriptionMap(descriptionMap);
	}

	/**
	* Sets the localized descriptions of this ext role from the map of locales and localized descriptions, and sets the default locale.
	*
	* @param descriptionMap the locales and localized descriptions of this ext role
	* @param defaultLocale the default locale
	*/
	@Override
	public void setDescriptionMap(
		Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Locale defaultLocale) {
		_extRole.setDescriptionMap(descriptionMap, defaultLocale);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_extRole.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_extRole.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_extRole.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the name of this ext role.
	*
	* @param name the name of this ext role
	*/
	@Override
	public void setName(java.lang.String name) {
		_extRole.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_extRole.setNew(n);
	}

	/**
	* Sets the primary key of this ext role.
	*
	* @param primaryKey the primary key of this ext role
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_extRole.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_extRole.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the role ID of this ext role.
	*
	* @param roleId the role ID of this ext role
	*/
	@Override
	public void setRoleId(long roleId) {
		_extRole.setRoleId(roleId);
	}

	/**
	* Sets the subtype of this ext role.
	*
	* @param subtype the subtype of this ext role
	*/
	@Override
	public void setSubtype(java.lang.String subtype) {
		_extRole.setSubtype(subtype);
	}

	/**
	* Sets the title of this ext role.
	*
	* @param title the title of this ext role
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_extRole.setTitle(title);
	}

	/**
	* Sets the localized title of this ext role in the language.
	*
	* @param title the localized title of this ext role
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_extRole.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this ext role in the language, and sets the default locale.
	*
	* @param title the localized title of this ext role
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_extRole.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_extRole.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this ext role from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this ext role
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap) {
		_extRole.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this ext role from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this ext role
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_extRole.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Sets the type of this ext role.
	*
	* @param type the type of this ext role
	*/
	@Override
	public void setType(int type) {
		_extRole.setType(type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExtRoleWrapper)) {
			return false;
		}

		ExtRoleWrapper extRoleWrapper = (ExtRoleWrapper)obj;

		if (Objects.equals(_extRole, extRoleWrapper._extRole)) {
			return true;
		}

		return false;
	}

	@Override
	public ExtRole getWrappedModel() {
		return _extRole;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _extRole.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _extRole.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_extRole.resetOriginalValues();
	}

	private final ExtRole _extRole;
}