/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.impl;

import com.datamusic.app.exception.NoSuchMediaException;
import com.datamusic.app.model.Media;
import com.datamusic.app.model.MediaTable;
import com.datamusic.app.model.impl.MediaImpl;
import com.datamusic.app.model.impl.MediaModelImpl;
import com.datamusic.app.service.persistence.MediaPersistence;
import com.datamusic.app.service.persistence.MediaUtil;
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
 * The persistence implementation for the media service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @generated
 */
@Component(service = MediaPersistence.class)
public class MediaPersistenceImpl
	extends BasePersistenceImpl<Media> implements MediaPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MediaUtil</code> to access the media persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MediaImpl.class.getName();

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
	 * Returns all the medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching medias
	 */
	@Override
	public List<Media> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of matching medias
	 */
	@Override
	public List<Media> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

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

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Media media : list) {
					if (!uuid.equals(media.getUuid())) {
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

			sb.append(_SQL_SELECT_MEDIA_WHERE);

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
				sb.append(MediaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Media>)QueryUtil.list(
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
	 * Returns the first media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByUuid_First(
			String uuid, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByUuid_First(uuid, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the first media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByUuid_First(
		String uuid, OrderByComparator<Media> orderByComparator) {

		List<Media> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByUuid_Last(
			String uuid, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByUuid_Last(uuid, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByUuid_Last(
		String uuid, OrderByComparator<Media> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Media> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medias before and after the current media in the ordered set where uuid = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media[] findByUuid_PrevAndNext(
			long mediaId, String uuid,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		uuid = Objects.toString(uuid, "");

		Media media = findByPrimaryKey(mediaId);

		Session session = null;

		try {
			session = openSession();

			Media[] array = new MediaImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, media, uuid, orderByComparator, true);

			array[1] = media;

			array[2] = getByUuid_PrevAndNext(
				session, media, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Media getByUuid_PrevAndNext(
		Session session, Media media, String uuid,
		OrderByComparator<Media> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEDIA_WHERE);

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
			sb.append(MediaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(media)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Media> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Media media :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(media);
		}
	}

	/**
	 * Returns the number of medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching medias
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEDIA_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "media.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(media.uuid IS NULL OR media.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching medias
	 */
	@Override
	public List<Media> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of matching medias
	 */
	@Override
	public List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

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

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Media media : list) {
					if (!uuid.equals(media.getUuid()) ||
						(companyId != media.getCompanyId())) {

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

			sb.append(_SQL_SELECT_MEDIA_WHERE);

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
				sb.append(MediaModelImpl.ORDER_BY_JPQL);
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

				list = (List<Media>)QueryUtil.list(
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
	 * Returns the first media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the first media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Media> orderByComparator) {

		List<Media> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Media> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Media> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medias before and after the current media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media[] findByUuid_C_PrevAndNext(
			long mediaId, String uuid, long companyId,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		uuid = Objects.toString(uuid, "");

		Media media = findByPrimaryKey(mediaId);

		Session session = null;

		try {
			session = openSession();

			Media[] array = new MediaImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, media, uuid, companyId, orderByComparator, true);

			array[1] = media;

			array[2] = getByUuid_C_PrevAndNext(
				session, media, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Media getByUuid_C_PrevAndNext(
		Session session, Media media, String uuid, long companyId,
		OrderByComparator<Media> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MEDIA_WHERE);

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
			sb.append(MediaModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(media)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Media> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Media media :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(media);
		}
	}

	/**
	 * Returns the number of medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching medias
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MEDIA_WHERE);

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
		"media.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(media.uuid IS NULL OR media.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"media.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByMediaName;
	private FinderPath _finderPathWithoutPaginationFindByMediaName;
	private FinderPath _finderPathCountByMediaName;

	/**
	 * Returns all the medias where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @return the matching medias
	 */
	@Override
	public List<Media> findByMediaName(String mediaName) {
		return findByMediaName(
			mediaName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias where mediaName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param mediaName the media name
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of matching medias
	 */
	@Override
	public List<Media> findByMediaName(String mediaName, int start, int end) {
		return findByMediaName(mediaName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias where mediaName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param mediaName the media name
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByMediaName(
		String mediaName, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return findByMediaName(mediaName, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias where mediaName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param mediaName the media name
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByMediaName(
		String mediaName, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		mediaName = Objects.toString(mediaName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMediaName;
				finderArgs = new Object[] {mediaName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMediaName;
			finderArgs = new Object[] {
				mediaName, start, end, orderByComparator
			};
		}

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Media media : list) {
					if (!mediaName.equals(media.getMediaName())) {
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

			sb.append(_SQL_SELECT_MEDIA_WHERE);

			boolean bindMediaName = false;

			if (mediaName.isEmpty()) {
				sb.append(_FINDER_COLUMN_MEDIANAME_MEDIANAME_3);
			}
			else {
				bindMediaName = true;

				sb.append(_FINDER_COLUMN_MEDIANAME_MEDIANAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MediaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMediaName) {
					queryPos.add(mediaName);
				}

				list = (List<Media>)QueryUtil.list(
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
	 * Returns the first media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByMediaName_First(
			String mediaName, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByMediaName_First(mediaName, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mediaName=");
		sb.append(mediaName);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the first media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByMediaName_First(
		String mediaName, OrderByComparator<Media> orderByComparator) {

		List<Media> list = findByMediaName(mediaName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByMediaName_Last(
			String mediaName, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByMediaName_Last(mediaName, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mediaName=");
		sb.append(mediaName);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the last media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByMediaName_Last(
		String mediaName, OrderByComparator<Media> orderByComparator) {

		int count = countByMediaName(mediaName);

		if (count == 0) {
			return null;
		}

		List<Media> list = findByMediaName(
			mediaName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medias before and after the current media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media[] findByMediaName_PrevAndNext(
			long mediaId, String mediaName,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		mediaName = Objects.toString(mediaName, "");

		Media media = findByPrimaryKey(mediaId);

		Session session = null;

		try {
			session = openSession();

			Media[] array = new MediaImpl[3];

			array[0] = getByMediaName_PrevAndNext(
				session, media, mediaName, orderByComparator, true);

			array[1] = media;

			array[2] = getByMediaName_PrevAndNext(
				session, media, mediaName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Media getByMediaName_PrevAndNext(
		Session session, Media media, String mediaName,
		OrderByComparator<Media> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEDIA_WHERE);

		boolean bindMediaName = false;

		if (mediaName.isEmpty()) {
			sb.append(_FINDER_COLUMN_MEDIANAME_MEDIANAME_3);
		}
		else {
			bindMediaName = true;

			sb.append(_FINDER_COLUMN_MEDIANAME_MEDIANAME_2);
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
			sb.append(MediaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindMediaName) {
			queryPos.add(mediaName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(media)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Media> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medias where mediaName = &#63; from the database.
	 *
	 * @param mediaName the media name
	 */
	@Override
	public void removeByMediaName(String mediaName) {
		for (Media media :
				findByMediaName(
					mediaName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(media);
		}
	}

	/**
	 * Returns the number of medias where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @return the number of matching medias
	 */
	@Override
	public int countByMediaName(String mediaName) {
		mediaName = Objects.toString(mediaName, "");

		FinderPath finderPath = _finderPathCountByMediaName;

		Object[] finderArgs = new Object[] {mediaName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEDIA_WHERE);

			boolean bindMediaName = false;

			if (mediaName.isEmpty()) {
				sb.append(_FINDER_COLUMN_MEDIANAME_MEDIANAME_3);
			}
			else {
				bindMediaName = true;

				sb.append(_FINDER_COLUMN_MEDIANAME_MEDIANAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindMediaName) {
					queryPos.add(mediaName);
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

	private static final String _FINDER_COLUMN_MEDIANAME_MEDIANAME_2 =
		"media.mediaName = ?";

	private static final String _FINDER_COLUMN_MEDIANAME_MEDIANAME_3 =
		"(media.mediaName IS NULL OR media.mediaName = '')";

	private FinderPath _finderPathWithPaginationFindByMediaId;
	private FinderPath _finderPathWithoutPaginationFindByMediaId;
	private FinderPath _finderPathCountByMediaId;

	/**
	 * Returns all the medias where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @return the matching medias
	 */
	@Override
	public List<Media> findByMediaId(long mediaId) {
		return findByMediaId(
			mediaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias where mediaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param mediaId the media ID
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of matching medias
	 */
	@Override
	public List<Media> findByMediaId(long mediaId, int start, int end) {
		return findByMediaId(mediaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias where mediaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param mediaId the media ID
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByMediaId(
		long mediaId, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return findByMediaId(mediaId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias where mediaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param mediaId the media ID
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByMediaId(
		long mediaId, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByMediaId;
				finderArgs = new Object[] {mediaId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByMediaId;
			finderArgs = new Object[] {mediaId, start, end, orderByComparator};
		}

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Media media : list) {
					if (mediaId != media.getMediaId()) {
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

			sb.append(_SQL_SELECT_MEDIA_WHERE);

			sb.append(_FINDER_COLUMN_MEDIAID_MEDIAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MediaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mediaId);

				list = (List<Media>)QueryUtil.list(
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
	 * Returns the first media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByMediaId_First(
			long mediaId, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByMediaId_First(mediaId, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mediaId=");
		sb.append(mediaId);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the first media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByMediaId_First(
		long mediaId, OrderByComparator<Media> orderByComparator) {

		List<Media> list = findByMediaId(mediaId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByMediaId_Last(
			long mediaId, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByMediaId_Last(mediaId, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("mediaId=");
		sb.append(mediaId);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the last media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByMediaId_Last(
		long mediaId, OrderByComparator<Media> orderByComparator) {

		int count = countByMediaId(mediaId);

		if (count == 0) {
			return null;
		}

		List<Media> list = findByMediaId(
			mediaId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the medias where mediaId = &#63; from the database.
	 *
	 * @param mediaId the media ID
	 */
	@Override
	public void removeByMediaId(long mediaId) {
		for (Media media :
				findByMediaId(
					mediaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(media);
		}
	}

	/**
	 * Returns the number of medias where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @return the number of matching medias
	 */
	@Override
	public int countByMediaId(long mediaId) {
		FinderPath finderPath = _finderPathCountByMediaId;

		Object[] finderArgs = new Object[] {mediaId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEDIA_WHERE);

			sb.append(_FINDER_COLUMN_MEDIAID_MEDIAID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(mediaId);

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

	private static final String _FINDER_COLUMN_MEDIAID_MEDIAID_2 =
		"media.mediaId = ?";

	private FinderPath _finderPathWithPaginationFindByArtist;
	private FinderPath _finderPathWithoutPaginationFindByArtist;
	private FinderPath _finderPathCountByArtist;

	/**
	 * Returns all the medias where artist = &#63;.
	 *
	 * @param artist the artist
	 * @return the matching medias
	 */
	@Override
	public List<Media> findByArtist(String artist) {
		return findByArtist(artist, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias where artist = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param artist the artist
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of matching medias
	 */
	@Override
	public List<Media> findByArtist(String artist, int start, int end) {
		return findByArtist(artist, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias where artist = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param artist the artist
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByArtist(
		String artist, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return findByArtist(artist, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias where artist = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param artist the artist
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByArtist(
		String artist, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		artist = Objects.toString(artist, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByArtist;
				finderArgs = new Object[] {artist};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByArtist;
			finderArgs = new Object[] {artist, start, end, orderByComparator};
		}

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Media media : list) {
					if (!artist.equals(media.getArtist())) {
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

			sb.append(_SQL_SELECT_MEDIA_WHERE);

			boolean bindArtist = false;

			if (artist.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARTIST_ARTIST_3);
			}
			else {
				bindArtist = true;

				sb.append(_FINDER_COLUMN_ARTIST_ARTIST_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MediaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArtist) {
					queryPos.add(artist);
				}

				list = (List<Media>)QueryUtil.list(
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
	 * Returns the first media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByArtist_First(
			String artist, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByArtist_First(artist, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("artist=");
		sb.append(artist);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the first media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByArtist_First(
		String artist, OrderByComparator<Media> orderByComparator) {

		List<Media> list = findByArtist(artist, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByArtist_Last(
			String artist, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByArtist_Last(artist, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("artist=");
		sb.append(artist);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the last media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByArtist_Last(
		String artist, OrderByComparator<Media> orderByComparator) {

		int count = countByArtist(artist);

		if (count == 0) {
			return null;
		}

		List<Media> list = findByArtist(
			artist, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medias before and after the current media in the ordered set where artist = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media[] findByArtist_PrevAndNext(
			long mediaId, String artist,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		artist = Objects.toString(artist, "");

		Media media = findByPrimaryKey(mediaId);

		Session session = null;

		try {
			session = openSession();

			Media[] array = new MediaImpl[3];

			array[0] = getByArtist_PrevAndNext(
				session, media, artist, orderByComparator, true);

			array[1] = media;

			array[2] = getByArtist_PrevAndNext(
				session, media, artist, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Media getByArtist_PrevAndNext(
		Session session, Media media, String artist,
		OrderByComparator<Media> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEDIA_WHERE);

		boolean bindArtist = false;

		if (artist.isEmpty()) {
			sb.append(_FINDER_COLUMN_ARTIST_ARTIST_3);
		}
		else {
			bindArtist = true;

			sb.append(_FINDER_COLUMN_ARTIST_ARTIST_2);
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
			sb.append(MediaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindArtist) {
			queryPos.add(artist);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(media)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Media> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medias where artist = &#63; from the database.
	 *
	 * @param artist the artist
	 */
	@Override
	public void removeByArtist(String artist) {
		for (Media media :
				findByArtist(
					artist, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(media);
		}
	}

	/**
	 * Returns the number of medias where artist = &#63;.
	 *
	 * @param artist the artist
	 * @return the number of matching medias
	 */
	@Override
	public int countByArtist(String artist) {
		artist = Objects.toString(artist, "");

		FinderPath finderPath = _finderPathCountByArtist;

		Object[] finderArgs = new Object[] {artist};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEDIA_WHERE);

			boolean bindArtist = false;

			if (artist.isEmpty()) {
				sb.append(_FINDER_COLUMN_ARTIST_ARTIST_3);
			}
			else {
				bindArtist = true;

				sb.append(_FINDER_COLUMN_ARTIST_ARTIST_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindArtist) {
					queryPos.add(artist);
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

	private static final String _FINDER_COLUMN_ARTIST_ARTIST_2 =
		"media.artist = ?";

	private static final String _FINDER_COLUMN_ARTIST_ARTIST_3 =
		"(media.artist IS NULL OR media.artist = '')";

	private FinderPath _finderPathWithPaginationFindByGenre;
	private FinderPath _finderPathWithoutPaginationFindByGenre;
	private FinderPath _finderPathCountByGenre;

	/**
	 * Returns all the medias where genre = &#63;.
	 *
	 * @param genre the genre
	 * @return the matching medias
	 */
	@Override
	public List<Media> findByGenre(String genre) {
		return findByGenre(genre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias where genre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param genre the genre
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of matching medias
	 */
	@Override
	public List<Media> findByGenre(String genre, int start, int end) {
		return findByGenre(genre, start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias where genre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param genre the genre
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByGenre(
		String genre, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return findByGenre(genre, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias where genre = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param genre the genre
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching medias
	 */
	@Override
	public List<Media> findByGenre(
		String genre, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		genre = Objects.toString(genre, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGenre;
				finderArgs = new Object[] {genre};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGenre;
			finderArgs = new Object[] {genre, start, end, orderByComparator};
		}

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Media media : list) {
					if (!genre.equals(media.getGenre())) {
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

			sb.append(_SQL_SELECT_MEDIA_WHERE);

			boolean bindGenre = false;

			if (genre.isEmpty()) {
				sb.append(_FINDER_COLUMN_GENRE_GENRE_3);
			}
			else {
				bindGenre = true;

				sb.append(_FINDER_COLUMN_GENRE_GENRE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MediaModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGenre) {
					queryPos.add(genre);
				}

				list = (List<Media>)QueryUtil.list(
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
	 * Returns the first media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByGenre_First(
			String genre, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByGenre_First(genre, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("genre=");
		sb.append(genre);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the first media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByGenre_First(
		String genre, OrderByComparator<Media> orderByComparator) {

		List<Media> list = findByGenre(genre, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	@Override
	public Media findByGenre_Last(
			String genre, OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		Media media = fetchByGenre_Last(genre, orderByComparator);

		if (media != null) {
			return media;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("genre=");
		sb.append(genre);

		sb.append("}");

		throw new NoSuchMediaException(sb.toString());
	}

	/**
	 * Returns the last media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public Media fetchByGenre_Last(
		String genre, OrderByComparator<Media> orderByComparator) {

		int count = countByGenre(genre);

		if (count == 0) {
			return null;
		}

		List<Media> list = findByGenre(
			genre, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the medias before and after the current media in the ordered set where genre = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media[] findByGenre_PrevAndNext(
			long mediaId, String genre,
			OrderByComparator<Media> orderByComparator)
		throws NoSuchMediaException {

		genre = Objects.toString(genre, "");

		Media media = findByPrimaryKey(mediaId);

		Session session = null;

		try {
			session = openSession();

			Media[] array = new MediaImpl[3];

			array[0] = getByGenre_PrevAndNext(
				session, media, genre, orderByComparator, true);

			array[1] = media;

			array[2] = getByGenre_PrevAndNext(
				session, media, genre, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Media getByGenre_PrevAndNext(
		Session session, Media media, String genre,
		OrderByComparator<Media> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MEDIA_WHERE);

		boolean bindGenre = false;

		if (genre.isEmpty()) {
			sb.append(_FINDER_COLUMN_GENRE_GENRE_3);
		}
		else {
			bindGenre = true;

			sb.append(_FINDER_COLUMN_GENRE_GENRE_2);
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
			sb.append(MediaModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindGenre) {
			queryPos.add(genre);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(media)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Media> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the medias where genre = &#63; from the database.
	 *
	 * @param genre the genre
	 */
	@Override
	public void removeByGenre(String genre) {
		for (Media media :
				findByGenre(
					genre, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(media);
		}
	}

	/**
	 * Returns the number of medias where genre = &#63;.
	 *
	 * @param genre the genre
	 * @return the number of matching medias
	 */
	@Override
	public int countByGenre(String genre) {
		genre = Objects.toString(genre, "");

		FinderPath finderPath = _finderPathCountByGenre;

		Object[] finderArgs = new Object[] {genre};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MEDIA_WHERE);

			boolean bindGenre = false;

			if (genre.isEmpty()) {
				sb.append(_FINDER_COLUMN_GENRE_GENRE_3);
			}
			else {
				bindGenre = true;

				sb.append(_FINDER_COLUMN_GENRE_GENRE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindGenre) {
					queryPos.add(genre);
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

	private static final String _FINDER_COLUMN_GENRE_GENRE_2 =
		"media.genre = ?";

	private static final String _FINDER_COLUMN_GENRE_GENRE_3 =
		"(media.genre IS NULL OR media.genre = '')";

	public MediaPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Media.class);

		setModelImplClass(MediaImpl.class);
		setModelPKClass(long.class);

		setTable(MediaTable.INSTANCE);
	}

	/**
	 * Caches the media in the entity cache if it is enabled.
	 *
	 * @param media the media
	 */
	@Override
	public void cacheResult(Media media) {
		entityCache.putResult(MediaImpl.class, media.getPrimaryKey(), media);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the medias in the entity cache if it is enabled.
	 *
	 * @param medias the medias
	 */
	@Override
	public void cacheResult(List<Media> medias) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (medias.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Media media : medias) {
			if (entityCache.getResult(MediaImpl.class, media.getPrimaryKey()) ==
					null) {

				cacheResult(media);
			}
		}
	}

	/**
	 * Clears the cache for all medias.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MediaImpl.class);

		finderCache.clearCache(MediaImpl.class);
	}

	/**
	 * Clears the cache for the media.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Media media) {
		entityCache.removeResult(MediaImpl.class, media);
	}

	@Override
	public void clearCache(List<Media> medias) {
		for (Media media : medias) {
			entityCache.removeResult(MediaImpl.class, media);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MediaImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MediaImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new media with the primary key. Does not add the media to the database.
	 *
	 * @param mediaId the primary key for the new media
	 * @return the new media
	 */
	@Override
	public Media create(long mediaId) {
		Media media = new MediaImpl();

		media.setNew(true);
		media.setPrimaryKey(mediaId);

		String uuid = PortalUUIDUtil.generate();

		media.setUuid(uuid);

		media.setCompanyId(CompanyThreadLocal.getCompanyId());

		return media;
	}

	/**
	 * Removes the media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media that was removed
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media remove(long mediaId) throws NoSuchMediaException {
		return remove((Serializable)mediaId);
	}

	/**
	 * Removes the media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the media
	 * @return the media that was removed
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media remove(Serializable primaryKey) throws NoSuchMediaException {
		Session session = null;

		try {
			session = openSession();

			Media media = (Media)session.get(MediaImpl.class, primaryKey);

			if (media == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMediaException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(media);
		}
		catch (NoSuchMediaException noSuchEntityException) {
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
	protected Media removeImpl(Media media) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(media)) {
				media = (Media)session.get(
					MediaImpl.class, media.getPrimaryKeyObj());
			}

			if (media != null) {
				session.delete(media);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (media != null) {
			clearCache(media);
		}

		return media;
	}

	@Override
	public Media updateImpl(Media media) {
		boolean isNew = media.isNew();

		if (!(media instanceof MediaModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(media.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(media);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in media proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Media implementation " +
					media.getClass());
		}

		MediaModelImpl mediaModelImpl = (MediaModelImpl)media;

		if (Validator.isNull(media.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			media.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (media.getCreateDate() == null)) {
			if (serviceContext == null) {
				media.setCreateDate(date);
			}
			else {
				media.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!mediaModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				media.setModifiedDate(date);
			}
			else {
				media.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(media);
			}
			else {
				media = (Media)session.merge(media);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MediaImpl.class, mediaModelImpl, false, true);

		if (isNew) {
			media.setNew(false);
		}

		media.resetOriginalValues();

		return media;
	}

	/**
	 * Returns the media with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the media
	 * @return the media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMediaException {

		Media media = fetchByPrimaryKey(primaryKey);

		if (media == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMediaException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return media;
	}

	/**
	 * Returns the media with the primary key or throws a <code>NoSuchMediaException</code> if it could not be found.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	@Override
	public Media findByPrimaryKey(long mediaId) throws NoSuchMediaException {
		return findByPrimaryKey((Serializable)mediaId);
	}

	/**
	 * Returns the media with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media, or <code>null</code> if a media with the primary key could not be found
	 */
	@Override
	public Media fetchByPrimaryKey(long mediaId) {
		return fetchByPrimaryKey((Serializable)mediaId);
	}

	/**
	 * Returns all the medias.
	 *
	 * @return the medias
	 */
	@Override
	public List<Media> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of medias
	 */
	@Override
	public List<Media> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of medias
	 */
	@Override
	public List<Media> findAll(
		int start, int end, OrderByComparator<Media> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of medias
	 */
	@Override
	public List<Media> findAll(
		int start, int end, OrderByComparator<Media> orderByComparator,
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

		List<Media> list = null;

		if (useFinderCache) {
			list = (List<Media>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MEDIA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MEDIA;

				sql = sql.concat(MediaModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Media>)QueryUtil.list(
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
	 * Removes all the medias from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Media media : findAll()) {
			remove(media);
		}
	}

	/**
	 * Returns the number of medias.
	 *
	 * @return the number of medias
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MEDIA);

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
		return "mediaId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MEDIA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MediaModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the media persistence.
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

		_finderPathWithPaginationFindByMediaName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMediaName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mediaName"}, true);

		_finderPathWithoutPaginationFindByMediaName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMediaName",
			new String[] {String.class.getName()}, new String[] {"mediaName"},
			true);

		_finderPathCountByMediaName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMediaName",
			new String[] {String.class.getName()}, new String[] {"mediaName"},
			false);

		_finderPathWithPaginationFindByMediaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMediaId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"mediaId"}, true);

		_finderPathWithoutPaginationFindByMediaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMediaId",
			new String[] {Long.class.getName()}, new String[] {"mediaId"},
			true);

		_finderPathCountByMediaId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMediaId",
			new String[] {Long.class.getName()}, new String[] {"mediaId"},
			false);

		_finderPathWithPaginationFindByArtist = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArtist",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"artist"}, true);

		_finderPathWithoutPaginationFindByArtist = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArtist",
			new String[] {String.class.getName()}, new String[] {"artist"},
			true);

		_finderPathCountByArtist = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArtist",
			new String[] {String.class.getName()}, new String[] {"artist"},
			false);

		_finderPathWithPaginationFindByGenre = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGenre",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"genre"}, true);

		_finderPathWithoutPaginationFindByGenre = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGenre",
			new String[] {String.class.getName()}, new String[] {"genre"},
			true);

		_finderPathCountByGenre = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGenre",
			new String[] {String.class.getName()}, new String[] {"genre"},
			false);

		MediaUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MediaUtil.setPersistence(null);

		entityCache.removeCache(MediaImpl.class.getName());
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

	private static final String _SQL_SELECT_MEDIA =
		"SELECT media FROM Media media";

	private static final String _SQL_SELECT_MEDIA_WHERE =
		"SELECT media FROM Media media WHERE ";

	private static final String _SQL_COUNT_MEDIA =
		"SELECT COUNT(media) FROM Media media";

	private static final String _SQL_COUNT_MEDIA_WHERE =
		"SELECT COUNT(media) FROM Media media WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "media.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Media exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Media exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MediaPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}