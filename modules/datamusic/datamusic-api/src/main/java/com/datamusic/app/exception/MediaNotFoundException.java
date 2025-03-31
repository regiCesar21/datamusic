/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.datamusic.app.exception;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Regisson Aguiar
 */
public class MediaNotFoundException extends PortalException {

	public MediaNotFoundException() {
	}

	public MediaNotFoundException(String msg) {
		super(msg);
	}

	public MediaNotFoundException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public MediaNotFoundException(Throwable throwable) {
		super(throwable);
	}

}