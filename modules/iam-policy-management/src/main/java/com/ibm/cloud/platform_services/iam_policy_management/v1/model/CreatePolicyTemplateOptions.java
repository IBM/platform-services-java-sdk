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
 * The createPolicyTemplate options.
 */
public class CreatePolicyTemplateOptions extends GenericModel {

  protected String name;
  protected String accountId;
  protected TemplatePolicy policy;
  protected String description;
  protected Boolean committed;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String accountId;
    private TemplatePolicy policy;
    private String description;
    private Boolean committed;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreatePolicyTemplateOptions instance.
     *
     * @param createPolicyTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CreatePolicyTemplateOptions createPolicyTemplateOptions) {
      this.name = createPolicyTemplateOptions.name;
      this.accountId = createPolicyTemplateOptions.accountId;
      this.policy = createPolicyTemplateOptions.policy;
      this.description = createPolicyTemplateOptions.description;
      this.committed = createPolicyTemplateOptions.committed;
      this.acceptLanguage = createPolicyTemplateOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param accountId the accountId
     * @param policy the policy
     */
    public Builder(String name, String accountId, TemplatePolicy policy) {
      this.name = name;
      this.accountId = accountId;
      this.policy = policy;
    }

    /**
     * Builds a CreatePolicyTemplateOptions.
     *
     * @return the new CreatePolicyTemplateOptions instance
     */
    public CreatePolicyTemplateOptions build() {
      return new CreatePolicyTemplateOptions(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreatePolicyTemplateOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreatePolicyTemplateOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the policy.
     *
     * @param policy the policy
     * @return the CreatePolicyTemplateOptions builder
     */
    public Builder policy(TemplatePolicy policy) {
      this.policy = policy;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreatePolicyTemplateOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the CreatePolicyTemplateOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreatePolicyTemplateOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreatePolicyTemplateOptions() { }

  protected CreatePolicyTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.policy,
      "policy cannot be null");
    name = builder.name;
    accountId = builder.accountId;
    policy = builder.policy;
    description = builder.description;
    committed = builder.committed;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a CreatePolicyTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Required field when creating a new template. Otherwise this field is optional. If the field is included it will
   * change the name value for all existing versions of the template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account ID where this template will be created.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the policy.
   *
   * The core set of properties associated with the template's policy objet.
   *
   * @return the policy
   */
  public TemplatePolicy policy() {
    return policy;
  }

  /**
   * Gets the description.
   *
   * Description of the policy template. This is shown to users in the enterprise account. Use this to describe the
   * purpose or context of the policy for enterprise users managing IAM templates.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the committed.
   *
   * Committed status of the template.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
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
}

