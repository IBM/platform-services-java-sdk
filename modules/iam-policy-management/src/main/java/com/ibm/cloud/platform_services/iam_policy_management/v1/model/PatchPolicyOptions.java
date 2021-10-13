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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The patchPolicy options.
 */
public class PatchPolicyOptions extends GenericModel {

  /**
   * The policy state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String policyId;
  protected String ifMatch;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;
    private String ifMatch;
    private String state;

    private Builder(PatchPolicyOptions patchPolicyOptions) {
      this.policyId = patchPolicyOptions.policyId;
      this.ifMatch = patchPolicyOptions.ifMatch;
      this.state = patchPolicyOptions.state;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String policyId, String ifMatch) {
      this.policyId = policyId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a PatchPolicyOptions.
     *
     * @return the new PatchPolicyOptions instance
     */
    public PatchPolicyOptions build() {
      return new PatchPolicyOptions(this);
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the PatchPolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the PatchPolicyOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the PatchPolicyOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected PatchPolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    policyId = builder.policyId;
    ifMatch = builder.ifMatch;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a PatchPolicyOptions builder
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

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a policy and must match the ETag value of the existing policy. The Etag can be
   * retrieved using the GET /v1/policies/{policy_id} API and looking at the ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the state.
   *
   * The policy state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

