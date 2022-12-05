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
 * The v2CreatePolicy options.
 */
public class V2CreatePolicyOptions extends GenericModel {

  protected String type;
  protected V2PolicyBaseControl control;
  protected String description;
  protected V2PolicyBaseSubject subject;
  protected V2PolicyBaseResource resource;
  protected String pattern;
  protected V2PolicyBaseRule rule;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private V2PolicyBaseControl control;
    private String description;
    private V2PolicyBaseSubject subject;
    private V2PolicyBaseResource resource;
    private String pattern;
    private V2PolicyBaseRule rule;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing V2CreatePolicyOptions instance.
     *
     * @param v2CreatePolicyOptions the instance to initialize the Builder with
     */
    private Builder(V2CreatePolicyOptions v2CreatePolicyOptions) {
      this.type = v2CreatePolicyOptions.type;
      this.control = v2CreatePolicyOptions.control;
      this.description = v2CreatePolicyOptions.description;
      this.subject = v2CreatePolicyOptions.subject;
      this.resource = v2CreatePolicyOptions.resource;
      this.pattern = v2CreatePolicyOptions.pattern;
      this.rule = v2CreatePolicyOptions.rule;
      this.acceptLanguage = v2CreatePolicyOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param control the control
     */
    public Builder(String type, V2PolicyBaseControl control) {
      this.type = type;
      this.control = control;
    }

    /**
     * Builds a V2CreatePolicyOptions.
     *
     * @return the new V2CreatePolicyOptions instance
     */
    public V2CreatePolicyOptions build() {
      return new V2CreatePolicyOptions(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the V2CreatePolicyOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the control.
     *
     * @param control the control
     * @return the V2CreatePolicyOptions builder
     */
    public Builder control(V2PolicyBaseControl control) {
      this.control = control;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the V2CreatePolicyOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the subject.
     *
     * @param subject the subject
     * @return the V2CreatePolicyOptions builder
     */
    public Builder subject(V2PolicyBaseSubject subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Set the resource.
     *
     * @param resource the resource
     * @return the V2CreatePolicyOptions builder
     */
    public Builder resource(V2PolicyBaseResource resource) {
      this.resource = resource;
      return this;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern
     * @return the V2CreatePolicyOptions builder
     */
    public Builder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Set the rule.
     *
     * @param rule the rule
     * @return the V2CreatePolicyOptions builder
     */
    public Builder rule(V2PolicyBaseRule rule) {
      this.rule = rule;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the V2CreatePolicyOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected V2CreatePolicyOptions() { }

  protected V2CreatePolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.control,
      "control cannot be null");
    type = builder.type;
    control = builder.control;
    description = builder.description;
    subject = builder.subject;
    resource = builder.resource;
    pattern = builder.pattern;
    rule = builder.rule;
    acceptLanguage = builder.acceptLanguage;
  }

  /**
   * New builder.
   *
   * @return a V2CreatePolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
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

  /**
   * Gets the acceptLanguage.
   *
   * Language code for translations
   * * `default` - English
   * * `de` -  German (Standard)
   * * `en` - English
   * * `es` - Spanish (Spain)
   * * `fr` - French (Standard)
   * * `it` - Italian (Standard)
   * * `ja` - Japanese
   * * `ko` - Korean
   * * `pt-br` - Portuguese (Brazil)
   * * `zh-cn` - Chinese (Simplified, PRC)
   * * `zh-tw` - (Chinese, Taiwan).
   *
   * @return the acceptLanguage
   */
  public String acceptLanguage() {
    return acceptLanguage;
  }
}

