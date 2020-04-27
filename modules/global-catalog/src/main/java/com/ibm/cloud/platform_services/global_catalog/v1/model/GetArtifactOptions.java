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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getArtifact options.
 */
public class GetArtifactOptions extends GenericModel {

  protected String objectId;
  protected String artifactId;
  protected String account;

  /**
   * Builder.
   */
  public static class Builder {
    private String objectId;
    private String artifactId;
    private String account;

    private Builder(GetArtifactOptions getArtifactOptions) {
      this.objectId = getArtifactOptions.objectId;
      this.artifactId = getArtifactOptions.artifactId;
      this.account = getArtifactOptions.account;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param objectId the objectId
     * @param artifactId the artifactId
     */
    public Builder(String objectId, String artifactId) {
      this.objectId = objectId;
      this.artifactId = artifactId;
    }

    /**
     * Builds a GetArtifactOptions.
     *
     * @return the new GetArtifactOptions instance
     */
    public GetArtifactOptions build() {
      return new GetArtifactOptions(this);
    }

    /**
     * Set the objectId.
     *
     * @param objectId the objectId
     * @return the GetArtifactOptions builder
     */
    public Builder objectId(String objectId) {
      this.objectId = objectId;
      return this;
    }

    /**
     * Set the artifactId.
     *
     * @param artifactId the artifactId
     * @return the GetArtifactOptions builder
     */
    public Builder artifactId(String artifactId) {
      this.artifactId = artifactId;
      return this;
    }

    /**
     * Set the account.
     *
     * @param account the account
     * @return the GetArtifactOptions builder
     */
    public Builder account(String account) {
      this.account = account;
      return this;
    }
  }

  protected GetArtifactOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.objectId,
      "objectId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.artifactId,
      "artifactId cannot be empty");
    objectId = builder.objectId;
    artifactId = builder.artifactId;
    account = builder.account;
  }

  /**
   * New builder.
   *
   * @return a GetArtifactOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the objectId.
   *
   * The object's unique ID.
   *
   * @return the objectId
   */
  public String objectId() {
    return objectId;
  }

  /**
   * Gets the artifactId.
   *
   * The artifact's ID.
   *
   * @return the artifactId
   */
  public String artifactId() {
    return artifactId;
  }

  /**
   * Gets the account.
   *
   * This changes the scope of the request regardless of the authorization header. Example scopes are `account` and
   * `global`. `account=global` is reqired if operating with a service ID that has a global admin policy, for example
   * `GET /?account=global`.
   *
   * @return the account
   */
  public String account() {
    return account;
  }
}

