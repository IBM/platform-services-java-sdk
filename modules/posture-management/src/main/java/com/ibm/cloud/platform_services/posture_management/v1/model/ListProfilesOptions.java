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
package com.ibm.cloud.platform_services.posture_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listProfiles options.
 */
public class ListProfilesOptions extends GenericModel {

  protected String accountId;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String name;

    private Builder(ListProfilesOptions listProfilesOptions) {
      this.accountId = listProfilesOptions.accountId;
      this.name = listProfilesOptions.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a ListProfilesOptions.
     *
     * @return the new ListProfilesOptions instance
     */
    public ListProfilesOptions build() {
      return new ListProfilesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListProfilesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListProfilesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected ListProfilesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a ListProfilesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Your account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * The name of the profile.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

