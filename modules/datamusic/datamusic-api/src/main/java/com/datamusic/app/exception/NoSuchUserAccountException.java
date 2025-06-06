/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.datamusic.app.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Regisson Aguiar
 */
public class NoSuchUserAccountException extends NoSuchModelException {

	public NoSuchUserAccountException() {
	}

	public NoSuchUserAccountException(String msg) {
		super(msg);
	}

	public NoSuchUserAccountException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchUserAccountException(Throwable throwable) {
		super(throwable);
	}

}