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
 * PolicyAssignmentV1OptionsRootTemplate.
 */
public class PolicyAssignmentV1OptionsRootTemplate extends GenericModel {

  protected String id;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String version;

    /**
     * Instantiates a new Builder from an existing PolicyAssignmentV1OptionsRootTemplate instance.
     *
     * @param policyAssignmentV1OptionsRootTemplate the instance to initialize the Builder with
     */
    private Builder(PolicyAssignmentV1OptionsRootTemplate policyAssignmentV1OptionsRootTemplate) {
      this.id = policyAssignmentV1OptionsRootTemplate.id;
      this.version = policyAssignmentV1OptionsRootTemplate.version;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PolicyAssignmentV1OptionsRootTemplate.
     *
     * @return the new PolicyAssignmentV1OptionsRootTemplate instance
     */
    public PolicyAssignmentV1OptionsRootTemplate build() {
      return new PolicyAssignmentV1OptionsRootTemplate(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the PolicyAssignmentV1OptionsRootTemplate builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the PolicyAssignmentV1OptionsRootTemplate builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected PolicyAssignmentV1OptionsRootTemplate() { }

  protected PolicyAssignmentV1OptionsRootTemplate(Builder builder) {
    id = builder.id;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a PolicyAssignmentV1OptionsRootTemplate builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The template id where this policy is being assigned from.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the version.
   *
   * The template version where this policy is being assigned from.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}

