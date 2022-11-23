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

package com.ibm.cloud.platform_services.iam_policy_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the IamPolicyManagement service.
 */
public class IamPolicyManagementIT extends SdkIntegrationTestBase {

    IamPolicyManagement service = null;
    Random random = new Random();

    private final String TEST_UNIQUE_ID = String.valueOf(random.nextInt(100000));
    private static final String TEST_USER_PREFIX = "IBMid-SDKJava";
    private final String TEST_USER_ID = TEST_USER_PREFIX + TEST_UNIQUE_ID;
    private static final String HEADER_ETAG = "ETag";
    private static final String TEST_VIEW_ROLE_CRN = "crn:v1:bluemix:public:iam::::role:Viewer";
    private static final String TEST_EDITOR_ROLE_CRN = "crn:v1:bluemix:public:iam::::role:Editor";
    private static final String TEST_SERVICE_NAME = "iam-groups";
    private static final String POLICY_TYPE = "access";

    String testAccountId = null;
    String testPolicyId = null;
    String testPolicyEtag = null;
    String testV2PolicyId = null;
    String testV2PolicyEtag = null;

    private static final String testCustomRoleNamePrefix = "TestJavaNode";
    private final String testCustomRoleName = testCustomRoleNamePrefix + TEST_UNIQUE_ID;
    private final String testCustomRoleDisplayName = "SDK " + testCustomRoleName;
    private final String testCustomRoleDescription = "SDK " + testCustomRoleName;
    private final List<String> testCustomRoleActions = Arrays.asList("iam-groups.groups.read");

    String testCustomRoleId = null;
    String testCustomRoleEtag = null;

    @Override
    public String getConfigFilename() {
        return "../../iam_policy_management.env";
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

        // Load up the config properties for this service.
        Map<String, String> config = CredentialUtils.getServiceProperties(IamPolicyManagement.DEFAULT_SERVICE_NAME);

        // Retrieve our test-specific properties.
        testAccountId = config.get("TEST_ACCOUNT_ID");
        assertNotNull(testAccountId);

        // Construct the service from our external configuration.
        service = IamPolicyManagement.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        log("Using Account Id: " + testAccountId);
        log("Using Service URL: " + service.getServiceUrl());
    }

    @Test
    public void testCreateAccessPolicy() {

        ResourceAttribute resourceAttributeAccount = new ResourceAttribute.Builder()
          .name("accountId")
          .value(testAccountId)
          .operator("stringEquals")
          .build();

        ResourceAttribute resourceAttributeService = new ResourceAttribute.Builder()
          .name("serviceType")
          .value("service")
          .operator("stringEquals")
          .build();

        ResourceTag resourceAttributeTag = new ResourceTag.Builder()
                .name("project")
                .value("prototype")
                .operator("stringEquals")
                .build();

        SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
          .name("iam_id")
          .value(TEST_USER_ID)
          .build();

        PolicyResource policyResourceModel = new PolicyResource.Builder()
          .attributes(new ArrayList<ResourceAttribute>(Arrays.asList(resourceAttributeAccount,
            resourceAttributeService)))
          .tags(new ArrayList<ResourceTag>(Arrays.asList(resourceAttributeTag)))
          .build();

        PolicyRole policyRoleModel = new PolicyRole.Builder()
          .roleId(TEST_VIEW_ROLE_CRN)
          .build();

        PolicySubject policySubjectModel = new PolicySubject.Builder()
          .attributes(new ArrayList<SubjectAttribute>(Arrays.asList(subjectAttributeModel)))
          .build();

        CreatePolicyOptions options = new CreatePolicyOptions.Builder()
          .type(POLICY_TYPE)
          .subjects(Arrays.asList(policySubjectModel))
          .roles(Arrays.asList(policyRoleModel))
          .resources(Arrays.asList(policyResourceModel))
          .build();

        Response<Policy> response = service.createPolicy(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        Policy result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getType(), POLICY_TYPE);
        assertEquals(result.getSubjects(), new ArrayList<PolicySubject>(Arrays.asList(policySubjectModel)));
        assertEquals(result.getResources(), new ArrayList<PolicyResource>(Arrays.asList(policyResourceModel)));
        assertEquals(result.getRoles().get(0).roleId(), policyRoleModel.roleId());

        testPolicyId = result.getId();
    }

    @Test(dependsOnMethods = {"testCreateAccessPolicy"})
    public void testGetAccessPolicy() {
        assertNotNull(testPolicyId);

        GetPolicyOptions options = new GetPolicyOptions.Builder()
                .policyId(testPolicyId)
                .build();

        Response<Policy> response = service.getPolicy(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Policy result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testPolicyId);


        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testPolicyEtag = values.get(0);
    }

    @Test(dependsOnMethods = {"testGetAccessPolicy"})
    public void testUpdateAccessPolicy() {
        assertNotNull(testPolicyId);
        assertNotNull(testPolicyEtag);

        ResourceAttribute resourceAttributeAccount = new ResourceAttribute.Builder()
          .name("accountId")
          .value(testAccountId)
          .operator("stringEquals")
          .build();

        ResourceAttribute resourceAttributeService = new ResourceAttribute.Builder()
          .name("serviceName")
          .value(TEST_SERVICE_NAME)
          .operator("stringEquals")
          .build();

        SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
          .name("iam_id")
          .value(TEST_USER_ID)
          .build();

        PolicyResource policyResourceModel = new PolicyResource.Builder()
          .attributes(new ArrayList<ResourceAttribute>(Arrays.asList(resourceAttributeAccount,
            resourceAttributeService)))
          .build();

        PolicyRole policyRoleModel = new PolicyRole.Builder()
          .roleId(TEST_EDITOR_ROLE_CRN)
          .build();

        PolicySubject policySubjectModel = new PolicySubject.Builder()
          .attributes(new ArrayList<SubjectAttribute>(Arrays.asList(subjectAttributeModel)))
          .build();

        UpdatePolicyOptions options = new UpdatePolicyOptions.Builder()
                .policyId(testPolicyId)
                .ifMatch(testPolicyEtag)
                .type(POLICY_TYPE)
                .subjects(new ArrayList<PolicySubject>(Arrays.asList(policySubjectModel)))
                .roles(new ArrayList<PolicyRole>(Arrays.asList(policyRoleModel)))
                .resources(new ArrayList<PolicyResource>(Arrays.asList(policyResourceModel)))
                .build();

        Response<Policy> response = service.updatePolicy(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Policy result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testPolicyId);
        assertEquals(result.getType(), POLICY_TYPE);
        assertEquals(result.getSubjects(), new ArrayList<PolicySubject>(Arrays.asList(policySubjectModel)));
        assertEquals(result.getResources(), new ArrayList<PolicyResource>(Arrays.asList(policyResourceModel)));
        assertEquals(result.getRoles().get(0).roleId(), policyRoleModel.roleId());

        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testPolicyEtag = values.get(0);
    }

    @Test(dependsOnMethods = {"testUpdateAccessPolicy"})
    public void testPatchPolicy() {
        assertNotNull(testPolicyId);
        assertNotNull(testPolicyEtag);

        PatchPolicyOptions patchPolicyOptions = new PatchPolicyOptions.Builder()
                .policyId(testPolicyId)
                .ifMatch(testPolicyEtag)
                .state("active")
                .build();

        Response<Policy> response = service.patchPolicy(patchPolicyOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        Policy policyResult = response.getResult();
        assertNotNull(policyResult);
        assertEquals(policyResult.getId(), testPolicyId);
        assertEquals(policyResult.getType(), POLICY_TYPE);
        assertEquals(policyResult.getState(), "active");
    }

    @Test(dependsOnMethods = {"testPatchPolicy"})
    public void testListAccessPolicies() throws Exception, InterruptedException {
        assertNotNull(testPolicyId);

        ListPoliciesOptions options = new ListPoliciesOptions.Builder()
                .accountId(testAccountId)
                .build();

        Response<PolicyList> response = service.listPolicies(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        PolicyList result = response.getResult();
        assertNotNull(result);

        // Confirm the test policy is present
        boolean foundTestPolicy = false;
        for (Policy policy : result.getPolicies()) {
            if (testPolicyId.equals(policy.getId())) {
                foundTestPolicy = true;
                break;
            }
        }
        assertTrue(foundTestPolicy);
    }

    @Test
    public void testCreateV2AccessPolicy() {

        V2PolicyAttribute resourceAttributeAccount = new V2PolicyAttribute.Builder()
          .key("accountId")
          .value(testAccountId)
          .operator("stringEquals")
          .build();

        V2PolicyAttribute resourceAttributeService = new V2PolicyAttribute.Builder()
          .key("serviceType")
          .value("service")
          .operator("stringEquals")
          .build();

        V2PolicyAttribute subjectAttributeModel = new V2PolicyAttribute.Builder()
          .key("iam_id")
          .value(TEST_USER_ID)
          .operator("stringEquals")
          .build();

        V2PolicyBaseResource policyResourceModel = new V2PolicyBaseResource.Builder()
          .attributes(new ArrayList<V2PolicyAttribute>(Arrays.asList(resourceAttributeAccount,
            resourceAttributeService)))
          .build();

        V2PolicyBaseSubject policySubjectModel = new V2PolicyBaseSubject.Builder()
          .attributes(new ArrayList<V2PolicyAttribute>(Arrays.asList(subjectAttributeModel)))
          .build();

        PolicyRole policyRoleModel = new PolicyRole.Builder()
          .roleId(TEST_VIEW_ROLE_CRN)
          .build();
        
        V2PolicyBaseControlGrant policyGrantModel = new V2PolicyBaseControlGrant.Builder()
          .roles(Arrays.asList(policyRoleModel))
          .build();

        V2PolicyBaseControl policyControlModel = new V2PolicyBaseControl.Builder()
          .grant(policyGrantModel)
          .build();

        V2CreatePolicyOptions options = new V2CreatePolicyOptions.Builder()
          .type(POLICY_TYPE)
          .subject(policySubjectModel)
          .control(policyControlModel)
          .resource(policyResourceModel)
          .build();

        Response<V2Policy> response = service.v2CreatePolicy(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        V2Policy result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getType(), POLICY_TYPE);
        assertEquals(result.getSubject(), policySubjectModel);
        assertEquals(result.getResource(), policyResourceModel);
        assertEquals(result.getControl(), policyControlModel);

        testV2PolicyId = result.getId();
    }

    @Test(dependsOnMethods = {"testCreateV2AccessPolicy"})
    public void testGetV2AccessPolicy() {
        assertNotNull(testV2PolicyId);

        V2GetPolicyOptions options = new V2GetPolicyOptions.Builder()
                .policyId(testV2PolicyId)
                .build();

        Response<V2Policy> response = service.v2GetPolicy(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        V2Policy result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testV2PolicyId);


        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testV2PolicyEtag = values.get(0);
    }

    @Test(dependsOnMethods = {"testGetV2AccessPolicy"})
    public void testUpdateV2AccessPolicy() {
        assertNotNull(testV2PolicyId);
        assertNotNull(testV2PolicyEtag);

        V2PolicyAttribute resourceAttributeAccount = new V2PolicyAttribute.Builder()
          .key("accountId")
          .value(testAccountId)
          .operator("stringEquals")
          .build();

        V2PolicyAttribute resourceAttributeService = new V2PolicyAttribute.Builder()
          .key("serviceName")
          .value(TEST_SERVICE_NAME)
          .operator("stringEquals")
          .build();

        V2PolicyAttribute subjectAttributeModel = new V2PolicyAttribute.Builder()
          .key("iam_id")
          .value(TEST_USER_ID)
          .operator("stringEquals")
          .build();

        V2PolicyBaseResource policyResourceModel = new V2PolicyBaseResource.Builder()
          .attributes(new ArrayList<V2PolicyAttribute>(Arrays.asList(resourceAttributeAccount,
            resourceAttributeService)))
          .build();

        V2PolicyBaseSubject policySubjectModel = new V2PolicyBaseSubject.Builder()
          .attributes(new ArrayList<V2PolicyAttribute>(Arrays.asList(subjectAttributeModel)))
          .build();
        
        PolicyRole policyRoleModel = new PolicyRole.Builder()
          .roleId(TEST_EDITOR_ROLE_CRN)
          .build();

        V2PolicyBaseControlGrant policyGrantModel = new V2PolicyBaseControlGrant.Builder()
          .roles(Arrays.asList(policyRoleModel))
          .build();

        V2PolicyBaseControl policyControlModel = new V2PolicyBaseControl.Builder()
          .grant(policyGrantModel)
          .build();

        V2UpdatePolicyOptions options = new V2UpdatePolicyOptions.Builder()
                .policyId(testV2PolicyId)
                .ifMatch(testV2PolicyEtag)
                .type(POLICY_TYPE)
                .subject(policySubjectModel)
                .control(policyControlModel)
                .resource(policyResourceModel)
                .build();

        Response<V2Policy> response = service.v2UpdatePolicy(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        V2Policy result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testV2PolicyId);
        assertEquals(result.getType(), POLICY_TYPE);
        assertEquals(result.getSubject(), policySubjectModel);
        assertEquals(result.getResource(), policyResourceModel);
        assertEquals(result.getControl(), policyControlModel);

        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testV2PolicyEtag = values.get(0);
    }

    @Test
    public void testCreateCustomRole() {

        CreateRoleOptions options = new CreateRoleOptions.Builder()
          .accountId(testAccountId)
          .name(testCustomRoleName)
          .displayName(testCustomRoleDisplayName)
          .description(testCustomRoleDescription)
          .serviceName(TEST_SERVICE_NAME)
          .actions(testCustomRoleActions)
          .build();

        Response<CustomRole> response = service.createRole(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);

        CustomRole result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), testCustomRoleName);
        assertEquals(result.getDisplayName(), testCustomRoleDisplayName);
        assertEquals(result.getDescription(), testCustomRoleDescription);
        assertEquals(result.getServiceName(), TEST_SERVICE_NAME);
        assertEquals(result.getActions(), testCustomRoleActions);

        testCustomRoleId = result.getId();
    }

    @Test(dependsOnMethods = {"testCreateCustomRole"})
    public void testGetCustomRole() {
        assertNotNull(testCustomRoleId);

        GetRoleOptions options = new GetRoleOptions.Builder()
                .roleId(testCustomRoleId)
                .build();

        Response<CustomRole> response = service.getRole(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        CustomRole result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getId(), testCustomRoleId);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), testCustomRoleName);
        assertEquals(result.getDisplayName(), testCustomRoleDisplayName);
        assertEquals(result.getDescription(), testCustomRoleDescription);
        assertEquals(result.getServiceName(), TEST_SERVICE_NAME);
        assertEquals(result.getActions(), testCustomRoleActions);


        List<String> values = response.getHeaders().values(HEADER_ETAG);
        assertNotNull(values);
        testCustomRoleEtag = values.get(0);
    }

    @Test(dependsOnMethods = {"testGetCustomRole"})
    public void testUpdateCustomRole() {
        assertNotNull(testCustomRoleId);
        assertNotNull(testCustomRoleEtag);

        String updatedRoleDescription = "Updated description";
        UpdateRoleOptions options = new UpdateRoleOptions.Builder()
          .roleId(testCustomRoleId)
          .ifMatch(testCustomRoleEtag)
          .displayName(testCustomRoleDisplayName)
          .description(updatedRoleDescription)
          .actions(testCustomRoleActions)
          .build();

        Response<CustomRole> response = service.updateRole(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        CustomRole result = response.getResult();
        assertNotNull(result);
        assertEquals(result.getAccountId(), testAccountId);
        assertEquals(result.getName(), testCustomRoleName);
        assertEquals(result.getDisplayName(), testCustomRoleDisplayName);
        assertEquals(result.getDescription(), updatedRoleDescription);
        assertEquals(result.getServiceName(), TEST_SERVICE_NAME);
        assertEquals(result.getActions(), testCustomRoleActions);
    }

    @Test(dependsOnMethods = {"testUpdateCustomRole"})
    public void testListRoles() throws Exception, InterruptedException {
        assertNotNull(testCustomRoleId);
        ListRolesOptions options = new ListRolesOptions.Builder()
                .accountId(testAccountId)
                .build();

        Response<RoleList> response = service.listRoles(options).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        RoleList result = response.getResult();
        assertNotNull(result);

        // Confirm the test role is present
        boolean foundTestRole = false;
        for (CustomRole role : result.getCustomRoles()) {
            if (testCustomRoleId.equals(role.getId())) {
                foundTestRole = true;
                break;
            }
        }
        assertTrue(foundTestRole);
    }

    @AfterClass
    public void tearDown() {
        // Delete all the access policies and roles created during the test.

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date now = new Date();
        final int FIVE_MINUTES = 5 * 60 * 1000;
        long fiveMinutesAgo = now.getTime() - FIVE_MINUTES;

        // List all policies in the account
        ListPoliciesOptions policyOptions = new ListPoliciesOptions.Builder()
                .accountId(testAccountId)
                .build();

        Response<PolicyList> policyResponse = service.listPolicies(policyOptions).execute();
        assertNotNull(policyResponse);
        assertEquals(policyResponse.getStatusCode(), 200);

        // Iterate across the policies
        PolicyList policyList = policyResponse.getResult();
        assertNotNull(policyList);
        for (Policy policy : policyList.getPolicies()) {

            // Delete the test policy or any test polcies older than 5 minutes
            if (policy.getSubjects().get(0).attributes().get(0).value().contains(TEST_USER_PREFIX)) {
                long createdAt = policy.getCreatedAt().getTime();

                // Delete v2 policy
                if (policy.getHref().contains("v2/policies")) {
                  if ((testV2PolicyId != null || testV2PolicyId.equals(policy.getId())) || createdAt < fiveMinutesAgo) {
                      V2DeletePolicyOptions deleteOptions = new V2DeletePolicyOptions.Builder()
                              .policyId(policy.getId()).build();
                      Response<Void> deleteResponse = service.v2DeletePolicy(deleteOptions).execute();
                      assertNotNull(deleteResponse);
                      assertEquals(deleteResponse.getStatusCode(), 204);
                      log("Cleanup test policy id: " + policy.getId());
                  }
                } else {
                  // Delete v1 policy
                  if ((testPolicyId != null || testPolicyId.equals(policy.getId())) || createdAt < fiveMinutesAgo) {
                      DeletePolicyOptions deleteOptions = new DeletePolicyOptions.Builder()
                              .policyId(policy.getId()).build();
                      Response<Void> deleteResponse = service.deletePolicy(deleteOptions).execute();
                      assertNotNull(deleteResponse);
                      assertEquals(deleteResponse.getStatusCode(), 204);
                      log("Cleanup test policy id: " + policy.getId());
                  }
                }
            }
        }

        ListRolesOptions roleOptions = new ListRolesOptions.Builder()
                .accountId(testAccountId)
                .build();

        Response<RoleList> roleResponse = service.listRoles(roleOptions).execute();
        assertNotNull(roleResponse);
        assertEquals(roleResponse.getStatusCode(), 200);

        RoleList rolesList = roleResponse.getResult();
        assertNotNull(rolesList);

        // Iterate across the list of custom roles
        for (CustomRole role : rolesList.getCustomRoles()) {
          if (role.getName().contains(testCustomRoleNamePrefix)) {
              long createdAt = role.getCreatedAt().getTime();

              // delete the role or any test role older than 5 minutes
              if ((testCustomRoleId != null && testCustomRoleId.equals(role.getId())) || createdAt < fiveMinutesAgo) {
                  DeleteRoleOptions deleteOptions = new DeleteRoleOptions.Builder()
                    .roleId(role.getId()).build();

                  Response<Void> deleteResponse = service.deleteRole(deleteOptions).execute();
                  assertNotNull(deleteResponse);
                  assertEquals(deleteResponse.getStatusCode(), 204);
                  log("Cleanup test role id: " + role.getId());
              }
          }
        }
    }
}
