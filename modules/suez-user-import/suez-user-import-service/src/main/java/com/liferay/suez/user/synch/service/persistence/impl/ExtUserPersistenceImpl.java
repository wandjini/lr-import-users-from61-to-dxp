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

package com.liferay.suez.user.synch.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.suez.user.synch.exception.NoSuchExtUserException;
import com.liferay.suez.user.synch.model.ExtUser;
import com.liferay.suez.user.synch.model.impl.ExtUserImpl;
import com.liferay.suez.user.synch.model.impl.ExtUserModelImpl;
import com.liferay.suez.user.synch.service.persistence.ExtUserPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the ext user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtUserPersistence
 * @see com.liferay.suez.user.synch.service.persistence.ExtUserUtil
 * @generated
 */
@ProviderType
public class ExtUserPersistenceImpl extends BasePersistenceImpl<ExtUser>
	implements ExtUserPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExtUserUtil} to access the ext user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExtUserImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
			ExtUserModelImpl.FINDER_CACHE_ENABLED, ExtUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
			ExtUserModelImpl.FINDER_CACHE_ENABLED, ExtUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
			ExtUserModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ExtUserPersistenceImpl() {
		setModelClass(ExtUser.class);
	}

	/**
	 * Caches the ext user in the entity cache if it is enabled.
	 *
	 * @param extUser the ext user
	 */
	@Override
	public void cacheResult(ExtUser extUser) {
		entityCache.putResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
			ExtUserImpl.class, extUser.getPrimaryKey(), extUser);

		extUser.resetOriginalValues();
	}

	/**
	 * Caches the ext users in the entity cache if it is enabled.
	 *
	 * @param extUsers the ext users
	 */
	@Override
	public void cacheResult(List<ExtUser> extUsers) {
		for (ExtUser extUser : extUsers) {
			if (entityCache.getResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
						ExtUserImpl.class, extUser.getPrimaryKey()) == null) {
				cacheResult(extUser);
			}
			else {
				extUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ext users.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExtUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ext user.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExtUser extUser) {
		entityCache.removeResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
			ExtUserImpl.class, extUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ExtUser> extUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExtUser extUser : extUsers) {
			entityCache.removeResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
				ExtUserImpl.class, extUser.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ext user with the primary key. Does not add the ext user to the database.
	 *
	 * @param userId the primary key for the new ext user
	 * @return the new ext user
	 */
	@Override
	public ExtUser create(long userId) {
		ExtUser extUser = new ExtUserImpl();

		extUser.setNew(true);
		extUser.setPrimaryKey(userId);

		extUser.setCompanyId(companyProvider.getCompanyId());

		return extUser;
	}

	/**
	 * Removes the ext user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userId the primary key of the ext user
	 * @return the ext user that was removed
	 * @throws NoSuchExtUserException if a ext user with the primary key could not be found
	 */
	@Override
	public ExtUser remove(long userId) throws NoSuchExtUserException {
		return remove((Serializable)userId);
	}

	/**
	 * Removes the ext user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ext user
	 * @return the ext user that was removed
	 * @throws NoSuchExtUserException if a ext user with the primary key could not be found
	 */
	@Override
	public ExtUser remove(Serializable primaryKey)
		throws NoSuchExtUserException {
		Session session = null;

		try {
			session = openSession();

			ExtUser extUser = (ExtUser)session.get(ExtUserImpl.class, primaryKey);

			if (extUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExtUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(extUser);
		}
		catch (NoSuchExtUserException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ExtUser removeImpl(ExtUser extUser) {
		extUser = toUnwrappedModel(extUser);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(extUser)) {
				extUser = (ExtUser)session.get(ExtUserImpl.class,
						extUser.getPrimaryKeyObj());
			}

			if (extUser != null) {
				session.delete(extUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (extUser != null) {
			clearCache(extUser);
		}

		return extUser;
	}

	@Override
	public ExtUser updateImpl(ExtUser extUser) {
		extUser = toUnwrappedModel(extUser);

		boolean isNew = extUser.isNew();

		ExtUserModelImpl extUserModelImpl = (ExtUserModelImpl)extUser;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (extUser.getCreateDate() == null)) {
			if (serviceContext == null) {
				extUser.setCreateDate(now);
			}
			else {
				extUser.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!extUserModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				extUser.setModifiedDate(now);
			}
			else {
				extUser.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (extUser.isNew()) {
				session.save(extUser);

				extUser.setNew(false);
			}
			else {
				extUser = (ExtUser)session.merge(extUser);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
			ExtUserImpl.class, extUser.getPrimaryKey(), extUser, false);

		extUser.resetOriginalValues();

		return extUser;
	}

	protected ExtUser toUnwrappedModel(ExtUser extUser) {
		if (extUser instanceof ExtUserImpl) {
			return extUser;
		}

		ExtUserImpl extUserImpl = new ExtUserImpl();

		extUserImpl.setNew(extUser.isNew());
		extUserImpl.setPrimaryKey(extUser.getPrimaryKey());

		extUserImpl.setUserId(extUser.getUserId());
		extUserImpl.setCompanyId(extUser.getCompanyId());
		extUserImpl.setCreateDate(extUser.getCreateDate());
		extUserImpl.setModifiedDate(extUser.getModifiedDate());
		extUserImpl.setDefaultUser(extUser.isDefaultUser());
		extUserImpl.setContactId(extUser.getContactId());
		extUserImpl.setPassword(extUser.getPassword());
		extUserImpl.setPasswordEncrypted(extUser.isPasswordEncrypted());
		extUserImpl.setPasswordReset(extUser.isPasswordReset());
		extUserImpl.setPasswordModifiedDate(extUser.getPasswordModifiedDate());
		extUserImpl.setDigest(extUser.getDigest());
		extUserImpl.setReminderQueryQuestion(extUser.getReminderQueryQuestion());
		extUserImpl.setReminderQueryAnswer(extUser.getReminderQueryAnswer());
		extUserImpl.setGraceLoginCount(extUser.getGraceLoginCount());
		extUserImpl.setScreenName(extUser.getScreenName());
		extUserImpl.setEmailAddress(extUser.getEmailAddress());
		extUserImpl.setFacebookId(extUser.getFacebookId());
		extUserImpl.setOpenId(extUser.getOpenId());
		extUserImpl.setPortraitId(extUser.getPortraitId());
		extUserImpl.setLanguageId(extUser.getLanguageId());
		extUserImpl.setTimeZoneId(extUser.getTimeZoneId());
		extUserImpl.setGreeting(extUser.getGreeting());
		extUserImpl.setComments(extUser.getComments());
		extUserImpl.setFirstName(extUser.getFirstName());
		extUserImpl.setMiddleName(extUser.getMiddleName());
		extUserImpl.setLastName(extUser.getLastName());
		extUserImpl.setJobTitle(extUser.getJobTitle());
		extUserImpl.setLoginDate(extUser.getLoginDate());
		extUserImpl.setLoginIP(extUser.getLoginIP());
		extUserImpl.setLastLoginDate(extUser.getLastLoginDate());
		extUserImpl.setLastLoginIP(extUser.getLastLoginIP());
		extUserImpl.setLastFailedLoginDate(extUser.getLastFailedLoginDate());
		extUserImpl.setFailedLoginAttempts(extUser.getFailedLoginAttempts());
		extUserImpl.setLockout(extUser.isLockout());
		extUserImpl.setLockoutDate(extUser.getLockoutDate());
		extUserImpl.setAgreedToTermsOfUse(extUser.isAgreedToTermsOfUse());
		extUserImpl.setEmailAddressVerified(extUser.isEmailAddressVerified());
		extUserImpl.setStatus(extUser.getStatus());
		extUserImpl.setRoleId(extUser.getRoleId());

		return extUserImpl;
	}

	/**
	 * Returns the ext user with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext user
	 * @return the ext user
	 * @throws NoSuchExtUserException if a ext user with the primary key could not be found
	 */
	@Override
	public ExtUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExtUserException {
		ExtUser extUser = fetchByPrimaryKey(primaryKey);

		if (extUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExtUserException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return extUser;
	}

	/**
	 * Returns the ext user with the primary key or throws a {@link NoSuchExtUserException} if it could not be found.
	 *
	 * @param userId the primary key of the ext user
	 * @return the ext user
	 * @throws NoSuchExtUserException if a ext user with the primary key could not be found
	 */
	@Override
	public ExtUser findByPrimaryKey(long userId) throws NoSuchExtUserException {
		return findByPrimaryKey((Serializable)userId);
	}

	/**
	 * Returns the ext user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext user
	 * @return the ext user, or <code>null</code> if a ext user with the primary key could not be found
	 */
	@Override
	public ExtUser fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
				ExtUserImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExtUser extUser = (ExtUser)serializable;

		if (extUser == null) {
			Session session = null;

			try {
				session = openSession();

				extUser = (ExtUser)session.get(ExtUserImpl.class, primaryKey);

				if (extUser != null) {
					cacheResult(extUser);
				}
				else {
					entityCache.putResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
						ExtUserImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
					ExtUserImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return extUser;
	}

	/**
	 * Returns the ext user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userId the primary key of the ext user
	 * @return the ext user, or <code>null</code> if a ext user with the primary key could not be found
	 */
	@Override
	public ExtUser fetchByPrimaryKey(long userId) {
		return fetchByPrimaryKey((Serializable)userId);
	}

	@Override
	public Map<Serializable, ExtUser> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExtUser> map = new HashMap<Serializable, ExtUser>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExtUser extUser = fetchByPrimaryKey(primaryKey);

			if (extUser != null) {
				map.put(primaryKey, extUser);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
					ExtUserImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExtUser)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXTUSER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (ExtUser extUser : (List<ExtUser>)q.list()) {
				map.put(extUser.getPrimaryKeyObj(), extUser);

				cacheResult(extUser);

				uncachedPrimaryKeys.remove(extUser.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExtUserModelImpl.ENTITY_CACHE_ENABLED,
					ExtUserImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the ext users.
	 *
	 * @return the ext users
	 */
	@Override
	public List<ExtUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ext users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ext users
	 * @param end the upper bound of the range of ext users (not inclusive)
	 * @return the range of ext users
	 */
	@Override
	public List<ExtUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ext users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ext users
	 * @param end the upper bound of the range of ext users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ext users
	 */
	@Override
	public List<ExtUser> findAll(int start, int end,
		OrderByComparator<ExtUser> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ext users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ExtUserModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ext users
	 * @param end the upper bound of the range of ext users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ext users
	 */
	@Override
	public List<ExtUser> findAll(int start, int end,
		OrderByComparator<ExtUser> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ExtUser> list = null;

		if (retrieveFromCache) {
			list = (List<ExtUser>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXTUSER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTUSER;

				if (pagination) {
					sql = sql.concat(ExtUserModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExtUser>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExtUser>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ext users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExtUser extUser : findAll()) {
			remove(extUser);
		}
	}

	/**
	 * Returns the number of ext users.
	 *
	 * @return the number of ext users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXTUSER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExtUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ext user persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExtUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_EXTUSER = "SELECT extUser FROM ExtUser extUser";
	private static final String _SQL_SELECT_EXTUSER_WHERE_PKS_IN = "SELECT extUser FROM ExtUser extUser WHERE userId IN (";
	private static final String _SQL_COUNT_EXTUSER = "SELECT COUNT(extUser) FROM ExtUser extUser";
	private static final String _ORDER_BY_ENTITY_ALIAS = "extUser.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExtUser exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ExtUserPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"password"
			});
}