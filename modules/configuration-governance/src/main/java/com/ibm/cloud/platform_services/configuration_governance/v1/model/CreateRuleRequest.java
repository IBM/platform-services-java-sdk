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
 * A rule to be created.
 */
public class CreateRuleRequest extends GenericModel {

  @SerializedName("request_id")
  protected String requestId;
  protected RuleRequest rule;

  /**
   * Builder.
   */
  public static class Builder {
    private String requestId;
    private RuleRequest rule;

    private Builder(CreateRuleRequest createRuleRequest) {
      this.requestId = createRuleRequest.requestId;
      this.rule = createRuleRequest.rule;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param rule the rule
     */
    public Builder(RuleRequest rule) {
      this.rule = rule;
    }

    /**
     * Builds a CreateRuleRequest.
     *
     * @return the new CreateRuleRequest instance
     */
    public CreateRuleRequest build() {
      return new CreateRuleRequest(this);
    }

    /**
     * Set the requestId.
     *
     * @param requestId the requestId
     * @return the CreateRuleRequest builder
     */
    public Builder requestId(String requestId) {
      this.requestId = requestId;
      return this;
    }

    /**
     * Set the rule.
     *
     * @param rule the rule
     * @return the CreateRuleRequest builder
     */
    public Builder rule(RuleRequest rule) {
      this.rule = rule;
      return this;
    }
  }

  protected CreateRuleRequest(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.rule,
      "rule cannot be null");
    requestId = builder.requestId;
    rule = builder.rule;
  }

  /**
   * New builder.
   *
   * @return a CreateRuleRequest builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the requestId.
   *
   * A field that you can use in bulk operations to store a custom identifier for an individual request. If you omit
   * this field, the service generates and sends a `request_id` string for each new rule. The generated string
   * corresponds with the numerical order of the rules request array. For example, `"request_id": "1"`, `"request_id":
   * "2"`.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `request_id` with
   * each request.
   *
   * @return the requestId
   */
  public String requestId() {
    return requestId;
  }

  /**
   * Gets the rule.
   *
   * User-settable properties associated with a rule to be created or updated.
   *
   * @return the rule
   */
  public RuleRequest rule() {
    return rule;
  }
}

