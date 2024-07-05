/*
 * (C) Copyright IBM Corp. 2024.
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
 * The resource attributes to which the policy grants access.
 */
public class V2PolicyResource extends GenericModel {

  protected List<V2PolicyResourceAttribute> attributes;
  protected List<V2PolicyResourceTag> tags;

  /**
   * Builder.
   */
  public static class Builder {
    private List<V2PolicyResourceAttribute> attributes;
    private List<V2PolicyResourceTag> tags;

    /**
     * Instantiates a new Builder from an existing V2PolicyResource instance.
     *
     * @param v2PolicyResource the instance to initialize the Builder with
     */
    private Builder(V2PolicyResource v2PolicyResource) {
      this.attributes = v2PolicyResource.attributes;
      this.tags = v2PolicyResource.tags;
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
    public Builder(List<V2PolicyResourceAttribute> attributes) {
      this.attributes = attributes;
    }

    /**
     * Builds a V2PolicyResource.
     *
     * @return the new V2PolicyResource instance
     */
    public V2PolicyResource build() {
      return new V2PolicyResource(this);
    }

    /**
     * Adds a new element to attributes.
     *
     * @param attributes the new element to be added
     * @return the V2PolicyResource builder
     */
    public Builder addAttributes(V2PolicyResourceAttribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<V2PolicyResourceAttribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Adds a new element to tags.
     *
     * @param tags the new element to be added
     * @return the V2PolicyResource builder
     */
    public Builder addTags(V2PolicyResourceTag tags) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(tags,
        "tags cannot be null");
      if (this.tags == null) {
        this.tags = new ArrayList<V2PolicyResourceTag>();
      }
      this.tags.add(tags);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the V2PolicyResource builder
     */
    public Builder attributes(List<V2PolicyResourceAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }

    /**
     * Set the tags.
     * Existing tags will be replaced.
     *
     * @param tags the tags
     * @return the V2PolicyResource builder
     */
    public Builder tags(List<V2PolicyResourceTag> tags) {
      this.tags = tags;
      return this;
    }
  }

  protected V2PolicyResource() { }

  protected V2PolicyResource(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attributes,
      "attributes cannot be null");
    attributes = builder.attributes;
    tags = builder.tags;
  }

  /**
   * New builder.
   *
   * @return a V2PolicyResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * List of resource attributes to which the policy grants access.
   *
   * @return the attributes
   */
  public List<V2PolicyResourceAttribute> attributes() {
    return attributes;
  }

  /**
   * Gets the tags.
   *
   * Optional list of resource tags to which the policy grants access.
   *
   * @return the tags
   */
  public List<V2PolicyResourceTag> tags() {
    return tags;
  }
}

