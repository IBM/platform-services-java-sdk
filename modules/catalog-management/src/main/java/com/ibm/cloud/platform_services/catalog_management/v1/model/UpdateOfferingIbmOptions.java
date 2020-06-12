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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateOfferingIbm options.
 */
public class UpdateOfferingIbmOptions extends GenericModel {

  /**
   * Type of approval, ibm or public.
   */
  public interface ApprovalType {
    /** ibm. */
    String IBM = "ibm";
    /** public. */
    String X_PUBLIC = "public";
  }

  /**
   * Approve (true) or disapprove (false).
   */
  public interface Approved {
    /** true. */
    String X_TRUE = "true";
    /** false. */
    String X_FALSE = "false";
  }

  protected String catalogIdentifier;
  protected String offeringId;
  protected String approvalType;
  protected String approved;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String approvalType;
    private String approved;

    private Builder(UpdateOfferingIbmOptions updateOfferingIbmOptions) {
      this.catalogIdentifier = updateOfferingIbmOptions.catalogIdentifier;
      this.offeringId = updateOfferingIbmOptions.offeringId;
      this.approvalType = updateOfferingIbmOptions.approvalType;
      this.approved = updateOfferingIbmOptions.approved;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @param offeringId the offeringId
     * @param approvalType the approvalType
     * @param approved the approved
     */
    public Builder(String catalogIdentifier, String offeringId, String approvalType, String approved) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.approvalType = approvalType;
      this.approved = approved;
    }

    /**
     * Builds a UpdateOfferingIbmOptions.
     *
     * @return the new UpdateOfferingIbmOptions instance
     */
    public UpdateOfferingIbmOptions build() {
      return new UpdateOfferingIbmOptions(this);
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the UpdateOfferingIbmOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the UpdateOfferingIbmOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the approvalType.
     *
     * @param approvalType the approvalType
     * @return the UpdateOfferingIbmOptions builder
     */
    public Builder approvalType(String approvalType) {
      this.approvalType = approvalType;
      return this;
    }

    /**
     * Set the approved.
     *
     * @param approved the approved
     * @return the UpdateOfferingIbmOptions builder
     */
    public Builder approved(String approved) {
      this.approved = approved;
      return this;
    }
  }

  protected UpdateOfferingIbmOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.approvalType,
      "approvalType cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.approved,
      "approved cannot be empty");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    approvalType = builder.approvalType;
    approved = builder.approved;
  }

  /**
   * New builder.
   *
   * @return a UpdateOfferingIbmOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the catalogIdentifier.
   *
   * Catalog identifier.
   *
   * @return the catalogIdentifier
   */
  public String catalogIdentifier() {
    return catalogIdentifier;
  }

  /**
   * Gets the offeringId.
   *
   * Offering identification.
   *
   * @return the offeringId
   */
  public String offeringId() {
    return offeringId;
  }

  /**
   * Gets the approvalType.
   *
   * Type of approval, ibm or public.
   *
   * @return the approvalType
   */
  public String approvalType() {
    return approvalType;
  }

  /**
   * Gets the approved.
   *
   * Approve (true) or disapprove (false).
   *
   * @return the approved
   */
  public String approved() {
    return approved;
  }
}

