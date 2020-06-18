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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Feature information.
 */
public class SyndicationResource extends GenericModel {

  @SerializedName("remove_related_components")
  protected Boolean removeRelatedComponents;
  protected List<SyndicationCluster> clusters;
  protected SyndicationHistory history;
  protected SyndicationAuthorization authorization;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean removeRelatedComponents;
    private List<SyndicationCluster> clusters;
    private SyndicationHistory history;
    private SyndicationAuthorization authorization;

    private Builder(SyndicationResource syndicationResource) {
      this.removeRelatedComponents = syndicationResource.removeRelatedComponents;
      this.clusters = syndicationResource.clusters;
      this.history = syndicationResource.history;
      this.authorization = syndicationResource.authorization;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SyndicationResource.
     *
     * @return the new SyndicationResource instance
     */
    public SyndicationResource build() {
      return new SyndicationResource(this);
    }

    /**
     * Adds an clusters to clusters.
     *
     * @param clusters the new clusters
     * @return the SyndicationResource builder
     */
    public Builder addClusters(SyndicationCluster clusters) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(clusters,
        "clusters cannot be null");
      if (this.clusters == null) {
        this.clusters = new ArrayList<SyndicationCluster>();
      }
      this.clusters.add(clusters);
      return this;
    }

    /**
     * Set the removeRelatedComponents.
     *
     * @param removeRelatedComponents the removeRelatedComponents
     * @return the SyndicationResource builder
     */
    public Builder removeRelatedComponents(Boolean removeRelatedComponents) {
      this.removeRelatedComponents = removeRelatedComponents;
      return this;
    }

    /**
     * Set the clusters.
     * Existing clusters will be replaced.
     *
     * @param clusters the clusters
     * @return the SyndicationResource builder
     */
    public Builder clusters(List<SyndicationCluster> clusters) {
      this.clusters = clusters;
      return this;
    }

    /**
     * Set the history.
     *
     * @param history the history
     * @return the SyndicationResource builder
     */
    public Builder history(SyndicationHistory history) {
      this.history = history;
      return this;
    }

    /**
     * Set the authorization.
     *
     * @param authorization the authorization
     * @return the SyndicationResource builder
     */
    public Builder authorization(SyndicationAuthorization authorization) {
      this.authorization = authorization;
      return this;
    }
  }

  protected SyndicationResource(Builder builder) {
    removeRelatedComponents = builder.removeRelatedComponents;
    clusters = builder.clusters;
    history = builder.history;
    authorization = builder.authorization;
  }

  /**
   * New builder.
   *
   * @return a SyndicationResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the removeRelatedComponents.
   *
   * Remove related components.
   *
   * @return the removeRelatedComponents
   */
  public Boolean removeRelatedComponents() {
    return removeRelatedComponents;
  }

  /**
   * Gets the clusters.
   *
   * Syndication clusters.
   *
   * @return the clusters
   */
  public List<SyndicationCluster> clusters() {
    return clusters;
  }

  /**
   * Gets the history.
   *
   * Feature information.
   *
   * @return the history
   */
  public SyndicationHistory history() {
    return history;
  }

  /**
   * Gets the authorization.
   *
   * Feature information.
   *
   * @return the authorization
   */
  public SyndicationAuthorization authorization() {
    return authorization;
  }
}

