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
 * Offering type.
 */
public class OfferingType extends GenericModel {

  /**
   * Offering type group. "crn_service_name" is strongly prefered over "category" as the latter is legacy and will be
   * deprecated in the future.
   */
  public interface Group {
    /** crn_service_name. */
    String CRN_SERVICE_NAME = "crn_service_name";
    /** category. */
    String CATEGORY = "category";
  }

  protected String group;
  protected String key;
  protected String kind;
  protected String id;

  /**
   * Builder.
   */
  public static class Builder {
    private String group;
    private String key;
    private String kind;
    private String id;

    private Builder(OfferingType offeringType) {
      this.group = offeringType.group;
      this.key = offeringType.key;
      this.kind = offeringType.kind;
      this.id = offeringType.id;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param group the group
     * @param key the key
     */
    public Builder(String group, String key) {
      this.group = group;
      this.key = key;
    }

    /**
     * Builds a OfferingType.
     *
     * @return the new OfferingType instance
     */
    public OfferingType build() {
      return new OfferingType(this);
    }

    /**
     * Set the group.
     *
     * @param group the group
     * @return the OfferingType builder
     */
    public Builder group(String group) {
      this.group = group;
      return this;
    }

    /**
     * Set the key.
     *
     * @param key the key
     * @return the OfferingType builder
     */
    public Builder key(String key) {
      this.key = key;
      return this;
    }

    /**
     * Set the kind.
     *
     * @param kind the kind
     * @return the OfferingType builder
     */
    public Builder kind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the OfferingType builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }
  }

  protected OfferingType(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.group,
      "group cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.key,
      "key cannot be null");
    group = builder.group;
    key = builder.key;
    kind = builder.kind;
    id = builder.id;
  }

  /**
   * New builder.
   *
   * @return a OfferingType builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the group.
   *
   * Offering type group. "crn_service_name" is strongly prefered over "category" as the latter is legacy and will be
   * deprecated in the future.
   *
   * @return the group
   */
  public String group() {
    return group;
  }

  /**
   * Gets the key.
   *
   * CRN service name of the offering.
   *
   * @return the key
   */
  public String key() {
    return key;
  }

  /**
   * Gets the kind.
   *
   * Optional. Platform kind of the offering.
   *
   * @return the kind
   */
  public String kind() {
    return kind;
  }

  /**
   * Gets the id.
   *
   * Offering id in the catalog. This alone is enough to identify the offering.
   *
   * @return the id
   */
  public String id() {
    return id;
  }
}

