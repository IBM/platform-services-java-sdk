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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The deleteServiceIdGroup options.
 */
public class DeleteServiceIdGroupOptions extends GenericModel {

  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    /**
     * Instantiates a new Builder from an existing DeleteServiceIdGroupOptions instance.
     *
     * @param deleteServiceIdGroupOptions the instance to initialize the Builder with
     */
    private Builder(DeleteServiceIdGroupOptions deleteServiceIdGroupOptions) {
      this.id = deleteServiceIdGroupOptions.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     */
    public Builder(String id) {
      this.id = id;
    }

    /**
     * Builds a DeleteServiceIdGroupOptions.
     *
     * @return the new DeleteServiceIdGroupOptions instance
     */
    public DeleteServiceIdGroupOptions build() {
      return new DeleteServiceIdGroupOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the DeleteServiceIdGroupOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected DeleteServiceIdGroupOptions() { }

  protected DeleteServiceIdGroupOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a DeleteServiceIdGroupOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID of the service ID group.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

