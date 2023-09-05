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

package com.ibm.cloud.platform_services.iam_identity.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.iam_identity.v1.model.*;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import okhttp3.HttpUrl;

/**
 * Integration test class for the IamIdentity service.
 */
public class IamIdentityIT extends SdkIntegrationTestBase {
    public IamIdentity service = null;
    public static Map<String, String> config = null;

    private static String APIKEY_NAME = "Java-SDK-IT-ApiKey";
    private static String SERVICEID_NAME = "Java-SDK-IT-ServiceId";
    private static String PROFILE_NAME_1 = "Java-SDK-IT-TrustedProfile1";
    private static String PROFILE_NAME_2 = "Java-SDK-IT-TrustedProfile2";
    private static String CLAIMRULE_TYPE = "Profile-SAML";
    private static String REALM_NAME = "https://sdk.test.realm/1234";
    private static String PROFILE_TEMPLATE_NAME = "Java-SDK-IT-TrustedProfileTemplate";
    private static String PROFILE_TEMPLATE_PROFILE_NAME = "Java-SDK-IT-TrustedProfile-FromTemplate";
    private static String ASSIGNMENT_TARGET_TYPE_ACCOUNT = "Account";
    private static String ACCOUNT_SETTINGS_TEMPLATE_NAME = "Java-SDK-IT-AccountSettingsTemplate";

    private static String ACCOUNT_ID;
    private static String IAM_ID;
    private static String IAM_ID_MEMBER;
    private static String IAM_APIKEY;
    private static String ENTERPRISE_ACCOUNT_ID;
    private static String ENTERPRISE_SUBACCOUNT_ID;

    private static String IAM_ID_INVALID = "IAM-InvalidId";
    private static String ACCOUNT_ID_INVALID = "Account-InvalidId";

    // Variables that hold values to be shared between the test methods.
    private String apikeyId1;
    private String apikeyEtag1;
    private String apikeyId2;

    private String serviceId1;
    private String serviceIdEtag1;

    private String profileId1;
    private String profile1IamId;
    private String profileId2;
    private String profileEtag;

    private String claimRuleId1;
    private String claimRuleId2;
    private String claimRuleEtag;

    private String linkId;

    private String accountSettingsEtag;

    private String reportReference;
    private String reportReferenceMfa;
    
    private String profileTemplateId;
    private long profileTemplateVersion;
    private String profileTemplateEtag;
    private String profileTemplateAssignmentId;
    private String profileTemplateAssignmentEtag;

    private String accountSettingsTemplateId;
    private long accountSettingsTemplateVersion;
    private String accountSettingsTemplateEtag;
    private String accountSettingsTemplateAssignmentId;
    private String accountSettingsTemplateAssignmentEtag;
    
    @Override
    public String getConfigFilename() {
        return "../../iam_identity.env";
    }

    @BeforeClass
    public void constructService() {

        if (skipTests()) {
            return;
        }

        service = IamIdentity.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        config = CredentialUtils.getServiceProperties(IamIdentity.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        ACCOUNT_ID = config.get("ACCOUNT_ID");
        IAM_ID = config.get("IAM_ID");
        IAM_ID_MEMBER = config.get("IAM_ID_MEMBER");
        IAM_APIKEY = config.get("APIKEY");
        ENTERPRISE_ACCOUNT_ID = config.get("ENTERPRISE_ACCOUNT_ID"); 
        ENTERPRISE_SUBACCOUNT_ID = config.get("ENTERPRISE_SUBACCOUNT_ID"); 

        profileId1 = config.get("profileId1");

        assertNotNull(ACCOUNT_ID);
        assertNotNull(IAM_ID);
        assertNotNull(IAM_ID_MEMBER);
        assertNotNull(IAM_APIKEY);

        // Make sure we start with a clean slate.
        cleanupResources();

    }

    @Test
    public void testCreateApiKey1() throws Exception {
        try {
            CreateApiKeyOptions createApiKeyOptions = new CreateApiKeyOptions.Builder()
                    .name(APIKEY_NAME)
                    .iamId(IAM_ID)
                    .description("JavaSDK test apikey #1")
                    .build();

            Response<ApiKey> response = service.createApiKey(createApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ApiKey apiKeyResult = response.getResult();
            assertNotNull(apiKeyResult);

            // Save the id for use by other test methods.
            apikeyId1 = apiKeyResult.getId();
            assertNotNull(apikeyId1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey1" })
    public void testCreateApiKey2() throws Exception {
        try {
            CreateApiKeyOptions createApiKeyOptions = new CreateApiKeyOptions.Builder()
                    .name(APIKEY_NAME)
                    .iamId(IAM_ID)
                    .description("JavaSDK test apikey #2")
                    .build();

            Response<ApiKey> response = service.createApiKey(createApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ApiKey apiKeyResult = response.getResult();
            assertNotNull(apiKeyResult);

            // Save the apikey id for use by other test methods.
            apikeyId2 = apiKeyResult.getId();
            assertNotNull(apikeyId2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey1" })
    public void testGetApiKey() throws Exception {
        assertNotNull(apikeyId1);
        try {
            GetApiKeyOptions getApiKeyOptions = new GetApiKeyOptions.Builder()
                    .id(apikeyId1)
                    .includeHistory(true)
                    .includeActivity(true)
                    .build();

            Response<ApiKey> response = service.getApiKey(getApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();
            assertNotNull(apiKeyResult);

            assertEquals(apiKeyResult.getId(), apikeyId1);
            assertEquals(apiKeyResult.getName(), APIKEY_NAME);
            assertEquals(apiKeyResult.getIamId(), IAM_ID);
            assertEquals(apiKeyResult.getAccountId(), ACCOUNT_ID);
            assertEquals(apiKeyResult.getCreatedBy(), IAM_ID);
            assertNotNull(apiKeyResult.getCreatedAt());
            assertFalse(apiKeyResult.isLocked());
            assertNotNull(apiKeyResult.getCrn());

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            apikeyEtag1 = response.getHeaders().values("Etag").get(0);
            assertNotNull(apikeyEtag1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey2" })
    public void testGetApiKeysDetails() throws Exception {
        try {
            GetApiKeysDetailsOptions getApiKeysDetailsOptions = new GetApiKeysDetailsOptions.Builder()
                    .iamApiKey(IAM_APIKEY)
                    .includeHistory(true)
                    .build();

            Response<ApiKey> response = service.getApiKeysDetails(getApiKeysDetailsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();
            assertNotNull(apiKeyResult);

            assertEquals(apiKeyResult.getAccountId(), ACCOUNT_ID);
            assertEquals(apiKeyResult.getIamId(), IAM_ID);
            assertNotNull(apiKeyResult.getHistory());
            assertNotEquals(apiKeyResult.getHistory().size(), 0);
            assertFalse(apiKeyResult.isLocked());
            assertEquals(apiKeyResult.getCreatedBy(), IAM_ID);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey1", "testCreateApiKey2" })
    public void testListApiKeys() throws Exception {
        try {
            List<ApiKey> apiKeys = new ArrayList<>();

            // Retrieve one api key at a time and save off the objects that we're interested in,
            // then validate the results at the end.
            long pagesize = 1;

            String pagetoken = null;
            do {
                // Get the "next" page of results.
                ListApiKeysOptions listApiKeysOptions = new ListApiKeysOptions.Builder()
                        .accountId(ACCOUNT_ID)
                        .iamId(IAM_ID)
                        .pagetoken(pagetoken)
                        .pagesize(pagesize)
                        .includeHistory(false)
                        .build();

                Response<ApiKeyList> response = service.listApiKeys(listApiKeysOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                ApiKeyList apiKeyListResult = response.getResult();
                assertNotNull(apiKeyListResult);

                assertEquals(apiKeyListResult.getLimit(), Long.valueOf(pagesize));

                // Walk through the returned results and save off the apikeys that we created earlier.
                for (ApiKey apikey : apiKeyListResult.getApikeys()) {
                    if (APIKEY_NAME.equals(apikey.getName())) {
                        apiKeys.add(apikey);
                    }
                }

                // Retrieve the pagetoken value for the next page of results.
                pagetoken = getPageTokenFromURL(apiKeyListResult.getNext());
            } while (pagetoken != null);

            // Make sure we got back two apikeys.
            assertEquals(apiKeys.size(), 2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListApiKeys" })
    public void testUpdateApiKey() throws Exception {
        assertNotNull(apikeyId1);
        assertNotNull(apikeyEtag1);
        try {
            String newDescription = "This is an updated description.";
            UpdateApiKeyOptions updateApiKeyOptions = new UpdateApiKeyOptions.Builder()
                    .id(apikeyId1)
                    .ifMatch(apikeyEtag1)
                    .description(newDescription)
                    .build();

            Response<ApiKey> response = service.updateApiKey(updateApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();
            assertNotNull(apiKeyResult);

            assertEquals(apiKeyResult.getDescription(), newDescription);
            assertEquals(apiKeyResult.getName(), APIKEY_NAME);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateApiKey" })
    public void testLockApiKey() throws Exception {
        assertNotNull(apikeyId2);
        try {
            LockApiKeyOptions lockApiKeyOptions = new LockApiKeyOptions.Builder()
                    .id(apikeyId2)
                    .build();
            Response<Void> response = service.lockApiKey(lockApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now retrieve the apikey and make sure it is locked.
            ApiKey apikey = getApikey(apikeyId2);
            assertNotNull(apikey);
            assertTrue(apikey.isLocked());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testLockApiKey" })
    public void testUnlockApiKey() throws Exception {
        assertNotNull(apikeyId2);
        try {
            UnlockApiKeyOptions unlockApiKeyOptions = new UnlockApiKeyOptions.Builder()
                    .id(apikeyId2)
                    .build();
            Response<Void> response = service.unlockApiKey(unlockApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now retrieve the apikey and make sure it is unlocked.
            ApiKey apikey = getApikey(apikeyId2);
            assertNotNull(apikey);
            assertFalse(apikey.isLocked());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUnlockApiKey" })
    public void testDeleteApiKey1() throws Exception {
        sleep(1);
        assertNotNull(apikeyId1);
        try {
            DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
                    .id(apikeyId1)
                    .build();
            Response<Void> response = service.deleteApiKey(deleteApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            ApiKey apikey = getApikey(apikeyId1);
            assertNull(apikey);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteApiKey1" })
    public void testDeleteApiKey2() throws Exception {
        sleep(2);
        assertNotNull(apikeyId2);
        try {
            DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
                    .id(apikeyId2)
                    .build();
            Response<Void> response = service.deleteApiKey(deleteApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            ApiKey apikey = getApikey(apikeyId2);
            assertNull(apikey);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateServiceId() throws Exception {
        try {
//            CreateApiKeyRequest createApiKeyRequestModel = new CreateApiKeyRequest.Builder()
//                    .name(APIKEY_NAME)
//                    .description("JavaSDK test apikey for serviceId")
//                    .iamId(IAM_ID)
//                    .accountId(ACCOUNT_ID)
//                    .build();

            CreateServiceIdOptions createServiceIdOptions = new CreateServiceIdOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .name(SERVICEID_NAME)
                    .description("JavaSDK test serviceId")
                    // .apikey(createApiKeyRequestModel)
                    .build();
            Response<ServiceId> response = service.createServiceId(createServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ServiceId serviceIdResult = response.getResult();
            assertNotNull(serviceIdResult);

            // Save off the id for use in other test methods.
            serviceId1 = serviceIdResult.getId();
            assertNotNull(serviceId1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateServiceId" })
    public void testGetServiceId() throws Exception {
        assertNotNull(serviceId1);
        try {
            GetServiceIdOptions getServiceIdOptions = new GetServiceIdOptions.Builder()
                    .id(serviceId1)
                    .includeHistory(true)
                    .includeActivity(true)
                    .build();

            Response<ServiceId> response = service.getServiceId(getServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();
            assertNotNull(serviceIdResult);

            assertEquals(serviceIdResult.getDescription(), "JavaSDK test serviceId");
            assertEquals(serviceIdResult.getName(), SERVICEID_NAME);
            assertNotNull(serviceIdResult.getHistory());
            assertNotEquals(serviceIdResult.getHistory().size(), 0);

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            serviceIdEtag1 = response.getHeaders().values("Etag").get(0);
            assertNotNull(serviceIdEtag1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetServiceId" })
    public void testListServiceIds() throws Exception {
        try {
            ListServiceIdsOptions listServiceIdsOptions = new ListServiceIdsOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .name(SERVICEID_NAME)
                    .pagesize(100)
                    .build();

            Response<ServiceIdList> response = service.listServiceIds(listServiceIdsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            ServiceIdList serviceIdListResult = response.getResult();
            assertNotNull(serviceIdListResult);

            // Verify that we received exactly 1 serviceId.
            assertNotNull(serviceIdListResult.getServiceids());
            assertEquals(serviceIdListResult.getServiceids().size(), 1);
            assertNotNull(serviceIdListResult.getOffset());
            assertEquals(serviceIdListResult.getOffset(), Long.valueOf(0));
            assertNull(serviceIdListResult.getNext());

            assertEquals(serviceIdListResult.getServiceids().get(0).getName(), SERVICEID_NAME);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListServiceIds" })
    public void testUpdateServiceId() throws Exception {
        assertNotNull(serviceId1);
        assertNotNull(serviceIdEtag1);
        try {
            String newDescription = "This is an updated description";
            UpdateServiceIdOptions updateServiceIdOptions = new UpdateServiceIdOptions.Builder()
                    .id(serviceId1)
                    .ifMatch(serviceIdEtag1)
                    .description("This is an updated description")
                    .build();

            Response<ServiceId> response = service.updateServiceId(updateServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();
            assertNotNull(serviceIdResult);

            assertEquals(serviceIdResult.getDescription(), newDescription);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateServiceId" })
    public void testLockServiceId() throws Exception {
        assertNotNull(serviceId1);
        try {
            LockServiceIdOptions lockServiceIdOptions = new LockServiceIdOptions.Builder()
                    .id(serviceId1)
                    .build();

            Response<Void> response = service.lockServiceId(lockServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            ServiceId serviceId = getServiceId(serviceId1);
            assertNotNull(serviceId);
            assertTrue(serviceId.isLocked());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testLockServiceId" })
    public void testUnlockServiceId() throws Exception {
        assertNotNull(serviceId1);
        try {
            UnlockServiceIdOptions unlockServiceIdOptions = new UnlockServiceIdOptions.Builder()
                    .id(serviceId1)
                    .build();

            Response<Void> response = service.unlockServiceId(unlockServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            ServiceId serviceId = getServiceId(serviceId1);
            assertNotNull(serviceId);
            assertFalse(serviceId.isLocked());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUnlockServiceId" })
    public void testDeleteServiceId() throws Exception {
        assertNotNull(serviceId1);
        try {
            DeleteServiceIdOptions deleteServiceIdOptions = new DeleteServiceIdOptions.Builder()
                    .id(serviceId1)
                    .build();

            Response<Void> response = service.deleteServiceId(deleteServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            ServiceId serviceId = getServiceId(serviceId1);
            assertNull(serviceId);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateApiKeyNegative() throws Exception {
        try {
            CreateApiKeyOptions createApiKeyOptions = new CreateApiKeyOptions.Builder()
                    .name(APIKEY_NAME)
                    .iamId(IAM_ID_INVALID)
                    .description("Negative Test")
                    .accountId(ACCOUNT_ID_INVALID)
                    .build();

            service.createApiKey(createApiKeyOptions).execute();
            fail("Invalid iam_id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testDeleteApiKeyNegative() throws Exception {
        try {
            DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
                    .id("InvalidApiKey")
                    .build();
            service.deleteApiKey(deleteApiKeyOptions).execute();
            fail("Invalid apikey id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testCreateServiceIdNegative() throws Exception {
        try {
//            CreateApiKeyRequest createApiKeyRequestModel = new CreateApiKeyRequest.Builder()
//                    .name(APIKEY_NAME)
//                    .description("JavaSDK test apikey for serviceId")
//                    .iamId(IAM_ID)
//                    .accountId(ACCOUNT_ID)
//                    .build();

            CreateServiceIdOptions createServiceIdOptions = new CreateServiceIdOptions.Builder()
                    .accountId("InvalidAccountId")
                    .name("NegativeTest")
                    .description("JavaSDK test serviceId")
                    // .apikey(createApiKeyRequestModel)
                    .build();

            service.createServiceId(createServiceIdOptions).execute();
            fail("Invalid account_id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testGetServiceIdNegative() throws Exception {
        try {
            GetServiceIdOptions getServiceIdOptions = new GetServiceIdOptions.Builder()
                    .id("InvalidServiceId")
                    .includeHistory(true)
                    .build();

            service.getServiceId(getServiceIdOptions).execute();
            fail("Invalid service id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testCreateProfile1() throws Exception {
        try {
            CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
                    .name(PROFILE_NAME_1)
                    .description("JavaSDK test Profile #1")
                    .accountId(ACCOUNT_ID)
                    .build();
            Response<TrustedProfile> response = service.createProfile(createProfileOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            TrustedProfile trustedProfileResult = response.getResult();
            assertNotNull(trustedProfileResult);

            // Save the id for use by other test methods.
            profileId1 = trustedProfileResult.getId();
            profile1IamId = trustedProfileResult.getIamId();
            assertNotNull(profileId1);
            assertNotNull(profile1IamId);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateProfile2() throws Exception {
        try {
            CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
                    .name(PROFILE_NAME_2)
                    .description("JavaSDK test Profile #2")
                    .accountId(ACCOUNT_ID)
                    .build();
            Response<TrustedProfile> response = service.createProfile(createProfileOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            TrustedProfile trustedProfileResult = response.getResult();
            assertNotNull(trustedProfileResult);

            profileId2 = trustedProfileResult.getId();
            assertNotNull(profileId2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateProfile1" })
    public void testGetProfile() throws Exception {
        assertNotNull(profileId1);
        try {
            GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
                    .profileId(profileId1)
                    .includeActivity(true)
                    .build();

            Response<TrustedProfile> response = service.getProfile(getProfileOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TrustedProfile trustedProfileResult = response.getResult();
            assertNotNull(trustedProfileResult);

            assertEquals(trustedProfileResult.getId(), profileId1);
            assertEquals(trustedProfileResult.getName(), PROFILE_NAME_1);
            assertEquals(trustedProfileResult.getIamId(), profile1IamId);
            assertEquals(trustedProfileResult.getAccountId(), ACCOUNT_ID);
            assertNotNull(trustedProfileResult.getCrn());

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            profileEtag = response.getHeaders().values("Etag").get(0);
            assertNotNull(profileEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateProfile1", "testCreateProfile2" })
    public void testListProfiles() throws Exception {
        try {
            List<TrustedProfile> profiles = new ArrayList<>();

            // Retrieve one profile at a time and save off the objects that we're interested in,
            // then validate the results at the end.
            long pagesize = 1;

            String pagetoken = null;
            do {
                // Get the "next" page of results.
                ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
                        .accountId(ACCOUNT_ID)
                        .pagetoken(pagetoken)
                        .pagesize(pagesize)
                        .includeHistory(false)
                        .build();

                Response<TrustedProfilesList> response = service.listProfiles(listProfilesOptions).execute();
                assertNotNull(response);
                assertEquals(response.getStatusCode(), 200);

                TrustedProfilesList profilesListResult = response.getResult();
                assertNotNull(profilesListResult);

                assertEquals(profilesListResult.getLimit(), Long.valueOf(pagesize));

                // Walk through the returned results
                for (TrustedProfile profile : profilesListResult.getProfiles()) {
                    if (PROFILE_NAME_1.equals(profile.getName()) || PROFILE_NAME_2.equals(profile.getName())) {
                        profiles.add(profile);
                    }
                }

                // Retrieve the pagetoken value for the next page of results.
                pagetoken = getPageTokenFromURL(profilesListResult.getNext());
            } while (pagetoken != null);

            assertEquals(profiles.size(), 2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListProfiles" })
    public void testUpdateProfile() throws Exception {
        assertNotNull(profileId1);
        assertNotNull(profileEtag);
        try {
            String newDescription = "updated description";
            UpdateProfileOptions updateProfileOptions = new UpdateProfileOptions.Builder()
                    .profileId(profileId1)
                    .ifMatch(profileEtag)
                    .description(newDescription)
                    .build();

            Response<TrustedProfile> response = service.updateProfile(updateProfileOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TrustedProfile profileResult = response.getResult();
            assertNotNull(profileResult);

            assertEquals(profileResult.getDescription(), newDescription);
            assertEquals(profileResult.getName(), PROFILE_NAME_1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateProfile" })
    public void testDeleteProfile1() throws Exception {
        sleep(1);
        assertNotNull(profileId1);
        try {
            DeleteProfileOptions deleteProfileOptions = new DeleteProfileOptions.Builder()
                    .profileId(profileId1)
                    .build();
            Response<Void> response = service.deleteProfile(deleteProfileOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            TrustedProfile profile = getProfile(profileId1);
            assertNull(profile);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteProfile1" })
    public void testCreateClaimRule1() throws Exception {
        try {

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"cloud-docs-dev\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            CreateClaimRuleOptions createClaimRuleOptions = new CreateClaimRuleOptions.Builder()
                    .profileId(profileId2)
                    .type(CLAIMRULE_TYPE)
                    .realmName(REALM_NAME)
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            Response<ProfileClaimRule> response = service.createClaimRule(createClaimRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ProfileClaimRule profileClaimRuleResult = response.getResult();
            assertNotNull(profileClaimRuleResult);

            // Save the id for use by other test methods.
            claimRuleId1 = profileClaimRuleResult.getId();
            assertNotNull(claimRuleId1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateClaimRule1" })
    public void testCreateClaimRule2() throws Exception {
        try {

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"Europe_Group\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            CreateClaimRuleOptions createClaimRuleOptions = new CreateClaimRuleOptions.Builder()
                    .profileId(profileId2)
                    .type(CLAIMRULE_TYPE)
                    .realmName(REALM_NAME)
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            Response<ProfileClaimRule> response = service.createClaimRule(createClaimRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ProfileClaimRule profileClaimRuleResult = response.getResult();
            assertNotNull(profileClaimRuleResult);

            // Save the id for use by other test methods.
            claimRuleId2 = profileClaimRuleResult.getId();
            assertNotNull(claimRuleId2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateClaimRule2" })
    public void testGetClaimRule() throws Exception {
        assertNotNull(claimRuleId1);
        try {
            GetClaimRuleOptions getClaimRuleOptions = new GetClaimRuleOptions.Builder()
                    .profileId(profileId2)
                    .ruleId(claimRuleId1)
                    .build();

            Response<ProfileClaimRule> response = service.getClaimRule(getClaimRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileClaimRule profileClaimRuleResult = response.getResult();
            assertNotNull(profileClaimRuleResult);

            assertEquals(profileClaimRuleResult.getId(), claimRuleId1);
            assertEquals(profileClaimRuleResult.getType(), CLAIMRULE_TYPE);
            assertEquals(profileClaimRuleResult.getRealmName(), REALM_NAME);
            assertNotNull(profileClaimRuleResult.getConditions());

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            claimRuleEtag = response.getHeaders().values("Etag").get(0);
            assertNotNull(claimRuleEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateClaimRule1", "testCreateClaimRule2" })
    public void testListClaimRules() throws Exception {
        try {
            List<ProfileClaimRule> claimRules = new ArrayList<>();

            // Retrieve one profile at a time and save off the objects that we're interested in,
            // then validate the results at the end.

            ListClaimRulesOptions listClaimRulesOptions = new ListClaimRulesOptions.Builder()
                    .profileId(profileId2)
                    .build();

            Response<ProfileClaimRuleList> response = service.listClaimRules(listClaimRulesOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileClaimRuleList claimRuleListResult = response.getResult();
            assertNotNull(claimRuleListResult);

            // Walk through the returned results
            for (ProfileClaimRule claimRule : claimRuleListResult.getRules()) {
                if (claimRuleId1.equals(claimRule.getId()) || claimRuleId2.equals(claimRule.getId())) {
                    claimRules.add(claimRule);
                }
            }

            assertEquals(claimRules.size(), 2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListClaimRules" })
    public void testUpdateClaimRule() throws Exception {
        assertNotNull(claimRuleId1);
        assertNotNull(claimRuleEtag);
        try {
            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"Europe_Group\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            UpdateClaimRuleOptions updateClaimRuleOptions = new UpdateClaimRuleOptions.Builder()
                    .profileId(profileId2)
                    .ruleId(claimRuleId1)
                    .ifMatch(claimRuleEtag)
                    .expiration(33200)
                    .conditions(conditions)
                    .type(CLAIMRULE_TYPE)
                    .realmName(REALM_NAME)
                    .build();

            Response<ProfileClaimRule> response = service.updateClaimRule(updateClaimRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileClaimRule claimRuleResult = response.getResult();
            assertNotNull(claimRuleResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateClaimRule" })
    public void testDeleteClaimRule1() throws Exception {
        sleep(1);
        assertNotNull(claimRuleId1);
        try {
            DeleteClaimRuleOptions deleteClaimRuleOptions = new DeleteClaimRuleOptions.Builder()
                    .profileId(profileId2)
                    .ruleId(claimRuleId1)
                    .build();
            Response<Void> response = service.deleteClaimRule(deleteClaimRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            ProfileClaimRule claimRule = getClaimRule(profileId2, claimRuleId1);
            assertNull(claimRule);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteClaimRule1" })
    public void testDeleteClaimRule2() throws Exception {
        sleep(1);
        assertNotNull(claimRuleId2);
        try {
            DeleteClaimRuleOptions deleteClaimRuleOptions = new DeleteClaimRuleOptions.Builder()
                    .profileId(profileId2)
                    .ruleId(claimRuleId2)
                    .build();
            Response<Void> response = service.deleteClaimRule(deleteClaimRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            ProfileClaimRule claimRule = getClaimRule(profileId2, claimRuleId2);
            assertNull(claimRule);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteClaimRule2" })
    public void testCreateLink() throws Exception {
        try {

            CreateProfileLinkRequestLink link = new CreateProfileLinkRequestLink.Builder()
                    .crn("crn:v1:staging:public:iam-identity::a/" + ACCOUNT_ID + "::computeresource:Fake-Compute-Resource")
                    .namespace("default")
                    .name("nice name")
                    .build();

            CreateLinkOptions createLinkOptions = new CreateLinkOptions.Builder()
                    .profileId(profileId2)
                    .name("Nice link")
                    .crType("ROKS_SA")
                    .link(link)
                    .build();

            Response<ProfileLink> response = service.createLink(createLinkOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ProfileLink profileLinkResult = response.getResult();
            assertNotNull(profileLinkResult);

            // Save the id for use by other test methods.
            linkId = profileLinkResult.getId();
            assertNotNull(linkId);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateLink" })
    public void testGetLink() throws Exception {
        assertNotNull(linkId);
        try {
            GetLinkOptions getLinkOptions = new GetLinkOptions.Builder()
                    .profileId(profileId2)
                    .linkId(linkId)
                    .build();

            Response<ProfileLink> response = service.getLink(getLinkOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileLink profileLinkResult = response.getResult();
            assertNotNull(profileLinkResult);

            assertEquals(profileLinkResult.getId(), linkId);
            assertEquals(profileLinkResult.getName(), "Nice link");
            assertEquals(profileLinkResult.getCrType(), "ROKS_SA");
            assertNotNull(profileLinkResult.getLink());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetLink" })
    public void testListLinks() throws Exception {
        try {
            List<ProfileLink> links = new ArrayList<>();

            // Retrieve one link at a time and save off the objects that we're interested in,
            // then validate the results at the end.

            ListLinksOptions listLinksOptions = new ListLinksOptions.Builder()
                    .profileId(profileId2)
                    .build();

            Response<ProfileLinkList> response = service.listLinks(listLinksOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileLinkList profileLinkListResult = response.getResult();
            assertNotNull(profileLinkListResult);

            // Walk through the returned results
            for (ProfileLink link : profileLinkListResult.getLinks()) {
                if (linkId.equals(link.getId())) {
                    links.add(link);
                }
            }
            assertEquals(links.size(), 1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testListLinks" })
    public void testDeleteLink() throws Exception {
        sleep(1);
        assertNotNull(linkId);
        try {
            DeleteLinkOptions deleteLinkOptions = new DeleteLinkOptions.Builder()
                    .profileId(profileId2)
                    .linkId(linkId)
                    .build();
            Response<Void> response = service.deleteLink(deleteLinkOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            ProfileLink link = getLink(profileId2, linkId);
            assertNull(link);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testDeleteLink" })
    public void testDeleteProfile2() throws Exception {
        sleep(1);
        assertNotNull(profileId2);
        try {
            DeleteProfileOptions deleteProfileOptions = new DeleteProfileOptions.Builder()
                    .profileId(profileId2)
                    .build();
            Response<Void> response = service.deleteProfile(deleteProfileOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now make sure the get operation does not return it.
            TrustedProfile profile = getProfile(profileId2);
            assertNull(profile);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateProfileUnauthorised() throws Exception {
        try {
            CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
                    .name("Dummy")
                    .description("Negative Test")
                    .accountId(ACCOUNT_ID_INVALID)
                    .build();

            service.createProfile(createProfileOptions).execute();
            fail("Invalid accountId should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testCreateProfileBadRequest() throws Exception {
        try {
            CreateProfileOptions createProfileOptions = new CreateProfileOptions.Builder()
                    .name("")
                    .accountId(ACCOUNT_ID)
                    .build();

            service.createProfile(createProfileOptions).execute();
            fail("Bad request should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testDeleteProfileNotFound() throws Exception {
        try {
            DeleteProfileOptions deleteProfileOptions = new DeleteProfileOptions.Builder()
                    .profileId("InvalidProfileId")
                    .build();
            service.deleteProfile(deleteProfileOptions).execute();
            fail("Invalid profile id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testGetProfileNotFound() throws Exception {
        try {
            GetProfileOptions getProfileOptions = new GetProfileOptions.Builder()
                    .profileId("InvalidProfileId")
                    .build();

            service.getProfile(getProfileOptions).execute();
            fail("Invalid profileId should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testUpdateProfileNotFound() throws Exception {
        try {
            UpdateProfileOptions updateProfileOptions = new UpdateProfileOptions.Builder()
                    .profileId("InvalidAccountId")
                    .ifMatch("dummy")
                    .description("dummy description")
                    .build();

            service.updateProfile(updateProfileOptions).execute();
            fail("Invalid profile id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);

        }
    }

    @Test
    public void testCreateClaimRuleNotFound() throws Exception {
        try {

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("fakeClaim")
                    .operator("EQUALS")
                    .value("\"does not exist\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            CreateClaimRuleOptions createClaimRuleOptions = new CreateClaimRuleOptions.Builder()
                    .profileId("fakeProfileId")
                    .type(CLAIMRULE_TYPE)
                    .realmName(REALM_NAME)
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            service.createClaimRule(createClaimRuleOptions).execute();
            fail("Invalid accountId should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testCreateClaimRuleBadRequest() throws Exception {
        try {

            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("fakeClaim")
                    .operator("EQUALS")
                    .value("\"does not exist\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            CreateClaimRuleOptions createClaimRuleOptions = new CreateClaimRuleOptions.Builder()
                    .profileId("fakeProfileId")
                    .type("")
                    .realmName("")
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            service.createClaimRule(createClaimRuleOptions).execute();
            fail("Invalid accountId should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testGetClaimRuleNotFound() throws Exception {
        try {
            GetClaimRuleOptions getClaimRuleOptions = new GetClaimRuleOptions.Builder()
                    .profileId("fakeId")
                    .ruleId("fakeId")
                    .build();

            service.getClaimRule(getClaimRuleOptions).execute();
            fail("Bad request should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testUpdateClaimRuleBadRequest() throws Exception {
        try {
            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("fakeClaim")
                    .operator("EQUALS")
                    .value("\"does not exist\"")
                    .build();

            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);

            UpdateClaimRuleOptions updateClaimRuleOptions = new UpdateClaimRuleOptions.Builder()
                    .profileId("fakeProfileId")
                    .ruleId("fakeRuleId")
                    .ifMatch("fake")
                    .type("")
                    .realmName("")
                    .expiration(43200)
                    .conditions(conditions)
                    .build();

            service.updateClaimRule(updateClaimRuleOptions).execute();
            fail("Invalid profileId and ruleId should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testDeleteClaimRuleNotFound() throws Exception {
        try {
            DeleteClaimRuleOptions deleteClaimRuleOptions = new DeleteClaimRuleOptions.Builder()
                    .profileId("InvalidProfileId")
                    .ruleId("InvalidRuleId")
                    .build();
            service.deleteClaimRule(deleteClaimRuleOptions).execute();
            fail("Invalid profile id and rule id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testCreateLinkBadRequest() throws Exception {
        try {

            CreateProfileLinkRequestLink link = new CreateProfileLinkRequestLink.Builder()
                    .crn("invalid")
                    .namespace("default")
                    .name("nice name")
                    .build();

            CreateLinkOptions createLinkOptions = new CreateLinkOptions.Builder()
                    .profileId("invalidId")
                    .name("Invalid link")
                    .crType("invalid")
                    .link(link)
                    .build();

            service.createLink(createLinkOptions).execute();
            fail("Bad request should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void testGetLinkNotFound() throws Exception {
        try {
            GetLinkOptions getLinkOptions = new GetLinkOptions.Builder()
                    .profileId("invalidId")
                    .linkId("invalidId")
                    .build();

            service.getLink(getLinkOptions).execute();
            fail("Bad request should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testDeleteLinkNotFound() throws Exception {
        try {
            DeleteLinkOptions deleteLinkOptions = new DeleteLinkOptions.Builder()
                    .profileId("invalidId")
                    .linkId("invalidId")
                    .build();
            service.deleteLink(deleteLinkOptions).execute();
            fail("Invalid profile id and rule id should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @Test
    public void testGetAccountSettings() throws Exception {
        try {
            GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .includeHistory(false)
                    .build();

            // Invoke operation
            Response<AccountSettingsResponse> response = service.getAccountSettings(getAccountSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            AccountSettingsResponse accountSettingsResponseResult = response.getResult();

            assertNotNull(accountSettingsResponseResult);

            assertEquals(accountSettingsResponseResult.getAccountId(), ACCOUNT_ID);
            assertNotNull(accountSettingsResponseResult.getRestrictCreatePlatformApikey());
            assertNotNull(accountSettingsResponseResult.getRestrictCreateServiceId());
            assertNotNull(accountSettingsResponseResult.getMfa());
            assertNotNull(accountSettingsResponseResult.getUserMfa());
            assertNotNull(accountSettingsResponseResult.getSessionExpirationInSeconds());
            assertNotNull(accountSettingsResponseResult.getSessionInvalidationInSeconds());
            assertNotNull(accountSettingsResponseResult.getSystemAccessTokenExpirationInSeconds());
            assertNotNull(accountSettingsResponseResult.getSystemRefreshTokenExpirationInSeconds());

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            accountSettingsEtag = response.getHeaders().values("Etag").get(0);
            assertNotNull(accountSettingsEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetAccountSettings" })
    public void testUpdateAccountSettings() throws Exception {
        assertNotNull(accountSettingsEtag);
        try {
            AccountSettingsUserMFA userMFA = new AccountSettingsUserMFA.Builder()
                    .iamId(IAM_ID_MEMBER)
                    .mfa("NONE")
                    .build();

            List<AccountSettingsUserMFA> userMFAExpList = new ArrayList<>();
            userMFAExpList.add(userMFA);

            UpdateAccountSettingsOptions updateAccountSettingsOptions = new UpdateAccountSettingsOptions.Builder()
                    .ifMatch(accountSettingsEtag)
                    .accountId(ACCOUNT_ID)
                    .restrictCreateServiceId("NOT_RESTRICTED")
                    .restrictCreatePlatformApikey("NOT_RESTRICTED")
//                    .allowedIpAddresses("testString")
                    .mfa("NONE")
                    .userMfa(userMFAExpList)
                    .sessionExpirationInSeconds("86400")
                    .sessionInvalidationInSeconds("7200")
                    .maxSessionsPerIdentity("10")
                    .systemAccessTokenExpirationInSeconds("3600")
                    .systemRefreshTokenExpirationInSeconds("259200")
                    .build();

            // Invoke operation
            Response<AccountSettingsResponse> response = service.updateAccountSettings(updateAccountSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            AccountSettingsResponse accountSettingsResponseResult = response.getResult();
            assertNotNull(accountSettingsResponseResult);

            assertEquals(accountSettingsResponseResult.getAllowedIpAddresses(), "");
            assertEquals(accountSettingsResponseResult.getAccountId(), updateAccountSettingsOptions.accountId());
            assertEquals(accountSettingsResponseResult.getMfa(), updateAccountSettingsOptions.mfa());
            assertEquals(accountSettingsResponseResult.getUserMfa(), updateAccountSettingsOptions.userMfa());
            assertEquals(accountSettingsResponseResult.getRestrictCreatePlatformApikey(), updateAccountSettingsOptions.restrictCreatePlatformApikey());
            assertEquals(accountSettingsResponseResult.getRestrictCreateServiceId(), updateAccountSettingsOptions.restrictCreateServiceId());
            assertEquals(accountSettingsResponseResult.getSessionExpirationInSeconds(), updateAccountSettingsOptions.sessionExpirationInSeconds());
            assertEquals(accountSettingsResponseResult.getSessionInvalidationInSeconds(), updateAccountSettingsOptions.sessionInvalidationInSeconds());
            assertEquals(accountSettingsResponseResult.getSystemAccessTokenExpirationInSeconds(),
                    updateAccountSettingsOptions.systemAccessTokenExpirationInSeconds());
            assertEquals(accountSettingsResponseResult.getSystemRefreshTokenExpirationInSeconds(),
                    updateAccountSettingsOptions.systemRefreshTokenExpirationInSeconds());
            assertNotEquals(accountSettingsResponseResult.getEntityTag(), accountSettingsEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateReport() throws Exception {
        try {
            CreateReportOptions createReportOptions = new CreateReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .type("inactive")
                    .duration("150")
                    .build();
            Response<ReportReference> response = service.createReport(createReportOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);

            ReportReference reportResult = response.getResult();
            assertNotNull(reportResult);

            reportReference = reportResult.getReference();
            assertNotNull(reportReference);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateReport" })
    public void testGetReportIncomplete() throws Exception {
        try {
            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference(reportReference)
                    .build();
            Response<Report> response = service.getReport(getReportOptions).execute();
            assertTrue(response.getStatusCode() == 204 || response.getStatusCode() == 200);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateReport" })
    public void testGetReportComplete() throws Exception {
        try {
            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference(reportReference)
                    .build();
            for (int i = 0; i < 30; i++) {
                Response<Report> response = service.getReport(getReportOptions).execute();
                if (response.getStatusCode() != 204) {
                    Report reportResult = response.getResult();
                    assertNotNull(reportResult);
                    assertEquals(reportResult.getCreatedBy(), IAM_ID);
                    assertEquals(reportResult.getReference(), reportReference);
                    assertNotNull(reportResult.getReportDuration());
                    assertNotNull(reportResult.getReportStartTime());
                    assertNotNull(reportResult.getReportEndTime());
                    break;
                }
                sleep(1);
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetReportNotFound() throws Exception {
        try {
            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference("test123")
                    .build();
            Response<Report> response = service.getReport(getReportOptions).execute();
            fail("Invalid reference should not have succeeded!");
        } catch (ServiceResponseException e) {
        	if (e.getStatusCode() != 404) {
                fail(String.format("Service returned status code %d: %s\nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            } else {
                assertEquals(e.getStatusCode(), 404);
            }
        }
    }

    @Test
    public void testCreateReportMfa() throws Exception {
        try {
            CreateMfaReportOptions createMfaReportOptions = new CreateMfaReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .type("mfa_status")
                    .build();
            Response<ReportReference> response = service.createMfaReport(createMfaReportOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);

            ReportReference reportResult = response.getResult();
            assertNotNull(reportResult);

            reportReferenceMfa = reportResult.getReference();
            assertNotNull(reportReferenceMfa);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateReportMfa" })
    public void testGetReportMfaComplete() throws Exception {
        try {
            GetMfaReportOptions getMfaReportOptions = new GetMfaReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference(reportReferenceMfa)
                    .build();
            for (int i = 0; i < 30; i++) {
                Response<ReportMfaEnrollmentStatus> response = service.getMfaReport(getMfaReportOptions).execute();
                if (response.getStatusCode() != 204) {
                    ReportMfaEnrollmentStatus reportResult = response.getResult();
                    assertNotNull(reportResult);
                    assertEquals(reportResult.getCreatedBy(), IAM_ID);
                    assertEquals(reportResult.getReference(), reportReferenceMfa);
                    break;
                }
                sleep(1);
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetReportMfaNotFound() throws Exception {
        try {
            GetMfaReportOptions getMfaReportOptions = new GetMfaReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference("test123")
                    .build();
            Response<ReportMfaEnrollmentStatus> response = service.getMfaReport(getMfaReportOptions).execute();
            assertEquals(response.getStatusCode(), 404);
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404) {
                fail(String.format("Service returned status code %d: %s\nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            } else {
                assertEquals(e.getStatusCode(), 404);
            }
        }
    }

    @Test
    public void testGetMfaStatus() throws Exception {
        try {
            GetMfaStatusOptions getMfaStatusOptions = new GetMfaStatusOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_ID)
                    .build();
            Response<UserMfaEnrollments> response = service.getMfaStatus(getMfaStatusOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            UserMfaEnrollments mfaStatusResponseResult = response.getResult();
            assertNotNull(mfaStatusResponseResult);
            assertNotNull(mfaStatusResponseResult.getIamId());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }



    @Test(dependsOnMethods = { "testCreateProfile1" })
    public void testSetProfileIdentities() throws Exception {
        try {
        	List<String> accounts= new ArrayList<String>();
        	accounts.add(ACCOUNT_ID);
        	String type="user";
        	String description="Identity description";
        	ProfileIdentityRequest profileIdentity= new ProfileIdentityRequest.Builder()
        			.identifier(IAM_ID)
        			.accounts(accounts)
        			.type(type)
        			.description(description)
        			.build();
        	List<ProfileIdentityRequest> listProfileIdentity= new ArrayList<ProfileIdentityRequest>();
        	listProfileIdentity.add(profileIdentity);

        	SetProfileIdentitiesOptions setProfileIdentitiesOptions = new SetProfileIdentitiesOptions.Builder()
        			.profileId(profileId1)
        			.identities(listProfileIdentity)
        			.ifMatch("*")
                    .build();
            Response<ProfileIdentitiesResponse> response = service.setProfileIdentities(setProfileIdentitiesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileIdentitiesResponse profileIdentitiesResponseResult = response.getResult();
            assertNotNull(profileIdentitiesResponseResult);
            assertNotNull(profileIdentitiesResponseResult.getIdentities());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testSetProfileIdentities" })
    public void testGetProfileIdentities() throws Exception {
        try {
        	GetProfileIdentitiesOptions getProfileIdentitiesOptions = new GetProfileIdentitiesOptions.Builder()
                    .profileId(profileId1)
                    .build();
            Response<ProfileIdentitiesResponse> response = service.getProfileIdentities(getProfileIdentitiesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileIdentitiesResponse profileIdentitiesResponseResult = response.getResult();
            assertNotNull(profileIdentitiesResponseResult);
            assertNotNull(profileIdentitiesResponseResult.getIdentities());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateProfile1" })
    public void testSetProfileIdentity() throws Exception {
        try {
        	List<String> accounts= new ArrayList<String>();
        	accounts.add(ACCOUNT_ID);
        	String type="user";
        	String description="Identity description";

        	SetProfileIdentityOptions setProfileIdentityOptions = new SetProfileIdentityOptions.Builder()
        			.profileId(profileId1)
        			.identityType(type)
        			.identifier(IAM_ID_MEMBER)
        			.type("user")
        			.accounts(accounts)
        			.description(description)
                    .build();
            Response<ProfileIdentityResponse> response = service.setProfileIdentity(setProfileIdentityOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileIdentityResponse profileIdentityResponseResult = response.getResult();
            assertNotNull(profileIdentityResponseResult);
            assertNotNull(profileIdentityResponseResult.getIdentifier());
            assertEquals(profileIdentityResponseResult.getIdentifier(), IAM_ID_MEMBER);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testSetProfileIdentity" })
    public void testGetProfileIdentity() throws Exception {
        try {
        	GetProfileIdentityOptions getProfileIdentityOptions = new GetProfileIdentityOptions.Builder()
                    .profileId(profileId1)
                    .identityType("user")
                    .identifierId(IAM_ID_MEMBER)
                    .build();
            Response<ProfileIdentityResponse> response = service.getProfileIdentity(getProfileIdentityOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ProfileIdentityResponse profileIdentityResponseResult = response.getResult();
            assertNotNull(profileIdentityResponseResult);
            assertNotNull(profileIdentityResponseResult.getIdentifier());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetProfileIdentity" })
    public void testDeleteProfileIdentity() throws Exception {
        try {
        	DeleteProfileIdentityOptions deleteProfileIdentityOptions = new DeleteProfileIdentityOptions.Builder()
                    .profileId(profileId1)
                    .identityType("user")
                    .identifierId(IAM_ID_MEMBER)
                    .build();
            Response<Void> response = service.deleteProfileIdentity(deleteProfileIdentityOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test
    public void testCreateProfileTemplate() throws Exception {
        try {
            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"cloud-docs-dev\"")
                    .build();
            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);
            
        	TrustedProfileTemplateClaimRule claimRule = new TrustedProfileTemplateClaimRule.Builder()
        			.name("My Rule")
        			.realmName(REALM_NAME)
        			.type(CLAIMRULE_TYPE)
        			.expiration(43200)
        			.conditions(conditions)
        			.build();
        	
        	TemplateProfileComponentRequest profile = new TemplateProfileComponentRequest.Builder()
        			.addRules(claimRule)
        			.name(PROFILE_TEMPLATE_PROFILE_NAME)
        			.description("JavaSDK test Profile cretaed from Profile Template #1")
        			.build();
        	
        	CreateProfileTemplateOptions createProfileTemplateOptions = new CreateProfileTemplateOptions.Builder()
        			.name(PROFILE_TEMPLATE_NAME)
                    .description("JavaSDK test Profile Template #1")
                    .accountId(ENTERPRISE_ACCOUNT_ID)
                    .profile(profile)
        			.build();
        			
            Response<TrustedProfileTemplateResponse> response = service.createProfileTemplate(createProfileTemplateOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            TrustedProfileTemplateResponse trustedProfileTemplateResult = response.getResult();
            assertNotNull(trustedProfileTemplateResult);

            // Save the id for use by other test methods.
            assertNotNull(trustedProfileTemplateResult.getId());
            profileTemplateId = trustedProfileTemplateResult.getId();
            assertNotNull(trustedProfileTemplateResult.getVersion());
            profileTemplateVersion = trustedProfileTemplateResult.getVersion().longValue();
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    
    @Test(dependsOnMethods = { "testCreateProfileTemplate" })
    public void testGetProfileTemplate() throws Exception {
        try {
            GetProfileTemplateVersionOptions getProfileTemplateOptions = new GetProfileTemplateVersionOptions.Builder()
            		.templateId(profileTemplateId)
            		.version(Long.toString(profileTemplateVersion))
                    .build();

            Response<TrustedProfileTemplateResponse> response = service.getProfileTemplateVersion(getProfileTemplateOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            TrustedProfileTemplateResponse profileTemplateResult = response.getResult();
            assertNotNull(profileTemplateResult);

            assertEquals(profileTemplateResult.getId(), profileTemplateId);

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            profileTemplateEtag = response.getHeaders().values("Etag").get(0);
            assertNotNull(profileTemplateEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateProfileTemplate" })
    public void testListProfileTemplates() throws Exception {
        try {
        	ListProfileTemplatesOptions listOptions = new ListProfileTemplatesOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.build();
        	
        	Response<TrustedProfileTemplateList> response = service.listProfileTemplates(listOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            assertNotNull(response.getResult());

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testGetProfileTemplate" })
    public void testUpdateProfileTemplate() throws Exception {
        try {
        	UpdateProfileTemplateVersionOptions updateOptions = new UpdateProfileTemplateVersionOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.templateId(profileTemplateId)
        			.version(Long.toString(profileTemplateVersion))
        			.ifMatch(profileTemplateEtag)
        			.name(PROFILE_TEMPLATE_NAME)
        			.description("JavaSDK test Profile Template #1 - updated")
        			.build();
        	
        	Response<TrustedProfileTemplateResponse> updateResponse = service.updateProfileTemplateVersion(updateOptions).execute();
            assertNotNull(updateResponse);
            assertEquals(updateResponse.getStatusCode(), 200);
            assertNotNull(updateResponse.getResult());
        	
            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(updateResponse.getHeaders().values("Etag"));
            assertEquals(updateResponse.getHeaders().values("Etag").size(), 1);
            profileTemplateEtag = updateResponse.getHeaders().values("Etag").get(0);
            assertNotNull(profileTemplateEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testUpdateProfileTemplate" })
    public void testAssignProfileTemplate() throws Exception {
        try {
        	CommitProfileTemplateOptions commitOptions = new CommitProfileTemplateOptions.Builder()
        			.templateId(profileTemplateId)
        			.version(Long.toString(profileTemplateVersion))
        			.build();
        	
        	Response<Void> commitResponse = service.commitProfileTemplate(commitOptions).execute();
            assertNotNull(commitResponse);
            assertEquals(commitResponse.getStatusCode(), 204);
            
            CreateTrustedProfileAssignmentOptions assignOptions = new CreateTrustedProfileAssignmentOptions.Builder()
            		.templateId(profileTemplateId)
            		.templateVersion(profileTemplateVersion)
            		.targetType(ASSIGNMENT_TARGET_TYPE_ACCOUNT)
            		.target(ENTERPRISE_SUBACCOUNT_ID)
            		.build();
            
            Response<TemplateAssignmentResponse> assignResponse = service.createTrustedProfileAssignment(assignOptions).execute();
            assertNotNull(commitResponse);
            assertEquals(commitResponse.getStatusCode(), 204);
            
            TemplateAssignmentResponse assignmentResponseResult = assignResponse.getResult();
            assertNotNull(assignmentResponseResult);

            // Save the id for use by other test methods.
            assertNotNull(assignmentResponseResult.getId());
            profileTemplateAssignmentId = assignmentResponseResult.getId();
            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(assignResponse.getHeaders().values("Etag"));
            assertEquals(assignResponse.getHeaders().values("Etag").size(), 1);
            profileTemplateAssignmentEtag = assignResponse.getHeaders().values("Etag").get(0);
            assertNotNull(profileTemplateAssignmentEtag);
            
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testAssignProfileTemplate" })
    public void testListProfileTemplateAssignments() throws Exception {
        try {
        	ListTrustedProfileAssignmentsOptions listOptions = new ListTrustedProfileAssignmentsOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.templateId(profileTemplateId)
        			.build();
        	
        	Response<TemplateAssignmentListResponse> listResponse = service.listTrustedProfileAssignments(listOptions).execute();
            assertNotNull(listResponse);
            assertEquals(listResponse.getStatusCode(), 200);
            assertNotNull(listResponse.getResult());
            
            TemplateAssignmentListResponse listResult = listResponse.getResult();
            assertNotNull(listResult.getAssignments());
            assertEquals(listResult.getAssignments().size(), 1);
        	
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testAssignProfileTemplate" })
    public void testCreateNewProfileTemplateVersion() throws Exception {
        try {
            ProfileClaimRuleConditions condition = new ProfileClaimRuleConditions.Builder()
                    .claim("blueGroups")
                    .operator("EQUALS")
                    .value("\"cloud-docs-dev\"")
                    .build();
            List<ProfileClaimRuleConditions> conditions = new ArrayList<>();
            conditions.add(condition);
            
        	TrustedProfileTemplateClaimRule claimRule = new TrustedProfileTemplateClaimRule.Builder()
        			.name("My Rule")
        			.realmName(REALM_NAME)
        			.type(CLAIMRULE_TYPE)
        			.expiration(43200)
        			.conditions(conditions)
        			.build();
        	
        	List<String> accounts= new ArrayList<String>();
        	accounts.add(ENTERPRISE_ACCOUNT_ID);
        	ProfileIdentityRequest profileIdentity= new ProfileIdentityRequest.Builder()
        			.identifier(IAM_ID)
        			.accounts(accounts)
        			.type("user")
        			.description("Identity description")
        			.build();
        	List<ProfileIdentityRequest> identities= new ArrayList<ProfileIdentityRequest>();
        	identities.add(profileIdentity);
        	
        	TemplateProfileComponentRequest profile = new TemplateProfileComponentRequest.Builder()
        			.addRules(claimRule)
        			.name(PROFILE_TEMPLATE_PROFILE_NAME)
        			.description("JavaSDK test Profile cretaed from Profile Template #1 - new version")
        			.identities(identities)
        			.build();
        	
        	CreateProfileTemplateVersionOptions createOptions = new CreateProfileTemplateVersionOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.templateId(profileTemplateId)
        			.name(PROFILE_TEMPLATE_NAME)
        			.description("JavaSDK test Profile Template #1 - new version")
        			.profile(profile)
        			.build();
        	
        	Response<TrustedProfileTemplateResponse> createResponse = service.createProfileTemplateVersion(createOptions).execute();
            assertNotNull(createResponse);
            assertEquals(createResponse.getStatusCode(), 201);
            assertNotNull(createResponse.getResult());
            
            TrustedProfileTemplateResponse createResult = createResponse.getResult();
            assertNotNull(createResult);

            // Save the version for use by other test methods.
            assertNotNull(createResult.getVersion());
            profileTemplateVersion = createResult.getVersion().longValue();
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testCreateNewProfileTemplateVersion" })
    public void testGetLatestProfileTemplateVersion() throws Exception {
    	GetLatestProfileTemplateVersionOptions getOptions = new GetLatestProfileTemplateVersionOptions.Builder()
    			.templateId(profileTemplateId)
    			.build();
    	
    	Response<TrustedProfileTemplateResponse> getResponse = service.getLatestProfileTemplateVersion(getOptions).execute();
        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);
        assertNotNull(getResponse.getResult());
    }
    
    @Test(dependsOnMethods = { "testCreateNewProfileTemplateVersion" })
    public void testListProfileTemplateVersions() throws Exception {
    	
    	ListVersionsOfProfileTemplateOptions listOptions = new ListVersionsOfProfileTemplateOptions.Builder()
    			.templateId(profileTemplateId)
    			.build();
    	
    	Response<TrustedProfileTemplateList> listResponse = service.listVersionsOfProfileTemplate(listOptions).execute();
        assertNotNull(listResponse);
        assertEquals(listResponse.getStatusCode(), 200);
        assertNotNull(listResponse.getResult());
        TrustedProfileTemplateList listResult = listResponse.getResult();
        assertNotNull(listResult.getProfileTemplates());
        assertTrue(listResult.getProfileTemplates().size() > 0);
    }
    
    @Test(dependsOnMethods = { "testAssignProfileTemplate", "testCreateNewProfileTemplateVersion" })
    public void testUpdateProfileTemplateAssignment() throws Exception {
        try {
        	CommitProfileTemplateOptions commitOptions = new CommitProfileTemplateOptions.Builder()
        			.templateId(profileTemplateId)
        			.version(Long.toString(profileTemplateVersion))
        			.build();
        	
        	Response<Void> commitResponse = service.commitProfileTemplate(commitOptions).execute();
            assertNotNull(commitResponse);
            assertEquals(commitResponse.getStatusCode(), 204);

        	waitUntilTrustedProfileAssignmentFinished(profileTemplateAssignmentId);
        	
        	UpdateTrustedProfileAssignmentOptions updateOptions = new UpdateTrustedProfileAssignmentOptions.Builder()
        			.assignmentId(profileTemplateAssignmentId)
        			.templateVersion(profileTemplateVersion)
        			.ifMatch(profileTemplateAssignmentEtag)
        			.build();
        	
        	Response<TemplateAssignmentResponse> updateResponse = service.updateTrustedProfileAssignment(updateOptions).execute();
            assertNotNull(updateResponse);
            assertEquals(updateResponse.getStatusCode(), 202);
            assertNotNull(updateResponse.getResult());
            
            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(updateResponse.getHeaders().values("Etag"));
            assertEquals(updateResponse.getHeaders().values("Etag").size(), 1);
            profileTemplateAssignmentEtag = updateResponse.getHeaders().values("Etag").get(0);
            assertNotNull(profileTemplateAssignmentEtag);
            
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testUpdateProfileTemplateAssignment" })
    public void testDeleteProfileTemplateAssignment() throws Exception {
        try {
        	waitUntilTrustedProfileAssignmentFinished(profileTemplateAssignmentId);
        	
        	DeleteTrustedProfileAssignmentOptions deleteOptions = new DeleteTrustedProfileAssignmentOptions.Builder()
        			.assignmentId(profileTemplateAssignmentId)
        			.build();
        	
        	Response<ExceptionResponse> deleteResponse = service.deleteTrustedProfileAssignment(deleteOptions).execute();
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 202);
        	
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testDeleteProfileTemplateAssignment" })
    public void testDeleteProfileTemplateVersion() throws Exception {
        try {
        	DeleteProfileTemplateVersionOptions deleteOptions = new DeleteProfileTemplateVersionOptions.Builder()
        			.templateId(profileTemplateId)
        			.version("1")
        			.build();
        	
        	Response<Void> deleteResponse = service.deleteProfileTemplateVersion(deleteOptions).execute();
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testDeleteProfileTemplateVersion" })
    public void testDeleteProfileTemplate() throws Exception {
        try {
        	waitUntilTrustedProfileAssignmentFinished(profileTemplateAssignmentId);
        	
            DeleteAllVersionsOfProfileTemplateOptions deleteTeplateOptions = new DeleteAllVersionsOfProfileTemplateOptions.Builder()
            		.templateId(profileTemplateId)
                    .build();

            // Invoke operation
            Response<Void> deleteResponse = service.deleteAllVersionsOfProfileTemplate(deleteTeplateOptions).execute();
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test
    public void testCreateAccountSettingsTemplate() throws Exception {
        try {
        	
        	AccountSettingsComponent accountSettings = new AccountSettingsComponent.Builder()
        			.mfa("LEVEL1")
        			.systemAccessTokenExpirationInSeconds("3000")
        			.build();
        	CreateAccountSettingsTemplateOptions createOptions = new CreateAccountSettingsTemplateOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.name(ACCOUNT_SETTINGS_TEMPLATE_NAME)
        			.description("JavaSDK test Account Settings Template #1")
        			.accountSettings(accountSettings)
        			.build();
        	Response<AccountSettingsTemplateResponse> createResponse = service.createAccountSettingsTemplate(createOptions).execute();
            assertNotNull(createResponse);
            assertEquals(createResponse.getStatusCode(), 201);

            AccountSettingsTemplateResponse createResult = createResponse.getResult();
            assertNotNull(createResult);

            // Save the id for use by other test methods.
            assertNotNull(createResult.getId());
            accountSettingsTemplateId = createResult.getId();
            assertNotNull(createResult.getVersion());
            accountSettingsTemplateVersion = createResult.getVersion().longValue();
        	
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testCreateAccountSettingsTemplate" })
    public void testGetAccountSettingsTemplate() throws Exception {
        try {
            GetAccountSettingsTemplateVersionOptions getOptions = new GetAccountSettingsTemplateVersionOptions.Builder()
            		.templateId(accountSettingsTemplateId)
            		.version(Long.toString(accountSettingsTemplateVersion))
                    .build();

            Response<AccountSettingsTemplateResponse> response = service.getAccountSettingsTemplateVersion(getOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            AccountSettingsTemplateResponse getResult = response.getResult();
            assertNotNull(getResult);

            assertEquals(getResult.getId(), accountSettingsTemplateId);

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            accountSettingsTemplateEtag = response.getHeaders().values("Etag").get(0);
            assertNotNull(accountSettingsTemplateEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateAccountSettingsTemplate" })
    public void testListAccountSettingsTemplates() throws Exception {
        try {
        	ListAccountSettingsTemplatesOptions listOptions = new ListAccountSettingsTemplatesOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.build();
        	
        	Response<AccountSettingsTemplateList> response = service.listAccountSettingsTemplates(listOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            assertNotNull(response.getResult());

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testCreateAccountSettingsTemplate" })
    public void testUpdateAccountSettingsTemplate() throws Exception {
        try {
        	AccountSettingsComponent accountSettings = new AccountSettingsComponent.Builder()
        			.mfa("LEVEL1")
        			.systemAccessTokenExpirationInSeconds("3000")
        			.build();
        	UpdateAccountSettingsTemplateVersionOptions updateOptions = new UpdateAccountSettingsTemplateVersionOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.templateId(accountSettingsTemplateId)
        			.version(Long.toString(accountSettingsTemplateVersion))
        			.ifMatch(accountSettingsTemplateEtag)
        			.name(ACCOUNT_SETTINGS_TEMPLATE_NAME)
        			.description("JavaSDK test Account Settings Template #1 - updated")
        			.accountSettings(accountSettings)
        			.build();
        	
        	Response<AccountSettingsTemplateResponse> updateResponse = service.updateAccountSettingsTemplateVersion(updateOptions).execute();
            assertNotNull(updateResponse);
            assertEquals(updateResponse.getStatusCode(), 200);
            assertNotNull(updateResponse.getResult());
        	
            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(updateResponse.getHeaders().values("Etag"));
            assertEquals(updateResponse.getHeaders().values("Etag").size(), 1);
            accountSettingsTemplateEtag = updateResponse.getHeaders().values("Etag").get(0);
            assertNotNull(accountSettingsTemplateEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testUpdateAccountSettingsTemplate" })
    public void testAssignAccountSettingsTemplate() throws Exception {
        try {
        	CommitAccountSettingsTemplateOptions commitOptions = new CommitAccountSettingsTemplateOptions.Builder()
        			.templateId(accountSettingsTemplateId)
        			.version(Long.toString(accountSettingsTemplateVersion))
        			.build();
        	
        	Response<Void> commitResponse = service.commitAccountSettingsTemplate(commitOptions).execute();
            assertNotNull(commitResponse);
            assertEquals(commitResponse.getStatusCode(), 204);
            
            CreateAccountSettingsAssignmentOptions assignOptions = new CreateAccountSettingsAssignmentOptions.Builder()
            		.templateId(accountSettingsTemplateId)
            		.templateVersion(accountSettingsTemplateVersion)
            		.targetType(ASSIGNMENT_TARGET_TYPE_ACCOUNT)
            		.target(ENTERPRISE_SUBACCOUNT_ID)
            		.build();
            
            Response<TemplateAssignmentResponse> assignResponse = service.createAccountSettingsAssignment(assignOptions).execute();
            assertNotNull(commitResponse);
            assertEquals(commitResponse.getStatusCode(), 204);
            
            TemplateAssignmentResponse assignmentResponseResult = assignResponse.getResult();
            assertNotNull(assignmentResponseResult);

            // Save the id for use by other test methods.
            assertNotNull(assignmentResponseResult.getId());
            accountSettingsTemplateAssignmentId = assignmentResponseResult.getId();
            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(assignResponse.getHeaders().values("Etag"));
            assertEquals(assignResponse.getHeaders().values("Etag").size(), 1);
            accountSettingsTemplateAssignmentEtag = assignResponse.getHeaders().values("Etag").get(0);
            assertNotNull(accountSettingsTemplateAssignmentEtag);
            
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testAssignAccountSettingsTemplate" })
    public void testCreateNewAccountSettingsTemplateVersion() throws Exception {
        try {
        	AccountSettingsComponent accountSettings = new AccountSettingsComponent.Builder()
        			.mfa("LEVEL1")
        			.systemAccessTokenExpirationInSeconds("2600")
        			.restrictCreatePlatformApikey("RESTRICTED")
        			.restrictCreateServiceId("RESTRICTED")
        			.build();
        	CreateAccountSettingsTemplateVersionOptions createOptions = new CreateAccountSettingsTemplateVersionOptions.Builder()
        			.accountId(ENTERPRISE_ACCOUNT_ID)
        			.templateId(accountSettingsTemplateId)
        			.name(ACCOUNT_SETTINGS_TEMPLATE_NAME)
        			.description("JavaSDK test AccountSettings Template #1 - new version")
        			.accountSettings(accountSettings)
        			.build();
        	
        	Response<AccountSettingsTemplateResponse> createResponse = service.createAccountSettingsTemplateVersion(createOptions).execute();
            assertNotNull(createResponse);
            assertEquals(createResponse.getStatusCode(), 201);
            assertNotNull(createResponse.getResult());
            
            AccountSettingsTemplateResponse createResult = createResponse.getResult();
            assertNotNull(createResult);

            // Save the version for use by other test methods.
            assertNotNull(createResult.getVersion());
            accountSettingsTemplateVersion = createResult.getVersion().longValue();
            
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testCreateNewAccountSettingsTemplateVersion" })
    public void testGetLatestAccountSettingsTemplateVersion() throws Exception {
        GetLatestAccountSettingsTemplateVersionOptions getOptions = new GetLatestAccountSettingsTemplateVersionOptions.Builder()
                .templateId(accountSettingsTemplateId)
                .build();
        
        Response<AccountSettingsTemplateResponse> getResponse = service.getLatestAccountSettingsTemplateVersion(getOptions).execute();
        assertNotNull(getResponse);
        assertEquals(getResponse.getStatusCode(), 200);
        assertNotNull(getResponse.getResult());
    }
    
    @Test(dependsOnMethods = { "testCreateNewAccountSettingsTemplateVersion" })
    public void testListAccountSettingsTemplateVersions() throws Exception {
        
        ListVersionsOfAccountSettingsTemplateOptions listOptions = new ListVersionsOfAccountSettingsTemplateOptions.Builder()
                .templateId(accountSettingsTemplateId)
                .build();
        
        Response<AccountSettingsTemplateList> listResponse = service.listVersionsOfAccountSettingsTemplate(listOptions).execute();
        assertNotNull(listResponse);
        assertEquals(listResponse.getStatusCode(), 200);
        assertNotNull(listResponse.getResult());
        AccountSettingsTemplateList listResult = listResponse.getResult();
        assertNotNull(listResult.getAccountSettingsTemplates());
        assertTrue(listResult.getAccountSettingsTemplates().size() > 0);
    }
    
    @Test(dependsOnMethods = { "testAssignAccountSettingsTemplate", "testCreateNewAccountSettingsTemplateVersion" })
    public void testUpdateAccountSettingsTemplateAssignment() throws Exception {
        try {
        	CommitAccountSettingsTemplateOptions commitOptions = new CommitAccountSettingsTemplateOptions.Builder()
        			.templateId(accountSettingsTemplateId)
        			.version(Long.toString(accountSettingsTemplateVersion))
        			.build();
        	
        	Response<Void> commitResponse = service.commitAccountSettingsTemplate(commitOptions).execute();
            assertNotNull(commitResponse);
            assertEquals(commitResponse.getStatusCode(), 204);

        	waitUntilAccountSettingsAssignmentFinished(accountSettingsTemplateAssignmentId);
        	
        	UpdateAccountSettingsAssignmentOptions updateOptions = new UpdateAccountSettingsAssignmentOptions.Builder()
        			.assignmentId(accountSettingsTemplateAssignmentId)
        			.templateVersion(accountSettingsTemplateVersion)
        			.ifMatch(accountSettingsTemplateAssignmentEtag)
        			.build();
        	
        	Response<TemplateAssignmentResponse> updateResponse = service.updateAccountSettingsAssignment(updateOptions).execute();
            assertNotNull(updateResponse);
            assertEquals(updateResponse.getStatusCode(), 202);
            assertNotNull(updateResponse.getResult());
            
            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(updateResponse.getHeaders().values("Etag"));
            assertEquals(updateResponse.getHeaders().values("Etag").size(), 1);
            accountSettingsTemplateAssignmentEtag = updateResponse.getHeaders().values("Etag").get(0);
            assertNotNull(accountSettingsTemplateAssignmentEtag);
            
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testUpdateAccountSettingsTemplateAssignment" })
    public void testDeleteAccountSettingsTemplateAssignment() throws Exception {
        try {
        	waitUntilAccountSettingsAssignmentFinished(accountSettingsTemplateAssignmentId);
        	
        	DeleteAccountSettingsAssignmentOptions deleteOptions = new DeleteAccountSettingsAssignmentOptions.Builder()
        			.assignmentId(accountSettingsTemplateAssignmentId)
        			.build();
        	
        	Response<ExceptionResponse> deleteResponse = service.deleteAccountSettingsAssignment(deleteOptions).execute();
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 202);
        	
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testUpdateAccountSettingsTemplateAssignment" })
    public void testDeleteAccountSettingsTemplateVersion() throws Exception {
        try {
        	DeleteAccountSettingsTemplateVersionOptions deleteOptions = new DeleteAccountSettingsTemplateVersionOptions.Builder()
        			.templateId(accountSettingsTemplateId)
        			.version("1")
        			.build();
        	
        	Response<Void> deleteResponse = service.deleteAccountSettingsTemplateVersion(deleteOptions).execute();
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test(dependsOnMethods = { "testDeleteAccountSettingsTemplateVersion" })
    public void testDeleteAccountSettingsTemplate() throws Exception {
        try {
        	waitUntilAccountSettingsAssignmentFinished(accountSettingsTemplateAssignmentId);
        	
            DeleteAllVersionsOfAccountSettingsTemplateOptions deleteTeplateOptions = new DeleteAllVersionsOfAccountSettingsTemplateOptions.Builder()
            		.templateId(accountSettingsTemplateId)
                    .build();

            // Invoke operation
            Response<Void> deleteResponse = service.deleteAllVersionsOfAccountSettingsTemplate(deleteTeplateOptions).execute();
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @AfterClass
    public void tearDown() {
        // Add any clean up logic here.
        sleep(5);
        cleanupResources();
    }

    private boolean isFinished(String status) {
    	return ("succeeded".equalsIgnoreCase(status) || "failed".equalsIgnoreCase(status));
    }
    
    private void waitUntilTrustedProfileAssignmentFinished(String assignmentId) {
    	GetTrustedProfileAssignmentOptions getOptions = new GetTrustedProfileAssignmentOptions.Builder()
    			.assignmentId(assignmentId)
    			.build();

    	boolean finished = false;
    	for (int i = 0; i < 20; i++) {
            Response<TemplateAssignmentResponse> getResponse = null;
    		try {
    		    getResponse = service.getTrustedProfileAssignment(getOptions).execute();
                TemplateAssignmentResponse result = getResponse.getResult();
                finished = isFinished(result.getStatus());
                if (finished) {
                	// Grab the Etag value from the response for use in the update operation.
                	assertNotNull(getResponse.getHeaders().values("Etag"));
                	assertEquals(getResponse.getHeaders().values("Etag").size(), 1);
                	profileTemplateAssignmentEtag = getResponse.getHeaders().values("Etag").get(0);
                    break;
                }
    	    } catch (NotFoundException e) {
    	    	// assignment removed
    	    	finished = true;
                break;
    	    }
            sleep(10);
        }
        assertEquals(finished, true);
    }
    
    private void waitUntilAccountSettingsAssignmentFinished(String assignmentId) {
    	GetAccountSettingsAssignmentOptions getOptions = new GetAccountSettingsAssignmentOptions.Builder()
    			.assignmentId(assignmentId)
    			.build();

    	boolean finished = false;
    	for (int i = 0; i < 20; i++) {
            Response<TemplateAssignmentResponse> getResponse = null;
    		try {
    		    getResponse = service.getAccountSettingsAssignment(getOptions).execute();
                TemplateAssignmentResponse result = getResponse.getResult();
                finished = isFinished(result.getStatus());
                if (finished) {
                	// Grab the Etag value from the response for use in the update operation.
                	assertNotNull(getResponse.getHeaders().values("Etag"));
                	assertEquals(getResponse.getHeaders().values("Etag").size(), 1);
                	accountSettingsTemplateAssignmentEtag = getResponse.getHeaders().values("Etag").get(0);
                    break;
                }
    	    } catch (NotFoundException e) {
    	    	// assignment removed
    	    	finished = true;
                break;
    	    }
            sleep(10);
        }
        assertEquals(finished, true);
    }
    
    private void sleep(int numSecs) {
        try {
            Thread.sleep(numSecs * 1000);
        } catch (Throwable t) {
        }
    }

    private void cleanupResources() {

        ListApiKeysOptions listApiKeysOptions = new ListApiKeysOptions.Builder()
                .accountId(ACCOUNT_ID)
                .iamId(IAM_ID)
                .pagesize(100)
                .build();

        Response<ApiKeyList> response = service.listApiKeys(listApiKeysOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        ApiKeyList apiKeyListResult = response.getResult();

        long numApikeys = apiKeyListResult.getApikeys().size();
        if (numApikeys > 0) {
            for (ApiKey apikey : apiKeyListResult.getApikeys()) {
                if (APIKEY_NAME.equals(apikey.getName())) {
                    DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
                            .id(apikey.getId())
                            .build();

                    // Invoke operation
                    Response<Void> deleteResponse = service.deleteApiKey(deleteApiKeyOptions).execute();
                    assertNotNull(deleteResponse);
                }
            }
        }

        ListServiceIdsOptions listServiceIdsOptions = new ListServiceIdsOptions.Builder()
                .accountId(ACCOUNT_ID)
                .name(SERVICEID_NAME)
                .pagesize(100)
                .build();

        Response<ServiceIdList> listDServiceIdResponse = service.listServiceIds(listServiceIdsOptions).execute();
        assertNotNull(listDServiceIdResponse);
        assertEquals(listDServiceIdResponse.getStatusCode(), 200);
        ServiceIdList serviceIdListResult = listDServiceIdResponse.getResult();
        assertNotNull(serviceIdListResult);

        long numServiceIds = serviceIdListResult.getServiceids().size();
        if (numServiceIds > 0) {
            for (ServiceId serviceId : serviceIdListResult.getServiceids()) {
                if (SERVICEID_NAME.equals(serviceId.getName())) {
                    DeleteServiceIdOptions deleteServiceIdOptions = new DeleteServiceIdOptions.Builder()
                            .id(serviceId.getId())
                            .build();
                    Response<Void> deleteResponse = service.deleteServiceId(deleteServiceIdOptions).execute();
                    assertNotNull(deleteResponse);
                }
            }
        }

        ListProfilesOptions listProfilesOptions = new ListProfilesOptions.Builder()
                .accountId(ACCOUNT_ID)
                .pagesize(100)
                .includeHistory(false)
                .build();

        Response<TrustedProfilesList> profileResponse = service.listProfiles(listProfilesOptions).execute();
        assertNotNull(profileResponse);
        assertEquals(profileResponse.getStatusCode(), 200);

        TrustedProfilesList profilesListResult = profileResponse.getResult();
        long numProfiles = profilesListResult.getProfiles().size();

        if (numProfiles > 0) {
            for (TrustedProfile profile : profilesListResult.getProfiles()) {
                if (PROFILE_NAME_1.equals(profile.getName()) || PROFILE_NAME_2.equals(profile.getName())) {
                    DeleteProfileOptions deleteProfileOptions = new DeleteProfileOptions.Builder()
                            .profileId(profile.getId())
                            .build();

                    // Invoke operation
                    Response<Void> deleteResponse = service.deleteProfile(deleteProfileOptions).execute();
                    assertNotNull(deleteResponse);
                }
            }
        }
        
        ListProfileTemplatesOptions listProfileTemplateOptions = new ListProfileTemplatesOptions.Builder()
        		.accountId(ENTERPRISE_ACCOUNT_ID)
        		.build(); 
        Response<TrustedProfileTemplateList> profileTemplatesResponse = service.listProfileTemplates(listProfileTemplateOptions).execute();
        assertNotNull(profileTemplatesResponse);
        assertEquals(profileTemplatesResponse.getStatusCode(), 200);
        
        TrustedProfileTemplateList profileTemplateList = profileTemplatesResponse.getResult();
        long numProfileTemplates = profileTemplateList.getProfileTemplates().size();

        if (numProfileTemplates > 0) {
            for (TrustedProfileTemplateResponse template : profileTemplateList.getProfileTemplates()) {
                if (PROFILE_TEMPLATE_NAME.equals(template.getName())) {
                	
                	ListTrustedProfileAssignmentsOptions assignmentsListOptions = new ListTrustedProfileAssignmentsOptions.Builder()
                			.accountId(ENTERPRISE_ACCOUNT_ID)
                			.templateId(template.getId())
                			.build();
                	
                	Response<TemplateAssignmentListResponse> assignmentsListResponse = service.listTrustedProfileAssignments(assignmentsListOptions).execute();
                    assertNotNull(assignmentsListResponse);
                    assertEquals(assignmentsListResponse.getStatusCode(), 200);
                    assertNotNull(assignmentsListResponse.getResult());
                    
                    TemplateAssignmentListResponse assignmentsListResult = assignmentsListResponse.getResult();
                    assertNotNull(assignmentsListResult.getAssignments());
                    long numAssignments = assignmentsListResult.getAssignments().size();
                    if (numAssignments > 0) {
                    	for (TemplateAssignmentResponse assignment : assignmentsListResult.getAssignments()) {
                    		if (!isFinished(assignment.getStatus())) {
                    			waitUntilTrustedProfileAssignmentFinished(assignment.getId());
                    		}
                    		DeleteTrustedProfileAssignmentOptions deleteAssignmentOptions = new DeleteTrustedProfileAssignmentOptions.Builder()
                    				.assignmentId(assignment.getId())
                    				.build();
                            Response<ExceptionResponse> deleteAssignmentResponse = service.deleteTrustedProfileAssignment(deleteAssignmentOptions).execute();
                            assertNotNull(deleteAssignmentResponse);
                            assertEquals(deleteAssignmentResponse.getStatusCode(), 202);
                			waitUntilTrustedProfileAssignmentFinished(assignment.getId());
                    	}
                    }
                	
                    DeleteAllVersionsOfProfileTemplateOptions deleteTeplateOptions = new DeleteAllVersionsOfProfileTemplateOptions.Builder()
                    		.templateId(template.getId())
                            .build();

                    // Invoke operation
                    Response<Void> deleteResponse = service.deleteAllVersionsOfProfileTemplate(deleteTeplateOptions).execute();
                    assertNotNull(deleteResponse);
                }
            }
        }
        
        ListAccountSettingsTemplatesOptions listAccountSettingsTemplateOptions = new ListAccountSettingsTemplatesOptions.Builder()
        		.accountId(ENTERPRISE_ACCOUNT_ID)
        		.build(); 
        Response<AccountSettingsTemplateList> accountSettingsTemplatesResponse = service.listAccountSettingsTemplates(listAccountSettingsTemplateOptions).execute();
        assertNotNull(accountSettingsTemplatesResponse);
        assertEquals(accountSettingsTemplatesResponse.getStatusCode(), 200);
        
        AccountSettingsTemplateList accountSettingsTemplateList = accountSettingsTemplatesResponse.getResult();
        long numAccountSettingsTemplates = accountSettingsTemplateList.getAccountSettingsTemplates().size();

        if (numAccountSettingsTemplates > 0) {
            for (AccountSettingsTemplateResponse template : accountSettingsTemplateList.getAccountSettingsTemplates()) {
                if (ACCOUNT_SETTINGS_TEMPLATE_NAME.equals(template.getName())) {
                	
                	ListAccountSettingsAssignmentsOptions assignmentsListOptions = new ListAccountSettingsAssignmentsOptions.Builder()
                			.accountId(ENTERPRISE_ACCOUNT_ID)
                			.templateId(template.getId())
                			.build();
                	
                	Response<TemplateAssignmentListResponse> assignmentsListResponse = service.listAccountSettingsAssignments(assignmentsListOptions).execute();
                    assertNotNull(assignmentsListResponse);
                    assertEquals(assignmentsListResponse.getStatusCode(), 200);
                    assertNotNull(assignmentsListResponse.getResult());
                    
                    TemplateAssignmentListResponse assignmentsListResult = assignmentsListResponse.getResult();
                    assertNotNull(assignmentsListResult.getAssignments());
                    long numAssignments = assignmentsListResult.getAssignments().size();
                    if (numAssignments > 0) {
                    	for (TemplateAssignmentResponse assignment : assignmentsListResult.getAssignments()) {
                    		if (!isFinished(assignment.getStatus())) {
                    			waitUntilAccountSettingsAssignmentFinished(assignment.getId());
                    		}
                    		DeleteAccountSettingsAssignmentOptions deleteAssignmentOptions = new DeleteAccountSettingsAssignmentOptions.Builder()
                    				.assignmentId(assignment.getId())
                    				.build();
                            Response<ExceptionResponse> deleteAssignmentResponse = service.deleteAccountSettingsAssignment(deleteAssignmentOptions).execute();
                            assertNotNull(deleteAssignmentResponse);
                            assertEquals(deleteAssignmentResponse.getStatusCode(), 202);
                			waitUntilAccountSettingsAssignmentFinished(assignment.getId());
                    	}
                    }
                	
                    DeleteAllVersionsOfAccountSettingsTemplateOptions deleteTeplateOptions = new DeleteAllVersionsOfAccountSettingsTemplateOptions.Builder()
                    		.templateId(template.getId())
                            .build();

                    // Invoke operation
                    Response<Void> deleteResponse = service.deleteAllVersionsOfAccountSettingsTemplate(deleteTeplateOptions).execute();
                    assertNotNull(deleteResponse);
                }
            }
        }
    }

    private String getPageTokenFromURL(String s) {
        if (s == null) {
            return null;
        }
        HttpUrl url = HttpUrl.parse(s);
        if (url == null) {
            return null;
        }
        return url.queryParameter("pagetoken");
    }

    private ApiKey getApikey(String id) {
        try {
            GetApiKeyOptions options = new GetApiKeyOptions.Builder().id(id).build();
            Response<ApiKey> response = service.getApiKey(options).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            return response.getResult();
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }

    private ServiceId getServiceId(String id) {
        try {
            GetServiceIdOptions options = new GetServiceIdOptions.Builder().id(id).build();
            Response<ServiceId> response = service.getServiceId(options).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            return response.getResult();
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }

    private TrustedProfile getProfile(String id) {
        try {
            GetProfileOptions options = new GetProfileOptions.Builder().profileId(id).build();
            Response<TrustedProfile> response = service.getProfile(options).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            return response.getResult();
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }

    private ProfileClaimRule getClaimRule(String profileId, String claimRuleId) {
        try {
            GetClaimRuleOptions options = new GetClaimRuleOptions.Builder().profileId(profileId).ruleId(claimRuleId).build();
            Response<ProfileClaimRule> response = service.getClaimRule(options).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            return response.getResult();
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }

    private ProfileLink getLink(String profileId, String linkId) {
        try {
            GetLinkOptions options = new GetLinkOptions.Builder().profileId(profileId).linkId(linkId).build();
            Response<ProfileLink> response = service.getLink(options).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            return response.getResult();
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }
}