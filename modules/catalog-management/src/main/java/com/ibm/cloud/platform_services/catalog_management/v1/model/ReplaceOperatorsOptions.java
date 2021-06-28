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

import java.util.ArrayList;
import java.util.List;

/**
 * The replaceOperators options.
 */
public class ReplaceOperatorsOptions extends GenericModel {

  protected String xAuthRefreshToken;
  protected String clusterId;
  protected String region;
  protected List<String> namespaces;
  protected Boolean allNamespaces;
  protected String versionLocatorId;

  /**
   * Builder.
   */
  public static class Builder {
    private String xAuthRefreshToken;
    private String clusterId;
    private String region;
    private List<String> namespaces;
    private Boolean allNamespaces;
    private String versionLocatorId;

    private Builder(ReplaceOperatorsOptions replaceOperatorsOptions) {
      this.xAuthRefreshToken = replaceOperatorsOptions.xAuthRefreshToken;
      this.clusterId = replaceOperatorsOptions.clusterId;
      this.region = replaceOperatorsOptions.region;
      this.namespaces = replaceOperatorsOptions.namespaces;
      this.allNamespaces = replaceOperatorsOptions.allNamespaces;
      this.versionLocatorId = replaceOperatorsOptions.versionLocatorId;
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
     * Builds a ReplaceOperatorsOptions.
     *
     * @return the new ReplaceOperatorsOptions instance
     */
    public ReplaceOperatorsOptions build() {
      return new ReplaceOperatorsOptions(this);
    }

    /**
     * Adds an namespaces to namespaces.
     *
     * @param namespaces the new namespaces
     * @return the ReplaceOperatorsOptions builder
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
     * @return the ReplaceOperatorsOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the ReplaceOperatorsOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the ReplaceOperatorsOptions builder
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
     * @return the ReplaceOperatorsOptions builder
     */
    public Builder namespaces(List<String> namespaces) {
      this.namespaces = namespaces;
      return this;
    }

    /**
     * Set the allNamespaces.
     *
     * @param allNamespaces the allNamespaces
     * @return the ReplaceOperatorsOptions builder
     */
    public Builder allNamespaces(Boolean allNamespaces) {
      this.allNamespaces = allNamespaces;
      return this;
    }

    /**
     * Set the versionLocatorId.
     *
     * @param versionLocatorId the versionLocatorId
     * @return the ReplaceOperatorsOptions builder
     */
    public Builder versionLocatorId(String versionLocatorId) {
      this.versionLocatorId = versionLocatorId;
      return this;
    }
  }

  protected ReplaceOperatorsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    xAuthRefreshToken = builder.xAuthRefreshToken;
    clusterId = builder.clusterId;
    region = builder.region;
    namespaces = builder.namespaces;
    allNamespaces = builder.allNamespaces;
    versionLocatorId = builder.versionLocatorId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceOperatorsOptions builder
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
   * Gets the allNamespaces.
   *
   * Denotes whether to install Operator(s) globally.
   *
   * @return the allNamespaces
   */
  public Boolean allNamespaces() {
    return allNamespaces;
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

