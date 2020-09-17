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
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKey;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyList;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyRequest;
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
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the IamIdentity service.
 */
public class IamIdentityIT extends SdkIntegrationTestBase {
    public IamIdentity service = null;
    public static Map<String, String> config = null;

    private final static String TEST_LABEL = "JavaSDKIntegrationTest";

    private static String ACCOUNT_ID;
    private static String SERVICE_ID;
    private static String IAM_ID;
    private static String IAM_APIKEY;

    //optional parameters- default values
    private String pageSize = "20";
    private String order = "asc";
    private String scope = "entity";
    private String sort = "name";
    private String type = "user";
    private String includeHistory = "false";
    private String entityLock = "false";
    private String pageToken;
    private String apikeyId;
    private String serviceIdUnique;

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../v1/iam_identity.env";
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
        SERVICE_ID = config.get("SERVICE_ID");
        IAM_ID = config.get("IAM_ID");
        IAM_APIKEY = config.get("IAM_APIKEY");

        assertNotNull(ACCOUNT_ID);
        assertNotNull(SERVICE_ID);
        assertNotNull(IAM_ID);

        System.out.println("Setup complete.");

    }

    @Test
    public void testListApiKeys() throws Exception {
        try {
            ListApiKeysOptions listApiKeysOptions = new ListApiKeysOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .iamId(IAM_ID)
                    .pagesize("20")
                    .pagetoken("testString")
                    .scope(scope)
                    .type(type)
                    .sort(sort)
                    .order(order)
                    .includeHistory(includeHistory)
                    .build();

            // Invoke operation
            Response<ApiKeyList> response = service.listApiKeys(listApiKeysOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKeyList apiKeyListResult = response.getResult();

            assertNotNull(apiKeyListResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateApiKey() throws Exception {
        try {
            CreateApiKeyOptions createApiKeyOptions = new CreateApiKeyOptions.Builder()
                    .name("apikeyTest")
                    .iamId(IAM_ID)
                    .description("apikeyTest-Desc")
                    .accountId(ACCOUNT_ID)
                    //.apikey("testString")
                    .storeValue(true)
                    .entityLock(entityLock)
                    .build();

            // Invoke operation
            Response<ApiKey> response = service.createApiKey(createApiKeyOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ApiKey apiKeyResult = response.getResult();
            apikeyId = apiKeyResult.getId();

            assertNotNull(apiKeyResult);
            assertNotNull(apikeyId);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testGetApiKeysDetails() throws Exception {
        try {
            GetApiKeysDetailsOptions getApiKeysDetailsOptions = new GetApiKeysDetailsOptions.Builder()
                    .iamApiKey(IAM_APIKEY)
                    .includeHistory(includeHistory)
                    .build();

            // Invoke operation
            Response<ApiKey> response = service.getApiKeysDetails(getApiKeysDetailsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();

            assertNotNull(apiKeyResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey" })
    public void testGetApiKey() throws Exception {
        try {
            GetApiKeyOptions getApiKeyOptions = new GetApiKeyOptions.Builder()
                    .id(apikeyId)
                    .includeHistory(includeHistory)
                    .build();

            // Invoke operation
            Response<ApiKey> response = service.getApiKey(getApiKeyOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();

            assertNotNull(apiKeyResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey" })
    public void testUpdateApiKey() throws Exception {
        try {
            UpdateApiKeyOptions updateApiKeyOptions = new UpdateApiKeyOptions.Builder()
                    .id(apikeyId)
                    .ifMatch("*")
                    .name("apikey-sdktest")
                    .description("sdktest-desc")
                    .build();

            // Invoke operation
            Response<ApiKey> response = service.updateApiKey(updateApiKeyOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ApiKey apiKeyResult = response.getResult();

            assertNotNull(apiKeyResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateApiKey" })
    public void testLockApiKey() throws Exception {
        try {
            LockApiKeyOptions lockApiKeyOptions = new LockApiKeyOptions.Builder()
                    .id(apikeyId)
                    .build();

            // Invoke operation
            Response<Void> response = service.lockApiKey(lockApiKeyOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testListServiceIds() throws Exception {
        try {
            ListServiceIdsOptions listServiceIdsOptions = new ListServiceIdsOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .name("testString")
                    .pagesize(pageSize)
                    //.pagetoken("testString")
                    .sort(sort)
                    .order(order)
                    .includeHistory(includeHistory)
                    .build();

            // Invoke operation
            Response<ServiceIdList> response = service.listServiceIds(listServiceIdsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceIdList serviceIdListResult = response.getResult();

            assertNotNull(serviceIdListResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateServiceId() throws Exception {
        try {
            CreateApiKeyRequest createApiKeyRequestModel = new CreateApiKeyRequest.Builder()
                    .name("apikey-test-serv")
                    .description("apikey-test-serv")
                    .iamId(IAM_ID)
                    .accountId(ACCOUNT_ID)
                    //.apikey(IAM_APIKEY)
                    .storeValue(true)
                    .build();

            CreateServiceIdOptions createServiceIdOptions = new CreateServiceIdOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .name("ServiceId-Test")
                    .description("ServiceID-Test-desc")
                    //.uniqueInstanceCrns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
                    .apikey(createApiKeyRequestModel)
                    .entityLock(entityLock)
                    .build();

            // Invoke operation
            Response<ServiceId> response = service.createServiceId(createServiceIdOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();
            serviceIdUnique = serviceIdResult.getId();

            assertNotNull(serviceIdResult);
            assertNotNull(serviceIdUnique);

        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateServiceId" })
    public void testGetServiceId() throws Exception {
        try {
            GetServiceIdOptions getServiceIdOptions = new GetServiceIdOptions.Builder()
                    .id(serviceIdUnique)
                    .includeHistory(includeHistory)
                    .build();

            // Invoke operation
            Response<ServiceId> response = service.getServiceId(getServiceIdOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();

            assertNotNull(serviceIdResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateServiceId" })
    public void testUpdateServiceId() throws Exception {
        try {
            UpdateServiceIdOptions updateServiceIdOptions = new UpdateServiceIdOptions.Builder()
                    .id(serviceIdUnique)
                    .ifMatch("*")
                    .name("updatedServiceId")
                    .description("updatedServiceId-Desc")
                    //.uniqueInstanceCrns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
                    .build();

            // Invoke operation
            Response<ServiceId> response = service.updateServiceId(updateServiceIdOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();

            assertNotNull(serviceIdResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateServiceId" })
    public void testLockServiceId() throws Exception {
        try {
            LockServiceIdOptions lockServiceIdOptions = new LockServiceIdOptions.Builder()
                    .id(serviceIdUnique)
                    .build();

            // Invoke operation
            Response<ServiceId> response = service.lockServiceId(lockServiceIdOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();

            assertNotNull(serviceIdResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testLockServiceId" })
    public void testUnlockServiceId() throws Exception {
        try {
            UnlockServiceIdOptions unlockServiceIdOptions = new UnlockServiceIdOptions.Builder()
                    .id(serviceIdUnique)
                    .build();

            // Invoke operation
            Response<ServiceId> response = service.unlockServiceId(unlockServiceIdOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceId serviceIdResult = response.getResult();

            assertNotNull(serviceIdResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testLockApiKey" })
    public void testUnlockApiKey() throws Exception {
        try {
            UnlockApiKeyOptions unlockApiKeyOptions = new UnlockApiKeyOptions.Builder()
                    .id(apikeyId)
                    .build();

            // Invoke operation
            Response<Void> response = service.unlockApiKey(unlockApiKeyOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUnlockServiceId" })
    public void testDeleteServiceId() throws Exception {
        try {
            DeleteServiceIdOptions deleteServiceIdOptions = new DeleteServiceIdOptions.Builder()
                    .id(serviceIdUnique)
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteServiceId(deleteServiceIdOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUnlockApiKey" })
    public void testDeleteApiKey() throws Exception {
        try {
            DeleteApiKeyOptions deleteApiKeyOptions = new DeleteApiKeyOptions.Builder()
                    .id(apikeyId)
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteApiKey(deleteApiKeyOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @AfterClass
    public void tearDown() {
        // Add any clean up logic here
        System.out.println("Clean up complete.");
    }
}
