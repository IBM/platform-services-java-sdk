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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The commitPolicyTemplate options.
 */
public class CommitPolicyTemplateOptions extends GenericModel {

  protected String policyTemplateId;
  protected String version;
  protected String ifMatch;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyTemplateId;
    private String version;
    private String ifMatch;

    /**
     * Instantiates a new Builder from an existing CommitPolicyTemplateOptions instance.
     *
     * @param commitPolicyTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CommitPolicyTemplateOptions commitPolicyTemplateOptions) {
      this.policyTemplateId = commitPolicyTemplateOptions.policyTemplateId;
      this.version = commitPolicyTemplateOptions.version;
      this.ifMatch = commitPolicyTemplateOptions.ifMatch;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String policyTemplateId, String version, String ifMatch) {
      this.policyTemplateId = policyTemplateId;
      this.version = version;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a CommitPolicyTemplateOptions.
     *
     * @return the new CommitPolicyTemplateOptions instance
     */
    public CommitPolicyTemplateOptions build() {
      return new CommitPolicyTemplateOptions(this);
    }

    /**
     * Set the policyTemplateId.
     *
     * @param policyTemplateId the policyTemplateId
     * @return the CommitPolicyTemplateOptions builder
     */
    public Builder policyTemplateId(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CommitPolicyTemplateOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the CommitPolicyTemplateOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }
  }

  protected CommitPolicyTemplateOptions() { }

  protected CommitPolicyTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyTemplateId,
      "policyTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    policyTemplateId = builder.policyTemplateId;
    version = builder.version;
    ifMatch = builder.ifMatch;
  }

  /**
   * New builder.
   *
   * @return a CommitPolicyTemplateOptions builder
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

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a policy template version and must match the ETag value of the existing policy
   * template version. The Etag can be retrieved using the GET
   * /v1/policy_templates/{policy_template_id}/versions/{version} API and looking at the ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }
}

