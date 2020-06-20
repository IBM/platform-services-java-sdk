/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getSchematicsWorkspaces options.
 */
public class GetSchematicsWorkspacesOptions extends GenericModel {

  protected String versionLocId;
  protected String xAuthRefreshToken;

  /**
   * Builder.
   */
  public static class Builder {
    private String versionLocId;
    private String xAuthRefreshToken;

    private Builder(GetSchematicsWorkspacesOptions getSchematicsWorkspacesOptions) {
      this.versionLocId = getSchematicsWorkspacesOptions.versionLocId;
      this.xAuthRefreshToken = getSchematicsWorkspacesOptions.xAuthRefreshToken;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param versionLocId the versionLocId
     * @param xAuthRefreshToken the xAuthRefreshToken
     */
    public Builder(String versionLocId, String xAuthRefreshToken) {
      this.versionLocId = versionLocId;
      this.xAuthRefreshToken = xAuthRefreshToken;
    }

    /**
     * Builds a GetSchematicsWorkspacesOptions.
     *
     * @return the new GetSchematicsWorkspacesOptions instance
     */
    public GetSchematicsWorkspacesOptions build() {
      return new GetSchematicsWorkspacesOptions(this);
    }

    /**
     * Set the versionLocId.
     *
     * @param versionLocId the versionLocId
     * @return the GetSchematicsWorkspacesOptions builder
     */
    public Builder versionLocId(String versionLocId) {
      this.versionLocId = versionLocId;
      return this;
    }

    /**
     * Set the xAuthRefreshToken.
     *
     * @param xAuthRefreshToken the xAuthRefreshToken
     * @return the GetSchematicsWorkspacesOptions builder
     */
    public Builder xAuthRefreshToken(String xAuthRefreshToken) {
      this.xAuthRefreshToken = xAuthRefreshToken;
      return this;
    }
  }

  protected GetSchematicsWorkspacesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionLocId,
      "versionLocId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.xAuthRefreshToken,
      "xAuthRefreshToken cannot be null");
    versionLocId = builder.versionLocId;
    xAuthRefreshToken = builder.xAuthRefreshToken;
  }

  /**
   * New builder.
   *
   * @return a GetSchematicsWorkspacesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the versionLocId.
   *
   * A dotted value of `catalogID`.`versionID`.
   *
   * @return the versionLocId
   */
  public String versionLocId() {
    return versionLocId;
  }

  /**
   * Gets the xAuthRefreshToken.
   *
   * IAM Refresh token.
   *
   * @return the xAuthRefreshToken
   */
  public String xAuthRefreshToken() {
    return xAuthRefreshToken;
  }
}

