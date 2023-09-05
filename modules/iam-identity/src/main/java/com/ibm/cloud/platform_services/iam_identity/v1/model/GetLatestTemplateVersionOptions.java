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
 * The getLatestTemplateVersion options.
 */
public class GetLatestTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing GetLatestTemplateVersionOptions instance.
     *
     * @param getLatestTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(GetLatestTemplateVersionOptions getLatestTemplateVersionOptions) {
      this.templateId = getLatestTemplateVersionOptions.templateId;
      this.includeHistory = getLatestTemplateVersionOptions.includeHistory;
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
     * Builds a GetLatestTemplateVersionOptions.
     *
     * @return the new GetLatestTemplateVersionOptions instance
     */
    public GetLatestTemplateVersionOptions build() {
      return new GetLatestTemplateVersionOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the GetLatestTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetLatestTemplateVersionOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected GetLatestTemplateVersionOptions() { }

  protected GetLatestTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a GetLatestTemplateVersionOptions builder
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

  /**
   * Gets the includeHistory.
   *
   * Defines if the entity history is included in the response.
   *
   * @return the includeHistory
   */
  public Boolean includeHistory() {
    return includeHistory;
  }
}

