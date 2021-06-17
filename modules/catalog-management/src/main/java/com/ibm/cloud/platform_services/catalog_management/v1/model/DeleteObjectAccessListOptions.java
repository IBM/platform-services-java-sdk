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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteObjectAccessList options.
 */
public class DeleteObjectAccessListOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String objectIdentifier;
  protected List<String> accounts;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String objectIdentifier;
    private List<String> accounts;

    private Builder(DeleteObjectAccessListOptions deleteObjectAccessListOptions) {
      this.catalogIdentifier = deleteObjectAccessListOptions.catalogIdentifier;
      this.objectIdentifier = deleteObjectAccessListOptions.objectIdentifier;
      this.accounts = deleteObjectAccessListOptions.accounts;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @param objectIdentifier the objectIdentifier
     * @param accounts the accounts
     */
    public Builder(String catalogIdentifier, String objectIdentifier, List<String> accounts) {
      this.catalogIdentifier = catalogIdentifier;
      this.objectIdentifier = objectIdentifier;
      this.accounts = accounts;
    }

    /**
     * Builds a DeleteObjectAccessListOptions.
     *
     * @return the new DeleteObjectAccessListOptions instance
     */
    public DeleteObjectAccessListOptions build() {
      return new DeleteObjectAccessListOptions(this);
    }

    /**
     * Adds an accounts to accounts.
     *
     * @param accounts the new accounts
     * @return the DeleteObjectAccessListOptions builder
     */
    public Builder addAccounts(String accounts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(accounts,
        "accounts cannot be null");
      if (this.accounts == null) {
        this.accounts = new ArrayList<String>();
      }
      this.accounts.add(accounts);
      return this;
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the DeleteObjectAccessListOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the objectIdentifier.
     *
     * @param objectIdentifier the objectIdentifier
     * @return the DeleteObjectAccessListOptions builder
     */
    public Builder objectIdentifier(String objectIdentifier) {
      this.objectIdentifier = objectIdentifier;
      return this;
    }

    /**
     * Set the accounts.
     * Existing accounts will be replaced.
     *
     * @param accounts the accounts
     * @return the DeleteObjectAccessListOptions builder
     */
    public Builder accounts(List<String> accounts) {
      this.accounts = accounts;
      return this;
    }
  }

  protected DeleteObjectAccessListOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.objectIdentifier,
      "objectIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accounts,
      "accounts cannot be null");
    catalogIdentifier = builder.catalogIdentifier;
    objectIdentifier = builder.objectIdentifier;
    accounts = builder.accounts;
  }

  /**
   * New builder.
   *
   * @return a DeleteObjectAccessListOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalogIdentifier.
   *
   * Catalog identifier.
   *
   * @return the catalogIdentifier
   */
  public String catalogIdentifier() {
    return catalogIdentifier;
  }

  /**
   * Gets the objectIdentifier.
   *
   * Object identifier.
   *
   * @return the objectIdentifier
   */
  public String objectIdentifier() {
    return objectIdentifier;
  }

  /**
   * Gets the accounts.
   *
   * A list of accounts to delete.  An entry with star["*"] will remove all accounts.
   *
   * @return the accounts
   */
  public List<String> accounts() {
    return accounts;
  }
}

