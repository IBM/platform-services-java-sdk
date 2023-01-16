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
package com.ibm.cloud.platform_services.iam_access_groups.v2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupMembersPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembersToAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupMembersList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupsList;
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
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * Unit test class for the IamAccessGroups service.
 */
public class IamAccessGroupsTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IamAccessGroups iamAccessGroupsService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new IamAccessGroups(serviceName, null);
  }

  // Test the createAccessGroup operation with a valid options model parameter
  @Test
  public void testCreateAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}";
    String createAccessGroupPath = "/v2/groups";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateAccessGroupOptions model
    CreateAccessGroupOptions createAccessGroupOptionsModel = new CreateAccessGroupOptions.Builder()
      .accountId("testString")
      .name("Managers")
      .description("Group for managers")
      .transactionId("testString")
      .build();

    // Invoke createAccessGroup() with a valid options model and verify the result
    Response<Group> response = iamAccessGroupsService.createAccessGroup(createAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Group responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccessGroupPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the createAccessGroup operation with and without retries enabled
  @Test
  public void testCreateAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testCreateAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testCreateAccessGroupWOptions();
  }

  // Test the createAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.createAccessGroup(null).execute();
  }

  // Test the listAccessGroups operation with a valid options model parameter
  @Test
  public void testListAccessGroupsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"groups\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}]}";
    String listAccessGroupsPath = "/v2/groups";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccessGroupsOptions model
    ListAccessGroupsOptions listAccessGroupsOptionsModel = new ListAccessGroupsOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .iamId("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .offset(Long.valueOf("26"))
      .sort("name")
      .showFederated(false)
      .hidePublicAccess(false)
      .build();

    // Invoke listAccessGroups() with a valid options model and verify the result
    Response<GroupsList> response = iamAccessGroupsService.listAccessGroups(listAccessGroupsOptionsModel).execute();
    assertNotNull(response);
    GroupsList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccessGroupsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("iam_id"), "testString");
    assertEquals(query.get("membership_type"), "static");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("sort"), "name");
    assertEquals(Boolean.valueOf(query.get("show_federated")), Boolean.valueOf(false));
    assertEquals(Boolean.valueOf(query.get("hide_public_access")), Boolean.valueOf(false));
  }

  // Test the listAccessGroups operation with and without retries enabled
  @Test
  public void testListAccessGroupsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testListAccessGroupsWOptions();

    iamAccessGroupsService.disableRetries();
    testListAccessGroupsWOptions();
  }

  // Test the listAccessGroups operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.listAccessGroups(null).execute();
  }

  // Test the listAccessGroups operation using the AccessGroupsPager.getNext() method
  @Test
  public void testListAccessGroupsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"limit\":1,\"groups\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\",\"href\":\"href\",\"is_federated\":false}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"groups\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\",\"href\":\"href\",\"is_federated\":false}]}";
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

    ListAccessGroupsOptions listAccessGroupsOptions = new ListAccessGroupsOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .iamId("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .sort("name")
      .showFederated(false)
      .hidePublicAccess(false)
      .build();

    List<Group> allResults = new ArrayList<>();
    AccessGroupsPager pager = new AccessGroupsPager(iamAccessGroupsService, listAccessGroupsOptions);
    while (pager.hasNext()) {
      List<Group> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }

  // Test the listAccessGroups operation using the AccessGroupsPager.getAll() method
  @Test
  public void testListAccessGroupsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"limit\":1,\"groups\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\",\"href\":\"href\",\"is_federated\":false}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"groups\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\",\"href\":\"href\",\"is_federated\":false}]}";
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

    ListAccessGroupsOptions listAccessGroupsOptions = new ListAccessGroupsOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .iamId("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .sort("name")
      .showFederated(false)
      .hidePublicAccess(false)
      .build();

    AccessGroupsPager pager = new AccessGroupsPager(iamAccessGroupsService, listAccessGroupsOptions);
    List<Group> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }

  // Test the getAccessGroup operation with a valid options model parameter
  @Test
  public void testGetAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}";
    String getAccessGroupPath = "/v2/groups/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccessGroupOptions model
    GetAccessGroupOptions getAccessGroupOptionsModel = new GetAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .showFederated(false)
      .build();

    // Invoke getAccessGroup() with a valid options model and verify the result
    Response<Group> response = iamAccessGroupsService.getAccessGroup(getAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Group responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccessGroupPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("show_federated")), Boolean.valueOf(false));
  }

  // Test the getAccessGroup operation with and without retries enabled
  @Test
  public void testGetAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testGetAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testGetAccessGroupWOptions();
  }

  // Test the getAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.getAccessGroup(null).execute();
  }

  // Test the updateAccessGroup operation with a valid options model parameter
  @Test
  public void testUpdateAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\", \"is_federated\": false}";
    String updateAccessGroupPath = "/v2/groups/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateAccessGroupOptions model
    UpdateAccessGroupOptions updateAccessGroupOptionsModel = new UpdateAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .ifMatch("testString")
      .name("Awesome Managers")
      .description("Group for awesome managers.")
      .transactionId("testString")
      .build();

    // Invoke updateAccessGroup() with a valid options model and verify the result
    Response<Group> response = iamAccessGroupsService.updateAccessGroup(updateAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Group responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccessGroupPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAccessGroup operation with and without retries enabled
  @Test
  public void testUpdateAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testUpdateAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testUpdateAccessGroupWOptions();
  }

  // Test the updateAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.updateAccessGroup(null).execute();
  }

  // Test the deleteAccessGroup operation with a valid options model parameter
  @Test
  public void testDeleteAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAccessGroupPath = "/v2/groups/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAccessGroupOptions model
    DeleteAccessGroupOptions deleteAccessGroupOptionsModel = new DeleteAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .force(false)
      .build();

    // Invoke deleteAccessGroup() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.deleteAccessGroup(deleteAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAccessGroupPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(false));
  }

  // Test the deleteAccessGroup operation with and without retries enabled
  @Test
  public void testDeleteAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testDeleteAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testDeleteAccessGroupWOptions();
  }

  // Test the deleteAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.deleteAccessGroup(null).execute();
  }

  // Test the isMemberOfAccessGroup operation with a valid options model parameter
  @Test
  public void testIsMemberOfAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String isMemberOfAccessGroupPath = "/v2/groups/testString/members/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the IsMemberOfAccessGroupOptions model
    IsMemberOfAccessGroupOptions isMemberOfAccessGroupOptionsModel = new IsMemberOfAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .iamId("testString")
      .transactionId("testString")
      .build();

    // Invoke isMemberOfAccessGroup() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.isMemberOfAccessGroup(isMemberOfAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "HEAD");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, isMemberOfAccessGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the isMemberOfAccessGroup operation with and without retries enabled
  @Test
  public void testIsMemberOfAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testIsMemberOfAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testIsMemberOfAccessGroupWOptions();
  }

  // Test the isMemberOfAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIsMemberOfAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.isMemberOfAccessGroup(null).execute();
  }

  // Test the addMembersToAccessGroup operation with a valid options model parameter
  @Test
  public void testAddMembersToAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"members\": [{\"iam_id\": \"iamId\", \"type\": \"type\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"status_code\": 10, \"trace\": \"trace\", \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String addMembersToAccessGroupPath = "/v2/groups/testString/members";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(207)
      .setBody(mockResponseBody));

    // Construct an instance of the AddGroupMembersRequestMembersItem model
    AddGroupMembersRequestMembersItem addGroupMembersRequestMembersItemModel = new AddGroupMembersRequestMembersItem.Builder()
      .iamId("IBMid-user1")
      .type("user")
      .build();

    // Construct an instance of the AddMembersToAccessGroupOptions model
    AddMembersToAccessGroupOptions addMembersToAccessGroupOptionsModel = new AddMembersToAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .members(java.util.Arrays.asList(addGroupMembersRequestMembersItemModel))
      .transactionId("testString")
      .build();

    // Invoke addMembersToAccessGroup() with a valid options model and verify the result
    Response<AddGroupMembersResponse> response = iamAccessGroupsService.addMembersToAccessGroup(addMembersToAccessGroupOptionsModel).execute();
    assertNotNull(response);
    AddGroupMembersResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addMembersToAccessGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addMembersToAccessGroup operation with and without retries enabled
  @Test
  public void testAddMembersToAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testAddMembersToAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testAddMembersToAccessGroupWOptions();
  }

  // Test the addMembersToAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddMembersToAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.addMembersToAccessGroup(null).execute();
  }

  // Test the listAccessGroupMembers operation with a valid options model parameter
  @Test
  public void testListAccessGroupMembersWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"members\": [{\"iam_id\": \"iamId\", \"type\": \"type\", \"membership_type\": \"membershipType\", \"name\": \"name\", \"email\": \"email\", \"description\": \"description\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\"}]}";
    String listAccessGroupMembersPath = "/v2/groups/testString/members";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccessGroupMembersOptions model
    ListAccessGroupMembersOptions listAccessGroupMembersOptionsModel = new ListAccessGroupMembersOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .offset(Long.valueOf("26"))
      .type("testString")
      .verbose(false)
      .sort("testString")
      .build();

    // Invoke listAccessGroupMembers() with a valid options model and verify the result
    Response<GroupMembersList> response = iamAccessGroupsService.listAccessGroupMembers(listAccessGroupMembersOptionsModel).execute();
    assertNotNull(response);
    GroupMembersList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccessGroupMembersPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("membership_type"), "static");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("type"), "testString");
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(false));
    assertEquals(query.get("sort"), "testString");
  }

  // Test the listAccessGroupMembers operation with and without retries enabled
  @Test
  public void testListAccessGroupMembersWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testListAccessGroupMembersWOptions();

    iamAccessGroupsService.disableRetries();
    testListAccessGroupMembersWOptions();
  }

  // Test the listAccessGroupMembers operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupMembersNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.listAccessGroupMembers(null).execute();
  }

  // Test the listAccessGroupMembers operation using the AccessGroupMembersPager.getNext() method
  @Test
  public void testListAccessGroupMembersWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"members\":[{\"iam_id\":\"iamId\",\"type\":\"type\",\"membership_type\":\"membershipType\",\"name\":\"name\",\"email\":\"email\",\"description\":\"description\",\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\"}],\"limit\":1}";
    String mockResponsePage2 = "{\"total_count\":2,\"members\":[{\"iam_id\":\"iamId\",\"type\":\"type\",\"membership_type\":\"membershipType\",\"name\":\"name\",\"email\":\"email\",\"description\":\"description\",\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\"}],\"limit\":1}";
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

    ListAccessGroupMembersOptions listAccessGroupMembersOptions = new ListAccessGroupMembersOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .type("testString")
      .verbose(false)
      .sort("testString")
      .build();

    List<ListGroupMembersResponseMember> allResults = new ArrayList<>();
    AccessGroupMembersPager pager = new AccessGroupMembersPager(iamAccessGroupsService, listAccessGroupMembersOptions);
    while (pager.hasNext()) {
      List<ListGroupMembersResponseMember> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }

  // Test the listAccessGroupMembers operation using the AccessGroupMembersPager.getAll() method
  @Test
  public void testListAccessGroupMembersWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"members\":[{\"iam_id\":\"iamId\",\"type\":\"type\",\"membership_type\":\"membershipType\",\"name\":\"name\",\"email\":\"email\",\"description\":\"description\",\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\"}],\"limit\":1}";
    String mockResponsePage2 = "{\"total_count\":2,\"members\":[{\"iam_id\":\"iamId\",\"type\":\"type\",\"membership_type\":\"membershipType\",\"name\":\"name\",\"email\":\"email\",\"description\":\"description\",\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\"}],\"limit\":1}";
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

    ListAccessGroupMembersOptions listAccessGroupMembersOptions = new ListAccessGroupMembersOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .type("testString")
      .verbose(false)
      .sort("testString")
      .build();

    AccessGroupMembersPager pager = new AccessGroupMembersPager(iamAccessGroupsService, listAccessGroupMembersOptions);
    List<ListGroupMembersResponseMember> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }

  // Test the removeMemberFromAccessGroup operation with a valid options model parameter
  @Test
  public void testRemoveMemberFromAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String removeMemberFromAccessGroupPath = "/v2/groups/testString/members/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the RemoveMemberFromAccessGroupOptions model
    RemoveMemberFromAccessGroupOptions removeMemberFromAccessGroupOptionsModel = new RemoveMemberFromAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .iamId("testString")
      .transactionId("testString")
      .build();

    // Invoke removeMemberFromAccessGroup() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.removeMemberFromAccessGroup(removeMemberFromAccessGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeMemberFromAccessGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the removeMemberFromAccessGroup operation with and without retries enabled
  @Test
  public void testRemoveMemberFromAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testRemoveMemberFromAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testRemoveMemberFromAccessGroupWOptions();
  }

  // Test the removeMemberFromAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveMemberFromAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.removeMemberFromAccessGroup(null).execute();
  }

  // Test the removeMembersFromAccessGroup operation with a valid options model parameter
  @Test
  public void testRemoveMembersFromAccessGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"access_group_id\": \"accessGroupId\", \"members\": [{\"iam_id\": \"iamId\", \"trace\": \"trace\", \"status_code\": 10, \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String removeMembersFromAccessGroupPath = "/v2/groups/testString/members/delete";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(207)
      .setBody(mockResponseBody));

    // Construct an instance of the RemoveMembersFromAccessGroupOptions model
    RemoveMembersFromAccessGroupOptions removeMembersFromAccessGroupOptionsModel = new RemoveMembersFromAccessGroupOptions.Builder()
      .accessGroupId("testString")
      .members(java.util.Arrays.asList("IBMId-user1", "iam-ServiceId-123", "iam-Profile-123"))
      .transactionId("testString")
      .build();

    // Invoke removeMembersFromAccessGroup() with a valid options model and verify the result
    Response<DeleteGroupBulkMembersResponse> response = iamAccessGroupsService.removeMembersFromAccessGroup(removeMembersFromAccessGroupOptionsModel).execute();
    assertNotNull(response);
    DeleteGroupBulkMembersResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeMembersFromAccessGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the removeMembersFromAccessGroup operation with and without retries enabled
  @Test
  public void testRemoveMembersFromAccessGroupWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testRemoveMembersFromAccessGroupWOptions();

    iamAccessGroupsService.disableRetries();
    testRemoveMembersFromAccessGroupWOptions();
  }

  // Test the removeMembersFromAccessGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveMembersFromAccessGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.removeMembersFromAccessGroup(null).execute();
  }

  // Test the removeMemberFromAllAccessGroups operation with a valid options model parameter
  @Test
  public void testRemoveMemberFromAllAccessGroupsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"groups\": [{\"access_group_id\": \"accessGroupId\", \"status_code\": 10, \"trace\": \"trace\", \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String removeMemberFromAllAccessGroupsPath = "/v2/groups/_allgroups/members/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(207)
      .setBody(mockResponseBody));

    // Construct an instance of the RemoveMemberFromAllAccessGroupsOptions model
    RemoveMemberFromAllAccessGroupsOptions removeMemberFromAllAccessGroupsOptionsModel = new RemoveMemberFromAllAccessGroupsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .transactionId("testString")
      .build();

    // Invoke removeMemberFromAllAccessGroups() with a valid options model and verify the result
    Response<DeleteFromAllGroupsResponse> response = iamAccessGroupsService.removeMemberFromAllAccessGroups(removeMemberFromAllAccessGroupsOptionsModel).execute();
    assertNotNull(response);
    DeleteFromAllGroupsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeMemberFromAllAccessGroupsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the removeMemberFromAllAccessGroups operation with and without retries enabled
  @Test
  public void testRemoveMemberFromAllAccessGroupsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testRemoveMemberFromAllAccessGroupsWOptions();

    iamAccessGroupsService.disableRetries();
    testRemoveMemberFromAllAccessGroupsWOptions();
  }

  // Test the removeMemberFromAllAccessGroups operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveMemberFromAllAccessGroupsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.removeMemberFromAllAccessGroups(null).execute();
  }

  // Test the addMemberToMultipleAccessGroups operation with a valid options model parameter
  @Test
  public void testAddMemberToMultipleAccessGroupsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"iam_id\": \"iamId\", \"groups\": [{\"access_group_id\": \"accessGroupId\", \"status_code\": 10, \"trace\": \"trace\", \"errors\": [{\"code\": \"code\", \"message\": \"message\"}]}]}";
    String addMemberToMultipleAccessGroupsPath = "/v2/groups/_allgroups/members/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(207)
      .setBody(mockResponseBody));

    // Construct an instance of the AddMemberToMultipleAccessGroupsOptions model
    AddMemberToMultipleAccessGroupsOptions addMemberToMultipleAccessGroupsOptionsModel = new AddMemberToMultipleAccessGroupsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .type("user")
      .groups(java.util.Arrays.asList("access-group-id-1"))
      .transactionId("testString")
      .build();

    // Invoke addMemberToMultipleAccessGroups() with a valid options model and verify the result
    Response<AddMembershipMultipleGroupsResponse> response = iamAccessGroupsService.addMemberToMultipleAccessGroups(addMemberToMultipleAccessGroupsOptionsModel).execute();
    assertNotNull(response);
    AddMembershipMultipleGroupsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addMemberToMultipleAccessGroupsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the addMemberToMultipleAccessGroups operation with and without retries enabled
  @Test
  public void testAddMemberToMultipleAccessGroupsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testAddMemberToMultipleAccessGroupsWOptions();

    iamAccessGroupsService.disableRetries();
    testAddMemberToMultipleAccessGroupsWOptions();
  }

  // Test the addMemberToMultipleAccessGroups operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddMemberToMultipleAccessGroupsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.addMemberToMultipleAccessGroups(null).execute();
  }

  // Test the addAccessGroupRule operation with a valid options model parameter
  @Test
  public void testAddAccessGroupRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"EQUALS\", \"value\": \"value\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String addAccessGroupRulePath = "/v2/groups/testString/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the RuleConditions model
    RuleConditions ruleConditionsModel = new RuleConditions.Builder()
      .claim("isManager")
      .operator("EQUALS")
      .value("true")
      .build();

    // Construct an instance of the AddAccessGroupRuleOptions model
    AddAccessGroupRuleOptions addAccessGroupRuleOptionsModel = new AddAccessGroupRuleOptions.Builder()
      .accessGroupId("testString")
      .expiration(Long.valueOf("12"))
      .realmName("https://idp.example.org/SAML2")
      .conditions(java.util.Arrays.asList(ruleConditionsModel))
      .name("Manager group rule")
      .transactionId("testString")
      .build();

    // Invoke addAccessGroupRule() with a valid options model and verify the result
    Response<Rule> response = iamAccessGroupsService.addAccessGroupRule(addAccessGroupRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, addAccessGroupRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the addAccessGroupRule operation with and without retries enabled
  @Test
  public void testAddAccessGroupRuleWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testAddAccessGroupRuleWOptions();

    iamAccessGroupsService.disableRetries();
    testAddAccessGroupRuleWOptions();
  }

  // Test the addAccessGroupRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddAccessGroupRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.addAccessGroupRule(null).execute();
  }

  // Test the listAccessGroupRules operation with a valid options model parameter
  @Test
  public void testListAccessGroupRulesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rules\": [{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"EQUALS\", \"value\": \"value\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listAccessGroupRulesPath = "/v2/groups/testString/rules";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccessGroupRulesOptions model
    ListAccessGroupRulesOptions listAccessGroupRulesOptionsModel = new ListAccessGroupRulesOptions.Builder()
      .accessGroupId("testString")
      .transactionId("testString")
      .build();

    // Invoke listAccessGroupRules() with a valid options model and verify the result
    Response<RulesList> response = iamAccessGroupsService.listAccessGroupRules(listAccessGroupRulesOptionsModel).execute();
    assertNotNull(response);
    RulesList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccessGroupRulesPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the listAccessGroupRules operation with and without retries enabled
  @Test
  public void testListAccessGroupRulesWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testListAccessGroupRulesWOptions();

    iamAccessGroupsService.disableRetries();
    testListAccessGroupRulesWOptions();
  }

  // Test the listAccessGroupRules operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAccessGroupRulesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.listAccessGroupRules(null).execute();
  }

  // Test the getAccessGroupRule operation with a valid options model parameter
  @Test
  public void testGetAccessGroupRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"EQUALS\", \"value\": \"value\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getAccessGroupRulePath = "/v2/groups/testString/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccessGroupRuleOptions model
    GetAccessGroupRuleOptions getAccessGroupRuleOptionsModel = new GetAccessGroupRuleOptions.Builder()
      .accessGroupId("testString")
      .ruleId("testString")
      .transactionId("testString")
      .build();

    // Invoke getAccessGroupRule() with a valid options model and verify the result
    Response<Rule> response = iamAccessGroupsService.getAccessGroupRule(getAccessGroupRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccessGroupRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAccessGroupRule operation with and without retries enabled
  @Test
  public void testGetAccessGroupRuleWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testGetAccessGroupRuleWOptions();

    iamAccessGroupsService.disableRetries();
    testGetAccessGroupRuleWOptions();
  }

  // Test the getAccessGroupRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccessGroupRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.getAccessGroupRule(null).execute();
  }

  // Test the replaceAccessGroupRule operation with a valid options model parameter
  @Test
  public void testReplaceAccessGroupRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"access_group_id\": \"accessGroupId\", \"account_id\": \"accountId\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"EQUALS\", \"value\": \"value\"}], \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String replaceAccessGroupRulePath = "/v2/groups/testString/rules/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the RuleConditions model
    RuleConditions ruleConditionsModel = new RuleConditions.Builder()
      .claim("isManager")
      .operator("EQUALS")
      .value("true")
      .build();

    // Construct an instance of the ReplaceAccessGroupRuleOptions model
    ReplaceAccessGroupRuleOptions replaceAccessGroupRuleOptionsModel = new ReplaceAccessGroupRuleOptions.Builder()
      .accessGroupId("testString")
      .ruleId("testString")
      .ifMatch("testString")
      .expiration(Long.valueOf("12"))
      .realmName("https://idp.example.org/SAML2")
      .conditions(java.util.Arrays.asList(ruleConditionsModel))
      .name("Manager group rule")
      .transactionId("testString")
      .build();

    // Invoke replaceAccessGroupRule() with a valid options model and verify the result
    Response<Rule> response = iamAccessGroupsService.replaceAccessGroupRule(replaceAccessGroupRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceAccessGroupRulePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the replaceAccessGroupRule operation with and without retries enabled
  @Test
  public void testReplaceAccessGroupRuleWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testReplaceAccessGroupRuleWOptions();

    iamAccessGroupsService.disableRetries();
    testReplaceAccessGroupRuleWOptions();
  }

  // Test the replaceAccessGroupRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceAccessGroupRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.replaceAccessGroupRule(null).execute();
  }

  // Test the removeAccessGroupRule operation with a valid options model parameter
  @Test
  public void testRemoveAccessGroupRuleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String removeAccessGroupRulePath = "/v2/groups/testString/rules/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the RemoveAccessGroupRuleOptions model
    RemoveAccessGroupRuleOptions removeAccessGroupRuleOptionsModel = new RemoveAccessGroupRuleOptions.Builder()
      .accessGroupId("testString")
      .ruleId("testString")
      .transactionId("testString")
      .build();

    // Invoke removeAccessGroupRule() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.removeAccessGroupRule(removeAccessGroupRuleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, removeAccessGroupRulePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the removeAccessGroupRule operation with and without retries enabled
  @Test
  public void testRemoveAccessGroupRuleWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testRemoveAccessGroupRuleWOptions();

    iamAccessGroupsService.disableRetries();
    testRemoveAccessGroupRuleWOptions();
  }

  // Test the removeAccessGroupRule operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRemoveAccessGroupRuleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.removeAccessGroupRule(null).execute();
  }

  // Test the getAccountSettings operation with a valid options model parameter
  @Test
  public void testGetAccountSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"public_access_enabled\": false}";
    String getAccountSettingsPath = "/v2/groups/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountSettingsOptions model
    GetAccountSettingsOptions getAccountSettingsOptionsModel = new GetAccountSettingsOptions.Builder()
      .accountId("testString")
      .transactionId("testString")
      .build();

    // Invoke getAccountSettings() with a valid options model and verify the result
    Response<AccountSettings> response = iamAccessGroupsService.getAccountSettings(getAccountSettingsOptionsModel).execute();
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
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the getAccountSettings operation with and without retries enabled
  @Test
  public void testGetAccountSettingsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testGetAccountSettingsWOptions();

    iamAccessGroupsService.disableRetries();
    testGetAccountSettingsWOptions();
  }

  // Test the getAccountSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.getAccountSettings(null).execute();
  }

  // Test the updateAccountSettings operation with a valid options model parameter
  @Test
  public void testUpdateAccountSettingsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"public_access_enabled\": false}";
    String updateAccountSettingsPath = "/v2/groups/settings";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateAccountSettingsOptions model
    UpdateAccountSettingsOptions updateAccountSettingsOptionsModel = new UpdateAccountSettingsOptions.Builder()
      .accountId("testString")
      .publicAccessEnabled(true)
      .transactionId("testString")
      .build();

    // Invoke updateAccountSettings() with a valid options model and verify the result
    Response<AccountSettings> response = iamAccessGroupsService.updateAccountSettings(updateAccountSettingsOptionsModel).execute();
    assertNotNull(response);
    AccountSettings responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountSettingsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
  }

  // Test the updateAccountSettings operation with and without retries enabled
  @Test
  public void testUpdateAccountSettingsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testUpdateAccountSettingsWOptions();

    iamAccessGroupsService.disableRetries();
    testUpdateAccountSettingsWOptions();
  }

  // Test the updateAccountSettings operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.updateAccountSettings(null).execute();
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
    iamAccessGroupsService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    iamAccessGroupsService = IamAccessGroups.newInstance(serviceName);
    String url = server.url("/").toString();
    iamAccessGroupsService.setServiceUrl(url);
  }
}