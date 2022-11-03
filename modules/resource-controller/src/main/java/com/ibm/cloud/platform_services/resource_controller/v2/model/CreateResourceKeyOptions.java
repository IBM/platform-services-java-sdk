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
 * The createResourceKey options.
 */
public class CreateResourceKeyOptions extends GenericModel {

  protected String name;
  protected String source;
  protected ResourceKeyPostParameters parameters;
  protected String role;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String source;
    private ResourceKeyPostParameters parameters;
    private String role;

    /**
     * Instantiates a new Builder from an existing CreateResourceKeyOptions instance.
     *
     * @param createResourceKeyOptions the instance to initialize the Builder with
     */
    private Builder(CreateResourceKeyOptions createResourceKeyOptions) {
      this.name = createResourceKeyOptions.name;
      this.source = createResourceKeyOptions.source;
      this.parameters = createResourceKeyOptions.parameters;
      this.role = createResourceKeyOptions.role;
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
     */
    public Builder(String name, String source) {
      this.name = name;
      this.source = source;
    }

    /**
     * Builds a CreateResourceKeyOptions.
     *
     * @return the new CreateResourceKeyOptions instance
     */
    public CreateResourceKeyOptions build() {
      return new CreateResourceKeyOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateResourceKeyOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the CreateResourceKeyOptions builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the CreateResourceKeyOptions builder
     */
    public Builder parameters(ResourceKeyPostParameters parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the CreateResourceKeyOptions builder
     */
    public Builder role(String role) {
      this.role = role;
      return this;
    }
  }

  protected CreateResourceKeyOptions() { }

  protected CreateResourceKeyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source,
      "source cannot be null");
    name = builder.name;
    source = builder.source;
    parameters = builder.parameters;
    role = builder.role;
  }

  /**
   * New builder.
   *
   * @return a CreateResourceKeyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the key.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the source.
   *
   * The ID of resource instance or alias.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the parameters.
   *
   * Configuration options represented as key-value pairs. Service defined options are passed through to the target
   * resource brokers, whereas platform defined options are not.
   *
   * @return the parameters
   */
  public ResourceKeyPostParameters parameters() {
    return parameters;
  }

  /**
   * Gets the role.
   *
   * The base IAM service role name (Reader, Writer, or Manager), or the service or custom role CRN. Refer to service’s
   * documentation for supported roles.
   *
   * @return the role
   */
  public String role() {
    return role;
  }
}

