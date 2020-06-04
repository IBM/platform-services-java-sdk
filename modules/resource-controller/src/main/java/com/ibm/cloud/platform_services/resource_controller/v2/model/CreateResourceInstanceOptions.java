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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createResourceInstance options.
 */
public class CreateResourceInstanceOptions extends GenericModel {

  protected String name;
  protected String target;
  protected String resourceGroup;
  protected String resourcePlanId;
  protected List<String> tags;
  protected Boolean allowCleanup;
  protected Map<String, Object> parameters;
  protected String entityLock;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String target;
    private String resourceGroup;
    private String resourcePlanId;
    private List<String> tags;
    private Boolean allowCleanup;
    private Map<String, Object> parameters;
    private String entityLock;

    private Builder(CreateResourceInstanceOptions createResourceInstanceOptions) {
      this.name = createResourceInstanceOptions.name;
      this.target = createResourceInstanceOptions.target;
      this.resourceGroup = createResourceInstanceOptions.resourceGroup;
      this.resourcePlanId = createResourceInstanceOptions.resourcePlanId;
      this.tags = createResourceInstanceOptions.tags;
      this.allowCleanup = createResourceInstanceOptions.allowCleanup;
      this.parameters = createResourceInstanceOptions.parameters;
      this.entityLock = createResourceInstanceOptions.entityLock;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param target the target
     * @param resourceGroup the resourceGroup
     * @param resourcePlanId the resourcePlanId
     */
    public Builder(String name, String target, String resourceGroup, String resourcePlanId) {
      this.name = name;
      this.target = target;
      this.resourceGroup = resourceGroup;
      this.resourcePlanId = resourcePlanId;
    }

    /**
     * Builds a CreateResourceInstanceOptions.
     *
     * @return the new CreateResourceInstanceOptions instance
     */
    public CreateResourceInstanceOptions build() {
      return new CreateResourceInstanceOptions(this);
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the CreateResourceInstanceOptions builder
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
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the resourceGroup.
     *
     * @param resourceGroup the resourceGroup
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder resourceGroup(String resourceGroup) {
      this.resourceGroup = resourceGroup;
      return this;
    }

    /**
     * Set the resourcePlanId.
     *
     * @param resourcePlanId the resourcePlanId
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder resourcePlanId(String resourcePlanId) {
      this.resourcePlanId = resourcePlanId;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder tags(List<String> tags) {
      this.tags = tags;
      return this;
    }

    /**
     * Set the allowCleanup.
     *
     * @param allowCleanup the allowCleanup
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder allowCleanup(Boolean allowCleanup) {
      this.allowCleanup = allowCleanup;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder parameters(Map<String, Object> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the entityLock.
     *
     * @param entityLock the entityLock
     * @return the CreateResourceInstanceOptions builder
     */
    public Builder entityLock(String entityLock) {
      this.entityLock = entityLock;
      return this;
    }
  }

  protected CreateResourceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourceGroup,
      "resourceGroup cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.resourcePlanId,
      "resourcePlanId cannot be null");
    name = builder.name;
    target = builder.target;
    resourceGroup = builder.resourceGroup;
    resourcePlanId = builder.resourcePlanId;
    tags = builder.tags;
    allowCleanup = builder.allowCleanup;
    parameters = builder.parameters;
    entityLock = builder.entityLock;
  }

  /**
   * New builder.
   *
   * @return a CreateResourceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the instance. Must be 180 characters or less and cannot include any special characters other than
   * `(space) - . _ :`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the target.
   *
   * The deployment location where the instance should be hosted.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the resourceGroup.
   *
   * Short or long ID of resource group.
   *
   * @return the resourceGroup
   */
  public String resourceGroup() {
    return resourceGroup;
  }

  /**
   * Gets the resourcePlanId.
   *
   * The unique ID of the plan associated with the offering. This value is provided by and stored in the global catalog.
   *
   * @return the resourcePlanId
   */
  public String resourcePlanId() {
    return resourcePlanId;
  }

  /**
   * Gets the tags.
   *
   * Tags that are attached to the instance after provisioning. These tags can be searched and managed through the
   * Tagging API in IBM Cloud.
   *
   * @return the tags
   */
  public List<String> tags() {
    return tags;
  }

  /**
   * Gets the allowCleanup.
   *
   * A boolean that dictates if the resource instance should be deleted (cleaned up) during the processing of a region
   * instance delete call.
   *
   * @return the allowCleanup
   */
  public Boolean allowCleanup() {
    return allowCleanup;
  }

  /**
   * Gets the parameters.
   *
   * Configuration options represented as key-value pairs that are passed through to the target resource brokers.
   *
   * @return the parameters
   */
  public Map<String, Object> parameters() {
    return parameters;
  }

  /**
   * Gets the entityLock.
   *
   * Indicates if the resource instance is locked for further update or delete operations. It does not affect actions
   * performed on child resources like aliases, bindings or keys. False by default.
   *
   * @return the entityLock
   */
  public String entityLock() {
    return entityLock;
  }
}

