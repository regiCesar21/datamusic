/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.impl;

import com.datamusic.app.model.CollectionItemTable;
import com.datamusic.app.model.impl.CollectionItemImpl;
import com.datamusic.app.model.impl.CollectionItemModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from CollectionItem.
 *
 * @author Regisson Aguiar
 * @generated
 */
@Component(
	property = {
		"class.name=com.datamusic.app.model.impl.CollectionItemImpl",
		"table.name=datamusic_CollectionItem"
	},
	service = ArgumentsResolver.class
)
public class CollectionItemModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		CollectionItemModelImpl collectionItemModelImpl =
			(CollectionItemModelImpl)baseModel;

		long columnBitmask = collectionItemModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(collectionItemModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					collectionItemModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(CollectionItemPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(collectionItemModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return CollectionItemImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return CollectionItemTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		CollectionItemModelImpl collectionItemModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = collectionItemModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = collectionItemModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= CollectionItemModelImpl.getColumnBitmask(
			"rating");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}