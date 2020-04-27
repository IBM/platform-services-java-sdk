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
 * The getAccountGroupById options.
 */
public class GetAccountGroupByIdOptions extends GenericModel {

  protected String accountGroupId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountGroupId;

    private Builder(GetAccountGroupByIdOptions getAccountGroupByIdOptions) {
      this.accountGroupId = getAccountGroupByIdOptions.accountGroupId;
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
     * Builds a GetAccountGroupByIdOptions.
     *
     * @return the new GetAccountGroupByIdOptions instance
     */
    public GetAccountGroupByIdOptions build() {
      return new GetAccountGroupByIdOptions(this);
    }

    /**
     * Set the accountGroupId.
     *
     * @param accountGroupId the accountGroupId
     * @return the GetAccountGroupByIdOptions builder
     */
    public Builder accountGroupId(String accountGroupId) {
      this.accountGroupId = accountGroupId;
      return this;
    }
  }

  protected GetAccountGroupByIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountGroupId,
      "accountGroupId cannot be empty");
    accountGroupId = builder.accountGroupId;
  }

  /**
   * New builder.
   *
   * @return a GetAccountGroupByIdOptions builder
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
}

