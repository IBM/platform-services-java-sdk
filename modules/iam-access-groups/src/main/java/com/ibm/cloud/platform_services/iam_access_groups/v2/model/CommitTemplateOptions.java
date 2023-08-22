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
 * The commitTemplate options.
 */
public class CommitTemplateOptions extends GenericModel {

  protected String templateId;
  protected String versionNum;
  protected String ifMatch;
  protected String transactionId;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String versionNum;
    private String ifMatch;
    private String transactionId;

    /**
     * Instantiates a new Builder from an existing CommitTemplateOptions instance.
     *
     * @param commitTemplateOptions the instance to initialize the Builder with
     */
    private Builder(CommitTemplateOptions commitTemplateOptions) {
      this.templateId = commitTemplateOptions.templateId;
      this.versionNum = commitTemplateOptions.versionNum;
      this.ifMatch = commitTemplateOptions.ifMatch;
      this.transactionId = commitTemplateOptions.transactionId;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String templateId, String versionNum, String ifMatch) {
      this.templateId = templateId;
      this.versionNum = versionNum;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a CommitTemplateOptions.
     *
     * @return the new CommitTemplateOptions instance
     */
    public CommitTemplateOptions build() {
      return new CommitTemplateOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the CommitTemplateOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the versionNum.
     *
     * @param versionNum the versionNum
     * @return the CommitTemplateOptions builder
     */
    public Builder versionNum(String versionNum) {
      this.versionNum = versionNum;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the CommitTemplateOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CommitTemplateOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }
  }

  protected CommitTemplateOptions() { }

  protected CommitTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.versionNum,
      "versionNum cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    templateId = builder.templateId;
    versionNum = builder.versionNum;
    ifMatch = builder.ifMatch;
    transactionId = builder.transactionId;
  }

  /**
   * New builder.
   *
   * @return a CommitTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the template to commit.
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
   * Gets the ifMatch.
   *
   * ETag value of the template version document.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
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

