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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.suez.user.synch.model.ExtUser;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for ExtUser. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExtUserLocalServiceUtil
 * @see com.liferay.suez.user.synch.service.base.ExtUserLocalServiceBaseImpl
 * @see com.liferay.suez.user.synch.service.impl.ExtUserLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface ExtUserLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExtUserLocalServiceUtil} to access the ext user local service. Add custom service methods to {@link com.liferay.suez.user.synch.service.impl.ExtUserLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the ext user to the database. Also notifies the appropriate model listeners.
	*
	* @param extUser the ext user
	* @return the ext user that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ExtUser addExtUser(ExtUser extUser);

	/**
	* Creates a new ext user with the primary key. Does not add the ext user to the database.
	*
	* @param userId the primary key for the new ext user
	* @return the new ext user
	*/
	public ExtUser createExtUser(long userId);

	/**
	* Deletes the ext user from the database. Also notifies the appropriate model listeners.
	*
	* @param extUser the ext user
	* @return the ext user that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public ExtUser deleteExtUser(ExtUser extUser);

	/**
	* Deletes the ext user with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param userId the primary key of the ext user
	* @return the ext user that was removed
	* @throws PortalException if a ext user with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public ExtUser deleteExtUser(long userId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExtUser fetchExtUser(long userId);

	/**
	* Returns the ext user with the primary key.
	*
	* @param userId the primary key of the ext user
	* @return the ext user
	* @throws PortalException if a ext user with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExtUser getExtUser(long userId) throws PortalException;

	/**
	* Updates the ext user in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param extUser the ext user
	* @return the ext user that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public ExtUser updateExtUser(ExtUser extUser);

	/**
	* This method return the total number of external users
	*/
	public int countExtUsers();

	/**
	* This method returns the number of external users filtered by company and role
	*/
	public int countExtUsersByCompanyAndRole(long companyId, long roleId,
		Date startDate, Date endDate);

	/**
	* This method returns the number of external users filtered by company and list of roles
	*/
	public int countExtUsersByCompanyAndRoleIds(long companyId,
		java.lang.Long[] roleIds, Date startDate, Date endDate);

	/**
	* Returns the number of ext users.
	*
	* @return the number of ext users
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getExtUsersCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* <p> This method return users</p>
	*
	* @return -> List of external users
	*/
	public List<ExtUser> findExtUsers(int start, int end);

	/**
	* This method returns the list of external users filtered by company and role
	*/
	public List<ExtUser> findExtUsersByCompanyAndRole(long companyId,
		long roleId, Date startDate, Date endDate, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ExtUser> getExtUsers(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}