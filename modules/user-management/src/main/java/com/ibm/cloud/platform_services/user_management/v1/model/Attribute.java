/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An attribute/value pair.
 */
public class Attribute extends GenericModel {

  protected String name;
  protected String value;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String value;

    private Builder(Attribute attribute) {
      this.name = attribute.name;
      this.value = attribute.value;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Attribute.
     *
     * @return the new Attribute instance
     */
    public Attribute build() {
      return new Attribute(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Attribute builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the value.
     *
     * @param value the value
     * @return the Attribute builder
     */
    public Builder value(String value) {
      this.value = value;
      return this;
    }
  }

  protected Attribute(Builder builder) {
    name = builder.name;
    value = builder.value;
  }

  /**
   * New builder.
   *
   * @return a Attribute builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * The name of the attribute.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the value.
   *
   * The value of the attribute.
   *
   * @return the value
   */
  public String value() {
    return value;
  }
}

