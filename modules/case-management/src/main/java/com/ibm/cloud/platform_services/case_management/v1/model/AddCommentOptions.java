/*
 * (C) Copyright IBM Corp. 2021.
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
 * The addComment options.
 */
public class AddCommentOptions extends GenericModel {

  protected String caseNumber;
  protected String comment;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private String comment;

    private Builder(AddCommentOptions addCommentOptions) {
      this.caseNumber = addCommentOptions.caseNumber;
      this.comment = addCommentOptions.comment;
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
     * @param comment the comment
     */
    public Builder(String caseNumber, String comment) {
      this.caseNumber = caseNumber;
      this.comment = comment;
    }

    /**
     * Builds a AddCommentOptions.
     *
     * @return the new AddCommentOptions instance
     */
    public AddCommentOptions build() {
      return new AddCommentOptions(this);
    }

    /**
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the AddCommentOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the comment.
     *
     * @param comment the comment
     * @return the AddCommentOptions builder
     */
    public Builder comment(String comment) {
      this.comment = comment;
      return this;
    }
  }

  protected AddCommentOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.comment,
      "comment cannot be null");
    caseNumber = builder.caseNumber;
    comment = builder.comment;
  }

  /**
   * New builder.
   *
   * @return a AddCommentOptions builder
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
   * Gets the comment.
   *
   * Comment to add to the case.
   *
   * @return the comment
   */
  public String comment() {
    return comment;
  }
}

