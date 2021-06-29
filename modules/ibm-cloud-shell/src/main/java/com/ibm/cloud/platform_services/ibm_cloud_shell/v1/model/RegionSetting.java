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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Describes a Cloud Shell region setting.
 */
public class RegionSetting extends GenericModel {

  protected Boolean enabled;
  protected String key;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean enabled;
    private String key;

    private Builder(RegionSetting regionSetting) {
      this.enabled = regionSetting.enabled;
      this.key = regionSetting.key;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RegionSetting.
     *
     * @return the new RegionSetting instance
     */
    public RegionSetting build() {
      return new RegionSetting(this);
    }

    /**
     * Set the enabled.
     *
     * @param enabled the enabled
     * @return the RegionSetting builder
     */
    public Builder enabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the RegionSetting builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }
  }

  protected RegionSetting(Builder builder) {
    enabled = builder.enabled;
    key = builder.key;
  }

  /**
   * New builder.
   *
   * @return a RegionSetting builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enabled.
   *
   * State of the region.
   *
   * @return the enabled
   */
  public Boolean enabled() {
    return enabled;
  }

  /**
   * Gets the key.
   *
   * Name of the region.
   *
   * @return the key
   */
  public String key() {
    return key;
  }
}

