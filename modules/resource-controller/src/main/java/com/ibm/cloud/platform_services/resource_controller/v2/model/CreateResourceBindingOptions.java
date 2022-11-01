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
 * The createResourceBinding options.
 */
public class CreateResourceBindingOptions extends GenericModel {

  protected String source;
  protected String target;
  protected String name;
  protected ResourceBindingPostParameters parameters;
  protected String role;

  /**
   * Builder.
   */
  public static class Builder {
    private String source;
    private String target;
    private String name;
    private ResourceBindingPostParameters parameters;
    private String role;

    /**
     * Instantiates a new Builder from an existing CreateResourceBindingOptions instance.
     *
     * @param createResourceBindingOptions the instance to initialize the Builder with
     */
    private Builder(CreateResourceBindingOptions createResourceBindingOptions) {
      this.source = createResourceBindingOptions.source;
      this.target = createResourceBindingOptions.target;
      this.name = createResourceBindingOptions.name;
      this.parameters = createResourceBindingOptions.parameters;
      this.role = createResourceBindingOptions.role;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param source the source
     * @param target the target
     */
    public Builder(String source, String target) {
      this.source = source;
      this.target = target;
    }

    /**
     * Builds a CreateResourceBindingOptions.
     *
     * @return the new CreateResourceBindingOptions instance
     */
    public CreateResourceBindingOptions build() {
      return new CreateResourceBindingOptions(this);
    }

    /**
     * Set the source.
     *
     * @param source the source
     * @return the CreateResourceBindingOptions builder
     */
    public Builder source(String source) {
      this.source = source;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the CreateResourceBindingOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateResourceBindingOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the CreateResourceBindingOptions builder
     */
    public Builder parameters(ResourceBindingPostParameters parameters) {
      this.parameters = parameters;
      return this;
    }

    /**
     * Set the role.
     *
     * @param role the role
     * @return the CreateResourceBindingOptions builder
     */
    public Builder role(String role) {
      this.role = role;
      return this;
    }
  }

  protected CreateResourceBindingOptions() { }

  protected CreateResourceBindingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.source,
      "source cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.target,
      "target cannot be null");
    source = builder.source;
    target = builder.target;
    name = builder.name;
    parameters = builder.parameters;
    role = builder.role;
  }

  /**
   * New builder.
   *
   * @return a CreateResourceBindingOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the source.
   *
   * The ID of resource alias.
   *
   * @return the source
   */
  public String source() {
    return source;
  }

  /**
   * Gets the target.
   *
   * The CRN of application to bind to in a specific environment, for example, Dallas YP, CFEE instance.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the name.
   *
   * The name of the binding. Must be 180 characters or less and cannot include any special characters other than
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
   * Configuration options represented as key-value pairs. Service defined options are passed through to the target
   * resource brokers, whereas platform defined options are not.
   *
   * @return the parameters
   */
  public ResourceBindingPostParameters parameters() {
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

