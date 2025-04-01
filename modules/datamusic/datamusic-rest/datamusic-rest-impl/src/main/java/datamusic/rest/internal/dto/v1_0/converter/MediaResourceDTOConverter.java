package datamusic.rest.internal.dto.v1_0.converter;

import datamusic.rest.dto.v1_0.Media;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;



import org.osgi.service.component.annotations.Component;

/**
 * @author Regisson Aguiar
 */
@Component(
        property = "dto.class.name=com.datamusic.app.model.Media",
        service = DTOConverter.class
)
public class MediaResourceDTOConverter
        implements DTOConverter<com.datamusic.app.model.Media, Media> {

    @Override
    public String getContentType() {
        return Media.class.getSimpleName();
    }

    @Override
    public Media toDTO(
            DTOConverterContext dtoConverterContext,
            com.datamusic.app.model.Media media) throws Exception {

        return new Media() {
            {
                setMediaName(media::getMediaName);
                setArtist(media::getArtist);
                setDescription(media::getDescription);
                setGenre(media::getGenre);
            }
        };
    }

}
