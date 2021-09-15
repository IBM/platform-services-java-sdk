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
 * The listAvailableServicerefTargets options.
 */
public class ListAvailableServicerefTargetsOptions extends GenericModel {

  /**
   * Specifies the types of services to retrieve.
   */
  public interface Type {
    /** all. */
    String ALL = "all";
    /** platform_service. */
    String PLATFORM_SERVICE = "platform_service";
  }

  protected String type;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;

    private Builder(ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions) {
      this.type = listAvailableServicerefTargetsOptions.type;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListAvailableServicerefTargetsOptions.
     *
     * @return the new ListAvailableServicerefTargetsOptions instance
     */
    public ListAvailableServicerefTargetsOptions build() {
      return new ListAvailableServicerefTargetsOptions(this);
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ListAvailableServicerefTargetsOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }
  }

  protected ListAvailableServicerefTargetsOptions(Builder builder) {
    type = builder.type;
  }

  /**
   * New builder.
   *
   * @return a ListAvailableServicerefTargetsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Specifies the types of services to retrieve.
   *
   * @return the type
   */
  public String type() {
    return type;
  }
}

