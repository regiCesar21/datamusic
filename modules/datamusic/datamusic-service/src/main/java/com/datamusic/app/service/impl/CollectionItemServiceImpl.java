/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.impl;

import com.datamusic.app.service.base.CollectionItemServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Regisson Aguiar
 */
@Component(
	property = {
		"json.web.service.context.name=datamusic",
		"json.web.service.context.path=CollectionItem"
	},
	service = AopService.class
)
public class CollectionItemServiceImpl extends CollectionItemServiceBaseImpl {
}