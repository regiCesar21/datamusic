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
 * This class is a wrapper for {@link Media}.
 * </p>
 *
 * @author Regisson Aguiar
 * @see Media
 * @generated
 */
public class MediaWrapper
	extends BaseModelWrapper<Media> implements Media, ModelWrapper<Media> {

	public MediaWrapper(Media media) {
		super(media);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("mediaId", getMediaId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("mediaName", getMediaName());
		attributes.put("artist", getArtist());
		attributes.put("description", getDescription());
		attributes.put("genre", getGenre());

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

		Long mediaId = (Long)attributes.get("mediaId");

		if (mediaId != null) {
			setMediaId(mediaId);
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

		String mediaName = (String)attributes.get("mediaName");

		if (mediaName != null) {
			setMediaName(mediaName);
		}

		String artist = (String)attributes.get("artist");

		if (artist != null) {
			setArtist(artist);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String genre = (String)attributes.get("genre");

		if (genre != null) {
			setGenre(genre);
		}
	}

	@Override
	public Media cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the artist of this media.
	 *
	 * @return the artist of this media
	 */
	@Override
	public String getArtist() {
		return model.getArtist();
	}

	/**
	 * Returns the company ID of this media.
	 *
	 * @return the company ID of this media
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this media.
	 *
	 * @return the create date of this media
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this media.
	 *
	 * @return the description of this media
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the genre of this media.
	 *
	 * @return the genre of this media
	 */
	@Override
	public String getGenre() {
		return model.getGenre();
	}

	/**
	 * Returns the media ID of this media.
	 *
	 * @return the media ID of this media
	 */
	@Override
	public long getMediaId() {
		return model.getMediaId();
	}

	/**
	 * Returns the media name of this media.
	 *
	 * @return the media name of this media
	 */
	@Override
	public String getMediaName() {
		return model.getMediaName();
	}

	/**
	 * Returns the modified date of this media.
	 *
	 * @return the modified date of this media
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this media.
	 *
	 * @return the mvcc version of this media
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this media.
	 *
	 * @return the primary key of this media
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this media.
	 *
	 * @return the uuid of this media
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
	 * Sets the artist of this media.
	 *
	 * @param artist the artist of this media
	 */
	@Override
	public void setArtist(String artist) {
		model.setArtist(artist);
	}

	/**
	 * Sets the company ID of this media.
	 *
	 * @param companyId the company ID of this media
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this media.
	 *
	 * @param createDate the create date of this media
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this media.
	 *
	 * @param description the description of this media
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the genre of this media.
	 *
	 * @param genre the genre of this media
	 */
	@Override
	public void setGenre(String genre) {
		model.setGenre(genre);
	}

	/**
	 * Sets the media ID of this media.
	 *
	 * @param mediaId the media ID of this media
	 */
	@Override
	public void setMediaId(long mediaId) {
		model.setMediaId(mediaId);
	}

	/**
	 * Sets the media name of this media.
	 *
	 * @param mediaName the media name of this media
	 */
	@Override
	public void setMediaName(String mediaName) {
		model.setMediaName(mediaName);
	}

	/**
	 * Sets the modified date of this media.
	 *
	 * @param modifiedDate the modified date of this media
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this media.
	 *
	 * @param mvccVersion the mvcc version of this media
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this media.
	 *
	 * @param primaryKey the primary key of this media
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this media.
	 *
	 * @param uuid the uuid of this media
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
	protected MediaWrapper wrap(Media media) {
		return new MediaWrapper(media);
	}

}