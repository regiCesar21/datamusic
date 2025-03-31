/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.test;

import com.datamusic.app.exception.NoSuchMediaException;
import com.datamusic.app.model.Media;
import com.datamusic.app.service.MediaLocalServiceUtil;
import com.datamusic.app.service.persistence.MediaPersistence;
import com.datamusic.app.service.persistence.MediaUtil;

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
public class MediaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.datamusic.app.service"));

	@Before
	public void setUp() {
		_persistence = MediaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Media> iterator = _medias.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Media media = _persistence.create(pk);

		Assert.assertNotNull(media);

		Assert.assertEquals(media.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Media newMedia = addMedia();

		_persistence.remove(newMedia);

		Media existingMedia = _persistence.fetchByPrimaryKey(
			newMedia.getPrimaryKey());

		Assert.assertNull(existingMedia);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addMedia();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Media newMedia = _persistence.create(pk);

		newMedia.setMvccVersion(RandomTestUtil.nextLong());

		newMedia.setUuid(RandomTestUtil.randomString());

		newMedia.setCompanyId(RandomTestUtil.nextLong());

		newMedia.setCreateDate(RandomTestUtil.nextDate());

		newMedia.setModifiedDate(RandomTestUtil.nextDate());

		newMedia.setMediaName(RandomTestUtil.randomString());

		newMedia.setArtist(RandomTestUtil.randomString());

		newMedia.setDescription(RandomTestUtil.randomString());

		newMedia.setGenre(RandomTestUtil.randomString());

		_medias.add(_persistence.update(newMedia));

		Media existingMedia = _persistence.findByPrimaryKey(
			newMedia.getPrimaryKey());

		Assert.assertEquals(
			existingMedia.getMvccVersion(), newMedia.getMvccVersion());
		Assert.assertEquals(existingMedia.getUuid(), newMedia.getUuid());
		Assert.assertEquals(existingMedia.getMediaId(), newMedia.getMediaId());
		Assert.assertEquals(
			existingMedia.getCompanyId(), newMedia.getCompanyId());
		Assert.assertEquals(
			Time.getShortTimestamp(existingMedia.getCreateDate()),
			Time.getShortTimestamp(newMedia.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingMedia.getModifiedDate()),
			Time.getShortTimestamp(newMedia.getModifiedDate()));
		Assert.assertEquals(
			existingMedia.getMediaName(), newMedia.getMediaName());
		Assert.assertEquals(existingMedia.getArtist(), newMedia.getArtist());
		Assert.assertEquals(
			existingMedia.getDescription(), newMedia.getDescription());
		Assert.assertEquals(existingMedia.getGenre(), newMedia.getGenre());
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
	public void testCountByMediaName() throws Exception {
		_persistence.countByMediaName("");

		_persistence.countByMediaName("null");

		_persistence.countByMediaName((String)null);
	}

	@Test
	public void testCountByMediaId() throws Exception {
		_persistence.countByMediaId(RandomTestUtil.nextLong());

		_persistence.countByMediaId(0L);
	}

	@Test
	public void testCountByArtist() throws Exception {
		_persistence.countByArtist("");

		_persistence.countByArtist("null");

		_persistence.countByArtist((String)null);
	}

	@Test
	public void testCountByGenre() throws Exception {
		_persistence.countByGenre("");

		_persistence.countByGenre("null");

		_persistence.countByGenre((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Media newMedia = addMedia();

		Media existingMedia = _persistence.findByPrimaryKey(
			newMedia.getPrimaryKey());

		Assert.assertEquals(existingMedia, newMedia);
	}

	@Test(expected = NoSuchMediaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Media> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"datamusic_Media", "mvccVersion", true, "uuid", true, "mediaId",
			true, "companyId", true, "createDate", true, "modifiedDate", true,
			"mediaName", true, "artist", true, "description", true, "genre",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Media newMedia = addMedia();

		Media existingMedia = _persistence.fetchByPrimaryKey(
			newMedia.getPrimaryKey());

		Assert.assertEquals(existingMedia, newMedia);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Media missingMedia = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingMedia);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Media newMedia1 = addMedia();
		Media newMedia2 = addMedia();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMedia1.getPrimaryKey());
		primaryKeys.add(newMedia2.getPrimaryKey());

		Map<Serializable, Media> medias = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, medias.size());
		Assert.assertEquals(newMedia1, medias.get(newMedia1.getPrimaryKey()));
		Assert.assertEquals(newMedia2, medias.get(newMedia2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Media> medias = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(medias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Media newMedia = addMedia();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMedia.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Media> medias = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, medias.size());
		Assert.assertEquals(newMedia, medias.get(newMedia.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Media> medias = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(medias.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Media newMedia = addMedia();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newMedia.getPrimaryKey());

		Map<Serializable, Media> medias = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, medias.size());
		Assert.assertEquals(newMedia, medias.get(newMedia.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			MediaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Media>() {

				@Override
				public void performAction(Media media) {
					Assert.assertNotNull(media);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Media newMedia = addMedia();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Media.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("mediaId", newMedia.getMediaId()));

		List<Media> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Media existingMedia = result.get(0);

		Assert.assertEquals(existingMedia, newMedia);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Media.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("mediaId", RandomTestUtil.nextLong()));

		List<Media> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Media newMedia = addMedia();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Media.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("mediaId"));

		Object newMediaId = newMedia.getMediaId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("mediaId", new Object[] {newMediaId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingMediaId = result.get(0);

		Assert.assertEquals(existingMediaId, newMediaId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Media.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("mediaId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"mediaId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Media addMedia() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Media media = _persistence.create(pk);

		media.setMvccVersion(RandomTestUtil.nextLong());

		media.setUuid(RandomTestUtil.randomString());

		media.setCompanyId(RandomTestUtil.nextLong());

		media.setCreateDate(RandomTestUtil.nextDate());

		media.setModifiedDate(RandomTestUtil.nextDate());

		media.setMediaName(RandomTestUtil.randomString());

		media.setArtist(RandomTestUtil.randomString());

		media.setDescription(RandomTestUtil.randomString());

		media.setGenre(RandomTestUtil.randomString());

		_medias.add(_persistence.update(media));

		return media;
	}

	private List<Media> _medias = new ArrayList<Media>();
	private MediaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}