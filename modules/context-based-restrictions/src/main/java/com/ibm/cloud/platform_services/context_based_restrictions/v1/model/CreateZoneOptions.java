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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createZone options.
 */
public class CreateZoneOptions extends GenericModel {

  protected String name;
  protected String accountId;
  protected String description;
  protected List<Address> addresses;
  protected List<Address> excluded;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String accountId;
    private String description;
    private List<Address> addresses;
    private List<Address> excluded;
    private String transactionId;

    private Builder(CreateZoneOptions createZoneOptions) {
      this.name = createZoneOptions.name;
      this.accountId = createZoneOptions.accountId;
      this.description = createZoneOptions.description;
      this.addresses = createZoneOptions.addresses;
      this.excluded = createZoneOptions.excluded;
      this.transactionId = createZoneOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateZoneOptions.
     *
     * @return the new CreateZoneOptions instance
     */
    public CreateZoneOptions build() {
      return new CreateZoneOptions(this);
    }

    /**
     * Adds an addresses to addresses.
     *
     * @param addresses the new addresses
     * @return the CreateZoneOptions builder
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
     * @return the CreateZoneOptions builder
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
     * Set the name.
     *
     * @param name the name
     * @return the CreateZoneOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateZoneOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateZoneOptions builder
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
     * @return the CreateZoneOptions builder
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
     * @return the CreateZoneOptions builder
     */
    public Builder excluded(List<Address> excluded) {
      this.excluded = excluded;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateZoneOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateZoneOptions(Builder builder) {
    name = builder.name;
    accountId = builder.accountId;
    description = builder.description;
    addresses = builder.addresses;
    excluded = builder.excluded;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateZoneOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * The list of excluded addresses in the zone.
   *
   * @return the excluded
   */
  public List<Address> excluded() {
    return excluded;
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

