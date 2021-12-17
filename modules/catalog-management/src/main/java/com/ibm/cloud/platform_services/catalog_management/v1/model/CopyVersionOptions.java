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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The copyVersion options.
 */
public class CopyVersionOptions extends GenericModel {

  protected String versionLocId;
  protected List<String> tags;
  protected List<String> targetKinds;
  protected byte[] content;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private List<String> tags;
    private List<String> targetKinds;
    private byte[] content;

    private Builder(CopyVersionOptions copyVersionOptions) {
      this.versionLocId = copyVersionOptions.versionLocId;
      this.tags = copyVersionOptions.tags;
      this.targetKinds = copyVersionOptions.targetKinds;
      this.content = copyVersionOptions.content;
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
     */
    public Builder(String versionLocId) {
      this.versionLocId = versionLocId;
    }

    /**
     * Builds a CopyVersionOptions.
     *
     * @return the new CopyVersionOptions instance
     */
    public CopyVersionOptions build() {
      return new CopyVersionOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the CopyVersionOptions builder
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
     * @return the CopyVersionOptions builder
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
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the CopyVersionOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the CopyVersionOptions builder
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
     * @return the CopyVersionOptions builder
     */
    public Builder targetKinds(List<String> targetKinds) {
      this.targetKinds = targetKinds;
      return this;
    }

    /**
     * Set the content.
     *
     * @param content the content
     * @return the CopyVersionOptions builder
     */
    public Builder content(byte[] content) {
      this.content = content;
      return this;
    }
  }

  protected CopyVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    versionLocId = builder.versionLocId;
    tags = builder.tags;
    targetKinds = builder.targetKinds;
    content = builder.content;
  }

  /**
   * New builder.
   *
   * @return a CopyVersionOptions builder
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
}

