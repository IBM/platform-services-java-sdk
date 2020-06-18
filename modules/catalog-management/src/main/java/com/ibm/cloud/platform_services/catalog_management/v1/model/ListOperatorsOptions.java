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
 * The listOperators options.
 */
public class ListOperatorsOptions extends GenericModel {

  protected String xAuthRefreshToken;
  protected String clusterId;
  protected String region;
  protected String versionLocatorId;

  /**
   * Builder.
   */
  public static class Builder {
    private String xAuthRefreshToken;
    private String clusterId;
    private String region;
    private String versionLocatorId;

    private Builder(ListOperatorsOptions listOperatorsOptions) {
      this.xAuthRefreshToken = listOperatorsOptions.xAuthRefreshToken;
      this.clusterId = listOperatorsOptions.clusterId;
      this.region = listOperatorsOptions.region;
      this.versionLocatorId = listOperatorsOptions.versionLocatorId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @param clusterId the clusterId
     * @param region the region
     * @param versionLocatorId the versionLocatorId
     */
    public Builder(String xAuthRefreshToken, String clusterId, String region, String versionLocatorId) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      this.clusterId = clusterId;
      this.region = region;
      this.versionLocatorId = versionLocatorId;
    }

    /**
     * Builds a ListOperatorsOptions.
     *
     * @return the new ListOperatorsOptions instance
     */
    public ListOperatorsOptions build() {
      return new ListOperatorsOptions(this);
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the ListOperatorsOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the ListOperatorsOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the ListOperatorsOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the versionLocatorId.
     *
     * @param versionLocatorId the versionLocatorId
     * @return the ListOperatorsOptions builder
     */
    public Builder versionLocatorId(String versionLocatorId) {
      this.versionLocatorId = versionLocatorId;
      return this;
    }
  }

  protected ListOperatorsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.clusterId,
      "clusterId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.region,
      "region cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.versionLocatorId,
      "versionLocatorId cannot be null");
    xAuthRefreshToken = builder.xAuthRefreshToken;
    clusterId = builder.clusterId;
    region = builder.region;
    versionLocatorId = builder.versionLocatorId;
  }

  /**
   * New builder.
   *
   * @return a ListOperatorsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the clusterId.
   *
   * Cluster identification.
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
   * Gets the versionLocatorId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocatorId
   */
  public String versionLocatorId() {
    return versionLocatorId;
  }
}

