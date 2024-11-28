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
 * The deleteProfileIdentity options.
 */
public class DeleteProfileIdentityOptions extends GenericModel {

  /**
   * Type of the identity.
   */
  public interface IdentityType {
    /** user. */
    String USER = "user";
    /** serviceid. */
    String SERVICEID = "serviceid";
    /** crn. */
    String CRN = "crn";
  }

  protected String profileId;
  protected String identityType;
  protected String identifierId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String identityType;
    private String identifierId;

    /**
     * Instantiates a new Builder from an existing DeleteProfileIdentityOptions instance.
     *
     * @param deleteProfileIdentityOptions the instance to initialize the Builder with
     */
    private Builder(DeleteProfileIdentityOptions deleteProfileIdentityOptions) {
      this.profileId = deleteProfileIdentityOptions.profileId;
      this.identityType = deleteProfileIdentityOptions.identityType;
      this.identifierId = deleteProfileIdentityOptions.identifierId;
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
     * @param identityType the identityType
     * @param identifierId the identifierId
     */
    public Builder(String profileId, String identityType, String identifierId) {
      this.profileId = profileId;
      this.identityType = identityType;
      this.identifierId = identifierId;
    }

    /**
     * Builds a DeleteProfileIdentityOptions.
     *
     * @return the new DeleteProfileIdentityOptions instance
     */
    public DeleteProfileIdentityOptions build() {
      return new DeleteProfileIdentityOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the DeleteProfileIdentityOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the identityType.
     *
     * @param identityType the identityType
     * @return the DeleteProfileIdentityOptions builder
     */
    public Builder identityType(String identityType) {
      this.identityType = identityType;
      return this;
    }

    /**
     * Set the identifierId.
     *
     * @param identifierId the identifierId
     * @return the DeleteProfileIdentityOptions builder
     */
    public Builder identifierId(String identifierId) {
      this.identifierId = identifierId;
      return this;
    }
  }

  protected DeleteProfileIdentityOptions() { }

  protected DeleteProfileIdentityOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.identityType,
      "identityType cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.identifierId,
      "identifierId cannot be empty");
    profileId = builder.profileId;
    identityType = builder.identityType;
    identifierId = builder.identifierId;
  }

  /**
   * New builder.
   *
   * @return a DeleteProfileIdentityOptions builder
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
   * Gets the identityType.
   *
   * Type of the identity.
   *
   * @return the identityType
   */
  public String identityType() {
    return identityType;
  }

  /**
   * Gets the identifierId.
   *
   * Identifier of the identity that can assume the trusted profiles.
   *
   * @return the identifierId
   */
  public String identifierId() {
    return identifierId;
  }
}

