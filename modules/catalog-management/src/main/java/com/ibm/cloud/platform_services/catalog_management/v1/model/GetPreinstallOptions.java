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
 * The getPreinstall options.
 */
public class GetPreinstallOptions extends GenericModel {

  protected String versionLocId;
  protected String xAuthRefreshToken;
  protected String clusterId;
  protected String region;
  protected String namespace;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private String xAuthRefreshToken;
    private String clusterId;
    private String region;
    private String namespace;

    private Builder(GetPreinstallOptions getPreinstallOptions) {
      this.versionLocId = getPreinstallOptions.versionLocId;
      this.xAuthRefreshToken = getPreinstallOptions.xAuthRefreshToken;
      this.clusterId = getPreinstallOptions.clusterId;
      this.region = getPreinstallOptions.region;
      this.namespace = getPreinstallOptions.namespace;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param versionLocId the versionLocId
     * @param xAuthRefreshToken the xAuthRefreshToken
     */
    public Builder(String versionLocId, String xAuthRefreshToken) {
      this.versionLocId = versionLocId;
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a GetPreinstallOptions.
     *
     * @return the new GetPreinstallOptions instance
     */
    public GetPreinstallOptions build() {
      return new GetPreinstallOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the GetPreinstallOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the GetPreinstallOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the GetPreinstallOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the GetPreinstallOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the GetPreinstallOptions builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }
  }

  protected GetPreinstallOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    versionLocId = builder.versionLocId;
    xAuthRefreshToken = builder.xAuthRefreshToken;
    clusterId = builder.clusterId;
    region = builder.region;
    namespace = builder.namespace;
  }

  /**
   * New builder.
   *
   * @return a GetPreinstallOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the versionLocId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocId
   */
  public String versionLocId() {
    return versionLocId;
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
   * Gets the namespace.
   *
   * Required if the version's pre-install scope is `namespace`.
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }
}

