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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listUsers options.
 */
public class ListUsersOptions extends GenericModel {

  protected String accountId;
  protected String state;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String state;

    private Builder(ListUsersOptions listUsersOptions) {
      this.accountId = listUsersOptions.accountId;
      this.state = listUsersOptions.state;
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
     * Builds a ListUsersOptions.
     *
     * @return the new ListUsersOptions instance
     */
    public ListUsersOptions build() {
      return new ListUsersOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListUsersOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListUsersOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected ListUsersOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a ListUsersOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the state.
   *
   * The state of the user.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

