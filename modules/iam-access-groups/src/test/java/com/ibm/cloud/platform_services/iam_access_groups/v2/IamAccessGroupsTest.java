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
package com.ibm.cloud.platform_services.iam_access_groups.v2;

import com.ibm.cloud.platform_services.iam_access_groups.v2.IamAccessGroups;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupMembersPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupRequest;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccessGroupsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AccountSettings;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersRequestMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddGroupMembersResponseMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMemberToMultipleAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembersToAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AddMembershipMultipleGroupsResponseGroupsItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Assertions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssertionsRule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssignmentResourceAccessGroup;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.AssignmentResourceEntry;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CommitTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Conditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.CreateTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteFromAllGroupsResponseGroupsItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteGroupBulkMembersResponseMembersItem;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteTemplateOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.DeleteTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Error;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetLatestTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GetTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Group;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupMembersList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupTemplate;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.GroupsList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.HrefStruct;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.IsMemberOfAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupMembersOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupRulesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListAssignmentsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListGroupMembersResponseMember;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplateVersionsResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ListTemplatesResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Members;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.MembersActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.PolicyTemplates;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMemberFromAllAccessGroupsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RemoveMembersFromAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ReplaceAccessGroupRuleOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.ResourceListWithTargetAccountID;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.Rule;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleActionControls;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RuleConditions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.RulesList;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateAssignmentResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateAssignmentVerboseResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateVersionResponse;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplateVersionsPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.TemplatesPager;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccessGroupOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateAssignmentOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.UpdateTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_access_groups.v2.utils.TestUtilities;
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
      .search("testString")
      .membershipType("static")
      .limit(Long.valueOf("10"))
      .offset(Long.valueOf("0"))
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
    assertEquals(query.get("search"), "testString");
    assertEquals(query.get("membership_type"), "static");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
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
      .search("testString")
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
      .search("testString")
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
      .offset(Long.valueOf("0"))
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
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
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
      .groups(java.util.Arrays.asList("AccessGroupId-b0d32f56-f85c-4bf1-af37-7bbd92b1b2b3"))
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

  // Test the createTemplate operation with a valid options model parameter
  @Test
  public void testCreateTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createTemplatePath = "/v1/group_templates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the MembersActionControls model
    MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
      .add(true)
      .remove(false)
      .build();

    // Construct an instance of the Members model
    Members membersModel = new Members.Builder()
      .users(java.util.Arrays.asList("IBMid-50PJGPKYJJ", "IBMid-665000T8WY"))
      .services(java.util.Arrays.asList("iam-ServiceId-345", "iam-ServiceId-456"))
      .actionControls(membersActionControlsModel)
      .build();

    // Construct an instance of the Conditions model
    Conditions conditionsModel = new Conditions.Builder()
      .claim("blueGroup")
      .operator("CONTAINS")
      .value("test-bluegroup-saml")
      .build();

    // Construct an instance of the RuleActionControls model
    RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
      .remove(false)
      .build();

    // Construct an instance of the AssertionsRule model
    AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
      .name("Manager group rule")
      .expiration(Long.valueOf("12"))
      .realmName("https://idp.example.org/SAML2")
      .conditions(java.util.Arrays.asList(conditionsModel))
      .actionControls(ruleActionControlsModel)
      .build();

    // Construct an instance of the AssertionsActionControls model
    AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
      .add(false)
      .remove(true)
      .build();

    // Construct an instance of the Assertions model
    Assertions assertionsModel = new Assertions.Builder()
      .rules(java.util.Arrays.asList(assertionsRuleModel))
      .actionControls(assertionsActionControlsModel)
      .build();

    // Construct an instance of the AccessActionControls model
    AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
      .add(false)
      .build();

    // Construct an instance of the GroupActionControls model
    GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
      .access(accessActionControlsModel)
      .build();

    // Construct an instance of the AccessGroupRequest model
    AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
      .name("IAM Admin Group")
      .description("This access group template allows admin access to all IAM platform services in the account.")
      .members(membersModel)
      .assertions(assertionsModel)
      .actionControls(groupActionControlsModel)
      .build();

    // Construct an instance of the PolicyTemplates model
    PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
      .id("policyTemplateId-123")
      .version("1")
      .build();

    // Construct an instance of the CreateTemplateOptions model
    CreateTemplateOptions createTemplateOptionsModel = new CreateTemplateOptions.Builder()
      .name("IAM Admin Group template")
      .accountId("accountID-123")
      .description("This access group template allows admin access to all IAM platform services in the account.")
      .group(accessGroupRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
      .transactionId("testString")
      .build();

    // Invoke createTemplate() with a valid options model and verify the result
    Response<TemplateResponse> response = iamAccessGroupsService.createTemplate(createTemplateOptionsModel).execute();
    assertNotNull(response);
    TemplateResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTemplate operation with and without retries enabled
  @Test
  public void testCreateTemplateWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testCreateTemplateWOptions();

    iamAccessGroupsService.disableRetries();
    testCreateTemplateWOptions();
  }

  // Test the createTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.createTemplate(null).execute();
  }

  // Test the listTemplates operation with a valid options model parameter
  @Test
  public void testListTemplatesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"group_templates\": [{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listTemplatesPath = "/v1/group_templates";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTemplatesOptions model
    ListTemplatesOptions listTemplatesOptionsModel = new ListTemplatesOptions.Builder()
      .accountId("accountID-123")
      .transactionId("testString")
      .limit(Long.valueOf("50"))
      .offset(Long.valueOf("0"))
      .verbose(true)
      .build();

    // Invoke listTemplates() with a valid options model and verify the result
    Response<ListTemplatesResponse> response = iamAccessGroupsService.listTemplates(listTemplatesOptionsModel).execute();
    assertNotNull(response);
    ListTemplatesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTemplatesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "accountID-123");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("50"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(true));
  }

  // Test the listTemplates operation with and without retries enabled
  @Test
  public void testListTemplatesWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testListTemplatesWOptions();

    iamAccessGroupsService.disableRetries();
    testListTemplatesWOptions();
  }

  // Test the listTemplates operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTemplatesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.listTemplates(null).execute();
  }

  // Test the listTemplates operation using the TemplatesPager.getNext() method
  @Test
  public void testListTemplatesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"group_templates\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\"}],\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"group_templates\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\"}],\"total_count\":2,\"limit\":1}";
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

    ListTemplatesOptions listTemplatesOptions = new ListTemplatesOptions.Builder()
      .accountId("accountID-123")
      .transactionId("testString")
      .limit(Long.valueOf("50"))
      .verbose(true)
      .build();

    List<GroupTemplate> allResults = new ArrayList<>();
    TemplatesPager pager = new TemplatesPager(iamAccessGroupsService, listTemplatesOptions);
    while (pager.hasNext()) {
      List<GroupTemplate> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listTemplates operation using the TemplatesPager.getAll() method
  @Test
  public void testListTemplatesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"group_templates\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\"}],\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"limit\":1}";
    String mockResponsePage2 = "{\"group_templates\":[{\"id\":\"id\",\"name\":\"name\",\"description\":\"description\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"2019-01-01T12:00:00.000Z\",\"last_modified_by_id\":\"lastModifiedById\"}],\"total_count\":2,\"limit\":1}";
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

    ListTemplatesOptions listTemplatesOptions = new ListTemplatesOptions.Builder()
      .accountId("accountID-123")
      .transactionId("testString")
      .limit(Long.valueOf("50"))
      .verbose(true)
      .build();

    TemplatesPager pager = new TemplatesPager(iamAccessGroupsService, listTemplatesOptions);
    List<GroupTemplate> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the createTemplateVersion operation with a valid options model parameter
  @Test
  public void testCreateTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createTemplateVersionPath = "/v1/group_templates/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the MembersActionControls model
    MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
      .add(true)
      .remove(false)
      .build();

    // Construct an instance of the Members model
    Members membersModel = new Members.Builder()
      .users(java.util.Arrays.asList("IBMid-50PJGPKYJJ", "IBMid-665000T8WY"))
      .services(java.util.Arrays.asList("iam-ServiceId-345"))
      .actionControls(membersActionControlsModel)
      .build();

    // Construct an instance of the Conditions model
    Conditions conditionsModel = new Conditions.Builder()
      .claim("blueGroup")
      .operator("CONTAINS")
      .value("test-bluegroup-saml")
      .build();

    // Construct an instance of the RuleActionControls model
    RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
      .remove(false)
      .build();

    // Construct an instance of the AssertionsRule model
    AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
      .name("Manager group rule")
      .expiration(Long.valueOf("12"))
      .realmName("https://idp.example.org/SAML2")
      .conditions(java.util.Arrays.asList(conditionsModel))
      .actionControls(ruleActionControlsModel)
      .build();

    // Construct an instance of the AssertionsActionControls model
    AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
      .add(false)
      .remove(true)
      .build();

    // Construct an instance of the Assertions model
    Assertions assertionsModel = new Assertions.Builder()
      .rules(java.util.Arrays.asList(assertionsRuleModel))
      .actionControls(assertionsActionControlsModel)
      .build();

    // Construct an instance of the AccessActionControls model
    AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
      .add(false)
      .build();

    // Construct an instance of the GroupActionControls model
    GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
      .access(accessActionControlsModel)
      .build();

    // Construct an instance of the AccessGroupRequest model
    AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
      .name("IAM Admin Group 8")
      .description("This access group template allows admin access to all IAM platform services in the account.")
      .members(membersModel)
      .assertions(assertionsModel)
      .actionControls(groupActionControlsModel)
      .build();

    // Construct an instance of the PolicyTemplates model
    PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
      .id("policyTemplateId-123")
      .version("1")
      .build();

    // Construct an instance of the CreateTemplateVersionOptions model
    CreateTemplateVersionOptions createTemplateVersionOptionsModel = new CreateTemplateVersionOptions.Builder()
      .templateId("testString")
      .name("IAM Admin Group template 2")
      .description("This access group template allows admin access to all IAM platform services in the account.")
      .group(accessGroupRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
      .transactionId("testString")
      .build();

    // Invoke createTemplateVersion() with a valid options model and verify the result
    Response<TemplateVersionResponse> response = iamAccessGroupsService.createTemplateVersion(createTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TemplateVersionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createTemplateVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createTemplateVersion operation with and without retries enabled
  @Test
  public void testCreateTemplateVersionWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testCreateTemplateVersionWOptions();

    iamAccessGroupsService.disableRetries();
    testCreateTemplateVersionWOptions();
  }

  // Test the createTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.createTemplateVersion(null).execute();
  }

  // Test the listTemplateVersions operation with a valid options model parameter
  @Test
  public void testListTemplateVersionsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"previous\": {\"href\": \"href\"}, \"next\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"group_template_versions\": [{\"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"createdAt\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"lastModifiedAt\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listTemplateVersionsPath = "/v1/group_templates/testString/versions";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListTemplateVersionsOptions model
    ListTemplateVersionsOptions listTemplateVersionsOptionsModel = new ListTemplateVersionsOptions.Builder()
      .templateId("testString")
      .limit(Long.valueOf("100"))
      .offset(Long.valueOf("0"))
      .build();

    // Invoke listTemplateVersions() with a valid options model and verify the result
    Response<ListTemplateVersionsResponse> response = iamAccessGroupsService.listTemplateVersions(listTemplateVersionsOptionsModel).execute();
    assertNotNull(response);
    ListTemplateVersionsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listTemplateVersionsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("100"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
  }

  // Test the listTemplateVersions operation with and without retries enabled
  @Test
  public void testListTemplateVersionsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testListTemplateVersionsWOptions();

    iamAccessGroupsService.disableRetries();
    testListTemplateVersionsWOptions();
  }

  // Test the listTemplateVersions operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListTemplateVersionsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.listTemplateVersions(null).execute();
  }

  // Test the listTemplateVersions operation using the TemplateVersionsPager.getNext() method
  @Test
  public void testListTemplateVersionsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"group_template_versions\":[{\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"createdAt\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"lastModifiedAt\",\"last_modified_by_id\":\"lastModifiedById\"}],\"limit\":1}";
    String mockResponsePage2 = "{\"total_count\":2,\"group_template_versions\":[{\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"createdAt\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"lastModifiedAt\",\"last_modified_by_id\":\"lastModifiedById\"}],\"limit\":1}";
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

    ListTemplateVersionsOptions listTemplateVersionsOptions = new ListTemplateVersionsOptions.Builder()
      .templateId("testString")
      .limit(Long.valueOf("100"))
      .build();

    List<ListTemplateVersionResponse> allResults = new ArrayList<>();
    TemplateVersionsPager pager = new TemplateVersionsPager(iamAccessGroupsService, listTemplateVersionsOptions);
    while (pager.hasNext()) {
      List<ListTemplateVersionResponse> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listTemplateVersions operation using the TemplateVersionsPager.getAll() method
  @Test
  public void testListTemplateVersionsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"next\":{\"href\":\"https://myhost.com/somePath?offset=1\"},\"total_count\":2,\"group_template_versions\":[{\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"createdAt\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"lastModifiedAt\",\"last_modified_by_id\":\"lastModifiedById\"}],\"limit\":1}";
    String mockResponsePage2 = "{\"total_count\":2,\"group_template_versions\":[{\"name\":\"name\",\"description\":\"description\",\"account_id\":\"accountId\",\"version\":\"version\",\"committed\":false,\"group\":{\"name\":\"name\",\"description\":\"description\",\"members\":{\"users\":[\"users\"],\"services\":[\"services\"],\"action_controls\":{\"add\":false,\"remove\":true}},\"assertions\":{\"rules\":[{\"name\":\"name\",\"expiration\":10,\"realm_name\":\"realmName\",\"conditions\":[{\"claim\":\"claim\",\"operator\":\"operator\",\"value\":\"value\"}],\"action_controls\":{\"remove\":true}}],\"action_controls\":{\"add\":false,\"remove\":true}},\"action_controls\":{\"access\":{\"add\":false}}},\"policy_template_references\":[{\"id\":\"id\",\"version\":\"version\"}],\"href\":\"href\",\"created_at\":\"createdAt\",\"created_by_id\":\"createdById\",\"last_modified_at\":\"lastModifiedAt\",\"last_modified_by_id\":\"lastModifiedById\"}],\"limit\":1}";
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

    ListTemplateVersionsOptions listTemplateVersionsOptions = new ListTemplateVersionsOptions.Builder()
      .templateId("testString")
      .limit(Long.valueOf("100"))
      .build();

    TemplateVersionsPager pager = new TemplateVersionsPager(iamAccessGroupsService, listTemplateVersionsOptions);
    List<ListTemplateVersionResponse> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getTemplateVersion operation with a valid options model parameter
  @Test
  public void testGetTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getTemplateVersionPath = "/v1/group_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetTemplateVersionOptions model
    GetTemplateVersionOptions getTemplateVersionOptionsModel = new GetTemplateVersionOptions.Builder()
      .templateId("testString")
      .versionNum("testString")
      .verbose(true)
      .transactionId("testString")
      .build();

    // Invoke getTemplateVersion() with a valid options model and verify the result
    Response<TemplateVersionResponse> response = iamAccessGroupsService.getTemplateVersion(getTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TemplateVersionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getTemplateVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(true));
  }

  // Test the getTemplateVersion operation with and without retries enabled
  @Test
  public void testGetTemplateVersionWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testGetTemplateVersionWOptions();

    iamAccessGroupsService.disableRetries();
    testGetTemplateVersionWOptions();
  }

  // Test the getTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.getTemplateVersion(null).execute();
  }

  // Test the updateTemplateVersion operation with a valid options model parameter
  @Test
  public void testUpdateTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String updateTemplateVersionPath = "/v1/group_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the MembersActionControls model
    MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
      .add(true)
      .remove(false)
      .build();

    // Construct an instance of the Members model
    Members membersModel = new Members.Builder()
      .users(java.util.Arrays.asList("IBMid-665000T8WY"))
      .services(java.util.Arrays.asList("iam-ServiceId-e371b0e5-1c80-48e3-bf12-c6a8ef2b1a11"))
      .actionControls(membersActionControlsModel)
      .build();

    // Construct an instance of the Conditions model
    Conditions conditionsModel = new Conditions.Builder()
      .claim("blueGroup")
      .operator("CONTAINS")
      .value("test-bluegroup-saml")
      .build();

    // Construct an instance of the RuleActionControls model
    RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
      .remove(false)
      .build();

    // Construct an instance of the AssertionsRule model
    AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
      .name("Manager group rule")
      .expiration(Long.valueOf("12"))
      .realmName("https://idp.example.org/SAML2")
      .conditions(java.util.Arrays.asList(conditionsModel))
      .actionControls(ruleActionControlsModel)
      .build();

    // Construct an instance of the AssertionsActionControls model
    AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
      .add(false)
      .remove(true)
      .build();

    // Construct an instance of the Assertions model
    Assertions assertionsModel = new Assertions.Builder()
      .rules(java.util.Arrays.asList(assertionsRuleModel))
      .actionControls(assertionsActionControlsModel)
      .build();

    // Construct an instance of the AccessActionControls model
    AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
      .add(false)
      .build();

    // Construct an instance of the GroupActionControls model
    GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
      .access(accessActionControlsModel)
      .build();

    // Construct an instance of the AccessGroupRequest model
    AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
      .name("IAM Admin Group 8")
      .description("This access group template allows admin access to all IAM platform services in the account.")
      .members(membersModel)
      .assertions(assertionsModel)
      .actionControls(groupActionControlsModel)
      .build();

    // Construct an instance of the PolicyTemplates model
    PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
      .id("policyTemplateId-123")
      .version("1")
      .build();

    // Construct an instance of the UpdateTemplateVersionOptions model
    UpdateTemplateVersionOptions updateTemplateVersionOptionsModel = new UpdateTemplateVersionOptions.Builder()
      .templateId("testString")
      .versionNum("testString")
      .ifMatch("testString")
      .name("IAM Admin Group template 2")
      .description("This access group template allows admin access to all IAM platform services in the account.")
      .group(accessGroupRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
      .transactionId("83adf5bd-de790caa3")
      .build();

    // Invoke updateTemplateVersion() with a valid options model and verify the result
    Response<TemplateVersionResponse> response = iamAccessGroupsService.updateTemplateVersion(updateTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TemplateVersionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateTemplateVersionPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateTemplateVersion operation with and without retries enabled
  @Test
  public void testUpdateTemplateVersionWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testUpdateTemplateVersionWOptions();

    iamAccessGroupsService.disableRetries();
    testUpdateTemplateVersionWOptions();
  }

  // Test the updateTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.updateTemplateVersion(null).execute();
  }

  // Test the deleteTemplateVersion operation with a valid options model parameter
  @Test
  public void testDeleteTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTemplateVersionPath = "/v1/group_templates/testString/versions/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTemplateVersionOptions model
    DeleteTemplateVersionOptions deleteTemplateVersionOptionsModel = new DeleteTemplateVersionOptions.Builder()
      .templateId("testString")
      .versionNum("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteTemplateVersion() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.deleteTemplateVersion(deleteTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTemplateVersionPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTemplateVersion operation with and without retries enabled
  @Test
  public void testDeleteTemplateVersionWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testDeleteTemplateVersionWOptions();

    iamAccessGroupsService.disableRetries();
    testDeleteTemplateVersionWOptions();
  }

  // Test the deleteTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.deleteTemplateVersion(null).execute();
  }

  // Test the commitTemplate operation with a valid options model parameter
  @Test
  public void testCommitTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String commitTemplatePath = "/v1/group_templates/testString/versions/testString/commit";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the CommitTemplateOptions model
    CommitTemplateOptions commitTemplateOptionsModel = new CommitTemplateOptions.Builder()
      .templateId("testString")
      .versionNum("testString")
      .ifMatch("testString")
      .transactionId("testString")
      .build();

    // Invoke commitTemplate() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.commitTemplate(commitTemplateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, commitTemplatePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the commitTemplate operation with and without retries enabled
  @Test
  public void testCommitTemplateWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testCommitTemplateWOptions();

    iamAccessGroupsService.disableRetries();
    testCommitTemplateWOptions();
  }

  // Test the commitTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCommitTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.commitTemplate(null).execute();
  }

  // Test the getLatestTemplateVersion operation with a valid options model parameter
  @Test
  public void testGetLatestTemplateVersionWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"description\": \"description\", \"account_id\": \"accountId\", \"version\": \"version\", \"committed\": false, \"group\": {\"name\": \"name\", \"description\": \"description\", \"members\": {\"users\": [\"users\"], \"services\": [\"services\"], \"action_controls\": {\"add\": false, \"remove\": true}}, \"assertions\": {\"rules\": [{\"name\": \"name\", \"expiration\": 10, \"realm_name\": \"realmName\", \"conditions\": [{\"claim\": \"claim\", \"operator\": \"operator\", \"value\": \"value\"}], \"action_controls\": {\"remove\": true}}], \"action_controls\": {\"add\": false, \"remove\": true}}, \"action_controls\": {\"access\": {\"add\": false}}}, \"policy_template_references\": [{\"id\": \"id\", \"version\": \"version\"}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getLatestTemplateVersionPath = "/v1/group_templates/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetLatestTemplateVersionOptions model
    GetLatestTemplateVersionOptions getLatestTemplateVersionOptionsModel = new GetLatestTemplateVersionOptions.Builder()
      .templateId("testString")
      .verbose(true)
      .transactionId("testString")
      .build();

    // Invoke getLatestTemplateVersion() with a valid options model and verify the result
    Response<TemplateVersionResponse> response = iamAccessGroupsService.getLatestTemplateVersion(getLatestTemplateVersionOptionsModel).execute();
    assertNotNull(response);
    TemplateVersionResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLatestTemplateVersionPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(true));
  }

  // Test the getLatestTemplateVersion operation with and without retries enabled
  @Test
  public void testGetLatestTemplateVersionWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testGetLatestTemplateVersionWOptions();

    iamAccessGroupsService.disableRetries();
    testGetLatestTemplateVersionWOptions();
  }

  // Test the getLatestTemplateVersion operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLatestTemplateVersionNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.getLatestTemplateVersion(null).execute();
  }

  // Test the deleteTemplate operation with a valid options model parameter
  @Test
  public void testDeleteTemplateWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteTemplatePath = "/v1/group_templates/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteTemplateOptions model
    DeleteTemplateOptions deleteTemplateOptionsModel = new DeleteTemplateOptions.Builder()
      .templateId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteTemplate() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.deleteTemplate(deleteTemplateOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteTemplatePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteTemplate operation with and without retries enabled
  @Test
  public void testDeleteTemplateWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testDeleteTemplateWOptions();

    iamAccessGroupsService.disableRetries();
    testDeleteTemplateWOptions();
  }

  // Test the deleteTemplate operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteTemplateNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.deleteTemplate(null).execute();
  }

  // Test the createAssignment operation with a valid options model parameter
  @Test
  public void testCreateAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": \"templateVersion\", \"target_type\": \"Account\", \"target\": \"target\", \"operation\": \"assign\", \"status\": \"accepted\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String createAssignmentPath = "/v1/group_assignments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateAssignmentOptions model
    CreateAssignmentOptions createAssignmentOptionsModel = new CreateAssignmentOptions.Builder()
      .templateId("AccessGroupTemplateId-4be4")
      .templateVersion("1")
      .targetType("AccountGroup")
      .target("0a45594d0f-123")
      .transactionId("testString")
      .build();

    // Invoke createAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentResponse> response = iamAccessGroupsService.createAssignment(createAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAssignmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAssignment operation with and without retries enabled
  @Test
  public void testCreateAssignmentWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testCreateAssignmentWOptions();

    iamAccessGroupsService.disableRetries();
    testCreateAssignmentWOptions();
  }

  // Test the createAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.createAssignment(null).execute();
  }

  // Test the listAssignments operation with a valid options model parameter
  @Test
  public void testListAssignmentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"limit\": 5, \"offset\": 6, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"assignments\": [{\"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": \"templateVersion\", \"target_type\": \"Account\", \"target\": \"target\", \"operation\": \"assign\", \"status\": \"accepted\", \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}]}";
    String listAssignmentsPath = "/v1/group_assignments";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAssignmentsOptions model
    ListAssignmentsOptions listAssignmentsOptionsModel = new ListAssignmentsOptions.Builder()
      .accountId("accountID-123")
      .templateId("testString")
      .templateVersion("testString")
      .target("testString")
      .status("accepted")
      .transactionId("testString")
      .limit(Long.valueOf("50"))
      .offset(Long.valueOf("0"))
      .build();

    // Invoke listAssignments() with a valid options model and verify the result
    Response<ListTemplateAssignmentResponse> response = iamAccessGroupsService.listAssignments(listAssignmentsOptionsModel).execute();
    assertNotNull(response);
    ListTemplateAssignmentResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAssignmentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "accountID-123");
    assertEquals(query.get("template_id"), "testString");
    assertEquals(query.get("template_version"), "testString");
    assertEquals(query.get("target"), "testString");
    assertEquals(query.get("status"), "accepted");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("50"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("0"));
  }

  // Test the listAssignments operation with and without retries enabled
  @Test
  public void testListAssignmentsWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testListAssignmentsWOptions();

    iamAccessGroupsService.disableRetries();
    testListAssignmentsWOptions();
  }

  // Test the listAssignments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAssignmentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.listAssignments(null).execute();
  }

  // Test the getAssignment operation with a valid options model parameter
  @Test
  public void testGetAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": \"templateVersion\", \"target_type\": \"targetType\", \"target\": \"target\", \"operation\": \"operation\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"group\": {\"group\": {\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}, \"members\": [{\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}], \"rules\": [{\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String getAssignmentPath = "/v1/group_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAssignmentOptions model
    GetAssignmentOptions getAssignmentOptionsModel = new GetAssignmentOptions.Builder()
      .assignmentId("testString")
      .transactionId("testString")
      .verbose(false)
      .build();

    // Invoke getAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentVerboseResponse> response = iamAccessGroupsService.getAssignment(getAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentVerboseResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAssignmentPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(Boolean.valueOf(query.get("verbose")), Boolean.valueOf(false));
  }

  // Test the getAssignment operation with and without retries enabled
  @Test
  public void testGetAssignmentWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testGetAssignmentWOptions();

    iamAccessGroupsService.disableRetries();
    testGetAssignmentWOptions();
  }

  // Test the getAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.getAssignment(null).execute();
  }

  // Test the updateAssignment operation with a valid options model parameter
  @Test
  public void testUpdateAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"account_id\": \"accountId\", \"template_id\": \"templateId\", \"template_version\": \"templateVersion\", \"target_type\": \"targetType\", \"target\": \"target\", \"operation\": \"operation\", \"status\": \"status\", \"resources\": [{\"target\": \"target\", \"group\": {\"group\": {\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}, \"members\": [{\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}], \"rules\": [{\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}]}, \"policy_template_references\": [{\"id\": \"id\", \"name\": \"name\", \"version\": \"version\", \"resource\": \"resource\", \"error\": \"error\", \"operation\": \"operation\", \"status\": \"status\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\"}";
    String updateAssignmentPath = "/v1/group_assignments/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateAssignmentOptions model
    UpdateAssignmentOptions updateAssignmentOptionsModel = new UpdateAssignmentOptions.Builder()
      .assignmentId("testString")
      .ifMatch("testString")
      .templateVersion("1")
      .build();

    // Invoke updateAssignment() with a valid options model and verify the result
    Response<TemplateAssignmentVerboseResponse> response = iamAccessGroupsService.updateAssignment(updateAssignmentOptionsModel).execute();
    assertNotNull(response);
    TemplateAssignmentVerboseResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAssignmentPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAssignment operation with and without retries enabled
  @Test
  public void testUpdateAssignmentWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testUpdateAssignmentWOptions();

    iamAccessGroupsService.disableRetries();
    testUpdateAssignmentWOptions();
  }

  // Test the updateAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.updateAssignment(null).execute();
  }

  // Test the deleteAssignment operation with a valid options model parameter
  @Test
  public void testDeleteAssignmentWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAssignmentPath = "/v1/group_assignments/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAssignmentOptions model
    DeleteAssignmentOptions deleteAssignmentOptionsModel = new DeleteAssignmentOptions.Builder()
      .assignmentId("testString")
      .transactionId("testString")
      .build();

    // Invoke deleteAssignment() with a valid options model and verify the result
    Response<Void> response = iamAccessGroupsService.deleteAssignment(deleteAssignmentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAssignmentPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAssignment operation with and without retries enabled
  @Test
  public void testDeleteAssignmentWRetries() throws Throwable {
    iamAccessGroupsService.enableRetries(4, 30);
    testDeleteAssignmentWOptions();

    iamAccessGroupsService.disableRetries();
    testDeleteAssignmentWOptions();
  }

  // Test the deleteAssignment operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAssignmentNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamAccessGroupsService.deleteAssignment(null).execute();
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