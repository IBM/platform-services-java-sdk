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
 * The deleteLicenseEntitlement options.
 */
public class DeleteLicenseEntitlementOptions extends GenericModel {

  protected String entitlementId;
  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String entitlementId;
    private String accountId;

    private Builder(DeleteLicenseEntitlementOptions deleteLicenseEntitlementOptions) {
      this.entitlementId = deleteLicenseEntitlementOptions.entitlementId;
      this.accountId = deleteLicenseEntitlementOptions.accountId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param entitlementId the entitlementId
     */
    public Builder(String entitlementId) {
      this.entitlementId = entitlementId;
    }

    /**
     * Builds a DeleteLicenseEntitlementOptions.
     *
     * @return the new DeleteLicenseEntitlementOptions instance
     */
    public DeleteLicenseEntitlementOptions build() {
      return new DeleteLicenseEntitlementOptions(this);
    }

    /**
     * Set the entitlementId.
     *
     * @param entitlementId the entitlementId
     * @return the DeleteLicenseEntitlementOptions builder
     */
    public Builder entitlementId(String entitlementId) {
      this.entitlementId = entitlementId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteLicenseEntitlementOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected DeleteLicenseEntitlementOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.entitlementId,
      "entitlementId cannot be empty");
    entitlementId = builder.entitlementId;
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a DeleteLicenseEntitlementOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the entitlementId.
   *
   * The specific entitlement ID (can be obtained from one of the license entitlement queries).
   *
   * @return the entitlementId
   */
  public String entitlementId() {
    return entitlementId;
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
}

