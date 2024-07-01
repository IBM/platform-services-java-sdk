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
 * The subject attributes for whom the policy grants access.
 */
public class V2PolicySubject extends GenericModel {

  protected List<V2PolicySubjectAttribute> attributes;

  /**
   * Builder.
   */
  public static class Builder {
    private List<V2PolicySubjectAttribute> attributes;

    /**
     * Instantiates a new Builder from an existing V2PolicySubject instance.
     *
     * @param v2PolicySubject the instance to initialize the Builder with
     */
    private Builder(V2PolicySubject v2PolicySubject) {
      this.attributes = v2PolicySubject.attributes;
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
    public Builder(List<V2PolicySubjectAttribute> attributes) {
      this.attributes = attributes;
    }

    /**
     * Builds a V2PolicySubject.
     *
     * @return the new V2PolicySubject instance
     */
    public V2PolicySubject build() {
      return new V2PolicySubject(this);
    }

    /**
     * Adds a new element to attributes.
     *
     * @param attributes the new element to be added
     * @return the V2PolicySubject builder
     */
    public Builder addAttributes(V2PolicySubjectAttribute attributes) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attributes,
        "attributes cannot be null");
      if (this.attributes == null) {
        this.attributes = new ArrayList<V2PolicySubjectAttribute>();
      }
      this.attributes.add(attributes);
      return this;
    }

    /**
     * Set the attributes.
     * Existing attributes will be replaced.
     *
     * @param attributes the attributes
     * @return the V2PolicySubject builder
     */
    public Builder attributes(List<V2PolicySubjectAttribute> attributes) {
      this.attributes = attributes;
      return this;
    }
  }

  protected V2PolicySubject() { }

  protected V2PolicySubject(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attributes,
      "attributes cannot be null");
    attributes = builder.attributes;
  }

  /**
   * New builder.
   *
   * @return a V2PolicySubject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the attributes.
   *
   * List of subject attributes associated with policy/.
   *
   * @return the attributes
   */
  public List<V2PolicySubjectAttribute> attributes() {
    return attributes;
  }
}

