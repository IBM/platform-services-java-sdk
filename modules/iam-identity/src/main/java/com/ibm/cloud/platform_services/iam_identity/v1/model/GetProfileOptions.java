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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getProfile options.
 */
public class GetProfileOptions extends GenericModel {

  protected String profileId;
  protected Boolean includeActivity;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private Boolean includeActivity;

    /**
     * Instantiates a new Builder from an existing GetProfileOptions instance.
     *
     * @param getProfileOptions the instance to initialize the Builder with
     */
    private Builder(GetProfileOptions getProfileOptions) {
      this.profileId = getProfileOptions.profileId;
      this.includeActivity = getProfileOptions.includeActivity;
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
     */
    public Builder(String profileId) {
      this.profileId = profileId;
    }

    /**
     * Builds a GetProfileOptions.
     *
     * @return the new GetProfileOptions instance
     */
    public GetProfileOptions build() {
      return new GetProfileOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the GetProfileOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the includeActivity.
     *
     * @param includeActivity the includeActivity
     * @return the GetProfileOptions builder
     */
    public Builder includeActivity(Boolean includeActivity) {
      this.includeActivity = includeActivity;
      return this;
    }
  }

  protected GetProfileOptions() { }

  protected GetProfileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    profileId = builder.profileId;
    includeActivity = builder.includeActivity;
  }

  /**
   * New builder.
   *
   * @return a GetProfileOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * ID of the trusted profile to get.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the includeActivity.
   *
   * Defines if the entity's activity is included in the response. Retrieving activity data is an expensive operation,
   * so only request this when needed.
   *
   * @return the includeActivity
   */
  public Boolean includeActivity() {
    return includeActivity;
  }
}

