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
package com.ibm.cloud.platform_services.enterprise_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateAccount options.
 */
public class UpdateAccountOptions extends GenericModel {

  protected String accountId;
  protected String parent;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String parent;

    private Builder(UpdateAccountOptions updateAccountOptions) {
      this.accountId = updateAccountOptions.accountId;
      this.parent = updateAccountOptions.parent;
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
     * @param parent the parent
     */
    public Builder(String accountId, String parent) {
      this.accountId = accountId;
      this.parent = parent;
    }

    /**
     * Builds a UpdateAccountOptions.
     *
     * @return the new UpdateAccountOptions instance
     */
    public UpdateAccountOptions build() {
      return new UpdateAccountOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateAccountOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the parent.
     *
     * @param parent the parent
     * @return the UpdateAccountOptions builder
     */
    public Builder parent(String parent) {
      this.parent = parent;
      return this;
    }
  }

  protected UpdateAccountOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.parent,
      "parent cannot be null");
    accountId = builder.accountId;
    parent = builder.parent;
  }

  /**
   * New builder.
   *
   * @return a UpdateAccountOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the account to retrieve.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the parent.
   *
   * The CRN of the new parent within the enterprise.
   *
   * @return the parent
   */
  public String parent() {
    return parent;
  }
}

