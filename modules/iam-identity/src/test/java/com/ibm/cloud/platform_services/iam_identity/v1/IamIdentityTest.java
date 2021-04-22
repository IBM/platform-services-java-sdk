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
package com.ibm.cloud.platform_services.iam_identity.v1;

import com.ibm.cloud.platform_services.iam_identity.v1.IamIdentity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyInsideCreateServiceIdRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.EnityHistoryRecord;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
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
 * Unit test class for the IamIdentity service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class IamIdentityTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IamIdentity iamIdentityService;

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

    iamIdentityService = IamIdentity.newInstance(serviceName);
    String url = server.url("/").toString();
    iamIdentityService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IamIdentity(serviceName, null);
  }

  @Test
  public void testListApiKeysWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"apikeys\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}]}";
    String listApiKeysPath = "/v1/apikeys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListApiKeysOptions model
    ListApiKeysOptions listApiKeysOptionsModel = new ListApiKeysOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .pagesize(Long.valueOf("26"))
    .pagetoken("testString")
    .scope("entity")
    .type("user")
    .sort("testString")
    .order("asc")
    .includeHistory(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiKeyList> response = iamIdentityService.listApiKeys(listApiKeysOptionsModel).execute();
    assertNotNull(response);
    ApiKeyList responseObj = response.getResult();
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
    assertEquals(query.get("iam_id"), "testString");
    assertEquals(Long.valueOf(query.get("pagesize")), Long.valueOf("26"));
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("scope"), "entity");
    assertEquals(query.get("type"), "user");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listApiKeysPath);
  }

  @Test
  public void testCreateApiKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String createApiKeyPath = "/v1/apikeys";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateApiKeyOptions model
    CreateApiKeyOptions createApiKeyOptionsModel = new CreateApiKeyOptions.Builder()
    .name("testString")
    .iamId("testString")
    .description("testString")
    .accountId("testString")
    .apikey("testString")
    .storeValue(true)
    .entityLock("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiKey> response = iamIdentityService.createApiKey(createApiKeyOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
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
    assertEquals(parsedPath, createApiKeyPath);
  }

  // Test the createApiKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateApiKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.createApiKey(null).execute();
  }

  @Test
  public void testGetApiKeysDetailsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String getApiKeysDetailsPath = "/v1/apikeys/details";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApiKeysDetailsOptions model
    GetApiKeysDetailsOptions getApiKeysDetailsOptionsModel = new GetApiKeysDetailsOptions.Builder()
    .iamApiKey("testString")
    .includeHistory(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiKey> response = iamIdentityService.getApiKeysDetails(getApiKeysDetailsOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getApiKeysDetailsPath);
  }

  @Test
  public void testGetApiKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String getApiKeyPath = "/v1/apikeys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetApiKeyOptions model
    GetApiKeyOptions getApiKeyOptionsModel = new GetApiKeyOptions.Builder()
    .id("testString")
    .includeHistory(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiKey> response = iamIdentityService.getApiKey(getApiKeyOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getApiKeyPath);
  }

  // Test the getApiKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApiKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.getApiKey(null).execute();
  }

  @Test
  public void testUpdateApiKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String updateApiKeyPath = "/v1/apikeys/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateApiKeyOptions model
    UpdateApiKeyOptions updateApiKeyOptionsModel = new UpdateApiKeyOptions.Builder()
    .id("testString")
    .ifMatch("testString")
    .name("testString")
    .description("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApiKey> response = iamIdentityService.updateApiKey(updateApiKeyOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
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
    assertEquals(parsedPath, updateApiKeyPath);
  }

  // Test the updateApiKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateApiKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.updateApiKey(null).execute();
  }

  @Test
  public void testDeleteApiKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteApiKeyPath = "/v1/apikeys/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteApiKeyOptions model
    DeleteApiKeyOptions deleteApiKeyOptionsModel = new DeleteApiKeyOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.deleteApiKey(deleteApiKeyOptionsModel).execute();
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
    assertEquals(parsedPath, deleteApiKeyPath);
  }

  // Test the deleteApiKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteApiKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.deleteApiKey(null).execute();
  }

  @Test
  public void testLockApiKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String lockApiKeyPath = "/v1/apikeys/testString/lock";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the LockApiKeyOptions model
    LockApiKeyOptions lockApiKeyOptionsModel = new LockApiKeyOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.lockApiKey(lockApiKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockApiKeyPath);
  }

  // Test the lockApiKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockApiKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.lockApiKey(null).execute();
  }

  @Test
  public void testUnlockApiKeyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String unlockApiKeyPath = "/v1/apikeys/testString/lock";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UnlockApiKeyOptions model
    UnlockApiKeyOptions unlockApiKeyOptionsModel = new UnlockApiKeyOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.unlockApiKey(unlockApiKeyOptionsModel).execute();
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
    assertEquals(parsedPath, unlockApiKeyPath);
  }

  // Test the unlockApiKey operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockApiKeyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.unlockApiKey(null).execute();
  }

  @Test
  public void testListServiceIdsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"serviceids\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}}]}";
    String listServiceIdsPath = "/v1/serviceids/";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListServiceIdsOptions model
    ListServiceIdsOptions listServiceIdsOptionsModel = new ListServiceIdsOptions.Builder()
    .accountId("testString")
    .name("testString")
    .pagesize(Long.valueOf("26"))
    .pagetoken("testString")
    .sort("testString")
    .order("asc")
    .includeHistory(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ServiceIdList> response = iamIdentityService.listServiceIds(listServiceIdsOptionsModel).execute();
    assertNotNull(response);
    ServiceIdList responseObj = response.getResult();
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
    assertEquals(Long.valueOf(query.get("pagesize")), Long.valueOf("26"));
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listServiceIdsPath);
  }

  @Test
  public void testCreateServiceIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}}";
    String createServiceIdPath = "/v1/serviceids/";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ApiKeyInsideCreateServiceIdRequest model
    ApiKeyInsideCreateServiceIdRequest apiKeyInsideCreateServiceIdRequestModel = new ApiKeyInsideCreateServiceIdRequest.Builder()
    .name("testString")
    .description("testString")
    .apikey("testString")
    .storeValue(true)
    .build();

    // Construct an instance of the CreateServiceIdOptions model
    CreateServiceIdOptions createServiceIdOptionsModel = new CreateServiceIdOptions.Builder()
    .accountId("testString")
    .name("testString")
    .description("testString")
    .uniqueInstanceCrns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .apikey(apiKeyInsideCreateServiceIdRequestModel)
    .entityLock("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ServiceId> response = iamIdentityService.createServiceId(createServiceIdOptionsModel).execute();
    assertNotNull(response);
    ServiceId responseObj = response.getResult();
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
    assertEquals(parsedPath, createServiceIdPath);
  }

  // Test the createServiceId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateServiceIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.createServiceId(null).execute();
  }

  @Test
  public void testGetServiceIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}}";
    String getServiceIdPath = "/v1/serviceids/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetServiceIdOptions model
    GetServiceIdOptions getServiceIdOptionsModel = new GetServiceIdOptions.Builder()
    .id("testString")
    .includeHistory(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ServiceId> response = iamIdentityService.getServiceId(getServiceIdOptionsModel).execute();
    assertNotNull(response);
    ServiceId responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getServiceIdPath);
  }

  // Test the getServiceId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetServiceIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.getServiceId(null).execute();
  }

  @Test
  public void testUpdateServiceIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}}";
    String updateServiceIdPath = "/v1/serviceids/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateServiceIdOptions model
    UpdateServiceIdOptions updateServiceIdOptionsModel = new UpdateServiceIdOptions.Builder()
    .id("testString")
    .ifMatch("testString")
    .name("testString")
    .description("testString")
    .uniqueInstanceCrns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ServiceId> response = iamIdentityService.updateServiceId(updateServiceIdOptionsModel).execute();
    assertNotNull(response);
    ServiceId responseObj = response.getResult();
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
    assertEquals(parsedPath, updateServiceIdPath);
  }

  // Test the updateServiceId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateServiceIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.updateServiceId(null).execute();
  }

  @Test
  public void testDeleteServiceIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteServiceIdPath = "/v1/serviceids/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteServiceIdOptions model
    DeleteServiceIdOptions deleteServiceIdOptionsModel = new DeleteServiceIdOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.deleteServiceId(deleteServiceIdOptionsModel).execute();
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
    assertEquals(parsedPath, deleteServiceIdPath);
  }

  // Test the deleteServiceId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteServiceIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.deleteServiceId(null).execute();
  }

  @Test
  public void testLockServiceIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String lockServiceIdPath = "/v1/serviceids/testString/lock";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the LockServiceIdOptions model
    LockServiceIdOptions lockServiceIdOptionsModel = new LockServiceIdOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.lockServiceId(lockServiceIdOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockServiceIdPath);
  }

  // Test the lockServiceId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockServiceIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.lockServiceId(null).execute();
  }

  @Test
  public void testUnlockServiceIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String unlockServiceIdPath = "/v1/serviceids/testString/lock";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UnlockServiceIdOptions model
    UnlockServiceIdOptions unlockServiceIdOptionsModel = new UnlockServiceIdOptions.Builder()
    .id("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.unlockServiceId(unlockServiceIdOptionsModel).execute();
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
    assertEquals(parsedPath, unlockServiceIdPath);
  }

  // Test the unlockServiceId operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockServiceIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.unlockServiceId(null).execute();
  }

  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"account_id\": \"accountId\", \"restrict_create_service_id\": \"RESTRICTED\", \"restrict_create_platform_apikey\": \"RESTRICTED\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"entity_tag\": \"entityTag\", \"mfa\": \"NONE\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"session_expiration_in_seconds\": \"sessionExpirationInSeconds\", \"session_invalidation_in_seconds\": \"sessionInvalidationInSeconds\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\"}";
    String getAccountSettingsPath = "/v1/accounts/testString/settings/identity";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountSettingsOptions model
    GetAccountSettingsOptions getAccountSettingsOptionsModel = new GetAccountSettingsOptions.Builder()
    .accountId("testString")
    .includeHistory(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSettingsResponse> response = iamIdentityService.getAccountSettings(getAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(true));
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
    iamIdentityService.getAccountSettings(null).execute();
  }

  @Test
  public void testUpdateAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"account_id\": \"accountId\", \"restrict_create_service_id\": \"RESTRICTED\", \"restrict_create_platform_apikey\": \"RESTRICTED\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"entity_tag\": \"entityTag\", \"mfa\": \"NONE\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"session_expiration_in_seconds\": \"sessionExpirationInSeconds\", \"session_invalidation_in_seconds\": \"sessionInvalidationInSeconds\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\"}";
    String updateAccountSettingsPath = "/v1/accounts/testString/settings/identity";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateAccountSettingsOptions model
    UpdateAccountSettingsOptions updateAccountSettingsOptionsModel = new UpdateAccountSettingsOptions.Builder()
    .ifMatch("testString")
    .accountId("testString")
    .restrictCreateServiceId("RESTRICTED")
    .restrictCreatePlatformApikey("RESTRICTED")
    .allowedIpAddresses("testString")
    .mfa("NONE")
    .sessionExpirationInSeconds("testString")
    .sessionInvalidationInSeconds("testString")
    .maxSessionsPerIdentity("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSettingsResponse> response = iamIdentityService.updateAccountSettings(updateAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, updateAccountSettingsPath);
  }

  // Test the updateAccountSettings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.updateAccountSettings(null).execute();
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
    iamIdentityService = null;
  }
}