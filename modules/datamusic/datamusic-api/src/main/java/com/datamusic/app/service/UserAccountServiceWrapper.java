/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserAccountService}.
 *
 * @author Regisson Aguiar
 * @see UserAccountService
 * @generated
 */
public class UserAccountServiceWrapper
	implements ServiceWrapper<UserAccountService>, UserAccountService {

	public UserAccountServiceWrapper() {
		this(null);
	}

	public UserAccountServiceWrapper(UserAccountService userAccountService) {
		_userAccountService = userAccountService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userAccountService.getOSGiServiceIdentifier();
	}

	@Override
	public UserAccountService getWrappedService() {
		return _userAccountService;
	}

	@Override
	public void setWrappedService(UserAccountService userAccountService) {
		_userAccountService = userAccountService;
	}

	private UserAccountService _userAccountService;

}