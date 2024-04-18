/*
 * (C) Copyright IBM Corp. 2024.
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
 * PolicyAssignmentV1OptionsRoot.
 */
public class PolicyAssignmentV1OptionsRoot extends GenericModel {

  @SerializedName("requester_id")
  protected String requesterId;
  @SerializedName("assignment_id")
  protected String assignmentId;
  protected PolicyAssignmentV1OptionsRootTemplate template;

  /**
   * Builder.
   */
  public static class Builder {
    private String requesterId;
    private String assignmentId;
    private PolicyAssignmentV1OptionsRootTemplate template;

    /**
     * Instantiates a new Builder from an existing PolicyAssignmentV1OptionsRoot instance.
     *
     * @param policyAssignmentV1OptionsRoot the instance to initialize the Builder with
     */
    private Builder(PolicyAssignmentV1OptionsRoot policyAssignmentV1OptionsRoot) {
      this.requesterId = policyAssignmentV1OptionsRoot.requesterId;
      this.assignmentId = policyAssignmentV1OptionsRoot.assignmentId;
      this.template = policyAssignmentV1OptionsRoot.template;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PolicyAssignmentV1OptionsRoot.
     *
     * @return the new PolicyAssignmentV1OptionsRoot instance
     */
    public PolicyAssignmentV1OptionsRoot build() {
      return new PolicyAssignmentV1OptionsRoot(this);
    }

    /**
     * Set the requesterId.
     *
     * @param requesterId the requesterId
     * @return the PolicyAssignmentV1OptionsRoot builder
     */
    public Builder requesterId(String requesterId) {
      this.requesterId = requesterId;
      return this;
    }

    /**
     * Set the assignmentId.
     *
     * @param assignmentId the assignmentId
     * @return the PolicyAssignmentV1OptionsRoot builder
     */
    public Builder assignmentId(String assignmentId) {
      this.assignmentId = assignmentId;
      return this;
    }

    /**
     * Set the template.
     *
     * @param template the template
     * @return the PolicyAssignmentV1OptionsRoot builder
     */
    public Builder template(PolicyAssignmentV1OptionsRootTemplate template) {
      this.template = template;
      return this;
    }
  }

  protected PolicyAssignmentV1OptionsRoot() { }

  protected PolicyAssignmentV1OptionsRoot(Builder builder) {
    requesterId = builder.requesterId;
    assignmentId = builder.assignmentId;
    template = builder.template;
  }

  /**
   * New builder.
   *
   * @return a PolicyAssignmentV1OptionsRoot builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the requesterId.
   *
   * @return the requesterId
   */
  public String requesterId() {
    return requesterId;
  }

  /**
   * Gets the assignmentId.
   *
   * Passed in value to correlate with other assignments.
   *
   * @return the assignmentId
   */
  public String assignmentId() {
    return assignmentId;
  }

  /**
   * Gets the template.
   *
   * @return the template
   */
  public PolicyAssignmentV1OptionsRootTemplate template() {
    return template;
  }
}

