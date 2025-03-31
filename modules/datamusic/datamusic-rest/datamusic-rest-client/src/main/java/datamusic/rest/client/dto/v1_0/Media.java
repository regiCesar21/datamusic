package datamusic.rest.client.dto.v1_0;

import datamusic.rest.client.function.UnsafeSupplier;
import datamusic.rest.client.serdes.v1_0.MediaSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Media implements Cloneable, Serializable {

	public static Media toDTO(String json) {
		return MediaSerDes.toDTO(json);
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setArtist(
		UnsafeSupplier<String, Exception> artistUnsafeSupplier) {

		try {
			artist = artistUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String artist;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String description;

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setGenre(
		UnsafeSupplier<String, Exception> genreUnsafeSupplier) {

		try {
			genre = genreUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String genre;

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

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public void setMediaName(
		UnsafeSupplier<String, Exception> mediaNameUnsafeSupplier) {

		try {
			mediaName = mediaNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String mediaName;

	@Override
	public Media clone() throws CloneNotSupportedException {
		return (Media)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Media)) {
			return false;
		}

		Media media = (Media)object;

		return Objects.equals(toString(), media.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return MediaSerDes.toJSON(this);
	}

}