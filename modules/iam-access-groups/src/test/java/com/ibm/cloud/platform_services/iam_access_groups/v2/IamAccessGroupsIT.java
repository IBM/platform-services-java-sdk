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
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
/**
 * Integration test class for the IamAccessGroups service.
 */
public class IamAccessGroupsIT extends SdkIntegrationTestBase {

    IamAccessGroups service = null;
    Random random = new Random();

    private static final String HEADER_ETAG = "ETag";
    private static final String TEST_GROUP_NAME = "SDK Test Group - Java";
    private static final String TEST_GROUP_DESC = "This group is used for integration test purposes. It can be deleted at any time.";
    private final String TEST_USER_ID = "IBMid-" + String.valueOf(random.nextInt(100000));;
    private static final String TEST_USER_TYPE = "user";

    String testAccountId = null;
    String testGroupId = null;
    String testGroupETag = null;
    String testClaimRuleId = null;
    String testClaimRuleETag = null;
    AccountSettings testAccountSettings = null;
    String testPolicyTemplateId = null;
    String testAccountGroupId = null;
    String testTemplateId = null;
    String testTemplateETag = null;
    String testTemplateVersionETag = null;
    String testAssignmentId = null;
    String testAssignmentETag = null;

    @Override
    public String getConfigFilename() {
        return "../../iam_access_groups_v2.env";
    }

    @Override
    public boolean loggingEnabled() {
        return false;
    }


    /**
     * This method is invoked before any @Test-annotated methods, and is responsible for
     * creating the instance of the service that will be used by the rest of the test methods,
     * as well as any other required initialization.
     */
    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        //
        // Perform the necessary setup required by this testcase.
        //

        // Load up the config properties for this service.
        Map<String, String> config = CredentialUtils.getServiceProperties(IamAccessGroups.DEFAULT_SERVICE_NAME);

        // Retrieve our test-specific properties.
        testAccountId = config.get("TEST_ACCOUNT_ID");
        testPolicyTemplateId = config.get("TEST_POLICY_TEMPLATE_ID");
        testAccountGroupId = config.get("TEST_ACCOUNT_GROUP_ID");
        assertNotNull(testAccountId);

        // Construct the service from our external configuration.
        service = IamAccessGroups.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        log("Using Account Id: " + testAccountId);
        log("Using Service URL: " + service.getServiceUrl());
    }

    @Test
    public void testCreateAccessGroup() {
        CreateAccessGroupOptions options = new CreateAccessGroupOptions.Builder()
                .accountId(testAccountId)
                .name(TEST_GROUP_NAME)
                .build();

        Response<Group> response = service.createAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        Group result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), TEST_GROUP_NAME);

        testGroupId = result.getId();
    }

    @Test(dependsOnMethods = {"testCreateAccessGroup"})
    public void testGetAccessGroup() {
        assertNotNull(testGroupId);

        GetAccessGroupOptions options = new GetAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .build();

        Response<Group> response = service.getAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Group result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), TEST_GROUP_NAME);
        assertEquals(result.getId(), testGroupId);
        assertEquals(result.getDescription(), "");

        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testGroupETag = values.get(0);
    }

    @Test(dependsOnMethods = {"testGetAccessGroup"})
    public void testUpdateAccessGroupDescription() {
        assertNotNull(testGroupId);
        assertNotNull(testGroupETag);

        UpdateAccessGroupOptions options = new UpdateAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .ifMatch(testGroupETag)
                .description(TEST_GROUP_DESC)
                .build();

        Response<Group> response = service.updateAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Group result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getId(), testGroupId);
        assertEquals(result.getName(), TEST_GROUP_NAME);
        assertEquals(result.getDescription(), TEST_GROUP_DESC);
    }

    @Test(dependsOnMethods = {"testUpdateAccessGroupDescription"})
    public void testListAccessGroups() throws Exception, InterruptedException {
        ListAccessGroupsOptions options = new ListAccessGroupsOptions.Builder()
                .accountId(testAccountId)
                .hidePublicAccess(true)
                .build();

        Response<GroupsList> response = service.listAccessGroups(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        GroupsList result = response.getResult();
        assertNotNull(response.getResult());

        // Confirm the test group is present
        boolean foundTestGroup = false;
        for (Group group : result.getGroups()) {
            if (testGroupId.equals(group.getId())) {
                foundTestGroup = true;
                break;
            }
        }
        assertTrue(foundTestGroup);
    }

    @Test(dependsOnMethods = { "testListAccessGroups" })
    public void testListAccessGroupsWithPager() throws Exception {
      try {
        ListAccessGroupsOptions options = new ListAccessGroupsOptions.Builder()
          .accountId(testAccountId)
          .hidePublicAccess(true)
         .build();

        // Test getNext().
        List<Group> allResults = new ArrayList<>();
        AccessGroupsPager pager = new AccessGroupsPager(service, options);
        while (pager.hasNext()) {
          List<Group> nextPage = pager.getNext();
          assertNotNull(nextPage);
          allResults.addAll(nextPage);
        }
        assertFalse(allResults.isEmpty());

        // Test getAll();
        pager = new AccessGroupsPager(service, options);
        List<Group> allItems = pager.getAll();
        assertNotNull(allItems);
        assertFalse(allItems.isEmpty());

        assertEquals(allItems.size(), allResults.size());
        System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s%nError details: %s",
            e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
      }
    }

    @Test(dependsOnMethods = { "testListAccessGroupsWithPager" })
    public void testAddMembersToAccessGroup() {
        assertNotNull(testGroupId);

        AddGroupMembersRequestMembersItem membersItem = new AddGroupMembersRequestMembersItem.Builder()
                .iamId(TEST_USER_ID)
                .type(TEST_USER_TYPE)
                .build();
        AddMembersToAccessGroupOptions options = new AddMembersToAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .addMembers(membersItem).build();
        Response<AddGroupMembersResponse> response = service.addMembersToAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 207);

        AddGroupMembersResponse result = response.getResult();
        assertNotNull(result);

        // Confirm the test user is present
        boolean foundTestUser = false;
        for (AddGroupMembersResponseMembersItem member : result.getMembers()) {
            if (TEST_USER_ID.equals(member.getIamId())) {
                foundTestUser = true;
            }
        }
        assertTrue(foundTestUser);
    }

    @Test(dependsOnMethods = { "testAddMembersToAccessGroup" })
    public void testAddMemberToMultipleAccessGroups() {
        assertNotNull(testGroupId);

        AddMemberToMultipleAccessGroupsOptions options = new AddMemberToMultipleAccessGroupsOptions.Builder()
                .accountId(
                        testAccountId)
                .iamId(TEST_USER_ID)
                .type(TEST_USER_TYPE)
                .addGroups(testGroupId)
                .build();
        Response<AddMembershipMultipleGroupsResponse> response = service.addMemberToMultipleAccessGroups(options)
                .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 207);

        AddMembershipMultipleGroupsResponse result = response.getResult();
        assertNotNull(result);

        // Confirm the test group is present
        boolean foundTestGroup = false;
        for (AddMembershipMultipleGroupsResponseGroupsItem group : result.getGroups()) {
            if (testGroupId.equals(group.getAccessGroupId())) {
                foundTestGroup = true;
            }
        }
        assertTrue(foundTestGroup);
    }

    @Test(dependsOnMethods = { "testAddMemberToMultipleAccessGroups" })
    public void testCheckMembership() {
        assertNotNull(testGroupId);

        IsMemberOfAccessGroupOptions options = new IsMemberOfAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .iamId(TEST_USER_ID)
                .build();
        Response<Void> response = service.isMemberOfAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test(dependsOnMethods = { "testCheckMembership" })
    public void testListAccessGroupMembers() {
        assertNotNull(testGroupId);

        ListAccessGroupMembersOptions options = new ListAccessGroupMembersOptions.Builder()
                .accessGroupId(testGroupId)
                .build();
        Response<GroupMembersList> response = service.listAccessGroupMembers(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        GroupMembersList result = response.getResult();
        assertNotNull(result);

        // Confirm the test user is present
        boolean foundTestUser = false;
        for (ListGroupMembersResponseMember member : result.getMembers()) {
            if (TEST_USER_ID.equals(member.getIamId())) {
                foundTestUser = true;
            }
        }
        assertTrue(foundTestUser);
    }

    @Test(dependsOnMethods = { "testListAccessGroupMembers" })
    public void testListAccessGroupMembersWithPager() throws Exception {
      assertNotNull(testGroupId);

      try {
        ListAccessGroupMembersOptions options = new ListAccessGroupMembersOptions.Builder()
          .accessGroupId(testGroupId)
          .build();

        // Test getNext().
        List<ListGroupMembersResponseMember> allResults = new ArrayList<>();
        AccessGroupMembersPager pager = new AccessGroupMembersPager(service, options);
        while (pager.hasNext()) {
          List<ListGroupMembersResponseMember> nextPage = pager.getNext();
          assertNotNull(nextPage);
          allResults.addAll(nextPage);
        }
        assertFalse(allResults.isEmpty());

        // Test getAll();
        pager = new AccessGroupMembersPager(service, options);
        List<ListGroupMembersResponseMember> allItems = pager.getAll();
        assertNotNull(allItems);
        assertFalse(allItems.isEmpty());

        assertEquals(allItems.size(), allResults.size());
        System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s%nError details: %s",
            e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
      }
    }

    @Test(dependsOnMethods = { "testListAccessGroupMembersWithPager" })
    public void testDeleteGroupMembership() {
        assertNotNull(testGroupId);

        RemoveMemberFromAccessGroupOptions options = new RemoveMemberFromAccessGroupOptions.Builder()
                .accessGroupId(testGroupId)
                .iamId(TEST_USER_ID)
                .build();
        Response<Void> response = service.removeMemberFromAccessGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test(dependsOnMethods = { "testDeleteGroupMembership" })
    public void testDeleteMemberFromAllGroups() {
        assertNotNull(testGroupId);

        try {
            RemoveMemberFromAllAccessGroupsOptions options = new RemoveMemberFromAllAccessGroupsOptions.Builder()
                    .accountId(testAccountId)
                    .iamId(TEST_USER_ID)
                    .build();
            service.removeMemberFromAllAccessGroups(options).execute();
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
            assertTrue(e.getMessage().contains(TEST_USER_ID));
        }
    }

    @Test(dependsOnMethods = { "testDeleteMemberFromAllGroups" })
    public void testDeleteBulkMembersFromGroup() {
        assertNotNull(testGroupId);

        try {
            RemoveMembersFromAccessGroupOptions options = new RemoveMembersFromAccessGroupOptions.Builder()
                    .accessGroupId(testGroupId)
                    .addMembers(TEST_USER_ID)
                    .build();
            service.removeMembersFromAccessGroup(options).execute();
        } catch (NotFoundException e) {
            assertEquals(e.getStatusCode(), 404);
            assertTrue(e.getMessage().contains(testGroupId));
        }
    }

    @Test(dependsOnMethods = { "testDeleteBulkMembersFromGroup" })
    public void testCreateAccessGroupRule() {
        assertNotNull(testGroupId);

        Long testExpiration = 24L;
        RuleConditions testCondition = new RuleConditions.Builder("test claim", "EQUALS", "1").build();
        List<RuleConditions> testConditions = Arrays.asList(testCondition);

        AddAccessGroupRuleOptions options = new AddAccessGroupRuleOptions.Builder()
                .accessGroupId(testGroupId)
                .expiration(testExpiration)
                .realmName("test realm name")
                .conditions(testConditions)
                .build();
        Response<Rule> response = service.addAccessGroupRule(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        Rule result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccessGroupId(), testGroupId);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getExpiration(), testExpiration);

        testClaimRuleId = result.getId();
    }

    @Test(dependsOnMethods = { "testCreateAccessGroupRule" })
    public void testGetAccessGroupRule() {
        assertNotNull(testGroupId);
        assertNotNull(testClaimRuleId);

        GetAccessGroupRuleOptions options = new GetAccessGroupRuleOptions.Builder()
                .accessGroupId(testGroupId)
                .ruleId(testClaimRuleId)
                .build();
        Response<Rule> response = service.getAccessGroupRule(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Rule result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testClaimRuleId);
        assertEquals(result.getAccessGroupId(), testGroupId);
        assertEquals(result.getAccountId(), testAccountId);

        testClaimRuleETag = response.getHeaders().values(HEADER_ETAG).get(0);
    }

    @Test(dependsOnMethods = { "testGetAccessGroupRule" })
    public void testListAccessGroupRules() {
        assertNotNull(testGroupId);

        ListAccessGroupRulesOptions options = new ListAccessGroupRulesOptions.Builder()
                .accessGroupId(testGroupId)
                .build();
        Response<RulesList> response = service.listAccessGroupRules(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        RulesList result = response.getResult();
        assertNotNull(result);

        // Confirm the test rule is present
        boolean foundTestClaimRule = false;
        for (Rule rule : result.getRules()) {
            if (testClaimRuleId.equals(rule.getId())) {
                foundTestClaimRule = true;
            }
        }
        assertTrue(foundTestClaimRule);
    }

    @Test(dependsOnMethods = { "testListAccessGroupRules" })
    public void testUpdateAccessGroupRule() {
        assertNotNull(testGroupId);
        assertNotNull(testClaimRuleId);

        Long testExpiration = 24L;
        RuleConditions testCondition = new RuleConditions.Builder("test claim", "EQUALS", "1").build();
        List<RuleConditions> testConditions = Arrays.asList(testCondition);

        ReplaceAccessGroupRuleOptions options = new ReplaceAccessGroupRuleOptions.Builder()
                .accessGroupId(testGroupId)
                .ruleId(testClaimRuleId)
                .ifMatch(testClaimRuleETag)
                .expiration(testExpiration)
                .realmName("updated test realm name")
                .conditions(testConditions)
                .build();
        Response<Rule> response = service.replaceAccessGroupRule(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Rule result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testClaimRuleId);
        assertEquals(result.getAccessGroupId(), testGroupId);
        assertEquals(result.getAccountId(), testAccountId);
    }

    @Test(dependsOnMethods = { "testUpdateAccessGroupRule" })
    public void testDeleteAccessGroupRule() {
        assertNotNull(testGroupId);
        assertNotNull(testClaimRuleId);

        RemoveAccessGroupRuleOptions options = new RemoveAccessGroupRuleOptions.Builder()
                .accessGroupId(testGroupId)
                .ruleId(testClaimRuleId)
                .build();
        Response<Void> response = service.removeAccessGroupRule(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test(dependsOnMethods = { "testDeleteAccessGroupRule" })
    public void testGetAccountSettings() {
        GetAccountSettingsOptions options = new GetAccountSettingsOptions.Builder()
                .accountId(testAccountId)
                .build();
        Response<AccountSettings> response = service.getAccountSettings(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        AccountSettings accountSettings = response.getResult();
        assertNotNull(accountSettings);
        assertEquals(accountSettings.getAccountId(), testAccountId);

        testAccountSettings = accountSettings;
    }

    @Test(dependsOnMethods = { "testGetAccountSettings" })
    public void testUpdateAccountSettings() {
        UpdateAccountSettingsOptions options = new UpdateAccountSettingsOptions.Builder()
                .accountId(testAccountId)
                .publicAccessEnabled(testAccountSettings.isPublicAccessEnabled())
                .build();
        Response<AccountSettings> response = service.updateAccountSettings(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        AccountSettings accountSettings = response.getResult();
        assertNotNull(accountSettings);
        assertEquals(accountSettings.getAccountId(), testAccountId);
        assertEquals(accountSettings.isPublicAccessEnabled(), options.publicAccessEnabled());
    }

    @Test(dependsOnMethods = { "testUpdateAccountSettings" })
    public void testCreateTemplate() throws Exception {
        try {
            MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
                    .add(true)
                    .remove(false)
                    .build();

            Members membersModel = new Members.Builder()
                    .users(java.util.Arrays.asList("IBMid-50PJGPKYJJ", "IBMid-665000T8WY"))
                    .actionControls(membersActionControlsModel)
                    .build();

            Conditions conditionsModel = new Conditions.Builder()
                    .claim("blueGroup")
                    .operator("CONTAINS")
                    .value("\"test-bluegroup-saml\"")
                    .build();

            RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
                    .remove(false)
                    .build();

            AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
                    .name("Manager group rule")
                    .expiration(Long.valueOf("12"))
                    .realmName("https://idp.example.org/SAML2")
                    .conditions(java.util.Arrays.asList(conditionsModel))
                    .actionControls(ruleActionControlsModel)
                    .build();

            AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
                    .add(false)
                    .remove(true)
                    .build();

            Assertions assertionsModel = new Assertions.Builder()
                    .rules(java.util.Arrays.asList(assertionsRuleModel))
                    .actionControls(assertionsActionControlsModel)
                    .build();

            AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
                    .add(false)
                    .build();

            GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
                    .access(accessActionControlsModel)
                    .build();

            AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
                    .name("IAM Admin Group")
                    .description("This access group template allows admin access to all IAM platform services in the account.")
                    .members(membersModel)
                    .assertions(assertionsModel)
                    .actionControls(groupActionControlsModel)
                    .build();

            PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
                    .id(testPolicyTemplateId)
                    .version("1")
                    .build();

            CreateTemplateOptions createTemplateOptions = new CreateTemplateOptions.Builder()
                    .name("IAM Admin Group template")
                    .accountId(testAccountId)
                    .description("This access group template allows admin access to all IAM platform services in the account.")
                    .group(accessGroupRequestModel)
                    .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<TemplateResponse> response = service.createTemplate(createTemplateOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            TemplateResponse templateResponseResult = response.getResult();
            testTemplateId = templateResponseResult.getId();
            assertNotNull(templateResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateTemplate" })
    public void testListTemplates() throws Exception {
        try {
            ListTemplatesOptions listTemplatesOptions = new ListTemplatesOptions.Builder()
                    .accountId(testAccountId)
                    .transactionId("testString")
                    .limit(Long.valueOf("50"))
                    .offset(Long.valueOf("0"))
                    .verbose(true)
                    .build();

            // Invoke operation
            Response<ListTemplatesResponse> response = service.listTemplates(listTemplatesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ListTemplatesResponse listTemplatesResponseResult = response.getResult();

            assertNotNull(listTemplatesResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTemplates" })
    public void testListTemplatesWithPager() throws Exception {
        try {
            ListTemplatesOptions options = new ListTemplatesOptions.Builder()
                    .accountId(testAccountId)
                    .transactionId("testString")
                    .limit(Long.valueOf("50"))
                    .verbose(true)
                    .build();

            // Test getNext().
            List<GroupTemplate> allResults = new ArrayList<>();
            TemplatesPager pager = new TemplatesPager(service, options);
            while (pager.hasNext()) {
                List<GroupTemplate> nextPage = pager.getNext();
                assertNotNull(nextPage);
                allResults.addAll(nextPage);
            }
            assertFalse(allResults.isEmpty());

            // Test getAll();
            pager = new TemplatesPager(service, options);
            List<GroupTemplate> allItems = pager.getAll();
            assertNotNull(allItems);
            assertFalse(allItems.isEmpty());

            assertEquals(allItems.size(), allResults.size());
            System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTemplates" })
    public void testCreateTemplateVersion() throws Exception {
        try {
            MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
                    .add(true)
                    .remove(false)
                    .build();

            Members membersModel = new Members.Builder()
                    .users(java.util.Arrays.asList("IBMid-50PJGPKYJJ", "IBMid-665000T8WY"))
                    .actionControls(membersActionControlsModel)
                    .build();

            Conditions conditionsModel = new Conditions.Builder()
                    .claim("blueGroup")
                    .operator("CONTAINS")
                    .value("\"test-bluegroup-saml\"")
                    .build();

            RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
                    .remove(true)
                    .build();

            AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
                    .name("Manager group rule")
                    .expiration(Long.valueOf("12"))
                    .realmName("https://idp.example.org/SAML2")
                    .conditions(java.util.Arrays.asList(conditionsModel))
                    .actionControls(ruleActionControlsModel)
                    .build();

            AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
                    .add(false)
                    .remove(true)
                    .build();

            Assertions assertionsModel = new Assertions.Builder()
                    .rules(java.util.Arrays.asList(assertionsRuleModel))
                    .actionControls(assertionsActionControlsModel)
                    .build();

            AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
                    .add(false)
                    .build();

            GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
                    .access(accessActionControlsModel)
                    .build();

            AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
                    .name("IAM Admin Group 8")
                    .description("This access group template allows admin access to all IAM platform services in the account.")
                    .members(membersModel)
                    .assertions(assertionsModel)
                    .actionControls(groupActionControlsModel)
                    .build();

            PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
                    .id(testPolicyTemplateId)
                    .version("1")
                    .build();

            CreateTemplateVersionOptions createTemplateVersionOptions = new CreateTemplateVersionOptions.Builder()
                    .templateId(testTemplateId)
                    .name("IAM Admin Group template 2")
                    .description("This access group template allows admin access to all IAM platform services in the account.")
                    .group(accessGroupRequestModel)
                    .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<TemplateVersionResponse> response = service.createTemplateVersion(createTemplateVersionOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            TemplateVersionResponse templateVersionResponseResult = response.getResult();

            assertNotNull(templateVersionResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateTemplateVersion" })
    public void testListTemplateVersions() throws Exception {
        try {
            ListTemplateVersionsOptions listTemplateVersionsOptions = new ListTemplateVersionsOptions.Builder()
                    .templateId(testTemplateId)
                    .limit(Long.valueOf("100"))
                    .offset(Long.valueOf("0"))
                    .build();

            // Invoke operation
            Response<ListTemplateVersionsResponse> response = service.listTemplateVersions(listTemplateVersionsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ListTemplateVersionsResponse listTemplateVersionsResponseResult = response.getResult();

            assertNotNull(listTemplateVersionsResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTemplateVersions" })
    public void testListTemplateVersionsWithPager() throws Exception {
        try {
            ListTemplateVersionsOptions options = new ListTemplateVersionsOptions.Builder()
                    .templateId(testTemplateId)
                    .limit(Long.valueOf("100"))
                    .build();

            // Test getNext().
            List<ListTemplateVersionResponse> allResults = new ArrayList<>();
            TemplateVersionsPager pager = new TemplateVersionsPager(service, options);
            while (pager.hasNext()) {
                List<ListTemplateVersionResponse> nextPage = pager.getNext();
                assertNotNull(nextPage);
                allResults.addAll(nextPage);
            }
            assertFalse(allResults.isEmpty());

            // Test getAll();
            pager = new TemplateVersionsPager(service, options);
            List<ListTemplateVersionResponse> allItems = pager.getAll();
            assertNotNull(allItems);
            assertFalse(allItems.isEmpty());

            assertEquals(allItems.size(), allResults.size());
            System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListTemplateVersionsWithPager" })
    public void testGetTemplateVersion() throws Exception {
        try {
            GetTemplateVersionOptions getTemplateVersionOptions = new GetTemplateVersionOptions.Builder()
                    .templateId(testTemplateId)
                    .versionNum("1")
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<TemplateVersionResponse> response = service.getTemplateVersion(getTemplateVersionOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TemplateVersionResponse templateVersionResponseResult = response.getResult();
            testTemplateETag = response.getHeaders().values("Etag").get(0);
            assertNotNull(templateVersionResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetTemplateVersion" })
    public void testUpdateTemplateVersion() throws Exception {
        try {
            MembersActionControls membersActionControlsModel = new MembersActionControls.Builder()
                    .add(true)
                    .remove(false)
                    .build();

            Members membersModel = new Members.Builder()
                    .users(java.util.Arrays.asList("IBMid-665000T8WY"))
                    .actionControls(membersActionControlsModel)
                    .build();

            Conditions conditionsModel = new Conditions.Builder()
                    .claim("blueGroup")
                    .operator("CONTAINS")
                    .value("\"test-bluegroup-saml\"")
                    .build();

            RuleActionControls ruleActionControlsModel = new RuleActionControls.Builder()
                    .remove(false)
                    .build();

            AssertionsRule assertionsRuleModel = new AssertionsRule.Builder()
                    .name("Manager group rule")
                    .expiration(Long.valueOf("12"))
                    .realmName("https://idp.example.org/SAML2")
                    .conditions(java.util.Arrays.asList(conditionsModel))
                    .actionControls(ruleActionControlsModel)
                    .build();

            AssertionsActionControls assertionsActionControlsModel = new AssertionsActionControls.Builder()
                    .add(false)
                    .remove(true)
                    .build();

            Assertions assertionsModel = new Assertions.Builder()
                    .rules(java.util.Arrays.asList(assertionsRuleModel))
                    .actionControls(assertionsActionControlsModel)
                    .build();

            AccessActionControls accessActionControlsModel = new AccessActionControls.Builder()
                    .add(false)
                    .build();

            GroupActionControls groupActionControlsModel = new GroupActionControls.Builder()
                    .access(accessActionControlsModel)
                    .build();

            AccessGroupRequest accessGroupRequestModel = new AccessGroupRequest.Builder()
                    .name("IAM Admin Group 8")
                    .description("This access group template allows admin access to all IAM platform services in the account.")
                    .members(membersModel)
                    .assertions(assertionsModel)
                    .actionControls(groupActionControlsModel)
                    .build();

            PolicyTemplates policyTemplatesModel = new PolicyTemplates.Builder()
                    .id(testPolicyTemplateId)
                    .version("1")
                    .build();

            UpdateTemplateVersionOptions updateTemplateVersionOptions = new UpdateTemplateVersionOptions.Builder()
                    .templateId(testTemplateId)
                    .versionNum("1")
                    .ifMatch(testTemplateETag)
                    .name("IAM Admin Group template 2")
                    .description("This access group template allows admin access to all IAM platform services in the account.")
                    .group(accessGroupRequestModel)
                    .policyTemplateReferences(java.util.Arrays.asList(policyTemplatesModel))
                    .transactionId("83adf5bd-de790caa3")
                    .build();

            // Invoke operation
            Response<TemplateVersionResponse> response = service.updateTemplateVersion(updateTemplateVersionOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            TemplateVersionResponse templateVersionResponseResult = response.getResult();

            assertNotNull(templateVersionResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateTemplateVersion" })
    public void testGetLatestTemplateVersion() throws Exception {
        try {
            GetLatestTemplateVersionOptions getLatestTemplateVersionOptions = new GetLatestTemplateVersionOptions.Builder()
                    .templateId(testTemplateId)
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<TemplateVersionResponse> response = service.getLatestTemplateVersion(getLatestTemplateVersionOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TemplateVersionResponse templateVersionResponseResult = response.getResult();
            testTemplateVersionETag = response.getHeaders().values("Etag").get(0);
            assertNotNull(templateVersionResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetLatestTemplateVersion" })
    public void testCommitTemplate() throws Exception {
        try {
            CommitTemplateOptions commitTemplateOptions = new CommitTemplateOptions.Builder()
                    .templateId(testTemplateId)
                    .versionNum("2")
                    .ifMatch(testTemplateVersionETag)
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<Void> response = service.commitTemplate(commitTemplateOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCommitTemplate" })
    public void testCreateAssignment() throws Exception {
        try {
            CreateAssignmentOptions createAssignmentOptions = new CreateAssignmentOptions.Builder()
                    .templateId(testTemplateId)
                    .templateVersion("2")
                    .targetType("AccountGroup")
                    .target(testAccountGroupId)
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<TemplateAssignmentResponse> response = service.createAssignment(createAssignmentOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);

            TemplateAssignmentResponse templateAssignmentResponseResult = response.getResult();
            testAssignmentId = templateAssignmentResponseResult.getId();

            assertNotNull(templateAssignmentResponseResult);
            Thread.sleep(60000);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateAssignment" })
    public void testListAssignments() throws Exception {
        try {
            ListAssignmentsOptions listAssignmentsOptions = new ListAssignmentsOptions.Builder()
                    .accountId(testAccountId)
                    .build();

            // Invoke operation
            Response<ListTemplateAssignmentResponse> response = service.listAssignments(listAssignmentsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ListTemplateAssignmentResponse listTemplateAssignmentResponseResult = response.getResult();

            assertNotNull(listTemplateAssignmentResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListAssignments" })
    public void testGetAssignment() throws Exception {
        try {
            GetAssignmentOptions getAssignmentOptions = new GetAssignmentOptions.Builder()
                    .assignmentId(testAssignmentId)
                    .transactionId("testString")
                    .verbose(false)
                    .build();

            // Invoke operation
            Response<TemplateAssignmentVerboseResponse> response = service.getAssignment(getAssignmentOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TemplateAssignmentVerboseResponse templateAssignmentVerboseResponseResult = response.getResult();
            testAssignmentETag = response.getHeaders().values("Etag").get(0);
            assertNotNull(templateAssignmentVerboseResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetAssignment" })
    public void testUpdateAssignment() throws Exception {
        try {
            UpdateAssignmentOptions updateAssignmentOptions = new UpdateAssignmentOptions.Builder()
                    .assignmentId(testAssignmentId)
                    .ifMatch(testAssignmentETag)
                    .templateVersion("2")
                    .build();

            // Invoke operation
            Response<TemplateAssignmentVerboseResponse> response = service.updateAssignment(updateAssignmentOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);

            TemplateAssignmentVerboseResponse templateAssignmentVerboseResponseResult = response.getResult();
            Thread.sleep(60000);
            assertNotNull(templateAssignmentVerboseResponseResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateAssignment" })
    public void testDeleteAssignment() throws Exception {
        try {
            DeleteAssignmentOptions deleteAssignmentOptions = new DeleteAssignmentOptions.Builder()
                    .assignmentId(testAssignmentId)
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteAssignment(deleteAssignmentOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);
            Thread.sleep(90000);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteAssignment" })
    public void testDeleteTemplateVersion() throws Exception {
        try {
            DeleteTemplateVersionOptions deleteTemplateVersionOptions = new DeleteTemplateVersionOptions.Builder()
                    .templateId(testTemplateId)
                    .versionNum("1")
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteTemplateVersion(deleteTemplateVersionOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
            Thread.sleep(30000);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteTemplateVersion" })
    public void testDeleteTemplate() throws Exception {
        try {
            DeleteTemplateOptions deleteTemplateOptions = new DeleteTemplateOptions.Builder()
                    .templateId(testTemplateId)
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteTemplate(deleteTemplateOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @AfterClass
    public void tearDown() {
        // Delete all the access groups that we created during the test.
        //
        // List all groups in the account (minus the public access group)
        ListAccessGroupsOptions options = new ListAccessGroupsOptions.Builder()
                .accountId(testAccountId)
                .hidePublicAccess(true)
                .build();

        Response<GroupsList> response = service.listAccessGroups(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        // Iterate across the groups
        GroupsList result = response.getResult();
        assertNotNull(result);
        for (Group group : result.getGroups()) {

            // Force delete the test group (or any test groups older than 5 minutes)
            if (TEST_GROUP_NAME.equals(group.getName())) {
                Date now = new Date();
                final int FIVE_MINUTES = 5 * 60 * 1000;
                long createdAt = group.getCreatedAt().getTime();
                long fiveMinutesAgo = now.getTime() - FIVE_MINUTES;

                if (testGroupId.equals(group.getId()) || createdAt < fiveMinutesAgo) {
                    DeleteAccessGroupOptions deleteOptions = new DeleteAccessGroupOptions.Builder()
                            .accessGroupId(group.getId()).force(true).build();
                    Response<Void> deleteResponse = service.deleteAccessGroup(deleteOptions).execute();
                    assertNotNull(deleteResponse);
                    assertEquals(deleteResponse.getStatusCode(), 204);
                }
            }
        }

    }
}
