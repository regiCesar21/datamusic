/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;datamusic_UserAccount&quot; database table.
 *
 * @author Regisson Aguiar
 * @see UserAccount
 * @generated
 */
public class UserAccountTable extends BaseTable<UserAccountTable> {

	public static final UserAccountTable INSTANCE = new UserAccountTable();

	public final Column<UserAccountTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<UserAccountTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserAccountTable, Long> userAccountId = createColumn(
		"userAccountId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<UserAccountTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<UserAccountTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserAccountTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<UserAccountTable, String> userNameAccount =
		createColumn(
			"userNameAccount", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<UserAccountTable, String> userFirstName = createColumn(
		"userFirstName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<UserAccountTable, String> userLastName = createColumn(
		"userLastName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private UserAccountTable() {
		super("datamusic_UserAccount", UserAccountTable::new);
	}

}