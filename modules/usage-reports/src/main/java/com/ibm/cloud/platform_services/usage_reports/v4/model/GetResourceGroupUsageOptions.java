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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getResourceGroupUsage options.
 */
public class GetResourceGroupUsageOptions extends GenericModel {

  protected String accountId;
  protected String resourceGroupId;
  protected String billingmonth;
  protected Boolean names;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String resourceGroupId;
    private String billingmonth;
    private Boolean names;
    private String acceptLanguage;

    private Builder(GetResourceGroupUsageOptions getResourceGroupUsageOptions) {
      this.accountId = getResourceGroupUsageOptions.accountId;
      this.resourceGroupId = getResourceGroupUsageOptions.resourceGroupId;
      this.billingmonth = getResourceGroupUsageOptions.billingmonth;
      this.names = getResourceGroupUsageOptions.names;
      this.acceptLanguage = getResourceGroupUsageOptions.acceptLanguage;
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
     * @param resourceGroupId the resourceGroupId
     * @param billingmonth the billingmonth
     */
    public Builder(String accountId, String resourceGroupId, String billingmonth) {
      this.accountId = accountId;
      this.resourceGroupId = resourceGroupId;
      this.billingmonth = billingmonth;
    }

    /**
     * Builds a GetResourceGroupUsageOptions.
     *
     * @return the new GetResourceGroupUsageOptions instance
     */
    public GetResourceGroupUsageOptions build() {
      return new GetResourceGroupUsageOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the GetResourceGroupUsageOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the GetResourceGroupUsageOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the billingmonth.
     *
     * @param billingmonth the billingmonth
     * @return the GetResourceGroupUsageOptions builder
     */
    public Builder billingmonth(String billingmonth) {
      this.billingmonth = billingmonth;
      return this;
    }

    /**
     * Set the names.
     *
     * @param names the names
     * @return the GetResourceGroupUsageOptions builder
     */
    public Builder names(Boolean names) {
      this.names = names;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the GetResourceGroupUsageOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected GetResourceGroupUsageOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.resourceGroupId,
      "resourceGroupId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.billingmonth,
      "billingmonth cannot be empty");
    accountId = builder.accountId;
    resourceGroupId = builder.resourceGroupId;
    billingmonth = builder.billingmonth;
    names = builder.names;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a GetResourceGroupUsageOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID for which the usage report is requested.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the resourceGroupId.
   *
   * Resource group for which the usage report is requested.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the billingmonth.
   *
   * The billing month for which the usage report is requested.  Format is yyyy-mm.
   *
   * @return the billingmonth
   */
  public String billingmonth() {
    return billingmonth;
  }

  /**
   * Gets the names.
   *
   * Include the name of every resource, plan, resource instance, organization, and resource group.
   *
   * @return the names
   */
  public Boolean names() {
    return names;
  }

  /**
   * Gets the acceptLanguage.
   *
   * Prioritize the names returned in the order of the specified languages. Language will default to English.
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

