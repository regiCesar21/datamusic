package datamusic.rest.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author me
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "https://schema.org/UserAccount", value = "UserAccount"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "UserAccount")
public class UserAccount implements Serializable {

	public static UserAccount toDTO(String json) {
		return ObjectMapperUtil.readValue(UserAccount.class, json);
	}

	public static UserAccount unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(UserAccount.class, json);
	}

	@Schema
	public Long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(Long userAccountId) {
		this.userAccountId = userAccountId;
	}

	@JsonIgnore
	public void setUserAccountId(
		UnsafeSupplier<Long, Exception> userAccountIdUnsafeSupplier) {

		try {
			userAccountId = userAccountIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long userAccountId;

	@Schema
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	@JsonIgnore
	public void setUserFirstName(
		UnsafeSupplier<String, Exception> userFirstNameUnsafeSupplier) {

		try {
			userFirstName = userFirstNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String userFirstName;

	@Schema
	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@JsonIgnore
	public void setUserLastName(
		UnsafeSupplier<String, Exception> userLastNameUnsafeSupplier) {

		try {
			userLastName = userLastNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String userLastName;

	@Schema
	public String getUserNameAccount() {
		return userNameAccount;
	}

	public void setUserNameAccount(String userNameAccount) {
		this.userNameAccount = userNameAccount;
	}

	@JsonIgnore
	public void setUserNameAccount(
		UnsafeSupplier<String, Exception> userNameAccountUnsafeSupplier) {

		try {
			userNameAccount = userNameAccountUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String userNameAccount;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (userAccountId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userAccountId\": ");

			sb.append(userAccountId);
		}

		if (userFirstName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userFirstName\": ");

			sb.append("\"");

			sb.append(_escape(userFirstName));

			sb.append("\"");
		}

		if (userLastName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userLastName\": ");

			sb.append("\"");

			sb.append(_escape(userLastName));

			sb.append("\"");
		}

		if (userNameAccount != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userNameAccount\": ");

			sb.append("\"");

			sb.append(_escape(userNameAccount));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "datamusic.rest.dto.v1_0.UserAccount",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}