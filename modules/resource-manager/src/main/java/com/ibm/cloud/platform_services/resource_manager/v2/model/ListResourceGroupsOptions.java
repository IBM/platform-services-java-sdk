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
package com.ibm.cloud.platform_services.resource_manager.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listResourceGroups options.
 */
public class ListResourceGroupsOptions extends GenericModel {

  protected String accountId;
  protected String date;
  protected String name;
  protected Boolean xDefault;
  protected Boolean includeDeleted;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String date;
    private String name;
    private Boolean xDefault;
    private Boolean includeDeleted;

    private Builder(ListResourceGroupsOptions listResourceGroupsOptions) {
      this.accountId = listResourceGroupsOptions.accountId;
      this.date = listResourceGroupsOptions.date;
      this.name = listResourceGroupsOptions.name;
      this.xDefault = listResourceGroupsOptions.xDefault;
      this.includeDeleted = listResourceGroupsOptions.includeDeleted;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListResourceGroupsOptions.
     *
     * @return the new ListResourceGroupsOptions instance
     */
    public ListResourceGroupsOptions build() {
      return new ListResourceGroupsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListResourceGroupsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the date.
     *
     * @param date the date
     * @return the ListResourceGroupsOptions builder
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListResourceGroupsOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the xDefault.
     *
     * @param xDefault the xDefault
     * @return the ListResourceGroupsOptions builder
     */
    public Builder xDefault(Boolean xDefault) {
      this.xDefault = xDefault;
      return this;
    }

    /**
     * Set the includeDeleted.
     *
     * @param includeDeleted the includeDeleted
     * @return the ListResourceGroupsOptions builder
     */
    public Builder includeDeleted(Boolean includeDeleted) {
      this.includeDeleted = includeDeleted;
      return this;
    }
  }

  protected ListResourceGroupsOptions(Builder builder) {
    accountId = builder.accountId;
    date = builder.date;
    name = builder.name;
    xDefault = builder.xDefault;
    includeDeleted = builder.includeDeleted;
  }

  /**
   * New builder.
   *
   * @return a ListResourceGroupsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account that contains the resource groups that you want to get.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the date.
   *
   * The date in the format of YYYY-MM which returns resource groups. Deleted resource groups will be excluded before
   * this month.
   *
   * @return the date
   */
  public String date() {
    return date;
  }

  /**
   * Gets the name.
   *
   * The name of the resource group.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the xDefault.
   *
   * Boolean value to specify whether or not to list default resource groups.
   *
   * @return the xDefault
   */
  public Boolean xDefault() {
    return xDefault;
  }

  /**
   * Gets the includeDeleted.
   *
   * Boolean value to specify whether or not to list default resource groups.
   *
   * @return the includeDeleted
   */
  public Boolean includeDeleted() {
    return includeDeleted;
  }
}

