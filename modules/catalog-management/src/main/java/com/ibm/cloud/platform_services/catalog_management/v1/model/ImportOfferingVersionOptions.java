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
 * The importOfferingVersion options.
 */
public class ImportOfferingVersionOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected String zipurl;
  protected List<String> tags;
  protected List<String> targetKinds;
  protected String targetVersion;
  protected Boolean includeConfig;
  protected String repoType;
  protected String xAuthToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String zipurl;
    private List<String> tags;
    private List<String> targetKinds;
    private String targetVersion;
    private Boolean includeConfig;
    private String repoType;
    private String xAuthToken;

    private Builder(ImportOfferingVersionOptions importOfferingVersionOptions) {
      this.catalogIdentifier = importOfferingVersionOptions.catalogIdentifier;
      this.offeringId = importOfferingVersionOptions.offeringId;
      this.zipurl = importOfferingVersionOptions.zipurl;
      this.tags = importOfferingVersionOptions.tags;
      this.targetKinds = importOfferingVersionOptions.targetKinds;
      this.targetVersion = importOfferingVersionOptions.targetVersion;
      this.includeConfig = importOfferingVersionOptions.includeConfig;
      this.repoType = importOfferingVersionOptions.repoType;
      this.xAuthToken = importOfferingVersionOptions.xAuthToken;
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
     * @param zipurl the zipurl
     */
    public Builder(String catalogIdentifier, String offeringId, String zipurl) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.zipurl = zipurl;
    }

    /**
     * Builds a ImportOfferingVersionOptions.
     *
     * @return the new ImportOfferingVersionOptions instance
     */
    public ImportOfferingVersionOptions build() {
      return new ImportOfferingVersionOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the ImportOfferingVersionOptions builder
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
     * @return the ImportOfferingVersionOptions builder
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
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the zipurl.
     *
     * @param zipurl the zipurl
     * @return the ImportOfferingVersionOptions builder
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
     * @return the ImportOfferingVersionOptions builder
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
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder targetKinds(List<String> targetKinds) {
      this.targetKinds = targetKinds;
      return this;
    }

    /**
     * Set the targetVersion.
     *
     * @param targetVersion the targetVersion
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder targetVersion(String targetVersion) {
      this.targetVersion = targetVersion;
      return this;
    }

    /**
     * Set the includeConfig.
     *
     * @param includeConfig the includeConfig
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder includeConfig(Boolean includeConfig) {
      this.includeConfig = includeConfig;
      return this;
    }

    /**
     * Set the repoType.
     *
     * @param repoType the repoType
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder repoType(String repoType) {
      this.repoType = repoType;
      return this;
    }

    /**
     * Set the xAuthToken.
     *
     * @param xAuthToken the xAuthToken
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder xAuthToken(String xAuthToken) {
      this.xAuthToken = xAuthToken;
      return this;
    }
  }

  protected ImportOfferingVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.zipurl,
      "zipurl cannot be null");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    zipurl = builder.zipurl;
    tags = builder.tags;
    targetKinds = builder.targetKinds;
    targetVersion = builder.targetVersion;
    includeConfig = builder.includeConfig;
    repoType = builder.repoType;
    xAuthToken = builder.xAuthToken;
  }

  /**
   * New builder.
   *
   * @return a ImportOfferingVersionOptions builder
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
   * Gets the targetVersion.
   *
   * The semver value for this new version, if not found in the zip url package content.
   *
   * @return the targetVersion
   */
  public String targetVersion() {
    return targetVersion;
  }

  /**
   * Gets the includeConfig.
   *
   * Add all possible configuration values to this version when importing.
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

