/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Address;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutAccountSettings;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutRule;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutRulePage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZonePage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetPage;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Integration test class for the ContextBasedRestrictions service.
 */
public class ContextBasedRestrictionsIT extends SdkIntegrationTestBase {
    public static Map<String, String> config = null;
    public ContextBasedRestrictions service = null;
    private final String NonExistentID = "1234567890abcdef1234567890abcdef";
    private final String InvalidID = "this_is_an_invalid_id";

    private String serviceURL;
    private String testAccountID;
    private String testServiceName;
    private String zoneID;
    private String zoneRev;
    private String ruleID;
    private String ruleRev;

    /**
     * This method provides our config filename to the base class.
     */

    public String getConfigFilename() {
        return "../../context_based_restrictions_v1.env";
    }

    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = ContextBasedRestrictions.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(ContextBasedRestrictions.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        serviceURL = config.get("URL");
        testAccountID = config.get("TEST_ACCOUNT_ID");
        testServiceName = config.get("TEST_SERVICE_NAME");

        System.out.printf("\nService URL: %s\n", serviceURL);
        System.out.printf("Test Account ID: %s\n", testAccountID);
        System.out.printf("Test Service Name: %s\n", testServiceName);
        System.out.println("Setup complete.");
    }

    @Test(groups = "createZone")
    public void testCreateZone() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234")
                    .build();

            CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
                    .name("SDK TEST - an example of zone")
                    .accountId(testAccountID)
                    .description("SDK TEST - this is an example of zone")
                    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.createZone(createZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            OutZone outZoneResult = response.getResult();

            assertNotNull(outZoneResult);
            this.zoneID = outZoneResult.getId();
            this.zoneRev = response.getHeaders().values("Etag").get(0);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "createZone", dependsOnMethods = "testCreateZone")
    public void testCreateZoneDuplicatedName() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234")
                    .build();

            CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
                    .name("SDK TEST - an example of zone")
                    .accountId(testAccountID)
                    .description("SDK TEST - this is an example of zone")
                    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.createZone(createZoneOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 409)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "createZone", dependsOnMethods = "testCreateZone")
    public void testCreateZoneInvalidIP() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234.")
                    .build();

            CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
                    .name("SDK TEST - an example of zone")
                    .accountId(testAccountID)
                    .description("SDK TEST - this is an example of zone")
                    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.createZone(createZoneOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "listZones", dependsOnGroups = "createZone")
    public void testListZones() throws Exception {
        try {
            ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
                    .accountId(testAccountID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZonePage> response = service.listZones(listZonesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutZonePage outZonePageResult = response.getResult();

            assertNotNull(outZonePageResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }


    @Test(groups = "listZones", dependsOnMethods = "testListZones")
    public void testListZonesInvalidAccountID() throws Exception {
        try {
            ListZonesOptions listZonesOptions = new ListZonesOptions.Builder()
                    .accountId(InvalidID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZonePage> response = service.listZones(listZonesOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "getZone", dependsOnGroups = "listZones")
    public void testGetZone() throws Exception {
        try {
            GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
                    .zoneId(zoneID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.getZone(getZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutZone outZoneResult = response.getResult();

            assertNotNull(outZoneResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "getZone", dependsOnMethods = "testGetZone")
    public void testGetZoneNotFound() throws Exception {
        try {
            GetZoneOptions getZoneOptions = new GetZoneOptions.Builder()
                    .zoneId(NonExistentID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.getZone(getZoneOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "replaceZone", dependsOnGroups = "getZone")
    public void testReplaceZone() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234")
                    .build();

            ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
                    .zoneId(zoneID)
                    .ifMatch(zoneRev)
                    .name("SDK TEST - an example of updated zone")
                    .accountId(testAccountID)
                    .description("SDK TEST - this is an example of updated zone")
                    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.replaceZone(replaceZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutZone outZoneResult = response.getResult();

            assertNotNull(outZoneResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }


    @Test(groups = "replaceZone", dependsOnMethods = "testReplaceZone")
    public void testReplaceZoneNotFound() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234")
                    .build();

            ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
                    .zoneId(NonExistentID)
                    .ifMatch("abc")
                    .name("SDK TEST - an example of zone")
                    .accountId(testAccountID)
                    .description("SDK TEST - this is an example of zone")
                    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.replaceZone(replaceZoneOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "replaceZone", dependsOnMethods = "testReplaceZone")
    public void testReplaceZoneInvalidIfMatch() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234")
                    .build();

            ReplaceZoneOptions replaceZoneOptions = new ReplaceZoneOptions.Builder()
                    .zoneId(zoneID)
                    .ifMatch("abc")
                    .name("SDK TEST - an example of zone")
                    .accountId(testAccountID)
                    .description("SDK TEST - this is an example of zone")
                    .addresses(new java.util.ArrayList<Address>(java.util.Arrays.asList(addressModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutZone> response = service.replaceZone(replaceZoneOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 412)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "serviceRef", dependsOnGroups = "replaceZone")
    public void testListAvailableServicerefTargets() throws Exception {
        try {
            ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions = new ListAvailableServicerefTargetsOptions.Builder()
                    .type("all")
                    .build();

            // Invoke operation
            Response<ServiceRefTargetPage> response = service.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceRefTargetPage serviceRefTargetPageResult = response.getResult();

            assertNotNull(serviceRefTargetPageResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "serviceRef", dependsOnMethods = "testListAvailableServicerefTargets")
    public void testListAvailableServicerefTargetsInvalidType() throws Exception {
        try {
            ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions = new ListAvailableServicerefTargetsOptions.Builder()
                    .type("invalid-type")
                    .build();

            // Invoke operation
            Response<ServiceRefTargetPage> response = service.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "createRule", dependsOnGroups = "serviceRef")
    public void testCreateRule() throws Exception {
        try {
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                    .name("networkZoneId")
                    .value(zoneID)
                    .build();

            RuleContext ruleContextModel = new RuleContext.Builder()
                    .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
                    .build();

            ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
                    .name("accountId")
                    .value(testAccountID)
                    .build();

            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                    .name("serviceName")
                    .value(testServiceName)
                    .build();

            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                    .name("tagName")
                    .value("tagValue")
                    .build();

            Resource resourceModel = new Resource.Builder()
                    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountID, resourceAttributeModelServiceName)))
                    .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
                    .build();

            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                    .description("SDK TEST - this is an example of rule")
                    .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
                    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRule> response = service.createRule(createRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            OutRule outRuleResult = response.getResult();

            assertNotNull(outRuleResult);

            this.ruleID = outRuleResult.getId();
            this.ruleRev = response.getHeaders().values("Etag").get(0);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "createRule", dependsOnMethods = "testCreateRule")
    public void testCreateRuleNotCBREnabled() throws Exception {
        try {
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                    .name("networkZoneId")
                    .value(zoneID)
                    .build();

            RuleContext ruleContextModel = new RuleContext.Builder()
                    .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
                    .build();

            ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
                    .name("accountId")
                    .value(testAccountID)
                    .build();

            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                    .name("serviceName")
                    .value("cbr-not-enabled")
                    .build();

            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                    .name("tagName")
                    .value("tagValue")
                    .build();

            Resource resourceModel = new Resource.Builder()
                    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountID, resourceAttributeModelServiceName)))
                    .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
                    .build();

            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                    .description("SDK TEST - this is an example of rule")
                    .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
                    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRule> response = service.createRule(createRuleOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "listRules", dependsOnGroups = "createRule")
    public void testListRules() throws Exception {
        try {
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                    .accountId(testAccountID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRulePage> response = service.listRules(listRulesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutRulePage outRulePageResult = response.getResult();

            assertNotNull(outRulePageResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }


    @Test(groups = "listRules", dependsOnMethods = "testListRules")
    public void testListRulesInvalidAccountID() throws Exception {
        try {
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                    .accountId(InvalidID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRulePage> response = service.listRules(listRulesOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "getRule", dependsOnGroups = "listRules")
    public void testGetRule() throws Exception {
        try {
            GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
                    .ruleId(ruleID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRule> response = service.getRule(getRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutRule outRuleResult = response.getResult();

            assertNotNull(outRuleResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }


    @Test(groups = "getRule", dependsOnMethods = "testGetRule")
    public void testGetRuleNotFound() throws Exception {
        try {
            GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
                    .ruleId(NonExistentID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRule> response = service.getRule(getRuleOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "replaceRule", dependsOnGroups = "getRule")
    public void testReplaceRule() throws Exception {
        try {
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                    .name("networkZoneId")
                    .value(zoneID)
                    .build();

            RuleContext ruleContextModel = new RuleContext.Builder()
                    .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
                    .build();

            ResourceAttribute resourceAttributeModelAccountName = new ResourceAttribute.Builder()
                    .name("accountId")
                    .value(testAccountID)
                    .build();

            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                    .name("serviceName")
                    .value(testServiceName)
                    .build();

            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                    .name("tagName")
                    .value("updatedTagValue")
                    .build();

            Resource resourceModel = new Resource.Builder()
                    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountName, resourceAttributeModelServiceName)))
                    .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
                    .build();

            ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
                    .ruleId(ruleID)
                    .ifMatch(ruleRev)
                    .description("SDK TEST - this is an example of updated rule")
                    .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
                    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRule> response = service.replaceRule(replaceRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutRule outRuleResult = response.getResult();

            assertNotNull(outRuleResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "replaceRule", dependsOnMethods = "testReplaceRule")
    public void testReplaceRuleNotFound() throws Exception {
        try {
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                    .name("networkZoneId")
                    .value(zoneID)
                    .build();

            RuleContext ruleContextModel = new RuleContext.Builder()
                    .attributes(new java.util.ArrayList<RuleContextAttribute>(java.util.Arrays.asList(ruleContextAttributeModel)))
                    .build();

            ResourceAttribute resourceAttributeModelAccountName = new ResourceAttribute.Builder()
                    .name("accountId")
                    .value(testAccountID)
                    .build();

            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                    .name("serviceName")
                    .value("cbr-not-enabled")
                    .build();

            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                    .name("tagName")
                    .value("updatedTagValue")
                    .build();

            Resource resourceModel = new Resource.Builder()
                    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModelAccountName, resourceAttributeModelServiceName)))
                    .tags(new java.util.ArrayList<ResourceTagAttribute>(java.util.Arrays.asList(resourceTagAttributeModel)))
                    .build();

            ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
                    .ruleId(NonExistentID)
                    .ifMatch("abc")
                    .description("SDK TEST - this is an example of rule")
                    .contexts(new java.util.ArrayList<RuleContext>(java.util.Arrays.asList(ruleContextModel)))
                    .resources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutRule> response = service.replaceRule(replaceRuleOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "accountSettings", dependsOnGroups = "replaceRule")
    public void testGetAccountSettings() throws Exception {
        try {
            GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
                    .accountId(testAccountID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutAccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OutAccountSettings outAccountSettingsResult = response.getResult();

            assertNotNull(outAccountSettingsResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "accountSettings", dependsOnMethods = "testGetAccountSettings")
    public void testGetAccountSettingsInvalidAccountID() throws Exception {
        try {
            GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
                    .accountId(InvalidID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OutAccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "deleteRule", dependsOnGroups = "accountSettings")
    public void testDeleteRule() throws Exception {
        try {
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
            ruleID = null;
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }


    @Test(groups = "deleteRule", dependsOnMethods = "testDeleteRule")
    public void testDeleteRuleNotFound() throws Exception {
        try {
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(NonExistentID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "deleteZone", dependsOnGroups = "deleteRule")
    public void testDeleteZone() throws Exception {
        try {
            DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
                    .zoneId(zoneID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteZone(deleteZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);
            zoneID = null;
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "deleteZone", dependsOnMethods = "testDeleteZone")
    public void testDeleteZoneNotFound() throws Exception {
        try {
            DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
                    .zoneId(NonExistentID)
                    .transactionId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Void> response = service.deleteZone(deleteZoneOptions).execute();
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    public String getTransactionID() {
        return "sdk-test-" + UUID.randomUUID();
    }

    @AfterClass
    public void tearDown() {
        // Add any clean up logic here
        if (ruleID != null) {
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleID)
                    .transactionId(getTransactionID())
                    .build();

            service.deleteRule(deleteRuleOptions).execute();
            System.out.println("Cleaned Rule ID.");
        }

        if (zoneID != null) {
            DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
                    .zoneId(zoneID)
                    .transactionId(getTransactionID())
                    .build();

            service.deleteZone(deleteZoneOptions).execute();
            System.out.println("Cleaned Zone ID.");
        }

        System.out.println("Clean up complete.");
    }
}
