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

import java.util.ArrayList;
import java.util.List;

/**
 * The createOperator options.
 */
public class CreateOperatorOptions extends GenericModel {

  protected String xAuthRefreshToken;
  protected String clusterId;
  protected String region;
  protected List<String> namespaces;
  protected String versionLocatorId;

  /**
   * Builder.
   */
  public static class Builder {
    private String xAuthRefreshToken;
    private String clusterId;
    private String region;
    private List<String> namespaces;
    private String versionLocatorId;

    private Builder(CreateOperatorOptions createOperatorOptions) {
      this.xAuthRefreshToken = createOperatorOptions.xAuthRefreshToken;
      this.clusterId = createOperatorOptions.clusterId;
      this.region = createOperatorOptions.region;
      this.namespaces = createOperatorOptions.namespaces;
      this.versionLocatorId = createOperatorOptions.versionLocatorId;
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
     */
    public Builder(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a CreateOperatorOptions.
     *
     * @return the new CreateOperatorOptions instance
     */
    public CreateOperatorOptions build() {
      return new CreateOperatorOptions(this);
    }

    /**
     * Adds an namespaces to namespaces.
     *
     * @param namespaces the new namespaces
     * @return the CreateOperatorOptions builder
     */
    public Builder addNamespaces(String namespaces) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(namespaces,
        "namespaces cannot be null");
      if (this.namespaces == null) {
        this.namespaces = new ArrayList<String>();
      }
      this.namespaces.add(namespaces);
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the CreateOperatorOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the CreateOperatorOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the CreateOperatorOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the namespaces.
     * Existing namespaces will be replaced.
     *
     * @param namespaces the namespaces
     * @return the CreateOperatorOptions builder
     */
    public Builder namespaces(List<String> namespaces) {
      this.namespaces = namespaces;
      return this;
    }

    /**
     * Set the versionLocatorId.
     *
     * @param versionLocatorId the versionLocatorId
     * @return the CreateOperatorOptions builder
     */
    public Builder versionLocatorId(String versionLocatorId) {
      this.versionLocatorId = versionLocatorId;
      return this;
    }
  }

  protected CreateOperatorOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    xAuthRefreshToken = builder.xAuthRefreshToken;
    clusterId = builder.clusterId;
    region = builder.region;
    namespaces = builder.namespaces;
    versionLocatorId = builder.versionLocatorId;
  }

  /**
   * New builder.
   *
   * @return a CreateOperatorOptions builder
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
   * Cluster ID.
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
   * Gets the namespaces.
   *
   * Kube namespaces to deploy Operator(s) to.
   *
   * @return the namespaces
   */
  public List<String> namespaces() {
    return namespaces;
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

