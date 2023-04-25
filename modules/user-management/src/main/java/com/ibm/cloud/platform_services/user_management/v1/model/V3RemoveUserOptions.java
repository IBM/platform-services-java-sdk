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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The v3RemoveUser options.
 */
public class V3RemoveUserOptions extends GenericModel {

  protected String accountId;
  protected String iamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;

    /**
     * Instantiates a new Builder from an existing V3RemoveUserOptions instance.
     *
     * @param v3RemoveUserOptions the instance to initialize the Builder with
     */
    private Builder(V3RemoveUserOptions v3RemoveUserOptions) {
      this.accountId = v3RemoveUserOptions.accountId;
      this.iamId = v3RemoveUserOptions.iamId;
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
     * @param iamId the iamId
     */
    public Builder(String accountId, String iamId) {
      this.accountId = accountId;
      this.iamId = iamId;
    }

    /**
     * Builds a V3RemoveUserOptions.
     *
     * @return the new V3RemoveUserOptions instance
     */
    public V3RemoveUserOptions build() {
      return new V3RemoveUserOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the V3RemoveUserOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the V3RemoveUserOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }
  }

  protected V3RemoveUserOptions() { }

  protected V3RemoveUserOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    accountId = builder.accountId;
    iamId = builder.iamId;
  }

  /**
   * New builder.
   *
   * @return a V3RemoveUserOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID of the specified user.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * The user's IAM ID.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }
}

