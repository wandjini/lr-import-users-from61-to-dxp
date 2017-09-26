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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.suez.user.synch.exception.NoSuchExtCompanyException;
import com.liferay.suez.user.synch.model.ExtCompany;
import com.liferay.suez.user.synch.model.impl.ExtCompanyImpl;
import com.liferay.suez.user.synch.model.impl.ExtCompanyModelImpl;
import com.liferay.suez.user.synch.service.persistence.ExtCompanyPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the ext company service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtCompanyPersistence
 * @see com.liferay.suez.user.synch.service.persistence.ExtCompanyUtil
 * @generated
 */
@ProviderType
public class ExtCompanyPersistenceImpl extends BasePersistenceImpl<ExtCompany>
	implements ExtCompanyPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExtCompanyUtil} to access the ext company persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExtCompanyImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyModelImpl.FINDER_CACHE_ENABLED, ExtCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyModelImpl.FINDER_CACHE_ENABLED, ExtCompanyImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_WEBID = new FinderPath(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyModelImpl.FINDER_CACHE_ENABLED, ExtCompanyImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByWebId",
			new String[] { String.class.getName() },
			ExtCompanyModelImpl.WEBID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WEBID = new FinderPath(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWebId",
			new String[] { String.class.getName() });

	/**
	 * Returns the ext company where webId = &#63; or throws a {@link NoSuchExtCompanyException} if it could not be found.
	 *
	 * @param webId the web ID
	 * @return the matching ext company
	 * @throws NoSuchExtCompanyException if a matching ext company could not be found
	 */
	@Override
	public ExtCompany findByWebId(String webId)
		throws NoSuchExtCompanyException {
		ExtCompany extCompany = fetchByWebId(webId);

		if (extCompany == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("webId=");
			msg.append(webId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchExtCompanyException(msg.toString());
		}

		return extCompany;
	}

	/**
	 * Returns the ext company where webId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param webId the web ID
	 * @return the matching ext company, or <code>null</code> if a matching ext company could not be found
	 */
	@Override
	public ExtCompany fetchByWebId(String webId) {
		return fetchByWebId(webId, true);
	}

	/**
	 * Returns the ext company where webId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param webId the web ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ext company, or <code>null</code> if a matching ext company could not be found
	 */
	@Override
	public ExtCompany fetchByWebId(String webId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { webId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_WEBID,
					finderArgs, this);
		}

		if (result instanceof ExtCompany) {
			ExtCompany extCompany = (ExtCompany)result;

			if (!Objects.equals(webId, extCompany.getWebId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EXTCOMPANY_WHERE);

			boolean bindWebId = false;

			if (webId == null) {
				query.append(_FINDER_COLUMN_WEBID_WEBID_1);
			}
			else if (webId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WEBID_WEBID_3);
			}
			else {
				bindWebId = true;

				query.append(_FINDER_COLUMN_WEBID_WEBID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWebId) {
					qPos.add(webId);
				}

				List<ExtCompany> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_WEBID,
						finderArgs, list);
				}
				else {
					ExtCompany extCompany = list.get(0);

					result = extCompany;

					cacheResult(extCompany);

					if ((extCompany.getWebId() == null) ||
							!extCompany.getWebId().equals(webId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_WEBID,
							finderArgs, extCompany);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_WEBID, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ExtCompany)result;
		}
	}

	/**
	 * Removes the ext company where webId = &#63; from the database.
	 *
	 * @param webId the web ID
	 * @return the ext company that was removed
	 */
	@Override
	public ExtCompany removeByWebId(String webId)
		throws NoSuchExtCompanyException {
		ExtCompany extCompany = findByWebId(webId);

		return remove(extCompany);
	}

	/**
	 * Returns the number of ext companies where webId = &#63;.
	 *
	 * @param webId the web ID
	 * @return the number of matching ext companies
	 */
	@Override
	public int countByWebId(String webId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WEBID;

		Object[] finderArgs = new Object[] { webId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXTCOMPANY_WHERE);

			boolean bindWebId = false;

			if (webId == null) {
				query.append(_FINDER_COLUMN_WEBID_WEBID_1);
			}
			else if (webId.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_WEBID_WEBID_3);
			}
			else {
				bindWebId = true;

				query.append(_FINDER_COLUMN_WEBID_WEBID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindWebId) {
					qPos.add(webId);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_WEBID_WEBID_1 = "extCompany.webId IS NULL";
	private static final String _FINDER_COLUMN_WEBID_WEBID_2 = "extCompany.webId = ?";
	private static final String _FINDER_COLUMN_WEBID_WEBID_3 = "(extCompany.webId IS NULL OR extCompany.webId = '')";

	public ExtCompanyPersistenceImpl() {
		setModelClass(ExtCompany.class);
	}

	/**
	 * Caches the ext company in the entity cache if it is enabled.
	 *
	 * @param extCompany the ext company
	 */
	@Override
	public void cacheResult(ExtCompany extCompany) {
		entityCache.putResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyImpl.class, extCompany.getPrimaryKey(), extCompany);

		finderCache.putResult(FINDER_PATH_FETCH_BY_WEBID,
			new Object[] { extCompany.getWebId() }, extCompany);

		extCompany.resetOriginalValues();
	}

	/**
	 * Caches the ext companies in the entity cache if it is enabled.
	 *
	 * @param extCompanies the ext companies
	 */
	@Override
	public void cacheResult(List<ExtCompany> extCompanies) {
		for (ExtCompany extCompany : extCompanies) {
			if (entityCache.getResult(
						ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
						ExtCompanyImpl.class, extCompany.getPrimaryKey()) == null) {
				cacheResult(extCompany);
			}
			else {
				extCompany.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ext companies.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExtCompanyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ext company.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExtCompany extCompany) {
		entityCache.removeResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyImpl.class, extCompany.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ExtCompanyModelImpl)extCompany);
	}

	@Override
	public void clearCache(List<ExtCompany> extCompanies) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExtCompany extCompany : extCompanies) {
			entityCache.removeResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
				ExtCompanyImpl.class, extCompany.getPrimaryKey());

			clearUniqueFindersCache((ExtCompanyModelImpl)extCompany);
		}
	}

	protected void cacheUniqueFindersCache(
		ExtCompanyModelImpl extCompanyModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] { extCompanyModelImpl.getWebId() };

			finderCache.putResult(FINDER_PATH_COUNT_BY_WEBID, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_WEBID, args,
				extCompanyModelImpl);
		}
		else {
			if ((extCompanyModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_WEBID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { extCompanyModelImpl.getWebId() };

				finderCache.putResult(FINDER_PATH_COUNT_BY_WEBID, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_WEBID, args,
					extCompanyModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		ExtCompanyModelImpl extCompanyModelImpl) {
		Object[] args = new Object[] { extCompanyModelImpl.getWebId() };

		finderCache.removeResult(FINDER_PATH_COUNT_BY_WEBID, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_WEBID, args);

		if ((extCompanyModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_WEBID.getColumnBitmask()) != 0) {
			args = new Object[] { extCompanyModelImpl.getOriginalWebId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_WEBID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_WEBID, args);
		}
	}

	/**
	 * Creates a new ext company with the primary key. Does not add the ext company to the database.
	 *
	 * @param companyId the primary key for the new ext company
	 * @return the new ext company
	 */
	@Override
	public ExtCompany create(long companyId) {
		ExtCompany extCompany = new ExtCompanyImpl();

		extCompany.setNew(true);
		extCompany.setPrimaryKey(companyId);

		extCompany.setCompanyId(companyProvider.getCompanyId());

		return extCompany;
	}

	/**
	 * Removes the ext company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyId the primary key of the ext company
	 * @return the ext company that was removed
	 * @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	 */
	@Override
	public ExtCompany remove(long companyId) throws NoSuchExtCompanyException {
		return remove((Serializable)companyId);
	}

	/**
	 * Removes the ext company with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ext company
	 * @return the ext company that was removed
	 * @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	 */
	@Override
	public ExtCompany remove(Serializable primaryKey)
		throws NoSuchExtCompanyException {
		Session session = null;

		try {
			session = openSession();

			ExtCompany extCompany = (ExtCompany)session.get(ExtCompanyImpl.class,
					primaryKey);

			if (extCompany == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExtCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(extCompany);
		}
		catch (NoSuchExtCompanyException nsee) {
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
	protected ExtCompany removeImpl(ExtCompany extCompany) {
		extCompany = toUnwrappedModel(extCompany);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(extCompany)) {
				extCompany = (ExtCompany)session.get(ExtCompanyImpl.class,
						extCompany.getPrimaryKeyObj());
			}

			if (extCompany != null) {
				session.delete(extCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (extCompany != null) {
			clearCache(extCompany);
		}

		return extCompany;
	}

	@Override
	public ExtCompany updateImpl(ExtCompany extCompany) {
		extCompany = toUnwrappedModel(extCompany);

		boolean isNew = extCompany.isNew();

		ExtCompanyModelImpl extCompanyModelImpl = (ExtCompanyModelImpl)extCompany;

		Session session = null;

		try {
			session = openSession();

			if (extCompany.isNew()) {
				session.save(extCompany);

				extCompany.setNew(false);
			}
			else {
				extCompany = (ExtCompany)session.merge(extCompany);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExtCompanyModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		entityCache.putResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
			ExtCompanyImpl.class, extCompany.getPrimaryKey(), extCompany, false);

		clearUniqueFindersCache(extCompanyModelImpl);
		cacheUniqueFindersCache(extCompanyModelImpl, isNew);

		extCompany.resetOriginalValues();

		return extCompany;
	}

	protected ExtCompany toUnwrappedModel(ExtCompany extCompany) {
		if (extCompany instanceof ExtCompanyImpl) {
			return extCompany;
		}

		ExtCompanyImpl extCompanyImpl = new ExtCompanyImpl();

		extCompanyImpl.setNew(extCompany.isNew());
		extCompanyImpl.setPrimaryKey(extCompany.getPrimaryKey());

		extCompanyImpl.setCompanyId(extCompany.getCompanyId());
		extCompanyImpl.setAccountId(extCompany.getAccountId());
		extCompanyImpl.setWebId(extCompany.getWebId());
		extCompanyImpl.setKey(extCompany.getKey());
		extCompanyImpl.setMx(extCompany.getMx());
		extCompanyImpl.setHomeURL(extCompany.getHomeURL());
		extCompanyImpl.setLogoId(extCompany.getLogoId());
		extCompanyImpl.setSystem(extCompany.isSystem());
		extCompanyImpl.setMaxUsers(extCompany.getMaxUsers());

		return extCompanyImpl;
	}

	/**
	 * Returns the ext company with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext company
	 * @return the ext company
	 * @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	 */
	@Override
	public ExtCompany findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExtCompanyException {
		ExtCompany extCompany = fetchByPrimaryKey(primaryKey);

		if (extCompany == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExtCompanyException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return extCompany;
	}

	/**
	 * Returns the ext company with the primary key or throws a {@link NoSuchExtCompanyException} if it could not be found.
	 *
	 * @param companyId the primary key of the ext company
	 * @return the ext company
	 * @throws NoSuchExtCompanyException if a ext company with the primary key could not be found
	 */
	@Override
	public ExtCompany findByPrimaryKey(long companyId)
		throws NoSuchExtCompanyException {
		return findByPrimaryKey((Serializable)companyId);
	}

	/**
	 * Returns the ext company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext company
	 * @return the ext company, or <code>null</code> if a ext company with the primary key could not be found
	 */
	@Override
	public ExtCompany fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
				ExtCompanyImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExtCompany extCompany = (ExtCompany)serializable;

		if (extCompany == null) {
			Session session = null;

			try {
				session = openSession();

				extCompany = (ExtCompany)session.get(ExtCompanyImpl.class,
						primaryKey);

				if (extCompany != null) {
					cacheResult(extCompany);
				}
				else {
					entityCache.putResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
						ExtCompanyImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
					ExtCompanyImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return extCompany;
	}

	/**
	 * Returns the ext company with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyId the primary key of the ext company
	 * @return the ext company, or <code>null</code> if a ext company with the primary key could not be found
	 */
	@Override
	public ExtCompany fetchByPrimaryKey(long companyId) {
		return fetchByPrimaryKey((Serializable)companyId);
	}

	@Override
	public Map<Serializable, ExtCompany> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExtCompany> map = new HashMap<Serializable, ExtCompany>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExtCompany extCompany = fetchByPrimaryKey(primaryKey);

			if (extCompany != null) {
				map.put(primaryKey, extCompany);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
					ExtCompanyImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExtCompany)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXTCOMPANY_WHERE_PKS_IN);

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

			for (ExtCompany extCompany : (List<ExtCompany>)q.list()) {
				map.put(extCompany.getPrimaryKeyObj(), extCompany);

				cacheResult(extCompany);

				uncachedPrimaryKeys.remove(extCompany.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExtCompanyModelImpl.ENTITY_CACHE_ENABLED,
					ExtCompanyImpl.class, primaryKey, nullModel);
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
	 * Returns all the ext companies.
	 *
	 * @return the ext companies
	 */
	@Override
	public List<ExtCompany> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ExtCompany> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ExtCompany> findAll(int start, int end,
		OrderByComparator<ExtCompany> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ExtCompany> findAll(int start, int end,
		OrderByComparator<ExtCompany> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ExtCompany> list = null;

		if (retrieveFromCache) {
			list = (List<ExtCompany>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXTCOMPANY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTCOMPANY;

				if (pagination) {
					sql = sql.concat(ExtCompanyModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExtCompany>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExtCompany>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ext companies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExtCompany extCompany : findAll()) {
			remove(extCompany);
		}
	}

	/**
	 * Returns the number of ext companies.
	 *
	 * @return the number of ext companies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXTCOMPANY);

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
		return ExtCompanyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ext company persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExtCompanyImpl.class.getName());
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
	private static final String _SQL_SELECT_EXTCOMPANY = "SELECT extCompany FROM ExtCompany extCompany";
	private static final String _SQL_SELECT_EXTCOMPANY_WHERE_PKS_IN = "SELECT extCompany FROM ExtCompany extCompany WHERE companyId IN (";
	private static final String _SQL_SELECT_EXTCOMPANY_WHERE = "SELECT extCompany FROM ExtCompany extCompany WHERE ";
	private static final String _SQL_COUNT_EXTCOMPANY = "SELECT COUNT(extCompany) FROM ExtCompany extCompany";
	private static final String _SQL_COUNT_EXTCOMPANY_WHERE = "SELECT COUNT(extCompany) FROM ExtCompany extCompany WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "extCompany.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExtCompany exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExtCompany exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExtCompanyPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
}