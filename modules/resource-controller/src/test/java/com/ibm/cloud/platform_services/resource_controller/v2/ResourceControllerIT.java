package com.ibm.cloud.platform_services.resource_controller.v2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.DeleteResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.GetResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListReclamationsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceInstancesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.LockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.Reclamation;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ReclamationsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAlias;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceAliasesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBinding;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceBindingsList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstance;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceInstancesList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKey;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeysList;
import com.ibm.cloud.platform_services.resource_controller.v2.model.RunReclamationActionOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UnlockResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceBindingOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceKeyOptions;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the ResourceController service.
 */
public class ResourceControllerIT extends SdkIntegrationTestBase {

    public static Map<String, String> config = null;
    private static String TEST_ACCOUNT_ID = null;
    private static String TEST_RESOURCE_GROUP_ID = null;
    private static String TEST_ORG_ID = null;
    private static String TEST_SPACE_ID = null;
    private static String TEST_APP_ID = null;
    private static String TEST_PLAN_ID1 = null;
    private static String TEST_PLAN_ID2 = null;
    private static final String TEST_REGION_ID1 = "global";
    private static final String TEST_REGION_ID2 = "global";

    private static final String reclaimInstanceName = "RcSdkReclaimInstance1";
    private static final String lockedInstanceNameUpdate = "RcSdkLockedInstanceUpdate1";
    private static final Map<String, String> instanceNames = new HashMap<String, String>();
    private static final Map<String, String> aliasNames = new HashMap<String, String>();
    private static final Map<String, String> bindingNames = new HashMap<String, String>();
    private static final Map<String, String> keyNames = new HashMap<String, String>();

    ResourceController service = null;
    String transactionId = null;
    String testInstanceCrn = null;
    String testInstanceGuid = null;
    String testAliasCrn = null;
    String testAliasGuid = null;
    String testBindingCrn = null;
    String testBindingGuid = null;
    String testInstanceKeyCrn = null;
    String testInstanceKeyGuid = null;
    String testAliasKeyCrn = null;
    String testAliasKeyGuid = null;
    String aliasTargetCrn = null;
    String bindTargetCrn = null;
    String testReclaimInstanceCrn = null;
    String testReclaimInstanceGuid = null;
    String testReclamationId1 = null;
    String testReclamationId2 = null;

    @Override
    public String getConfigFilename() {
        return "../../resource_controller.env";
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
        // Populate name maps
        instanceNames.put("name", "RcSdkInstance1Java");
        instanceNames.put("update", "RcSdkInstanceUpdate1Java");
        aliasNames.put("name", "RcSdkAlias1Java");
        aliasNames.put("update", "RcSdkAliasUpdate1Java");
        bindingNames.put("name", "RcSdkBinding1Java");
        bindingNames.put("update", "RcSdkBindingUpdate1Java");
        keyNames.put("name", "RcSdkKey1Java");
        keyNames.put("update", "RcSdkKeyUpdate1Java");
        keyNames.put("name2", "RcSdkKey2Java");
        keyNames.put("update2", "RcSdkKeyUpdate2Java");

        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        // Construct the service instance from our external configuration.
        service = ResourceController.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        config = CredentialUtils.getServiceProperties(ResourceController.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());

        TEST_ACCOUNT_ID = config.get("ACCOUNT_ID");
        TEST_RESOURCE_GROUP_ID = config.get("RESOURCE_GROUP");
        TEST_ORG_ID = config.get("ORGANIZATION_GUID");
        TEST_SPACE_ID = config.get("SPACE_GUID");
        TEST_APP_ID = config.get("APPLICATION_GUID");
        TEST_PLAN_ID1 = config.get("PLAN_ID");
        TEST_PLAN_ID2 = config.get("RECLAMATION_PLAN_ID");

        transactionId = UUID.randomUUID().toString();
        log("Transaction-Id for Test Run: " + transactionId);
    }

    @AfterClass
    public void cleanup() {
        cleanupResources();

        if (testReclaimInstanceGuid != null) {
            cleanupReclamationInstance();
        } else {
            log("Reclamation instance was not created. No cleanup needed.");
        }
        cleanupByName();
    }

    @Test
    public void test00CreateResoureInstance() {
        CreateResourceInstanceOptions options = new CreateResourceInstanceOptions.Builder()
            .name(instanceNames.get("name"))
            .target(TEST_REGION_ID1)
            .resourceGroup(TEST_RESOURCE_GROUP_ID)
            .resourcePlanId(TEST_PLAN_ID1)
            .build();

        Response<ResourceInstance> response = service.createResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test00-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getGuid());
        assertNotNull(result.getCrn());
        assertEquals(result.getId(), result.getCrn());
        assertEquals(result.getName(), instanceNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getResourcePlanId(), TEST_PLAN_ID1);
        assertEquals(result.getState(), "active");
        assertFalse(result.isLocked());
        assertEquals(result.getLastOperation().get("type").toString(), "create");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");

        testInstanceCrn = result.getId();
        testInstanceGuid = result.getGuid();
    }

    @Test
    public void test01GetResourceInstance() {
        GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
            .id(testInstanceGuid)
            .build();

        Response<ResourceInstance> response = service.getResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test01-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceCrn);
        assertEquals(result.getGuid(), testInstanceGuid);
        assertEquals(result.getCrn(), testInstanceCrn);
        assertEquals(result.getName(), instanceNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getResourcePlanId(), TEST_PLAN_ID1);
        assertEquals(result.getState(), "active");
        assertFalse(result.isLocked());
        assertEquals(result.getLastOperation().get("type").toString(), "create");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    }

    @Test
    public void test02UpdateResourceInstance() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hello", "bye");

        UpdateResourceInstanceOptions options = new UpdateResourceInstanceOptions.Builder()
            .id(testInstanceGuid)
            .name(instanceNames.get("update"))
            .parameters(params)
            .build();

        Response<ResourceInstance> response = service.updateResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test02-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceCrn);
        assertEquals(result.getName(), instanceNames.get("update"));
        assertEquals(result.getState(), "active");
        assertEquals(result.getLastOperation().get("type").toString(), "update");
        assertEquals(result.getLastOperation().get("sub_type").toString(), "config");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    }

    @Test
    public void test03ListResourceInstancesWithNoFilter() {
        ListResourceInstancesOptions options = new ListResourceInstancesOptions.Builder().build();

        Response<ResourceInstancesList> response = service.listResourceInstances(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test03-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceInstancesList result = response.getResult();
        assertNotEquals(result.getResources().size(), 0);
        assertNotEquals(result.getRowsCount(), 0);
    }

    @Test
    public void test04ListResourceInstancesWithGuidFilter() {
        ListResourceInstancesOptions options = new ListResourceInstancesOptions.Builder()
            .guid(testInstanceGuid)
            .build();

        Response<ResourceInstancesList> response = service.listResourceInstances(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test04-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceInstancesList result = response.getResult();
        assertEquals(result.getResources().size(), 1);
        assertEquals(result.getRowsCount(), Long.valueOf(1));

        ResourceInstance instance = result.getResources().get(0);
        assertEquals(instance.getId(), testInstanceCrn);
        assertEquals(instance.getGuid(), testInstanceGuid);
        assertEquals(instance.getName(), instanceNames.get("update"));
        assertEquals(instance.getState(), "active");
        assertEquals(instance.getLastOperation().get("type").toString(), "update");
        assertEquals(instance.getLastOperation().get("sub_type").toString(), "config");
        assertFalse((Boolean) instance.getLastOperation().get("async"));
        assertEquals(instance.getLastOperation().get("state").toString(), "succeeded");
    }

    @Test
    public void test05ListResourceInstancesWithNameFilter() {
        ListResourceInstancesOptions options = new ListResourceInstancesOptions.Builder()
            .name(instanceNames.get("name"))
            .build();

        Response<ResourceInstancesList> response = service.listResourceInstances(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test05-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceInstancesList result = response.getResult();
        assertEquals(result.getResources().size(), 0);
        assertEquals(result.getRowsCount(), Long.valueOf(0));
    }

    @Test
    public void test06CreateResoureAlias() {
        String target = "crn:v1:bluemix:public:bluemix:us-south:o/" + TEST_ORG_ID + "::cf-space:" + TEST_SPACE_ID;
        aliasTargetCrn = "crn:v1:bluemix:public:cf:us-south:o/" + TEST_ORG_ID + "::cf-space:" + TEST_SPACE_ID;
        CreateResourceAliasOptions options = new CreateResourceAliasOptions.Builder()
            .name(aliasNames.get("name"))
            .source(testInstanceGuid)
            .target(target)
            .build();

        Response<ResourceAlias> response = service.createResourceAlias(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test06-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResourceAlias result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getGuid());
        assertNotNull(result.getCrn());
        assertEquals(result.getId(), result.getCrn());
        assertEquals(result.getName(), aliasNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getTargetCrn(), aliasTargetCrn);
        assertEquals(result.getState(), "active");
        assertEquals(result.getResourceInstanceId(), testInstanceCrn);

        testAliasCrn = result.getId();
        testAliasGuid = result.getGuid();
    }

    @Test
    public void test07GetResourceAlias() {
        GetResourceAliasOptions options = new GetResourceAliasOptions.Builder()
            .id(testAliasGuid)
            .build();

        Response<ResourceAlias> response = service.getResourceAlias(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test07-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceAlias result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testAliasCrn);
        assertEquals(result.getGuid(), testAliasGuid);
        assertEquals(result.getCrn(), testAliasCrn);
        assertEquals(result.getName(), aliasNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getTargetCrn(), aliasTargetCrn);
        assertEquals(result.getState(), "active");
        assertEquals(result.getResourceInstanceId(), testInstanceCrn);
    }

    @Test
    public void test08UpdateResourceAlias() {
        UpdateResourceAliasOptions options = new UpdateResourceAliasOptions.Builder()
            .id(testAliasGuid)
            .name(aliasNames.get("update"))
            .build();

        Response<ResourceAlias> response = service.updateResourceAlias(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test08-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceAlias result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testAliasCrn);
        assertEquals(result.getName(), aliasNames.get("update"));
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test09ListResourceAliasesWithNoFilter() {
        ListResourceAliasesOptions options = new ListResourceAliasesOptions.Builder().build();

        Response<ResourceAliasesList> response = service.listResourceAliases(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test09-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceAliasesList result = response.getResult();
        assertNotEquals(result.getResources().size(), 0);
        assertNotEquals(result.getRowsCount(), 0);
    }

    @Test
    public void test10ListResourceAliasesWithGuidFilter() {
        ListResourceAliasesOptions options = new ListResourceAliasesOptions.Builder()
            .guid(testAliasGuid)
            .build();

        Response<ResourceAliasesList> response = service.listResourceAliases(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test10-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceAliasesList result = response.getResult();
        assertEquals(result.getResources().size(), 1);
        assertEquals(result.getRowsCount(), Long.valueOf(1));

        ResourceAlias alias = result.getResources().get(0);
        assertEquals(alias.getId(), testAliasCrn);
        assertEquals(alias.getGuid(), testAliasGuid);
        assertEquals(alias.getName(), aliasNames.get("update"));
        assertEquals(alias.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(alias.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(alias.getTargetCrn(), aliasTargetCrn);
        assertEquals(alias.getState(), "active");
        assertEquals(alias.getResourceInstanceId(), testInstanceCrn);
    }

    @Test
    public void test11ListResourceAliasesWithNameFilter() {
        ListResourceAliasesOptions options = new ListResourceAliasesOptions.Builder()
            .name(aliasNames.get("name"))
            .build();

        Response<ResourceAliasesList> response = service.listResourceAliases(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test11-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceAliasesList result = response.getResult();
        assertEquals(result.getResources().size(), 0);
        assertEquals(result.getRowsCount(), Long.valueOf(0));
    }

    @Test
    public void test12CreateResoureBinding() {
        String target = "crn:v1:staging:public:bluemix:us-south:s/" + TEST_SPACE_ID + "::cf-application:" + TEST_APP_ID;
        bindTargetCrn = "crn:v1:staging:public:cf:us-south:s/" + TEST_SPACE_ID + "::cf-application:" + TEST_APP_ID;
        CreateResourceBindingOptions options = new CreateResourceBindingOptions.Builder()
            .source(testAliasGuid)
            .target(target)
            .name(bindingNames.get("name"))
            .build();

        Response<ResourceBinding> response = service.createResourceBinding(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test12-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResourceBinding result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getGuid());
        assertNotNull(result.getCrn());
        assertEquals(result.getId(), result.getCrn());
        assertEquals(result.getName(), bindingNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getSourceCrn(), testAliasCrn);
        assertEquals(result.getTargetCrn(), bindTargetCrn);
        assertEquals(result.getState(), "active");

        testBindingCrn = result.getId();
        testBindingGuid = result.getGuid();
    }

    @Test
    public void test13GetResourceBinding() {
        GetResourceBindingOptions options = new GetResourceBindingOptions.Builder()
            .id(testBindingGuid)
            .build();

        Response<ResourceBinding> response = service.getResourceBinding(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test13-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceBinding result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testBindingCrn);
        assertEquals(result.getGuid(), testBindingGuid);
        assertEquals(result.getCrn(), testBindingCrn);
        assertEquals(result.getName(), bindingNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getSourceCrn(), testAliasCrn);
        assertEquals(result.getTargetCrn(), bindTargetCrn);
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test14UpdateResourceBinding() {
        UpdateResourceBindingOptions options = new UpdateResourceBindingOptions.Builder()
            .id(testBindingGuid)
            .name(bindingNames.get("update"))
            .build();

        Response<ResourceBinding> response = service.updateResourceBinding(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test14-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceBinding result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testBindingCrn);
        assertEquals(result.getName(), bindingNames.get("update"));
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test15ListResourceBindingsWithNoFilter() {
        ListResourceBindingsOptions options = new ListResourceBindingsOptions.Builder().build();

        Response<ResourceBindingsList> response = service.listResourceBindings(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test15-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceBindingsList result = response.getResult();
        assertNotEquals(result.getResources().size(), 0);
        assertNotEquals(result.getRowsCount(), 0);
    }

    @Test
    public void test16ListResourceBindingsWithGuidFilter() {
        ListResourceBindingsOptions options = new ListResourceBindingsOptions.Builder()
            .guid(testBindingGuid)
            .build();

        Response<ResourceBindingsList> response = service.listResourceBindings(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test16-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceBindingsList result = response.getResult();
        assertEquals(result.getResources().size(), 1);
        assertEquals(result.getRowsCount(), Long.valueOf(1));

        ResourceBinding binding = result.getResources().get(0);
        assertEquals(binding.getId(), testBindingCrn);
        assertEquals(binding.getGuid(), testBindingGuid);
        assertEquals(binding.getName(), bindingNames.get("update"));
        assertEquals(binding.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(binding.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(binding.getSourceCrn(), testAliasCrn);
        assertEquals(binding.getTargetCrn(), bindTargetCrn);
        assertEquals(binding.getState(), "active");
    }

    @Test
    public void test17ListResourceBindingsWithNameFilter() {
        ListResourceBindingsOptions options = new ListResourceBindingsOptions.Builder()
            .name(bindingNames.get("name"))
            .build();

        Response<ResourceBindingsList> response = service.listResourceBindings(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test17-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceBindingsList result = response.getResult();
        assertEquals(result.getResources().size(), 0);
        assertEquals(result.getRowsCount(), Long.valueOf(0));
    }

    @Test
    public void test18CreateResoureKeyForInstance() {
        CreateResourceKeyOptions options = new CreateResourceKeyOptions.Builder()
            .name(keyNames.get("name"))
            .source(testInstanceGuid)
            .build();

        Response<ResourceKey> response = service.createResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test18-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getGuid());
        assertNotNull(result.getCrn());
        assertEquals(result.getId(), result.getCrn());
        assertEquals(result.getName(), keyNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getSourceCrn(), testInstanceCrn);
        assertEquals(result.getState(), "active");

        testInstanceKeyCrn = result.getId();
        testInstanceKeyGuid = result.getGuid();
    }

    @Test
    public void test19GetResourceKey() {
        GetResourceKeyOptions options = new GetResourceKeyOptions.Builder()
            .id(testInstanceKeyGuid)
            .build();

        Response<ResourceKey> response = service.getResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test19-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceKeyCrn);
        assertEquals(result.getGuid(), testInstanceKeyGuid);
        assertEquals(result.getCrn(), testInstanceKeyCrn);
        assertEquals(result.getName(), keyNames.get("name"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getSourceCrn(), testInstanceCrn);
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test20UpdateResourceKey() {
        UpdateResourceKeyOptions options = new UpdateResourceKeyOptions.Builder()
            .id(testInstanceKeyGuid)
            .name(keyNames.get("update"))
            .build();

        Response<ResourceKey> response = service.updateResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test20-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceKeyCrn);
        assertEquals(result.getName(), keyNames.get("update"));
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test21ListResourceKeysWithNoFilter() {
        ListResourceKeysOptions options = new ListResourceKeysOptions.Builder().build();

        Response<ResourceKeysList> response = service.listResourceKeys(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test21-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKeysList result = response.getResult();
        assertNotEquals(result.getResources().size(), 0);
        assertNotEquals(result.getRowsCount(), 0);
    }

    @Test
    public void test22ListResourceKeysWithGuidFilter() {
        ListResourceKeysOptions options = new ListResourceKeysOptions.Builder()
            .guid(testInstanceKeyGuid)
            .build();

        Response<ResourceKeysList> response = service.listResourceKeys(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test22-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKeysList result = response.getResult();
        assertEquals(result.getResources().size(), 1);
        assertEquals(result.getRowsCount(), Long.valueOf(1));

        ResourceKey key = result.getResources().get(0);
        assertEquals(key.getId(), testInstanceKeyCrn);
        assertEquals(key.getGuid(), testInstanceKeyGuid);
        assertEquals(key.getName(), keyNames.get("update"));
        assertEquals(key.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(key.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(key.getSourceCrn(), testInstanceCrn);
        assertEquals(key.getState(), "active");
    }

    @Test
    public void test23ListResourceKeysWithNameFilter() {
        ListResourceKeysOptions options = new ListResourceKeysOptions.Builder()
            .name(keyNames.get("name"))
            .build();

        Response<ResourceKeysList> response = service.listResourceKeys(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test23-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKeysList result = response.getResult();
        assertEquals(result.getResources().size(), 0);
        assertEquals(result.getRowsCount(), Long.valueOf(0));
    }

    @Test
    public void test24CreateResoureKeyForAlias() {
        CreateResourceKeyOptions options = new CreateResourceKeyOptions.Builder()
            .name(keyNames.get("name2"))
            .source(testAliasGuid)
            .build();

        Response<ResourceKey> response = service.createResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test24-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getGuid());
        assertNotNull(result.getCrn());
        assertEquals(result.getId(), result.getCrn());
        assertEquals(result.getName(), keyNames.get("name2"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getSourceCrn(), testAliasCrn);
        assertEquals(result.getState(), "active");

        testAliasKeyCrn = result.getId();
        testAliasKeyGuid = result.getGuid();
    }

    @Test
    public void test25GetResourceKey() {
        GetResourceKeyOptions options = new GetResourceKeyOptions.Builder()
            .id(testAliasKeyGuid)
            .build();

        Response<ResourceKey> response = service.getResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test25-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testAliasKeyCrn);
        assertEquals(result.getGuid(), testAliasKeyGuid);
        assertEquals(result.getCrn(), testAliasKeyCrn);
        assertEquals(result.getName(), keyNames.get("name2"));
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getSourceCrn(), testAliasCrn);
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test26UpdateResourceKey() {
        UpdateResourceKeyOptions options = new UpdateResourceKeyOptions.Builder()
            .id(testAliasKeyCrn)
            .name(keyNames.get("update2"))
            .build();

        Response<ResourceKey> response = service.updateResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test26-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testAliasKeyCrn);
        assertEquals(result.getName(), keyNames.get("update2"));
        assertEquals(result.getState(), "active");
    }

    @Test
    public void test27ListResourceKeysWithNoFilter() {
        ListResourceKeysOptions options = new ListResourceKeysOptions.Builder().build();

        Response<ResourceKeysList> response = service.listResourceKeys(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test27-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKeysList result = response.getResult();
        assertNotEquals(result.getResources().size(), 0);
        assertNotEquals(result.getRowsCount(), 0);
    }

    @Test
    public void test28ListResourceKeysWithGuidFilter() {
        ListResourceKeysOptions options = new ListResourceKeysOptions.Builder()
            .guid(testAliasKeyGuid)
            .build();

        Response<ResourceKeysList> response = service.listResourceKeys(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test28-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKeysList result = response.getResult();
        assertEquals(result.getResources().size(), 1);
        assertEquals(result.getRowsCount(), Long.valueOf(1));

        ResourceKey key = result.getResources().get(0);
        assertEquals(key.getId(), testAliasKeyCrn);
        assertEquals(key.getGuid(), testAliasKeyGuid);
        assertEquals(key.getName(), keyNames.get("update2"));
        assertEquals(key.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(key.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(key.getSourceCrn(), testAliasCrn);
        assertEquals(key.getState(), "active");
    }

    @Test
    public void test29ListResourceKeysWithNameFilter() {
        ListResourceKeysOptions options = new ListResourceKeysOptions.Builder()
            .name(keyNames.get("name2"))
            .build();

        Response<ResourceKeysList> response = service.listResourceKeys(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test29-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceKeysList result = response.getResult();
        assertEquals(result.getResources().size(), 0);
        assertEquals(result.getRowsCount(), Long.valueOf(0));
    }

    @Test
    public void test30DeleteResourceAliasWithDependenciesFail() {
        try {
            DeleteResourceAliasOptions options = new DeleteResourceAliasOptions.Builder()
                .id(testAliasGuid)
                .build();

            Response<Void> response = service.deleteResourceAlias(options)
                .addHeader("Transaction-Id", "rc-sdk-java-test30-" + transactionId)
                .execute();
        } catch (ServiceResponseException e) {
            assertNotNull(e);
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void test31DeleteResourceInstanceWithDependenciesFail() {
        try {
            DeleteResourceInstanceOptions options = new DeleteResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .build();

            Response<Void> response = service.deleteResourceInstance(options)
                .addHeader("Transaction-Id", "rc-sdk-java-test31-" + transactionId)
                .execute();
        } catch (ServiceResponseException e) {
            assertNotNull(e);
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void test32DeleteResourceBinding() {
        DeleteResourceBindingOptions options = new DeleteResourceBindingOptions.Builder()
                .id(testBindingGuid)
                .build();

        Response<Void> response = service.deleteResourceBinding(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test32-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void test33VerifyResourceBindingWasDeleted() {
        GetResourceBindingOptions options = new GetResourceBindingOptions.Builder()
                .id(testBindingGuid)
                .build();

        Response<ResourceBinding> response = service.getResourceBinding(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test33-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceBinding result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testBindingCrn);
        assertEquals(result.getState(), "removed");
    }

    @Test
    public void test34DeleteResourceKeys() {
        DeleteResourceKeyOptions options = new DeleteResourceKeyOptions.Builder()
                .id(testAliasKeyGuid)
                .build();

        Response<Void> response = service.deleteResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test34-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);

        DeleteResourceKeyOptions options2 = new DeleteResourceKeyOptions.Builder()
                .id(testInstanceKeyGuid)
                .build();

        Response<Void> response2 = service.deleteResourceKey(options2)
            .addHeader("Transaction-Id", "rc-sdk-java-test34-" + transactionId)
            .execute();
        assertNotNull(response2);
        assertEquals(response2.getStatusCode(), 204);
    }

    @Test
    public void test35VerifyResourceKeysWereDeleted() {
        GetResourceKeyOptions options = new GetResourceKeyOptions.Builder()
                .id(testAliasKeyGuid)
                .build();

        Response<ResourceKey> response = service.getResourceKey(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test35-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceKey result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testAliasKeyCrn);
        assertEquals(result.getState(), "removed");

        GetResourceKeyOptions options2 = new GetResourceKeyOptions.Builder()
                .id(testInstanceKeyGuid)
                .build();

        Response<ResourceKey> response2 = service.getResourceKey(options2)
            .addHeader("Transaction-Id", "rc-sdk-java-test35-" + transactionId)
            .execute();
        assertEquals(response2.getStatusCode(), 200);

        ResourceKey result2 = response2.getResult();
        assertNotNull(result2);
        assertEquals(result2.getId(), testInstanceKeyCrn);
        assertEquals(result2.getState(), "removed");
    }

    @Test
    public void test36DeleteResourceAlias() {
        DeleteResourceAliasOptions options = new DeleteResourceAliasOptions.Builder()
                .id(testAliasGuid)
                .build();

        Response<Void> response = service.deleteResourceAlias(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test36-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void test37VerifyResourceAliasWasDeleted() {
        GetResourceAliasOptions options = new GetResourceAliasOptions.Builder()
                .id(testAliasGuid)
                .build();

        Response<ResourceAlias> response = service.getResourceAlias(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test37-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceAlias result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testAliasCrn);
        assertEquals(result.getState(), "removed");
    }

    @Test
    public void test38LockResourceInstance() {
        LockResourceInstanceOptions options = new LockResourceInstanceOptions.Builder()
            .id(testInstanceGuid)
            .build();

        Response<ResourceInstance> response = service.lockResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test38-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceCrn);
        assertTrue(result.isLocked());
        assertEquals(result.getLastOperation().get("type").toString(), "lock");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    }

    @Test
    public void test39UpdateLockedResourceInstanceFail() {
        try {
            UpdateResourceInstanceOptions options = new UpdateResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .name(lockedInstanceNameUpdate)
                .build();

            Response<ResourceInstance> response = service.updateResourceInstance(options)
                .addHeader("Transaction-Id", "rc-sdk-java-test39-" + transactionId)
                .execute();
        } catch (ServiceResponseException e) {
            assertNotNull(e);
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void test40DeleteLockedResourceInstanceFail() {
        try {
            DeleteResourceInstanceOptions options = new DeleteResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .build();

            Response<Void> response = service.deleteResourceInstance(options)
                .addHeader("Transaction-Id", "rc-sdk-java-test40-" + transactionId)
                .execute();
        } catch (ServiceResponseException e) {
            assertNotNull(e);
            assertEquals(e.getStatusCode(), 400);
        }
    }

    @Test
    public void test41UnlockResourceInstance() {
        UnlockResourceInstanceOptions options = new UnlockResourceInstanceOptions.Builder()
            .id(testInstanceGuid)
            .build();

        Response<ResourceInstance> response = service.unlockResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test41-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceCrn);
        assertFalse(result.isLocked());
        assertEquals(result.getLastOperation().get("type").toString(), "unlock");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    }

    @Test
    public void test42DeleteResourceInstance() {
        DeleteResourceInstanceOptions options = new DeleteResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .build();

        Response<Void> response = service.deleteResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test42-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void test43VerifyResourceInstanceWasDeleted() {
        GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .build();

        Response<ResourceInstance> response = service.getResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test43-" + transactionId)
            .execute();
        assertEquals(response.getStatusCode(), 200);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testInstanceCrn);
        assertEquals(result.getState(), "removed");
        assertEquals(result.getLastOperation().get("type").toString(), "delete");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    }

    @Test
    public void test44CreateResoureInstanceForReclamationEnabledPlan() {
        CreateResourceInstanceOptions options = new CreateResourceInstanceOptions.Builder()
            .name(reclaimInstanceName)
            .target(TEST_REGION_ID2)
            .resourceGroup(TEST_RESOURCE_GROUP_ID)
            .resourcePlanId(TEST_PLAN_ID2)
            .build();

        Response<ResourceInstance> response = service.createResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test44-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        ResourceInstance result = response.getResult();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertNotNull(result.getGuid());
        assertNotNull(result.getCrn());
        assertEquals(result.getId(), result.getCrn());
        assertEquals(result.getName(), reclaimInstanceName);
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getResourcePlanId(), TEST_PLAN_ID2);
        assertEquals(result.getState(), "active");
        assertFalse(result.isLocked());
        assertEquals(result.getLastOperation().get("type").toString(), "create");
        assertFalse((Boolean) result.getLastOperation().get("async"));
        assertEquals(result.getLastOperation().get("state").toString(), "succeeded");

        testReclaimInstanceCrn = result.getId();
        testReclaimInstanceGuid = result.getGuid();
    }

    @Test
    public void test45ScheduleResourceInstanceForReclamation() {
        DeleteResourceInstanceOptions options = new DeleteResourceInstanceOptions.Builder()
            .id(testReclaimInstanceGuid)
            .build();

        Response<Void> response = service.deleteResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test45-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            log("Failed to wait for 20 seconds.");
        }
    }

    // Commented because redis timeouts cause intermittent failure

    // @Test
    // public void test46VerifyResourceInstanceIsPendingReclamation() {
    //     GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
    //         .id(testReclaimInstanceGuid)
    //         .build();

    //     Response<ResourceInstance> response = service.getResourceInstance(options)
    //         .addHeader("Transaction-Id", "rc-sdk-java-test46-" + transactionId)
    //         .execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);

    //     ResourceInstance result = response.getResult();
    //     assertNotNull(result);
    //     assertEquals(result.getId(), testReclaimInstanceCrn);
    //     assertEquals(result.getState(), "pending_reclamation");
    //     assertEquals(result.getLastOperation().get("type").toString(), "reclamation");
    //     assertEquals(result.getLastOperation().get("sub_type").toString(), "pending");
    //     assertFalse((Boolean) result.getLastOperation().get("async"));
    //     assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    // }

    @Test
    public void test47ListReclamationsForAccountId() {
        ListReclamationsOptions options = new ListReclamationsOptions.Builder()
            // .accountId(TEST_ACCOUNT_ID)
            .resourceInstanceId(testReclaimInstanceGuid) //checking reclamations with instance guid for more test reliability
            .build();

        Response<ReclamationsList> response = service.listReclamations(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test47-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ReclamationsList result = response.getResult();
        assertNotNull(result);
        assertNotEquals(result.getResources().size(), 0);

        Boolean foundReclamation = false;
        for (Reclamation r : result.getResources()) {
            if (r.getResourceInstanceId().equals(testReclaimInstanceGuid)) {
                assertEquals(r.getResourceInstanceId(), testReclaimInstanceGuid);
                assertEquals(r.getAccountId(), TEST_ACCOUNT_ID);
                assertEquals(r.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
                assertEquals(r.getState(), "SCHEDULED");

                foundReclamation = true;
                testReclamationId1 = r.getId();
            }
        }
        assertTrue(foundReclamation);
    }

    @Test
    public void test48RestoreResourceInstance() {
        RunReclamationActionOptions options = new RunReclamationActionOptions.Builder()
            .id(testReclamationId1)
            .actionName("restore")
            .build();

        Response<Reclamation> response = service.runReclamationAction(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test48-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Reclamation result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getResourceInstanceId(), testReclaimInstanceGuid);
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getState(), "RESTORING");

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            log("Failed to wait for 20 seconds.");
        }
    }

    // Commented because redis timeouts cause intermittent failure

    // @Test
    // public void test49VerifyResourceInstanceWasRestored() {
    //     GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
    //         .id(testReclaimInstanceGuid)
    //         .build();

    //     Response<ResourceInstance> response = service.getResourceInstance(options)
    //         .addHeader("Transaction-Id", "rc-sdk-java-test49-" + transactionId)
    //         .execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);

    //     ResourceInstance result = response.getResult();
    //     assertNotNull(result);
    //     assertEquals(result.getId(), testReclaimInstanceCrn);
    //     assertEquals(result.getState(), "active");
    //     assertEquals(result.getLastOperation().get("type").toString(), "reclamation");
    //     assertEquals(result.getLastOperation().get("sub_type").toString(), "restore");
    //     assertFalse((Boolean) result.getLastOperation().get("async"));
    //     assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    // }

    @Test
    public void test50ScheduleResourceInstanceForReclamation2() {
        DeleteResourceInstanceOptions options = new DeleteResourceInstanceOptions.Builder()
            .id(testReclaimInstanceGuid)
            .build();

        Response<Void> response = service.deleteResourceInstance(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test50-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            log("Failed to wait for 20 seconds.");
        }
    }

    @Test
    public void test51ListReclamationsForAccountIdAndResourceInstanceId() {
        ListReclamationsOptions options = new ListReclamationsOptions.Builder()
            .accountId(TEST_ACCOUNT_ID)
            .resourceInstanceId(testReclaimInstanceGuid)
            .build();

        Response<ReclamationsList> response = service.listReclamations(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test51-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ReclamationsList result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getResources().size(), 1);

        Reclamation reclamation = result.getResources().get(0);
        assertEquals(reclamation.getResourceInstanceId(), testReclaimInstanceGuid);
        assertEquals(reclamation.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(reclamation.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(reclamation.getState(), "SCHEDULED");
        testReclamationId2 = reclamation.getId();
    }

    @Test
    public void test52ReclaimResourceInstance() {
        RunReclamationActionOptions options = new RunReclamationActionOptions.Builder()
            .id(testReclamationId2)
            .actionName("reclaim")
            .build();

        Response<Reclamation> response = service.runReclamationAction(options)
            .addHeader("Transaction-Id", "rc-sdk-java-test52-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Reclamation result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getResourceInstanceId(), testReclaimInstanceGuid);
        assertEquals(result.getAccountId(), TEST_ACCOUNT_ID);
        assertEquals(result.getResourceGroupId(), TEST_RESOURCE_GROUP_ID);
        assertEquals(result.getState(), "RECLAIMING");

        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (Exception e) {
            log("Failed to wait for 20 seconds.");
        }
    }

    // Commented because redis timeouts cause intermittent failure

    // @Test
    // public void test53VerifyResourceInstanceWasReclaimed() {
    //     GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
    //             .id(testReclaimInstanceGuid)
    //             .build();

    //     Response<ResourceInstance> response = service.getResourceInstance(options)
    //         .addHeader("Transaction-Id", "rc-sdk-java-test53-" + transactionId)
    //         .execute();
    //     assertNotNull(response);
    //     assertEquals(response.getStatusCode(), 200);

    //     ResourceInstance result = response.getResult();
    //     assertNotNull(result);
    //     assertEquals(result.getId(), testReclaimInstanceCrn);
    //     assertEquals(result.getState(), "removed");
    //     assertEquals(result.getLastOperation().get("type").toString(), "reclamation");
    //     assertEquals(result.getLastOperation().get("sub_type").toString(), "delete");
    //     assertFalse((Boolean) result.getLastOperation().get("async"));
    //     assertEquals(result.getLastOperation().get("state").toString(), "succeeded");
    // }

    public void cleanupResources() {
        if (testInstanceKeyGuid != null) {
            try {
                DeleteResourceKeyOptions options = new DeleteResourceKeyOptions.Builder()
                    .id(testInstanceKeyGuid)
                    .build();

                service.deleteResourceKey(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

                log("Successful cleanup of key " + testInstanceKeyGuid);
            } catch (ServiceResponseException e) {
                if (e.getStatusCode() == 410) {
                    log("Key " + testInstanceKeyGuid + " was already deleted by tests.");
                } else {
                    log("Failed to cleanup key " + testInstanceKeyGuid + ". Error: " + e.getMessage());
                }
            }
        } else {
            log("Key for instance was not created. No cleanup needed.");
        }

        if (testAliasKeyGuid != null) {
            try {
                DeleteResourceKeyOptions options = new DeleteResourceKeyOptions.Builder()
                    .id(testAliasKeyGuid)
                    .build();

                service.deleteResourceKey(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

                log("Successful cleanup of key " + testAliasKeyGuid);
            } catch (ServiceResponseException e) {
                if (e.getStatusCode() == 410) {
                    log("Key " + testAliasKeyGuid + " was already deleted by tests.");
                } else {
                    log("Failed to cleanup key " + testAliasKeyGuid + ". Error: " + e.getMessage());
                }
            }
        } else {
            log("Key for alias was not created. No cleanup needed.");
        }

        if (testBindingGuid != null) {
            try {
                DeleteResourceBindingOptions options = new DeleteResourceBindingOptions.Builder()
                    .id(testBindingGuid)
                    .build();

                service.deleteResourceBinding(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

                log("Successful cleanup of binding " + testBindingGuid);
            } catch (ServiceResponseException e) {
                if (e.getStatusCode() == 410) {
                    log("Binding " + testBindingGuid + " was already deleted by tests.");
                } else {
                    log("Failed to cleanup binding " + testBindingGuid + ". Error: " + e.getMessage());
                }
            }
        } else {
            log("Binding was not created. No cleanup needed.");
        }

        if (testAliasGuid != null) {
            try {
                DeleteResourceAliasOptions options = new DeleteResourceAliasOptions.Builder()
                    .id(testAliasGuid)
                    .build();

                service.deleteResourceAlias(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

                log("Successful cleanup of alias " + testAliasGuid);
            } catch (ServiceResponseException e) {
                if (e.getStatusCode() == 410) {
                    log("Alias " + testAliasGuid + " was already deleted by tests.");
                } else {
                    log("Failed to cleanup alias " + testAliasGuid + ". Error: " + e.getMessage());
                }
            }
        } else {
            log("Alias was not created. No cleanup needed.");
        }

        if (testInstanceGuid != null) {
            cleanupInstance();
        } else {
            log("Instance was not created. No cleanup needed.");
        }
    }

    public void cleanupInstance() {
        ResourceInstance instance = null;
        try {
            GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .build();

            Response<ResourceInstance> response = service.getResourceInstance(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

            instance = response.getResult();
        } catch (ServiceResponseException e) {
            log("Failed to retrieve instance " + testInstanceGuid + "for cleanup. Error: " + e.getMessage());
        }

        if (instance != null && instance.getState().equals("active") && instance.isLocked()) {
            try {
                UnlockResourceInstanceOptions options = new UnlockResourceInstanceOptions.Builder()
                    .id(testInstanceGuid)
                    .build();

                service.unlockResourceInstance(options)
                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                    .execute();

                log("Successfully unlocked instance " + testInstanceGuid);
            } catch (ServiceResponseException e) {
                log("Failed to unlock instance " + testInstanceGuid + "for cleanup. Error: " + e.getMessage());
            }
        }

        try {
            DeleteResourceInstanceOptions options = new DeleteResourceInstanceOptions.Builder()
                .id(testInstanceGuid)
                .build();

            service.deleteResourceInstance(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

            log("Successfully cleaned up instance " + testInstanceGuid);
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() == 410) {
                log("Instance " + testInstanceGuid + " was already deleted by tests.");
            } else {
                log("Failed to cleanup instance " + testInstanceGuid + ". Error: " + e.getMessage());
            }
        }
    }

    public void cleanupReclamationInstance() {
        try {
            GetResourceInstanceOptions options = new GetResourceInstanceOptions.Builder()
                .id(testReclaimInstanceGuid)
                .build();

            Response<ResourceInstance> response = service.getResourceInstance(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

            ResourceInstance instance = response.getResult();
            if (instance.getState().equals("removed")) {
                log("Instance " + testReclaimInstanceGuid + " was already reclaimed by tests.");
            } else if (instance.getState().equals("pending_reclamation")) {
                cleanupInstancePendingReclamation();
            } else {
                DeleteResourceInstanceOptions options2 = new DeleteResourceInstanceOptions.Builder()
                    .id(testReclaimInstanceGuid)
                    .build();

                service.deleteResourceInstance(options2)
                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                    .execute();

                log("Successfully scheduled instance " + testReclaimInstanceGuid + " for reclamation.");

                try {
                    TimeUnit.SECONDS.sleep(20);
                } catch (Exception e) {
                    log("Failed to wait for 20 seconds.");
                }

                cleanupInstancePendingReclamation();
            }
        } catch (ServiceResponseException e) {
            log("Failed to reclaim instance " + testReclaimInstanceGuid + ". Error: " + e.getMessage());
        }
    }

    public void cleanupInstancePendingReclamation() {
        try {
            ListReclamationsOptions options = new ListReclamationsOptions.Builder()
                .accountId(TEST_ACCOUNT_ID)
                .resourceInstanceId(testReclaimInstanceGuid)
                .build();

            Response<ReclamationsList> response = service.listReclamations(options)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

            ReclamationsList reclamationList = response.getResult();
            if (reclamationList.getResources().size() == 0) {
                log("No reclamations for instance " + testReclaimInstanceGuid + " were returned.");
                return;
            }

            String reclamationId = reclamationList.getResources().get(0).getId();
            RunReclamationActionOptions options2 = new RunReclamationActionOptions.Builder()
                .id(reclamationId)
                .actionName("reclaim")
                .build();

            service.runReclamationAction(options2)
                .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                .execute();

                log("Successfully reclaimed instance " + testReclaimInstanceGuid);
        } catch (ServiceResponseException e) {
            log("Failed to reclaim instance " + testReclaimInstanceGuid + ". Error: " + e.getMessage());
        }
    }

    public void cleanupByName(){
        //Resource Key
        for (String name : keyNames.values()){
            try {
                ListResourceKeysOptions listKeyOptions = new ListResourceKeysOptions.Builder()
                    .name(name)
                    .build();

                Response<ResourceKeysList> response = service.listResourceKeys(listKeyOptions)
                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                    .execute();
                ResourceKeysList result = response.getResult();
                List<ResourceKey> resources = result.getResources();
                if (resources.size() > 0){
                    for (ResourceKey res : resources){
                        String keyGuid = res.getGuid();
                        try {
                            DeleteResourceKeyOptions deleteKeyOptions = new DeleteResourceKeyOptions.Builder()
                                .id(keyGuid)
                                .build();

                            service.deleteResourceKey(deleteKeyOptions)
                            .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                            .execute();

                            log("Successful cleanup of key " + keyGuid);
                        } catch (ServiceResponseException e) {
                            if (e.getStatusCode() == 410) {
                                log("Key " + keyGuid + " was already deleted by tests.");
                            } else {
                                log("Failed to cleanup key " + keyGuid + ". Error: " + e.getMessage());
                            }
                        }
                    }
                } else {
                    log("No keys found for name " + name);
                }
            } catch (ServiceResponseException e) {
                log("Failed to retrieve key with name " + name + "for cleanup. Error: " + e.getMessage());
            }
        }

        //Resource Instance
        for (String name : instanceNames.values()){
            try {
                ListResourceInstancesOptions listInstanceOptions = new ListResourceInstancesOptions.Builder()
                    .name(name)
                    .build();

                Response<ResourceInstancesList> response = service.listResourceInstances(listInstanceOptions)
                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                    .execute();
                ResourceInstancesList result = response.getResult();
                List<ResourceInstance> resources = result.getResources();
                if (resources.size() > 0){
                    for (ResourceInstance res : resources){
                        String instanceGuid = res.getGuid();

                        //unlock if its locked
                        if (res.getState().equals("active") && res.isLocked()) {
                            try {
                                UnlockResourceInstanceOptions options = new UnlockResourceInstanceOptions.Builder()
                                    .id(instanceGuid)
                                    .build();

                                service.unlockResourceInstance(options)
                                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                                    .execute();

                                log("Successfully unlocked instance " + instanceGuid);
                            } catch (ServiceResponseException e) {
                                log("Failed to unlock instance " + instanceGuid + "for cleanup. Error: " + e.getMessage());
                            }
                        }

                        try {
                            DeleteResourceInstanceOptions deleteInstanceOptions = new DeleteResourceInstanceOptions.Builder()
                                .id(instanceGuid)
                                .build();

                            service.deleteResourceInstance(deleteInstanceOptions)
                            .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                            .execute();

                            log("Successful cleanup of instance " + instanceGuid);
                        } catch (ServiceResponseException e) {
                            if (e.getStatusCode() == 410) {
                                log("Instance " + instanceGuid + " was already deleted by tests.");
                            } else {
                                log("Failed to cleanup instance " + instanceGuid + ". Error: " + e.getMessage());
                            }
                        }
                    }
                } else {
                    log("No instances found for name " + name);
                }
            } catch (ServiceResponseException e) {
                log("Failed to retrieve instance with name " + name + "for cleanup. Error: " + e.getMessage());
            }

        }

        //Resource Binding
        for (String name : bindingNames.values()){
            try {
                ListResourceBindingsOptions listBindingOptions = new ListResourceBindingsOptions.Builder()
                    .name(name)
                    .build();

                Response<ResourceBindingsList> response = service.listResourceBindings(listBindingOptions)
                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                    .execute();
                ResourceBindingsList result = response.getResult();
                List<ResourceBinding> resources = result.getResources();
                if (resources.size() > 0){
                    for (ResourceBinding res : resources){
                        String bindingGuid = res.getGuid();
                        try {
                            DeleteResourceBindingOptions deleteBindingOptions = new DeleteResourceBindingOptions.Builder()
                                .id(bindingGuid)
                                .build();

                            service.deleteResourceBinding(deleteBindingOptions)
                            .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                            .execute();

                            log("Successful cleanup of binding " + bindingGuid);
                        } catch (ServiceResponseException e) {
                            if (e.getStatusCode() == 410) {
                                log("Binding " + bindingGuid + " was already deleted by tests.");
                            } else {
                                log("Failed to cleanup binding " + bindingGuid + ". Error: " + e.getMessage());
                            }
                        }
                    }
                } else {
                    log("No bindings found for name " + name);
                }
            } catch (ServiceResponseException e) {
                log("Failed to retrieve Bindings with name " + name + "for cleanup. Error: " + e.getMessage());
            }

        }

        //Resource Alias
        for (String name : aliasNames.values()){
            try {
                ListResourceAliasesOptions listAliasOptions = new ListResourceAliasesOptions.Builder()
                    .name(name)
                    .build();

                Response<ResourceAliasesList> response = service.listResourceAliases(listAliasOptions)
                    .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                    .execute();
                ResourceAliasesList result = response.getResult();
                List<ResourceAlias> resources = result.getResources();
                if (resources.size() > 0){
                    for (ResourceAlias res : resources){
                        String aliasGuid = res.getGuid();
                        try {
                            DeleteResourceAliasOptions deleteAliasOptions = new DeleteResourceAliasOptions.Builder()
                                .id(aliasGuid)
                                .build();

                            service.deleteResourceAlias(deleteAliasOptions)
                            .addHeader("Transaction-Id", "rc-sdk-java-cleanup-" + transactionId)
                            .execute();

                            log("Successful cleanup of alias " + aliasGuid);
                        } catch (ServiceResponseException e) {
                            if (e.getStatusCode() == 410) {
                                log("Alias " + aliasGuid + " was already deleted by tests.");
                            } else {
                                log("Failed to cleanup alias " + aliasGuid + ". Error: " + e.getMessage());
                            }
                        }
                    }
                } else {
                    log("No alias found for name " + name);
                }
            } catch (ServiceResponseException e) {
                log("Failed to retrieve alias with name " + name + "for cleanup. Error: " + e.getMessage());
            }

        }
    }
}

