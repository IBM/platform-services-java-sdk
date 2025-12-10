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
 * The replaceRoleTemplate options.
 */
public class ReplaceRoleTemplateOptions extends GenericModel {

  protected String roleTemplateId;
  protected String version;
  protected String ifMatch;
  protected String name;
  protected String description;
  protected TemplateRole role;
  protected Boolean committed;

  /**
   * Builder.
   */
  public static class Builder {
    private String roleTemplateId;
    private String version;
    private String ifMatch;
    private String name;
    private String description;
    private TemplateRole role;
    private Boolean committed;

    /**
     * Instantiates a new Builder from an existing ReplaceRoleTemplateOptions instance.
     *
     * @param replaceRoleTemplateOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceRoleTemplateOptions replaceRoleTemplateOptions) {
      this.roleTemplateId = replaceRoleTemplateOptions.roleTemplateId;
      this.version = replaceRoleTemplateOptions.version;
      this.ifMatch = replaceRoleTemplateOptions.ifMatch;
      this.name = replaceRoleTemplateOptions.name;
      this.description = replaceRoleTemplateOptions.description;
      this.role = replaceRoleTemplateOptions.role;
      this.committed = replaceRoleTemplateOptions.committed;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String roleTemplateId, String version, String ifMatch) {
      this.roleTemplateId = roleTemplateId;
      this.version = version;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a ReplaceRoleTemplateOptions.
     *
     * @return the new ReplaceRoleTemplateOptions instance
     */
    public ReplaceRoleTemplateOptions build() {
      return new ReplaceRoleTemplateOptions(this);
    }

    /**
     * Set the roleTemplateId.
     *
     * @param roleTemplateId the roleTemplateId
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder roleTemplateId(String roleTemplateId) {
      this.roleTemplateId = roleTemplateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder role(TemplateRole role) {
      this.role = role;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the ReplaceRoleTemplateOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }
  }

  protected ReplaceRoleTemplateOptions() { }

  protected ReplaceRoleTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.roleTemplateId,
      "roleTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    roleTemplateId = builder.roleTemplateId;
    version = builder.version;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
    role = builder.role;
    committed = builder.committed;
  }

  /**
   * New builder.
   *
   * @return a ReplaceRoleTemplateOptions builder
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
   * Role template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a role template version must match the Etag value of the existing role template
   * version. The Etag can be retrieved using the GET /v1/role_templates/{template_id}/versions/{version} API and
   * looking at the Etag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise, this field is optional. If the field is included, it will
   * change the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the role template. This is shown to users in the enterprise account. Use this to describe the
   * purpose or context of the role for enterprise users managing IAM templates.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the role.
   *
   * The role properties that are created in an action resource when the template is assigned.
   *
   * @return the role
   */
  public TemplateRole role() {
    return role;
  }

  /**
   * Gets the committed.
   *
   * Committed status of the template version. If committed is set to true, then the template version can no longer be
   * updated.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
  }
}

