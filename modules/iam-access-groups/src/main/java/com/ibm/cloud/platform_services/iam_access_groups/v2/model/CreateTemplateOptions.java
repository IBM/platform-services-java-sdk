/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createTemplate options.
 */
public class CreateTemplateOptions extends GenericModel {

  protected String name;
  protected String accountId;
  protected String description;
  protected AccessGroupRequest group;
  protected List<PolicyTemplates> policyTemplateReferences;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String accountId;
    private String description;
    private AccessGroupRequest group;
    private List<PolicyTemplates> policyTemplateReferences;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateTemplateOptions instance.
     *
     * @param createTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CreateTemplateOptions createTemplateOptions) {
      this.name = createTemplateOptions.name;
      this.accountId = createTemplateOptions.accountId;
      this.description = createTemplateOptions.description;
      this.group = createTemplateOptions.group;
      this.policyTemplateReferences = createTemplateOptions.policyTemplateReferences;
      this.transactionId = createTemplateOptions.transactionId;
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
     */
    public Builder(String name, String accountId) {
      this.name = name;
      this.accountId = accountId;
    }

    /**
     * Builds a CreateTemplateOptions.
     *
     * @return the new CreateTemplateOptions instance
     */
    public CreateTemplateOptions build() {
      return new CreateTemplateOptions(this);
    }

    /**
     * Adds an policyTemplateReferences to policyTemplateReferences.
     *
     * @param policyTemplateReferences the new policyTemplateReferences
     * @return the CreateTemplateOptions builder
     */
    public Builder addPolicyTemplateReferences(PolicyTemplates policyTemplateReferences) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(policyTemplateReferences,
        "policyTemplateReferences cannot be null");
      if (this.policyTemplateReferences == null) {
        this.policyTemplateReferences = new ArrayList<PolicyTemplates>();
      }
      this.policyTemplateReferences.add(policyTemplateReferences);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateTemplateOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateTemplateOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateTemplateOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the group.
     *
     * @param group the group
     * @return the CreateTemplateOptions builder
     */
    public Builder group(AccessGroupRequest group) {
      this.group = group;
      return this;
    }

    /**
     * Set the policyTemplateReferences.
     * Existing policyTemplateReferences will be replaced.
     *
     * @param policyTemplateReferences the policyTemplateReferences
     * @return the CreateTemplateOptions builder
     */
    public Builder policyTemplateReferences(List<PolicyTemplates> policyTemplateReferences) {
      this.policyTemplateReferences = policyTemplateReferences;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateTemplateOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateTemplateOptions() { }

  protected CreateTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    name = builder.name;
    accountId = builder.accountId;
    description = builder.description;
    group = builder.group;
    policyTemplateReferences = builder.policyTemplateReferences;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Give the access group template a unique name that doesn't conflict with an existing access group templates in the
   * account.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account id in which the template will be created.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the description.
   *
   * Assign an optional description for the access group template.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the group.
   *
   * Access Group Component.
   *
   * @return the group
   */
  public AccessGroupRequest group() {
    return group;
  }

  /**
   * Gets the policyTemplateReferences.
   *
   * Existing policy templates that you can reference to assign access in the Access group input component.
   *
   * @return the policyTemplateReferences
   */
  public List<PolicyTemplates> policyTemplateReferences() {
    return policyTemplateReferences;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

