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
 * The deleteActionControlTemplate options.
 */
public class DeleteActionControlTemplateOptions extends GenericModel {

  protected String actionControlTemplateId;

  /**
   * Builder.
   */
  public static class Builder {
    private String actionControlTemplateId;

    /**
     * Instantiates a new Builder from an existing DeleteActionControlTemplateOptions instance.
     *
     * @param deleteActionControlTemplateOptions the instance to initialize the Builder with
     */
    private Builder(DeleteActionControlTemplateOptions deleteActionControlTemplateOptions) {
      this.actionControlTemplateId = deleteActionControlTemplateOptions.actionControlTemplateId;
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
     */
    public Builder(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
    }

    /**
     * Builds a DeleteActionControlTemplateOptions.
     *
     * @return the new DeleteActionControlTemplateOptions instance
     */
    public DeleteActionControlTemplateOptions build() {
      return new DeleteActionControlTemplateOptions(this);
    }

    /**
     * Set the actionControlTemplateId.
     *
     * @param actionControlTemplateId the actionControlTemplateId
     * @return the DeleteActionControlTemplateOptions builder
     */
    public Builder actionControlTemplateId(String actionControlTemplateId) {
      this.actionControlTemplateId = actionControlTemplateId;
      return this;
    }
  }

  protected DeleteActionControlTemplateOptions() { }

  protected DeleteActionControlTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.actionControlTemplateId,
      "actionControlTemplateId cannot be empty");
    actionControlTemplateId = builder.actionControlTemplateId;
  }

  /**
   * New builder.
   *
   * @return a DeleteActionControlTemplateOptions builder
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
}

