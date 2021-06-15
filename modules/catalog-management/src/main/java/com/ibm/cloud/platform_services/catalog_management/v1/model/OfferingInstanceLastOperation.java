/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * the last operation performed and status.
 */
public class OfferingInstanceLastOperation extends GenericModel {

  protected String operation;
  protected String state;
  protected String message;
  @SerializedName("transaction_id")
  protected String transactionId;
  protected String updated;

  /**
   * Builder.
   */
  public static class Builder {
    private String operation;
    private String state;
    private String message;
    private String transactionId;
    private String updated;

    private Builder(OfferingInstanceLastOperation offeringInstanceLastOperation) {
      this.operation = offeringInstanceLastOperation.operation;
      this.state = offeringInstanceLastOperation.state;
      this.message = offeringInstanceLastOperation.message;
      this.transactionId = offeringInstanceLastOperation.transactionId;
      this.updated = offeringInstanceLastOperation.updated;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a OfferingInstanceLastOperation.
     *
     * @return the new OfferingInstanceLastOperation instance
     */
    public OfferingInstanceLastOperation build() {
      return new OfferingInstanceLastOperation(this);
    }

    /**
     * Set the operation.
     *
     * @param operation the operation
     * @return the OfferingInstanceLastOperation builder
     */
    public Builder operation(String operation) {
      this.operation = operation;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the OfferingInstanceLastOperation builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the message.
     *
     * @param message the message
     * @return the OfferingInstanceLastOperation builder
     */
    public Builder message(String message) {
      this.message = message;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the OfferingInstanceLastOperation builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the updated.
     *
     * @param updated the updated
     * @return the OfferingInstanceLastOperation builder
     */
    public Builder updated(String updated) {
      this.updated = updated;
      return this;
    }
  }

  protected OfferingInstanceLastOperation(Builder builder) {
    operation = builder.operation;
    state = builder.state;
    message = builder.message;
    transactionId = builder.transactionId;
    updated = builder.updated;
  }

  /**
   * New builder.
   *
   * @return a OfferingInstanceLastOperation builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the operation.
   *
   * last operation performed.
   *
   * @return the operation
   */
  public String operation() {
    return operation;
  }

  /**
   * Gets the state.
   *
   * state after the last operation performed.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the message.
   *
   * additional information about the last operation.
   *
   * @return the message
   */
  public String message() {
    return message;
  }

  /**
   * Gets the transactionId.
   *
   * transaction id from the last operation.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the updated.
   *
   * Date and time last updated.
   *
   * @return the updated
   */
  public String updated() {
    return updated;
  }
}

