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
package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * An rule resource.
 */
public class Resource extends GenericModel {

  protected List<ResourceAttribute> attributes;
  protected List<ResourceTagAttribute> tags;

  /**
   * Builder.
   */
  public static class Builder {
    private List<ResourceAttribute> attributes;
    private List<ResourceTagAttribute> tags;

    private Builder(Resource resource) {
      this.attributes = resource.attributes;
      this.tags = resource.tags;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param attributes the attributes
     */
    public Builder(List<ResourceAttribute> attributes) {
      this.attributes = attributes;
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
    public Builder addAttributes(ResourceAttribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<ResourceAttribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Adds an tags to tags.
     *
     * @param tags the new tags
     * @return the Resource builder
     */
    public Builder addTags(ResourceTagAttribute tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<ResourceTagAttribute>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the Resource builder
     */
    public Builder attributes(List<ResourceAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the Resource builder
     */
    public Builder tags(List<ResourceTagAttribute> tags) {
      this.tags = tags;
      return this;
    }
  }

  protected Resource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attributes,
      "attributes cannot be null");
    attributes = builder.attributes;
    tags = builder.tags;
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
   * The resource attributes.
   *
   * @return the attributes
   */
  public List<ResourceAttribute> attributes() {
    return attributes;
  }

  /**
   * Gets the tags.
   *
   * The optional resource tags.
   *
   * @return the tags
   */
  public List<ResourceTagAttribute> tags() {
    return tags;
  }
}

