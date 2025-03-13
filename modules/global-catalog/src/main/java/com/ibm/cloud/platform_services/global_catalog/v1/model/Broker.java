/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The broker associated with a catalog entry.
 */
public class Broker extends GenericModel {

  protected String name;
  protected String guid;

  /**
   * Builder.
   */
  public static class Builder {
    private String name;
    private String guid;

    /**
     * Instantiates a new Builder from an existing Broker instance.
     *
     * @param broker the instance to initialize the Builder with
     */
    private Builder(Broker broker) {
      this.name = broker.name;
      this.guid = broker.guid;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Broker.
     *
     * @return the new Broker instance
     */
    public Broker build() {
      return new Broker(this);
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the Broker builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the guid.
     *
     * @param guid the guid
     * @return the Broker builder
     */
    public Builder guid(String guid) {
      this.guid = guid;
      return this;
    }
  }

  protected Broker() { }

  protected Broker(Builder builder) {
    name = builder.name;
    guid = builder.guid;
  }

  /**
   * New builder.
   *
   * @return a Broker builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the name.
   *
   * Broker name.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the guid.
   *
   * Broker guid.
   *
   * @return the guid
   */
  public String guid() {
    return guid;
  }
}

