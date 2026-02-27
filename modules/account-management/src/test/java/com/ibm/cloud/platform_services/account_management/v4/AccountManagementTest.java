/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.account_management.v4;

import com.ibm.cloud.platform_services.account_management.v4.AccountManagement;
import com.ibm.cloud.platform_services.account_management.v4.model.AccountResponse;
import com.ibm.cloud.platform_services.account_management.v4.model.AccountResponseTraits;
import com.ibm.cloud.platform_services.account_management.v4.model.GetAccountOptions;
import com.ibm.cloud.platform_services.account_management.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
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
 * Unit test class for the AccountManagement service.
 */
public class AccountManagementTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected AccountManagement accountManagementService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new AccountManagement(serviceName, null);
  }

  // Test the getAccount operation with a valid options model parameter
  @Test
  public void testGetAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"id\": \"id\", \"owner\": \"owner\", \"owner_userid\": \"ownerUserid\", \"owner_iamid\": \"ownerIamid\", \"type\": \"type\", \"status\": \"status\", \"linked_softlayer_account\": \"linkedSoftlayerAccount\", \"team_directory_enabled\": true, \"traits\": {\"eu_supported\": false, \"poc\": false, \"hippa\": false}}";
    String getAccountPath = "/v4/accounts/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountOptions model
    GetAccountOptions getAccountOptionsModel = new GetAccountOptions.Builder()
      .accountId("testString")
      .build();

    // Invoke getAccount() with a valid options model and verify the result
    Response<AccountResponse> response = accountManagementService.getAccount(getAccountOptionsModel).execute();
    assertNotNull(response);
    AccountResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAccount operation with and without retries enabled
  @Test
  public void testGetAccountWRetries() throws Throwable {
    accountManagementService.enableRetries(4, 30);
    testGetAccountWOptions();

    accountManagementService.disableRetries();
    testGetAccountWOptions();
  }

  // Test the getAccount operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    accountManagementService.getAccount(null).execute();
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
    accountManagementService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    accountManagementService = AccountManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    accountManagementService.setServiceUrl(url);
  }
}