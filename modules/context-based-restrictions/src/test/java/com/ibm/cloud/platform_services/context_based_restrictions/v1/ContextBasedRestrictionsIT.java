/*
 * (C) Copyright IBM Corp. 2026.
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

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.APIType;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressIPAddress;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.AddressServiceRef;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneAssignmentOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneAssignmentOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.EnterpriseTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneAssignmentOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.PatchZoneAssignmentOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServiceOperationsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetServicerefTargetOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZoneAssignmentsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.NewRuleOperations;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.NewRuleOperationsApiTypesItem;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OperationsList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Resource;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Rule;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContext;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleContextAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.RuleList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTarget;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefValue;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.Zone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignment;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentBulkOutput;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentSummary;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneAssignmentZoneSpec;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ZoneList;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.RetryRunner;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.util.List;
import java.util.Map;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Integration test class for the ContextBasedRestrictions service.
 */
public class ContextBasedRestrictionsIT extends SdkIntegrationTestBase {
    private static Map<String, String> config = null;
    private ContextBasedRestrictions service = null;
    private final String NonExistentID = "1234567890abcdef1234567890abcdef";
    private final String InvalidID = "this_is_an_invalid_id";
    private final String itemName = "Java SDK Test";
    private final String itemDescription = "Java SDK Test description";

    private String serviceURL;
    private String testAccountID;
    private String testTargetAccountID;
    private String testServiceName;
    private String zoneID;
    private String zoneRev;
    private String ruleID;
    private String ruleRev;
    private String zoneAssignmentID;
    private String zoneAssignmentRev;

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
        testTargetAccountID = config.get("TEST_TARGET_ACCOUNT_ID");

        System.out.printf("\nService URL: %s\n", serviceURL);
        System.out.printf("Test Account ID: %s\n", testAccountID);
        System.out.printf("Test Service Name: %s\n", testServiceName);
        System.out.printf("Test Target Account ID: %s\n", testTargetAccountID);
        System.out.println("Setup complete.");
    }

    @Test(groups = "createZone")
    public void testCreateZone() throws Exception {
        try {
            AddressIPAddress addressModel = new AddressIPAddress.Builder()
                    .type("ipAddress")
                    .value("169.23.56.234")
                    .build();

            ServiceRefValue serviceRefValueModel = new ServiceRefValue.Builder()
                    .accountId(testAccountID)
                    .serviceName("containers-kubernetes")
                    .location("dal")
                    .build();
            AddressServiceRef serviceRefAddressModel = new AddressServiceRef.Builder()
                    .type("serviceRef")
                    .ref(serviceRefValueModel)
                    .build();

            CreateZoneOptions createZoneOptions = new CreateZoneOptions.Builder()
                    .name(itemName)
                    .accountId(testAccountID)
                    .description(itemDescription)
                    .addresses(java.util.Arrays.asList(addressModel, serviceRefAddressModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Zone> response = service.createZone(createZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            Zone outZoneResult = response.getResult();

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
                    .name(itemName)
                    .accountId(testAccountID)
                    .description(itemDescription)
                    .addresses(java.util.Arrays.asList(addressModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.createZone(createZoneOptions).execute();
            fail("Expected a 409 response for a duplicate zone name");
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
                    .name(itemName)
                    .accountId(testAccountID)
                    .description(itemDescription)
                    .addresses(java.util.Arrays.asList(addressModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.createZone(createZoneOptions).execute();
            fail("Expected a 400 response for an invalid IP address");
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<ZoneList> response = service.listZones(listZonesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ZoneList zoneListResult = response.getResult();

            assertNotNull(zoneListResult);
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.listZones(listZonesOptions).execute();
            fail("Expected a 400 response for an invalid account ID");
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Zone> response = service.getZone(getZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Zone zoneResult = response.getResult();

            assertNotNull(zoneResult);
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.getZone(getZoneOptions).execute();
            fail("Expected a 404 response for a non-existent zone");
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
                    .name(itemName + " updated")
                    .accountId(testAccountID)
                    .description(itemDescription + "updated")
                    .addresses(java.util.Arrays.asList(addressModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Zone> response = service.replaceZone(replaceZoneOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Zone zoneResult = response.getResult();

            assertNotNull(zoneResult);
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
                    .name(itemName)
                    .accountId(testAccountID)
                    .description(itemDescription)
                    .addresses(java.util.Arrays.asList(addressModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.replaceZone(replaceZoneOptions).execute();
            fail("Expected a 404 response for a non-existent zone");
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
                    .name(itemName)
                    .accountId(testAccountID)
                    .description(itemDescription)
                    .addresses(java.util.Arrays.asList(addressModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.replaceZone(replaceZoneOptions).execute();
            fail("Expected a 412 response for an invalid If-Match value");
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<ServiceRefTargetList> response = service
                    .listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceRefTargetList serviceRefTargetListResult = response.getResult();

            assertNotNull(serviceRefTargetListResult);
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.listAvailableServicerefTargets(listAvailableServicerefTargetsOptions).execute();
            fail("Expected a 400 response for an invalid type");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "serviceRef", dependsOnGroups = "replaceZone")
    public void testGetServicerefTarget() throws Exception {
        try {
            GetServicerefTargetOptions getServicerefTargetOptions = new GetServicerefTargetOptions.Builder()
                    .serviceName("containers-kubernetes")
                    .xCorrelationId("testString")
                    .transactionId("testString")
                    .build();

            // Invoke operation
            Response<ServiceRefTarget> response = service.getServicerefTarget(getServicerefTargetOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ServiceRefTarget serviceRefTargetResult = response.getResult();

            assertNotNull(serviceRefTargetResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "serviceRef", dependsOnMethods = "testGetServicerefTarget")
    public void testGetServicerefTargetNotFound() throws Exception {
        try {
            GetServicerefTargetOptions getServicerefTargetOptions = new GetServicerefTargetOptions.Builder()
                    .serviceName("unknown-service-name")
                    .xCorrelationId("testString")
                    .transactionId("testString")
                    .build();

            // Invoke operation
            service.getServicerefTarget(getServicerefTargetOptions).execute();
            fail("Expected a 404 response for an unknown service name");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404)
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
                    .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
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
                    .attributes(
                            java.util.Arrays.asList(resourceAttributeModelAccountID, resourceAttributeModelServiceName))
                    .tags(java.util.Arrays.asList(resourceTagAttributeModel))
                    .build();

            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                    .description(itemDescription)
                    .contexts(java.util.Arrays.asList(ruleContextModel))
                    .resources(java.util.Arrays.asList(resourceModel))
                    .enforcementMode("enabled")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Rule> response = service.createRule(createRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            Rule ruleResult = response.getResult();

            assertNotNull(ruleResult);

            this.ruleID = ruleResult.getId();
            this.ruleRev = response.getHeaders().values("Etag").get(0);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "createRule", dependsOnGroups = "serviceRef")
    public void testCreateRuleWithAPITypes() throws Exception {
        try {
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                    .name("networkZoneId")
                    .value(zoneID)
                    .build();

            RuleContext ruleContextModel = new RuleContext.Builder()
                    .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
                    .build();

            ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
                    .name("accountId")
                    .value(testAccountID)
                    .build();

            ResourceAttribute resourceAttributeModelServiceName = new ResourceAttribute.Builder()
                    .name("serviceName")
                    .value("containers-kubernetes")
                    .build();

            ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
                    .name("tagName")
                    .value("tagValue")
                    .build();

            Resource resourceModel = new Resource.Builder()
                    .attributes(
                            java.util.Arrays.asList(resourceAttributeModelAccountID, resourceAttributeModelServiceName))
                    .tags(java.util.Arrays.asList(resourceTagAttributeModel))
                    .build();

            NewRuleOperationsApiTypesItem apiTypeModel = new NewRuleOperationsApiTypesItem.Builder()
                    .apiTypeId("crn:v1:bluemix:public:containers-kubernetes::::api-type:management")
                    .build();
            NewRuleOperations operationsModel = new NewRuleOperations.Builder()
                    .apiTypes(java.util.Arrays.asList(apiTypeModel))
                    .build();

            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                    .description(itemDescription)
                    .contexts(java.util.Arrays.asList(ruleContextModel))
                    .resources(java.util.Arrays.asList(resourceModel))
                    .operations(operationsModel)
                    .enforcementMode("enabled")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Rule> response = service.createRule(createRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            Rule ruleResult = response.getResult();

            assertNotNull(ruleResult);

            // cleanup
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleResult.getId())
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Void> deleteResponse = service.deleteRule(deleteRuleOptions).execute();
            // Validate response
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 204);
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
                    .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
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
                    .attributes(
                            java.util.Arrays.asList(resourceAttributeModelAccountID, resourceAttributeModelServiceName))
                    .tags(java.util.Arrays.asList(resourceTagAttributeModel))
                    .build();

            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                    .description(itemDescription)
                    .contexts(java.util.Arrays.asList(ruleContextModel))
                    .resources(java.util.Arrays.asList(resourceModel))
                    .enforcementMode("enabled")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.createRule(createRuleOptions).execute();
            fail("Expected a 400 response for a service that is not CBR enabled");
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<RuleList> response = service.listRules(listRulesOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            RuleList ruleListResult = response.getResult();

            assertNotNull(ruleListResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "listRules", dependsOnGroups = "createRule")
    public void testListRulesWithServiceGroupID() throws Exception {
        try {
            // create rule with service group id
            RuleContextAttribute ruleContextAttributeModel = new RuleContextAttribute.Builder()
                    .name("networkZoneId")
                    .value(zoneID)
                    .build();

            RuleContext ruleContextModel = new RuleContext.Builder()
                    .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
                    .build();

            ResourceAttribute resourceAttributeModelAccountID = new ResourceAttribute.Builder()
                    .name("accountId")
                    .value(testAccountID)
                    .build();

            ResourceAttribute resourceAttributeModelServiceGroupID = new ResourceAttribute.Builder()
                    .name("service_group_id")
                    .value("IAM")
                    .build();

            Resource resourceModel = new Resource.Builder()
                    .attributes(java.util.Arrays.asList(resourceAttributeModelAccountID,
                            resourceAttributeModelServiceGroupID))
                    .build();

            CreateRuleOptions createRuleOptions = new CreateRuleOptions.Builder()
                    .description(itemDescription + " with service group")
                    .contexts(java.util.Arrays.asList(ruleContextModel))
                    .resources(java.util.Arrays.asList(resourceModel))
                    .enforcementMode("enabled")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Rule> response = service.createRule(createRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            Rule ruleResult = response.getResult();

            assertNotNull(ruleResult);

            // List rule with service group ID
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                    .accountId(testAccountID)
                    .serviceGroupId("IAM")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<RuleList> listResponse = service.listRules(listRulesOptions).execute();
            // Validate response
            assertNotNull(listResponse);
            assertEquals(listResponse.getStatusCode(), 200);

            RuleList ruleListResult = listResponse.getResult();

            assertNotNull(ruleListResult);
            assertEquals((double) ruleListResult.getCount(), (double) 1);
            assertEquals(ruleListResult.getRules().get(0).getId(), ruleResult.getId());

            // cleanup
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleResult.getId())
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Void> deleteResponse = service.deleteRule(deleteRuleOptions).execute();
            // Validate response
            assertNotNull(deleteResponse);
            assertEquals(deleteResponse.getStatusCode(), 204);
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.listRules(listRulesOptions).execute();
            fail("Expected a 400 response for an invalid account ID");
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Rule> response = service.getRule(getRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Rule ruleResult = response.getResult();

            assertNotNull(ruleResult);
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.getRule(getRuleOptions).execute();
            fail("Expected a 404 response for a non-existent rule");
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
                    .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
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
                    .attributes(java.util.Arrays.asList(resourceAttributeModelAccountName,
                            resourceAttributeModelServiceName))
                    .tags(java.util.Arrays.asList(resourceTagAttributeModel))
                    .build();

            ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
                    .ruleId(ruleID)
                    .ifMatch(ruleRev)
                    .description(itemDescription + " updated")
                    .contexts(java.util.Arrays.asList(ruleContextModel))
                    .resources(java.util.Arrays.asList(resourceModel))
                    .enforcementMode("disabled")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<Rule> response = service.replaceRule(replaceRuleOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Rule ruleResult = response.getResult();

            assertNotNull(ruleResult);
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
                    .attributes(java.util.Arrays.asList(ruleContextAttributeModel))
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
                    .attributes(java.util.Arrays.asList(resourceAttributeModelAccountName,
                            resourceAttributeModelServiceName))
                    .tags(java.util.Arrays.asList(resourceTagAttributeModel))
                    .build();

            ReplaceRuleOptions replaceRuleOptions = new ReplaceRuleOptions.Builder()
                    .ruleId(NonExistentID)
                    .ifMatch("abc")
                    .description(itemDescription)
                    .contexts(java.util.Arrays.asList(ruleContextModel))
                    .resources(java.util.Arrays.asList(resourceModel))
                    .enforcementMode("disabled")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.replaceRule(replaceRuleOptions).execute();
            fail("Expected a 404 response for a non-existent rule");
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<AccountSettings> response = service.getAccountSettings(getAccountSettingsOptions).execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            AccountSettings accountSettingsResult = response.getResult();

            assertNotNull(accountSettingsResult);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "zoneAssignments", dependsOnMethods = "testCreateZone")
    public void testCreateZoneAssignment() throws Exception {
        try {
            EnterpriseTarget enterpriseTargetModel = new EnterpriseTarget.Builder()
                    .type("Account")
                    .id(testTargetAccountID)
                    .build();

            ZoneAssignmentZoneSpec zoneAssignmentZoneSpecModel = new ZoneAssignmentZoneSpec.Builder()
                    .id(zoneID)
                    .build();

            CreateZoneAssignmentOptions createZoneAssignmentOptions = new CreateZoneAssignmentOptions.Builder()
                    .accountId(testAccountID)
                    .target(enterpriseTargetModel)
                    .zones(java.util.Arrays.asList(zoneAssignmentZoneSpecModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            Response<ZoneAssignmentBulkOutput> response = service.createZoneAssignment(createZoneAssignmentOptions)
                    .execute();

            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            ZoneAssignmentBulkOutput result = response.getResult();
            assertNotNull(result);

            List<ZoneAssignment> assignments = result.getAssignments();
            assertNotNull(assignments);
            assertEquals(assignments.size(), 1);

            zoneAssignmentID = assignments.get(0).getId();
            zoneAssignmentRev = response.getHeaders().values("Etag").get(0);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "zoneAssignments", dependsOnMethods = "testCreateZoneAssignment")
    public void testListZoneAssignments() throws Exception {
        try {
            ListZoneAssignmentsOptions listZoneAssignmentsOptions = new ListZoneAssignmentsOptions.Builder()
                    .accountId(testAccountID)
                    .zoneId(zoneID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            Response<ZoneAssignmentList> response = service.listZoneAssignments(listZoneAssignmentsOptions).execute();

            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ZoneAssignmentList result = response.getResult();
            assertNotNull(result);

            List<ZoneAssignmentSummary> assignments = result.getAssignments();
            assertNotNull(assignments);
            assertTrue(assignments.stream().anyMatch(a -> zoneAssignmentID.equals(a.getId())),
                    "Zone assignment " + zoneAssignmentID + " not found in list");
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "zoneAssignments", dependsOnMethods = "testListZoneAssignments")
    public void testGetZoneAssignment() throws Exception {
        try {
            GetZoneAssignmentOptions getZoneAssignmentOptions = new GetZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(zoneAssignmentID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            Response<ZoneAssignment> response = service.getZoneAssignment(getZoneAssignmentOptions).execute();

            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ZoneAssignment result = response.getResult();
            assertNotNull(result);
            assertEquals(result.getId(), zoneAssignmentID);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "zoneAssignments", dependsOnMethods = "testGetZoneAssignment")
    public void testPatchZoneAssignment() throws Exception {
        try {
            PatchZoneAssignmentOptions patchZoneAssignmentOptions = new PatchZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(zoneAssignmentID)
                    .ifMatch(zoneAssignmentRev)
                    .force(true)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            Response<ZoneAssignment> response = service.patchZoneAssignment(patchZoneAssignmentOptions).execute();

            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            ZoneAssignment result = response.getResult();
            assertNotNull(result);
            assertEquals(result.getId(), zoneAssignmentID);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(groups = "zoneAssignments", dependsOnMethods = "testPatchZoneAssignment")
    public void testDeleteZoneAssignment() throws Exception {
        try {
            DeleteZoneAssignmentOptions deleteZoneAssignmentOptions = new DeleteZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(zoneAssignmentID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            Response<Void> response = service.deleteZoneAssignment(deleteZoneAssignmentOptions).execute();

            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }

        waitForZoneAssignmentToNotExist(zoneAssignmentID);
        zoneAssignmentID = null;
    }

    @Test(groups = "zoneAssignments", dependsOnMethods = "testCreateZone")
    public void testCreateZoneAssignmentNonexistentAccount() throws Exception {
        try {
            EnterpriseTarget enterpriseTargetModel = new EnterpriseTarget.Builder()
                    .type("Account")
                    .id(NonExistentID)
                    .build();

            ZoneAssignmentZoneSpec zoneAssignmentZoneSpecModel = new ZoneAssignmentZoneSpec.Builder()
                    .id(zoneID)
                    .build();

            CreateZoneAssignmentOptions createZoneAssignmentOptions = new CreateZoneAssignmentOptions.Builder()
                    .accountId(testAccountID)
                    .target(enterpriseTargetModel)
                    .zones(java.util.Arrays.asList(zoneAssignmentZoneSpecModel))
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            service.createZoneAssignment(createZoneAssignmentOptions).execute();
            fail("Expected a 400 response for a non-existent target account");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400) {
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            }
        }
    }

    @Test(groups = "zoneAssignments")
    public void testGetZoneAssignmentNotFound() throws Exception {
        try {
            GetZoneAssignmentOptions getZoneAssignmentOptions = new GetZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(NonExistentID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            service.getZoneAssignment(getZoneAssignmentOptions).execute();
            fail("Expected a 404 response for a non-existent zone assignment");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404) {
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            }
        }
    }

    @Test(groups = "zoneAssignments")
    public void testPatchZoneAssignmentNotFound() throws Exception {
        try {
            PatchZoneAssignmentOptions patchZoneAssignmentOptions = new PatchZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(NonExistentID)
                    .ifMatch("12345")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            service.patchZoneAssignment(patchZoneAssignmentOptions).execute();
            fail("Expected a 404 response for a non-existent zone assignment");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404) {
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            }
        }
    }

    @Test(groups = "zoneAssignments")
    public void testDeleteZoneAssignmentNotFound() throws Exception {
        try {
            DeleteZoneAssignmentOptions deleteZoneAssignmentOptions = new DeleteZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(NonExistentID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            service.deleteZoneAssignment(deleteZoneAssignmentOptions).execute();
            fail("Expected a 404 response for a non-existent zone assignment");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 404) {
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            }
        }
    }

    @Test(groups = "accountSettings", dependsOnMethods = "testGetAccountSettings")
    public void testGetAccountSettingsInvalidAccountID() throws Exception {
        try {
            GetAccountSettingsOptions getAccountSettingsOptions = new GetAccountSettingsOptions.Builder()
                    .accountId(InvalidID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.getAccountSettings(getAccountSettingsOptions).execute();
            fail("Expected a 400 response for an invalid account ID");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400)
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testListAvailableServiceOperations() throws Exception {
        try {
            ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptions = new ListAvailableServiceOperationsOptions.Builder()
                    .serviceName("containers-kubernetes")
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            Response<OperationsList> response = service
                    .listAvailableServiceOperations(listAvailableServiceOperationsOptions)
                    .execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OperationsList operationsListResult = response.getResult();

            assertNotNull(operationsListResult);

            for (APIType apiType : operationsListResult.getApiTypes()) {
                assertNotEquals(apiType.getType(), "");
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testListAvailableServiceOperationsServiceGroup() throws Exception {
        try {
            ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptions = new ListAvailableServiceOperationsOptions.Builder()
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .serviceGroupId("IAM")
                    .build();

            // Invoke operation
            Response<OperationsList> response = service
                    .listAvailableServiceOperations(listAvailableServiceOperationsOptions)
                    .execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OperationsList operationsListResult = response.getResult();

            assertNotNull(operationsListResult);

            for (APIType apiType : operationsListResult.getApiTypes()) {
                assertNotEquals(apiType.getType(), "");
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testListAvailableServiceOperationsResourceType() throws Exception {
        try {
            ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptions = new ListAvailableServiceOperationsOptions.Builder()
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .serviceName("iam-access-management")
                    .resourceType("customRole")
                    .build();

            // Invoke operation
            Response<OperationsList> response = service
                    .listAvailableServiceOperations(listAvailableServiceOperationsOptions)
                    .execute();
            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            OperationsList operationsListResult = response.getResult();

            assertNotNull(operationsListResult);

            for (APIType apiType : operationsListResult.getApiTypes()) {
                assertNotEquals(apiType.getType(), "");
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s%nError details: %s",
                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testListAvailableServiceOperationsMutualExclusion() throws Exception {
        try {
            ListAvailableServiceOperationsOptions listAvailableServiceOperationsOptions = new ListAvailableServiceOperationsOptions.Builder()
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
                    .serviceName("iam-access-management")
                    .serviceGroupId("IAM")
                    .build();

            // Invoke operation
            service.listAvailableServiceOperations(listAvailableServiceOperationsOptions).execute();
            fail("Expected a 400 response when both serviceName and serviceGroupId are specified");
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() != 400) {
                fail(String.format("Service returned status code %d: %s%nError details: %s",
                        e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
            }
        }
    }

    @Test(groups = "deleteRule", dependsOnGroups = "accountSettings")
    public void testDeleteRule() throws Exception {
        try {
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleID)
                    .transactionId(getTransactionID())
                    .xCorrelationId(getTransactionID())
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.deleteRule(deleteRuleOptions).execute();
            fail("Expected a 404 response for a non-existent rule");
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
                    // Using the standard X-Correlation-Id header in this case
                    .xCorrelationId(getTransactionID())
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
                    .xCorrelationId(getTransactionID())
                    .build();

            // Invoke operation
            service.deleteZone(deleteZoneOptions).execute();
            fail("Expected a 404 response for a non-existent zone");
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
        // This cleanup is needed in case any of the delete tests above fail or get
        // skipped.

        if (ruleID != null) {
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleID)
                    .build();
            service.deleteRule(deleteRuleOptions).execute();
            System.out.println("Cleaned up rule.");
        }

        if (zoneAssignmentID != null) {
            DeleteZoneAssignmentOptions deleteAssignmentOptions = new DeleteZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(zoneAssignmentID)
                    .build();
            service.deleteZoneAssignment(deleteAssignmentOptions).execute();
            waitForZoneAssignmentToNotExist(zoneAssignmentID);
            System.out.println("Cleaned up zone assignment.");
        }

        if (zoneID != null) {
            DeleteZoneOptions deleteZoneOptions = new DeleteZoneOptions.Builder()
                    .zoneId(zoneID)
                    .build();
            service.deleteZone(deleteZoneOptions).execute();
            System.out.println("Cleaned up zone.");
        }

        System.out.println("Clean up complete.");
    }

    // The zone assignment delete is asynchronous, so wait until the assignment can
    // no longer be found.
    private void waitForZoneAssignmentToNotExist(String assignmentID) {
        System.out.print("Waiting for the zone assignment to be deleted.");
        System.out.flush();

        final long timeoutSeconds = 3 * 60; // The delete usually takes around 1 minute.
        final long start = System.currentTimeMillis();
        final long timeoutTime = start + timeoutSeconds * 1000;

        while (true) {
            boolean exists = zoneAssignmentExists(assignmentID);
            if (!exists) {
                System.out.println();
                break;
            } else if (System.currentTimeMillis() > timeoutTime) {
                throw new RuntimeException(String.format("Zone assignment %s still exists after %d seconds",
                        assignmentID, timeoutSeconds));
            } else {
                System.out.print(".");
                System.out.flush();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Interrupted while waiting to retry", ie);
                }
            }
        }
    }

    private boolean zoneAssignmentExists(String assignmentID) {
        try {
            GetZoneAssignmentOptions getZoneAssignmentOptions = new GetZoneAssignmentOptions.Builder()
                    .zoneAssignmentId(assignmentID)
                    .build();
            service.getZoneAssignment(getZoneAssignmentOptions).execute();
            return true;
        } catch (ServiceResponseException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }
}
