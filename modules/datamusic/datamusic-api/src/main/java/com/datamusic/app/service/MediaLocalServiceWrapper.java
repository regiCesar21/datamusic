/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MediaLocalService}.
 *
 * @author Regisson Aguiar
 * @see MediaLocalService
 * @generated
 */
public class MediaLocalServiceWrapper
	implements MediaLocalService, ServiceWrapper<MediaLocalService> {

	public MediaLocalServiceWrapper() {
		this(null);
	}

	public MediaLocalServiceWrapper(MediaLocalService mediaLocalService) {
		_mediaLocalService = mediaLocalService;
	}

	/**
	 * Adds the media to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param media the media
	 * @return the media that was added
	 */
	@Override
	public com.datamusic.app.model.Media addMedia(
		com.datamusic.app.model.Media media) {

		return _mediaLocalService.addMedia(media);
	}

	/**
	 * Creates a new media with the primary key. Does not add the media to the database.
	 *
	 * @param mediaId the primary key for the new media
	 * @return the new media
	 */
	@Override
	public com.datamusic.app.model.Media createMedia(long mediaId) {
		return _mediaLocalService.createMedia(mediaId);
	}

	@Override
	public com.datamusic.app.model.Media createMedia(
			long mediaId, String mediaName, String artist, String description,
			String genre)
		throws com.datamusic.app.exception.DuplicateMediaException {

		return _mediaLocalService.createMedia(
			mediaId, mediaName, artist, description, genre);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the media with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param mediaId the primary key of the media
	 * @return the media that was removed
	 * @throws MediaNotFoundException
	 * @throws NoSuchMediaException
	 * @throws PortalException if a media with the primary key could not be found
	 */
	@Override
	public com.datamusic.app.model.Media deleteMedia(long mediaId)
		throws com.datamusic.app.exception.MediaNotFoundException,
			   com.datamusic.app.exception.NoSuchMediaException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _mediaLocalService.deleteMedia(mediaId);
	}

	/**
	 * Deletes the media from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param media the media
	 * @return the media that was removed
	 */
	@Override
	public com.datamusic.app.model.Media deleteMedia(
		com.datamusic.app.model.Media media) {

		return _mediaLocalService.deleteMedia(media);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _mediaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _mediaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mediaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _mediaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.MediaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mediaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.MediaModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mediaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _mediaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _mediaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.datamusic.app.model.Media fetchMedia(long mediaId) {
		return _mediaLocalService.fetchMedia(mediaId);
	}

	/**
	 * Returns the media with the matching UUID and company.
	 *
	 * @param uuid the media's UUID
	 * @param companyId the primary key of the company
	 * @return the matching media, or <code>null</code> if a matching media could not be found
	 */
	@Override
	public com.datamusic.app.model.Media fetchMediaByUuidAndCompanyId(
		String uuid, long companyId) {

		return _mediaLocalService.fetchMediaByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mediaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _mediaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mediaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the media with the primary key.
	 *
	 * @param mediaId the primary key of the media
	 * @return the media
	 * @throws PortalException if a media with the primary key could not be found
	 */
	@Override
	public com.datamusic.app.model.Media getMedia(long mediaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaLocalService.getMedia(mediaId);
	}

	/**
	 * Returns the media with the matching UUID and company.
	 *
	 * @param uuid the media's UUID
	 * @param companyId the primary key of the company
	 * @return the matching media
	 * @throws PortalException if a matching media could not be found
	 */
	@Override
	public com.datamusic.app.model.Media getMediaByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaLocalService.getMediaByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the medias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.MediaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of medias
	 * @param end the upper bound of the range of medias (not inclusive)
	 * @return the range of medias
	 */
	@Override
	public java.util.List<com.datamusic.app.model.Media> getMedias(
		int start, int end) {

		return _mediaLocalService.getMedias(start, end);
	}

	/**
	 * Returns the number of medias.
	 *
	 * @return the number of medias
	 */
	@Override
	public int getMediasCount() {
		return _mediaLocalService.getMediasCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mediaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mediaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the media in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MediaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param media the media
	 * @return the media that was updated
	 */
	@Override
	public com.datamusic.app.model.Media updateMedia(
		com.datamusic.app.model.Media media) {

		return _mediaLocalService.updateMedia(media);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _mediaLocalService.getBasePersistence();
	}

	@Override
	public MediaLocalService getWrappedService() {
		return _mediaLocalService;
	}

	@Override
	public void setWrappedService(MediaLocalService mediaLocalService) {
		_mediaLocalService = mediaLocalService;
	}

	private MediaLocalService _mediaLocalService;

}