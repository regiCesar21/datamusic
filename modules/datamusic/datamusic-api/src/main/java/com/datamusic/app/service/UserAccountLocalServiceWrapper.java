/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link UserAccountLocalService}.
 *
 * @author Regisson Aguiar
 * @see UserAccountLocalService
 * @generated
 */
public class UserAccountLocalServiceWrapper
	implements ServiceWrapper<UserAccountLocalService>,
			   UserAccountLocalService {

	public UserAccountLocalServiceWrapper() {
		this(null);
	}

	public UserAccountLocalServiceWrapper(
		UserAccountLocalService userAccountLocalService) {

		_userAccountLocalService = userAccountLocalService;
	}

	/**
	 * Adds the user account to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userAccount the user account
	 * @return the user account that was added
	 */
	@Override
	public com.datamusic.app.model.UserAccount addUserAccount(
		com.datamusic.app.model.UserAccount userAccount) {

		return _userAccountLocalService.addUserAccount(userAccount);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAccountLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user account with the primary key. Does not add the user account to the database.
	 *
	 * @param userAccountId the primary key for the new user account
	 * @return the new user account
	 */
	@Override
	public com.datamusic.app.model.UserAccount createUserAccount(
		long userAccountId) {

		return _userAccountLocalService.createUserAccount(userAccountId);
	}

	@Override
	public com.datamusic.app.model.UserAccount createUserAccount(
		String userNameAccount) {

		return _userAccountLocalService.createUserAccount(userNameAccount);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAccountLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account that was removed
	 * @throws PortalException if a user account with the primary key could not be found
	 */
	@Override
	public com.datamusic.app.model.UserAccount deleteUserAccount(
			long userAccountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAccountLocalService.deleteUserAccount(userAccountId);
	}

	/**
	 * Deletes the user account from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userAccount the user account
	 * @return the user account that was removed
	 */
	@Override
	public com.datamusic.app.model.UserAccount deleteUserAccount(
		com.datamusic.app.model.UserAccount userAccount) {

		return _userAccountLocalService.deleteUserAccount(userAccount);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userAccountLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userAccountLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userAccountLocalService.dynamicQuery();
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

		return _userAccountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.UserAccountModelImpl</code>.
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

		return _userAccountLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.UserAccountModelImpl</code>.
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

		return _userAccountLocalService.dynamicQuery(
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

		return _userAccountLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userAccountLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.datamusic.app.model.UserAccount fetchUserAccount(
		long userAccountId) {

		return _userAccountLocalService.fetchUserAccount(userAccountId);
	}

	/**
	 * Returns the user account with the matching UUID and company.
	 *
	 * @param uuid the user account's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public com.datamusic.app.model.UserAccount
		fetchUserAccountByUuidAndCompanyId(String uuid, long companyId) {

		return _userAccountLocalService.fetchUserAccountByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userAccountLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userAccountLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userAccountLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userAccountLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAccountLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user account with the primary key.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account
	 * @throws PortalException if a user account with the primary key could not be found
	 */
	@Override
	public com.datamusic.app.model.UserAccount getUserAccount(
			long userAccountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAccountLocalService.getUserAccount(userAccountId);
	}

	/**
	 * Returns the user account with the matching UUID and company.
	 *
	 * @param uuid the user account's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user account
	 * @throws PortalException if a matching user account could not be found
	 */
	@Override
	public com.datamusic.app.model.UserAccount getUserAccountByUuidAndCompanyId(
			String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAccountLocalService.getUserAccountByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the user accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.datamusic.app.model.impl.UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of user accounts
	 */
	@Override
	public java.util.List<com.datamusic.app.model.UserAccount> getUserAccounts(
		int start, int end) {

		return _userAccountLocalService.getUserAccounts(start, end);
	}

	/**
	 * Returns the number of user accounts.
	 *
	 * @return the number of user accounts
	 */
	@Override
	public int getUserAccountsCount() {
		return _userAccountLocalService.getUserAccountsCount();
	}

	/**
	 * Updates the user account in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAccountLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userAccount the user account
	 * @return the user account that was updated
	 */
	@Override
	public com.datamusic.app.model.UserAccount updateUserAccount(
		com.datamusic.app.model.UserAccount userAccount) {

		return _userAccountLocalService.updateUserAccount(userAccount);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _userAccountLocalService.getBasePersistence();
	}

	@Override
	public UserAccountLocalService getWrappedService() {
		return _userAccountLocalService;
	}

	@Override
	public void setWrappedService(
		UserAccountLocalService userAccountLocalService) {

		_userAccountLocalService = userAccountLocalService;
	}

	private UserAccountLocalService _userAccountLocalService;

}