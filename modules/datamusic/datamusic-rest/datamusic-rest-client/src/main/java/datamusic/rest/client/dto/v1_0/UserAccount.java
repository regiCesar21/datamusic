package datamusic.rest.client.dto.v1_0;

import datamusic.rest.client.function.UnsafeSupplier;
import datamusic.rest.client.serdes.v1_0.UserAccountSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class UserAccount implements Cloneable, Serializable {

	public static UserAccount toDTO(String json) {
		return UserAccountSerDes.toDTO(json);
	}

	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	public void setUserAccountId(
		UnsafeSupplier<Long, Exception> userAccountIdUnsafeSupplier) {

		try {
			userAccountId = userAccountIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long userAccountId;

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public void setUserFirstName(
		UnsafeSupplier<String, Exception> userFirstNameUnsafeSupplier) {

		try {
			userFirstName = userFirstNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String userFirstName;

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public void setUserLastName(
		UnsafeSupplier<String, Exception> userLastNameUnsafeSupplier) {

		try {
			userLastName = userLastNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String userLastName;

	public String getUserNameAccount() {
		return userNameAccount;
	}

	public void setUserNameAccount(String userNameAccount) {
		this.userNameAccount = userNameAccount;
	}

	public void setUserNameAccount(
		UnsafeSupplier<String, Exception> userNameAccountUnsafeSupplier) {

		try {
			userNameAccount = userNameAccountUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String userNameAccount;

	@Override
	public UserAccount clone() throws CloneNotSupportedException {
		return (UserAccount)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserAccount)) {
			return false;
		}

		UserAccount userAccount = (UserAccount)object;

		return Objects.equals(toString(), userAccount.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return UserAccountSerDes.toJSON(this);
	}

}