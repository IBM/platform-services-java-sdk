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
package com.ibm.cloud.platform_services.user_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A collection of attribute value pairs.
 */
public class Resource extends GenericModel {

  protected List<Attribute> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Attribute> attributes;

    /**
     * Instantiates a new Builder from an existing Resource instance.
     *
     * @param resource the instance to initialize the Builder with
     */
    private Builder(Resource resource) {
      this.attributes = resource.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Resource.
     *
     * @return the new Resource instance
     */
    public Resource build() {
      return new Resource(this);
    }

    /**
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the Resource builder
     */
    public Builder addAttributes(Attribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<Attribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the Resource builder
     */
    public Builder attributes(List<Attribute> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected Resource() { }

  protected Resource(Builder builder) {
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a Resource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * A list of IAM attributes.
   *
   * @return the attributes
   */
  public List<Attribute> attributes() {
    return attributes;
  }
}

