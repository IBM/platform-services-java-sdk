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
 * The importOffering options.
 */
public class ImportOfferingOptions extends GenericModel {

  protected String catalogIdentifier;
  protected List<String> tags;
  protected List<String> targetKinds;
  protected byte[] content;
  protected String zipurl;
  protected String offeringId;
  protected String targetVersion;
  protected Boolean includeConfig;
  protected Boolean isVsi;
  protected String repoType;
  protected String xAuthToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private List<String> tags;
    private List<String> targetKinds;
    private byte[] content;
    private String zipurl;
    private String offeringId;
    private String targetVersion;
    private Boolean includeConfig;
    private Boolean isVsi;
    private String repoType;
    private String xAuthToken;

    private Builder(ImportOfferingOptions importOfferingOptions) {
      this.catalogIdentifier = importOfferingOptions.catalogIdentifier;
      this.tags = importOfferingOptions.tags;
      this.targetKinds = importOfferingOptions.targetKinds;
      this.content = importOfferingOptions.content;
      this.zipurl = importOfferingOptions.zipurl;
      this.offeringId = importOfferingOptions.offeringId;
      this.targetVersion = importOfferingOptions.targetVersion;
      this.includeConfig = importOfferingOptions.includeConfig;
      this.isVsi = importOfferingOptions.isVsi;
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
     */
    public Builder(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
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
     * Set the content.
     *
     * @param content the content
     * @return the ImportOfferingOptions builder
     */
    public Builder content(byte[] content) {
      this.content = content;
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
     * Set the targetVersion.
     *
     * @param targetVersion the targetVersion
     * @return the ImportOfferingOptions builder
     */
    public Builder targetVersion(String targetVersion) {
      this.targetVersion = targetVersion;
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
     * Set the isVsi.
     *
     * @param isVsi the isVsi
     * @return the ImportOfferingOptions builder
     */
    public Builder isVsi(Boolean isVsi) {
      this.isVsi = isVsi;
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
    catalogIdentifier = builder.catalogIdentifier;
    tags = builder.tags;
    targetKinds = builder.targetKinds;
    content = builder.content;
    zipurl = builder.zipurl;
    offeringId = builder.offeringId;
    targetVersion = builder.targetVersion;
    includeConfig = builder.includeConfig;
    isVsi = builder.isVsi;
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
   * URL path to zip location.  If not specified, must provide content in this post body.
   *
   * @return the zipurl
   */
  public String zipurl() {
    return zipurl;
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
   * Gets the targetVersion.
   *
   * The semver value for this new version.
   *
   * @return the targetVersion
   */
  public String targetVersion() {
    return targetVersion;
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

