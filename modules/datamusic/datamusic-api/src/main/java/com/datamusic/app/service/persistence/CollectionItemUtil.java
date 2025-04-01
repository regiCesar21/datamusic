/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence;

import com.datamusic.app.model.CollectionItem;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the collection item service. This utility wraps <code>com.datamusic.app.service.persistence.impl.CollectionItemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @see CollectionItemPersistence
 * @generated
 */
public class CollectionItemUtil {

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
	public static void clearCache(CollectionItem collectionItem) {
		getPersistence().clearCache(collectionItem);
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
	public static Map<Serializable, CollectionItem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CollectionItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CollectionItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CollectionItem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CollectionItem update(CollectionItem collectionItem) {
		return getPersistence().update(collectionItem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CollectionItem update(
		CollectionItem collectionItem, ServiceContext serviceContext) {

		return getPersistence().update(collectionItem, serviceContext);
	}

	/**
	 * Returns all the collection items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching collection items
	 */
	public static List<CollectionItem> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
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
	public static List<CollectionItem> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
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
	public static List<CollectionItem> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
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
	public static List<CollectionItem> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public static CollectionItem findByUuid_First(
			String uuid, OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public static CollectionItem fetchByUuid_First(
		String uuid, OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public static CollectionItem findByUuid_Last(
			String uuid, OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public static CollectionItem fetchByUuid_Last(
		String uuid, OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
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
	public static CollectionItem[] findByUuid_PrevAndNext(
			long collectionItemId, String uuid,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByUuid_PrevAndNext(
			collectionItemId, uuid, orderByComparator);
	}

	/**
	 * Removes all the collection items where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of collection items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching collection items
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching collection items
	 */
	public static List<CollectionItem> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
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
	public static List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
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
	public static List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
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
	public static List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
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
	public static CollectionItem findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public static CollectionItem fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
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
	public static CollectionItem findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public static CollectionItem fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
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
	public static CollectionItem[] findByUuid_C_PrevAndNext(
			long collectionItemId, String uuid, long companyId,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByUuid_C_PrevAndNext(
			collectionItemId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the collection items where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching collection items
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @return the matching collection items
	 */
	public static List<CollectionItem> findByU_R(
		long userAccountId, Long rating) {

		return getPersistence().findByU_R(userAccountId, rating);
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
	public static List<CollectionItem> findByU_R(
		long userAccountId, Long rating, int start, int end) {

		return getPersistence().findByU_R(userAccountId, rating, start, end);
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
	public static List<CollectionItem> findByU_R(
		long userAccountId, Long rating, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().findByU_R(
			userAccountId, rating, start, end, orderByComparator);
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
	public static List<CollectionItem> findByU_R(
		long userAccountId, Long rating, int start, int end,
		OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_R(
			userAccountId, rating, start, end, orderByComparator,
			useFinderCache);
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
	public static CollectionItem findByU_R_First(
			long userAccountId, Long rating,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByU_R_First(
			userAccountId, rating, orderByComparator);
	}

	/**
	 * Returns the first collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public static CollectionItem fetchByU_R_First(
		long userAccountId, Long rating,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().fetchByU_R_First(
			userAccountId, rating, orderByComparator);
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
	public static CollectionItem findByU_R_Last(
			long userAccountId, Long rating,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByU_R_Last(
			userAccountId, rating, orderByComparator);
	}

	/**
	 * Returns the last collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public static CollectionItem fetchByU_R_Last(
		long userAccountId, Long rating,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().fetchByU_R_Last(
			userAccountId, rating, orderByComparator);
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
	public static CollectionItem[] findByU_R_PrevAndNext(
			long collectionItemId, long userAccountId, Long rating,
			OrderByComparator<CollectionItem> orderByComparator)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByU_R_PrevAndNext(
			collectionItemId, userAccountId, rating, orderByComparator);
	}

	/**
	 * Removes all the collection items where userAccountId = &#63; and rating = &#63; from the database.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 */
	public static void removeByU_R(long userAccountId, Long rating) {
		getPersistence().removeByU_R(userAccountId, rating);
	}

	/**
	 * Returns the number of collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @return the number of matching collection items
	 */
	public static int countByU_R(long userAccountId, Long rating) {
		return getPersistence().countByU_R(userAccountId, rating);
	}

	/**
	 * Caches the collection item in the entity cache if it is enabled.
	 *
	 * @param collectionItem the collection item
	 */
	public static void cacheResult(CollectionItem collectionItem) {
		getPersistence().cacheResult(collectionItem);
	}

	/**
	 * Caches the collection items in the entity cache if it is enabled.
	 *
	 * @param collectionItems the collection items
	 */
	public static void cacheResult(List<CollectionItem> collectionItems) {
		getPersistence().cacheResult(collectionItems);
	}

	/**
	 * Creates a new collection item with the primary key. Does not add the collection item to the database.
	 *
	 * @param collectionItemId the primary key for the new collection item
	 * @return the new collection item
	 */
	public static CollectionItem create(long collectionItemId) {
		return getPersistence().create(collectionItemId);
	}

	/**
	 * Removes the collection item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item that was removed
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	public static CollectionItem remove(long collectionItemId)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().remove(collectionItemId);
	}

	public static CollectionItem updateImpl(CollectionItem collectionItem) {
		return getPersistence().updateImpl(collectionItem);
	}

	/**
	 * Returns the collection item with the primary key or throws a <code>NoSuchCollectionItemException</code> if it could not be found.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	public static CollectionItem findByPrimaryKey(long collectionItemId)
		throws com.datamusic.app.exception.NoSuchCollectionItemException {

		return getPersistence().findByPrimaryKey(collectionItemId);
	}

	/**
	 * Returns the collection item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item, or <code>null</code> if a collection item with the primary key could not be found
	 */
	public static CollectionItem fetchByPrimaryKey(long collectionItemId) {
		return getPersistence().fetchByPrimaryKey(collectionItemId);
	}

	/**
	 * Returns all the collection items.
	 *
	 * @return the collection items
	 */
	public static List<CollectionItem> findAll() {
		return getPersistence().findAll();
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
	public static List<CollectionItem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<CollectionItem> findAll(
		int start, int end,
		OrderByComparator<CollectionItem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<CollectionItem> findAll(
		int start, int end, OrderByComparator<CollectionItem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the collection items from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of collection items.
	 *
	 * @return the number of collection items
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CollectionItemPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CollectionItemPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CollectionItemPersistence _persistence;

}