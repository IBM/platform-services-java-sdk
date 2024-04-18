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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The set of properties required for a policy assignment.
 */
public class PolicyAssignmentV1Options extends GenericModel {

  protected PolicyAssignmentV1OptionsRoot root;

  /**
   * Builder.
   */
  public static class Builder {
    private PolicyAssignmentV1OptionsRoot root;

    /**
     * Instantiates a new Builder from an existing PolicyAssignmentV1Options instance.
     *
     * @param policyAssignmentV1Options the instance to initialize the Builder with
     */
    private Builder(PolicyAssignmentV1Options policyAssignmentV1Options) {
      this.root = policyAssignmentV1Options.root;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param root the root
     */
    public Builder(PolicyAssignmentV1OptionsRoot root) {
      this.root = root;
    }

    /**
     * Builds a PolicyAssignmentV1Options.
     *
     * @return the new PolicyAssignmentV1Options instance
     */
    public PolicyAssignmentV1Options build() {
      return new PolicyAssignmentV1Options(this);
    }

    /**
     * Set the root.
     *
     * @param root the root
     * @return the PolicyAssignmentV1Options builder
     */
    public Builder root(PolicyAssignmentV1OptionsRoot root) {
      this.root = root;
      return this;
    }
  }

  protected PolicyAssignmentV1Options() { }

  protected PolicyAssignmentV1Options(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.root,
      "root cannot be null");
    root = builder.root;
  }

  /**
   * New builder.
   *
   * @return a PolicyAssignmentV1Options builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the root.
   *
   * @return the root
   */
  public PolicyAssignmentV1OptionsRoot root() {
    return root;
  }
}

