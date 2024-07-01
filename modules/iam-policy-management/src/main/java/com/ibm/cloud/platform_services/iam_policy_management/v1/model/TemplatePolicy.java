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
 * The core set of properties associated with the template's policy objet.
 */
public class TemplatePolicy extends GenericModel {

  /**
   * The policy type; either 'access' or 'authorization'.
   */
  public interface Type {
    /** access. */
    String ACCESS = "access";
    /** authorization. */
    String AUTHORIZATION = "authorization";
  }

  protected String type;
  protected String description;
  protected V2PolicyResource resource;
  protected V2PolicySubject subject;
  protected String pattern;
  protected V2PolicyRule rule;
  protected Control control;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String description;
    private V2PolicyResource resource;
    private V2PolicySubject subject;
    private String pattern;
    private V2PolicyRule rule;
    private Control control;

    /**
     * Instantiates a new Builder from an existing TemplatePolicy instance.
     *
     * @param templatePolicy the instance to initialize the Builder with
     */
    private Builder(TemplatePolicy templatePolicy) {
      this.type = templatePolicy.type;
      this.description = templatePolicy.description;
      this.resource = templatePolicy.resource;
      this.subject = templatePolicy.subject;
      this.pattern = templatePolicy.pattern;
      this.rule = templatePolicy.rule;
      this.control = templatePolicy.control;
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
     */
    public Builder(String type) {
      this.type = type;
    }

    /**
     * Builds a TemplatePolicy.
     *
     * @return the new TemplatePolicy instance
     */
    public TemplatePolicy build() {
      return new TemplatePolicy(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the TemplatePolicy builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the TemplatePolicy builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the resource.
     *
     * @param resource the resource
     * @return the TemplatePolicy builder
     */
    public Builder resource(V2PolicyResource resource) {
      this.resource = resource;
      return this;
    }

    /**
     * Set the subject.
     *
     * @param subject the subject
     * @return the TemplatePolicy builder
     */
    public Builder subject(V2PolicySubject subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern
     * @return the TemplatePolicy builder
     */
    public Builder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Set the rule.
     *
     * @param rule the rule
     * @return the TemplatePolicy builder
     */
    public Builder rule(V2PolicyRule rule) {
      this.rule = rule;
      return this;
    }

    /**
     * Set the control.
     *
     * @param control the control
     * @return the TemplatePolicy builder
     */
    public Builder control(Control control) {
      this.control = control;
      return this;
    }
  }

  protected TemplatePolicy() { }

  protected TemplatePolicy(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    type = builder.type;
    description = builder.description;
    resource = builder.resource;
    subject = builder.subject;
    pattern = builder.pattern;
    rule = builder.rule;
    control = builder.control;
  }

  /**
   * New builder.
   *
   * @return a TemplatePolicy builder
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
   * Gets the description.
   *
   * Description of the policy. This is shown in child accounts when an access group or trusted profile template uses
   * the policy template to assign access.
   *
   * @return the description
   */
  public String description() {
    return description;
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
   * Gets the control.
   *
   * Specifies the type of access granted by the policy.
   *
   * @return the control
   */
  public Control control() {
    return control;
  }
}

