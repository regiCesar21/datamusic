/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.datamusic.app.model.UserAccount;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for UserAccount. This utility wraps
 * <code>com.datamusic.app.service.impl.UserAccountLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Regisson Aguiar
 * @see UserAccountLocalService
 * @generated
 */
public class UserAccountLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.datamusic.app.service.impl.UserAccountLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static UserAccount addUserAccount(UserAccount userAccount) {
		return getService().addUserAccount(userAccount);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user account with the primary key. Does not add the user account to the database.
	 *
	 * @param userAccountId the primary key for the new user account
	 * @return the new user account
	 */
	public static UserAccount createUserAccount(long userAccountId) {
		return getService().createUserAccount(userAccountId);
	}

	public static UserAccount createUserAccount(String userNameAccount) {
		return getService().createUserAccount(userNameAccount);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static UserAccount deleteUserAccount(long userAccountId)
		throws PortalException {

		return getService().deleteUserAccount(userAccountId);
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
	public static UserAccount deleteUserAccount(UserAccount userAccount) {
		return getService().deleteUserAccount(userAccount);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static UserAccount fetchUserAccount(long userAccountId) {
		return getService().fetchUserAccount(userAccountId);
	}

	/**
	 * Returns the user account with the matching UUID and company.
	 *
	 * @param uuid the user account's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchUserAccountByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().fetchUserAccountByUuidAndCompanyId(uuid, companyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user account with the primary key.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account
	 * @throws PortalException if a user account with the primary key could not be found
	 */
	public static UserAccount getUserAccount(long userAccountId)
		throws PortalException {

		return getService().getUserAccount(userAccountId);
	}

	/**
	 * Returns the user account with the matching UUID and company.
	 *
	 * @param uuid the user account's UUID
	 * @param companyId the primary key of the company
	 * @return the matching user account
	 * @throws PortalException if a matching user account could not be found
	 */
	public static UserAccount getUserAccountByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException {

		return getService().getUserAccountByUuidAndCompanyId(uuid, companyId);
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
	public static List<UserAccount> getUserAccounts(int start, int end) {
		return getService().getUserAccounts(start, end);
	}

	/**
	 * Returns the number of user accounts.
	 *
	 * @return the number of user accounts
	 */
	public static int getUserAccountsCount() {
		return getService().getUserAccountsCount();
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
	public static UserAccount updateUserAccount(UserAccount userAccount) {
		return getService().updateUserAccount(userAccount);
	}

	public static UserAccountLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<UserAccountLocalService> _serviceSnapshot =
		new Snapshot<>(
			UserAccountLocalServiceUtil.class, UserAccountLocalService.class);

}