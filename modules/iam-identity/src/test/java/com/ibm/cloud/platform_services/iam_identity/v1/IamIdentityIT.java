/*
 * (C) Copyright IBM Corp. 2020, 2021.
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
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateLinkOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileLinkRequestLink;
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
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkLink;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileLinkList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.Report;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportReference;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfilesList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateProfileOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdOptions;
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
    private static String REALM_NAME = "https://w3id.sso.ibm.com/auth/sps/samlidp2/saml20";

    private static String ACCOUNT_ID;
    private static String IAM_ID;
    private static String IAM_ID_MEMBER;
    private static String IAM_APIKEY;

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
    public void testCreateProfile1() throws Exception{
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
    public void testCreateProfile2() throws Exception{
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
                    .crn("crn:v1:staging:public:iam-identity::a/"+ ACCOUNT_ID +"::computeresource:Fake-Compute-Resource")
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
            assertEquals(e.getStatusCode(), 403);
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
                    .systemRefreshTokenExpirationInSeconds("2592000")
                    .build();

            // Invoke operation
            Response<AccountSettingsResponse> response = service.updateAccountSettings(updateAccountSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            AccountSettingsResponse accountSettingsResponseResult = response.getResult();
            assertNotNull(accountSettingsResponseResult);

            assertNull(accountSettingsResponseResult.getAllowedIpAddresses());
            assertEquals(accountSettingsResponseResult.getAccountId(), updateAccountSettingsOptions.accountId());
            assertEquals(accountSettingsResponseResult.getMfa(), updateAccountSettingsOptions.mfa());
            assertEquals(accountSettingsResponseResult.getUserMfa(), updateAccountSettingsOptions.userMfa());
            assertEquals(accountSettingsResponseResult.getRestrictCreatePlatformApikey(), updateAccountSettingsOptions.restrictCreatePlatformApikey());
            assertEquals(accountSettingsResponseResult.getRestrictCreateServiceId(), updateAccountSettingsOptions.restrictCreateServiceId());
            assertEquals(accountSettingsResponseResult.getSessionExpirationInSeconds(), updateAccountSettingsOptions.sessionExpirationInSeconds());
            assertEquals(accountSettingsResponseResult.getSessionInvalidationInSeconds(), updateAccountSettingsOptions.sessionInvalidationInSeconds());
            assertEquals(accountSettingsResponseResult.getSystemAccessTokenExpirationInSeconds(), updateAccountSettingsOptions.systemAccessTokenExpirationInSeconds());
            assertEquals(accountSettingsResponseResult.getSystemRefreshTokenExpirationInSeconds(), updateAccountSettingsOptions.systemRefreshTokenExpirationInSeconds());
            assertNotEquals(accountSettingsResponseResult.getEntityTag(), accountSettingsEtag);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }
    
    @Test
    public void testCreateReport() throws Exception {
        try{
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

    @Test
    public void testGetReportIncomplete() throws Exception {
        try{
            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference(reportReference)
                    .build();
            Response<Report> response = service.getReport(getReportOptions).execute();
            
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetReportComplete() throws Exception {
        try{
            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference(reportReference)
                    .build();
            for (int i = 0; i < 30; i++){
                Response<Report> response = service.getReport(getReportOptions).execute();
                if(response.getStatusCode() != 204){
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
        try{
            GetReportOptions getReportOptions = new GetReportOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .reference("test123")
                    .build();
            Response<Report> response = service.getReport(getReportOptions).execute();
            
            assertEquals(response.getStatusCode(), 404);
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
        assertNotNull(response);
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