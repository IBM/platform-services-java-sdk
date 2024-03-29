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
 * The deleteTemplateVersion options.
 */
public class DeleteTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected String versionNum;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String versionNum;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing DeleteTemplateVersionOptions instance.
     *
     * @param deleteTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(DeleteTemplateVersionOptions deleteTemplateVersionOptions) {
      this.templateId = deleteTemplateVersionOptions.templateId;
      this.versionNum = deleteTemplateVersionOptions.versionNum;
      this.transactionId = deleteTemplateVersionOptions.transactionId;
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
     * @param versionNum the versionNum
     */
    public Builder(String templateId, String versionNum) {
      this.templateId = templateId;
      this.versionNum = versionNum;
    }

    /**
     * Builds a DeleteTemplateVersionOptions.
     *
     * @return the new DeleteTemplateVersionOptions instance
     */
    public DeleteTemplateVersionOptions build() {
      return new DeleteTemplateVersionOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the DeleteTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the versionNum.
     *
     * @param versionNum the versionNum
     * @return the DeleteTemplateVersionOptions builder
     */
    public Builder versionNum(String versionNum) {
      this.versionNum = versionNum;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the DeleteTemplateVersionOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected DeleteTemplateVersionOptions() { }

  protected DeleteTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionNum,
      "versionNum cannot be empty");
    templateId = builder.templateId;
    versionNum = builder.versionNum;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a DeleteTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the template to delete.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the versionNum.
   *
   * version number in path.
   *
   * @return the versionNum
   */
  public String versionNum() {
    return versionNum;
  }

  /**
   * Gets the transactionId.
   *
   * An optional transaction id for the request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }
}

