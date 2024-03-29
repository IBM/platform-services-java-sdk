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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteAssignment options.
 */
public class DeleteAssignmentOptions extends GenericModel {

  protected String assignmentId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String assignmentId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing DeleteAssignmentOptions instance.
     *
     * @param deleteAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteAssignmentOptions deleteAssignmentOptions) {
      this.assignmentId = deleteAssignmentOptions.assignmentId;
      this.transactionId = deleteAssignmentOptions.transactionId;
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
     * Builds a DeleteAssignmentOptions.
     *
     * @return the new DeleteAssignmentOptions instance
     */
    public DeleteAssignmentOptions build() {
      return new DeleteAssignmentOptions(this);
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the DeleteAssignmentOptions builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteAssignmentOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteAssignmentOptions() { }

  protected DeleteAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.assignmentId,
      "assignmentId cannot be empty");
    assignmentId = builder.assignmentId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the assignmentId.
   *
   * assignment id path parameter.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

