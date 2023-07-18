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
 * The updateProfileTemplateVersion options.
 */
public class UpdateProfileTemplateVersionOptions extends GenericModel {

  protected String ifMatch;
  protected String templateId;
  protected String version;
  protected String accountId;
  protected String name;
  protected String description;
  protected TemplateProfileComponentRequest profile;
  protected List<PolicyTemplateReference> policyTemplateReferences;

  /**
   * Builder.
   */
  public static class Builder {
    private String ifMatch;
    private String templateId;
    private String version;
    private String accountId;
    private String name;
    private String description;
    private TemplateProfileComponentRequest profile;
    private List<PolicyTemplateReference> policyTemplateReferences;

    /**
     * Instantiates a new Builder from an existing UpdateProfileTemplateVersionOptions instance.
     *
     * @param updateProfileTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(UpdateProfileTemplateVersionOptions updateProfileTemplateVersionOptions) {
      this.ifMatch = updateProfileTemplateVersionOptions.ifMatch;
      this.templateId = updateProfileTemplateVersionOptions.templateId;
      this.version = updateProfileTemplateVersionOptions.version;
      this.accountId = updateProfileTemplateVersionOptions.accountId;
      this.name = updateProfileTemplateVersionOptions.name;
      this.description = updateProfileTemplateVersionOptions.description;
      this.profile = updateProfileTemplateVersionOptions.profile;
      this.policyTemplateReferences = updateProfileTemplateVersionOptions.policyTemplateReferences;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ifMatch the ifMatch
     * @param templateId the templateId
     * @param version the version
     */
    public Builder(String ifMatch, String templateId, String version) {
      this.ifMatch = ifMatch;
      this.templateId = templateId;
      this.version = version;
    }

    /**
     * Builds a UpdateProfileTemplateVersionOptions.
     *
     * @return the new UpdateProfileTemplateVersionOptions instance
     */
    public UpdateProfileTemplateVersionOptions build() {
      return new UpdateProfileTemplateVersionOptions(this);
    }

    /**
     * Adds an policyTemplateReferences to policyTemplateReferences.
     *
     * @param policyTemplateReferences the new policyTemplateReferences
     * @return the UpdateProfileTemplateVersionOptions builder
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
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the profile.
     *
     * @param profile the profile
     * @return the UpdateProfileTemplateVersionOptions builder
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
     * @return the UpdateProfileTemplateVersionOptions builder
     */
    public Builder policyTemplateReferences(List<PolicyTemplateReference> policyTemplateReferences) {
      this.policyTemplateReferences = policyTemplateReferences;
      return this;
    }
  }

  protected UpdateProfileTemplateVersionOptions() { }

  protected UpdateProfileTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    ifMatch = builder.ifMatch;
    templateId = builder.templateId;
    version = builder.version;
    accountId = builder.accountId;
    name = builder.name;
    description = builder.description;
    profile = builder.profile;
    policyTemplateReferences = builder.policyTemplateReferences;
  }

  /**
   * New builder.
   *
   * @return a UpdateProfileTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ifMatch.
   *
   * Entity tag of the Template to be updated. Specify the tag that you retrieved when reading the Profile Template.
   * This value helps identifying parallel usage of this API. Pass * to indicate to update any version available. This
   * might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
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
   * Gets the version.
   *
   * Version of the Profile Template.
   *
   * @return the version
   */
  public String version() {
    return version;
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

