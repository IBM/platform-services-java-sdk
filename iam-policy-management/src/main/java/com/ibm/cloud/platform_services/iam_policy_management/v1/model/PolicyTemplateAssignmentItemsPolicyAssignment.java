/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

/**
 * The set of properties associated with the policy template assignment.
 */
public class PolicyTemplateAssignmentItemsPolicyAssignment extends PolicyTemplateAssignmentItems {

  /**
   * Assignment target type.
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
    /** Enterprise. */
    String ENTERPRISE = "Enterprise";
  }

  /**
   * The policy assignment status.
   */
  public interface Status {
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
    /** succeed_with_errors. */
    String SUCCEED_WITH_ERRORS = "succeed_with_errors";
    /** failed. */
    String FAILED = "failed";
  }


  protected PolicyTemplateAssignmentItemsPolicyAssignment() { }
}

