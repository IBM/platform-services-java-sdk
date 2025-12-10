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
 * The listRoleAssignments options.
 */
public class ListRoleAssignmentsOptions extends GenericModel {

  protected String accountId;
  protected String acceptLanguage;
  protected String templateId;
  protected String templateVersion;
  protected Long limit;
  protected String start;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String acceptLanguage;
    private String templateId;
    private String templateVersion;
    private Long limit;
    private String start;

    /**
     * Instantiates a new Builder from an existing ListRoleAssignmentsOptions instance.
     *
     * @param listRoleAssignmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListRoleAssignmentsOptions listRoleAssignmentsOptions) {
      this.accountId = listRoleAssignmentsOptions.accountId;
      this.acceptLanguage = listRoleAssignmentsOptions.acceptLanguage;
      this.templateId = listRoleAssignmentsOptions.templateId;
      this.templateVersion = listRoleAssignmentsOptions.templateVersion;
      this.limit = listRoleAssignmentsOptions.limit;
      this.start = listRoleAssignmentsOptions.start;
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
     * Builds a ListRoleAssignmentsOptions.
     *
     * @return the new ListRoleAssignmentsOptions instance
     */
    public ListRoleAssignmentsOptions build() {
      return new ListRoleAssignmentsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListRoleAssignmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListRoleAssignmentsOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ListRoleAssignmentsOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the ListRoleAssignmentsOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListRoleAssignmentsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the start.
     *
     * @param start the start
     * @return the ListRoleAssignmentsOptions builder
     */
    public Builder start(String start) {
      this.start = start;
      return this;
    }
  }

  protected ListRoleAssignmentsOptions() { }

  protected ListRoleAssignmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    templateId = builder.templateId;
    templateVersion = builder.templateVersion;
    limit = builder.limit;
    start = builder.start;
  }

  /**
   * New builder.
   *
   * @return a ListRoleAssignmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The account GUID in which the role assignment belongs to.
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
   * Gets the templateId.
   *
   * Optional template ID.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * Optional role template version.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
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

