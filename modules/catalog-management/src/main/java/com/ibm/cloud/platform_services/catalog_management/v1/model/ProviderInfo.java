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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information on the provider for this offering, or omitted if no provider information is given.
 */
public class ProviderInfo extends GenericModel {

  protected String id;
  protected String name;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String name;

    private Builder(ProviderInfo providerInfo) {
      this.id = providerInfo.id;
      this.name = providerInfo.name;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ProviderInfo.
     *
     * @return the new ProviderInfo instance
     */
    public ProviderInfo build() {
      return new ProviderInfo(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ProviderInfo builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the ProviderInfo builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }
  }

  protected ProviderInfo(Builder builder) {
    id = builder.id;
    name = builder.name;
  }

  /**
   * New builder.
   *
   * @return a ProviderInfo builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The id of this provider.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the name.
   *
   * The name of this provider.
   *
   * @return the name
   */
  public String name() {
    return name;
  }
}

