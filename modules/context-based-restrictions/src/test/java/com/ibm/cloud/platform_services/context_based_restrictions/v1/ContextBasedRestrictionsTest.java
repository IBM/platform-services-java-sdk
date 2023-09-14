/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.context_based_restrictions.v1;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.ContextBasedRestrictions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.APIType;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Action;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Address;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddressRange;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressServiceRef;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressSubnet;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressVPC;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServiceOperationsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.NewRuleOperations;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.NewRuleOperationsApiTypesItem;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OperationsList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Rule;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetLocationsItem;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefValue;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Zone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneSummary;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
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
 * Unit test class for the ContextBasedRestrictions service.
 */
public class ContextBasedRestrictionsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ContextBasedRestrictions contextBasedRestrictionsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new ContextBasedRestrictions(serviceName, null);
  }

  // Test the createZone operation with a valid options model parameter
  @Test
  public void testCreateZoneWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"address_count\": 12, \"excluded_count\": 13, \"name\": \"name\", \"account_id\": \"accountId\", \"description\": \"description\", \"addresses\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"excluded\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createZonePath = "/v1/zones";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the AddressIPAddress model
    AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("169.23.56.234, 3ffe:1900:fe21:4545::")
      .build();

    // Construct an instance of the CreateZoneOptions model
    CreateZoneOptions createZoneOptionsModel = new CreateZoneOptions.Builder()
      .name("an example of zone")
      .accountId("12ab34cd56ef78ab90cd12ef34ab56cd")
      .description("this is an example of zone")
      .addresses(java.util.Arrays.asList(addressModel))
      .excluded(java.util.Arrays.asList(addressModel))
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke createZone() with a valid options model and verify the result
    Response<Zone> response = contextBasedRestrictionsService.createZone(createZoneOptionsModel).execute();
    assertNotNull(response);
    Zone responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createZonePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createZone operation with and without retries enabled
  @Test
  public void testCreateZoneWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testCreateZoneWOptions();

    contextBasedRestrictionsService.disableRetries();
    testCreateZoneWOptions();
  }

  // Test the listZones operation with a valid options model parameter
  @Test
  public void testListZonesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"count\": 5, \"zones\": [{\"id\": \"id\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"addresses_preview\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"address_count\": 12, \"excluded_count\": 13, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listZonesPath = "/v1/zones";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListZonesOptions model
    ListZonesOptions listZonesOptionsModel = new ListZonesOptions.Builder()
      .accountId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .name("testString")
      .sort("testString")
      .build();

    // Invoke listZones() with a valid options model and verify the result
    Response<ZoneList> response = contextBasedRestrictionsService.listZones(listZonesOptionsModel).execute();
    assertNotNull(response);
    ZoneList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listZonesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("sort"), "testString");
  }

  // Test the listZones operation with and without retries enabled
  @Test
  public void testListZonesWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testListZonesWOptions();

    contextBasedRestrictionsService.disableRetries();
    testListZonesWOptions();
  }

  // Test the listZones operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListZonesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.listZones(null).execute();
  }

  // Test the getZone operation with a valid options model parameter
  @Test
  public void testGetZoneWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"address_count\": 12, \"excluded_count\": 13, \"name\": \"name\", \"account_id\": \"accountId\", \"description\": \"description\", \"addresses\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"excluded\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getZonePath = "/v1/zones/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetZoneOptions model
    GetZoneOptions getZoneOptionsModel = new GetZoneOptions.Builder()
      .zoneId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke getZone() with a valid options model and verify the result
    Response<Zone> response = contextBasedRestrictionsService.getZone(getZoneOptionsModel).execute();
    assertNotNull(response);
    Zone responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getZonePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getZone operation with and without retries enabled
  @Test
  public void testGetZoneWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testGetZoneWOptions();

    contextBasedRestrictionsService.disableRetries();
    testGetZoneWOptions();
  }

  // Test the getZone operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetZoneNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.getZone(null).execute();
  }

  // Test the replaceZone operation with a valid options model parameter
  @Test
  public void testReplaceZoneWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"address_count\": 12, \"excluded_count\": 13, \"name\": \"name\", \"account_id\": \"accountId\", \"description\": \"description\", \"addresses\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"excluded\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String replaceZonePath = "/v1/zones/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AddressIPAddress model
    AddressIPAddress addressModel = new AddressIPAddress.Builder()
      .type("ipAddress")
      .value("169.23.56.234, 3ffe:1900:fe21:4545::")
      .build();

    // Construct an instance of the ReplaceZoneOptions model
    ReplaceZoneOptions replaceZoneOptionsModel = new ReplaceZoneOptions.Builder()
      .zoneId("testString")
      .ifMatch("testString")
      .name("an example of zone")
      .accountId("12ab34cd56ef78ab90cd12ef34ab56cd")
      .description("this is an example of zone")
      .addresses(java.util.Arrays.asList(addressModel))
      .excluded(java.util.Arrays.asList(addressModel))
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke replaceZone() with a valid options model and verify the result
    Response<Zone> response = contextBasedRestrictionsService.replaceZone(replaceZoneOptionsModel).execute();
    assertNotNull(response);
    Zone responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceZonePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceZone operation with and without retries enabled
  @Test
  public void testReplaceZoneWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testReplaceZoneWOptions();

    contextBasedRestrictionsService.disableRetries();
    testReplaceZoneWOptions();
  }

  // Test the replaceZone operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceZoneNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.replaceZone(null).execute();
  }

  // Test the deleteZone operation with a valid options model parameter
  @Test
  public void testDeleteZoneWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteZonePath = "/v1/zones/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteZoneOptions model
    DeleteZoneOptions deleteZoneOptionsModel = new DeleteZoneOptions.Builder()
      .zoneId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteZone() with a valid options model and verify the result
    Response<Void> response = contextBasedRestrictionsService.deleteZone(deleteZoneOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteZonePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteZone operation with and without retries enabled
  @Test
  public void testDeleteZoneWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testDeleteZoneWOptions();

    contextBasedRestrictionsService.disableRetries();
    testDeleteZoneWOptions();
  }

  // Test the deleteZone operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteZoneNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.deleteZone(null).execute();
  }

  // Test the listAvailableServicerefTargets operation with a valid options model parameter
  @Test
  public void testListAvailableServicerefTargetsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"count\": 5, \"targets\": [{\"service_name\": \"serviceName\", \"service_type\": \"serviceType\", \"locations\": [{\"name\": \"name\"}]}]}";
    String listAvailableServicerefTargetsPath = "/v1/zones/serviceref_targets";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAvailableServicerefTargetsOptions model
    ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptionsModel = new ListAvailableServicerefTargetsOptions.Builder()
      .xCorrelationId("testString")
      .transactionId("testString")
      .type("all")
      .build();

    // Invoke listAvailableServicerefTargets() with a valid options model and verify the result
    Response<ServiceRefTargetList> response = contextBasedRestrictionsService.listAvailableServicerefTargets(listAvailableServicerefTargetsOptionsModel).execute();
    assertNotNull(response);
    ServiceRefTargetList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAvailableServicerefTargetsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("type"), "all");
  }

  // Test the listAvailableServicerefTargets operation with and without retries enabled
  @Test
  public void testListAvailableServicerefTargetsWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testListAvailableServicerefTargetsWOptions();

    contextBasedRestrictionsService.disableRetries();
    testListAvailableServicerefTargetsWOptions();
  }

  // Test the createRule operation with a valid options model parameter
  @Test
  public void testCreateRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"operations\": {\"api_types\": [{\"api_type_id\": \"apiTypeId\"}]}, \"enforcement_mode\": \"enabled\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createRulePath = "/v1/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the RuleContextAttribute model
    RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
      .name("networkZoneId")
      .value("65810ac762004f22ac19f8f8edf70a34")
      .build();

    // Construct an instance of the RuleContext model
    RuleContext ruleContextModel = new RuleContext.Builder()
      .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
      .build();

    // Construct an instance of the ResourceAttribute model
    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("accountId")
      .value("12ab34cd56ef78ab90cd12ef34ab56cd")
      .operator("testString")
      .build();

    // Construct an instance of the ResourceTagAttribute model
    ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
      .attributes(java.util.Arrays.asList(resourceAttributeModel))
      .tags(java.util.Arrays.asList(resourceTagAttributeModel))
      .build();

    // Construct an instance of the NewRuleOperationsApiTypesItem model
    NewRuleOperationsApiTypesItem newRuleOperationsApiTypesItemModel = new NewRuleOperationsApiTypesItem.Builder()
      .apiTypeId("testString")
      .build();

    // Construct an instance of the NewRuleOperations model
    NewRuleOperations newRuleOperationsModel = new NewRuleOperations.Builder()
      .apiTypes(java.util.Arrays.asList(newRuleOperationsApiTypesItemModel))
      .build();

    // Construct an instance of the CreateRuleOptions model
    CreateRuleOptions createRuleOptionsModel = new CreateRuleOptions.Builder()
      .description("this is an example of rule")
      .contexts(java.util.Arrays.asList(ruleContextModel))
      .resources(java.util.Arrays.asList(resourceModel))
      .operations(newRuleOperationsModel)
      .enforcementMode("enabled")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke createRule() with a valid options model and verify the result
    Response<Rule> response = contextBasedRestrictionsService.createRule(createRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createRule operation with and without retries enabled
  @Test
  public void testCreateRuleWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testCreateRuleWOptions();

    contextBasedRestrictionsService.disableRetries();
    testCreateRuleWOptions();
  }

  // Test the listRules operation with a valid options model parameter
  @Test
  public void testListRulesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"count\": 5, \"rules\": [{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"operations\": {\"api_types\": [{\"api_type_id\": \"apiTypeId\"}]}, \"enforcement_mode\": \"enabled\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listRulesPath = "/v1/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListRulesOptions model
    ListRulesOptions listRulesOptionsModel = new ListRulesOptions.Builder()
      .accountId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .region("testString")
      .resource("testString")
      .resourceType("testString")
      .serviceInstance("testString")
      .serviceName("testString")
      .serviceType("testString")
      .serviceGroupId("testString")
      .zoneId("testString")
      .sort("testString")
      .enforcementMode("enabled")
      .build();

    // Invoke listRules() with a valid options model and verify the result
    Response<RuleList> response = contextBasedRestrictionsService.listRules(listRulesOptionsModel).execute();
    assertNotNull(response);
    RuleList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listRulesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("resource"), "testString");
    assertEquals(query.get("resource_type"), "testString");
    assertEquals(query.get("service_instance"), "testString");
    assertEquals(query.get("service_name"), "testString");
    assertEquals(query.get("service_type"), "testString");
    assertEquals(query.get("service_group_id"), "testString");
    assertEquals(query.get("zone_id"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("enforcement_mode"), "enabled");
  }

  // Test the listRules operation with and without retries enabled
  @Test
  public void testListRulesWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testListRulesWOptions();

    contextBasedRestrictionsService.disableRetries();
    testListRulesWOptions();
  }

  // Test the listRules operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRulesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.listRules(null).execute();
  }

  // Test the getRule operation with a valid options model parameter
  @Test
  public void testGetRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"operations\": {\"api_types\": [{\"api_type_id\": \"apiTypeId\"}]}, \"enforcement_mode\": \"enabled\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getRulePath = "/v1/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetRuleOptions model
    GetRuleOptions getRuleOptionsModel = new GetRuleOptions.Builder()
      .ruleId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke getRule() with a valid options model and verify the result
    Response<Rule> response = contextBasedRestrictionsService.getRule(getRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getRule operation with and without retries enabled
  @Test
  public void testGetRuleWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testGetRuleWOptions();

    contextBasedRestrictionsService.disableRetries();
    testGetRuleWOptions();
  }

  // Test the getRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.getRule(null).execute();
  }

  // Test the replaceRule operation with a valid options model parameter
  @Test
  public void testReplaceRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"operations\": {\"api_types\": [{\"api_type_id\": \"apiTypeId\"}]}, \"enforcement_mode\": \"enabled\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String replaceRulePath = "/v1/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the RuleContextAttribute model
    RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
      .name("networkZoneId")
      .value("76921bd873115033bd2a0909fe081b45")
      .build();

    // Construct an instance of the RuleContext model
    RuleContext ruleContextModel = new RuleContext.Builder()
      .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
      .build();

    // Construct an instance of the ResourceAttribute model
    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("accountId")
      .value("12ab34cd56ef78ab90cd12ef34ab56cd")
      .operator("testString")
      .build();

    // Construct an instance of the ResourceTagAttribute model
    ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
      .attributes(java.util.Arrays.asList(resourceAttributeModel))
      .tags(java.util.Arrays.asList(resourceTagAttributeModel))
      .build();

    // Construct an instance of the NewRuleOperationsApiTypesItem model
    NewRuleOperationsApiTypesItem newRuleOperationsApiTypesItemModel = new NewRuleOperationsApiTypesItem.Builder()
      .apiTypeId("testString")
      .build();

    // Construct an instance of the NewRuleOperations model
    NewRuleOperations newRuleOperationsModel = new NewRuleOperations.Builder()
      .apiTypes(java.util.Arrays.asList(newRuleOperationsApiTypesItemModel))
      .build();

    // Construct an instance of the ReplaceRuleOptions model
    ReplaceRuleOptions replaceRuleOptionsModel = new ReplaceRuleOptions.Builder()
      .ruleId("testString")
      .ifMatch("testString")
      .description("this is an example of rule")
      .contexts(java.util.Arrays.asList(ruleContextModel))
      .resources(java.util.Arrays.asList(resourceModel))
      .operations(newRuleOperationsModel)
      .enforcementMode("disabled")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke replaceRule() with a valid options model and verify the result
    Response<Rule> response = contextBasedRestrictionsService.replaceRule(replaceRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceRulePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceRule operation with and without retries enabled
  @Test
  public void testReplaceRuleWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testReplaceRuleWOptions();

    contextBasedRestrictionsService.disableRetries();
    testReplaceRuleWOptions();
  }

  // Test the replaceRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.replaceRule(null).execute();
  }

  // Test the deleteRule operation with a valid options model parameter
  @Test
  public void testDeleteRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteRulePath = "/v1/rules/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteRuleOptions model
    DeleteRuleOptions deleteRuleOptionsModel = new DeleteRuleOptions.Builder()
      .ruleId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteRule() with a valid options model and verify the result
    Response<Void> response = contextBasedRestrictionsService.deleteRule(deleteRuleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteRule operation with and without retries enabled
  @Test
  public void testDeleteRuleWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testDeleteRuleWOptions();

    contextBasedRestrictionsService.disableRetries();
    testDeleteRuleWOptions();
  }

  // Test the deleteRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.deleteRule(null).execute();
  }

  // Test the getAccountSettings operation with a valid options model parameter
  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"rule_count_limit\": 14, \"zone_count_limit\": 14, \"current_rule_count\": 16, \"current_zone_count\": 16, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getAccountSettingsPath = "/v1/account_settings/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountSettingsOptions model
    GetAccountSettingsOptions getAccountSettingsOptionsModel = new GetAccountSettingsOptions.Builder()
      .accountId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .build();

    // Invoke getAccountSettings() with a valid options model and verify the result
    Response<AccountSettings> response = contextBasedRestrictionsService.getAccountSettings(getAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountSettingsPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAccountSettings operation with and without retries enabled
  @Test
  public void testGetAccountSettingsWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testGetAccountSettingsWOptions();

    contextBasedRestrictionsService.disableRetries();
    testGetAccountSettingsWOptions();
  }

  // Test the getAccountSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    contextBasedRestrictionsService.getAccountSettings(null).execute();
  }

  // Test the listAvailableServiceOperations operation with a valid options model parameter
  @Test
  public void testListAvailableServiceOperationsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"api_types\": [{\"api_type_id\": \"apiTypeId\", \"display_name\": \"displayName\", \"description\": \"description\", \"type\": \"type\", \"actions\": [{\"action_id\": \"actionId\", \"description\": \"description\"}]}]}";
    String listAvailableServiceOperationsPath = "/v1/operations";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAvailableServiceOperationsOptions model
    ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptionsModel = new ListAvailableServiceOperationsOptions.Builder()
      .xCorrelationId("testString")
      .transactionId("testString")
      .serviceName("testString")
      .serviceGroupId("testString")
      .resourceType("testString")
      .build();

    // Invoke listAvailableServiceOperations() with a valid options model and verify the result
    Response<OperationsList> response = contextBasedRestrictionsService.listAvailableServiceOperations(listAvailableServiceOperationsOptionsModel).execute();
    assertNotNull(response);
    OperationsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAvailableServiceOperationsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("service_name"), "testString");
    assertEquals(query.get("service_group_id"), "testString");
    assertEquals(query.get("resource_type"), "testString");
  }

  // Test the listAvailableServiceOperations operation with and without retries enabled
  @Test
  public void testListAvailableServiceOperationsWRetries() throws Throwable {
    contextBasedRestrictionsService.enableRetries(4, 30);
    testListAvailableServiceOperationsWOptions();

    contextBasedRestrictionsService.disableRetries();
    testListAvailableServiceOperationsWOptions();
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
    contextBasedRestrictionsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    contextBasedRestrictionsService = ContextBasedRestrictions.newInstance(serviceName);
    String url = server.url("/").toString();
    contextBasedRestrictionsService.setServiceUrl(url);
  }
}