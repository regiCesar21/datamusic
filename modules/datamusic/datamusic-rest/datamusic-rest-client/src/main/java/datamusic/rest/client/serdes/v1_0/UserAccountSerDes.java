package datamusic.rest.client.serdes.v1_0;

import datamusic.rest.client.dto.v1_0.UserAccount;
import datamusic.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class UserAccountSerDes {

	public static UserAccount toDTO(String json) {
		UserAccountJSONParser userAccountJSONParser =
			new UserAccountJSONParser();

		return userAccountJSONParser.parseToDTO(json);
	}

	public static UserAccount[] toDTOs(String json) {
		UserAccountJSONParser userAccountJSONParser =
			new UserAccountJSONParser();

		return userAccountJSONParser.parseToDTOs(json);
	}

	public static String toJSON(UserAccount userAccount) {
		if (userAccount == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (userAccount.getUserAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userAccountId\": ");

			sb.append(userAccount.getUserAccountId());
		}

		if (userAccount.getUserFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userFirstName\": ");

			sb.append("\"");

			sb.append(_escape(userAccount.getUserFirstName()));

			sb.append("\"");
		}

		if (userAccount.getUserLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userLastName\": ");

			sb.append("\"");

			sb.append(_escape(userAccount.getUserLastName()));

			sb.append("\"");
		}

		if (userAccount.getUserNameAccount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userNameAccount\": ");

			sb.append("\"");

			sb.append(_escape(userAccount.getUserNameAccount()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		UserAccountJSONParser userAccountJSONParser =
			new UserAccountJSONParser();

		return userAccountJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(UserAccount userAccount) {
		if (userAccount == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (userAccount.getUserAccountId() == null) {
			map.put("userAccountId", null);
		}
		else {
			map.put(
				"userAccountId",
				String.valueOf(userAccount.getUserAccountId()));
		}

		if (userAccount.getUserFirstName() == null) {
			map.put("userFirstName", null);
		}
		else {
			map.put(
				"userFirstName",
				String.valueOf(userAccount.getUserFirstName()));
		}

		if (userAccount.getUserLastName() == null) {
			map.put("userLastName", null);
		}
		else {
			map.put(
				"userLastName", String.valueOf(userAccount.getUserLastName()));
		}

		if (userAccount.getUserNameAccount() == null) {
			map.put("userNameAccount", null);
		}
		else {
			map.put(
				"userNameAccount",
				String.valueOf(userAccount.getUserNameAccount()));
		}

		return map;
	}

	public static class UserAccountJSONParser
		extends BaseJSONParser<UserAccount> {

		@Override
		protected UserAccount createDTO() {
			return new UserAccount();
		}

		@Override
		protected UserAccount[] createDTOArray(int size) {
			return new UserAccount[size];
		}

		@Override
		protected void setField(
			UserAccount userAccount, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "userAccountId")) {
				if (jsonParserFieldValue != null) {
					userAccount.setUserAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userFirstName")) {
				if (jsonParserFieldValue != null) {
					userAccount.setUserFirstName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userLastName")) {
				if (jsonParserFieldValue != null) {
					userAccount.setUserLastName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userNameAccount")) {
				if (jsonParserFieldValue != null) {
					userAccount.setUserNameAccount(
						(String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}