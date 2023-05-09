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
  protected String description;
  protected String accountId;
  protected AccessGroupInput accessGroup;
  protected List<PolicyTemplatesInput> policyTemplates;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String accountId;
    private AccessGroupInput accessGroup;
    private List<PolicyTemplatesInput> policyTemplates;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateTemplateOptions instance.
     *
     * @param createTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CreateTemplateOptions createTemplateOptions) {
      this.name = createTemplateOptions.name;
      this.description = createTemplateOptions.description;
      this.accountId = createTemplateOptions.accountId;
      this.accessGroup = createTemplateOptions.accessGroup;
      this.policyTemplates = createTemplateOptions.policyTemplates;
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
     * @param description the description
     * @param accountId the accountId
     */
    public Builder(String name, String description, String accountId) {
      this.name = name;
      this.description = description;
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
     * Adds an policyTemplates to policyTemplates.
     *
     * @param policyTemplates the new policyTemplates
     * @return the CreateTemplateOptions builder
     */
    public Builder addPolicyTemplates(PolicyTemplatesInput policyTemplates) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(policyTemplates,
        "policyTemplates cannot be null");
      if (this.policyTemplates == null) {
        this.policyTemplates = new ArrayList<PolicyTemplatesInput>();
      }
      this.policyTemplates.add(policyTemplates);
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
     * Set the accessGroup.
     *
     * @param accessGroup the accessGroup
     * @return the CreateTemplateOptions builder
     */
    public Builder accessGroup(AccessGroupInput accessGroup) {
      this.accessGroup = accessGroup;
      return this;
    }

    /**
     * Set the policyTemplates.
     * Existing policyTemplates will be replaced.
     *
     * @param policyTemplates the policyTemplates
     * @return the CreateTemplateOptions builder
     */
    public Builder policyTemplates(List<PolicyTemplatesInput> policyTemplates) {
      this.policyTemplates = policyTemplates;
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
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    name = builder.name;
    description = builder.description;
    accountId = builder.accountId;
    accessGroup = builder.accessGroup;
    policyTemplates = builder.policyTemplates;
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
   * create template input name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * create template input description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the accountId.
   *
   * create template input account id.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the accessGroup.
   *
   * Access Group Input Component.
   *
   * @return the accessGroup
   */
  public AccessGroupInput accessGroup() {
    return accessGroup;
  }

  /**
   * Gets the policyTemplates.
   *
   * policy template references.
   *
   * @return the policyTemplates
   */
  public List<PolicyTemplatesInput> policyTemplates() {
    return policyTemplates;
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

