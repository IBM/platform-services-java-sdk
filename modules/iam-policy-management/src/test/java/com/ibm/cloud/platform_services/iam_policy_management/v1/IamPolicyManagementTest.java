/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.iam_policy_management.v1;

import com.ibm.cloud.platform_services.iam_policy_management.v1.IamPolicyManagement;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CustomRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListRolesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PatchPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicySubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Role;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.SubjectAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2DeletePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2GetPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseControl;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseControlGrant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseRule;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseRuleV2PolicyAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseRuleV2RuleWithConditions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyBaseSubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2UpdatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import java.io.IOException;
import java.io.InputStream;
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
 * Unit test class for the IamPolicyManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class IamPolicyManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IamPolicyManagement iamPolicyManagementService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new IamPolicyManagement(serviceName, null);
  }

  // Test the listPolicies operation with a valid options model parameter
  @Test
  public void testListPoliciesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"policies\": [{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}]}";
    String listPoliciesPath = "/v1/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListPoliciesOptions model
    ListPoliciesOptions listPoliciesOptionsModel = new ListPoliciesOptions.Builder()
      .accountId("testString")
      .acceptLanguage("default")
      .iamId("testString")
      .accessGroupId("testString")
      .type("access")
      .serviceType("service")
      .tagName("testString")
      .tagValue("testString")
      .sort("id")
      .format("include_last_permit")
      .state("active")
      .build();

    // Invoke listPolicies() with a valid options model and verify the result
    Response<PolicyList> response = iamPolicyManagementService.listPolicies(listPoliciesOptionsModel).execute();
    assertNotNull(response);
    PolicyList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listPoliciesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("iam_id"), "testString");
    assertEquals(query.get("access_group_id"), "testString");
    assertEquals(query.get("type"), "access");
    assertEquals(query.get("service_type"), "service");
    assertEquals(query.get("tag_name"), "testString");
    assertEquals(query.get("tag_value"), "testString");
    assertEquals(query.get("sort"), "id");
    assertEquals(query.get("format"), "include_last_permit");
    assertEquals(query.get("state"), "active");
  }

  // Test the listPolicies operation with and without retries enabled
  @Test
  public void testListPoliciesWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testListPoliciesWOptions();

    iamPolicyManagementService.disableRetries();
    testListPoliciesWOptions();
  }

  // Test the listPolicies operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListPoliciesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.listPolicies(null).execute();
  }

  // Test the createPolicy operation with a valid options model parameter
  @Test
  public void testCreatePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String createPolicyPath = "/v1/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the SubjectAttribute model
    SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
      .name("testString")
      .value("testString")
      .build();

    // Construct an instance of the PolicySubject model
    PolicySubject policySubjectModel = new PolicySubject.Builder()
      .attributes(java.util.Arrays.asList(subjectAttributeModel))
      .build();

    // Construct an instance of the PolicyRole model
    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();

    // Construct an instance of the ResourceAttribute model
    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

    // Construct an instance of the ResourceTag model
    ResourceTag resourceTagModel = new ResourceTag.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

    // Construct an instance of the PolicyResource model
    PolicyResource policyResourceModel = new PolicyResource.Builder()
      .attributes(java.util.Arrays.asList(resourceAttributeModel))
      .tags(java.util.Arrays.asList(resourceTagModel))
      .build();

    // Construct an instance of the CreatePolicyOptions model
    CreatePolicyOptions createPolicyOptionsModel = new CreatePolicyOptions.Builder()
      .type("testString")
      .subjects(java.util.Arrays.asList(policySubjectModel))
      .roles(java.util.Arrays.asList(policyRoleModel))
      .resources(java.util.Arrays.asList(policyResourceModel))
      .description("testString")
      .acceptLanguage("default")
      .build();

    // Invoke createPolicy() with a valid options model and verify the result
    Response<Policy> response = iamPolicyManagementService.createPolicy(createPolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createPolicyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createPolicy operation with and without retries enabled
  @Test
  public void testCreatePolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testCreatePolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testCreatePolicyWOptions();
  }

  // Test the createPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.createPolicy(null).execute();
  }

  // Test the updatePolicy operation with a valid options model parameter
  @Test
  public void testUpdatePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String updatePolicyPath = "/v1/policies/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the SubjectAttribute model
    SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
      .name("testString")
      .value("testString")
      .build();

    // Construct an instance of the PolicySubject model
    PolicySubject policySubjectModel = new PolicySubject.Builder()
      .attributes(java.util.Arrays.asList(subjectAttributeModel))
      .build();

    // Construct an instance of the PolicyRole model
    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();

    // Construct an instance of the ResourceAttribute model
    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

    // Construct an instance of the ResourceTag model
    ResourceTag resourceTagModel = new ResourceTag.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();

    // Construct an instance of the PolicyResource model
    PolicyResource policyResourceModel = new PolicyResource.Builder()
      .attributes(java.util.Arrays.asList(resourceAttributeModel))
      .tags(java.util.Arrays.asList(resourceTagModel))
      .build();

    // Construct an instance of the UpdatePolicyOptions model
    UpdatePolicyOptions updatePolicyOptionsModel = new UpdatePolicyOptions.Builder()
      .policyId("testString")
      .ifMatch("testString")
      .type("testString")
      .subjects(java.util.Arrays.asList(policySubjectModel))
      .roles(java.util.Arrays.asList(policyRoleModel))
      .resources(java.util.Arrays.asList(policyResourceModel))
      .description("testString")
      .build();

    // Invoke updatePolicy() with a valid options model and verify the result
    Response<Policy> response = iamPolicyManagementService.updatePolicy(updatePolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updatePolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updatePolicy operation with and without retries enabled
  @Test
  public void testUpdatePolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testUpdatePolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testUpdatePolicyWOptions();
  }

  // Test the updatePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdatePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.updatePolicy(null).execute();
  }

  // Test the getPolicy operation with a valid options model parameter
  @Test
  public void testGetPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String getPolicyPath = "/v1/policies/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPolicyOptions model
    GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
      .policyId("testString")
      .build();

    // Invoke getPolicy() with a valid options model and verify the result
    Response<Policy> response = iamPolicyManagementService.getPolicy(getPolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPolicyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getPolicy operation with and without retries enabled
  @Test
  public void testGetPolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testGetPolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testGetPolicyWOptions();
  }

  // Test the getPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.getPolicy(null).execute();
  }

  // Test the deletePolicy operation with a valid options model parameter
  @Test
  public void testDeletePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deletePolicyPath = "/v1/policies/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeletePolicyOptions model
    DeletePolicyOptions deletePolicyOptionsModel = new DeletePolicyOptions.Builder()
      .policyId("testString")
      .build();

    // Invoke deletePolicy() with a valid options model and verify the result
    Response<Void> response = iamPolicyManagementService.deletePolicy(deletePolicyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deletePolicyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deletePolicy operation with and without retries enabled
  @Test
  public void testDeletePolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testDeletePolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testDeletePolicyWOptions();
  }

  // Test the deletePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeletePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.deletePolicy(null).execute();
  }

  // Test the patchPolicy operation with a valid options model parameter
  @Test
  public void testPatchPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String patchPolicyPath = "/v1/policies/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PatchPolicyOptions model
    PatchPolicyOptions patchPolicyOptionsModel = new PatchPolicyOptions.Builder()
      .policyId("testString")
      .ifMatch("testString")
      .state("active")
      .build();

    // Invoke patchPolicy() with a valid options model and verify the result
    Response<Policy> response = iamPolicyManagementService.patchPolicy(patchPolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, patchPolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the patchPolicy operation with and without retries enabled
  @Test
  public void testPatchPolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testPatchPolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testPatchPolicyWOptions();
  }

  // Test the patchPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPatchPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.patchPolicy(null).execute();
  }

  // Test the listRoles operation with a valid options model parameter
  @Test
  public void testListRolesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"custom_roles\": [{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"Developer\", \"account_id\": \"accountId\", \"service_name\": \"iam-groups\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}], \"service_roles\": [{\"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\"}], \"system_roles\": [{\"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\"}]}";
    String listRolesPath = "/v2/roles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListRolesOptions model
    ListRolesOptions listRolesOptionsModel = new ListRolesOptions.Builder()
      .acceptLanguage("default")
      .accountId("testString")
      .serviceName("iam-groups")
      .sourceServiceName("iam-groups")
      .policyType("authorization")
      .build();

    // Invoke listRoles() with a valid options model and verify the result
    Response<RoleList> response = iamPolicyManagementService.listRoles(listRolesOptionsModel).execute();
    assertNotNull(response);
    RoleList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listRolesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("service_name"), "iam-groups");
    assertEquals(query.get("source_service_name"), "iam-groups");
    assertEquals(query.get("policy_type"), "authorization");
  }

  // Test the listRoles operation with and without retries enabled
  @Test
  public void testListRolesWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testListRolesWOptions();

    iamPolicyManagementService.disableRetries();
    testListRolesWOptions();
  }

  // Test the createRole operation with a valid options model parameter
  @Test
  public void testCreateRoleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"Developer\", \"account_id\": \"accountId\", \"service_name\": \"iam-groups\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}";
    String createRolePath = "/v2/roles";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateRoleOptions model
    CreateRoleOptions createRoleOptionsModel = new CreateRoleOptions.Builder()
      .displayName("testString")
      .actions(java.util.Arrays.asList("testString"))
      .name("Developer")
      .accountId("testString")
      .serviceName("iam-groups")
      .description("testString")
      .acceptLanguage("default")
      .build();

    // Invoke createRole() with a valid options model and verify the result
    Response<CustomRole> response = iamPolicyManagementService.createRole(createRoleOptionsModel).execute();
    assertNotNull(response);
    CustomRole responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createRolePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createRole operation with and without retries enabled
  @Test
  public void testCreateRoleWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testCreateRoleWOptions();

    iamPolicyManagementService.disableRetries();
    testCreateRoleWOptions();
  }

  // Test the createRole operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRoleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.createRole(null).execute();
  }

  // Test the updateRole operation with a valid options model parameter
  @Test
  public void testUpdateRoleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"Developer\", \"account_id\": \"accountId\", \"service_name\": \"iam-groups\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}";
    String updateRolePath = "/v2/roles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateRoleOptions model
    UpdateRoleOptions updateRoleOptionsModel = new UpdateRoleOptions.Builder()
      .roleId("testString")
      .ifMatch("testString")
      .displayName("testString")
      .description("testString")
      .actions(java.util.Arrays.asList("testString"))
      .build();

    // Invoke updateRole() with a valid options model and verify the result
    Response<CustomRole> response = iamPolicyManagementService.updateRole(updateRoleOptionsModel).execute();
    assertNotNull(response);
    CustomRole responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateRolePath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateRole operation with and without retries enabled
  @Test
  public void testUpdateRoleWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testUpdateRoleWOptions();

    iamPolicyManagementService.disableRetries();
    testUpdateRoleWOptions();
  }

  // Test the updateRole operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateRoleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.updateRole(null).execute();
  }

  // Test the getRole operation with a valid options model parameter
  @Test
  public void testGetRoleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"Developer\", \"account_id\": \"accountId\", \"service_name\": \"iam-groups\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}";
    String getRolePath = "/v2/roles/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetRoleOptions model
    GetRoleOptions getRoleOptionsModel = new GetRoleOptions.Builder()
      .roleId("testString")
      .build();

    // Invoke getRole() with a valid options model and verify the result
    Response<CustomRole> response = iamPolicyManagementService.getRole(getRoleOptionsModel).execute();
    assertNotNull(response);
    CustomRole responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRolePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getRole operation with and without retries enabled
  @Test
  public void testGetRoleWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testGetRoleWOptions();

    iamPolicyManagementService.disableRetries();
    testGetRoleWOptions();
  }

  // Test the getRole operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRoleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.getRole(null).execute();
  }

  // Test the deleteRole operation with a valid options model parameter
  @Test
  public void testDeleteRoleWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteRolePath = "/v2/roles/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteRoleOptions model
    DeleteRoleOptions deleteRoleOptionsModel = new DeleteRoleOptions.Builder()
      .roleId("testString")
      .build();

    // Invoke deleteRole() with a valid options model and verify the result
    Response<Void> response = iamPolicyManagementService.deleteRole(deleteRoleOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteRolePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteRole operation with and without retries enabled
  @Test
  public void testDeleteRoleWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testDeleteRoleWOptions();

    iamPolicyManagementService.disableRetries();
    testDeleteRoleWOptions();
  }

  // Test the deleteRole operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRoleNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.deleteRole(null).execute();
  }

  // Test the v2ListPolicies operation with a valid options model parameter
  @Test
  public void testV2ListPoliciesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"policies\": [{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subject\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"control\": {\"grant\": {\"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}]}}, \"resource\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"pattern\": \"pattern\", \"rule\": {\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}]}";
    String v2ListPoliciesPath = "/v2/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the V2ListPoliciesOptions model
    V2ListPoliciesOptions v2ListPoliciesOptionsModel = new V2ListPoliciesOptions.Builder()
      .accountId("testString")
      .acceptLanguage("default")
      .iamId("testString")
      .accessGroupId("testString")
      .type("access")
      .serviceType("service")
      .serviceName("testString")
      .serviceGroupId("testString")
      .format("include_last_permit")
      .state("active")
      .build();

    // Invoke v2ListPolicies() with a valid options model and verify the result
    Response<V2PolicyList> response = iamPolicyManagementService.v2ListPolicies(v2ListPoliciesOptionsModel).execute();
    assertNotNull(response);
    V2PolicyList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, v2ListPoliciesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("iam_id"), "testString");
    assertEquals(query.get("access_group_id"), "testString");
    assertEquals(query.get("type"), "access");
    assertEquals(query.get("service_type"), "service");
    assertEquals(query.get("service_name"), "testString");
    assertEquals(query.get("service_group_id"), "testString");
    assertEquals(query.get("format"), "include_last_permit");
    assertEquals(query.get("state"), "active");
  }

  // Test the v2ListPolicies operation with and without retries enabled
  @Test
  public void testV2ListPoliciesWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testV2ListPoliciesWOptions();

    iamPolicyManagementService.disableRetries();
    testV2ListPoliciesWOptions();
  }

  // Test the v2ListPolicies operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2ListPoliciesNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.v2ListPolicies(null).execute();
  }

  // Test the v2CreatePolicy operation with a valid options model parameter
  @Test
  public void testV2CreatePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subject\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"control\": {\"grant\": {\"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}]}}, \"resource\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"pattern\": \"pattern\", \"rule\": {\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String v2CreatePolicyPath = "/v2/policies";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the PolicyRole model
    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();

    // Construct an instance of the V2PolicyBaseControlGrant model
    V2PolicyBaseControlGrant v2PolicyBaseControlGrantModel = new V2PolicyBaseControlGrant.Builder()
      .roles(java.util.Arrays.asList(policyRoleModel))
      .build();

    // Construct an instance of the V2PolicyBaseControl model
    V2PolicyBaseControl v2PolicyBaseControlModel = new V2PolicyBaseControl.Builder()
      .grant(v2PolicyBaseControlGrantModel)
      .build();

    // Construct an instance of the V2PolicyAttribute model
    V2PolicyAttribute v2PolicyAttributeModel = new V2PolicyAttribute.Builder()
      .key("testString")
      .operator("testString")
      .value("testString")
      .build();

    // Construct an instance of the V2PolicyBaseSubject model
    V2PolicyBaseSubject v2PolicyBaseSubjectModel = new V2PolicyBaseSubject.Builder()
      .attributes(java.util.Arrays.asList(v2PolicyAttributeModel))
      .build();

    // Construct an instance of the V2PolicyBaseResource model
    V2PolicyBaseResource v2PolicyBaseResourceModel = new V2PolicyBaseResource.Builder()
      .attributes(java.util.Arrays.asList(v2PolicyAttributeModel))
      .build();

    // Construct an instance of the V2PolicyBaseRuleV2PolicyAttribute model
    V2PolicyBaseRuleV2PolicyAttribute v2PolicyBaseRuleModel = new V2PolicyBaseRuleV2PolicyAttribute.Builder()
      .key("testString")
      .operator("testString")
      .value("testString")
      .build();

    // Construct an instance of the V2CreatePolicyOptions model
    V2CreatePolicyOptions v2CreatePolicyOptionsModel = new V2CreatePolicyOptions.Builder()
      .type("testString")
      .control(v2PolicyBaseControlModel)
      .description("testString")
      .subject(v2PolicyBaseSubjectModel)
      .resource(v2PolicyBaseResourceModel)
      .pattern("testString")
      .rule(v2PolicyBaseRuleModel)
      .acceptLanguage("default")
      .build();

    // Invoke v2CreatePolicy() with a valid options model and verify the result
    Response<V2Policy> response = iamPolicyManagementService.v2CreatePolicy(v2CreatePolicyOptionsModel).execute();
    assertNotNull(response);
    V2Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, v2CreatePolicyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the v2CreatePolicy operation with and without retries enabled
  @Test
  public void testV2CreatePolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testV2CreatePolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testV2CreatePolicyWOptions();
  }

  // Test the v2CreatePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2CreatePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.v2CreatePolicy(null).execute();
  }

  // Test the v2UpdatePolicy operation with a valid options model parameter
  @Test
  public void testV2UpdatePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subject\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"control\": {\"grant\": {\"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}]}}, \"resource\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"pattern\": \"pattern\", \"rule\": {\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String v2UpdatePolicyPath = "/v2/policies/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the PolicyRole model
    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();

    // Construct an instance of the V2PolicyBaseControlGrant model
    V2PolicyBaseControlGrant v2PolicyBaseControlGrantModel = new V2PolicyBaseControlGrant.Builder()
      .roles(java.util.Arrays.asList(policyRoleModel))
      .build();

    // Construct an instance of the V2PolicyBaseControl model
    V2PolicyBaseControl v2PolicyBaseControlModel = new V2PolicyBaseControl.Builder()
      .grant(v2PolicyBaseControlGrantModel)
      .build();

    // Construct an instance of the V2PolicyAttribute model
    V2PolicyAttribute v2PolicyAttributeModel = new V2PolicyAttribute.Builder()
      .key("testString")
      .operator("testString")
      .value("testString")
      .build();

    // Construct an instance of the V2PolicyBaseSubject model
    V2PolicyBaseSubject v2PolicyBaseSubjectModel = new V2PolicyBaseSubject.Builder()
      .attributes(java.util.Arrays.asList(v2PolicyAttributeModel))
      .build();

    // Construct an instance of the V2PolicyBaseResource model
    V2PolicyBaseResource v2PolicyBaseResourceModel = new V2PolicyBaseResource.Builder()
      .attributes(java.util.Arrays.asList(v2PolicyAttributeModel))
      .build();

    // Construct an instance of the V2PolicyBaseRuleV2PolicyAttribute model
    V2PolicyBaseRuleV2PolicyAttribute v2PolicyBaseRuleModel = new V2PolicyBaseRuleV2PolicyAttribute.Builder()
      .key("testString")
      .operator("testString")
      .value("testString")
      .build();

    // Construct an instance of the V2UpdatePolicyOptions model
    V2UpdatePolicyOptions v2UpdatePolicyOptionsModel = new V2UpdatePolicyOptions.Builder()
      .policyId("testString")
      .ifMatch("testString")
      .type("testString")
      .control(v2PolicyBaseControlModel)
      .description("testString")
      .subject(v2PolicyBaseSubjectModel)
      .resource(v2PolicyBaseResourceModel)
      .pattern("testString")
      .rule(v2PolicyBaseRuleModel)
      .build();

    // Invoke v2UpdatePolicy() with a valid options model and verify the result
    Response<V2Policy> response = iamPolicyManagementService.v2UpdatePolicy(v2UpdatePolicyOptionsModel).execute();
    assertNotNull(response);
    V2Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, v2UpdatePolicyPath);
    // Verify header parameters
    assertEquals(request.getHeader("If-Match"), "testString");
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the v2UpdatePolicy operation with and without retries enabled
  @Test
  public void testV2UpdatePolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testV2UpdatePolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testV2UpdatePolicyWOptions();
  }

  // Test the v2UpdatePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2UpdatePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.v2UpdatePolicy(null).execute();
  }

  // Test the v2GetPolicy operation with a valid options model parameter
  @Test
  public void testV2GetPolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subject\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"control\": {\"grant\": {\"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}]}}, \"resource\": {\"attributes\": [{\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}]}, \"pattern\": \"pattern\", \"rule\": {\"key\": \"key\", \"operator\": \"operator\", \"value\": \"anyValue\"}, \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"active\"}";
    String v2GetPolicyPath = "/v2/policies/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the V2GetPolicyOptions model
    V2GetPolicyOptions v2GetPolicyOptionsModel = new V2GetPolicyOptions.Builder()
      .policyId("testString")
      .build();

    // Invoke v2GetPolicy() with a valid options model and verify the result
    Response<V2Policy> response = iamPolicyManagementService.v2GetPolicy(v2GetPolicyOptionsModel).execute();
    assertNotNull(response);
    V2Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, v2GetPolicyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the v2GetPolicy operation with and without retries enabled
  @Test
  public void testV2GetPolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testV2GetPolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testV2GetPolicyWOptions();
  }

  // Test the v2GetPolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2GetPolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.v2GetPolicy(null).execute();
  }

  // Test the v2DeletePolicy operation with a valid options model parameter
  @Test
  public void testV2DeletePolicyWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String v2DeletePolicyPath = "/v2/policies/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the V2DeletePolicyOptions model
    V2DeletePolicyOptions v2DeletePolicyOptionsModel = new V2DeletePolicyOptions.Builder()
      .policyId("testString")
      .build();

    // Invoke v2DeletePolicy() with a valid options model and verify the result
    Response<Void> response = iamPolicyManagementService.v2DeletePolicy(v2DeletePolicyOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, v2DeletePolicyPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the v2DeletePolicy operation with and without retries enabled
  @Test
  public void testV2DeletePolicyWRetries() throws Throwable {
    iamPolicyManagementService.enableRetries(4, 30);
    testV2DeletePolicyWOptions();

    iamPolicyManagementService.disableRetries();
    testV2DeletePolicyWOptions();
  }

  // Test the v2DeletePolicy operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2DeletePolicyNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    iamPolicyManagementService.v2DeletePolicy(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    iamPolicyManagementService = null;
  }

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv()
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    iamPolicyManagementService = IamPolicyManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    iamPolicyManagementService.setServiceUrl(url);
  }
}