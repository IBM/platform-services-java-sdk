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
 * The deleteOfferingInstance options.
 */
public class DeleteOfferingInstanceOptions extends GenericModel {

  protected String instanceIdentifier;
  protected String xAuthRefreshToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String instanceIdentifier;
    private String xAuthRefreshToken;

    private Builder(DeleteOfferingInstanceOptions deleteOfferingInstanceOptions) {
      this.instanceIdentifier = deleteOfferingInstanceOptions.instanceIdentifier;
      this.xAuthRefreshToken = deleteOfferingInstanceOptions.xAuthRefreshToken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param instanceIdentifier the instanceIdentifier
     * @param xAuthRefreshToken the xAuthRefreshToken
     */
    public Builder(String instanceIdentifier, String xAuthRefreshToken) {
      this.instanceIdentifier = instanceIdentifier;
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a DeleteOfferingInstanceOptions.
     *
     * @return the new DeleteOfferingInstanceOptions instance
     */
    public DeleteOfferingInstanceOptions build() {
      return new DeleteOfferingInstanceOptions(this);
    }

    /**
     * Set the instanceIdentifier.
     *
     * @param instanceIdentifier the instanceIdentifier
     * @return the DeleteOfferingInstanceOptions builder
     */
    public Builder instanceIdentifier(String instanceIdentifier) {
      this.instanceIdentifier = instanceIdentifier;
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the DeleteOfferingInstanceOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }
  }

  protected DeleteOfferingInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.instanceIdentifier,
      "instanceIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    instanceIdentifier = builder.instanceIdentifier;
    xAuthRefreshToken = builder.xAuthRefreshToken;
  }

  /**
   * New builder.
   *
   * @return a DeleteOfferingInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the instanceIdentifier.
   *
   * Version Instance identifier.
   *
   * @return the instanceIdentifier
   */
  public String instanceIdentifier() {
    return instanceIdentifier;
  }

  /**
   * Gets the xAuthRefreshToken.
   *
   * IAM Refresh token.
   *
   * @return the xAuthRefreshToken
   */
  public String xAuthRefreshToken() {
    return xAuthRefreshToken;
  }
}

