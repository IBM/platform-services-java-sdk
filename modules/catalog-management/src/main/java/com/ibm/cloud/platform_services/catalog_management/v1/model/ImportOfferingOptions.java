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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The importOffering options.
 */
public class ImportOfferingOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String zipurl;
  protected List<String> tags;
  protected List<String> targetKinds;
  protected String offeringId;
  protected Boolean includeConfig;
  protected String repoType;
  protected String xAuthToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String zipurl;
    private List<String> tags;
    private List<String> targetKinds;
    private String offeringId;
    private Boolean includeConfig;
    private String repoType;
    private String xAuthToken;

    private Builder(ImportOfferingOptions importOfferingOptions) {
      this.catalogIdentifier = importOfferingOptions.catalogIdentifier;
      this.zipurl = importOfferingOptions.zipurl;
      this.tags = importOfferingOptions.tags;
      this.targetKinds = importOfferingOptions.targetKinds;
      this.offeringId = importOfferingOptions.offeringId;
      this.includeConfig = importOfferingOptions.includeConfig;
      this.repoType = importOfferingOptions.repoType;
      this.xAuthToken = importOfferingOptions.xAuthToken;
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
     * @param zipurl the zipurl
     */
    public Builder(String catalogIdentifier, String zipurl) {
      this.catalogIdentifier = catalogIdentifier;
      this.zipurl = zipurl;
    }

    /**
     * Builds a ImportOfferingOptions.
     *
     * @return the new ImportOfferingOptions instance
     */
    public ImportOfferingOptions build() {
      return new ImportOfferingOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the ImportOfferingOptions builder
     */
    public Builder addTags(String tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<String>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Adds an targetKinds to targetKinds.
     *
     * @param targetKinds the new targetKinds
     * @return the ImportOfferingOptions builder
     */
    public Builder addTargetKinds(String targetKinds) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(targetKinds,
        "targetKinds cannot be null");
      if (this.targetKinds == null) {
        this.targetKinds = new ArrayList<String>();
      }
      this.targetKinds.add(targetKinds);
      return this;
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the ImportOfferingOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the zipurl.
     *
     * @param zipurl the zipurl
     * @return the ImportOfferingOptions builder
     */
    public Builder zipurl(String zipurl) {
      this.zipurl = zipurl;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the ImportOfferingOptions builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the targetKinds.
     * Existing targetKinds will be replaced.
     *
     * @param targetKinds the targetKinds
     * @return the ImportOfferingOptions builder
     */
    public Builder targetKinds(List<String> targetKinds) {
      this.targetKinds = targetKinds;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the ImportOfferingOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the includeConfig.
     *
     * @param includeConfig the includeConfig
     * @return the ImportOfferingOptions builder
     */
    public Builder includeConfig(Boolean includeConfig) {
      this.includeConfig = includeConfig;
      return this;
    }

    /**
     * Set the repoType.
     *
     * @param repoType the repoType
     * @return the ImportOfferingOptions builder
     */
    public Builder repoType(String repoType) {
      this.repoType = repoType;
      return this;
    }

    /**
     * Set the xAuthToken.
     *
     * @param xAuthToken the xAuthToken
     * @return the ImportOfferingOptions builder
     */
    public Builder xAuthToken(String xAuthToken) {
      this.xAuthToken = xAuthToken;
      return this;
    }
  }

  protected ImportOfferingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.zipurl,
      "zipurl cannot be null");
    catalogIdentifier = builder.catalogIdentifier;
    zipurl = builder.zipurl;
    tags = builder.tags;
    targetKinds = builder.targetKinds;
    offeringId = builder.offeringId;
    includeConfig = builder.includeConfig;
    repoType = builder.repoType;
    xAuthToken = builder.xAuthToken;
  }

  /**
   * New builder.
   *
   * @return a ImportOfferingOptions builder
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
   * Gets the zipurl.
   *
   * URL path to zip location.
   *
   * @return the zipurl
   */
  public String zipurl() {
    return zipurl;
  }

  /**
   * Gets the tags.
   *
   * Tags array.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the targetKinds.
   *
   * Target kinds.  Current valid values are 'iks', 'roks', 'vcenter', and 'terraform'.
   *
   * @return the targetKinds
   */
  public List<String> targetKinds() {
    return targetKinds;
  }

  /**
   * Gets the offeringId.
   *
   * Re-use the specified offeringID during import.
   *
   * @return the offeringId
   */
  public String offeringId() {
    return offeringId;
  }

  /**
   * Gets the includeConfig.
   *
   * Add all possible configuration items when creating this version.
   *
   * @return the includeConfig
   */
  public Boolean includeConfig() {
    return includeConfig;
  }

  /**
   * Gets the repoType.
   *
   * The type of repository containing this version.  Valid values are 'public_git' or 'enterprise_git'.
   *
   * @return the repoType
   */
  public String repoType() {
    return repoType;
  }

  /**
   * Gets the xAuthToken.
   *
   * Authentication token used to access the specified zip file.
   *
   * @return the xAuthToken
   */
  public String xAuthToken() {
    return xAuthToken;
  }
}

