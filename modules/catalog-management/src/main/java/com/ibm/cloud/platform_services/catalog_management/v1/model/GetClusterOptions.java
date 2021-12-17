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
 * The getCluster options.
 */
public class GetClusterOptions extends GenericModel {

  protected String clusterId;
  protected String region;
  protected String xAuthRefreshToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String clusterId;
    private String region;
    private String xAuthRefreshToken;

    private Builder(GetClusterOptions getClusterOptions) {
      this.clusterId = getClusterOptions.clusterId;
      this.region = getClusterOptions.region;
      this.xAuthRefreshToken = getClusterOptions.xAuthRefreshToken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param clusterId the clusterId
     * @param region the region
     * @param xAuthRefreshToken the xAuthRefreshToken
     */
    public Builder(String clusterId, String region, String xAuthRefreshToken) {
      this.clusterId = clusterId;
      this.region = region;
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a GetClusterOptions.
     *
     * @return the new GetClusterOptions instance
     */
    public GetClusterOptions build() {
      return new GetClusterOptions(this);
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the GetClusterOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the GetClusterOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the GetClusterOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }
  }

  protected GetClusterOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.clusterId,
      "clusterId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.region,
      "region cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    clusterId = builder.clusterId;
    region = builder.region;
    xAuthRefreshToken = builder.xAuthRefreshToken;
  }

  /**
   * New builder.
   *
   * @return a GetClusterOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the clusterId.
   *
   * ID of the cluster.
   *
   * @return the clusterId
   */
  public String clusterId() {
    return clusterId;
  }

  /**
   * Gets the region.
   *
   * Region of the cluster.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the xAuthRefreshToken.
   *
   * IAM Refresh token.
   *
   * @return the xAuthRefreshToken
   */
  public String xAuthRefreshToken() {
    return xAuthRefreshToken;
  }
}

