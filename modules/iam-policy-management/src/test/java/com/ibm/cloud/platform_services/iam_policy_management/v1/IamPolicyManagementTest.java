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
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
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
 * Unit test class for the IamPolicyManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class IamPolicyManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected IamPolicyManagement iamPolicyManagementService;

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

    iamPolicyManagementService = IamPolicyManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    iamPolicyManagementService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new IamPolicyManagement(serviceName, null);
  }

  @Test
  public void testListPoliciesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"policies\": [{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"state\"}]}";
    String listPoliciesPath = "/v1/policies";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListPoliciesOptions model
    ListPoliciesOptions listPoliciesOptionsModel = new ListPoliciesOptions.Builder()
    .accountId("testString")
    .acceptLanguage("testString")
    .iamId("testString")
    .accessGroupId("testString")
    .type("testString")
    .serviceType("testString")
    .tagName("testString")
    .tagValue("testString")
    .sort("testString")
    .format("testString")
    .state("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PolicyList> response = iamPolicyManagementService.listPolicies(listPoliciesOptionsModel).execute();
    assertNotNull(response);
    PolicyList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("iam_id"), "testString");
    assertEquals(query.get("access_group_id"), "testString");
    assertEquals(query.get("type"), "testString");
    assertEquals(query.get("service_type"), "testString");
    assertEquals(query.get("tag_name"), "testString");
    assertEquals(query.get("tag_value"), "testString");
    assertEquals(query.get("sort"), "testString");
    assertEquals(query.get("format"), "testString");
    assertEquals(query.get("state"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listPoliciesPath);
  }

  // Test the listPolicies operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListPoliciesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.listPolicies(null).execute();
  }

  @Test
  public void testCreatePolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"state\"}";
    String createPolicyPath = "/v1/policies";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SubjectAttribute model
    SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
    .name("testString")
    .value("testString")
    .build();

    // Construct an instance of the PolicySubject model
    PolicySubject policySubjectModel = new PolicySubject.Builder()
    .attributes(new java.util.ArrayList<SubjectAttribute>(java.util.Arrays.asList(subjectAttributeModel)))
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
    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
    .tags(new java.util.ArrayList<ResourceTag>(java.util.Arrays.asList(resourceTagModel)))
    .build();

    // Construct an instance of the CreatePolicyOptions model
    CreatePolicyOptions createPolicyOptionsModel = new CreatePolicyOptions.Builder()
    .type("testString")
    .subjects(new java.util.ArrayList<PolicySubject>(java.util.Arrays.asList(policySubjectModel)))
    .roles(new java.util.ArrayList<PolicyRole>(java.util.Arrays.asList(policyRoleModel)))
    .resources(new java.util.ArrayList<PolicyResource>(java.util.Arrays.asList(policyResourceModel)))
    .description("testString")
    .acceptLanguage("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Policy> response = iamPolicyManagementService.createPolicy(createPolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
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
    assertEquals(parsedPath, createPolicyPath);
  }

  // Test the createPolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.createPolicy(null).execute();
  }

  @Test
  public void testUpdatePolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"state\"}";
    String updatePolicyPath = "/v1/policies/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SubjectAttribute model
    SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
    .name("testString")
    .value("testString")
    .build();

    // Construct an instance of the PolicySubject model
    PolicySubject policySubjectModel = new PolicySubject.Builder()
    .attributes(new java.util.ArrayList<SubjectAttribute>(java.util.Arrays.asList(subjectAttributeModel)))
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
    .attributes(new java.util.ArrayList<ResourceAttribute>(java.util.Arrays.asList(resourceAttributeModel)))
    .tags(new java.util.ArrayList<ResourceTag>(java.util.Arrays.asList(resourceTagModel)))
    .build();

    // Construct an instance of the UpdatePolicyOptions model
    UpdatePolicyOptions updatePolicyOptionsModel = new UpdatePolicyOptions.Builder()
    .policyId("testString")
    .ifMatch("testString")
    .type("testString")
    .subjects(new java.util.ArrayList<PolicySubject>(java.util.Arrays.asList(policySubjectModel)))
    .roles(new java.util.ArrayList<PolicyRole>(java.util.Arrays.asList(policyRoleModel)))
    .resources(new java.util.ArrayList<PolicyResource>(java.util.Arrays.asList(policyResourceModel)))
    .description("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Policy> response = iamPolicyManagementService.updatePolicy(updatePolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
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
    assertEquals(parsedPath, updatePolicyPath);
  }

  // Test the updatePolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdatePolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.updatePolicy(null).execute();
  }

  @Test
  public void testGetPolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"state\"}";
    String getPolicyPath = "/v1/policies/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPolicyOptions model
    GetPolicyOptions getPolicyOptionsModel = new GetPolicyOptions.Builder()
    .policyId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Policy> response = iamPolicyManagementService.getPolicy(getPolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
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
    assertEquals(parsedPath, getPolicyPath);
  }

  // Test the getPolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.getPolicy(null).execute();
  }

  @Test
  public void testDeletePolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deletePolicyPath = "/v1/policies/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeletePolicyOptions model
    DeletePolicyOptions deletePolicyOptionsModel = new DeletePolicyOptions.Builder()
    .policyId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamPolicyManagementService.deletePolicy(deletePolicyOptionsModel).execute();
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
    assertEquals(parsedPath, deletePolicyPath);
  }

  // Test the deletePolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeletePolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.deletePolicy(null).execute();
  }

  @Test
  public void testPatchPolicyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"type\": \"type\", \"description\": \"description\", \"subjects\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\"}]}], \"roles\": [{\"role_id\": \"roleId\", \"display_name\": \"displayName\", \"description\": \"description\"}], \"resources\": [{\"attributes\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}], \"tags\": [{\"name\": \"name\", \"value\": \"value\", \"operator\": \"operator\"}]}], \"href\": \"href\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"state\": \"state\"}";
    String patchPolicyPath = "/v1/policies/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PatchPolicyOptions model
    PatchPolicyOptions patchPolicyOptionsModel = new PatchPolicyOptions.Builder()
    .policyId("testString")
    .ifMatch("testString")
    .state("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Policy> response = iamPolicyManagementService.patchPolicy(patchPolicyOptionsModel).execute();
    assertNotNull(response);
    Policy responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, patchPolicyPath);
  }

  // Test the patchPolicy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPatchPolicyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.patchPolicy(null).execute();
  }

  @Test
  public void testListRolesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"custom_roles\": [{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"service_name\": \"serviceName\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}], \"service_roles\": [{\"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\"}], \"system_roles\": [{\"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\"}]}";
    String listRolesPath = "/v2/roles";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListRolesOptions model
    ListRolesOptions listRolesOptionsModel = new ListRolesOptions.Builder()
    .acceptLanguage("testString")
    .accountId("testString")
    .serviceName("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<RoleList> response = iamPolicyManagementService.listRoles(listRolesOptionsModel).execute();
    assertNotNull(response);
    RoleList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("service_name"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listRolesPath);
  }

  @Test
  public void testCreateRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"service_name\": \"serviceName\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}";
    String createRolePath = "/v2/roles";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateRoleOptions model
    CreateRoleOptions createRoleOptionsModel = new CreateRoleOptions.Builder()
    .displayName("testString")
    .actions(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .name("testString")
    .accountId("testString")
    .serviceName("testString")
    .description("testString")
    .acceptLanguage("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CustomRole> response = iamPolicyManagementService.createRole(createRoleOptionsModel).execute();
    assertNotNull(response);
    CustomRole responseObj = response.getResult();
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
    assertEquals(parsedPath, createRolePath);
  }

  // Test the createRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.createRole(null).execute();
  }

  @Test
  public void testUpdateRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"service_name\": \"serviceName\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}";
    String updateRolePath = "/v2/roles/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateRoleOptions model
    UpdateRoleOptions updateRoleOptionsModel = new UpdateRoleOptions.Builder()
    .roleId("testString")
    .ifMatch("testString")
    .displayName("testString")
    .description("testString")
    .actions(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CustomRole> response = iamPolicyManagementService.updateRole(updateRoleOptionsModel).execute();
    assertNotNull(response);
    CustomRole responseObj = response.getResult();
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
    assertEquals(parsedPath, updateRolePath);
  }

  // Test the updateRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.updateRole(null).execute();
  }

  @Test
  public void testGetRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"display_name\": \"displayName\", \"description\": \"description\", \"actions\": [\"actions\"], \"crn\": \"crn\", \"name\": \"name\", \"account_id\": \"accountId\", \"service_name\": \"serviceName\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by_id\": \"createdById\", \"last_modified_at\": \"2019-01-01T12:00:00.000Z\", \"last_modified_by_id\": \"lastModifiedById\", \"href\": \"href\"}";
    String getRolePath = "/v2/roles/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetRoleOptions model
    GetRoleOptions getRoleOptionsModel = new GetRoleOptions.Builder()
    .roleId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CustomRole> response = iamPolicyManagementService.getRole(getRoleOptionsModel).execute();
    assertNotNull(response);
    CustomRole responseObj = response.getResult();
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
    assertEquals(parsedPath, getRolePath);
  }

  // Test the getRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.getRole(null).execute();
  }

  @Test
  public void testDeleteRoleWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteRolePath = "/v2/roles/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteRoleOptions model
    DeleteRoleOptions deleteRoleOptionsModel = new DeleteRoleOptions.Builder()
    .roleId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = iamPolicyManagementService.deleteRole(deleteRoleOptionsModel).execute();
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
    assertEquals(parsedPath, deleteRolePath);
  }

  // Test the deleteRole operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteRoleNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    iamPolicyManagementService.deleteRole(null).execute();
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
    iamPolicyManagementService = null;
  }
}