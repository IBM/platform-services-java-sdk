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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createProfileTemplateVersion options.
 */
public class CreateProfileTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected String accountId;
  protected String name;
  protected String description;
  protected TemplateProfileComponentRequest profile;
  protected List<PolicyTemplateReference> policyTemplateReferences;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String accountId;
    private String name;
    private String description;
    private TemplateProfileComponentRequest profile;
    private List<PolicyTemplateReference> policyTemplateReferences;

    /**
     * Instantiates a new Builder from an existing CreateProfileTemplateVersionOptions instance.
     *
     * @param createProfileTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(CreateProfileTemplateVersionOptions createProfileTemplateVersionOptions) {
      this.templateId = createProfileTemplateVersionOptions.templateId;
      this.accountId = createProfileTemplateVersionOptions.accountId;
      this.name = createProfileTemplateVersionOptions.name;
      this.description = createProfileTemplateVersionOptions.description;
      this.profile = createProfileTemplateVersionOptions.profile;
      this.policyTemplateReferences = createProfileTemplateVersionOptions.policyTemplateReferences;
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
     * Builds a CreateProfileTemplateVersionOptions.
     *
     * @return the new CreateProfileTemplateVersionOptions instance
     */
    public CreateProfileTemplateVersionOptions build() {
      return new CreateProfileTemplateVersionOptions(this);
    }

    /**
     * Adds an policyTemplateReferences to policyTemplateReferences.
     *
     * @param policyTemplateReferences the new policyTemplateReferences
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder addPolicyTemplateReferences(PolicyTemplateReference policyTemplateReferences) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(policyTemplateReferences,
        "policyTemplateReferences cannot be null");
      if (this.policyTemplateReferences == null) {
        this.policyTemplateReferences = new ArrayList<PolicyTemplateReference>();
      }
      this.policyTemplateReferences.add(policyTemplateReferences);
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the profile.
     *
     * @param profile the profile
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder profile(TemplateProfileComponentRequest profile) {
      this.profile = profile;
      return this;
    }

    /**
     * Set the policyTemplateReferences.
     * Existing policyTemplateReferences will be replaced.
     *
     * @param policyTemplateReferences the policyTemplateReferences
     * @return the CreateProfileTemplateVersionOptions builder
     */
    public Builder policyTemplateReferences(List<PolicyTemplateReference> policyTemplateReferences) {
      this.policyTemplateReferences = policyTemplateReferences;
      return this;
    }
  }

  protected CreateProfileTemplateVersionOptions() { }

  protected CreateProfileTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    profile = builder.profile;
    policyTemplateReferences = builder.policyTemplateReferences;
  }

  /**
   * New builder.
   *
   * @return a CreateProfileTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the trusted profile template.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the accountId.
   *
   * ID of the account where the template resides.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the name.
   *
   * The name of the trusted profile template. This is visible only in the enterprise account. Required field when
   * creating a new template. Otherwise this field is optional. If the field is included it will change the name value
   * for all existing versions of the template.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the trusted profile template. Describe the template for enterprise account users.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the profile.
   *
   * Input body parameters for the TemplateProfileComponent.
   *
   * @return the profile
   */
  public TemplateProfileComponentRequest profile() {
    return profile;
  }

  /**
   * Gets the policyTemplateReferences.
   *
   * Existing policy templates that you can reference to assign access in the trusted profile component.
   *
   * @return the policyTemplateReferences
   */
  public List<PolicyTemplateReference> policyTemplateReferences() {
    return policyTemplateReferences;
  }
}

