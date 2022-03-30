/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getReport options.
 */
public class GetReportOptions extends GenericModel {

  protected String accountId;
  protected String reference;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String reference;

    private Builder(GetReportOptions getReportOptions) {
      this.accountId = getReportOptions.accountId;
      this.reference = getReportOptions.reference;
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
     * @param reference the reference
     */
    public Builder(String accountId, String reference) {
      this.accountId = accountId;
      this.reference = reference;
    }

    /**
     * Builds a GetReportOptions.
     *
     * @return the new GetReportOptions instance
     */
    public GetReportOptions build() {
      return new GetReportOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetReportOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the reference.
     *
     * @param reference the reference
     * @return the GetReportOptions builder
     */
    public Builder reference(String reference) {
      this.reference = reference;
      return this;
    }
  }

  protected GetReportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.reference,
      "reference cannot be empty");
    accountId = builder.accountId;
    reference = builder.reference;
  }

  /**
   * New builder.
   *
   * @return a GetReportOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * ID of the account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the reference.
   *
   * Reference for the report to be generated, You can use 'latest' to get the latest report for the given account.
   *
   * @return the reference
   */
  public String reference() {
    return reference;
  }
}

