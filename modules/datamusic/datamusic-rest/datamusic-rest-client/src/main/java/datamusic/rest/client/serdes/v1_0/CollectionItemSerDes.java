package datamusic.rest.client.serdes.v1_0;

import datamusic.rest.client.dto.v1_0.CollectionItem;
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
public class CollectionItemSerDes {

	public static CollectionItem toDTO(String json) {
		CollectionItemJSONParser collectionItemJSONParser =
			new CollectionItemJSONParser();

		return collectionItemJSONParser.parseToDTO(json);
	}

	public static CollectionItem[] toDTOs(String json) {
		CollectionItemJSONParser collectionItemJSONParser =
			new CollectionItemJSONParser();

		return collectionItemJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CollectionItem collectionItem) {
		if (collectionItem == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (collectionItem.getCollectionItemId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"collectionItemId\": ");

			sb.append(collectionItem.getCollectionItemId());
		}

		if (collectionItem.getMediaId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mediaId\": ");

			sb.append(collectionItem.getMediaId());
		}

		if (collectionItem.getRating() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rating\": ");

			sb.append(collectionItem.getRating());
		}

		if (collectionItem.getReview() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"review\": ");

			sb.append("\"");

			sb.append(_escape(collectionItem.getReview()));

			sb.append("\"");
		}

		if (collectionItem.getUserAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userAccountId\": ");

			sb.append(collectionItem.getUserAccountId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CollectionItemJSONParser collectionItemJSONParser =
			new CollectionItemJSONParser();

		return collectionItemJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CollectionItem collectionItem) {
		if (collectionItem == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (collectionItem.getCollectionItemId() == null) {
			map.put("collectionItemId", null);
		}
		else {
			map.put(
				"collectionItemId",
				String.valueOf(collectionItem.getCollectionItemId()));
		}

		if (collectionItem.getMediaId() == null) {
			map.put("mediaId", null);
		}
		else {
			map.put("mediaId", String.valueOf(collectionItem.getMediaId()));
		}

		if (collectionItem.getRating() == null) {
			map.put("rating", null);
		}
		else {
			map.put("rating", String.valueOf(collectionItem.getRating()));
		}

		if (collectionItem.getReview() == null) {
			map.put("review", null);
		}
		else {
			map.put("review", String.valueOf(collectionItem.getReview()));
		}

		if (collectionItem.getUserAccountId() == null) {
			map.put("userAccountId", null);
		}
		else {
			map.put(
				"userAccountId",
				String.valueOf(collectionItem.getUserAccountId()));
		}

		return map;
	}

	public static class CollectionItemJSONParser
		extends BaseJSONParser<CollectionItem> {

		@Override
		protected CollectionItem createDTO() {
			return new CollectionItem();
		}

		@Override
		protected CollectionItem[] createDTOArray(int size) {
			return new CollectionItem[size];
		}

		@Override
		protected void setField(
			CollectionItem collectionItem, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "collectionItemId")) {
				if (jsonParserFieldValue != null) {
					collectionItem.setCollectionItemId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mediaId")) {
				if (jsonParserFieldValue != null) {
					collectionItem.setMediaId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "rating")) {
				if (jsonParserFieldValue != null) {
					collectionItem.setRating(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "review")) {
				if (jsonParserFieldValue != null) {
					collectionItem.setReview((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userAccountId")) {
				if (jsonParserFieldValue != null) {
					collectionItem.setUserAccountId(
						Long.valueOf((String)jsonParserFieldValue));
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