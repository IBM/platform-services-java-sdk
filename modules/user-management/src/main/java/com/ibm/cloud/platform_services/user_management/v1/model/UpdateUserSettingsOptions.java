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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateUserSettings options.
 */
public class UpdateUserSettingsOptions extends GenericModel {

  protected String accountId;
  protected String iamId;
  protected String language;
  protected String notificationLanguage;
  protected String allowedIpAddresses;
  protected Boolean selfManage;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;
    private String language;
    private String notificationLanguage;
    private String allowedIpAddresses;
    private Boolean selfManage;

    /**
     * Instantiates a new Builder from an existing UpdateUserSettingsOptions instance.
     *
     * @param updateUserSettingsOptions the instance to initialize the Builder with
     */
    private Builder(UpdateUserSettingsOptions updateUserSettingsOptions) {
      this.accountId = updateUserSettingsOptions.accountId;
      this.iamId = updateUserSettingsOptions.iamId;
      this.language = updateUserSettingsOptions.language;
      this.notificationLanguage = updateUserSettingsOptions.notificationLanguage;
      this.allowedIpAddresses = updateUserSettingsOptions.allowedIpAddresses;
      this.selfManage = updateUserSettingsOptions.selfManage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param iamId the iamId
     */
    public Builder(String accountId, String iamId) {
      this.accountId = accountId;
      this.iamId = iamId;
    }

    /**
     * Builds a UpdateUserSettingsOptions.
     *
     * @return the new UpdateUserSettingsOptions instance
     */
    public UpdateUserSettingsOptions build() {
      return new UpdateUserSettingsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the notificationLanguage.
     *
     * @param notificationLanguage the notificationLanguage
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder notificationLanguage(String notificationLanguage) {
      this.notificationLanguage = notificationLanguage;
      return this;
    }

    /**
     * Set the allowedIpAddresses.
     *
     * @param allowedIpAddresses the allowedIpAddresses
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder allowedIpAddresses(String allowedIpAddresses) {
      this.allowedIpAddresses = allowedIpAddresses;
      return this;
    }

    /**
     * Set the selfManage.
     *
     * @param selfManage the selfManage
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder selfManage(Boolean selfManage) {
      this.selfManage = selfManage;
      return this;
    }

    /**
     * Set the userSettings.
     *
     * @param userSettings the userSettings
     * @return the UpdateUserSettingsOptions builder
     */
    public Builder userSettings(UserSettings userSettings) {
      this.language = userSettings.language();
      this.notificationLanguage = userSettings.notificationLanguage();
      this.allowedIpAddresses = userSettings.allowedIpAddresses();
      this.selfManage = userSettings.selfManage();
      return this;
    }
  }

  protected UpdateUserSettingsOptions() { }

  protected UpdateUserSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    accountId = builder.accountId;
    iamId = builder.iamId;
    language = builder.language;
    notificationLanguage = builder.notificationLanguage;
    allowedIpAddresses = builder.allowedIpAddresses;
    selfManage = builder.selfManage;
  }

  /**
   * New builder.
   *
   * @return a UpdateUserSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID of the specified user.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * The user's IAM ID.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the language.
   *
   * The console UI language. By default, this field is empty.
   *
   * @return the language
   */
  public String language() {
    return language;
  }

  /**
   * Gets the notificationLanguage.
   *
   * The language for email and phone notifications. By default, this field is empty.
   *
   * @return the notificationLanguage
   */
  public String notificationLanguage() {
    return notificationLanguage;
  }

  /**
   * Gets the allowedIpAddresses.
   *
   * A comma-separated list of IP addresses.
   *
   * @return the allowedIpAddresses
   */
  public String allowedIpAddresses() {
    return allowedIpAddresses;
  }

  /**
   * Gets the selfManage.
   *
   * Whether user managed login is enabled. The default value is `false`.
   *
   * @return the selfManage
   */
  public Boolean selfManage() {
    return selfManage;
  }
}

