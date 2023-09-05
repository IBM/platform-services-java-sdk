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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createAccountSettingsTemplateVersion options.
 */
public class CreateAccountSettingsTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected String accountId;
  protected String name;
  protected String description;
  protected AccountSettingsComponent accountSettings;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String accountId;
    private String name;
    private String description;
    private AccountSettingsComponent accountSettings;

    /**
     * Instantiates a new Builder from an existing CreateAccountSettingsTemplateVersionOptions instance.
     *
     * @param createAccountSettingsTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(CreateAccountSettingsTemplateVersionOptions createAccountSettingsTemplateVersionOptions) {
      this.templateId = createAccountSettingsTemplateVersionOptions.templateId;
      this.accountId = createAccountSettingsTemplateVersionOptions.accountId;
      this.name = createAccountSettingsTemplateVersionOptions.name;
      this.description = createAccountSettingsTemplateVersionOptions.description;
      this.accountSettings = createAccountSettingsTemplateVersionOptions.accountSettings;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param templateId the templateId
     */
    public Builder(String templateId) {
      this.templateId = templateId;
    }

    /**
     * Builds a CreateAccountSettingsTemplateVersionOptions.
     *
     * @return the new CreateAccountSettingsTemplateVersionOptions instance
     */
    public CreateAccountSettingsTemplateVersionOptions build() {
      return new CreateAccountSettingsTemplateVersionOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CreateAccountSettingsTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateAccountSettingsTemplateVersionOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateAccountSettingsTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateAccountSettingsTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the accountSettings.
     *
     * @param accountSettings the accountSettings
     * @return the CreateAccountSettingsTemplateVersionOptions builder
     */
    public Builder accountSettings(AccountSettingsComponent accountSettings) {
      this.accountSettings = accountSettings;
      return this;
    }
  }

  protected CreateAccountSettingsTemplateVersionOptions() { }

  protected CreateAccountSettingsTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    accountSettings = builder.accountSettings;
  }

  /**
   * New builder.
   *
   * @return a CreateAccountSettingsTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the account settings template.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the accountId.
   *
   * ID of the account where the template resides.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * The name of the trusted profile template. This is visible only in the enterprise account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the trusted profile template. Describe the template for enterprise account users.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the accountSettings.
   *
   * @return the accountSettings
   */
  public AccountSettingsComponent accountSettings() {
    return accountSettings;
  }
}

