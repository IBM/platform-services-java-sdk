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
package com.ibm.cloud.platform_services.context_based_restrictions.v1;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.ContextBasedRestrictions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AccountSettings;
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
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
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
 * Unit test class for the ContextBasedRestrictions service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class ContextBasedRestrictionsTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ContextBasedRestrictions contextBasedRestrictionsService;

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

    contextBasedRestrictionsService = ContextBasedRestrictions.newInstance(serviceName);
    String url = server.url("/").toString();
    contextBasedRestrictionsService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new ContextBasedRestrictions(serviceName, null);
  }

  @Test
  public void testCreateZoneWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"description\": \"description\", \"addresses\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"excluded\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createZonePath = "/v1/zones";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddressIPAddress model
    AddressIPAddress addressModel = new AddressIPAddress.Builder()
    .type("ipAddress")
    .value("169.23.56.234")
    .build();

    // Construct an instance of the CreateZoneOptions model
    CreateZoneOptions createZoneOptionsModel = new CreateZoneOptions.Builder()
    .name("an example of zone")
    .accountId("12ab34cd56ef78ab90cd12ef34ab56cd")
    .description("this is an example of zone")
    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
    .excluded(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Zone> response = contextBasedRestrictionsService.createZone(createZoneOptionsModel).execute();
    assertNotNull(response);
    Zone responseObj = response.getResult();
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
    assertEquals(parsedPath, createZonePath);
  }

  @Test
  public void testListZonesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"count\": 5, \"zones\": [{\"id\": \"id\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"addresses_preview\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"address_count\": 12, \"excluded_count\": 13, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listZonesPath = "/v1/zones";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListZonesOptions model
    ListZonesOptions listZonesOptionsModel = new ListZonesOptions.Builder()
    .accountId("testString")
    .transactionId("testString")
    .name("testString")
    .sort("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ZoneList> response = contextBasedRestrictionsService.listZones(listZonesOptionsModel).execute();
    assertNotNull(response);
    ZoneList responseObj = response.getResult();
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
    assertEquals(query.get("sort"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listZonesPath);
  }

  // Test the listZones operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListZonesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.listZones(null).execute();
  }

  @Test
  public void testGetZoneWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"description\": \"description\", \"addresses\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"excluded\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getZonePath = "/v1/zones/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetZoneOptions model
    GetZoneOptions getZoneOptionsModel = new GetZoneOptions.Builder()
    .zoneId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Zone> response = contextBasedRestrictionsService.getZone(getZoneOptionsModel).execute();
    assertNotNull(response);
    Zone responseObj = response.getResult();
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
    assertEquals(parsedPath, getZonePath);
  }

  // Test the getZone operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetZoneNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.getZone(null).execute();
  }

  @Test
  public void testReplaceZoneWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"description\": \"description\", \"addresses\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"excluded\": [{\"type\": \"ipAddress\", \"value\": \"value\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String replaceZonePath = "/v1/zones/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddressIPAddress model
    AddressIPAddress addressModel = new AddressIPAddress.Builder()
    .type("ipAddress")
    .value("169.23.56.234")
    .build();

    // Construct an instance of the ReplaceZoneOptions model
    ReplaceZoneOptions replaceZoneOptionsModel = new ReplaceZoneOptions.Builder()
    .zoneId("testString")
    .ifMatch("testString")
    .name("an example of zone")
    .accountId("12ab34cd56ef78ab90cd12ef34ab56cd")
    .description("this is an example of zone")
    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
    .excluded(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Zone> response = contextBasedRestrictionsService.replaceZone(replaceZoneOptionsModel).execute();
    assertNotNull(response);
    Zone responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceZonePath);
  }

  // Test the replaceZone operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceZoneNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.replaceZone(null).execute();
  }

  @Test
  public void testDeleteZoneWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteZonePath = "/v1/zones/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteZoneOptions model
    DeleteZoneOptions deleteZoneOptionsModel = new DeleteZoneOptions.Builder()
    .zoneId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = contextBasedRestrictionsService.deleteZone(deleteZoneOptionsModel).execute();
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
    assertEquals(parsedPath, deleteZonePath);
  }

  // Test the deleteZone operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteZoneNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.deleteZone(null).execute();
  }

  @Test
  public void testListAvailableServicerefTargetsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"count\": 5, \"targets\": [{\"service_name\": \"serviceName\", \"service_type\": \"serviceType\"}]}";
    String listAvailableServicerefTargetsPath = "/v1/zones/serviceref_targets";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAvailableServicerefTargetsOptions model
    ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptionsModel = new ListAvailableServicerefTargetsOptions.Builder()
    .type("all")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ServiceRefTargetList> response = contextBasedRestrictionsService.listAvailableServicerefTargets(listAvailableServicerefTargetsOptionsModel).execute();
    assertNotNull(response);
    ServiceRefTargetList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("type"), "all");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAvailableServicerefTargetsPath);
  }

  @Test
  public void testCreateRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createRulePath = "/v1/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleContextAttribute model
    RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
    .name("networkZoneId")
    .value("65810ac762004f22ac19f8f8edf70a34")
    .build();

    // Construct an instance of the RuleContext model
    RuleContext ruleContextModel = new RuleContext.Builder()
    .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
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
    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
    .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
    .build();

    // Construct an instance of the CreateRuleOptions model
    CreateRuleOptions createRuleOptionsModel = new CreateRuleOptions.Builder()
    .description("this is an example of rule")
    .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = contextBasedRestrictionsService.createRule(createRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
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
    assertEquals(parsedPath, createRulePath);
  }

  @Test
  public void testListRulesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"count\": 5, \"rules\": [{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listRulesPath = "/v1/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListRulesOptions model
    ListRulesOptions listRulesOptionsModel = new ListRulesOptions.Builder()
    .accountId("testString")
    .transactionId("testString")
    .region("testString")
    .resource("testString")
    .resourceType("testString")
    .serviceInstance("testString")
    .serviceName("testString")
    .serviceType("testString")
    .zoneId("testString")
    .sort("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RuleList> response = contextBasedRestrictionsService.listRules(listRulesOptionsModel).execute();
    assertNotNull(response);
    RuleList responseObj = response.getResult();
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
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("resource"), "testString");
    assertEquals(query.get("resource_type"), "testString");
    assertEquals(query.get("service_instance"), "testString");
    assertEquals(query.get("service_name"), "testString");
    assertEquals(query.get("service_type"), "testString");
    assertEquals(query.get("zone_id"), "testString");
    assertEquals(query.get("sort"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listRulesPath);
  }

  // Test the listRules operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRulesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.listRules(null).execute();
  }

  @Test
  public void testGetRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getRulePath = "/v1/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetRuleOptions model
    GetRuleOptions getRuleOptionsModel = new GetRuleOptions.Builder()
    .ruleId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = contextBasedRestrictionsService.getRule(getRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
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
    assertEquals(parsedPath, getRulePath);
  }

  // Test the getRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.getRule(null).execute();
  }

  @Test
  public void testReplaceRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"description\": \"description\", \"contexts\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String replaceRulePath = "/v1/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleContextAttribute model
    RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
    .name("networkZoneId")
    .value("76921bd873115033bd2a0909fe081b45")
    .build();

    // Construct an instance of the RuleContext model
    RuleContext ruleContextModel = new RuleContext.Builder()
    .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
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
    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
    .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
    .build();

    // Construct an instance of the ReplaceRuleOptions model
    ReplaceRuleOptions replaceRuleOptionsModel = new ReplaceRuleOptions.Builder()
    .ruleId("testString")
    .ifMatch("testString")
    .description("this is an example of rule")
    .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = contextBasedRestrictionsService.replaceRule(replaceRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceRulePath);
  }

  // Test the replaceRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.replaceRule(null).execute();
  }

  @Test
  public void testDeleteRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteRulePath = "/v1/rules/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteRuleOptions model
    DeleteRuleOptions deleteRuleOptionsModel = new DeleteRuleOptions.Builder()
    .ruleId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = contextBasedRestrictionsService.deleteRule(deleteRuleOptionsModel).execute();
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
    assertEquals(parsedPath, deleteRulePath);
  }

  // Test the deleteRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    contextBasedRestrictionsService.deleteRule(null).execute();
  }

  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"crn\": \"crn\", \"rule_count_limit\": 14, \"zone_count_limit\": 14, \"current_rule_count\": 16, \"current_zone_count\": 16, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getAccountSettingsPath = "/v1/account_settings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountSettingsOptions model
    GetAccountSettingsOptions getAccountSettingsOptionsModel = new GetAccountSettingsOptions.Builder()
    .accountId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSettings> response = contextBasedRestrictionsService.getAccountSettings(getAccountSettingsOptionsModel).execute();
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
    contextBasedRestrictionsService.getAccountSettings(null).execute();
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
    contextBasedRestrictionsService = null;
  }
}