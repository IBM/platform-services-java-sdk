/*
 * (C) Copyright IBM Corp. 2024.
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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteAccount options.
 */
public class DeleteAccountOptions extends GenericModel {

  protected String accountId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;

    /**
     * Instantiates a new Builder from an existing DeleteAccountOptions instance.
     *
     * @param deleteAccountOptions the instance to initialize the Builder with
     */
    private Builder(DeleteAccountOptions deleteAccountOptions) {
      this.accountId = deleteAccountOptions.accountId;
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
     * Builds a DeleteAccountOptions.
     *
     * @return the new DeleteAccountOptions instance
     */
    public DeleteAccountOptions build() {
      return new DeleteAccountOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the DeleteAccountOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }
  }

  protected DeleteAccountOptions() { }

  protected DeleteAccountOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    accountId = builder.accountId;
  }

  /**
   * New builder.
   *
   * @return a DeleteAccountOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the target account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }
}

