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
 * The createRoleTemplate options.
 */
public class CreateRoleTemplateOptions extends GenericModel {

  protected String name;
  protected String accountId;
  protected String description;
  protected Boolean committed;
  protected RoleTemplatePrototypeRole role;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String accountId;
    private String description;
    private Boolean committed;
    private RoleTemplatePrototypeRole role;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreateRoleTemplateOptions instance.
     *
     * @param createRoleTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CreateRoleTemplateOptions createRoleTemplateOptions) {
      this.name = createRoleTemplateOptions.name;
      this.accountId = createRoleTemplateOptions.accountId;
      this.description = createRoleTemplateOptions.description;
      this.committed = createRoleTemplateOptions.committed;
      this.role = createRoleTemplateOptions.role;
      this.acceptLanguage = createRoleTemplateOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param accountId the accountId
     */
    public Builder(String name, String accountId) {
      this.name = name;
      this.accountId = accountId;
    }

    /**
     * Builds a CreateRoleTemplateOptions.
     *
     * @return the new CreateRoleTemplateOptions instance
     */
    public CreateRoleTemplateOptions build() {
      return new CreateRoleTemplateOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateRoleTemplateOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateRoleTemplateOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateRoleTemplateOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the CreateRoleTemplateOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the CreateRoleTemplateOptions builder
     */
    public Builder role(RoleTemplatePrototypeRole role) {
      this.role = role;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreateRoleTemplateOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreateRoleTemplateOptions() { }

  protected CreateRoleTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    name = builder.name;
    accountId = builder.accountId;
    description = builder.description;
    committed = builder.committed;
    role = builder.role;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a CreateRoleTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise, this field is optional. If the field is included, it
   * changes the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account ID where this template is created.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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
   * Gets the committed.
   *
   * Committed status of the template. If committed is set to true, then the template version can no longer be updated.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
  }

  /**
   * Gets the role.
   *
   * The role properties that are created in an action resource when the template is assigned.
   *
   * @return the role
   */
  public RoleTemplatePrototypeRole role() {
    return role;
  }

  /**
   * Gets the acceptLanguage.
   *
   * Language code for translations
   * * `default` - English
   * * `de` -  German (Standard)
   * * `en` - English
   * * `es` - Spanish (Spain)
   * * `fr` - French (Standard)
   * * `it` - Italian (Standard)
   * * `ja` - Japanese
   * * `ko` - Korean
   * * `pt-br` - Portuguese (Brazil)
   * * `zh-cn` - Chinese (Simplified, PRC)
   * * `zh-tw` - (Chinese, Taiwan).
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

