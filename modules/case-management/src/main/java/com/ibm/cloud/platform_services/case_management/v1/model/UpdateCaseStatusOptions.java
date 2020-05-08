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
package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateCaseStatus options.
 */
public class UpdateCaseStatusOptions extends GenericModel {

  protected String caseNumber;
  protected StatusPayload statusPayload;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private StatusPayload statusPayload;

    private Builder(UpdateCaseStatusOptions updateCaseStatusOptions) {
      this.caseNumber = updateCaseStatusOptions.caseNumber;
      this.statusPayload = updateCaseStatusOptions.statusPayload;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param caseNumber the caseNumber
     * @param statusPayload the statusPayload
     */
    public Builder(String caseNumber, StatusPayload statusPayload) {
      this.caseNumber = caseNumber;
      this.statusPayload = statusPayload;
    }

    /**
     * Builds a UpdateCaseStatusOptions.
     *
     * @return the new UpdateCaseStatusOptions instance
     */
    public UpdateCaseStatusOptions build() {
      return new UpdateCaseStatusOptions(this);
    }

    /**
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the UpdateCaseStatusOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the statusPayload.
     *
     * @param statusPayload the statusPayload
     * @return the UpdateCaseStatusOptions builder
     */
    public Builder statusPayload(StatusPayload statusPayload) {
      this.statusPayload = statusPayload;
      return this;
    }
  }

  protected UpdateCaseStatusOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.statusPayload,
      "statusPayload cannot be null");
    caseNumber = builder.caseNumber;
    statusPayload = builder.statusPayload;
  }

  /**
   * New builder.
   *
   * @return a UpdateCaseStatusOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the caseNumber.
   *
   * Unique identifier of a case.
   *
   * @return the caseNumber
   */
  public String caseNumber() {
    return caseNumber;
  }

  /**
   * Gets the statusPayload.
   *
   * @return the statusPayload
   */
  public StatusPayload statusPayload() {
    return statusPayload;
  }
}

