/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Link details.
 */
public class CreateProfileLinkRequestLink extends GenericModel {

  protected String crn;
  protected String namespace;
  protected String name;
  @SerializedName("component_type")
  protected String componentType;
  @SerializedName("component_name")
  protected String componentName;

  /**
   * Builder.
   */
  public static class Builder {
    private String crn;
    private String namespace;
    private String name;
    private String componentType;
    private String componentName;

    /**
     * Instantiates a new Builder from an existing CreateProfileLinkRequestLink instance.
     *
     * @param createProfileLinkRequestLink the instance to initialize the Builder with
     */
    private Builder(CreateProfileLinkRequestLink createProfileLinkRequestLink) {
      this.crn = createProfileLinkRequestLink.crn;
      this.namespace = createProfileLinkRequestLink.namespace;
      this.name = createProfileLinkRequestLink.name;
      this.componentType = createProfileLinkRequestLink.componentType;
      this.componentName = createProfileLinkRequestLink.componentName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param crn the crn
     */
    public Builder(String crn) {
      this.crn = crn;
    }

    /**
     * Builds a CreateProfileLinkRequestLink.
     *
     * @return the new CreateProfileLinkRequestLink instance
     */
    public CreateProfileLinkRequestLink build() {
      return new CreateProfileLinkRequestLink(this);
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the componentType.
     *
     * @param componentType the componentType
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder componentType(String componentType) {
      this.componentType = componentType;
      return this;
    }

    /**
     * Set the componentName.
     *
     * @param componentName the componentName
     * @return the CreateProfileLinkRequestLink builder
     */
    public Builder componentName(String componentName) {
      this.componentName = componentName;
      return this;
    }
  }

  protected CreateProfileLinkRequestLink() { }

  protected CreateProfileLinkRequestLink(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.crn,
      "crn cannot be null");
    crn = builder.crn;
    namespace = builder.namespace;
    name = builder.name;
    componentType = builder.componentType;
    componentName = builder.componentName;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileLinkRequestLink builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the crn.
   *
   * The CRN of the compute resource.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the namespace.
   *
   * The compute resource namespace, only required if cr_type is IKS_SA or ROKS_SA.
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }

  /**
   * Gets the name.
   *
   * Name of the compute resource, only required if cr_type is IKS_SA or ROKS_SA.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the componentType.
   *
   * Component type of the compute resource, only required if cr_type is CE.
   *
   * @return the componentType
   */
  public String componentType() {
    return componentType;
  }

  /**
   * Gets the componentName.
   *
   * Component name of the compute resource, only required if cr_type is CE.
   *
   * @return the componentName
   */
  public String componentName() {
    return componentName;
  }
}

