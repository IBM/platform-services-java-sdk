/*
 * (C) Copyright IBM Corp. 2022.
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
package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getResourceInstance options.
 */
public class GetResourceInstanceOptions extends GenericModel {

  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;

    /**
     * Instantiates a new Builder from an existing GetResourceInstanceOptions instance.
     *
     * @param getResourceInstanceOptions the instance to initialize the Builder with
     */
    private Builder(GetResourceInstanceOptions getResourceInstanceOptions) {
      this.id = getResourceInstanceOptions.id;
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
     * Builds a GetResourceInstanceOptions.
     *
     * @return the new GetResourceInstanceOptions instance
     */
    public GetResourceInstanceOptions build() {
      return new GetResourceInstanceOptions(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetResourceInstanceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected GetResourceInstanceOptions() { }

  protected GetResourceInstanceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a GetResourceInstanceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The resource instance URL-encoded CRN or GUID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

