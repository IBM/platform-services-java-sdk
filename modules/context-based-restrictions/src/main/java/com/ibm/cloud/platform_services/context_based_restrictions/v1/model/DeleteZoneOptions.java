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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteZone options.
 */
public class DeleteZoneOptions extends GenericModel {

  protected String zoneId;
  protected String xCorrelationId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String zoneId;
    private String xCorrelationId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing DeleteZoneOptions instance.
     *
     * @param deleteZoneOptions the instance to initialize the Builder with
     */
    private Builder(DeleteZoneOptions deleteZoneOptions) {
      this.zoneId = deleteZoneOptions.zoneId;
      this.xCorrelationId = deleteZoneOptions.xCorrelationId;
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
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the DeleteZoneOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteZoneOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteZoneOptions() { }

  protected DeleteZoneOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.zoneId,
      "zoneId cannot be empty");
    zoneId = builder.zoneId;
    xCorrelationId = builder.xCorrelationId;
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
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this headers is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the transactionId.
   *
   * The `Transaction-Id` header behaves as the `X-Correlation-Id` header. It is supported for backward compatibility
   * with other IBM platform services that support the `Transaction-Id` header only. If both `X-Correlation-Id` and
   * `Transaction-Id` are provided, `X-Correlation-Id` has the precedence over `Transaction-Id`.
   *
   * @return the transactionId
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String transactionId() {
    return transactionId;
  }
}

