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

package com.liferay.suez.user.synch.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.suez.user.synch.model.ExtRole;
import com.liferay.suez.user.synch.service.ExtRoleLocalService;
import com.liferay.suez.user.synch.service.persistence.ExtCompanyPersistence;
import com.liferay.suez.user.synch.service.persistence.ExtRolePersistence;
import com.liferay.suez.user.synch.service.persistence.ExtUserFinder;
import com.liferay.suez.user.synch.service.persistence.ExtUserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the ext role local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.suez.user.synch.service.impl.ExtRoleLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.suez.user.synch.service.impl.ExtRoleLocalServiceImpl
 * @see com.liferay.suez.user.synch.service.ExtRoleLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class ExtRoleLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements ExtRoleLocalService, IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.suez.user.synch.service.ExtRoleLocalServiceUtil} to access the ext role local service.
	 */

	/**
	 * Adds the ext role to the database. Also notifies the appropriate model listeners.
	 *
	 * @param extRole the ext role
	 * @return the ext role that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExtRole addExtRole(ExtRole extRole) {
		extRole.setNew(true);

		return extRolePersistence.update(extRole);
	}

	/**
	 * Creates a new ext role with the primary key. Does not add the ext role to the database.
	 *
	 * @param roleId the primary key for the new ext role
	 * @return the new ext role
	 */
	@Override
	public ExtRole createExtRole(long roleId) {
		return extRolePersistence.create(roleId);
	}

	/**
	 * Deletes the ext role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the ext role
	 * @return the ext role that was removed
	 * @throws PortalException if a ext role with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExtRole deleteExtRole(long roleId) throws PortalException {
		return extRolePersistence.remove(roleId);
	}

	/**
	 * Deletes the ext role from the database. Also notifies the appropriate model listeners.
	 *
	 * @param extRole the ext role
	 * @return the ext role that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ExtRole deleteExtRole(ExtRole extRole) {
		return extRolePersistence.remove(extRole);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(ExtRole.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return extRolePersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return extRolePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return extRolePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return extRolePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return extRolePersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public ExtRole fetchExtRole(long roleId) {
		return extRolePersistence.fetchByPrimaryKey(roleId);
	}

	/**
	 * Returns the ext role with the primary key.
	 *
	 * @param roleId the primary key of the ext role
	 * @return the ext role
	 * @throws PortalException if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole getExtRole(long roleId) throws PortalException {
		return extRolePersistence.findByPrimaryKey(roleId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(extRoleLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExtRole.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("roleId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(extRoleLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ExtRole.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("roleId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(extRoleLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ExtRole.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("roleId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return extRoleLocalService.deleteExtRole((ExtRole)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return extRolePersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<ExtRole> getExtRoles(int start, int end) {
		return extRolePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of ext roles.
	 *
	 * @return the number of ext roles
	 */
	@Override
	public int getExtRolesCount() {
		return extRolePersistence.countAll();
	}

	/**
	 * Updates the ext role in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param extRole the ext role
	 * @return the ext role that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ExtRole updateExtRole(ExtRole extRole) {
		return extRolePersistence.update(extRole);
	}

	/**
	 * Returns the ext company local service.
	 *
	 * @return the ext company local service
	 */
	public com.liferay.suez.user.synch.service.ExtCompanyLocalService getExtCompanyLocalService() {
		return extCompanyLocalService;
	}

	/**
	 * Sets the ext company local service.
	 *
	 * @param extCompanyLocalService the ext company local service
	 */
	public void setExtCompanyLocalService(
		com.liferay.suez.user.synch.service.ExtCompanyLocalService extCompanyLocalService) {
		this.extCompanyLocalService = extCompanyLocalService;
	}

	/**
	 * Returns the ext company persistence.
	 *
	 * @return the ext company persistence
	 */
	public ExtCompanyPersistence getExtCompanyPersistence() {
		return extCompanyPersistence;
	}

	/**
	 * Sets the ext company persistence.
	 *
	 * @param extCompanyPersistence the ext company persistence
	 */
	public void setExtCompanyPersistence(
		ExtCompanyPersistence extCompanyPersistence) {
		this.extCompanyPersistence = extCompanyPersistence;
	}

	/**
	 * Returns the ext role local service.
	 *
	 * @return the ext role local service
	 */
	public ExtRoleLocalService getExtRoleLocalService() {
		return extRoleLocalService;
	}

	/**
	 * Sets the ext role local service.
	 *
	 * @param extRoleLocalService the ext role local service
	 */
	public void setExtRoleLocalService(ExtRoleLocalService extRoleLocalService) {
		this.extRoleLocalService = extRoleLocalService;
	}

	/**
	 * Returns the ext role persistence.
	 *
	 * @return the ext role persistence
	 */
	public ExtRolePersistence getExtRolePersistence() {
		return extRolePersistence;
	}

	/**
	 * Sets the ext role persistence.
	 *
	 * @param extRolePersistence the ext role persistence
	 */
	public void setExtRolePersistence(ExtRolePersistence extRolePersistence) {
		this.extRolePersistence = extRolePersistence;
	}

	/**
	 * Returns the ext user local service.
	 *
	 * @return the ext user local service
	 */
	public com.liferay.suez.user.synch.service.ExtUserLocalService getExtUserLocalService() {
		return extUserLocalService;
	}

	/**
	 * Sets the ext user local service.
	 *
	 * @param extUserLocalService the ext user local service
	 */
	public void setExtUserLocalService(
		com.liferay.suez.user.synch.service.ExtUserLocalService extUserLocalService) {
		this.extUserLocalService = extUserLocalService;
	}

	/**
	 * Returns the ext user persistence.
	 *
	 * @return the ext user persistence
	 */
	public ExtUserPersistence getExtUserPersistence() {
		return extUserPersistence;
	}

	/**
	 * Sets the ext user persistence.
	 *
	 * @param extUserPersistence the ext user persistence
	 */
	public void setExtUserPersistence(ExtUserPersistence extUserPersistence) {
		this.extUserPersistence = extUserPersistence;
	}

	/**
	 * Returns the ext user finder.
	 *
	 * @return the ext user finder
	 */
	public ExtUserFinder getExtUserFinder() {
		return extUserFinder;
	}

	/**
	 * Sets the ext user finder.
	 *
	 * @param extUserFinder the ext user finder
	 */
	public void setExtUserFinder(ExtUserFinder extUserFinder) {
		this.extUserFinder = extUserFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.liferay.suez.user.synch.model.ExtRole",
			extRoleLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.liferay.suez.user.synch.model.ExtRole");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ExtRoleLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ExtRole.class;
	}

	protected String getModelClassName() {
		return ExtRole.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = extRolePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.suez.user.synch.service.ExtCompanyLocalService.class)
	protected com.liferay.suez.user.synch.service.ExtCompanyLocalService extCompanyLocalService;
	@BeanReference(type = ExtCompanyPersistence.class)
	protected ExtCompanyPersistence extCompanyPersistence;
	@BeanReference(type = ExtRoleLocalService.class)
	protected ExtRoleLocalService extRoleLocalService;
	@BeanReference(type = ExtRolePersistence.class)
	protected ExtRolePersistence extRolePersistence;
	@BeanReference(type = com.liferay.suez.user.synch.service.ExtUserLocalService.class)
	protected com.liferay.suez.user.synch.service.ExtUserLocalService extUserLocalService;
	@BeanReference(type = ExtUserPersistence.class)
	protected ExtUserPersistence extUserPersistence;
	@BeanReference(type = ExtUserFinder.class)
	protected ExtUserFinder extUserFinder;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}