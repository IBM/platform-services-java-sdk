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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Repository info for offerings.
 */
public class RepoInfo extends GenericModel {

  protected String token;
  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String token;
    private String type;

    private Builder(RepoInfo repoInfo) {
      this.token = repoInfo.token;
      this.type = repoInfo.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a RepoInfo.
     *
     * @return the new RepoInfo instance
     */
    public RepoInfo build() {
      return new RepoInfo(this);
    }

    /**
     * Set the token.
     *
     * @param token the token
     * @return the RepoInfo builder
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the RepoInfo builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected RepoInfo(Builder builder) {
    token = builder.token;
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a RepoInfo builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the token.
   *
   * Token for private repos.
   *
   * @return the token
   */
  public String token() {
    return token;
  }

  /**
   * Gets the type.
   *
   * Public or enterprise GitHub.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

