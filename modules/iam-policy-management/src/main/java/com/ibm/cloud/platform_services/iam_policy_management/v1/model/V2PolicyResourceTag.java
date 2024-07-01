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
public class V2PolicyResourceTag extends GenericModel {

  /**
   * The operator of an access management tag.
   */
  public interface Operator {
    /** stringEquals. */
    String STRINGEQUALS = "stringEquals";
    /** stringMatch. */
    String STRINGMATCH = "stringMatch";
  }

  protected String key;
  protected String value;
  protected String operator;

  /**
   * Builder.
   */
  public static class Builder {
    private String key;
    private String value;
    private String operator;

    /**
     * Instantiates a new Builder from an existing V2PolicyResourceTag instance.
     *
     * @param v2PolicyResourceTag the instance to initialize the Builder with
     */
    private Builder(V2PolicyResourceTag v2PolicyResourceTag) {
      this.key = v2PolicyResourceTag.key;
      this.value = v2PolicyResourceTag.value;
      this.operator = v2PolicyResourceTag.operator;
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
     * @param value the value
     * @param operator the operator
     */
    public Builder(String key, String value, String operator) {
      this.key = key;
      this.value = value;
      this.operator = operator;
    }

    /**
     * Builds a V2PolicyResourceTag.
     *
     * @return the new V2PolicyResourceTag instance
     */
    public V2PolicyResourceTag build() {
      return new V2PolicyResourceTag(this);
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the V2PolicyResourceTag builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the V2PolicyResourceTag builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }

    /**
     * Set the operator.
     *
     * @param operator the operator
     * @return the V2PolicyResourceTag builder
     */
    public Builder operator(String operator) {
      this.operator = operator;
      return this;
    }
  }

  protected V2PolicyResourceTag() { }

  protected V2PolicyResourceTag(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.key,
      "key cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.operator,
      "operator cannot be null");
    key = builder.key;
    value = builder.value;
    operator = builder.operator;
  }

  /**
   * New builder.
   *
   * @return a V2PolicyResourceTag builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the key.
   *
   * The name of an access management tag.
   *
   * @return the key
   */
  public String key() {
    return key;
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

