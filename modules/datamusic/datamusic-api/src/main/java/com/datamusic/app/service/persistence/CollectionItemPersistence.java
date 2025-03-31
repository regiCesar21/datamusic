/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence;

import com.datamusic.app.exception.NoSuchCollectionItemException;
import com.datamusic.app.model.CollectionItem;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the collection item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @see CollectionItemUtil
 * @generated
 */
@ProviderType
public interface CollectionItemPersistence
	extends BasePersistence<CollectionItem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CollectionItemUtil} to access the collection item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the collection items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching collection items
	 */
	public java.util.List<CollectionItem> findByUuid(String uuid);

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
	public java.util.List<CollectionItem> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<CollectionItem> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

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
	public java.util.List<CollectionItem> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public CollectionItem findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public CollectionItem fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public CollectionItem findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public CollectionItem fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

	/**
	 * Returns the collection items before and after the current collection item in the ordered set where uuid = &#63;.
	 *
	 * @param collectionItemId the primary key of the current collection item
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	public CollectionItem[] findByUuid_PrevAndNext(
			long collectionItemId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Removes all the collection items where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of collection items where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching collection items
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching collection items
	 */
	public java.util.List<CollectionItem> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

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
	public java.util.List<CollectionItem> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public CollectionItem findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the first collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public CollectionItem fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public CollectionItem findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the last collection item in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public CollectionItem fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

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
	public CollectionItem[] findByUuid_C_PrevAndNext(
			long collectionItemId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Removes all the collection items where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of collection items where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching collection items
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @return the matching collection items
	 */
	public java.util.List<CollectionItem> findByU_R(
		long userAccountId, int rating);

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
	public java.util.List<CollectionItem> findByU_R(
		long userAccountId, int rating, int start, int end);

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
	public java.util.List<CollectionItem> findByU_R(
		long userAccountId, int rating, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

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
	public java.util.List<CollectionItem> findByU_R(
		long userAccountId, int rating, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public CollectionItem findByU_R_First(
			long userAccountId, int rating,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the first collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public CollectionItem fetchByU_R_First(
		long userAccountId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

	/**
	 * Returns the last collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item
	 * @throws NoSuchCollectionItemException if a matching collection item could not be found
	 */
	public CollectionItem findByU_R_Last(
			long userAccountId, int rating,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the last collection item in the ordered set where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	public CollectionItem fetchByU_R_Last(
		long userAccountId, int rating,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

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
	public CollectionItem[] findByU_R_PrevAndNext(
			long collectionItemId, long userAccountId, int rating,
			com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
				orderByComparator)
		throws NoSuchCollectionItemException;

	/**
	 * Removes all the collection items where userAccountId = &#63; and rating = &#63; from the database.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 */
	public void removeByU_R(long userAccountId, int rating);

	/**
	 * Returns the number of collection items where userAccountId = &#63; and rating = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param rating the rating
	 * @return the number of matching collection items
	 */
	public int countByU_R(long userAccountId, int rating);

	/**
	 * Caches the collection item in the entity cache if it is enabled.
	 *
	 * @param collectionItem the collection item
	 */
	public void cacheResult(CollectionItem collectionItem);

	/**
	 * Caches the collection items in the entity cache if it is enabled.
	 *
	 * @param collectionItems the collection items
	 */
	public void cacheResult(java.util.List<CollectionItem> collectionItems);

	/**
	 * Creates a new collection item with the primary key. Does not add the collection item to the database.
	 *
	 * @param collectionItemId the primary key for the new collection item
	 * @return the new collection item
	 */
	public CollectionItem create(long collectionItemId);

	/**
	 * Removes the collection item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item that was removed
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	public CollectionItem remove(long collectionItemId)
		throws NoSuchCollectionItemException;

	public CollectionItem updateImpl(CollectionItem collectionItem);

	/**
	 * Returns the collection item with the primary key or throws a <code>NoSuchCollectionItemException</code> if it could not be found.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item
	 * @throws NoSuchCollectionItemException if a collection item with the primary key could not be found
	 */
	public CollectionItem findByPrimaryKey(long collectionItemId)
		throws NoSuchCollectionItemException;

	/**
	 * Returns the collection item with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item, or <code>null</code> if a collection item with the primary key could not be found
	 */
	public CollectionItem fetchByPrimaryKey(long collectionItemId);

	/**
	 * Returns all the collection items.
	 *
	 * @return the collection items
	 */
	public java.util.List<CollectionItem> findAll();

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
	public java.util.List<CollectionItem> findAll(int start, int end);

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
	public java.util.List<CollectionItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator);

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
	public java.util.List<CollectionItem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CollectionItem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the collection items from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of collection items.
	 *
	 * @return the number of collection items
	 */
	public int countAll();

}