package datamusic.rest.internal.resource.v1_0;

import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import datamusic.rest.dto.v1_0.CollectionItem;
import datamusic.rest.resource.v1_0.CollectionItemResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Collection;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/collection-item.properties",
	scope = ServiceScope.PROTOTYPE, service = CollectionItemResource.class
)
public class CollectionItemResourceImpl extends BaseCollectionItemResourceImpl {
	@Override
	public void setContextBatchUnsafeBiConsumer(UnsafeBiConsumer<Collection<CollectionItem>, UnsafeFunction<CollectionItem, CollectionItem, Exception>, Exception> unsafeBiConsumer) {

	}
}