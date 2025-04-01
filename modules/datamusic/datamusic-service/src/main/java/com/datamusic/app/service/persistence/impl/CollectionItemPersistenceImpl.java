/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.impl;

import com.datamusic.app.exception.NoSuchCollectionItemException;
import com.datamusic.app.model.CollectionItem;
import com.datamusic.app.model.CollectionItemTable;
import com.datamusic.app.model.impl.CollectionItemImpl;
import com.datamusic.app.model.impl.CollectionItemModelImpl;
import com.datamusic.app.service.persistence.CollectionItemPersistence;
import com.datamusic.app.service.persistence.CollectionItemUtil;
import com.datamusic.app.service.persistence.impl.constants.datamusicPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the collection item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @generated
 */
@Component(service = CollectionItemPersistence.class)
public class CollectionItemPersistenceImpl
	extends BasePersistenceImpl<CollectionItem>
	implements CollectionItemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CollectionItemUtil</code> to access the collection item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CollectionItemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the collection items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @return the range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection items where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<CollectionItem> list = null;

		if (useFinderCache) {
			list = (List<CollectionItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CollectionItem collectionItem : list) {
					if (!uuid.equals(collectionItem.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_COLLECTIONITEM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CollectionItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<CollectionItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	@Override
	public CollectionItem findByUuid_First(
			String uuid, OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByUuid_First(
			uuid, orderByComparator);

		if (collectionItem != null) {
			return collectionItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCollectionItemException(sb.toString());
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public CollectionItem fetchByUuid_First(
		String uuid, OrderByComparator<CollectionItem> orderByComparator) {

		List<CollectionItem> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	@Override
	public CollectionItem findByUuid_Last(
			String uuid, OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByUuid_Last(
			uuid, orderByComparator);

		if (collectionItem != null) {
			return collectionItem;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchCollectionItemException(sb.toString());
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public CollectionItem fetchByUuid_Last(
		String uuid, OrderByComparator<CollectionItem> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CollectionItem> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the collection items before and after the current collection item in the ordered set where uuid = &#63;.
	 *
	 * @param collectionItemId the primary key of the current collection item
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem[] findByUuid_PrevAndNext(
			long collectionItemId, String uuid,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		uuid = Objects.toString(uuid, "");

		CollectionItem collectionItem = findByPrimaryKey(collectionItemId);

		Session session = null;

		try {
			session = openSession();

			CollectionItem[] array = new CollectionItemImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, collectionItem, uuid, orderByComparator, true);

			array[1] = collectionItem;

			array[2] = getByUuid_PrevAndNext(
				session, collectionItem, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CollectionItem getByUuid_PrevAndNext(
		Session session, CollectionItem collectionItem, String uuid,
		OrderByComparator<CollectionItem> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COLLECTIONITEM_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CollectionItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						collectionItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CollectionItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the collection items where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CollectionItem collectionItem :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(collectionItem);
		}
	}

	/**
	 * Returns the number of collection items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching collection items
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COLLECTIONITEM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"collectionItem.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(collectionItem.uuid IS NULL OR collectionItem.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @return the range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<CollectionItem> list = null;

		if (useFinderCache) {
			list = (List<CollectionItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CollectionItem collectionItem : list) {
					if (!uuid.equals(collectionItem.getUuid()) ||
						(companyId != collectionItem.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_COLLECTIONITEM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CollectionItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<CollectionItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	@Override
	public CollectionItem findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (collectionItem != null) {
			return collectionItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCollectionItemException(sb.toString());
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public CollectionItem fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CollectionItem> orderByComparator) {

		List<CollectionItem> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	@Override
	public CollectionItem findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (collectionItem != null) {
			return collectionItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchCollectionItemException(sb.toString());
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public CollectionItem fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CollectionItem> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CollectionItem> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the collection items before and after the current collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param collectionItemId the primary key of the current collection item
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem[] findByUuid_C_PrevAndNext(
			long collectionItemId, String uuid, long companyId,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		uuid = Objects.toString(uuid, "");

		CollectionItem collectionItem = findByPrimaryKey(collectionItemId);

		Session session = null;

		try {
			session = openSession();

			CollectionItem[] array = new CollectionItemImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, collectionItem, uuid, companyId, orderByComparator,
				true);

			array[1] = collectionItem;

			array[2] = getByUuid_C_PrevAndNext(
				session, collectionItem, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CollectionItem getByUuid_C_PrevAndNext(
		Session session, CollectionItem collectionItem, String uuid,
		long companyId, OrderByComparator<CollectionItem> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLLECTIONITEM_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CollectionItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						collectionItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CollectionItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the collection items where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CollectionItem collectionItem :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(collectionItem);
		}
	}

	/**
	 * Returns the number of collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching collection items
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLLECTIONITEM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"collectionItem.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(collectionItem.uuid IS NULL OR collectionItem.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"collectionItem.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByU_R;
	private FinderPath _finderPathWithoutPaginationFindByU_R;
	private FinderPath _finderPathCountByU_R;

	/**
	 * Returns all the collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @return the matching collection items
	 */
	@Override
	public List<CollectionItem> findByU_R(long userAccountId, Long rating) {
		return findByU_R(
			userAccountId, rating, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @return the range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByU_R(
		long userAccountId, Long rating, int start, int end) {

		return findByU_R(userAccountId, rating, start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByU_R(
		long userAccountId, Long rating, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return findByU_R(
			userAccountId, rating, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching collection items
	 */
	@Override
	public List<CollectionItem> findByU_R(
		long userAccountId, Long rating, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_R;
				finderArgs = new Object[] {userAccountId, rating};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_R;
			finderArgs = new Object[] {
				userAccountId, rating, start, end, orderByComparator
			};
		}

		List<CollectionItem> list = null;

		if (useFinderCache) {
			list = (List<CollectionItem>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CollectionItem collectionItem : list) {
					if ((userAccountId != collectionItem.getUserAccountId()) ||
						!Objects.equals(rating, collectionItem.getRating())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_COLLECTIONITEM_WHERE);

			sb.append(_FINDER_COLUMN_U_R_USERACCOUNTID_2);

			sb.append(_FINDER_COLUMN_U_R_RATING_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CollectionItemModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userAccountId);

				queryPos.add(rating.longValue());

				list = (List<CollectionItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	@Override
	public CollectionItem findByU_R_First(
			long userAccountId, Long rating,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByU_R_First(
			userAccountId, rating, orderByComparator);

		if (collectionItem != null) {
			return collectionItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userAccountId=");
		sb.append(userAccountId);

		sb.append(", rating=");
		sb.append(rating);

		sb.append("}");

		throw new NoSuchCollectionItemException(sb.toString());
	}

	/**
	 * Returns the first collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public CollectionItem fetchByU_R_First(
		long userAccountId, Long rating,
		OrderByComparator<CollectionItem> orderByComparator) {

		List<CollectionItem> list = findByU_R(
			userAccountId, rating, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	@Override
	public CollectionItem findByU_R_Last(
			long userAccountId, Long rating,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByU_R_Last(
			userAccountId, rating, orderByComparator);

		if (collectionItem != null) {
			return collectionItem;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userAccountId=");
		sb.append(userAccountId);

		sb.append(", rating=");
		sb.append(rating);

		sb.append("}");

		throw new NoSuchCollectionItemException(sb.toString());
	}

	/**
	 * Returns the last collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public CollectionItem fetchByU_R_Last(
		long userAccountId, Long rating,
		OrderByComparator<CollectionItem> orderByComparator) {

		int count = countByU_R(userAccountId, rating);

		if (count == 0) {
			return null;
		}

		List<CollectionItem> list = findByU_R(
			userAccountId, rating, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the collection items before and after the current collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param collectionItemId the primary key of the current collection item
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem[] findByU_R_PrevAndNext(
			long collectionItemId, long userAccountId, Long rating,
			OrderByComparator<CollectionItem> orderByComparator)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = findByPrimaryKey(collectionItemId);

		Session session = null;

		try {
			session = openSession();

			CollectionItem[] array = new CollectionItemImpl[3];

			array[0] = getByU_R_PrevAndNext(
				session, collectionItem, userAccountId, rating,
				orderByComparator, true);

			array[1] = collectionItem;

			array[2] = getByU_R_PrevAndNext(
				session, collectionItem, userAccountId, rating,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CollectionItem getByU_R_PrevAndNext(
		Session session, CollectionItem collectionItem, long userAccountId,
		Long rating, OrderByComparator<CollectionItem> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_COLLECTIONITEM_WHERE);

		sb.append(_FINDER_COLUMN_U_R_USERACCOUNTID_2);

		sb.append(_FINDER_COLUMN_U_R_RATING_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CollectionItemModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userAccountId);

		queryPos.add(rating.longValue());

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						collectionItem)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CollectionItem> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the collection items where userAccountId = &#63; and rating = &#63; from the database.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 */
	@Override
	public void removeByU_R(long userAccountId, Long rating) {
		for (CollectionItem collectionItem :
				findByU_R(
					userAccountId, rating, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(collectionItem);
		}
	}

	/**
	 * Returns the number of collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @return the number of matching collection items
	 */
	@Override
	public int countByU_R(long userAccountId, Long rating) {
		FinderPath finderPath = _finderPathCountByU_R;

		Object[] finderArgs = new Object[] {userAccountId, rating};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COLLECTIONITEM_WHERE);

			sb.append(_FINDER_COLUMN_U_R_USERACCOUNTID_2);

			sb.append(_FINDER_COLUMN_U_R_RATING_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userAccountId);

				queryPos.add(rating.longValue());

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_R_USERACCOUNTID_2 =
		"collectionItem.userAccountId = ? AND ";

	private static final String _FINDER_COLUMN_U_R_RATING_2 =
		"collectionItem.rating = ?";

	public CollectionItemPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CollectionItem.class);

		setModelImplClass(CollectionItemImpl.class);
		setModelPKClass(long.class);

		setTable(CollectionItemTable.INSTANCE);
	}

	/**
	 * Caches the collection item in the entity cache if it is enabled.
	 *
	 * @param collectionItem the collection item
	 */
	@Override
	public void cacheResult(CollectionItem collectionItem) {
		entityCache.putResult(
			CollectionItemImpl.class, collectionItem.getPrimaryKey(),
			collectionItem);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the collection items in the entity cache if it is enabled.
	 *
	 * @param collectionItems the collection items
	 */
	@Override
	public void cacheResult(List<CollectionItem> collectionItems) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (collectionItems.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CollectionItem collectionItem : collectionItems) {
			if (entityCache.getResult(
					CollectionItemImpl.class, collectionItem.getPrimaryKey()) ==
						null) {

				cacheResult(collectionItem);
			}
		}
	}

	/**
	 * Clears the cache for all collection items.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CollectionItemImpl.class);

		finderCache.clearCache(CollectionItemImpl.class);
	}

	/**
	 * Clears the cache for the collection item.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CollectionItem collectionItem) {
		entityCache.removeResult(CollectionItemImpl.class, collectionItem);
	}

	@Override
	public void clearCache(List<CollectionItem> collectionItems) {
		for (CollectionItem collectionItem : collectionItems) {
			entityCache.removeResult(CollectionItemImpl.class, collectionItem);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CollectionItemImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CollectionItemImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new collection item with the primary key. Does not add the collection item to the database.
	 *
	 * @param collectionItemId the primary key for the new collection item
	 * @return the new collection item
	 */
	@Override
	public CollectionItem create(long collectionItemId) {
		CollectionItem collectionItem = new CollectionItemImpl();

		collectionItem.setNew(true);
		collectionItem.setPrimaryKey(collectionItemId);

		String uuid = PortalUUIDUtil.generate();

		collectionItem.setUuid(uuid);

		collectionItem.setCompanyId(CompanyThreadLocal.getCompanyId());

		return collectionItem;
	}

	/**
	 * Removes the collection item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item that was removed
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem remove(long collectionItemId)
		throws NoSuchCollectionItemException {

		return remove((Serializable)collectionItemId);
	}

	/**
	 * Removes the collection item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the collection item
	 * @return the collection item that was removed
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem remove(Serializable primaryKey)
		throws NoSuchCollectionItemException {

		Session session = null;

		try {
			session = openSession();

			CollectionItem collectionItem = (CollectionItem)session.get(
				CollectionItemImpl.class, primaryKey);

			if (collectionItem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCollectionItemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(collectionItem);
		}
		catch (NoSuchCollectionItemException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CollectionItem removeImpl(CollectionItem collectionItem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(collectionItem)) {
				collectionItem = (CollectionItem)session.get(
					CollectionItemImpl.class,
					collectionItem.getPrimaryKeyObj());
			}

			if (collectionItem != null) {
				session.delete(collectionItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (collectionItem != null) {
			clearCache(collectionItem);
		}

		return collectionItem;
	}

	@Override
	public CollectionItem updateImpl(CollectionItem collectionItem) {
		boolean isNew = collectionItem.isNew();

		if (!(collectionItem instanceof CollectionItemModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(collectionItem.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					collectionItem);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in collectionItem proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CollectionItem implementation " +
					collectionItem.getClass());
		}

		CollectionItemModelImpl collectionItemModelImpl =
			(CollectionItemModelImpl)collectionItem;

		if (Validator.isNull(collectionItem.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			collectionItem.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (collectionItem.getCreateDate() == null)) {
			if (serviceContext == null) {
				collectionItem.setCreateDate(date);
			}
			else {
				collectionItem.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!collectionItemModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				collectionItem.setModifiedDate(date);
			}
			else {
				collectionItem.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(collectionItem);
			}
			else {
				collectionItem = (CollectionItem)session.merge(collectionItem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CollectionItemImpl.class, collectionItemModelImpl, false, true);

		if (isNew) {
			collectionItem.setNew(false);
		}

		collectionItem.resetOriginalValues();

		return collectionItem;
	}

	/**
	 * Returns the collection item with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the collection item
	 * @return the collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCollectionItemException {

		CollectionItem collectionItem = fetchByPrimaryKey(primaryKey);

		if (collectionItem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCollectionItemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return collectionItem;
	}

	/**
	 * Returns the collection item with the primary key or throws a <code>NoSuchCollectionItemException</code> if it could not be found.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem findByPrimaryKey(long collectionItemId)
		throws NoSuchCollectionItemException {

		return findByPrimaryKey((Serializable)collectionItemId);
	}

	/**
	 * Returns the collection item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item, or <code>null</code> if a collection item with the primary key could not be found
	 */
	@Override
	public CollectionItem fetchByPrimaryKey(long collectionItemId) {
		return fetchByPrimaryKey((Serializable)collectionItemId);
	}

	/**
	 * Returns all the collection items.
	 *
	 * @return the collection items
	 */
	@Override
	public List<CollectionItem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the collection items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @return the range of collection items
	 */
	@Override
	public List<CollectionItem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the collection items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of collection items
	 */
	@Override
	public List<CollectionItem> findAll(
		int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the collection items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of collection items
	 */
	@Override
	public List<CollectionItem> findAll(
		int start, int end, OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<CollectionItem> list = null;

		if (useFinderCache) {
			list = (List<CollectionItem>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COLLECTIONITEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COLLECTIONITEM;

				sql = sql.concat(CollectionItemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CollectionItem>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the collection items from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CollectionItem collectionItem : findAll()) {
			remove(collectionItem);
		}
	}

	/**
	 * Returns the number of collection items.
	 *
	 * @return the number of collection items
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COLLECTIONITEM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "collectionItemId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COLLECTIONITEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CollectionItemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the collection item persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByU_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"userAccountId", "rating"}, true);

		_finderPathWithoutPaginationFindByU_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userAccountId", "rating"}, true);

		_finderPathCountByU_R = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_R",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"userAccountId", "rating"}, false);

		CollectionItemUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CollectionItemUtil.setPersistence(null);

		entityCache.removeCache(CollectionItemImpl.class.getName());
	}

	@Override
	@Reference(
		target = datamusicPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = datamusicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = datamusicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_COLLECTIONITEM =
		"SELECT collectionItem FROM CollectionItem collectionItem";

	private static final String _SQL_SELECT_COLLECTIONITEM_WHERE =
		"SELECT collectionItem FROM CollectionItem collectionItem WHERE ";

	private static final String _SQL_COUNT_COLLECTIONITEM =
		"SELECT COUNT(collectionItem) FROM CollectionItem collectionItem";

	private static final String _SQL_COUNT_COLLECTIONITEM_WHERE =
		"SELECT COUNT(collectionItem) FROM CollectionItem collectionItem WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "collectionItem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CollectionItem exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CollectionItem exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CollectionItemPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}