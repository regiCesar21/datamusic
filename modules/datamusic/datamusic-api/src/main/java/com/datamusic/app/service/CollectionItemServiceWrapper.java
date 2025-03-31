/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CollectionItemService}.
 *
 * @author Regisson Aguiar
 * @see CollectionItemService
 * @generated
 */
public class CollectionItemServiceWrapper
	implements CollectionItemService, ServiceWrapper<CollectionItemService> {

	public CollectionItemServiceWrapper() {
		this(null);
	}

	public CollectionItemServiceWrapper(
		CollectionItemService collectionItemService) {

		_collectionItemService = collectionItemService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _collectionItemService.getOSGiServiceIdentifier();
	}

	@Override
	public CollectionItemService getWrappedService() {
		return _collectionItemService;
	}

	@Override
	public void setWrappedService(CollectionItemService collectionItemService) {
		_collectionItemService = collectionItemService;
	}

	private CollectionItemService _collectionItemService;

}