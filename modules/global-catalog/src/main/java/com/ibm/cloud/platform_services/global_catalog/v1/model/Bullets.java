/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information related to list delimiters.
 */
public class Bullets extends GenericModel {

  protected String title;
  protected String description;
  protected String icon;
  protected Long quantity;

  /**
   * Builder.
   */
  public static class Builder {
    private String title;
    private String description;
    private String icon;
    private Long quantity;

    /**
     * Instantiates a new Builder from an existing Bullets instance.
     *
     * @param bullets the instance to initialize the Builder with
     */
    private Builder(Bullets bullets) {
      this.title = bullets.title;
      this.description = bullets.description;
      this.icon = bullets.icon;
      this.quantity = bullets.quantity;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Bullets.
     *
     * @return the new Bullets instance
     */
    public Bullets build() {
      return new Bullets(this);
    }

    /**
     * Set the title.
     *
     * @param title the title
     * @return the Bullets builder
     */
    public Builder title(String title) {
      this.title = title;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Bullets builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the icon.
     *
     * @param icon the icon
     * @return the Bullets builder
     */
    public Builder icon(String icon) {
      this.icon = icon;
      return this;
    }

    /**
     * Set the quantity.
     *
     * @param quantity the quantity
     * @return the Bullets builder
     */
    public Builder quantity(long quantity) {
      this.quantity = quantity;
      return this;
    }
  }

  protected Bullets() { }

  protected Bullets(Builder builder) {
    title = builder.title;
    description = builder.description;
    icon = builder.icon;
    quantity = builder.quantity;
  }

  /**
   * New builder.
   *
   * @return a Bullets builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the title.
   *
   * The bullet title.
   *
   * @return the title
   */
  public String title() {
    return title;
  }

  /**
   * Gets the description.
   *
   * The bullet description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the icon.
   *
   * The icon to use for rendering the bullet.
   *
   * @return the icon
   */
  public String icon() {
    return icon;
  }

  /**
   * Gets the quantity.
   *
   * The bullet quantity.
   *
   * @return the quantity
   */
  public Long quantity() {
    return quantity;
  }
}

