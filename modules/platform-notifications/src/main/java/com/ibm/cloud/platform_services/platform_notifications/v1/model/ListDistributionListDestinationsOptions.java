/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listDistributionListDestinations options.
 */
public class ListDistributionListDestinationsOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    /**
     * Instantiates a new Builder from an existing ListDistributionListDestinationsOptions instance.
     *
     * @param listDistributionListDestinationsOptions the instance to initialize the Builder with
     */
    private Builder(ListDistributionListDestinationsOptions listDistributionListDestinationsOptions) {
      this.accountId = listDistributionListDestinationsOptions.accountId;
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
     * Builds a ListDistributionListDestinationsOptions.
     *
     * @return the new ListDistributionListDestinationsOptions instance
     */
    public ListDistributionListDestinationsOptions build() {
      return new ListDistributionListDestinationsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListDistributionListDestinationsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected ListDistributionListDestinationsOptions() { }

  protected ListDistributionListDestinationsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a ListDistributionListDestinationsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

