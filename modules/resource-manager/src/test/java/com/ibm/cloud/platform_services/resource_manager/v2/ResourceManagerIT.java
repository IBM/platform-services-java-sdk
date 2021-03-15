package com.ibm.cloud.platform_services.resource_manager.v2;

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

import com.ibm.cloud.platform_services.resource_manager.v2.model.*;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertFalse;

/**
 * Integration test class for the IamAccessGroups service.
 */
public class ResourceManagerIT extends SdkIntegrationTestBase {
    public static Map<String, String> config = null;
    ResourceManager resourceManagerService = null;

    private static String URL;
    private static String AUTH_TYPE;
    private static String APIKEY;
    private static String AUTH_URL;
    private static String QUOTA_ID;
    private static String USER_ACCOUNT_ID;

    private static String NEW_RESOURCE_GROUP_ID = "NEW_RESOURCE_GROUP_ID";

    // Simulates the user's activity. Only a user from account can delete resource group
    ResourceManager resourceManagerUsersService = null;

    @Override
    public String getConfigFilename() {
        return "../../resource_manager.env";
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

        // Construct the service1 instance from our external configuration.
        resourceManagerService = ResourceManager.newInstance("RESOURCE_MANAGER_SERVICE");
        assertNotNull(resourceManagerService);
        assertNotNull(resourceManagerService.getServiceUrl());

        // Construct the service2 instance from our external configuration.
        resourceManagerUsersService = ResourceManager.newInstance(ResourceManager.DEFAULT_SERVICE_NAME);
        assertNotNull(resourceManagerUsersService);
        assertNotNull(resourceManagerUsersService.getServiceUrl());

        //Load up our test-specific config properties
        config = CredentialUtils.getServiceProperties(ResourceManager.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(resourceManagerUsersService.getServiceUrl(), config.get("URL"));

        URL = config.get("URL");
        AUTH_TYPE = config.get("AUTH_TYPE");
        APIKEY = config.get("APIKEY");
        AUTH_URL = config.get("AUTH_URL");
        QUOTA_ID = config.get("QUOTA_ID");
        USER_ACCOUNT_ID = config.get("USER_ACCOUNT_ID");

        assertNotNull(URL);
        assertNotNull(AUTH_TYPE);
        assertNotNull(APIKEY);
        assertNotNull(AUTH_URL);
        assertNotNull(QUOTA_ID);
        assertNotNull(USER_ACCOUNT_ID);

        log("Service URL: " + resourceManagerUsersService.getServiceUrl());
        log("Setup Complete.");
    }

    @Test
    public void testListQuotaDefinitions() {
        Response<QuotaDefinitionList> response = resourceManagerService.listQuotaDefinitions().execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        QuotaDefinitionList result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getResources());
    }

    @Test
    public void testGetQuotaDefinition() {
        GetQuotaDefinitionOptions options = new GetQuotaDefinitionOptions.Builder()
                .id(QUOTA_ID)
                .build();

        Response<QuotaDefinition> response = resourceManagerService.getQuotaDefinition(options).execute();
        assertEquals(response.getStatusCode(), 200);

        QuotaDefinition result = response.getResult();
        assertNotNull(result);
    }


    @Test
    public void testListResourceGroupsInAccount() {
        ListResourceGroupsOptions options = new ListResourceGroupsOptions.Builder()
                .accountId(USER_ACCOUNT_ID)
                .build();

        Response<ResourceGroupList> response = resourceManagerService.listResourceGroups(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceGroupList result = response.getResult();
        assertNotNull(result.getResources());
        assertNotNull(result.getResources().get(0).getId());
        assertNotNull(result.getResources().get(0).getName());
        assertNotNull(result.getResources().get(0).getCrn());
        assertNotNull(result.getResources().get(0).getAccountId());
        assertNotNull(result.getResources().get(0).getState());
        assertNotNull(result.getResources().get(0).getQuotaId());
        assertNotNull(result.getResources().get(0).getQuotaUrl());
        assertNotNull(result.getResources().get(0).getCreatedAt());
        assertNotNull(result.getResources().get(0).getUpdatedAt());
    }

    @Test(priority = 0)
    public void testCreateResourceGroupInAccount(ITestContext iTestContext) {
        CreateResourceGroupOptions options = new CreateResourceGroupOptions.Builder()
                .accountId(USER_ACCOUNT_ID)
                .name("TestGroup")
                .build();

        Response<ResCreateResourceGroup> response = resourceManagerService.createResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResCreateResourceGroup result = response.getResult();
        assertNotNull(result.getId());

        iTestContext.setAttribute(NEW_RESOURCE_GROUP_ID, result.getId());
    }

    @Test(priority = 1)
    public void testGetResourceGroupById(ITestContext iTestContext) {
        String newResourceGroupId = (String) iTestContext.getAttribute(NEW_RESOURCE_GROUP_ID);
        assertNotNull(newResourceGroupId);

        GetResourceGroupOptions options = new GetResourceGroupOptions.Builder()
                .id(newResourceGroupId)
                .build();

        Response<ResourceGroup> response = resourceManagerService.getResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceGroup result = response.getResult();
        assertNotNull(result);
    }

    @Test(priority = 1)
    public void testUpdateResourceGroupById(ITestContext iTestContext) {
        String newResourceGroupId = (String) iTestContext.getAttribute(NEW_RESOURCE_GROUP_ID);
        assertNotNull(newResourceGroupId);

        UpdateResourceGroupOptions options = new UpdateResourceGroupOptions.Builder()
                .id(newResourceGroupId)
                .name("TestGroup2")
                .state("ACTIVE")
                .build();

        Response<ResourceGroup> response = resourceManagerService.updateResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceGroup result = response.getResult();
        assertNotNull(result);
    }

    @Test(priority = 1)
    public void testDeleteResourceGroupById(ITestContext iTestContext) {
        String newResourceGroupId = (String) iTestContext.getAttribute(NEW_RESOURCE_GROUP_ID);
        assertNotNull(newResourceGroupId);

        DeleteResourceGroupOptions options = new DeleteResourceGroupOptions.Builder()
                .id(newResourceGroupId)
                .build();

        Response<Void> response = resourceManagerUsersService.deleteResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

}

