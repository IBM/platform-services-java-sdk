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
 * The deleteResourceAlias options.
 */
public class DeleteResourceAliasOptions extends GenericModel {

  protected String id;
  protected Boolean recursive;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private Boolean recursive;

    /**
     * Instantiates a new Builder from an existing DeleteResourceAliasOptions instance.
     *
     * @param deleteResourceAliasOptions the instance to initialize the Builder with
     */
    private Builder(DeleteResourceAliasOptions deleteResourceAliasOptions) {
      this.id = deleteResourceAliasOptions.id;
      this.recursive = deleteResourceAliasOptions.recursive;
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
     * Builds a DeleteResourceAliasOptions.
     *
     * @return the new DeleteResourceAliasOptions instance
     */
    public DeleteResourceAliasOptions build() {
      return new DeleteResourceAliasOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteResourceAliasOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the recursive.
     *
     * @param recursive the recursive
     * @return the DeleteResourceAliasOptions builder
     */
    public Builder recursive(Boolean recursive) {
      this.recursive = recursive;
      return this;
    }
  }

  protected DeleteResourceAliasOptions() { }

  protected DeleteResourceAliasOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
    recursive = builder.recursive;
  }

  /**
   * New builder.
   *
   * @return a DeleteResourceAliasOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The resource alias URL-encoded CRN or GUID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the recursive.
   *
   * Deletes the resource bindings and keys associated with the alias.
   *
   * @return the recursive
   */
  public Boolean recursive() {
    return recursive;
  }
}

