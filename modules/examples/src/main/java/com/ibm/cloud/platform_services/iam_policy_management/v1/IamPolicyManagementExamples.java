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
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdateRoleOptions;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IamPolicyManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(IamPolicyManagementExamples.class);
  protected IamPolicyManagementExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    IamPolicyManagement service = IamPolicyManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(IamPolicyManagement.DEFAULT_SERVICE_NAME);

    try {
      // begin-list_policies
      ListPoliciesOptions listPoliciesOptions = new ListPoliciesOptions.Builder()
        .accountId("testString")
        .build();

      Response<PolicyList> response = service.listPolicies(listPoliciesOptions).execute();
      PolicyList policyList = response.getResult();

      System.out.println(policyList);
      // end-list_policies
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_policy
      PolicySubject policySubjectModel = new PolicySubject.Builder()
        .build();
      PolicyRole policyRoleModel = new PolicyRole.Builder()
        .roleId("testString")
        .build();
      PolicyResource policyResourceModel = new PolicyResource.Builder()
        .build();
      CreatePolicyOptions createPolicyOptions = new CreatePolicyOptions.Builder()
        .type("testString")
        .subjects(new java.util.ArrayList<PolicySubject>(java.util.Arrays.asList(policySubjectModel)))
        .roles(new java.util.ArrayList<PolicyRole>(java.util.Arrays.asList(policyRoleModel)))
        .resources(new java.util.ArrayList<PolicyResource>(java.util.Arrays.asList(policyResourceModel)))
        .build();

      Response<Policy> response = service.createPolicy(createPolicyOptions).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-create_policy
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_policy
      PolicySubject policySubjectModel = new PolicySubject.Builder()
        .build();
      PolicyRole policyRoleModel = new PolicyRole.Builder()
        .roleId("testString")
        .build();
      PolicyResource policyResourceModel = new PolicyResource.Builder()
        .build();
      UpdatePolicyOptions updatePolicyOptions = new UpdatePolicyOptions.Builder()
        .policyId("testString")
        .ifMatch("testString")
        .type("testString")
        .subjects(new java.util.ArrayList<PolicySubject>(java.util.Arrays.asList(policySubjectModel)))
        .roles(new java.util.ArrayList<PolicyRole>(java.util.Arrays.asList(policyRoleModel)))
        .resources(new java.util.ArrayList<PolicyResource>(java.util.Arrays.asList(policyResourceModel)))
        .build();

      Response<Policy> response = service.updatePolicy(updatePolicyOptions).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-update_policy
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_policy
      GetPolicyOptions getPolicyOptions = new GetPolicyOptions.Builder()
        .policyId("testString")
        .build();

      Response<Policy> response = service.getPolicy(getPolicyOptions).execute();
      Policy policy = response.getResult();

      System.out.println(policy);
      // end-get_policy
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-list_roles
      ListRolesOptions listRolesOptions = new ListRolesOptions.Builder()
        .build();

      Response<RoleList> response = service.listRoles(listRolesOptions).execute();
      RoleList roleList = response.getResult();

      System.out.println(roleList);
      // end-list_roles
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-create_role
      CreateRoleOptions createRoleOptions = new CreateRoleOptions.Builder()
        .displayName("testString")
        .actions(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .name("testString")
        .accountId("testString")
        .serviceName("testString")
        .build();

      Response<CustomRole> response = service.createRole(createRoleOptions).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);
      // end-create_role
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_role
      UpdateRoleOptions updateRoleOptions = new UpdateRoleOptions.Builder()
        .roleId("testString")
        .ifMatch("testString")
        .build();

      Response<CustomRole> response = service.updateRole(updateRoleOptions).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);
      // end-update_role
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-get_role
      GetRoleOptions getRoleOptions = new GetRoleOptions.Builder()
        .roleId("testString")
        .build();

      Response<CustomRole> response = service.getRole(getRoleOptions).execute();
      CustomRole customRole = response.getResult();

      System.out.println(customRole);
      // end-get_role
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_role
      DeleteRoleOptions deleteRoleOptions = new DeleteRoleOptions.Builder()
        .roleId("testString")
        .build();

      service.deleteRole(deleteRoleOptions).execute();
      // end-delete_role
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-delete_policy
      DeletePolicyOptions deletePolicyOptions = new DeletePolicyOptions.Builder()
        .policyId("testString")
        .build();

      service.deletePolicy(deletePolicyOptions).execute();
      // end-delete_policy
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
