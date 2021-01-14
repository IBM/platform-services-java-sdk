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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createRules options.
 */
public class CreateRulesOptions extends GenericModel {

  protected List<CreateRuleRequest> rules;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private List<CreateRuleRequest> rules;
    private String transactionId;

    private Builder(CreateRulesOptions createRulesOptions) {
      this.rules = createRulesOptions.rules;
      this.transactionId = createRulesOptions.transactionId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param rules the rules
     */
    public Builder(List<CreateRuleRequest> rules) {
      this.rules = rules;
    }

    /**
     * Builds a CreateRulesOptions.
     *
     * @return the new CreateRulesOptions instance
     */
    public CreateRulesOptions build() {
      return new CreateRulesOptions(this);
    }

    /**
     * Adds an rule to rules.
     *
     * @param rule the new rule
     * @return the CreateRulesOptions builder
     */
    public Builder addRule(CreateRuleRequest rule) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(rule,
        "rule cannot be null");
      if (this.rules == null) {
        this.rules = new ArrayList<CreateRuleRequest>();
      }
      this.rules.add(rule);
      return this;
    }

    /**
     * Set the rules.
     * Existing rules will be replaced.
     *
     * @param rules the rules
     * @return the CreateRulesOptions builder
     */
    public Builder rules(List<CreateRuleRequest> rules) {
      this.rules = rules;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateRulesOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CreateRulesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rules,
      "rules cannot be null");
    rules = builder.rules;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CreateRulesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the rules.
   *
   * A list of rules to be created.
   *
   * @return the rules
   */
  public List<CreateRuleRequest> rules() {
    return rules;
  }

  /**
   * Gets the transactionId.
   *
   * The unique identifier that is used to trace an entire request. If you omit this field, the service generates and
   * sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is set in
   * the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

