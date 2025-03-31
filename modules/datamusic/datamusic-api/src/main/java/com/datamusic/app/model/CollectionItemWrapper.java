/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CollectionItem}.
 * </p>
 *
 * @author Regisson Aguiar
 * @see CollectionItem
 * @generated
 */
public class CollectionItemWrapper
	extends BaseModelWrapper<CollectionItem>
	implements CollectionItem, ModelWrapper<CollectionItem> {

	public CollectionItemWrapper(CollectionItem collectionItem) {
		super(collectionItem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("collectionItemId", getCollectionItemId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userAccountId", getUserAccountId());
		attributes.put("mediaId", getMediaId());
		attributes.put("review", getReview());
		attributes.put("rating", getRating());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long collectionItemId = (Long)attributes.get("collectionItemId");

		if (collectionItemId != null) {
			setCollectionItemId(collectionItemId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userAccountId = (Long)attributes.get("userAccountId");

		if (userAccountId != null) {
			setUserAccountId(userAccountId);
		}

		Long mediaId = (Long)attributes.get("mediaId");

		if (mediaId != null) {
			setMediaId(mediaId);
		}

		String review = (String)attributes.get("review");

		if (review != null) {
			setReview(review);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}
	}

	@Override
	public CollectionItem cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the collection item ID of this collection item.
	 *
	 * @return the collection item ID of this collection item
	 */
	@Override
	public long getCollectionItemId() {
		return model.getCollectionItemId();
	}

	/**
	 * Returns the company ID of this collection item.
	 *
	 * @return the company ID of this collection item
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this collection item.
	 *
	 * @return the create date of this collection item
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the media ID of this collection item.
	 *
	 * @return the media ID of this collection item
	 */
	@Override
	public long getMediaId() {
		return model.getMediaId();
	}

	/**
	 * Returns the modified date of this collection item.
	 *
	 * @return the modified date of this collection item
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this collection item.
	 *
	 * @return the mvcc version of this collection item
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this collection item.
	 *
	 * @return the primary key of this collection item
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rating of this collection item.
	 *
	 * @return the rating of this collection item
	 */
	@Override
	public int getRating() {
		return model.getRating();
	}

	/**
	 * Returns the review of this collection item.
	 *
	 * @return the review of this collection item
	 */
	@Override
	public String getReview() {
		return model.getReview();
	}

	/**
	 * Returns the user account ID of this collection item.
	 *
	 * @return the user account ID of this collection item
	 */
	@Override
	public long getUserAccountId() {
		return model.getUserAccountId();
	}

	/**
	 * Returns the uuid of this collection item.
	 *
	 * @return the uuid of this collection item
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the collection item ID of this collection item.
	 *
	 * @param collectionItemId the collection item ID of this collection item
	 */
	@Override
	public void setCollectionItemId(long collectionItemId) {
		model.setCollectionItemId(collectionItemId);
	}

	/**
	 * Sets the company ID of this collection item.
	 *
	 * @param companyId the company ID of this collection item
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this collection item.
	 *
	 * @param createDate the create date of this collection item
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the media ID of this collection item.
	 *
	 * @param mediaId the media ID of this collection item
	 */
	@Override
	public void setMediaId(long mediaId) {
		model.setMediaId(mediaId);
	}

	/**
	 * Sets the modified date of this collection item.
	 *
	 * @param modifiedDate the modified date of this collection item
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this collection item.
	 *
	 * @param mvccVersion the mvcc version of this collection item
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this collection item.
	 *
	 * @param primaryKey the primary key of this collection item
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rating of this collection item.
	 *
	 * @param rating the rating of this collection item
	 */
	@Override
	public void setRating(int rating) {
		model.setRating(rating);
	}

	/**
	 * Sets the review of this collection item.
	 *
	 * @param review the review of this collection item
	 */
	@Override
	public void setReview(String review) {
		model.setReview(review);
	}

	/**
	 * Sets the user account ID of this collection item.
	 *
	 * @param userAccountId the user account ID of this collection item
	 */
	@Override
	public void setUserAccountId(long userAccountId) {
		model.setUserAccountId(userAccountId);
	}

	/**
	 * Sets the uuid of this collection item.
	 *
	 * @param uuid the uuid of this collection item
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CollectionItemWrapper wrap(CollectionItem collectionItem) {
		return new CollectionItemWrapper(collectionItem);
	}

}