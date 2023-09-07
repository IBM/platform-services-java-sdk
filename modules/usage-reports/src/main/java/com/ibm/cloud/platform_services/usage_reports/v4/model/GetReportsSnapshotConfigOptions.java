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
 * The getReportsSnapshotConfig options.
 */
public class GetReportsSnapshotConfigOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    /**
     * Instantiates a new Builder from an existing GetReportsSnapshotConfigOptions instance.
     *
     * @param getReportsSnapshotConfigOptions the instance to initialize the Builder with
     */
    private Builder(GetReportsSnapshotConfigOptions getReportsSnapshotConfigOptions) {
      this.accountId = getReportsSnapshotConfigOptions.accountId;
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
     * Builds a GetReportsSnapshotConfigOptions.
     *
     * @return the new GetReportsSnapshotConfigOptions instance
     */
    public GetReportsSnapshotConfigOptions build() {
      return new GetReportsSnapshotConfigOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetReportsSnapshotConfigOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected GetReportsSnapshotConfigOptions() { }

  protected GetReportsSnapshotConfigOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a GetReportsSnapshotConfigOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID for which the billing report snapshot is configured.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

