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
 * The getVersionUpdates options.
 */
public class GetVersionUpdatesOptions extends GenericModel {

  protected String versionLocId;
  protected String clusterId;
  protected String region;
  protected String resourceGroupId;
  protected String namespace;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private String clusterId;
    private String region;
    private String resourceGroupId;
    private String namespace;

    private Builder(GetVersionUpdatesOptions getVersionUpdatesOptions) {
      this.versionLocId = getVersionUpdatesOptions.versionLocId;
      this.clusterId = getVersionUpdatesOptions.clusterId;
      this.region = getVersionUpdatesOptions.region;
      this.resourceGroupId = getVersionUpdatesOptions.resourceGroupId;
      this.namespace = getVersionUpdatesOptions.namespace;
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
     */
    public Builder(String versionLocId) {
      this.versionLocId = versionLocId;
    }

    /**
     * Builds a GetVersionUpdatesOptions.
     *
     * @return the new GetVersionUpdatesOptions instance
     */
    public GetVersionUpdatesOptions build() {
      return new GetVersionUpdatesOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the GetVersionUpdatesOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the GetVersionUpdatesOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the GetVersionUpdatesOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the GetVersionUpdatesOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the GetVersionUpdatesOptions builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }
  }

  protected GetVersionUpdatesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    versionLocId = builder.versionLocId;
    clusterId = builder.clusterId;
    region = builder.region;
    resourceGroupId = builder.resourceGroupId;
    namespace = builder.namespace;
  }

  /**
   * New builder.
   *
   * @return a GetVersionUpdatesOptions builder
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
   * Gets the clusterId.
   *
   * The id of the cluster where this version was installed.
   *
   * @return the clusterId
   */
  public String clusterId() {
    return clusterId;
  }

  /**
   * Gets the region.
   *
   * The region of the cluster where this version was installed.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the resourceGroupId.
   *
   * The resource group id of the cluster where this version was installed.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the namespace.
   *
   * The namespace of the cluster where this version was installed.
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }
}

