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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCreditPools options.
 */
public class GetCreditPoolsOptions extends GenericModel {

  protected String billingUnitId;
  protected String date;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String billingUnitId;
    private String date;
    private String type;

    private Builder(GetCreditPoolsOptions getCreditPoolsOptions) {
      this.billingUnitId = getCreditPoolsOptions.billingUnitId;
      this.date = getCreditPoolsOptions.date;
      this.type = getCreditPoolsOptions.type;
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
  }

  protected GetCreditPoolsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.billingUnitId,
      "billingUnitId cannot be null");
    billingUnitId = builder.billingUnitId;
    date = builder.date;
    type = builder.type;
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
}

