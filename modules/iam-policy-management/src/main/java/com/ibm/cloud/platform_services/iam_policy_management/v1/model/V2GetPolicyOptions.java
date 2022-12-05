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
 * The v2GetPolicy options.
 */
public class V2GetPolicyOptions extends GenericModel {

  protected String policyId;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;

    /**
     * Instantiates a new Builder from an existing V2GetPolicyOptions instance.
     *
     * @param v2GetPolicyOptions the instance to initialize the Builder with
     */
    private Builder(V2GetPolicyOptions v2GetPolicyOptions) {
      this.policyId = v2GetPolicyOptions.policyId;
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
     * Builds a V2GetPolicyOptions.
     *
     * @return the new V2GetPolicyOptions instance
     */
    public V2GetPolicyOptions build() {
      return new V2GetPolicyOptions(this);
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the V2GetPolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }
  }

  protected V2GetPolicyOptions() { }

  protected V2GetPolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    policyId = builder.policyId;
  }

  /**
   * New builder.
   *
   * @return a V2GetPolicyOptions builder
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

