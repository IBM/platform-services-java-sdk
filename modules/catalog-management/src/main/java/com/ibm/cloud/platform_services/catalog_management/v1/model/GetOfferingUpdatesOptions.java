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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getOfferingUpdates options.
 */
public class GetOfferingUpdatesOptions extends GenericModel {

  protected String catalogIdentifier;
  protected String offeringId;
  protected String kind;
  protected String version;
  protected String clusterId;
  protected String region;
  protected String resourceGroupId;
  protected String namespace;

  /**
   * Builder.
   */
  public static class Builder {
    private String catalogIdentifier;
    private String offeringId;
    private String kind;
    private String version;
    private String clusterId;
    private String region;
    private String resourceGroupId;
    private String namespace;

    private Builder(GetOfferingUpdatesOptions getOfferingUpdatesOptions) {
      this.catalogIdentifier = getOfferingUpdatesOptions.catalogIdentifier;
      this.offeringId = getOfferingUpdatesOptions.offeringId;
      this.kind = getOfferingUpdatesOptions.kind;
      this.version = getOfferingUpdatesOptions.version;
      this.clusterId = getOfferingUpdatesOptions.clusterId;
      this.region = getOfferingUpdatesOptions.region;
      this.resourceGroupId = getOfferingUpdatesOptions.resourceGroupId;
      this.namespace = getOfferingUpdatesOptions.namespace;
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
     * @param kind the kind
     */
    public Builder(String catalogIdentifier, String offeringId, String kind) {
      this.catalogIdentifier = catalogIdentifier;
      this.offeringId = offeringId;
      this.kind = kind;
    }

    /**
     * Builds a GetOfferingUpdatesOptions.
     *
     * @return the new GetOfferingUpdatesOptions instance
     */
    public GetOfferingUpdatesOptions build() {
      return new GetOfferingUpdatesOptions(this);
    }

    /**
     * Set the catalogIdentifier.
     *
     * @param catalogIdentifier the catalogIdentifier
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder catalogIdentifier(String catalogIdentifier) {
      this.catalogIdentifier = catalogIdentifier;
      return this;
    }

    /**
     * Set the offeringId.
     *
     * @param offeringId the offeringId
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder offeringId(String offeringId) {
      this.offeringId = offeringId;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the clusterId.
     *
     * @param clusterId the clusterId
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder clusterId(String clusterId) {
      this.clusterId = clusterId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the resourceGroupId.
     *
     * @param resourceGroupId the resourceGroupId
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder resourceGroupId(String resourceGroupId) {
      this.resourceGroupId = resourceGroupId;
      return this;
    }

    /**
     * Set the namespace.
     *
     * @param namespace the namespace
     * @return the GetOfferingUpdatesOptions builder
     */
    public Builder namespace(String namespace) {
      this.namespace = namespace;
      return this;
    }
  }

  protected GetOfferingUpdatesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.catalogIdentifier,
      "catalogIdentifier cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.offeringId,
      "offeringId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.kind,
      "kind cannot be null");
    catalogIdentifier = builder.catalogIdentifier;
    offeringId = builder.offeringId;
    kind = builder.kind;
    version = builder.version;
    clusterId = builder.clusterId;
    region = builder.region;
    resourceGroupId = builder.resourceGroupId;
    namespace = builder.namespace;
  }

  /**
   * New builder.
   *
   * @return a GetOfferingUpdatesOptions builder
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
   * Gets the kind.
   *
   * The kind of offering (e.g, helm, ova, terraform ...).
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the version.
   *
   * optionaly provide an existing version to check updates for if one is not given, all version will be returned.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the clusterId.
   *
   * The id of the cluster where this version was installed.
   *
   * @return the clusterId
   */
  public String clusterId() {
    return clusterId;
  }

  /**
   * Gets the region.
   *
   * The region of the cluster where this version was installed.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the resourceGroupId.
   *
   * The resource group id of the cluster where this version was installed.
   *
   * @return the resourceGroupId
   */
  public String resourceGroupId() {
    return resourceGroupId;
  }

  /**
   * Gets the namespace.
   *
   * The namespace of the cluster where this version was installed.
   *
   * @return the namespace
   */
  public String namespace() {
    return namespace;
  }
}

