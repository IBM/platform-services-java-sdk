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

import java.util.Date;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Feature information.
 */
public class SyndicationAuthorization extends GenericModel {

  protected String token;
  @SerializedName("last_run")
  protected Date lastRun;

  /**
   * Builder.
   */
  public static class Builder {
    private String token;
    private Date lastRun;

    private Builder(SyndicationAuthorization syndicationAuthorization) {
      this.token = syndicationAuthorization.token;
      this.lastRun = syndicationAuthorization.lastRun;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a SyndicationAuthorization.
     *
     * @return the new SyndicationAuthorization instance
     */
    public SyndicationAuthorization build() {
      return new SyndicationAuthorization(this);
    }

    /**
     * Set the token.
     *
     * @param token the token
     * @return the SyndicationAuthorization builder
     */
    public Builder token(String token) {
      this.token = token;
      return this;
    }

    /**
     * Set the lastRun.
     *
     * @param lastRun the lastRun
     * @return the SyndicationAuthorization builder
     */
    public Builder lastRun(Date lastRun) {
      this.lastRun = lastRun;
      return this;
    }
  }

  protected SyndicationAuthorization(Builder builder) {
    token = builder.token;
    lastRun = builder.lastRun;
  }

  /**
   * New builder.
   *
   * @return a SyndicationAuthorization builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the token.
   *
   * Array of syndicated namespaces.
   *
   * @return the token
   */
  public String token() {
    return token;
  }

  /**
   * Gets the lastRun.
   *
   * Date and time last updated.
   *
   * @return the lastRun
   */
  public Date lastRun() {
    return lastRun;
  }
}

