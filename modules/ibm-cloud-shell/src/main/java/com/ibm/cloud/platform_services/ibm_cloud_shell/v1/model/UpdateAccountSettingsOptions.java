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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateAccountSettings options.
 */
public class UpdateAccountSettingsOptions extends GenericModel {

  protected String accountId;
  protected String rev;
  protected Boolean defaultEnableNewFeatures;
  protected Boolean defaultEnableNewRegions;
  protected Boolean enabled;
  protected List<Feature> features;
  protected List<RegionSetting> regions;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String rev;
    private Boolean defaultEnableNewFeatures;
    private Boolean defaultEnableNewRegions;
    private Boolean enabled;
    private List<Feature> features;
    private List<RegionSetting> regions;

    private Builder(UpdateAccountSettingsOptions updateAccountSettingsOptions) {
      this.accountId = updateAccountSettingsOptions.accountId;
      this.rev = updateAccountSettingsOptions.rev;
      this.defaultEnableNewFeatures = updateAccountSettingsOptions.defaultEnableNewFeatures;
      this.defaultEnableNewRegions = updateAccountSettingsOptions.defaultEnableNewRegions;
      this.enabled = updateAccountSettingsOptions.enabled;
      this.features = updateAccountSettingsOptions.features;
      this.regions = updateAccountSettingsOptions.regions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a UpdateAccountSettingsOptions.
     *
     * @return the new UpdateAccountSettingsOptions instance
     */
    public UpdateAccountSettingsOptions build() {
      return new UpdateAccountSettingsOptions(this);
    }

    /**
     * Adds an features to features.
     *
     * @param features the new features
     * @return the UpdateAccountSettingsOptions builder
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
     * @return the UpdateAccountSettingsOptions builder
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
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the rev.
     *
     * @param rev the rev
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder rev(String rev) {
      this.rev = rev;
      return this;
    }

    /**
     * Set the defaultEnableNewFeatures.
     *
     * @param defaultEnableNewFeatures the defaultEnableNewFeatures
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder defaultEnableNewFeatures(Boolean defaultEnableNewFeatures) {
      this.defaultEnableNewFeatures = defaultEnableNewFeatures;
      return this;
    }

    /**
     * Set the defaultEnableNewRegions.
     *
     * @param defaultEnableNewRegions the defaultEnableNewRegions
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder defaultEnableNewRegions(Boolean defaultEnableNewRegions) {
      this.defaultEnableNewRegions = defaultEnableNewRegions;
      return this;
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the UpdateAccountSettingsOptions builder
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
     * @return the UpdateAccountSettingsOptions builder
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
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder regions(List<RegionSetting> regions) {
      this.regions = regions;
      return this;
    }

    /**
     * Set the accountSettings.
     *
     * @param accountSettings the accountSettings
     * @return the UpdateAccountSettingsOptions builder
     */
    public Builder accountSettings(AccountSettings accountSettings) {
      this.rev = accountSettings.rev();
      this.defaultEnableNewFeatures = accountSettings.defaultEnableNewFeatures();
      this.defaultEnableNewRegions = accountSettings.defaultEnableNewRegions();
      this.enabled = accountSettings.enabled();
      this.features = accountSettings.features();
      this.regions = accountSettings.regions();
      return this;
    }
  }

  protected UpdateAccountSettingsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
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
   * @return a UpdateAccountSettingsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID in which the account settings belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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
}

