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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getAccountSummary options.
 */
public class GetAccountSummaryOptions extends GenericModel {

  protected String accountId;
  protected String billingmonth;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String billingmonth;

    /**
     * Instantiates a new Builder from an existing GetAccountSummaryOptions instance.
     *
     * @param getAccountSummaryOptions the instance to initialize the Builder with
     */
    private Builder(GetAccountSummaryOptions getAccountSummaryOptions) {
      this.accountId = getAccountSummaryOptions.accountId;
      this.billingmonth = getAccountSummaryOptions.billingmonth;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param billingmonth the billingmonth
     */
    public Builder(String accountId, String billingmonth) {
      this.accountId = accountId;
      this.billingmonth = billingmonth;
    }

    /**
     * Builds a GetAccountSummaryOptions.
     *
     * @return the new GetAccountSummaryOptions instance
     */
    public GetAccountSummaryOptions build() {
      return new GetAccountSummaryOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetAccountSummaryOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the billingmonth.
     *
     * @param billingmonth the billingmonth
     * @return the GetAccountSummaryOptions builder
     */
    public Builder billingmonth(String billingmonth) {
      this.billingmonth = billingmonth;
      return this;
    }
  }

  protected GetAccountSummaryOptions() { }

  protected GetAccountSummaryOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.billingmonth,
      "billingmonth cannot be empty");
    accountId = builder.accountId;
    billingmonth = builder.billingmonth;
  }

  /**
   * New builder.
   *
   * @return a GetAccountSummaryOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID for which the usage report is requested.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the billingmonth.
   *
   * The billing month for which the usage report is requested.  Format is yyyy-mm.
   *
   * @return the billingmonth
   */
  public String billingmonth() {
    return billingmonth;
  }
}

