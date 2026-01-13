/*
 * (C) Copyright IBM Corp. 2026.
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
 * The createApiKey options.
 */
public class CreateApiKeyOptions extends GenericModel {

  protected String name;
  protected String iamId;
  protected String description;
  protected String accountId;
  protected String apikey;
  protected Boolean storeValue;
  protected Boolean supportSessions;
  protected String actionWhenLeaked;
  protected String expiresAt;
  protected String entityLock;
  protected String entityDisable;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String iamId;
    private String description;
    private String accountId;
    private String apikey;
    private Boolean storeValue;
    private Boolean supportSessions;
    private String actionWhenLeaked;
    private String expiresAt;
    private String entityLock;
    private String entityDisable;

    /**
     * Instantiates a new Builder from an existing CreateApiKeyOptions instance.
     *
     * @param createApiKeyOptions the instance to initialize the Builder with
     */
    private Builder(CreateApiKeyOptions createApiKeyOptions) {
      this.name = createApiKeyOptions.name;
      this.iamId = createApiKeyOptions.iamId;
      this.description = createApiKeyOptions.description;
      this.accountId = createApiKeyOptions.accountId;
      this.apikey = createApiKeyOptions.apikey;
      this.storeValue = createApiKeyOptions.storeValue;
      this.supportSessions = createApiKeyOptions.supportSessions;
      this.actionWhenLeaked = createApiKeyOptions.actionWhenLeaked;
      this.expiresAt = createApiKeyOptions.expiresAt;
      this.entityLock = createApiKeyOptions.entityLock;
      this.entityDisable = createApiKeyOptions.entityDisable;
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
     * @param iamId the iamId
     */
    public Builder(String name, String iamId) {
      this.name = name;
      this.iamId = iamId;
    }

    /**
     * Builds a CreateApiKeyOptions.
     *
     * @return the new CreateApiKeyOptions instance
     */
    public CreateApiKeyOptions build() {
      return new CreateApiKeyOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateApiKeyOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the CreateApiKeyOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateApiKeyOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateApiKeyOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the apikey.
     *
     * @param apikey the apikey
     * @return the CreateApiKeyOptions builder
     */
    public Builder apikey(String apikey) {
      this.apikey = apikey;
      return this;
    }

    /**
     * Set the storeValue.
     *
     * @param storeValue the storeValue
     * @return the CreateApiKeyOptions builder
     */
    public Builder storeValue(Boolean storeValue) {
      this.storeValue = storeValue;
      return this;
    }

    /**
     * Set the supportSessions.
     *
     * @param supportSessions the supportSessions
     * @return the CreateApiKeyOptions builder
     */
    public Builder supportSessions(Boolean supportSessions) {
      this.supportSessions = supportSessions;
      return this;
    }

    /**
     * Set the actionWhenLeaked.
     *
     * @param actionWhenLeaked the actionWhenLeaked
     * @return the CreateApiKeyOptions builder
     */
    public Builder actionWhenLeaked(String actionWhenLeaked) {
      this.actionWhenLeaked = actionWhenLeaked;
      return this;
    }

    /**
     * Set the expiresAt.
     *
     * @param expiresAt the expiresAt
     * @return the CreateApiKeyOptions builder
     */
    public Builder expiresAt(String expiresAt) {
      this.expiresAt = expiresAt;
      return this;
    }

    /**
     * Set the entityLock.
     *
     * @param entityLock the entityLock
     * @return the CreateApiKeyOptions builder
     */
    public Builder entityLock(String entityLock) {
      this.entityLock = entityLock;
      return this;
    }

    /**
     * Set the entityDisable.
     *
     * @param entityDisable the entityDisable
     * @return the CreateApiKeyOptions builder
     */
    public Builder entityDisable(String entityDisable) {
      this.entityDisable = entityDisable;
      return this;
    }
  }

  protected CreateApiKeyOptions() { }

  protected CreateApiKeyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.iamId,
      "iamId cannot be null");
    name = builder.name;
    iamId = builder.iamId;
    description = builder.description;
    accountId = builder.accountId;
    apikey = builder.apikey;
    storeValue = builder.storeValue;
    supportSessions = builder.supportSessions;
    actionWhenLeaked = builder.actionWhenLeaked;
    expiresAt = builder.expiresAt;
    entityLock = builder.entityLock;
    entityDisable = builder.entityDisable;
  }

  /**
   * New builder.
   *
   * @return a CreateApiKeyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the API key. The name is not checked for uniqueness. Therefore multiple names with the same value can
   * exist. Access is done via the UUID of the API key.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the iamId.
   *
   * The iam_id that this API key authenticates.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the description.
   *
   * The optional description of the API key. The 'description' property is only available if a description was provided
   * during a create of an API key.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * The account ID of the API key.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the apikey.
   *
   * You can optionally passthrough the API key value for this API key. If passed, a minimum length validation of 32
   * characters for that apiKey value is done, i.e. the value can contain any characters and can even be non-URL safe,
   * but the minimum length requirement must be met. If omitted, the API key management will create an URL safe opaque
   * API key value. The value of the API key is checked for uniqueness. Ensure enough variations when passing in this
   * value.
   *
   * @return the apikey
   */
  public String apikey() {
    return apikey;
  }

  /**
   * Gets the storeValue.
   *
   * Send true or false to set whether the API key value is retrievable in the future by using the Get details of an API
   * key request. If you create an API key for a user, you must specify `false` or omit the value. We don't allow
   * storing of API keys for users.
   *
   * @return the storeValue
   */
  public Boolean storeValue() {
    return storeValue;
  }

  /**
   * Gets the supportSessions.
   *
   * Defines whether you can manage CLI login sessions for the API key. When `true`, sessions are created and can be
   * reviewed or revoked. When `false`, no sessions are tracked. To block access, delete or rotate the API key.
   * Available only for user API keys.
   *
   * @return the supportSessions
   */
  public Boolean supportSessions() {
    return supportSessions;
  }

  /**
   * Gets the actionWhenLeaked.
   *
   * Defines the action to take when API key is leaked, valid values are 'none', 'disable' and 'delete'.
   *
   * @return the actionWhenLeaked
   */
  public String actionWhenLeaked() {
    return actionWhenLeaked;
  }

  /**
   * Gets the expiresAt.
   *
   * Date and time when the API key becomes invalid, ISO 8601 datetime in the format 'yyyy-MM-ddTHH:mm+0000'.
   *
   * @return the expiresAt
   */
  public String expiresAt() {
    return expiresAt;
  }

  /**
   * Gets the entityLock.
   *
   * Indicates if the API key is locked for further write operations. False by default.
   *
   * @return the entityLock
   */
  public String entityLock() {
    return entityLock;
  }

  /**
   * Gets the entityDisable.
   *
   * Indicates if the API key is disabled. False by default.
   *
   * @return the entityDisable
   */
  public String entityDisable() {
    return entityDisable;
  }
}

