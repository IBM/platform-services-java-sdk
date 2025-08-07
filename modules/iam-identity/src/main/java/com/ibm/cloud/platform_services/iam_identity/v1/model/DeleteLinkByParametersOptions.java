/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteLinkByParameters options.
 */
public class DeleteLinkByParametersOptions extends GenericModel {

  protected String profileId;
  protected String type;
  protected String crn;
  protected String namespace;
  protected String name;
  protected String componentType;
  protected String componentName;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String type;
    private String crn;
    private String namespace;
    private String name;
    private String componentType;
    private String componentName;

    /**
     * Instantiates a new Builder from an existing DeleteLinkByParametersOptions instance.
     *
     * @param deleteLinkByParametersOptions the instance to initialize the Builder with
     */
    private Builder(DeleteLinkByParametersOptions deleteLinkByParametersOptions) {
      this.profileId = deleteLinkByParametersOptions.profileId;
      this.type = deleteLinkByParametersOptions.type;
      this.crn = deleteLinkByParametersOptions.crn;
      this.namespace = deleteLinkByParametersOptions.namespace;
      this.name = deleteLinkByParametersOptions.name;
      this.componentType = deleteLinkByParametersOptions.componentType;
      this.componentName = deleteLinkByParametersOptions.componentName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profileId the profileId
     * @param type the type
     */
    public Builder(String profileId, String type) {
      this.profileId = profileId;
      this.type = type;
    }

    /**
     * Builds a DeleteLinkByParametersOptions.
     *
     * @return the new DeleteLinkByParametersOptions instance
     */
    public DeleteLinkByParametersOptions build() {
      return new DeleteLinkByParametersOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the componentType.
     *
     * @param componentType the componentType
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder componentType(String componentType) {
      this.componentType = componentType;
      return this;
    }

    /**
     * Set the componentName.
     *
     * @param componentName the componentName
     * @return the DeleteLinkByParametersOptions builder
     */
    public Builder componentName(String componentName) {
      this.componentName = componentName;
      return this;
    }
  }

  protected DeleteLinkByParametersOptions() { }

  protected DeleteLinkByParametersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    profileId = builder.profileId;
    type = builder.type;
    crn = builder.crn;
    namespace = builder.namespace;
    name = builder.name;
    componentType = builder.componentType;
    componentName = builder.componentName;
  }

  /**
   * New builder.
   *
   * @return a DeleteLinkByParametersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * The unique ID of the Trusted Profile.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the type.
   *
   * The compute resource type. Valid values are VSI, BMS, IKS_SA, ROKS_SA, CE.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the crn.
   *
   * CRN of the compute resource (IKS/ROKS/VSI/BMS).
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the namespace.
   *
   * Namespace of the compute resource (IKS/ROKS).
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }

  /**
   * Gets the name.
   *
   * Name of the compute resource (IKS/ROKS).
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the componentType.
   *
   * Component type of the compute resource, only required if type is CE.
   *
   * @return the componentType
   */
  public String componentType() {
    return componentType;
  }

  /**
   * Gets the componentName.
   *
   * Component name of the compute resource, only required if type is CE.
   *
   * @return the componentName
   */
  public String componentName() {
    return componentName;
  }
}

