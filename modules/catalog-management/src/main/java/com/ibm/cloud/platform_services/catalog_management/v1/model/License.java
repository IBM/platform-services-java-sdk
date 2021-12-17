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
 * BSS license.
 */
public class License extends GenericModel {

  protected String id;
  protected String name;
  protected String type;
  protected String url;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private String type;
    private String url;
    private String description;

    private Builder(License license) {
      this.id = license.id;
      this.name = license.name;
      this.type = license.type;
      this.url = license.url;
      this.description = license.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a License.
     *
     * @return the new License instance
     */
    public License build() {
      return new License(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the License builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the License builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the License builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the License builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the License builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected License(Builder builder) {
    id = builder.id;
    name = builder.name;
    type = builder.type;
    url = builder.url;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a License builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * License ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * license name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the type.
   *
   * type of license e.g., Apache xxx.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the url.
   *
   * URL for the license text.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the description.
   *
   * License description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

