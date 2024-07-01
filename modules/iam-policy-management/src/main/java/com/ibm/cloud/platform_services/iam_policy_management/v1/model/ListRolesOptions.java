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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listRoles options.
 */
public class ListRolesOptions extends GenericModel {

  protected String acceptLanguage;
  protected String accountId;
  protected String serviceName;
  protected String sourceServiceName;
  protected String policyType;
  protected String serviceGroupId;

  /**
   * Builder.
   */
  public static class Builder {
    private String acceptLanguage;
    private String accountId;
    private String serviceName;
    private String sourceServiceName;
    private String policyType;
    private String serviceGroupId;

    /**
     * Instantiates a new Builder from an existing ListRolesOptions instance.
     *
     * @param listRolesOptions the instance to initialize the Builder with
     */
    private Builder(ListRolesOptions listRolesOptions) {
      this.acceptLanguage = listRolesOptions.acceptLanguage;
      this.accountId = listRolesOptions.accountId;
      this.serviceName = listRolesOptions.serviceName;
      this.sourceServiceName = listRolesOptions.sourceServiceName;
      this.policyType = listRolesOptions.policyType;
      this.serviceGroupId = listRolesOptions.serviceGroupId;
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

    /**
     * Set the sourceServiceName.
     *
     * @param sourceServiceName the sourceServiceName
     * @return the ListRolesOptions builder
     */
    public Builder sourceServiceName(String sourceServiceName) {
      this.sourceServiceName = sourceServiceName;
      return this;
    }

    /**
     * Set the policyType.
     *
     * @param policyType the policyType
     * @return the ListRolesOptions builder
     */
    public Builder policyType(String policyType) {
      this.policyType = policyType;
      return this;
    }

    /**
     * Set the serviceGroupId.
     *
     * @param serviceGroupId the serviceGroupId
     * @return the ListRolesOptions builder
     */
    public Builder serviceGroupId(String serviceGroupId) {
      this.serviceGroupId = serviceGroupId;
      return this;
    }
  }

  protected ListRolesOptions() { }

  protected ListRolesOptions(Builder builder) {
    acceptLanguage = builder.acceptLanguage;
    accountId = builder.accountId;
    serviceName = builder.serviceName;
    sourceServiceName = builder.sourceServiceName;
    policyType = builder.policyType;
    serviceGroupId = builder.serviceGroupId;
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
   * Language code for translations
   * * `default` - English
   * * `de` -  German (Standard)
   * * `en` - English
   * * `es` - Spanish (Spain)
   * * `fr` - French (Standard)
   * * `it` - Italian (Standard)
   * * `ja` - Japanese
   * * `ko` - Korean
   * * `pt-br` - Portuguese (Brazil)
   * * `zh-cn` - Chinese (Simplified, PRC)
   * * `zh-tw` - (Chinese, Taiwan).
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }

  /**
   * Gets the accountId.
   *
   * Optional account GUID in which the roles belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the serviceName.
   *
   * Optional name of IAM enabled service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the sourceServiceName.
   *
   * Optional name of source IAM enabled service.
   *
   * @return the sourceServiceName
   */
  public String sourceServiceName() {
    return sourceServiceName;
  }

  /**
   * Gets the policyType.
   *
   * Optional Policy Type.
   *
   * @return the policyType
   */
  public String policyType() {
    return policyType;
  }

  /**
   * Gets the serviceGroupId.
   *
   * Optional id of service group.
   *
   * @return the serviceGroupId
   */
  public String serviceGroupId() {
    return serviceGroupId;
  }
}

