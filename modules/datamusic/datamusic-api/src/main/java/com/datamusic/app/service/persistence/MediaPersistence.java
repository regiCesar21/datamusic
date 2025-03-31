/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence;

import com.datamusic.app.exception.NoSuchMediaException;
import com.datamusic.app.model.Media;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the media service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @see MediaUtil
 * @generated
 */
@ProviderType
public interface MediaPersistence extends BasePersistence<Media> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MediaUtil} to access the media persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching medias
	 */
	public java.util.List<Media> findByUuid(String uuid);

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
	public java.util.List<Media> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Media> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the first media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the last media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the last media in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the medias before and after the current media in the ordered set where uuid = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public Media[] findByUuid_PrevAndNext(
			long mediaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Removes all the medias where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of medias where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching medias
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching medias
	 */
	public java.util.List<Media> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the first media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the last media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the last media in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public Media[] findByUuid_C_PrevAndNext(
			long mediaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Removes all the medias where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of medias where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching medias
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the medias where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @return the matching medias
	 */
	public java.util.List<Media> findByMediaName(String mediaName);

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
	public java.util.List<Media> findByMediaName(
		String mediaName, int start, int end);

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
	public java.util.List<Media> findByMediaName(
		String mediaName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findByMediaName(
		String mediaName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByMediaName_First(
			String mediaName,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the first media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByMediaName_First(
		String mediaName,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the last media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByMediaName_Last(
			String mediaName,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the last media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByMediaName_Last(
		String mediaName,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the medias before and after the current media in the ordered set where mediaName = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param mediaName the media name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public Media[] findByMediaName_PrevAndNext(
			long mediaId, String mediaName,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Removes all the medias where mediaName = &#63; from the database.
	 *
	 * @param mediaName the media name
	 */
	public void removeByMediaName(String mediaName);

	/**
	 * Returns the number of medias where mediaName = &#63;.
	 *
	 * @param mediaName the media name
	 * @return the number of matching medias
	 */
	public int countByMediaName(String mediaName);

	/**
	 * Returns all the medias where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @return the matching medias
	 */
	public java.util.List<Media> findByMediaId(long mediaId);

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
	public java.util.List<Media> findByMediaId(
		long mediaId, int start, int end);

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
	public java.util.List<Media> findByMediaId(
		long mediaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findByMediaId(
		long mediaId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByMediaId_First(
			long mediaId,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the first media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByMediaId_First(
		long mediaId,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the last media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByMediaId_Last(
			long mediaId,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the last media in the ordered set where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByMediaId_Last(
		long mediaId,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Removes all the medias where mediaId = &#63; from the database.
	 *
	 * @param mediaId the media ID
	 */
	public void removeByMediaId(long mediaId);

	/**
	 * Returns the number of medias where mediaId = &#63;.
	 *
	 * @param mediaId the media ID
	 * @return the number of matching medias
	 */
	public int countByMediaId(long mediaId);

	/**
	 * Returns all the medias where artist = &#63;.
	 *
	 * @param artist the artist
	 * @return the matching medias
	 */
	public java.util.List<Media> findByArtist(String artist);

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
	public java.util.List<Media> findByArtist(
		String artist, int start, int end);

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
	public java.util.List<Media> findByArtist(
		String artist, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findByArtist(
		String artist, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByArtist_First(
			String artist,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the first media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByArtist_First(
		String artist,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the last media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByArtist_Last(
			String artist,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the last media in the ordered set where artist = &#63;.
	 *
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByArtist_Last(
		String artist,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the medias before and after the current media in the ordered set where artist = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param artist the artist
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public Media[] findByArtist_PrevAndNext(
			long mediaId, String artist,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Removes all the medias where artist = &#63; from the database.
	 *
	 * @param artist the artist
	 */
	public void removeByArtist(String artist);

	/**
	 * Returns the number of medias where artist = &#63;.
	 *
	 * @param artist the artist
	 * @return the number of matching medias
	 */
	public int countByArtist(String artist);

	/**
	 * Returns all the medias where genre = &#63;.
	 *
	 * @param genre the genre
	 * @return the matching medias
	 */
	public java.util.List<Media> findByGenre(String genre);

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
	public java.util.List<Media> findByGenre(String genre, int start, int end);

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
	public java.util.List<Media> findByGenre(
		String genre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findByGenre(
		String genre, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByGenre_First(
			String genre,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the first media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByGenre_First(
		String genre,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the last media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media
	 * @throws NoSuchMediaException if a matching media could not be found
	 */
	public Media findByGenre_Last(
			String genre,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Returns the last media in the ordered set where genre = &#63;.
	 *
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching media, or <code>null</code> if a matching media could not be found
	 */
	public Media fetchByGenre_Last(
		String genre,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

	/**
	 * Returns the medias before and after the current media in the ordered set where genre = &#63;.
	 *
	 * @param mediaId the primary key of the current media
	 * @param genre the genre
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public Media[] findByGenre_PrevAndNext(
			long mediaId, String genre,
			com.liferay.portal.kernel.util.OrderByComparator<Media>
				orderByComparator)
		throws NoSuchMediaException;

	/**
	 * Removes all the medias where genre = &#63; from the database.
	 *
	 * @param genre the genre
	 */
	public void removeByGenre(String genre);

	/**
	 * Returns the number of medias where genre = &#63;.
	 *
	 * @param genre the genre
	 * @return the number of matching medias
	 */
	public int countByGenre(String genre);

	/**
	 * Caches the media in the entity cache if it is enabled.
	 *
	 * @param media the media
	 */
	public void cacheResult(Media media);

	/**
	 * Caches the medias in the entity cache if it is enabled.
	 *
	 * @param medias the medias
	 */
	public void cacheResult(java.util.List<Media> medias);

	/**
	 * Creates a new media with the primary key. Does not add the media to the database.
	 *
	 * @param mediaId the primary key for the new media
	 * @return the new media
	 */
	public Media create(long mediaId);

	/**
	 * Removes the media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media that was removed
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public Media remove(long mediaId) throws NoSuchMediaException;

	public Media updateImpl(Media media);

	/**
	 * Returns the media with the primary key or throws a <code>NoSuchMediaException</code> if it could not be found.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media
	 * @throws NoSuchMediaException if a media with the primary key could not be found
	 */
	public Media findByPrimaryKey(long mediaId) throws NoSuchMediaException;

	/**
	 * Returns the media with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media, or <code>null</code> if a media with the primary key could not be found
	 */
	public Media fetchByPrimaryKey(long mediaId);

	/**
	 * Returns all the medias.
	 *
	 * @return the medias
	 */
	public java.util.List<Media> findAll();

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
	public java.util.List<Media> findAll(int start, int end);

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
	public java.util.List<Media> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator);

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
	public java.util.List<Media> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Media>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the medias from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of medias.
	 *
	 * @return the number of medias
	 */
	public int countAll();

}