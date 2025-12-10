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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getActionControlAssignment options.
 */
public class GetActionControlAssignmentOptions extends GenericModel {

  protected String assignmentId;

  /**
   * Builder.
   */
  public static class Builder {
    private String assignmentId;

    /**
     * Instantiates a new Builder from an existing GetActionControlAssignmentOptions instance.
     *
     * @param getActionControlAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(GetActionControlAssignmentOptions getActionControlAssignmentOptions) {
      this.assignmentId = getActionControlAssignmentOptions.assignmentId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param assignmentId the assignmentId
     */
    public Builder(String assignmentId) {
      this.assignmentId = assignmentId;
    }

    /**
     * Builds a GetActionControlAssignmentOptions.
     *
     * @return the new GetActionControlAssignmentOptions instance
     */
    public GetActionControlAssignmentOptions build() {
      return new GetActionControlAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the GetActionControlAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }
  }

  protected GetActionControlAssignmentOptions() { }

  protected GetActionControlAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.assignmentId,
      "assignmentId cannot be empty");
    assignmentId = builder.assignmentId;
  }

  /**
   * New builder.
   *
   * @return a GetActionControlAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * Action control template assignment ID.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }
}

