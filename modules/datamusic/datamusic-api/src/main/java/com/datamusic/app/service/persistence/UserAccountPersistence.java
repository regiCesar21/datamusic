/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence;

import com.datamusic.app.exception.NoSuchUserAccountException;
import com.datamusic.app.model.UserAccount;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the user account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @see UserAccountUtil
 * @generated
 */
@ProviderType
public interface UserAccountPersistence extends BasePersistence<UserAccount> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserAccountUtil} to access the user account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user accounts
	 */
	public java.util.List<UserAccount> findByUuid(String uuid);

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
	public java.util.List<UserAccount> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<UserAccount> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the first user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the last user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the last user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where uuid = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public UserAccount[] findByUuid_PrevAndNext(
			long userAccountId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Removes all the user accounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user accounts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user accounts
	 */
	public java.util.List<UserAccount> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the first user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the last user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the last user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public UserAccount[] findByUuid_C_PrevAndNext(
			long userAccountId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Removes all the user accounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user accounts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the user accounts where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @return the matching user accounts
	 */
	public java.util.List<UserAccount> findByUserNameAccount(
		String userNameAccount);

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
	public java.util.List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end);

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
	public java.util.List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserNameAccount_First(
			String userNameAccount,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the first user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserNameAccount_First(
		String userNameAccount,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the last user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserNameAccount_Last(
			String userNameAccount,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the last user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserNameAccount_Last(
		String userNameAccount,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public UserAccount[] findByUserNameAccount_PrevAndNext(
			long userAccountId, String userNameAccount,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Removes all the user accounts where userNameAccount = &#63; from the database.
	 *
	 * @param userNameAccount the user name account
	 */
	public void removeByUserNameAccount(String userNameAccount);

	/**
	 * Returns the number of user accounts where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @return the number of matching user accounts
	 */
	public int countByUserNameAccount(String userNameAccount);

	/**
	 * Returns all the user accounts where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @return the matching user accounts
	 */
	public java.util.List<UserAccount> findByUserAccountId(long userAccountId);

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
	public java.util.List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end);

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
	public java.util.List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserAccountId_First(
			long userAccountId,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the first user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserAccountId_First(
		long userAccountId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the last user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserAccountId_Last(
			long userAccountId,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the last user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserAccountId_Last(
		long userAccountId,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Removes all the user accounts where userAccountId = &#63; from the database.
	 *
	 * @param userAccountId the user account ID
	 */
	public void removeByUserAccountId(long userAccountId);

	/**
	 * Returns the number of user accounts where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @return the number of matching user accounts
	 */
	public int countByUserAccountId(long userAccountId);

	/**
	 * Returns all the user accounts where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @return the matching user accounts
	 */
	public java.util.List<UserAccount> findByUserFirstName(
		String userFirstName);

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
	public java.util.List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end);

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
	public java.util.List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserFirstName_First(
			String userFirstName,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the first user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserFirstName_First(
		String userFirstName,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the last user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserFirstName_Last(
			String userFirstName,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the last user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserFirstName_Last(
		String userFirstName,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public UserAccount[] findByUserFirstName_PrevAndNext(
			long userAccountId, String userFirstName,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Removes all the user accounts where userFirstName = &#63; from the database.
	 *
	 * @param userFirstName the user first name
	 */
	public void removeByUserFirstName(String userFirstName);

	/**
	 * Returns the number of user accounts where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @return the number of matching user accounts
	 */
	public int countByUserFirstName(String userFirstName);

	/**
	 * Returns all the user accounts where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @return the matching user accounts
	 */
	public java.util.List<UserAccount> findByUserLastName(String userLastName);

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
	public java.util.List<UserAccount> findByUserLastName(
		String userLastName, int start, int end);

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
	public java.util.List<UserAccount> findByUserLastName(
		String userLastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findByUserLastName(
		String userLastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserLastName_First(
			String userLastName,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the first user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserLastName_First(
		String userLastName,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the last user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	public UserAccount findByUserLastName_Last(
			String userLastName,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Returns the last user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	public UserAccount fetchByUserLastName_Last(
		String userLastName,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

	/**
	 * Returns the user accounts before and after the current user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userAccountId the primary key of the current user account
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public UserAccount[] findByUserLastName_PrevAndNext(
			long userAccountId, String userLastName,
			com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
				orderByComparator)
		throws NoSuchUserAccountException;

	/**
	 * Removes all the user accounts where userLastName = &#63; from the database.
	 *
	 * @param userLastName the user last name
	 */
	public void removeByUserLastName(String userLastName);

	/**
	 * Returns the number of user accounts where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @return the number of matching user accounts
	 */
	public int countByUserLastName(String userLastName);

	/**
	 * Caches the user account in the entity cache if it is enabled.
	 *
	 * @param userAccount the user account
	 */
	public void cacheResult(UserAccount userAccount);

	/**
	 * Caches the user accounts in the entity cache if it is enabled.
	 *
	 * @param userAccounts the user accounts
	 */
	public void cacheResult(java.util.List<UserAccount> userAccounts);

	/**
	 * Creates a new user account with the primary key. Does not add the user account to the database.
	 *
	 * @param userAccountId the primary key for the new user account
	 * @return the new user account
	 */
	public UserAccount create(long userAccountId);

	/**
	 * Removes the user account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account that was removed
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public UserAccount remove(long userAccountId)
		throws NoSuchUserAccountException;

	public UserAccount updateImpl(UserAccount userAccount);

	/**
	 * Returns the user account with the primary key or throws a <code>NoSuchUserAccountException</code> if it could not be found.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	public UserAccount findByPrimaryKey(long userAccountId)
		throws NoSuchUserAccountException;

	/**
	 * Returns the user account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account, or <code>null</code> if a user account with the primary key could not be found
	 */
	public UserAccount fetchByPrimaryKey(long userAccountId);

	/**
	 * Returns all the user accounts.
	 *
	 * @return the user accounts
	 */
	public java.util.List<UserAccount> findAll();

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
	public java.util.List<UserAccount> findAll(int start, int end);

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
	public java.util.List<UserAccount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator);

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
	public java.util.List<UserAccount> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserAccount>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user accounts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user accounts.
	 *
	 * @return the number of user accounts
	 */
	public int countAll();

}