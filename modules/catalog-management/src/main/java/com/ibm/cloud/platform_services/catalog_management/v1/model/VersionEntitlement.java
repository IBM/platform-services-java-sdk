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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Entitlement license info.
 */
public class VersionEntitlement extends GenericModel {

  @SerializedName("provider_name")
  protected String providerName;
  @SerializedName("provider_id")
  protected String providerId;
  @SerializedName("product_id")
  protected String productId;
  @SerializedName("part_numbers")
  protected List<String> partNumbers;
  @SerializedName("image_repo_name")
  protected String imageRepoName;

  /**
   * Builder.
   */
  public static class Builder {
    private String providerName;
    private String providerId;
    private String productId;
    private List<String> partNumbers;
    private String imageRepoName;

    private Builder(VersionEntitlement versionEntitlement) {
      this.providerName = versionEntitlement.providerName;
      this.providerId = versionEntitlement.providerId;
      this.productId = versionEntitlement.productId;
      this.partNumbers = versionEntitlement.partNumbers;
      this.imageRepoName = versionEntitlement.imageRepoName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a VersionEntitlement.
     *
     * @return the new VersionEntitlement instance
     */
    public VersionEntitlement build() {
      return new VersionEntitlement(this);
    }

    /**
     * Adds an partNumbers to partNumbers.
     *
     * @param partNumbers the new partNumbers
     * @return the VersionEntitlement builder
     */
    public Builder addPartNumbers(String partNumbers) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(partNumbers,
        "partNumbers cannot be null");
      if (this.partNumbers == null) {
        this.partNumbers = new ArrayList<String>();
      }
      this.partNumbers.add(partNumbers);
      return this;
    }

    /**
     * Set the providerName.
     *
     * @param providerName the providerName
     * @return the VersionEntitlement builder
     */
    public Builder providerName(String providerName) {
      this.providerName = providerName;
      return this;
    }

    /**
     * Set the providerId.
     *
     * @param providerId the providerId
     * @return the VersionEntitlement builder
     */
    public Builder providerId(String providerId) {
      this.providerId = providerId;
      return this;
    }

    /**
     * Set the productId.
     *
     * @param productId the productId
     * @return the VersionEntitlement builder
     */
    public Builder productId(String productId) {
      this.productId = productId;
      return this;
    }

    /**
     * Set the partNumbers.
     * Existing partNumbers will be replaced.
     *
     * @param partNumbers the partNumbers
     * @return the VersionEntitlement builder
     */
    public Builder partNumbers(List<String> partNumbers) {
      this.partNumbers = partNumbers;
      return this;
    }

    /**
     * Set the imageRepoName.
     *
     * @param imageRepoName the imageRepoName
     * @return the VersionEntitlement builder
     */
    public Builder imageRepoName(String imageRepoName) {
      this.imageRepoName = imageRepoName;
      return this;
    }
  }

  protected VersionEntitlement(Builder builder) {
    providerName = builder.providerName;
    providerId = builder.providerId;
    productId = builder.productId;
    partNumbers = builder.partNumbers;
    imageRepoName = builder.imageRepoName;
  }

  /**
   * New builder.
   *
   * @return a VersionEntitlement builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the providerName.
   *
   * Provider name.
   *
   * @return the providerName
   */
  public String providerName() {
    return providerName;
  }

  /**
   * Gets the providerId.
   *
   * Provider ID.
   *
   * @return the providerId
   */
  public String providerId() {
    return providerId;
  }

  /**
   * Gets the productId.
   *
   * Product ID.
   *
   * @return the productId
   */
  public String productId() {
    return productId;
  }

  /**
   * Gets the partNumbers.
   *
   * list of license entitlement part numbers, eg. D1YGZLL,D1ZXILL.
   *
   * @return the partNumbers
   */
  public List<String> partNumbers() {
    return partNumbers;
  }

  /**
   * Gets the imageRepoName.
   *
   * Image repository name.
   *
   * @return the imageRepoName
   */
  public String imageRepoName() {
    return imageRepoName;
  }
}

