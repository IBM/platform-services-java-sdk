/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteResourceInstance options.
 */
public class DeleteResourceInstanceOptions extends GenericModel {

  protected String id;
  protected Boolean recursive;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Boolean recursive;

    /**
     * Instantiates a new Builder from an existing DeleteResourceInstanceOptions instance.
     *
     * @param deleteResourceInstanceOptions the instance to initialize the Builder with
     */
    private Builder(DeleteResourceInstanceOptions deleteResourceInstanceOptions) {
      this.id = deleteResourceInstanceOptions.id;
      this.recursive = deleteResourceInstanceOptions.recursive;
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
     * Builds a DeleteResourceInstanceOptions.
     *
     * @return the new DeleteResourceInstanceOptions instance
     */
    public DeleteResourceInstanceOptions build() {
      return new DeleteResourceInstanceOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteResourceInstanceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the recursive.
     *
     * @param recursive the recursive
     * @return the DeleteResourceInstanceOptions builder
     */
    public Builder recursive(Boolean recursive) {
      this.recursive = recursive;
      return this;
    }
  }

  protected DeleteResourceInstanceOptions() { }

  protected DeleteResourceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    recursive = builder.recursive;
  }

  /**
   * New builder.
   *
   * @return a DeleteResourceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The resource instance URL-encoded CRN or GUID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the recursive.
   *
   * Will delete resource bindings, keys and aliases associated with the instance.
   *
   * @return the recursive
   */
  public Boolean recursive() {
    return recursive;
  }
}

