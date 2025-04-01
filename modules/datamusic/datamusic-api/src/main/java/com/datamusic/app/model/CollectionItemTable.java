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
 * The table class for the &quot;datamusic_CollectionItem&quot; database table.
 *
 * @author Regisson Aguiar
 * @see CollectionItem
 * @generated
 */
public class CollectionItemTable extends BaseTable<CollectionItemTable> {

	public static final CollectionItemTable INSTANCE =
		new CollectionItemTable();

	public final Column<CollectionItemTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<CollectionItemTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, Long> collectionItemId =
		createColumn(
			"collectionItemId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CollectionItemTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, Long> userAccountId = createColumn(
		"userAccountId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, Long> mediaId = createColumn(
		"mediaId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, String> review = createColumn(
		"review", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CollectionItemTable, Long> rating = createColumn(
		"rating", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private CollectionItemTable() {
		super("datamusic_CollectionItem", CollectionItemTable::new);
	}

}