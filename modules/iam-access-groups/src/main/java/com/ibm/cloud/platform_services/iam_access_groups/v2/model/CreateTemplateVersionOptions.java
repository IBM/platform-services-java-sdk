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
 * The createTemplateVersion options.
 */
public class CreateTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected String name;
  protected String description;
  protected AccessGroupInput accessGroup;
  protected List<PolicyTemplatesInput> policyTemplates;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String name;
    private String description;
    private AccessGroupInput accessGroup;
    private List<PolicyTemplatesInput> policyTemplates;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateTemplateVersionOptions instance.
     *
     * @param createTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(CreateTemplateVersionOptions createTemplateVersionOptions) {
      this.templateId = createTemplateVersionOptions.templateId;
      this.name = createTemplateVersionOptions.name;
      this.description = createTemplateVersionOptions.description;
      this.accessGroup = createTemplateVersionOptions.accessGroup;
      this.policyTemplates = createTemplateVersionOptions.policyTemplates;
      this.transactionId = createTemplateVersionOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param templateId the templateId
     */
    public Builder(String templateId) {
      this.templateId = templateId;
    }

    /**
     * Builds a CreateTemplateVersionOptions.
     *
     * @return the new CreateTemplateVersionOptions instance
     */
    public CreateTemplateVersionOptions build() {
      return new CreateTemplateVersionOptions(this);
    }

    /**
     * Adds an policyTemplates to policyTemplates.
     *
     * @param policyTemplates the new policyTemplates
     * @return the CreateTemplateVersionOptions builder
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
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CreateTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the accessGroup.
     *
     * @param accessGroup the accessGroup
     * @return the CreateTemplateVersionOptions builder
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
     * @return the CreateTemplateVersionOptions builder
     */
    public Builder policyTemplates(List<PolicyTemplatesInput> policyTemplates) {
      this.policyTemplates = policyTemplates;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateTemplateVersionOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateTemplateVersionOptions() { }

  protected CreateTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    name = builder.name;
    description = builder.description;
    accessGroup = builder.accessGroup;
    policyTemplates = builder.policyTemplates;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * parameter template id.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the name.
   *
   * The name of the template version.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the template version.
   *
   * @return the description
   */
  public String description() {
    return description;
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
   * The policy templates associated with the template version.
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

