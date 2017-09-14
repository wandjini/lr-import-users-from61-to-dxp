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
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.AttachedModel;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Locale;
import java.util.Map;

/**
 * The base model interface for the ExtRole service. Represents a row in the &quot;role_&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.suez.user.synch.model.impl.ExtRoleImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtRole
 * @see com.liferay.suez.user.synch.model.impl.ExtRoleImpl
 * @see com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl
 * @generated
 */
@ProviderType
public interface ExtRoleModel extends AttachedModel, BaseModel<ExtRole>,
	LocalizedModel, ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ext role model instance should use the {@link ExtRole} interface instead.
	 */

	/**
	 * Returns the primary key of this ext role.
	 *
	 * @return the primary key of this ext role
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ext role.
	 *
	 * @param primaryKey the primary key of this ext role
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the role ID of this ext role.
	 *
	 * @return the role ID of this ext role
	 */
	public long getRoleId();

	/**
	 * Sets the role ID of this ext role.
	 *
	 * @param roleId the role ID of this ext role
	 */
	public void setRoleId(long roleId);

	/**
	 * Returns the company ID of this ext role.
	 *
	 * @return the company ID of this ext role
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ext role.
	 *
	 * @param companyId the company ID of this ext role
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the fully qualified class name of this ext role.
	 *
	 * @return the fully qualified class name of this ext role
	 */
	@Override
	public String getClassName();

	public void setClassName(String className);

	/**
	 * Returns the class name ID of this ext role.
	 *
	 * @return the class name ID of this ext role
	 */
	@Override
	public long getClassNameId();

	/**
	 * Sets the class name ID of this ext role.
	 *
	 * @param classNameId the class name ID of this ext role
	 */
	@Override
	public void setClassNameId(long classNameId);

	/**
	 * Returns the class p k of this ext role.
	 *
	 * @return the class p k of this ext role
	 */
	@Override
	public long getClassPK();

	/**
	 * Sets the class p k of this ext role.
	 *
	 * @param classPK the class p k of this ext role
	 */
	@Override
	public void setClassPK(long classPK);

	/**
	 * Returns the name of this ext role.
	 *
	 * @return the name of this ext role
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this ext role.
	 *
	 * @param name the name of this ext role
	 */
	public void setName(String name);

	/**
	 * Returns the title of this ext role.
	 *
	 * @return the title of this ext role
	 */
	public String getTitle();

	/**
	 * Returns the localized title of this ext role in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this ext role
	 */
	@AutoEscape
	public String getTitle(Locale locale);

	/**
	 * Returns the localized title of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this ext role. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getTitle(Locale locale, boolean useDefault);

	/**
	 * Returns the localized title of this ext role in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this ext role
	 */
	@AutoEscape
	public String getTitle(String languageId);

	/**
	 * Returns the localized title of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this ext role
	 */
	@AutoEscape
	public String getTitle(String languageId, boolean useDefault);

	@AutoEscape
	public String getTitleCurrentLanguageId();

	@AutoEscape
	public String getTitleCurrentValue();

	/**
	 * Returns a map of the locales and localized titles of this ext role.
	 *
	 * @return the locales and localized titles of this ext role
	 */
	public Map<Locale, String> getTitleMap();

	/**
	 * Sets the title of this ext role.
	 *
	 * @param title the title of this ext role
	 */
	public void setTitle(String title);

	/**
	 * Sets the localized title of this ext role in the language.
	 *
	 * @param title the localized title of this ext role
	 * @param locale the locale of the language
	 */
	public void setTitle(String title, Locale locale);

	/**
	 * Sets the localized title of this ext role in the language, and sets the default locale.
	 *
	 * @param title the localized title of this ext role
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setTitle(String title, Locale locale, Locale defaultLocale);

	public void setTitleCurrentLanguageId(String languageId);

	/**
	 * Sets the localized titles of this ext role from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this ext role
	 */
	public void setTitleMap(Map<Locale, String> titleMap);

	/**
	 * Sets the localized titles of this ext role from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this ext role
	 * @param defaultLocale the default locale
	 */
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale);

	/**
	 * Returns the description of this ext role.
	 *
	 * @return the description of this ext role
	 */
	public String getDescription();

	/**
	 * Returns the localized description of this ext role in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized description of this ext role
	 */
	@AutoEscape
	public String getDescription(Locale locale);

	/**
	 * Returns the localized description of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this ext role. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getDescription(Locale locale, boolean useDefault);

	/**
	 * Returns the localized description of this ext role in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized description of this ext role
	 */
	@AutoEscape
	public String getDescription(String languageId);

	/**
	 * Returns the localized description of this ext role in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized description of this ext role
	 */
	@AutoEscape
	public String getDescription(String languageId, boolean useDefault);

	@AutoEscape
	public String getDescriptionCurrentLanguageId();

	@AutoEscape
	public String getDescriptionCurrentValue();

	/**
	 * Returns a map of the locales and localized descriptions of this ext role.
	 *
	 * @return the locales and localized descriptions of this ext role
	 */
	public Map<Locale, String> getDescriptionMap();

	/**
	 * Sets the description of this ext role.
	 *
	 * @param description the description of this ext role
	 */
	public void setDescription(String description);

	/**
	 * Sets the localized description of this ext role in the language.
	 *
	 * @param description the localized description of this ext role
	 * @param locale the locale of the language
	 */
	public void setDescription(String description, Locale locale);

	/**
	 * Sets the localized description of this ext role in the language, and sets the default locale.
	 *
	 * @param description the localized description of this ext role
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setDescription(String description, Locale locale,
		Locale defaultLocale);

	public void setDescriptionCurrentLanguageId(String languageId);

	/**
	 * Sets the localized descriptions of this ext role from the map of locales and localized descriptions.
	 *
	 * @param descriptionMap the locales and localized descriptions of this ext role
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap);

	/**
	 * Sets the localized descriptions of this ext role from the map of locales and localized descriptions, and sets the default locale.
	 *
	 * @param descriptionMap the locales and localized descriptions of this ext role
	 * @param defaultLocale the default locale
	 */
	public void setDescriptionMap(Map<Locale, String> descriptionMap,
		Locale defaultLocale);

	/**
	 * Returns the type of this ext role.
	 *
	 * @return the type of this ext role
	 */
	public int getType();

	/**
	 * Sets the type of this ext role.
	 *
	 * @param type the type of this ext role
	 */
	public void setType(int type);

	/**
	 * Returns the subtype of this ext role.
	 *
	 * @return the subtype of this ext role
	 */
	@AutoEscape
	public String getSubtype();

	/**
	 * Sets the subtype of this ext role.
	 *
	 * @param subtype the subtype of this ext role
	 */
	public void setSubtype(String subtype);

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
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

	@Override
	public Object clone();

	@Override
	public int compareTo(ExtRole extRole);

	@Override
	public int hashCode();

	@Override
	public CacheModel<ExtRole> toCacheModel();

	@Override
	public ExtRole toEscapedModel();

	@Override
	public ExtRole toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}