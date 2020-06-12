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
 * The listLicenseEntitlements options.
 */
public class ListLicenseEntitlementsOptions extends GenericModel {

  protected String accountId;
  protected String licenseProductId;
  protected String versionId;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String licenseProductId;
    private String versionId;
    private String state;

    private Builder(ListLicenseEntitlementsOptions listLicenseEntitlementsOptions) {
      this.accountId = listLicenseEntitlementsOptions.accountId;
      this.licenseProductId = listLicenseEntitlementsOptions.licenseProductId;
      this.versionId = listLicenseEntitlementsOptions.versionId;
      this.state = listLicenseEntitlementsOptions.state;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListLicenseEntitlementsOptions.
     *
     * @return the new ListLicenseEntitlementsOptions instance
     */
    public ListLicenseEntitlementsOptions build() {
      return new ListLicenseEntitlementsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListLicenseEntitlementsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the licenseProductId.
     *
     * @param licenseProductId the licenseProductId
     * @return the ListLicenseEntitlementsOptions builder
     */
    public Builder licenseProductId(String licenseProductId) {
      this.licenseProductId = licenseProductId;
      return this;
    }

    /**
     * Set the versionId.
     *
     * @param versionId the versionId
     * @return the ListLicenseEntitlementsOptions builder
     */
    public Builder versionId(String versionId) {
      this.versionId = versionId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListLicenseEntitlementsOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected ListLicenseEntitlementsOptions(Builder builder) {
    accountId = builder.accountId;
    licenseProductId = builder.licenseProductId;
    versionId = builder.versionId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a ListLicenseEntitlementsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the licenseProductId.
   *
   * The license product ID. If from PPA (Passport Advantage) this is the product Part number(s) which can be one or
   * more IDs, eg. D1YGZLL,5737L09.
   *
   * @return the licenseProductId
   */
  public String licenseProductId() {
    return licenseProductId;
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

  /**
   * Gets the state.
   *
   * The state of the license entitlement. eg. usually 'active', or if it's been deleted will show as 'removed'.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

