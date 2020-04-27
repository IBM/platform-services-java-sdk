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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Environment variables for the template.
 */
public class ObjectMetadataBaseTemplateEnvironmentVariables extends GenericModel {

  @SerializedName("_key_")
  protected String key;

  /**
   * Builder.
   */
  public static class Builder {
    private String key;

    private Builder(ObjectMetadataBaseTemplateEnvironmentVariables objectMetadataBaseTemplateEnvironmentVariables) {
      this.key = objectMetadataBaseTemplateEnvironmentVariables.key;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ObjectMetadataBaseTemplateEnvironmentVariables.
     *
     * @return the new ObjectMetadataBaseTemplateEnvironmentVariables instance
     */
    public ObjectMetadataBaseTemplateEnvironmentVariables build() {
      return new ObjectMetadataBaseTemplateEnvironmentVariables(this);
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the ObjectMetadataBaseTemplateEnvironmentVariables builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }
  }

  protected ObjectMetadataBaseTemplateEnvironmentVariables(Builder builder) {
    key = builder.key;
  }

  /**
   * New builder.
   *
   * @return a ObjectMetadataBaseTemplateEnvironmentVariables builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the key.
   *
   * Key is the editable first string in a key:value pair of environment variables.
   *
   * @return the key
   */
  public String key() {
    return key;
  }
}

