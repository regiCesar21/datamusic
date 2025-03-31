/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model.impl;

import com.datamusic.app.model.UserAccount;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserAccount in entity cache.
 *
 * @author Regisson Aguiar
 * @generated
 */
public class UserAccountCacheModel
	implements CacheModel<UserAccount>, Externalizable, MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserAccountCacheModel)) {
			return false;
		}

		UserAccountCacheModel userAccountCacheModel =
			(UserAccountCacheModel)object;

		if ((userAccountId == userAccountCacheModel.userAccountId) &&
			(mvccVersion == userAccountCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, userAccountId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", userAccountId=");
		sb.append(userAccountId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userNameAccount=");
		sb.append(userNameAccount);
		sb.append(", userFirstName=");
		sb.append(userFirstName);
		sb.append(", userLastName=");
		sb.append(userLastName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserAccount toEntityModel() {
		UserAccountImpl userAccountImpl = new UserAccountImpl();

		userAccountImpl.setMvccVersion(mvccVersion);

		if (uuid == null) {
			userAccountImpl.setUuid("");
		}
		else {
			userAccountImpl.setUuid(uuid);
		}

		userAccountImpl.setUserAccountId(userAccountId);
		userAccountImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			userAccountImpl.setCreateDate(null);
		}
		else {
			userAccountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userAccountImpl.setModifiedDate(null);
		}
		else {
			userAccountImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userNameAccount == null) {
			userAccountImpl.setUserNameAccount("");
		}
		else {
			userAccountImpl.setUserNameAccount(userNameAccount);
		}

		if (userFirstName == null) {
			userAccountImpl.setUserFirstName("");
		}
		else {
			userAccountImpl.setUserFirstName(userFirstName);
		}

		if (userLastName == null) {
			userAccountImpl.setUserLastName("");
		}
		else {
			userAccountImpl.setUserLastName(userLastName);
		}

		userAccountImpl.resetOriginalValues();

		return userAccountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();
		uuid = objectInput.readUTF();

		userAccountId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userNameAccount = objectInput.readUTF();
		userFirstName = objectInput.readUTF();
		userLastName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userAccountId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (userNameAccount == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userNameAccount);
		}

		if (userFirstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userFirstName);
		}

		if (userLastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userLastName);
		}
	}

	public long mvccVersion;
	public String uuid;
	public long userAccountId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String userNameAccount;
	public String userFirstName;
	public String userLastName;

}