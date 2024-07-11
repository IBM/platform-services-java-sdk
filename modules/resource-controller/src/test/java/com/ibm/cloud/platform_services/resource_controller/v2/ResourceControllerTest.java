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

package com.ibm.cloud.platform_services.resource_controller.v2;

import com.ibm.cloud.platform_services.resource_controller.v2.ResourceController;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CancelLastopResourceInstanceOptions;
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
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesForInstancePager;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesPager;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingPostParameters;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsForAliasPager;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsPager;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstanceLastOperation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesPager;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeyPostParameters;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysForInstancePager;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysPager;
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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
 * Unit test class for the ResourceController service.
 */
public class ResourceControllerTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ResourceController resourceControllerService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new ResourceController(serviceName, null);
  }

  // Test the listResourceInstances operation with a valid options model parameter
  @Test
  public void testListResourceInstancesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}]}";
    String listResourceInstancesPath = "/v2/resource_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceInstancesOptions model
    ListResourceInstancesOptions listResourceInstancesOptionsModel = new ListResourceInstancesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .resourcePlanId("testString")
      .type("testString")
      .subType("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .state("active")
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    // Invoke listResourceInstances() with a valid options model and verify the result
    Response<ResourceInstancesList> response = resourceControllerService.listResourceInstances(listResourceInstancesOptionsModel).execute();
    assertNotNull(response);
    ResourceInstancesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceInstancesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("resource_plan_id"), "testString");
    assertEquals(query.get("type"), "testString");
    assertEquals(query.get("sub_type"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("state"), "active");
    assertEquals(query.get("updated_from"), "2021-01-01");
    assertEquals(query.get("updated_to"), "2021-01-01");
  }

  // Test the listResourceInstances operation with and without retries enabled
  @Test
  public void testListResourceInstancesWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceInstancesWOptions();

    resourceControllerService.disableRetries();
    testListResourceInstancesWOptions();
  }

  // Test the listResourceInstances operation using the ResourceInstancesPager.getNext() method
  @Test
  public void testListResourceInstancesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"scheduled_reclaim_at\":\"2019-01-01T12:00:00.000Z\",\"restored_at\":\"2019-01-01T12:00:00.000Z\",\"restored_by\":\"restoredBy\",\"scheduled_reclaim_by\":\"scheduledReclaimBy\",\"name\":\"name\",\"region_id\":\"regionId\",\"account_id\":\"accountId\",\"reseller_channel_id\":\"resellerChannelId\",\"resource_plan_id\":\"resourcePlanId\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_crn\":\"resourceGroupCrn\",\"target_crn\":\"targetCrn\",\"onetime_credentials\":true,\"parameters\":{\"anyKey\":\"anyValue\"},\"allow_cleanup\":true,\"crn\":\"crn\",\"state\":\"active\",\"type\":\"type\",\"sub_type\":\"subType\",\"resource_id\":\"resourceId\",\"dashboard_url\":\"dashboardUrl\",\"last_operation\":{\"type\":\"type\",\"state\":\"in progress\",\"sub_type\":\"subType\",\"async\":false,\"description\":\"description\",\"reason_code\":\"reasonCode\",\"poll_after\":9,\"cancelable\":true,\"poll\":true},\"resource_aliases_url\":\"resourceAliasesUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\",\"plan_history\":[{\"resource_plan_id\":\"resourcePlanId\",\"start_date\":\"2019-01-01T12:00:00.000Z\",\"requestor_id\":\"requestorId\"}],\"migrated\":true,\"extensions\":{\"anyKey\":\"anyValue\"},\"controlled_by\":\"controlledBy\",\"locked\":true}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"scheduled_reclaim_at\":\"2019-01-01T12:00:00.000Z\",\"restored_at\":\"2019-01-01T12:00:00.000Z\",\"restored_by\":\"restoredBy\",\"scheduled_reclaim_by\":\"scheduledReclaimBy\",\"name\":\"name\",\"region_id\":\"regionId\",\"account_id\":\"accountId\",\"reseller_channel_id\":\"resellerChannelId\",\"resource_plan_id\":\"resourcePlanId\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_crn\":\"resourceGroupCrn\",\"target_crn\":\"targetCrn\",\"onetime_credentials\":true,\"parameters\":{\"anyKey\":\"anyValue\"},\"allow_cleanup\":true,\"crn\":\"crn\",\"state\":\"active\",\"type\":\"type\",\"sub_type\":\"subType\",\"resource_id\":\"resourceId\",\"dashboard_url\":\"dashboardUrl\",\"last_operation\":{\"type\":\"type\",\"state\":\"in progress\",\"sub_type\":\"subType\",\"async\":false,\"description\":\"description\",\"reason_code\":\"reasonCode\",\"poll_after\":9,\"cancelable\":true,\"poll\":true},\"resource_aliases_url\":\"resourceAliasesUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\",\"plan_history\":[{\"resource_plan_id\":\"resourcePlanId\",\"start_date\":\"2019-01-01T12:00:00.000Z\",\"requestor_id\":\"requestorId\"}],\"migrated\":true,\"extensions\":{\"anyKey\":\"anyValue\"},\"controlled_by\":\"controlledBy\",\"locked\":true}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceInstancesOptions listResourceInstancesOptions = new ListResourceInstancesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .resourcePlanId("testString")
      .type("testString")
      .subType("testString")
      .limit(Long.valueOf("10"))
      .state("active")
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    List<ResourceInstance> allResults = new ArrayList<>();
    ResourceInstancesPager pager = new ResourceInstancesPager(resourceControllerService, listResourceInstancesOptions);
    while (pager.hasNext()) {
      List<ResourceInstance> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceInstances operation using the ResourceInstancesPager.getAll() method
  @Test
  public void testListResourceInstancesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"scheduled_reclaim_at\":\"2019-01-01T12:00:00.000Z\",\"restored_at\":\"2019-01-01T12:00:00.000Z\",\"restored_by\":\"restoredBy\",\"scheduled_reclaim_by\":\"scheduledReclaimBy\",\"name\":\"name\",\"region_id\":\"regionId\",\"account_id\":\"accountId\",\"reseller_channel_id\":\"resellerChannelId\",\"resource_plan_id\":\"resourcePlanId\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_crn\":\"resourceGroupCrn\",\"target_crn\":\"targetCrn\",\"onetime_credentials\":true,\"parameters\":{\"anyKey\":\"anyValue\"},\"allow_cleanup\":true,\"crn\":\"crn\",\"state\":\"active\",\"type\":\"type\",\"sub_type\":\"subType\",\"resource_id\":\"resourceId\",\"dashboard_url\":\"dashboardUrl\",\"last_operation\":{\"type\":\"type\",\"state\":\"in progress\",\"sub_type\":\"subType\",\"async\":false,\"description\":\"description\",\"reason_code\":\"reasonCode\",\"poll_after\":9,\"cancelable\":true,\"poll\":true},\"resource_aliases_url\":\"resourceAliasesUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\",\"plan_history\":[{\"resource_plan_id\":\"resourcePlanId\",\"start_date\":\"2019-01-01T12:00:00.000Z\",\"requestor_id\":\"requestorId\"}],\"migrated\":true,\"extensions\":{\"anyKey\":\"anyValue\"},\"controlled_by\":\"controlledBy\",\"locked\":true}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"scheduled_reclaim_at\":\"2019-01-01T12:00:00.000Z\",\"restored_at\":\"2019-01-01T12:00:00.000Z\",\"restored_by\":\"restoredBy\",\"scheduled_reclaim_by\":\"scheduledReclaimBy\",\"name\":\"name\",\"region_id\":\"regionId\",\"account_id\":\"accountId\",\"reseller_channel_id\":\"resellerChannelId\",\"resource_plan_id\":\"resourcePlanId\",\"resource_group_id\":\"resourceGroupId\",\"resource_group_crn\":\"resourceGroupCrn\",\"target_crn\":\"targetCrn\",\"onetime_credentials\":true,\"parameters\":{\"anyKey\":\"anyValue\"},\"allow_cleanup\":true,\"crn\":\"crn\",\"state\":\"active\",\"type\":\"type\",\"sub_type\":\"subType\",\"resource_id\":\"resourceId\",\"dashboard_url\":\"dashboardUrl\",\"last_operation\":{\"type\":\"type\",\"state\":\"in progress\",\"sub_type\":\"subType\",\"async\":false,\"description\":\"description\",\"reason_code\":\"reasonCode\",\"poll_after\":9,\"cancelable\":true,\"poll\":true},\"resource_aliases_url\":\"resourceAliasesUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\",\"plan_history\":[{\"resource_plan_id\":\"resourcePlanId\",\"start_date\":\"2019-01-01T12:00:00.000Z\",\"requestor_id\":\"requestorId\"}],\"migrated\":true,\"extensions\":{\"anyKey\":\"anyValue\"},\"controlled_by\":\"controlledBy\",\"locked\":true}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceInstancesOptions listResourceInstancesOptions = new ListResourceInstancesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .resourcePlanId("testString")
      .type("testString")
      .subType("testString")
      .limit(Long.valueOf("10"))
      .state("active")
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    ResourceInstancesPager pager = new ResourceInstancesPager(resourceControllerService, listResourceInstancesOptions);
    List<ResourceInstance> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createResourceInstance operation with a valid options model parameter
  @Test
  public void testCreateResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String createResourceInstancePath = "/v2/resource_instances";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateResourceInstanceOptions model
    CreateResourceInstanceOptions createResourceInstanceOptionsModel = new CreateResourceInstanceOptions.Builder()
      .name("ExampleResourceInstance")
      .target("global")
      .resourceGroup("13aa3ee48c3b44ddb64c05c79f7ab8ef")
      .resourcePlanId("a10e4960-3685-11e9-b210-d663bd873d93")
      .tags(java.util.Arrays.asList("testString"))
      .allowCleanup(false)
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .entityLock(false)
      .build();

    // Invoke createResourceInstance() with a valid options model and verify the result
    Response<ResourceInstance> response = resourceControllerService.createResourceInstance(createResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createResourceInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createResourceInstance operation with and without retries enabled
  @Test
  public void testCreateResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testCreateResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testCreateResourceInstanceWOptions();
  }

  // Test the createResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.createResourceInstance(null).execute();
  }

  // Test the getResourceInstance operation with a valid options model parameter
  @Test
  public void testGetResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String getResourceInstancePath = "/v2/resource_instances/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceInstanceOptions model
    GetResourceInstanceOptions getResourceInstanceOptionsModel = new GetResourceInstanceOptions.Builder()
      .id("testString")
      .build();

    // Invoke getResourceInstance() with a valid options model and verify the result
    Response<ResourceInstance> response = resourceControllerService.getResourceInstance(getResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getResourceInstance operation with and without retries enabled
  @Test
  public void testGetResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testGetResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testGetResourceInstanceWOptions();
  }

  // Test the getResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.getResourceInstance(null).execute();
  }

  // Test the deleteResourceInstance operation with a valid options model parameter
  @Test
  public void testDeleteResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteResourceInstancePath = "/v2/resource_instances/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteResourceInstanceOptions model
    DeleteResourceInstanceOptions deleteResourceInstanceOptionsModel = new DeleteResourceInstanceOptions.Builder()
      .id("testString")
      .recursive(false)
      .build();

    // Invoke deleteResourceInstance() with a valid options model and verify the result
    Response<Void> response = resourceControllerService.deleteResourceInstance(deleteResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteResourceInstancePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("recursive")), Boolean.valueOf(false));
  }

  // Test the deleteResourceInstance operation with and without retries enabled
  @Test
  public void testDeleteResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testDeleteResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testDeleteResourceInstanceWOptions();
  }

  // Test the deleteResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.deleteResourceInstance(null).execute();
  }

  // Test the updateResourceInstance operation with a valid options model parameter
  @Test
  public void testUpdateResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String updateResourceInstancePath = "/v2/resource_instances/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateResourceInstanceOptions model
    UpdateResourceInstanceOptions updateResourceInstanceOptionsModel = new UpdateResourceInstanceOptions.Builder()
      .id("testString")
      .name("UpdatedExampleResourceInstance")
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .resourcePlanId("testString")
      .allowCleanup(true)
      .build();

    // Invoke updateResourceInstance() with a valid options model and verify the result
    Response<ResourceInstance> response = resourceControllerService.updateResourceInstance(updateResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateResourceInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateResourceInstance operation with and without retries enabled
  @Test
  public void testUpdateResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testUpdateResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testUpdateResourceInstanceWOptions();
  }

  // Test the updateResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.updateResourceInstance(null).execute();
  }

  // Test the listResourceAliasesForInstance operation with a valid options model parameter
  @Test
  public void testListResourceAliasesForInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}]}";
    String listResourceAliasesForInstancePath = "/v2/resource_instances/testString/resource_aliases";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceAliasesForInstanceOptions model
    ListResourceAliasesForInstanceOptions listResourceAliasesForInstanceOptionsModel = new ListResourceAliasesForInstanceOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listResourceAliasesForInstance() with a valid options model and verify the result
    Response<ResourceAliasesList> response = resourceControllerService.listResourceAliasesForInstance(listResourceAliasesForInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceAliasesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceAliasesForInstancePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listResourceAliasesForInstance operation with and without retries enabled
  @Test
  public void testListResourceAliasesForInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceAliasesForInstanceWOptions();

    resourceControllerService.disableRetries();
    testListResourceAliasesForInstanceWOptions();
  }

  // Test the listResourceAliasesForInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceAliasesForInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.listResourceAliasesForInstance(null).execute();
  }

  // Test the listResourceAliasesForInstance operation using the ResourceAliasesForInstancePager.getNext() method
  @Test
  public void testListResourceAliasesForInstanceWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceAliasesForInstanceOptions listResourceAliasesForInstanceOptions = new ListResourceAliasesForInstanceOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<ResourceAlias> allResults = new ArrayList<>();
    ResourceAliasesForInstancePager pager = new ResourceAliasesForInstancePager(resourceControllerService, listResourceAliasesForInstanceOptions);
    while (pager.hasNext()) {
      List<ResourceAlias> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceAliasesForInstance operation using the ResourceAliasesForInstancePager.getAll() method
  @Test
  public void testListResourceAliasesForInstanceWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceAliasesForInstanceOptions listResourceAliasesForInstanceOptions = new ListResourceAliasesForInstanceOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .build();

    ResourceAliasesForInstancePager pager = new ResourceAliasesForInstancePager(resourceControllerService, listResourceAliasesForInstanceOptions);
    List<ResourceAlias> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceKeysForInstance operation with a valid options model parameter
  @Test
  public void testListResourceKeysForInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"onetime_credentials\": true, \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}]}";
    String listResourceKeysForInstancePath = "/v2/resource_instances/testString/resource_keys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceKeysForInstanceOptions model
    ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptionsModel = new ListResourceKeysForInstanceOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listResourceKeysForInstance() with a valid options model and verify the result
    Response<ResourceKeysList> response = resourceControllerService.listResourceKeysForInstance(listResourceKeysForInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceKeysList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceKeysForInstancePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listResourceKeysForInstance operation with and without retries enabled
  @Test
  public void testListResourceKeysForInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceKeysForInstanceWOptions();

    resourceControllerService.disableRetries();
    testListResourceKeysForInstanceWOptions();
  }

  // Test the listResourceKeysForInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceKeysForInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.listResourceKeysForInstance(null).execute();
  }

  // Test the listResourceKeysForInstance operation using the ResourceKeysForInstancePager.getNext() method
  @Test
  public void testListResourceKeysForInstanceWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptions = new ListResourceKeysForInstanceOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<ResourceKey> allResults = new ArrayList<>();
    ResourceKeysForInstancePager pager = new ResourceKeysForInstancePager(resourceControllerService, listResourceKeysForInstanceOptions);
    while (pager.hasNext()) {
      List<ResourceKey> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceKeysForInstance operation using the ResourceKeysForInstancePager.getAll() method
  @Test
  public void testListResourceKeysForInstanceWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceKeysForInstanceOptions listResourceKeysForInstanceOptions = new ListResourceKeysForInstanceOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .build();

    ResourceKeysForInstancePager pager = new ResourceKeysForInstancePager(resourceControllerService, listResourceKeysForInstanceOptions);
    List<ResourceKey> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the lockResourceInstance operation with a valid options model parameter
  @Test
  public void testLockResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String lockResourceInstancePath = "/v2/resource_instances/testString/lock";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the LockResourceInstanceOptions model
    LockResourceInstanceOptions lockResourceInstanceOptionsModel = new LockResourceInstanceOptions.Builder()
      .id("testString")
      .build();

    // Invoke lockResourceInstance() with a valid options model and verify the result
    Response<ResourceInstance> response = resourceControllerService.lockResourceInstance(lockResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockResourceInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the lockResourceInstance operation with and without retries enabled
  @Test
  public void testLockResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testLockResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testLockResourceInstanceWOptions();
  }

  // Test the lockResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.lockResourceInstance(null).execute();
  }

  // Test the unlockResourceInstance operation with a valid options model parameter
  @Test
  public void testUnlockResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String unlockResourceInstancePath = "/v2/resource_instances/testString/lock";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UnlockResourceInstanceOptions model
    UnlockResourceInstanceOptions unlockResourceInstanceOptionsModel = new UnlockResourceInstanceOptions.Builder()
      .id("testString")
      .build();

    // Invoke unlockResourceInstance() with a valid options model and verify the result
    Response<ResourceInstance> response = resourceControllerService.unlockResourceInstance(unlockResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unlockResourceInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unlockResourceInstance operation with and without retries enabled
  @Test
  public void testUnlockResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testUnlockResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testUnlockResourceInstanceWOptions();
  }

  // Test the unlockResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.unlockResourceInstance(null).execute();
  }

  // Test the cancelLastopResourceInstance operation with a valid options model parameter
  @Test
  public void testCancelLastopResourceInstanceWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"scheduled_reclaim_at\": \"2019-01-01T12:00:00.000Z\", \"restored_at\": \"2019-01-01T12:00:00.000Z\", \"restored_by\": \"restoredBy\", \"scheduled_reclaim_by\": \"scheduledReclaimBy\", \"name\": \"name\", \"region_id\": \"regionId\", \"account_id\": \"accountId\", \"reseller_channel_id\": \"resellerChannelId\", \"resource_plan_id\": \"resourcePlanId\", \"resource_group_id\": \"resourceGroupId\", \"resource_group_crn\": \"resourceGroupCrn\", \"target_crn\": \"targetCrn\", \"onetime_credentials\": true, \"parameters\": {\"anyKey\": \"anyValue\"}, \"allow_cleanup\": true, \"crn\": \"crn\", \"state\": \"active\", \"type\": \"type\", \"sub_type\": \"subType\", \"resource_id\": \"resourceId\", \"dashboard_url\": \"dashboardUrl\", \"last_operation\": {\"type\": \"type\", \"state\": \"in progress\", \"sub_type\": \"subType\", \"async\": false, \"description\": \"description\", \"reason_code\": \"reasonCode\", \"poll_after\": 9, \"cancelable\": true, \"poll\": true}, \"resource_aliases_url\": \"resourceAliasesUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\", \"plan_history\": [{\"resource_plan_id\": \"resourcePlanId\", \"start_date\": \"2019-01-01T12:00:00.000Z\", \"requestor_id\": \"requestorId\"}], \"migrated\": true, \"extensions\": {\"anyKey\": \"anyValue\"}, \"controlled_by\": \"controlledBy\", \"locked\": true}";
    String cancelLastopResourceInstancePath = "/v2/resource_instances/testString/last_operation";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the CancelLastopResourceInstanceOptions model
    CancelLastopResourceInstanceOptions cancelLastopResourceInstanceOptionsModel = new CancelLastopResourceInstanceOptions.Builder()
      .id("testString")
      .build();

    // Invoke cancelLastopResourceInstance() with a valid options model and verify the result
    Response<ResourceInstance> response = resourceControllerService.cancelLastopResourceInstance(cancelLastopResourceInstanceOptionsModel).execute();
    assertNotNull(response);
    ResourceInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, cancelLastopResourceInstancePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the cancelLastopResourceInstance operation with and without retries enabled
  @Test
  public void testCancelLastopResourceInstanceWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testCancelLastopResourceInstanceWOptions();

    resourceControllerService.disableRetries();
    testCancelLastopResourceInstanceWOptions();
  }

  // Test the cancelLastopResourceInstance operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCancelLastopResourceInstanceNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.cancelLastopResourceInstance(null).execute();
  }

  // Test the listResourceKeys operation with a valid options model parameter
  @Test
  public void testListResourceKeysWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"onetime_credentials\": true, \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}]}";
    String listResourceKeysPath = "/v2/resource_keys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceKeysOptions model
    ListResourceKeysOptions listResourceKeysOptionsModel = new ListResourceKeysOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    // Invoke listResourceKeys() with a valid options model and verify the result
    Response<ResourceKeysList> response = resourceControllerService.listResourceKeys(listResourceKeysOptionsModel).execute();
    assertNotNull(response);
    ResourceKeysList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceKeysPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("updated_from"), "2021-01-01");
    assertEquals(query.get("updated_to"), "2021-01-01");
  }

  // Test the listResourceKeys operation with and without retries enabled
  @Test
  public void testListResourceKeysWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceKeysWOptions();

    resourceControllerService.disableRetries();
    testListResourceKeysWOptions();
  }

  // Test the listResourceKeys operation using the ResourceKeysPager.getNext() method
  @Test
  public void testListResourceKeysWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceKeysOptions listResourceKeysOptions = new ListResourceKeysOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .limit(Long.valueOf("10"))
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    List<ResourceKey> allResults = new ArrayList<>();
    ResourceKeysPager pager = new ResourceKeysPager(resourceControllerService, listResourceKeysOptions);
    while (pager.hasNext()) {
      List<ResourceKey> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceKeys operation using the ResourceKeysPager.getAll() method
  @Test
  public void testListResourceKeysWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"name\":\"name\",\"crn\":\"crn\",\"state\":\"state\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"resource_id\":\"resourceId\",\"onetime_credentials\":true,\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceKeysOptions listResourceKeysOptions = new ListResourceKeysOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .limit(Long.valueOf("10"))
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    ResourceKeysPager pager = new ResourceKeysPager(resourceControllerService, listResourceKeysOptions);
    List<ResourceKey> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createResourceKey operation with a valid options model parameter
  @Test
  public void testCreateResourceKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"onetime_credentials\": true, \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}";
    String createResourceKeyPath = "/v2/resource_keys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ResourceKeyPostParameters model
    ResourceKeyPostParameters resourceKeyPostParametersModel = new ResourceKeyPostParameters.Builder()
      .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
      .add("exampleParameter", "exampleValue")
      .build();

    // Construct an instance of the CreateResourceKeyOptions model
    CreateResourceKeyOptions createResourceKeyOptionsModel = new CreateResourceKeyOptions.Builder()
      .name("ExampleResourceKey")
      .source("381fd51a-f251-4f95-aff4-2b03fa8caa63")
      .parameters(resourceKeyPostParametersModel)
      .role("Writer")
      .build();

    // Invoke createResourceKey() with a valid options model and verify the result
    Response<ResourceKey> response = resourceControllerService.createResourceKey(createResourceKeyOptionsModel).execute();
    assertNotNull(response);
    ResourceKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createResourceKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createResourceKey operation with and without retries enabled
  @Test
  public void testCreateResourceKeyWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testCreateResourceKeyWOptions();

    resourceControllerService.disableRetries();
    testCreateResourceKeyWOptions();
  }

  // Test the createResourceKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.createResourceKey(null).execute();
  }

  // Test the getResourceKey operation with a valid options model parameter
  @Test
  public void testGetResourceKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"onetime_credentials\": true, \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}";
    String getResourceKeyPath = "/v2/resource_keys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceKeyOptions model
    GetResourceKeyOptions getResourceKeyOptionsModel = new GetResourceKeyOptions.Builder()
      .id("testString")
      .build();

    // Invoke getResourceKey() with a valid options model and verify the result
    Response<ResourceKey> response = resourceControllerService.getResourceKey(getResourceKeyOptionsModel).execute();
    assertNotNull(response);
    ResourceKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getResourceKey operation with and without retries enabled
  @Test
  public void testGetResourceKeyWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testGetResourceKeyWOptions();

    resourceControllerService.disableRetries();
    testGetResourceKeyWOptions();
  }

  // Test the getResourceKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.getResourceKey(null).execute();
  }

  // Test the deleteResourceKey operation with a valid options model parameter
  @Test
  public void testDeleteResourceKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteResourceKeyPath = "/v2/resource_keys/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteResourceKeyOptions model
    DeleteResourceKeyOptions deleteResourceKeyOptionsModel = new DeleteResourceKeyOptions.Builder()
      .id("testString")
      .build();

    // Invoke deleteResourceKey() with a valid options model and verify the result
    Response<Void> response = resourceControllerService.deleteResourceKey(deleteResourceKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteResourceKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteResourceKey operation with and without retries enabled
  @Test
  public void testDeleteResourceKeyWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testDeleteResourceKeyWOptions();

    resourceControllerService.disableRetries();
    testDeleteResourceKeyWOptions();
  }

  // Test the deleteResourceKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.deleteResourceKey(null).execute();
  }

  // Test the updateResourceKey operation with a valid options model parameter
  @Test
  public void testUpdateResourceKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"name\": \"name\", \"crn\": \"crn\", \"state\": \"state\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"resource_id\": \"resourceId\", \"onetime_credentials\": true, \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_alias_url\": \"resourceAliasUrl\"}";
    String updateResourceKeyPath = "/v2/resource_keys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateResourceKeyOptions model
    UpdateResourceKeyOptions updateResourceKeyOptionsModel = new UpdateResourceKeyOptions.Builder()
      .id("testString")
      .name("UpdatedExampleResourceKey")
      .build();

    // Invoke updateResourceKey() with a valid options model and verify the result
    Response<ResourceKey> response = resourceControllerService.updateResourceKey(updateResourceKeyOptionsModel).execute();
    assertNotNull(response);
    ResourceKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateResourceKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateResourceKey operation with and without retries enabled
  @Test
  public void testUpdateResourceKeyWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testUpdateResourceKeyWOptions();

    resourceControllerService.disableRetries();
    testUpdateResourceKeyWOptions();
  }

  // Test the updateResourceKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.updateResourceKey(null).execute();
  }

  // Test the listResourceBindings operation with a valid options model parameter
  @Test
  public void testListResourceBindingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}]}";
    String listResourceBindingsPath = "/v2/resource_bindings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceBindingsOptions model
    ListResourceBindingsOptions listResourceBindingsOptionsModel = new ListResourceBindingsOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .regionBindingId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    // Invoke listResourceBindings() with a valid options model and verify the result
    Response<ResourceBindingsList> response = resourceControllerService.listResourceBindings(listResourceBindingsOptionsModel).execute();
    assertNotNull(response);
    ResourceBindingsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceBindingsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("region_binding_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("updated_from"), "2021-01-01");
    assertEquals(query.get("updated_to"), "2021-01-01");
  }

  // Test the listResourceBindings operation with and without retries enabled
  @Test
  public void testListResourceBindingsWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceBindingsWOptions();

    resourceControllerService.disableRetries();
    testListResourceBindingsWOptions();
  }

  // Test the listResourceBindings operation using the ResourceBindingsPager.getNext() method
  @Test
  public void testListResourceBindingsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceBindingsOptions listResourceBindingsOptions = new ListResourceBindingsOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .regionBindingId("testString")
      .limit(Long.valueOf("10"))
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    List<ResourceBinding> allResults = new ArrayList<>();
    ResourceBindingsPager pager = new ResourceBindingsPager(resourceControllerService, listResourceBindingsOptions);
    while (pager.hasNext()) {
      List<ResourceBinding> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceBindings operation using the ResourceBindingsPager.getAll() method
  @Test
  public void testListResourceBindingsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceBindingsOptions listResourceBindingsOptions = new ListResourceBindingsOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .regionBindingId("testString")
      .limit(Long.valueOf("10"))
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    ResourceBindingsPager pager = new ResourceBindingsPager(resourceControllerService, listResourceBindingsOptions);
    List<ResourceBinding> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createResourceBinding operation with a valid options model parameter
  @Test
  public void testCreateResourceBindingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}";
    String createResourceBindingPath = "/v2/resource_bindings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the ResourceBindingPostParameters model
    ResourceBindingPostParameters resourceBindingPostParametersModel = new ResourceBindingPostParameters.Builder()
      .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
      .add("exampleParameter", "exampleValue")
      .build();

    // Construct an instance of the CreateResourceBindingOptions model
    CreateResourceBindingOptions createResourceBindingOptionsModel = new CreateResourceBindingOptions.Builder()
      .source("faaec9d8-ec64-44d8-ab83-868632fac6a2")
      .target("crn:v1:staging:public:bluemix:us-south:s/e1773b6e-17b4-40c8-b5ed-d2a1c4b620d7::cf-application:8d9457e0-1303-4f32-b4b3-5525575f6205")
      .name("ExampleResourceBinding")
      .parameters(resourceBindingPostParametersModel)
      .role("Writer")
      .build();

    // Invoke createResourceBinding() with a valid options model and verify the result
    Response<ResourceBinding> response = resourceControllerService.createResourceBinding(createResourceBindingOptionsModel).execute();
    assertNotNull(response);
    ResourceBinding responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createResourceBindingPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createResourceBinding operation with and without retries enabled
  @Test
  public void testCreateResourceBindingWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testCreateResourceBindingWOptions();

    resourceControllerService.disableRetries();
    testCreateResourceBindingWOptions();
  }

  // Test the createResourceBinding operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceBindingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.createResourceBinding(null).execute();
  }

  // Test the getResourceBinding operation with a valid options model parameter
  @Test
  public void testGetResourceBindingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}";
    String getResourceBindingPath = "/v2/resource_bindings/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceBindingOptions model
    GetResourceBindingOptions getResourceBindingOptionsModel = new GetResourceBindingOptions.Builder()
      .id("testString")
      .build();

    // Invoke getResourceBinding() with a valid options model and verify the result
    Response<ResourceBinding> response = resourceControllerService.getResourceBinding(getResourceBindingOptionsModel).execute();
    assertNotNull(response);
    ResourceBinding responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceBindingPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getResourceBinding operation with and without retries enabled
  @Test
  public void testGetResourceBindingWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testGetResourceBindingWOptions();

    resourceControllerService.disableRetries();
    testGetResourceBindingWOptions();
  }

  // Test the getResourceBinding operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceBindingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.getResourceBinding(null).execute();
  }

  // Test the deleteResourceBinding operation with a valid options model parameter
  @Test
  public void testDeleteResourceBindingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteResourceBindingPath = "/v2/resource_bindings/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteResourceBindingOptions model
    DeleteResourceBindingOptions deleteResourceBindingOptionsModel = new DeleteResourceBindingOptions.Builder()
      .id("testString")
      .build();

    // Invoke deleteResourceBinding() with a valid options model and verify the result
    Response<Void> response = resourceControllerService.deleteResourceBinding(deleteResourceBindingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteResourceBindingPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteResourceBinding operation with and without retries enabled
  @Test
  public void testDeleteResourceBindingWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testDeleteResourceBindingWOptions();

    resourceControllerService.disableRetries();
    testDeleteResourceBindingWOptions();
  }

  // Test the deleteResourceBinding operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceBindingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.deleteResourceBinding(null).execute();
  }

  // Test the updateResourceBinding operation with a valid options model parameter
  @Test
  public void testUpdateResourceBindingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}";
    String updateResourceBindingPath = "/v2/resource_bindings/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateResourceBindingOptions model
    UpdateResourceBindingOptions updateResourceBindingOptionsModel = new UpdateResourceBindingOptions.Builder()
      .id("testString")
      .name("UpdatedExampleResourceBinding")
      .build();

    // Invoke updateResourceBinding() with a valid options model and verify the result
    Response<ResourceBinding> response = resourceControllerService.updateResourceBinding(updateResourceBindingOptionsModel).execute();
    assertNotNull(response);
    ResourceBinding responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateResourceBindingPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateResourceBinding operation with and without retries enabled
  @Test
  public void testUpdateResourceBindingWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testUpdateResourceBindingWOptions();

    resourceControllerService.disableRetries();
    testUpdateResourceBindingWOptions();
  }

  // Test the updateResourceBinding operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceBindingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.updateResourceBinding(null).execute();
  }

  // Test the listResourceAliases operation with a valid options model parameter
  @Test
  public void testListResourceAliasesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}]}";
    String listResourceAliasesPath = "/v2/resource_aliases";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceAliasesOptions model
    ListResourceAliasesOptions listResourceAliasesOptionsModel = new ListResourceAliasesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceInstanceId("testString")
      .regionInstanceId("testString")
      .resourceId("testString")
      .resourceGroupId("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    // Invoke listResourceAliases() with a valid options model and verify the result
    Response<ResourceAliasesList> response = resourceControllerService.listResourceAliases(listResourceAliasesOptionsModel).execute();
    assertNotNull(response);
    ResourceAliasesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceAliasesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("guid"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("region_instance_id"), "testString");
    assertEquals(query.get("resource_id"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
    assertEquals(query.get("updated_from"), "2021-01-01");
    assertEquals(query.get("updated_to"), "2021-01-01");
  }

  // Test the listResourceAliases operation with and without retries enabled
  @Test
  public void testListResourceAliasesWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceAliasesWOptions();

    resourceControllerService.disableRetries();
    testListResourceAliasesWOptions();
  }

  // Test the listResourceAliases operation using the ResourceAliasesPager.getNext() method
  @Test
  public void testListResourceAliasesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceAliasesOptions listResourceAliasesOptions = new ListResourceAliasesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceInstanceId("testString")
      .regionInstanceId("testString")
      .resourceId("testString")
      .resourceGroupId("testString")
      .limit(Long.valueOf("10"))
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    List<ResourceAlias> allResults = new ArrayList<>();
    ResourceAliasesPager pager = new ResourceAliasesPager(resourceControllerService, listResourceAliasesOptions);
    while (pager.hasNext()) {
      List<ResourceAlias> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceAliases operation using the ResourceAliasesPager.getAll() method
  @Test
  public void testListResourceAliasesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"name\":\"name\",\"resource_instance_id\":\"resourceInstanceId\",\"target_crn\":\"targetCrn\",\"account_id\":\"accountId\",\"resource_id\":\"resourceId\",\"resource_group_id\":\"resourceGroupId\",\"crn\":\"crn\",\"region_instance_id\":\"regionInstanceId\",\"region_instance_crn\":\"regionInstanceCrn\",\"state\":\"state\",\"migrated\":true,\"resource_instance_url\":\"resourceInstanceUrl\",\"resource_bindings_url\":\"resourceBindingsUrl\",\"resource_keys_url\":\"resourceKeysUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceAliasesOptions listResourceAliasesOptions = new ListResourceAliasesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceInstanceId("testString")
      .regionInstanceId("testString")
      .resourceId("testString")
      .resourceGroupId("testString")
      .limit(Long.valueOf("10"))
      .updatedFrom("2021-01-01")
      .updatedTo("2021-01-01")
      .build();

    ResourceAliasesPager pager = new ResourceAliasesPager(resourceControllerService, listResourceAliasesOptions);
    List<ResourceAlias> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createResourceAlias operation with a valid options model parameter
  @Test
  public void testCreateResourceAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}";
    String createResourceAliasPath = "/v2/resource_aliases";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateResourceAliasOptions model
    CreateResourceAliasOptions createResourceAliasOptionsModel = new CreateResourceAliasOptions.Builder()
      .name("ExampleResourceAlias")
      .source("381fd51a-f251-4f95-aff4-2b03fa8caa63")
      .target("crn:v1:bluemix:public:bluemix:us-south:o/d35d4f0e-5076-4c89-9361-2522894b6548::cf-space:e1773b6e-17b4-40c8-b5ed-d2a1c4b620d7")
      .build();

    // Invoke createResourceAlias() with a valid options model and verify the result
    Response<ResourceAlias> response = resourceControllerService.createResourceAlias(createResourceAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceAlias responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createResourceAliasPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createResourceAlias operation with and without retries enabled
  @Test
  public void testCreateResourceAliasWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testCreateResourceAliasWOptions();

    resourceControllerService.disableRetries();
    testCreateResourceAliasWOptions();
  }

  // Test the createResourceAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.createResourceAlias(null).execute();
  }

  // Test the getResourceAlias operation with a valid options model parameter
  @Test
  public void testGetResourceAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}";
    String getResourceAliasPath = "/v2/resource_aliases/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetResourceAliasOptions model
    GetResourceAliasOptions getResourceAliasOptionsModel = new GetResourceAliasOptions.Builder()
      .id("testString")
      .build();

    // Invoke getResourceAlias() with a valid options model and verify the result
    Response<ResourceAlias> response = resourceControllerService.getResourceAlias(getResourceAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceAlias responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getResourceAliasPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getResourceAlias operation with and without retries enabled
  @Test
  public void testGetResourceAliasWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testGetResourceAliasWOptions();

    resourceControllerService.disableRetries();
    testGetResourceAliasWOptions();
  }

  // Test the getResourceAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.getResourceAlias(null).execute();
  }

  // Test the deleteResourceAlias operation with a valid options model parameter
  @Test
  public void testDeleteResourceAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteResourceAliasPath = "/v2/resource_aliases/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteResourceAliasOptions model
    DeleteResourceAliasOptions deleteResourceAliasOptionsModel = new DeleteResourceAliasOptions.Builder()
      .id("testString")
      .recursive(false)
      .build();

    // Invoke deleteResourceAlias() with a valid options model and verify the result
    Response<Void> response = resourceControllerService.deleteResourceAlias(deleteResourceAliasOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteResourceAliasPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("recursive")), Boolean.valueOf(false));
  }

  // Test the deleteResourceAlias operation with and without retries enabled
  @Test
  public void testDeleteResourceAliasWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testDeleteResourceAliasWOptions();

    resourceControllerService.disableRetries();
    testDeleteResourceAliasWOptions();
  }

  // Test the deleteResourceAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteResourceAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.deleteResourceAlias(null).execute();
  }

  // Test the updateResourceAlias operation with a valid options model parameter
  @Test
  public void testUpdateResourceAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"name\": \"name\", \"resource_instance_id\": \"resourceInstanceId\", \"target_crn\": \"targetCrn\", \"account_id\": \"accountId\", \"resource_id\": \"resourceId\", \"resource_group_id\": \"resourceGroupId\", \"crn\": \"crn\", \"region_instance_id\": \"regionInstanceId\", \"region_instance_crn\": \"regionInstanceCrn\", \"state\": \"state\", \"migrated\": true, \"resource_instance_url\": \"resourceInstanceUrl\", \"resource_bindings_url\": \"resourceBindingsUrl\", \"resource_keys_url\": \"resourceKeysUrl\"}";
    String updateResourceAliasPath = "/v2/resource_aliases/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateResourceAliasOptions model
    UpdateResourceAliasOptions updateResourceAliasOptionsModel = new UpdateResourceAliasOptions.Builder()
      .id("testString")
      .name("UpdatedExampleResourceAlias")
      .build();

    // Invoke updateResourceAlias() with a valid options model and verify the result
    Response<ResourceAlias> response = resourceControllerService.updateResourceAlias(updateResourceAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceAlias responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateResourceAliasPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateResourceAlias operation with and without retries enabled
  @Test
  public void testUpdateResourceAliasWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testUpdateResourceAliasWOptions();

    resourceControllerService.disableRetries();
    testUpdateResourceAliasWOptions();
  }

  // Test the updateResourceAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.updateResourceAlias(null).execute();
  }

  // Test the listResourceBindingsForAlias operation with a valid options model parameter
  @Test
  public void testListResourceBindingsForAliasWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"id\": \"id\", \"guid\": \"guid\", \"url\": \"url\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"deleted_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_by\": \"updatedBy\", \"deleted_by\": \"deletedBy\", \"source_crn\": \"sourceCrn\", \"target_crn\": \"targetCrn\", \"crn\": \"crn\", \"region_binding_id\": \"regionBindingId\", \"region_binding_crn\": \"regionBindingCrn\", \"name\": \"name\", \"account_id\": \"accountId\", \"resource_group_id\": \"resourceGroupId\", \"state\": \"state\", \"credentials\": {\"REDACTED\": \"REDACTED\", \"apikey\": \"apikey\", \"iam_apikey_description\": \"iamApikeyDescription\", \"iam_apikey_name\": \"iamApikeyName\", \"iam_role_crn\": \"iamRoleCrn\", \"iam_serviceid_crn\": \"iamServiceidCrn\"}, \"iam_compatible\": false, \"resource_id\": \"resourceId\", \"migrated\": true, \"resource_alias_url\": \"resourceAliasUrl\"}]}";
    String listResourceBindingsForAliasPath = "/v2/resource_aliases/testString/resource_bindings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListResourceBindingsForAliasOptions model
    ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptionsModel = new ListResourceBindingsForAliasOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .start("testString")
      .build();

    // Invoke listResourceBindingsForAlias() with a valid options model and verify the result
    Response<ResourceBindingsList> response = resourceControllerService.listResourceBindingsForAlias(listResourceBindingsForAliasOptionsModel).execute();
    assertNotNull(response);
    ResourceBindingsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listResourceBindingsForAliasPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(query.get("start"), "testString");
  }

  // Test the listResourceBindingsForAlias operation with and without retries enabled
  @Test
  public void testListResourceBindingsForAliasWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListResourceBindingsForAliasWOptions();

    resourceControllerService.disableRetries();
    testListResourceBindingsForAliasWOptions();
  }

  // Test the listResourceBindingsForAlias operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceBindingsForAliasNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.listResourceBindingsForAlias(null).execute();
  }

  // Test the listResourceBindingsForAlias operation using the ResourceBindingsForAliasPager.getNext() method
  @Test
  public void testListResourceBindingsForAliasWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptions = new ListResourceBindingsForAliasOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<ResourceBinding> allResults = new ArrayList<>();
    ResourceBindingsForAliasPager pager = new ResourceBindingsForAliasPager(resourceControllerService, listResourceBindingsForAliasOptions);
    while (pager.hasNext()) {
      List<ResourceBinding> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listResourceBindingsForAlias operation using the ResourceBindingsForAliasPager.getAll() method
  @Test
  public void testListResourceBindingsForAliasWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?start=1\",\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"id\":\"id\",\"guid\":\"guid\",\"url\":\"url\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"deleted_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_by\":\"updatedBy\",\"deleted_by\":\"deletedBy\",\"source_crn\":\"sourceCrn\",\"target_crn\":\"targetCrn\",\"crn\":\"crn\",\"region_binding_id\":\"regionBindingId\",\"region_binding_crn\":\"regionBindingCrn\",\"name\":\"name\",\"account_id\":\"accountId\",\"resource_group_id\":\"resourceGroupId\",\"state\":\"state\",\"credentials\":{\"REDACTED\":\"REDACTED\",\"apikey\":\"apikey\",\"iam_apikey_description\":\"iamApikeyDescription\",\"iam_apikey_name\":\"iamApikeyName\",\"iam_role_crn\":\"iamRoleCrn\",\"iam_serviceid_crn\":\"iamServiceidCrn\"},\"iam_compatible\":false,\"resource_id\":\"resourceId\",\"migrated\":true,\"resource_alias_url\":\"resourceAliasUrl\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptions = new ListResourceBindingsForAliasOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("10"))
      .build();

    ResourceBindingsForAliasPager pager = new ResourceBindingsForAliasPager(resourceControllerService, listResourceBindingsForAliasOptions);
    List<ResourceBinding> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listReclamations operation with a valid options model parameter
  @Test
  public void testListReclamationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"resources\": [{\"id\": \"id\", \"entity_id\": \"entityId\", \"entity_type_id\": \"entityTypeId\", \"entity_crn\": \"entityCrn\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_group_id\": \"resourceGroupId\", \"account_id\": \"accountId\", \"policy_id\": \"policyId\", \"state\": \"state\", \"target_time\": \"targetTime\", \"custom_properties\": {\"anyKey\": \"anyValue\"}, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}]}";
    String listReclamationsPath = "/v1/reclamations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListReclamationsOptions model
    ListReclamationsOptions listReclamationsOptionsModel = new ListReclamationsOptions.Builder()
      .accountId("testString")
      .resourceInstanceId("testString")
      .resourceGroupId("testString")
      .build();

    // Invoke listReclamations() with a valid options model and verify the result
    Response<ReclamationsList> response = resourceControllerService.listReclamations(listReclamationsOptionsModel).execute();
    assertNotNull(response);
    ReclamationsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listReclamationsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("resource_instance_id"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
  }

  // Test the listReclamations operation with and without retries enabled
  @Test
  public void testListReclamationsWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testListReclamationsWOptions();

    resourceControllerService.disableRetries();
    testListReclamationsWOptions();
  }

  // Test the runReclamationAction operation with a valid options model parameter
  @Test
  public void testRunReclamationActionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"entity_id\": \"entityId\", \"entity_type_id\": \"entityTypeId\", \"entity_crn\": \"entityCrn\", \"resource_instance_id\": \"resourceInstanceId\", \"resource_group_id\": \"resourceGroupId\", \"account_id\": \"accountId\", \"policy_id\": \"policyId\", \"state\": \"state\", \"target_time\": \"targetTime\", \"custom_properties\": {\"anyKey\": \"anyValue\"}, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}";
    String runReclamationActionPath = "/v1/reclamations/testString/actions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the RunReclamationActionOptions model
    RunReclamationActionOptions runReclamationActionOptionsModel = new RunReclamationActionOptions.Builder()
      .id("testString")
      .actionName("testString")
      .requestBy("testString")
      .comment("testString")
      .build();

    // Invoke runReclamationAction() with a valid options model and verify the result
    Response<Reclamation> response = resourceControllerService.runReclamationAction(runReclamationActionOptionsModel).execute();
    assertNotNull(response);
    Reclamation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, runReclamationActionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the runReclamationAction operation with and without retries enabled
  @Test
  public void testRunReclamationActionWRetries() throws Throwable {
    resourceControllerService.enableRetries(4, 30);
    testRunReclamationActionWOptions();

    resourceControllerService.disableRetries();
    testRunReclamationActionWOptions();
  }

  // Test the runReclamationAction operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRunReclamationActionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    resourceControllerService.runReclamationAction(null).execute();
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
    resourceControllerService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    resourceControllerService = ResourceController.newInstance(serviceName);
    String url = server.url("/").toString();
    resourceControllerService.setServiceUrl(url);
  }
}