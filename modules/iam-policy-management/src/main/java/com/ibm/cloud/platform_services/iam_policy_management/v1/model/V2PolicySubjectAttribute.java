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
 * Subject attribute for whom the policy grants access.
 */
public class V2PolicySubjectAttribute extends GenericModel {

  /**
   * The operator of an attribute.
   */
  public interface Operator {
    /** stringEquals. */
    String STRINGEQUALS = "stringEquals";
    /** stringExists. */
    String STRINGEXISTS = "stringExists";
  }

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
     * Instantiates a new Builder from an existing V2PolicySubjectAttribute instance.
     *
     * @param v2PolicySubjectAttribute the instance to initialize the Builder with
     */
    private Builder(V2PolicySubjectAttribute v2PolicySubjectAttribute) {
      this.key = v2PolicySubjectAttribute.key;
      this.operator = v2PolicySubjectAttribute.operator;
      this.value = v2PolicySubjectAttribute.value;
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
     * Builds a V2PolicySubjectAttribute.
     *
     * @return the new V2PolicySubjectAttribute instance
     */
    public V2PolicySubjectAttribute build() {
      return new V2PolicySubjectAttribute(this);
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the V2PolicySubjectAttribute builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the V2PolicySubjectAttribute builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the V2PolicySubjectAttribute builder
     */
    public Builder value(Object value) {
      this.value = value;
      return this;
    }
  }

  protected V2PolicySubjectAttribute() { }

  protected V2PolicySubjectAttribute(Builder builder) {
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
   * @return a V2PolicySubjectAttribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the key.
   *
   * The name of a subject attribute, e.g., iam_id, access_group_id.
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
   * The value of a rule, resource, or subject attribute; can be boolean or string for resource and subject attribute.
   * Can be string or an array of strings (e.g., array of days to permit access) for rule attribute.
   *
   * @return the value
   */
  public Object value() {
    return value;
  }
}

