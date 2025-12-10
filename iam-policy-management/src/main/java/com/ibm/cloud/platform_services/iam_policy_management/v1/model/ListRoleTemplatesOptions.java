/*
 * (C) Copyright IBM Corp. 2025.
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
 * The listRoleTemplates options.
 */
public class ListRoleTemplatesOptions extends GenericModel {

  /**
   * The role template state.
   */
  public interface State {
    /** active. */
    String ACTIVE = "active";
    /** deleted. */
    String DELETED = "deleted";
  }

  protected String accountId;
  protected String acceptLanguage;
  protected String name;
  protected String roleName;
  protected String roleServiceName;
  protected String state;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String acceptLanguage;
    private String name;
    private String roleName;
    private String roleServiceName;
    private String state;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListRoleTemplatesOptions instance.
     *
     * @param listRoleTemplatesOptions the instance to initialize the Builder with
     */
    private Builder(ListRoleTemplatesOptions listRoleTemplatesOptions) {
      this.accountId = listRoleTemplatesOptions.accountId;
      this.acceptLanguage = listRoleTemplatesOptions.acceptLanguage;
      this.name = listRoleTemplatesOptions.name;
      this.roleName = listRoleTemplatesOptions.roleName;
      this.roleServiceName = listRoleTemplatesOptions.roleServiceName;
      this.state = listRoleTemplatesOptions.state;
      this.limit = listRoleTemplatesOptions.limit;
      this.start = listRoleTemplatesOptions.start;
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
     * Builds a ListRoleTemplatesOptions.
     *
     * @return the new ListRoleTemplatesOptions instance
     */
    public ListRoleTemplatesOptions build() {
      return new ListRoleTemplatesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the roleName.
     *
     * @param roleName the roleName
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder roleName(String roleName) {
      this.roleName = roleName;
      return this;
    }

    /**
     * Set the roleServiceName.
     *
     * @param roleServiceName the roleServiceName
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder roleServiceName(String roleServiceName) {
      this.roleServiceName = roleServiceName;
      return this;
    }

    /**
     * Set the state.
     *
     * @param state the state
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder state(String state) {
      this.state = state;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListRoleTemplatesOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListRoleTemplatesOptions() { }

  protected ListRoleTemplatesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    name = builder.name;
    roleName = builder.roleName;
    roleServiceName = builder.roleServiceName;
    state = builder.state;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListRoleTemplatesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account GUID that the role templates belong to.
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
   * Gets the name.
   *
   * The role template name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the roleName.
   *
   * The template role name.
   *
   * @return the roleName
   */
  public String roleName() {
    return roleName;
  }

  /**
   * Gets the roleServiceName.
   *
   * The template role service name.
   *
   * @return the roleServiceName
   */
  public String roleServiceName() {
    return roleServiceName;
  }

  /**
   * Gets the state.
   *
   * The role template state.
   *
   * @return the state
   */
  public String state() {
    return state;
  }

  /**
   * Gets the limit.
   *
   * The number of documents to include in the collection.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the start.
   *
   * Page token that refers to the page of the collection to return.
   *
   * @return the start
   */
  public String start() {
    return start;
  }
}

