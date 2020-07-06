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
package com.ibm.cloud.platform_services.open_service_broker.v1;

import com.ibm.cloud.platform_services.open_service_broker.v1.OpenServiceBroker;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.BindResource;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Context;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.GetLastOperationOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.GetServiceInstanceStateOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ListCatalogOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Plans;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceStateOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp1874644Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp1874650Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079872Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079874Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079876Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079894Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2448145Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Services;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.UpdateServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.VolumeMount;
import com.ibm.cloud.platform_services.open_service_broker.v1.utils.TestUtilities;
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
 * Unit test class for the OpenServiceBroker service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class OpenServiceBrokerTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected OpenServiceBroker testService;

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

    testService = OpenServiceBroker.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new OpenServiceBroker(serviceName, null);
  }

  @Test
  public void testGetServiceInstanceStateWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"active\": true, \"enabled\": false, \"last_active\": 10}";
    String getServiceInstanceStatePath = "/bluemix_v1/service_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetServiceInstanceStateOptions model
    GetServiceInstanceStateOptions getServiceInstanceStateOptionsModel = new GetServiceInstanceStateOptions.Builder()
    .instanceId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp1874644Root> response = testService.getServiceInstanceState(getServiceInstanceStateOptionsModel).execute();
    assertNotNull(response);
    Resp1874644Root responseObj = response.getResult();
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
    assertEquals(parsedPath, getServiceInstanceStatePath);
  }

  // Test the getServiceInstanceState operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetServiceInstanceStateNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getServiceInstanceState(null).execute();
  }

  @Test
  public void testReplaceServiceInstanceStateWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"active\": true, \"enabled\": false, \"last_active\": 10}";
    String replaceServiceInstanceStatePath = "/bluemix_v1/service_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ReplaceServiceInstanceStateOptions model
    ReplaceServiceInstanceStateOptions replaceServiceInstanceStateOptionsModel = new ReplaceServiceInstanceStateOptions.Builder()
    .instanceId("testString")
    .enabled(false)
    .initiatorId("null")
    .reasonCode("null")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp2448145Root> response = testService.replaceServiceInstanceState(replaceServiceInstanceStateOptionsModel).execute();
    assertNotNull(response);
    Resp2448145Root responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceServiceInstanceStatePath);
  }

  // Test the replaceServiceInstanceState operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceServiceInstanceStateNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceServiceInstanceState(null).execute();
  }

  @Test
  public void testReplaceServiceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"dashboard_url\": \"dashboardUrl\", \"operation\": \"operation\"}";
    String replaceServiceInstancePath = "/v2/service_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Context model
    Context contextModel = new Context.Builder()
    .accountId("null")
    .crn("null")
    .platform("null")
    .build();

    // Construct an instance of the ReplaceServiceInstanceOptions model
    ReplaceServiceInstanceOptions replaceServiceInstanceOptionsModel = new ReplaceServiceInstanceOptions.Builder()
    .instanceId("testString")
    .context(contextModel)
    .organizationGuid("null")
    .parameters(new java.util.HashMap<String,String>(){{put("foo", "null"); }})
    .planId("null")
    .serviceId("null")
    .spaceGuid("null")
    .acceptsIncomplete(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp2079872Root> response = testService.replaceServiceInstance(replaceServiceInstanceOptionsModel).execute();
    assertNotNull(response);
    Resp2079872Root responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("accepts_incomplete")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceServiceInstancePath);
  }

  // Test the replaceServiceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceServiceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceServiceInstance(null).execute();
  }

  @Test
  public void testUpdateServiceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"operation\": \"operation\"}";
    String updateServiceInstancePath = "/v2/service_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Context model
    Context contextModel = new Context.Builder()
    .accountId("null")
    .crn("null")
    .platform("null")
    .build();

    // Construct an instance of the UpdateServiceInstanceOptions model
    UpdateServiceInstanceOptions updateServiceInstanceOptionsModel = new UpdateServiceInstanceOptions.Builder()
    .instanceId("testString")
    .context(contextModel)
    .parameters(new java.util.HashMap<String,String>(){{put("foo", "null"); }})
    .planId("null")
    .previousValues(new java.util.HashMap<String,String>(){{put("foo", "null"); }})
    .serviceId("null")
    .acceptsIncomplete(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp2079874Root> response = testService.updateServiceInstance(updateServiceInstanceOptionsModel).execute();
    assertNotNull(response);
    Resp2079874Root responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("accepts_incomplete")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateServiceInstancePath);
  }

  // Test the updateServiceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateServiceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateServiceInstance(null).execute();
  }

  @Test
  public void testDeleteServiceInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"operation\": \"operation\"}";
    String deleteServiceInstancePath = "/v2/service_instances/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteServiceInstanceOptions model
    DeleteServiceInstanceOptions deleteServiceInstanceOptionsModel = new DeleteServiceInstanceOptions.Builder()
    .serviceId("testString")
    .planId("testString")
    .instanceId("testString")
    .acceptsIncomplete(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp2079874Root> response = testService.deleteServiceInstance(deleteServiceInstanceOptionsModel).execute();
    assertNotNull(response);
    Resp2079874Root responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("service_id"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(Boolean.valueOf(query.get("accepts_incomplete")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteServiceInstancePath);
  }

  // Test the deleteServiceInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteServiceInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteServiceInstance(null).execute();
  }

  @Test
  public void testListCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"services\": [{\"bindable\": true, \"description\": \"description\", \"id\": \"id\", \"name\": \"name\", \"plan_updateable\": true, \"plans\": [{\"description\": \"description\", \"free\": true, \"id\": \"id\", \"name\": \"name\"}]}]}";
    String listCatalogPath = "/v2/catalog";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCatalogOptions model
    ListCatalogOptions listCatalogOptionsModel = new ListCatalogOptions();

    // Invoke operation with valid options model (positive test)
    Response<Resp1874650Root> response = testService.listCatalog(listCatalogOptionsModel).execute();
    assertNotNull(response);
    Resp1874650Root responseObj = response.getResult();
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
    assertEquals(parsedPath, listCatalogPath);
  }

  @Test
  public void testGetLastOperationWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"description\": \"description\", \"state\": \"state\"}";
    String getLastOperationPath = "/v2/service_instances/testString/last_operation";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLastOperationOptions model
    GetLastOperationOptions getLastOperationOptionsModel = new GetLastOperationOptions.Builder()
    .instanceId("testString")
    .operation("testString")
    .planId("testString")
    .serviceId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp2079894Root> response = testService.getLastOperation(getLastOperationOptionsModel).execute();
    assertNotNull(response);
    Resp2079894Root responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("operation"), "testString");
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("service_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLastOperationPath);
  }

  // Test the getLastOperation operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLastOperationNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getLastOperation(null).execute();
  }

  @Test
  public void testReplaceServiceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"credentials\": {\"mapKey\": \"anyValue\"}, \"syslog_drain_url\": \"syslogDrainUrl\", \"route_service_url\": \"routeServiceUrl\", \"volume_mounts\": [{\"driver\": \"driver\", \"container_dir\": \"containerDir\", \"mode\": \"mode\", \"device_type\": \"deviceType\", \"device\": \"device\"}]}";
    String replaceServiceBindingPath = "/v2/service_instances/testString/service_bindings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the BindResource model
    BindResource bindResourceModel = new BindResource.Builder()
    .accountId("null")
    .serviceidCrn("null")
    .targetCrn("null")
    .appGuid("null")
    .route("null")
    .build();

    // Construct an instance of the ReplaceServiceBindingOptions model
    ReplaceServiceBindingOptions replaceServiceBindingOptionsModel = new ReplaceServiceBindingOptions.Builder()
    .bindingId("testString")
    .instanceId("testString")
    .bindResource(bindResourceModel)
    .parameters(new java.util.HashMap<String,String>(){{put("foo", "null"); }})
    .planId("null")
    .serviceId("null")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Resp2079876Root> response = testService.replaceServiceBinding(replaceServiceBindingOptionsModel).execute();
    assertNotNull(response);
    Resp2079876Root responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceServiceBindingPath);
  }

  // Test the replaceServiceBinding operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceServiceBindingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceServiceBinding(null).execute();
  }

  @Test
  public void testDeleteServiceBindingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteServiceBindingPath = "/v2/service_instances/testString/service_bindings/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteServiceBindingOptions model
    DeleteServiceBindingOptions deleteServiceBindingOptionsModel = new DeleteServiceBindingOptions.Builder()
    .bindingId("testString")
    .instanceId("testString")
    .planId("testString")
    .serviceId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteServiceBinding(deleteServiceBindingOptionsModel).execute();
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
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("plan_id"), "testString");
    assertEquals(query.get("service_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteServiceBindingPath);
  }

  // Test the deleteServiceBinding operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteServiceBindingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteServiceBinding(null).execute();
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