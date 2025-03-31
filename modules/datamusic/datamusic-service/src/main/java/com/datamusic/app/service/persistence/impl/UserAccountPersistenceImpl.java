/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.impl;

import com.datamusic.app.exception.NoSuchUserAccountException;
import com.datamusic.app.model.UserAccount;
import com.datamusic.app.model.UserAccountTable;
import com.datamusic.app.model.impl.UserAccountImpl;
import com.datamusic.app.model.impl.UserAccountModelImpl;
import com.datamusic.app.service.persistence.UserAccountPersistence;
import com.datamusic.app.service.persistence.UserAccountUtil;
import com.datamusic.app.service.persistence.impl.constants.datamusicPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Regisson Aguiar
 * @generated
 */
@Component(service = UserAccountPersistence.class)
public class UserAccountPersistenceImpl
	extends BasePersistenceImpl<UserAccount> implements UserAccountPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserAccountUtil</code> to access the user account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserAccountImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the user accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user accounts
	 */
	@Override
	public List<UserAccount> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccount userAccount : list) {
					if (!uuid.equals(userAccount.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUuid_First(
			String uuid, OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUuid_First(uuid, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUuid_First(
		String uuid, OrderByComparator<UserAccount> orderByComparator) {

		List<UserAccount> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUuid_Last(
			String uuid, OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUuid_Last(uuid, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUuid_Last(
		String uuid, OrderByComparator<UserAccount> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserAccount> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserAccount[] findByUuid_PrevAndNext(
			long userAccountId, String uuid,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		uuid = Objects.toString(uuid, "");

		UserAccount userAccount = findByPrimaryKey(userAccountId);

		Session session = null;

		try {
			session = openSession();

			UserAccount[] array = new UserAccountImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userAccount, uuid, orderByComparator, true);

			array[1] = userAccount;

			array[2] = getByUuid_PrevAndNext(
				session, userAccount, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccount getByUuid_PrevAndNext(
		Session session, UserAccount userAccount, String uuid,
		OrderByComparator<UserAccount> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user accounts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserAccount userAccount :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user accounts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERACCOUNT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"userAccount.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userAccount.uuid IS NULL OR userAccount.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user accounts
	 */
	@Override
	public List<UserAccount> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccount userAccount : list) {
					if (!uuid.equals(userAccount.getUuid()) ||
						(companyId != userAccount.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public UserAccount findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the first user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserAccount> orderByComparator) {

		List<UserAccount> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserAccount findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the last user account in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserAccount> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserAccount> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserAccount[] findByUuid_C_PrevAndNext(
			long userAccountId, String uuid, long companyId,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		uuid = Objects.toString(uuid, "");

		UserAccount userAccount = findByPrimaryKey(userAccountId);

		Session session = null;

		try {
			session = openSession();

			UserAccount[] array = new UserAccountImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, userAccount, uuid, companyId, orderByComparator, true);

			array[1] = userAccount;

			array[2] = getByUuid_C_PrevAndNext(
				session, userAccount, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccount getByUuid_C_PrevAndNext(
		Session session, UserAccount userAccount, String uuid, long companyId,
		OrderByComparator<UserAccount> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user accounts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserAccount userAccount :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user accounts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_USERACCOUNT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"userAccount.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(userAccount.uuid IS NULL OR userAccount.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"userAccount.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByUserNameAccount;
	private FinderPath _finderPathWithoutPaginationFindByUserNameAccount;
	private FinderPath _finderPathCountByUserNameAccount;

	/**
	 * Returns all the user accounts where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @return the matching user accounts
	 */
	@Override
	public List<UserAccount> findByUserNameAccount(String userNameAccount) {
		return findByUserNameAccount(
			userNameAccount, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end) {

		return findByUserNameAccount(userNameAccount, start, end, null);
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
	@Override
	public List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return findByUserNameAccount(
			userNameAccount, start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findByUserNameAccount(
		String userNameAccount, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		userNameAccount = Objects.toString(userNameAccount, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserNameAccount;
				finderArgs = new Object[] {userNameAccount};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserNameAccount;
			finderArgs = new Object[] {
				userNameAccount, start, end, orderByComparator
			};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccount userAccount : list) {
					if (!userNameAccount.equals(
							userAccount.getUserNameAccount())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

			boolean bindUserNameAccount = false;

			if (userNameAccount.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_3);
			}
			else {
				bindUserNameAccount = true;

				sb.append(_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserNameAccount) {
					queryPos.add(userNameAccount);
				}

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserNameAccount_First(
			String userNameAccount,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserNameAccount_First(
			userNameAccount, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userNameAccount=");
		sb.append(userNameAccount);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the first user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserNameAccount_First(
		String userNameAccount,
		OrderByComparator<UserAccount> orderByComparator) {

		List<UserAccount> list = findByUserNameAccount(
			userNameAccount, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserNameAccount_Last(
			String userNameAccount,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserNameAccount_Last(
			userNameAccount, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userNameAccount=");
		sb.append(userNameAccount);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the last user account in the ordered set where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserNameAccount_Last(
		String userNameAccount,
		OrderByComparator<UserAccount> orderByComparator) {

		int count = countByUserNameAccount(userNameAccount);

		if (count == 0) {
			return null;
		}

		List<UserAccount> list = findByUserNameAccount(
			userNameAccount, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserAccount[] findByUserNameAccount_PrevAndNext(
			long userAccountId, String userNameAccount,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		userNameAccount = Objects.toString(userNameAccount, "");

		UserAccount userAccount = findByPrimaryKey(userAccountId);

		Session session = null;

		try {
			session = openSession();

			UserAccount[] array = new UserAccountImpl[3];

			array[0] = getByUserNameAccount_PrevAndNext(
				session, userAccount, userNameAccount, orderByComparator, true);

			array[1] = userAccount;

			array[2] = getByUserNameAccount_PrevAndNext(
				session, userAccount, userNameAccount, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccount getByUserNameAccount_PrevAndNext(
		Session session, UserAccount userAccount, String userNameAccount,
		OrderByComparator<UserAccount> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

		boolean bindUserNameAccount = false;

		if (userNameAccount.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_3);
		}
		else {
			bindUserNameAccount = true;

			sb.append(_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUserNameAccount) {
			queryPos.add(userNameAccount);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user accounts where userNameAccount = &#63; from the database.
	 *
	 * @param userNameAccount the user name account
	 */
	@Override
	public void removeByUserNameAccount(String userNameAccount) {
		for (UserAccount userAccount :
				findByUserNameAccount(
					userNameAccount, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts where userNameAccount = &#63;.
	 *
	 * @param userNameAccount the user name account
	 * @return the number of matching user accounts
	 */
	@Override
	public int countByUserNameAccount(String userNameAccount) {
		userNameAccount = Objects.toString(userNameAccount, "");

		FinderPath finderPath = _finderPathCountByUserNameAccount;

		Object[] finderArgs = new Object[] {userNameAccount};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERACCOUNT_WHERE);

			boolean bindUserNameAccount = false;

			if (userNameAccount.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_3);
			}
			else {
				bindUserNameAccount = true;

				sb.append(_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserNameAccount) {
					queryPos.add(userNameAccount);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_2 =
			"userAccount.userNameAccount = ?";

	private static final String
		_FINDER_COLUMN_USERNAMEACCOUNT_USERNAMEACCOUNT_3 =
			"(userAccount.userNameAccount IS NULL OR userAccount.userNameAccount = '')";

	private FinderPath _finderPathWithPaginationFindByUserAccountId;
	private FinderPath _finderPathWithoutPaginationFindByUserAccountId;
	private FinderPath _finderPathCountByUserAccountId;

	/**
	 * Returns all the user accounts where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @return the matching user accounts
	 */
	@Override
	public List<UserAccount> findByUserAccountId(long userAccountId) {
		return findByUserAccountId(
			userAccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end) {

		return findByUserAccountId(userAccountId, start, end, null);
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
	@Override
	public List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return findByUserAccountId(
			userAccountId, start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findByUserAccountId(
		long userAccountId, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserAccountId;
				finderArgs = new Object[] {userAccountId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserAccountId;
			finderArgs = new Object[] {
				userAccountId, start, end, orderByComparator
			};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccount userAccount : list) {
					if (userAccountId != userAccount.getUserAccountId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

			sb.append(_FINDER_COLUMN_USERACCOUNTID_USERACCOUNTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userAccountId);

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserAccountId_First(
			long userAccountId,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserAccountId_First(
			userAccountId, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userAccountId=");
		sb.append(userAccountId);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the first user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserAccountId_First(
		long userAccountId, OrderByComparator<UserAccount> orderByComparator) {

		List<UserAccount> list = findByUserAccountId(
			userAccountId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserAccountId_Last(
			long userAccountId,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserAccountId_Last(
			userAccountId, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userAccountId=");
		sb.append(userAccountId);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the last user account in the ordered set where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserAccountId_Last(
		long userAccountId, OrderByComparator<UserAccount> orderByComparator) {

		int count = countByUserAccountId(userAccountId);

		if (count == 0) {
			return null;
		}

		List<UserAccount> list = findByUserAccountId(
			userAccountId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the user accounts where userAccountId = &#63; from the database.
	 *
	 * @param userAccountId the user account ID
	 */
	@Override
	public void removeByUserAccountId(long userAccountId) {
		for (UserAccount userAccount :
				findByUserAccountId(
					userAccountId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts where userAccountId = &#63;.
	 *
	 * @param userAccountId the user account ID
	 * @return the number of matching user accounts
	 */
	@Override
	public int countByUserAccountId(long userAccountId) {
		FinderPath finderPath = _finderPathCountByUserAccountId;

		Object[] finderArgs = new Object[] {userAccountId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERACCOUNT_WHERE);

			sb.append(_FINDER_COLUMN_USERACCOUNTID_USERACCOUNTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userAccountId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERACCOUNTID_USERACCOUNTID_2 =
		"userAccount.userAccountId = ?";

	private FinderPath _finderPathWithPaginationFindByUserFirstName;
	private FinderPath _finderPathWithoutPaginationFindByUserFirstName;
	private FinderPath _finderPathCountByUserFirstName;

	/**
	 * Returns all the user accounts where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @return the matching user accounts
	 */
	@Override
	public List<UserAccount> findByUserFirstName(String userFirstName) {
		return findByUserFirstName(
			userFirstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end) {

		return findByUserFirstName(userFirstName, start, end, null);
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
	@Override
	public List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return findByUserFirstName(
			userFirstName, start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findByUserFirstName(
		String userFirstName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		userFirstName = Objects.toString(userFirstName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserFirstName;
				finderArgs = new Object[] {userFirstName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserFirstName;
			finderArgs = new Object[] {
				userFirstName, start, end, orderByComparator
			};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccount userAccount : list) {
					if (!userFirstName.equals(userAccount.getUserFirstName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

			boolean bindUserFirstName = false;

			if (userFirstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_3);
			}
			else {
				bindUserFirstName = true;

				sb.append(_FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserFirstName) {
					queryPos.add(userFirstName);
				}

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserFirstName_First(
			String userFirstName,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserFirstName_First(
			userFirstName, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userFirstName=");
		sb.append(userFirstName);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the first user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserFirstName_First(
		String userFirstName,
		OrderByComparator<UserAccount> orderByComparator) {

		List<UserAccount> list = findByUserFirstName(
			userFirstName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserFirstName_Last(
			String userFirstName,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserFirstName_Last(
			userFirstName, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userFirstName=");
		sb.append(userFirstName);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the last user account in the ordered set where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserFirstName_Last(
		String userFirstName,
		OrderByComparator<UserAccount> orderByComparator) {

		int count = countByUserFirstName(userFirstName);

		if (count == 0) {
			return null;
		}

		List<UserAccount> list = findByUserFirstName(
			userFirstName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserAccount[] findByUserFirstName_PrevAndNext(
			long userAccountId, String userFirstName,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		userFirstName = Objects.toString(userFirstName, "");

		UserAccount userAccount = findByPrimaryKey(userAccountId);

		Session session = null;

		try {
			session = openSession();

			UserAccount[] array = new UserAccountImpl[3];

			array[0] = getByUserFirstName_PrevAndNext(
				session, userAccount, userFirstName, orderByComparator, true);

			array[1] = userAccount;

			array[2] = getByUserFirstName_PrevAndNext(
				session, userAccount, userFirstName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccount getByUserFirstName_PrevAndNext(
		Session session, UserAccount userAccount, String userFirstName,
		OrderByComparator<UserAccount> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

		boolean bindUserFirstName = false;

		if (userFirstName.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_3);
		}
		else {
			bindUserFirstName = true;

			sb.append(_FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUserFirstName) {
			queryPos.add(userFirstName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user accounts where userFirstName = &#63; from the database.
	 *
	 * @param userFirstName the user first name
	 */
	@Override
	public void removeByUserFirstName(String userFirstName) {
		for (UserAccount userAccount :
				findByUserFirstName(
					userFirstName, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts where userFirstName = &#63;.
	 *
	 * @param userFirstName the user first name
	 * @return the number of matching user accounts
	 */
	@Override
	public int countByUserFirstName(String userFirstName) {
		userFirstName = Objects.toString(userFirstName, "");

		FinderPath finderPath = _finderPathCountByUserFirstName;

		Object[] finderArgs = new Object[] {userFirstName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERACCOUNT_WHERE);

			boolean bindUserFirstName = false;

			if (userFirstName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_3);
			}
			else {
				bindUserFirstName = true;

				sb.append(_FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserFirstName) {
					queryPos.add(userFirstName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_2 =
		"userAccount.userFirstName = ?";

	private static final String _FINDER_COLUMN_USERFIRSTNAME_USERFIRSTNAME_3 =
		"(userAccount.userFirstName IS NULL OR userAccount.userFirstName = '')";

	private FinderPath _finderPathWithPaginationFindByUserLastName;
	private FinderPath _finderPathWithoutPaginationFindByUserLastName;
	private FinderPath _finderPathCountByUserLastName;

	/**
	 * Returns all the user accounts where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @return the matching user accounts
	 */
	@Override
	public List<UserAccount> findByUserLastName(String userLastName) {
		return findByUserLastName(
			userLastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findByUserLastName(
		String userLastName, int start, int end) {

		return findByUserLastName(userLastName, start, end, null);
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
	@Override
	public List<UserAccount> findByUserLastName(
		String userLastName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator) {

		return findByUserLastName(
			userLastName, start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findByUserLastName(
		String userLastName, int start, int end,
		OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		userLastName = Objects.toString(userLastName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserLastName;
				finderArgs = new Object[] {userLastName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserLastName;
			finderArgs = new Object[] {
				userLastName, start, end, orderByComparator
			};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserAccount userAccount : list) {
					if (!userLastName.equals(userAccount.getUserLastName())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

			boolean bindUserLastName = false;

			if (userLastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERLASTNAME_USERLASTNAME_3);
			}
			else {
				bindUserLastName = true;

				sb.append(_FINDER_COLUMN_USERLASTNAME_USERLASTNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserLastName) {
					queryPos.add(userLastName);
				}

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserLastName_First(
			String userLastName,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserLastName_First(
			userLastName, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userLastName=");
		sb.append(userLastName);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the first user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserLastName_First(
		String userLastName, OrderByComparator<UserAccount> orderByComparator) {

		List<UserAccount> list = findByUserLastName(
			userLastName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account
	 * @throws NoSuchUserAccountException if a matching user account could not be found
	 */
	@Override
	public UserAccount findByUserLastName_Last(
			String userLastName,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByUserLastName_Last(
			userLastName, orderByComparator);

		if (userAccount != null) {
			return userAccount;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userLastName=");
		sb.append(userLastName);

		sb.append("}");

		throw new NoSuchUserAccountException(sb.toString());
	}

	/**
	 * Returns the last user account in the ordered set where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user account, or <code>null</code> if a matching user account could not be found
	 */
	@Override
	public UserAccount fetchByUserLastName_Last(
		String userLastName, OrderByComparator<UserAccount> orderByComparator) {

		int count = countByUserLastName(userLastName);

		if (count == 0) {
			return null;
		}

		List<UserAccount> list = findByUserLastName(
			userLastName, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserAccount[] findByUserLastName_PrevAndNext(
			long userAccountId, String userLastName,
			OrderByComparator<UserAccount> orderByComparator)
		throws NoSuchUserAccountException {

		userLastName = Objects.toString(userLastName, "");

		UserAccount userAccount = findByPrimaryKey(userAccountId);

		Session session = null;

		try {
			session = openSession();

			UserAccount[] array = new UserAccountImpl[3];

			array[0] = getByUserLastName_PrevAndNext(
				session, userAccount, userLastName, orderByComparator, true);

			array[1] = userAccount;

			array[2] = getByUserLastName_PrevAndNext(
				session, userAccount, userLastName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserAccount getByUserLastName_PrevAndNext(
		Session session, UserAccount userAccount, String userLastName,
		OrderByComparator<UserAccount> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERACCOUNT_WHERE);

		boolean bindUserLastName = false;

		if (userLastName.isEmpty()) {
			sb.append(_FINDER_COLUMN_USERLASTNAME_USERLASTNAME_3);
		}
		else {
			bindUserLastName = true;

			sb.append(_FINDER_COLUMN_USERLASTNAME_USERLASTNAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserAccountModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUserLastName) {
			queryPos.add(userLastName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userAccount)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserAccount> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user accounts where userLastName = &#63; from the database.
	 *
	 * @param userLastName the user last name
	 */
	@Override
	public void removeByUserLastName(String userLastName) {
		for (UserAccount userAccount :
				findByUserLastName(
					userLastName, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts where userLastName = &#63;.
	 *
	 * @param userLastName the user last name
	 * @return the number of matching user accounts
	 */
	@Override
	public int countByUserLastName(String userLastName) {
		userLastName = Objects.toString(userLastName, "");

		FinderPath finderPath = _finderPathCountByUserLastName;

		Object[] finderArgs = new Object[] {userLastName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERACCOUNT_WHERE);

			boolean bindUserLastName = false;

			if (userLastName.isEmpty()) {
				sb.append(_FINDER_COLUMN_USERLASTNAME_USERLASTNAME_3);
			}
			else {
				bindUserLastName = true;

				sb.append(_FINDER_COLUMN_USERLASTNAME_USERLASTNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUserLastName) {
					queryPos.add(userLastName);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERLASTNAME_USERLASTNAME_2 =
		"userAccount.userLastName = ?";

	private static final String _FINDER_COLUMN_USERLASTNAME_USERLASTNAME_3 =
		"(userAccount.userLastName IS NULL OR userAccount.userLastName = '')";

	public UserAccountPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserAccount.class);

		setModelImplClass(UserAccountImpl.class);
		setModelPKClass(long.class);

		setTable(UserAccountTable.INSTANCE);
	}

	/**
	 * Caches the user account in the entity cache if it is enabled.
	 *
	 * @param userAccount the user account
	 */
	@Override
	public void cacheResult(UserAccount userAccount) {
		entityCache.putResult(
			UserAccountImpl.class, userAccount.getPrimaryKey(), userAccount);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user accounts in the entity cache if it is enabled.
	 *
	 * @param userAccounts the user accounts
	 */
	@Override
	public void cacheResult(List<UserAccount> userAccounts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userAccounts.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserAccount userAccount : userAccounts) {
			if (entityCache.getResult(
					UserAccountImpl.class, userAccount.getPrimaryKey()) ==
						null) {

				cacheResult(userAccount);
			}
		}
	}

	/**
	 * Clears the cache for all user accounts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserAccountImpl.class);

		finderCache.clearCache(UserAccountImpl.class);
	}

	/**
	 * Clears the cache for the user account.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserAccount userAccount) {
		entityCache.removeResult(UserAccountImpl.class, userAccount);
	}

	@Override
	public void clearCache(List<UserAccount> userAccounts) {
		for (UserAccount userAccount : userAccounts) {
			entityCache.removeResult(UserAccountImpl.class, userAccount);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserAccountImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserAccountImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user account with the primary key. Does not add the user account to the database.
	 *
	 * @param userAccountId the primary key for the new user account
	 * @return the new user account
	 */
	@Override
	public UserAccount create(long userAccountId) {
		UserAccount userAccount = new UserAccountImpl();

		userAccount.setNew(true);
		userAccount.setPrimaryKey(userAccountId);

		String uuid = PortalUUIDUtil.generate();

		userAccount.setUuid(uuid);

		userAccount.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userAccount;
	}

	/**
	 * Removes the user account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account that was removed
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	@Override
	public UserAccount remove(long userAccountId)
		throws NoSuchUserAccountException {

		return remove((Serializable)userAccountId);
	}

	/**
	 * Removes the user account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user account
	 * @return the user account that was removed
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	@Override
	public UserAccount remove(Serializable primaryKey)
		throws NoSuchUserAccountException {

		Session session = null;

		try {
			session = openSession();

			UserAccount userAccount = (UserAccount)session.get(
				UserAccountImpl.class, primaryKey);

			if (userAccount == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserAccountException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userAccount);
		}
		catch (NoSuchUserAccountException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserAccount removeImpl(UserAccount userAccount) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userAccount)) {
				userAccount = (UserAccount)session.get(
					UserAccountImpl.class, userAccount.getPrimaryKeyObj());
			}

			if (userAccount != null) {
				session.delete(userAccount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userAccount != null) {
			clearCache(userAccount);
		}

		return userAccount;
	}

	@Override
	public UserAccount updateImpl(UserAccount userAccount) {
		boolean isNew = userAccount.isNew();

		if (!(userAccount instanceof UserAccountModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userAccount.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userAccount);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userAccount proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserAccount implementation " +
					userAccount.getClass());
		}

		UserAccountModelImpl userAccountModelImpl =
			(UserAccountModelImpl)userAccount;

		if (Validator.isNull(userAccount.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userAccount.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (userAccount.getCreateDate() == null)) {
			if (serviceContext == null) {
				userAccount.setCreateDate(date);
			}
			else {
				userAccount.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!userAccountModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userAccount.setModifiedDate(date);
			}
			else {
				userAccount.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userAccount);
			}
			else {
				userAccount = (UserAccount)session.merge(userAccount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			UserAccountImpl.class, userAccountModelImpl, false, true);

		if (isNew) {
			userAccount.setNew(false);
		}

		userAccount.resetOriginalValues();

		return userAccount;
	}

	/**
	 * Returns the user account with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user account
	 * @return the user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	@Override
	public UserAccount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserAccountException {

		UserAccount userAccount = fetchByPrimaryKey(primaryKey);

		if (userAccount == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserAccountException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userAccount;
	}

	/**
	 * Returns the user account with the primary key or throws a <code>NoSuchUserAccountException</code> if it could not be found.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account
	 * @throws NoSuchUserAccountException if a user account with the primary key could not be found
	 */
	@Override
	public UserAccount findByPrimaryKey(long userAccountId)
		throws NoSuchUserAccountException {

		return findByPrimaryKey((Serializable)userAccountId);
	}

	/**
	 * Returns the user account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAccountId the primary key of the user account
	 * @return the user account, or <code>null</code> if a user account with the primary key could not be found
	 */
	@Override
	public UserAccount fetchByPrimaryKey(long userAccountId) {
		return fetchByPrimaryKey((Serializable)userAccountId);
	}

	/**
	 * Returns all the user accounts.
	 *
	 * @return the user accounts
	 */
	@Override
	public List<UserAccount> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserAccount> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserAccount> findAll(
		int start, int end, OrderByComparator<UserAccount> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserAccount> findAll(
		int start, int end, OrderByComparator<UserAccount> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserAccount> list = null;

		if (useFinderCache) {
			list = (List<UserAccount>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERACCOUNT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERACCOUNT;

				sql = sql.concat(UserAccountModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserAccount>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user accounts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserAccount userAccount : findAll()) {
			remove(userAccount);
		}
	}

	/**
	 * Returns the number of user accounts.
	 *
	 * @return the number of user accounts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERACCOUNT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userAccountId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERACCOUNT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserAccountModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user account persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByUserNameAccount = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserNameAccount",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userNameAccount"}, true);

		_finderPathWithoutPaginationFindByUserNameAccount = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserNameAccount",
			new String[] {String.class.getName()},
			new String[] {"userNameAccount"}, true);

		_finderPathCountByUserNameAccount = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserNameAccount",
			new String[] {String.class.getName()},
			new String[] {"userNameAccount"}, false);

		_finderPathWithPaginationFindByUserAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserAccountId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userAccountId"}, true);

		_finderPathWithoutPaginationFindByUserAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserAccountId",
			new String[] {Long.class.getName()}, new String[] {"userAccountId"},
			true);

		_finderPathCountByUserAccountId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserAccountId",
			new String[] {Long.class.getName()}, new String[] {"userAccountId"},
			false);

		_finderPathWithPaginationFindByUserFirstName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserFirstName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userFirstName"}, true);

		_finderPathWithoutPaginationFindByUserFirstName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserFirstName",
			new String[] {String.class.getName()},
			new String[] {"userFirstName"}, true);

		_finderPathCountByUserFirstName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserFirstName",
			new String[] {String.class.getName()},
			new String[] {"userFirstName"}, false);

		_finderPathWithPaginationFindByUserLastName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserLastName",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userLastName"}, true);

		_finderPathWithoutPaginationFindByUserLastName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserLastName",
			new String[] {String.class.getName()},
			new String[] {"userLastName"}, true);

		_finderPathCountByUserLastName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserLastName",
			new String[] {String.class.getName()},
			new String[] {"userLastName"}, false);

		UserAccountUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		UserAccountUtil.setPersistence(null);

		entityCache.removeCache(UserAccountImpl.class.getName());
	}

	@Override
	@Reference(
		target = datamusicPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = datamusicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = datamusicPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERACCOUNT =
		"SELECT userAccount FROM UserAccount userAccount";

	private static final String _SQL_SELECT_USERACCOUNT_WHERE =
		"SELECT userAccount FROM UserAccount userAccount WHERE ";

	private static final String _SQL_COUNT_USERACCOUNT =
		"SELECT COUNT(userAccount) FROM UserAccount userAccount";

	private static final String _SQL_COUNT_USERACCOUNT_WHERE =
		"SELECT COUNT(userAccount) FROM UserAccount userAccount WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userAccount.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserAccount exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserAccount exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserAccountPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}