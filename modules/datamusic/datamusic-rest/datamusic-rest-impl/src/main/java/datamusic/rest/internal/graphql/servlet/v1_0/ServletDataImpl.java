package datamusic.rest.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import datamusic.rest.internal.graphql.mutation.v1_0.Mutation;
import datamusic.rest.internal.graphql.query.v1_0.Query;
import datamusic.rest.resource.v1_0.CollectionItemResource;
import datamusic.rest.resource.v1_0.MediaResource;
import datamusic.rest.resource.v1_0.UserAccountResource;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author me
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCollectionItemResourceComponentServiceObjects(
			_collectionItemResourceComponentServiceObjects);
		Mutation.setMediaResourceComponentServiceObjects(
			_mediaResourceComponentServiceObjects);
		Mutation.setUserAccountResourceComponentServiceObjects(
			_userAccountResourceComponentServiceObjects);

		Query.setCollectionItemResourceComponentServiceObjects(
			_collectionItemResourceComponentServiceObjects);
		Query.setMediaResourceComponentServiceObjects(
			_mediaResourceComponentServiceObjects);
		Query.setUserAccountResourceComponentServiceObjects(
			_userAccountResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/datamusic-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CollectionItemResource>
		_collectionItemResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<MediaResource>
		_mediaResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<UserAccountResource>
		_userAccountResourceComponentServiceObjects;

}