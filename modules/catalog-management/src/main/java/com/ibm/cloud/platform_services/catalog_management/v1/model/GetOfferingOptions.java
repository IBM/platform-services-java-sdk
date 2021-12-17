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
 * The getOffering options.
 */
public class GetOfferingOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected String type;
  protected Boolean digest;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String type;
    private Boolean digest;

    private Builder(GetOfferingOptions getOfferingOptions) {
      this.catalogIdentifier = getOfferingOptions.catalogIdentifier;
      this.offeringId = getOfferingOptions.offeringId;
      this.type = getOfferingOptions.type;
      this.digest = getOfferingOptions.digest;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @param offeringId the offeringId
     */
    public Builder(String catalogIdentifier, String offeringId) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
    }

    /**
     * Builds a GetOfferingOptions.
     *
     * @return the new GetOfferingOptions instance
     */
    public GetOfferingOptions build() {
      return new GetOfferingOptions(this);
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the GetOfferingOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the GetOfferingOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the GetOfferingOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the digest.
     *
     * @param digest the digest
     * @return the GetOfferingOptions builder
     */
    public Builder digest(Boolean digest) {
      this.digest = digest;
      return this;
    }
  }

  protected GetOfferingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    type = builder.type;
    digest = builder.digest;
  }

  /**
   * New builder.
   *
   * @return a GetOfferingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalogIdentifier.
   *
   * Catalog identifier.
   *
   * @return the catalogIdentifier
   */
  public String catalogIdentifier() {
    return catalogIdentifier;
  }

  /**
   * Gets the offeringId.
   *
   * Offering identification.
   *
   * @return the offeringId
   */
  public String offeringId() {
    return offeringId;
  }

  /**
   * Gets the type.
   *
   * Offering Parameter Type.  Valid values are 'name' or 'id'.  Default is 'id'.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the digest.
   *
   * Return the digest format of the specified offering.  Default is false.
   *
   * @return the digest
   */
  public Boolean digest() {
    return digest;
  }
}

