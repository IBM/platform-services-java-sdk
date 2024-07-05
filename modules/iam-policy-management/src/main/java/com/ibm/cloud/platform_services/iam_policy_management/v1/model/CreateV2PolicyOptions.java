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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createV2Policy options.
 */
public class CreateV2PolicyOptions extends GenericModel {

  /**
   * The policy type; either 'access' or 'authorization'.
   */
  public interface Type {
    /** access. */
    String ACCESS = "access";
    /** authorization. */
    String AUTHORIZATION = "authorization";
  }

  protected Control control;
  protected String type;
  protected String description;
  protected V2PolicySubject subject;
  protected V2PolicyResource resource;
  protected String pattern;
  protected V2PolicyRule rule;
  protected String acceptLanguage;

  /**
   * Builder.
   */
  public static class Builder {
    private Control control;
    private String type;
    private String description;
    private V2PolicySubject subject;
    private V2PolicyResource resource;
    private String pattern;
    private V2PolicyRule rule;
    private String acceptLanguage;

    /**
     * Instantiates a new Builder from an existing CreateV2PolicyOptions instance.
     *
     * @param createV2PolicyOptions the instance to initialize the Builder with
     */
    private Builder(CreateV2PolicyOptions createV2PolicyOptions) {
      this.control = createV2PolicyOptions.control;
      this.type = createV2PolicyOptions.type;
      this.description = createV2PolicyOptions.description;
      this.subject = createV2PolicyOptions.subject;
      this.resource = createV2PolicyOptions.resource;
      this.pattern = createV2PolicyOptions.pattern;
      this.rule = createV2PolicyOptions.rule;
      this.acceptLanguage = createV2PolicyOptions.acceptLanguage;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param control the control
     * @param type the type
     */
    public Builder(Control control, String type) {
      this.control = control;
      this.type = type;
    }

    /**
     * Builds a CreateV2PolicyOptions.
     *
     * @return the new CreateV2PolicyOptions instance
     */
    public CreateV2PolicyOptions build() {
      return new CreateV2PolicyOptions(this);
    }

    /**
     * Set the control.
     *
     * @param control the control
     * @return the CreateV2PolicyOptions builder
     */
    public Builder control(Control control) {
      this.control = control;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateV2PolicyOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateV2PolicyOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the subject.
     *
     * @param subject the subject
     * @return the CreateV2PolicyOptions builder
     */
    public Builder subject(V2PolicySubject subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Set the resource.
     *
     * @param resource the resource
     * @return the CreateV2PolicyOptions builder
     */
    public Builder resource(V2PolicyResource resource) {
      this.resource = resource;
      return this;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern
     * @return the CreateV2PolicyOptions builder
     */
    public Builder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Set the rule.
     *
     * @param rule the rule
     * @return the CreateV2PolicyOptions builder
     */
    public Builder rule(V2PolicyRule rule) {
      this.rule = rule;
      return this;
    }

    /**
     * Set the acceptLanguage.
     *
     * @param acceptLanguage the acceptLanguage
     * @return the CreateV2PolicyOptions builder
     */
    public Builder acceptLanguage(String acceptLanguage) {
      this.acceptLanguage = acceptLanguage;
      return this;
    }
  }

  protected CreateV2PolicyOptions() { }

  protected CreateV2PolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.control,
      "control cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    control = builder.control;
    type = builder.type;
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
   * @return a CreateV2PolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the control.
   *
   * Specifies the type of access granted by the policy.
   *
   * @return the control
   */
  public Control control() {
    return control;
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
   * Gets the description.
   *
   * Description of the policy.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the subject.
   *
   * The subject attributes for whom the policy grants access.
   *
   * @return the subject
   */
  public V2PolicySubject subject() {
    return subject;
  }

  /**
   * Gets the resource.
   *
   * The resource attributes to which the policy grants access.
   *
   * @return the resource
   */
  public V2PolicyResource resource() {
    return resource;
  }

  /**
   * Gets the pattern.
   *
   * Indicates pattern of rule, either 'time-based-conditions:once', 'time-based-conditions:weekly:all-day', or
   * 'time-based-conditions:weekly:custom-hours'.
   *
   * @return the pattern
   */
  public String pattern() {
    return pattern;
  }

  /**
   * Gets the rule.
   *
   * Additional access conditions associated with the policy.
   *
   * @return the rule
   */
  public V2PolicyRule rule() {
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

