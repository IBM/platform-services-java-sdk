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
 * The listAssignments options.
 */
public class ListAssignmentsOptions extends GenericModel {

  /**
   * Filter results by the assignment status.
   */
  public interface Status {
    /** accepted. */
    String ACCEPTED = "accepted";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
    /** failed. */
    String FAILED = "failed";
  }

  protected String accountId;
  protected String templateId;
  protected String templateVersion;
  protected String target;
  protected String status;
  protected String transactionId;
  protected Long limit;
  protected Long offset;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String templateId;
    private String templateVersion;
    private String target;
    private String status;
    private String transactionId;
    private Long limit;
    private Long offset;

    /**
     * Instantiates a new Builder from an existing ListAssignmentsOptions instance.
     *
     * @param listAssignmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListAssignmentsOptions listAssignmentsOptions) {
      this.accountId = listAssignmentsOptions.accountId;
      this.templateId = listAssignmentsOptions.templateId;
      this.templateVersion = listAssignmentsOptions.templateVersion;
      this.target = listAssignmentsOptions.target;
      this.status = listAssignmentsOptions.status;
      this.transactionId = listAssignmentsOptions.transactionId;
      this.limit = listAssignmentsOptions.limit;
      this.offset = listAssignmentsOptions.offset;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a ListAssignmentsOptions.
     *
     * @return the new ListAssignmentsOptions instance
     */
    public ListAssignmentsOptions build() {
      return new ListAssignmentsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListAssignmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ListAssignmentsOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the ListAssignmentsOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the ListAssignmentsOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ListAssignmentsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListAssignmentsOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListAssignmentsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the offset.
     *
     * @param offset the offset
     * @return the ListAssignmentsOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }
  }

  protected ListAssignmentsOptions() { }

  protected ListAssignmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    templateId = builder.templateId;
    templateVersion = builder.templateVersion;
    target = builder.target;
    status = builder.status;
    transactionId = builder.transactionId;
    limit = builder.limit;
    offset = builder.offset;
  }

  /**
   * New builder.
   *
   * @return a ListAssignmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Enterprise account ID.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the templateId.
   *
   * Filter results by Template Id.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * Filter results by Template Version.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }

  /**
   * Gets the target.
   *
   * Filter results by the assignment target.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the status.
   *
   * Filter results by the assignment status.
   *
   * @return the status
   */
  public String status() {
    return status;
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

  /**
   * Gets the limit.
   *
   * Return up to this limit of results where limit is between 0 and 100.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the offset.
   *
   * The offset of the first result item to be returned.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }
}

