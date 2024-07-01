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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createRole options.
 */
public class CreateRoleOptions extends GenericModel {

  protected String displayName;
  protected List<String> actions;
  protected String name;
  protected String accountId;
  protected String serviceName;
  protected String description;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String displayName;
    private List<String> actions;
    private String name;
    private String accountId;
    private String serviceName;
    private String description;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreateRoleOptions instance.
     *
     * @param createRoleOptions the instance to initialize the Builder with
     */
    private Builder(CreateRoleOptions createRoleOptions) {
      this.displayName = createRoleOptions.displayName;
      this.actions = createRoleOptions.actions;
      this.name = createRoleOptions.name;
      this.accountId = createRoleOptions.accountId;
      this.serviceName = createRoleOptions.serviceName;
      this.description = createRoleOptions.description;
      this.acceptLanguage = createRoleOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param displayName the displayName
     * @param actions the actions
     * @param name the name
     * @param accountId the accountId
     * @param serviceName the serviceName
     */
    public Builder(String displayName, List<String> actions, String name, String accountId, String serviceName) {
      this.displayName = displayName;
      this.actions = actions;
      this.name = name;
      this.accountId = accountId;
      this.serviceName = serviceName;
    }

    /**
     * Builds a CreateRoleOptions.
     *
     * @return the new CreateRoleOptions instance
     */
    public CreateRoleOptions build() {
      return new CreateRoleOptions(this);
    }

    /**
     * Adds a new element to actions.
     *
     * @param actions the new element to be added
     * @return the CreateRoleOptions builder
     */
    public Builder addActions(String actions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(actions,
        "actions cannot be null");
      if (this.actions == null) {
        this.actions = new ArrayList<String>();
      }
      this.actions.add(actions);
      return this;
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the CreateRoleOptions builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the actions.
     * Existing actions will be replaced.
     *
     * @param actions the actions
     * @return the CreateRoleOptions builder
     */
    public Builder actions(List<String> actions) {
      this.actions = actions;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateRoleOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateRoleOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the CreateRoleOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateRoleOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreateRoleOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreateRoleOptions() { }

  protected CreateRoleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.displayName,
      "displayName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.actions,
      "actions cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.serviceName,
      "serviceName cannot be null");
    displayName = builder.displayName;
    actions = builder.actions;
    name = builder.name;
    accountId = builder.accountId;
    serviceName = builder.serviceName;
    description = builder.description;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a CreateRoleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the displayName.
   *
   * The display name of the role that is shown in the console.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the actions.
   *
   * The actions of the role. For more information, see [IAM roles and
   * actions](https://cloud.ibm.com/docs/account?topic=account-iam-service-roles-actions).
   *
   * @return the actions
   */
  public List<String> actions() {
    return actions;
  }

  /**
   * Gets the name.
   *
   * The name of the role that is used in the CRN. Can only be alphanumeric and has to be capitalized.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * The account GUID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the serviceName.
   *
   * The service name.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the description.
   *
   * The description of the role.
   *
   * @return the description
   */
  public String description() {
    return description;
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

