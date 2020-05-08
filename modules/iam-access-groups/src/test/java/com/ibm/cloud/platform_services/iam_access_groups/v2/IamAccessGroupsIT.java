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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.platform_services.iam_access_groups.v2.model.*;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

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

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../iam_access_groups.env";
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
        assertNotNull(testAccountId);

        // Construct the service from our external configuration.
        service = IamAccessGroups.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        System.out.println("Using Account Id: " + testAccountId);
        System.out.println("Using Service URL: " + service.getServiceUrl());
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
    public void testListGroupMembers() {
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

    @Test(dependsOnMethods = { "testListGroupMembers" })
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

                try {

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    Date parsedDate = dateFormat.parse(group.getCreatedAt());
                    Date now = new Date();

                    final int FIVE_MINUTES = 5 * 60 * 1000;
                    long createdAt = parsedDate.getTime();
                    long fiveMinutesAgo = now.getTime() - FIVE_MINUTES;

                    if (testGroupId.equals(group.getId()) || createdAt < fiveMinutesAgo) {
                        DeleteAccessGroupOptions deleteOptions = new DeleteAccessGroupOptions.Builder()
                                .accessGroupId(group.getId()).force(true).build();
                        Response<Void> deleteResponse = service.deleteAccessGroup(deleteOptions).execute();
                        assertNotNull(deleteResponse);
                        assertEquals(deleteResponse.getStatusCode(), 204);
                    }

                }  catch (ParseException e) {
                    System.out.println("Exception :" + e);
                    System.out.println("Cleanup failed");
                    break;
                }
            }
        }

    }
}
