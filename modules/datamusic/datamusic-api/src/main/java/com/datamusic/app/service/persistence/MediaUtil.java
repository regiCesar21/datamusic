/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence;

import com.datamusic.app.model.Media;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the media service. This utility wraps <code>com.datamusic.app.service.persistence.impl.MediaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @see MediaPersistence
 * @generated
 */
public class MediaUtil {

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
	public static void clearCache(Media media) {
		getPersistence().clearCache(media);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Media> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Media> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Media> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Media> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Media update(Media media) {
		return getPersistence().update(media);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Media update(Media media, ServiceContext serviceContext) {
		return getPersistence().update(media, serviceContext);
	}

	/**
	 * Returns all the medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching medias
	 */
	public static List<Media> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<Media> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<Media> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<Media> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByUuid_First(
			String uuid, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByUuid_First(
		String uuid, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByUuid_Last(
			String uuid, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByUuid_Last(
		String uuid, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static Media[] findByUuid_PrevAndNext(
			long mediaId, String uuid,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByUuid_PrevAndNext(
			mediaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the medias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching medias
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching medias
	 */
	public static List<Media> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static Media findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static Media findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static Media[] findByUuid_C_PrevAndNext(
			long mediaId, String uuid, long companyId,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			mediaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the medias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching medias
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the medias where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @return the matching medias
	 */
	public static List<Media> findByMediaName(String mediaName) {
		return getPersistence().findByMediaName(mediaName);
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
	public static List<Media> findByMediaName(
		String mediaName, int start, int end) {

		return getPersistence().findByMediaName(mediaName, start, end);
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
	public static List<Media> findByMediaName(
		String mediaName, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findByMediaName(
			mediaName, start, end, orderByComparator);
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
	public static List<Media> findByMediaName(
		String mediaName, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByMediaName(
			mediaName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByMediaName_First(
			String mediaName, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByMediaName_First(
			mediaName, orderByComparator);
	}

	/**
	 * Returns the first media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByMediaName_First(
		String mediaName, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByMediaName_First(
			mediaName, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByMediaName_Last(
			String mediaName, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByMediaName_Last(
			mediaName, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByMediaName_Last(
		String mediaName, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByMediaName_Last(
			mediaName, orderByComparator);
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
	public static Media[] findByMediaName_PrevAndNext(
			long mediaId, String mediaName,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByMediaName_PrevAndNext(
			mediaId, mediaName, orderByComparator);
	}

	/**
	 * Removes all the medias where mediaName = &#63; from the database.
	 *
	 * @param mediaName the media name
	 */
	public static void removeByMediaName(String mediaName) {
		getPersistence().removeByMediaName(mediaName);
	}

	/**
	 * Returns the number of medias where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @return the number of matching medias
	 */
	public static int countByMediaName(String mediaName) {
		return getPersistence().countByMediaName(mediaName);
	}

	/**
	 * Returns all the medias where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @return the matching medias
	 */
	public static List<Media> findByMediaId(long mediaId) {
		return getPersistence().findByMediaId(mediaId);
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
	public static List<Media> findByMediaId(long mediaId, int start, int end) {
		return getPersistence().findByMediaId(mediaId, start, end);
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
	public static List<Media> findByMediaId(
		long mediaId, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findByMediaId(
			mediaId, start, end, orderByComparator);
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
	public static List<Media> findByMediaId(
		long mediaId, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByMediaId(
			mediaId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByMediaId_First(
			long mediaId, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByMediaId_First(mediaId, orderByComparator);
	}

	/**
	 * Returns the first media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByMediaId_First(
		long mediaId, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByMediaId_First(
			mediaId, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByMediaId_Last(
			long mediaId, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByMediaId_Last(mediaId, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByMediaId_Last(
		long mediaId, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByMediaId_Last(mediaId, orderByComparator);
	}

	/**
	 * Removes all the medias where mediaId = &#63; from the database.
	 *
	 * @param mediaId the media ID
	 */
	public static void removeByMediaId(long mediaId) {
		getPersistence().removeByMediaId(mediaId);
	}

	/**
	 * Returns the number of medias where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @return the number of matching medias
	 */
	public static int countByMediaId(long mediaId) {
		return getPersistence().countByMediaId(mediaId);
	}

	/**
	 * Returns all the medias where artist = &#63;.
	 *
	 * @param artist the artist
	 * @return the matching medias
	 */
	public static List<Media> findByArtist(String artist) {
		return getPersistence().findByArtist(artist);
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
	public static List<Media> findByArtist(String artist, int start, int end) {
		return getPersistence().findByArtist(artist, start, end);
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
	public static List<Media> findByArtist(
		String artist, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findByArtist(
			artist, start, end, orderByComparator);
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
	public static List<Media> findByArtist(
		String artist, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByArtist(
			artist, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByArtist_First(
			String artist, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByArtist_First(artist, orderByComparator);
	}

	/**
	 * Returns the first media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByArtist_First(
		String artist, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByArtist_First(artist, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByArtist_Last(
			String artist, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByArtist_Last(artist, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByArtist_Last(
		String artist, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByArtist_Last(artist, orderByComparator);
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
	public static Media[] findByArtist_PrevAndNext(
			long mediaId, String artist,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByArtist_PrevAndNext(
			mediaId, artist, orderByComparator);
	}

	/**
	 * Removes all the medias where artist = &#63; from the database.
	 *
	 * @param artist the artist
	 */
	public static void removeByArtist(String artist) {
		getPersistence().removeByArtist(artist);
	}

	/**
	 * Returns the number of medias where artist = &#63;.
	 *
	 * @param artist the artist
	 * @return the number of matching medias
	 */
	public static int countByArtist(String artist) {
		return getPersistence().countByArtist(artist);
	}

	/**
	 * Returns all the medias where genre = &#63;.
	 *
	 * @param genre the genre
	 * @return the matching medias
	 */
	public static List<Media> findByGenre(String genre) {
		return getPersistence().findByGenre(genre);
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
	public static List<Media> findByGenre(String genre, int start, int end) {
		return getPersistence().findByGenre(genre, start, end);
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
	public static List<Media> findByGenre(
		String genre, int start, int end,
		OrderByComparator<Media> orderByComparator) {

		return getPersistence().findByGenre(
			genre, start, end, orderByComparator);
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
	public static List<Media> findByGenre(
		String genre, int start, int end,
		OrderByComparator<Media> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGenre(
			genre, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByGenre_First(
			String genre, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByGenre_First(genre, orderByComparator);
	}

	/**
	 * Returns the first media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByGenre_First(
		String genre, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByGenre_First(genre, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public static Media findByGenre_Last(
			String genre, OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByGenre_Last(genre, orderByComparator);
	}

	/**
	 * Returns the last media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public static Media fetchByGenre_Last(
		String genre, OrderByComparator<Media> orderByComparator) {

		return getPersistence().fetchByGenre_Last(genre, orderByComparator);
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
	public static Media[] findByGenre_PrevAndNext(
			long mediaId, String genre,
			OrderByComparator<Media> orderByComparator)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByGenre_PrevAndNext(
			mediaId, genre, orderByComparator);
	}

	/**
	 * Removes all the medias where genre = &#63; from the database.
	 *
	 * @param genre the genre
	 */
	public static void removeByGenre(String genre) {
		getPersistence().removeByGenre(genre);
	}

	/**
	 * Returns the number of medias where genre = &#63;.
	 *
	 * @param genre the genre
	 * @return the number of matching medias
	 */
	public static int countByGenre(String genre) {
		return getPersistence().countByGenre(genre);
	}

	/**
	 * Caches the media in the entity cache if it is enabled.
	 *
	 * @param media the media
	 */
	public static void cacheResult(Media media) {
		getPersistence().cacheResult(media);
	}

	/**
	 * Caches the medias in the entity cache if it is enabled.
	 *
	 * @param medias the medias
	 */
	public static void cacheResult(List<Media> medias) {
		getPersistence().cacheResult(medias);
	}

	/**
	 * Creates a new media with the primary key. Does not add the media to the database.
	 *
	 * @param mediaId the primary key for the new media
	 * @return the new media
	 */
	public static Media create(long mediaId) {
		return getPersistence().create(mediaId);
	}

	/**
	 * Removes the media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media that was removed
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public static Media remove(long mediaId)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().remove(mediaId);
	}

	public static Media updateImpl(Media media) {
		return getPersistence().updateImpl(media);
	}

	/**
	 * Returns the media with the primary key or throws a <code>NoSuchMediaException</code> if it could not be found.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public static Media findByPrimaryKey(long mediaId)
		throws com.datamusic.app.exception.NoSuchMediaException {

		return getPersistence().findByPrimaryKey(mediaId);
	}

	/**
	 * Returns the media with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media, or <code>null</code> if a media with the primary key could not be found
	 */
	public static Media fetchByPrimaryKey(long mediaId) {
		return getPersistence().fetchByPrimaryKey(mediaId);
	}

	/**
	 * Returns all the medias.
	 *
	 * @return the medias
	 */
	public static List<Media> findAll() {
		return getPersistence().findAll();
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
	public static List<Media> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Media> findAll(
		int start, int end, OrderByComparator<Media> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Media> findAll(
		int start, int end, OrderByComparator<Media> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the medias from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of medias.
	 *
	 * @return the number of medias
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MediaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(MediaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile MediaPersistence _persistence;

}