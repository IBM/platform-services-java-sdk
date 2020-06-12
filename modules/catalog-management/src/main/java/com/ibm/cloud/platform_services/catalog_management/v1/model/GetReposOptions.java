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
 * The getRepos options.
 */
public class GetReposOptions extends GenericModel {

  protected String type;
  protected String repourl;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String repourl;

    private Builder(GetReposOptions getReposOptions) {
      this.type = getReposOptions.type;
      this.repourl = getReposOptions.repourl;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param repourl the repourl
     */
    public Builder(String type, String repourl) {
      this.type = type;
      this.repourl = repourl;
    }

    /**
     * Builds a GetReposOptions.
     *
     * @return the new GetReposOptions instance
     */
    public GetReposOptions build() {
      return new GetReposOptions(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the GetReposOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the repourl.
     *
     * @param repourl the repourl
     * @return the GetReposOptions builder
     */
    public Builder repourl(String repourl) {
      this.repourl = repourl;
      return this;
    }
  }

  protected GetReposOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.type,
      "type cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.repourl,
      "repourl cannot be null");
    type = builder.type;
    repourl = builder.repourl;
  }

  /**
   * New builder.
   *
   * @return a GetReposOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * The type of repo (valid repo types: helm).
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the repourl.
   *
   * The URL for the repo's root (e.g https://kubernetes-charts-incubator.storage.googleapis.com).
   *
   * @return the repourl
   */
  public String repourl() {
    return repourl;
  }
}

