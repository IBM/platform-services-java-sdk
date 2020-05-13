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
 * PolicyRequestResourcesItem.
 */
public class PolicyRequestResourcesItem extends GenericModel {

  protected List<PolicyRequestResourcesItemAttributesItem> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<PolicyRequestResourcesItemAttributesItem> attributes;

    private Builder(PolicyRequestResourcesItem policyRequestResourcesItem) {
      this.attributes = policyRequestResourcesItem.attributes;
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
    public Builder(List<PolicyRequestResourcesItemAttributesItem> attributes) {
      this.attributes = attributes;
    }

    /**
     * Builds a PolicyRequestResourcesItem.
     *
     * @return the new PolicyRequestResourcesItem instance
     */
    public PolicyRequestResourcesItem build() {
      return new PolicyRequestResourcesItem(this);
    }

    /**
     * Adds an attributes to attributes.
     *
     * @param attributes the new attributes
     * @return the PolicyRequestResourcesItem builder
     */
    public Builder addAttributes(PolicyRequestResourcesItemAttributesItem attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<PolicyRequestResourcesItemAttributesItem>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the PolicyRequestResourcesItem builder
     */
    public Builder attributes(List<PolicyRequestResourcesItemAttributesItem> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected PolicyRequestResourcesItem(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attributes,
      "attributes cannot be null");
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a PolicyRequestResourcesItem builder
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
  public List<PolicyRequestResourcesItemAttributesItem> attributes() {
    return attributes;
  }
}

