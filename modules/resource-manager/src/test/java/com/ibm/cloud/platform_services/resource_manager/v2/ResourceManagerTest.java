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
package com.ibm.cloud.platform_services.resource_manager.v2;

import com.ibm.cloud.platform_services.resource_manager.v2.ResourceManager;
import com.ibm.cloud.platform_services.resource_manager.v2.model.CreateResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.DeleteResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.GetQuotaDefinitionOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.GetResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ListQuotaDefinitionsOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ListResourceGroupsOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.model.QuotaDefinition;
import com.ibm.cloud.platform_services.resource_manager.v2.model.QuotaDefinitionList;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResCreateResourceGroup;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceGroup;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceGroupList;
import com.ibm.cloud.platform_services.resource_manager.v2.model.ResourceQuota;
import com.ibm.cloud.platform_services.resource_manager.v2.model.UpdateResourceGroupOptions;
import com.ibm.cloud.platform_services.resource_manager.v2.utils.TestUtilities;
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
 * Unit test class for the ResourceManager service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class ResourceManagerTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ResourceManager testService;

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

    testService = ResourceManager.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new ResourceManager(serviceName, null);
  }

  @Test
  public void testListResourceGroupsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resources\": [{\"id\": \"id\", \"crn\": \"crn\", \"account_id\": \"accountId\", \"name\": \"name\", \"state\": \"state\", \"default\": true, \"quota_id\": \"quotaId\", \"quota_url\": \"quotaUrl\", \"payment_methods_url\": \"paymentMethodsUrl\", \"resource_linkages\": [\"anyValue\"], \"teams_url\": \"teamsUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\"}]}";
    String listResourceGroupsPath = "/resource_groups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceGroupsOptions model
    ListResourceGroupsOptions listResourceGroupsOptionsModel = new ListResourceGroupsOptions.Builder()
    .accountId("testString")
    .date("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceGroupList> response = testService.listResourceGroups(listResourceGroupsOptionsModel).execute();
    assertNotNull(response);
    ResourceGroupList responseObj = response.getResult();
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
    assertEquals(query.get("date"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceGroupsPath);
  }

  @Test
  public void testCreateResourceGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\"}";
    String createResourceGroupPath = "/resource_groups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateResourceGroupOptions model
    CreateResourceGroupOptions createResourceGroupOptionsModel = new CreateResourceGroupOptions.Builder()
    .name("test1")
    .accountId("25eba2a9-beef-450b-82cf-f5ad5e36c6dd")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResCreateResourceGroup> response = testService.createResourceGroup(createResourceGroupOptionsModel).execute();
    assertNotNull(response);
    ResCreateResourceGroup responseObj = response.getResult();
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
    assertEquals(parsedPath, createResourceGroupPath);
  }

  @Test
  public void testGetResourceGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"account_id\": \"accountId\", \"name\": \"name\", \"state\": \"state\", \"default\": true, \"quota_id\": \"quotaId\", \"quota_url\": \"quotaUrl\", \"payment_methods_url\": \"paymentMethodsUrl\", \"resource_linkages\": [\"anyValue\"], \"teams_url\": \"teamsUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\"}";
    String getResourceGroupPath = "/resource_groups/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceGroupOptions model
    GetResourceGroupOptions getResourceGroupOptionsModel = new GetResourceGroupOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceGroup> response = testService.getResourceGroup(getResourceGroupOptionsModel).execute();
    assertNotNull(response);
    ResourceGroup responseObj = response.getResult();
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
    assertEquals(parsedPath, getResourceGroupPath);
  }

  // Test the getResourceGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getResourceGroup(null).execute();
  }

  @Test
  public void testUpdateResourceGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"account_id\": \"accountId\", \"name\": \"name\", \"state\": \"state\", \"default\": true, \"quota_id\": \"quotaId\", \"quota_url\": \"quotaUrl\", \"payment_methods_url\": \"paymentMethodsUrl\", \"resource_linkages\": [\"anyValue\"], \"teams_url\": \"teamsUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\"}";
    String updateResourceGroupPath = "/resource_groups/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceGroupOptions model
    UpdateResourceGroupOptions updateResourceGroupOptionsModel = new UpdateResourceGroupOptions.Builder()
    .id("testString")
    .name("testString")
    .state("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceGroup> response = testService.updateResourceGroup(updateResourceGroupOptionsModel).execute();
    assertNotNull(response);
    ResourceGroup responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateResourceGroupPath);
  }

  // Test the updateResourceGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateResourceGroup(null).execute();
  }

  @Test
  public void testDeleteResourceGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteResourceGroupPath = "/resource_groups/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteResourceGroupOptions model
    DeleteResourceGroupOptions deleteResourceGroupOptionsModel = new DeleteResourceGroupOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteResourceGroup(deleteResourceGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteResourceGroupPath);
  }

  // Test the deleteResourceGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteResourceGroup(null).execute();
  }

  @Test
  public void testListQuotaDefinitionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resources\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"number_of_apps\": 12, \"number_of_service_instances\": 24, \"default_number_of_instances_per_lite_plan\": 35, \"instances_per_app\": 15, \"instance_memory\": \"instanceMemory\", \"total_app_memory\": \"totalAppMemory\", \"vsi_limit\": 8, \"resource_quotas\": [{\"_id\": \"id\", \"resource_id\": \"resourceId\", \"crn\": \"crn\", \"limit\": 5}], \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\"}]}";
    String listQuotaDefinitionsPath = "/quota_definitions";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListQuotaDefinitionsOptions model
    ListQuotaDefinitionsOptions listQuotaDefinitionsOptionsModel = new ListQuotaDefinitionsOptions();

    // Invoke operation with valid options model (positive test)
    Response<QuotaDefinitionList> response = testService.listQuotaDefinitions(listQuotaDefinitionsOptionsModel).execute();
    assertNotNull(response);
    QuotaDefinitionList responseObj = response.getResult();
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
    assertEquals(parsedPath, listQuotaDefinitionsPath);
  }

  @Test
  public void testGetQuotaDefinitionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"number_of_apps\": 12, \"number_of_service_instances\": 24, \"default_number_of_instances_per_lite_plan\": 35, \"instances_per_app\": 15, \"instance_memory\": \"instanceMemory\", \"total_app_memory\": \"totalAppMemory\", \"vsi_limit\": 8, \"resource_quotas\": [{\"_id\": \"id\", \"resource_id\": \"resourceId\", \"crn\": \"crn\", \"limit\": 5}], \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\"}";
    String getQuotaDefinitionPath = "/quota_definitions/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetQuotaDefinitionOptions model
    GetQuotaDefinitionOptions getQuotaDefinitionOptionsModel = new GetQuotaDefinitionOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<QuotaDefinition> response = testService.getQuotaDefinition(getQuotaDefinitionOptionsModel).execute();
    assertNotNull(response);
    QuotaDefinition responseObj = response.getResult();
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
    assertEquals(parsedPath, getQuotaDefinitionPath);
  }

  // Test the getQuotaDefinition operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetQuotaDefinitionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getQuotaDefinition(null).execute();
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