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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The resource attributes associated with a policy.
 */
public class V2PolicyBaseResource extends GenericModel {

  protected List<V2PolicyAttribute> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<V2PolicyAttribute> attributes;

    /**
     * Instantiates a new Builder from an existing V2PolicyBaseResource instance.
     *
     * @param v2PolicyBaseResource the instance to initialize the Builder with
     */
    private Builder(V2PolicyBaseResource v2PolicyBaseResource) {
      this.attributes = v2PolicyBaseResource.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a V2PolicyBaseResource.
     *
     * @return the new V2PolicyBaseResource instance
     */
    public V2PolicyBaseResource build() {
      return new V2PolicyBaseResource(this);
    }

    /**
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the V2PolicyBaseResource builder
     */
    public Builder addAttributes(V2PolicyAttribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<V2PolicyAttribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the V2PolicyBaseResource builder
     */
    public Builder attributes(List<V2PolicyAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected V2PolicyBaseResource() { }

  protected V2PolicyBaseResource(Builder builder) {
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a V2PolicyBaseResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * List of resource attributes associated with policy/.
   *
   * @return the attributes
   */
  public List<V2PolicyAttribute> attributes() {
    return attributes;
  }
}

