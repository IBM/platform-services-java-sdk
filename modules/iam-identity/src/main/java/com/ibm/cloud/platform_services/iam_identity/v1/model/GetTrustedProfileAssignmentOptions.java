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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getTrustedProfileAssignment options.
 */
public class GetTrustedProfileAssignmentOptions extends GenericModel {

  protected String assignmentId;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String assignmentId;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing GetTrustedProfileAssignmentOptions instance.
     *
     * @param getTrustedProfileAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(GetTrustedProfileAssignmentOptions getTrustedProfileAssignmentOptions) {
      this.assignmentId = getTrustedProfileAssignmentOptions.assignmentId;
      this.includeHistory = getTrustedProfileAssignmentOptions.includeHistory;
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
     * Builds a GetTrustedProfileAssignmentOptions.
     *
     * @return the new GetTrustedProfileAssignmentOptions instance
     */
    public GetTrustedProfileAssignmentOptions build() {
      return new GetTrustedProfileAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the GetTrustedProfileAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetTrustedProfileAssignmentOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected GetTrustedProfileAssignmentOptions() { }

  protected GetTrustedProfileAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.assignmentId,
      "assignmentId cannot be empty");
    assignmentId = builder.assignmentId;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a GetTrustedProfileAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * ID of the Assignment Record.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the includeHistory.
   *
   * Defines if the entity history is included in the response.
   *
   * @return the includeHistory
   */
  public Boolean includeHistory() {
    return includeHistory;
  }
}

