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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreateRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CustomRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeletePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.DeleteRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetPolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.GetRoleOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListRolesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicySubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleList;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.SubjectAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdateRoleOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Below are examples on how to use IAM Policy Management service
 *
 * The following environment variables are assumed to be defined when running examples below:
 *
 * IAM_POLICY_MANAGEMENT_URL=https://iam.cloud.ibm.com
 * IAM_POLICY_MANAGEMENT_AUTH_TYPE=iam
 * IAM_POLICY_MANAGEMENT_AUTH_URL=https://iam.cloud.ibm.com/identity/token
 * IAM_POLICY_MANAGEMENT_APIKEY= <YOUR_APIKEY>
 * IAM_POLICY_MANAGEMENT_TEST_ACCOUNT_ID= <YOUR_ACCOUNT_ID>
 *
 * Alternatively, above envirnmonet variables can be placed in a "credentials" file and then:
 * export IBM_CREDENTIALS_FILE=<name of credentials file>
 *
 */

public class IamPolicyManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamPolicyManagementExamples.class);
  protected IamPolicyManagementExamples() { }

  private static Random random = new Random();
  private static final String TEST_UNIQUE_ID = String.valueOf(random.nextInt(100000));
  private static final String TEST_USER_PREFIX = "IBMid-SDKJava";
  private static final String TEST_USER_ID = TEST_USER_PREFIX + TEST_UNIQUE_ID;
  private static final String TEST_SERVICE_NAME = "iam-groups";
  private static String testAccountId = null;
  private static String testPolicyId = null;
  private static String testPolicyEtag = null;
  private static String testCustomRoleId = null;
  private static String testCustomRoleEtag = null;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_policy_management.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IamPolicyManagement service = IamPolicyManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IamPolicyManagement.DEFAULT_SERVICE_NAME);
    testAccountId = config.get("TEST_ACCOUNT_ID");

    try {
      // begin-create_policy
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

      ResourceAttribute resourceAttributeResource = new ResourceAttribute.Builder()
              .name("resource")
              .value("SDK-Java-Test")
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
                      resourceAttributeService, resourceAttributeResource)))
              .tags(new ArrayList<ResourceTag>(Arrays.asList(resourceAttributeTag)))
              .build();

      PolicyRole policyRoleModel = new PolicyRole.Builder()
              .roleId("crn:v1:bluemix:public:iam::::role:Viewer")
              .build();

      PolicySubject policySubjectModel = new PolicySubject.Builder()
              .attributes(new ArrayList<SubjectAttribute>(Arrays.asList(subjectAttributeModel)))
              .build();

      CreatePolicyOptions options = new CreatePolicyOptions.Builder()
              .type("access")
              .subjects(Arrays.asList(policySubjectModel))
              .roles(Arrays.asList(policyRoleModel))
              .resources(Arrays.asList(policyResourceModel))
              .build();

      Response<Policy> response = service.createPolicy(options).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-create_policy

      testPolicyId = policy.getId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_policy
      GetPolicyOptions options = new GetPolicyOptions.Builder()
              .policyId(testPolicyId)
              .build();

      Response<Policy> response = service.getPolicy(options).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-get_policy

      testPolicyEtag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_policy
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

      ResourceAttribute resourceAttributeResource = new ResourceAttribute.Builder()
              .name("resource")
              .value("SDK-Java-Test")
              .operator("stringEquals")
              .build();

      SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
              .name("iam_id")
              .value(TEST_USER_ID)
              .build();

      PolicyResource policyResourceModel = new PolicyResource.Builder()
              .attributes(new ArrayList<ResourceAttribute>(Arrays.asList(resourceAttributeAccount,
                      resourceAttributeService, resourceAttributeResource)))
              .build();

      PolicyRole policyRoleModel = new PolicyRole.Builder()
              .roleId("crn:v1:bluemix:public:iam::::role:Editor")
              .build();

      PolicySubject policySubjectModel = new PolicySubject.Builder()
              .attributes(new ArrayList<SubjectAttribute>(Arrays.asList(subjectAttributeModel)))
              .build();

      UpdatePolicyOptions options = new UpdatePolicyOptions.Builder()
              .policyId(testPolicyId)
              .ifMatch(testPolicyEtag)
              .type("access")
              .subjects(new ArrayList<PolicySubject>(Arrays.asList(policySubjectModel)))
              .roles(new ArrayList<PolicyRole>(Arrays.asList(policyRoleModel)))
              .resources(new ArrayList<PolicyResource>(Arrays.asList(policyResourceModel)))
              .build();

      Response<Policy> response = service.updatePolicy(options).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-update_policy
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_policies
      ListPoliciesOptions options = new ListPoliciesOptions.Builder()
              .accountId(testAccountId)
              .format("include_last_permit")
              .build();

      Response<PolicyList> response = service.listPolicies(options).execute();
      PolicyList policyList = response.getResult();

      System.out.println(policyList);
      // end-list_policies
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_policy
      DeletePolicyOptions options = new DeletePolicyOptions.Builder()
              .policyId(testPolicyId)
              .build();

      service.deletePolicy(options).execute();
      // end-delete_policy
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_role
      CreateRoleOptions options = new CreateRoleOptions.Builder()
              .accountId(testAccountId)
              .name("ExampleRoleIAMGroups")
              .displayName("IAM Groups read access")
              .serviceName(TEST_SERVICE_NAME)
              .actions(Arrays.asList("iam-groups.groups.read"))
              .build();

      Response<CustomRole> response = service.createRole(options).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);
      // end-create_role

      testCustomRoleId = customRole.getId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_role
      GetRoleOptions options = new GetRoleOptions.Builder()
              .roleId(testCustomRoleId)
              .build();

      Response<CustomRole> response = service.getRole(options).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);
      // end-get_role

      testCustomRoleEtag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_role
      List<String> updatedRoleId = Arrays.asList("iam-groups.groups.read", "iam-groups.groups.list");
      UpdateRoleOptions options = new UpdateRoleOptions.Builder()
              .roleId(testCustomRoleId)
              .ifMatch(testCustomRoleEtag)
              .actions(updatedRoleId)
              .build();

      Response<CustomRole> response = service.updateRole(options).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);
      // end-update_role
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_roles
      ListRolesOptions options = new ListRolesOptions.Builder()
              .accountId(testAccountId)
              .build();

      Response<RoleList> response = service.listRoles(options).execute();
      RoleList roleList = response.getResult();

      System.out.println(roleList);
      // end-list_roles
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_role
      DeleteRoleOptions deleteRoleOptions = new DeleteRoleOptions.Builder()
        .roleId(testCustomRoleId)
        .build();

      service.deleteRole(deleteRoleOptions).execute();
      // end-delete_role
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
