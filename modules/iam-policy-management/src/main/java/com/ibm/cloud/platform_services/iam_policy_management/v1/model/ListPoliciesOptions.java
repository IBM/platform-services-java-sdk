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
 * The listPolicies options.
 */
public class ListPoliciesOptions extends GenericModel {

  protected String accountId;
  protected String acceptLanguage;
  protected String iamId;
  protected String accessGroupId;
  protected String type;
  protected String serviceType;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String acceptLanguage;
    private String iamId;
    private String accessGroupId;
    private String type;
    private String serviceType;

    private Builder(ListPoliciesOptions listPoliciesOptions) {
      this.accountId = listPoliciesOptions.accountId;
      this.acceptLanguage = listPoliciesOptions.acceptLanguage;
      this.iamId = listPoliciesOptions.iamId;
      this.accessGroupId = listPoliciesOptions.accessGroupId;
      this.type = listPoliciesOptions.type;
      this.serviceType = listPoliciesOptions.serviceType;
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
     * Builds a ListPoliciesOptions.
     *
     * @return the new ListPoliciesOptions instance
     */
    public ListPoliciesOptions build() {
      return new ListPoliciesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListPoliciesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListPoliciesOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the ListPoliciesOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the ListPoliciesOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListPoliciesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the serviceType.
     *
     * @param serviceType the serviceType
     * @return the ListPoliciesOptions builder
     */
    public Builder serviceType(String serviceType) {
      this.serviceType = serviceType;
      return this;
    }
  }

  protected ListPoliciesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    iamId = builder.iamId;
    accessGroupId = builder.accessGroupId;
    type = builder.type;
    serviceType = builder.serviceType;
  }

  /**
   * New builder.
   *
   * @return a ListPoliciesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account GUID in which the policies belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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
   * Gets the iamId.
   *
   * The IAM ID used to identify the subject.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the accessGroupId.
   *
   * The access group id.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the type.
   *
   * The type of policy (access or authorization).
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the serviceType.
   *
   * The type of service.
   *
   * @return the serviceType
   */
  public String serviceType() {
    return serviceType;
  }
}

