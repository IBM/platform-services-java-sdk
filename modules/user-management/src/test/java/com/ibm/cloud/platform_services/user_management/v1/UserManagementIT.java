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

package com.ibm.cloud.platform_services.user_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the UserManagement service.
 */
public class UserManagementIT extends SdkIntegrationTestBase {
    public UserManagement service = null;
    public UserManagement alternateService = null;
    public static Map<String, String> config = null;
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
    public String userId = null;

    public static final String ACCOUNT_ID = "1aa434630b594b8a88b961a44c9eb2a9";
    public static final String IAM_USERID = "IBMid-550008BJPR";
    public static final String INVITED_USER_EMAIL = "aminttest+linked_account_owner_11@mail.test.ibm.com";
    public static final String VIEWER_ROLEID = "crn:v1:bluemix:public:iam::::role:Viewer";
    public static final String ACCESS_GROUP_ID = "AccessGroupId-51675919-2bd7-4ce3-86e4-5faff8065574";

    @Override
    public String getConfigFilename() {
        return "../../user_management.env";
    }

    @Override
    public boolean loggingEnabled() {
        return false;
    }

    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = UserManagement.newInstance("USERMGMT1");
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        alternateService = UserManagement.newInstance("USERMGMT2");
        assertNotNull(alternateService);
        assertNotNull(alternateService.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties("USERMGMT1");
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

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

    @Test
    public void testUpdateUserSettings() throws Exception {
        try {
            UpdateUserSettingsOptions updateUserSettingsOptions = new UpdateUserSettingsOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_USERID)
                    .language("French")
                    .notificationLanguage("English")
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

    @Test
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
                start = getStartTokenFromURL(userListResult.getNextUrl());
            } while (start != null);

            log(String.format("Received a total of %d user profiles.\n", userProfiles.size()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
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
            Response<InvitedUserList> response = alternateService.inviteUsers(inviteUsersOptions).execute();
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

    @Test
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

    @Test
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

    @Test
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

    private String getStartTokenFromURL(String s) {
        try {
            if (s == null) {
                return null;
            }

            // Parse "s" as a URI and retrieve its decoded query string.
            URI uri = new URI(s);
            String query = uri.getQuery();
            if (query == null || query.isEmpty()) {
                return null;
            }

            // Parse the query string into a map of key/value pairs.
            Map<String, String> params = new LinkedHashMap<>();
            for (String param : query.split("&")) {
                String[] keyValue = param.split("=", 2);
                String value = keyValue.length > 1 ? keyValue[1] : null;
                if (!keyValue[0].isEmpty()) {
                    params.put(keyValue[0], value);
                }
            }

            return params.get("_start");
        } catch (Throwable t) {

        }

        return null;
    }
}
