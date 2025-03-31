/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the UserAccount service. Represents a row in the &quot;datamusic_UserAccount&quot; database table, with each column mapped to a property of this class.
 *
 * @author Regisson Aguiar
 * @see UserAccountModel
 * @generated
 */
@ImplementationClassName("com.datamusic.app.model.impl.UserAccountImpl")
@ProviderType
public interface UserAccount extends PersistedModel, UserAccountModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.datamusic.app.model.impl.UserAccountImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserAccount, Long> USER_ACCOUNT_ID_ACCESSOR =
		new Accessor<UserAccount, Long>() {

			@Override
			public Long get(UserAccount userAccount) {
				return userAccount.getUserAccountId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserAccount> getTypeClass() {
				return UserAccount.class;
			}

		};

}