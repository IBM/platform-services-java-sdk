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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Rule Input component.
 */
public class AssertionsRule extends GenericModel {

  protected String name;
  protected Long expiration;
  @SerializedName("realm_name")
  protected String realmName;
  protected List<Conditions> conditions;
  @SerializedName("action_controls")
  protected RuleActionControls actionControls;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private Long expiration;
    private String realmName;
    private List<Conditions> conditions;
    private RuleActionControls actionControls;

    /**
     * Instantiates a new Builder from an existing AssertionsRule instance.
     *
     * @param assertionsRule the instance to initialize the Builder with
     */
    private Builder(AssertionsRule assertionsRule) {
      this.name = assertionsRule.name;
      this.expiration = assertionsRule.expiration;
      this.realmName = assertionsRule.realmName;
      this.conditions = assertionsRule.conditions;
      this.actionControls = assertionsRule.actionControls;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a AssertionsRule.
     *
     * @return the new AssertionsRule instance
     */
    public AssertionsRule build() {
      return new AssertionsRule(this);
    }

    /**
     * Adds an conditions to conditions.
     *
     * @param conditions the new conditions
     * @return the AssertionsRule builder
     */
    public Builder addConditions(Conditions conditions) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(conditions,
        "conditions cannot be null");
      if (this.conditions == null) {
        this.conditions = new ArrayList<Conditions>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the AssertionsRule builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the expiration.
     *
     * @param expiration the expiration
     * @return the AssertionsRule builder
     */
    public Builder expiration(long expiration) {
      this.expiration = expiration;
      return this;
    }

    /**
     * Set the realmName.
     *
     * @param realmName the realmName
     * @return the AssertionsRule builder
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
     * @return the AssertionsRule builder
     */
    public Builder conditions(List<Conditions> conditions) {
      this.conditions = conditions;
      return this;
    }

    /**
     * Set the actionControls.
     *
     * @param actionControls the actionControls
     * @return the AssertionsRule builder
     */
    public Builder actionControls(RuleActionControls actionControls) {
      this.actionControls = actionControls;
      return this;
    }
  }

  protected AssertionsRule() { }

  protected AssertionsRule(Builder builder) {
    name = builder.name;
    expiration = builder.expiration;
    realmName = builder.realmName;
    conditions = builder.conditions;
    actionControls = builder.actionControls;
  }

  /**
   * New builder.
   *
   * @return a AssertionsRule builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Dynamic rule name.
   *
   * @return the name
   */
  public String name() {
    return name;
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
   * The identity provider (IdP) URL.
   *
   * @return the realmName
   */
  public String realmName() {
    return realmName;
  }

  /**
   * Gets the conditions.
   *
   * Conditions of membership. You can think of this as a key:value pair.
   *
   * @return the conditions
   */
  public List<Conditions> conditions() {
    return conditions;
  }

  /**
   * Gets the actionControls.
   *
   * Control whether or not access group administrators in child accounts can update and remove this dynamic rule in the
   * enterprise-managed access group in their account.This overrides outer level AssertionsActionControls.
   *
   * @return the actionControls
   */
  public RuleActionControls actionControls() {
    return actionControls;
  }
}

