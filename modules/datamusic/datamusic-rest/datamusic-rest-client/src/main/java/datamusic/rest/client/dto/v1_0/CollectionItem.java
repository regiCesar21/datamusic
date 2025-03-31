package datamusic.rest.client.dto.v1_0;

import datamusic.rest.client.function.UnsafeSupplier;
import datamusic.rest.client.serdes.v1_0.CollectionItemSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class CollectionItem implements Cloneable, Serializable {

	public static CollectionItem toDTO(String json) {
		return CollectionItemSerDes.toDTO(json);
	}

	public Long getCollectionItemId() {
		return collectionItemId;
	}

	public void setCollectionItemId(Long collectionItemId) {
		this.collectionItemId = collectionItemId;
	}

	public void setCollectionItemId(
		UnsafeSupplier<Long, Exception> collectionItemIdUnsafeSupplier) {

		try {
			collectionItemId = collectionItemIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long collectionItemId;

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public void setMediaId(
		UnsafeSupplier<Long, Exception> mediaIdUnsafeSupplier) {

		try {
			mediaId = mediaIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long mediaId;

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

	public void setRating(
		UnsafeSupplier<Long, Exception> ratingUnsafeSupplier) {

		try {
			rating = ratingUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long rating;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public void setReview(
		UnsafeSupplier<String, Exception> reviewUnsafeSupplier) {

		try {
			review = reviewUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String review;

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

	@Override
	public CollectionItem clone() throws CloneNotSupportedException {
		return (CollectionItem)super.clone();
	}

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
		return CollectionItemSerDes.toJSON(this);
	}

}