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
 * The createResourceAlias options.
 */
public class CreateResourceAliasOptions extends GenericModel {

  protected String name;
  protected String source;
  protected String target;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String source;
    private String target;

    /**
     * Instantiates a new Builder from an existing CreateResourceAliasOptions instance.
     *
     * @param createResourceAliasOptions the instance to initialize the Builder with
     */
    private Builder(CreateResourceAliasOptions createResourceAliasOptions) {
      this.name = createResourceAliasOptions.name;
      this.source = createResourceAliasOptions.source;
      this.target = createResourceAliasOptions.target;
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
     * @param source the source
     * @param target the target
     */
    public Builder(String name, String source, String target) {
      this.name = name;
      this.source = source;
      this.target = target;
    }

    /**
     * Builds a CreateResourceAliasOptions.
     *
     * @return the new CreateResourceAliasOptions instance
     */
    public CreateResourceAliasOptions build() {
      return new CreateResourceAliasOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateResourceAliasOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the CreateResourceAliasOptions builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateResourceAliasOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }
  }

  protected CreateResourceAliasOptions() { }

  protected CreateResourceAliasOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source,
      "source cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    name = builder.name;
    source = builder.source;
    target = builder.target;
  }

  /**
   * New builder.
   *
   * @return a CreateResourceAliasOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the alias. Must be 180 characters or less and cannot include any special characters other than `(space)
   * - . _ :`.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the source.
   *
   * The ID of resource instance.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the target.
   *
   * The CRN of target name(space) in a specific environment, for example, space in Dallas YP, CFEE instance etc.
   *
   * @return the target
   */
  public String target() {
    return target;
  }
}

