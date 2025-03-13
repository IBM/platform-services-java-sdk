/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SLA Disaster Recovery-related metadata.
 */
public class DRMetaData extends GenericModel {

  protected Boolean dr;
  protected String description;

  /**
   * Builder.
   */
  public static class Builder {
    private Boolean dr;
    private String description;

    /**
     * Instantiates a new Builder from an existing DRMetaData instance.
     *
     * @param drMetaData the instance to initialize the Builder with
     */
    private Builder(DRMetaData drMetaData) {
      this.dr = drMetaData.dr;
      this.description = drMetaData.description;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a DRMetaData.
     *
     * @return the new DRMetaData instance
     */
    public DRMetaData build() {
      return new DRMetaData(this);
    }

    /**
     * Set the dr.
     *
     * @param dr the dr
     * @return the DRMetaData builder
     */
    public Builder dr(Boolean dr) {
      this.dr = dr;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the DRMetaData builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }
  }

  protected DRMetaData() { }

  protected DRMetaData(Builder builder) {
    dr = builder.dr;
    description = builder.description;
  }

  /**
   * New builder.
   *
   * @return a DRMetaData builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the dr.
   *
   * Required boolean value that describes whether disaster recovery is on.
   *
   * @return the dr
   */
  public Boolean dr() {
    return dr;
  }

  /**
   * Gets the description.
   *
   * Description of the disaster recovery implementation.
   *
   * @return the description
   */
  public String description() {
    return description;
  }
}

