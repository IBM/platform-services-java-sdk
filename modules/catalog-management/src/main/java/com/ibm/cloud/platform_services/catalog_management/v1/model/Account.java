/*
 * (C) Copyright IBM Corp. 2020.
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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Account information.
 */
public class Account extends GenericModel {

  protected String id;
  @SerializedName("account_filters")
  protected Filters accountFilters;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Filters accountFilters;

    private Builder(Account account) {
      this.id = account.id;
      this.accountFilters = account.accountFilters;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Account.
     *
     * @return the new Account instance
     */
    public Account build() {
      return new Account(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Account builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the accountFilters.
     *
     * @param accountFilters the accountFilters
     * @return the Account builder
     */
    public Builder accountFilters(Filters accountFilters) {
      this.accountFilters = accountFilters;
      return this;
    }
  }

  protected Account(Builder builder) {
    id = builder.id;
    accountFilters = builder.accountFilters;
  }

  /**
   * New builder.
   *
   * @return a Account builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Account identification.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the accountFilters.
   *
   * Filters for account and catalog filters.
   *
   * @return the accountFilters
   */
  public Filters accountFilters() {
    return accountFilters;
  }
}

