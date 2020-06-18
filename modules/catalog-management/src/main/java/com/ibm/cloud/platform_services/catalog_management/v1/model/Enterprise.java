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
 * Enterprise account information.
 */
public class Enterprise extends GenericModel {

  protected String id;
  @SerializedName("_rev")
  protected String rev;
  @SerializedName("account_filters")
  protected Filters accountFilters;
  @SerializedName("account_groups")
  protected EnterpriseAccountGroups accountGroups;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String rev;
    private Filters accountFilters;
    private EnterpriseAccountGroups accountGroups;

    private Builder(Enterprise enterprise) {
      this.id = enterprise.id;
      this.rev = enterprise.rev;
      this.accountFilters = enterprise.accountFilters;
      this.accountGroups = enterprise.accountGroups;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Enterprise.
     *
     * @return the new Enterprise instance
     */
    public Enterprise build() {
      return new Enterprise(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the Enterprise builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the Enterprise builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the accountFilters.
     *
     * @param accountFilters the accountFilters
     * @return the Enterprise builder
     */
    public Builder accountFilters(Filters accountFilters) {
      this.accountFilters = accountFilters;
      return this;
    }

    /**
     * Set the accountGroups.
     *
     * @param accountGroups the accountGroups
     * @return the Enterprise builder
     */
    public Builder accountGroups(EnterpriseAccountGroups accountGroups) {
      this.accountGroups = accountGroups;
      return this;
    }
  }

  protected Enterprise(Builder builder) {
    id = builder.id;
    rev = builder.rev;
    accountFilters = builder.accountFilters;
    accountGroups = builder.accountGroups;
  }

  /**
   * New builder.
   *
   * @return a Enterprise builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Enterprise identification.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the rev.
   *
   * Cloudant revision.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
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

  /**
   * Gets the accountGroups.
   *
   * Map of account group ids to AccountGroup objects.
   *
   * @return the accountGroups
   */
  public EnterpriseAccountGroups accountGroups() {
    return accountGroups;
  }
}

