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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The user settings returned.
 */
public class UserSettings extends GenericModel {

  protected String language;
  @SerializedName("notification_language")
  protected String notificationLanguage;
  @SerializedName("allowed_ip_addresses")
  protected String allowedIpAddresses;
  @SerializedName("self_manage")
  protected Boolean selfManage;

  /**
   * Builder.
   */
  public static class Builder {
    private String language;
    private String notificationLanguage;
    private String allowedIpAddresses;
    private Boolean selfManage;

    /**
     * Instantiates a new Builder from an existing UserSettings instance.
     *
     * @param userSettings the instance to initialize the Builder with
     */
    private Builder(UserSettings userSettings) {
      this.language = userSettings.language;
      this.notificationLanguage = userSettings.notificationLanguage;
      this.allowedIpAddresses = userSettings.allowedIpAddresses;
      this.selfManage = userSettings.selfManage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a UserSettings.
     *
     * @return the new UserSettings instance
     */
    public UserSettings build() {
      return new UserSettings(this);
    }

    /**
     * Set the language.
     *
     * @param language the language
     * @return the UserSettings builder
     */
    public Builder language(String language) {
      this.language = language;
      return this;
    }

    /**
     * Set the notificationLanguage.
     *
     * @param notificationLanguage the notificationLanguage
     * @return the UserSettings builder
     */
    public Builder notificationLanguage(String notificationLanguage) {
      this.notificationLanguage = notificationLanguage;
      return this;
    }

    /**
     * Set the allowedIpAddresses.
     *
     * @param allowedIpAddresses the allowedIpAddresses
     * @return the UserSettings builder
     */
    public Builder allowedIpAddresses(String allowedIpAddresses) {
      this.allowedIpAddresses = allowedIpAddresses;
      return this;
    }

    /**
     * Set the selfManage.
     *
     * @param selfManage the selfManage
     * @return the UserSettings builder
     */
    public Builder selfManage(Boolean selfManage) {
      this.selfManage = selfManage;
      return this;
    }
  }

  protected UserSettings() { }

  protected UserSettings(Builder builder) {
    language = builder.language;
    notificationLanguage = builder.notificationLanguage;
    allowedIpAddresses = builder.allowedIpAddresses;
    selfManage = builder.selfManage;
  }

  /**
   * New builder.
   *
   * @return a UserSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

