/*
 * (C) Copyright IBM Corp. 2021, 2023.
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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagAllOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResult;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the GlobalTagging service.
 */
public class GlobalTaggingTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected GlobalTagging globalTaggingService;

  public void constructClientService() throws Throwable {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    globalTaggingService = GlobalTagging.newInstance(serviceName);
    String url = server.url("/").toString();
    globalTaggingService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new GlobalTagging(serviceName, null);
  }

  @Test
  public void testListTagsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_count\": 0, \"offset\": 0, \"limit\": 1, \"items\": [{\"name\": \"name\"}]}";
    String listTagsPath = "/v3/tags";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListTagsOptions model
    ListTagsOptions listTagsOptionsModel = new ListTagsOptions.Builder()
    .impersonateUser("testString")
    .accountId("testString")
    .tagType("user")
    .fullData(true)
    .providers(new java.util.ArrayList<String>(java.util.Arrays.asList("ghost")))
    .attachedTo("testString")
    .offset(Long.valueOf("0"))
    .limit(Long.valueOf("1"))
    .timeout(Long.valueOf("0"))
    .orderByName("asc")
    .attachedOnly(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TagList> response = globalTaggingService.listTags(listTagsOptionsModel).execute();
    assertNotNull(response);
    TagList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
    assertEquals(Boolean.valueOf(query.get("full_data")), Boolean.valueOf(true));
    assertEquals(query.get("providers"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("ghost")), ","));
    assertEquals(query.get("attached_to"), "testString");
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(query.get("order_by_name"), "asc");
    assertEquals(Boolean.valueOf(query.get("attached_only")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTagsPath);
  }

  @Test
  public void testCreateTagWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"tag_name\": \"tagName\", \"is_error\": false}]}";
    String createTagPath = "/v3/tags";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateTagOptions model
    CreateTagOptions createTagOptionsModel = new CreateTagOptions.Builder()
    .tagNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .impersonateUser("testString")
    .accountId("testString")
    .tagType("access")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateTagResults> response = globalTaggingService.createTag(createTagOptionsModel).execute();
    assertNotNull(response);
    CreateTagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "access");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTagPath);
  }

  // Test the createTag operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTagNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    globalTaggingService.createTag(null).execute();
  }

  @Test
  public void testDeleteTagAllWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_count\": 10, \"errors\": true, \"items\": [{\"tag_name\": \"tagName\", \"is_error\": false}]}";
    String deleteTagAllPath = "/v3/tags";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTagAllOptions model
    DeleteTagAllOptions deleteTagAllOptionsModel = new DeleteTagAllOptions.Builder()
    .providers("ghost")
    .impersonateUser("testString")
    .accountId("testString")
    .tagType("user")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteTagsResult> response = globalTaggingService.deleteTagAll(deleteTagAllOptionsModel).execute();
    assertNotNull(response);
    DeleteTagsResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("providers"), "ghost");
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTagAllPath);
  }

  @Test
  public void testDeleteTagWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"provider\": \"ghost\", \"is_error\": false}]}";
    String deleteTagPath = "/v3/tags/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteTagOptions model
    DeleteTagOptions deleteTagOptionsModel = new DeleteTagOptions.Builder()
    .tagName("testString")
    .providers(new java.util.ArrayList<String>(java.util.Arrays.asList("ghost")))
    .impersonateUser("testString")
    .accountId("testString")
    .tagType("user")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteTagResults> response = globalTaggingService.deleteTag(deleteTagOptionsModel).execute();
    assertNotNull(response);
    DeleteTagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("providers"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("ghost")), ","));
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTagPath);
  }

  // Test the deleteTag operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTagNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    globalTaggingService.deleteTag(null).execute();
  }

  @Test
  public void testAttachTagWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"resource_id\": \"resourceId\", \"is_error\": false}]}";
    String attachTagPath = "/v3/tags/attach";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
    .resourceId("testString")
    .resourceType("testString")
    .build();

    // Construct an instance of the AttachTagOptions model
    AttachTagOptions attachTagOptionsModel = new AttachTagOptions.Builder()
    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .tagName("testString")
    .tagNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .impersonateUser("testString")
    .accountId("testString")
    .tagType("user")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TagResults> response = globalTaggingService.attachTag(attachTagOptionsModel).execute();
    assertNotNull(response);
    TagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, attachTagPath);
  }

  // Test the attachTag operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAttachTagNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    globalTaggingService.attachTag(null).execute();
  }

  @Test
  public void testDetachTagWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"results\": [{\"resource_id\": \"resourceId\", \"is_error\": false}]}";
    String detachTagPath = "/v3/tags/detach";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
    .resourceId("testString")
    .resourceType("testString")
    .build();

    // Construct an instance of the DetachTagOptions model
    DetachTagOptions detachTagOptionsModel = new DetachTagOptions.Builder()
    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .tagName("testString")
    .tagNames(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .impersonateUser("testString")
    .accountId("testString")
    .tagType("user")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TagResults> response = globalTaggingService.detachTag(detachTagOptionsModel).execute();
    assertNotNull(response);
    TagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("tag_type"), "user");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, detachTagPath);
  }

  // Test the detachTag operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDetachTagNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    globalTaggingService.detachTag(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    globalTaggingService = null;
  }
}