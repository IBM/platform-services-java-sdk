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
 * The getPolicyTemplate options.
 */
public class GetPolicyTemplateOptions extends GenericModel {

  /**
   * The policy template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String policyTemplateId;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyTemplateId;
    private String state;

    /**
     * Instantiates a new Builder from an existing GetPolicyTemplateOptions instance.
     *
     * @param getPolicyTemplateOptions the instance to initialize the Builder with
     */
    private Builder(GetPolicyTemplateOptions getPolicyTemplateOptions) {
      this.policyTemplateId = getPolicyTemplateOptions.policyTemplateId;
      this.state = getPolicyTemplateOptions.state;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyTemplateId the policyTemplateId
     */
    public Builder(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
    }

    /**
     * Builds a GetPolicyTemplateOptions.
     *
     * @return the new GetPolicyTemplateOptions instance
     */
    public GetPolicyTemplateOptions build() {
      return new GetPolicyTemplateOptions(this);
    }

    /**
     * Set the policyTemplateId.
     *
     * @param policyTemplateId the policyTemplateId
     * @return the GetPolicyTemplateOptions builder
     */
    public Builder policyTemplateId(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the GetPolicyTemplateOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected GetPolicyTemplateOptions() { }

  protected GetPolicyTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyTemplateId,
      "policyTemplateId cannot be empty");
    policyTemplateId = builder.policyTemplateId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a GetPolicyTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyTemplateId.
   *
   * The policy template ID.
   *
   * @return the policyTemplateId
   */
  public String policyTemplateId() {
    return policyTemplateId;
  }

  /**
   * Gets the state.
   *
   * The policy template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

