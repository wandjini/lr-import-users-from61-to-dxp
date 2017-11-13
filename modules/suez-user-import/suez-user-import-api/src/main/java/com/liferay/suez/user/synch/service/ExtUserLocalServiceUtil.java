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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ExtUser. This utility wraps
 * {@link com.liferay.suez.user.synch.service.impl.ExtUserLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExtUserLocalService
 * @see com.liferay.suez.user.synch.service.base.ExtUserLocalServiceBaseImpl
 * @see com.liferay.suez.user.synch.service.impl.ExtUserLocalServiceImpl
 * @generated
 */
@ProviderType
public class ExtUserLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.suez.user.synch.service.impl.ExtUserLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the ext user to the database. Also notifies the appropriate model listeners.
	*
	* @param extUser the ext user
	* @return the ext user that was added
	*/
	public static com.liferay.suez.user.synch.model.ExtUser addExtUser(
		com.liferay.suez.user.synch.model.ExtUser extUser) {
		return getService().addExtUser(extUser);
	}

	/**
	* Creates a new ext user with the primary key. Does not add the ext user to the database.
	*
	* @param userId the primary key for the new ext user
	* @return the new ext user
	*/
	public static com.liferay.suez.user.synch.model.ExtUser createExtUser(
		long userId) {
		return getService().createExtUser(userId);
	}

	/**
	* Deletes the ext user from the database. Also notifies the appropriate model listeners.
	*
	* @param extUser the ext user
	* @return the ext user that was removed
	*/
	public static com.liferay.suez.user.synch.model.ExtUser deleteExtUser(
		com.liferay.suez.user.synch.model.ExtUser extUser) {
		return getService().deleteExtUser(extUser);
	}

	/**
	* Deletes the ext user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the ext user
	* @return the ext user that was removed
	* @throws PortalException if a ext user with the primary key could not be found
	*/
	public static com.liferay.suez.user.synch.model.ExtUser deleteExtUser(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteExtUser(userId);
	}

	public static com.liferay.suez.user.synch.model.ExtUser fetchExtUser(
		long userId) {
		return getService().fetchExtUser(userId);
	}

	/**
	* Returns the ext user with the primary key.
	*
	* @param userId the primary key of the ext user
	* @return the ext user
	* @throws PortalException if a ext user with the primary key could not be found
	*/
	public static com.liferay.suez.user.synch.model.ExtUser getExtUser(
		long userId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getExtUser(userId);
	}

	/**
	* Updates the ext user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param extUser the ext user
	* @return the ext user that was updated
	*/
	public static com.liferay.suez.user.synch.model.ExtUser updateExtUser(
		com.liferay.suez.user.synch.model.ExtUser extUser) {
		return getService().updateExtUser(extUser);
	}

	/**
	* This method return the total number of external users
	*/
	public static int countExtUsers() {
		return getService().countExtUsers();
	}

	/**
	* This method returns the number of external users filtered by company and role
	*/
	public static int countExtUsersByCompanyAndRole(long companyId,
		long roleId, java.util.Date startDate, java.util.Date endDate) {
		return getService()
				   .countExtUsersByCompanyAndRole(companyId, roleId, startDate,
			endDate);
	}

	/**
	* This method returns the number of external users filtered by company and list of roles
	*/
	public static int countExtUsersByCompanyAndRoleIds(long companyId,
		java.lang.Long[] roleIds, java.util.Date startDate,
		java.util.Date endDate) {
		return getService()
				   .countExtUsersByCompanyAndRoleIds(companyId, roleIds,
			startDate, endDate);
	}

	/**
	* Returns the number of ext users.
	*
	* @return the number of ext users
	*/
	public static int getExtUsersCount() {
		return getService().getExtUsersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* <p> This method return users</p>
	*
	* @return -> List of external users
	*/
	public static java.util.List<com.liferay.suez.user.synch.model.ExtUser> findExtUsers(
		int start, int end) {
		return getService().findExtUsers(start, end);
	}

	/**
	* This method returns the list of external users filtered by company and role
	*/
	public static java.util.List<com.liferay.suez.user.synch.model.ExtUser> findExtUsersByCompanyAndRole(
		long companyId, long roleId, java.util.Date startDate,
		java.util.Date endDate, int start, int end) {
		return getService()
				   .findExtUsersByCompanyAndRole(companyId, roleId, startDate,
			endDate, start, end);
	}

	/**
	* Returns a range of all the ext users.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.suez.user.synch.model.impl.ExtUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext users
	* @param end the upper bound of the range of ext users (not inclusive)
	* @return the range of ext users
	*/
	public static java.util.List<com.liferay.suez.user.synch.model.ExtUser> getExtUsers(
		int start, int end) {
		return getService().getExtUsers(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ExtUserLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExtUserLocalService, ExtUserLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ExtUserLocalService.class);
}