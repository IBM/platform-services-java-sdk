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

import java.util.ArrayList;
import java.util.List;

/**
 * The importOfferingVersion options.
 */
public class ImportOfferingVersionOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected List<String> tags;
  protected List<String> targetKinds;
  protected byte[] content;
  protected String zipurl;
  protected String targetVersion;
  protected Boolean includeConfig;
  protected Boolean isVsi;
  protected String repoType;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private List<String> tags;
    private List<String> targetKinds;
    private byte[] content;
    private String zipurl;
    private String targetVersion;
    private Boolean includeConfig;
    private Boolean isVsi;
    private String repoType;

    private Builder(ImportOfferingVersionOptions importOfferingVersionOptions) {
      this.catalogIdentifier = importOfferingVersionOptions.catalogIdentifier;
      this.offeringId = importOfferingVersionOptions.offeringId;
      this.tags = importOfferingVersionOptions.tags;
      this.targetKinds = importOfferingVersionOptions.targetKinds;
      this.content = importOfferingVersionOptions.content;
      this.zipurl = importOfferingVersionOptions.zipurl;
      this.targetVersion = importOfferingVersionOptions.targetVersion;
      this.includeConfig = importOfferingVersionOptions.includeConfig;
      this.isVsi = importOfferingVersionOptions.isVsi;
      this.repoType = importOfferingVersionOptions.repoType;
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
     * Set the content.
     *
     * @param content the content
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder content(byte[] content) {
      this.content = content;
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
     * Set the isVsi.
     *
     * @param isVsi the isVsi
     * @return the ImportOfferingVersionOptions builder
     */
    public Builder isVsi(Boolean isVsi) {
      this.isVsi = isVsi;
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
  }

  protected ImportOfferingVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    tags = builder.tags;
    targetKinds = builder.targetKinds;
    content = builder.content;
    zipurl = builder.zipurl;
    targetVersion = builder.targetVersion;
    includeConfig = builder.includeConfig;
    isVsi = builder.isVsi;
    repoType = builder.repoType;
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
   * Gets the content.
   *
   * byte array representing the content to be imported.  Only supported for OVA images at this time.
   *
   * @return the content
   */
  public byte[] content() {
    return content;
  }

  /**
   * Gets the zipurl.
   *
   * URL path to zip location.  If not specified, must provide content in the body of this call.
   *
   * @return the zipurl
   */
  public String zipurl() {
    return zipurl;
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
   * Gets the isVsi.
   *
   * Indicates that the current terraform template is used to install a VSI Image.
   *
   * @return the isVsi
   */
  public Boolean isVsi() {
    return isVsi;
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
}

