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
 * The getLicenseEntitlements options.
 */
public class GetLicenseEntitlementsOptions extends GenericModel {

  protected String licenseProductId;
  protected String accountId;
  protected String versionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String licenseProductId;
    private String accountId;
    private String versionId;

    private Builder(GetLicenseEntitlementsOptions getLicenseEntitlementsOptions) {
      this.licenseProductId = getLicenseEntitlementsOptions.licenseProductId;
      this.accountId = getLicenseEntitlementsOptions.accountId;
      this.versionId = getLicenseEntitlementsOptions.versionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param licenseProductId the licenseProductId
     */
    public Builder(String licenseProductId) {
      this.licenseProductId = licenseProductId;
    }

    /**
     * Builds a GetLicenseEntitlementsOptions.
     *
     * @return the new GetLicenseEntitlementsOptions instance
     */
    public GetLicenseEntitlementsOptions build() {
      return new GetLicenseEntitlementsOptions(this);
    }

    /**
     * Set the licenseProductId.
     *
     * @param licenseProductId the licenseProductId
     * @return the GetLicenseEntitlementsOptions builder
     */
    public Builder licenseProductId(String licenseProductId) {
      this.licenseProductId = licenseProductId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetLicenseEntitlementsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the versionId.
     *
     * @param versionId the versionId
     * @return the GetLicenseEntitlementsOptions builder
     */
    public Builder versionId(String versionId) {
      this.versionId = versionId;
      return this;
    }
  }

  protected GetLicenseEntitlementsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.licenseProductId,
      "licenseProductId cannot be empty");
    licenseProductId = builder.licenseProductId;
    accountId = builder.accountId;
    versionId = builder.versionId;
  }

  /**
   * New builder.
   *
   * @return a GetLicenseEntitlementsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the licenseProductId.
   *
   * The license product ID. If from PPA (Passport Advantage) this is a specific product Part number, eg. D1YGZLL.
   *
   * @return the licenseProductId
   */
  public String licenseProductId() {
    return licenseProductId;
  }

  /**
   * Gets the accountId.
   *
   * The account ID to query for the entitlement. Default is the account from the user's token.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the versionId.
   *
   * The GC ID of the specific offering version.
   *
   * @return the versionId
   */
  public String versionId() {
    return versionId;
  }
}

