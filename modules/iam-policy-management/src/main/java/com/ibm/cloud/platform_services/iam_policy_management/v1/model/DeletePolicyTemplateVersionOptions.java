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
 * The deletePolicyTemplateVersion options.
 */
public class DeletePolicyTemplateVersionOptions extends GenericModel {

  protected String policyTemplateId;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyTemplateId;
    private String version;

    /**
     * Instantiates a new Builder from an existing DeletePolicyTemplateVersionOptions instance.
     *
     * @param deletePolicyTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(DeletePolicyTemplateVersionOptions deletePolicyTemplateVersionOptions) {
      this.policyTemplateId = deletePolicyTemplateVersionOptions.policyTemplateId;
      this.version = deletePolicyTemplateVersionOptions.version;
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
     * @param version the version
     */
    public Builder(String policyTemplateId, String version) {
      this.policyTemplateId = policyTemplateId;
      this.version = version;
    }

    /**
     * Builds a DeletePolicyTemplateVersionOptions.
     *
     * @return the new DeletePolicyTemplateVersionOptions instance
     */
    public DeletePolicyTemplateVersionOptions build() {
      return new DeletePolicyTemplateVersionOptions(this);
    }

    /**
     * Set the policyTemplateId.
     *
     * @param policyTemplateId the policyTemplateId
     * @return the DeletePolicyTemplateVersionOptions builder
     */
    public Builder policyTemplateId(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the DeletePolicyTemplateVersionOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected DeletePolicyTemplateVersionOptions() { }

  protected DeletePolicyTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyTemplateId,
      "policyTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    policyTemplateId = builder.policyTemplateId;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a DeletePolicyTemplateVersionOptions builder
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
   * Gets the version.
   *
   * The policy template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}

