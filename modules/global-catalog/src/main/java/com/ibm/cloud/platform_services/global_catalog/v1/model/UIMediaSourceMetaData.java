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
 * Location of your applications media source files.
 */
public class UIMediaSourceMetaData extends GenericModel {

  protected String type;
  protected String url;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String url;

    /**
     * Instantiates a new Builder from an existing UIMediaSourceMetaData instance.
     *
     * @param uiMediaSourceMetaData the instance to initialize the Builder with
     */
    private Builder(UIMediaSourceMetaData uiMediaSourceMetaData) {
      this.type = uiMediaSourceMetaData.type;
      this.url = uiMediaSourceMetaData.url;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a UIMediaSourceMetaData.
     *
     * @return the new UIMediaSourceMetaData instance
     */
    public UIMediaSourceMetaData build() {
      return new UIMediaSourceMetaData(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the UIMediaSourceMetaData builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the UIMediaSourceMetaData builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }
  }

  protected UIMediaSourceMetaData() { }

  protected UIMediaSourceMetaData(Builder builder) {
    type = builder.type;
    url = builder.url;
  }

  /**
   * New builder.
   *
   * @return a UIMediaSourceMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

