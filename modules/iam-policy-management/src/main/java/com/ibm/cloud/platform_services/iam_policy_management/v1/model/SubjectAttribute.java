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
 * An attribute associated with a subject.
 */
public class SubjectAttribute extends GenericModel {

  protected String name;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;

    /**
     * Instantiates a new Builder from an existing SubjectAttribute instance.
     *
     * @param subjectAttribute the instance to initialize the Builder with
     */
    private Builder(SubjectAttribute subjectAttribute) {
      this.name = subjectAttribute.name;
      this.value = subjectAttribute.value;
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
     * Builds a SubjectAttribute.
     *
     * @return the new SubjectAttribute instance
     */
    public SubjectAttribute build() {
      return new SubjectAttribute(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the SubjectAttribute builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the SubjectAttribute builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected SubjectAttribute() { }

  protected SubjectAttribute(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.name,
      "name cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.value,
      "value cannot be null");
    name = builder.name;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a SubjectAttribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of an attribute.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The value of an attribute.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

