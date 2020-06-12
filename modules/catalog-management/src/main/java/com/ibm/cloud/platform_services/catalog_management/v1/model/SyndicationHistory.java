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
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Feature information.
 */
public class SyndicationHistory extends GenericModel {

  protected List<String> namespaces;
  protected List<SyndicationCluster> clusters;
  @SerializedName("last_run")
  protected Date lastRun;

  /**
   * Builder.
   */
  public static class Builder {
    private List<String> namespaces;
    private List<SyndicationCluster> clusters;
    private Date lastRun;

    private Builder(SyndicationHistory syndicationHistory) {
      this.namespaces = syndicationHistory.namespaces;
      this.clusters = syndicationHistory.clusters;
      this.lastRun = syndicationHistory.lastRun;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SyndicationHistory.
     *
     * @return the new SyndicationHistory instance
     */
    public SyndicationHistory build() {
      return new SyndicationHistory(this);
    }

    /**
     * Adds an namespaces to namespaces.
     *
     * @param namespaces the new namespaces
     * @return the SyndicationHistory builder
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
     * Adds an clusters to clusters.
     *
     * @param clusters the new clusters
     * @return the SyndicationHistory builder
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
     * Set the namespaces.
     * Existing namespaces will be replaced.
     *
     * @param namespaces the namespaces
     * @return the SyndicationHistory builder
     */
    public Builder namespaces(List<String> namespaces) {
      this.namespaces = namespaces;
      return this;
    }

    /**
     * Set the clusters.
     * Existing clusters will be replaced.
     *
     * @param clusters the clusters
     * @return the SyndicationHistory builder
     */
    public Builder clusters(List<SyndicationCluster> clusters) {
      this.clusters = clusters;
      return this;
    }

    /**
     * Set the lastRun.
     *
     * @param lastRun the lastRun
     * @return the SyndicationHistory builder
     */
    public Builder lastRun(Date lastRun) {
      this.lastRun = lastRun;
      return this;
    }
  }

  protected SyndicationHistory(Builder builder) {
    namespaces = builder.namespaces;
    clusters = builder.clusters;
    lastRun = builder.lastRun;
  }

  /**
   * New builder.
   *
   * @return a SyndicationHistory builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the namespaces.
   *
   * Array of syndicated namespaces.
   *
   * @return the namespaces
   */
  public List<String> namespaces() {
    return namespaces;
  }

  /**
   * Gets the clusters.
   *
   * Array of syndicated namespaces.
   *
   * @return the clusters
   */
  public List<SyndicationCluster> clusters() {
    return clusters;
  }

  /**
   * Gets the lastRun.
   *
   * Date and time last syndicated.
   *
   * @return the lastRun
   */
  public Date lastRun() {
    return lastRun;
  }
}

