/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model.impl;

import com.datamusic.app.model.CollectionItem;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CollectionItem in entity cache.
 *
 * @author Regisson Aguiar
 * @generated
 */
public class CollectionItemCacheModel
	implements CacheModel<CollectionItem>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CollectionItemCacheModel)) {
			return false;
		}

		CollectionItemCacheModel collectionItemCacheModel =
			(CollectionItemCacheModel)object;

		if ((collectionItemId == collectionItemCacheModel.collectionItemId) &&
			(mvccVersion == collectionItemCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, collectionItemId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", collectionItemId=");
		sb.append(collectionItemId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userAccountId=");
		sb.append(userAccountId);
		sb.append(", mediaId=");
		sb.append(mediaId);
		sb.append(", review=");
		sb.append(review);
		sb.append(", rating=");
		sb.append(rating);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CollectionItem toEntityModel() {
		CollectionItemImpl collectionItemImpl = new CollectionItemImpl();

		collectionItemImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			collectionItemImpl.setUuid("");
		}
		else {
			collectionItemImpl.setUuid(uuid);
		}

		collectionItemImpl.setCollectionItemId(collectionItemId);
		collectionItemImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			collectionItemImpl.setCreateDate(null);
		}
		else {
			collectionItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			collectionItemImpl.setModifiedDate(null);
		}
		else {
			collectionItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		collectionItemImpl.setUserAccountId(userAccountId);
		collectionItemImpl.setMediaId(mediaId);

		if (review == null) {
			collectionItemImpl.setReview("");
		}
		else {
			collectionItemImpl.setReview(review);
		}

		collectionItemImpl.setRating(rating);

		collectionItemImpl.resetOriginalValues();

		return collectionItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		collectionItemId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		userAccountId = objectInput.readLong();

		mediaId = objectInput.readLong();
		review = objectInput.readUTF();

		rating = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(collectionItemId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(userAccountId);

		objectOutput.writeLong(mediaId);

		if (review == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(review);
		}

		objectOutput.writeLong(rating);
	}

	public long mvccVersion;
	public String uuid;
	public long collectionItemId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userAccountId;
	public long mediaId;
	public String review;
	public long rating;

}