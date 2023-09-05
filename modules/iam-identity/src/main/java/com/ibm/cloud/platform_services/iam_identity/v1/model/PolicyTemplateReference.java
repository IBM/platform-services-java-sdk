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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Metadata for external access policy.
 */
public class PolicyTemplateReference extends GenericModel {

  protected String id;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String version;

    /**
     * Instantiates a new Builder from an existing PolicyTemplateReference instance.
     *
     * @param policyTemplateReference the instance to initialize the Builder with
     */
    private Builder(PolicyTemplateReference policyTemplateReference) {
      this.id = policyTemplateReference.id;
      this.version = policyTemplateReference.version;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     * @param version the version
     */
    public Builder(String id, String version) {
      this.id = id;
      this.version = version;
    }

    /**
     * Builds a PolicyTemplateReference.
     *
     * @return the new PolicyTemplateReference instance
     */
    public PolicyTemplateReference build() {
      return new PolicyTemplateReference(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the PolicyTemplateReference builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the PolicyTemplateReference builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected PolicyTemplateReference() { }

  protected PolicyTemplateReference(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.id,
      "id cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.version,
      "version cannot be null");
    id = builder.id;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a PolicyTemplateReference builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * ID of Access Policy Template.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Version of Access Policy Template.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}

