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
 * The getDistributionListDestination options.
 */
public class GetDistributionListDestinationOptions extends GenericModel {

  protected String accountId;
  protected String destinationId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String destinationId;

    /**
     * Instantiates a new Builder from an existing GetDistributionListDestinationOptions instance.
     *
     * @param getDistributionListDestinationOptions the instance to initialize the Builder with
     */
    private Builder(GetDistributionListDestinationOptions getDistributionListDestinationOptions) {
      this.accountId = getDistributionListDestinationOptions.accountId;
      this.destinationId = getDistributionListDestinationOptions.destinationId;
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
     * @param destinationId the destinationId
     */
    public Builder(String accountId, String destinationId) {
      this.accountId = accountId;
      this.destinationId = destinationId;
    }

    /**
     * Builds a GetDistributionListDestinationOptions.
     *
     * @return the new GetDistributionListDestinationOptions instance
     */
    public GetDistributionListDestinationOptions build() {
      return new GetDistributionListDestinationOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetDistributionListDestinationOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the destinationId.
     *
     * @param destinationId the destinationId
     * @return the GetDistributionListDestinationOptions builder
     */
    public Builder destinationId(String destinationId) {
      this.destinationId = destinationId;
      return this;
    }
  }

  protected GetDistributionListDestinationOptions() { }

  protected GetDistributionListDestinationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.destinationId,
      "destinationId cannot be empty");
    accountId = builder.accountId;
    destinationId = builder.destinationId;
  }

  /**
   * New builder.
   *
   * @return a GetDistributionListDestinationOptions builder
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

  /**
   * Gets the destinationId.
   *
   * The ID of the destination.
   *
   * @return the destinationId
   */
  public String destinationId() {
    return destinationId;
  }
}

