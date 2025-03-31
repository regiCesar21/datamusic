package datamusic.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import datamusic.rest.client.dto.v1_0.CollectionItem;
import datamusic.rest.client.http.HttpInvoker;
import datamusic.rest.client.pagination.Page;
import datamusic.rest.client.resource.v1_0.CollectionItemResource;
import datamusic.rest.client.serdes.v1_0.CollectionItemSerDes;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author me
 * @generated
 */
@Generated("")
public abstract class BaseCollectionItemResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_collectionItemResource.setContextCompany(testCompany);

		CollectionItemResource.Builder builder =
			CollectionItemResource.builder();

		collectionItemResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		CollectionItem collectionItem1 = randomCollectionItem();

		String json = objectMapper.writeValueAsString(collectionItem1);

		CollectionItem collectionItem2 = CollectionItemSerDes.toDTO(json);

		Assert.assertTrue(equals(collectionItem1, collectionItem2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		CollectionItem collectionItem = randomCollectionItem();

		String json1 = objectMapper.writeValueAsString(collectionItem);
		String json2 = CollectionItemSerDes.toJSON(collectionItem);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		CollectionItem collectionItem = randomCollectionItem();

		collectionItem.setReview(regex);

		String json = CollectionItemSerDes.toJSON(collectionItem);

		Assert.assertFalse(json.contains(regex));

		collectionItem = CollectionItemSerDes.toDTO(json);

		Assert.assertEquals(regex, collectionItem.getReview());
	}

	@Test
	public void testGetCollectionItem() throws Exception {
		Page<CollectionItem> page = collectionItemResource.getCollectionItem();

		long totalCount = page.getTotalCount();

		CollectionItem collectionItem1 =
			testGetCollectionItem_addCollectionItem(randomCollectionItem());

		CollectionItem collectionItem2 =
			testGetCollectionItem_addCollectionItem(randomCollectionItem());

		page = collectionItemResource.getCollectionItem();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(collectionItem1, (List<CollectionItem>)page.getItems());
		assertContains(collectionItem2, (List<CollectionItem>)page.getItems());
		assertValid(page);
	}

	protected CollectionItem testGetCollectionItem_addCollectionItem(
			CollectionItem collectionItem)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostCollectionItem() throws Exception {
		CollectionItem randomCollectionItem = randomCollectionItem();

		CollectionItem postCollectionItem =
			testPostCollectionItem_addCollectionItem(randomCollectionItem);

		assertEquals(randomCollectionItem, postCollectionItem);
		assertValid(postCollectionItem);
	}

	protected CollectionItem testPostCollectionItem_addCollectionItem(
			CollectionItem collectionItem)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		CollectionItem collectionItem, List<CollectionItem> collectionItems) {

		boolean contains = false;

		for (CollectionItem item : collectionItems) {
			if (equals(collectionItem, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			collectionItems + " does not contain " + collectionItem, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		CollectionItem collectionItem1, CollectionItem collectionItem2) {

		Assert.assertTrue(
			collectionItem1 + " does not equal " + collectionItem2,
			equals(collectionItem1, collectionItem2));
	}

	protected void assertEquals(
		List<CollectionItem> collectionItems1,
		List<CollectionItem> collectionItems2) {

		Assert.assertEquals(collectionItems1.size(), collectionItems2.size());

		for (int i = 0; i < collectionItems1.size(); i++) {
			CollectionItem collectionItem1 = collectionItems1.get(i);
			CollectionItem collectionItem2 = collectionItems2.get(i);

			assertEquals(collectionItem1, collectionItem2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<CollectionItem> collectionItems1,
		List<CollectionItem> collectionItems2) {

		Assert.assertEquals(collectionItems1.size(), collectionItems2.size());

		for (CollectionItem collectionItem1 : collectionItems1) {
			boolean contains = false;

			for (CollectionItem collectionItem2 : collectionItems2) {
				if (equals(collectionItem1, collectionItem2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				collectionItems2 + " does not contain " + collectionItem1,
				contains);
		}
	}

	protected void assertValid(CollectionItem collectionItem) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("collectionItemId", additionalAssertFieldName)) {
				if (collectionItem.getCollectionItemId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mediaId", additionalAssertFieldName)) {
				if (collectionItem.getMediaId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("rating", additionalAssertFieldName)) {
				if (collectionItem.getRating() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("review", additionalAssertFieldName)) {
				if (collectionItem.getReview() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userAccountId", additionalAssertFieldName)) {
				if (collectionItem.getUserAccountId() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<CollectionItem> page) {
		boolean valid = false;

		java.util.Collection<CollectionItem> collectionItems = page.getItems();

		int size = collectionItems.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					datamusic.rest.dto.v1_0.CollectionItem.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		CollectionItem collectionItem1, CollectionItem collectionItem2) {

		if (collectionItem1 == collectionItem2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("collectionItemId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						collectionItem1.getCollectionItemId(),
						collectionItem2.getCollectionItemId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mediaId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						collectionItem1.getMediaId(),
						collectionItem2.getMediaId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("rating", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						collectionItem1.getRating(),
						collectionItem2.getRating())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("review", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						collectionItem1.getReview(),
						collectionItem2.getReview())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userAccountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						collectionItem1.getUserAccountId(),
						collectionItem2.getUserAccountId())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_collectionItemResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_collectionItemResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		CollectionItem collectionItem) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("collectionItemId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("mediaId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("rating")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("review")) {
			sb.append("'");
			sb.append(String.valueOf(collectionItem.getReview()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userAccountId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected CollectionItem randomCollectionItem() throws Exception {
		return new CollectionItem() {
			{
				collectionItemId = RandomTestUtil.randomLong();
				mediaId = RandomTestUtil.randomLong();
				rating = RandomTestUtil.randomLong();
				review = StringUtil.toLowerCase(RandomTestUtil.randomString());
				userAccountId = RandomTestUtil.randomLong();
			}
		};
	}

	protected CollectionItem randomIrrelevantCollectionItem() throws Exception {
		CollectionItem randomIrrelevantCollectionItem = randomCollectionItem();

		return randomIrrelevantCollectionItem;
	}

	protected CollectionItem randomPatchCollectionItem() throws Exception {
		return randomCollectionItem();
	}

	protected CollectionItemResource collectionItemResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseCollectionItemResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private datamusic.rest.resource.v1_0.CollectionItemResource
		_collectionItemResource;

}