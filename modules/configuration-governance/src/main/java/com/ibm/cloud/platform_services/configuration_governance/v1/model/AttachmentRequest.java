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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The scopes to attach to the rule.
 */
public class AttachmentRequest extends GenericModel {

  @SerializedName("account_id")
  protected String accountId;
  @SerializedName("included_scope")
  protected RuleScope includedScope;
  @SerializedName("excluded_scopes")
  protected List<RuleScope> excludedScopes;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private RuleScope includedScope;
    private List<RuleScope> excludedScopes;

    private Builder(AttachmentRequest attachmentRequest) {
      this.accountId = attachmentRequest.accountId;
      this.includedScope = attachmentRequest.includedScope;
      this.excludedScopes = attachmentRequest.excludedScopes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     * @param includedScope the includedScope
     */
    public Builder(String accountId, RuleScope includedScope) {
      this.accountId = accountId;
      this.includedScope = includedScope;
    }

    /**
     * Builds a AttachmentRequest.
     *
     * @return the new AttachmentRequest instance
     */
    public AttachmentRequest build() {
      return new AttachmentRequest(this);
    }

    /**
     * Adds an excludedScope to excludedScopes.
     *
     * @param excludedScope the new excludedScope
     * @return the AttachmentRequest builder
     */
    public Builder addExcludedScope(RuleScope excludedScope) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(excludedScope,
        "excludedScope cannot be null");
      if (this.excludedScopes == null) {
        this.excludedScopes = new ArrayList<RuleScope>();
      }
      this.excludedScopes.add(excludedScope);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the AttachmentRequest builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the includedScope.
     *
     * @param includedScope the includedScope
     * @return the AttachmentRequest builder
     */
    public Builder includedScope(RuleScope includedScope) {
      this.includedScope = includedScope;
      return this;
    }

    /**
     * Set the excludedScopes.
     * Existing excludedScopes will be replaced.
     *
     * @param excludedScopes the excludedScopes
     * @return the AttachmentRequest builder
     */
    public Builder excludedScopes(List<RuleScope> excludedScopes) {
      this.excludedScopes = excludedScopes;
      return this;
    }
  }

  protected AttachmentRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.includedScope,
      "includedScope cannot be null");
    accountId = builder.accountId;
    includedScope = builder.includedScope;
    excludedScopes = builder.excludedScopes;
  }

  /**
   * New builder.
   *
   * @return a AttachmentRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Your IBM Cloud account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the includedScope.
   *
   * The extent at which the rule can be attached across your accounts.
   *
   * @return the includedScope
   */
  public RuleScope includedScope() {
    return includedScope;
  }

  /**
   * Gets the excludedScopes.
   *
   * @return the excludedScopes
   */
  public List<RuleScope> excludedScopes() {
    return excludedScopes;
  }
}

