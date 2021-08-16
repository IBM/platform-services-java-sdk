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
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileLinkRequestLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.EnityHistoryRecord;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListClaimRulesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfilesList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileOptions;
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
  public void testCreateProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String createProfilePath = "/v1/profiles";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateProfileOptions model
    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
    .name("testString")
    .accountId("testString")
    .description("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TrustedProfile> response = iamIdentityService.createProfile(createProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfile responseObj = response.getResult();
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
    assertEquals(parsedPath, createProfilePath);
  }

  // Test the createProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.createProfile(null).execute();
  }

  @Test
  public void testListProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"profiles\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}]}";
    String listProfilePath = "/v1/profiles";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListProfileOptions model
    ListProfileOptions listProfileOptionsModel = new ListProfileOptions.Builder()
    .accountId("testString")
    .name("testString")
    .pagesize(Long.valueOf("26"))
    .sort("testString")
    .order("asc")
    .includeHistory(false)
    .pagetoken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TrustedProfilesList> response = iamIdentityService.listProfile(listProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfilesList responseObj = response.getResult();
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
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
    assertEquals(query.get("pagetoken"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfilePath);
  }

  // Test the listProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.listProfile(null).execute();
  }

  @Test
  public void testGetProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String getProfilePath = "/v1/profiles/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetProfileOptions model
    GetProfileOptions getProfileOptionsModel = new GetProfileOptions.Builder()
    .profileId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TrustedProfile> response = iamIdentityService.getProfile(getProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfile responseObj = response.getResult();
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
    assertEquals(parsedPath, getProfilePath);
  }

  // Test the getProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.getProfile(null).execute();
  }

  @Test
  public void testUpdateProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}]}";
    String updateProfilePath = "/v1/profiles/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateProfileOptions model
    UpdateProfileOptions updateProfileOptionsModel = new UpdateProfileOptions.Builder()
    .profileId("testString")
    .ifMatch("testString")
    .name("testString")
    .description("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<TrustedProfile> response = iamIdentityService.updateProfile(updateProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfile responseObj = response.getResult();
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
    assertEquals(parsedPath, updateProfilePath);
  }

  // Test the updateProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.updateProfile(null).execute();
  }

  @Test
  public void testDeleteProfileWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteProfilePath = "/v1/profiles/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteProfileOptions model
    DeleteProfileOptions deleteProfileOptionsModel = new DeleteProfileOptions.Builder()
    .profileId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.deleteProfile(deleteProfileOptionsModel).execute();
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
    assertEquals(parsedPath, deleteProfilePath);
  }

  // Test the deleteProfile operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.deleteProfile(null).execute();
  }

  @Test
  public void testCreateClaimRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}";
    String createClaimRulePath = "/v1/profiles/testString/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ProfileClaimRuleConditions model
    ProfileClaimRuleConditions profileClaimRuleConditionsModel = new ProfileClaimRuleConditions.Builder()
    .claim("testString")
    .operator("testString")
    .value("testString")
    .build();

    // Construct an instance of the ResponseContext model
    ResponseContext responseContextModel = new ResponseContext.Builder()
    .transactionId("testString")
    .operation("testString")
    .userAgent("testString")
    .url("testString")
    .instanceId("testString")
    .threadId("testString")
    .host("testString")
    .startTime("testString")
    .endTime("testString")
    .elapsedTime("testString")
    .clusterName("testString")
    .build();

    // Construct an instance of the CreateClaimRuleOptions model
    CreateClaimRuleOptions createClaimRuleOptionsModel = new CreateClaimRuleOptions.Builder()
    .profileId("testString")
    .type("testString")
    .conditions(new java.util.ArrayList<ProfileClaimRuleConditions>(java.util.Arrays.asList(profileClaimRuleConditionsModel)))
    .context(responseContextModel)
    .name("testString")
    .realmName("testString")
    .crType("testString")
    .expiration(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileClaimRule> response = iamIdentityService.createClaimRule(createClaimRuleOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRule responseObj = response.getResult();
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
    assertEquals(parsedPath, createClaimRulePath);
  }

  // Test the createClaimRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClaimRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.createClaimRule(null).execute();
  }

  @Test
  public void testListClaimRulesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"rules\": [{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}]}";
    String listClaimRulesPath = "/v1/profiles/testString/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListClaimRulesOptions model
    ListClaimRulesOptions listClaimRulesOptionsModel = new ListClaimRulesOptions.Builder()
    .profileId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileClaimRuleList> response = iamIdentityService.listClaimRules(listClaimRulesOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRuleList responseObj = response.getResult();
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
    assertEquals(parsedPath, listClaimRulesPath);
  }

  // Test the listClaimRules operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListClaimRulesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.listClaimRules(null).execute();
  }

  @Test
  public void testGetClaimRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}";
    String getClaimRulePath = "/v1/profiles/testString/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetClaimRuleOptions model
    GetClaimRuleOptions getClaimRuleOptionsModel = new GetClaimRuleOptions.Builder()
    .profileId("testString")
    .ruleId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileClaimRule> response = iamIdentityService.getClaimRule(getClaimRuleOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRule responseObj = response.getResult();
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
    assertEquals(parsedPath, getClaimRulePath);
  }

  // Test the getClaimRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClaimRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.getClaimRule(null).execute();
  }

  @Test
  public void testUpdateClaimRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}";
    String updateClaimRulePath = "/v1/profiles/testString/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ProfileClaimRuleConditions model
    ProfileClaimRuleConditions profileClaimRuleConditionsModel = new ProfileClaimRuleConditions.Builder()
    .claim("testString")
    .operator("testString")
    .value("testString")
    .build();

    // Construct an instance of the ResponseContext model
    ResponseContext responseContextModel = new ResponseContext.Builder()
    .transactionId("testString")
    .operation("testString")
    .userAgent("testString")
    .url("testString")
    .instanceId("testString")
    .threadId("testString")
    .host("testString")
    .startTime("testString")
    .endTime("testString")
    .elapsedTime("testString")
    .clusterName("testString")
    .build();

    // Construct an instance of the UpdateClaimRuleOptions model
    UpdateClaimRuleOptions updateClaimRuleOptionsModel = new UpdateClaimRuleOptions.Builder()
    .profileId("testString")
    .ruleId("testString")
    .ifMatch("testString")
    .type("testString")
    .conditions(new java.util.ArrayList<ProfileClaimRuleConditions>(java.util.Arrays.asList(profileClaimRuleConditionsModel)))
    .context(responseContextModel)
    .name("testString")
    .realmName("testString")
    .crType("testString")
    .expiration(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileClaimRule> response = iamIdentityService.updateClaimRule(updateClaimRuleOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRule responseObj = response.getResult();
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
    assertEquals(parsedPath, updateClaimRulePath);
  }

  // Test the updateClaimRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateClaimRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.updateClaimRule(null).execute();
  }

  @Test
  public void testDeleteClaimRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteClaimRulePath = "/v1/profiles/testString/rules/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteClaimRuleOptions model
    DeleteClaimRuleOptions deleteClaimRuleOptionsModel = new DeleteClaimRuleOptions.Builder()
    .profileId("testString")
    .ruleId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.deleteClaimRule(deleteClaimRuleOptionsModel).execute();
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
    assertEquals(parsedPath, deleteClaimRulePath);
  }

  // Test the deleteClaimRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteClaimRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.deleteClaimRule(null).execute();
  }

  @Test
  public void testCreateLinkWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"cr_type\": \"crType\", \"link\": {\"crn\": \"crn\", \"namespace\": \"namespace\", \"name\": \"name\"}}";
    String createLinkPath = "/v1/profiles/testString/links";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateProfileLinkRequestLink model
    CreateProfileLinkRequestLink createProfileLinkRequestLinkModel = new CreateProfileLinkRequestLink.Builder()
    .crn("testString")
    .namespace("testString")
    .name("testString")
    .build();

    // Construct an instance of the CreateLinkOptions model
    CreateLinkOptions createLinkOptionsModel = new CreateLinkOptions.Builder()
    .profileId("testString")
    .crType("testString")
    .link(createProfileLinkRequestLinkModel)
    .name("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileLink> response = iamIdentityService.createLink(createLinkOptionsModel).execute();
    assertNotNull(response);
    ProfileLink responseObj = response.getResult();
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
    assertEquals(parsedPath, createLinkPath);
  }

  // Test the createLink operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateLinkNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.createLink(null).execute();
  }

  @Test
  public void testListLinkWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"links\": [{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"cr_type\": \"crType\", \"link\": {\"crn\": \"crn\", \"namespace\": \"namespace\", \"name\": \"name\"}}]}";
    String listLinkPath = "/v1/profiles/testString/links";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListLinkOptions model
    ListLinkOptions listLinkOptionsModel = new ListLinkOptions.Builder()
    .profileId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileLinkList> response = iamIdentityService.listLink(listLinkOptionsModel).execute();
    assertNotNull(response);
    ProfileLinkList responseObj = response.getResult();
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
    assertEquals(parsedPath, listLinkPath);
  }

  // Test the listLink operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListLinkNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.listLink(null).execute();
  }

  @Test
  public void testGetLinkWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"cr_type\": \"crType\", \"link\": {\"crn\": \"crn\", \"namespace\": \"namespace\", \"name\": \"name\"}}";
    String getLinkPath = "/v1/profiles/testString/links/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLinkOptions model
    GetLinkOptions getLinkOptionsModel = new GetLinkOptions.Builder()
    .profileId("testString")
    .linkId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ProfileLink> response = iamIdentityService.getLink(getLinkOptionsModel).execute();
    assertNotNull(response);
    ProfileLink responseObj = response.getResult();
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
    assertEquals(parsedPath, getLinkPath);
  }

  // Test the getLink operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLinkNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.getLink(null).execute();
  }

  @Test
  public void testDeleteLinkWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteLinkPath = "/v1/profiles/testString/links/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteLinkOptions model
    DeleteLinkOptions deleteLinkOptionsModel = new DeleteLinkOptions.Builder()
    .profileId("testString")
    .linkId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamIdentityService.deleteLink(deleteLinkOptionsModel).execute();
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
    assertEquals(parsedPath, deleteLinkPath);
  }

  // Test the deleteLink operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLinkNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamIdentityService.deleteLink(null).execute();
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