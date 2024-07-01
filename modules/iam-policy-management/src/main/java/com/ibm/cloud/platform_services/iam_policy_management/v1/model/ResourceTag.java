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
 * A tag associated with a resource.
 */
public class ResourceTag extends GenericModel {

  protected String name;
  protected String value;
  protected String operator;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;
    private String operator;

    /**
     * Instantiates a new Builder from an existing ResourceTag instance.
     *
     * @param resourceTag the instance to initialize the Builder with
     */
    private Builder(ResourceTag resourceTag) {
      this.name = resourceTag.name;
      this.value = resourceTag.value;
      this.operator = resourceTag.operator;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param name the name
     * @param value the value
     */
    public Builder(String name, String value) {
      this.name = name;
      this.value = value;
    }

    /**
     * Builds a ResourceTag.
     *
     * @return the new ResourceTag instance
     */
    public ResourceTag build() {
      return new ResourceTag(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ResourceTag builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ResourceTag builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the ResourceTag builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }
  }

  protected ResourceTag() { }

  protected ResourceTag(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    name = builder.name;
    value = builder.value;
    operator = builder.operator;
  }

  /**
   * New builder.
   *
   * @return a ResourceTag builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of an access management tag.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The value of an access management tag.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the operator.
   *
   * The operator of an access management tag.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }
}

