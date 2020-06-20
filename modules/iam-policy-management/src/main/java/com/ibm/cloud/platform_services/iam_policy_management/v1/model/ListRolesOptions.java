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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listRoles options.
 */
public class ListRolesOptions extends GenericModel {

  protected String acceptLanguage;
  protected String accountId;
  protected String serviceName;

  /**
   * Builder.
   */
  public static class Builder {
    private String acceptLanguage;
    private String accountId;
    private String serviceName;

    private Builder(ListRolesOptions listRolesOptions) {
      this.acceptLanguage = listRolesOptions.acceptLanguage;
      this.accountId = listRolesOptions.accountId;
      this.serviceName = listRolesOptions.serviceName;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListRolesOptions.
     *
     * @return the new ListRolesOptions instance
     */
    public ListRolesOptions build() {
      return new ListRolesOptions(this);
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListRolesOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListRolesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the ListRolesOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }
  }

  protected ListRolesOptions(Builder builder) {
    acceptLanguage = builder.acceptLanguage;
    accountId = builder.accountId;
    serviceName = builder.serviceName;
  }

  /**
   * New builder.
   *
   * @return a ListRolesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the acceptLanguage.
   *
   * Translation language code.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }

  /**
   * Gets the accountId.
   *
   * The account GUID in which the roles belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the serviceName.
   *
   * The name of service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }
}

