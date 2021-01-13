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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The addAccessGroupRule options.
 */
public class AddAccessGroupRuleOptions extends GenericModel {

  protected String accessGroupId;
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
    private Long expiration;
    private String realmName;
    private List<RuleConditions> conditions;
    private String name;
    private String transactionId;

    private Builder(AddAccessGroupRuleOptions addAccessGroupRuleOptions) {
      this.accessGroupId = addAccessGroupRuleOptions.accessGroupId;
      this.expiration = addAccessGroupRuleOptions.expiration;
      this.realmName = addAccessGroupRuleOptions.realmName;
      this.conditions = addAccessGroupRuleOptions.conditions;
      this.name = addAccessGroupRuleOptions.name;
      this.transactionId = addAccessGroupRuleOptions.transactionId;
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
     * @param expiration the expiration
     * @param realmName the realmName
     * @param conditions the conditions
     */
    public Builder(String accessGroupId, Long expiration, String realmName, List<RuleConditions> conditions) {
      this.accessGroupId = accessGroupId;
      this.expiration = expiration;
      this.realmName = realmName;
      this.conditions = conditions;
    }

    /**
     * Builds a AddAccessGroupRuleOptions.
     *
     * @return the new AddAccessGroupRuleOptions instance
     */
    public AddAccessGroupRuleOptions build() {
      return new AddAccessGroupRuleOptions(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the AddAccessGroupRuleOptions builder
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
     * @return the AddAccessGroupRuleOptions builder
     */
    public Builder accessGroupId(String accessGroupId) {
      this.accessGroupId = accessGroupId;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the AddAccessGroupRuleOptions builder
     */
    public Builder expiration(long expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the realmName.
     *
     * @param realmName the realmName
     * @return the AddAccessGroupRuleOptions builder
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
     * @return the AddAccessGroupRuleOptions builder
     */
    public Builder conditions(List<RuleConditions> conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AddAccessGroupRuleOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the AddAccessGroupRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected AddAccessGroupRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accessGroupId,
      "accessGroupId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.expiration,
      "expiration cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.realmName,
      "realmName cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.conditions,
      "conditions cannot be null");
    accessGroupId = builder.accessGroupId;
    expiration = builder.expiration;
    realmName = builder.realmName;
    conditions = builder.conditions;
    name = builder.name;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a AddAccessGroupRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accessGroupId.
   *
   * The Access Group identifier.
   *
   * @return the accessGroupId
   */
  public String accessGroupId() {
    return accessGroupId;
  }

  /**
   * Gets the expiration.
   *
   * The number of hours that the rule lives for (Must be between 1 and 24).
   *
   * @return the expiration
   */
  public Long expiration() {
    return expiration;
  }

  /**
   * Gets the realmName.
   *
   * The url of the identity provider.
   *
   * @return the realmName
   */
  public String realmName() {
    return realmName;
  }

  /**
   * Gets the conditions.
   *
   * A list of conditions the rule must satisfy.
   *
   * @return the conditions
   */
  public List<RuleConditions> conditions() {
    return conditions;
  }

  /**
   * Gets the name.
   *
   * The name of the rule.
   *
   * @return the name
   */
  public String name() {
    return name;
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

