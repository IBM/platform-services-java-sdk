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
 * The reloadOffering options.
 */
public class ReloadOfferingOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected String targetVersion;
  protected List<String> tags;
  protected List<String> targetKinds;
  protected byte[] content;
  protected String zipurl;
  protected String repoType;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String targetVersion;
    private List<String> tags;
    private List<String> targetKinds;
    private byte[] content;
    private String zipurl;
    private String repoType;

    private Builder(ReloadOfferingOptions reloadOfferingOptions) {
      this.catalogIdentifier = reloadOfferingOptions.catalogIdentifier;
      this.offeringId = reloadOfferingOptions.offeringId;
      this.targetVersion = reloadOfferingOptions.targetVersion;
      this.tags = reloadOfferingOptions.tags;
      this.targetKinds = reloadOfferingOptions.targetKinds;
      this.content = reloadOfferingOptions.content;
      this.zipurl = reloadOfferingOptions.zipurl;
      this.repoType = reloadOfferingOptions.repoType;
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
     * @param targetVersion the targetVersion
     */
    public Builder(String catalogIdentifier, String offeringId, String targetVersion) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.targetVersion = targetVersion;
    }

    /**
     * Builds a ReloadOfferingOptions.
     *
     * @return the new ReloadOfferingOptions instance
     */
    public ReloadOfferingOptions build() {
      return new ReloadOfferingOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the ReloadOfferingOptions builder
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
     * @return the ReloadOfferingOptions builder
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
     * @return the ReloadOfferingOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the ReloadOfferingOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the targetVersion.
     *
     * @param targetVersion the targetVersion
     * @return the ReloadOfferingOptions builder
     */
    public Builder targetVersion(String targetVersion) {
      this.targetVersion = targetVersion;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the ReloadOfferingOptions builder
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
     * @return the ReloadOfferingOptions builder
     */
    public Builder targetKinds(List<String> targetKinds) {
      this.targetKinds = targetKinds;
      return this;
    }

    /**
     * Set the content.
     *
     * @param content the content
     * @return the ReloadOfferingOptions builder
     */
    public Builder content(byte[] content) {
      this.content = content;
      return this;
    }

    /**
     * Set the zipurl.
     *
     * @param zipurl the zipurl
     * @return the ReloadOfferingOptions builder
     */
    public Builder zipurl(String zipurl) {
      this.zipurl = zipurl;
      return this;
    }

    /**
     * Set the repoType.
     *
     * @param repoType the repoType
     * @return the ReloadOfferingOptions builder
     */
    public Builder repoType(String repoType) {
      this.repoType = repoType;
      return this;
    }
  }

  protected ReloadOfferingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.targetVersion,
      "targetVersion cannot be null");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    targetVersion = builder.targetVersion;
    tags = builder.tags;
    targetKinds = builder.targetKinds;
    content = builder.content;
    zipurl = builder.zipurl;
    repoType = builder.repoType;
  }

  /**
   * New builder.
   *
   * @return a ReloadOfferingOptions builder
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

