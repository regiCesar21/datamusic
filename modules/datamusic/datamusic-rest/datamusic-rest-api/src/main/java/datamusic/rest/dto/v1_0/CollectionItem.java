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
	description = "https://schema.org/CollectionItem", value = "CollectionItem"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "CollectionItem")
public class CollectionItem implements Serializable {

	public static CollectionItem toDTO(String json) {
		return ObjectMapperUtil.readValue(CollectionItem.class, json);
	}

	public static CollectionItem unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(CollectionItem.class, json);
	}

	@Schema
	public Long getCollectionItemId() {
		return collectionItemId;
	}

	public void setCollectionItemId(Long collectionItemId) {
		this.collectionItemId = collectionItemId;
	}

	@JsonIgnore
	public void setCollectionItemId(
		UnsafeSupplier<Long, Exception> collectionItemIdUnsafeSupplier) {

		try {
			collectionItemId = collectionItemIdUnsafeSupplier.get();
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
	protected Long collectionItemId;

	@Schema
	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	@JsonIgnore
	public void setMediaId(
		UnsafeSupplier<Long, Exception> mediaIdUnsafeSupplier) {

		try {
			mediaId = mediaIdUnsafeSupplier.get();
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
	protected Long mediaId;

	@Schema
	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	@JsonIgnore
	public void setRating(
		UnsafeSupplier<Long, Exception> ratingUnsafeSupplier) {

		try {
			rating = ratingUnsafeSupplier.get();
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
	protected Long rating;

	@Schema
	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@JsonIgnore
	public void setReview(
		UnsafeSupplier<String, Exception> reviewUnsafeSupplier) {

		try {
			review = reviewUnsafeSupplier.get();
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
	protected String review;

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

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CollectionItem)) {
			return false;
		}

		CollectionItem collectionItem = (CollectionItem)object;

		return Objects.equals(toString(), collectionItem.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (collectionItemId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"collectionItemId\": ");

			sb.append(collectionItemId);
		}

		if (mediaId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"mediaId\": ");

			sb.append(mediaId);
		}

		if (rating != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"rating\": ");

			sb.append(rating);
		}

		if (review != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"review\": ");

			sb.append("\"");

			sb.append(_escape(review));

			sb.append("\"");
		}

		if (userAccountId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userAccountId\": ");

			sb.append(userAccountId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "datamusic.rest.dto.v1_0.CollectionItem",
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