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
 * The replaceAccessGroupRule options.
 */
public class ReplaceAccessGroupRuleOptions extends GenericModel {

  protected String accessGroupId;
  protected String ruleId;
  protected String ifMatch;
  protected Long expiration;
  protected String realmName;
  protected List<RuleConditions> conditions;
  protected String name;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String accessGroupId;
    private String ruleId;
    private String ifMatch;
    private Long expiration;
    private String realmName;
    private List<RuleConditions> conditions;
    private String name;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing ReplaceAccessGroupRuleOptions instance.
     *
     * @param replaceAccessGroupRuleOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceAccessGroupRuleOptions replaceAccessGroupRuleOptions) {
      this.accessGroupId = replaceAccessGroupRuleOptions.accessGroupId;
      this.ruleId = replaceAccessGroupRuleOptions.ruleId;
      this.ifMatch = replaceAccessGroupRuleOptions.ifMatch;
      this.expiration = replaceAccessGroupRuleOptions.expiration;
      this.realmName = replaceAccessGroupRuleOptions.realmName;
      this.conditions = replaceAccessGroupRuleOptions.conditions;
      this.name = replaceAccessGroupRuleOptions.name;
      this.transactionId = replaceAccessGroupRuleOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accessGroupId the accessGroupId
     * @param ruleId the ruleId
     * @param ifMatch the ifMatch
     * @param expiration the expiration
     * @param realmName the realmName
     * @param conditions the conditions
     */
    public Builder(String accessGroupId, String ruleId, String ifMatch, Long expiration, String realmName, List<RuleConditions> conditions) {
      this.accessGroupId = accessGroupId;
      this.ruleId = ruleId;
      this.ifMatch = ifMatch;
      this.expiration = expiration;
      this.realmName = realmName;
      this.conditions = conditions;
    }

    /**
     * Builds a ReplaceAccessGroupRuleOptions.
     *
     * @return the new ReplaceAccessGroupRuleOptions instance
     */
    public ReplaceAccessGroupRuleOptions build() {
      return new ReplaceAccessGroupRuleOptions(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder addConditions(RuleConditions conditions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conditions,
        "conditions cannot be null");
      if (this.conditions == null) {
        this.conditions = new ArrayList<RuleConditions>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /**
     * Set the accessGroupId.
     *
     * @param accessGroupId the accessGroupId
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder expiration(long expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the realmName.
     *
     * @param realmName the realmName
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder realmName(String realmName) {
      this.realmName = realmName;
      return this;
    }

    /**
     * Set the conditions.
     * Existing conditions will be replaced.
     *
     * @param conditions the conditions
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder conditions(List<RuleConditions> conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceAccessGroupRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected ReplaceAccessGroupRuleOptions() { }

  protected ReplaceAccessGroupRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.expiration,
      "expiration cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.realmName,
      "realmName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.conditions,
      "conditions cannot be null");
    accessGroupId = builder.accessGroupId;
    ruleId = builder.ruleId;
    ifMatch = builder.ifMatch;
    expiration = builder.expiration;
    realmName = builder.realmName;
    conditions = builder.conditions;
    name = builder.name;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceAccessGroupRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The access group identifier.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the ruleId.
   *
   * The rule to get.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the ifMatch.
   *
   * The current revision number of the rule being updated. This can be found in the Get Rule response ETag header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the expiration.
   *
   * Session duration in hours. Access group membership is revoked after this time period expires. Users must log back
   * in to refresh their access group membership.
   *
   * @return the expiration
   */
  public Long expiration() {
    return expiration;
  }

  /**
   * Gets the realmName.
   *
   * The URL of the identity provider (IdP).
   *
   * @return the realmName
   */
  public String realmName() {
    return realmName;
  }

  /**
   * Gets the conditions.
   *
   * A list of conditions that identities must satisfy to gain access group membership.
   *
   * @return the conditions
   */
  public List<RuleConditions> conditions() {
    return conditions;
  }

  /**
   * Gets the name.
   *
   * The name of the dynaimic rule.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction ID can be passed to your request, which can be useful for tracking calls through multiple
   * services by using one identifier. The header key must be set to Transaction-Id and the value is anything that you
   * choose. If no transaction ID is passed in, then a random ID is generated.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

