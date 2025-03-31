/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MediaService}.
 *
 * @author Regisson Aguiar
 * @see MediaService
 * @generated
 */
public class MediaServiceWrapper
	implements MediaService, ServiceWrapper<MediaService> {

	public MediaServiceWrapper() {
		this(null);
	}

	public MediaServiceWrapper(MediaService mediaService) {
		_mediaService = mediaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mediaService.getOSGiServiceIdentifier();
	}

	@Override
	public MediaService getWrappedService() {
		return _mediaService;
	}

	@Override
	public void setWrappedService(MediaService mediaService) {
		_mediaService = mediaService;
	}

	private MediaService _mediaService;

}