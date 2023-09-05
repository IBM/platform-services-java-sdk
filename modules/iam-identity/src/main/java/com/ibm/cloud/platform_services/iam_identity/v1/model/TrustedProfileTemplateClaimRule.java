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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * TrustedProfileTemplateClaimRule.
 */
public class TrustedProfileTemplateClaimRule extends GenericModel {

  /**
   * Type of the claim rule.
   */
  public interface Type {
    /** Profile-SAML. */
    String PROFILE_SAML = "Profile-SAML";
  }

  protected String name;
  protected String type;
  @SerializedName("realm_name")
  protected String realmName;
  protected Long expiration;
  protected List<ProfileClaimRuleConditions> conditions;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String type;
    private String realmName;
    private Long expiration;
    private List<ProfileClaimRuleConditions> conditions;

    /**
     * Instantiates a new Builder from an existing TrustedProfileTemplateClaimRule instance.
     *
     * @param trustedProfileTemplateClaimRule the instance to initialize the Builder with
     */
    private Builder(TrustedProfileTemplateClaimRule trustedProfileTemplateClaimRule) {
      this.name = trustedProfileTemplateClaimRule.name;
      this.type = trustedProfileTemplateClaimRule.type;
      this.realmName = trustedProfileTemplateClaimRule.realmName;
      this.expiration = trustedProfileTemplateClaimRule.expiration;
      this.conditions = trustedProfileTemplateClaimRule.conditions;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param conditions the conditions
     */
    public Builder(String type, List<ProfileClaimRuleConditions> conditions) {
      this.type = type;
      this.conditions = conditions;
    }

    /**
     * Builds a TrustedProfileTemplateClaimRule.
     *
     * @return the new TrustedProfileTemplateClaimRule instance
     */
    public TrustedProfileTemplateClaimRule build() {
      return new TrustedProfileTemplateClaimRule(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the TrustedProfileTemplateClaimRule builder
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
     * Set the name.
     *
     * @param name the name
     * @return the TrustedProfileTemplateClaimRule builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the TrustedProfileTemplateClaimRule builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the realmName.
     *
     * @param realmName the realmName
     * @return the TrustedProfileTemplateClaimRule builder
     */
    public Builder realmName(String realmName) {
      this.realmName = realmName;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the TrustedProfileTemplateClaimRule builder
     */
    public Builder expiration(long expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the conditions.
     * Existing conditions will be replaced.
     *
     * @param conditions the conditions
     * @return the TrustedProfileTemplateClaimRule builder
     */
    public Builder conditions(List<ProfileClaimRuleConditions> conditions) {
      this.conditions = conditions;
      return this;
    }
  }

  protected TrustedProfileTemplateClaimRule() { }

  protected TrustedProfileTemplateClaimRule(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.conditions,
      "conditions cannot be null");
    name = builder.name;
    type = builder.type;
    realmName = builder.realmName;
    expiration = builder.expiration;
    conditions = builder.conditions;
  }

  /**
   * New builder.
   *
   * @return a TrustedProfileTemplateClaimRule builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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
   * Gets the type.
   *
   * Type of the claim rule.
   *
   * @return the type
   */
  public String type() {
    return type;
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
   * Gets the expiration.
   *
   * Session expiration in seconds, only required if type is 'Profile-SAML'.
   *
   * @return the expiration
   */
  public Long expiration() {
    return expiration;
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
}

