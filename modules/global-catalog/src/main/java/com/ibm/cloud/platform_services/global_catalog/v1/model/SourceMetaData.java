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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Location of your applications source files.
 */
public class SourceMetaData extends GenericModel {

  protected String path;
  protected String type;
  protected String url;

  /**
   * Builder.
   */
  public static class Builder {
    private String path;
    private String type;
    private String url;

    private Builder(SourceMetaData sourceMetaData) {
      this.path = sourceMetaData.path;
      this.type = sourceMetaData.type;
      this.url = sourceMetaData.url;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SourceMetaData.
     *
     * @return the new SourceMetaData instance
     */
    public SourceMetaData build() {
      return new SourceMetaData(this);
    }

    /**
     * Set the path.
     *
     * @param path the path
     * @return the SourceMetaData builder
     */
    public Builder path(String path) {
      this.path = path;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the SourceMetaData builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the SourceMetaData builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected SourceMetaData(Builder builder) {
    path = builder.path;
    type = builder.type;
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a SourceMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the path.
   *
   * Path to your application.
   *
   * @return the path
   */
  public String path() {
    return path;
  }

  /**
   * Gets the type.
   *
   * Type of source, for example, git.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the url.
   *
   * URL to source.
   *
   * @return the url
   */
  public String url() {
    return url;
  }
}

