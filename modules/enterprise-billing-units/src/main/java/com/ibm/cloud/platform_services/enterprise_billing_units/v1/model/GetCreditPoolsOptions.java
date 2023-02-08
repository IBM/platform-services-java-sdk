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
 * The getCreditPools options.
 */
public class GetCreditPoolsOptions extends GenericModel {

  protected String billingUnitId;
  protected String date;
  protected String type;
  protected Long limit;
  protected Long start;

  /**
   * Builder.
   */
  public static class Builder {
    private String billingUnitId;
    private String date;
    private String type;
    private Long limit;
    private Long start;

    /**
     * Instantiates a new Builder from an existing GetCreditPoolsOptions instance.
     *
     * @param getCreditPoolsOptions the instance to initialize the Builder with
     */
    private Builder(GetCreditPoolsOptions getCreditPoolsOptions) {
      this.billingUnitId = getCreditPoolsOptions.billingUnitId;
      this.date = getCreditPoolsOptions.date;
      this.type = getCreditPoolsOptions.type;
      this.limit = getCreditPoolsOptions.limit;
      this.start = getCreditPoolsOptions.start;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param billingUnitId the billingUnitId
     */
    public Builder(String billingUnitId) {
      this.billingUnitId = billingUnitId;
    }

    /**
     * Builds a GetCreditPoolsOptions.
     *
     * @return the new GetCreditPoolsOptions instance
     */
    public GetCreditPoolsOptions build() {
      return new GetCreditPoolsOptions(this);
    }

    /**
     * Set the billingUnitId.
     *
     * @param billingUnitId the billingUnitId
     * @return the GetCreditPoolsOptions builder
     */
    public Builder billingUnitId(String billingUnitId) {
      this.billingUnitId = billingUnitId;
      return this;
    }

    /**
     * Set the date.
     *
     * @param date the date
     * @return the GetCreditPoolsOptions builder
     */
    public Builder date(String date) {
      this.date = date;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the GetCreditPoolsOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetCreditPoolsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the GetCreditPoolsOptions builder
     */
    public Builder start(long start) {
      this.start = start;
      return this;
    }
  }

  protected GetCreditPoolsOptions() { }

  protected GetCreditPoolsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.billingUnitId,
      "billingUnitId cannot be null");
    billingUnitId = builder.billingUnitId;
    date = builder.date;
    type = builder.type;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a GetCreditPoolsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the billingUnitId.
   *
   * The ID of the billing unit.
   *
   * @return the billingUnitId
   */
  public String billingUnitId() {
    return billingUnitId;
  }

  /**
   * Gets the date.
   *
   * The date in the format of YYYY-MM.
   *
   * @return the date
   */
  public String date() {
    return date;
  }

  /**
   * Gets the type.
   *
   * Filters the credit pool by type, either `PLATFORM` or `SUPPORT`.
   *
   * @return the type
   */
  public String type() {
    return type;
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
   * The pagination offset. This will be the index of the first returned result.
   *
   * @return the start
   */
  public Long start() {
    return start;
  }
}

