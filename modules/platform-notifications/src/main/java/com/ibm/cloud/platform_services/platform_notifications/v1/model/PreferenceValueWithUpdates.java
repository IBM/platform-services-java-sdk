/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Preference settings for notification types that support updates.
 */
public class PreferenceValueWithUpdates extends GenericModel {

  public interface Channels {
    /** email. */
    String EMAIL = "email";
  }

  protected List<String> channels;
  protected Boolean updates;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> channels;
    private Boolean updates;

    /**
     * Instantiates a new Builder from an existing PreferenceValueWithUpdates instance.
     *
     * @param preferenceValueWithUpdates the instance to initialize the Builder with
     */
    private Builder(PreferenceValueWithUpdates preferenceValueWithUpdates) {
      this.channels = preferenceValueWithUpdates.channels;
      this.updates = preferenceValueWithUpdates.updates;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param channels the channels
     */
    public Builder(List<String> channels) {
      this.channels = channels;
    }

    /**
     * Builds a PreferenceValueWithUpdates.
     *
     * @return the new PreferenceValueWithUpdates instance
     */
    public PreferenceValueWithUpdates build() {
      return new PreferenceValueWithUpdates(this);
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the PreferenceValueWithUpdates builder
     */
    public Builder addChannels(String channels) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(channels,
        "channels cannot be null");
      if (this.channels == null) {
        this.channels = new ArrayList<String>();
      }
      this.channels.add(channels);
      return this;
    }

    /**
     * Set the channels.
     * Existing channels will be replaced.
     *
     * @param channels the channels
     * @return the PreferenceValueWithUpdates builder
     */
    public Builder channels(List<String> channels) {
      this.channels = channels;
      return this;
    }

    /**
     * Set the updates.
     *
     * @param updates the updates
     * @return the PreferenceValueWithUpdates builder
     */
    public Builder updates(Boolean updates) {
      this.updates = updates;
      return this;
    }
  }

  protected PreferenceValueWithUpdates() { }

  protected PreferenceValueWithUpdates(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.channels,
      "channels cannot be null");
    channels = builder.channels;
    updates = builder.updates;
  }

  /**
   * New builder.
   *
   * @return a PreferenceValueWithUpdates builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the channels.
   *
   * Array of communication channels for this preference.
   *
   * @return the channels
   */
  public List<String> channels() {
    return channels;
  }

  /**
   * Gets the updates.
   *
   * Whether to receive updates for this preference. Optional, defaults to false if not provided.
   *
   * @return the updates
   */
  public Boolean updates() {
    return updates;
  }
}

