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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Publish information.
 */
public class PublishObject extends GenericModel {

  @SerializedName("permit_ibm_public_publish")
  protected Boolean permitIbmPublicPublish;
  @SerializedName("ibm_approved")
  protected Boolean ibmApproved;
  @SerializedName("public_approved")
  protected Boolean publicApproved;
  @SerializedName("portal_approval_record")
  protected String portalApprovalRecord;
  @SerializedName("portal_url")
  protected String portalUrl;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean permitIbmPublicPublish;
    private Boolean ibmApproved;
    private Boolean publicApproved;
    private String portalApprovalRecord;
    private String portalUrl;

    private Builder(PublishObject publishObject) {
      this.permitIbmPublicPublish = publishObject.permitIbmPublicPublish;
      this.ibmApproved = publishObject.ibmApproved;
      this.publicApproved = publishObject.publicApproved;
      this.portalApprovalRecord = publishObject.portalApprovalRecord;
      this.portalUrl = publishObject.portalUrl;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a PublishObject.
     *
     * @return the new PublishObject instance
     */
    public PublishObject build() {
      return new PublishObject(this);
    }

    /**
     * Set the permitIbmPublicPublish.
     *
     * @param permitIbmPublicPublish the permitIbmPublicPublish
     * @return the PublishObject builder
     */
    public Builder permitIbmPublicPublish(Boolean permitIbmPublicPublish) {
      this.permitIbmPublicPublish = permitIbmPublicPublish;
      return this;
    }

    /**
     * Set the ibmApproved.
     *
     * @param ibmApproved the ibmApproved
     * @return the PublishObject builder
     */
    public Builder ibmApproved(Boolean ibmApproved) {
      this.ibmApproved = ibmApproved;
      return this;
    }

    /**
     * Set the publicApproved.
     *
     * @param publicApproved the publicApproved
     * @return the PublishObject builder
     */
    public Builder publicApproved(Boolean publicApproved) {
      this.publicApproved = publicApproved;
      return this;
    }

    /**
     * Set the portalApprovalRecord.
     *
     * @param portalApprovalRecord the portalApprovalRecord
     * @return the PublishObject builder
     */
    public Builder portalApprovalRecord(String portalApprovalRecord) {
      this.portalApprovalRecord = portalApprovalRecord;
      return this;
    }

    /**
     * Set the portalUrl.
     *
     * @param portalUrl the portalUrl
     * @return the PublishObject builder
     */
    public Builder portalUrl(String portalUrl) {
      this.portalUrl = portalUrl;
      return this;
    }
  }

  protected PublishObject(Builder builder) {
    permitIbmPublicPublish = builder.permitIbmPublicPublish;
    ibmApproved = builder.ibmApproved;
    publicApproved = builder.publicApproved;
    portalApprovalRecord = builder.portalApprovalRecord;
    portalUrl = builder.portalUrl;
  }

  /**
   * New builder.
   *
   * @return a PublishObject builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the permitIbmPublicPublish.
   *
   * Is it permitted to request publishing to IBM or Public.
   *
   * @return the permitIbmPublicPublish
   */
  public Boolean permitIbmPublicPublish() {
    return permitIbmPublicPublish;
  }

  /**
   * Gets the ibmApproved.
   *
   * Indicates if this offering has been approved for use by all IBMers.
   *
   * @return the ibmApproved
   */
  public Boolean ibmApproved() {
    return ibmApproved;
  }

  /**
   * Gets the publicApproved.
   *
   * Indicates if this offering has been approved for use by all IBM Cloud users.
   *
   * @return the publicApproved
   */
  public Boolean publicApproved() {
    return publicApproved;
  }

  /**
   * Gets the portalApprovalRecord.
   *
   * The portal's approval record ID.
   *
   * @return the portalApprovalRecord
   */
  public String portalApprovalRecord() {
    return portalApprovalRecord;
  }

  /**
   * Gets the portalUrl.
   *
   * The portal UI URL.
   *
   * @return the portalUrl
   */
  public String portalUrl() {
    return portalUrl;
  }
}

