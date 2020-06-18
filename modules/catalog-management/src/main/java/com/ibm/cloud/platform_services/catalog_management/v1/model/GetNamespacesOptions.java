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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getNamespaces options.
 */
public class GetNamespacesOptions extends GenericModel {

  protected String clusterId;
  protected String region;
  protected String xAuthRefreshToken;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String clusterId;
    private String region;
    private String xAuthRefreshToken;
    private Long limit;
    private Long offset;

    private Builder(GetNamespacesOptions getNamespacesOptions) {
      this.clusterId = getNamespacesOptions.clusterId;
      this.region = getNamespacesOptions.region;
      this.xAuthRefreshToken = getNamespacesOptions.xAuthRefreshToken;
      this.limit = getNamespacesOptions.limit;
      this.offset = getNamespacesOptions.offset;
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
     * Builds a GetNamespacesOptions.
     *
     * @return the new GetNamespacesOptions instance
     */
    public GetNamespacesOptions build() {
      return new GetNamespacesOptions(this);
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the GetNamespacesOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the GetNamespacesOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the GetNamespacesOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetNamespacesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetNamespacesOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected GetNamespacesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.clusterId,
      "clusterId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.region,
      "region cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    clusterId = builder.clusterId;
    region = builder.region;
    xAuthRefreshToken = builder.xAuthRefreshToken;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a GetNamespacesOptions builder
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
   * Cluster region.
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

  /**
   * Gets the limit.
   *
   * number or results to return.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * number of results to skip before returning values.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }
}

