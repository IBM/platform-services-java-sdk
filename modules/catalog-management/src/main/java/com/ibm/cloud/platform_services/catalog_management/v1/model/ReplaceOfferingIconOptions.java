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
 * The replaceOfferingIcon options.
 */
public class ReplaceOfferingIconOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected String fileName;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String fileName;

    private Builder(ReplaceOfferingIconOptions replaceOfferingIconOptions) {
      this.catalogIdentifier = replaceOfferingIconOptions.catalogIdentifier;
      this.offeringId = replaceOfferingIconOptions.offeringId;
      this.fileName = replaceOfferingIconOptions.fileName;
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
     * @param fileName the fileName
     */
    public Builder(String catalogIdentifier, String offeringId, String fileName) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.fileName = fileName;
    }

    /**
     * Builds a ReplaceOfferingIconOptions.
     *
     * @return the new ReplaceOfferingIconOptions instance
     */
    public ReplaceOfferingIconOptions build() {
      return new ReplaceOfferingIconOptions(this);
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the ReplaceOfferingIconOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the ReplaceOfferingIconOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the fileName.
     *
     * @param fileName the fileName
     * @return the ReplaceOfferingIconOptions builder
     */
    public Builder fileName(String fileName) {
      this.fileName = fileName;
      return this;
    }
  }

  protected ReplaceOfferingIconOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.fileName,
      "fileName cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    fileName = builder.fileName;
  }

  /**
   * New builder.
   *
   * @return a ReplaceOfferingIconOptions builder
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
   * Gets the fileName.
   *
   * Name of the file name that is being uploaded.
   *
   * @return the fileName
   */
  public String fileName() {
    return fileName;
  }
}

