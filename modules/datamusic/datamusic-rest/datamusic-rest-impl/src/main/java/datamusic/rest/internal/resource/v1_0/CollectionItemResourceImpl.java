package datamusic.rest.internal.resource.v1_0;

import datamusic.rest.resource.v1_0.CollectionItemResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author me
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/collection-item.properties",
	scope = ServiceScope.PROTOTYPE, service = CollectionItemResource.class
)
public class CollectionItemResourceImpl extends BaseCollectionItemResourceImpl {
}