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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Image annotation for this catalog entry. The image is a URL.
 */
public class Image extends GenericModel {

  protected String image;
  @SerializedName("small_image")
  protected String smallImage;
  @SerializedName("medium_image")
  protected String mediumImage;
  @SerializedName("feature_image")
  protected String featureImage;

  /**
   * Builder.
   */
  public static class Builder {
    private String image;
    private String smallImage;
    private String mediumImage;
    private String featureImage;

    private Builder(Image image) {
      this.image = image.image;
      this.smallImage = image.smallImage;
      this.mediumImage = image.mediumImage;
      this.featureImage = image.featureImage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param image the image
     */
    public Builder(String image) {
      this.image = image;
    }

    /**
     * Builds a Image.
     *
     * @return the new Image instance
     */
    public Image build() {
      return new Image(this);
    }

    /**
     * Set the image.
     *
     * @param image the image
     * @return the Image builder
     */
    public Builder image(String image) {
      this.image = image;
      return this;
    }

    /**
     * Set the smallImage.
     *
     * @param smallImage the smallImage
     * @return the Image builder
     */
    public Builder smallImage(String smallImage) {
      this.smallImage = smallImage;
      return this;
    }

    /**
     * Set the mediumImage.
     *
     * @param mediumImage the mediumImage
     * @return the Image builder
     */
    public Builder mediumImage(String mediumImage) {
      this.mediumImage = mediumImage;
      return this;
    }

    /**
     * Set the featureImage.
     *
     * @param featureImage the featureImage
     * @return the Image builder
     */
    public Builder featureImage(String featureImage) {
      this.featureImage = featureImage;
      return this;
    }
  }

  protected Image(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.image,
      "image cannot be null");
    image = builder.image;
    smallImage = builder.smallImage;
    mediumImage = builder.mediumImage;
    featureImage = builder.featureImage;
  }

  /**
   * New builder.
   *
   * @return a Image builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the image.
   *
   * URL for the large, default image.
   *
   * @return the image
   */
  public String image() {
    return image;
  }

  /**
   * Gets the smallImage.
   *
   * URL for a small image.
   *
   * @return the smallImage
   */
  public String smallImage() {
    return smallImage;
  }

  /**
   * Gets the mediumImage.
   *
   * URL for a medium image.
   *
   * @return the mediumImage
   */
  public String mediumImage() {
    return mediumImage;
  }

  /**
   * Gets the featureImage.
   *
   * URL for a featured image.
   *
   * @return the featureImage
   */
  public String featureImage() {
    return featureImage;
  }
}

