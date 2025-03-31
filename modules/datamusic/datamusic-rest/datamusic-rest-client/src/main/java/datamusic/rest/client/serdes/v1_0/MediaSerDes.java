package datamusic.rest.client.serdes.v1_0;

import datamusic.rest.client.dto.v1_0.Media;
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
public class MediaSerDes {

	public static Media toDTO(String json) {
		MediaJSONParser mediaJSONParser = new MediaJSONParser();

		return mediaJSONParser.parseToDTO(json);
	}

	public static Media[] toDTOs(String json) {
		MediaJSONParser mediaJSONParser = new MediaJSONParser();

		return mediaJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Media media) {
		if (media == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (media.getArtist() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"artist\": ");

			sb.append("\"");

			sb.append(_escape(media.getArtist()));

			sb.append("\"");
		}

		if (media.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(media.getDescription()));

			sb.append("\"");
		}

		if (media.getGenre() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"genre\": ");

			sb.append("\"");

			sb.append(_escape(media.getGenre()));

			sb.append("\"");
		}

		if (media.getMediaId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mediaId\": ");

			sb.append(media.getMediaId());
		}

		if (media.getMediaName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mediaName\": ");

			sb.append("\"");

			sb.append(_escape(media.getMediaName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		MediaJSONParser mediaJSONParser = new MediaJSONParser();

		return mediaJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Media media) {
		if (media == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (media.getArtist() == null) {
			map.put("artist", null);
		}
		else {
			map.put("artist", String.valueOf(media.getArtist()));
		}

		if (media.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(media.getDescription()));
		}

		if (media.getGenre() == null) {
			map.put("genre", null);
		}
		else {
			map.put("genre", String.valueOf(media.getGenre()));
		}

		if (media.getMediaId() == null) {
			map.put("mediaId", null);
		}
		else {
			map.put("mediaId", String.valueOf(media.getMediaId()));
		}

		if (media.getMediaName() == null) {
			map.put("mediaName", null);
		}
		else {
			map.put("mediaName", String.valueOf(media.getMediaName()));
		}

		return map;
	}

	public static class MediaJSONParser extends BaseJSONParser<Media> {

		@Override
		protected Media createDTO() {
			return new Media();
		}

		@Override
		protected Media[] createDTOArray(int size) {
			return new Media[size];
		}

		@Override
		protected void setField(
			Media media, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "artist")) {
				if (jsonParserFieldValue != null) {
					media.setArtist((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					media.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "genre")) {
				if (jsonParserFieldValue != null) {
					media.setGenre((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mediaId")) {
				if (jsonParserFieldValue != null) {
					media.setMediaId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "mediaName")) {
				if (jsonParserFieldValue != null) {
					media.setMediaName((String)jsonParserFieldValue);
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