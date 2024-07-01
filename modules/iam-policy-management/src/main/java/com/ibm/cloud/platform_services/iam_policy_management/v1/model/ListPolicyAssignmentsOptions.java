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
 * The listPolicyAssignments options.
 */
public class ListPolicyAssignmentsOptions extends GenericModel {

  protected String version;
  protected String accountId;
  protected String acceptLanguage;
  protected String templateId;
  protected String templateVersion;

  /**
   * Builder.
   */
  public static class Builder {
    private String version;
    private String accountId;
    private String acceptLanguage;
    private String templateId;
    private String templateVersion;

    /**
     * Instantiates a new Builder from an existing ListPolicyAssignmentsOptions instance.
     *
     * @param listPolicyAssignmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListPolicyAssignmentsOptions listPolicyAssignmentsOptions) {
      this.version = listPolicyAssignmentsOptions.version;
      this.accountId = listPolicyAssignmentsOptions.accountId;
      this.acceptLanguage = listPolicyAssignmentsOptions.acceptLanguage;
      this.templateId = listPolicyAssignmentsOptions.templateId;
      this.templateVersion = listPolicyAssignmentsOptions.templateVersion;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param version the version
     * @param accountId the accountId
     */
    public Builder(String version, String accountId) {
      this.version = version;
      this.accountId = accountId;
    }

    /**
     * Builds a ListPolicyAssignmentsOptions.
     *
     * @return the new ListPolicyAssignmentsOptions instance
     */
    public ListPolicyAssignmentsOptions build() {
      return new ListPolicyAssignmentsOptions(this);
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the ListPolicyAssignmentsOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListPolicyAssignmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the ListPolicyAssignmentsOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ListPolicyAssignmentsOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the ListPolicyAssignmentsOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }
  }

  protected ListPolicyAssignmentsOptions() { }

  protected ListPolicyAssignmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.version,
      "version cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    version = builder.version;
    accountId = builder.accountId;
    acceptLanguage = builder.acceptLanguage;
    templateId = builder.templateId;
    templateVersion = builder.templateVersion;
  }

  /**
   * New builder.
   *
   * @return a ListPolicyAssignmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the version.
   *
   * specify version of response body format.
   *
   * @return the version
   */
  public String version() {
    return version;
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
   * Gets the templateId.
   *
   * Optional template id.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * Optional policy template version.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }
}

