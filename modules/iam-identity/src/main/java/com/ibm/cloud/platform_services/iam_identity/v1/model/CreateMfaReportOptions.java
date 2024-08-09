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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createMfaReport options.
 */
public class CreateMfaReportOptions extends GenericModel {

  protected String accountId;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String type;

    /**
     * Instantiates a new Builder from an existing CreateMfaReportOptions instance.
     *
     * @param createMfaReportOptions the instance to initialize the Builder with
     */
    private Builder(CreateMfaReportOptions createMfaReportOptions) {
      this.accountId = createMfaReportOptions.accountId;
      this.type = createMfaReportOptions.type;
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
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a CreateMfaReportOptions.
     *
     * @return the new CreateMfaReportOptions instance
     */
    public CreateMfaReportOptions build() {
      return new CreateMfaReportOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateMfaReportOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateMfaReportOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected CreateMfaReportOptions() { }

  protected CreateMfaReportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a CreateMfaReportOptions builder
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
   * Gets the type.
   *
   * Optional report type. The supported value is 'mfa_status'. List MFA enrollment status for all the identities.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

