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
 * The getActionControlTemplateVersion options.
 */
public class GetActionControlTemplateVersionOptions extends GenericModel {

  protected String actionControlTemplateId;
  protected String version;

  /**
   * Builder.
   */
  public static class Builder {
    private String actionControlTemplateId;
    private String version;

    /**
     * Instantiates a new Builder from an existing GetActionControlTemplateVersionOptions instance.
     *
     * @param getActionControlTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(GetActionControlTemplateVersionOptions getActionControlTemplateVersionOptions) {
      this.actionControlTemplateId = getActionControlTemplateVersionOptions.actionControlTemplateId;
      this.version = getActionControlTemplateVersionOptions.version;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @param version the version
     */
    public Builder(String actionControlTemplateId, String version) {
      this.actionControlTemplateId = actionControlTemplateId;
      this.version = version;
    }

    /**
     * Builds a GetActionControlTemplateVersionOptions.
     *
     * @return the new GetActionControlTemplateVersionOptions instance
     */
    public GetActionControlTemplateVersionOptions build() {
      return new GetActionControlTemplateVersionOptions(this);
    }

    /**
     * Set the actionControlTemplateId.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @return the GetActionControlTemplateVersionOptions builder
     */
    public Builder actionControlTemplateId(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the GetActionControlTemplateVersionOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }
  }

  protected GetActionControlTemplateVersionOptions() { }

  protected GetActionControlTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionControlTemplateId,
      "actionControlTemplateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.version,
      "version cannot be empty");
    actionControlTemplateId = builder.actionControlTemplateId;
    version = builder.version;
  }

  /**
   * New builder.
   *
   * @return a GetActionControlTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the actionControlTemplateId.
   *
   * Action control template ID.
   *
   * @return the actionControlTemplateId
   */
  public String actionControlTemplateId() {
    return actionControlTemplateId;
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

