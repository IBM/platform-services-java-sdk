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
 * Media-related metadata.
 */
public class UIMetaMedia extends GenericModel {

  protected String caption;
  @SerializedName("thumbnail_url")
  protected String thumbnailUrl;
  protected String type;
  @SerializedName("URL")
  protected String url;
  protected Bullets source;

  /**
   * Builder.
   */
  public static class Builder {
    private String caption;
    private String thumbnailUrl;
    private String type;
    private String url;
    private Bullets source;

    private Builder(UIMetaMedia uiMetaMedia) {
      this.caption = uiMetaMedia.caption;
      this.thumbnailUrl = uiMetaMedia.thumbnailUrl;
      this.type = uiMetaMedia.type;
      this.url = uiMetaMedia.url;
      this.source = uiMetaMedia.source;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a UIMetaMedia.
     *
     * @return the new UIMetaMedia instance
     */
    public UIMetaMedia build() {
      return new UIMetaMedia(this);
    }

    /**
     * Set the caption.
     *
     * @param caption the caption
     * @return the UIMetaMedia builder
     */
    public Builder caption(String caption) {
      this.caption = caption;
      return this;
    }

    /**
     * Set the thumbnailUrl.
     *
     * @param thumbnailUrl the thumbnailUrl
     * @return the UIMetaMedia builder
     */
    public Builder thumbnailUrl(String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the UIMetaMedia builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the UIMetaMedia builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the UIMetaMedia builder
     */
    public Builder source(Bullets source) {
      this.source = source;
      return this;
    }
  }

  protected UIMetaMedia(Builder builder) {
    caption = builder.caption;
    thumbnailUrl = builder.thumbnailUrl;
    type = builder.type;
    url = builder.url;
    source = builder.source;
  }

  /**
   * New builder.
   *
   * @return a UIMetaMedia builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the caption.
   *
   * Caption for an image.
   *
   * @return the caption
   */
  public String caption() {
    return caption;
  }

  /**
   * Gets the thumbnailUrl.
   *
   * URL for thumbnail image.
   *
   * @return the thumbnailUrl
   */
  public String thumbnailUrl() {
    return thumbnailUrl;
  }

  /**
   * Gets the type.
   *
   * Type of media.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the url.
   *
   * URL for media.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the source.
   *
   * Information related to list delimiters.
   *
   * @return the source
   */
  public Bullets source() {
    return source;
  }
}

