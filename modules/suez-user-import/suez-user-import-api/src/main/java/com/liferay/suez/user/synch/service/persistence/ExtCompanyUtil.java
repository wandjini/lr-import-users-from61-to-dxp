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

import com.liferay.suez.user.synch.model.ExtCompany;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the ext company service. This utility wraps {@link com.liferay.suez.user.synch.service.persistence.impl.ExtCompanyPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtCompanyPersistence
 * @see com.liferay.suez.user.synch.service.persistence.impl.ExtCompanyPersistenceImpl
 * @generated
 */
@ProviderType
public class ExtCompanyUtil {
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
	public static void clearCache(ExtCompany extCompany) {
		getPersistence().clearCache(extCompany);
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
	public static List<ExtCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ExtCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ExtCompany> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ExtCompany> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ExtCompany update(ExtCompany extCompany) {
		return getPersistence().update(extCompany);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ExtCompany update(ExtCompany extCompany,
		ServiceContext serviceContext) {
		return getPersistence().update(extCompany, serviceContext);
	}

	/**
	* Returns the ext company where webId = &#63; or throws a {@link NoSuchExtCompanyException} if it could not be found.
	*
	* @param webId the web ID
	* @return the matching ext company
	* @throws NoSuchExtCompanyException if a matching ext company could not be found
	*/
	public static ExtCompany findByWebId(java.lang.String webId)
		throws com.liferay.suez.user.synch.exception.NoSuchExtCompanyException {
		return getPersistence().findByWebId(webId);
	}

	/**
	* Returns the ext company where webId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param webId the web ID
	* @return the matching ext company, or <code>null</code> if a matching ext company could not be found
	*/
	public static ExtCompany fetchByWebId(java.lang.String webId) {
		return getPersistence().fetchByWebId(webId);
	}

	/**
	* Returns the ext company where webId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param webId the web ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ext company, or <code>null</code> if a matching ext company could not be found
	*/
	public static ExtCompany fetchByWebId(java.lang.String webId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByWebId(webId, retrieveFromCache);
	}

	/**
	* Removes the ext company where webId = &#63; from the database.
	*
	* @param webId the web ID
	* @return the ext company that was removed
	*/
	public static ExtCompany removeByWebId(java.lang.String webId)
		throws com.liferay.suez.user.synch.exception.NoSuchExtCompanyException {
		return getPersistence().removeByWebId(webId);
	}

	/**
	* Returns the number of ext companies where webId = &#63;.
	*
	* @param webId the web ID
	* @return the number of matching ext companies
	*/
	public static int countByWebId(java.lang.String webId) {
		return getPersistence().countByWebId(webId);
	}

	/**
	* Caches the ext company in the entity cache if it is enabled.
	*
	* @param extCompany the ext company
	*/
	public static void cacheResult(ExtCompany extCompany) {
		getPersistence().cacheResult(extCompany);
	}

	/**
	* Caches the ext companies in the entity cache if it is enabled.
	*
	* @param extCompanies the ext companies
	*/
	public static void cacheResult(List<ExtCompany> extCompanies) {
		getPersistence().cacheResult(extCompanies);
	}

	/**
	* Creates a new ext company with the primary key. Does not add the ext company to the database.
	*
	* @param companyId the primary key for the new ext company
	* @return the new ext company
	*/
	public static ExtCompany create(long companyId) {
		return getPersistence().create(companyId);
	}

	/**
	* Removes the ext company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company that was removed
	* @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	*/
	public static ExtCompany remove(long companyId)
		throws com.liferay.suez.user.synch.exception.NoSuchExtCompanyException {
		return getPersistence().remove(companyId);
	}

	public static ExtCompany updateImpl(ExtCompany extCompany) {
		return getPersistence().updateImpl(extCompany);
	}

	/**
	* Returns the ext company with the primary key or throws a {@link NoSuchExtCompanyException} if it could not be found.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company
	* @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	*/
	public static ExtCompany findByPrimaryKey(long companyId)
		throws com.liferay.suez.user.synch.exception.NoSuchExtCompanyException {
		return getPersistence().findByPrimaryKey(companyId);
	}

	/**
	* Returns the ext company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company, or <code>null</code> if a ext company with the primary key could not be found
	*/
	public static ExtCompany fetchByPrimaryKey(long companyId) {
		return getPersistence().fetchByPrimaryKey(companyId);
	}

	public static java.util.Map<java.io.Serializable, ExtCompany> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the ext companies.
	*
	* @return the ext companies
	*/
	public static List<ExtCompany> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the ext companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext companies
	* @param end the upper bound of the range of ext companies (not inclusive)
	* @return the range of ext companies
	*/
	public static List<ExtCompany> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the ext companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext companies
	* @param end the upper bound of the range of ext companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of ext companies
	*/
	public static List<ExtCompany> findAll(int start, int end,
		OrderByComparator<ExtCompany> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the ext companies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtCompanyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of ext companies
	* @param end the upper bound of the range of ext companies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of ext companies
	*/
	public static List<ExtCompany> findAll(int start, int end,
		OrderByComparator<ExtCompany> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the ext companies from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of ext companies.
	*
	* @return the number of ext companies
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static ExtCompanyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExtCompanyPersistence, ExtCompanyPersistence> _serviceTracker =
		ServiceTrackerFactory.open(ExtCompanyPersistence.class);
}