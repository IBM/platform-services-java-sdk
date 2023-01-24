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
package com.ibm.cloud.platform_services.ibm_cloud_shell.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.Feature;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.RegionSetting;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the IbmCloudShell service.
 */
public class IbmCloudShellTest  {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IbmCloudShell ibmCloudShellService;

  public void constructClientService() throws Throwable {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    ibmCloudShellService = IbmCloudShell.newInstance(serviceName);
    String url = server.url("/").toString();
    ibmCloudShellService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IbmCloudShell(serviceName, null);
  }

  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"_id\": \"id\", \"_rev\": \"rev\", \"account_id\": \"accountId\", \"created_at\": 9, \"created_by\": \"createdBy\", \"default_enable_new_features\": true, \"default_enable_new_regions\": false, \"enabled\": false, \"features\": [{\"enabled\": false, \"key\": \"key\"}], \"regions\": [{\"enabled\": false, \"key\": \"key\"}], \"type\": \"type\", \"updated_at\": 9, \"updated_by\": \"updatedBy\"}";
    String getAccountSettingsPath = "/api/v1/user/accounts/12345678-abcd-1a2b-a1b2-1234567890ab/settings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountSettingsOptions model
    GetAccountSettingsOptions getAccountSettingsOptionsModel = new GetAccountSettingsOptions.Builder()
    .accountId("12345678-abcd-1a2b-a1b2-1234567890ab")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSettings> response = ibmCloudShellService.getAccountSettings(getAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettings responseObj = response.getResult();
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
    assertEquals(parsedPath, getAccountSettingsPath);
  }

  // Test the getAccountSettings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSettingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmCloudShellService.getAccountSettings(null).execute();
  }

  @Test
  public void testUpdateAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"_id\": \"id\", \"_rev\": \"rev\", \"account_id\": \"accountId\", \"created_at\": 9, \"created_by\": \"createdBy\", \"default_enable_new_features\": true, \"default_enable_new_regions\": false, \"enabled\": false, \"features\": [{\"enabled\": false, \"key\": \"key\"}], \"regions\": [{\"enabled\": false, \"key\": \"key\"}], \"type\": \"type\", \"updated_at\": 9, \"updated_by\": \"updatedBy\"}";
    String updateAccountSettingsPath = "/api/v1/user/accounts/12345678-abcd-1a2b-a1b2-1234567890ab/settings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .enabled(true)
    .key("server.file_manager")
    .build();

    // Construct an instance of the RegionSetting model
    RegionSetting regionSettingModel = new RegionSetting.Builder()
    .enabled(true)
    .key("eu-de")
    .build();

    // Construct an instance of the UpdateAccountSettingsOptions model
    UpdateAccountSettingsOptions updateAccountSettingsOptionsModel = new UpdateAccountSettingsOptions.Builder()
    .accountId("12345678-abcd-1a2b-a1b2-1234567890ab")
    .rev("130-12345678-abcd-1a2b-a1b2-1234567890ab")
    .defaultEnableNewFeatures(true)
    .defaultEnableNewRegions(true)
    .enabled(true)
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .regions(new java.util.ArrayList<RegionSetting>(java.util.Arrays.asList(regionSettingModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSettings> response = ibmCloudShellService.updateAccountSettings(updateAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettings responseObj = response.getResult();
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
    assertEquals(parsedPath, updateAccountSettingsPath);
  }

  // Test the updateAccountSettings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    ibmCloudShellService.updateAccountSettings(null).execute();
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
    ibmCloudShellService = null;
  }
}