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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Imported metadata that displays in the dashboard.
 */
public class UISupport extends GenericModel {

  @SerializedName("display_name")
  protected String displayName;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String displayName;
    private String description;

    private Builder(UISupport uiSupport) {
      this.displayName = uiSupport.displayName;
      this.description = uiSupport.description;
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
     * @param description the description
     */
    public Builder(String displayName, String description) {
      this.displayName = displayName;
      this.description = description;
    }

    /**
     * Builds a UISupport.
     *
     * @return the new UISupport instance
     */
    public UISupport build() {
      return new UISupport(this);
    }

    /**
     * Set the displayName.
     *
     * @param displayName the displayName
     * @return the UISupport builder
     */
    public Builder displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UISupport builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UISupport(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.displayName,
      "displayName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    displayName = builder.displayName;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UISupport builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the displayName.
   *
   * The display name for a rule.
   *
   * @return the displayName
   */
  public String displayName() {
    return displayName;
  }

  /**
   * Gets the description.
   *
   * An extended description of a rule.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

