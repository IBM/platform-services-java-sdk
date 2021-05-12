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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getOfferingLicense options.
 */
public class GetOfferingLicenseOptions extends GenericModel {

  protected String versionLocId;
  protected String licenseId;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private String licenseId;

    private Builder(GetOfferingLicenseOptions getOfferingLicenseOptions) {
      this.versionLocId = getOfferingLicenseOptions.versionLocId;
      this.licenseId = getOfferingLicenseOptions.licenseId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param versionLocId the versionLocId
     * @param licenseId the licenseId
     */
    public Builder(String versionLocId, String licenseId) {
      this.versionLocId = versionLocId;
      this.licenseId = licenseId;
    }

    /**
     * Builds a GetOfferingLicenseOptions.
     *
     * @return the new GetOfferingLicenseOptions instance
     */
    public GetOfferingLicenseOptions build() {
      return new GetOfferingLicenseOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the GetOfferingLicenseOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the licenseId.
     *
     * @param licenseId the licenseId
     * @return the GetOfferingLicenseOptions builder
     */
    public Builder licenseId(String licenseId) {
      this.licenseId = licenseId;
      return this;
    }
  }

  protected GetOfferingLicenseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.licenseId,
      "licenseId cannot be empty");
    versionLocId = builder.versionLocId;
    licenseId = builder.licenseId;
  }

  /**
   * New builder.
   *
   * @return a GetOfferingLicenseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the versionLocId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocId
   */
  public String versionLocId() {
    return versionLocId;
  }

  /**
   * Gets the licenseId.
   *
   * The ID of the license, which maps to the file name in the 'licenses' directory of this verions tgz file.
   *
   * @return the licenseId
   */
  public String licenseId() {
    return licenseId;
  }
}

