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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Parameters for the API key in the Create service Id V1 REST request.
 */
public class ApiKeyInsideCreateServiceIdRequest extends GenericModel {

  protected String name;
  protected String description;
  protected String apikey;
  @SerializedName("store_value")
  protected Boolean storeValue;
  @SerializedName("action_when_leaked")
  protected String actionWhenLeaked;
  @SerializedName("expires_at")
  protected String expiresAt;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String apikey;
    private Boolean storeValue;
    private String actionWhenLeaked;
    private String expiresAt;

    /**
     * Instantiates a new Builder from an existing ApiKeyInsideCreateServiceIdRequest instance.
     *
     * @param apiKeyInsideCreateServiceIdRequest the instance to initialize the Builder with
     */
    private Builder(ApiKeyInsideCreateServiceIdRequest apiKeyInsideCreateServiceIdRequest) {
      this.name = apiKeyInsideCreateServiceIdRequest.name;
      this.description = apiKeyInsideCreateServiceIdRequest.description;
      this.apikey = apiKeyInsideCreateServiceIdRequest.apikey;
      this.storeValue = apiKeyInsideCreateServiceIdRequest.storeValue;
      this.actionWhenLeaked = apiKeyInsideCreateServiceIdRequest.actionWhenLeaked;
      this.expiresAt = apiKeyInsideCreateServiceIdRequest.expiresAt;
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
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a ApiKeyInsideCreateServiceIdRequest.
     *
     * @return the new ApiKeyInsideCreateServiceIdRequest instance
     */
    public ApiKeyInsideCreateServiceIdRequest build() {
      return new ApiKeyInsideCreateServiceIdRequest(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ApiKeyInsideCreateServiceIdRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ApiKeyInsideCreateServiceIdRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the apikey.
     *
     * @param apikey the apikey
     * @return the ApiKeyInsideCreateServiceIdRequest builder
     */
    public Builder apikey(String apikey) {
      this.apikey = apikey;
      return this;
    }

    /**
     * Set the storeValue.
     *
     * @param storeValue the storeValue
     * @return the ApiKeyInsideCreateServiceIdRequest builder
     */
    public Builder storeValue(Boolean storeValue) {
      this.storeValue = storeValue;
      return this;
    }

    /**
     * Set the actionWhenLeaked.
     *
     * @param actionWhenLeaked the actionWhenLeaked
     * @return the ApiKeyInsideCreateServiceIdRequest builder
     */
    public Builder actionWhenLeaked(String actionWhenLeaked) {
      this.actionWhenLeaked = actionWhenLeaked;
      return this;
    }

    /**
     * Set the expiresAt.
     *
     * @param expiresAt the expiresAt
     * @return the ApiKeyInsideCreateServiceIdRequest builder
     */
    public Builder expiresAt(String expiresAt) {
      this.expiresAt = expiresAt;
      return this;
    }
  }

  protected ApiKeyInsideCreateServiceIdRequest() { }

  protected ApiKeyInsideCreateServiceIdRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    description = builder.description;
    apikey = builder.apikey;
    storeValue = builder.storeValue;
    actionWhenLeaked = builder.actionWhenLeaked;
    expiresAt = builder.expiresAt;
  }

  /**
   * New builder.
   *
   * @return a ApiKeyInsideCreateServiceIdRequest builder
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
}

