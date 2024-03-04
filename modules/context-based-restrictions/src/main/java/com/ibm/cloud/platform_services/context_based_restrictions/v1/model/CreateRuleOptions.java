/*
 * (C) Copyright IBM Corp. 2024.
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

  /**
   * The rule enforcement mode:
   *  * `enabled` - The restrictions are enforced and reported. This is the default.
   *  * `disabled` - The restrictions are disabled. Nothing is enforced or reported.
   *  * `report` - The restrictions are evaluated and reported, but not enforced.
   */
  public interface EnforcementMode {
    /** enabled. */
    String ENABLED = "enabled";
    /** disabled. */
    String DISABLED = "disabled";
    /** report. */
    String REPORT = "report";
  }

  protected String description;
  protected List<RuleContext> contexts;
  protected List<Resource> resources;
  protected NewRuleOperations operations;
  protected String enforcementMode;
  protected String xCorrelationId;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String description;
    private List<RuleContext> contexts;
    private List<Resource> resources;
    private NewRuleOperations operations;
    private String enforcementMode;
    private String xCorrelationId;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CreateRuleOptions instance.
     *
     * @param createRuleOptions the instance to initialize the Builder with
     */
    private Builder(CreateRuleOptions createRuleOptions) {
      this.description = createRuleOptions.description;
      this.contexts = createRuleOptions.contexts;
      this.resources = createRuleOptions.resources;
      this.operations = createRuleOptions.operations;
      this.enforcementMode = createRuleOptions.enforcementMode;
      this.xCorrelationId = createRuleOptions.xCorrelationId;
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
     * Adds a new element to contexts.
     *
     * @param contexts the new element to be added
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
     * Adds a new element to resources.
     *
     * @param resources the new element to be added
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
     * Set the operations.
     *
     * @param operations the operations
     * @return the CreateRuleOptions builder
     */
    public Builder operations(NewRuleOperations operations) {
      this.operations = operations;
      return this;
    }

    /**
     * Set the enforcementMode.
     *
     * @param enforcementMode the enforcementMode
     * @return the CreateRuleOptions builder
     */
    public Builder enforcementMode(String enforcementMode) {
      this.enforcementMode = enforcementMode;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the CreateRuleOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateRuleOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateRuleOptions() { }

  protected CreateRuleOptions(Builder builder) {
    description = builder.description;
    contexts = builder.contexts;
    resources = builder.resources;
    operations = builder.operations;
    enforcementMode = builder.enforcementMode;
    xCorrelationId = builder.xCorrelationId;
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
   * Gets the operations.
   *
   * The operations this rule applies to.
   *
   * @return the operations
   */
  public NewRuleOperations operations() {
    return operations;
  }

  /**
   * Gets the enforcementMode.
   *
   * The rule enforcement mode:
   *  * `enabled` - The restrictions are enforced and reported. This is the default.
   *  * `disabled` - The restrictions are disabled. Nothing is enforced or reported.
   *  * `report` - The restrictions are evaluated and reported, but not enforced.
   *
   * @return the enforcementMode
   */
  public String enforcementMode() {
    return enforcementMode;
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this headers is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the transactionId.
   *
   * The `Transaction-Id` header behaves as the `X-Correlation-Id` header. It is supported for backward compatibility
   * with other IBM platform services that support the `Transaction-Id` header only. If both `X-Correlation-Id` and
   * `Transaction-Id` are provided, `X-Correlation-Id` has the precedence over `Transaction-Id`.
   *
   * @return the transactionId
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String transactionId() {
    return transactionId;
  }
}

