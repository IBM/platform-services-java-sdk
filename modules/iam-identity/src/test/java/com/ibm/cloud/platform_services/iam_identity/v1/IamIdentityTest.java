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
package com.ibm.cloud.platform_services.iam_identity.v1;

import com.ibm.cloud.platform_services.iam_identity.v1.IamIdentity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountBasedMfaEnrollment;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsComponent;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsTemplateList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsTemplateResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Activity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyInsideCreateServiceIdRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApikeyActivity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApikeyActivityServiceid;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApikeyActivityUser;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CommitAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CommitProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateMfaReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileLinkRequestLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAllVersionsOfAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteAllVersionsOfProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.EnityHistoryRecord;
import com.ibm.cloud.platform_services.iam_identity.v1.model.EntityActivity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Error;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ExceptionResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLatestAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLatestProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetMfaReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetMfaStatusOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileIdentitiesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetReportOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdBasedMfaEnrollment;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListAccountSettingsAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListAccountSettingsTemplatesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListClaimRulesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListLinksOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfileTemplatesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListTrustedProfileAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListVersionsOfAccountSettingsTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListVersionsOfProfileTemplateOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.MfaEnrollmentTypeStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.model.MfaEnrollments;
import com.ibm.cloud.platform_services.iam_identity.v1.model.PolicyTemplateReference;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentitiesResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentityRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentityResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportMfaEnrollmentStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportReference;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.SetProfileIdentitiesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.SetProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentListResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentResource;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentResourceError;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentResponseResource;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAssignmentResponseResourceDetail;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateProfileComponentRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateProfileComponentResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfilesList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateTrustedProfileAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserActivity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserMfaEnrollments;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserReportMfaEnrollmentStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
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
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"assignment_id\": \"assignmentId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
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
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"profiles\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"assignment_id\": \"assignmentId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}]}";
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
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"assignment_id\": \"assignmentId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
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
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"name\": \"name\", \"description\": \"description\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"modified_at\": \"2019-01-01T12:00:00.000Z\", \"iam_id\": \"iamId\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"assignment_id\": \"assignmentId\", \"ims_account_id\": 12, \"ims_user_id\": 9, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"activity\": {\"last_authn\": \"lastAuthn\", \"authn_count\": 10}}";
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

  // Test the getProfileIdentities operation with a valid options model parameter
  @Test
  public void testGetProfileIdentitiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"entity_tag\": \"entityTag\", \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}";
    String getProfileIdentitiesPath = "/v1/profiles/testString/identities";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileIdentitiesOptions model
    GetProfileIdentitiesOptions getProfileIdentitiesOptionsModel = new GetProfileIdentitiesOptions.Builder()
      .profileId("testString")
      .build();

    // Invoke getProfileIdentities() with a valid options model and verify the result
    Response<ProfileIdentitiesResponse> response = iamIdentityService.getProfileIdentities(getProfileIdentitiesOptionsModel).execute();
    assertNotNull(response);
    ProfileIdentitiesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfileIdentitiesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getProfileIdentities operation with and without retries enabled
  @Test
  public void testGetProfileIdentitiesWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetProfileIdentitiesWOptions();

    iamIdentityService.disableRetries();
    testGetProfileIdentitiesWOptions();
  }

  // Test the getProfileIdentities operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileIdentitiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getProfileIdentities(null).execute();
  }

  // Test the setProfileIdentities operation with a valid options model parameter
  @Test
  public void testSetProfileIdentitiesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"entity_tag\": \"entityTag\", \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}";
    String setProfileIdentitiesPath = "/v1/profiles/testString/identities";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ProfileIdentityRequest model
    ProfileIdentityRequest profileIdentityRequestModel = new ProfileIdentityRequest.Builder()
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();

    // Construct an instance of the SetProfileIdentitiesOptions model
    SetProfileIdentitiesOptions setProfileIdentitiesOptionsModel = new SetProfileIdentitiesOptions.Builder()
      .profileId("testString")
      .ifMatch("testString")
      .identities(java.util.Arrays.asList(profileIdentityRequestModel))
      .build();

    // Invoke setProfileIdentities() with a valid options model and verify the result
    Response<ProfileIdentitiesResponse> response = iamIdentityService.setProfileIdentities(setProfileIdentitiesOptionsModel).execute();
    assertNotNull(response);
    ProfileIdentitiesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, setProfileIdentitiesPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the setProfileIdentities operation with and without retries enabled
  @Test
  public void testSetProfileIdentitiesWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testSetProfileIdentitiesWOptions();

    iamIdentityService.disableRetries();
    testSetProfileIdentitiesWOptions();
  }

  // Test the setProfileIdentities operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetProfileIdentitiesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.setProfileIdentities(null).execute();
  }

  // Test the setProfileIdentity operation with a valid options model parameter
  @Test
  public void testSetProfileIdentityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}";
    String setProfileIdentityPath = "/v1/profiles/testString/identities/user";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SetProfileIdentityOptions model
    SetProfileIdentityOptions setProfileIdentityOptionsModel = new SetProfileIdentityOptions.Builder()
      .profileId("testString")
      .identityType("user")
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();

    // Invoke setProfileIdentity() with a valid options model and verify the result
    Response<ProfileIdentityResponse> response = iamIdentityService.setProfileIdentity(setProfileIdentityOptionsModel).execute();
    assertNotNull(response);
    ProfileIdentityResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, setProfileIdentityPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the setProfileIdentity operation with and without retries enabled
  @Test
  public void testSetProfileIdentityWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testSetProfileIdentityWOptions();

    iamIdentityService.disableRetries();
    testSetProfileIdentityWOptions();
  }

  // Test the setProfileIdentity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetProfileIdentityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.setProfileIdentity(null).execute();
  }

  // Test the getProfileIdentity operation with a valid options model parameter
  @Test
  public void testGetProfileIdentityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}";
    String getProfileIdentityPath = "/v1/profiles/testString/identities/user/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileIdentityOptions model
    GetProfileIdentityOptions getProfileIdentityOptionsModel = new GetProfileIdentityOptions.Builder()
      .profileId("testString")
      .identityType("user")
      .identifierId("testString")
      .build();

    // Invoke getProfileIdentity() with a valid options model and verify the result
    Response<ProfileIdentityResponse> response = iamIdentityService.getProfileIdentity(getProfileIdentityOptionsModel).execute();
    assertNotNull(response);
    ProfileIdentityResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfileIdentityPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getProfileIdentity operation with and without retries enabled
  @Test
  public void testGetProfileIdentityWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetProfileIdentityWOptions();

    iamIdentityService.disableRetries();
    testGetProfileIdentityWOptions();
  }

  // Test the getProfileIdentity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileIdentityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getProfileIdentity(null).execute();
  }

  // Test the deleteProfileIdentity operation with a valid options model parameter
  @Test
  public void testDeleteProfileIdentityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteProfileIdentityPath = "/v1/profiles/testString/identities/user/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProfileIdentityOptions model
    DeleteProfileIdentityOptions deleteProfileIdentityOptionsModel = new DeleteProfileIdentityOptions.Builder()
      .profileId("testString")
      .identityType("user")
      .identifierId("testString")
      .build();

    // Invoke deleteProfileIdentity() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteProfileIdentity(deleteProfileIdentityOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfileIdentityPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteProfileIdentity operation with and without retries enabled
  @Test
  public void testDeleteProfileIdentityWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteProfileIdentityWOptions();

    iamIdentityService.disableRetries();
    testDeleteProfileIdentityWOptions();
  }

  // Test the deleteProfileIdentity operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileIdentityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteProfileIdentity(null).execute();
  }

  // Test the getAccountSettings operation with a valid options model parameter
  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"account_id\": \"accountId\", \"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"entity_tag\": \"entityTag\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}";
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
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"account_id\": \"accountId\", \"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"entity_tag\": \"entityTag\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}";
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
      .systemRefreshTokenExpirationInSeconds("259200")
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

  // Test the getMfaStatus operation with a valid options model parameter
  @Test
  public void testGetMfaStatusWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"effective_mfa_type\": \"effectiveMfaType\", \"id_based_mfa\": {\"trait_account_default\": \"NONE\", \"trait_user_specific\": \"NONE\", \"trait_effective\": \"NONE\", \"complies\": true}, \"account_based_mfa\": {\"security_questions\": {\"required\": true, \"enrolled\": true}, \"totp\": {\"required\": true, \"enrolled\": true}, \"verisign\": {\"required\": true, \"enrolled\": true}, \"complies\": true}}";
    String getMfaStatusPath = "/v1/mfa/accounts/testString/status";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetMfaStatusOptions model
    GetMfaStatusOptions getMfaStatusOptionsModel = new GetMfaStatusOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .build();

    // Invoke getMfaStatus() with a valid options model and verify the result
    Response<UserMfaEnrollments> response = iamIdentityService.getMfaStatus(getMfaStatusOptionsModel).execute();
    assertNotNull(response);
    UserMfaEnrollments responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMfaStatusPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("iam_id"), "testString");
  }

  // Test the getMfaStatus operation with and without retries enabled
  @Test
  public void testGetMfaStatusWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetMfaStatusWOptions();

    iamIdentityService.disableRetries();
    testGetMfaStatusWOptions();
  }

  // Test the getMfaStatus operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetMfaStatusNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getMfaStatus(null).execute();
  }

  // Test the createMfaReport operation with a valid options model parameter
  @Test
  public void testCreateMfaReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"reference\": \"reference\"}";
    String createMfaReportPath = "/v1/mfa/accounts/testString/report";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateMfaReportOptions model
    CreateMfaReportOptions createMfaReportOptionsModel = new CreateMfaReportOptions.Builder()
      .accountId("testString")
      .type("testString")
      .build();

    // Invoke createMfaReport() with a valid options model and verify the result
    Response<ReportReference> response = iamIdentityService.createMfaReport(createMfaReportOptionsModel).execute();
    assertNotNull(response);
    ReportReference responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createMfaReportPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("type"), "testString");
  }

  // Test the createMfaReport operation with and without retries enabled
  @Test
  public void testCreateMfaReportWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateMfaReportWOptions();

    iamIdentityService.disableRetries();
    testCreateMfaReportWOptions();
  }

  // Test the createMfaReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateMfaReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createMfaReport(null).execute();
  }

  // Test the getMfaReport operation with a valid options model parameter
  @Test
  public void testGetMfaReportWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"created_by\": \"createdBy\", \"reference\": \"reference\", \"report_time\": \"reportTime\", \"account_id\": \"accountId\", \"ims_account_id\": \"imsAccountId\", \"users\": [{\"iam_id\": \"iamId\", \"name\": \"name\", \"username\": \"username\", \"email\": \"email\", \"enrollments\": {\"effective_mfa_type\": \"effectiveMfaType\", \"id_based_mfa\": {\"trait_account_default\": \"NONE\", \"trait_user_specific\": \"NONE\", \"trait_effective\": \"NONE\", \"complies\": true}, \"account_based_mfa\": {\"security_questions\": {\"required\": true, \"enrolled\": true}, \"totp\": {\"required\": true, \"enrolled\": true}, \"verisign\": {\"required\": true, \"enrolled\": true}, \"complies\": true}}}]}";
    String getMfaReportPath = "/v1/mfa/accounts/testString/report/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetMfaReportOptions model
    GetMfaReportOptions getMfaReportOptionsModel = new GetMfaReportOptions.Builder()
      .accountId("testString")
      .reference("testString")
      .build();

    // Invoke getMfaReport() with a valid options model and verify the result
    Response<ReportMfaEnrollmentStatus> response = iamIdentityService.getMfaReport(getMfaReportOptionsModel).execute();
    assertNotNull(response);
    ReportMfaEnrollmentStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getMfaReportPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getMfaReport operation with and without retries enabled
  @Test
  public void testGetMfaReportWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetMfaReportWOptions();

    iamIdentityService.disableRetries();
    testGetMfaReportWOptions();
  }

  // Test the getMfaReport operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetMfaReportNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getMfaReport(null).execute();
  }

  // Test the listAccountSettingsAssignments operation with a valid options model parameter
  @Test
  public void testListAccountSettingsAssignmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"assignments\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}]}";
    String listAccountSettingsAssignmentsPath = "/v1/account_settings_assignments/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccountSettingsAssignmentsOptions model
    ListAccountSettingsAssignmentsOptions listAccountSettingsAssignmentsOptionsModel = new ListAccountSettingsAssignmentsOptions.Builder()
      .accountId("testString")
      .templateId("testString")
      .templateVersion("testString")
      .target("testString")
      .targetType("Account")
      .limit(Long.valueOf("20"))
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory(false)
      .build();

    // Invoke listAccountSettingsAssignments() with a valid options model and verify the result
    Response<TemplateAssignmentListResponse> response = iamIdentityService.listAccountSettingsAssignments(listAccountSettingsAssignmentsOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentListResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccountSettingsAssignmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("template_id"), "testString");
    assertEquals(query.get("template_version"), "testString");
    assertEquals(query.get("target"), "testString");
    assertEquals(query.get("target_type"), "Account");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("20"));
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "created_at");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the listAccountSettingsAssignments operation with and without retries enabled
  @Test
  public void testListAccountSettingsAssignmentsWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListAccountSettingsAssignmentsWOptions();

    iamIdentityService.disableRetries();
    testListAccountSettingsAssignmentsWOptions();
  }

  // Test the createAccountSettingsAssignment operation with a valid options model parameter
  @Test
  public void testCreateAccountSettingsAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}";
    String createAccountSettingsAssignmentPath = "/v1/account_settings_assignments/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateAccountSettingsAssignmentOptions model
    CreateAccountSettingsAssignmentOptions createAccountSettingsAssignmentOptionsModel = new CreateAccountSettingsAssignmentOptions.Builder()
      .templateId("testString")
      .templateVersion(Long.valueOf("1"))
      .targetType("Account")
      .target("testString")
      .build();

    // Invoke createAccountSettingsAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamIdentityService.createAccountSettingsAssignment(createAccountSettingsAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountSettingsAssignmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAccountSettingsAssignment operation with and without retries enabled
  @Test
  public void testCreateAccountSettingsAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateAccountSettingsAssignmentWOptions();

    iamIdentityService.disableRetries();
    testCreateAccountSettingsAssignmentWOptions();
  }

  // Test the createAccountSettingsAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountSettingsAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createAccountSettingsAssignment(null).execute();
  }

  // Test the getAccountSettingsAssignment operation with a valid options model parameter
  @Test
  public void testGetAccountSettingsAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}";
    String getAccountSettingsAssignmentPath = "/v1/account_settings_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountSettingsAssignmentOptions model
    GetAccountSettingsAssignmentOptions getAccountSettingsAssignmentOptionsModel = new GetAccountSettingsAssignmentOptions.Builder()
      .assignmentId("testString")
      .includeHistory(false)
      .build();

    // Invoke getAccountSettingsAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamIdentityService.getAccountSettingsAssignment(getAccountSettingsAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountSettingsAssignmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getAccountSettingsAssignment operation with and without retries enabled
  @Test
  public void testGetAccountSettingsAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetAccountSettingsAssignmentWOptions();

    iamIdentityService.disableRetries();
    testGetAccountSettingsAssignmentWOptions();
  }

  // Test the getAccountSettingsAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSettingsAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getAccountSettingsAssignment(null).execute();
  }

  // Test the deleteAccountSettingsAssignment operation with a valid options model parameter
  @Test
  public void testDeleteAccountSettingsAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"status_code\": \"statusCode\", \"errors\": [{\"code\": \"code\", \"message_code\": \"messageCode\", \"message\": \"message\", \"details\": \"details\"}], \"trace\": \"trace\"}";
    String deleteAccountSettingsAssignmentPath = "/v1/account_settings_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAccountSettingsAssignmentOptions model
    DeleteAccountSettingsAssignmentOptions deleteAccountSettingsAssignmentOptionsModel = new DeleteAccountSettingsAssignmentOptions.Builder()
      .assignmentId("testString")
      .build();

    // Invoke deleteAccountSettingsAssignment() with a valid options model and verify the result
    Response<ExceptionResponse> response = iamIdentityService.deleteAccountSettingsAssignment(deleteAccountSettingsAssignmentOptionsModel).execute();
    assertNotNull(response);
    ExceptionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAccountSettingsAssignmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAccountSettingsAssignment operation with and without retries enabled
  @Test
  public void testDeleteAccountSettingsAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteAccountSettingsAssignmentWOptions();

    iamIdentityService.disableRetries();
    testDeleteAccountSettingsAssignmentWOptions();
  }

  // Test the deleteAccountSettingsAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAccountSettingsAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteAccountSettingsAssignment(null).execute();
  }

  // Test the updateAccountSettingsAssignment operation with a valid options model parameter
  @Test
  public void testUpdateAccountSettingsAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}";
    String updateAccountSettingsAssignmentPath = "/v1/account_settings_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateAccountSettingsAssignmentOptions model
    UpdateAccountSettingsAssignmentOptions updateAccountSettingsAssignmentOptionsModel = new UpdateAccountSettingsAssignmentOptions.Builder()
      .assignmentId("testString")
      .ifMatch("testString")
      .templateVersion(Long.valueOf("1"))
      .build();

    // Invoke updateAccountSettingsAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamIdentityService.updateAccountSettingsAssignment(updateAccountSettingsAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountSettingsAssignmentPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAccountSettingsAssignment operation with and without retries enabled
  @Test
  public void testUpdateAccountSettingsAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateAccountSettingsAssignmentWOptions();

    iamIdentityService.disableRetries();
    testUpdateAccountSettingsAssignmentWOptions();
  }

  // Test the updateAccountSettingsAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateAccountSettingsAssignment(null).execute();
  }

  // Test the listAccountSettingsTemplates operation with a valid options model parameter
  @Test
  public void testListAccountSettingsTemplatesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 20, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"account_settings_templates\": [{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listAccountSettingsTemplatesPath = "/v1/account_settings_templates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccountSettingsTemplatesOptions model
    ListAccountSettingsTemplatesOptions listAccountSettingsTemplatesOptionsModel = new ListAccountSettingsTemplatesOptions.Builder()
      .accountId("testString")
      .limit("20")
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory("false")
      .build();

    // Invoke listAccountSettingsTemplates() with a valid options model and verify the result
    Response<AccountSettingsTemplateList> response = iamIdentityService.listAccountSettingsTemplates(listAccountSettingsTemplatesOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccountSettingsTemplatesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("limit"), "20");
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "created_at");
    assertEquals(query.get("order"), "asc");
    assertEquals(query.get("include_history"), "false");
  }

  // Test the listAccountSettingsTemplates operation with and without retries enabled
  @Test
  public void testListAccountSettingsTemplatesWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListAccountSettingsTemplatesWOptions();

    iamIdentityService.disableRetries();
    testListAccountSettingsTemplatesWOptions();
  }

  // Test the createAccountSettingsTemplate operation with a valid options model parameter
  @Test
  public void testCreateAccountSettingsTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createAccountSettingsTemplatePath = "/v1/account_settings_templates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the AccountSettingsUserMFA model
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();

    // Construct an instance of the AccountSettingsComponent model
    AccountSettingsComponent accountSettingsComponentModel = new AccountSettingsComponent.Builder()
      .restrictCreateServiceId("NOT_SET")
      .restrictCreatePlatformApikey("NOT_SET")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(accountSettingsUserMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("259200")
      .build();

    // Construct an instance of the CreateAccountSettingsTemplateOptions model
    CreateAccountSettingsTemplateOptions createAccountSettingsTemplateOptionsModel = new CreateAccountSettingsTemplateOptions.Builder()
      .accountId("testString")
      .name("testString")
      .description("testString")
      .accountSettings(accountSettingsComponentModel)
      .build();

    // Invoke createAccountSettingsTemplate() with a valid options model and verify the result
    Response<AccountSettingsTemplateResponse> response = iamIdentityService.createAccountSettingsTemplate(createAccountSettingsTemplateOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountSettingsTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAccountSettingsTemplate operation with and without retries enabled
  @Test
  public void testCreateAccountSettingsTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateAccountSettingsTemplateWOptions();

    iamIdentityService.disableRetries();
    testCreateAccountSettingsTemplateWOptions();
  }

  // Test the getLatestAccountSettingsTemplateVersion operation with a valid options model parameter
  @Test
  public void testGetLatestAccountSettingsTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getLatestAccountSettingsTemplateVersionPath = "/v1/account_settings_templates/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLatestAccountSettingsTemplateVersionOptions model
    GetLatestAccountSettingsTemplateVersionOptions getLatestAccountSettingsTemplateVersionOptionsModel = new GetLatestAccountSettingsTemplateVersionOptions.Builder()
      .templateId("testString")
      .includeHistory(false)
      .build();

    // Invoke getLatestAccountSettingsTemplateVersion() with a valid options model and verify the result
    Response<AccountSettingsTemplateResponse> response = iamIdentityService.getLatestAccountSettingsTemplateVersion(getLatestAccountSettingsTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLatestAccountSettingsTemplateVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getLatestAccountSettingsTemplateVersion operation with and without retries enabled
  @Test
  public void testGetLatestAccountSettingsTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetLatestAccountSettingsTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testGetLatestAccountSettingsTemplateVersionWOptions();
  }

  // Test the getLatestAccountSettingsTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLatestAccountSettingsTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getLatestAccountSettingsTemplateVersion(null).execute();
  }

  // Test the deleteAllVersionsOfAccountSettingsTemplate operation with a valid options model parameter
  @Test
  public void testDeleteAllVersionsOfAccountSettingsTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAllVersionsOfAccountSettingsTemplatePath = "/v1/account_settings_templates/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAllVersionsOfAccountSettingsTemplateOptions model
    DeleteAllVersionsOfAccountSettingsTemplateOptions deleteAllVersionsOfAccountSettingsTemplateOptionsModel = new DeleteAllVersionsOfAccountSettingsTemplateOptions.Builder()
      .templateId("testString")
      .build();

    // Invoke deleteAllVersionsOfAccountSettingsTemplate() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteAllVersionsOfAccountSettingsTemplate(deleteAllVersionsOfAccountSettingsTemplateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAllVersionsOfAccountSettingsTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAllVersionsOfAccountSettingsTemplate operation with and without retries enabled
  @Test
  public void testDeleteAllVersionsOfAccountSettingsTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteAllVersionsOfAccountSettingsTemplateWOptions();

    iamIdentityService.disableRetries();
    testDeleteAllVersionsOfAccountSettingsTemplateWOptions();
  }

  // Test the deleteAllVersionsOfAccountSettingsTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAllVersionsOfAccountSettingsTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteAllVersionsOfAccountSettingsTemplate(null).execute();
  }

  // Test the listVersionsOfAccountSettingsTemplate operation with a valid options model parameter
  @Test
  public void testListVersionsOfAccountSettingsTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 20, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"account_settings_templates\": [{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listVersionsOfAccountSettingsTemplatePath = "/v1/account_settings_templates/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListVersionsOfAccountSettingsTemplateOptions model
    ListVersionsOfAccountSettingsTemplateOptions listVersionsOfAccountSettingsTemplateOptionsModel = new ListVersionsOfAccountSettingsTemplateOptions.Builder()
      .templateId("testString")
      .limit("20")
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory("false")
      .build();

    // Invoke listVersionsOfAccountSettingsTemplate() with a valid options model and verify the result
    Response<AccountSettingsTemplateList> response = iamIdentityService.listVersionsOfAccountSettingsTemplate(listVersionsOfAccountSettingsTemplateOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listVersionsOfAccountSettingsTemplatePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("limit"), "20");
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "created_at");
    assertEquals(query.get("order"), "asc");
    assertEquals(query.get("include_history"), "false");
  }

  // Test the listVersionsOfAccountSettingsTemplate operation with and without retries enabled
  @Test
  public void testListVersionsOfAccountSettingsTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListVersionsOfAccountSettingsTemplateWOptions();

    iamIdentityService.disableRetries();
    testListVersionsOfAccountSettingsTemplateWOptions();
  }

  // Test the listVersionsOfAccountSettingsTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListVersionsOfAccountSettingsTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.listVersionsOfAccountSettingsTemplate(null).execute();
  }

  // Test the createAccountSettingsTemplateVersion operation with a valid options model parameter
  @Test
  public void testCreateAccountSettingsTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createAccountSettingsTemplateVersionPath = "/v1/account_settings_templates/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the AccountSettingsUserMFA model
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();

    // Construct an instance of the AccountSettingsComponent model
    AccountSettingsComponent accountSettingsComponentModel = new AccountSettingsComponent.Builder()
      .restrictCreateServiceId("NOT_SET")
      .restrictCreatePlatformApikey("NOT_SET")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(accountSettingsUserMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("259200")
      .build();

    // Construct an instance of the CreateAccountSettingsTemplateVersionOptions model
    CreateAccountSettingsTemplateVersionOptions createAccountSettingsTemplateVersionOptionsModel = new CreateAccountSettingsTemplateVersionOptions.Builder()
      .templateId("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .accountSettings(accountSettingsComponentModel)
      .build();

    // Invoke createAccountSettingsTemplateVersion() with a valid options model and verify the result
    Response<AccountSettingsTemplateResponse> response = iamIdentityService.createAccountSettingsTemplateVersion(createAccountSettingsTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountSettingsTemplateVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAccountSettingsTemplateVersion operation with and without retries enabled
  @Test
  public void testCreateAccountSettingsTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateAccountSettingsTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testCreateAccountSettingsTemplateVersionWOptions();
  }

  // Test the createAccountSettingsTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountSettingsTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createAccountSettingsTemplateVersion(null).execute();
  }

  // Test the getAccountSettingsTemplateVersion operation with a valid options model parameter
  @Test
  public void testGetAccountSettingsTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getAccountSettingsTemplateVersionPath = "/v1/account_settings_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountSettingsTemplateVersionOptions model
    GetAccountSettingsTemplateVersionOptions getAccountSettingsTemplateVersionOptionsModel = new GetAccountSettingsTemplateVersionOptions.Builder()
      .templateId("testString")
      .version("testString")
      .includeHistory(false)
      .build();

    // Invoke getAccountSettingsTemplateVersion() with a valid options model and verify the result
    Response<AccountSettingsTemplateResponse> response = iamIdentityService.getAccountSettingsTemplateVersion(getAccountSettingsTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountSettingsTemplateVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getAccountSettingsTemplateVersion operation with and without retries enabled
  @Test
  public void testGetAccountSettingsTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetAccountSettingsTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testGetAccountSettingsTemplateVersionWOptions();
  }

  // Test the getAccountSettingsTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSettingsTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getAccountSettingsTemplateVersion(null).execute();
  }

  // Test the updateAccountSettingsTemplateVersion operation with a valid options model parameter
  @Test
  public void testUpdateAccountSettingsTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"account_settings\": {\"restrict_create_service_id\": \"NOT_SET\", \"restrict_create_platform_apikey\": \"NOT_SET\", \"allowed_ip_addresses\": \"allowedIpAddresses\", \"mfa\": \"NONE\", \"user_mfa\": [{\"iam_id\": \"iamId\", \"mfa\": \"NONE\"}], \"session_expiration_in_seconds\": \"86400\", \"session_invalidation_in_seconds\": \"7200\", \"max_sessions_per_identity\": \"maxSessionsPerIdentity\", \"system_access_token_expiration_in_seconds\": \"3600\", \"system_refresh_token_expiration_in_seconds\": \"259200\"}, \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String updateAccountSettingsTemplateVersionPath = "/v1/account_settings_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the AccountSettingsUserMFA model
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();

    // Construct an instance of the AccountSettingsComponent model
    AccountSettingsComponent accountSettingsComponentModel = new AccountSettingsComponent.Builder()
      .restrictCreateServiceId("NOT_SET")
      .restrictCreatePlatformApikey("NOT_SET")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(accountSettingsUserMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("259200")
      .build();

    // Construct an instance of the UpdateAccountSettingsTemplateVersionOptions model
    UpdateAccountSettingsTemplateVersionOptions updateAccountSettingsTemplateVersionOptionsModel = new UpdateAccountSettingsTemplateVersionOptions.Builder()
      .ifMatch("testString")
      .templateId("testString")
      .version("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .accountSettings(accountSettingsComponentModel)
      .build();

    // Invoke updateAccountSettingsTemplateVersion() with a valid options model and verify the result
    Response<AccountSettingsTemplateResponse> response = iamIdentityService.updateAccountSettingsTemplateVersion(updateAccountSettingsTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    AccountSettingsTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountSettingsTemplateVersionPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAccountSettingsTemplateVersion operation with and without retries enabled
  @Test
  public void testUpdateAccountSettingsTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateAccountSettingsTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testUpdateAccountSettingsTemplateVersionWOptions();
  }

  // Test the updateAccountSettingsTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateAccountSettingsTemplateVersion(null).execute();
  }

  // Test the deleteAccountSettingsTemplateVersion operation with a valid options model parameter
  @Test
  public void testDeleteAccountSettingsTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAccountSettingsTemplateVersionPath = "/v1/account_settings_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAccountSettingsTemplateVersionOptions model
    DeleteAccountSettingsTemplateVersionOptions deleteAccountSettingsTemplateVersionOptionsModel = new DeleteAccountSettingsTemplateVersionOptions.Builder()
      .templateId("testString")
      .version("testString")
      .build();

    // Invoke deleteAccountSettingsTemplateVersion() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteAccountSettingsTemplateVersion(deleteAccountSettingsTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAccountSettingsTemplateVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAccountSettingsTemplateVersion operation with and without retries enabled
  @Test
  public void testDeleteAccountSettingsTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteAccountSettingsTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testDeleteAccountSettingsTemplateVersionWOptions();
  }

  // Test the deleteAccountSettingsTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAccountSettingsTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteAccountSettingsTemplateVersion(null).execute();
  }

  // Test the commitAccountSettingsTemplate operation with a valid options model parameter
  @Test
  public void testCommitAccountSettingsTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String commitAccountSettingsTemplatePath = "/v1/account_settings_templates/testString/versions/testString/commit";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the CommitAccountSettingsTemplateOptions model
    CommitAccountSettingsTemplateOptions commitAccountSettingsTemplateOptionsModel = new CommitAccountSettingsTemplateOptions.Builder()
      .templateId("testString")
      .version("testString")
      .build();

    // Invoke commitAccountSettingsTemplate() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.commitAccountSettingsTemplate(commitAccountSettingsTemplateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, commitAccountSettingsTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the commitAccountSettingsTemplate operation with and without retries enabled
  @Test
  public void testCommitAccountSettingsTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCommitAccountSettingsTemplateWOptions();

    iamIdentityService.disableRetries();
    testCommitAccountSettingsTemplateWOptions();
  }

  // Test the commitAccountSettingsTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCommitAccountSettingsTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.commitAccountSettingsTemplate(null).execute();
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

  // Test the listTrustedProfileAssignments operation with a valid options model parameter
  @Test
  public void testListTrustedProfileAssignmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 5, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"assignments\": [{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}]}";
    String listTrustedProfileAssignmentsPath = "/v1/profile_assignments/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTrustedProfileAssignmentsOptions model
    ListTrustedProfileAssignmentsOptions listTrustedProfileAssignmentsOptionsModel = new ListTrustedProfileAssignmentsOptions.Builder()
      .accountId("testString")
      .templateId("testString")
      .templateVersion("testString")
      .target("testString")
      .targetType("Account")
      .limit(Long.valueOf("20"))
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory(false)
      .build();

    // Invoke listTrustedProfileAssignments() with a valid options model and verify the result
    Response<TemplateAssignmentListResponse> response = iamIdentityService.listTrustedProfileAssignments(listTrustedProfileAssignmentsOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentListResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTrustedProfileAssignmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("template_id"), "testString");
    assertEquals(query.get("template_version"), "testString");
    assertEquals(query.get("target"), "testString");
    assertEquals(query.get("target_type"), "Account");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("20"));
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "created_at");
    assertEquals(query.get("order"), "asc");
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the listTrustedProfileAssignments operation with and without retries enabled
  @Test
  public void testListTrustedProfileAssignmentsWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListTrustedProfileAssignmentsWOptions();

    iamIdentityService.disableRetries();
    testListTrustedProfileAssignmentsWOptions();
  }

  // Test the createTrustedProfileAssignment operation with a valid options model parameter
  @Test
  public void testCreateTrustedProfileAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}";
    String createTrustedProfileAssignmentPath = "/v1/profile_assignments/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateTrustedProfileAssignmentOptions model
    CreateTrustedProfileAssignmentOptions createTrustedProfileAssignmentOptionsModel = new CreateTrustedProfileAssignmentOptions.Builder()
      .templateId("testString")
      .templateVersion(Long.valueOf("1"))
      .targetType("Account")
      .target("testString")
      .build();

    // Invoke createTrustedProfileAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamIdentityService.createTrustedProfileAssignment(createTrustedProfileAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTrustedProfileAssignmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTrustedProfileAssignment operation with and without retries enabled
  @Test
  public void testCreateTrustedProfileAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateTrustedProfileAssignmentWOptions();

    iamIdentityService.disableRetries();
    testCreateTrustedProfileAssignmentWOptions();
  }

  // Test the createTrustedProfileAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTrustedProfileAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createTrustedProfileAssignment(null).execute();
  }

  // Test the getTrustedProfileAssignment operation with a valid options model parameter
  @Test
  public void testGetTrustedProfileAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}";
    String getTrustedProfileAssignmentPath = "/v1/profile_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTrustedProfileAssignmentOptions model
    GetTrustedProfileAssignmentOptions getTrustedProfileAssignmentOptionsModel = new GetTrustedProfileAssignmentOptions.Builder()
      .assignmentId("testString")
      .includeHistory(false)
      .build();

    // Invoke getTrustedProfileAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamIdentityService.getTrustedProfileAssignment(getTrustedProfileAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTrustedProfileAssignmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getTrustedProfileAssignment operation with and without retries enabled
  @Test
  public void testGetTrustedProfileAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetTrustedProfileAssignmentWOptions();

    iamIdentityService.disableRetries();
    testGetTrustedProfileAssignmentWOptions();
  }

  // Test the getTrustedProfileAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTrustedProfileAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getTrustedProfileAssignment(null).execute();
  }

  // Test the deleteTrustedProfileAssignment operation with a valid options model parameter
  @Test
  public void testDeleteTrustedProfileAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"status_code\": \"statusCode\", \"errors\": [{\"code\": \"code\", \"message_code\": \"messageCode\", \"message\": \"message\", \"details\": \"details\"}], \"trace\": \"trace\"}";
    String deleteTrustedProfileAssignmentPath = "/v1/profile_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTrustedProfileAssignmentOptions model
    DeleteTrustedProfileAssignmentOptions deleteTrustedProfileAssignmentOptionsModel = new DeleteTrustedProfileAssignmentOptions.Builder()
      .assignmentId("testString")
      .build();

    // Invoke deleteTrustedProfileAssignment() with a valid options model and verify the result
    Response<ExceptionResponse> response = iamIdentityService.deleteTrustedProfileAssignment(deleteTrustedProfileAssignmentOptionsModel).execute();
    assertNotNull(response);
    ExceptionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTrustedProfileAssignmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTrustedProfileAssignment operation with and without retries enabled
  @Test
  public void testDeleteTrustedProfileAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteTrustedProfileAssignmentWOptions();

    iamIdentityService.disableRetries();
    testDeleteTrustedProfileAssignmentWOptions();
  }

  // Test the deleteTrustedProfileAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTrustedProfileAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteTrustedProfileAssignment(null).execute();
  }

  // Test the updateTrustedProfileAssignment operation with a valid options model parameter
  @Test
  public void testUpdateTrustedProfileAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": 15, \"target_type\": \"targetType\", \"target\": \"target\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"profile\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"account_settings\": {\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}, \"policy_template_refs\": [{\"id\": \"id\", \"version\": \"version\", \"resource_created\": {\"id\": \"id\"}, \"error_message\": {\"name\": \"name\", \"errorCode\": \"errorCode\", \"message\": \"message\", \"statusCode\": \"statusCode\"}, \"status\": \"status\"}]}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"entity_tag\": \"entityTag\"}";
    String updateTrustedProfileAssignmentPath = "/v1/profile_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateTrustedProfileAssignmentOptions model
    UpdateTrustedProfileAssignmentOptions updateTrustedProfileAssignmentOptionsModel = new UpdateTrustedProfileAssignmentOptions.Builder()
      .assignmentId("testString")
      .ifMatch("testString")
      .templateVersion(Long.valueOf("1"))
      .build();

    // Invoke updateTrustedProfileAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamIdentityService.updateTrustedProfileAssignment(updateTrustedProfileAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateTrustedProfileAssignmentPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateTrustedProfileAssignment operation with and without retries enabled
  @Test
  public void testUpdateTrustedProfileAssignmentWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateTrustedProfileAssignmentWOptions();

    iamIdentityService.disableRetries();
    testUpdateTrustedProfileAssignmentWOptions();
  }

  // Test the updateTrustedProfileAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTrustedProfileAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateTrustedProfileAssignment(null).execute();
  }

  // Test the listProfileTemplates operation with a valid options model parameter
  @Test
  public void testListProfileTemplatesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 20, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"profile_templates\": [{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listProfileTemplatesPath = "/v1/profile_templates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListProfileTemplatesOptions model
    ListProfileTemplatesOptions listProfileTemplatesOptionsModel = new ListProfileTemplatesOptions.Builder()
      .accountId("testString")
      .limit("20")
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory("false")
      .build();

    // Invoke listProfileTemplates() with a valid options model and verify the result
    Response<TrustedProfileTemplateList> response = iamIdentityService.listProfileTemplates(listProfileTemplatesOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listProfileTemplatesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("limit"), "20");
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "created_at");
    assertEquals(query.get("order"), "asc");
    assertEquals(query.get("include_history"), "false");
  }

  // Test the listProfileTemplates operation with and without retries enabled
  @Test
  public void testListProfileTemplatesWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListProfileTemplatesWOptions();

    iamIdentityService.disableRetries();
    testListProfileTemplatesWOptions();
  }

  // Test the createProfileTemplate operation with a valid options model parameter
  @Test
  public void testCreateProfileTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createProfileTemplatePath = "/v1/profile_templates";
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

    // Construct an instance of the TrustedProfileTemplateClaimRule model
    TrustedProfileTemplateClaimRule trustedProfileTemplateClaimRuleModel = new TrustedProfileTemplateClaimRule.Builder()
      .name("testString")
      .type("Profile-SAML")
      .realmName("testString")
      .expiration(Long.valueOf("26"))
      .conditions(java.util.Arrays.asList(profileClaimRuleConditionsModel))
      .build();

    // Construct an instance of the ProfileIdentityRequest model
    ProfileIdentityRequest profileIdentityRequestModel = new ProfileIdentityRequest.Builder()
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();

    // Construct an instance of the TemplateProfileComponentRequest model
    TemplateProfileComponentRequest templateProfileComponentRequestModel = new TemplateProfileComponentRequest.Builder()
      .name("testString")
      .description("testString")
      .rules(java.util.Arrays.asList(trustedProfileTemplateClaimRuleModel))
      .identities(java.util.Arrays.asList(profileIdentityRequestModel))
      .build();

    // Construct an instance of the PolicyTemplateReference model
    PolicyTemplateReference policyTemplateReferenceModel = new PolicyTemplateReference.Builder()
      .id("testString")
      .version("testString")
      .build();

    // Construct an instance of the CreateProfileTemplateOptions model
    CreateProfileTemplateOptions createProfileTemplateOptionsModel = new CreateProfileTemplateOptions.Builder()
      .accountId("testString")
      .name("testString")
      .description("testString")
      .profile(templateProfileComponentRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplateReferenceModel))
      .build();

    // Invoke createProfileTemplate() with a valid options model and verify the result
    Response<TrustedProfileTemplateResponse> response = iamIdentityService.createProfileTemplate(createProfileTemplateOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProfileTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createProfileTemplate operation with and without retries enabled
  @Test
  public void testCreateProfileTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateProfileTemplateWOptions();

    iamIdentityService.disableRetries();
    testCreateProfileTemplateWOptions();
  }

  // Test the getLatestProfileTemplateVersion operation with a valid options model parameter
  @Test
  public void testGetLatestProfileTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getLatestProfileTemplateVersionPath = "/v1/profile_templates/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLatestProfileTemplateVersionOptions model
    GetLatestProfileTemplateVersionOptions getLatestProfileTemplateVersionOptionsModel = new GetLatestProfileTemplateVersionOptions.Builder()
      .templateId("testString")
      .includeHistory(false)
      .build();

    // Invoke getLatestProfileTemplateVersion() with a valid options model and verify the result
    Response<TrustedProfileTemplateResponse> response = iamIdentityService.getLatestProfileTemplateVersion(getLatestProfileTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLatestProfileTemplateVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getLatestProfileTemplateVersion operation with and without retries enabled
  @Test
  public void testGetLatestProfileTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetLatestProfileTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testGetLatestProfileTemplateVersionWOptions();
  }

  // Test the getLatestProfileTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLatestProfileTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getLatestProfileTemplateVersion(null).execute();
  }

  // Test the deleteAllVersionsOfProfileTemplate operation with a valid options model parameter
  @Test
  public void testDeleteAllVersionsOfProfileTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAllVersionsOfProfileTemplatePath = "/v1/profile_templates/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAllVersionsOfProfileTemplateOptions model
    DeleteAllVersionsOfProfileTemplateOptions deleteAllVersionsOfProfileTemplateOptionsModel = new DeleteAllVersionsOfProfileTemplateOptions.Builder()
      .templateId("testString")
      .build();

    // Invoke deleteAllVersionsOfProfileTemplate() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteAllVersionsOfProfileTemplate(deleteAllVersionsOfProfileTemplateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAllVersionsOfProfileTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAllVersionsOfProfileTemplate operation with and without retries enabled
  @Test
  public void testDeleteAllVersionsOfProfileTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteAllVersionsOfProfileTemplateWOptions();

    iamIdentityService.disableRetries();
    testDeleteAllVersionsOfProfileTemplateWOptions();
  }

  // Test the deleteAllVersionsOfProfileTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAllVersionsOfProfileTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteAllVersionsOfProfileTemplate(null).execute();
  }

  // Test the listVersionsOfProfileTemplate operation with a valid options model parameter
  @Test
  public void testListVersionsOfProfileTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"context\": {\"transaction_id\": \"transactionId\", \"operation\": \"operation\", \"user_agent\": \"userAgent\", \"url\": \"url\", \"instance_id\": \"instanceId\", \"thread_id\": \"threadId\", \"host\": \"host\", \"start_time\": \"startTime\", \"end_time\": \"endTime\", \"elapsed_time\": \"elapsedTime\", \"cluster_name\": \"clusterName\"}, \"offset\": 6, \"limit\": 20, \"first\": \"first\", \"previous\": \"previous\", \"next\": \"next\", \"profile_templates\": [{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listVersionsOfProfileTemplatePath = "/v1/profile_templates/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListVersionsOfProfileTemplateOptions model
    ListVersionsOfProfileTemplateOptions listVersionsOfProfileTemplateOptionsModel = new ListVersionsOfProfileTemplateOptions.Builder()
      .templateId("testString")
      .limit("20")
      .pagetoken("testString")
      .sort("created_at")
      .order("asc")
      .includeHistory("false")
      .build();

    // Invoke listVersionsOfProfileTemplate() with a valid options model and verify the result
    Response<TrustedProfileTemplateList> response = iamIdentityService.listVersionsOfProfileTemplate(listVersionsOfProfileTemplateOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listVersionsOfProfileTemplatePath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("limit"), "20");
    assertEquals(query.get("pagetoken"), "testString");
    assertEquals(query.get("sort"), "created_at");
    assertEquals(query.get("order"), "asc");
    assertEquals(query.get("include_history"), "false");
  }

  // Test the listVersionsOfProfileTemplate operation with and without retries enabled
  @Test
  public void testListVersionsOfProfileTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testListVersionsOfProfileTemplateWOptions();

    iamIdentityService.disableRetries();
    testListVersionsOfProfileTemplateWOptions();
  }

  // Test the listVersionsOfProfileTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListVersionsOfProfileTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.listVersionsOfProfileTemplate(null).execute();
  }

  // Test the createProfileTemplateVersion operation with a valid options model parameter
  @Test
  public void testCreateProfileTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createProfileTemplateVersionPath = "/v1/profile_templates/testString/versions";
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

    // Construct an instance of the TrustedProfileTemplateClaimRule model
    TrustedProfileTemplateClaimRule trustedProfileTemplateClaimRuleModel = new TrustedProfileTemplateClaimRule.Builder()
      .name("testString")
      .type("Profile-SAML")
      .realmName("testString")
      .expiration(Long.valueOf("26"))
      .conditions(java.util.Arrays.asList(profileClaimRuleConditionsModel))
      .build();

    // Construct an instance of the ProfileIdentityRequest model
    ProfileIdentityRequest profileIdentityRequestModel = new ProfileIdentityRequest.Builder()
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();

    // Construct an instance of the TemplateProfileComponentRequest model
    TemplateProfileComponentRequest templateProfileComponentRequestModel = new TemplateProfileComponentRequest.Builder()
      .name("testString")
      .description("testString")
      .rules(java.util.Arrays.asList(trustedProfileTemplateClaimRuleModel))
      .identities(java.util.Arrays.asList(profileIdentityRequestModel))
      .build();

    // Construct an instance of the PolicyTemplateReference model
    PolicyTemplateReference policyTemplateReferenceModel = new PolicyTemplateReference.Builder()
      .id("testString")
      .version("testString")
      .build();

    // Construct an instance of the CreateProfileTemplateVersionOptions model
    CreateProfileTemplateVersionOptions createProfileTemplateVersionOptionsModel = new CreateProfileTemplateVersionOptions.Builder()
      .templateId("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .profile(templateProfileComponentRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplateReferenceModel))
      .build();

    // Invoke createProfileTemplateVersion() with a valid options model and verify the result
    Response<TrustedProfileTemplateResponse> response = iamIdentityService.createProfileTemplateVersion(createProfileTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createProfileTemplateVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createProfileTemplateVersion operation with and without retries enabled
  @Test
  public void testCreateProfileTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCreateProfileTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testCreateProfileTemplateVersionWOptions();
  }

  // Test the createProfileTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.createProfileTemplateVersion(null).execute();
  }

  // Test the getProfileTemplateVersion operation with a valid options model parameter
  @Test
  public void testGetProfileTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getProfileTemplateVersionPath = "/v1/profile_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetProfileTemplateVersionOptions model
    GetProfileTemplateVersionOptions getProfileTemplateVersionOptionsModel = new GetProfileTemplateVersionOptions.Builder()
      .templateId("testString")
      .version("testString")
      .includeHistory(false)
      .build();

    // Invoke getProfileTemplateVersion() with a valid options model and verify the result
    Response<TrustedProfileTemplateResponse> response = iamIdentityService.getProfileTemplateVersion(getProfileTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getProfileTemplateVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("include_history")), Boolean.valueOf(false));
  }

  // Test the getProfileTemplateVersion operation with and without retries enabled
  @Test
  public void testGetProfileTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testGetProfileTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testGetProfileTemplateVersionWOptions();
  }

  // Test the getProfileTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetProfileTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.getProfileTemplateVersion(null).execute();
  }

  // Test the updateProfileTemplateVersion operation with a valid options model parameter
  @Test
  public void testUpdateProfileTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"version\": 7, \"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"committed\": false, \"profile\": {\"name\": \"name\", \"description\": \"description\", \"rules\": [{\"name\": \"name\", \"type\": \"Profile-SAML\", \"realm_name\": \"realmName\", \"expiration\": 10, \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}]}], \"identities\": [{\"iam_id\": \"iamId\", \"identifier\": \"identifier\", \"type\": \"user\", \"accounts\": [\"accounts\"], \"description\": \"description\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"history\": [{\"timestamp\": \"timestamp\", \"iam_id\": \"iamId\", \"iam_id_account\": \"iamIdAccount\", \"action\": \"action\", \"params\": [\"params\"], \"message\": \"message\"}], \"entity_tag\": \"entityTag\", \"crn\": \"crn\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String updateProfileTemplateVersionPath = "/v1/profile_templates/testString/versions/testString";
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

    // Construct an instance of the TrustedProfileTemplateClaimRule model
    TrustedProfileTemplateClaimRule trustedProfileTemplateClaimRuleModel = new TrustedProfileTemplateClaimRule.Builder()
      .name("testString")
      .type("Profile-SAML")
      .realmName("testString")
      .expiration(Long.valueOf("26"))
      .conditions(java.util.Arrays.asList(profileClaimRuleConditionsModel))
      .build();

    // Construct an instance of the ProfileIdentityRequest model
    ProfileIdentityRequest profileIdentityRequestModel = new ProfileIdentityRequest.Builder()
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();

    // Construct an instance of the TemplateProfileComponentRequest model
    TemplateProfileComponentRequest templateProfileComponentRequestModel = new TemplateProfileComponentRequest.Builder()
      .name("testString")
      .description("testString")
      .rules(java.util.Arrays.asList(trustedProfileTemplateClaimRuleModel))
      .identities(java.util.Arrays.asList(profileIdentityRequestModel))
      .build();

    // Construct an instance of the PolicyTemplateReference model
    PolicyTemplateReference policyTemplateReferenceModel = new PolicyTemplateReference.Builder()
      .id("testString")
      .version("testString")
      .build();

    // Construct an instance of the UpdateProfileTemplateVersionOptions model
    UpdateProfileTemplateVersionOptions updateProfileTemplateVersionOptionsModel = new UpdateProfileTemplateVersionOptions.Builder()
      .ifMatch("testString")
      .templateId("testString")
      .version("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .profile(templateProfileComponentRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplateReferenceModel))
      .build();

    // Invoke updateProfileTemplateVersion() with a valid options model and verify the result
    Response<TrustedProfileTemplateResponse> response = iamIdentityService.updateProfileTemplateVersion(updateProfileTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TrustedProfileTemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateProfileTemplateVersionPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateProfileTemplateVersion operation with and without retries enabled
  @Test
  public void testUpdateProfileTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testUpdateProfileTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testUpdateProfileTemplateVersionWOptions();
  }

  // Test the updateProfileTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateProfileTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.updateProfileTemplateVersion(null).execute();
  }

  // Test the deleteProfileTemplateVersion operation with a valid options model parameter
  @Test
  public void testDeleteProfileTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteProfileTemplateVersionPath = "/v1/profile_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteProfileTemplateVersionOptions model
    DeleteProfileTemplateVersionOptions deleteProfileTemplateVersionOptionsModel = new DeleteProfileTemplateVersionOptions.Builder()
      .templateId("testString")
      .version("testString")
      .build();

    // Invoke deleteProfileTemplateVersion() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.deleteProfileTemplateVersion(deleteProfileTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteProfileTemplateVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteProfileTemplateVersion operation with and without retries enabled
  @Test
  public void testDeleteProfileTemplateVersionWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testDeleteProfileTemplateVersionWOptions();

    iamIdentityService.disableRetries();
    testDeleteProfileTemplateVersionWOptions();
  }

  // Test the deleteProfileTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteProfileTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.deleteProfileTemplateVersion(null).execute();
  }

  // Test the commitProfileTemplate operation with a valid options model parameter
  @Test
  public void testCommitProfileTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String commitProfileTemplatePath = "/v1/profile_templates/testString/versions/testString/commit";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the CommitProfileTemplateOptions model
    CommitProfileTemplateOptions commitProfileTemplateOptionsModel = new CommitProfileTemplateOptions.Builder()
      .templateId("testString")
      .version("testString")
      .build();

    // Invoke commitProfileTemplate() with a valid options model and verify the result
    Response<Void> response = iamIdentityService.commitProfileTemplate(commitProfileTemplateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, commitProfileTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the commitProfileTemplate operation with and without retries enabled
  @Test
  public void testCommitProfileTemplateWRetries() throws Throwable {
    iamIdentityService.enableRetries(4, 30);
    testCommitProfileTemplateWOptions();

    iamIdentityService.disableRetries();
    testCommitProfileTemplateWOptions();
  }

  // Test the commitProfileTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCommitProfileTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamIdentityService.commitProfileTemplate(null).execute();
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