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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deletePolicy options.
 */
public class DeletePolicyOptions extends GenericModel {

  protected String policyId;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;

    /**
     * Instantiates a new Builder from an existing DeletePolicyOptions instance.
     *
     * @param deletePolicyOptions the instance to initialize the Builder with
     */
    private Builder(DeletePolicyOptions deletePolicyOptions) {
      this.policyId = deletePolicyOptions.policyId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyId the policyId
     */
    public Builder(String policyId) {
      this.policyId = policyId;
    }

    /**
     * Builds a DeletePolicyOptions.
     *
     * @return the new DeletePolicyOptions instance
     */
    public DeletePolicyOptions build() {
      return new DeletePolicyOptions(this);
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the DeletePolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }
  }

  protected DeletePolicyOptions() { }

  protected DeletePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    policyId = builder.policyId;
  }

  /**
   * New builder.
   *
   * @return a DeletePolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyId.
   *
   * The policy ID.
   *
   * @return the policyId
   */
  public String policyId() {
    return policyId;
  }
}

