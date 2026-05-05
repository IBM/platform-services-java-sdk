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
 * The testDistributionListDestination options.
 */
public class TestDistributionListDestinationOptions extends GenericModel {

  protected String accountId;
  protected String destinationId;
  protected TestDestinationRequestBodyPrototype testDestinationRequestBodyPrototype;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String destinationId;
    private TestDestinationRequestBodyPrototype testDestinationRequestBodyPrototype;

    /**
     * Instantiates a new Builder from an existing TestDistributionListDestinationOptions instance.
     *
     * @param testDistributionListDestinationOptions the instance to initialize the Builder with
     */
    private Builder(TestDistributionListDestinationOptions testDistributionListDestinationOptions) {
      this.accountId = testDistributionListDestinationOptions.accountId;
      this.destinationId = testDistributionListDestinationOptions.destinationId;
      this.testDestinationRequestBodyPrototype = testDistributionListDestinationOptions.testDestinationRequestBodyPrototype;
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
     * @param testDestinationRequestBodyPrototype the testDestinationRequestBodyPrototype
     */
    public Builder(String accountId, String destinationId, TestDestinationRequestBodyPrototype testDestinationRequestBodyPrototype) {
      this.accountId = accountId;
      this.destinationId = destinationId;
      this.testDestinationRequestBodyPrototype = testDestinationRequestBodyPrototype;
    }

    /**
     * Builds a TestDistributionListDestinationOptions.
     *
     * @return the new TestDistributionListDestinationOptions instance
     */
    public TestDistributionListDestinationOptions build() {
      return new TestDistributionListDestinationOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the TestDistributionListDestinationOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the destinationId.
     *
     * @param destinationId the destinationId
     * @return the TestDistributionListDestinationOptions builder
     */
    public Builder destinationId(String destinationId) {
      this.destinationId = destinationId;
      return this;
    }

    /**
     * Set the testDestinationRequestBodyPrototype.
     *
     * @param testDestinationRequestBodyPrototype the testDestinationRequestBodyPrototype
     * @return the TestDistributionListDestinationOptions builder
     */
    public Builder testDestinationRequestBodyPrototype(TestDestinationRequestBodyPrototype testDestinationRequestBodyPrototype) {
      this.testDestinationRequestBodyPrototype = testDestinationRequestBodyPrototype;
      return this;
    }
  }

  protected TestDistributionListDestinationOptions() { }

  protected TestDistributionListDestinationOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.destinationId,
      "destinationId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.testDestinationRequestBodyPrototype,
      "testDestinationRequestBodyPrototype cannot be null");
    accountId = builder.accountId;
    destinationId = builder.destinationId;
    testDestinationRequestBodyPrototype = builder.testDestinationRequestBodyPrototype;
  }

  /**
   * New builder.
   *
   * @return a TestDistributionListDestinationOptions builder
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

  /**
   * Gets the testDestinationRequestBodyPrototype.
   *
   * @return the testDestinationRequestBodyPrototype
   */
  public TestDestinationRequestBodyPrototype testDestinationRequestBodyPrototype() {
    return testDestinationRequestBodyPrototype;
  }
}

