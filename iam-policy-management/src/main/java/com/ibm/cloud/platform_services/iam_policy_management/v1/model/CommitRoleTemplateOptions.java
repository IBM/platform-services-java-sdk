/*
 * (C) Copyright IBM Corp. 2025.
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
 * The commitRoleTemplate options.
 */
public class CommitRoleTemplateOptions extends GenericModel {

  protected String roleTemplateId;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleTemplateId;
    private String version;

    /**
     * Instantiates a new Builder from an existing CommitRoleTemplateOptions instance.
     *
     * @param commitRoleTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CommitRoleTemplateOptions commitRoleTemplateOptions) {
      this.roleTemplateId = commitRoleTemplateOptions.roleTemplateId;
      this.version = commitRoleTemplateOptions.version;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param roleTemplateId the roleTemplateId
     * @param version the version
     */
    public Builder(String roleTemplateId, String version) {
      this.roleTemplateId = roleTemplateId;
      this.version = version;
    }

    /**
     * Builds a CommitRoleTemplateOptions.
     *
     * @return the new CommitRoleTemplateOptions instance
     */
    public CommitRoleTemplateOptions build() {
      return new CommitRoleTemplateOptions(this);
    }

    /**
     * Set the roleTemplateId.
     *
     * @param roleTemplateId the roleTemplateId
     * @return the CommitRoleTemplateOptions builder
     */
    public Builder roleTemplateId(String roleTemplateId) {
      this.roleTemplateId = roleTemplateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the CommitRoleTemplateOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected CommitRoleTemplateOptions() { }

  protected CommitRoleTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleTemplateId,
      "roleTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    roleTemplateId = builder.roleTemplateId;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a CommitRoleTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the roleTemplateId.
   *
   * Role template ID.
   *
   * @return the roleTemplateId
   */
  public String roleTemplateId() {
    return roleTemplateId;
  }

  /**
   * Gets the version.
   *
   * The role template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}

