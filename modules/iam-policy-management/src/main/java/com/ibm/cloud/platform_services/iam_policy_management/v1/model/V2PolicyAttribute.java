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
 * Resource/subject attribute associated with policy attributes.
 */
public class V2PolicyAttribute extends GenericModel {

  protected String key;
  protected String operator;
  protected Object value;

  /**
   * Builder.
   */
  public static class Builder {
    private String key;
    private String operator;
    private Object value;

    /**
     * Instantiates a new Builder from an existing V2PolicyAttribute instance.
     *
     * @param v2PolicyAttribute the instance to initialize the Builder with
     */
    private Builder(V2PolicyAttribute v2PolicyAttribute) {
      this.key = v2PolicyAttribute.key;
      this.operator = v2PolicyAttribute.operator;
      this.value = v2PolicyAttribute.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param key the key
     * @param operator the operator
     * @param value the value
     */
    public Builder(String key, String operator, Object value) {
      this.key = key;
      this.operator = operator;
      this.value = value;
    }

    /**
     * Builds a V2PolicyAttribute.
     *
     * @return the new V2PolicyAttribute instance
     */
    public V2PolicyAttribute build() {
      return new V2PolicyAttribute(this);
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the V2PolicyAttribute builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the V2PolicyAttribute builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the V2PolicyAttribute builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }
  }

  protected V2PolicyAttribute() { }

  protected V2PolicyAttribute(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.key,
      "key cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    key = builder.key;
    operator = builder.operator;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a V2PolicyAttribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the key.
   *
   * The name of an attribute.
   *
   * @return the key
   */
  public String key() {
    return key;
  }

  /**
   * Gets the operator.
   *
   * The operator of an attribute.
   *
   * @return the operator
   */
  public String operator() {
    return operator;
  }

  /**
   * Gets the value.
   *
   * The value of an attribute; can be array, boolean, string, or integer.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }
}

