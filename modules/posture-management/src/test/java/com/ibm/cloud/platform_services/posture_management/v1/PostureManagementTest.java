/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.posture_management.v1;

import com.ibm.cloud.platform_services.posture_management.v1.PostureManagement;
import com.ibm.cloud.platform_services.posture_management.v1.model.ApplicabilityCriteria;
import com.ibm.cloud.platform_services.posture_management.v1.model.CreateValidationScanOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListProfileOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListScopesOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.Profile;
import com.ibm.cloud.platform_services.posture_management.v1.model.ProfilesList;
import com.ibm.cloud.platform_services.posture_management.v1.model.Result;
import com.ibm.cloud.platform_services.posture_management.v1.model.Scan;
import com.ibm.cloud.platform_services.posture_management.v1.model.Scope;
import com.ibm.cloud.platform_services.posture_management.v1.model.ScopesList;
import com.ibm.cloud.platform_services.posture_management.v1.utils.TestUtilities;
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
 * Unit test class for the PostureManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class PostureManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected PostureManagement postureManagementService;

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

    postureManagementService = PostureManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    postureManagementService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new PostureManagement(serviceName, null);
  }

  @Test
  public void testCreateValidationScanWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"result\": true, \"message\": \"message\"}";
    String createValidationScanPath = "/posture/v1/scans/validation";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateValidationScanOptions model
    CreateValidationScanOptions createValidationScanOptionsModel = new CreateValidationScanOptions.Builder()
    .accountId("testString")
    .scopeId(Long.valueOf("1"))
    .profileId(Long.valueOf("6"))
    .groupProfileId(Long.valueOf("13"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Result> response = postureManagementService.createValidationScan(createValidationScanOptionsModel).execute();
    assertNotNull(response);
    Result responseObj = response.getResult();
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
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createValidationScanPath);
  }

  // Test the createValidationScan operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateValidationScanNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    postureManagementService.createValidationScan(null).execute();
  }

  @Test
  public void testListProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"profiles\": [{\"name\": \"CIS IBM Foundations Benchmark 1.0.0\", \"no_of_goals\": 58, \"description\": \"CIS IBM Foundations Benchmark 1.0.0\", \"version\": 1, \"created_by\": \"IBMid-5500081P68\", \"modified_by\": \"IBMid-5500081P68\", \"reason_for_delete\": \"reasonForDelete\", \"applicability_criteria\": {\"environment\": [\"[IBM Cloud]\"], \"resource\": [\"[My_example_bucket]\"], \"environment_category\": [\"[Cloud]\"], \"resource_category\": [\"[Storage]\"], \"resource_type\": [\"Bucket\"], \"software_details\": {\"mapKey\": \"anyValue\"}, \"os_details\": {\"mapKey\": \"anyValue\"}, \"additional_details\": {\"mapKey\": \"anyValue\"}, \"environment_category_description\": {\"mapKey\": \"Cloud\"}, \"environment_description\": {\"mapKey\": \"IBM Cloud\"}, \"resource_category_description\": {\"mapKey\": \"Storage\"}, \"resource_type_description\": {\"mapKey\": \"Bucket\"}, \"resource_description\": {\"mapKey\": \"My_specific_bucket\"}}, \"profile_id\": 3045, \"base_profile\": \"CIS IBM Foundations Benchmark 1.0.0\", \"profile_type\": \"predefined\", \"created_time\": \"2021-02-26T04:07:25Z\", \"modified_time\": \"2021-02-26T04:07:25Z\", \"enabled\": true}]}";
    String listProfilePath = "/posture/v1/profiles";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListProfileOptions model
    ListProfileOptions listProfileOptionsModel = new ListProfileOptions.Builder()
    .accountId("testString")
    .name("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfilesList> response = postureManagementService.listProfile(listProfileOptionsModel).execute();
    assertNotNull(response);
    ProfilesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("name"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfilePath);
  }

  // Test the listProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    postureManagementService.listProfile(null).execute();
  }

  @Test
  public void testListScopesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"scopes\": [{\"description\": \"This scope targets all of the resources that are available in our IBM Cloud staging environment.\", \"created_by\": \"IBMid-5500081P68\", \"modified_by\": \"IBMid-5500081P68\", \"scope_id\": 1, \"name\": \"My_Example_Scope\", \"enabled\": true, \"environment_type\": \"ibm\", \"created_time\": \"2021-02-26T04:07:25Z\", \"modified_time\": \"2021-02-26T04:07:25Z\", \"last_scan_type\": \"fact_collection\", \"last_scan_type_description\": \"Fact collection\", \"last_scan_status_updated_time\": \"2021-02-26T04:07:25Z\", \"collectors_id\": [12], \"scans\": [{\"scan_id\": 235, \"discover_id\": 49, \"status\": \"validation_completed\", \"status_message\": \"The collector aborted the task during upgrade.\"}]}]}";
    String listScopesPath = "/posture/v1/scopes";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListScopesOptions model
    ListScopesOptions listScopesOptionsModel = new ListScopesOptions.Builder()
    .accountId("testString")
    .name("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ScopesList> response = postureManagementService.listScopes(listScopesOptionsModel).execute();
    assertNotNull(response);
    ScopesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("name"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listScopesPath);
  }

  // Test the listScopes operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListScopesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    postureManagementService.listScopes(null).execute();
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
    postureManagementService = null;
  }
}