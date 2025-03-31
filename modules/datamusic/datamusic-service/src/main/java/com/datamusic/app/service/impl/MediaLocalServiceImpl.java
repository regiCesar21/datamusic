/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.impl;

import com.datamusic.app.exception.DuplicateMediaException;
import com.datamusic.app.exception.MediaNotFoundException;
import com.datamusic.app.exception.NoSuchMediaException;
import com.datamusic.app.model.Media;
import com.datamusic.app.service.MediaLocalService;
import com.datamusic.app.service.base.MediaLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Regisson Aguiar
 */
@Component(
	property = "model.class.name=com.datamusic.app.model.Media",
	service = AopService.class
)
public class MediaLocalServiceImpl extends MediaLocalServiceBaseImpl {

	public Media createMedia(long mediaId, String mediaName, String artist, String description, String genre) throws DuplicateMediaException {
		Media media = mediaPersistence.create(mediaId);

		media.setMediaId(mediaId);
		media.setMediaName(mediaName);
		media.setArtist(artist);
		media.setDescription(description);
		media.setGenre(genre);
		media.setCreateDate(new Date());
		media.setModifiedDate(new Date());

		return mediaPersistence.update(media);
	}


	public Media deleteMedia(long mediaId) throws MediaNotFoundException, NoSuchMediaException {
		if (mediaPersistence.findByMediaId(mediaId) == null) {
			throw new MediaNotFoundException(
					"No such media with id: " + mediaId);
		}
		else {
			_log.debug("Deleting media with id: " + mediaId);

			return mediaPersistence.remove(mediaId);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
			MediaLocalServiceImpl.class);
}