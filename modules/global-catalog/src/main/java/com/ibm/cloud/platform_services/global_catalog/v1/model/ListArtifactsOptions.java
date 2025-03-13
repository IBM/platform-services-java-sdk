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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listArtifacts options.
 */
public class ListArtifactsOptions extends GenericModel {

  protected String objectId;
  protected String account;

  /**
   * Builder.
   */
  public static class Builder {
    private String objectId;
    private String account;

    /**
     * Instantiates a new Builder from an existing ListArtifactsOptions instance.
     *
     * @param listArtifactsOptions the instance to initialize the Builder with
     */
    private Builder(ListArtifactsOptions listArtifactsOptions) {
      this.objectId = listArtifactsOptions.objectId;
      this.account = listArtifactsOptions.account;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param objectId the objectId
     */
    public Builder(String objectId) {
      this.objectId = objectId;
    }

    /**
     * Builds a ListArtifactsOptions.
     *
     * @return the new ListArtifactsOptions instance
     */
    public ListArtifactsOptions build() {
      return new ListArtifactsOptions(this);
    }

    /**
     * Set the objectId.
     *
     * @param objectId the objectId
     * @return the ListArtifactsOptions builder
     */
    public Builder objectId(String objectId) {
      this.objectId = objectId;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the ListArtifactsOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }
  }

  protected ListArtifactsOptions() { }

  protected ListArtifactsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.objectId,
      "objectId cannot be empty");
    objectId = builder.objectId;
    account = builder.account;
  }

  /**
   * New builder.
   *
   * @return a ListArtifactsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the objectId.
   *
   * The object's unique ID.
   *
   * @return the objectId
   */
  public String objectId() {
    return objectId;
  }

  /**
   * Gets the account.
   *
   * This changes the scope of the request regardless of the authorization header. Example scopes are `account` and
   * `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for example
   * `GET /?account=global`.
   *
   * @return the account
   */
  public String account() {
    return account;
  }
}

