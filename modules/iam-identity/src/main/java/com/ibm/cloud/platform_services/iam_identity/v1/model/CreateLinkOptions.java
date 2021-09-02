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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createLink options.
 */
public class CreateLinkOptions extends GenericModel {

  protected String profileId;
  protected String crType;
  protected CreateProfileLinkRequestLink link;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String crType;
    private CreateProfileLinkRequestLink link;
    private String name;

    private Builder(CreateLinkOptions createLinkOptions) {
      this.profileId = createLinkOptions.profileId;
      this.crType = createLinkOptions.crType;
      this.link = createLinkOptions.link;
      this.name = createLinkOptions.name;
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
     * @param crType the crType
     * @param link the link
     */
    public Builder(String profileId, String crType, CreateProfileLinkRequestLink link) {
      this.profileId = profileId;
      this.crType = crType;
      this.link = link;
    }

    /**
     * Builds a CreateLinkOptions.
     *
     * @return the new CreateLinkOptions instance
     */
    public CreateLinkOptions build() {
      return new CreateLinkOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the CreateLinkOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the crType.
     *
     * @param crType the crType
     * @return the CreateLinkOptions builder
     */
    public Builder crType(String crType) {
      this.crType = crType;
      return this;
    }

    /**
     * Set the link.
     *
     * @param link the link
     * @return the CreateLinkOptions builder
     */
    public Builder link(CreateProfileLinkRequestLink link) {
      this.link = link;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateLinkOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected CreateLinkOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.crType,
      "crType cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.link,
      "link cannot be null");
    profileId = builder.profileId;
    crType = builder.crType;
    link = builder.link;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a CreateLinkOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * ID of the trusted profile.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the crType.
   *
   * The compute resource type. Valid values are VSI, IKS_SA, ROKS_SA.
   *
   * @return the crType
   */
  public String crType() {
    return crType;
  }

  /**
   * Gets the link.
   *
   * Link details.
   *
   * @return the link
   */
  public CreateProfileLinkRequestLink link() {
    return link;
  }

  /**
   * Gets the name.
   *
   * Optional name of the Link.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

