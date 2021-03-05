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
    ResourceManager canCreateRetrieveAndUpdateResourceGroupService = null;

    private static String URL;
    private static String AUTH_TYPE;
    private static String APIKEY;
    private static String AUTH_URL;
    private static String TEST_QUOTA_ID;
    private static String TEST_USER_ACCOUNT_ID;

    // Simulates the user's activity. Only a user from account can delete resource group
    ResourceManager usersService = null;
    String newResourceGroupID = null;

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
        canCreateRetrieveAndUpdateResourceGroupService = ResourceManager.newInstance("RMGR1");
        assertNotNull(canCreateRetrieveAndUpdateResourceGroupService);
        assertNotNull(canCreateRetrieveAndUpdateResourceGroupService.getServiceUrl());

        // Construct the service2 instance from our external configuration.
        usersService = ResourceManager.newInstance("RMGR2");
        assertNotNull(usersService);
        assertNotNull(usersService.getServiceUrl());

        //Load up our test-specific config properties
        config = CredentialUtils.getServiceProperties(ResourceManager.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(usersService.getServiceUrl(), config.get("URL"));

        URL = config.get("URL");
        AUTH_TYPE = config.get("AUTH_TYPE");
        APIKEY = config.get("APIKEY");
        AUTH_URL = config.get("AUTH_URL");
        TEST_QUOTA_ID = config.get("TEST_QUOTA_ID");
        TEST_USER_ACCOUNT_ID = config.get("TEST_USER_ACCOUNT_ID");

        assertNotNull(URL);
        assertNotNull(AUTH_TYPE);
        assertNotNull(APIKEY);
        assertNotNull(AUTH_URL);
        assertNotNull(TEST_QUOTA_ID);
        assertNotNull(TEST_USER_ACCOUNT_ID);

        log("Service URL: " + usersService.getServiceUrl());
        log("Setup Complete.");
    }

    @Test
    public void testListQuotaDefinitions() {
        Response<QuotaDefinitionList> response = canCreateRetrieveAndUpdateResourceGroupService.listQuotaDefinitions().execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        QuotaDefinitionList result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getResources());
    }

    @Test
    public void testGetQuotaDefinition() {
        GetQuotaDefinitionOptions options = new GetQuotaDefinitionOptions.Builder()
                .id(TEST_QUOTA_ID)
                .build();

        Response<QuotaDefinition> response = canCreateRetrieveAndUpdateResourceGroupService.getQuotaDefinition(options).execute();
        assertEquals(response.getStatusCode(), 200);

        QuotaDefinition result = response.getResult();
        assertNotNull(result);
    }


    @Test
    public void testListResourceGroupsInAccount() {
        ListResourceGroupsOptions options = new ListResourceGroupsOptions.Builder()
                .accountId(TEST_USER_ACCOUNT_ID)
                .build();

        Response<ResourceGroupList> response = canCreateRetrieveAndUpdateResourceGroupService.listResourceGroups(options).execute();
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

    @Test
    public void testCreateResourceGroupInAccount() {
        CreateResourceGroupOptions options = new CreateResourceGroupOptions.Builder()
                .accountId(TEST_USER_ACCOUNT_ID)
                .name("TestGroup")
                .build();

        Response<ResCreateResourceGroup> response = canCreateRetrieveAndUpdateResourceGroupService.createResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResCreateResourceGroup result = response.getResult();
        assertNotNull(result.getId());

        newResourceGroupID = result.getId();
    }

    @Test
    public void testGetResourceGroupById() {
        GetResourceGroupOptions options = new GetResourceGroupOptions.Builder()
                .id(newResourceGroupID)
                .build();

        Response<ResourceGroup> response = canCreateRetrieveAndUpdateResourceGroupService.getResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceGroup result = response.getResult();
        assertNotNull(result);
    }

    @Test
    public void testUpdateResourceGroupById() {
        UpdateResourceGroupOptions options = new UpdateResourceGroupOptions.Builder()
                .id(newResourceGroupID)
                .name("TestGroup2")
                .state("ACTIVE")
                .build();

        Response<ResourceGroup> response = canCreateRetrieveAndUpdateResourceGroupService.updateResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceGroup result = response.getResult();
        assertNotNull(result);
    }

    @Test
    public void testDeleteResourceGroupById() {
        DeleteResourceGroupOptions options = new DeleteResourceGroupOptions.Builder()
                .id(newResourceGroupID)
                .build();

        Response<Void> response = usersService.deleteResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

}

