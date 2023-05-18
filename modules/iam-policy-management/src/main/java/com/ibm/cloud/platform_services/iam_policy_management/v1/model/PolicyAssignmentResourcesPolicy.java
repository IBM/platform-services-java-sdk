/*
 * (C) Copyright IBM Corp. 2023.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Set of properties for the assigned resource.
 */
public class PolicyAssignmentResourcesPolicy extends GenericModel {

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

  @SerializedName("resource_created")
  protected AssignmentResourceCreated resourceCreated;
  @SerializedName("error_message")
  protected ErrorResponse errorMessage;
  protected String status;

  protected PolicyAssignmentResourcesPolicy() { }

  /**
   * Gets the resourceCreated.
   *
   * On success, includes the  policy assigned.
   *
   * @return the resourceCreated
   */
  public AssignmentResourceCreated getResourceCreated() {
    return resourceCreated;
  }

  /**
   * Gets the errorMessage.
   *
   * The error response from API.
   *
   * @return the errorMessage
   */
  public ErrorResponse getErrorMessage() {
    return errorMessage;
  }

  /**
   * Gets the status.
   *
   * The policy assignment status.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }
}

