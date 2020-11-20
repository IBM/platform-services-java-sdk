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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.DeleteServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetApiKeysDetailsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListApiKeysOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ListServiceIdsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LockServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceId;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UnlockServiceIdOptions;
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

    private static String ACCOUNT_ID;
    private static String IAM_ID;
    private static String IAM_APIKEY;

    private static String IAM_ID_INVALID = "IAM-InvalidId";
    private static String ACCOUNT_ID_INVALID = "Account-InvalidId";

    // Variables that hold values to be shared between the test methods.
    private String apikeyId1;
    private String apikeyEtag1;
    private String apikeyId2;

    private String serviceId1;
    private String serviceIdEtag1;

    @Override
    public String getConfigFilename() {
        return "../../iam_identity.env";
    }

    @Override
    public boolean loggingEnabled() {
        return false;
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
        IAM_APIKEY = config.get("APIKEY");

        assertNotNull(ACCOUNT_ID);
        assertNotNull(IAM_ID);
        assertNotNull(IAM_APIKEY);

        // Make sure we start with a clean slate.
        cleanupResources();

        log("Setup complete.");
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
            log(String.format(">>> createApiKey #1 response:\n%s", apiKeyResult.toString()));

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
            log(String.format("\n>>> createApiKey #2 response:\n%s", apiKeyResult.toString()));

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
                    .build();

            Response<ApiKey> response = service.getApiKey(getApiKeyOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();
            assertNotNull(apiKeyResult);
            log(String.format("\n>>> getApiKey response:\n%s", apiKeyResult.toString()));

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
            log(String.format("\n>>> getApiKeysDetails response:\n%s", apiKeyResult.toString()));

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
                log(String.format("\n>>> listApiKeys response:\n%s", apiKeyListResult.toString()));

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
            log(String.format("\n>>> updateApiKey response:\n%s", apiKeyResult.toString()));

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
            log(String.format("\n>>> createServiceId response:\n%s", serviceIdResult.toString()));

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
                    .build();

            Response<ServiceId> response = service.getServiceId(getServiceIdOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();
            assertNotNull(serviceIdResult);
            log(String.format("\n>>> getServiceId response:\n%s", serviceIdResult.toString()));

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
            log(String.format("\n>>> listServiceIds response:\n%s", serviceIdListResult.toString()));

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
            log(String.format("\n>>> updateServiceId response:\n%s", serviceIdResult.toString()));

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
             log(String.format("Service returned status code %s: %s\nError details: %s",
                  e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
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
             log(String.format("Service returned status code %s: %s\nError details: %s",
                  e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
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
             log(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
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
             log(String.format("Service returned status code %s: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 404);
        }
    }

    @AfterClass
    public void tearDown() {
        // Add any clean up logic here.
        sleep(5);
        cleanupResources();
        log("Clean up complete.");
    }

    private void sleep(int numSecs) {
        try {
            Thread.sleep(numSecs * 1000);
        } catch (Throwable t) {
        }

    }

    private void cleanupResources() {
        log(">>> Cleaning up resources.");

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
        log(String.format(">>> Cleanup found %d apikeys.", numApikeys));
        if (numApikeys > 0) {
            for (ApiKey apikey : apiKeyListResult.getApikeys()) {
                if (APIKEY_NAME.equals(apikey.getName())) {
                    log(String.format(">>> Deleting apikey: %s", apikey.getId()));
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
        log(String.format(">>> Cleanup found %d service ids.", numServiceIds));
        if (numServiceIds > 0) {
            for (ServiceId serviceId : serviceIdListResult.getServiceids()) {
                if (SERVICEID_NAME.equals(serviceId.getName())) {
                    log(String.format(">>> Deleting serviceId: %s", serviceId.getId()));
                    DeleteServiceIdOptions deleteServiceIdOptions = new DeleteServiceIdOptions.Builder()
                            .id(serviceId.getId())
                            .build();
                    Response<Void> deleteResponse = service.deleteServiceId(deleteServiceIdOptions).execute();
                    assertNotNull(deleteResponse);
                }
            }
        }

        log(">>> Finished cleanup.");
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
}
