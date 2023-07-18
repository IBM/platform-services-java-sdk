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
 * The updateAccountSettingsTemplateVersion options.
 */
public class UpdateAccountSettingsTemplateVersionOptions extends GenericModel {

  protected String ifMatch;
  protected String templateId;
  protected String version;
  protected String accountId;
  protected String name;
  protected String description;
  protected AccountSettingsComponent accountSettings;

  /**
   * Builder.
   */
  public static class Builder {
    private String ifMatch;
    private String templateId;
    private String version;
    private String accountId;
    private String name;
    private String description;
    private AccountSettingsComponent accountSettings;

    /**
     * Instantiates a new Builder from an existing UpdateAccountSettingsTemplateVersionOptions instance.
     *
     * @param updateAccountSettingsTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(UpdateAccountSettingsTemplateVersionOptions updateAccountSettingsTemplateVersionOptions) {
      this.ifMatch = updateAccountSettingsTemplateVersionOptions.ifMatch;
      this.templateId = updateAccountSettingsTemplateVersionOptions.templateId;
      this.version = updateAccountSettingsTemplateVersionOptions.version;
      this.accountId = updateAccountSettingsTemplateVersionOptions.accountId;
      this.name = updateAccountSettingsTemplateVersionOptions.name;
      this.description = updateAccountSettingsTemplateVersionOptions.description;
      this.accountSettings = updateAccountSettingsTemplateVersionOptions.accountSettings;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ifMatch the ifMatch
     * @param templateId the templateId
     * @param version the version
     */
    public Builder(String ifMatch, String templateId, String version) {
      this.ifMatch = ifMatch;
      this.templateId = templateId;
      this.version = version;
    }

    /**
     * Builds a UpdateAccountSettingsTemplateVersionOptions.
     *
     * @return the new UpdateAccountSettingsTemplateVersionOptions instance
     */
    public UpdateAccountSettingsTemplateVersionOptions build() {
      return new UpdateAccountSettingsTemplateVersionOptions(this);
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the accountSettings.
     *
     * @param accountSettings the accountSettings
     * @return the UpdateAccountSettingsTemplateVersionOptions builder
     */
    public Builder accountSettings(AccountSettingsComponent accountSettings) {
      this.accountSettings = accountSettings;
      return this;
    }
  }

  protected UpdateAccountSettingsTemplateVersionOptions() { }

  protected UpdateAccountSettingsTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    ifMatch = builder.ifMatch;
    templateId = builder.templateId;
    version = builder.version;
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    accountSettings = builder.accountSettings;
  }

  /**
   * New builder.
   *
   * @return a UpdateAccountSettingsTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ifMatch.
   *
   * Entity tag of the Template to be updated. Specify the tag that you retrieved when reading the account settings
   * template. This value helps identifying parallel usage of this API. Pass * to indicate to update any version
   * available. This might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
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
   * Gets the version.
   *
   * Version of the account settings template.
   *
   * @return the version
   */
  public String version() {
    return version;
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

