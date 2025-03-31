/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.datamusic.app.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserAccount}.
 * </p>
 *
 * @author Regisson Aguiar
 * @see UserAccount
 * @generated
 */
public class UserAccountWrapper
	extends BaseModelWrapper<UserAccount>
	implements ModelWrapper<UserAccount>, UserAccount {

	public UserAccountWrapper(UserAccount userAccount) {
		super(userAccount);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("userAccountId", getUserAccountId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userNameAccount", getUserNameAccount());
		attributes.put("userFirstName", getUserFirstName());
		attributes.put("userLastName", getUserLastName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userAccountId = (Long)attributes.get("userAccountId");

		if (userAccountId != null) {
			setUserAccountId(userAccountId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String userNameAccount = (String)attributes.get("userNameAccount");

		if (userNameAccount != null) {
			setUserNameAccount(userNameAccount);
		}

		String userFirstName = (String)attributes.get("userFirstName");

		if (userFirstName != null) {
			setUserFirstName(userFirstName);
		}

		String userLastName = (String)attributes.get("userLastName");

		if (userLastName != null) {
			setUserLastName(userLastName);
		}
	}

	@Override
	public UserAccount cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this user account.
	 *
	 * @return the company ID of this user account
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this user account.
	 *
	 * @return the create date of this user account
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this user account.
	 *
	 * @return the modified date of this user account
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this user account.
	 *
	 * @return the mvcc version of this user account
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this user account.
	 *
	 * @return the primary key of this user account
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user account ID of this user account.
	 *
	 * @return the user account ID of this user account
	 */
	@Override
	public long getUserAccountId() {
		return model.getUserAccountId();
	}

	/**
	 * Returns the user first name of this user account.
	 *
	 * @return the user first name of this user account
	 */
	@Override
	public String getUserFirstName() {
		return model.getUserFirstName();
	}

	/**
	 * Returns the user last name of this user account.
	 *
	 * @return the user last name of this user account
	 */
	@Override
	public String getUserLastName() {
		return model.getUserLastName();
	}

	/**
	 * Returns the user name account of this user account.
	 *
	 * @return the user name account of this user account
	 */
	@Override
	public String getUserNameAccount() {
		return model.getUserNameAccount();
	}

	/**
	 * Returns the uuid of this user account.
	 *
	 * @return the uuid of this user account
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this user account.
	 *
	 * @param companyId the company ID of this user account
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this user account.
	 *
	 * @param createDate the create date of this user account
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this user account.
	 *
	 * @param modifiedDate the modified date of this user account
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this user account.
	 *
	 * @param mvccVersion the mvcc version of this user account
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this user account.
	 *
	 * @param primaryKey the primary key of this user account
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user account ID of this user account.
	 *
	 * @param userAccountId the user account ID of this user account
	 */
	@Override
	public void setUserAccountId(long userAccountId) {
		model.setUserAccountId(userAccountId);
	}

	/**
	 * Sets the user first name of this user account.
	 *
	 * @param userFirstName the user first name of this user account
	 */
	@Override
	public void setUserFirstName(String userFirstName) {
		model.setUserFirstName(userFirstName);
	}

	/**
	 * Sets the user last name of this user account.
	 *
	 * @param userLastName the user last name of this user account
	 */
	@Override
	public void setUserLastName(String userLastName) {
		model.setUserLastName(userLastName);
	}

	/**
	 * Sets the user name account of this user account.
	 *
	 * @param userNameAccount the user name account of this user account
	 */
	@Override
	public void setUserNameAccount(String userNameAccount) {
		model.setUserNameAccount(userNameAccount);
	}

	/**
	 * Sets the uuid of this user account.
	 *
	 * @param uuid the uuid of this user account
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected UserAccountWrapper wrap(UserAccount userAccount) {
		return new UserAccountWrapper(userAccount);
	}

}