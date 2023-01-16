/*
 * (C) Copyright IBM Corp. 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.platform_services.global_tagging.v1;

import com.ibm.cloud.platform_services.global_tagging.v1.GlobalTagging;
import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagResultsResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagAllOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResult;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResultItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Tag;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GlobalTagging service.
 */
public class GlobalTaggingTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected GlobalTagging globalTaggingService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new GlobalTagging(serviceName, null);
  }

  // Test the listTags operation with a valid options model parameter
  @Test
  public void testListTagsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 0, \"offset\": 0, \"limit\": 1, \"items\": [{\"name\": \"name\"}]}";
    String listTagsPath = "/v3/tags";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTagsOptions model
    ListTagsOptions listTagsOptionsModel = new ListTagsOptions.Builder()
      .transactionId("testString")
      .impersonateUser("testString")
      .accountId("testString")
      .tagType("user")
      .fullData(false)
      .providers(java.util.Arrays.asList("ghost"))
      .attachedTo("testString")
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("1"))
      .timeout(Long.valueOf("0"))
      .orderByName("asc")
      .attachedOnly(false)
      .build();

    // Invoke listTags() with a valid options model and verify the result
    Response<TagList> response = globalTaggingService.listTags(listTagsOptionsModel).execute();
    assertNotNull(response);
    TagList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTagsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
    assertEquals(Boolean.valueOf(query.get("full_data")), Boolean.valueOf(false));
    assertEquals(query.get("providers"), RequestUtils.join(java.util.Arrays.asList("ghost"), ","));
    assertEquals(query.get("attached_to"), "testString");
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(query.get("order_by_name"), "asc");
    assertEquals(Boolean.valueOf(query.get("attached_only")), Boolean.valueOf(false));
  }

  // Test the listTags operation with and without retries enabled
  @Test
  public void testListTagsWRetries() throws Throwable {
    globalTaggingService.enableRetries(4, 30);
    testListTagsWOptions();

    globalTaggingService.disableRetries();
    testListTagsWOptions();
  }

  // Test the createTag operation with a valid options model parameter
  @Test
  public void testCreateTagWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"tag_name\": \"tagName\", \"is_error\": false}]}";
    String createTagPath = "/v3/tags";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateTagOptions model
    CreateTagOptions createTagOptionsModel = new CreateTagOptions.Builder()
      .tagNames(java.util.Arrays.asList("testString"))
      .impersonateUser("testString")
      .transactionId("testString")
      .accountId("testString")
      .tagType("access")
      .build();

    // Invoke createTag() with a valid options model and verify the result
    Response<CreateTagResults> response = globalTaggingService.createTag(createTagOptionsModel).execute();
    assertNotNull(response);
    CreateTagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTagPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "access");
  }

  // Test the createTag operation with and without retries enabled
  @Test
  public void testCreateTagWRetries() throws Throwable {
    globalTaggingService.enableRetries(4, 30);
    testCreateTagWOptions();

    globalTaggingService.disableRetries();
    testCreateTagWOptions();
  }

  // Test the createTag operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTagNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalTaggingService.createTag(null).execute();
  }

  // Test the deleteTagAll operation with a valid options model parameter
  @Test
  public void testDeleteTagAllWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"total_count\": 10, \"errors\": true, \"items\": [{\"tag_name\": \"tagName\", \"is_error\": false}]}";
    String deleteTagAllPath = "/v3/tags";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTagAllOptions model
    DeleteTagAllOptions deleteTagAllOptionsModel = new DeleteTagAllOptions.Builder()
      .transactionId("testString")
      .providers("ghost")
      .impersonateUser("testString")
      .accountId("testString")
      .tagType("user")
      .build();

    // Invoke deleteTagAll() with a valid options model and verify the result
    Response<DeleteTagsResult> response = globalTaggingService.deleteTagAll(deleteTagAllOptionsModel).execute();
    assertNotNull(response);
    DeleteTagsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTagAllPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("providers"), "ghost");
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
  }

  // Test the deleteTagAll operation with and without retries enabled
  @Test
  public void testDeleteTagAllWRetries() throws Throwable {
    globalTaggingService.enableRetries(4, 30);
    testDeleteTagAllWOptions();

    globalTaggingService.disableRetries();
    testDeleteTagAllWOptions();
  }

  // Test the deleteTag operation with a valid options model parameter
  @Test
  public void testDeleteTagWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"provider\": \"ghost\", \"is_error\": false}]}";
    String deleteTagPath = "/v3/tags/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTagOptions model
    DeleteTagOptions deleteTagOptionsModel = new DeleteTagOptions.Builder()
      .tagName("testString")
      .transactionId("testString")
      .providers(java.util.Arrays.asList("ghost"))
      .impersonateUser("testString")
      .accountId("testString")
      .tagType("user")
      .build();

    // Invoke deleteTag() with a valid options model and verify the result
    Response<DeleteTagResults> response = globalTaggingService.deleteTag(deleteTagOptionsModel).execute();
    assertNotNull(response);
    DeleteTagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTagPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("providers"), RequestUtils.join(java.util.Arrays.asList("ghost"), ","));
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
  }

  // Test the deleteTag operation with and without retries enabled
  @Test
  public void testDeleteTagWRetries() throws Throwable {
    globalTaggingService.enableRetries(4, 30);
    testDeleteTagWOptions();

    globalTaggingService.disableRetries();
    testDeleteTagWOptions();
  }

  // Test the deleteTag operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTagNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalTaggingService.deleteTag(null).execute();
  }

  // Test the attachTag operation with a valid options model parameter
  @Test
  public void testAttachTagWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"resource_id\": \"resourceId\", \"is_error\": false}]}";
    String attachTagPath = "/v3/tags/attach";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
      .resourceId("testString")
      .resourceType("testString")
      .build();

    // Construct an instance of the AttachTagOptions model
    AttachTagOptions attachTagOptionsModel = new AttachTagOptions.Builder()
      .resources(java.util.Arrays.asList(resourceModel))
      .tagName("testString")
      .tagNames(java.util.Arrays.asList("testString"))
      .transactionId("testString")
      .impersonateUser("testString")
      .accountId("testString")
      .tagType("user")
      .build();

    // Invoke attachTag() with a valid options model and verify the result
    Response<TagResults> response = globalTaggingService.attachTag(attachTagOptionsModel).execute();
    assertNotNull(response);
    TagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, attachTagPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
  }

  // Test the attachTag operation with and without retries enabled
  @Test
  public void testAttachTagWRetries() throws Throwable {
    globalTaggingService.enableRetries(4, 30);
    testAttachTagWOptions();

    globalTaggingService.disableRetries();
    testAttachTagWOptions();
  }

  // Test the attachTag operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAttachTagNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalTaggingService.attachTag(null).execute();
  }

  // Test the detachTag operation with a valid options model parameter
  @Test
  public void testDetachTagWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"results\": [{\"resource_id\": \"resourceId\", \"is_error\": false}]}";
    String detachTagPath = "/v3/tags/detach";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
      .resourceId("testString")
      .resourceType("testString")
      .build();

    // Construct an instance of the DetachTagOptions model
    DetachTagOptions detachTagOptionsModel = new DetachTagOptions.Builder()
      .resources(java.util.Arrays.asList(resourceModel))
      .tagName("testString")
      .tagNames(java.util.Arrays.asList("testString"))
      .transactionId("testString")
      .impersonateUser("testString")
      .accountId("testString")
      .tagType("user")
      .build();

    // Invoke detachTag() with a valid options model and verify the result
    Response<TagResults> response = globalTaggingService.detachTag(detachTagOptionsModel).execute();
    assertNotNull(response);
    TagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, detachTagPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
  }

  // Test the detachTag operation with and without retries enabled
  @Test
  public void testDetachTagWRetries() throws Throwable {
    globalTaggingService.enableRetries(4, 30);
    testDetachTagWOptions();

    globalTaggingService.disableRetries();
    testDetachTagWOptions();
  }

  // Test the detachTag operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDetachTagNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalTaggingService.detachTag(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    globalTaggingService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    globalTaggingService = GlobalTagging.newInstance(serviceName);
    String url = server.url("/").toString();
    globalTaggingService.setServiceUrl(url);
  }
}