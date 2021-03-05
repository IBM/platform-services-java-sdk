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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateResourceInstance options.
 */
public class UpdateResourceInstanceOptions extends GenericModel {

  protected String id;
  protected String name;
  protected Map<String, Object> parameters;
  protected String resourcePlanId;
  protected Boolean allowCleanup;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private Map<String, Object> parameters;
    private String resourcePlanId;
    private Boolean allowCleanup;

    private Builder(UpdateResourceInstanceOptions updateResourceInstanceOptions) {
      this.id = updateResourceInstanceOptions.id;
      this.name = updateResourceInstanceOptions.name;
      this.parameters = updateResourceInstanceOptions.parameters;
      this.resourcePlanId = updateResourceInstanceOptions.resourcePlanId;
      this.allowCleanup = updateResourceInstanceOptions.allowCleanup;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a UpdateResourceInstanceOptions.
     *
     * @return the new UpdateResourceInstanceOptions instance
     */
    public UpdateResourceInstanceOptions build() {
      return new UpdateResourceInstanceOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateResourceInstanceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateResourceInstanceOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the UpdateResourceInstanceOptions builder
     */
    public Builder parameters(Map<String, Object> parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the resourcePlanId.
     *
     * @param resourcePlanId the resourcePlanId
     * @return the UpdateResourceInstanceOptions builder
     */
    public Builder resourcePlanId(String resourcePlanId) {
      this.resourcePlanId = resourcePlanId;
      return this;
    }

    /**
     * Set the allowCleanup.
     *
     * @param allowCleanup the allowCleanup
     * @return the UpdateResourceInstanceOptions builder
     */
    public Builder allowCleanup(Boolean allowCleanup) {
      this.allowCleanup = allowCleanup;
      return this;
    }
  }

  protected UpdateResourceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    name = builder.name;
    parameters = builder.parameters;
    resourcePlanId = builder.resourcePlanId;
    allowCleanup = builder.allowCleanup;
  }

  /**
   * New builder.
   *
   * @return a UpdateResourceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The short or long ID of the instance.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The new name of the instance. Must be 180 characters or less and cannot include any special characters other than
   * `(space) - . _ :`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the parameters.
   *
   * The new configuration options for the instance.
   *
   * @return the parameters
   */
  public Map<String, Object> parameters() {
    return parameters;
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
}

