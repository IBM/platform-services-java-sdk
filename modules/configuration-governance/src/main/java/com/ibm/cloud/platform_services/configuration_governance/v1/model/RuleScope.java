/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The extent at which the rule can be attached across your accounts.
 */
public class RuleScope extends GenericModel {

  /**
   * The type of scope that you want to evaluate.
   */
  public interface ScopeType {
    /** enterprise. */
    String ENTERPRISE = "enterprise";
    /** enterprise.account_group. */
    String ENTERPRISE_ACCOUNT_GROUP = "enterprise.account_group";
    /** enterprise.account. */
    String ENTERPRISE_ACCOUNT = "enterprise.account";
    /** account. */
    String ACCOUNT = "account";
    /** account.resource_group. */
    String ACCOUNT_RESOURCE_GROUP = "account.resource_group";
  }

  protected String note;
  @SerializedName("scope_id")
  protected String scopeId;
  @SerializedName("scope_type")
  protected String scopeType;

  /**
   * Builder.
   */
  public static class Builder {
    private String note;
    private String scopeId;
    private String scopeType;

    private Builder(RuleScope ruleScope) {
      this.note = ruleScope.note;
      this.scopeId = ruleScope.scopeId;
      this.scopeType = ruleScope.scopeType;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param scopeId the scopeId
     * @param scopeType the scopeType
     */
    public Builder(String scopeId, String scopeType) {
      this.scopeId = scopeId;
      this.scopeType = scopeType;
    }

    /**
     * Builds a RuleScope.
     *
     * @return the new RuleScope instance
     */
    public RuleScope build() {
      return new RuleScope(this);
    }

    /**
     * Set the note.
     *
     * @param note the note
     * @return the RuleScope builder
     */
    public Builder note(String note) {
      this.note = note;
      return this;
    }

    /**
     * Set the scopeId.
     *
     * @param scopeId the scopeId
     * @return the RuleScope builder
     */
    public Builder scopeId(String scopeId) {
      this.scopeId = scopeId;
      return this;
    }

    /**
     * Set the scopeType.
     *
     * @param scopeType the scopeType
     * @return the RuleScope builder
     */
    public Builder scopeType(String scopeType) {
      this.scopeType = scopeType;
      return this;
    }
  }

  protected RuleScope(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.scopeId,
      "scopeId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.scopeType,
      "scopeType cannot be null");
    note = builder.note;
    scopeId = builder.scopeId;
    scopeType = builder.scopeType;
  }

  /**
   * New builder.
   *
   * @return a RuleScope builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the note.
   *
   * A short description or alias to assign to the scope.
   *
   * @return the note
   */
  public String note() {
    return note;
  }

  /**
   * Gets the scopeId.
   *
   * The ID of the scope, such as an enterprise, account, or account group, that you want to evaluate.
   *
   * @return the scopeId
   */
  public String scopeId() {
    return scopeId;
  }

  /**
   * Gets the scopeType.
   *
   * The type of scope that you want to evaluate.
   *
   * @return the scopeType
   */
  public String scopeType() {
    return scopeType;
  }
}

