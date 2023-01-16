/*
 * (C) Copyright IBM Corp. 2022, 2023.
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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyInsideCreateServiceIdRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileLinkRequestLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListClaimRulesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListLinksOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportReference;
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
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the IamIdentity service.
 */
public class IamIdentityTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IamIdentity iamIdentityService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new IamIdentity(serviceName, null);
  }

  // Test the listApiKeys operation with a valid options model parameter
  @Test
  public void testListApiKeysWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"apikeys\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}]}";
    String listApiKeysPath = "/v1/apikeys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .includeHistory(false)
      .build();

    // Invoke listApiKeys() with a valid options model and verify the result
    Response<ApiKeyList> response = iamIdentityService.listApiKeys(listApiKeysOptionsModel).execute();
    assertNotNull(response);
    ApiKeyList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listApiKeysPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("iam_id"), "testString");
    assertEquals(Long.valueOf(query.get("pagesize")), Long.valueOf("26"));
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("scope"), "entity");
    assertEquals(query.get("type"), "user");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the listApiKeys operation with and without retries enabled
  @Test
  public void testListApiKeysWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListApiKeysWOptions();

    iamIdentityService.disableRetries();
    testListApiKeysWOptions();
  }

  // Test the createApiKey operation with a valid options model parameter
  @Test
  public void testCreateApiKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String createApiKeyPath = "/v1/apikeys";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateApiKeyOptions model
    CreateApiKeyOptions createApiKeyOptionsModel = new CreateApiKeyOptions.Builder()
      .name("testString")
      .iamId("testString")
      .description("testString")
      .accountId("testString")
      .apikey("testString")
      .storeValue(true)
      .entityLock("false")
      .build();

    // Invoke createApiKey() with a valid options model and verify the result
    Response<ApiKey> response = iamIdentityService.createApiKey(createApiKeyOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createApiKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createApiKey operation with and without retries enabled
  @Test
  public void testCreateApiKeyWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateApiKeyWOptions();

    iamIdentityService.disableRetries();
    testCreateApiKeyWOptions();
  }

  // Test the createApiKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateApiKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createApiKey(null).execute();
  }

  // Test the getApiKeysDetails operation with a valid options model parameter
  @Test
  public void testGetApiKeysDetailsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String getApiKeysDetailsPath = "/v1/apikeys/details";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetApiKeysDetailsOptions model
    GetApiKeysDetailsOptions getApiKeysDetailsOptionsModel = new GetApiKeysDetailsOptions.Builder()
      .iamApiKey("testString")
      .includeHistory(false)
      .build();

    // Invoke getApiKeysDetails() with a valid options model and verify the result
    Response<ApiKey> response = iamIdentityService.getApiKeysDetails(getApiKeysDetailsOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getApiKeysDetailsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getApiKeysDetails operation with and without retries enabled
  @Test
  public void testGetApiKeysDetailsWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetApiKeysDetailsWOptions();

    iamIdentityService.disableRetries();
    testGetApiKeysDetailsWOptions();
  }

  // Test the getApiKey operation with a valid options model parameter
  @Test
  public void testGetApiKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String getApiKeyPath = "/v1/apikeys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetApiKeyOptions model
    GetApiKeyOptions getApiKeyOptionsModel = new GetApiKeyOptions.Builder()
      .id("testString")
      .includeHistory(false)
      .includeActivity(false)
      .build();

    // Invoke getApiKey() with a valid options model and verify the result
    Response<ApiKey> response = iamIdentityService.getApiKey(getApiKeyOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getApiKeyPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_activity")), Boolean.valueOf(false));
  }

  // Test the getApiKey operation with and without retries enabled
  @Test
  public void testGetApiKeyWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetApiKeyWOptions();

    iamIdentityService.disableRetries();
    testGetApiKeyWOptions();
  }

  // Test the getApiKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetApiKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getApiKey(null).execute();
  }

  // Test the updateApiKey operation with a valid options model parameter
  @Test
  public void testUpdateApiKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String updateApiKeyPath = "/v1/apikeys/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateApiKeyOptions model
    UpdateApiKeyOptions updateApiKeyOptionsModel = new UpdateApiKeyOptions.Builder()
      .id("testString")
      .ifMatch("testString")
      .name("testString")
      .description("testString")
      .build();

    // Invoke updateApiKey() with a valid options model and verify the result
    Response<ApiKey> response = iamIdentityService.updateApiKey(updateApiKeyOptionsModel).execute();
    assertNotNull(response);
    ApiKey responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateApiKeyPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateApiKey operation with and without retries enabled
  @Test
  public void testUpdateApiKeyWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateApiKeyWOptions();

    iamIdentityService.disableRetries();
    testUpdateApiKeyWOptions();
  }

  // Test the updateApiKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateApiKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateApiKey(null).execute();
  }

  // Test the deleteApiKey operation with a valid options model parameter
  @Test
  public void testDeleteApiKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteApiKeyPath = "/v1/apikeys/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteApiKeyOptions model
    DeleteApiKeyOptions deleteApiKeyOptionsModel = new DeleteApiKeyOptions.Builder()
      .id("testString")
      .build();

    // Invoke deleteApiKey() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteApiKey(deleteApiKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteApiKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteApiKey operation with and without retries enabled
  @Test
  public void testDeleteApiKeyWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteApiKeyWOptions();

    iamIdentityService.disableRetries();
    testDeleteApiKeyWOptions();
  }

  // Test the deleteApiKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteApiKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteApiKey(null).execute();
  }

  // Test the lockApiKey operation with a valid options model parameter
  @Test
  public void testLockApiKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String lockApiKeyPath = "/v1/apikeys/testString/lock";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the LockApiKeyOptions model
    LockApiKeyOptions lockApiKeyOptionsModel = new LockApiKeyOptions.Builder()
      .id("testString")
      .build();

    // Invoke lockApiKey() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.lockApiKey(lockApiKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockApiKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the lockApiKey operation with and without retries enabled
  @Test
  public void testLockApiKeyWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testLockApiKeyWOptions();

    iamIdentityService.disableRetries();
    testLockApiKeyWOptions();
  }

  // Test the lockApiKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockApiKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.lockApiKey(null).execute();
  }

  // Test the unlockApiKey operation with a valid options model parameter
  @Test
  public void testUnlockApiKeyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String unlockApiKeyPath = "/v1/apikeys/testString/lock";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UnlockApiKeyOptions model
    UnlockApiKeyOptions unlockApiKeyOptionsModel = new UnlockApiKeyOptions.Builder()
      .id("testString")
      .build();

    // Invoke unlockApiKey() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.unlockApiKey(unlockApiKeyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unlockApiKeyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unlockApiKey operation with and without retries enabled
  @Test
  public void testUnlockApiKeyWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUnlockApiKeyWOptions();

    iamIdentityService.disableRetries();
    testUnlockApiKeyWOptions();
  }

  // Test the unlockApiKey operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockApiKeyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.unlockApiKey(null).execute();
  }

  // Test the listServiceIds operation with a valid options model parameter
  @Test
  public void testListServiceIdsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"serviceids\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}, \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}]}";
    String listServiceIdsPath = "/v1/serviceids/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListServiceIdsOptions model
    ListServiceIdsOptions listServiceIdsOptionsModel = new ListServiceIdsOptions.Builder()
      .accountId("testString")
      .name("testString")
      .pagesize(Long.valueOf("26"))
      .pagetoken("testString")
      .sort("testString")
      .order("asc")
      .includeHistory(false)
      .build();

    // Invoke listServiceIds() with a valid options model and verify the result
    Response<ServiceIdList> response = iamIdentityService.listServiceIds(listServiceIdsOptionsModel).execute();
    assertNotNull(response);
    ServiceIdList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listServiceIdsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(Long.valueOf(query.get("pagesize")), Long.valueOf("26"));
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the listServiceIds operation with and without retries enabled
  @Test
  public void testListServiceIdsWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListServiceIdsWOptions();

    iamIdentityService.disableRetries();
    testListServiceIdsWOptions();
  }

  // Test the createServiceId operation with a valid options model parameter
  @Test
  public void testCreateServiceIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}, \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String createServiceIdPath = "/v1/serviceids/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

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
      .uniqueInstanceCrns(java.util.Arrays.asList("testString"))
      .apikey(apiKeyInsideCreateServiceIdRequestModel)
      .entityLock("false")
      .build();

    // Invoke createServiceId() with a valid options model and verify the result
    Response<ServiceId> response = iamIdentityService.createServiceId(createServiceIdOptionsModel).execute();
    assertNotNull(response);
    ServiceId responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createServiceIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createServiceId operation with and without retries enabled
  @Test
  public void testCreateServiceIdWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateServiceIdWOptions();

    iamIdentityService.disableRetries();
    testCreateServiceIdWOptions();
  }

  // Test the createServiceId operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateServiceIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createServiceId(null).execute();
  }

  // Test the getServiceId operation with a valid options model parameter
  @Test
  public void testGetServiceIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}, \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String getServiceIdPath = "/v1/serviceids/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetServiceIdOptions model
    GetServiceIdOptions getServiceIdOptionsModel = new GetServiceIdOptions.Builder()
      .id("testString")
      .includeHistory(false)
      .includeActivity(false)
      .build();

    // Invoke getServiceId() with a valid options model and verify the result
    Response<ServiceId> response = iamIdentityService.getServiceId(getServiceIdOptionsModel).execute();
    assertNotNull(response);
    ServiceId responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getServiceIdPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("include_activity")), Boolean.valueOf(false));
  }

  // Test the getServiceId operation with and without retries enabled
  @Test
  public void testGetServiceIdWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetServiceIdWOptions();

    iamIdentityService.disableRetries();
    testGetServiceIdWOptions();
  }

  // Test the getServiceId operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetServiceIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getServiceId(null).execute();
  }

  // Test the updateServiceId operation with a valid options model parameter
  @Test
  public void testUpdateServiceIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"iam_id\": \"iamId\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"unique_instance_crns\": [\"uniqueInstanceCrns\"], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"apikey\": {\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"locked\": true, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"description\": \"description\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"apikey\": \"apikey\", \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}, \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String updateServiceIdPath = "/v1/serviceids/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateServiceIdOptions model
    UpdateServiceIdOptions updateServiceIdOptionsModel = new UpdateServiceIdOptions.Builder()
      .id("testString")
      .ifMatch("testString")
      .name("testString")
      .description("testString")
      .uniqueInstanceCrns(java.util.Arrays.asList("testString"))
      .build();

    // Invoke updateServiceId() with a valid options model and verify the result
    Response<ServiceId> response = iamIdentityService.updateServiceId(updateServiceIdOptionsModel).execute();
    assertNotNull(response);
    ServiceId responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateServiceIdPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateServiceId operation with and without retries enabled
  @Test
  public void testUpdateServiceIdWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateServiceIdWOptions();

    iamIdentityService.disableRetries();
    testUpdateServiceIdWOptions();
  }

  // Test the updateServiceId operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateServiceIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateServiceId(null).execute();
  }

  // Test the deleteServiceId operation with a valid options model parameter
  @Test
  public void testDeleteServiceIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteServiceIdPath = "/v1/serviceids/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteServiceIdOptions model
    DeleteServiceIdOptions deleteServiceIdOptionsModel = new DeleteServiceIdOptions.Builder()
      .id("testString")
      .build();

    // Invoke deleteServiceId() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteServiceId(deleteServiceIdOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteServiceIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteServiceId operation with and without retries enabled
  @Test
  public void testDeleteServiceIdWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteServiceIdWOptions();

    iamIdentityService.disableRetries();
    testDeleteServiceIdWOptions();
  }

  // Test the deleteServiceId operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteServiceIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteServiceId(null).execute();
  }

  // Test the lockServiceId operation with a valid options model parameter
  @Test
  public void testLockServiceIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String lockServiceIdPath = "/v1/serviceids/testString/lock";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the LockServiceIdOptions model
    LockServiceIdOptions lockServiceIdOptionsModel = new LockServiceIdOptions.Builder()
      .id("testString")
      .build();

    // Invoke lockServiceId() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.lockServiceId(lockServiceIdOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, lockServiceIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the lockServiceId operation with and without retries enabled
  @Test
  public void testLockServiceIdWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testLockServiceIdWOptions();

    iamIdentityService.disableRetries();
    testLockServiceIdWOptions();
  }

  // Test the lockServiceId operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testLockServiceIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.lockServiceId(null).execute();
  }

  // Test the unlockServiceId operation with a valid options model parameter
  @Test
  public void testUnlockServiceIdWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String unlockServiceIdPath = "/v1/serviceids/testString/lock";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UnlockServiceIdOptions model
    UnlockServiceIdOptions unlockServiceIdOptionsModel = new UnlockServiceIdOptions.Builder()
      .id("testString")
      .build();

    // Invoke unlockServiceId() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.unlockServiceId(unlockServiceIdOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, unlockServiceIdPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the unlockServiceId operation with and without retries enabled
  @Test
  public void testUnlockServiceIdWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUnlockServiceIdWOptions();

    iamIdentityService.disableRetries();
    testUnlockServiceIdWOptions();
  }

  // Test the unlockServiceId operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUnlockServiceIdNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.unlockServiceId(null).execute();
  }

  // Test the createProfile operation with a valid options model parameter
  @Test
  public void testCreateProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String createProfilePath = "/v1/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateProfileOptions model
    CreateProfileOptions createProfileOptionsModel = new CreateProfileOptions.Builder()
      .name("testString")
      .accountId("testString")
      .description("testString")
      .build();

    // Invoke createProfile() with a valid options model and verify the result
    Response<TrustedProfile> response = iamIdentityService.createProfile(createProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProfilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createProfile operation with and without retries enabled
  @Test
  public void testCreateProfileWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateProfileWOptions();

    iamIdentityService.disableRetries();
    testCreateProfileWOptions();
  }

  // Test the createProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createProfile(null).execute();
  }

  // Test the listProfiles operation with a valid options model parameter
  @Test
  public void testListProfilesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"profiles\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}]}";
    String listProfilesPath = "/v1/profiles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfilesOptions model
    ListProfilesOptions listProfilesOptionsModel = new ListProfilesOptions.Builder()
      .accountId("testString")
      .name("testString")
      .pagesize(Long.valueOf("26"))
      .sort("testString")
      .order("asc")
      .includeHistory(false)
      .pagetoken("testString")
      .build();

    // Invoke listProfiles() with a valid options model and verify the result
    Response<TrustedProfilesList> response = iamIdentityService.listProfiles(listProfilesOptionsModel).execute();
    assertNotNull(response);
    TrustedProfilesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfilesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(Long.valueOf(query.get("pagesize")), Long.valueOf("26"));
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
    assertEquals(query.get("pagetoken"), "testString");
  }

  // Test the listProfiles operation with and without retries enabled
  @Test
  public void testListProfilesWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListProfilesWOptions();

    iamIdentityService.disableRetries();
    testListProfilesWOptions();
  }

  // Test the listProfiles operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListProfilesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.listProfiles(null).execute();
  }

  // Test the getProfile operation with a valid options model parameter
  @Test
  public void testGetProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String getProfilePath = "/v1/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileOptions model
    GetProfileOptions getProfileOptionsModel = new GetProfileOptions.Builder()
      .profileId("testString")
      .includeActivity(false)
      .build();

    // Invoke getProfile() with a valid options model and verify the result
    Response<TrustedProfile> response = iamIdentityService.getProfile(getProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfilePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_activity")), Boolean.valueOf(false));
  }

  // Test the getProfile operation with and without retries enabled
  @Test
  public void testGetProfileWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetProfileWOptions();

    iamIdentityService.disableRetries();
    testGetProfileWOptions();
  }

  // Test the getProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getProfile(null).execute();
  }

  // Test the updateProfile operation with a valid options model parameter
  @Test
  public void testUpdateProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
    String updateProfilePath = "/v1/profiles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateProfileOptions model
    UpdateProfileOptions updateProfileOptionsModel = new UpdateProfileOptions.Builder()
      .profileId("testString")
      .ifMatch("testString")
      .name("testString")
      .description("testString")
      .build();

    // Invoke updateProfile() with a valid options model and verify the result
    Response<TrustedProfile> response = iamIdentityService.updateProfile(updateProfileOptionsModel).execute();
    assertNotNull(response);
    TrustedProfile responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateProfilePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateProfile operation with and without retries enabled
  @Test
  public void testUpdateProfileWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateProfileWOptions();

    iamIdentityService.disableRetries();
    testUpdateProfileWOptions();
  }

  // Test the updateProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateProfile(null).execute();
  }

  // Test the deleteProfile operation with a valid options model parameter
  @Test
  public void testDeleteProfileWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteProfilePath = "/v1/profiles/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProfileOptions model
    DeleteProfileOptions deleteProfileOptionsModel = new DeleteProfileOptions.Builder()
      .profileId("testString")
      .build();

    // Invoke deleteProfile() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteProfile(deleteProfileOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfilePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteProfile operation with and without retries enabled
  @Test
  public void testDeleteProfileWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteProfileWOptions();

    iamIdentityService.disableRetries();
    testDeleteProfileWOptions();
  }

  // Test the deleteProfile operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteProfile(null).execute();
  }

  // Test the createClaimRule operation with a valid options model parameter
  @Test
  public void testCreateClaimRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}";
    String createClaimRulePath = "/v1/profiles/testString/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

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
      .conditions(java.util.Arrays.asList(profileClaimRuleConditionsModel))
      .context(responseContextModel)
      .name("testString")
      .realmName("testString")
      .crType("testString")
      .expiration(Long.valueOf("26"))
      .build();

    // Invoke createClaimRule() with a valid options model and verify the result
    Response<ProfileClaimRule> response = iamIdentityService.createClaimRule(createClaimRuleOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createClaimRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createClaimRule operation with and without retries enabled
  @Test
  public void testCreateClaimRuleWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateClaimRuleWOptions();

    iamIdentityService.disableRetries();
    testCreateClaimRuleWOptions();
  }

  // Test the createClaimRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClaimRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createClaimRule(null).execute();
  }

  // Test the listClaimRules operation with a valid options model parameter
  @Test
  public void testListClaimRulesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"rules\": [{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}]}";
    String listClaimRulesPath = "/v1/profiles/testString/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListClaimRulesOptions model
    ListClaimRulesOptions listClaimRulesOptionsModel = new ListClaimRulesOptions.Builder()
      .profileId("testString")
      .build();

    // Invoke listClaimRules() with a valid options model and verify the result
    Response<ProfileClaimRuleList> response = iamIdentityService.listClaimRules(listClaimRulesOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRuleList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listClaimRulesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listClaimRules operation with and without retries enabled
  @Test
  public void testListClaimRulesWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListClaimRulesWOptions();

    iamIdentityService.disableRetries();
    testListClaimRulesWOptions();
  }

  // Test the listClaimRules operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListClaimRulesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.listClaimRules(null).execute();
  }

  // Test the getClaimRule operation with a valid options model parameter
  @Test
  public void testGetClaimRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}";
    String getClaimRulePath = "/v1/profiles/testString/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetClaimRuleOptions model
    GetClaimRuleOptions getClaimRuleOptionsModel = new GetClaimRuleOptions.Builder()
      .profileId("testString")
      .ruleId("testString")
      .build();

    // Invoke getClaimRule() with a valid options model and verify the result
    Response<ProfileClaimRule> response = iamIdentityService.getClaimRule(getClaimRuleOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getClaimRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getClaimRule operation with and without retries enabled
  @Test
  public void testGetClaimRuleWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetClaimRuleWOptions();

    iamIdentityService.disableRetries();
    testGetClaimRuleWOptions();
  }

  // Test the getClaimRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClaimRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getClaimRule(null).execute();
  }

  // Test the updateClaimRule operation with a valid options model parameter
  @Test
  public void testUpdateClaimRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"type\": \"type\", \"realm_name\": \"realmName\", \"expiration\": 10, \"cr_type\": \"crType\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}";
    String updateClaimRulePath = "/v1/profiles/testString/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .conditions(java.util.Arrays.asList(profileClaimRuleConditionsModel))
      .context(responseContextModel)
      .name("testString")
      .realmName("testString")
      .crType("testString")
      .expiration(Long.valueOf("26"))
      .build();

    // Invoke updateClaimRule() with a valid options model and verify the result
    Response<ProfileClaimRule> response = iamIdentityService.updateClaimRule(updateClaimRuleOptionsModel).execute();
    assertNotNull(response);
    ProfileClaimRule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateClaimRulePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateClaimRule operation with and without retries enabled
  @Test
  public void testUpdateClaimRuleWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateClaimRuleWOptions();

    iamIdentityService.disableRetries();
    testUpdateClaimRuleWOptions();
  }

  // Test the updateClaimRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateClaimRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateClaimRule(null).execute();
  }

  // Test the deleteClaimRule operation with a valid options model parameter
  @Test
  public void testDeleteClaimRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteClaimRulePath = "/v1/profiles/testString/rules/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteClaimRuleOptions model
    DeleteClaimRuleOptions deleteClaimRuleOptionsModel = new DeleteClaimRuleOptions.Builder()
      .profileId("testString")
      .ruleId("testString")
      .build();

    // Invoke deleteClaimRule() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteClaimRule(deleteClaimRuleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteClaimRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteClaimRule operation with and without retries enabled
  @Test
  public void testDeleteClaimRuleWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteClaimRuleWOptions();

    iamIdentityService.disableRetries();
    testDeleteClaimRuleWOptions();
  }

  // Test the deleteClaimRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteClaimRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteClaimRule(null).execute();
  }

  // Test the createLink operation with a valid options model parameter
  @Test
  public void testCreateLinkWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"cr_type\": \"crType\", \"link\": {\"crn\": \"crn\", \"namespace\": \"namespace\", \"name\": \"name\"}}";
    String createLinkPath = "/v1/profiles/testString/links";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

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

    // Invoke createLink() with a valid options model and verify the result
    Response<ProfileLink> response = iamIdentityService.createLink(createLinkOptionsModel).execute();
    assertNotNull(response);
    ProfileLink responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createLinkPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createLink operation with and without retries enabled
  @Test
  public void testCreateLinkWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateLinkWOptions();

    iamIdentityService.disableRetries();
    testCreateLinkWOptions();
  }

  // Test the createLink operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateLinkNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createLink(null).execute();
  }

  // Test the listLinks operation with a valid options model parameter
  @Test
  public void testListLinksWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"links\": [{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"cr_type\": \"crType\", \"link\": {\"crn\": \"crn\", \"namespace\": \"namespace\", \"name\": \"name\"}}]}";
    String listLinksPath = "/v1/profiles/testString/links";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListLinksOptions model
    ListLinksOptions listLinksOptionsModel = new ListLinksOptions.Builder()
      .profileId("testString")
      .build();

    // Invoke listLinks() with a valid options model and verify the result
    Response<ProfileLinkList> response = iamIdentityService.listLinks(listLinksOptionsModel).execute();
    assertNotNull(response);
    ProfileLinkList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLinksPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listLinks operation with and without retries enabled
  @Test
  public void testListLinksWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListLinksWOptions();

    iamIdentityService.disableRetries();
    testListLinksWOptions();
  }

  // Test the listLinks operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListLinksNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.listLinks(null).execute();
  }

  // Test the getLink operation with a valid options model parameter
  @Test
  public void testGetLinkWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"entity_tag\": \"entityTag\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"name\": \"name\", \"cr_type\": \"crType\", \"link\": {\"crn\": \"crn\", \"namespace\": \"namespace\", \"name\": \"name\"}}";
    String getLinkPath = "/v1/profiles/testString/links/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLinkOptions model
    GetLinkOptions getLinkOptionsModel = new GetLinkOptions.Builder()
      .profileId("testString")
      .linkId("testString")
      .build();

    // Invoke getLink() with a valid options model and verify the result
    Response<ProfileLink> response = iamIdentityService.getLink(getLinkOptionsModel).execute();
    assertNotNull(response);
    ProfileLink responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLinkPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getLink operation with and without retries enabled
  @Test
  public void testGetLinkWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetLinkWOptions();

    iamIdentityService.disableRetries();
    testGetLinkWOptions();
  }

  // Test the getLink operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLinkNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getLink(null).execute();
  }

  // Test the deleteLink operation with a valid options model parameter
  @Test
  public void testDeleteLinkWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteLinkPath = "/v1/profiles/testString/links/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteLinkOptions model
    DeleteLinkOptions deleteLinkOptionsModel = new DeleteLinkOptions.Builder()
      .profileId("testString")
      .linkId("testString")
      .build();

    // Invoke deleteLink() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteLink(deleteLinkOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLinkPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteLink operation with and without retries enabled
  @Test
  public void testDeleteLinkWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteLinkWOptions();

    iamIdentityService.disableRetries();
    testDeleteLinkWOptions();
  }

  // Test the deleteLink operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLinkNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteLink(null).execute();
  }

  // Test the getAccountSettings operation with a valid options model parameter
  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"account_id\": \"accountId\", \"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"entity_tag\": \"entityTag\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"2592000\"}";
    String getAccountSettingsPath = "/v1/accounts/testString/settings/identity";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountSettingsOptions model
    GetAccountSettingsOptions getAccountSettingsOptionsModel = new GetAccountSettingsOptions.Builder()
      .accountId("testString")
      .includeHistory(false)
      .build();

    // Invoke getAccountSettings() with a valid options model and verify the result
    Response<AccountSettingsResponse> response = iamIdentityService.getAccountSettings(getAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountSettingsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getAccountSettings operation with and without retries enabled
  @Test
  public void testGetAccountSettingsWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetAccountSettingsWOptions();

    iamIdentityService.disableRetries();
    testGetAccountSettingsWOptions();
  }

  // Test the getAccountSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getAccountSettings(null).execute();
  }

  // Test the updateAccountSettings operation with a valid options model parameter
  @Test
  public void testUpdateAccountSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"account_id\": \"accountId\", \"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"entity_tag\": \"entityTag\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"2592000\"}";
    String updateAccountSettingsPath = "/v1/accounts/testString/settings/identity";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AccountSettingsUserMFA model
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();

    // Construct an instance of the UpdateAccountSettingsOptions model
    UpdateAccountSettingsOptions updateAccountSettingsOptionsModel = new UpdateAccountSettingsOptions.Builder()
      .ifMatch("testString")
      .accountId("testString")
      .restrictCreateServiceId("RESTRICTED")
      .restrictCreatePlatformApikey("RESTRICTED")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(accountSettingsUserMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("2592000")
      .build();

    // Invoke updateAccountSettings() with a valid options model and verify the result
    Response<AccountSettingsResponse> response = iamIdentityService.updateAccountSettings(updateAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountSettingsPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAccountSettings operation with and without retries enabled
  @Test
  public void testUpdateAccountSettingsWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateAccountSettingsWOptions();

    iamIdentityService.disableRetries();
    testUpdateAccountSettingsWOptions();
  }

  // Test the updateAccountSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateAccountSettings(null).execute();
  }

  // Test the createReport operation with a valid options model parameter
  @Test
  public void testCreateReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"reference\": \"reference\"}";
    String createReportPath = "/v1/activity/accounts/testString/report";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateReportOptions model
    CreateReportOptions createReportOptionsModel = new CreateReportOptions.Builder()
      .accountId("testString")
      .type("inactive")
      .duration("720")
      .build();

    // Invoke createReport() with a valid options model and verify the result
    Response<ReportReference> response = iamIdentityService.createReport(createReportOptionsModel).execute();
    assertNotNull(response);
    ReportReference responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createReportPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("type"), "inactive");
    assertEquals(query.get("duration"), "720");
  }

  // Test the createReport operation with and without retries enabled
  @Test
  public void testCreateReportWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateReportWOptions();

    iamIdentityService.disableRetries();
    testCreateReportWOptions();
  }

  // Test the createReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createReport(null).execute();
  }

  // Test the getReport operation with a valid options model parameter
  @Test
  public void testGetReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_by\": \"createdBy\", \"reference\": \"reference\", \"report_duration\": \"reportDuration\", \"report_start_time\": \"reportStartTime\", \"report_end_time\": \"reportEndTime\", \"users\": [{\"iam_id\": \"iamId\", \"name\": \"name\", \"username\": \"username\", \"email\": \"email\", \"last_authn\": \"lastAuthn\"}], \"apikeys\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"serviceid\": {\"id\": \"id\", \"name\": \"name\"}, \"user\": {\"iam_id\": \"iamId\", \"name\": \"name\", \"username\": \"username\", \"email\": \"email\"}, \"last_authn\": \"lastAuthn\"}], \"serviceids\": [{\"id\": \"id\", \"name\": \"name\", \"last_authn\": \"lastAuthn\"}], \"profiles\": [{\"id\": \"id\", \"name\": \"name\", \"last_authn\": \"lastAuthn\"}]}";
    String getReportPath = "/v1/activity/accounts/testString/report/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetReportOptions model
    GetReportOptions getReportOptionsModel = new GetReportOptions.Builder()
      .accountId("testString")
      .reference("testString")
      .build();

    // Invoke getReport() with a valid options model and verify the result
    Response<Report> response = iamIdentityService.getReport(getReportOptionsModel).execute();
    assertNotNull(response);
    Report responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReportPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getReport operation with and without retries enabled
  @Test
  public void testGetReportWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetReportWOptions();

    iamIdentityService.disableRetries();
    testGetReportWOptions();
  }

  // Test the getReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getReport(null).execute();
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
    iamIdentityService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    iamIdentityService = IamIdentity.newInstance(serviceName);
    String url = server.url("/").toString();
    iamIdentityService.setServiceUrl(url);
  }
}