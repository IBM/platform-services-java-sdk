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
 * Preference settings for notification types that do not support updates.
 */
public class PreferenceValueWithoutUpdates extends GenericModel {

  public interface Channels {
    /** email. */
    String EMAIL = "email";
  }

  protected List<String> channels;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> channels;

    /**
     * Instantiates a new Builder from an existing PreferenceValueWithoutUpdates instance.
     *
     * @param preferenceValueWithoutUpdates the instance to initialize the Builder with
     */
    private Builder(PreferenceValueWithoutUpdates preferenceValueWithoutUpdates) {
      this.channels = preferenceValueWithoutUpdates.channels;
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
     * Builds a PreferenceValueWithoutUpdates.
     *
     * @return the new PreferenceValueWithoutUpdates instance
     */
    public PreferenceValueWithoutUpdates build() {
      return new PreferenceValueWithoutUpdates(this);
    }

    /**
     * Adds a new element to channels.
     *
     * @param channels the new element to be added
     * @return the PreferenceValueWithoutUpdates builder
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
     * @return the PreferenceValueWithoutUpdates builder
     */
    public Builder channels(List<String> channels) {
      this.channels = channels;
      return this;
    }
  }

  protected PreferenceValueWithoutUpdates() { }

  protected PreferenceValueWithoutUpdates(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.channels,
      "channels cannot be null");
    channels = builder.channels;
  }

  /**
   * New builder.
   *
   * @return a PreferenceValueWithoutUpdates builder
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
}

