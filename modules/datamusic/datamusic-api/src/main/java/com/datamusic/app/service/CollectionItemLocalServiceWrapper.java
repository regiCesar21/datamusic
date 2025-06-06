/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CollectionItemLocalService}.
 *
 * @author Regisson Aguiar
 * @see CollectionItemLocalService
 * @generated
 */
public class CollectionItemLocalServiceWrapper
	implements CollectionItemLocalService,
			   ServiceWrapper<CollectionItemLocalService> {

	public CollectionItemLocalServiceWrapper() {
		this(null);
	}

	public CollectionItemLocalServiceWrapper(
		CollectionItemLocalService collectionItemLocalService) {

		_collectionItemLocalService = collectionItemLocalService;
	}

	/**
	 * Adds the collection item to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionItem the collection item
	 * @return the collection item that was added
	 */
	@Override
	public com.datamusic.app.model.CollectionItem addCollectionItem(
		com.datamusic.app.model.CollectionItem collectionItem) {

		return _collectionItemLocalService.addCollectionItem(collectionItem);
	}

	/**
	 * Creates a new collection item with the primary key. Does not add the collection item to the database.
	 *
	 * @param collectionItemId the primary key for the new collection item
	 * @return the new collection item
	 */
	@Override
	public com.datamusic.app.model.CollectionItem createCollectionItem(
		long collectionItemId) {

		return _collectionItemLocalService.createCollectionItem(
			collectionItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionItemLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the collection item from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionItem the collection item
	 * @return the collection item that was removed
	 */
	@Override
	public com.datamusic.app.model.CollectionItem deleteCollectionItem(
		com.datamusic.app.model.CollectionItem collectionItem) {

		return _collectionItemLocalService.deleteCollectionItem(collectionItem);
	}

	/**
	 * Deletes the collection item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item that was removed
	 * @throws PortalException if a collection item with the primary key could not be found
	 */
	@Override
	public com.datamusic.app.model.CollectionItem deleteCollectionItem(
			long collectionItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionItemLocalService.deleteCollectionItem(
			collectionItemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionItemLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _collectionItemLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _collectionItemLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _collectionItemLocalService.dynamicQuery();
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

		return _collectionItemLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.CollectionItemModelImpl</code>.
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

		return _collectionItemLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.CollectionItemModelImpl</code>.
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

		return _collectionItemLocalService.dynamicQuery(
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

		return _collectionItemLocalService.dynamicQueryCount(dynamicQuery);
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

		return _collectionItemLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.datamusic.app.model.CollectionItem fetchCollectionItem(
		long collectionItemId) {

		return _collectionItemLocalService.fetchCollectionItem(
			collectionItemId);
	}

	/**
	 * Returns the collection item with the matching UUID and company.
	 *
	 * @param uuid the collection item's UUID
	 * @param companyId the primary key of the company
	 * @return the matching collection item, or <code>null</code> if a matching collection item could not be found
	 */
	@Override
	public com.datamusic.app.model.CollectionItem
		fetchCollectionItemByUuidAndCompanyId(String uuid, long companyId) {

		return _collectionItemLocalService.
			fetchCollectionItemByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _collectionItemLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the collection item with the primary key.
	 *
	 * @param collectionItemId the primary key of the collection item
	 * @return the collection item
	 * @throws PortalException if a collection item with the primary key could not be found
	 */
	@Override
	public com.datamusic.app.model.CollectionItem getCollectionItem(
			long collectionItemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionItemLocalService.getCollectionItem(collectionItemId);
	}

	/**
	 * Returns the collection item with the matching UUID and company.
	 *
	 * @param uuid the collection item's UUID
	 * @param companyId the primary key of the company
	 * @return the matching collection item
	 * @throws PortalException if a matching collection item could not be found
	 */
	@Override
	public com.datamusic.app.model.CollectionItem
			getCollectionItemByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionItemLocalService.getCollectionItemByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the collection items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.CollectionItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of collection items
	 * @param end the upper bound of the range of collection items (not inclusive)
	 * @return the range of collection items
	 */
	@Override
	public java.util.List<com.datamusic.app.model.CollectionItem>
		getCollectionItems(int start, int end) {

		return _collectionItemLocalService.getCollectionItems(start, end);
	}

	/**
	 * Returns the number of collection items.
	 *
	 * @return the number of collection items
	 */
	@Override
	public int getCollectionItemsCount() {
		return _collectionItemLocalService.getCollectionItemsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _collectionItemLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _collectionItemLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _collectionItemLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _collectionItemLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the collection item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CollectionItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param collectionItem the collection item
	 * @return the collection item that was updated
	 */
	@Override
	public com.datamusic.app.model.CollectionItem updateCollectionItem(
		com.datamusic.app.model.CollectionItem collectionItem) {

		return _collectionItemLocalService.updateCollectionItem(collectionItem);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _collectionItemLocalService.getBasePersistence();
	}

	@Override
	public CollectionItemLocalService getWrappedService() {
		return _collectionItemLocalService;
	}

	@Override
	public void setWrappedService(
		CollectionItemLocalService collectionItemLocalService) {

		_collectionItemLocalService = collectionItemLocalService;
	}

	private CollectionItemLocalService _collectionItemLocalService;

}