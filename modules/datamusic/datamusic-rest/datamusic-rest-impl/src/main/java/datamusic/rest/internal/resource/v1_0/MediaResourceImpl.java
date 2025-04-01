package datamusic.rest.internal.resource.v1_0;

import com.datamusic.app.service.MediaLocalService;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import datamusic.rest.dto.v1_0.Media;
import datamusic.rest.resource.v1_0.MediaResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/media.properties",
	scope = ServiceScope.PROTOTYPE, service = MediaResource.class
)
public class MediaResourceImpl extends BaseMediaResourceImpl {


	public Media postMedia(Media media) throws Exception {
		com.datamusic.app.model.Media media1 = _mediaLocalService.createMedia(0, media.getMediaName(), media.getArtist(), media.getDescription(), media.getGenre());
		return new Media(){
			{
				setMediaName(media1::getMediaName);
				setArtist(media1::getArtist);
				setDescription(media1::getDescription);
				setGenre(media1::getGenre);
			}
		};
	}

	@Reference
	private MediaLocalService _mediaLocalService;

	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<Media>, UnsafeFunction<Media, Media, Exception>, Exception> unsafeBiConsumer) {

	}
}