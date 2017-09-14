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

import com.liferay.suez.user.synch.exception.NoSuchExtRoleException;
import com.liferay.suez.user.synch.model.ExtRole;

/**
 * The persistence interface for the ext role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.suez.user.synch.service.persistence.impl.ExtRolePersistenceImpl
 * @see ExtRoleUtil
 * @generated
 */
@ProviderType
public interface ExtRolePersistence extends BasePersistence<ExtRole> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtRoleUtil} to access the ext role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the ext roles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching ext roles
	*/
	public java.util.List<ExtRole> findByCompanyId(long companyId);

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
	public java.util.List<ExtRole> findByCompanyId(long companyId, int start,
		int end);

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
	public java.util.List<ExtRole> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator);

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
	public java.util.List<ExtRole> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ext role
	* @throws NoSuchExtRoleException if a matching ext role could not be found
	*/
	public ExtRole findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator)
		throws NoSuchExtRoleException;

	/**
	* Returns the first ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public ExtRole fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator);

	/**
	* Returns the last ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ext role
	* @throws NoSuchExtRoleException if a matching ext role could not be found
	*/
	public ExtRole findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator)
		throws NoSuchExtRoleException;

	/**
	* Returns the last ext role in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public ExtRole fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator);

	/**
	* Returns the ext roles before and after the current ext role in the ordered set where companyId = &#63;.
	*
	* @param roleId the primary key of the current ext role
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ext role
	* @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	*/
	public ExtRole[] findByCompanyId_PrevAndNext(long roleId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator)
		throws NoSuchExtRoleException;

	/**
	* Removes all the ext roles where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of ext roles where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching ext roles
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns the ext role where companyId = &#63; and name = &#63; or throws a {@link NoSuchExtRoleException} if it could not be found.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching ext role
	* @throws NoSuchExtRoleException if a matching ext role could not be found
	*/
	public ExtRole findByC_N(long companyId, java.lang.String name)
		throws NoSuchExtRoleException;

	/**
	* Returns the ext role where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public ExtRole fetchByC_N(long companyId, java.lang.String name);

	/**
	* Returns the ext role where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching ext role, or <code>null</code> if a matching ext role could not be found
	*/
	public ExtRole fetchByC_N(long companyId, java.lang.String name,
		boolean retrieveFromCache);

	/**
	* Removes the ext role where companyId = &#63; and name = &#63; from the database.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the ext role that was removed
	*/
	public ExtRole removeByC_N(long companyId, java.lang.String name)
		throws NoSuchExtRoleException;

	/**
	* Returns the number of ext roles where companyId = &#63; and name = &#63;.
	*
	* @param companyId the company ID
	* @param name the name
	* @return the number of matching ext roles
	*/
	public int countByC_N(long companyId, java.lang.String name);

	/**
	* Caches the ext role in the entity cache if it is enabled.
	*
	* @param extRole the ext role
	*/
	public void cacheResult(ExtRole extRole);

	/**
	* Caches the ext roles in the entity cache if it is enabled.
	*
	* @param extRoles the ext roles
	*/
	public void cacheResult(java.util.List<ExtRole> extRoles);

	/**
	* Creates a new ext role with the primary key. Does not add the ext role to the database.
	*
	* @param roleId the primary key for the new ext role
	* @return the new ext role
	*/
	public ExtRole create(long roleId);

	/**
	* Removes the ext role with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role that was removed
	* @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	*/
	public ExtRole remove(long roleId) throws NoSuchExtRoleException;

	public ExtRole updateImpl(ExtRole extRole);

	/**
	* Returns the ext role with the primary key or throws a {@link NoSuchExtRoleException} if it could not be found.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role
	* @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	*/
	public ExtRole findByPrimaryKey(long roleId) throws NoSuchExtRoleException;

	/**
	* Returns the ext role with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param roleId the primary key of the ext role
	* @return the ext role, or <code>null</code> if a ext role with the primary key could not be found
	*/
	public ExtRole fetchByPrimaryKey(long roleId);

	@Override
	public java.util.Map<java.io.Serializable, ExtRole> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the ext roles.
	*
	* @return the ext roles
	*/
	public java.util.List<ExtRole> findAll();

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
	public java.util.List<ExtRole> findAll(int start, int end);

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
	public java.util.List<ExtRole> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator);

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
	public java.util.List<ExtRole> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExtRole> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the ext roles from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of ext roles.
	*
	* @return the number of ext roles
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}