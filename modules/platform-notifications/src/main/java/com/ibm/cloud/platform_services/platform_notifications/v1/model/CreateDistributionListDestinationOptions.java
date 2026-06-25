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
 * The createDistributionListDestination options.
 */
public class CreateDistributionListDestinationOptions extends GenericModel {

  protected String accountId;
  protected AddDestinationPrototype addDestinationPrototype;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private AddDestinationPrototype addDestinationPrototype;

    /**
     * Instantiates a new Builder from an existing CreateDistributionListDestinationOptions instance.
     *
     * @param createDistributionListDestinationOptions the instance to initialize the Builder with
     */
    private Builder(CreateDistributionListDestinationOptions createDistributionListDestinationOptions) {
      this.accountId = createDistributionListDestinationOptions.accountId;
      this.addDestinationPrototype = createDistributionListDestinationOptions.addDestinationPrototype;
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
     * @param addDestinationPrototype the addDestinationPrototype
     */
    public Builder(String accountId, AddDestinationPrototype addDestinationPrototype) {
      this.accountId = accountId;
      this.addDestinationPrototype = addDestinationPrototype;
    }

    /**
     * Builds a CreateDistributionListDestinationOptions.
     *
     * @return the new CreateDistributionListDestinationOptions instance
     */
    public CreateDistributionListDestinationOptions build() {
      return new CreateDistributionListDestinationOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateDistributionListDestinationOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the addDestinationPrototype.
     *
     * @param addDestinationPrototype the addDestinationPrototype
     * @return the CreateDistributionListDestinationOptions builder
     */
    public Builder addDestinationPrototype(AddDestinationPrototype addDestinationPrototype) {
      this.addDestinationPrototype = addDestinationPrototype;
      return this;
    }
  }

  protected CreateDistributionListDestinationOptions() { }

  protected CreateDistributionListDestinationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.addDestinationPrototype,
      "addDestinationPrototype cannot be null");
    accountId = builder.accountId;
    addDestinationPrototype = builder.addDestinationPrototype;
  }

  /**
   * New builder.
   *
   * @return a CreateDistributionListDestinationOptions builder
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
   * Gets the addDestinationPrototype.
   *
   * @return the addDestinationPrototype
   */
  public AddDestinationPrototype addDestinationPrototype() {
    return addDestinationPrototype;
  }
}

