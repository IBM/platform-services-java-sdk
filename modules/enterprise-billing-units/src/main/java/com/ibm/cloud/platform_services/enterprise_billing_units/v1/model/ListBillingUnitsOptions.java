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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listBillingUnits options.
 */
public class ListBillingUnitsOptions extends GenericModel {

  protected String accountId;
  protected String enterpriseId;
  protected String accountGroupId;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String enterpriseId;
    private String accountGroupId;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListBillingUnitsOptions instance.
     *
     * @param listBillingUnitsOptions the instance to initialize the Builder with
     */
    private Builder(ListBillingUnitsOptions listBillingUnitsOptions) {
      this.accountId = listBillingUnitsOptions.accountId;
      this.enterpriseId = listBillingUnitsOptions.enterpriseId;
      this.accountGroupId = listBillingUnitsOptions.accountGroupId;
      this.limit = listBillingUnitsOptions.limit;
      this.start = listBillingUnitsOptions.start;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListBillingUnitsOptions.
     *
     * @return the new ListBillingUnitsOptions instance
     */
    public ListBillingUnitsOptions build() {
      return new ListBillingUnitsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListBillingUnitsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the enterpriseId.
     *
     * @param enterpriseId the enterpriseId
     * @return the ListBillingUnitsOptions builder
     */
    public Builder enterpriseId(String enterpriseId) {
      this.enterpriseId = enterpriseId;
      return this;
    }

    /**
     * Set the accountGroupId.
     *
     * @param accountGroupId the accountGroupId
     * @return the ListBillingUnitsOptions builder
     */
    public Builder accountGroupId(String accountGroupId) {
      this.accountGroupId = accountGroupId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListBillingUnitsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListBillingUnitsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListBillingUnitsOptions() { }

  protected ListBillingUnitsOptions(Builder builder) {
    accountId = builder.accountId;
    enterpriseId = builder.enterpriseId;
    accountGroupId = builder.accountGroupId;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListBillingUnitsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The enterprise account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the enterpriseId.
   *
   * The enterprise ID.
   *
   * @return the enterpriseId
   */
  public String enterpriseId() {
    return enterpriseId;
  }

  /**
   * Gets the accountGroupId.
   *
   * The account group ID.
   *
   * @return the accountGroupId
   */
  public String accountGroupId() {
    return accountGroupId;
  }

  /**
   * Gets the limit.
   *
   * Return results up to this limit. Valid values are between 0 and 100.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * The pagination offset. This represents the index of the first returned result.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

