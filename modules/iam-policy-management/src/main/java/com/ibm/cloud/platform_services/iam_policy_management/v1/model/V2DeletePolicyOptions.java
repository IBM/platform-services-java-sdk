/*
 * (C) Copyright IBM Corp. 2022.
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
 * The v2DeletePolicy options.
 */
public class V2DeletePolicyOptions extends GenericModel {

  protected String policyId;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;

    /**
     * Instantiates a new Builder from an existing V2DeletePolicyOptions instance.
     *
     * @param v2DeletePolicyOptions the instance to initialize the Builder with
     */
    private Builder(V2DeletePolicyOptions v2DeletePolicyOptions) {
      this.policyId = v2DeletePolicyOptions.policyId;
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
     * Builds a V2DeletePolicyOptions.
     *
     * @return the new V2DeletePolicyOptions instance
     */
    public V2DeletePolicyOptions build() {
      return new V2DeletePolicyOptions(this);
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the V2DeletePolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }
  }

  protected V2DeletePolicyOptions() { }

  protected V2DeletePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    policyId = builder.policyId;
  }

  /**
   * New builder.
   *
   * @return a V2DeletePolicyOptions builder
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

