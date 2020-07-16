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
package com.ibm.cloud.platform_services.global_search.v2;

import com.ibm.cloud.platform_services.global_search.v2.GlobalSearch;
import com.ibm.cloud.platform_services.global_search.v2.model.GetSupportedTypesOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.ResultItem;
import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.SupportedTypesList;
import com.ibm.cloud.platform_services.global_search.v2.utils.TestUtilities;
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
 * Unit test class for the GlobalSearch service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class GlobalSearchTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected GlobalSearch testService;

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

    testService = GlobalSearch.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new GlobalSearch(serviceName, null);
  }

  @Test
  public void testSearchWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"search_cursor\": \"searchCursor\", \"limit\": 5, \"items\": [{\"crn\": \"crn\"}]}";
    String searchPath = "/v3/resources/search";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SearchOptions model
    SearchOptions searchOptionsModel = new SearchOptions.Builder()
    .query("testString")
    .fields(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .searchCursor("testString")
    .transactionId("testString")
    .accountId("testString")
    .limit(Long.valueOf("1"))
    .timeout(Long.valueOf("0"))
    .sort(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ScanResult> response = testService.search(searchOptionsModel).execute();
    assertNotNull(response);
    ScanResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1"));
    assertEquals(Long.valueOf(query.get("timeout")), Long.valueOf("0"));
    assertEquals(Arrays.asList(query.get("sort")), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, searchPath);
  }

  @Test
  public void testGetSupportedTypesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"supported_types\": [\"supportedTypes\"]}";
    String getSupportedTypesPath = "/v2/resources/supported_types";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSupportedTypesOptions model
    GetSupportedTypesOptions getSupportedTypesOptionsModel = new GetSupportedTypesOptions();

    // Invoke operation with valid options model (positive test)
    Response<SupportedTypesList> response = testService.getSupportedTypes(getSupportedTypesOptionsModel).execute();
    assertNotNull(response);
    SupportedTypesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getSupportedTypesPath);
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