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
 * The listEnterprises options.
 */
public class ListEnterprisesOptions extends GenericModel {

  protected String enterpriseAccountId;
  protected String accountGroupId;
  protected String accountId;
  protected Long limit;

  /**
   * Builder.
   */
  public static class Builder {
    private String enterpriseAccountId;
    private String accountGroupId;
    private String accountId;
    private Long limit;

    private Builder(ListEnterprisesOptions listEnterprisesOptions) {
      this.enterpriseAccountId = listEnterprisesOptions.enterpriseAccountId;
      this.accountGroupId = listEnterprisesOptions.accountGroupId;
      this.accountId = listEnterprisesOptions.accountId;
      this.limit = listEnterprisesOptions.limit;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListEnterprisesOptions.
     *
     * @return the new ListEnterprisesOptions instance
     */
    public ListEnterprisesOptions build() {
      return new ListEnterprisesOptions(this);
    }

    /**
     * Set the enterpriseAccountId.
     *
     * @param enterpriseAccountId the enterpriseAccountId
     * @return the ListEnterprisesOptions builder
     */
    public Builder enterpriseAccountId(String enterpriseAccountId) {
      this.enterpriseAccountId = enterpriseAccountId;
      return this;
    }

    /**
     * Set the accountGroupId.
     *
     * @param accountGroupId the accountGroupId
     * @return the ListEnterprisesOptions builder
     */
    public Builder accountGroupId(String accountGroupId) {
      this.accountGroupId = accountGroupId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListEnterprisesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListEnterprisesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }
  }

  protected ListEnterprisesOptions(Builder builder) {
    enterpriseAccountId = builder.enterpriseAccountId;
    accountGroupId = builder.accountGroupId;
    accountId = builder.accountId;
    limit = builder.limit;
  }

  /**
   * New builder.
   *
   * @return a ListEnterprisesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the enterpriseAccountId.
   *
   * Get enterprises for a given enterprise account ID.
   *
   * @return the enterpriseAccountId
   */
  public String enterpriseAccountId() {
    return enterpriseAccountId;
  }

  /**
   * Gets the accountGroupId.
   *
   * Get enterprises for a given account group ID.
   *
   * @return the accountGroupId
   */
  public String accountGroupId() {
    return accountGroupId;
  }

  /**
   * Gets the accountId.
   *
   * Get enterprises for a given account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the limit.
   *
   * Return results up to this limit. Valid values are between `0` and `100`.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }
}

