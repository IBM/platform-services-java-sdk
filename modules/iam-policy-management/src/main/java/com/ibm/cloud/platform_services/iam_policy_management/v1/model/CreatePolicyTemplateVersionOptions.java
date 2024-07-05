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
 * The createPolicyTemplateVersion options.
 */
public class CreatePolicyTemplateVersionOptions extends GenericModel {

  protected String policyTemplateId;
  protected TemplatePolicy policy;
  protected String name;
  protected String description;
  protected Boolean committed;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyTemplateId;
    private TemplatePolicy policy;
    private String name;
    private String description;
    private Boolean committed;

    /**
     * Instantiates a new Builder from an existing CreatePolicyTemplateVersionOptions instance.
     *
     * @param createPolicyTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(CreatePolicyTemplateVersionOptions createPolicyTemplateVersionOptions) {
      this.policyTemplateId = createPolicyTemplateVersionOptions.policyTemplateId;
      this.policy = createPolicyTemplateVersionOptions.policy;
      this.name = createPolicyTemplateVersionOptions.name;
      this.description = createPolicyTemplateVersionOptions.description;
      this.committed = createPolicyTemplateVersionOptions.committed;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyTemplateId the policyTemplateId
     * @param policy the policy
     */
    public Builder(String policyTemplateId, TemplatePolicy policy) {
      this.policyTemplateId = policyTemplateId;
      this.policy = policy;
    }

    /**
     * Builds a CreatePolicyTemplateVersionOptions.
     *
     * @return the new CreatePolicyTemplateVersionOptions instance
     */
    public CreatePolicyTemplateVersionOptions build() {
      return new CreatePolicyTemplateVersionOptions(this);
    }

    /**
     * Set the policyTemplateId.
     *
     * @param policyTemplateId the policyTemplateId
     * @return the CreatePolicyTemplateVersionOptions builder
     */
    public Builder policyTemplateId(String policyTemplateId) {
      this.policyTemplateId = policyTemplateId;
      return this;
    }

    /**
     * Set the policy.
     *
     * @param policy the policy
     * @return the CreatePolicyTemplateVersionOptions builder
     */
    public Builder policy(TemplatePolicy policy) {
      this.policy = policy;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreatePolicyTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreatePolicyTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the committed.
     *
     * @param committed the committed
     * @return the CreatePolicyTemplateVersionOptions builder
     */
    public Builder committed(Boolean committed) {
      this.committed = committed;
      return this;
    }
  }

  protected CreatePolicyTemplateVersionOptions() { }

  protected CreatePolicyTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyTemplateId,
      "policyTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.policy,
      "policy cannot be null");
    policyTemplateId = builder.policyTemplateId;
    policy = builder.policy;
    name = builder.name;
    description = builder.description;
    committed = builder.committed;
  }

  /**
   * New builder.
   *
   * @return a CreatePolicyTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyTemplateId.
   *
   * The policy template ID.
   *
   * @return the policyTemplateId
   */
  public String policyTemplateId() {
    return policyTemplateId;
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
   * Committed status of the template version.
   *
   * @return the committed
   */
  public Boolean committed() {
    return committed;
  }
}

