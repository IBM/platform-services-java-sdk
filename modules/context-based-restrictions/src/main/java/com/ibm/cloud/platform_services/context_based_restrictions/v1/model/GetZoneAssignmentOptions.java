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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getZoneAssignment options.
 */
public class GetZoneAssignmentOptions extends GenericModel {

  protected String zoneAssignmentId;
  protected String xCorrelationId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String zoneAssignmentId;
    private String xCorrelationId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing GetZoneAssignmentOptions instance.
     *
     * @param getZoneAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(GetZoneAssignmentOptions getZoneAssignmentOptions) {
      this.zoneAssignmentId = getZoneAssignmentOptions.zoneAssignmentId;
      this.xCorrelationId = getZoneAssignmentOptions.xCorrelationId;
      this.transactionId = getZoneAssignmentOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param zoneAssignmentId the zoneAssignmentId
     */
    public Builder(String zoneAssignmentId) {
      this.zoneAssignmentId = zoneAssignmentId;
    }

    /**
     * Builds a GetZoneAssignmentOptions.
     *
     * @return the new GetZoneAssignmentOptions instance
     */
    public GetZoneAssignmentOptions build() {
      return new GetZoneAssignmentOptions(this);
    }

    /**
     * Set the zoneAssignmentId.
     *
     * @param zoneAssignmentId the zoneAssignmentId
     * @return the GetZoneAssignmentOptions builder
     */
    public Builder zoneAssignmentId(String zoneAssignmentId) {
      this.zoneAssignmentId = zoneAssignmentId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the GetZoneAssignmentOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetZoneAssignmentOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetZoneAssignmentOptions() { }

  protected GetZoneAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.zoneAssignmentId,
      "zoneAssignmentId cannot be empty");
    zoneAssignmentId = builder.zoneAssignmentId;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetZoneAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the zoneAssignmentId.
   *
   * The ID of a zone assignment.
   *
   * @return the zoneAssignmentId
   */
  public String zoneAssignmentId() {
    return zoneAssignmentId;
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

