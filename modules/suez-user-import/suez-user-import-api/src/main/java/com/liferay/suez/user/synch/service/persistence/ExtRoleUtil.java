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

package com.liferay.suez.user.synch.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.suez.user.synch.model.ExtRole;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ext role service. This utility wraps {@link com.liferay.suez.user.synch.service.persistence.impl.ExtRolePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtRolePersistence
 * @see com.liferay.suez.user.synch.service.persistence.impl.ExtRolePersistenceImpl
 * @generated
 */
@ProviderType
public class ExtRoleUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ExtRole extRole) {
		getPersistence().clearCache(extRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ExtRole> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExtRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExtRole> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExtRole> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExtRole update(ExtRole extRole) {
		return getPersistence().update(extRole);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExtRole update(ExtRole extRole, ServiceContext serviceContext) {
		return getPersistence().update(extRole, serviceContext);
	}

	/**
	* Returns all the ext roles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching ext roles
	*/
	public static List<ExtRole> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the ext roles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @return the range of matching ext roles
	*/
	public static List<ExtRole> findByCompanyId(long companyId, int start,
		int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the ext roles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching ext roles
	*/
	public static List<ExtRole> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<ExtRole> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ext roles where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching ext roles
	*/
	public static List<ExtRole> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<ExtRole> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ext role
	* @throws NoSuchExtRoleException if a matching ext role could not be found
	*/
	public static ExtRole findByCompanyId_First(long companyId,
		OrderByComparator<ExtRole> orderByComparator)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public static ExtRole fetchByCompanyId_First(long companyId,
		OrderByComparator<ExtRole> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ext role
	* @throws NoSuchExtRoleException if a matching ext role could not be found
	*/
	public static ExtRole findByCompanyId_Last(long companyId,
		OrderByComparator<ExtRole> orderByComparator)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public static ExtRole fetchByCompanyId_Last(long companyId,
		OrderByComparator<ExtRole> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the ext roles before and after the current ext role in the ordered set where companyId = &#63;.
	*
	* @param roleId the primary key of the current ext role
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ext role
	* @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	*/
	public static ExtRole[] findByCompanyId_PrevAndNext(long roleId,
		long companyId, OrderByComparator<ExtRole> orderByComparator)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(roleId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the ext roles where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of ext roles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching ext roles
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the ext role where companyId = &#63; and name = &#63; or throws a {@link NoSuchExtRoleException} if it could not be found.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching ext role
	* @throws NoSuchExtRoleException if a matching ext role could not be found
	*/
	public static ExtRole findByC_N(long companyId, java.lang.String name)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence().findByC_N(companyId, name);
	}

	/**
	* Returns the ext role where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public static ExtRole fetchByC_N(long companyId, java.lang.String name) {
		return getPersistence().fetchByC_N(companyId, name);
	}

	/**
	* Returns the ext role where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public static ExtRole fetchByC_N(long companyId, java.lang.String name,
		boolean retrieveFromCache) {
		return getPersistence().fetchByC_N(companyId, name, retrieveFromCache);
	}

	/**
	* Removes the ext role where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the ext role that was removed
	*/
	public static ExtRole removeByC_N(long companyId, java.lang.String name)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence().removeByC_N(companyId, name);
	}

	/**
	* Returns the number of ext roles where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching ext roles
	*/
	public static int countByC_N(long companyId, java.lang.String name) {
		return getPersistence().countByC_N(companyId, name);
	}

	/**
	* Caches the ext role in the entity cache if it is enabled.
	*
	* @param extRole the ext role
	*/
	public static void cacheResult(ExtRole extRole) {
		getPersistence().cacheResult(extRole);
	}

	/**
	* Caches the ext roles in the entity cache if it is enabled.
	*
	* @param extRoles the ext roles
	*/
	public static void cacheResult(List<ExtRole> extRoles) {
		getPersistence().cacheResult(extRoles);
	}

	/**
	* Creates a new ext role with the primary key. Does not add the ext role to the database.
	*
	* @param roleId the primary key for the new ext role
	* @return the new ext role
	*/
	public static ExtRole create(long roleId) {
		return getPersistence().create(roleId);
	}

	/**
	* Removes the ext role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role that was removed
	* @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	*/
	public static ExtRole remove(long roleId)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence().remove(roleId);
	}

	public static ExtRole updateImpl(ExtRole extRole) {
		return getPersistence().updateImpl(extRole);
	}

	/**
	* Returns the ext role with the primary key or throws a {@link NoSuchExtRoleException} if it could not be found.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role
	* @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	*/
	public static ExtRole findByPrimaryKey(long roleId)
		throws com.liferay.suez.user.synch.exception.NoSuchExtRoleException {
		return getPersistence().findByPrimaryKey(roleId);
	}

	/**
	* Returns the ext role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role, or <code>null</code> if a ext role with the primary key could not be found
	*/
	public static ExtRole fetchByPrimaryKey(long roleId) {
		return getPersistence().fetchByPrimaryKey(roleId);
	}

	public static java.util.Map<java.io.Serializable, ExtRole> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ext roles.
	*
	* @return the ext roles
	*/
	public static List<ExtRole> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ext roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @return the range of ext roles
	*/
	public static List<ExtRole> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ext roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ext roles
	*/
	public static List<ExtRole> findAll(int start, int end,
		OrderByComparator<ExtRole> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ext roles.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtRoleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext roles
	* @param end the upper bound of the range of ext roles (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ext roles
	*/
	public static List<ExtRole> findAll(int start, int end,
		OrderByComparator<ExtRole> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ext roles from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ext roles.
	*
	* @return the number of ext roles
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ExtRolePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExtRolePersistence, ExtRolePersistence> _serviceTracker =
		ServiceTrackerFactory.open(ExtRolePersistence.class);
}