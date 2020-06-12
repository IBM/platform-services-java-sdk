/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createLicenseEntitlement options.
 */
public class CreateLicenseEntitlementOptions extends GenericModel {

  protected String name;
  protected String effectiveFrom;
  protected String effectiveUntil;
  protected String versionId;
  protected String licenseId;
  protected String licenseOwnerId;
  protected String licenseProviderId;
  protected String licenseProductId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String effectiveFrom;
    private String effectiveUntil;
    private String versionId;
    private String licenseId;
    private String licenseOwnerId;
    private String licenseProviderId;
    private String licenseProductId;
    private String accountId;

    private Builder(CreateLicenseEntitlementOptions createLicenseEntitlementOptions) {
      this.name = createLicenseEntitlementOptions.name;
      this.effectiveFrom = createLicenseEntitlementOptions.effectiveFrom;
      this.effectiveUntil = createLicenseEntitlementOptions.effectiveUntil;
      this.versionId = createLicenseEntitlementOptions.versionId;
      this.licenseId = createLicenseEntitlementOptions.licenseId;
      this.licenseOwnerId = createLicenseEntitlementOptions.licenseOwnerId;
      this.licenseProviderId = createLicenseEntitlementOptions.licenseProviderId;
      this.licenseProductId = createLicenseEntitlementOptions.licenseProductId;
      this.accountId = createLicenseEntitlementOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateLicenseEntitlementOptions.
     *
     * @return the new CreateLicenseEntitlementOptions instance
     */
    public CreateLicenseEntitlementOptions build() {
      return new CreateLicenseEntitlementOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the effectiveFrom.
     *
     * @param effectiveFrom the effectiveFrom
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder effectiveFrom(String effectiveFrom) {
      this.effectiveFrom = effectiveFrom;
      return this;
    }

    /**
     * Set the effectiveUntil.
     *
     * @param effectiveUntil the effectiveUntil
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder effectiveUntil(String effectiveUntil) {
      this.effectiveUntil = effectiveUntil;
      return this;
    }

    /**
     * Set the versionId.
     *
     * @param versionId the versionId
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder versionId(String versionId) {
      this.versionId = versionId;
      return this;
    }

    /**
     * Set the licenseId.
     *
     * @param licenseId the licenseId
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder licenseId(String licenseId) {
      this.licenseId = licenseId;
      return this;
    }

    /**
     * Set the licenseOwnerId.
     *
     * @param licenseOwnerId the licenseOwnerId
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder licenseOwnerId(String licenseOwnerId) {
      this.licenseOwnerId = licenseOwnerId;
      return this;
    }

    /**
     * Set the licenseProviderId.
     *
     * @param licenseProviderId the licenseProviderId
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder licenseProviderId(String licenseProviderId) {
      this.licenseProviderId = licenseProviderId;
      return this;
    }

    /**
     * Set the licenseProductId.
     *
     * @param licenseProductId the licenseProductId
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder licenseProductId(String licenseProductId) {
      this.licenseProductId = licenseProductId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateLicenseEntitlementOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected CreateLicenseEntitlementOptions(Builder builder) {
    name = builder.name;
    effectiveFrom = builder.effectiveFrom;
    effectiveUntil = builder.effectiveUntil;
    versionId = builder.versionId;
    licenseId = builder.licenseId;
    licenseOwnerId = builder.licenseOwnerId;
    licenseProviderId = builder.licenseProviderId;
    licenseProductId = builder.licenseProductId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a CreateLicenseEntitlementOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Entitlement name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the effectiveFrom.
   *
   * Entitlement is good from this starting date. eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the effectiveFrom
   */
  public String effectiveFrom() {
    return effectiveFrom;
  }

  /**
   * Gets the effectiveUntil.
   *
   * Entitlement is good until this ending date. eg. '2019-07-17T21:21:47.6794935Z'.
   *
   * @return the effectiveUntil
   */
  public String effectiveUntil() {
    return effectiveUntil;
  }

  /**
   * Gets the versionId.
   *
   * Global Catalog ID of the version.
   *
   * @return the versionId
   */
  public String versionId() {
    return versionId;
  }

  /**
   * Gets the licenseId.
   *
   * Specific license entitlement ID from the license provider, eg. D1W3R4.
   *
   * @return the licenseId
   */
  public String licenseId() {
    return licenseId;
  }

  /**
   * Gets the licenseOwnerId.
   *
   * IBM ID of the owner of this license entitlement.
   *
   * @return the licenseOwnerId
   */
  public String licenseOwnerId() {
    return licenseOwnerId;
  }

  /**
   * Gets the licenseProviderId.
   *
   * License provider ID.
   *
   * @return the licenseProviderId
   */
  public String licenseProviderId() {
    return licenseProviderId;
  }

  /**
   * Gets the licenseProductId.
   *
   * License product ID.
   *
   * @return the licenseProductId
   */
  public String licenseProductId() {
    return licenseProductId;
  }

  /**
   * Gets the accountId.
   *
   * if not specified the token's account will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

