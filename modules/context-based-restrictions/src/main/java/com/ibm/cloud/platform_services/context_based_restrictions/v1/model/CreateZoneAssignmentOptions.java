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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createZoneAssignment options.
 */
public class CreateZoneAssignmentOptions extends GenericModel {

  protected String accountId;
  protected EnterpriseTarget target;
  protected List<ZoneAssignmentZoneSpec> zones;
  protected String xCorrelationId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private EnterpriseTarget target;
    private List<ZoneAssignmentZoneSpec> zones;
    private String xCorrelationId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateZoneAssignmentOptions instance.
     *
     * @param createZoneAssignmentOptions the instance to initialize the Builder with
     */
    private Builder(CreateZoneAssignmentOptions createZoneAssignmentOptions) {
      this.accountId = createZoneAssignmentOptions.accountId;
      this.target = createZoneAssignmentOptions.target;
      this.zones = createZoneAssignmentOptions.zones;
      this.xCorrelationId = createZoneAssignmentOptions.xCorrelationId;
      this.transactionId = createZoneAssignmentOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateZoneAssignmentOptions.
     *
     * @return the new CreateZoneAssignmentOptions instance
     */
    public CreateZoneAssignmentOptions build() {
      return new CreateZoneAssignmentOptions(this);
    }

    /**
     * Adds a new element to zones.
     *
     * @param zones the new element to be added
     * @return the CreateZoneAssignmentOptions builder
     */
    public Builder addZones(ZoneAssignmentZoneSpec zones) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(zones,
        "zones cannot be null");
      if (this.zones == null) {
        this.zones = new ArrayList<ZoneAssignmentZoneSpec>();
      }
      this.zones.add(zones);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateZoneAssignmentOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateZoneAssignmentOptions builder
     */
    public Builder target(EnterpriseTarget target) {
      this.target = target;
      return this;
    }

    /**
     * Set the zones.
     * Existing zones will be replaced.
     *
     * @param zones the zones
     * @return the CreateZoneAssignmentOptions builder
     */
    public Builder zones(List<ZoneAssignmentZoneSpec> zones) {
      this.zones = zones;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the CreateZoneAssignmentOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateZoneAssignmentOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateZoneAssignmentOptions() { }

  protected CreateZoneAssignmentOptions(Builder builder) {
    accountId = builder.accountId;
    target = builder.target;
    zones = builder.zones;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateZoneAssignmentOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account that owns the zones being assigned.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the target.
   *
   * The enterprise entity to which the zones are being assigned.
   *
   * @return the target
   */
  public EnterpriseTarget target() {
    return target;
  }

  /**
   * Gets the zones.
   *
   * The list of zones to assign.
   *
   * @return the zones
   */
  public List<ZoneAssignmentZoneSpec> zones() {
    return zones;
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

