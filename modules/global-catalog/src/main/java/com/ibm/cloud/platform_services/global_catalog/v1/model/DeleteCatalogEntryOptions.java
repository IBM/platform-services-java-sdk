/*
 * (C) Copyright IBM Corp. 2021.
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
 * The deleteCatalogEntry options.
 */
public class DeleteCatalogEntryOptions extends GenericModel {

  protected String id;
  protected String account;
  protected Boolean force;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String account;
    private Boolean force;

    private Builder(DeleteCatalogEntryOptions deleteCatalogEntryOptions) {
      this.id = deleteCatalogEntryOptions.id;
      this.account = deleteCatalogEntryOptions.account;
      this.force = deleteCatalogEntryOptions.force;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a DeleteCatalogEntryOptions.
     *
     * @return the new DeleteCatalogEntryOptions instance
     */
    public DeleteCatalogEntryOptions build() {
      return new DeleteCatalogEntryOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteCatalogEntryOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the DeleteCatalogEntryOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the DeleteCatalogEntryOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected DeleteCatalogEntryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    account = builder.account;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a DeleteCatalogEntryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The object's unique ID.
   *
   * @return the id
   */
  public String id() {
    return id;
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

  /**
   * Gets the force.
   *
   * This will cause entry to be deleted fully. By default it is archived for two weeks, so that it can be restored if
   * necessary.
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}

