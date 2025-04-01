package datamusic.rest.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;

import datamusic.rest.dto.v1_0.CollectionItem;
import datamusic.rest.dto.v1_0.Media;
import datamusic.rest.dto.v1_0.UserAccount;
import datamusic.rest.resource.v1_0.CollectionItemResource;
import datamusic.rest.resource.v1_0.MediaResource;
import datamusic.rest.resource.v1_0.UserAccountResource;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author me
 * @generated
 */
@Generated("")
public class Query {

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {collectionItem{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CollectionItemPage collectionItem() throws Exception {
		return _applyComponentServiceObjects(
			_collectionItemResourceComponentServiceObjects,
			this::_populateResourceContext,
			collectionItemResource -> new CollectionItemPage(
				collectionItemResource.getCollectionItem()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {media{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public MediaPage media() throws Exception {
		return _applyComponentServiceObjects(
			_mediaResourceComponentServiceObjects,
			this::_populateResourceContext,
			mediaResource -> new MediaPage(mediaResource.getMedia()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {mediaById(mediaId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public MediaPage mediaById(@GraphQLName("mediaId") Integer mediaId)
		throws Exception {

		return _applyComponentServiceObjects(
			_mediaResourceComponentServiceObjects,
			this::_populateResourceContext,
			mediaResource -> new MediaPage(
				mediaResource.getMediaById(mediaId)));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {userAccount{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public UserAccountPage userAccount() throws Exception {
		return _applyComponentServiceObjects(
			_userAccountResourceComponentServiceObjects,
			this::_populateResourceContext,
			userAccountResource -> new UserAccountPage(
				userAccountResource.getUserAccount()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {userAccountIdById(userAccountId: ___){userAccountId, userNameAccount, userFirstName, userLastName}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public UserAccount userAccountIdById(
			@GraphQLName("userAccountId") Integer userAccountId)
		throws Exception {

		return _applyComponentServiceObjects(
			_userAccountResourceComponentServiceObjects,
			this::_populateResourceContext,
			userAccountResource -> userAccountResource.getUserAccountIdById(
				userAccountId));
	}

	@GraphQLTypeExtension(CollectionItem.class)
	public class GetUserAccountIdByIdTypeExtension {

		public GetUserAccountIdByIdTypeExtension(
			CollectionItem collectionItem) {

			_collectionItem = collectionItem;
		}

		@GraphQLField
		public UserAccount userAccountIdById() throws Exception {
			return _applyComponentServiceObjects(
				_userAccountResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				userAccountResource -> userAccountResource.getUserAccountIdById(
                        Math.toIntExact(_collectionItem.getUserAccountId())));
		}

		private CollectionItem _collectionItem;

	}

	@GraphQLName("CollectionItemPage")
	public class CollectionItemPage {

		public CollectionItemPage(Page collectionItemPage) {
			actions = collectionItemPage.getActions();

			items = collectionItemPage.getItems();
			lastPage = collectionItemPage.getLastPage();
			page = collectionItemPage.getPage();
			pageSize = collectionItemPage.getPageSize();
			totalCount = collectionItemPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<CollectionItem> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("MediaPage")
	public class MediaPage {

		public MediaPage(Page mediaPage) {
			actions = mediaPage.getActions();

			items = mediaPage.getItems();
			lastPage = mediaPage.getLastPage();
			page = mediaPage.getPage();
			pageSize = mediaPage.getPageSize();
			totalCount = mediaPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Media> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("UserAccountPage")
	public class UserAccountPage {

		public UserAccountPage(Page userAccountPage) {
			actions = userAccountPage.getActions();

			items = userAccountPage.getItems();
			lastPage = userAccountPage.getLastPage();
			page = userAccountPage.getPage();
			pageSize = userAccountPage.getPageSize();
			totalCount = userAccountPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<UserAccount> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

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
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}