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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Integration test class for the IamAccessGroups service.
 */
public class ResourceManagerIT extends SdkIntegrationTestBase {

    private static final String TEST_QUOTA_ID = "7ce89f4a-4381-4600-b814-3cd9a4f4bdf4";
    private static final String TEST_USER_ACCOUNT_ID = "60ce10d1d94749bf8dceff12065db1b0";
    ResourceManager service1 = null;
    ResourceManager service2 = null;
    String newResourceGroupID = null;

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../resource_manager.env";
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
        service1 = ResourceManager.newInstance("RMGR1");
        assertNotNull(service1);
        assertNotNull(service1.getServiceUrl());

        // Construct the service2 instance from our external configuration.
        service2 = ResourceManager.newInstance("RMGR2");
        assertNotNull(service2);
        assertNotNull(service2.getServiceUrl());
    }

    @Test
    public void testListQuotaDefinitions() {
        Response<QuotaDefinitionList> response = service1.listQuotaDefinitions().execute();
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

        Response<QuotaDefinition> response = service1.getQuotaDefinition(options).execute();
        assertEquals(response.getStatusCode(), 200);

        QuotaDefinition result = response.getResult();
        assertNotNull(result);
    }


    @Test
    public void testListResourceGroupsInAccount() {
        ListResourceGroupsOptions options = new ListResourceGroupsOptions.Builder()
                .accountId(TEST_USER_ACCOUNT_ID)
                .build();

        Response<ResourceGroupList> response = service1.listResourceGroups(options).execute();
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

        Response<ResCreateResourceGroup> response = service1.createResourceGroup(options).execute();
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

        Response<ResourceGroup> response = service1.getResourceGroup(options).execute();
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

        Response<ResourceGroup> response = service1.updateResourceGroup(options).execute();
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

        Response<Void> response = service2.deleteResourceGroup(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

}

