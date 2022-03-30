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
 * The createReport options.
 */
public class CreateReportOptions extends GenericModel {

  protected String accountId;
  protected String type;
  protected String duration;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String type;
    private String duration;

    private Builder(CreateReportOptions createReportOptions) {
      this.accountId = createReportOptions.accountId;
      this.type = createReportOptions.type;
      this.duration = createReportOptions.duration;
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
     * Builds a CreateReportOptions.
     *
     * @return the new CreateReportOptions instance
     */
    public CreateReportOptions build() {
      return new CreateReportOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateReportOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateReportOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the duration.
     *
     * @param duration the duration
     * @return the CreateReportOptions builder
     */
    public Builder duration(String duration) {
      this.duration = duration;
      return this;
    }
  }

  protected CreateReportOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    type = builder.type;
    duration = builder.duration;
  }

  /**
   * New builder.
   *
   * @return a CreateReportOptions builder
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
   * Optional report type, supported value is 'inactive' - List all identities that have not authenticated within the
   * time indicated by duration.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the duration.
   *
   * Optional duration of the report, supported unit of duration is hours.
   *
   * @return the duration
   */
  public String duration() {
    return duration;
  }
}

