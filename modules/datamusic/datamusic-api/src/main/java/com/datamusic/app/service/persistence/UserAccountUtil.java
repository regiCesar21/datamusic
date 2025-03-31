/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence;

import com.datamusic.app.model.UserAccount;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the user account service. This utility wraps <code>com.datamusic.app.service.persistence.impl.UserAccountPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @see UserAccountPersistence
 * @generated
 */
public class UserAccountUtil {

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
	public static void clearCache(UserAccount userAccount) {
		getPersistence().clearCache(userAccount);
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
	public static Map<Serializable, UserAccount> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserAccount> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserAccount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserAccount> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserAccount update(UserAccount userAccount) {
		return getPersistence().update(userAccount);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserAccount update(
		UserAccount userAccount, ServiceContext serviceContext) {

		return getPersistence().update(userAccount, serviceContext);
	}

	/**
	 * Returns all the user accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user accounts
	 */
	public static List<UserAccount> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of matching user accounts
	 */
	public static List<UserAccount> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUuid_First(
			String uuid, OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUuid_First(
		String uuid, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUuid_Last(
			String uuid, OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUuid_Last(
		String uuid, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where uuid = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount[] findByUuid_PrevAndNext(
			long userAccountId, String uuid,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUuid_PrevAndNext(
			userAccountId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user accounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user accounts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user accounts
	 */
	public static List<UserAccount> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of matching user accounts
	 */
	public static List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount[] findByUuid_C_PrevAndNext(
			long userAccountId, String uuid, long companyId,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUuid_C_PrevAndNext(
			userAccountId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the user accounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user accounts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the user accounts where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @return the matching user accounts
	 */
	public static List<UserAccount> findByUserNameAccount(
		String userNameAccount) {

		return getPersistence().findByUserNameAccount(userNameAccount);
	}

	/**
	 * Returns a range of all the user accounts where userNameAccount = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userNameAccount the user name account
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of matching user accounts
	 */
	public static List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end) {

		return getPersistence().findByUserNameAccount(
			userNameAccount, start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts where userNameAccount = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userNameAccount the user name account
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findByUserNameAccount(
			userNameAccount, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts where userNameAccount = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userNameAccount the user name account
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserNameAccount(
			userNameAccount, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserNameAccount_First(
			String userNameAccount,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserNameAccount_First(
			userNameAccount, orderByComparator);
	}

	/**
	 * Returns the first user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserNameAccount_First(
		String userNameAccount,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserNameAccount_First(
			userNameAccount, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserNameAccount_Last(
			String userNameAccount,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserNameAccount_Last(
			userNameAccount, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserNameAccount_Last(
		String userNameAccount,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserNameAccount_Last(
			userNameAccount, orderByComparator);
	}

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount[] findByUserNameAccount_PrevAndNext(
			long userAccountId, String userNameAccount,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserNameAccount_PrevAndNext(
			userAccountId, userNameAccount, orderByComparator);
	}

	/**
	 * Removes all the user accounts where userNameAccount = &#63; from the database.
	 *
	 * @param userNameAccount the user name account
	 */
	public static void removeByUserNameAccount(String userNameAccount) {
		getPersistence().removeByUserNameAccount(userNameAccount);
	}

	/**
	 * Returns the number of user accounts where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @return the number of matching user accounts
	 */
	public static int countByUserNameAccount(String userNameAccount) {
		return getPersistence().countByUserNameAccount(userNameAccount);
	}

	/**
	 * Returns all the user accounts where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @return the matching user accounts
	 */
	public static List<UserAccount> findByUserAccountId(long userAccountId) {
		return getPersistence().findByUserAccountId(userAccountId);
	}

	/**
	 * Returns a range of all the user accounts where userAccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userAccountId the user account ID
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of matching user accounts
	 */
	public static List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end) {

		return getPersistence().findByUserAccountId(userAccountId, start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts where userAccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userAccountId the user account ID
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findByUserAccountId(
			userAccountId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts where userAccountId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userAccountId the user account ID
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserAccountId(
			userAccountId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserAccountId_First(
			long userAccountId,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserAccountId_First(
			userAccountId, orderByComparator);
	}

	/**
	 * Returns the first user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserAccountId_First(
		long userAccountId, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserAccountId_First(
			userAccountId, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserAccountId_Last(
			long userAccountId,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserAccountId_Last(
			userAccountId, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserAccountId_Last(
		long userAccountId, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserAccountId_Last(
			userAccountId, orderByComparator);
	}

	/**
	 * Removes all the user accounts where userAccountId = &#63; from the database.
	 *
	 * @param userAccountId the user account ID
	 */
	public static void removeByUserAccountId(long userAccountId) {
		getPersistence().removeByUserAccountId(userAccountId);
	}

	/**
	 * Returns the number of user accounts where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @return the number of matching user accounts
	 */
	public static int countByUserAccountId(long userAccountId) {
		return getPersistence().countByUserAccountId(userAccountId);
	}

	/**
	 * Returns all the user accounts where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @return the matching user accounts
	 */
	public static List<UserAccount> findByUserFirstName(String userFirstName) {
		return getPersistence().findByUserFirstName(userFirstName);
	}

	/**
	 * Returns a range of all the user accounts where userFirstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userFirstName the user first name
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of matching user accounts
	 */
	public static List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end) {

		return getPersistence().findByUserFirstName(userFirstName, start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts where userFirstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userFirstName the user first name
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findByUserFirstName(
			userFirstName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts where userFirstName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userFirstName the user first name
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserFirstName(
			userFirstName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserFirstName_First(
			String userFirstName,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserFirstName_First(
			userFirstName, orderByComparator);
	}

	/**
	 * Returns the first user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserFirstName_First(
		String userFirstName,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserFirstName_First(
			userFirstName, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserFirstName_Last(
			String userFirstName,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserFirstName_Last(
			userFirstName, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserFirstName_Last(
		String userFirstName,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserFirstName_Last(
			userFirstName, orderByComparator);
	}

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount[] findByUserFirstName_PrevAndNext(
			long userAccountId, String userFirstName,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserFirstName_PrevAndNext(
			userAccountId, userFirstName, orderByComparator);
	}

	/**
	 * Removes all the user accounts where userFirstName = &#63; from the database.
	 *
	 * @param userFirstName the user first name
	 */
	public static void removeByUserFirstName(String userFirstName) {
		getPersistence().removeByUserFirstName(userFirstName);
	}

	/**
	 * Returns the number of user accounts where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @return the number of matching user accounts
	 */
	public static int countByUserFirstName(String userFirstName) {
		return getPersistence().countByUserFirstName(userFirstName);
	}

	/**
	 * Returns all the user accounts where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @return the matching user accounts
	 */
	public static List<UserAccount> findByUserLastName(String userLastName) {
		return getPersistence().findByUserLastName(userLastName);
	}

	/**
	 * Returns a range of all the user accounts where userLastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userLastName the user last name
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of matching user accounts
	 */
	public static List<UserAccount> findByUserLastName(
		String userLastName, int start, int end) {

		return getPersistence().findByUserLastName(userLastName, start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts where userLastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userLastName the user last name
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserLastName(
		String userLastName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findByUserLastName(
			userLastName, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts where userLastName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param userLastName the user last name
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user accounts
	 */
	public static List<UserAccount> findByUserLastName(
		String userLastName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserLastName(
			userLastName, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserLastName_First(
			String userLastName,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserLastName_First(
			userLastName, orderByComparator);
	}

	/**
	 * Returns the first user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserLastName_First(
		String userLastName, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserLastName_First(
			userLastName, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public static UserAccount findByUserLastName_Last(
			String userLastName,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserLastName_Last(
			userLastName, orderByComparator);
	}

	/**
	 * Returns the last user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public static UserAccount fetchByUserLastName_Last(
		String userLastName, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().fetchByUserLastName_Last(
			userLastName, orderByComparator);
	}

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount[] findByUserLastName_PrevAndNext(
			long userAccountId, String userLastName,
			OrderByComparator<UserAccount> orderByComparator)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByUserLastName_PrevAndNext(
			userAccountId, userLastName, orderByComparator);
	}

	/**
	 * Removes all the user accounts where userLastName = &#63; from the database.
	 *
	 * @param userLastName the user last name
	 */
	public static void removeByUserLastName(String userLastName) {
		getPersistence().removeByUserLastName(userLastName);
	}

	/**
	 * Returns the number of user accounts where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @return the number of matching user accounts
	 */
	public static int countByUserLastName(String userLastName) {
		return getPersistence().countByUserLastName(userLastName);
	}

	/**
	 * Caches the user account in the entity cache if it is enabled.
	 *
	 * @param userAccount the user account
	 */
	public static void cacheResult(UserAccount userAccount) {
		getPersistence().cacheResult(userAccount);
	}

	/**
	 * Caches the user accounts in the entity cache if it is enabled.
	 *
	 * @param userAccounts the user accounts
	 */
	public static void cacheResult(List<UserAccount> userAccounts) {
		getPersistence().cacheResult(userAccounts);
	}

	/**
	 * Creates a new user account with the primary key. Does not add the user account to the database.
	 *
	 * @param userAccountId the primary key for the new user account
	 * @return the new user account
	 */
	public static UserAccount create(long userAccountId) {
		return getPersistence().create(userAccountId);
	}

	/**
	 * Removes the user account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account that was removed
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount remove(long userAccountId)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().remove(userAccountId);
	}

	public static UserAccount updateImpl(UserAccount userAccount) {
		return getPersistence().updateImpl(userAccount);
	}

	/**
	 * Returns the user account with the primary key or throws a <code>NoSuchUserAccountException</code> if it could not be found.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public static UserAccount findByPrimaryKey(long userAccountId)
		throws com.datamusic.app.exception.NoSuchUserAccountException {

		return getPersistence().findByPrimaryKey(userAccountId);
	}

	/**
	 * Returns the user account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account, or <code>null</code> if a user account with the primary key could not be found
	 */
	public static UserAccount fetchByPrimaryKey(long userAccountId) {
		return getPersistence().fetchByPrimaryKey(userAccountId);
	}

	/**
	 * Returns all the user accounts.
	 *
	 * @return the user accounts
	 */
	public static List<UserAccount> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @return the range of user accounts
	 */
	public static List<UserAccount> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user accounts
	 */
	public static List<UserAccount> findAll(
		int start, int end, OrderByComparator<UserAccount> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user accounts
	 * @param end the upper bound of the range of user accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user accounts
	 */
	public static List<UserAccount> findAll(
		int start, int end, OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user accounts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user accounts.
	 *
	 * @return the number of user accounts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserAccountPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(UserAccountPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile UserAccountPersistence _persistence;

}