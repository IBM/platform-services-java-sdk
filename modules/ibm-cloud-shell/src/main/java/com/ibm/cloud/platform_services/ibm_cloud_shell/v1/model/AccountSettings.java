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
package com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Definition of Cloud Shell account settings.
 */
public class AccountSettings extends GenericModel {

  @SerializedName("_id")
  protected String id;
  @SerializedName("_rev")
  protected String rev;
  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("created_at")
  protected Long createdAt;
  @SerializedName("created_by")
  protected String createdBy;
  @SerializedName("default_enable_new_features")
  protected Boolean defaultEnableNewFeatures;
  @SerializedName("default_enable_new_regions")
  protected Boolean defaultEnableNewRegions;
  protected Boolean enabled;
  protected List<Feature> features;
  protected List<RegionSetting> regions;
  protected String type;
  @SerializedName("updated_at")
  protected Long updatedAt;
  @SerializedName("updated_by")
  protected String updatedBy;

  /**
   * Builder.
   */
  public static class Builder {
    private String rev;
    private Boolean defaultEnableNewFeatures;
    private Boolean defaultEnableNewRegions;
    private Boolean enabled;
    private List<Feature> features;
    private List<RegionSetting> regions;

    private Builder(AccountSettings accountSettings) {
      this.rev = accountSettings.rev;
      this.defaultEnableNewFeatures = accountSettings.defaultEnableNewFeatures;
      this.defaultEnableNewRegions = accountSettings.defaultEnableNewRegions;
      this.enabled = accountSettings.enabled;
      this.features = accountSettings.features;
      this.regions = accountSettings.regions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AccountSettings.
     *
     * @return the new AccountSettings instance
     */
    public AccountSettings build() {
      return new AccountSettings(this);
    }

    /**
     * Adds an features to features.
     *
     * @param features the new features
     * @return the AccountSettings builder
     */
    public Builder addFeatures(Feature features) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(features,
        "features cannot be null");
      if (this.features == null) {
        this.features = new ArrayList<Feature>();
      }
      this.features.add(features);
      return this;
    }

    /**
     * Adds an regions to regions.
     *
     * @param regions the new regions
     * @return the AccountSettings builder
     */
    public Builder addRegions(RegionSetting regions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(regions,
        "regions cannot be null");
      if (this.regions == null) {
        this.regions = new ArrayList<RegionSetting>();
      }
      this.regions.add(regions);
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the AccountSettings builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the defaultEnableNewFeatures.
     *
     * @param defaultEnableNewFeatures the defaultEnableNewFeatures
     * @return the AccountSettings builder
     */
    public Builder defaultEnableNewFeatures(Boolean defaultEnableNewFeatures) {
      this.defaultEnableNewFeatures = defaultEnableNewFeatures;
      return this;
    }

    /**
     * Set the defaultEnableNewRegions.
     *
     * @param defaultEnableNewRegions the defaultEnableNewRegions
     * @return the AccountSettings builder
     */
    public Builder defaultEnableNewRegions(Boolean defaultEnableNewRegions) {
      this.defaultEnableNewRegions = defaultEnableNewRegions;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the AccountSettings builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the features.
     * Existing features will be replaced.
     *
     * @param features the features
     * @return the AccountSettings builder
     */
    public Builder features(List<Feature> features) {
      this.features = features;
      return this;
    }

    /**
     * Set the regions.
     * Existing regions will be replaced.
     *
     * @param regions the regions
     * @return the AccountSettings builder
     */
    public Builder regions(List<RegionSetting> regions) {
      this.regions = regions;
      return this;
    }
  }

  protected AccountSettings(Builder builder) {
    rev = builder.rev;
    defaultEnableNewFeatures = builder.defaultEnableNewFeatures;
    defaultEnableNewRegions = builder.defaultEnableNewRegions;
    enabled = builder.enabled;
    features = builder.features;
    regions = builder.regions;
  }

  /**
   * New builder.
   *
   * @return a AccountSettings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique id of the settings object.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the rev.
   *
   * Unique revision number for the settings object.
   *
   * @return the rev
   */
  public String rev() {
    return rev;
  }

  /**
   * Gets the accountId.
   *
   * The id of the account the settings belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the createdAt.
   *
   * Creation timestamp in Unix epoch time.
   *
   * @return the createdAt
   */
  public Long createdAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * IAM ID of creator.
   *
   * @return the createdBy
   */
  public String createdBy() {
    return createdBy;
  }

  /**
   * Gets the defaultEnableNewFeatures.
   *
   * You can choose which Cloud Shell features are available in the account and whether any new features are enabled as
   * they become available. The feature settings apply only to the enabled Cloud Shell locations.
   *
   * @return the defaultEnableNewFeatures
   */
  public Boolean defaultEnableNewFeatures() {
    return defaultEnableNewFeatures;
  }

  /**
   * Gets the defaultEnableNewRegions.
   *
   * Set whether Cloud Shell is enabled in a specific location for the account. The location determines where user and
   * session data are stored. By default, users are routed to the nearest available location.
   *
   * @return the defaultEnableNewRegions
   */
  public Boolean defaultEnableNewRegions() {
    return defaultEnableNewRegions;
  }

  /**
   * Gets the enabled.
   *
   * When enabled, Cloud Shell is available to all users in the account.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the features.
   *
   * List of Cloud Shell features.
   *
   * @return the features
   */
  public List<Feature> features() {
    return features;
  }

  /**
   * Gets the regions.
   *
   * List of Cloud Shell region settings.
   *
   * @return the regions
   */
  public List<RegionSetting> regions() {
    return regions;
  }

  /**
   * Gets the type.
   *
   * Type of api response object.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the updatedAt.
   *
   * Timestamp of last update in Unix epoch time.
   *
   * @return the updatedAt
   */
  public Long updatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * IAM ID of last updater.
   *
   * @return the updatedBy
   */
  public String updatedBy() {
    return updatedBy;
  }
}

