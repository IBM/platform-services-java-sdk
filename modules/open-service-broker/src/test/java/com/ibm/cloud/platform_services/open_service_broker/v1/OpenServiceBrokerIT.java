package com.ibm.cloud.platform_services.open_service_broker.v1;

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

import com.ibm.cloud.platform_services.open_service_broker.v1.model.*;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * Integration test class for the IamAccessGroups service.
 */
public class OpenServiceBrokerIT extends SdkIntegrationTestBase {
    
    private static final String TEST_ACCOUNT_ID = "bc2b2fca0af84354a916dc1de6eee42e";
    private static final String TEST_RESOURCE_GROUP_ID = "13aa3ee48c3b44ddb64c05c79f7ab8ef";
    private static final String TEST_ORG_ID = "d35d4f0e-5076-4c89-9361-2522894b6548";
    private static final String TEST_SPACE_ID = "336ba5f3-f185-488e-ac8d-02195eebb2f3";
    private static final String TEST_APP_ID = "bf692181-1f0e-46be-9faf-eb0857f4d1d5";
    private static final String TEST_PLAN_ID1 = "a10e4820-3685-11e9-b210-d663bd873d93";
    private static final String TEST_PLAN_ID2 = "a10e4410-3685-11e9-b210-d663bd873d933";
    private static final String TEST_INSTANCE_ID = "crn:v1:staging:public:bss-monitor:global:a/bc2b2fca0af84354a916dc1de6eee42e:sdkTestInstance::";
    private static final String TEST_BINDING_ID = "crn:v1:staging:public:bss-monitor:us-south:a/bc2b2fca0af84354a916dc1de6eee42e:sdkTestInstance:resource-binding:sdkTestBinding";
    private static final String TEST_INSTANCE_ID_ESCAPED = "crn%3Av1%3Astaging%3Apublic%3Abss-monitor%3Aglobal%3Aa%2Fbc2b2fca0af84354a916dc1de6eee42e%3AsdkTestInstance%3A%3A";
    private static final String TEST_BINDING_ID_ESCAPED = "crn%3Av1%3Astaging%3Apublic%3Abss-monitor%3Aus-south%3Aa%2Fbc2b2fca0af84354a916dc1de6eee42e%3AsdkTestInstance%3Aresource-binding%3AsdkTestBinding";
    private static final String TEST_DASHBOARD_URL = "http://www.example.com/crn%3Av1%3Astaging%3Apublic%3Abss-monitor%3Aglobal%3Aa%2Fbc2b2fca0af84354a916dc1de6eee42e%3AsdkTestInstance%3A%3A";
    private static final String TEST_SERVICE_ID  = "a10e46ae-3685-11e9-b210-d663bd873d93";
    private static final String TEST_REASON_CODE = "test_reason";
    private static final String TEST_INITIATOR_ID = "test_initiator";

    OpenServiceBroker service = null;
    String transactionId = null;

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../open_service_broker.env";
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

        // Construct the service instance from our external configuration.
        service = OpenServiceBroker.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        transactionId = UUID.randomUUID().toString();
        System.out.println("Transaction-Id for Test Run: " + transactionId);
    }

    @Test
    public void test00CreateServiceInstance() {
        Context contextReq = new Context.Builder()
            .accountId(TEST_ACCOUNT_ID)
            .crn(TEST_INSTANCE_ID)
            .platform("ibmcloud")
            .build();

        Map<String, String> param = new HashMap<String, String>();
        param.put("hello", "bye");

        ReplaceServiceInstanceOptions options = new ReplaceServiceInstanceOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .planId(TEST_PLAN_ID1)
            .serviceId(TEST_SERVICE_ID)
            .organizationGuid(TEST_ORG_ID)
            .spaceGuid(TEST_SPACE_ID)
            .context(contextReq)
            .parameters(param)
            .acceptsIncomplete(true)
            .build();

        Response<Resp2079872Root> response = service.replaceServiceInstance(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test00-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        Resp2079872Root result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getDashboardUrl(), TEST_DASHBOARD_URL);
    }

    @Test
    public void test01UpdateServiceInstance() {
        Context contextReq = new Context.Builder()
            .accountId(TEST_ACCOUNT_ID)
            .crn(TEST_INSTANCE_ID)
            .platform("cf")
            .build();

        Map<String, String> param = new HashMap<String, String>();
        param.put("hello", "hi");

        Map<String, String> previousValues = new HashMap<String, String>();
        previousValues.put("plan_id", TEST_PLAN_ID1);

        UpdateServiceInstanceOptions options = new UpdateServiceInstanceOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .planId(TEST_PLAN_ID2)
            .serviceId(TEST_SERVICE_ID)
            .context(contextReq)
            .parameters(param)
            .previousValues(previousValues)
            .acceptsIncomplete(true)
            .build();

        Response<Resp2079874Root> response = service.updateServiceInstance(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test01-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Resp2079874Root result = response.getResult();
        assertNotNull(result);
    }

    @Test
    public void test02DisableServiceInstanceState() {
        ReplaceServiceInstanceStateOptions options = new ReplaceServiceInstanceStateOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .enabled(false)
            .initiatorId(TEST_INITIATOR_ID)
            .reasonCode(TEST_REASON_CODE)
            .build();

        Response<Resp2448145Root> response = service.replaceServiceInstanceState(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test02-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Resp2448145Root result = response.getResult();
        assertNotNull(result);
    }

     @Test
    public void test03EnableServiceInstanceState() {
        ReplaceServiceInstanceStateOptions options = new ReplaceServiceInstanceStateOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .enabled(true)
            .initiatorId(TEST_INITIATOR_ID)
            .reasonCode(TEST_REASON_CODE)
            .build();

        Response<Resp2448145Root> response = service.replaceServiceInstanceState(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test03-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Resp2448145Root result = response.getResult();
        assertNotNull(result);
    }

    @Test
    public void test04BindServiceInstance() {
        Map<String, String> param = new HashMap<String, String>();
        param.put("hello", "bye");

        BindResource bindRes = new BindResource.Builder()
            .accountId(TEST_ACCOUNT_ID)
            .serviceidCrn(TEST_APP_ID)
            .build();

        ReplaceServiceBindingOptions options = new ReplaceServiceBindingOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .bindingId(TEST_BINDING_ID_ESCAPED)
            .planId(TEST_PLAN_ID2)
            .serviceId(TEST_SERVICE_ID)
            .parameters(param)
            .bindResource(bindRes)
            .build();

        Response<Resp2079876Root> response = service.replaceServiceBinding(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test04-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        Resp2079876Root result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getCredentials().get("credField"), "credValue");
    }

    @Test
    public void test05GetServiceInstanceState() {
        GetServiceInstanceStateOptions options = new GetServiceInstanceStateOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .build();

        Response<Resp1874644Root> response = service.getServiceInstanceState(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test05-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Resp1874644Root result = response.getResult();
        assertNotNull(result);
    }

    @Test
    public void test06GetCatalogMetadata() {
        ListCatalogOptions options = new ListCatalogOptions();

        Response<Resp1874650Root> response = service.listCatalog(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test06-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Resp1874650Root result = response.getResult();
        assertNotNull(result);

        List<Services> services = result.getServices();
        assertEquals(services.size(), 1);
        assertEquals(services.get(0).getId(), TEST_SERVICE_ID);
        assertEquals(services.get(0).getName(), "bss-monitor");
        assertTrue(services.get(0).isBindable());
        assertTrue(services.get(0).isPlanUpdateable());
    }

    @Test
    public void test07DeleteServiceBinding() {
        DeleteServiceBindingOptions options = new DeleteServiceBindingOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .bindingId(TEST_BINDING_ID_ESCAPED)
            .planId(TEST_PLAN_ID2)
            .serviceId(TEST_SERVICE_ID)
            .build();

        Response<Void> response = service.deleteServiceBinding(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test07-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test08DeleteServiceInstance() {
        DeleteServiceInstanceOptions options = new DeleteServiceInstanceOptions.Builder()
            .instanceId(TEST_INSTANCE_ID_ESCAPED)
            .planId(TEST_PLAN_ID2)
            .serviceId(TEST_SERVICE_ID)
            .acceptsIncomplete(true)
            .build();

        Response<Resp2079874Root> response = service.deleteServiceInstance(options)
            .addHeader("Transaction-Id", "osb-sdk-java-test08-" + transactionId)
            .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Resp2079874Root result = response.getResult();
        assertNotNull(result);
    }
}

