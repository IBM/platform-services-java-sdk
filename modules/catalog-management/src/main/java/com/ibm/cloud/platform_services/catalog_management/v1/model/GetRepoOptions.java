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
 * The getRepo options.
 */
public class GetRepoOptions extends GenericModel {

  protected String type;
  protected String charturl;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String charturl;

    private Builder(GetRepoOptions getRepoOptions) {
      this.type = getRepoOptions.type;
      this.charturl = getRepoOptions.charturl;
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
     * @param charturl the charturl
     */
    public Builder(String type, String charturl) {
      this.type = type;
      this.charturl = charturl;
    }

    /**
     * Builds a GetRepoOptions.
     *
     * @return the new GetRepoOptions instance
     */
    public GetRepoOptions build() {
      return new GetRepoOptions(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the GetRepoOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the charturl.
     *
     * @param charturl the charturl
     * @return the GetRepoOptions builder
     */
    public Builder charturl(String charturl) {
      this.charturl = charturl;
      return this;
    }
  }

  protected GetRepoOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.type,
      "type cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.charturl,
      "charturl cannot be null");
    type = builder.type;
    charturl = builder.charturl;
  }

  /**
   * New builder.
   *
   * @return a GetRepoOptions builder
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
   * Gets the charturl.
   *
   * The URL for the repo's chart zip file (e.g
   * https://registry.bluemix.net/helm/ibm-charts/charts/ibm-redis-ha-dev-1.0.0.tgz).
   *
   * @return the charturl
   */
  public String charturl() {
    return charturl;
  }
}

