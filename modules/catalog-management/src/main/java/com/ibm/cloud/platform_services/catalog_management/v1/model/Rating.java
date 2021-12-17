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
 * Repository info for offerings.
 */
public class Rating extends GenericModel {

  @SerializedName("one_star_count")
  protected Long oneStarCount;
  @SerializedName("two_star_count")
  protected Long twoStarCount;
  @SerializedName("three_star_count")
  protected Long threeStarCount;
  @SerializedName("four_star_count")
  protected Long fourStarCount;

  /**
   * Builder.
   */
  public static class Builder {
    private Long oneStarCount;
    private Long twoStarCount;
    private Long threeStarCount;
    private Long fourStarCount;

    private Builder(Rating rating) {
      this.oneStarCount = rating.oneStarCount;
      this.twoStarCount = rating.twoStarCount;
      this.threeStarCount = rating.threeStarCount;
      this.fourStarCount = rating.fourStarCount;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Rating.
     *
     * @return the new Rating instance
     */
    public Rating build() {
      return new Rating(this);
    }

    /**
     * Set the oneStarCount.
     *
     * @param oneStarCount the oneStarCount
     * @return the Rating builder
     */
    public Builder oneStarCount(long oneStarCount) {
      this.oneStarCount = oneStarCount;
      return this;
    }

    /**
     * Set the twoStarCount.
     *
     * @param twoStarCount the twoStarCount
     * @return the Rating builder
     */
    public Builder twoStarCount(long twoStarCount) {
      this.twoStarCount = twoStarCount;
      return this;
    }

    /**
     * Set the threeStarCount.
     *
     * @param threeStarCount the threeStarCount
     * @return the Rating builder
     */
    public Builder threeStarCount(long threeStarCount) {
      this.threeStarCount = threeStarCount;
      return this;
    }

    /**
     * Set the fourStarCount.
     *
     * @param fourStarCount the fourStarCount
     * @return the Rating builder
     */
    public Builder fourStarCount(long fourStarCount) {
      this.fourStarCount = fourStarCount;
      return this;
    }
  }

  protected Rating(Builder builder) {
    oneStarCount = builder.oneStarCount;
    twoStarCount = builder.twoStarCount;
    threeStarCount = builder.threeStarCount;
    fourStarCount = builder.fourStarCount;
  }

  /**
   * New builder.
   *
   * @return a Rating builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the oneStarCount.
   *
   * One start rating.
   *
   * @return the oneStarCount
   */
  public Long oneStarCount() {
    return oneStarCount;
  }

  /**
   * Gets the twoStarCount.
   *
   * Two start rating.
   *
   * @return the twoStarCount
   */
  public Long twoStarCount() {
    return twoStarCount;
  }

  /**
   * Gets the threeStarCount.
   *
   * Three start rating.
   *
   * @return the threeStarCount
   */
  public Long threeStarCount() {
    return threeStarCount;
  }

  /**
   * Gets the fourStarCount.
   *
   * Four start rating.
   *
   * @return the fourStarCount
   */
  public Long fourStarCount() {
    return fourStarCount;
  }
}

