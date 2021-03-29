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
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PatchPolicyOptions;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the IAM Policy Management service.
//
// The following configuration properties are assumed to be defined:
//
// IAM_POLICY_MANAGEMENT_URL=<service url>
// IAM_POLICY_MANAGEMENT_AUTH_TYPE=iam
// IAM_POLICY_MANAGEMENT_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// IAM_POLICY_MANAGEMENT_APIKEY=<YOUR_APIKEY>
// IAM_POLICY_MANAGEMENT_TEST_ACCOUNT_ID=<YOUR_ACCOUNT_ID>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of config file>
//

public class IamPolicyManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamPolicyManagementExamples.class);
  protected IamPolicyManagementExamples() { }

  private static final String EXAMPLE_USER_ID = "IBMid-user1";
  private static final String EXAMPLE_SERVICE_NAME = "iam-groups";
  private static String exampleAccountId = null;
  private static String examplePolicyId = null;
  private static String examplePolicyEtag = null;
  private static String exampleCustomRoleId = null;
  private static String exampleCustomRoleEtag = null;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../iam_policy_management.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IamPolicyManagement service = IamPolicyManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IamPolicyManagement.DEFAULT_SERVICE_NAME);
    exampleAccountId = config.get("TEST_ACCOUNT_ID");

    try {
      // begin-create_policy

      SubjectAttribute subjectAttribute = new SubjectAttribute.Builder()
              .name("iam_id")
              .value(EXAMPLE_USER_ID)
              .build();

      PolicySubject policySubjects = new PolicySubject.Builder()
              .addAttributes(subjectAttribute)
              .build();

      PolicyRole policyRoles = new PolicyRole.Builder()
              .roleId("crn:v1:bluemix:public:iam::::role:Viewer")
              .build();

      ResourceAttribute accountIdResourceAttribute = new ResourceAttribute.Builder()
              .name("accountId")
              .value(exampleAccountId)
              .operator("stringEquals")
              .build();

      ResourceAttribute serviceNameResourceAttribute = new ResourceAttribute.Builder()
              .name("serviceType")
              .value("service")
              .operator("stringEquals")
              .build();

      ResourceTag policyResourceTag = new ResourceTag.Builder()
              .name("project")
              .value("prototype")
              .operator("stringEquals")
              .build();

      PolicyResource policyResources = new PolicyResource.Builder()
              .addAttributes(accountIdResourceAttribute)
              .addAttributes(serviceNameResourceAttribute)
              .addTags(policyResourceTag)
              .build();

      CreatePolicyOptions options = new CreatePolicyOptions.Builder()
              .type("access")
              .subjects(Arrays.asList(policySubjects))
              .roles(Arrays.asList(policyRoles))
              .resources(Arrays.asList(policyResources))
              .build();

      Response<Policy> response = service.createPolicy(options).execute();
      Policy policy = response.getResult();

      System.out.println(policy);

      // end-create_policy

      examplePolicyId = policy.getId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_policy

      GetPolicyOptions options = new GetPolicyOptions.Builder()
              .policyId(examplePolicyId)
              .build();

      Response<Policy> response = service.getPolicy(options).execute();
      Policy policy = response.getResult();

      System.out.println(policy);

      // end-get_policy

      examplePolicyEtag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_policy

      SubjectAttribute subjectAttribute = new SubjectAttribute.Builder()
              .name("iam_id")
              .value(EXAMPLE_USER_ID)
              .build();

      PolicySubject policySubjects = new PolicySubject.Builder()
              .addAttributes(subjectAttribute)
              .build();

      ResourceAttribute accountIdResourceAttribute = new ResourceAttribute.Builder()
              .name("accountId")
              .value(exampleAccountId)
              .operator("stringEquals")
              .build();

      ResourceAttribute serviceNameResourceAttribute = new ResourceAttribute.Builder()
              .name("serviceType")
              .value("service")
              .operator("stringEquals")
              .build();

      ResourceTag policyResourceTag = new ResourceTag.Builder()
              .name("project")
              .value("prototype")
              .operator("stringEquals")
              .build();

      PolicyResource policyResources = new PolicyResource.Builder()
              .addAttributes(accountIdResourceAttribute)
              .addAttributes(serviceNameResourceAttribute)
              .addTags(policyResourceTag)
              .build();

      PolicyRole updatedPolicyRole = new PolicyRole.Builder()
              .roleId("crn:v1:bluemix:public:iam::::role:Editor")
              .build();

      UpdatePolicyOptions options = new UpdatePolicyOptions.Builder()
              .type("access")
              .policyId(examplePolicyId)
              .ifMatch(examplePolicyEtag)
              .subjects(new ArrayList<PolicySubject>(Arrays.asList(policySubjects)))
              .roles(new ArrayList<PolicyRole>(Arrays.asList(updatedPolicyRole)))
              .resources(new ArrayList<PolicyResource>(Arrays.asList(policyResources)))
              .build();

      Response<Policy> response = service.updatePolicy(options).execute();
      Policy policy = response.getResult();

      System.out.println(policy);

      // end-update_policy

      examplePolicyEtag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-patch_policy

      PatchPolicyOptions patchPolicyOptions = new PatchPolicyOptions.Builder()
              .policyId(examplePolicyId)
              .ifMatch(examplePolicyEtag)
              .state("active")
              .build();

      Response<Policy> response = service.patchPolicy(patchPolicyOptions).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-patch_policy
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_policies

      ListPoliciesOptions options = new ListPoliciesOptions.Builder()
              .accountId(exampleAccountId)
              .iamId(EXAMPLE_USER_ID)
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
              .policyId(examplePolicyId)
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
              .displayName("IAM Groups read access")
              .actions(Arrays.asList("iam-groups.groups.read"))
              .name("ExampleRoleIAMGroups")
              .accountId(exampleAccountId)
              .serviceName(EXAMPLE_SERVICE_NAME)
              .build();

      Response<CustomRole> response = service.createRole(options).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);

      // end-create_role

      exampleCustomRoleId = customRole.getId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_role

      GetRoleOptions options = new GetRoleOptions.Builder()
              .roleId(exampleCustomRoleId)
              .build();

      Response<CustomRole> response = service.getRole(options).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);

      // end-get_role

      exampleCustomRoleEtag = response.getHeaders().values("Etag").get(0);
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_role

      List<String> updatedRoleActions = Arrays.asList("iam-groups.groups.read", "iam-groups.groups.list");
      UpdateRoleOptions options = new UpdateRoleOptions.Builder()
              .roleId(exampleCustomRoleId)
              .ifMatch(exampleCustomRoleEtag)
              .actions(updatedRoleActions)
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
              .accountId(exampleAccountId)
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

      DeleteRoleOptions options = new DeleteRoleOptions.Builder()
        .roleId(exampleCustomRoleId)
        .build();

      service.deleteRole(options).execute();

      // end-delete_role
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
