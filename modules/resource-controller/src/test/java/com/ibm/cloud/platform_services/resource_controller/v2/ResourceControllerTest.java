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
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesForInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsForAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysForInstanceOptions;
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
import com.ibm.cloud.sdk.core.util.DateUtils;
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
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class ResourceControllerTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ResourceController resourceControllerService;

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

    resourceControllerService = ResourceController.newInstance(serviceName);
    String url = server.url("/").toString();
    resourceControllerService.setServiceUrl(url);
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
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}]}";
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
    .limit(Long.valueOf("100"))
    .start("testString")
    .state("active")
    .orderDirection("asc")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstancesList> response = resourceControllerService.listResourceInstances(listResourceInstancesOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("state"), "active");
    assertEquals(query.get("order_direction"), "asc");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceInstancesPath);
  }

  @Test
  public void testCreateResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String createResourceInstancePath = "/v2/resource_instances";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateResourceInstanceOptions model
    CreateResourceInstanceOptions createResourceInstanceOptionsModel = new CreateResourceInstanceOptions.Builder()
    .name("ExampleResourceInstance")
    .target("global")
    .resourceGroup("13aa3ee48c3b44ddb64c05c79f7ab8ef")
    .resourcePlanId("a10e4960-3685-11e9-b210-d663bd873d93")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allowCleanup(true)
    .parameters(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .entityLock(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = resourceControllerService.createResourceInstance(createResourceInstanceOptionsModel).execute();
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
    resourceControllerService.createResourceInstance(null).execute();
  }

  @Test
  public void testGetResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
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
    Response<ResourceInstance> response = resourceControllerService.getResourceInstance(getResourceInstanceOptionsModel).execute();
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
    resourceControllerService.getResourceInstance(null).execute();
  }

  @Test
  public void testDeleteResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String deleteResourceInstancePath = "/v2/resource_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteResourceInstanceOptions model
    DeleteResourceInstanceOptions deleteResourceInstanceOptionsModel = new DeleteResourceInstanceOptions.Builder()
    .id("testString")
    .recursive(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = resourceControllerService.deleteResourceInstance(deleteResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("recursive")), Boolean.valueOf(true));
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
    resourceControllerService.deleteResourceInstance(null).execute();
  }

  @Test
  public void testUpdateResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String updateResourceInstancePath = "/v2/resource_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceInstanceOptions model
    UpdateResourceInstanceOptions updateResourceInstanceOptionsModel = new UpdateResourceInstanceOptions.Builder()
    .id("testString")
    .name("UpdatedExampleResourceInstance")
    .parameters(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .resourcePlanId("testString")
    .allowCleanup(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceInstance> response = resourceControllerService.updateResourceInstance(updateResourceInstanceOptionsModel).execute();
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
    resourceControllerService.updateResourceInstance(null).execute();
  }

  @Test
  public void testListResourceAliasesForInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}]}";
    String listResourceAliasesForInstancePath = "/v2/resource_instances/testString/resource_aliases";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceAliasesForInstanceOptions model
    ListResourceAliasesForInstanceOptions listResourceAliasesForInstanceOptionsModel = new ListResourceAliasesForInstanceOptions.Builder()
    .id("testString")
    .limit(Long.valueOf("100"))
    .start("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAliasesList> response = resourceControllerService.listResourceAliasesForInstance(listResourceAliasesForInstanceOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceAliasesForInstancePath);
  }

  // Test the listResourceAliasesForInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceAliasesForInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    resourceControllerService.listResourceAliasesForInstance(null).execute();
  }

  @Test
  public void testListResourceKeysForInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}]}";
    String listResourceKeysForInstancePath = "/v2/resource_instances/testString/resource_keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceKeysForInstanceOptions model
    ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptionsModel = new ListResourceKeysForInstanceOptions.Builder()
    .id("testString")
    .limit(Long.valueOf("100"))
    .start("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKeysList> response = resourceControllerService.listResourceKeysForInstance(listResourceKeysForInstanceOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceKeysForInstancePath);
  }

  // Test the listResourceKeysForInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceKeysForInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    resourceControllerService.listResourceKeysForInstance(null).execute();
  }

  @Test
  public void testLockResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
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
    Response<ResourceInstance> response = resourceControllerService.lockResourceInstance(lockResourceInstanceOptionsModel).execute();
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
    resourceControllerService.lockResourceInstance(null).execute();
  }

  @Test
  public void testUnlockResourceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"parameters\": {\"mapKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"state\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"mapKey\": \"anyValue\"}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"mapKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
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
    Response<ResourceInstance> response = resourceControllerService.unlockResourceInstance(unlockResourceInstanceOptionsModel).execute();
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
    resourceControllerService.unlockResourceInstance(null).execute();
  }

  @Test
  public void testListResourceKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}]}";
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
    .limit(Long.valueOf("100"))
    .start("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKeysList> response = resourceControllerService.listResourceKeys(listResourceKeysOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceKeysPath);
  }

  @Test
  public void testCreateResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}";
    String createResourceKeyPath = "/v2/resource_keys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResourceKeyPostParameters model
    ResourceKeyPostParameters resourceKeyPostParametersModel = new ResourceKeyPostParameters.Builder()
    .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
    .add("foo", "testString")
    .build();

    // Construct an instance of the CreateResourceKeyOptions model
    CreateResourceKeyOptions createResourceKeyOptionsModel = new CreateResourceKeyOptions.Builder()
    .name("ExampleResourceKey")
    .source("381fd51a-f251-4f95-aff4-2b03fa8caa63")
    .parameters(resourceKeyPostParametersModel)
    .role("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKey> response = resourceControllerService.createResourceKey(createResourceKeyOptionsModel).execute();
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
    resourceControllerService.createResourceKey(null).execute();
  }

  @Test
  public void testGetResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}";
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
    Response<ResourceKey> response = resourceControllerService.getResourceKey(getResourceKeyOptionsModel).execute();
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
    resourceControllerService.getResourceKey(null).execute();
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
    Response<Void> response = resourceControllerService.deleteResourceKey(deleteResourceKeyOptionsModel).execute();
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
    resourceControllerService.deleteResourceKey(null).execute();
  }

  @Test
  public void testUpdateResourceKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}";
    String updateResourceKeyPath = "/v2/resource_keys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceKeyOptions model
    UpdateResourceKeyOptions updateResourceKeyOptionsModel = new UpdateResourceKeyOptions.Builder()
    .id("testString")
    .name("UpdatedExampleResourceKey")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceKey> response = resourceControllerService.updateResourceKey(updateResourceKeyOptionsModel).execute();
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
    resourceControllerService.updateResourceKey(null).execute();
  }

  @Test
  public void testListResourceBindingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}]}";
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
    .limit(Long.valueOf("100"))
    .start("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBindingsList> response = resourceControllerService.listResourceBindings(listResourceBindingsOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceBindingsPath);
  }

  @Test
  public void testCreateResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}";
    String createResourceBindingPath = "/v2/resource_bindings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ResourceBindingPostParameters model
    ResourceBindingPostParameters resourceBindingPostParametersModel = new ResourceBindingPostParameters.Builder()
    .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
    .add("foo", "testString")
    .build();

    // Construct an instance of the CreateResourceBindingOptions model
    CreateResourceBindingOptions createResourceBindingOptionsModel = new CreateResourceBindingOptions.Builder()
    .source("faaec9d8-ec64-44d8-ab83-868632fac6a2")
    .target("crn:v1:staging:public:bluemix:us-south:s/e1773b6e-17b4-40c8-b5ed-d2a1c4b620d7::cf-application:8d9457e0-1303-4f32-b4b3-5525575f6205")
    .name("ExampleResourceBinding")
    .parameters(resourceBindingPostParametersModel)
    .role("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBinding> response = resourceControllerService.createResourceBinding(createResourceBindingOptionsModel).execute();
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
    resourceControllerService.createResourceBinding(null).execute();
  }

  @Test
  public void testGetResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}";
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
    Response<ResourceBinding> response = resourceControllerService.getResourceBinding(getResourceBindingOptionsModel).execute();
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
    resourceControllerService.getResourceBinding(null).execute();
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
    Response<Void> response = resourceControllerService.deleteResourceBinding(deleteResourceBindingOptionsModel).execute();
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
    resourceControllerService.deleteResourceBinding(null).execute();
  }

  @Test
  public void testUpdateResourceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}";
    String updateResourceBindingPath = "/v2/resource_bindings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceBindingOptions model
    UpdateResourceBindingOptions updateResourceBindingOptionsModel = new UpdateResourceBindingOptions.Builder()
    .id("testString")
    .name("UpdatedExampleResourceBinding")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBinding> response = resourceControllerService.updateResourceBinding(updateResourceBindingOptionsModel).execute();
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
    resourceControllerService.updateResourceBinding(null).execute();
  }

  @Test
  public void testListResourceAliasesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}]}";
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
    .limit(Long.valueOf("100"))
    .start("testString")
    .updatedFrom("2019-01-08T00:00:00.000Z")
    .updatedTo("2019-01-08T00:00:00.000Z")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAliasesList> response = resourceControllerService.listResourceAliases(listResourceAliasesOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("updated_from"), "2019-01-08T00:00:00.000Z");
    assertEquals(query.get("updated_to"), "2019-01-08T00:00:00.000Z");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceAliasesPath);
  }

  @Test
  public void testCreateResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}";
    String createResourceAliasPath = "/v2/resource_aliases";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateResourceAliasOptions model
    CreateResourceAliasOptions createResourceAliasOptionsModel = new CreateResourceAliasOptions.Builder()
    .name("ExampleResourceAlias")
    .source("381fd51a-f251-4f95-aff4-2b03fa8caa63")
    .target("crn:v1:bluemix:public:bluemix:us-south:o/d35d4f0e-5076-4c89-9361-2522894b6548::cf-space:e1773b6e-17b4-40c8-b5ed-d2a1c4b620d7")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAlias> response = resourceControllerService.createResourceAlias(createResourceAliasOptionsModel).execute();
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
    resourceControllerService.createResourceAlias(null).execute();
  }

  @Test
  public void testGetResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}";
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
    Response<ResourceAlias> response = resourceControllerService.getResourceAlias(getResourceAliasOptionsModel).execute();
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
    resourceControllerService.getResourceAlias(null).execute();
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
    Response<Void> response = resourceControllerService.deleteResourceAlias(deleteResourceAliasOptionsModel).execute();
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
    resourceControllerService.deleteResourceAlias(null).execute();
  }

  @Test
  public void testUpdateResourceAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}";
    String updateResourceAliasPath = "/v2/resource_aliases/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateResourceAliasOptions model
    UpdateResourceAliasOptions updateResourceAliasOptionsModel = new UpdateResourceAliasOptions.Builder()
    .id("testString")
    .name("UpdatedExampleResourceAlias")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceAlias> response = resourceControllerService.updateResourceAlias(updateResourceAliasOptionsModel).execute();
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
    resourceControllerService.updateResourceAlias(null).execute();
  }

  @Test
  public void testListResourceBindingsForAliasWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}]}";
    String listResourceBindingsForAliasPath = "/v2/resource_aliases/testString/resource_bindings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListResourceBindingsForAliasOptions model
    ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptionsModel = new ListResourceBindingsForAliasOptions.Builder()
    .id("testString")
    .limit(Long.valueOf("100"))
    .start("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ResourceBindingsList> response = resourceControllerService.listResourceBindingsForAlias(listResourceBindingsForAliasOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(query.get("start"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceBindingsForAliasPath);
  }

  // Test the listResourceBindingsForAlias operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceBindingsForAliasNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    resourceControllerService.listResourceBindingsForAlias(null).execute();
  }

  @Test
  public void testListReclamationsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resources\": [{\"id\": \"id\", \"entity_id\": \"entityId\", \"entity_type_id\": \"entityTypeId\", \"entity_crn\": \"entityCrn\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_group_id\": \"resourceGroupId\", \"account_id\": \"accountId\", \"policy_id\": \"policyId\", \"state\": \"state\", \"target_time\": \"targetTime\", \"custom_properties\": {\"mapKey\": \"anyValue\"}, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}]}";
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
    Response<ReclamationsList> response = resourceControllerService.listReclamations(listReclamationsOptionsModel).execute();
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
    String mockResponseBody = "{\"id\": \"id\", \"entity_id\": \"entityId\", \"entity_type_id\": \"entityTypeId\", \"entity_crn\": \"entityCrn\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_group_id\": \"resourceGroupId\", \"account_id\": \"accountId\", \"policy_id\": \"policyId\", \"state\": \"state\", \"target_time\": \"targetTime\", \"custom_properties\": {\"mapKey\": \"anyValue\"}, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}";
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
    Response<Reclamation> response = resourceControllerService.runReclamationAction(runReclamationActionOptionsModel).execute();
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
    resourceControllerService.runReclamationAction(null).execute();
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
    resourceControllerService = null;
  }
}