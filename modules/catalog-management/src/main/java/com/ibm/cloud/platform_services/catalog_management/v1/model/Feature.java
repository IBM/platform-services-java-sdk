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

/**
 * Feature information.
 */
public class Feature extends GenericModel {

  protected String title;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String title;
    private String description;

    private Builder(Feature feature) {
      this.title = feature.title;
      this.description = feature.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Feature.
     *
     * @return the new Feature instance
     */
    public Feature build() {
      return new Feature(this);
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the Feature builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Feature builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected Feature(Builder builder) {
    title = builder.title;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a Feature builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the title.
   *
   * Heading.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * Feature description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

