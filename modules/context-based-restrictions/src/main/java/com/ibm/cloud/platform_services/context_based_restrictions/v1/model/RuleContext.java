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
 * A rule context.
 */
public class RuleContext extends GenericModel {

  protected List<RuleContextAttribute> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<RuleContextAttribute> attributes;

    /**
     * Instantiates a new Builder from an existing RuleContext instance.
     *
     * @param ruleContext the instance to initialize the Builder with
     */
    private Builder(RuleContext ruleContext) {
      this.attributes = ruleContext.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param attributes the attributes
     */
    public Builder(List<RuleContextAttribute> attributes) {
      this.attributes = attributes;
    }

    /**
     * Builds a RuleContext.
     *
     * @return the new RuleContext instance
     */
    public RuleContext build() {
      return new RuleContext(this);
    }

    /**
     * Adds a new element to attributes.
     *
     * @param attributes the new element to be added
     * @return the RuleContext builder
     */
    public Builder addAttributes(RuleContextAttribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<RuleContextAttribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the RuleContext builder
     */
    public Builder attributes(List<RuleContextAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected RuleContext() { }

  protected RuleContext(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attributes,
      "attributes cannot be null");
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a RuleContext builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * The attributes.
   *
   * @return the attributes
   */
  public List<RuleContextAttribute> attributes() {
    return attributes;
  }
}

