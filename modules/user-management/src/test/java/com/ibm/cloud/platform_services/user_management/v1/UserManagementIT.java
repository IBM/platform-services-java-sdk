/*
 * (C) Copyright IBM Corp. 2020, 2023.
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

package com.ibm.cloud.platform_services.user_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.platform_services.user_management.v1.model.Attribute;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.GetUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUser;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUserIamPolicy;
import com.ibm.cloud.platform_services.user_management.v1.model.InviteUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.InvitedUser;
import com.ibm.cloud.platform_services.user_management.v1.model.InvitedUserList;
import com.ibm.cloud.platform_services.user_management.v1.model.ListUsersOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.RemoveUserOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.Resource;
import com.ibm.cloud.platform_services.user_management.v1.model.Role;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserProfileOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.model.UserList;
import com.ibm.cloud.platform_services.user_management.v1.model.UserProfile;
import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.platform_services.user_management.v1.model.UsersPager;
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.UrlHelper;

/**
 * Integration test class for the UserManagement service.
 */
public class UserManagementIT extends SdkIntegrationTestBase {
    public UserManagement service = null;
    public UserManagement adminService = null;
    public static Map<String, String> config = null;
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
    public String userId = null;

    private static String ACCOUNT_ID;
    private static String IAM_USERID;
    private static String INVITED_USER_EMAIL;
    private static String VIEWER_ROLEID;
    private static String ACCESS_GROUP_ID;

    @Override
    public String getConfigFilename() {
        return "../../user_management.env";
    }

    @Override
    public boolean loggingEnabled() {
        return true;
    }

    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = UserManagement.newInstance(UserManagement.DEFAULT_SERVICE_NAME);
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

//        HttpConfigOptions options =
//            new HttpConfigOptions.Builder()
//                .loggingLevel(HttpConfigOptions.LoggingLevel.BODY)
//            .build();
//        service.configureClient(options);

        adminService = UserManagement.newInstance("USER_MANAGEMENT_ADMIN");
        assertNotNull(adminService);
        assertNotNull(adminService.getServiceUrl());
//        adminService.configureClient(options);

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(UserManagement.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        ACCOUNT_ID = config.get("ACCOUNT_ID");
        IAM_USERID = config.get("USER_ID");
        INVITED_USER_EMAIL = config.get("MEMBER_EMAIL");
        VIEWER_ROLEID = config.get("VIEWER_ROLE_ID");
        ACCESS_GROUP_ID = config.get("ACCESS_GROUP_ID");

        assertNotNull(ACCOUNT_ID);
        assertNotNull(IAM_USERID);
        assertNotNull(INVITED_USER_EMAIL);
        assertNotNull(VIEWER_ROLEID);
        assertNotNull(ACCESS_GROUP_ID);

        log(String.format("Service URL: %s", service.getServiceUrl()));
        log("Setup complete.");
    }

    @Test
    public void testGetUserSettings() throws Exception {
        try {
            GetUserSettingsOptions getUserSettingsOptions = new GetUserSettingsOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_USERID)
                    .build();

            // Invoke operation
            Response<UserSettings> response = service.getUserSettings(getUserSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            UserSettings userSettingsResult = response.getResult();
            assertNotNull(userSettingsResult);
            log(String.format("getUserSettings() result:\n%s", userSettingsResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testGetUserSettings" })
    public void testUpdateUserSettings() throws Exception {
        try {
            UpdateUserSettingsOptions updateUserSettingsOptions = new UpdateUserSettingsOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_USERID)
                    .allowedIpAddresses("32.96.110.50,172.16.254.1")
                    .selfManage(true)
                    .build();

            // Invoke operation
            Response<Void> response = service.updateUserSettings(updateUserSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testUpdateUserSettings" })
    public void testListUsers() throws Exception {
        try {
            List<UserProfile> userProfiles = new ArrayList<>();

            long pageSize = 10;
            String start = null;
            do {
                ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
                        .accountId(ACCOUNT_ID)
                        .limit(pageSize)
                        .start(start)
                        .build();

                // Invoke operation
                Response<UserList> response = service.listUsers(listUsersOptions).execute();
                // Validate response
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                UserList userListResult = response.getResult();
                assertNotNull(userListResult);
                // log(String.format("listUsers() result:\n%s", userListResult.toString()));

                // Add this page of results to our overall list.
                for (UserProfile userProfile : userListResult.getResources()) {
                    userProfiles.add(userProfile);
                }

                // Get "start" value for next page.
                start = UrlHelper.getQueryParam(userListResult.getNextUrl(), "_start");
            } while (start != null);

            log(String.format("Received a total of %d user profiles.\n", userProfiles.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testListUsers" })
    public void testListUsersIncludeSettings() throws Exception {
        try {
            List<UserProfile> userProfiles = new ArrayList<>();

            long pageSize = 10;
            String start = null;
            do {
                ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
                        .accountId(ACCOUNT_ID)
                        .includeSettings(true)
                        .limit(pageSize)
                        .start(start)
                        .build();

                // Invoke operation
                Response<UserList> response = service.listUsers(listUsersOptions).execute();
                // Validate response
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                UserList userListResult = response.getResult();
                assertNotNull(userListResult);
                // log(String.format("listUsers() result:\n%s", userListResult.toString()));

                // Add this page of results to our overall list.
                for (UserProfile userProfile : userListResult.getResources()) {
                    userProfiles.add(userProfile);
                }

                // Get "start" value for next page.
                start = UrlHelper.getQueryParam(userListResult.getNextUrl(), "_start");
            } while (start != null);

            log(String.format("Received a total of %d user profiles.\n", userProfiles.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testListUsersIncludeSettings" })
    public void testListUsersWithSearch() throws Exception {
        try {
            List<UserProfile> userProfiles = new ArrayList<>();

            long pageSize = 10;
            String start = null;
            do {
                ListUsersOptions listUsersOptions = new ListUsersOptions.Builder()
                        .accountId(ACCOUNT_ID)
                        .search("state:ACTIVE")
                        .limit(pageSize)
                        .start(start)
                        .build();

                // Invoke operation
                Response<UserList> response = service.listUsers(listUsersOptions).execute();
                // Validate response
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                UserList userListResult = response.getResult();
                assertNotNull(userListResult);
                // log(String.format("listUsers() result:\n%s", userListResult.toString()));

                // Add this page of results to our overall list.
                for (UserProfile userProfile : userListResult.getResources()) {
                    userProfiles.add(userProfile);
                }

                // Get "start" value for next page.
                start = UrlHelper.getQueryParam(userListResult.getNextUrl(), "_start");
            } while (start != null);

            log(String.format("Received a total of %d user profiles.\n", userProfiles.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListUsersWithSearch" })
    public void testListUsersWithPager() throws Exception {
      try {
        ListUsersOptions options = new ListUsersOptions.Builder()
          .accountId(ACCOUNT_ID)
          .build();

        // Test getNext().
        List<UserProfile> allResults = new ArrayList<>();
        UsersPager pager = new UsersPager(service, options);
        while (pager.hasNext()) {
          List<UserProfile> nextPage = pager.getNext();
          assertNotNull(nextPage);
          allResults.addAll(nextPage);
        }
        assertFalse(allResults.isEmpty());

        // Test getAll();
        pager = new UsersPager(service, options);
        List<UserProfile> allItems = pager.getAll();
        assertNotNull(allItems);
        assertFalse(allItems.isEmpty());

        assertEquals(allItems.size(), allResults.size());
        System.out.println(String.format("Retrieved a total of %d item(s) with pagination.", allResults.size()));
      } catch (ServiceResponseException e) {
          fail(String.format("Service returned status code %d: %s%nError details: %s",
            e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
      }
    }

    @Test(dependsOnMethods={ "testListUsersWithPager" })
    public void testInviteUsers() throws Exception {
        try {
            InviteUser inviteUserModel = new InviteUser.Builder()
                    .email(INVITED_USER_EMAIL)
                    .accountRole("Member")
                    .build();

            Role roleModel = new Role.Builder()
                    .roleId(VIEWER_ROLEID)
                    .build();

            Attribute attributeModel = new Attribute.Builder()
                    .name("accountId")
                    .value(ACCOUNT_ID)
                    .build();

            Attribute attributeModel2 = new Attribute.Builder()
                    .name("resourceGroupId")
                    .value("*")
                    .build();

            Attribute[] attributeArray = new Attribute[] { attributeModel, attributeModel2 };

            Resource resourceModel = new Resource.Builder()
                    .attributes(new java.util.ArrayList<Attribute>(java.util.Arrays.asList(attributeArray)))
                    .build();

            InviteUserIamPolicy inviteUserIamPolicyModel = new InviteUserIamPolicy.Builder()
                    .type("access")
                    .roles(new java.util.ArrayList<Role>(java.util.Arrays.asList(roleModel)))
                    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
                    .build();

            InviteUsersOptions inviteUsersOptions = new InviteUsersOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .users(new java.util.ArrayList<InviteUser>(java.util.Arrays.asList(inviteUserModel)))
                    .iamPolicy(new java.util.ArrayList<InviteUserIamPolicy>(
                            java.util.Arrays.asList(inviteUserIamPolicyModel)))
                    .accessGroups(new java.util.ArrayList<String>(java.util.Arrays.asList(ACCESS_GROUP_ID)))
                    .build();

            // Invoke operation
            Response<InvitedUserList> response = adminService.inviteUsers(inviteUsersOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);

            InvitedUserList invitedUserListResult = response.getResult();
            assertNotNull(invitedUserListResult);

            List<InvitedUser> resources = invitedUserListResult.getResources();
            userId = resources.get(0).getId();

            log(String.format("inviteUsers() result:\n%s", invitedUserListResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testInviteUsers" })
    public void testGetUserProfile() throws Exception {
        try {
            GetUserProfileOptions getUserProfileOptions = new GetUserProfileOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_USERID)
                    .build();

            // Invoke operation
            Response<UserProfile> response = service.getUserProfile(getUserProfileOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            UserProfile userProfileResult = response.getResult();
            assertNotNull(userProfileResult);

            log(String.format("getUserProfile() result:\n%s", userProfileResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testGetUserProfile" })
    public void testUpdateUserProfile() throws Exception {
        try {
            UpdateUserProfileOptions updateUserProfileOptions = new UpdateUserProfileOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_USERID)
                    .firstname("John")
                    .lastname("Doe")
                    .state("ACTIVE")
                    .email("do_not_delete_user_without_iam_policy_stage@mail.test.ibm.com")
                    .build();

            // Invoke operation
            Response<Void> response = service.updateUserProfile(updateUserProfileOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returneinvitedUserListResultd status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods={ "testUpdateUserProfile" })
    public void testRemoveUser() throws Exception {
        try {
            RemoveUserOptions removeUsersOptions = new RemoveUserOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(userId)
                    .build();

            // Invoke operation
            Response<Void> response = service.removeUser(removeUsersOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }
}
