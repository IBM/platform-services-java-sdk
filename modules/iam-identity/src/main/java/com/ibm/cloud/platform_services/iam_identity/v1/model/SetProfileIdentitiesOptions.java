/*
 * (C) Copyright IBM Corp. 2023.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The setProfileIdentities options.
 */
public class SetProfileIdentitiesOptions extends GenericModel {

  protected String profileId;
  protected String ifMatch;
  protected List<ProfileIdentityRequest> identities;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String ifMatch;
    private List<ProfileIdentityRequest> identities;

    /**
     * Instantiates a new Builder from an existing SetProfileIdentitiesOptions instance.
     *
     * @param setProfileIdentitiesOptions the instance to initialize the Builder with
     */
    private Builder(SetProfileIdentitiesOptions setProfileIdentitiesOptions) {
      this.profileId = setProfileIdentitiesOptions.profileId;
      this.ifMatch = setProfileIdentitiesOptions.ifMatch;
      this.identities = setProfileIdentitiesOptions.identities;
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
     * Builds a SetProfileIdentitiesOptions.
     *
     * @return the new SetProfileIdentitiesOptions instance
     */
    public SetProfileIdentitiesOptions build() {
      return new SetProfileIdentitiesOptions(this);
    }

    /**
     * Adds an identities to identities.
     *
     * @param identities the new identities
     * @return the SetProfileIdentitiesOptions builder
     */
    public Builder addIdentities(ProfileIdentityRequest identities) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(identities,
        "identities cannot be null");
      if (this.identities == null) {
        this.identities = new ArrayList<ProfileIdentityRequest>();
      }
      this.identities.add(identities);
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the SetProfileIdentitiesOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the SetProfileIdentitiesOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the identities.
     * Existing identities will be replaced.
     *
     * @param identities the identities
     * @return the SetProfileIdentitiesOptions builder
     */
    public Builder identities(List<ProfileIdentityRequest> identities) {
      this.identities = identities;
      return this;
    }
  }

  protected SetProfileIdentitiesOptions() { }

  protected SetProfileIdentitiesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    profileId = builder.profileId;
    ifMatch = builder.ifMatch;
    identities = builder.identities;
  }

  /**
   * New builder.
   *
   * @return a SetProfileIdentitiesOptions builder
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
   * Gets the ifMatch.
   *
   * Entity tag of the Identities to be updated. Specify the tag that you retrieved when reading the Profile Identities.
   * This value helps identify parallel usage of this API. Pass * to indicate updating any available version, which may
   * result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the identities.
   *
   * List of identities that can assume the trusted profile.
   *
   * @return the identities
   */
  public List<ProfileIdentityRequest> identities() {
    return identities;
  }
}

