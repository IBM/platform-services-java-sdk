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
 * The deleteZoneAssignment options.
 */
public class DeleteZoneAssignmentOptions extends GenericModel {

  protected String zoneAssignmentId;
  protected String xCorrelationId;
  protected String transactionId;
  protected Boolean force;

  /**
   * Builder.
   */
  public static class Builder {
    private String zoneAssignmentId;
    private String xCorrelationId;
    private String transactionId;
    private Boolean force;

    /**
     * Instantiates a new Builder from an existing DeleteZoneAssignmentOptions instance.
     *
     * @param deleteZoneAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(DeleteZoneAssignmentOptions deleteZoneAssignmentOptions) {
      this.zoneAssignmentId = deleteZoneAssignmentOptions.zoneAssignmentId;
      this.xCorrelationId = deleteZoneAssignmentOptions.xCorrelationId;
      this.transactionId = deleteZoneAssignmentOptions.transactionId;
      this.force = deleteZoneAssignmentOptions.force;
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
     * Builds a DeleteZoneAssignmentOptions.
     *
     * @return the new DeleteZoneAssignmentOptions instance
     */
    public DeleteZoneAssignmentOptions build() {
      return new DeleteZoneAssignmentOptions(this);
    }

    /**
     * Set the zoneAssignmentId.
     *
     * @param zoneAssignmentId the zoneAssignmentId
     * @return the DeleteZoneAssignmentOptions builder
     */
    public Builder zoneAssignmentId(String zoneAssignmentId) {
      this.zoneAssignmentId = zoneAssignmentId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the DeleteZoneAssignmentOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteZoneAssignmentOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the force.
     *
     * @param force the force
     * @return the DeleteZoneAssignmentOptions builder
     */
    public Builder force(Boolean force) {
      this.force = force;
      return this;
    }
  }

  protected DeleteZoneAssignmentOptions() { }

  protected DeleteZoneAssignmentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.zoneAssignmentId,
      "zoneAssignmentId cannot be empty");
    zoneAssignmentId = builder.zoneAssignmentId;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
    force = builder.force;
  }

  /**
   * New builder.
   *
   * @return a DeleteZoneAssignmentOptions builder
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

  /**
   * Gets the force.
   *
   * If `true`, references to the shared zone are automatically removed from any rules in target accounts that are being
   * unshared as a result of this deletion — specifically, accounts that are not covered by another zone assignment.
   * Without this flag, the unshare will fail for any such account whose rules still reference the zone, causing the
   * overall assignment deletion to fail. Failures in one target account do not prevent the unshare from proceeding in
   * other target accounts.
   *
   * @return the force
   */
  public Boolean force() {
    return force;
  }
}

