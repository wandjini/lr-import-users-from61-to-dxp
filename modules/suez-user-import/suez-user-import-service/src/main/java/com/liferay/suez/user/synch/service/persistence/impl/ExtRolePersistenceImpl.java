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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.suez.user.synch.exception.NoSuchExtRoleException;
import com.liferay.suez.user.synch.model.ExtRole;
import com.liferay.suez.user.synch.model.impl.ExtRoleImpl;
import com.liferay.suez.user.synch.model.impl.ExtRoleModelImpl;
import com.liferay.suez.user.synch.service.persistence.ExtRolePersistence;

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
 * The persistence implementation for the ext role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExtRolePersistence
 * @see com.liferay.suez.user.synch.service.persistence.ExtRoleUtil
 * @generated
 */
@ProviderType
public class ExtRolePersistenceImpl extends BasePersistenceImpl<ExtRole>
	implements ExtRolePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExtRoleUtil} to access the ext role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExtRoleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, ExtRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, ExtRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, ExtRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, ExtRoleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ExtRoleModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the ext roles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching ext roles
	 */
	@Override
	public List<ExtRole> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<ExtRole> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<ExtRole> findByCompanyId(long companyId, int start, int end,
		OrderByComparator<ExtRole> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ExtRole> findByCompanyId(long companyId, int start, int end,
		OrderByComparator<ExtRole> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<ExtRole> list = null;

		if (retrieveFromCache) {
			list = (List<ExtRole>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (ExtRole extRole : list) {
					if ((companyId != extRole.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EXTROLE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExtRoleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ExtRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExtRole>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first ext role in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ext role
	 * @throws NoSuchExtRoleException if a matching ext role could not be found
	 */
	@Override
	public ExtRole findByCompanyId_First(long companyId,
		OrderByComparator<ExtRole> orderByComparator)
		throws NoSuchExtRoleException {
		ExtRole extRole = fetchByCompanyId_First(companyId, orderByComparator);

		if (extRole != null) {
			return extRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExtRoleException(msg.toString());
	}

	/**
	 * Returns the first ext role in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ext role, or <code>null</code> if a matching ext role could not be found
	 */
	@Override
	public ExtRole fetchByCompanyId_First(long companyId,
		OrderByComparator<ExtRole> orderByComparator) {
		List<ExtRole> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ext role in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ext role
	 * @throws NoSuchExtRoleException if a matching ext role could not be found
	 */
	@Override
	public ExtRole findByCompanyId_Last(long companyId,
		OrderByComparator<ExtRole> orderByComparator)
		throws NoSuchExtRoleException {
		ExtRole extRole = fetchByCompanyId_Last(companyId, orderByComparator);

		if (extRole != null) {
			return extRole;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExtRoleException(msg.toString());
	}

	/**
	 * Returns the last ext role in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ext role, or <code>null</code> if a matching ext role could not be found
	 */
	@Override
	public ExtRole fetchByCompanyId_Last(long companyId,
		OrderByComparator<ExtRole> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<ExtRole> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ExtRole[] findByCompanyId_PrevAndNext(long roleId, long companyId,
		OrderByComparator<ExtRole> orderByComparator)
		throws NoSuchExtRoleException {
		ExtRole extRole = findByPrimaryKey(roleId);

		Session session = null;

		try {
			session = openSession();

			ExtRole[] array = new ExtRoleImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, extRole, companyId,
					orderByComparator, true);

			array[1] = extRole;

			array[2] = getByCompanyId_PrevAndNext(session, extRole, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExtRole getByCompanyId_PrevAndNext(Session session,
		ExtRole extRole, long companyId,
		OrderByComparator<ExtRole> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXTROLE_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ExtRoleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(extRole);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ExtRole> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ext roles where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (ExtRole extRole : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(extRole);
		}
	}

	/**
	 * Returns the number of ext roles where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching ext roles
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXTROLE_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "extRole.companyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_C_N = new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, ExtRoleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_N",
			new String[] { Long.class.getName(), String.class.getName() },
			ExtRoleModelImpl.COMPANYID_COLUMN_BITMASK |
			ExtRoleModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_N = new FinderPath(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_N",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the ext role where companyId = &#63; and name = &#63; or throws a {@link NoSuchExtRoleException} if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching ext role
	 * @throws NoSuchExtRoleException if a matching ext role could not be found
	 */
	@Override
	public ExtRole findByC_N(long companyId, String name)
		throws NoSuchExtRoleException {
		ExtRole extRole = fetchByC_N(companyId, name);

		if (extRole == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchExtRoleException(msg.toString());
		}

		return extRole;
	}

	/**
	 * Returns the ext role where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the matching ext role, or <code>null</code> if a matching ext role could not be found
	 */
	@Override
	public ExtRole fetchByC_N(long companyId, String name) {
		return fetchByC_N(companyId, name, true);
	}

	/**
	 * Returns the ext role where companyId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ext role, or <code>null</code> if a matching ext role could not be found
	 */
	@Override
	public ExtRole fetchByC_N(long companyId, String name,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { companyId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_N,
					finderArgs, this);
		}

		if (result instanceof ExtRole) {
			ExtRole extRole = (ExtRole)result;

			if ((companyId != extRole.getCompanyId()) ||
					!Objects.equals(name, extRole.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EXTROLE_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_C_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_C_N_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindName) {
					qPos.add(StringUtil.toLowerCase(name));
				}

				List<ExtRole> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_N, finderArgs,
						list);
				}
				else {
					ExtRole extRole = list.get(0);

					result = extRole;

					cacheResult(extRole);

					if ((extRole.getCompanyId() != companyId) ||
							(extRole.getName() == null) ||
							!extRole.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_N,
							finderArgs, extRole);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_N, finderArgs);

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
			return (ExtRole)result;
		}
	}

	/**
	 * Removes the ext role where companyId = &#63; and name = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the ext role that was removed
	 */
	@Override
	public ExtRole removeByC_N(long companyId, String name)
		throws NoSuchExtRoleException {
		ExtRole extRole = findByC_N(companyId, name);

		return remove(extRole);
	}

	/**
	 * Returns the number of ext roles where companyId = &#63; and name = &#63;.
	 *
	 * @param companyId the company ID
	 * @param name the name
	 * @return the number of matching ext roles
	 */
	@Override
	public int countByC_N(long companyId, String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_N;

		Object[] finderArgs = new Object[] { companyId, name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXTROLE_WHERE);

			query.append(_FINDER_COLUMN_C_N_COMPANYID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_C_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_C_N_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindName) {
					qPos.add(StringUtil.toLowerCase(name));
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

	private static final String _FINDER_COLUMN_C_N_COMPANYID_2 = "extRole.companyId = ? AND ";
	private static final String _FINDER_COLUMN_C_N_NAME_1 = "extRole.name IS NULL";
	private static final String _FINDER_COLUMN_C_N_NAME_2 = "lower(extRole.name) = ?";
	private static final String _FINDER_COLUMN_C_N_NAME_3 = "(extRole.name IS NULL OR extRole.name = '')";

	public ExtRolePersistenceImpl() {
		setModelClass(ExtRole.class);
	}

	/**
	 * Caches the ext role in the entity cache if it is enabled.
	 *
	 * @param extRole the ext role
	 */
	@Override
	public void cacheResult(ExtRole extRole) {
		entityCache.putResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleImpl.class, extRole.getPrimaryKey(), extRole);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_N,
			new Object[] { extRole.getCompanyId(), extRole.getName() }, extRole);

		extRole.resetOriginalValues();
	}

	/**
	 * Caches the ext roles in the entity cache if it is enabled.
	 *
	 * @param extRoles the ext roles
	 */
	@Override
	public void cacheResult(List<ExtRole> extRoles) {
		for (ExtRole extRole : extRoles) {
			if (entityCache.getResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
						ExtRoleImpl.class, extRole.getPrimaryKey()) == null) {
				cacheResult(extRole);
			}
			else {
				extRole.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ext roles.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExtRoleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ext role.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExtRole extRole) {
		entityCache.removeResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleImpl.class, extRole.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ExtRoleModelImpl)extRole);
	}

	@Override
	public void clearCache(List<ExtRole> extRoles) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ExtRole extRole : extRoles) {
			entityCache.removeResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
				ExtRoleImpl.class, extRole.getPrimaryKey());

			clearUniqueFindersCache((ExtRoleModelImpl)extRole);
		}
	}

	protected void cacheUniqueFindersCache(ExtRoleModelImpl extRoleModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					extRoleModelImpl.getCompanyId(), extRoleModelImpl.getName()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_C_N, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_C_N, args,
				extRoleModelImpl);
		}
		else {
			if ((extRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_C_N.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						extRoleModelImpl.getCompanyId(),
						extRoleModelImpl.getName()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_C_N, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_C_N, args,
					extRoleModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(ExtRoleModelImpl extRoleModelImpl) {
		Object[] args = new Object[] {
				extRoleModelImpl.getCompanyId(), extRoleModelImpl.getName()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_C_N, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_C_N, args);

		if ((extRoleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_N.getColumnBitmask()) != 0) {
			args = new Object[] {
					extRoleModelImpl.getOriginalCompanyId(),
					extRoleModelImpl.getOriginalName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_N, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_N, args);
		}
	}

	/**
	 * Creates a new ext role with the primary key. Does not add the ext role to the database.
	 *
	 * @param roleId the primary key for the new ext role
	 * @return the new ext role
	 */
	@Override
	public ExtRole create(long roleId) {
		ExtRole extRole = new ExtRoleImpl();

		extRole.setNew(true);
		extRole.setPrimaryKey(roleId);

		extRole.setCompanyId(companyProvider.getCompanyId());

		return extRole;
	}

	/**
	 * Removes the ext role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roleId the primary key of the ext role
	 * @return the ext role that was removed
	 * @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole remove(long roleId) throws NoSuchExtRoleException {
		return remove((Serializable)roleId);
	}

	/**
	 * Removes the ext role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ext role
	 * @return the ext role that was removed
	 * @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole remove(Serializable primaryKey)
		throws NoSuchExtRoleException {
		Session session = null;

		try {
			session = openSession();

			ExtRole extRole = (ExtRole)session.get(ExtRoleImpl.class, primaryKey);

			if (extRole == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExtRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(extRole);
		}
		catch (NoSuchExtRoleException nsee) {
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
	protected ExtRole removeImpl(ExtRole extRole) {
		extRole = toUnwrappedModel(extRole);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(extRole)) {
				extRole = (ExtRole)session.get(ExtRoleImpl.class,
						extRole.getPrimaryKeyObj());
			}

			if (extRole != null) {
				session.delete(extRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (extRole != null) {
			clearCache(extRole);
		}

		return extRole;
	}

	@Override
	public ExtRole updateImpl(ExtRole extRole) {
		extRole = toUnwrappedModel(extRole);

		boolean isNew = extRole.isNew();

		ExtRoleModelImpl extRoleModelImpl = (ExtRoleModelImpl)extRole;

		Session session = null;

		try {
			session = openSession();

			if (extRole.isNew()) {
				session.save(extRole);

				extRole.setNew(false);
			}
			else {
				extRole = (ExtRole)session.merge(extRole);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExtRoleModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((extRoleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						extRoleModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { extRoleModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		entityCache.putResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
			ExtRoleImpl.class, extRole.getPrimaryKey(), extRole, false);

		clearUniqueFindersCache(extRoleModelImpl);
		cacheUniqueFindersCache(extRoleModelImpl, isNew);

		extRole.resetOriginalValues();

		return extRole;
	}

	protected ExtRole toUnwrappedModel(ExtRole extRole) {
		if (extRole instanceof ExtRoleImpl) {
			return extRole;
		}

		ExtRoleImpl extRoleImpl = new ExtRoleImpl();

		extRoleImpl.setNew(extRole.isNew());
		extRoleImpl.setPrimaryKey(extRole.getPrimaryKey());

		extRoleImpl.setRoleId(extRole.getRoleId());
		extRoleImpl.setCompanyId(extRole.getCompanyId());
		extRoleImpl.setClassNameId(extRole.getClassNameId());
		extRoleImpl.setClassPK(extRole.getClassPK());
		extRoleImpl.setName(extRole.getName());
		extRoleImpl.setTitle(extRole.getTitle());
		extRoleImpl.setDescription(extRole.getDescription());
		extRoleImpl.setType(extRole.getType());
		extRoleImpl.setSubtype(extRole.getSubtype());

		return extRoleImpl;
	}

	/**
	 * Returns the ext role with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext role
	 * @return the ext role
	 * @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExtRoleException {
		ExtRole extRole = fetchByPrimaryKey(primaryKey);

		if (extRole == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExtRoleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return extRole;
	}

	/**
	 * Returns the ext role with the primary key or throws a {@link NoSuchExtRoleException} if it could not be found.
	 *
	 * @param roleId the primary key of the ext role
	 * @return the ext role
	 * @throws NoSuchExtRoleException if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole findByPrimaryKey(long roleId) throws NoSuchExtRoleException {
		return findByPrimaryKey((Serializable)roleId);
	}

	/**
	 * Returns the ext role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ext role
	 * @return the ext role, or <code>null</code> if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
				ExtRoleImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ExtRole extRole = (ExtRole)serializable;

		if (extRole == null) {
			Session session = null;

			try {
				session = openSession();

				extRole = (ExtRole)session.get(ExtRoleImpl.class, primaryKey);

				if (extRole != null) {
					cacheResult(extRole);
				}
				else {
					entityCache.putResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
						ExtRoleImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
					ExtRoleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return extRole;
	}

	/**
	 * Returns the ext role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roleId the primary key of the ext role
	 * @return the ext role, or <code>null</code> if a ext role with the primary key could not be found
	 */
	@Override
	public ExtRole fetchByPrimaryKey(long roleId) {
		return fetchByPrimaryKey((Serializable)roleId);
	}

	@Override
	public Map<Serializable, ExtRole> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ExtRole> map = new HashMap<Serializable, ExtRole>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ExtRole extRole = fetchByPrimaryKey(primaryKey);

			if (extRole != null) {
				map.put(primaryKey, extRole);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
					ExtRoleImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ExtRole)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EXTROLE_WHERE_PKS_IN);

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

			for (ExtRole extRole : (List<ExtRole>)q.list()) {
				map.put(extRole.getPrimaryKeyObj(), extRole);

				cacheResult(extRole);

				uncachedPrimaryKeys.remove(extRole.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ExtRoleModelImpl.ENTITY_CACHE_ENABLED,
					ExtRoleImpl.class, primaryKey, nullModel);
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
	 * Returns all the ext roles.
	 *
	 * @return the ext roles
	 */
	@Override
	public List<ExtRole> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ExtRole> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ExtRole> findAll(int start, int end,
		OrderByComparator<ExtRole> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ExtRole> findAll(int start, int end,
		OrderByComparator<ExtRole> orderByComparator, boolean retrieveFromCache) {
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

		List<ExtRole> list = null;

		if (retrieveFromCache) {
			list = (List<ExtRole>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXTROLE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXTROLE;

				if (pagination) {
					sql = sql.concat(ExtRoleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ExtRole>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ExtRole>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the ext roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExtRole extRole : findAll()) {
			remove(extRole);
		}
	}

	/**
	 * Returns the number of ext roles.
	 *
	 * @return the number of ext roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXTROLE);

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
		return ExtRoleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ext role persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ExtRoleImpl.class.getName());
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
	private static final String _SQL_SELECT_EXTROLE = "SELECT extRole FROM ExtRole extRole";
	private static final String _SQL_SELECT_EXTROLE_WHERE_PKS_IN = "SELECT extRole FROM ExtRole extRole WHERE roleId IN (";
	private static final String _SQL_SELECT_EXTROLE_WHERE = "SELECT extRole FROM ExtRole extRole WHERE ";
	private static final String _SQL_COUNT_EXTROLE = "SELECT COUNT(extRole) FROM ExtRole extRole";
	private static final String _SQL_COUNT_EXTROLE_WHERE = "SELECT COUNT(extRole) FROM ExtRole extRole WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "extRole.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ExtRole exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ExtRole exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(ExtRolePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}