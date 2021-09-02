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
 * The listLink options.
 */
public class ListLinkOptions extends GenericModel {

  protected String profileId;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;

    private Builder(ListLinkOptions listLinkOptions) {
      this.profileId = listLinkOptions.profileId;
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
     * Builds a ListLinkOptions.
     *
     * @return the new ListLinkOptions instance
     */
    public ListLinkOptions build() {
      return new ListLinkOptions(this);
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the ListLinkOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }
  }

  protected ListLinkOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    profileId = builder.profileId;
  }

  /**
   * New builder.
   *
   * @return a ListLinkOptions builder
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
}

