/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.test;

import com.datamusic.app.exception.NoSuchUserAccountException;
import com.datamusic.app.model.UserAccount;
import com.datamusic.app.service.UserAccountLocalServiceUtil;
import com.datamusic.app.service.persistence.UserAccountPersistence;
import com.datamusic.app.service.persistence.UserAccountUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class UserAccountPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.datamusic.app.service"));

	@Before
	public void setUp() {
		_persistence = UserAccountUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<UserAccount> iterator = _userAccounts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserAccount userAccount = _persistence.create(pk);

		Assert.assertNotNull(userAccount);

		Assert.assertEquals(userAccount.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		UserAccount newUserAccount = addUserAccount();

		_persistence.remove(newUserAccount);

		UserAccount existingUserAccount = _persistence.fetchByPrimaryKey(
			newUserAccount.getPrimaryKey());

		Assert.assertNull(existingUserAccount);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addUserAccount();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserAccount newUserAccount = _persistence.create(pk);

		newUserAccount.setMvccVersion(RandomTestUtil.nextLong());

		newUserAccount.setUuid(RandomTestUtil.randomString());

		newUserAccount.setCompanyId(RandomTestUtil.nextLong());

		newUserAccount.setCreateDate(RandomTestUtil.nextDate());

		newUserAccount.setModifiedDate(RandomTestUtil.nextDate());

		newUserAccount.setUserNameAccount(RandomTestUtil.randomString());

		newUserAccount.setUserFirstName(RandomTestUtil.randomString());

		newUserAccount.setUserLastName(RandomTestUtil.randomString());

		_userAccounts.add(_persistence.update(newUserAccount));

		UserAccount existingUserAccount = _persistence.findByPrimaryKey(
			newUserAccount.getPrimaryKey());

		Assert.assertEquals(
			existingUserAccount.getMvccVersion(),
			newUserAccount.getMvccVersion());
		Assert.assertEquals(
			existingUserAccount.getUuid(), newUserAccount.getUuid());
		Assert.assertEquals(
			existingUserAccount.getUserAccountId(),
			newUserAccount.getUserAccountId());
		Assert.assertEquals(
			existingUserAccount.getCompanyId(), newUserAccount.getCompanyId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingUserAccount.getCreateDate()),
			Time.getShortTimestamp(newUserAccount.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingUserAccount.getModifiedDate()),
			Time.getShortTimestamp(newUserAccount.getModifiedDate()));
		Assert.assertEquals(
			existingUserAccount.getUserNameAccount(),
			newUserAccount.getUserNameAccount());
		Assert.assertEquals(
			existingUserAccount.getUserFirstName(),
			newUserAccount.getUserFirstName());
		Assert.assertEquals(
			existingUserAccount.getUserLastName(),
			newUserAccount.getUserLastName());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByUserNameAccount() throws Exception {
		_persistence.countByUserNameAccount("");

		_persistence.countByUserNameAccount("null");

		_persistence.countByUserNameAccount((String)null);
	}

	@Test
	public void testCountByUserAccountId() throws Exception {
		_persistence.countByUserAccountId(RandomTestUtil.nextLong());

		_persistence.countByUserAccountId(0L);
	}

	@Test
	public void testCountByUserFirstName() throws Exception {
		_persistence.countByUserFirstName("");

		_persistence.countByUserFirstName("null");

		_persistence.countByUserFirstName((String)null);
	}

	@Test
	public void testCountByUserLastName() throws Exception {
		_persistence.countByUserLastName("");

		_persistence.countByUserLastName("null");

		_persistence.countByUserLastName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		UserAccount newUserAccount = addUserAccount();

		UserAccount existingUserAccount = _persistence.findByPrimaryKey(
			newUserAccount.getPrimaryKey());

		Assert.assertEquals(existingUserAccount, newUserAccount);
	}

	@Test(expected = NoSuchUserAccountException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<UserAccount> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"datamusic_UserAccount", "mvccVersion", true, "uuid", true,
			"userAccountId", true, "companyId", true, "createDate", true,
			"modifiedDate", true, "userNameAccount", true, "userFirstName",
			true, "userLastName", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		UserAccount newUserAccount = addUserAccount();

		UserAccount existingUserAccount = _persistence.fetchByPrimaryKey(
			newUserAccount.getPrimaryKey());

		Assert.assertEquals(existingUserAccount, newUserAccount);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserAccount missingUserAccount = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingUserAccount);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		UserAccount newUserAccount1 = addUserAccount();
		UserAccount newUserAccount2 = addUserAccount();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserAccount1.getPrimaryKey());
		primaryKeys.add(newUserAccount2.getPrimaryKey());

		Map<Serializable, UserAccount> userAccounts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, userAccounts.size());
		Assert.assertEquals(
			newUserAccount1, userAccounts.get(newUserAccount1.getPrimaryKey()));
		Assert.assertEquals(
			newUserAccount2, userAccounts.get(newUserAccount2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, UserAccount> userAccounts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userAccounts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		UserAccount newUserAccount = addUserAccount();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserAccount.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, UserAccount> userAccounts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userAccounts.size());
		Assert.assertEquals(
			newUserAccount, userAccounts.get(newUserAccount.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, UserAccount> userAccounts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(userAccounts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		UserAccount newUserAccount = addUserAccount();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newUserAccount.getPrimaryKey());

		Map<Serializable, UserAccount> userAccounts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, userAccounts.size());
		Assert.assertEquals(
			newUserAccount, userAccounts.get(newUserAccount.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			UserAccountLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<UserAccount>() {

				@Override
				public void performAction(UserAccount userAccount) {
					Assert.assertNotNull(userAccount);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		UserAccount newUserAccount = addUserAccount();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserAccount.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"userAccountId", newUserAccount.getUserAccountId()));

		List<UserAccount> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		UserAccount existingUserAccount = result.get(0);

		Assert.assertEquals(existingUserAccount, newUserAccount);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserAccount.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"userAccountId", RandomTestUtil.nextLong()));

		List<UserAccount> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		UserAccount newUserAccount = addUserAccount();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserAccount.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("userAccountId"));

		Object newUserAccountId = newUserAccount.getUserAccountId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"userAccountId", new Object[] {newUserAccountId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingUserAccountId = result.get(0);

		Assert.assertEquals(existingUserAccountId, newUserAccountId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			UserAccount.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("userAccountId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"userAccountId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected UserAccount addUserAccount() throws Exception {
		long pk = RandomTestUtil.nextLong();

		UserAccount userAccount = _persistence.create(pk);

		userAccount.setMvccVersion(RandomTestUtil.nextLong());

		userAccount.setUuid(RandomTestUtil.randomString());

		userAccount.setCompanyId(RandomTestUtil.nextLong());

		userAccount.setCreateDate(RandomTestUtil.nextDate());

		userAccount.setModifiedDate(RandomTestUtil.nextDate());

		userAccount.setUserNameAccount(RandomTestUtil.randomString());

		userAccount.setUserFirstName(RandomTestUtil.randomString());

		userAccount.setUserLastName(RandomTestUtil.randomString());

		_userAccounts.add(_persistence.update(userAccount));

		return userAccount;
	}

	private List<UserAccount> _userAccounts = new ArrayList<UserAccount>();
	private UserAccountPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}