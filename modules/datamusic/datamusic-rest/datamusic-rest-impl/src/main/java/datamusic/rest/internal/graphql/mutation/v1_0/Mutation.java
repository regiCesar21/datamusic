package datamusic.rest.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import datamusic.rest.dto.v1_0.CollectionItem;
import datamusic.rest.dto.v1_0.Media;
import datamusic.rest.dto.v1_0.UserAccount;
import datamusic.rest.resource.v1_0.CollectionItemResource;
import datamusic.rest.resource.v1_0.MediaResource;
import datamusic.rest.resource.v1_0.UserAccountResource;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Mutation {

	public static void setCollectionItemResourceComponentServiceObjects(
		ComponentServiceObjects<CollectionItemResource>
			collectionItemResourceComponentServiceObjects) {

		_collectionItemResourceComponentServiceObjects =
			collectionItemResourceComponentServiceObjects;
	}

	public static void setMediaResourceComponentServiceObjects(
		ComponentServiceObjects<MediaResource>
			mediaResourceComponentServiceObjects) {

		_mediaResourceComponentServiceObjects =
			mediaResourceComponentServiceObjects;
	}

	public static void setUserAccountResourceComponentServiceObjects(
		ComponentServiceObjects<UserAccountResource>
			userAccountResourceComponentServiceObjects) {

		_userAccountResourceComponentServiceObjects =
			userAccountResourceComponentServiceObjects;
	}

	@GraphQLField
	public CollectionItem createCollectionItem(
			@GraphQLName("collectionItem") CollectionItem collectionItem)
		throws Exception {

		return _applyComponentServiceObjects(
			_collectionItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			collectionItemResource -> collectionItemResource.postCollectionItem(
				collectionItem));
	}

	@GraphQLField
	public Response createCollectionItemBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_collectionItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			collectionItemResource ->
				collectionItemResource.postCollectionItemBatch(
					callbackURL, object));
	}

	@GraphQLField
	public Media createMedia(@GraphQLName("media") Media media)
		throws Exception {

		return _applyComponentServiceObjects(
			_mediaResourceComponentServiceObjects,
			this::_populateResourceContext,
			mediaResource -> mediaResource.postMedia(media));
	}

	@GraphQLField
	public Response createMediaBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_mediaResourceComponentServiceObjects,
			this::_populateResourceContext,
			mediaResource -> mediaResource.postMediaBatch(callbackURL, object));
	}

	@GraphQLField
	public java.util.Collection<Media> deleteMediaById(
			@GraphQLName("mediaId") Integer mediaId)
		throws Exception {

		return _applyComponentServiceObjects(
			_mediaResourceComponentServiceObjects,
			this::_populateResourceContext,
			mediaResource -> {
				Page paginationPage = mediaResource.deleteMediaById(mediaId);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	public UserAccount createUserAccount(
			@GraphQLName("userAccount") UserAccount userAccount)
		throws Exception {

		return _applyComponentServiceObjects(
			_userAccountResourceComponentServiceObjects,
			this::_populateResourceContext,
			userAccountResource -> userAccountResource.postUserAccount(
				userAccount));
	}

	@GraphQLField
	public Response createUserAccountBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_userAccountResourceComponentServiceObjects,
			this::_populateResourceContext,
			userAccountResource -> userAccountResource.postUserAccountBatch(
				callbackURL, object));
	}

	@GraphQLField
	public Response deleteUserAccountById(
			@GraphQLName("userAccountId") Integer userAccountId)
		throws Exception {

		return _applyComponentServiceObjects(
			_userAccountResourceComponentServiceObjects,
			this::_populateResourceContext,
			userAccountResource -> userAccountResource.deleteUserAccountById(
				userAccountId));
	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			CollectionItemResource collectionItemResource)
		throws Exception {

		collectionItemResource.setContextAcceptLanguage(_acceptLanguage);
		collectionItemResource.setContextCompany(_company);
		collectionItemResource.setContextHttpServletRequest(
			_httpServletRequest);
		collectionItemResource.setContextHttpServletResponse(
			_httpServletResponse);
		collectionItemResource.setContextUriInfo(_uriInfo);
		collectionItemResource.setContextUser(_user);
		collectionItemResource.setGroupLocalService(_groupLocalService);
		collectionItemResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(MediaResource mediaResource)
		throws Exception {

		mediaResource.setContextAcceptLanguage(_acceptLanguage);
		mediaResource.setContextCompany(_company);
		mediaResource.setContextHttpServletRequest(_httpServletRequest);
		mediaResource.setContextHttpServletResponse(_httpServletResponse);
		mediaResource.setContextUriInfo(_uriInfo);
		mediaResource.setContextUser(_user);
		mediaResource.setGroupLocalService(_groupLocalService);
		mediaResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			UserAccountResource userAccountResource)
		throws Exception {

		userAccountResource.setContextAcceptLanguage(_acceptLanguage);
		userAccountResource.setContextCompany(_company);
		userAccountResource.setContextHttpServletRequest(_httpServletRequest);
		userAccountResource.setContextHttpServletResponse(_httpServletResponse);
		userAccountResource.setContextUriInfo(_uriInfo);
		userAccountResource.setContextUser(_user);
		userAccountResource.setGroupLocalService(_groupLocalService);
		userAccountResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CollectionItemResource>
		_collectionItemResourceComponentServiceObjects;
	private static ComponentServiceObjects<MediaResource>
		_mediaResourceComponentServiceObjects;
	private static ComponentServiceObjects<UserAccountResource>
		_userAccountResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}