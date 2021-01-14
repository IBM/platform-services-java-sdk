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
package com.ibm.cloud.platform_services.configuration_governance.v1;

import com.ibm.cloud.platform_services.configuration_governance.v1.ConfigurationGovernance;
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
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Link;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Rule;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleCondition;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleConditionAndLvl2;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleConditionOrLvl2;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleConditionSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequest;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfig;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigMultipleProperties;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionAnd;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigMultiplePropertiesConditionOr;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleRequiredConfigSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleResponseError;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleSingleProperty;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleTargetAttribute;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.TargetResource;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ConfigurationGovernance service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class ConfigurationGovernanceTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected ConfigurationGovernance configurationGovernanceService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    configurationGovernanceService = ConfigurationGovernance.newInstance(serviceName);
    String url = server.url("/").toString();
    configurationGovernanceService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new ConfigurationGovernance(serviceName, null);
  }

  @Test
  public void testCreateRulesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rules\": [{\"request_id\": \"3cebc877-58e7-44a5-a292-32114fa73558\", \"status_code\": 201, \"rule\": {\"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"rule_type\": \"user_defined\", \"target\": {\"service_name\": \"iam-groups\", \"resource_kind\": \"zone\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"property\": \"public_access_enabled\", \"operator\": \"is_true\", \"value\": \"value\"}, \"enforcement_actions\": [{\"action\": \"audit_log\"}], \"labels\": [\"label\"], \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"creation_date\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"modification_date\": \"2019-01-01T12:00:00\", \"modified_by\": \"modifiedBy\", \"number_of_attachments\": 3}, \"errors\": [{\"code\": \"bad_request\", \"message\": \"The rule is missing an account ID\"}], \"trace\": \"861263b4-cee3-4514-8d8c-05d17308e6eb\"}]}";
    String createRulesPath = "/config/v1/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleTargetAttribute model
    RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
    .name("resource_id")
    .operator("string_equals")
    .value("f0f8f7994e754ff38f9d370201966561")
    .build();

    // Construct an instance of the TargetResource model
    TargetResource targetResourceModel = new TargetResource.Builder()
    .serviceName("iam-groups")
    .resourceKind("service")
    .additionalTargetAttributes(new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)))
    .build();

    // Construct an instance of the RuleConditionSingleProperty model
    RuleConditionSingleProperty ruleConditionModel = new RuleConditionSingleProperty.Builder()
    .description("testString")
    .property("public_access_enabled")
    .operator("is_false")
    .value("testString")
    .build();

    // Construct an instance of the RuleRequiredConfigMultiplePropertiesConditionAnd model
    RuleRequiredConfigMultiplePropertiesConditionAnd ruleRequiredConfigModel = new RuleRequiredConfigMultiplePropertiesConditionAnd.Builder()
    .description("Public access check")
    .and(new java.util.ArrayList<RuleCondition>(java.util.Arrays.asList(ruleConditionModel)))
    .build();

    // Construct an instance of the EnforcementAction model
    EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
    .action("disallow")
    .build();

    // Construct an instance of the RuleRequest model
    RuleRequest ruleRequestModel = new RuleRequest.Builder()
    .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
    .name("Disable public access")
    .description("Ensure that public access to account resources is disabled.")
    .ruleType("user_defined")
    .target(targetResourceModel)
    .requiredConfig(ruleRequiredConfigModel)
    .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
    .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the CreateRuleRequest model
    CreateRuleRequest createRuleRequestModel = new CreateRuleRequest.Builder()
    .requestId("3cebc877-58e7-44a5-a292-32114fa73558")
    .rule(ruleRequestModel)
    .build();

    // Construct an instance of the CreateRulesOptions model
    CreateRulesOptions createRulesOptionsModel = new CreateRulesOptions.Builder()
    .rules(new java.util.ArrayList<CreateRuleRequest>(java.util.Arrays.asList(createRuleRequestModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateRulesResponse> response = configurationGovernanceService.createRules(createRulesOptionsModel).execute();
    assertNotNull(response);
    CreateRulesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createRulesPath);
  }

  // Test the createRules operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRulesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.createRules(null).execute();
  }

  @Test
  public void testListRulesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 1000, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"rules\": [{\"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"rule_type\": \"user_defined\", \"target\": {\"service_name\": \"iam-groups\", \"resource_kind\": \"zone\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"property\": \"public_access_enabled\", \"operator\": \"is_true\", \"value\": \"value\"}, \"enforcement_actions\": [{\"action\": \"audit_log\"}], \"labels\": [\"label\"], \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"creation_date\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"modification_date\": \"2019-01-01T12:00:00\", \"modified_by\": \"modifiedBy\", \"number_of_attachments\": 3}]}";
    String listRulesPath = "/config/v1/rules";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListRulesOptions model
    ListRulesOptions listRulesOptionsModel = new ListRulesOptions.Builder()
    .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
    .transactionId("testString")
    .attached(true)
    .labels("SOC2,ITCS300")
    .scopes("scope_id")
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RuleList> response = configurationGovernanceService.listRules(listRulesOptionsModel).execute();
    assertNotNull(response);
    RuleList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "531fc3e28bfc43c5a2cea07786d93f5c");
    assertEquals(Boolean.valueOf(query.get("attached")), Boolean.valueOf(true));
    assertEquals(query.get("labels"), "SOC2,ITCS300");
    assertEquals(query.get("scopes"), "scope_id");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listRulesPath);
  }

  // Test the listRules operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListRulesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.listRules(null).execute();
  }

  @Test
  public void testGetRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"rule_type\": \"user_defined\", \"target\": {\"service_name\": \"iam-groups\", \"resource_kind\": \"zone\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"property\": \"public_access_enabled\", \"operator\": \"is_true\", \"value\": \"value\"}, \"enforcement_actions\": [{\"action\": \"audit_log\"}], \"labels\": [\"label\"], \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"creation_date\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"modification_date\": \"2019-01-01T12:00:00\", \"modified_by\": \"modifiedBy\", \"number_of_attachments\": 3}";
    String getRulePath = "/config/v1/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetRuleOptions model
    GetRuleOptions getRuleOptionsModel = new GetRuleOptions.Builder()
    .ruleId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = configurationGovernanceService.getRule(getRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRulePath);
  }

  // Test the getRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.getRule(null).execute();
  }

  @Test
  public void testUpdateRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_id\": \"accountId\", \"name\": \"name\", \"description\": \"description\", \"rule_type\": \"user_defined\", \"target\": {\"service_name\": \"iam-groups\", \"resource_kind\": \"zone\", \"additional_target_attributes\": [{\"name\": \"name\", \"operator\": \"string_equals\", \"value\": \"value\"}]}, \"required_config\": {\"description\": \"description\", \"property\": \"public_access_enabled\", \"operator\": \"is_true\", \"value\": \"value\"}, \"enforcement_actions\": [{\"action\": \"audit_log\"}], \"labels\": [\"label\"], \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"creation_date\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"modification_date\": \"2019-01-01T12:00:00\", \"modified_by\": \"modifiedBy\", \"number_of_attachments\": 3}";
    String updateRulePath = "/config/v1/rules/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleTargetAttribute model
    RuleTargetAttribute ruleTargetAttributeModel = new RuleTargetAttribute.Builder()
    .name("testString")
    .operator("string_equals")
    .value("testString")
    .build();

    // Construct an instance of the TargetResource model
    TargetResource targetResourceModel = new TargetResource.Builder()
    .serviceName("iam-groups")
    .resourceKind("service")
    .additionalTargetAttributes(new java.util.ArrayList<RuleTargetAttribute>(java.util.Arrays.asList(ruleTargetAttributeModel)))
    .build();

    // Construct an instance of the RuleRequiredConfigSingleProperty model
    RuleRequiredConfigSingleProperty ruleRequiredConfigModel = new RuleRequiredConfigSingleProperty.Builder()
    .description("testString")
    .property("public_access_enabled")
    .operator("is_false")
    .value("testString")
    .build();

    // Construct an instance of the EnforcementAction model
    EnforcementAction enforcementActionModel = new EnforcementAction.Builder()
    .action("audit_log")
    .build();

    // Construct an instance of the UpdateRuleOptions model
    UpdateRuleOptions updateRuleOptionsModel = new UpdateRuleOptions.Builder()
    .ruleId("testString")
    .ifMatch("testString")
    .name("Disable public access")
    .description("Ensure that public access to account resources is disabled.")
    .target(targetResourceModel)
    .requiredConfig(ruleRequiredConfigModel)
    .enforcementActions(new java.util.ArrayList<EnforcementAction>(java.util.Arrays.asList(enforcementActionModel)))
    .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
    .ruleType("user_defined")
    .labels(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Rule> response = configurationGovernanceService.updateRule(updateRuleOptionsModel).execute();
    assertNotNull(response);
    Rule responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateRulePath);
  }

  // Test the updateRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.updateRule(null).execute();
  }

  @Test
  public void testDeleteRuleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteRulePath = "/config/v1/rules/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteRuleOptions model
    DeleteRuleOptions deleteRuleOptionsModel = new DeleteRuleOptions.Builder()
    .ruleId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = configurationGovernanceService.deleteRule(deleteRuleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteRulePath);
  }

  // Test the deleteRule operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRuleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.deleteRule(null).execute();
  }

  @Test
  public void testCreateAttachmentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"attachments\": [{\"attachment_id\": \"attachment-fc7b9a77-1c85-406c-b346-f3f5bb9aa7e2\", \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"account_id\": \"accountId\", \"included_scope\": {\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}, \"excluded_scopes\": [{\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}]}]}";
    String createAttachmentsPath = "/config/v1/rules/testString/attachments";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleScope model
    RuleScope ruleScopeModel = new RuleScope.Builder()
    .note("My enterprise")
    .scopeId("282cf433ac91493ba860480d92519990")
    .scopeType("enterprise")
    .build();

    // Construct an instance of the AttachmentRequest model
    AttachmentRequest attachmentRequestModel = new AttachmentRequest.Builder()
    .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
    .includedScope(ruleScopeModel)
    .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
    .build();

    // Construct an instance of the CreateAttachmentsOptions model
    CreateAttachmentsOptions createAttachmentsOptionsModel = new CreateAttachmentsOptions.Builder()
    .ruleId("testString")
    .attachments(new java.util.ArrayList<AttachmentRequest>(java.util.Arrays.asList(attachmentRequestModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateAttachmentsResponse> response = configurationGovernanceService.createAttachments(createAttachmentsOptionsModel).execute();
    assertNotNull(response);
    CreateAttachmentsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAttachmentsPath);
  }

  // Test the createAttachments operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAttachmentsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.createAttachments(null).execute();
  }

  @Test
  public void testListAttachmentsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 1000, \"total_count\": 10, \"first\": {\"href\": \"href\"}, \"last\": {\"href\": \"href\"}, \"attachments\": [{\"attachment_id\": \"attachment-fc7b9a77-1c85-406c-b346-f3f5bb9aa7e2\", \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"account_id\": \"accountId\", \"included_scope\": {\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}, \"excluded_scopes\": [{\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}]}]}";
    String listAttachmentsPath = "/config/v1/rules/testString/attachments";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAttachmentsOptions model
    ListAttachmentsOptions listAttachmentsOptionsModel = new ListAttachmentsOptions.Builder()
    .ruleId("testString")
    .transactionId("testString")
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AttachmentList> response = configurationGovernanceService.listAttachments(listAttachmentsOptionsModel).execute();
    assertNotNull(response);
    AttachmentList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAttachmentsPath);
  }

  // Test the listAttachments operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListAttachmentsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.listAttachments(null).execute();
  }

  @Test
  public void testGetAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"attachment_id\": \"attachment-fc7b9a77-1c85-406c-b346-f3f5bb9aa7e2\", \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"account_id\": \"accountId\", \"included_scope\": {\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}, \"excluded_scopes\": [{\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}]}";
    String getAttachmentPath = "/config/v1/rules/testString/attachments/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAttachmentOptions model
    GetAttachmentOptions getAttachmentOptionsModel = new GetAttachmentOptions.Builder()
    .ruleId("testString")
    .attachmentId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Attachment> response = configurationGovernanceService.getAttachment(getAttachmentOptionsModel).execute();
    assertNotNull(response);
    Attachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAttachmentPath);
  }

  // Test the getAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.getAttachment(null).execute();
  }

  @Test
  public void testUpdateAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"attachment_id\": \"attachment-fc7b9a77-1c85-406c-b346-f3f5bb9aa7e2\", \"rule_id\": \"rule-81f3db5e-f9db-4c46-9de3-a4a76e66adbf\", \"account_id\": \"accountId\", \"included_scope\": {\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}, \"excluded_scopes\": [{\"note\": \"note\", \"scope_id\": \"scopeId\", \"scope_type\": \"enterprise\"}]}";
    String updateAttachmentPath = "/config/v1/rules/testString/attachments/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RuleScope model
    RuleScope ruleScopeModel = new RuleScope.Builder()
    .note("My enterprise")
    .scopeId("282cf433ac91493ba860480d92519990")
    .scopeType("enterprise")
    .build();

    // Construct an instance of the UpdateAttachmentOptions model
    UpdateAttachmentOptions updateAttachmentOptionsModel = new UpdateAttachmentOptions.Builder()
    .ruleId("testString")
    .attachmentId("testString")
    .ifMatch("testString")
    .accountId("531fc3e28bfc43c5a2cea07786d93f5c")
    .includedScope(ruleScopeModel)
    .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Attachment> response = configurationGovernanceService.updateAttachment(updateAttachmentOptionsModel).execute();
    assertNotNull(response);
    Attachment responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAttachmentPath);
  }

  // Test the updateAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.updateAttachment(null).execute();
  }

  @Test
  public void testDeleteAttachmentWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteAttachmentPath = "/config/v1/rules/testString/attachments/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteAttachmentOptions model
    DeleteAttachmentOptions deleteAttachmentOptionsModel = new DeleteAttachmentOptions.Builder()
    .ruleId("testString")
    .attachmentId("testString")
    .transactionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = configurationGovernanceService.deleteAttachment(deleteAttachmentOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAttachmentPath);
  }

  // Test the deleteAttachment operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAttachmentNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    configurationGovernanceService.deleteAttachment(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    configurationGovernanceService = null;
  }
}