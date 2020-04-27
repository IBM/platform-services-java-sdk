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
 * The updateAccountGroup options.
 */
public class UpdateAccountGroupOptions extends GenericModel {

  protected String accountGroupId;
  protected String name;
  protected String primaryContactIamId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountGroupId;
    private String name;
    private String primaryContactIamId;

    private Builder(UpdateAccountGroupOptions updateAccountGroupOptions) {
      this.accountGroupId = updateAccountGroupOptions.accountGroupId;
      this.name = updateAccountGroupOptions.name;
      this.primaryContactIamId = updateAccountGroupOptions.primaryContactIamId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountGroupId the accountGroupId
     */
    public Builder(String accountGroupId) {
      this.accountGroupId = accountGroupId;
    }

    /**
     * Builds a UpdateAccountGroupOptions.
     *
     * @return the new UpdateAccountGroupOptions instance
     */
    public UpdateAccountGroupOptions build() {
      return new UpdateAccountGroupOptions(this);
    }

    /**
     * Set the accountGroupId.
     *
     * @param accountGroupId the accountGroupId
     * @return the UpdateAccountGroupOptions builder
     */
    public Builder accountGroupId(String accountGroupId) {
      this.accountGroupId = accountGroupId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateAccountGroupOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the primaryContactIamId.
     *
     * @param primaryContactIamId the primaryContactIamId
     * @return the UpdateAccountGroupOptions builder
     */
    public Builder primaryContactIamId(String primaryContactIamId) {
      this.primaryContactIamId = primaryContactIamId;
      return this;
    }
  }

  protected UpdateAccountGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountGroupId,
      "accountGroupId cannot be empty");
    accountGroupId = builder.accountGroupId;
    name = builder.name;
    primaryContactIamId = builder.primaryContactIamId;
  }

  /**
   * New builder.
   *
   * @return a UpdateAccountGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountGroupId.
   *
   * The ID of the account group to retrieve.
   *
   * @return the accountGroupId
   */
  public String accountGroupId() {
    return accountGroupId;
  }

  /**
   * Gets the name.
   *
   * The new name of the account group. This field must have 3 - 60 characters.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the primaryContactIamId.
   *
   * The IAM ID of the user to be the new primary contact for the account group.
   *
   * @return the primaryContactIamId
   */
  public String primaryContactIamId() {
    return primaryContactIamId;
  }
}

