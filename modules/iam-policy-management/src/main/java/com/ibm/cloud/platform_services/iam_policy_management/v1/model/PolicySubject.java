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
 * The subject attribute values that must match in order for this policy to apply in a permission decision.
 */
public class PolicySubject extends GenericModel {

  protected List<SubjectAttribute> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<SubjectAttribute> attributes;

    /**
     * Instantiates a new Builder from an existing PolicySubject instance.
     *
     * @param policySubject the instance to initialize the Builder with
     */
    private Builder(PolicySubject policySubject) {
      this.attributes = policySubject.attributes;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PolicySubject.
     *
     * @return the new PolicySubject instance
     */
    public PolicySubject build() {
      return new PolicySubject(this);
    }

    /**
     * Adds a new element to attributes.
     *
     * @param attributes the new element to be added
     * @return the PolicySubject builder
     */
    public Builder addAttributes(SubjectAttribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<SubjectAttribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the PolicySubject builder
     */
    public Builder attributes(List<SubjectAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected PolicySubject() { }

  protected PolicySubject(Builder builder) {
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a PolicySubject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * List of subject attributes.
   *
   * @return the attributes
   */
  public List<SubjectAttribute> attributes() {
    return attributes;
  }
}

