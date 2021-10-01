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
 * The createRule options.
 */
public class CreateRuleOptions extends GenericModel {

  protected String description;
  protected List<RuleContext> contexts;
  protected List<Resource> resources;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RuleContext> contexts;
    private List<Resource> resources;
    private String transactionId;

    private Builder(CreateRuleOptions createRuleOptions) {
      this.description = createRuleOptions.description;
      this.contexts = createRuleOptions.contexts;
      this.resources = createRuleOptions.resources;
      this.transactionId = createRuleOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a CreateRuleOptions.
     *
     * @return the new CreateRuleOptions instance
     */
    public CreateRuleOptions build() {
      return new CreateRuleOptions(this);
    }

    /**
     * Adds an contexts to contexts.
     *
     * @param contexts the new contexts
     * @return the CreateRuleOptions builder
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
     * @return the CreateRuleOptions builder
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
     * Set the description.
     *
     * @param description the description
     * @return the CreateRuleOptions builder
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
     * @return the CreateRuleOptions builder
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
     * @return the CreateRuleOptions builder
     */
    public Builder resources(List<Resource> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateRuleOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateRuleOptions(Builder builder) {
    description = builder.description;
    contexts = builder.contexts;
    resources = builder.resources;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateRuleOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

