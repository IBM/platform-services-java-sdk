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
 * The getTemplateVersion options.
 */
public class GetTemplateVersionOptions extends GenericModel {

  protected String templateId;
  protected String versionNum;
  protected Boolean verbose;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String versionNum;
    private Boolean verbose;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing GetTemplateVersionOptions instance.
     *
     * @param getTemplateVersionOptions the instance to initialize the Builder with
     */
    private Builder(GetTemplateVersionOptions getTemplateVersionOptions) {
      this.templateId = getTemplateVersionOptions.templateId;
      this.versionNum = getTemplateVersionOptions.versionNum;
      this.verbose = getTemplateVersionOptions.verbose;
      this.transactionId = getTemplateVersionOptions.transactionId;
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
     * Builds a GetTemplateVersionOptions.
     *
     * @return the new GetTemplateVersionOptions instance
     */
    public GetTemplateVersionOptions build() {
      return new GetTemplateVersionOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the GetTemplateVersionOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the versionNum.
     *
     * @param versionNum the versionNum
     * @return the GetTemplateVersionOptions builder
     */
    public Builder versionNum(String versionNum) {
      this.versionNum = versionNum;
      return this;
    }

    /**
     * Set the verbose.
     *
     * @param verbose the verbose
     * @return the GetTemplateVersionOptions builder
     */
    public Builder verbose(Boolean verbose) {
      this.verbose = verbose;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the GetTemplateVersionOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected GetTemplateVersionOptions() { }

  protected GetTemplateVersionOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionNum,
      "versionNum cannot be empty");
    templateId = builder.templateId;
    versionNum = builder.versionNum;
    verbose = builder.verbose;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a GetTemplateVersionOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the template to get a specific version of.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the versionNum.
   *
   * Version number.
   *
   * @return the versionNum
   */
  public String versionNum() {
    return versionNum;
  }

  /**
   * Gets the verbose.
   *
   * If `verbose=true`, IAM resource details are returned. If performance is a concern, leave the `verbose` parameter
   * off so that details are not retrieved.
   *
   * @return the verbose
   */
  public Boolean verbose() {
    return verbose;
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

