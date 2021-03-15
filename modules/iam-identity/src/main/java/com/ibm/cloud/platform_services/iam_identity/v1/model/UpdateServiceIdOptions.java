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
package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updateServiceId options.
 */
public class UpdateServiceIdOptions extends GenericModel {

  protected String id;
  protected String ifMatch;
  protected String name;
  protected String description;
  protected List<String> uniqueInstanceCrns;

  /**
   * Builder.
   */
  public static class Builder {
    private String id;
    private String ifMatch;
    private String name;
    private String description;
    private List<String> uniqueInstanceCrns;

    private Builder(UpdateServiceIdOptions updateServiceIdOptions) {
      this.id = updateServiceIdOptions.id;
      this.ifMatch = updateServiceIdOptions.ifMatch;
      this.name = updateServiceIdOptions.name;
      this.description = updateServiceIdOptions.description;
      this.uniqueInstanceCrns = updateServiceIdOptions.uniqueInstanceCrns;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param id the id
     * @param ifMatch the ifMatch
     */
    public Builder(String id, String ifMatch) {
      this.id = id;
      this.ifMatch = ifMatch;
    }

    /**
     * Builds a UpdateServiceIdOptions.
     *
     * @return the new UpdateServiceIdOptions instance
     */
    public UpdateServiceIdOptions build() {
      return new UpdateServiceIdOptions(this);
    }

    /**
     * Adds an uniqueInstanceCrns to uniqueInstanceCrns.
     *
     * @param uniqueInstanceCrns the new uniqueInstanceCrns
     * @return the UpdateServiceIdOptions builder
     */
    public Builder addUniqueInstanceCrns(String uniqueInstanceCrns) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(uniqueInstanceCrns,
        "uniqueInstanceCrns cannot be null");
      if (this.uniqueInstanceCrns == null) {
        this.uniqueInstanceCrns = new ArrayList<String>();
      }
      this.uniqueInstanceCrns.add(uniqueInstanceCrns);
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the UpdateServiceIdOptions builder
     */
    public Builder id(String id) {
      this.id = id;
      return this;
    }

    /**
     * Set the ifMatch.
     *
     * @param ifMatch the ifMatch
     * @return the UpdateServiceIdOptions builder
     */
    public Builder ifMatch(String ifMatch) {
      this.ifMatch = ifMatch;
      return this;
    }

    /**
     * Set the name.
     *
     * @param name the name
     * @return the UpdateServiceIdOptions builder
     */
    public Builder name(String name) {
      this.name = name;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the UpdateServiceIdOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the uniqueInstanceCrns.
     * Existing uniqueInstanceCrns will be replaced.
     *
     * @param uniqueInstanceCrns the uniqueInstanceCrns
     * @return the UpdateServiceIdOptions builder
     */
    public Builder uniqueInstanceCrns(List<String> uniqueInstanceCrns) {
      this.uniqueInstanceCrns = uniqueInstanceCrns;
      return this;
    }
  }

  protected UpdateServiceIdOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.id,
      "id cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.ifMatch,
      "ifMatch cannot be null");
    id = builder.id;
    ifMatch = builder.ifMatch;
    name = builder.name;
    description = builder.description;
    uniqueInstanceCrns = builder.uniqueInstanceCrns;
  }

  /**
   * New builder.
   *
   * @return a UpdateServiceIdOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the id.
   *
   * Unique ID of the service ID to be updated.
   *
   * @return the id
   */
  public String id() {
    return id;
  }

  /**
   * Gets the ifMatch.
   *
   * Version of the service ID to be updated. Specify the version that you retrieved as entity_tag (ETag header) when
   * reading the service ID. This value helps identifying parallel usage of this API. Pass * to indicate to update any
   * version available. This might result in stale updates.
   *
   * @return the ifMatch
   */
  public String ifMatch() {
    return ifMatch;
  }

  /**
   * Gets the name.
   *
   * The name of the service ID to update. If specified in the request the parameter must not be empty. The name is not
   * checked for uniqueness. Failure to this will result in an Error condition.
   *
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * Gets the description.
   *
   * The description of the service ID to update. If specified an empty description will clear the description of the
   * service ID. If an non empty value is provided the service ID will be updated.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the uniqueInstanceCrns.
   *
   * List of CRNs which point to the services connected to this service ID. If specified an empty list will clear all
   * existing unique instance crns of the service ID.
   *
   * @return the uniqueInstanceCrns
   */
  public List<String> uniqueInstanceCrns() {
    return uniqueInstanceCrns;
  }
}

