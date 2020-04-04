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
package com.ibm.cloud.platform_services.iam_access_groups.v2;

import com.ibm.cloud.platform_services.iam_access_groups.v2.IamAccessGroups;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponseMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembersToAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponseGroupsItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponseGroupsItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponseMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Error;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupMembersList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupsList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.HrefStruct;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.IsMemberOfAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupMembersOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupRulesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListGroupMembersResponseMember;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAllAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMembersFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ReplaceAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Rule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleConditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
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
 * Unit test class for the IamAccessGroups service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class IamAccessGroupsTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  protected MockWebServer server;
  protected IamAccessGroups testService;

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

    testService = IamAccessGroups.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IamAccessGroups(serviceName, null);
  }

  @Test
  public void testCreateAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}";
    String createAccessGroupPath = "/groups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateAccessGroupOptions model
    CreateAccessGroupOptions createAccessGroupOptionsModel = new CreateAccessGroupOptions.Builder()
    .accountId("testString")
    .name("testString")
    .description("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Group> response = testService.createAccessGroup(createAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Group responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccessGroupPath);
  }

  // Test the createAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createAccessGroup(null).execute();
  }

  @Test
  public void testListAccessGroupsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"groups\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}]}";
    String listAccessGroupsPath = "/groups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAccessGroupsOptions model
    ListAccessGroupsOptions listAccessGroupsOptionsModel = new ListAccessGroupsOptions.Builder()
    .accountId("testString")
    .transactionId("testString")
    .iamId("testString")
    .limit(Long.valueOf("26"))
    .offset(Long.valueOf("26"))
    .sort("testString")
    .showFederated(true)
    .hidePublicAccess(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GroupsList> response = testService.listAccessGroups(listAccessGroupsOptionsModel).execute();
    assertNotNull(response);
    GroupsList responseObj = response.getResult();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("sort"), "testString");
    assertEquals(Boolean.valueOf(query.get("show_federated")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("hide_public_access")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccessGroupsPath);
  }

  // Test the listAccessGroups operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listAccessGroups(null).execute();
  }

  @Test
  public void testGetAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}";
    String getAccessGroupPath = "/groups/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccessGroupOptions model
    GetAccessGroupOptions getAccessGroupOptionsModel = new GetAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .transactionId("testString")
    .showFederated(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Group> response = testService.getAccessGroup(getAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Group responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("show_federated")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccessGroupPath);
  }

  // Test the getAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAccessGroup(null).execute();
  }

  @Test
  public void testUpdateAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}";
    String updateAccessGroupPath = "/groups/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateAccessGroupOptions model
    UpdateAccessGroupOptions updateAccessGroupOptionsModel = new UpdateAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .ifMatch("testString")
    .name("testString")
    .description("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Group> response = testService.updateAccessGroup(updateAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Group responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccessGroupPath);
  }

  // Test the updateAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateAccessGroup(null).execute();
  }

  @Test
  public void testDeleteAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteAccessGroupPath = "/groups/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteAccessGroupOptions model
    DeleteAccessGroupOptions deleteAccessGroupOptionsModel = new DeleteAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .transactionId("testString")
    .force(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteAccessGroup(deleteAccessGroupOptionsModel).execute();
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
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAccessGroupPath);
  }

  // Test the deleteAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteAccessGroup(null).execute();
  }

  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"public_access_enabled\": false}";
    String getAccountSettingsPath = "/groups/settings";

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
    Response<AccountSettings> response = testService.getAccountSettings(getAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettings responseObj = response.getResult();
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
    testService.getAccountSettings(null).execute();
  }

  @Test
  public void testUpdateAccountSettingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\", \"public_access_enabled\": false}";
    String updateAccountSettingsPath = "/groups/settings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateAccountSettingsOptions model
    UpdateAccountSettingsOptions updateAccountSettingsOptionsModel = new UpdateAccountSettingsOptions.Builder()
    .accountId("testString")
    .publicAccessEnabled(true)
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountSettings> response = testService.updateAccountSettings(updateAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
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
    testService.updateAccountSettings(null).execute();
  }

  @Test
  public void testIsMemberOfAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String isMemberOfAccessGroupPath = "/groups/testString/members/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the IsMemberOfAccessGroupOptions model
    IsMemberOfAccessGroupOptions isMemberOfAccessGroupOptionsModel = new IsMemberOfAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .iamId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.isMemberOfAccessGroup(isMemberOfAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, isMemberOfAccessGroupPath);
  }

  // Test the isMemberOfAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIsMemberOfAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.isMemberOfAccessGroup(null).execute();
  }

  @Test
  public void testAddMembersToAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"members\": [{\"iam_id\": \"iamId\", \"type\": \"type\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"status_code\": 10, \"trace\": \"trace\", \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String addMembersToAccessGroupPath = "/groups/testString/members";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(207)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddGroupMembersRequestMembersItem model
    AddGroupMembersRequestMembersItem addGroupMembersRequestMembersItemModel = new AddGroupMembersRequestMembersItem.Builder()
    .iamId("testString")
    .type("testString")
    .build();

    // Construct an instance of the AddMembersToAccessGroupOptions model
    AddMembersToAccessGroupOptions addMembersToAccessGroupOptionsModel = new AddMembersToAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .members(new ArrayList<AddGroupMembersRequestMembersItem>(Arrays.asList(addGroupMembersRequestMembersItemModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AddGroupMembersResponse> response = testService.addMembersToAccessGroup(addMembersToAccessGroupOptionsModel).execute();
    assertNotNull(response);
    AddGroupMembersResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, addMembersToAccessGroupPath);
  }

  // Test the addMembersToAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddMembersToAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.addMembersToAccessGroup(null).execute();
  }

  @Test
  public void testListAccessGroupMembersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"members\": [{\"iam_id\": \"iamId\", \"type\": \"type\", \"name\": \"name\", \"email\": \"email\", \"description\": \"description\", \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\"}]}";
    String listAccessGroupMembersPath = "/groups/testString/members";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAccessGroupMembersOptions model
    ListAccessGroupMembersOptions listAccessGroupMembersOptionsModel = new ListAccessGroupMembersOptions.Builder()
    .accessGroupId("testString")
    .transactionId("testString")
    .limit(Double.valueOf("72.5"))
    .offset(Double.valueOf("72.5"))
    .type("testString")
    .verbose(true)
    .sort("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<GroupMembersList> response = testService.listAccessGroupMembers(listAccessGroupMembersOptionsModel).execute();
    assertNotNull(response);
    GroupMembersList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Double.valueOf(query.get("limit")), Double.valueOf("72.5"));
    assertEquals(Double.valueOf(query.get("offset")), Double.valueOf("72.5"));
    assertEquals(query.get("type"), "testString");
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(true));
    assertEquals(query.get("sort"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccessGroupMembersPath);
  }

  // Test the listAccessGroupMembers operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupMembersNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listAccessGroupMembers(null).execute();
  }

  @Test
  public void testRemoveMemberFromAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String removeMemberFromAccessGroupPath = "/groups/testString/members/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RemoveMemberFromAccessGroupOptions model
    RemoveMemberFromAccessGroupOptions removeMemberFromAccessGroupOptionsModel = new RemoveMemberFromAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .iamId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.removeMemberFromAccessGroup(removeMemberFromAccessGroupOptionsModel).execute();
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
    assertEquals(parsedPath, removeMemberFromAccessGroupPath);
  }

  // Test the removeMemberFromAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveMemberFromAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.removeMemberFromAccessGroup(null).execute();
  }

  @Test
  public void testRemoveMembersFromAccessGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"access_group_id\": \"accessGroupId\", \"members\": [{\"iam_id\": \"iamId\", \"trace\": \"trace\", \"status_code\": 10, \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String removeMembersFromAccessGroupPath = "/groups/testString/members/delete";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(207)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RemoveMembersFromAccessGroupOptions model
    RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptionsModel = new RemoveMembersFromAccessGroupOptions.Builder()
    .accessGroupId("testString")
    .members(new ArrayList<String>(Arrays.asList("testString")))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteGroupBulkMembersResponse> response = testService.removeMembersFromAccessGroup(removeMembersFromAccessGroupOptionsModel).execute();
    assertNotNull(response);
    DeleteGroupBulkMembersResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, removeMembersFromAccessGroupPath);
  }

  // Test the removeMembersFromAccessGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveMembersFromAccessGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.removeMembersFromAccessGroup(null).execute();
  }

  @Test
  public void testRemoveMemberFromAllAccessGroupsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"groups\": [{\"access_group_id\": \"accessGroupId\", \"status_code\": 10, \"trace\": \"trace\", \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String removeMemberFromAllAccessGroupsPath = "/groups/_allgroups/members/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(207)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RemoveMemberFromAllAccessGroupsOptions model
    RemoveMemberFromAllAccessGroupsOptions removeMemberFromAllAccessGroupsOptionsModel = new RemoveMemberFromAllAccessGroupsOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeleteFromAllGroupsResponse> response = testService.removeMemberFromAllAccessGroups(removeMemberFromAllAccessGroupsOptionsModel).execute();
    assertNotNull(response);
    DeleteFromAllGroupsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeMemberFromAllAccessGroupsPath);
  }

  // Test the removeMemberFromAllAccessGroups operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveMemberFromAllAccessGroupsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.removeMemberFromAllAccessGroups(null).execute();
  }

  @Test
  public void testAddMemberToMultipleAccessGroupsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"groups\": [{\"access_group_id\": \"accessGroupId\", \"status_code\": 10, \"trace\": \"trace\", \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String addMemberToMultipleAccessGroupsPath = "/groups/_allgroups/members/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(207)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddMemberToMultipleAccessGroupsOptions model
    AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptionsModel = new AddMemberToMultipleAccessGroupsOptions.Builder()
    .accountId("testString")
    .iamId("testString")
    .type("testString")
    .groups(new ArrayList<String>(Arrays.asList("testString")))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AddMembershipMultipleGroupsResponse> response = testService.addMemberToMultipleAccessGroups(addMemberToMultipleAccessGroupsOptionsModel).execute();
    assertNotNull(response);
    AddMembershipMultipleGroupsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addMemberToMultipleAccessGroupsPath);
  }

  // Test the addMemberToMultipleAccessGroups operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddMemberToMultipleAccessGroupsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.addMemberToMultipleAccessGroups(null).execute();
  }

  @Test
  public void testAddAccessGroupRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String addAccessGroupRulePath = "/groups/testString/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleConditions model
    RuleConditions ruleConditionsModel = new RuleConditions.Builder()
    .claim("testString")
    .operator("testString")
    .value("testString")
    .build();

    // Construct an instance of the AddAccessGroupRuleOptions model
    AddAccessGroupRuleOptions addAccessGroupRuleOptionsModel = new AddAccessGroupRuleOptions.Builder()
    .accessGroupId("testString")
    .expiration(Long.valueOf("26"))
    .realmName("testString")
    .conditions(new ArrayList<RuleConditions>(Arrays.asList(ruleConditionsModel)))
    .name("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = testService.addAccessGroupRule(addAccessGroupRuleOptionsModel).execute();
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
    assertEquals(parsedPath, addAccessGroupRulePath);
  }

  // Test the addAccessGroupRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddAccessGroupRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.addAccessGroupRule(null).execute();
  }

  @Test
  public void testListAccessGroupRulesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rules\": [{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listAccessGroupRulesPath = "/groups/testString/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAccessGroupRulesOptions model
    ListAccessGroupRulesOptions listAccessGroupRulesOptionsModel = new ListAccessGroupRulesOptions.Builder()
    .accessGroupId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RulesList> response = testService.listAccessGroupRules(listAccessGroupRulesOptionsModel).execute();
    assertNotNull(response);
    RulesList responseObj = response.getResult();
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
    assertEquals(parsedPath, listAccessGroupRulesPath);
  }

  // Test the listAccessGroupRules operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupRulesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listAccessGroupRules(null).execute();
  }

  @Test
  public void testGetAccessGroupRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getAccessGroupRulePath = "/groups/testString/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccessGroupRuleOptions model
    GetAccessGroupRuleOptions getAccessGroupRuleOptionsModel = new GetAccessGroupRuleOptions.Builder()
    .accessGroupId("testString")
    .ruleId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = testService.getAccessGroupRule(getAccessGroupRuleOptionsModel).execute();
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
    assertEquals(parsedPath, getAccessGroupRulePath);
  }

  // Test the getAccessGroupRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccessGroupRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAccessGroupRule(null).execute();
  }

  @Test
  public void testReplaceAccessGroupRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String replaceAccessGroupRulePath = "/groups/testString/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleConditions model
    RuleConditions ruleConditionsModel = new RuleConditions.Builder()
    .claim("testString")
    .operator("testString")
    .value("testString")
    .build();

    // Construct an instance of the ReplaceAccessGroupRuleOptions model
    ReplaceAccessGroupRuleOptions replaceAccessGroupRuleOptionsModel = new ReplaceAccessGroupRuleOptions.Builder()
    .accessGroupId("testString")
    .ruleId("testString")
    .ifMatch("testString")
    .expiration(Long.valueOf("26"))
    .realmName("testString")
    .conditions(new ArrayList<RuleConditions>(Arrays.asList(ruleConditionsModel)))
    .name("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = testService.replaceAccessGroupRule(replaceAccessGroupRuleOptionsModel).execute();
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
    assertEquals(parsedPath, replaceAccessGroupRulePath);
  }

  // Test the replaceAccessGroupRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceAccessGroupRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceAccessGroupRule(null).execute();
  }

  @Test
  public void testRemoveAccessGroupRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String removeAccessGroupRulePath = "/groups/testString/rules/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RemoveAccessGroupRuleOptions model
    RemoveAccessGroupRuleOptions removeAccessGroupRuleOptionsModel = new RemoveAccessGroupRuleOptions.Builder()
    .accessGroupId("testString")
    .ruleId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.removeAccessGroupRule(removeAccessGroupRuleOptionsModel).execute();
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
    assertEquals(parsedPath, removeAccessGroupRulePath);
  }

  // Test the removeAccessGroupRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveAccessGroupRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.removeAccessGroupRule(null).execute();
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