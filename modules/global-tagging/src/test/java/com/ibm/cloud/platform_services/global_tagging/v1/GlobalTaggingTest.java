/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.sdk.core.util.EnvironmentUtils;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GlobalTagging service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class GlobalTaggingTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  protected MockWebServer server;
  protected GlobalTagging testService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    testService = GlobalTagging.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
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
    String mockResponseBody = "{\"total_count\": 10, \"offset\": 6, \"limit\": 5, \"items\": [{\"name\": \"name\"}]}";
    String listTagsPath = "/v3/tags";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListTagsOptions model
    ListTagsOptions listTagsOptionsModel = new ListTagsOptions.Builder()
    .providers(new ArrayList<String>(Arrays.asList("ghost")))
    .attachedTo("testString")
    .fullData(true)
    .offset(Long.valueOf("26"))
    .limit(Long.valueOf("26"))
    .orderByName("asc")
    .timeout(Long.valueOf("26"))
    .attachedOnly(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TagList> response = testService.listTags(listTagsOptionsModel).execute();
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
    assertEquals(Arrays.asList(query.get("providers")), new ArrayList<String>(Arrays.asList("ghost")));
    assertEquals(query.get("attached_to"), "testString");
    assertEquals(Boolean.valueOf(query.get("full_data")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(query.get("order_by_name"), "asc");
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("attached_only")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTagsPath);
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
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteTagsResult> response = testService.deleteTagAll(deleteTagAllOptionsModel).execute();
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
    .providers(new ArrayList<String>(Arrays.asList("ghost")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteTagResults> response = testService.deleteTag(deleteTagOptionsModel).execute();
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
    assertEquals(Arrays.asList(query.get("providers")), new ArrayList<String>(Arrays.asList("ghost")));
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
    testService.deleteTag(null).execute();
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
    .resources(new ArrayList<Resource>(Arrays.asList(resourceModel)))
    .tagName("testString")
    .tagNames(new ArrayList<String>(Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TagResults> response = testService.attachTag(attachTagOptionsModel).execute();
    assertNotNull(response);
    TagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

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
    testService.attachTag(null).execute();
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
    .resources(new ArrayList<Resource>(Arrays.asList(resourceModel)))
    .tagName("testString")
    .tagNames(new ArrayList<String>(Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TagResults> response = testService.detachTag(detachTagOptionsModel).execute();
    assertNotNull(response);
    TagResults responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

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
    testService.detachTag(null).execute();
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
    testService = null;
  }
}