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

import datamusic.rest.client.dto.v1_0.Media;
import datamusic.rest.client.http.HttpInvoker;
import datamusic.rest.client.pagination.Page;
import datamusic.rest.client.resource.v1_0.MediaResource;
import datamusic.rest.client.serdes.v1_0.MediaSerDes;

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
public abstract class BaseMediaResourceTestCase {

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

		_mediaResource.setContextCompany(testCompany);

		MediaResource.Builder builder = MediaResource.builder();

		mediaResource = builder.authentication(
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

		Media media1 = randomMedia();

		String json = objectMapper.writeValueAsString(media1);

		Media media2 = MediaSerDes.toDTO(json);

		Assert.assertTrue(equals(media1, media2));
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

		Media media = randomMedia();

		String json1 = objectMapper.writeValueAsString(media);
		String json2 = MediaSerDes.toJSON(media);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Media media = randomMedia();

		media.setArtist(regex);
		media.setDescription(regex);
		media.setGenre(regex);
		media.setMediaName(regex);

		String json = MediaSerDes.toJSON(media);

		Assert.assertFalse(json.contains(regex));

		media = MediaSerDes.toDTO(json);

		Assert.assertEquals(regex, media.getArtist());
		Assert.assertEquals(regex, media.getDescription());
		Assert.assertEquals(regex, media.getGenre());
		Assert.assertEquals(regex, media.getMediaName());
	}

	@Test
	public void testGetMedia() throws Exception {
		Page<Media> page = mediaResource.getMedia();

		long totalCount = page.getTotalCount();

		Media media1 = testGetMedia_addMedia(randomMedia());

		Media media2 = testGetMedia_addMedia(randomMedia());

		page = mediaResource.getMedia();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(media1, (List<Media>)page.getItems());
		assertContains(media2, (List<Media>)page.getItems());
		assertValid(page);
	}

	protected Media testGetMedia_addMedia(Media media) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostMedia() throws Exception {
		Media randomMedia = randomMedia();

		Media postMedia = testPostMedia_addMedia(randomMedia);

		assertEquals(randomMedia, postMedia);
		assertValid(postMedia);
	}

	protected Media testPostMedia_addMedia(Media media) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteMediaById() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetMediaById() throws Exception {
		Integer mediaId = testGetMediaById_getMediaId();
		Integer irrelevantMediaId = testGetMediaById_getIrrelevantMediaId();

		Page<Media> page = mediaResource.getMediaById(mediaId);

		Assert.assertEquals(0, page.getTotalCount());

		if (irrelevantMediaId != null) {
			Media irrelevantMedia = testGetMediaById_addMedia(
				irrelevantMediaId, randomIrrelevantMedia());

			page = mediaResource.getMediaById(irrelevantMediaId);

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantMedia), (List<Media>)page.getItems());
			assertValid(page);
		}

		Media media1 = testGetMediaById_addMedia(mediaId, randomMedia());

		Media media2 = testGetMediaById_addMedia(mediaId, randomMedia());

		page = mediaResource.getMediaById(mediaId);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(media1, media2), (List<Media>)page.getItems());
		assertValid(page);
	}

	protected Media testGetMediaById_addMedia(Integer mediaId, Media media)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Integer testGetMediaById_getMediaId() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Integer testGetMediaById_getIrrelevantMediaId() throws Exception {
		return null;
	}

	protected void assertContains(Media media, List<Media> medias) {
		boolean contains = false;

		for (Media item : medias) {
			if (equals(media, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(medias + " does not contain " + media, contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Media media1, Media media2) {
		Assert.assertTrue(
			media1 + " does not equal " + media2, equals(media1, media2));
	}

	protected void assertEquals(List<Media> medias1, List<Media> medias2) {
		Assert.assertEquals(medias1.size(), medias2.size());

		for (int i = 0; i < medias1.size(); i++) {
			Media media1 = medias1.get(i);
			Media media2 = medias2.get(i);

			assertEquals(media1, media2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Media> medias1, List<Media> medias2) {

		Assert.assertEquals(medias1.size(), medias2.size());

		for (Media media1 : medias1) {
			boolean contains = false;

			for (Media media2 : medias2) {
				if (equals(media1, media2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				medias2 + " does not contain " + media1, contains);
		}
	}

	protected void assertValid(Media media) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("artist", additionalAssertFieldName)) {
				if (media.getArtist() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (media.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("genre", additionalAssertFieldName)) {
				if (media.getGenre() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mediaId", additionalAssertFieldName)) {
				if (media.getMediaId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("mediaName", additionalAssertFieldName)) {
				if (media.getMediaName() == null) {
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

	protected void assertValid(Page<Media> page) {
		boolean valid = false;

		java.util.Collection<Media> medias = page.getItems();

		int size = medias.size();

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
				getDeclaredFields(datamusic.rest.dto.v1_0.Media.class)) {

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

	protected boolean equals(Media media1, Media media2) {
		if (media1 == media2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("artist", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						media1.getArtist(), media2.getArtist())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						media1.getDescription(), media2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("genre", additionalAssertFieldName)) {
				if (!Objects.deepEquals(media1.getGenre(), media2.getGenre())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("mediaId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						media1.getMediaId(), media2.getMediaId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("mediaName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						media1.getMediaName(), media2.getMediaName())) {

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

		if (!(_mediaResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_mediaResource;

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
		EntityField entityField, String operator, Media media) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("artist")) {
			sb.append("'");
			sb.append(String.valueOf(media.getArtist()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(media.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("genre")) {
			sb.append("'");
			sb.append(String.valueOf(media.getGenre()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("mediaId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("mediaName")) {
			sb.append("'");
			sb.append(String.valueOf(media.getMediaName()));
			sb.append("'");

			return sb.toString();
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

	protected Media randomMedia() throws Exception {
		return new Media() {
			{
				artist = StringUtil.toLowerCase(RandomTestUtil.randomString());
				description = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				genre = StringUtil.toLowerCase(RandomTestUtil.randomString());
				mediaId = RandomTestUtil.randomLong();
				mediaName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
			}
		};
	}

	protected Media randomIrrelevantMedia() throws Exception {
		Media randomIrrelevantMedia = randomMedia();

		return randomIrrelevantMedia;
	}

	protected Media randomPatchMedia() throws Exception {
		return randomMedia();
	}

	protected MediaResource mediaResource;
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
		LogFactoryUtil.getLog(BaseMediaResourceTestCase.class);

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
	private datamusic.rest.resource.v1_0.MediaResource _mediaResource;

}