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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceZone options.
 */
public class ReplaceZoneOptions extends GenericModel {

  protected String zoneId;
  protected String ifMatch;
  protected String name;
  protected String accountId;
  protected String description;
  protected List<Address> addresses;
  protected List<Address> excluded;
  protected String xCorrelationId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String zoneId;
    private String ifMatch;
    private String name;
    private String accountId;
    private String description;
    private List<Address> addresses;
    private List<Address> excluded;
    private String xCorrelationId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceZoneOptions instance.
     *
     * @param replaceZoneOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceZoneOptions replaceZoneOptions) {
      this.zoneId = replaceZoneOptions.zoneId;
      this.ifMatch = replaceZoneOptions.ifMatch;
      this.name = replaceZoneOptions.name;
      this.accountId = replaceZoneOptions.accountId;
      this.description = replaceZoneOptions.description;
      this.addresses = replaceZoneOptions.addresses;
      this.excluded = replaceZoneOptions.excluded;
      this.xCorrelationId = replaceZoneOptions.xCorrelationId;
      this.transactionId = replaceZoneOptions.transactionId;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String zoneId, String ifMatch) {
      this.zoneId = zoneId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a ReplaceZoneOptions.
     *
     * @return the new ReplaceZoneOptions instance
     */
    public ReplaceZoneOptions build() {
      return new ReplaceZoneOptions(this);
    }

    /**
     * Adds an addresses to addresses.
     *
     * @param addresses the new addresses
     * @return the ReplaceZoneOptions builder
     */
    public Builder addAddresses(Address addresses) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(addresses,
        "addresses cannot be null");
      if (this.addresses == null) {
        this.addresses = new ArrayList<Address>();
      }
      this.addresses.add(addresses);
      return this;
    }

    /**
     * Adds an excluded to excluded.
     *
     * @param excluded the new excluded
     * @return the ReplaceZoneOptions builder
     */
    public Builder addExcluded(Address excluded) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(excluded,
        "excluded cannot be null");
      if (this.excluded == null) {
        this.excluded = new ArrayList<Address>();
      }
      this.excluded.add(excluded);
      return this;
    }

    /**
     * Set the zoneId.
     *
     * @param zoneId the zoneId
     * @return the ReplaceZoneOptions builder
     */
    public Builder zoneId(String zoneId) {
      this.zoneId = zoneId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceZoneOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceZoneOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ReplaceZoneOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceZoneOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the addresses.
     * Existing addresses will be replaced.
     *
     * @param addresses the addresses
     * @return the ReplaceZoneOptions builder
     */
    public Builder addresses(List<Address> addresses) {
      this.addresses = addresses;
      return this;
    }

    /**
     * Set the excluded.
     * Existing excluded will be replaced.
     *
     * @param excluded the excluded
     * @return the ReplaceZoneOptions builder
     */
    public Builder excluded(List<Address> excluded) {
      this.excluded = excluded;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ReplaceZoneOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceZoneOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected ReplaceZoneOptions() { }

  protected ReplaceZoneOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.zoneId,
      "zoneId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    zoneId = builder.zoneId;
    ifMatch = builder.ifMatch;
    name = builder.name;
    accountId = builder.accountId;
    description = builder.description;
    addresses = builder.addresses;
    excluded = builder.excluded;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceZoneOptions builder
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
   * Gets the ifMatch.
   *
   * The current revision of the resource being updated. This can be found in the Create/Get/Update resource response
   * ETag header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * The name of the zone.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * The id of the account owning this zone.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the description.
   *
   * The description of the zone.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the addresses.
   *
   * The list of addresses in the zone.
   *
   * @return the addresses
   */
  public List<Address> addresses() {
    return addresses;
  }

  /**
   * Gets the excluded.
   *
   * The list of excluded addresses in the zone. Only addresses of type `ipAddress`, `ipRange`, and `subnet` can be
   * excluded.
   *
   * @return the excluded
   */
  public List<Address> excluded() {
    return excluded;
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

