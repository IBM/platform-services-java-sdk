/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The v2UpdatePolicy options.
 */
public class V2UpdatePolicyOptions extends GenericModel {

  protected String policyId;
  protected String ifMatch;
  protected String type;
  protected V2PolicyBaseControl control;
  protected String description;
  protected V2PolicyBaseSubject subject;
  protected V2PolicyBaseResource resource;
  protected String pattern;
  protected V2PolicyBaseRule rule;

  /**
   * Builder.
   */
  public static class Builder {
    private String policyId;
    private String ifMatch;
    private String type;
    private V2PolicyBaseControl control;
    private String description;
    private V2PolicyBaseSubject subject;
    private V2PolicyBaseResource resource;
    private String pattern;
    private V2PolicyBaseRule rule;

    /**
     * Instantiates a new Builder from an existing V2UpdatePolicyOptions instance.
     *
     * @param v2UpdatePolicyOptions the instance to initialize the Builder with
     */
    private Builder(V2UpdatePolicyOptions v2UpdatePolicyOptions) {
      this.policyId = v2UpdatePolicyOptions.policyId;
      this.ifMatch = v2UpdatePolicyOptions.ifMatch;
      this.type = v2UpdatePolicyOptions.type;
      this.control = v2UpdatePolicyOptions.control;
      this.description = v2UpdatePolicyOptions.description;
      this.subject = v2UpdatePolicyOptions.subject;
      this.resource = v2UpdatePolicyOptions.resource;
      this.pattern = v2UpdatePolicyOptions.pattern;
      this.rule = v2UpdatePolicyOptions.rule;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param policyId the policyId
     * @param ifMatch the ifMatch
     * @param type the type
     * @param control the control
     */
    public Builder(String policyId, String ifMatch, String type, V2PolicyBaseControl control) {
      this.policyId = policyId;
      this.ifMatch = ifMatch;
      this.type = type;
      this.control = control;
    }

    /**
     * Builds a V2UpdatePolicyOptions.
     *
     * @return the new V2UpdatePolicyOptions instance
     */
    public V2UpdatePolicyOptions build() {
      return new V2UpdatePolicyOptions(this);
    }

    /**
     * Set the policyId.
     *
     * @param policyId the policyId
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder policyId(String policyId) {
      this.policyId = policyId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the control.
     *
     * @param control the control
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder control(V2PolicyBaseControl control) {
      this.control = control;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the subject.
     *
     * @param subject the subject
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder subject(V2PolicyBaseSubject subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Set the resource.
     *
     * @param resource the resource
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder resource(V2PolicyBaseResource resource) {
      this.resource = resource;
      return this;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Set the rule.
     *
     * @param rule the rule
     * @return the V2UpdatePolicyOptions builder
     */
    public Builder rule(V2PolicyBaseRule rule) {
      this.rule = rule;
      return this;
    }
  }

  protected V2UpdatePolicyOptions() { }

  protected V2UpdatePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.policyId,
      "policyId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.control,
      "control cannot be null");
    policyId = builder.policyId;
    ifMatch = builder.ifMatch;
    type = builder.type;
    control = builder.control;
    description = builder.description;
    subject = builder.subject;
    resource = builder.resource;
    pattern = builder.pattern;
    rule = builder.rule;
  }

  /**
   * New builder.
   *
   * @return a V2UpdatePolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the policyId.
   *
   * The policy ID.
   *
   * @return the policyId
   */
  public String policyId() {
    return policyId;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a policy and must match the ETag value of the existing policy. The Etag can be
   * retrieved using the GET /v1/policies/{policy_id} API and looking at the ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the type.
   *
   * The policy type; either 'access' or 'authorization'.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the control.
   *
   * Specifies the type of access granted by the policy.
   *
   * @return the control
   */
  public V2PolicyBaseControl control() {
    return control;
  }

  /**
   * Gets the description.
   *
   * Customer-defined description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the subject.
   *
   * The subject attributes associated with a policy.
   *
   * @return the subject
   */
  public V2PolicyBaseSubject subject() {
    return subject;
  }

  /**
   * Gets the resource.
   *
   * The resource attributes associated with a policy.
   *
   * @return the resource
   */
  public V2PolicyBaseResource resource() {
    return resource;
  }

  /**
   * Gets the pattern.
   *
   * Indicates pattern of rule.
   *
   * @return the pattern
   */
  public String pattern() {
    return pattern;
  }

  /**
   * Gets the rule.
   *
   * Additional access conditions associated with a policy.
   *
   * @return the rule
   */
  public V2PolicyBaseRule rule() {
    return rule;
  }
}

