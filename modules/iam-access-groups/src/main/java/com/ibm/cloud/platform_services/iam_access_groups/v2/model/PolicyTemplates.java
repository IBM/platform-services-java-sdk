/*
 * (C) Copyright IBM Corp. 2023.
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
package com.ibm.cloud.platform_services.iam_access_groups.v2.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Policy Templates Input component.
 */
public class PolicyTemplates extends GenericModel {

  protected String id;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String version;

    /**
     * Instantiates a new Builder from an existing PolicyTemplates instance.
     *
     * @param policyTemplates the instance to initialize the Builder with
     */
    private Builder(PolicyTemplates policyTemplates) {
      this.id = policyTemplates.id;
      this.version = policyTemplates.version;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PolicyTemplates.
     *
     * @return the new PolicyTemplates instance
     */
    public PolicyTemplates build() {
      return new PolicyTemplates(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the PolicyTemplates builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the PolicyTemplates builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected PolicyTemplates() { }

  protected PolicyTemplates(Builder builder) {
    id = builder.id;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a PolicyTemplates builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Policy template ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Policy template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}

