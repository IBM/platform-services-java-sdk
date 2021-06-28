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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Feature information.
 */
public class SyndicationCluster extends GenericModel {

  protected String region;
  protected String id;
  protected String name;
  @SerializedName("resource_group_name")
  protected String resourceGroupName;
  protected String type;
  protected List<String> namespaces;
  @SerializedName("all_namespaces")
  protected Boolean allNamespaces;

  /**
   * Builder.
   */
  public static class Builder {
    private String region;
    private String id;
    private String name;
    private String resourceGroupName;
    private String type;
    private List<String> namespaces;
    private Boolean allNamespaces;

    private Builder(SyndicationCluster syndicationCluster) {
      this.region = syndicationCluster.region;
      this.id = syndicationCluster.id;
      this.name = syndicationCluster.name;
      this.resourceGroupName = syndicationCluster.resourceGroupName;
      this.type = syndicationCluster.type;
      this.namespaces = syndicationCluster.namespaces;
      this.allNamespaces = syndicationCluster.allNamespaces;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SyndicationCluster.
     *
     * @return the new SyndicationCluster instance
     */
    public SyndicationCluster build() {
      return new SyndicationCluster(this);
    }

    /**
     * Adds an namespaces to namespaces.
     *
     * @param namespaces the new namespaces
     * @return the SyndicationCluster builder
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
     * Set the region.
     *
     * @param region the region
     * @return the SyndicationCluster builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the SyndicationCluster builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the SyndicationCluster builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the resourceGroupName.
     *
     * @param resourceGroupName the resourceGroupName
     * @return the SyndicationCluster builder
     */
    public Builder resourceGroupName(String resourceGroupName) {
      this.resourceGroupName = resourceGroupName;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the SyndicationCluster builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the namespaces.
     * Existing namespaces will be replaced.
     *
     * @param namespaces the namespaces
     * @return the SyndicationCluster builder
     */
    public Builder namespaces(List<String> namespaces) {
      this.namespaces = namespaces;
      return this;
    }

    /**
     * Set the allNamespaces.
     *
     * @param allNamespaces the allNamespaces
     * @return the SyndicationCluster builder
     */
    public Builder allNamespaces(Boolean allNamespaces) {
      this.allNamespaces = allNamespaces;
      return this;
    }
  }

  protected SyndicationCluster(Builder builder) {
    region = builder.region;
    id = builder.id;
    name = builder.name;
    resourceGroupName = builder.resourceGroupName;
    type = builder.type;
    namespaces = builder.namespaces;
    allNamespaces = builder.allNamespaces;
  }

  /**
   * New builder.
   *
   * @return a SyndicationCluster builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the id.
   *
   * Cluster ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * Cluster name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the resourceGroupName.
   *
   * Resource group ID.
   *
   * @return the resourceGroupName
   */
  public String resourceGroupName() {
    return resourceGroupName;
  }

  /**
   * Gets the type.
   *
   * Syndication type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the namespaces.
   *
   * Syndicated namespaces.
   *
   * @return the namespaces
   */
  public List<String> namespaces() {
    return namespaces;
  }

  /**
   * Gets the allNamespaces.
   *
   * Syndicated to all namespaces on cluster.
   *
   * @return the allNamespaces
   */
  public Boolean allNamespaces() {
    return allNamespaces;
  }
}

