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
 * The getLatestAccountSettingsTemplateVersion options.
 */
public class GetLatestAccountSettingsTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing GetLatestAccountSettingsTemplateVersionOptions instance.
     *
     * @param getLatestAccountSettingsTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(GetLatestAccountSettingsTemplateVersionOptions getLatestAccountSettingsTemplateVersionOptions) {
      this.templateId = getLatestAccountSettingsTemplateVersionOptions.templateId;
      this.includeHistory = getLatestAccountSettingsTemplateVersionOptions.includeHistory;
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
     * Builds a GetLatestAccountSettingsTemplateVersionOptions.
     *
     * @return the new GetLatestAccountSettingsTemplateVersionOptions instance
     */
    public GetLatestAccountSettingsTemplateVersionOptions build() {
      return new GetLatestAccountSettingsTemplateVersionOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the GetLatestAccountSettingsTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the GetLatestAccountSettingsTemplateVersionOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected GetLatestAccountSettingsTemplateVersionOptions() { }

  protected GetLatestAccountSettingsTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a GetLatestAccountSettingsTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the account settings template.
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

