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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The replaceRule options.
 */
public class ReplaceRuleOptions extends GenericModel {

  protected String ruleId;
  protected String ifMatch;
  protected String description;
  protected List<RuleContext> contexts;
  protected List<Resource> resources;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String ifMatch;
    private String description;
    private List<RuleContext> contexts;
    private List<Resource> resources;
    private String transactionId;

    private Builder(ReplaceRuleOptions replaceRuleOptions) {
      this.ruleId = replaceRuleOptions.ruleId;
      this.ifMatch = replaceRuleOptions.ifMatch;
      this.description = replaceRuleOptions.description;
      this.contexts = replaceRuleOptions.contexts;
      this.resources = replaceRuleOptions.resources;
      this.transactionId = replaceRuleOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     * @param ifMatch the ifMatch
     */
    public Builder(String ruleId, String ifMatch) {
      this.ruleId = ruleId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a ReplaceRuleOptions.
     *
     * @return the new ReplaceRuleOptions instance
     */
    public ReplaceRuleOptions build() {
      return new ReplaceRuleOptions(this);
    }

    /**
     * Adds an contexts to contexts.
     *
     * @param contexts the new contexts
     * @return the ReplaceRuleOptions builder
     */
    public Builder addContexts(RuleContext contexts) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(contexts,
        "contexts cannot be null");
      if (this.contexts == null) {
        this.contexts = new ArrayList<RuleContext>();
      }
      this.contexts.add(contexts);
      return this;
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the ReplaceRuleOptions builder
     */
    public Builder addResources(Resource resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<Resource>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the ReplaceRuleOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceRuleOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceRuleOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the contexts.
     * Existing contexts will be replaced.
     *
     * @param contexts the contexts
     * @return the ReplaceRuleOptions builder
     */
    public Builder contexts(List<RuleContext> contexts) {
      this.contexts = contexts;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the ReplaceRuleOptions builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ReplaceRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected ReplaceRuleOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    ruleId = builder.ruleId;
    ifMatch = builder.ifMatch;
    description = builder.description;
    contexts = builder.contexts;
    resources = builder.resources;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a ReplaceRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ruleId.
   *
   * The ID of a rule.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the ifMatch.
   *
   * The current revision of the resource being updated. This can be found in the Create/Get/Update resource response
   * ETag header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the description.
   *
   * The description of the rule.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the contexts.
   *
   * The contexts this rule applies to.
   *
   * @return the contexts
   */
  public List<RuleContext> contexts() {
    return contexts;
  }

  /**
   * Gets the resources.
   *
   * The resources this rule apply to.
   *
   * @return the resources
   */
  public List<Resource> resources() {
    return resources;
  }

  /**
   * Gets the transactionId.
   *
   * The UUID that is used to correlate and track transactions. If you omit this field, the service generates and sends
   * a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

