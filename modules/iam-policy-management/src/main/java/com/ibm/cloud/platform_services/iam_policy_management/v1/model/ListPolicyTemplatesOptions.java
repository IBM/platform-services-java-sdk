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
 * The listPolicyTemplates options.
 */
public class ListPolicyTemplatesOptions extends GenericModel {

  /**
   * The policy template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  /**
   * Service type, Optional.
   */
  public interface PolicyServiceType {
    /** service. */
    String SERVICE = "service";
    /** platform_service. */
    String PLATFORM_SERVICE = "platform_service";
  }

  /**
   * Policy type, Optional.
   */
  public interface PolicyType {
    /** access. */
    String ACCESS = "access";
    /** authorization. */
    String AUTHORIZATION = "authorization";
  }

  protected String accountId;
  protected String acceptLanguage;
  protected String state;
  protected String name;
  protected String policyServiceType;
  protected String policyServiceName;
  protected String policyServiceGroupId;
  protected String policyType;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String acceptLanguage;
    private String state;
    private String name;
    private String policyServiceType;
    private String policyServiceName;
    private String policyServiceGroupId;
    private String policyType;

    /**
     * Instantiates a new Builder from an existing ListPolicyTemplatesOptions instance.
     *
     * @param listPolicyTemplatesOptions the instance to initialize the Builder with
     */
    private Builder(ListPolicyTemplatesOptions listPolicyTemplatesOptions) {
      this.accountId = listPolicyTemplatesOptions.accountId;
      this.acceptLanguage = listPolicyTemplatesOptions.acceptLanguage;
      this.state = listPolicyTemplatesOptions.state;
      this.name = listPolicyTemplatesOptions.name;
      this.policyServiceType = listPolicyTemplatesOptions.policyServiceType;
      this.policyServiceName = listPolicyTemplatesOptions.policyServiceName;
      this.policyServiceGroupId = listPolicyTemplatesOptions.policyServiceGroupId;
      this.policyType = listPolicyTemplatesOptions.policyType;
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
     * Builds a ListPolicyTemplatesOptions.
     *
     * @return the new ListPolicyTemplatesOptions instance
     */
    public ListPolicyTemplatesOptions build() {
      return new ListPolicyTemplatesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the policyServiceType.
     *
     * @param policyServiceType the policyServiceType
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder policyServiceType(String policyServiceType) {
      this.policyServiceType = policyServiceType;
      return this;
    }

    /**
     * Set the policyServiceName.
     *
     * @param policyServiceName the policyServiceName
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder policyServiceName(String policyServiceName) {
      this.policyServiceName = policyServiceName;
      return this;
    }

    /**
     * Set the policyServiceGroupId.
     *
     * @param policyServiceGroupId the policyServiceGroupId
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder policyServiceGroupId(String policyServiceGroupId) {
      this.policyServiceGroupId = policyServiceGroupId;
      return this;
    }

    /**
     * Set the policyType.
     *
     * @param policyType the policyType
     * @return the ListPolicyTemplatesOptions builder
     */
    public Builder policyType(String policyType) {
      this.policyType = policyType;
      return this;
    }
  }

  protected ListPolicyTemplatesOptions() { }

  protected ListPolicyTemplatesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    state = builder.state;
    name = builder.name;
    policyServiceType = builder.policyServiceType;
    policyServiceName = builder.policyServiceName;
    policyServiceGroupId = builder.policyServiceGroupId;
    policyType = builder.policyType;
  }

  /**
   * New builder.
   *
   * @return a ListPolicyTemplatesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account GUID that the policy templates belong to.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
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
   * Gets the state.
   *
   * The policy template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the name.
   *
   * The policy template name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the policyServiceType.
   *
   * Service type, Optional.
   *
   * @return the policyServiceType
   */
  public String policyServiceType() {
    return policyServiceType;
  }

  /**
   * Gets the policyServiceName.
   *
   * Service name, Optional.
   *
   * @return the policyServiceName
   */
  public String policyServiceName() {
    return policyServiceName;
  }

  /**
   * Gets the policyServiceGroupId.
   *
   * Service group id, Optional.
   *
   * @return the policyServiceGroupId
   */
  public String policyServiceGroupId() {
    return policyServiceGroupId;
  }

  /**
   * Gets the policyType.
   *
   * Policy type, Optional.
   *
   * @return the policyType
   */
  public String policyType() {
    return policyType;
  }
}

