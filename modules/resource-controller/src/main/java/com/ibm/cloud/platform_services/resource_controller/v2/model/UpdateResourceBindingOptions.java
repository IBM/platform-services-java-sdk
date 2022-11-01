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
 * The updateResourceBinding options.
 */
public class UpdateResourceBindingOptions extends GenericModel {

  protected String id;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;

    /**
     * Instantiates a new Builder from an existing UpdateResourceBindingOptions instance.
     *
     * @param updateResourceBindingOptions the instance to initialize the Builder with
     */
    private Builder(UpdateResourceBindingOptions updateResourceBindingOptions) {
      this.id = updateResourceBindingOptions.id;
      this.name = updateResourceBindingOptions.name;
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
     * @param name the name
     */
    public Builder(String id, String name) {
      this.id = id;
      this.name = name;
    }

    /**
     * Builds a UpdateResourceBindingOptions.
     *
     * @return the new UpdateResourceBindingOptions instance
     */
    public UpdateResourceBindingOptions build() {
      return new UpdateResourceBindingOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateResourceBindingOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateResourceBindingOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected UpdateResourceBindingOptions() { }

  protected UpdateResourceBindingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    id = builder.id;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a UpdateResourceBindingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The resource binding URL-encoded CRN or GUID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The new name of the binding. Must be 180 characters or less and cannot include any special characters other than
   * `(space) - . _ :`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

