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
 * The deleteFile options.
 */
public class DeleteFileOptions extends GenericModel {

  protected String caseNumber;
  protected String fileId;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private String fileId;

    private Builder(DeleteFileOptions deleteFileOptions) {
      this.caseNumber = deleteFileOptions.caseNumber;
      this.fileId = deleteFileOptions.fileId;
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
     * @param fileId the fileId
     */
    public Builder(String caseNumber, String fileId) {
      this.caseNumber = caseNumber;
      this.fileId = fileId;
    }

    /**
     * Builds a DeleteFileOptions.
     *
     * @return the new DeleteFileOptions instance
     */
    public DeleteFileOptions build() {
      return new DeleteFileOptions(this);
    }

    /**
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the DeleteFileOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the fileId.
     *
     * @param fileId the fileId
     * @return the DeleteFileOptions builder
     */
    public Builder fileId(String fileId) {
      this.fileId = fileId;
      return this;
    }
  }

  protected DeleteFileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.fileId,
      "fileId cannot be empty");
    caseNumber = builder.caseNumber;
    fileId = builder.fileId;
  }

  /**
   * New builder.
   *
   * @return a DeleteFileOptions builder
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
   * Gets the fileId.
   *
   * Unique identifier of a file.
   *
   * @return the fileId
   */
  public String fileId() {
    return fileId;
  }
}

