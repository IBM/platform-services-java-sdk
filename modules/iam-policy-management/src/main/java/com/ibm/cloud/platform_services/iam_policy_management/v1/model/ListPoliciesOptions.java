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
 * The listPolicies options.
 */
public class ListPoliciesOptions extends GenericModel {

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
   * Optional top level policy field to sort results. Ascending sort is default. Descending sort available by prepending
   * '-' to field. Example '-last_modified_at'.
   */
  public interface Sort {
    /** id. */
    String ID = "id";
    /** type. */
    String TYPE = "type";
    /** href. */
    String HREF = "href";
    /** created_at. */
    String CREATED_AT = "created_at";
    /** created_by_id. */
    String CREATED_BY_ID = "created_by_id";
    /** last_modified_at. */
    String LAST_MODIFIED_AT = "last_modified_at";
    /** last_modified_by_id. */
    String LAST_MODIFIED_BY_ID = "last_modified_by_id";
    /** state. */
    String STATE = "state";
  }

  /**
   * Include additional data per policy returned
   * * `include_last_permit` - returns details of when the policy last granted a permit decision and the number of times
   * it has done so
   * * `display` - returns the list of all actions included in each of the policy roles.
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
  protected String tagName;
  protected String tagValue;
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
    private String tagName;
    private String tagValue;
    private String sort;
    private String format;
    private String state;

    /**
     * Instantiates a new Builder from an existing ListPoliciesOptions instance.
     *
     * @param listPoliciesOptions the instance to initialize the Builder with
     */
    private Builder(ListPoliciesOptions listPoliciesOptions) {
      this.accountId = listPoliciesOptions.accountId;
      this.acceptLanguage = listPoliciesOptions.acceptLanguage;
      this.iamId = listPoliciesOptions.iamId;
      this.accessGroupId = listPoliciesOptions.accessGroupId;
      this.type = listPoliciesOptions.type;
      this.serviceType = listPoliciesOptions.serviceType;
      this.tagName = listPoliciesOptions.tagName;
      this.tagValue = listPoliciesOptions.tagValue;
      this.sort = listPoliciesOptions.sort;
      this.format = listPoliciesOptions.format;
      this.state = listPoliciesOptions.state;
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

    /**
     * Set the tagName.
     *
     * @param tagName the tagName
     * @return the ListPoliciesOptions builder
     */
    public Builder tagName(String tagName) {
      this.tagName = tagName;
      return this;
    }

    /**
     * Set the tagValue.
     *
     * @param tagValue the tagValue
     * @return the ListPoliciesOptions builder
     */
    public Builder tagValue(String tagValue) {
      this.tagValue = tagValue;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListPoliciesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the format.
     *
     * @param format the format
     * @return the ListPoliciesOptions builder
     */
    public Builder format(String format) {
      this.format = format;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListPoliciesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }
  }

  protected ListPoliciesOptions() { }

  protected ListPoliciesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    iamId = builder.iamId;
    accessGroupId = builder.accessGroupId;
    type = builder.type;
    serviceType = builder.serviceType;
    tagName = builder.tagName;
    tagValue = builder.tagValue;
    sort = builder.sort;
    format = builder.format;
    state = builder.state;
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
   * The account GUID that the policies belong to.
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
   * Gets the tagName.
   *
   * Optional name of the access tag in the policy.
   *
   * @return the tagName
   */
  public String tagName() {
    return tagName;
  }

  /**
   * Gets the tagValue.
   *
   * Optional value of the access tag in the policy.
   *
   * @return the tagValue
   */
  public String tagValue() {
    return tagValue;
  }

  /**
   * Gets the sort.
   *
   * Optional top level policy field to sort results. Ascending sort is default. Descending sort available by prepending
   * '-' to field. Example '-last_modified_at'.
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
   * * `display` - returns the list of all actions included in each of the policy roles.
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

