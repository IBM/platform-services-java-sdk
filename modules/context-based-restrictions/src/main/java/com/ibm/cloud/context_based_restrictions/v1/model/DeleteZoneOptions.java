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
package com.ibm.cloud.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteZone options.
 */
public class DeleteZoneOptions extends GenericModel {

  protected String zoneId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String zoneId;
    private String transactionId;

    private Builder(DeleteZoneOptions deleteZoneOptions) {
      this.zoneId = deleteZoneOptions.zoneId;
      this.transactionId = deleteZoneOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param zoneId the zoneId
     */
    public Builder(String zoneId) {
      this.zoneId = zoneId;
    }

    /**
     * Builds a DeleteZoneOptions.
     *
     * @return the new DeleteZoneOptions instance
     */
    public DeleteZoneOptions build() {
      return new DeleteZoneOptions(this);
    }

    /**
     * Set the zoneId.
     *
     * @param zoneId the zoneId
     * @return the DeleteZoneOptions builder
     */
    public Builder zoneId(String zoneId) {
      this.zoneId = zoneId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteZoneOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteZoneOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.zoneId,
      "zoneId cannot be empty");
    zoneId = builder.zoneId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteZoneOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the zoneId.
   *
   * The ID of a zone.
   *
   * @return the zoneId
   */
  public String zoneId() {
    return zoneId;
  }

  /**
   * Gets the transactionId.
   *
   * The UUID that is used to correlate and track transactions. If you omit this field, the service generates and sends
   * a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

