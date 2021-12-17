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
 * The deprecateOffering options.
 */
public class DeprecateOfferingOptions extends GenericModel {

  /**
   * Set deprecation (true) or cancel deprecation (false).
   */
  public interface Setting {
    /** true. */
    String X_TRUE = "true";
    /** false. */
    String X_FALSE = "false";
  }

  protected String catalogIdentifier;
  protected String offeringId;
  protected String setting;
  protected String description;
  protected Long daysUntilDeprecate;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String setting;
    private String description;
    private Long daysUntilDeprecate;

    private Builder(DeprecateOfferingOptions deprecateOfferingOptions) {
      this.catalogIdentifier = deprecateOfferingOptions.catalogIdentifier;
      this.offeringId = deprecateOfferingOptions.offeringId;
      this.setting = deprecateOfferingOptions.setting;
      this.description = deprecateOfferingOptions.description;
      this.daysUntilDeprecate = deprecateOfferingOptions.daysUntilDeprecate;
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
     * @param setting the setting
     */
    public Builder(String catalogIdentifier, String offeringId, String setting) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.setting = setting;
    }

    /**
     * Builds a DeprecateOfferingOptions.
     *
     * @return the new DeprecateOfferingOptions instance
     */
    public DeprecateOfferingOptions build() {
      return new DeprecateOfferingOptions(this);
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the DeprecateOfferingOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the DeprecateOfferingOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the setting.
     *
     * @param setting the setting
     * @return the DeprecateOfferingOptions builder
     */
    public Builder setting(String setting) {
      this.setting = setting;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DeprecateOfferingOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the daysUntilDeprecate.
     *
     * @param daysUntilDeprecate the daysUntilDeprecate
     * @return the DeprecateOfferingOptions builder
     */
    public Builder daysUntilDeprecate(long daysUntilDeprecate) {
      this.daysUntilDeprecate = daysUntilDeprecate;
      return this;
    }
  }

  protected DeprecateOfferingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.setting,
      "setting cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    setting = builder.setting;
    description = builder.description;
    daysUntilDeprecate = builder.daysUntilDeprecate;
  }

  /**
   * New builder.
   *
   * @return a DeprecateOfferingOptions builder
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
   * Gets the setting.
   *
   * Set deprecation (true) or cancel deprecation (false).
   *
   * @return the setting
   */
  public String setting() {
    return setting;
  }

  /**
   * Gets the description.
   *
   * Additional information that users can provide to be displayed in deprecation notification.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the daysUntilDeprecate.
   *
   * Specifies the amount of days until product is not available in catalog.
   *
   * @return the daysUntilDeprecate
   */
  public Long daysUntilDeprecate() {
    return daysUntilDeprecate;
  }
}

