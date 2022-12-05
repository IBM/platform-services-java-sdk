/*
 * (C) Copyright IBM Corp. 2022.
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
 * The v2ListPolicies options.
 */
public class V2ListPoliciesOptions extends GenericModel {

  /**
   * Optional type of policy.
   */
  public interface Type {
    /** access. */
    String ACCESS = "access";
    /** authorization. */
    String AUTHORIZATION = "authorization";
  }

  /**
   * Optional type of service.
   */
  public interface ServiceType {
    /** service. */
    String SERVICE = "service";
    /** platform_service. */
    String PLATFORM_SERVICE = "platform_service";
  }

  /**
   * Include additional data per policy returned
   * * `include_last_permit` - returns details of when the policy last granted a permit decision and the number of times
   * it has done so
   * * `display` - returns the list of all actions included in each of the policy roles and translations for all
   * relevant fields.
   */
  public interface Format {
    /** include_last_permit. */
    String INCLUDE_LAST_PERMIT = "include_last_permit";
    /** display. */
    String DISPLAY = "display";
  }

  /**
   * The state of the policy.
   * * `active` - returns active policies
   * * `deleted` - returns non-active policies.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String accountId;
  protected String acceptLanguage;
  protected String iamId;
  protected String accessGroupId;
  protected String type;
  protected String serviceType;
  protected String serviceName;
  protected String serviceGroupId;
  protected String format;
  protected String state;

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
    private String serviceName;
    private String serviceGroupId;
    private String format;
    private String state;

    /**
     * Instantiates a new Builder from an existing V2ListPoliciesOptions instance.
     *
     * @param v2ListPoliciesOptions the instance to initialize the Builder with
     */
    private Builder(V2ListPoliciesOptions v2ListPoliciesOptions) {
      this.accountId = v2ListPoliciesOptions.accountId;
      this.acceptLanguage = v2ListPoliciesOptions.acceptLanguage;
      this.iamId = v2ListPoliciesOptions.iamId;
      this.accessGroupId = v2ListPoliciesOptions.accessGroupId;
      this.type = v2ListPoliciesOptions.type;
      this.serviceType = v2ListPoliciesOptions.serviceType;
      this.serviceName = v2ListPoliciesOptions.serviceName;
      this.serviceGroupId = v2ListPoliciesOptions.serviceGroupId;
      this.format = v2ListPoliciesOptions.format;
      this.state = v2ListPoliciesOptions.state;
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
     * Builds a V2ListPoliciesOptions.
     *
     * @return the new V2ListPoliciesOptions instance
     */
    public V2ListPoliciesOptions build() {
      return new V2ListPoliciesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the V2ListPoliciesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the V2ListPoliciesOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the V2ListPoliciesOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the V2ListPoliciesOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the V2ListPoliciesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the serviceType.
     *
     * @param serviceType the serviceType
     * @return the V2ListPoliciesOptions builder
     */
    public Builder serviceType(String serviceType) {
      this.serviceType = serviceType;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the V2ListPoliciesOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the serviceGroupId.
     *
     * @param serviceGroupId the serviceGroupId
     * @return the V2ListPoliciesOptions builder
     */
    public Builder serviceGroupId(String serviceGroupId) {
      this.serviceGroupId = serviceGroupId;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the V2ListPoliciesOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the V2ListPoliciesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected V2ListPoliciesOptions() { }

  protected V2ListPoliciesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    iamId = builder.iamId;
    accessGroupId = builder.accessGroupId;
    type = builder.type;
    serviceType = builder.serviceType;
    serviceName = builder.serviceName;
    serviceGroupId = builder.serviceGroupId;
    format = builder.format;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a V2ListPoliciesOptions builder
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
   * Gets the iamId.
   *
   * Optional IAM ID used to identify the subject.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the accessGroupId.
   *
   * Optional access group id.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the type.
   *
   * Optional type of policy.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the serviceType.
   *
   * Optional type of service.
   *
   * @return the serviceType
   */
  public String serviceType() {
    return serviceType;
  }

  /**
   * Gets the serviceName.
   *
   * Optional name of service.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the serviceGroupId.
   *
   * Optional ID of service group.
   *
   * @return the serviceGroupId
   */
  public String serviceGroupId() {
    return serviceGroupId;
  }

  /**
   * Gets the format.
   *
   * Include additional data per policy returned
   * * `include_last_permit` - returns details of when the policy last granted a permit decision and the number of times
   * it has done so
   * * `display` - returns the list of all actions included in each of the policy roles and translations for all
   * relevant fields.
   *
   * @return the format
   */
  public String format() {
    return format;
  }

  /**
   * Gets the state.
   *
   * The state of the policy.
   * * `active` - returns active policies
   * * `deleted` - returns non-active policies.
   *
   * @return the state
   */
  public String state() {
    return state;
  }
}

