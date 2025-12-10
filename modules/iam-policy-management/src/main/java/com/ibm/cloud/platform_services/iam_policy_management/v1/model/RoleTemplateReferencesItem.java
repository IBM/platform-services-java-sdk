/*
 * (C) Copyright IBM Corp. 2025.
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
 * A role template reference associated with a policy template.
 */
public class RoleTemplateReferencesItem extends GenericModel {

  protected String id;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String version;

    /**
     * Instantiates a new Builder from an existing RoleTemplateReferencesItem instance.
     *
     * @param roleTemplateReferencesItem the instance to initialize the Builder with
     */
    private Builder(RoleTemplateReferencesItem roleTemplateReferencesItem) {
      this.id = roleTemplateReferencesItem.id;
      this.version = roleTemplateReferencesItem.version;
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
     * Builds a RoleTemplateReferencesItem.
     *
     * @return the new RoleTemplateReferencesItem instance
     */
    public RoleTemplateReferencesItem build() {
      return new RoleTemplateReferencesItem(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the RoleTemplateReferencesItem builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the RoleTemplateReferencesItem builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected RoleTemplateReferencesItem() { }

  protected RoleTemplateReferencesItem(Builder builder) {
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
   * @return a RoleTemplateReferencesItem builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * The role template ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Role template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}
