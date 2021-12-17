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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Schematics workspace configuration.
 */
public class DeployRequestBodySchematics extends GenericModel {

  protected String name;
  protected String description;
  protected List<String> tags;
  @SerializedName("resource_group_id")
  protected String resourceGroupId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private List<String> tags;
    private String resourceGroupId;

    private Builder(DeployRequestBodySchematics deployRequestBodySchematics) {
      this.name = deployRequestBodySchematics.name;
      this.description = deployRequestBodySchematics.description;
      this.tags = deployRequestBodySchematics.tags;
      this.resourceGroupId = deployRequestBodySchematics.resourceGroupId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DeployRequestBodySchematics.
     *
     * @return the new DeployRequestBodySchematics instance
     */
    public DeployRequestBodySchematics build() {
      return new DeployRequestBodySchematics(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the DeployRequestBodySchematics builder
     */
    public Builder addTags(String tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<String>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the DeployRequestBodySchematics builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DeployRequestBodySchematics builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the DeployRequestBodySchematics builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the DeployRequestBodySchematics builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }
  }

  protected DeployRequestBodySchematics(Builder builder) {
    name = builder.name;
    description = builder.description;
    tags = builder.tags;
    resourceGroupId = builder.resourceGroupId;
  }

  /**
   * New builder.
   *
   * @return a DeployRequestBodySchematics builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Schematics workspace name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Schematics workspace description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the tags.
   *
   * Schematics workspace tags.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Resource group to use when creating the schematics workspace.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }
}

