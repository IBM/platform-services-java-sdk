/*
 * (C) Copyright IBM Corp. 2020.
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
package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createAttachments options.
 */
public class CreateAttachmentsOptions extends GenericModel {

  protected String ruleId;
  protected String transactionId;
  protected List<AttachmentRequest> attachments;

  /**
   * Builder.
   */
  public static class Builder {
    private String ruleId;
    private String transactionId;
    private List<AttachmentRequest> attachments;

    private Builder(CreateAttachmentsOptions createAttachmentsOptions) {
      this.ruleId = createAttachmentsOptions.ruleId;
      this.transactionId = createAttachmentsOptions.transactionId;
      this.attachments = createAttachmentsOptions.attachments;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param ruleId the ruleId
     * @param transactionId the transactionId
     * @param attachments the attachments
     */
    public Builder(String ruleId, String transactionId, List<AttachmentRequest> attachments) {
      this.ruleId = ruleId;
      this.transactionId = transactionId;
      this.attachments = attachments;
    }

    /**
     * Builds a CreateAttachmentsOptions.
     *
     * @return the new CreateAttachmentsOptions instance
     */
    public CreateAttachmentsOptions build() {
      return new CreateAttachmentsOptions(this);
    }

    /**
     * Adds an attachment to attachments.
     *
     * @param attachment the new attachment
     * @return the CreateAttachmentsOptions builder
     */
    public Builder addAttachment(AttachmentRequest attachment) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(attachment,
        "attachment cannot be null");
      if (this.attachments == null) {
        this.attachments = new ArrayList<AttachmentRequest>();
      }
      this.attachments.add(attachment);
      return this;
    }

    /**
     * Set the ruleId.
     *
     * @param ruleId the ruleId
     * @return the CreateAttachmentsOptions builder
     */
    public Builder ruleId(String ruleId) {
      this.ruleId = ruleId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the CreateAttachmentsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the attachments.
     * Existing attachments will be replaced.
     *
     * @param attachments the attachments
     * @return the CreateAttachmentsOptions builder
     */
    public Builder attachments(List<AttachmentRequest> attachments) {
      this.attachments = attachments;
      return this;
    }
  }

  protected CreateAttachmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.ruleId,
      "ruleId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.transactionId,
      "transactionId cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.attachments,
      "attachments cannot be null");
    ruleId = builder.ruleId;
    transactionId = builder.transactionId;
    attachments = builder.attachments;
  }

  /**
   * New builder.
   *
   * @return a CreateAttachmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the ruleId.
   *
   * The UUID that uniquely identifies the rule.
   *
   * @return the ruleId
   */
  public String ruleId() {
    return ruleId;
  }

  /**
   * Gets the transactionId.
   *
   * The unique identifier that is used to trace an entire request. If you omit this field, the service generates and
   * sends a transaction ID in the
   * `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the attachments.
   *
   * @return the attachments
   */
  public List<AttachmentRequest> attachments() {
    return attachments;
  }
}

