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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Overview is nested in the top level. The key value pair is `[_language_]overview_ui`.
 */
public class Overview extends GenericModel {

  @SerializedName("display_name")
  protected String displayName;
  @SerializedName("long_description")
  protected String longDescription;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String displayName;
    private String longDescription;
    private String description;

    private Builder(Overview overview) {
      this.displayName = overview.displayName;
      this.longDescription = overview.longDescription;
      this.description = overview.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param displayName the displayName
     * @param longDescription the longDescription
     * @param description the description
     */
    public Builder(String displayName, String longDescription, String description) {
      this.displayName = displayName;
      this.longDescription = longDescription;
      this.description = description;
    }

    /**
     * Builds a Overview.
     *
     * @return the new Overview instance
     */
    public Overview build() {
      return new Overview(this);
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the Overview builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the longDescription.
     *
     * @param longDescription the longDescription
     * @return the Overview builder
     */
    public Builder longDescription(String longDescription) {
      this.longDescription = longDescription;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Overview builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected Overview(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.displayName,
      "displayName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.longDescription,
      "longDescription cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    displayName = builder.displayName;
    longDescription = builder.longDescription;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a Overview builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the displayName.
   *
   * The translated display name.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the longDescription.
   *
   * The translated long description.
   *
   * @return the longDescription
   */
  public String longDescription() {
    return longDescription;
  }

  /**
   * Gets the description.
   *
   * The translated description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

