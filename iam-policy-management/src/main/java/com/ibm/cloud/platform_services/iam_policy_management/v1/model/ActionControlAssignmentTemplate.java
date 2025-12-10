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
 * The action control template id and version that will be assigned.
 */
public class ActionControlAssignmentTemplate extends GenericModel {

  protected String id;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String version;

    /**
     * Instantiates a new Builder from an existing ActionControlAssignmentTemplate instance.
     *
     * @param actionControlAssignmentTemplate the instance to initialize the Builder with
     */
    private Builder(ActionControlAssignmentTemplate actionControlAssignmentTemplate) {
      this.id = actionControlAssignmentTemplate.id;
      this.version = actionControlAssignmentTemplate.version;
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
     * Builds a ActionControlAssignmentTemplate.
     *
     * @return the new ActionControlAssignmentTemplate instance
     */
    public ActionControlAssignmentTemplate build() {
      return new ActionControlAssignmentTemplate(this);
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ActionControlAssignmentTemplate builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the ActionControlAssignmentTemplate builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected ActionControlAssignmentTemplate() { }

  protected ActionControlAssignmentTemplate(Builder builder) {
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
   * @return a ActionControlAssignmentTemplate builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Action control template ID.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the version.
   *
   * Action control template version.
   *
   * @return the version
   */
  public String version() {
    return version;
  }
}

