/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.test;

import com.datamusic.app.exception.NoSuchCollectionItemException;
import com.datamusic.app.model.CollectionItem;
import com.datamusic.app.service.CollectionItemLocalServiceUtil;
import com.datamusic.app.service.persistence.CollectionItemPersistence;
import com.datamusic.app.service.persistence.CollectionItemUtil;

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
public class CollectionItemPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.datamusic.app.service"));

	@Before
	public void setUp() {
		_persistence = CollectionItemUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CollectionItem> iterator = _collectionItems.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionItem collectionItem = _persistence.create(pk);

		Assert.assertNotNull(collectionItem);

		Assert.assertEquals(collectionItem.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CollectionItem newCollectionItem = addCollectionItem();

		_persistence.remove(newCollectionItem);

		CollectionItem existingCollectionItem = _persistence.fetchByPrimaryKey(
			newCollectionItem.getPrimaryKey());

		Assert.assertNull(existingCollectionItem);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCollectionItem();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionItem newCollectionItem = _persistence.create(pk);

		newCollectionItem.setMvccVersion(RandomTestUtil.nextLong());

		newCollectionItem.setUuid(RandomTestUtil.randomString());

		newCollectionItem.setCompanyId(RandomTestUtil.nextLong());

		newCollectionItem.setCreateDate(RandomTestUtil.nextDate());

		newCollectionItem.setModifiedDate(RandomTestUtil.nextDate());

		newCollectionItem.setUserAccountId(RandomTestUtil.nextLong());

		newCollectionItem.setMediaId(RandomTestUtil.nextLong());

		newCollectionItem.setReview(RandomTestUtil.randomString());

		newCollectionItem.setRating(RandomTestUtil.nextInt());

		_collectionItems.add(_persistence.update(newCollectionItem));

		CollectionItem existingCollectionItem = _persistence.findByPrimaryKey(
			newCollectionItem.getPrimaryKey());

		Assert.assertEquals(
			existingCollectionItem.getMvccVersion(),
			newCollectionItem.getMvccVersion());
		Assert.assertEquals(
			existingCollectionItem.getUuid(), newCollectionItem.getUuid());
		Assert.assertEquals(
			existingCollectionItem.getCollectionItemId(),
			newCollectionItem.getCollectionItemId());
		Assert.assertEquals(
			existingCollectionItem.getCompanyId(),
			newCollectionItem.getCompanyId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCollectionItem.getCreateDate()),
			Time.getShortTimestamp(newCollectionItem.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCollectionItem.getModifiedDate()),
			Time.getShortTimestamp(newCollectionItem.getModifiedDate()));
		Assert.assertEquals(
			existingCollectionItem.getUserAccountId(),
			newCollectionItem.getUserAccountId());
		Assert.assertEquals(
			existingCollectionItem.getMediaId(),
			newCollectionItem.getMediaId());
		Assert.assertEquals(
			existingCollectionItem.getReview(), newCollectionItem.getReview());
		Assert.assertEquals(
			existingCollectionItem.getRating(), newCollectionItem.getRating());
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
	public void testCountByU_R() throws Exception {
		_persistence.countByU_R(
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByU_R(0L, 0);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CollectionItem newCollectionItem = addCollectionItem();

		CollectionItem existingCollectionItem = _persistence.findByPrimaryKey(
			newCollectionItem.getPrimaryKey());

		Assert.assertEquals(existingCollectionItem, newCollectionItem);
	}

	@Test(expected = NoSuchCollectionItemException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<CollectionItem> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"datamusic_CollectionItem", "mvccVersion", true, "uuid", true,
			"collectionItemId", true, "companyId", true, "createDate", true,
			"modifiedDate", true, "userAccountId", true, "mediaId", true,
			"review", true, "rating", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CollectionItem newCollectionItem = addCollectionItem();

		CollectionItem existingCollectionItem = _persistence.fetchByPrimaryKey(
			newCollectionItem.getPrimaryKey());

		Assert.assertEquals(existingCollectionItem, newCollectionItem);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionItem missingCollectionItem = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingCollectionItem);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CollectionItem newCollectionItem1 = addCollectionItem();
		CollectionItem newCollectionItem2 = addCollectionItem();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCollectionItem1.getPrimaryKey());
		primaryKeys.add(newCollectionItem2.getPrimaryKey());

		Map<Serializable, CollectionItem> collectionItems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, collectionItems.size());
		Assert.assertEquals(
			newCollectionItem1,
			collectionItems.get(newCollectionItem1.getPrimaryKey()));
		Assert.assertEquals(
			newCollectionItem2,
			collectionItems.get(newCollectionItem2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CollectionItem> collectionItems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(collectionItems.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CollectionItem newCollectionItem = addCollectionItem();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCollectionItem.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CollectionItem> collectionItems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, collectionItems.size());
		Assert.assertEquals(
			newCollectionItem,
			collectionItems.get(newCollectionItem.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CollectionItem> collectionItems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(collectionItems.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CollectionItem newCollectionItem = addCollectionItem();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCollectionItem.getPrimaryKey());

		Map<Serializable, CollectionItem> collectionItems =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, collectionItems.size());
		Assert.assertEquals(
			newCollectionItem,
			collectionItems.get(newCollectionItem.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CollectionItemLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CollectionItem>() {

				@Override
				public void performAction(CollectionItem collectionItem) {
					Assert.assertNotNull(collectionItem);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CollectionItem newCollectionItem = addCollectionItem();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionItem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"collectionItemId", newCollectionItem.getCollectionItemId()));

		List<CollectionItem> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		CollectionItem existingCollectionItem = result.get(0);

		Assert.assertEquals(existingCollectionItem, newCollectionItem);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionItem.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"collectionItemId", RandomTestUtil.nextLong()));

		List<CollectionItem> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CollectionItem newCollectionItem = addCollectionItem();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionItem.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("collectionItemId"));

		Object newCollectionItemId = newCollectionItem.getCollectionItemId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"collectionItemId", new Object[] {newCollectionItemId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCollectionItemId = result.get(0);

		Assert.assertEquals(existingCollectionItemId, newCollectionItemId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CollectionItem.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("collectionItemId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"collectionItemId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CollectionItem addCollectionItem() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CollectionItem collectionItem = _persistence.create(pk);

		collectionItem.setMvccVersion(RandomTestUtil.nextLong());

		collectionItem.setUuid(RandomTestUtil.randomString());

		collectionItem.setCompanyId(RandomTestUtil.nextLong());

		collectionItem.setCreateDate(RandomTestUtil.nextDate());

		collectionItem.setModifiedDate(RandomTestUtil.nextDate());

		collectionItem.setUserAccountId(RandomTestUtil.nextLong());

		collectionItem.setMediaId(RandomTestUtil.nextLong());

		collectionItem.setReview(RandomTestUtil.randomString());

		collectionItem.setRating(RandomTestUtil.nextInt());

		_collectionItems.add(_persistence.update(collectionItem));

		return collectionItem;
	}

	private List<CollectionItem> _collectionItems =
		new ArrayList<CollectionItem>();
	private CollectionItemPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}