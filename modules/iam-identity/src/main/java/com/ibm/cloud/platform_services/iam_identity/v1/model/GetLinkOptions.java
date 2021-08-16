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
 * The getLink options.
 */
public class GetLinkOptions extends GenericModel {

  protected String profileId;
  protected String linkId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String linkId;

    private Builder(GetLinkOptions getLinkOptions) {
      this.profileId = getLinkOptions.profileId;
      this.linkId = getLinkOptions.linkId;
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
     * @param linkId the linkId
     */
    public Builder(String profileId, String linkId) {
      this.profileId = profileId;
      this.linkId = linkId;
    }

    /**
     * Builds a GetLinkOptions.
     *
     * @return the new GetLinkOptions instance
     */
    public GetLinkOptions build() {
      return new GetLinkOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the GetLinkOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the linkId.
     *
     * @param linkId the linkId
     * @return the GetLinkOptions builder
     */
    public Builder linkId(String linkId) {
      this.linkId = linkId;
      return this;
    }
  }

  protected GetLinkOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.linkId,
      "linkId cannot be empty");
    profileId = builder.profileId;
    linkId = builder.linkId;
  }

  /**
   * New builder.
   *
   * @return a GetLinkOptions builder
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
   * Gets the linkId.
   *
   * ID of the link.
   *
   * @return the linkId
   */
  public String linkId() {
    return linkId;
  }
}

