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

package com.liferay.suez.user.synch.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExtCompanyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExtCompanyLocalService
 * @generated
 */
@ProviderType
public class ExtCompanyLocalServiceWrapper implements ExtCompanyLocalService,
	ServiceWrapper<ExtCompanyLocalService> {
	public ExtCompanyLocalServiceWrapper(
		ExtCompanyLocalService extCompanyLocalService) {
		_extCompanyLocalService = extCompanyLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _extCompanyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _extCompanyLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _extCompanyLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extCompanyLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extCompanyLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the ext company to the database. Also notifies the appropriate model listeners.
	*
	* @param extCompany the ext company
	* @return the ext company that was added
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtCompany addExtCompany(
		com.liferay.suez.user.synch.model.ExtCompany extCompany) {
		return _extCompanyLocalService.addExtCompany(extCompany);
	}

	/**
	* Creates a new ext company with the primary key. Does not add the ext company to the database.
	*
	* @param companyId the primary key for the new ext company
	* @return the new ext company
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtCompany createExtCompany(
		long companyId) {
		return _extCompanyLocalService.createExtCompany(companyId);
	}

	/**
	* Deletes the ext company from the database. Also notifies the appropriate model listeners.
	*
	* @param extCompany the ext company
	* @return the ext company that was removed
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtCompany deleteExtCompany(
		com.liferay.suez.user.synch.model.ExtCompany extCompany) {
		return _extCompanyLocalService.deleteExtCompany(extCompany);
	}

	/**
	* Deletes the ext company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company that was removed
	* @throws PortalException if a ext company with the primary key could not be found
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtCompany deleteExtCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extCompanyLocalService.deleteExtCompany(companyId);
	}

	@Override
	public com.liferay.suez.user.synch.model.ExtCompany fetchExtCompany(
		long companyId) {
		return _extCompanyLocalService.fetchExtCompany(companyId);
	}

	/**
	* Returns the ext company with the primary key.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company
	* @throws PortalException if a ext company with the primary key could not be found
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtCompany getExtCompany(
		long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extCompanyLocalService.getExtCompany(companyId);
	}

	/**
	* Updates the ext company in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param extCompany the ext company
	* @return the ext company that was updated
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtCompany updateExtCompany(
		com.liferay.suez.user.synch.model.ExtCompany extCompany) {
		return _extCompanyLocalService.updateExtCompany(extCompany);
	}

	/**
	* Returns the number of ext companies.
	*
	* @return the number of ext companies
	*/
	@Override
	public int getExtCompaniesCount() {
		return _extCompanyLocalService.getExtCompaniesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _extCompanyLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _extCompanyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _extCompanyLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _extCompanyLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the ext companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext companies
	* @param end the upper bound of the range of ext companies (not inclusive)
	* @return the range of ext companies
	*/
	@Override
	public java.util.List<com.liferay.suez.user.synch.model.ExtCompany> getExtCompanies(
		int start, int end) {
		return _extCompanyLocalService.getExtCompanies(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _extCompanyLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _extCompanyLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public ExtCompanyLocalService getWrappedService() {
		return _extCompanyLocalService;
	}

	@Override
	public void setWrappedService(ExtCompanyLocalService extCompanyLocalService) {
		_extCompanyLocalService = extCompanyLocalService;
	}

	private ExtCompanyLocalService _extCompanyLocalService;
}