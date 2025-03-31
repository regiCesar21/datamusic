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
 * The table class for the &quot;datamusic_Media&quot; database table.
 *
 * @author Regisson Aguiar
 * @see Media
 * @generated
 */
public class MediaTable extends BaseTable<MediaTable> {

	public static final MediaTable INSTANCE = new MediaTable();

	public final Column<MediaTable, Long> mvccVersion = createColumn(
		"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<MediaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MediaTable, Long> mediaId = createColumn(
		"mediaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MediaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MediaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MediaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<MediaTable, String> mediaName = createColumn(
		"mediaName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MediaTable, String> artist = createColumn(
		"artist", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MediaTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MediaTable, String> genre = createColumn(
		"genre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MediaTable() {
		super("datamusic_Media", MediaTable::new);
	}

}