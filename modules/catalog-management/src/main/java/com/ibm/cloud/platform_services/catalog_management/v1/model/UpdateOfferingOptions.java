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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateOffering options.
 */
public class UpdateOfferingOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected String ifMatch;
  protected List<JsonPatchOperation> updates;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String ifMatch;
    private List<JsonPatchOperation> updates;

    private Builder(UpdateOfferingOptions updateOfferingOptions) {
      this.catalogIdentifier = updateOfferingOptions.catalogIdentifier;
      this.offeringId = updateOfferingOptions.offeringId;
      this.ifMatch = updateOfferingOptions.ifMatch;
      this.updates = updateOfferingOptions.updates;
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
     * @param ifMatch the ifMatch
     */
    public Builder(String catalogIdentifier, String offeringId, String ifMatch) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateOfferingOptions.
     *
     * @return the new UpdateOfferingOptions instance
     */
    public UpdateOfferingOptions build() {
      return new UpdateOfferingOptions(this);
    }

    /**
     * Adds an updates to updates.
     *
     * @param updates the new updates
     * @return the UpdateOfferingOptions builder
     */
    public Builder addUpdates(JsonPatchOperation updates) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(updates,
        "updates cannot be null");
      if (this.updates == null) {
        this.updates = new ArrayList<JsonPatchOperation>();
      }
      this.updates.add(updates);
      return this;
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the UpdateOfferingOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the UpdateOfferingOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateOfferingOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the updates.
     * Existing updates will be replaced.
     *
     * @param updates the updates
     * @return the UpdateOfferingOptions builder
     */
    public Builder updates(List<JsonPatchOperation> updates) {
      this.updates = updates;
      return this;
    }
  }

  protected UpdateOfferingOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    ifMatch = builder.ifMatch;
    updates = builder.updates;
  }

  /**
   * New builder.
   *
   * @return a UpdateOfferingOptions builder
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
   * Gets the ifMatch.
   *
   * Offering etag contained in quotes.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the updates.
   *
   * Array of patch operations as defined in RFC 6902.
   *
   * @return the updates
   */
  public List<JsonPatchOperation> updates() {
    return updates;
  }
}

