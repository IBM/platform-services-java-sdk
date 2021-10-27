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
package com.ibm.cloud.platform_services.resource_manager.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateResourceGroup options.
 */
public class UpdateResourceGroupOptions extends GenericModel {

  protected String id;
  protected String name;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;
    private String state;

    private Builder(UpdateResourceGroupOptions updateResourceGroupOptions) {
      this.id = updateResourceGroupOptions.id;
      this.name = updateResourceGroupOptions.name;
      this.state = updateResourceGroupOptions.state;
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
     * Builds a UpdateResourceGroupOptions.
     *
     * @return the new UpdateResourceGroupOptions instance
     */
    public UpdateResourceGroupOptions build() {
      return new UpdateResourceGroupOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateResourceGroupOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateResourceGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the UpdateResourceGroupOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected UpdateResourceGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    name = builder.name;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a UpdateResourceGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The short or long ID of the alias.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The new name of the resource group.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the state.
   *
   * The state of the resource group.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

