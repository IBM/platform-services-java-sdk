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

package com.ibm.cloud.platform_services.partner_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getBillingOptions options.
 */
public class GetBillingOptionsOptions extends GenericModel {

  protected String partnerId;
  protected String customerId;
  protected String resellerId;
  protected String date;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String partnerId;
    private String customerId;
    private String resellerId;
    private String date;
    private Long limit;

    /**
     * Instantiates a new Builder from an existing GetBillingOptionsOptions instance.
     *
     * @param getBillingOptionsOptions the instance to initialize the Builder with
     */
    private Builder(GetBillingOptionsOptions getBillingOptionsOptions) {
      this.partnerId = getBillingOptionsOptions.partnerId;
      this.customerId = getBillingOptionsOptions.customerId;
      this.resellerId = getBillingOptionsOptions.resellerId;
      this.date = getBillingOptionsOptions.date;
      this.limit = getBillingOptionsOptions.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param partnerId the partnerId
     */
    public Builder(String partnerId) {
      this.partnerId = partnerId;
    }

    /**
     * Builds a GetBillingOptionsOptions.
     *
     * @return the new GetBillingOptionsOptions instance
     */
    public GetBillingOptionsOptions build() {
      return new GetBillingOptionsOptions(this);
    }

    /**
     * Set the partnerId.
     *
     * @param partnerId the partnerId
     * @return the GetBillingOptionsOptions builder
     */
    public Builder partnerId(String partnerId) {
      this.partnerId = partnerId;
      return this;
    }

    /**
     * Set the customerId.
     *
     * @param customerId the customerId
     * @return the GetBillingOptionsOptions builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    /**
     * Set the resellerId.
     *
     * @param resellerId the resellerId
     * @return the GetBillingOptionsOptions builder
     */
    public Builder resellerId(String resellerId) {
      this.resellerId = resellerId;
      return this;
    }

    /**
     * Set the date.
     *
     * @param date the date
     * @return the GetBillingOptionsOptions builder
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetBillingOptionsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected GetBillingOptionsOptions() { }

  protected GetBillingOptionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.partnerId,
      "partnerId cannot be null");
    partnerId = builder.partnerId;
    customerId = builder.customerId;
    resellerId = builder.resellerId;
    date = builder.date;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a GetBillingOptionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the partnerId.
   *
   * Enterprise ID of the distributor or reseller for which the report is requested.
   *
   * @return the partnerId
   */
  public String partnerId() {
    return partnerId;
  }

  /**
   * Gets the customerId.
   *
   * Account ID/Enterprise ID of the end customer for which the report is requested. This parameter cannot be used along
   * with `reseller_id` query parameter.
   *
   * @return the customerId
   */
  public String customerId() {
    return customerId;
  }

  /**
   * Gets the resellerId.
   *
   * Enterprise ID of the reseller for which the report is requested. This parameter cannot be used along with
   * `customer_id` query parameter.
   *
   * @return the resellerId
   */
  public String resellerId() {
    return resellerId;
  }

  /**
   * Gets the date.
   *
   * The billing month for which the report is requested. Format is yyyy-mm. Defaults to current month.
   *
   * @return the date
   */
  public String date() {
    return date;
  }

  /**
   * Gets the limit.
   *
   * Number of billing option reports returned. The default value is 200. Maximum value is 200.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

