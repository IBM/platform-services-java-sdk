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
 * The replaceV2Policy options.
 */
public class ReplaceV2PolicyOptions extends GenericModel {

  /**
   * The policy type; either 'access' or 'authorization'.
   */
  public interface Type {
    /** access. */
    String ACCESS = "access";
    /** authorization. */
    String AUTHORIZATION = "authorization";
  }

  protected String id;
  protected String ifMatch;
  protected Control control;
  protected String type;
  protected String description;
  protected V2PolicySubject subject;
  protected V2PolicyResource resource;
  protected String pattern;
  protected V2PolicyRule rule;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String ifMatch;
    private Control control;
    private String type;
    private String description;
    private V2PolicySubject subject;
    private V2PolicyResource resource;
    private String pattern;
    private V2PolicyRule rule;

    /**
     * Instantiates a new Builder from an existing ReplaceV2PolicyOptions instance.
     *
     * @param replaceV2PolicyOptions the instance to initialize the Builder with
     */
    private Builder(ReplaceV2PolicyOptions replaceV2PolicyOptions) {
      this.id = replaceV2PolicyOptions.id;
      this.ifMatch = replaceV2PolicyOptions.ifMatch;
      this.control = replaceV2PolicyOptions.control;
      this.type = replaceV2PolicyOptions.type;
      this.description = replaceV2PolicyOptions.description;
      this.subject = replaceV2PolicyOptions.subject;
      this.resource = replaceV2PolicyOptions.resource;
      this.pattern = replaceV2PolicyOptions.pattern;
      this.rule = replaceV2PolicyOptions.rule;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     * @param ifMatch the ifMatch
     * @param control the control
     * @param type the type
     */
    public Builder(String id, String ifMatch, Control control, String type) {
      this.id = id;
      this.ifMatch = ifMatch;
      this.control = control;
      this.type = type;
    }

    /**
     * Builds a ReplaceV2PolicyOptions.
     *
     * @return the new ReplaceV2PolicyOptions instance
     */
    public ReplaceV2PolicyOptions build() {
      return new ReplaceV2PolicyOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the control.
     *
     * @param control the control
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder control(Control control) {
      this.control = control;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the subject.
     *
     * @param subject the subject
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder subject(V2PolicySubject subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Set the resource.
     *
     * @param resource the resource
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder resource(V2PolicyResource resource) {
      this.resource = resource;
      return this;
    }

    /**
     * Set the pattern.
     *
     * @param pattern the pattern
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder pattern(String pattern) {
      this.pattern = pattern;
      return this;
    }

    /**
     * Set the rule.
     *
     * @param rule the rule
     * @return the ReplaceV2PolicyOptions builder
     */
    public Builder rule(V2PolicyRule rule) {
      this.rule = rule;
      return this;
    }
  }

  protected ReplaceV2PolicyOptions() { }

  protected ReplaceV2PolicyOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.control,
      "control cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    id = builder.id;
    ifMatch = builder.ifMatch;
    control = builder.control;
    type = builder.type;
    description = builder.description;
    subject = builder.subject;
    resource = builder.resource;
    pattern = builder.pattern;
    rule = builder.rule;
  }

  /**
   * New builder.
   *
   * @return a ReplaceV2PolicyOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The policy ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the ifMatch.
   *
   * The revision number for updating a policy and must match the ETag value of the existing policy. The Etag can be
   * retrieved using the GET /v2/policies/{id} API and looking at the ETag response header.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
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
}

