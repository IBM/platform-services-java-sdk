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
 * The updateProfile options.
 */
public class UpdateProfileOptions extends GenericModel {

  protected String profileId;
  protected String ifMatch;
  protected String name;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String ifMatch;
    private String name;
    private String description;

    private Builder(UpdateProfileOptions updateProfileOptions) {
      this.profileId = updateProfileOptions.profileId;
      this.ifMatch = updateProfileOptions.ifMatch;
      this.name = updateProfileOptions.name;
      this.description = updateProfileOptions.description;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String profileId, String ifMatch) {
      this.profileId = profileId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateProfileOptions.
     *
     * @return the new UpdateProfileOptions instance
     */
    public UpdateProfileOptions build() {
      return new UpdateProfileOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the UpdateProfileOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateProfileOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateProfileOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateProfileOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected UpdateProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    profileId = builder.profileId;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a UpdateProfileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * ID of the trusted profile to be updated.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the ifMatch.
   *
   * Version of the trusted profile to be updated.  Specify the version that you retrived when reading list of trusted
   * profiles. This value helps to identify any parallel usage of trusted profile. Pass * to indicate to update any
   * version available. This might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * The name of the trusted profile to update. If specified in the request the parameter must not be empty. The name is
   * checked for uniqueness. Failure to this will result in an Error condition.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the trusted profile to update. If specified an empty description will clear the description of
   * the trusted profile. If a non empty value is provided the trusted profile will be updated.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

