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
 * The getLicenses options.
 */
public class GetLicensesOptions extends GenericModel {

  protected String licenseProviderId;
  protected String accountId;
  protected String name;
  protected String licenseType;
  protected String licenseProductId;

  /**
   * Builder.
   */
  public static class Builder {
    private String licenseProviderId;
    private String accountId;
    private String name;
    private String licenseType;
    private String licenseProductId;

    private Builder(GetLicensesOptions getLicensesOptions) {
      this.licenseProviderId = getLicensesOptions.licenseProviderId;
      this.accountId = getLicensesOptions.accountId;
      this.name = getLicensesOptions.name;
      this.licenseType = getLicensesOptions.licenseType;
      this.licenseProductId = getLicensesOptions.licenseProductId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param licenseProviderId the licenseProviderId
     */
    public Builder(String licenseProviderId) {
      this.licenseProviderId = licenseProviderId;
    }

    /**
     * Builds a GetLicensesOptions.
     *
     * @return the new GetLicensesOptions instance
     */
    public GetLicensesOptions build() {
      return new GetLicensesOptions(this);
    }

    /**
     * Set the licenseProviderId.
     *
     * @param licenseProviderId the licenseProviderId
     * @return the GetLicensesOptions builder
     */
    public Builder licenseProviderId(String licenseProviderId) {
      this.licenseProviderId = licenseProviderId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetLicensesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the GetLicensesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the licenseType.
     *
     * @param licenseType the licenseType
     * @return the GetLicensesOptions builder
     */
    public Builder licenseType(String licenseType) {
      this.licenseType = licenseType;
      return this;
    }

    /**
     * Set the licenseProductId.
     *
     * @param licenseProductId the licenseProductId
     * @return the GetLicensesOptions builder
     */
    public Builder licenseProductId(String licenseProductId) {
      this.licenseProductId = licenseProductId;
      return this;
    }
  }

  protected GetLicensesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.licenseProviderId,
      "licenseProviderId cannot be null");
    licenseProviderId = builder.licenseProviderId;
    accountId = builder.accountId;
    name = builder.name;
    licenseType = builder.licenseType;
    licenseProductId = builder.licenseProductId;
  }

  /**
   * New builder.
   *
   * @return a GetLicensesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the licenseProviderId.
   *
   * ID of the license provider, ie. retrieved from GET license_providers.
   *
   * @return the licenseProviderId
   */
  public String licenseProviderId() {
    return licenseProviderId;
  }

  /**
   * Gets the accountId.
   *
   * If not specified the token's account will be used.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * License name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the licenseType.
   *
   * Type of license, if not specified, default is ibm-ppa.
   *
   * @return the licenseType
   */
  public String licenseType() {
    return licenseType;
  }

  /**
   * Gets the licenseProductId.
   *
   * The license product ID. If from PPA (Passport Advantage) this is the product Part number, eg. D1YGZLL.
   *
   * @return the licenseProductId
   */
  public String licenseProductId() {
    return licenseProductId;
  }
}

