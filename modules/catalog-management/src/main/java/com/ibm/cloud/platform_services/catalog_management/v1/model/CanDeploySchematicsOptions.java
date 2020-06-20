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
 * The canDeploySchematics options.
 */
public class CanDeploySchematicsOptions extends GenericModel {

  protected String versionLocId;
  protected String clusterId;
  protected String region;
  protected String namespace;
  protected String resourceGroupId;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private String clusterId;
    private String region;
    private String namespace;
    private String resourceGroupId;

    private Builder(CanDeploySchematicsOptions canDeploySchematicsOptions) {
      this.versionLocId = canDeploySchematicsOptions.versionLocId;
      this.clusterId = canDeploySchematicsOptions.clusterId;
      this.region = canDeploySchematicsOptions.region;
      this.namespace = canDeploySchematicsOptions.namespace;
      this.resourceGroupId = canDeploySchematicsOptions.resourceGroupId;
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
     * @param clusterId the clusterId
     * @param region the region
     */
    public Builder(String versionLocId, String clusterId, String region) {
      this.versionLocId = versionLocId;
      this.clusterId = clusterId;
      this.region = region;
    }

    /**
     * Builds a CanDeploySchematicsOptions.
     *
     * @return the new CanDeploySchematicsOptions instance
     */
    public CanDeploySchematicsOptions build() {
      return new CanDeploySchematicsOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the CanDeploySchematicsOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the CanDeploySchematicsOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the CanDeploySchematicsOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the CanDeploySchematicsOptions builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the CanDeploySchematicsOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }
  }

  protected CanDeploySchematicsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.clusterId,
      "clusterId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.region,
      "region cannot be null");
    versionLocId = builder.versionLocId;
    clusterId = builder.clusterId;
    region = builder.region;
    namespace = builder.namespace;
    resourceGroupId = builder.resourceGroupId;
  }

  /**
   * New builder.
   *
   * @return a CanDeploySchematicsOptions builder
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

  /**
   * Gets the resourceGroupId.
   *
   * Resource group identification.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }
}

