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
package com.ibm.cloud.platform_services.resource_controller.v2;

import com.ibm.cloud.platform_services.resource_controller.v2.ResourceController;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Credentials;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListReclamationsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.LockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.PlanHistoryItem;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Reclamation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ReclamationsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAlias;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingPostParameters;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeyPostParameters;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.RunReclamationActionOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UnlockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
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
 * Unit test class for the ResourceController service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class ResourceControllerTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ResourceController testService;

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

    testService = ResourceController.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new ResourceController(serviceName, null);
  }

  @Test
  public void testListResourceInstancesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"resource_id\": \"resourceId\", \"resource_plan_id\": \"resourcePlanId\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"allow_cleanup\": true, \"locked\": true, \"last_operation\": {\"mapKey\": \"anyValue\"}, \"dashboard_url\": \"dashboardUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00\"}], \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}], \"rows_count\": 9}";
    String listResourceInstancesPath = "/v2/resource_instances";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceInstancesOptions model
    ListResourceInstancesOptions listResourceInstancesOptionsModel = new ListResourceInstancesOptions.Builder()
    .guid("testString")
    .name("testString")
    .resourceGroupId("testString")
    .resourceId("testString")
    .resourcePlanId("testString")
    .type("testString")
    .subType("testString")
    .limit("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstancesList> response = testService.listResourceInstances(listResourceInstancesOptionsModel).execute();
    assertNotNull(response);
    ResourceInstancesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("resource_plan_id"), "testString");
    assertEquals(query.get("type"), "testString");
    assertEquals(query.get("sub_type"), "testString");
    assertEquals(query.get("limit"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceInstancesPath);
  }

  @Test
  public void testCreateResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"resource_id\": \"resourceId\", \"resource_plan_id\": \"resourcePlanId\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"allow_cleanup\": true, \"locked\": true, \"last_operation\": {\"mapKey\": \"anyValue\"}, \"dashboard_url\": \"dashboardUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00\"}], \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String createResourceInstancePath = "/v2/resource_instances";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateResourceInstanceOptions model
    CreateResourceInstanceOptions createResourceInstanceOptionsModel = new CreateResourceInstanceOptions.Builder()
    .name("my-instance")
    .target("bluemix-us-south")
    .resourceGroup("5c49eabc-f5e8-5881-a37e-2d100a33b3df")
    .resourcePlanId("cloudant-standard")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allowCleanup(true)
    .parameters(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .entityLock("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = testService.createResourceInstance(createResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
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
    assertEquals(parsedPath, createResourceInstancePath);
  }

  // Test the createResourceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createResourceInstance(null).execute();
  }

  @Test
  public void testGetResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"resource_id\": \"resourceId\", \"resource_plan_id\": \"resourcePlanId\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"allow_cleanup\": true, \"locked\": true, \"last_operation\": {\"mapKey\": \"anyValue\"}, \"dashboard_url\": \"dashboardUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00\"}], \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String getResourceInstancePath = "/v2/resource_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceInstanceOptions model
    GetResourceInstanceOptions getResourceInstanceOptionsModel = new GetResourceInstanceOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = testService.getResourceInstance(getResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
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
    assertEquals(parsedPath, getResourceInstancePath);
  }

  // Test the getResourceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getResourceInstance(null).execute();
  }

  @Test
  public void testDeleteResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteResourceInstancePath = "/v2/resource_instances/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteResourceInstanceOptions model
    DeleteResourceInstanceOptions deleteResourceInstanceOptionsModel = new DeleteResourceInstanceOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteResourceInstance(deleteResourceInstanceOptionsModel).execute();
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
    assertEquals(parsedPath, deleteResourceInstancePath);
  }

  // Test the deleteResourceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteResourceInstance(null).execute();
  }

  @Test
  public void testUpdateResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"resource_id\": \"resourceId\", \"resource_plan_id\": \"resourcePlanId\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"allow_cleanup\": true, \"locked\": true, \"last_operation\": {\"mapKey\": \"anyValue\"}, \"dashboard_url\": \"dashboardUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00\"}], \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String updateResourceInstancePath = "/v2/resource_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceInstanceOptions model
    UpdateResourceInstanceOptions updateResourceInstanceOptionsModel = new UpdateResourceInstanceOptions.Builder()
    .id("testString")
    .name("my-new-instance-name")
    .parameters(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .resourcePlanId("a8dff6d3-d287-4668-a81d-c87c55c2656d")
    .allowCleanup(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = testService.updateResourceInstance(updateResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
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
    assertEquals(parsedPath, updateResourceInstancePath);
  }

  // Test the updateResourceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateResourceInstance(null).execute();
  }

  @Test
  public void testLockResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"resource_id\": \"resourceId\", \"resource_plan_id\": \"resourcePlanId\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"allow_cleanup\": true, \"locked\": true, \"last_operation\": {\"mapKey\": \"anyValue\"}, \"dashboard_url\": \"dashboardUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00\"}], \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String lockResourceInstancePath = "/v2/resource_instances/testString/lock";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the LockResourceInstanceOptions model
    LockResourceInstanceOptions lockResourceInstanceOptionsModel = new LockResourceInstanceOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = testService.lockResourceInstance(lockResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
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
    assertEquals(parsedPath, lockResourceInstancePath);
  }

  // Test the lockResourceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockResourceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.lockResourceInstance(null).execute();
  }

  @Test
  public void testUnlockResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"resource_id\": \"resourceId\", \"resource_plan_id\": \"resourcePlanId\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"allow_cleanup\": true, \"locked\": true, \"last_operation\": {\"mapKey\": \"anyValue\"}, \"dashboard_url\": \"dashboardUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00\"}], \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String unlockResourceInstancePath = "/v2/resource_instances/testString/lock";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UnlockResourceInstanceOptions model
    UnlockResourceInstanceOptions unlockResourceInstanceOptionsModel = new UnlockResourceInstanceOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = testService.unlockResourceInstance(unlockResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unlockResourceInstancePath);
  }

  // Test the unlockResourceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockResourceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.unlockResourceInstance(null).execute();
  }

  @Test
  public void testListResourceKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_instance_url\": \"resourceInstanceUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}], \"rows_count\": 9}";
    String listResourceKeysPath = "/v2/resource_keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceKeysOptions model
    ListResourceKeysOptions listResourceKeysOptionsModel = new ListResourceKeysOptions.Builder()
    .guid("testString")
    .name("testString")
    .resourceGroupId("testString")
    .resourceId("testString")
    .limit("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKeysList> response = testService.listResourceKeys(listResourceKeysOptionsModel).execute();
    assertNotNull(response);
    ResourceKeysList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("limit"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceKeysPath);
  }

  @Test
  public void testCreateResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_instance_url\": \"resourceInstanceUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String createResourceKeyPath = "/v2/resource_keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResourceKeyPostParameters model
    ResourceKeyPostParameters resourceKeyPostParametersModel = new ResourceKeyPostParameters.Builder()
    .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
    .build();

    // Construct an instance of the CreateResourceKeyOptions model
    CreateResourceKeyOptions createResourceKeyOptionsModel = new CreateResourceKeyOptions.Builder()
    .name("my-key")
    .source("25eba2a9-beef-450b-82cf-f5ad5e36c6dd")
    .parameters(resourceKeyPostParametersModel)
    .role("Writer")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKey> response = testService.createResourceKey(createResourceKeyOptionsModel).execute();
    assertNotNull(response);
    ResourceKey responseObj = response.getResult();
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
    assertEquals(parsedPath, createResourceKeyPath);
  }

  // Test the createResourceKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createResourceKey(null).execute();
  }

  @Test
  public void testGetResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_instance_url\": \"resourceInstanceUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String getResourceKeyPath = "/v2/resource_keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceKeyOptions model
    GetResourceKeyOptions getResourceKeyOptionsModel = new GetResourceKeyOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKey> response = testService.getResourceKey(getResourceKeyOptionsModel).execute();
    assertNotNull(response);
    ResourceKey responseObj = response.getResult();
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
    assertEquals(parsedPath, getResourceKeyPath);
  }

  // Test the getResourceKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getResourceKey(null).execute();
  }

  @Test
  public void testDeleteResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteResourceKeyPath = "/v2/resource_keys/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteResourceKeyOptions model
    DeleteResourceKeyOptions deleteResourceKeyOptionsModel = new DeleteResourceKeyOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteResourceKey(deleteResourceKeyOptionsModel).execute();
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
    assertEquals(parsedPath, deleteResourceKeyPath);
  }

  // Test the deleteResourceKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteResourceKey(null).execute();
  }

  @Test
  public void testUpdateResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_instance_url\": \"resourceInstanceUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String updateResourceKeyPath = "/v2/resource_keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceKeyOptions model
    UpdateResourceKeyOptions updateResourceKeyOptionsModel = new UpdateResourceKeyOptions.Builder()
    .id("testString")
    .name("my-new-key-name")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKey> response = testService.updateResourceKey(updateResourceKeyOptionsModel).execute();
    assertNotNull(response);
    ResourceKey responseObj = response.getResult();
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
    assertEquals(parsedPath, updateResourceKeyPath);
  }

  // Test the updateResourceKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateResourceKey(null).execute();
  }

  @Test
  public void testListResourceBindingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"region_binding_id\": \"regionBindingId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_alias_url\": \"resourceAliasUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}], \"rows_count\": 9}";
    String listResourceBindingsPath = "/v2/resource_bindings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceBindingsOptions model
    ListResourceBindingsOptions listResourceBindingsOptionsModel = new ListResourceBindingsOptions.Builder()
    .guid("testString")
    .name("testString")
    .resourceGroupId("testString")
    .resourceId("testString")
    .regionBindingId("testString")
    .limit("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBindingsList> response = testService.listResourceBindings(listResourceBindingsOptionsModel).execute();
    assertNotNull(response);
    ResourceBindingsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("region_binding_id"), "testString");
    assertEquals(query.get("limit"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceBindingsPath);
  }

  @Test
  public void testCreateResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"region_binding_id\": \"regionBindingId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_alias_url\": \"resourceAliasUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String createResourceBindingPath = "/v2/resource_bindings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResourceBindingPostParameters model
    ResourceBindingPostParameters resourceBindingPostParametersModel = new ResourceBindingPostParameters.Builder()
    .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
    .build();

    // Construct an instance of the CreateResourceBindingOptions model
    CreateResourceBindingOptions createResourceBindingOptionsModel = new CreateResourceBindingOptions.Builder()
    .source("25eba2a9-beef-450b-82cf-f5ad5e36c6dd")
    .target("crn:v1:bluemix:public:cf:us-south:s/0ba4dba0-a120-4a1e-a124-5a249a904b76::cf-application:a1caa40b-2c24-4da8-8267-ac2c1a42ad0c")
    .name("my-binding")
    .parameters(resourceBindingPostParametersModel)
    .role("Writer")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBinding> response = testService.createResourceBinding(createResourceBindingOptionsModel).execute();
    assertNotNull(response);
    ResourceBinding responseObj = response.getResult();
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
    assertEquals(parsedPath, createResourceBindingPath);
  }

  // Test the createResourceBinding operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceBindingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createResourceBinding(null).execute();
  }

  @Test
  public void testGetResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"region_binding_id\": \"regionBindingId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_alias_url\": \"resourceAliasUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String getResourceBindingPath = "/v2/resource_bindings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceBindingOptions model
    GetResourceBindingOptions getResourceBindingOptionsModel = new GetResourceBindingOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBinding> response = testService.getResourceBinding(getResourceBindingOptionsModel).execute();
    assertNotNull(response);
    ResourceBinding responseObj = response.getResult();
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
    assertEquals(parsedPath, getResourceBindingPath);
  }

  // Test the getResourceBinding operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceBindingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getResourceBinding(null).execute();
  }

  @Test
  public void testDeleteResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteResourceBindingPath = "/v2/resource_bindings/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteResourceBindingOptions model
    DeleteResourceBindingOptions deleteResourceBindingOptionsModel = new DeleteResourceBindingOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteResourceBinding(deleteResourceBindingOptionsModel).execute();
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
    assertEquals(parsedPath, deleteResourceBindingPath);
  }

  // Test the deleteResourceBinding operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceBindingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteResourceBinding(null).execute();
  }

  @Test
  public void testUpdateResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"region_binding_id\": \"regionBindingId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_alias_url\": \"resourceAliasUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String updateResourceBindingPath = "/v2/resource_bindings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceBindingOptions model
    UpdateResourceBindingOptions updateResourceBindingOptionsModel = new UpdateResourceBindingOptions.Builder()
    .id("testString")
    .name("my-new-binding-name")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBinding> response = testService.updateResourceBinding(updateResourceBindingOptionsModel).execute();
    assertNotNull(response);
    ResourceBinding responseObj = response.getResult();
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
    assertEquals(parsedPath, updateResourceBindingPath);
  }

  // Test the updateResourceBinding operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceBindingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateResourceBinding(null).execute();
  }

  @Test
  public void testListResourceAliasesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"resource_instance_id\": \"resourceInstanceId\", \"region_instance_id\": \"regionInstanceId\", \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}], \"rows_count\": 9}";
    String listResourceAliasesPath = "/v2/resource_aliases";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceAliasesOptions model
    ListResourceAliasesOptions listResourceAliasesOptionsModel = new ListResourceAliasesOptions.Builder()
    .guid("testString")
    .name("testString")
    .resourceInstanceId("testString")
    .regionInstanceId("testString")
    .resourceId("testString")
    .resourceGroupId("testString")
    .limit("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAliasesList> response = testService.listResourceAliases(listResourceAliasesOptionsModel).execute();
    assertNotNull(response);
    ResourceAliasesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("region_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("limit"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceAliasesPath);
  }

  @Test
  public void testCreateResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"resource_instance_id\": \"resourceInstanceId\", \"region_instance_id\": \"regionInstanceId\", \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String createResourceAliasPath = "/v2/resource_aliases";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateResourceAliasOptions model
    CreateResourceAliasOptions createResourceAliasOptionsModel = new CreateResourceAliasOptions.Builder()
    .name("my-alias")
    .source("a8dff6d3-d287-4668-a81d-c87c55c2656d")
    .target("crn:v1:staging:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAlias> response = testService.createResourceAlias(createResourceAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceAlias responseObj = response.getResult();
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
    assertEquals(parsedPath, createResourceAliasPath);
  }

  // Test the createResourceAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createResourceAlias(null).execute();
  }

  @Test
  public void testGetResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"resource_instance_id\": \"resourceInstanceId\", \"region_instance_id\": \"regionInstanceId\", \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String getResourceAliasPath = "/v2/resource_aliases/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceAliasOptions model
    GetResourceAliasOptions getResourceAliasOptionsModel = new GetResourceAliasOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAlias> response = testService.getResourceAlias(getResourceAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceAlias responseObj = response.getResult();
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
    assertEquals(parsedPath, getResourceAliasPath);
  }

  // Test the getResourceAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getResourceAlias(null).execute();
  }

  @Test
  public void testDeleteResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteResourceAliasPath = "/v2/resource_aliases/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteResourceAliasOptions model
    DeleteResourceAliasOptions deleteResourceAliasOptionsModel = new DeleteResourceAliasOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteResourceAlias(deleteResourceAliasOptionsModel).execute();
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
    assertEquals(parsedPath, deleteResourceAliasPath);
  }

  // Test the deleteResourceAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteResourceAlias(null).execute();
  }

  @Test
  public void testUpdateResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"crn\": \"crn\", \"url\": \"url\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"state\": \"state\", \"resource_instance_id\": \"resourceInstanceId\", \"region_instance_id\": \"regionInstanceId\", \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"created_at\": \"2019-01-01T12:00:00\", \"updated_at\": \"2019-01-01T12:00:00\", \"deleted_at\": \"2019-01-01T12:00:00\"}";
    String updateResourceAliasPath = "/v2/resource_aliases/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceAliasOptions model
    UpdateResourceAliasOptions updateResourceAliasOptionsModel = new UpdateResourceAliasOptions.Builder()
    .id("testString")
    .name("my-new-alias-name")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAlias> response = testService.updateResourceAlias(updateResourceAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceAlias responseObj = response.getResult();
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
    assertEquals(parsedPath, updateResourceAliasPath);
  }

  // Test the updateResourceAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateResourceAlias(null).execute();
  }

  @Test
  public void testListReclamationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resources\": [{\"id\": \"id\", \"entity_id\": \"entityId\", \"entity_type_id\": \"entityTypeId\", \"entity_crn\": \"entityCrn\", \"resource_instance_id\": \"anyValue\", \"resource_group_id\": \"resourceGroupId\", \"account_id\": \"accountId\", \"policy_id\": \"policyId\", \"state\": \"state\", \"target_time\": \"targetTime\", \"custom_properties\": {\"mapKey\": \"anyValue\"}, \"created_at\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00\", \"updated_by\": \"updatedBy\"}]}";
    String listReclamationsPath = "/v1/reclamations";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListReclamationsOptions model
    ListReclamationsOptions listReclamationsOptionsModel = new ListReclamationsOptions.Builder()
    .accountId("testString")
    .resourceInstanceId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ReclamationsList> response = testService.listReclamations(listReclamationsOptionsModel).execute();
    assertNotNull(response);
    ReclamationsList responseObj = response.getResult();
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
    assertEquals(query.get("resource_instance_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listReclamationsPath);
  }

  @Test
  public void testRunReclamationActionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"entity_id\": \"entityId\", \"entity_type_id\": \"entityTypeId\", \"entity_crn\": \"entityCrn\", \"resource_instance_id\": \"anyValue\", \"resource_group_id\": \"resourceGroupId\", \"account_id\": \"accountId\", \"policy_id\": \"policyId\", \"state\": \"state\", \"target_time\": \"targetTime\", \"custom_properties\": {\"mapKey\": \"anyValue\"}, \"created_at\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00\", \"updated_by\": \"updatedBy\"}";
    String runReclamationActionPath = "/v1/reclamations/testString/actions/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RunReclamationActionOptions model
    RunReclamationActionOptions runReclamationActionOptionsModel = new RunReclamationActionOptions.Builder()
    .id("testString")
    .actionName("testString")
    .requestBy("testString")
    .comment("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Reclamation> response = testService.runReclamationAction(runReclamationActionOptionsModel).execute();
    assertNotNull(response);
    Reclamation responseObj = response.getResult();
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
    assertEquals(parsedPath, runReclamationActionPath);
  }

  // Test the runReclamationAction operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRunReclamationActionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.runReclamationAction(null).execute();
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