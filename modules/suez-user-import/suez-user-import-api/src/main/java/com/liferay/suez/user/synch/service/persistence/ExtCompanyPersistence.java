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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.suez.user.synch.exception.NoSuchExtCompanyException;
import com.liferay.suez.user.synch.model.ExtCompany;

/**
 * The persistence interface for the ext company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.suez.user.synch.service.persistence.impl.ExtCompanyPersistenceImpl
 * @see ExtCompanyUtil
 * @generated
 */
@ProviderType
public interface ExtCompanyPersistence extends BasePersistence<ExtCompany> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtCompanyUtil} to access the ext company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the ext company where webId = &#63; or throws a {@link NoSuchExtCompanyException} if it could not be found.
	*
	* @param webId the web ID
	* @return the matching ext company
	* @throws NoSuchExtCompanyException if a matching ext company could not be found
	*/
	public ExtCompany findByWebId(java.lang.String webId)
		throws NoSuchExtCompanyException;

	/**
	* Returns the ext company where webId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param webId the web ID
	* @return the matching ext company, or <code>null</code> if a matching ext company could not be found
	*/
	public ExtCompany fetchByWebId(java.lang.String webId);

	/**
	* Returns the ext company where webId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param webId the web ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ext company, or <code>null</code> if a matching ext company could not be found
	*/
	public ExtCompany fetchByWebId(java.lang.String webId,
		boolean retrieveFromCache);

	/**
	* Removes the ext company where webId = &#63; from the database.
	*
	* @param webId the web ID
	* @return the ext company that was removed
	*/
	public ExtCompany removeByWebId(java.lang.String webId)
		throws NoSuchExtCompanyException;

	/**
	* Returns the number of ext companies where webId = &#63;.
	*
	* @param webId the web ID
	* @return the number of matching ext companies
	*/
	public int countByWebId(java.lang.String webId);

	/**
	* Caches the ext company in the entity cache if it is enabled.
	*
	* @param extCompany the ext company
	*/
	public void cacheResult(ExtCompany extCompany);

	/**
	* Caches the ext companies in the entity cache if it is enabled.
	*
	* @param extCompanies the ext companies
	*/
	public void cacheResult(java.util.List<ExtCompany> extCompanies);

	/**
	* Creates a new ext company with the primary key. Does not add the ext company to the database.
	*
	* @param companyId the primary key for the new ext company
	* @return the new ext company
	*/
	public ExtCompany create(long companyId);

	/**
	* Removes the ext company with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company that was removed
	* @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	*/
	public ExtCompany remove(long companyId) throws NoSuchExtCompanyException;

	public ExtCompany updateImpl(ExtCompany extCompany);

	/**
	* Returns the ext company with the primary key or throws a {@link NoSuchExtCompanyException} if it could not be found.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company
	* @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	*/
	public ExtCompany findByPrimaryKey(long companyId)
		throws NoSuchExtCompanyException;

	/**
	* Returns the ext company with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param companyId the primary key of the ext company
	* @return the ext company, or <code>null</code> if a ext company with the primary key could not be found
	*/
	public ExtCompany fetchByPrimaryKey(long companyId);

	@Override
	public java.util.Map<java.io.Serializable, ExtCompany> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ext companies.
	*
	* @return the ext companies
	*/
	public java.util.List<ExtCompany> findAll();

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
	public java.util.List<ExtCompany> findAll(int start, int end);

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
	public java.util.List<ExtCompany> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExtCompany> orderByComparator);

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
	public java.util.List<ExtCompany> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExtCompany> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ext companies from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ext companies.
	*
	* @return the number of ext companies
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}