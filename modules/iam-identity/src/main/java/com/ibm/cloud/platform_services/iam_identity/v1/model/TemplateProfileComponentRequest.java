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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Input body parameters for the TemplateProfileComponent.
 */
public class TemplateProfileComponentRequest extends GenericModel {

  protected String name;
  protected String description;
  protected String email;
  protected List<TrustedProfileTemplateClaimRule> rules;
  protected List<ProfileIdentityRequest> identities;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String description;
    private String email;
    private List<TrustedProfileTemplateClaimRule> rules;
    private List<ProfileIdentityRequest> identities;

    /**
     * Instantiates a new Builder from an existing TemplateProfileComponentRequest instance.
     *
     * @param templateProfileComponentRequest the instance to initialize the Builder with
     */
    private Builder(TemplateProfileComponentRequest templateProfileComponentRequest) {
      this.name = templateProfileComponentRequest.name;
      this.description = templateProfileComponentRequest.description;
      this.email = templateProfileComponentRequest.email;
      this.rules = templateProfileComponentRequest.rules;
      this.identities = templateProfileComponentRequest.identities;
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
     */
    public Builder(String name) {
      this.name = name;
    }

    /**
     * Builds a TemplateProfileComponentRequest.
     *
     * @return the new TemplateProfileComponentRequest instance
     */
    public TemplateProfileComponentRequest build() {
      return new TemplateProfileComponentRequest(this);
    }

    /**
     * Adds a new element to rules.
     *
     * @param rules the new element to be added
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder addRules(TrustedProfileTemplateClaimRule rules) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(rules,
        "rules cannot be null");
      if (this.rules == null) {
        this.rules = new ArrayList<TrustedProfileTemplateClaimRule>();
      }
      this.rules.add(rules);
      return this;
    }

    /**
     * Adds a new element to identities.
     *
     * @param identities the new element to be added
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder addIdentities(ProfileIdentityRequest identities) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(identities,
        "identities cannot be null");
      if (this.identities == null) {
        this.identities = new ArrayList<ProfileIdentityRequest>();
      }
      this.identities.add(identities);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the email.
     *
     * @param email the email
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder email(String email) {
      this.email = email;
      return this;
    }

    /**
     * Set the rules.
     * Existing rules will be replaced.
     *
     * @param rules the rules
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder rules(List<TrustedProfileTemplateClaimRule> rules) {
      this.rules = rules;
      return this;
    }

    /**
     * Set the identities.
     * Existing identities will be replaced.
     *
     * @param identities the identities
     * @return the TemplateProfileComponentRequest builder
     */
    public Builder identities(List<ProfileIdentityRequest> identities) {
      this.identities = identities;
      return this;
    }
  }

  protected TemplateProfileComponentRequest() { }

  protected TemplateProfileComponentRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    name = builder.name;
    description = builder.description;
    email = builder.email;
    rules = builder.rules;
    identities = builder.identities;
  }

  /**
   * New builder.
   *
   * @return a TemplateProfileComponentRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Name of the Profile.
   *
   * You can use replacement variables in the profile name to adjust the name per account.
   *
   * The following variables are supported:
   *
   * - `${template_id}` will be replaced by a unique identifier representing the trusted profile template
   *
   * - `${template_name}` will be replaced by the current name of the trusted profile template
   *
   * - `${template_version}` will be replaced by the current version of the trusted profile template
   *
   * - `${account_id}` will be replaced by the account identifier to which this trusted profile template is assigned to
   *
   * - `${account_name}` will be replaced by the account name to which this trusted profile template is assigned to
   *
   * Changes to e.g. the name of the account will NOT cause an update of the trusted profile name. The profile name is
   * processed during account assignment and any template version upgrade, i.e. during that operation, the updated
   * account name would be used.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * Description of the Profile.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the email.
   *
   * Email of the trusted profile.
   *
   * @return the email
   */
  public String email() {
    return email;
  }

  /**
   * Gets the rules.
   *
   * Rules for the Profile.
   *
   * @return the rules
   */
  public List<TrustedProfileTemplateClaimRule> rules() {
    return rules;
  }

  /**
   * Gets the identities.
   *
   * Identities for the Profile.
   *
   * @return the identities
   */
  public List<ProfileIdentityRequest> identities() {
    return identities;
  }
}

