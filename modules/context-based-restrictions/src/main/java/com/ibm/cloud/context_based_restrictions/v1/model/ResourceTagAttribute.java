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
package com.ibm.cloud.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A rule resource tag attribute.
 */
public class ResourceTagAttribute extends GenericModel {

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

    private Builder(ResourceTagAttribute resourceTagAttribute) {
      this.name = resourceTagAttribute.name;
      this.value = resourceTagAttribute.value;
      this.operator = resourceTagAttribute.operator;
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
     * Builds a ResourceTagAttribute.
     *
     * @return the new ResourceTagAttribute instance
     */
    public ResourceTagAttribute build() {
      return new ResourceTagAttribute(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ResourceTagAttribute builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the ResourceTagAttribute builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the ResourceTagAttribute builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }
  }

  protected ResourceTagAttribute(Builder builder) {
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
   * @return a ResourceTagAttribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The tag attribute name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The tag attribute value.
   *
   * @return the value
   */
  public String value() {
    return value;
  }

  /**
   * Gets the operator.
   *
   * The attribute operator.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }
}

