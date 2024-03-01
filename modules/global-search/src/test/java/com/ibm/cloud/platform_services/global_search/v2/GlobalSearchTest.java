/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.global_search.v2;

import com.ibm.cloud.platform_services.global_search.v2.GlobalSearch;
import com.ibm.cloud.platform_services.global_search.v2.model.ResultItem;
import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.utils.TestUtilities;
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
 * Unit test class for the GlobalSearch service.
 */
public class GlobalSearchTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected GlobalSearch globalSearchService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new GlobalSearch(serviceName, null);
  }

  // Test the search operation with a valid options model parameter
  @Test
  public void testSearchWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"search_cursor\": \"searchCursor\", \"limit\": 5, \"items\": [{\"crn\": \"crn\"}]}";
    String searchPath = "/v3/resources/search";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SearchOptions model
    SearchOptions searchOptionsModel = new SearchOptions.Builder()
      .query("testString")
      .fields(java.util.Arrays.asList("testString"))
      .searchCursor("testString")
      .xRequestId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .timeout(Long.valueOf("0"))
      .sort(java.util.Arrays.asList("testString"))
      .isDeleted("false")
      .isReclaimed("false")
      .isPublic("false")
      .impersonateUser("testString")
      .canTag("false")
      .build();

    // Invoke search() with a valid options model and verify the result
    Response<ScanResult> response = globalSearchService.search(searchOptionsModel).execute();
    assertNotNull(response);
    ScanResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, searchPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(query.get("sort"), RequestUtils.join(java.util.Arrays.asList("testString"), ","));
    assertEquals(query.get("is_deleted"), "false");
    assertEquals(query.get("is_reclaimed"), "false");
    assertEquals(query.get("is_public"), "false");
    assertEquals(query.get("impersonate_user"), "testString");
    assertEquals(query.get("can_tag"), "false");
  }

  // Test the search operation with and without retries enabled
  @Test
  public void testSearchWRetries() throws Throwable {
    globalSearchService.enableRetries(4, 30);
    testSearchWOptions();

    globalSearchService.disableRetries();
    testSearchWOptions();
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
    globalSearchService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    globalSearchService = GlobalSearch.newInstance(serviceName);
    String url = server.url("/").toString();
    globalSearchService.setServiceUrl(url);
  }
}