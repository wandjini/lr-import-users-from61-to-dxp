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
 * Provides a wrapper for {@link ExtRoleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExtRoleLocalService
 * @generated
 */
@ProviderType
public class ExtRoleLocalServiceWrapper implements ExtRoleLocalService,
	ServiceWrapper<ExtRoleLocalService> {
	public ExtRoleLocalServiceWrapper(ExtRoleLocalService extRoleLocalService) {
		_extRoleLocalService = extRoleLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _extRoleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _extRoleLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _extRoleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extRoleLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extRoleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the ext role to the database. Also notifies the appropriate model listeners.
	*
	* @param extRole the ext role
	* @return the ext role that was added
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtRole addExtRole(
		com.liferay.suez.user.synch.model.ExtRole extRole) {
		return _extRoleLocalService.addExtRole(extRole);
	}

	/**
	* Creates a new ext role with the primary key. Does not add the ext role to the database.
	*
	* @param roleId the primary key for the new ext role
	* @return the new ext role
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtRole createExtRole(long roleId) {
		return _extRoleLocalService.createExtRole(roleId);
	}

	/**
	* Deletes the ext role from the database. Also notifies the appropriate model listeners.
	*
	* @param extRole the ext role
	* @return the ext role that was removed
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtRole deleteExtRole(
		com.liferay.suez.user.synch.model.ExtRole extRole) {
		return _extRoleLocalService.deleteExtRole(extRole);
	}

	/**
	* Deletes the ext role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role that was removed
	* @throws PortalException if a ext role with the primary key could not be found
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtRole deleteExtRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extRoleLocalService.deleteExtRole(roleId);
	}

	@Override
	public com.liferay.suez.user.synch.model.ExtRole fetchExtRole(long roleId) {
		return _extRoleLocalService.fetchExtRole(roleId);
	}

	/**
	* Returns the ext role with the primary key.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role
	* @throws PortalException if a ext role with the primary key could not be found
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtRole getExtRole(long roleId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _extRoleLocalService.getExtRole(roleId);
	}

	/**
	* Updates the ext role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param extRole the ext role
	* @return the ext role that was updated
	*/
	@Override
	public com.liferay.suez.user.synch.model.ExtRole updateExtRole(
		com.liferay.suez.user.synch.model.ExtRole extRole) {
		return _extRoleLocalService.updateExtRole(extRole);
	}

	/**
	* Returns the number of ext roles.
	*
	* @return the number of ext roles
	*/
	@Override
	public int getExtRolesCount() {
		return _extRoleLocalService.getExtRolesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _extRoleLocalService.getOSGiServiceIdentifier();
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
		return _extRoleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _extRoleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _extRoleLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.suez.user.synch.model.ExtRole> getExtRoles() {
		return _extRoleLocalService.getExtRoles();
	}

	/**
	* Returns a range of all the ext roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @return the range of ext roles
	*/
	@Override
	public java.util.List<com.liferay.suez.user.synch.model.ExtRole> getExtRoles(
		int start, int end) {
		return _extRoleLocalService.getExtRoles(start, end);
	}

	@Override
	public java.util.List<com.liferay.suez.user.synch.model.ExtRole> getExtRolesByCompany(
		long companyId) {
		return _extRoleLocalService.getExtRolesByCompany(companyId);
	}

	@Override
	public java.util.List<com.liferay.suez.user.synch.model.ExtRole> getExtRolesByCompanyAndName(
		long companyId, java.lang.String name) {
		return _extRoleLocalService.getExtRolesByCompanyAndName(companyId, name);
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
		return _extRoleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _extRoleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public ExtRoleLocalService getWrappedService() {
		return _extRoleLocalService;
	}

	@Override
	public void setWrappedService(ExtRoleLocalService extRoleLocalService) {
		_extRoleLocalService = extRoleLocalService;
	}

	private ExtRoleLocalService _extRoleLocalService;
}