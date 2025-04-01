package datamusic.rest.internal.dto.v1_0.converter;

import datamusic.rest.dto.v1_0.CollectionItem;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;



import org.osgi.service.component.annotations.Component;

/**
 * @author Regisson Aguiar
 */
@Component(
        property = "dto.class.name=com.datamusic.app.model.CollectionItem",
        service = DTOConverter.class
)
public class CollectionItemResourceDTOConverter
        implements DTOConverter<com.datamusic.app.model.CollectionItem, CollectionItem> {

    @Override
    public String getContentType() {
        return CollectionItem.class.getSimpleName();
    }

    @Override
    public CollectionItem toDTO(
            DTOConverterContext dtoConverterContext,
            com.datamusic.app.model.CollectionItem collectionItem) throws Exception {

        return new CollectionItem() {
            {
                setUserAccountId(collectionItem::getUserAccountId);
                setMediaId(collectionItem::getMediaId);
                setReview(collectionItem::getReview);
                setRating(collectionItem::getRating);
            }
        };
    }

}
