/*
 * (C) Copyright IBM Corp. 2022.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The uploadFile options.
 */
public class UploadFileOptions extends GenericModel {

  protected String caseNumber;
  protected List<FileWithMetadata> file;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private List<FileWithMetadata> file;

    /**
     * Instantiates a new Builder from an existing UploadFileOptions instance.
     *
     * @param uploadFileOptions the instance to initialize the Builder with
     */
    private Builder(UploadFileOptions uploadFileOptions) {
      this.caseNumber = uploadFileOptions.caseNumber;
      this.file = uploadFileOptions.file;
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
     * @param file the file
     */
    public Builder(String caseNumber, List<FileWithMetadata> file) {
      this.caseNumber = caseNumber;
      this.file = file;
    }

    /**
     * Builds a UploadFileOptions.
     *
     * @return the new UploadFileOptions instance
     */
    public UploadFileOptions build() {
      return new UploadFileOptions(this);
    }

    /**
     * Adds an file to file.
     *
     * @param file the new file
     * @return the UploadFileOptions builder
     */
    public Builder addFile(FileWithMetadata file) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(file,
        "file cannot be null");
      if (this.file == null) {
        this.file = new ArrayList<FileWithMetadata>();
      }
      this.file.add(file);
      return this;
    }

    /**
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the UploadFileOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the file.
     * Existing file will be replaced.
     *
     * @param file the file
     * @return the UploadFileOptions builder
     */
    public Builder file(List<FileWithMetadata> file) {
      this.file = file;
      return this;
    }
  }

  protected UploadFileOptions() { }

  protected UploadFileOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.file,
      "file cannot be null");
    caseNumber = builder.caseNumber;
    file = builder.file;
  }

  /**
   * New builder.
   *
   * @return a UploadFileOptions builder
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
   * Gets the file.
   *
   * file of supported types, 8MB in size limit.
   *
   * @return the file
   */
  public List<FileWithMetadata> file() {
    return file;
  }
}

