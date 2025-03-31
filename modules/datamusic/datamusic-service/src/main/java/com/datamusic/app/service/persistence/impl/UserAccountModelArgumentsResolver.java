/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.service.persistence.impl;

import com.datamusic.app.model.UserAccountTable;
import com.datamusic.app.model.impl.UserAccountImpl;
import com.datamusic.app.model.impl.UserAccountModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from UserAccount.
 *
 * @author Regisson Aguiar
 * @generated
 */
@Component(
	property = {
		"class.name=com.datamusic.app.model.impl.UserAccountImpl",
		"table.name=datamusic_UserAccount"
	},
	service = ArgumentsResolver.class
)
public class UserAccountModelArgumentsResolver implements ArgumentsResolver {

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

		UserAccountModelImpl userAccountModelImpl =
			(UserAccountModelImpl)baseModel;

		long columnBitmask = userAccountModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(userAccountModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					userAccountModelImpl.getColumnBitmask(columnName);
			}

			if (finderPath.isBaseModelResult() &&
				(UserAccountPersistenceImpl.
					FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
						finderPath.getCacheName())) {

				finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(userAccountModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return UserAccountImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return UserAccountTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		UserAccountModelImpl userAccountModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = userAccountModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = userAccountModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

	private static final long _ORDER_BY_COLUMNS_BITMASK;

	static {
		long orderByColumnsBitmask = 0;

		orderByColumnsBitmask |= UserAccountModelImpl.getColumnBitmask(
			"userNameAccount");

		_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
	}

}