/*
 * (C) Copyright IBM Corp. 2021.
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
 * The updateClaimRule options.
 */
public class UpdateClaimRuleOptions extends GenericModel {

  protected String profileId;
  protected String ruleId;
  protected String ifMatch;
  protected String type;
  protected List<ProfileClaimRuleConditions> conditions;
  protected ResponseContext context;
  protected String name;
  protected String realmName;
  protected String crType;
  protected Long expiration;

  /**
   * Builder.
   */
  public static class Builder {
    private String profileId;
    private String ruleId;
    private String ifMatch;
    private String type;
    private List<ProfileClaimRuleConditions> conditions;
    private ResponseContext context;
    private String name;
    private String realmName;
    private String crType;
    private Long expiration;

    private Builder(UpdateClaimRuleOptions updateClaimRuleOptions) {
      this.profileId = updateClaimRuleOptions.profileId;
      this.ruleId = updateClaimRuleOptions.ruleId;
      this.ifMatch = updateClaimRuleOptions.ifMatch;
      this.type = updateClaimRuleOptions.type;
      this.conditions = updateClaimRuleOptions.conditions;
      this.context = updateClaimRuleOptions.context;
      this.name = updateClaimRuleOptions.name;
      this.realmName = updateClaimRuleOptions.realmName;
      this.crType = updateClaimRuleOptions.crType;
      this.expiration = updateClaimRuleOptions.expiration;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param profileId the profileId
     * @param ruleId the ruleId
     * @param ifMatch the ifMatch
     * @param type the type
     * @param conditions the conditions
     */
    public Builder(String profileId, String ruleId, String ifMatch, String type, List<ProfileClaimRuleConditions> conditions) {
      this.profileId = profileId;
      this.ruleId = ruleId;
      this.ifMatch = ifMatch;
      this.type = type;
      this.conditions = conditions;
    }

    /**
     * Builds a UpdateClaimRuleOptions.
     *
     * @return the new UpdateClaimRuleOptions instance
     */
    public UpdateClaimRuleOptions build() {
      return new UpdateClaimRuleOptions(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder addConditions(ProfileClaimRuleConditions conditions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conditions,
        "conditions cannot be null");
      if (this.conditions == null) {
        this.conditions = new ArrayList<ProfileClaimRuleConditions>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /**
     * Set the profileId.
     *
     * @param profileId the profileId
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder profileId(String profileId) {
      this.profileId = profileId;
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the conditions.
     * Existing conditions will be replaced.
     *
     * @param conditions the conditions
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder conditions(List<ProfileClaimRuleConditions> conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the context.
     *
     * @param context the context
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder context(ResponseContext context) {
      this.context = context;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the realmName.
     *
     * @param realmName the realmName
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder realmName(String realmName) {
      this.realmName = realmName;
      return this;
    }

    /**
     * Set the crType.
     *
     * @param crType the crType
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder crType(String crType) {
      this.crType = crType;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the UpdateClaimRuleOptions builder
     */
    public Builder expiration(long expiration) {
      this.expiration = expiration;
      return this;
    }
  }

  protected UpdateClaimRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.profileId,
      "profileId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.conditions,
      "conditions cannot be null");
    profileId = builder.profileId;
    ruleId = builder.ruleId;
    ifMatch = builder.ifMatch;
    type = builder.type;
    conditions = builder.conditions;
    context = builder.context;
    name = builder.name;
    realmName = builder.realmName;
    crType = builder.crType;
    expiration = builder.expiration;
  }

  /**
   * New builder.
   *
   * @return a UpdateClaimRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the profileId.
   *
   * ID of the trusted profile.
   *
   * @return the profileId
   */
  public String profileId() {
    return profileId;
  }

  /**
   * Gets the ruleId.
   *
   * ID of the claim rule to update.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the ifMatch.
   *
   * Version of the claim rule to be updated.  Specify the version that you retrived when reading list of claim rules.
   * This value helps to identify any parallel usage of claim rule. Pass * to indicate to update any version available.
   * This might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the type.
   *
   * Type of the calim rule, either 'Profile-SAML' or 'Profile-CR'.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the conditions.
   *
   * Conditions of this claim rule.
   *
   * @return the conditions
   */
  public List<ProfileClaimRuleConditions> conditions() {
    return conditions;
  }

  /**
   * Gets the context.
   *
   * Context with key properties for problem determination.
   *
   * @return the context
   */
  public ResponseContext context() {
    return context;
  }

  /**
   * Gets the name.
   *
   * Name of the claim rule to be created or updated.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the realmName.
   *
   * The realm name of the Idp this claim rule applies to. This field is required only if the type is specified as
   * 'Profile-SAML'.
   *
   * @return the realmName
   */
  public String realmName() {
    return realmName;
  }

  /**
   * Gets the crType.
   *
   * The compute resource type the rule applies to, required only if type is specified as 'Profile-CR'. Valid values are
   * VSI, IKS_SA, ROKS_SA.
   *
   * @return the crType
   */
  public String crType() {
    return crType;
  }

  /**
   * Gets the expiration.
   *
   * Session expiration in seconds, only required if type is 'Profile-SAML'.
   *
   * @return the expiration
   */
  public Long expiration() {
    return expiration;
  }
}

