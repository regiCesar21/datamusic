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
 * The extended model interface for the CollectionItem service. Represents a row in the &quot;datamusic_CollectionItem&quot; database table, with each column mapped to a property of this class.
 *
 * @author Regisson Aguiar
 * @see CollectionItemModel
 * @generated
 */
@ImplementationClassName("com.datamusic.app.model.impl.CollectionItemImpl")
@ProviderType
public interface CollectionItem extends CollectionItemModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.datamusic.app.model.impl.CollectionItemImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CollectionItem, Long>
		COLLECTION_ITEM_ID_ACCESSOR = new Accessor<CollectionItem, Long>() {

			@Override
			public Long get(CollectionItem collectionItem) {
				return collectionItem.getCollectionItemId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CollectionItem> getTypeClass() {
				return CollectionItem.class;
			}

		};

}