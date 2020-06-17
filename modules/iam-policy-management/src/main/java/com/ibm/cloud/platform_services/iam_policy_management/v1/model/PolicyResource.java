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
package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The attributes of the resource. Note that only one resource is allowed in a policy.
 */
public class PolicyResource extends GenericModel {

  protected List<ResourceAttribute> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<ResourceAttribute> attributes;

    private Builder(PolicyResource policyResource) {
      this.attributes = policyResource.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PolicyResource.
     *
     * @return the new PolicyResource instance
     */
    public PolicyResource build() {
      return new PolicyResource(this);
    }

    /**
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the PolicyResource builder
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
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the PolicyResource builder
     */
    public Builder attributes(List<ResourceAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected PolicyResource(Builder builder) {
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a PolicyResource builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * List of resource attributes.
   *
   * @return the attributes
   */
  public List<ResourceAttribute> attributes() {
    return attributes;
  }
}

