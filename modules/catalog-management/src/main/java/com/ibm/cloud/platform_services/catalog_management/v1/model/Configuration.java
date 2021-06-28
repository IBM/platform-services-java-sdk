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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration description.
 */
public class Configuration extends GenericModel {

  protected String key;
  protected String type;
  @SerializedName("default_value")
  protected Object defaultValue;
  @SerializedName("value_constraint")
  protected String valueConstraint;
  protected String description;
  protected Boolean required;
  protected List<Object> options;
  protected Boolean hidden;

  /**
   * Builder.
   */
  public static class Builder {
    private String key;
    private String type;
    private Object defaultValue;
    private String valueConstraint;
    private String description;
    private Boolean required;
    private List<Object> options;
    private Boolean hidden;

    private Builder(Configuration configuration) {
      this.key = configuration.key;
      this.type = configuration.type;
      this.defaultValue = configuration.defaultValue;
      this.valueConstraint = configuration.valueConstraint;
      this.description = configuration.description;
      this.required = configuration.required;
      this.options = configuration.options;
      this.hidden = configuration.hidden;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Configuration.
     *
     * @return the new Configuration instance
     */
    public Configuration build() {
      return new Configuration(this);
    }

    /**
     * Adds an options to options.
     *
     * @param options the new options
     * @return the Configuration builder
     */
    public Builder addOptions(Object options) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(options,
        "options cannot be null");
      if (this.options == null) {
        this.options = new ArrayList<Object>();
      }
      this.options.add(options);
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the Configuration builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the Configuration builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the defaultValue.
     *
     * @param defaultValue the defaultValue
     * @return the Configuration builder
     */
    public Builder defaultValue(Object defaultValue) {
      this.defaultValue = defaultValue;
      return this;
    }

    /**
     * Set the valueConstraint.
     *
     * @param valueConstraint the valueConstraint
     * @return the Configuration builder
     */
    public Builder valueConstraint(String valueConstraint) {
      this.valueConstraint = valueConstraint;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the Configuration builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the required.
     *
     * @param required the required
     * @return the Configuration builder
     */
    public Builder required(Boolean required) {
      this.required = required;
      return this;
    }

    /**
     * Set the options.
     * Existing options will be replaced.
     *
     * @param options the options
     * @return the Configuration builder
     */
    public Builder options(List<Object> options) {
      this.options = options;
      return this;
    }

    /**
     * Set the hidden.
     *
     * @param hidden the hidden
     * @return the Configuration builder
     */
    public Builder hidden(Boolean hidden) {
      this.hidden = hidden;
      return this;
    }
  }

  protected Configuration(Builder builder) {
    key = builder.key;
    type = builder.type;
    defaultValue = builder.defaultValue;
    valueConstraint = builder.valueConstraint;
    description = builder.description;
    required = builder.required;
    options = builder.options;
    hidden = builder.hidden;
  }

  /**
   * New builder.
   *
   * @return a Configuration builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the key.
   *
   * Configuration key.
   *
   * @return the key
   */
  public String key() {
    return key;
  }

  /**
   * Gets the type.
   *
   * Value type (string, boolean, int).
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the defaultValue.
   *
   * The default value.  To use a secret when the type is password, specify a JSON encoded value of
   * $ref:#/components/schemas/SecretInstance, prefixed with `cmsm_v1:`.
   *
   * @return the defaultValue
   */
  public Object defaultValue() {
    return defaultValue;
  }

  /**
   * Gets the valueConstraint.
   *
   * Constraint associated with value, e.g., for string type - regx:[a-z].
   *
   * @return the valueConstraint
   */
  public String valueConstraint() {
    return valueConstraint;
  }

  /**
   * Gets the description.
   *
   * Key description.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the required.
   *
   * Is key required to install.
   *
   * @return the required
   */
  public Boolean required() {
    return required;
  }

  /**
   * Gets the options.
   *
   * List of options of type.
   *
   * @return the options
   */
  public List<Object> options() {
    return options;
  }

  /**
   * Gets the hidden.
   *
   * Hide values.
   *
   * @return the hidden
   */
  public Boolean hidden() {
    return hidden;
  }
}

