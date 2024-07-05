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
 * The listV2Policies options.
 */
public class ListV2PoliciesOptions extends GenericModel {

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
  protected String sort;
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
    private String sort;
    private String format;
    private String state;

    /**
     * Instantiates a new Builder from an existing ListV2PoliciesOptions instance.
     *
     * @param listV2PoliciesOptions the instance to initialize the Builder with
     */
    private Builder(ListV2PoliciesOptions listV2PoliciesOptions) {
      this.accountId = listV2PoliciesOptions.accountId;
      this.acceptLanguage = listV2PoliciesOptions.acceptLanguage;
      this.iamId = listV2PoliciesOptions.iamId;
      this.accessGroupId = listV2PoliciesOptions.accessGroupId;
      this.type = listV2PoliciesOptions.type;
      this.serviceType = listV2PoliciesOptions.serviceType;
      this.serviceName = listV2PoliciesOptions.serviceName;
      this.serviceGroupId = listV2PoliciesOptions.serviceGroupId;
      this.sort = listV2PoliciesOptions.sort;
      this.format = listV2PoliciesOptions.format;
      this.state = listV2PoliciesOptions.state;
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
     * Builds a ListV2PoliciesOptions.
     *
     * @return the new ListV2PoliciesOptions instance
     */
    public ListV2PoliciesOptions build() {
      return new ListV2PoliciesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListV2PoliciesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListV2PoliciesOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the ListV2PoliciesOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the ListV2PoliciesOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListV2PoliciesOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the serviceType.
     *
     * @param serviceType the serviceType
     * @return the ListV2PoliciesOptions builder
     */
    public Builder serviceType(String serviceType) {
      this.serviceType = serviceType;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the ListV2PoliciesOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the serviceGroupId.
     *
     * @param serviceGroupId the serviceGroupId
     * @return the ListV2PoliciesOptions builder
     */
    public Builder serviceGroupId(String serviceGroupId) {
      this.serviceGroupId = serviceGroupId;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListV2PoliciesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the ListV2PoliciesOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListV2PoliciesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected ListV2PoliciesOptions() { }

  protected ListV2PoliciesOptions(Builder builder) {
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
    sort = builder.sort;
    format = builder.format;
    state = builder.state;
  }

  /**
   * New builder.
   *
   * @return a ListV2PoliciesOptions builder
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
   * Gets the sort.
   *
   * Optional top level policy field to sort results. Ascending sort is default. Descending sort available by prepending
   * '-' to field, for example, '-last_modified_at'. Note that last permit information is only included when
   * 'format=include_last_permit', for example, "format=include_last_permit&amp;sort=last_permit_at" Example fields that
   * can be sorted on:
   *   - 'id'
   *   - 'type'
   *   - 'href'
   *   - 'created_at'
   *   - 'created_by_id'
   *   - 'last_modified_at'
   *   - 'last_modified_by_id'
   *   - 'state'
   *   - 'last_permit_at'
   *   - 'last_permit_frequency'.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
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

