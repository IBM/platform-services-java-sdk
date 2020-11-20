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

package com.ibm.cloud.platform_services.configuration_governance.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.configuration_governance.v1.model.Attachment;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.AttachmentList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.AttachmentRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRuleResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.EnforcementAction;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Rule;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Rule.RuleType;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleConditionSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfig;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionAnd;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleTargetAttribute;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateRuleOptions;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ForbiddenException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the ConfigurationGovernance service.
 */
public class ConfigurationGovernanceIT extends SdkIntegrationTestBase {
    public ConfigurationGovernance service = null;
    public ConfigurationGovernance serviceNoAccess = null;
    public static Map<String, String> config = null;

    private final static String TEST_LABEL = "JavaSDKIntegrationTest";

    // Test-related config properties.
    private static String ACCOUNT_ID;
    private static String TEST_SERVICE_NAME;
    private static String ENTERPRISE_SCOPE_ID;
    private static String SUBACCT_SCOPE_ID;

    // Generate a txn-id to be used during this test run.
    private String transactionId = UUID.randomUUID().toString();

    // Variables to hold various id's and object instances (these could perhaps be configured via links).
    private String ruleId1;
    private Rule rule1;
    private String ruleEtag1;
    private String ruleId2;

    private RuleRequest sampleRule1;
    private RuleRequest sampleRule2;
    private RuleRequest badSampleRule;

    private RuleScope enterpriseScope;
    private RuleScope accountScope;
    private RuleScope badScope;

    private String attachmentId1;
    private Attachment attachment1;
    private String attachmentEtag1;
    private String attachmentId2;

    @Override
    public String getConfigFilename() {
        return "../../configuration_governance.env";
    }

    @Override
    public boolean loggingEnabled() {
        return false;
    }

    @BeforeClass
    public void constructService() {
        log("Starting setup...");

        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        // Construct the service client.
        service = ConfigurationGovernance.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Construct a separate service client for some negative tests.
        // This service has an apikey that lacks the necessary access to create or list rules, etc.
        serviceNoAccess = ConfigurationGovernance.newInstance("NO_ACCESS");
        assertNotNull(serviceNoAccess);
        assertNotNull(serviceNoAccess.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(ConfigurationGovernance.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        // Retrieve and verify some additional test-related config properties.
        ACCOUNT_ID = config.get("ACCOUNT_ID");
        TEST_SERVICE_NAME = config.get("TEST_SERVICE_NAME");
        ENTERPRISE_SCOPE_ID = config.get("ENTERPRISE_SCOPE_ID");
        SUBACCT_SCOPE_ID = config.get("SUBACCT_SCOPE_ID");
        assertNotNull(ACCOUNT_ID);
        assertNotNull(TEST_SERVICE_NAME);
        assertNotNull(ENTERPRISE_SCOPE_ID);
        assertNotNull(SUBACCT_SCOPE_ID);

        log("Service URL: " + service.getServiceUrl());
        log("Transaction ID: " + transactionId);

        // Clean any existing test rules before we start the actual tests.
        cleanRules(TEST_LABEL);

        // Create some sample model instances that we'll use when invoking the operations.
        initSampleData();

        log("Finished setup.");
    }

    @Test
    public void testCreateRule1() throws Exception {
        try {
            CreateRuleRequest ruleRequest1 = new CreateRuleRequest.Builder()
                    .requestId("request-0")
                    .rule(sampleRule1)
                    .build();

            CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
                    .rules(new ArrayList<>(Arrays.asList(ruleRequest1)))
                    .transactionId(transactionId)
                    .build();

            Response<CreateRulesResponse> response = service.createRules(createRulesOptions).execute();
            assertNotNull(response);
            log(String.format("createRules() response:\n%s", response.getResult().toString()));
            assertEquals(response.getStatusCode(), 201);

            CreateRulesResponse result = response.getResult();
            assertNotNull(result);
            assertEquals(result.getRules().size(), 1);

            CreateRuleResponse ruleResponse1 = result.getRules().get(0);
            assertEquals(ruleResponse1.getRequestId(), "request-0");
            assertEquals(ruleResponse1.getStatusCode().longValue(), 201);
            ruleId1 = ruleResponse1.getRule().getRuleId();
            assertTrue(ruleId1 != null && !ruleId1.isEmpty());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateRule1" })
    public void testCreateRule2() throws Exception {
        try {
            CreateRuleRequest ruleRequest1 = new CreateRuleRequest.Builder()
                    .rule(sampleRule2)
                    .build();

            CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
                    .rules(new ArrayList<>(Arrays.asList(ruleRequest1)))
                    .transactionId(transactionId)
                    .build();

            Response<CreateRulesResponse> response = service.createRules(createRulesOptions).execute();

            assertNotNull(response);
            log(String.format("createRules():\n%s\n", response.getResult().toString()));
            assertEquals(response.getStatusCode(), 201);

            CreateRulesResponse result = response.getResult();
            assertNotNull(result);
            assertEquals(result.getRules().size(), 1);

            CreateRuleResponse ruleResponse1 = result.getRules().get(0);
            assertFalse(ruleResponse1.getRequestId().isEmpty());
            assertEquals(ruleResponse1.getStatusCode().longValue(), 201);
            ruleId2 = ruleResponse1.getRule().getRuleId();
            assertTrue(ruleId2 != null && !ruleId2.isEmpty());
            assertNotEquals(ruleId1, ruleId2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testCreateRuleInvalidRule() throws Exception {
        try {
            CreateRuleRequest ruleRequestModel1 = new CreateRuleRequest.Builder()
                    .requestId("request-1")
                    .rule(badSampleRule)
                    .build();

            CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
                    .rules(new ArrayList<>(Arrays.asList(ruleRequestModel1)))
                    .transactionId(transactionId)
                    .build();

            // An error will be reported within the CreateRuleResponse entry, but the operation itself will
            // return a 207 status code.
            Response<CreateRulesResponse> response = service.createRules(createRulesOptions).execute();
            assertNotNull(response);
            log(String.format("createRules() response:\n%s", response.getResult().toString()));
            assertEquals(response.getStatusCode(), 207);

            CreateRulesResponse result = response.getResult();
            assertNotNull(result);
            assertEquals(result.getRules().size(), 1);

            // Verify the response entry indicates an error.
            CreateRuleResponse ruleResponse = result.getRules().get(0);
            assertEquals(ruleResponse.getRequestId(), "request-1");
            assertEquals(ruleResponse.getStatusCode().longValue(), 400);
            assertEquals(ruleResponse.getTrace(), transactionId);
            assertFalse(ruleResponse.getErrors().isEmpty());
            assertEquals(ruleResponse.getErrors().get(0).getCode(), "rule_error");
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(expectedExceptions = {ForbiddenException.class})
    public void testCreateRuleNoAccess() throws Exception {
        CreateRuleRequest ruleRequest1 = new CreateRuleRequest.Builder()
                .requestId("request-1")
                .rule(sampleRule1)
                .build();

        CreateRulesOptions createRulesOptions = new CreateRulesOptions.Builder()
                .rules(new ArrayList<>(Arrays.asList(ruleRequest1)))
                .transactionId(transactionId)
                .build();

        serviceNoAccess.createRules(createRulesOptions).execute();
    }

    @Test(dependsOnMethods = { "testCreateRule1", "testCreateRule2" })
    public void testListRules() throws Exception {
        try {
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .labels(TEST_LABEL)
                    .transactionId(transactionId)
                    .limit(1000)
                    .offset(0)
                    .build();

            Response<RuleList> response = service.listRules(listRulesOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);
            RuleList result = response.getResult();
            assertNotNull(result);

            log(String.format("listRules() result:\n%s", result.toString()));
            assertEquals(result.getTotalCount().longValue(), 2);
            assertEquals(result.getOffset().longValue(), 0);
            assertEquals(result.getLimit().longValue(), 1000);
            assertNotNull(result.getFirst());
            assertNotNull(result.getLast());
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(expectedExceptions = {ForbiddenException.class})
    public void testListRulesNoAccess() throws Exception {
        ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                .accountId(ACCOUNT_ID)
                .labels(TEST_LABEL)
                .transactionId(transactionId)
                .limit(1000)
                .offset(0)
                .build();

        serviceNoAccess.listRules(listRulesOptions).execute();
    }

    @Test(dependsOnMethods = { "testCreateRule1" })
    public void testGetRule() throws Exception {
        try {
            assertNotNull(ruleId1);

            GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
                    .ruleId(ruleId1)
                    .transactionId(transactionId)
                    .build();

            Response<Rule> response = service.getRule(getRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Rule result = response.getResult();
            assertNotNull(result);
            log(String.format("getRule() result:\n%s", result.toString()));
            rule1 = result;

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            ruleEtag1 = response.getHeaders().values("Etag").get(0);
            assertNotNull(ruleEtag1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateRule1" })
    public void testGetRuleInvalidRuleId() throws Exception {
        try {

            GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
                    .ruleId("BOGUS_ID")
                    .transactionId(transactionId)
                    .build();

            service.getRule(getRuleOptions).execute();
            fail("Invalid get should not have succeeded!");
        } catch (ServiceResponseException e) {
            // log(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
            //        e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 404);
            assertTrue(e.getMessage().contains("not found"));
        }
    }

    @Test(dependsOnMethods = { "testGetRule" })
    public void testUpdateRule() throws Exception {
        try {
            assertNotNull(rule1);
            assertNotNull(ruleId1);
            assertNotNull(ruleEtag1);

            // Starting with "rule1" (result of a get), modify the description, then call the update operation.
            // Note: we also update the version, but that is currently NOT being stored by the server :(
            UpdateRuleOptions updateRuleOptions = new UpdateRuleOptions.Builder()
                    .ruleId(ruleId1)
                    .ifMatch(ruleEtag1)
                    .name(rule1.getName())
                    .description("Updated: " + rule1.getDescription())
                    .target(rule1.getTarget())
                    .requiredConfig(rule1.getRequiredConfig())
                    .enforcementActions(rule1.getEnforcementActions())
                    .accountId(rule1.getAccountId())
                    .ruleType(rule1.getRuleType())
                    .labels(rule1.getLabels())
                    .transactionId(transactionId)
                    .build();

            Response<Rule> response = service.updateRule(updateRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Rule result = response.getResult();
            assertNotNull(result);
            log(String.format("updateRule() result:\n%s", result.toString()));
            assertTrue(result.getDescription().startsWith("Updated: "));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateRule" })
    public void testUpdateRuleInvalidEtag() throws Exception {
        try {
            assertNotNull(rule1);
            assertNotNull(ruleId1);
            assertNotNull(ruleEtag1);

            // Starting with "rule1" (result of a get), modify the version, then call the update operation.
            UpdateRuleOptions updateRuleOptions = new UpdateRuleOptions.Builder()
                    .ruleId(ruleId1)
                    .ifMatch(ruleEtag1 + "just-foolin'")
                    .name(rule1.getName())
                    .description("Updated: " + rule1.getDescription())
                    .target(rule1.getTarget())
                    .requiredConfig(rule1.getRequiredConfig())
                    .enforcementActions(rule1.getEnforcementActions())
                    .accountId(rule1.getAccountId())
                    .ruleType(rule1.getRuleType())
                    .labels(rule1.getLabels())
                    .transactionId(transactionId)
                    .build();

            service.updateRule(updateRuleOptions).execute();
            fail("Invalid update should not have succeeded!");
        } catch (ServiceResponseException e) {
            // log(String.format("Received expected exception... returned status code %d: %s\nError details: %s", e.getStatusCode(),
            //        e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 400);
            assertTrue(e.getMessage().contains("If-Match"));
        }
    }

    @Test(dependsOnMethods = { "testListRules" })
    public void testDeleteRule() throws Exception {
        try {
            assertNotNull(ruleId2);

            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId(ruleId2)
                    .transactionId(transactionId)
                    .build();

            Response<Void> response = service.deleteRule(deleteRuleOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now check to make sure listRules() returns only 1 rule.
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .labels(TEST_LABEL)
                    .transactionId(transactionId)
                    .limit(1000)
                    .offset(0)
                    .build();

            Response<RuleList> listResponse = service.listRules(listRulesOptions).execute();
            assertNotNull(listResponse);
            assertEquals(listResponse.getStatusCode(), 200);
            RuleList result = listResponse.getResult();
            assertNotNull(result);
            assertEquals(result.getTotalCount().longValue(), 1);

            // Next, make sure we can not do a get on the deleted rule.
            Rule rule = getRule(ruleId2);
            assertNull(rule);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test
    public void testDeleteRuleInvalidRuleId() throws Exception {
        try {
            DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                    .ruleId("BOGUS_RULE_ID")
                    .transactionId(transactionId)
                    .build();

            service.deleteRule(deleteRuleOptions).execute();
            fail("Invalid delete should not have succeeded!");
        } catch (ServiceResponseException e) {
            assertEquals(e.getStatusCode(), 404);
            assertTrue(e.getMessage().contains("not found"));
            // log(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
            //         e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateRule" })
    public void testCreateAttachment1() throws Exception {
        try {
            assertNotNull(ruleId1);

            AttachmentRequest attachmentRequestModel = new AttachmentRequest.Builder()
                    .accountId(ACCOUNT_ID)
                    .includedScope(enterpriseScope)
                    .excludedScopes(new ArrayList<>(Arrays.asList(accountScope)))
                    .build();

            CreateAttachmentsOptions createAttachmentsOptions = new CreateAttachmentsOptions.Builder()
                    .ruleId(ruleId1)
                    .attachments(new ArrayList<>(Arrays.asList(attachmentRequestModel)))
                    .transactionId(transactionId)
                    .build();

            Response<CreateAttachmentsResponse> response =
                    service.createAttachments(createAttachmentsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            CreateAttachmentsResponse result = response.getResult();
            assertNotNull(result);
            log(String.format("createAttachments() result:\n%s", result.toString()));
            assertNotNull(result.getAttachments());
            assertEquals(result.getAttachments().size(), 1);
            assertNotNull(result.getAttachments().get(0));
            attachmentId1 = result.getAttachments().get(0).getAttachmentId();
            assertNotNull(attachmentId1);

            // Now retrieve the rule and make sure the num_attachments is 1.
            Rule rule = getRule(ruleId1);
            assertNotNull(rule);
            assertNotNull(rule.getNumberOfAttachments());
            assertEquals(rule.getNumberOfAttachments().longValue(), 1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateAttachment1" })
    public void testCreateAttachment2() throws Exception {
        try {
            assertNotNull(ruleId1);

            AttachmentRequest attachmentRequestModel = new AttachmentRequest.Builder()
                    .accountId(ACCOUNT_ID)
                    .includedScope(accountScope)
                    .build();

            CreateAttachmentsOptions createAttachmentsOptions = new CreateAttachmentsOptions.Builder()
                    .ruleId(ruleId1)
                    .attachments(new ArrayList<>(Arrays.asList(attachmentRequestModel)))
                    .transactionId(transactionId)
                    .build();

            Response<CreateAttachmentsResponse> response =
                    service.createAttachments(createAttachmentsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 201);

            CreateAttachmentsResponse result = response.getResult();
            assertNotNull(result);
            log(String.format("createAttachments() result:\n%s", result.toString()));
            assertNotNull(result.getAttachments());
            assertEquals(result.getAttachments().size(), 1);
            attachmentId2 = result.getAttachments().get(0).getAttachmentId();
            assertNotNull(attachmentId2);


            // Now retrieve the rule and make sure the num_attachments is 2.
            Rule rule = getRule(ruleId1);
            assertNotNull(rule);
            assertNotNull(rule.getNumberOfAttachments());
            assertEquals(rule.getNumberOfAttachments().longValue(), 2);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testUpdateRule" })
    public void testCreateAttachmentInvalidScopeType() throws Exception {
        try {
            assertNotNull(ruleId1);

            AttachmentRequest attachmentRequestModel = new AttachmentRequest.Builder()
                    .accountId(ACCOUNT_ID)
                    .includedScope(enterpriseScope)
                    .excludedScopes(new ArrayList<>(Arrays.asList(badScope)))
                    .build();

            CreateAttachmentsOptions createAttachmentsOptions = new CreateAttachmentsOptions.Builder()
                    .ruleId(ruleId1)
                    .attachments(new ArrayList<>(Arrays.asList(attachmentRequestModel)))
                    .transactionId(transactionId)
                    .build();

            service.createAttachments(createAttachmentsOptions).execute();
            fail("Invalid attachment should not have succeeded!");
        } catch (ServiceResponseException e) {
            // log(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
            //        e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 400);
            assertTrue(e.getMessage().contains("not a descendant"));
        }
    }

    @Test(dependsOnMethods = { "testCreateAttachment1" })
    public void testGetAttachment() throws Exception {
        try {
            assertNotNull(ruleId1);
            assertNotNull(attachmentId1);

            GetAttachmentOptions getAttachmentOptions = new GetAttachmentOptions.Builder()
                    .ruleId(ruleId1)
                    .attachmentId(attachmentId1)
                    .transactionId(transactionId)
                    .build();

            Response<Attachment> response = service.getAttachment(getAttachmentOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Attachment result = response.getResult();
            assertNotNull(result);
            log(String.format("getAttachment() result:\n%s", result.toString()));
            attachment1 = result;

            assertEquals(result.getAccountId(), ACCOUNT_ID);
            assertEquals(result.getRuleId(), ruleId1);
            assertEquals(result.getAttachmentId(), attachmentId1);
            assertEquals(result.getIncludedScope().note(), "enterprise");
            assertEquals(result.getExcludedScopes().size(), 1);

            // Grab the Etag value from the response for use in the update operation.
            assertNotNull(response.getHeaders().values("Etag"));
            assertEquals(response.getHeaders().values("Etag").size(), 1);
            attachmentEtag1 = response.getHeaders().values("Etag").get(0);
            assertNotNull(attachmentEtag1);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetAttachment" })
    public void testGetAttachmentInvalidAttachmentId() throws Exception {
        try {
            assertNotNull(ruleId1);
            assertNotNull(attachmentId1);

            GetAttachmentOptions getAttachmentOptions = new GetAttachmentOptions.Builder()
                    .ruleId(ruleId1)
                    .attachmentId("BOGUS_ID")
                    .transactionId(transactionId)
                    .build();

            service.getAttachment(getAttachmentOptions).execute();
            fail("Invalid attachment id should not have succeeded!");
        } catch (ServiceResponseException e) {
            //log(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
            //        e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 404);
            assertTrue(e.getMessage().contains("not found"));
        }
    }

    @Test(dependsOnMethods = { "testCreateAttachment2" })
    public void testListAttachments() throws Exception {
        try {
            ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
                    .ruleId(ruleId1)
                    .transactionId(transactionId)
                    .limit(1000)
                    .offset(0)
                    .build();

            Response<AttachmentList> response = service.listAttachments(listAttachmentsOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            AttachmentList result = response.getResult();
            log(String.format("listAttachments() result:\n%s", result.toString()));
            assertNotNull(result);
            assertEquals(result.getOffset().longValue(), 0);
            assertEquals(result.getLimit().longValue(), 1000);
            assertEquals(result.getTotalCount().longValue(), 2);
            assertNotNull(result.getFirst());
            assertNotNull(result.getLast());
            for (Attachment att : result.getAttachments()) {
                if (attachmentId1.equals(att.getAttachmentId())) {
                    assertEquals(att.getIncludedScope().note(), "enterprise");
                    assertEquals(att.getExcludedScopes().size(), 1);
                } else if (attachmentId2.equals(att.getAttachmentId())) {
                    assertEquals(att.getIncludedScope().note(), "leaf account");
                    assertTrue(att.getExcludedScopes() == null || att.getExcludedScopes().isEmpty());
                } else {
                    fail(String.format("Unrecognized attachmentId: %s", att.getAttachmentId()));
                }
            }
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetAttachment" })
    public void testUpdateAttachment() throws Exception {
        try {
            assertNotNull(ruleId1);
            assertNotNull(attachment1);
            assertNotNull(attachmentEtag1);

            RuleScope updatedScope = attachment1.getIncludedScope().newBuilder()
                    .note("Updated: " + attachment1.getIncludedScope().note())
                    .build();

            UpdateAttachmentOptions updateAttachmentOptions = new UpdateAttachmentOptions.Builder()
                    .ifMatch(attachmentEtag1)
                    .ruleId(attachment1.getRuleId())
                    .attachmentId(attachment1.getAttachmentId())
                    .accountId(attachment1.getAccountId())
                    .includedScope(updatedScope)
                    .excludedScopes(attachment1.getExcludedScopes())
                    .transactionId(transactionId)
                    .build();

            Response<Attachment> response = service.updateAttachment(updateAttachmentOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Attachment result = response.getResult();
            assertNotNull(result);
            log(String.format("updateAttachment() result:\n%s", result.toString()));
            assertNotNull(result.getIncludedScope());
            assertTrue(result.getIncludedScope().note().startsWith("Updated:"));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testGetAttachment" })
    public void testUpdateAttachmentInvalidEtag() throws Exception {
        try {
            assertNotNull(ruleId1);
            assertNotNull(attachment1);
            assertNotNull(attachmentEtag1);

            RuleScope updatedScope = attachment1.getIncludedScope().newBuilder()
                    .note("Updated: " + attachment1.getIncludedScope().note())
                    .build();

            UpdateAttachmentOptions updateAttachmentOptions = new UpdateAttachmentOptions.Builder()
                    .ifMatch("BOGUS_ETAG")
                    .ruleId(attachment1.getRuleId())
                    .attachmentId(attachment1.getAttachmentId())
                    .accountId(attachment1.getAccountId())
                    .includedScope(updatedScope)
                    .excludedScopes(attachment1.getExcludedScopes())
                    .transactionId(transactionId)
                    .build();

            service.updateAttachment(updateAttachmentOptions).execute();
            fail("Invalid update should not have succeeded!");
        } catch (ServiceResponseException e) {
            //log(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
            //        e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 400);
            assertTrue(e.getMessage().contains("If-Match"));
        }
    }

    @Test(dependsOnMethods = { "testListAttachments" })
    public void testDeleteAttachment() throws Exception {
        try {
            assertNotNull(ruleId1);
            assertNotNull(attachmentId2);

            DeleteAttachmentOptions deleteAttachmentOptions = new DeleteAttachmentOptions.Builder()
                    .ruleId(ruleId1)
                    .attachmentId(attachmentId2)
                    .transactionId(transactionId)
                    .build();

            Response<Void> response = service.deleteAttachment(deleteAttachmentOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 204);

            // Now verify that listAttachments() returns only 1.
            ListAttachmentsOptions listAttachmentsOptions = new ListAttachmentsOptions.Builder()
                    .ruleId(ruleId1)
                    .transactionId(transactionId)
                    .limit(1000)
                    .offset(0)
                    .build();

            Response<AttachmentList> listResponse = service.listAttachments(listAttachmentsOptions).execute();
            assertNotNull(listResponse);
            assertEquals(listResponse.getStatusCode(), 200);

            AttachmentList result = listResponse.getResult();
            assertNotNull(result);
            assertEquals(result.getTotalCount().longValue(), 1);

            // Next, make sure we cannot retrieve the deleted attachment via a get.
            Attachment attachment = getAttachment(ruleId1, attachmentId2);
            assertNull(attachment);
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }

    @Test(dependsOnMethods = { "testCreateRule1" })
    public void testDeleteAttachmentInvalidAttachmentId() throws Exception {
        try {
            assertNotNull(ruleId1);

            DeleteAttachmentOptions deleteAttachmentOptions = new DeleteAttachmentOptions.Builder()
                    .ruleId(ruleId1)
                    .attachmentId("BOGUS_ID")
                    .transactionId(transactionId)
                    .build();

            service.deleteAttachment(deleteAttachmentOptions).execute();
            fail("Invalid delete should not have succeeded!");
        } catch (ServiceResponseException e) {
            // log(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
            //         e.getMessage(), e.getDebuggingInfo()));
            assertEquals(e.getStatusCode(), 404);
            assertTrue(e.getMessage().contains("not found"));
        }
    }

    @AfterClass
    public void tearDown() {
        log("Starting clean up...");
        cleanRules(TEST_LABEL);
        log("Clean up complete.");
    }


    private Rule getRule(String ruleId) {
        try {
            GetRuleOptions getRuleOptions = new GetRuleOptions.Builder()
                    .ruleId(ruleId)
                    .transactionId(transactionId)
                    .build();

            Response<Rule> getResponse = service.getRule(getRuleOptions).execute();
            assertNotNull(getResponse);
            assertEquals(getResponse.getStatusCode(), 200);
            Rule rule = getResponse.getResult();
            assertNotNull(rule);
            // log(String.format("Received response:\n%s", rule.toString()));
            return rule;
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }

    private Attachment getAttachment(String ruleId, String attachmentId) {
        try {
            GetAttachmentOptions getAttachmentOptions = new GetAttachmentOptions.Builder()
                    .ruleId(ruleId)
                    .attachmentId(attachmentId)
                    .transactionId(transactionId)
                    .build();

            Response<Attachment> response = service.getAttachment(getAttachmentOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            Attachment result = response.getResult();
            assertNotNull(result);
            return result;
        } catch (NotFoundException e) {
            return null;
        } catch (Throwable t) {
            throw t;
        }
    }

    /**
     * @param testLabel
     */
    private void cleanRules(String label) {
        try {
            log("Cleaning rules...");

            // List any existing rules for this account with the specified label.
            ListRulesOptions listRulesOptions = new ListRulesOptions.Builder()
                    .accountId(ACCOUNT_ID)
                    .labels(label)
                    .offset(0)
                    .limit(1000)
                    .transactionId(transactionId)
                    .build();
            Response<RuleList> response = service.listRules(listRulesOptions).execute();
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 200);

            RuleList ruleListResult = response.getResult();
            assertNotNull(ruleListResult);

            log(String.format("Found %d rule(s) to be cleaned", ruleListResult.getTotalCount()));

            // Now walk through the returned rules and delete each one.
            if (ruleListResult.getTotalCount() > 0) {
                for (Rule rule : ruleListResult.getRules()) {
                    DeleteRuleOptions deleteRuleOptions = new DeleteRuleOptions.Builder()
                            .ruleId(rule.getRuleId())
                            .transactionId(transactionId)
                            .build();

                    log(String.format("Deleting rule: name='%s' id='%s'", rule.getName(), rule.getRuleId()));

                    Response<Void> deleteResponse = service.deleteRule(deleteRuleOptions).execute();
                    assertNotNull(deleteResponse);
                    assertEquals(deleteResponse.getStatusCode(), 204);
                }
            }
            log("Finished cleaning rules...");
        } catch (ServiceResponseException e) {
            throw e;
        }
    }

    private void initSampleData() {

        RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
                .name("resource_id")
                .operator(RuleTargetAttribute.Operator.IS_NOT_EMPTY)
                .build();
        List<RuleTargetAttribute> targetAttributes = Arrays.asList(ruleTargetAttributeModel);

        TargetResource targetResourceModel = new TargetResource.Builder()
                .serviceName(TEST_SERVICE_NAME)
                .resourceKind("bucket")
                .additionalTargetAttributes(targetAttributes)
                .build();

        RuleConditionSingleProperty allowedGBCondition = new RuleConditionSingleProperty.Builder()
                .property("allowed_gb")
                .operator(RuleConditionSingleProperty.Operator.NUM_LESS_THAN_EQUALS)
                .value("20")
                .build();

        RuleConditionSingleProperty locationCondition = new RuleConditionSingleProperty.Builder()
                .property("location")
                .operator(RuleConditionSingleProperty.Operator.STRING_EQUALS)
                .value("us-east")
                .build();

        // Used in sampleRule1.
        RuleRequiredConfig ruleRequiredConfigModel1 = new RuleRequiredConfigMultiplePropertiesConditionAnd.Builder()
                .description("allowed_gb==20 && location=='us-east'")
                .addOperand(allowedGBCondition)
                .addOperand(locationCondition)
                .build();

        // Used in sampleRule2.
        RuleRequiredConfig ruleRequiredConfigModel2 = new RuleRequiredConfigSingleProperty.Builder()
                .description("allowed_gb<=30")
                .property("allowed_gb")
                .operator(RuleRequiredConfigSingleProperty.Operator.NUM_LESS_THAN_EQUALS)
                .value("30")
                .build();

        EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
                .action(EnforcementAction.Action.DISALLOW)
                .build();

        // Sample rules.
        sampleRule1 = new RuleRequest.Builder()
                .accountId(ACCOUNT_ID)
                .name("Java Test Rule #1")
                .description("This is the description for Java Test Rule #1.")
                .ruleType(RuleType.USER_DEFINED)
                .target(targetResourceModel)
                .requiredConfig(ruleRequiredConfigModel1)
                .enforcementActions(new ArrayList<>(Arrays.asList(enforcementActionModel)))
                .labels(new ArrayList<>(Arrays.asList(TEST_LABEL)))
                .build();

        sampleRule2 = new RuleRequest.Builder()
                .accountId(ACCOUNT_ID)
                .name("Java Test Rule #2")
                .description("This is the description for Java Test Rule #2.")
                .ruleType(RuleType.USER_DEFINED)
                .target(targetResourceModel)
                .requiredConfig(ruleRequiredConfigModel2)
                .enforcementActions(new ArrayList<>(Arrays.asList(enforcementActionModel)))
                .labels(new ArrayList<>(Arrays.asList(TEST_LABEL)))
                .build();

        badSampleRule = new RuleRequest.Builder()
                .accountId(ACCOUNT_ID)
                .name("Java Test Rule #2")
                .description("This is the description for Java Test Rule #2.")
                .ruleType("service_defined")
                .target(targetResourceModel)
                .requiredConfig(ruleRequiredConfigModel2)
                .enforcementActions(new ArrayList<>(Arrays.asList(enforcementActionModel)))
                .labels(new ArrayList<>(Arrays.asList(TEST_LABEL)))
                .build();

        // Sample rule scopes.
        enterpriseScope = new RuleScope.Builder()
                .note("enterprise")
                .scopeId(ENTERPRISE_SCOPE_ID)
                .scopeType("enterprise")
                .build();

        accountScope = new RuleScope.Builder()
                .note("leaf account")
                .scopeId(SUBACCT_SCOPE_ID)
                .scopeType("enterprise.account")
                .build();

        badScope = new RuleScope.Builder()
                .note("leaf account")
                .scopeId(SUBACCT_SCOPE_ID)
                .scopeType("enterprise.BOGUS")
                .build();
    }
}
