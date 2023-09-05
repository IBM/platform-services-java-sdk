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
 * The deleteAllVersionsOfProfileTemplate options.
 */
public class DeleteAllVersionsOfProfileTemplateOptions extends GenericModel {

  protected String templateId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;

    /**
     * Instantiates a new Builder from an existing DeleteAllVersionsOfProfileTemplateOptions instance.
     *
     * @param deleteAllVersionsOfProfileTemplateOptions the instance to initialize the Builder with
     */
    private Builder(DeleteAllVersionsOfProfileTemplateOptions deleteAllVersionsOfProfileTemplateOptions) {
      this.templateId = deleteAllVersionsOfProfileTemplateOptions.templateId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param templateId the templateId
     */
    public Builder(String templateId) {
      this.templateId = templateId;
    }

    /**
     * Builds a DeleteAllVersionsOfProfileTemplateOptions.
     *
     * @return the new DeleteAllVersionsOfProfileTemplateOptions instance
     */
    public DeleteAllVersionsOfProfileTemplateOptions build() {
      return new DeleteAllVersionsOfProfileTemplateOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the DeleteAllVersionsOfProfileTemplateOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }
  }

  protected DeleteAllVersionsOfProfileTemplateOptions() { }

  protected DeleteAllVersionsOfProfileTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
  }

  /**
   * New builder.
   *
   * @return a DeleteAllVersionsOfProfileTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the trusted profile template.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }
}

