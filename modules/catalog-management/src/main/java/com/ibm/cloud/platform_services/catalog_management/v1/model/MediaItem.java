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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Offering Media information.
 */
public class MediaItem extends GenericModel {

  protected String url;
  protected String caption;
  protected String type;
  @SerializedName("thumbnail_url")
  protected String thumbnailUrl;

  /**
   * Builder.
   */
  public static class Builder {
    private String url;
    private String caption;
    private String type;
    private String thumbnailUrl;

    private Builder(MediaItem mediaItem) {
      this.url = mediaItem.url;
      this.caption = mediaItem.caption;
      this.type = mediaItem.type;
      this.thumbnailUrl = mediaItem.thumbnailUrl;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a MediaItem.
     *
     * @return the new MediaItem instance
     */
    public MediaItem build() {
      return new MediaItem(this);
    }

    /**
     * Set the url.
     *
     * @param url the url
     * @return the MediaItem builder
     */
    public Builder url(String url) {
      this.url = url;
      return this;
    }

    /**
     * Set the caption.
     *
     * @param caption the caption
     * @return the MediaItem builder
     */
    public Builder caption(String caption) {
      this.caption = caption;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the MediaItem builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the thumbnailUrl.
     *
     * @param thumbnailUrl the thumbnailUrl
     * @return the MediaItem builder
     */
    public Builder thumbnailUrl(String thumbnailUrl) {
      this.thumbnailUrl = thumbnailUrl;
      return this;
    }
  }

  protected MediaItem(Builder builder) {
    url = builder.url;
    caption = builder.caption;
    type = builder.type;
    thumbnailUrl = builder.thumbnailUrl;
  }

  /**
   * New builder.
   *
   * @return a MediaItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the url.
   *
   * URL of the specified media item.
   *
   * @return the url
   */
  public String url() {
    return url;
  }

  /**
   * Gets the caption.
   *
   * Caption for this media item.
   *
   * @return the caption
   */
  public String caption() {
    return caption;
  }

  /**
   * Gets the type.
   *
   * Type of this media item.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the thumbnailUrl.
   *
   * Thumbnail URL for this media item.
   *
   * @return the thumbnailUrl
   */
  public String thumbnailUrl() {
    return thumbnailUrl;
  }
}

