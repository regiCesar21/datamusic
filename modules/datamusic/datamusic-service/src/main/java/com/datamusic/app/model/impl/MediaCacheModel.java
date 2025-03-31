/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model.impl;

import com.datamusic.app.model.Media;

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
 * The cache model class for representing Media in entity cache.
 *
 * @author Regisson Aguiar
 * @generated
 */
public class MediaCacheModel
	implements CacheModel<Media>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MediaCacheModel)) {
			return false;
		}

		MediaCacheModel mediaCacheModel = (MediaCacheModel)object;

		if ((mediaId == mediaCacheModel.mediaId) &&
			(mvccVersion == mediaCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, mediaId);

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
		sb.append(", mediaId=");
		sb.append(mediaId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", mediaName=");
		sb.append(mediaName);
		sb.append(", artist=");
		sb.append(artist);
		sb.append(", description=");
		sb.append(description);
		sb.append(", genre=");
		sb.append(genre);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Media toEntityModel() {
		MediaImpl mediaImpl = new MediaImpl();

		mediaImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			mediaImpl.setUuid("");
		}
		else {
			mediaImpl.setUuid(uuid);
		}

		mediaImpl.setMediaId(mediaId);
		mediaImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			mediaImpl.setCreateDate(null);
		}
		else {
			mediaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			mediaImpl.setModifiedDate(null);
		}
		else {
			mediaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (mediaName == null) {
			mediaImpl.setMediaName("");
		}
		else {
			mediaImpl.setMediaName(mediaName);
		}

		if (artist == null) {
			mediaImpl.setArtist("");
		}
		else {
			mediaImpl.setArtist(artist);
		}

		if (description == null) {
			mediaImpl.setDescription("");
		}
		else {
			mediaImpl.setDescription(description);
		}

		if (genre == null) {
			mediaImpl.setGenre("");
		}
		else {
			mediaImpl.setGenre(genre);
		}

		mediaImpl.resetOriginalValues();

		return mediaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		mediaId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		mediaName = objectInput.readUTF();
		artist = objectInput.readUTF();
		description = objectInput.readUTF();
		genre = objectInput.readUTF();
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

		objectOutput.writeLong(mediaId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (mediaName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mediaName);
		}

		if (artist == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(artist);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (genre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(genre);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long mediaId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String mediaName;
	public String artist;
	public String description;
	public String genre;

}