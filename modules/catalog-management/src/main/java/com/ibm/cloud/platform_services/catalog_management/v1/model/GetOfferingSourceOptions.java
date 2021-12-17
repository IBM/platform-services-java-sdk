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
 * The getOfferingSource options.
 */
public class GetOfferingSourceOptions extends GenericModel {

  protected String version;
  protected String accept;
  protected String catalogId;
  protected String name;
  protected String id;
  protected String kind;
  protected String channel;

  /**
   * Builder.
   */
  public static class Builder {
    private String version;
    private String accept;
    private String catalogId;
    private String name;
    private String id;
    private String kind;
    private String channel;

    private Builder(GetOfferingSourceOptions getOfferingSourceOptions) {
      this.version = getOfferingSourceOptions.version;
      this.accept = getOfferingSourceOptions.accept;
      this.catalogId = getOfferingSourceOptions.catalogId;
      this.name = getOfferingSourceOptions.name;
      this.id = getOfferingSourceOptions.id;
      this.kind = getOfferingSourceOptions.kind;
      this.channel = getOfferingSourceOptions.channel;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param version the version
     */
    public Builder(String version) {
      this.version = version;
    }

    /**
     * Builds a GetOfferingSourceOptions.
     *
     * @return the new GetOfferingSourceOptions instance
     */
    public GetOfferingSourceOptions build() {
      return new GetOfferingSourceOptions(this);
    }

    /**
     * Set the version.
     *
     * @param version the version
     * @return the GetOfferingSourceOptions builder
     */
    public Builder version(String version) {
      this.version = version;
      return this;
    }

    /**
     * Set the accept.
     *
     * @param accept the accept
     * @return the GetOfferingSourceOptions builder
     */
    public Builder accept(String accept) {
      this.accept = accept;
      return this;
    }

    /**
     * Set the catalogId.
     *
     * @param catalogId the catalogId
     * @return the GetOfferingSourceOptions builder
     */
    public Builder catalogId(String catalogId) {
      this.catalogId = catalogId;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the GetOfferingSourceOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the GetOfferingSourceOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the GetOfferingSourceOptions builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the channel.
     *
     * @param channel the channel
     * @return the GetOfferingSourceOptions builder
     */
    public Builder channel(String channel) {
      this.channel = channel;
      return this;
    }
  }

  protected GetOfferingSourceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.version,
      "version cannot be null");
    version = builder.version;
    accept = builder.accept;
    catalogId = builder.catalogId;
    name = builder.name;
    id = builder.id;
    kind = builder.kind;
    channel = builder.channel;
  }

  /**
   * New builder.
   *
   * @return a GetOfferingSourceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the version.
   *
   * The version being requested.
   *
   * @return the version
   */
  public String version() {
    return version;
  }

  /**
   * Gets the accept.
   *
   * The type of the response: application/yaml, application/json, or application/x-gzip.
   *
   * @return the accept
   */
  public String accept() {
    return accept;
  }

  /**
   * Gets the catalogId.
   *
   * Catlaog ID.  If not specified, this value will default to the public catalog.
   *
   * @return the catalogId
   */
  public String catalogId() {
    return catalogId;
  }

  /**
   * Gets the name.
   *
   * Offering name.  An offering name or ID must be specified.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the id.
   *
   * Offering id.  An offering name or ID must be specified.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the kind.
   *
   * The kind of offering (e.g. helm, ova, terraform...).
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the channel.
   *
   * The channel value of the specified version.
   *
   * @return the channel
   */
  public String channel() {
    return channel;
  }
}

