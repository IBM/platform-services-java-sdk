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
package com.ibm.cloud.platform_services.partner_billing_units.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCreditPoolsReport options.
 */
public class GetCreditPoolsReportOptions extends GenericModel {

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
     * Instantiates a new Builder from an existing GetCreditPoolsReportOptions instance.
     *
     * @param getCreditPoolsReportOptions the instance to initialize the Builder with
     */
    private Builder(GetCreditPoolsReportOptions getCreditPoolsReportOptions) {
      this.partnerId = getCreditPoolsReportOptions.partnerId;
      this.customerId = getCreditPoolsReportOptions.customerId;
      this.resellerId = getCreditPoolsReportOptions.resellerId;
      this.date = getCreditPoolsReportOptions.date;
      this.limit = getCreditPoolsReportOptions.limit;
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
     * Builds a GetCreditPoolsReportOptions.
     *
     * @return the new GetCreditPoolsReportOptions instance
     */
    public GetCreditPoolsReportOptions build() {
      return new GetCreditPoolsReportOptions(this);
    }

    /**
     * Set the partnerId.
     *
     * @param partnerId the partnerId
     * @return the GetCreditPoolsReportOptions builder
     */
    public Builder partnerId(String partnerId) {
      this.partnerId = partnerId;
      return this;
    }

    /**
     * Set the customerId.
     *
     * @param customerId the customerId
     * @return the GetCreditPoolsReportOptions builder
     */
    public Builder customerId(String customerId) {
      this.customerId = customerId;
      return this;
    }

    /**
     * Set the resellerId.
     *
     * @param resellerId the resellerId
     * @return the GetCreditPoolsReportOptions builder
     */
    public Builder resellerId(String resellerId) {
      this.resellerId = resellerId;
      return this;
    }

    /**
     * Set the date.
     *
     * @param date the date
     * @return the GetCreditPoolsReportOptions builder
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetCreditPoolsReportOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected GetCreditPoolsReportOptions() { }

  protected GetCreditPoolsReportOptions(Builder builder) {
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
   * @return a GetCreditPoolsReportOptions builder
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
   * Enterprise ID of the customer for which the report is requested.
   *
   * @return the customerId
   */
  public String customerId() {
    return customerId;
  }

  /**
   * Gets the resellerId.
   *
   * Enterprise ID of the reseller for which the report is requested.
   *
   * @return the resellerId
   */
  public String resellerId() {
    return resellerId;
  }

  /**
   * Gets the date.
   *
   * The billing month for which the usage report is requested. Format is yyyy-mm. Defaults to current month.
   *
   * @return the date
   */
  public String date() {
    return date;
  }

  /**
   * Gets the limit.
   *
   * Number of usage records returned. The default value is 30. Maximum value is 200.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

