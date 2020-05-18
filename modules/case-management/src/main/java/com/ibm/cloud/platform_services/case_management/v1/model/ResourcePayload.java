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
 * Payload to add a resource to a case.
 */
public class ResourcePayload extends GenericModel {

  protected String crn;
  protected String type;
  protected Double id;
  protected String note;

  /**
   * Builder.
   */
  public static class Builder {
    private String crn;
    private String type;
    private Double id;
    private String note;

    private Builder(ResourcePayload resourcePayload) {
      this.crn = resourcePayload.crn;
      this.type = resourcePayload.type;
      this.id = resourcePayload.id;
      this.note = resourcePayload.note;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ResourcePayload.
     *
     * @return the new ResourcePayload instance
     */
    public ResourcePayload build() {
      return new ResourcePayload(this);
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the ResourcePayload builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the ResourcePayload builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the ResourcePayload builder
     */
    public Builder id(Double id) {
      this.id = id;
      return this;
    }

    /**
     * Set the note.
     *
     * @param note the note
     * @return the ResourcePayload builder
     */
    public Builder note(String note) {
      this.note = note;
      return this;
    }
  }

  protected ResourcePayload(Builder builder) {
    crn = builder.crn;
    type = builder.type;
    id = builder.id;
    note = builder.note;
  }

  /**
   * New builder.
   *
   * @return a ResourcePayload builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the crn.
   *
   * Cloud Resource Name of the resource.
   *
   * @return the crn
   */
  public String crn() {
    return crn;
  }

  /**
   * Gets the type.
   *
   * Only used to attach Classic IaaS devices which have no CRN.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the id.
   *
   * Only used to attach Classic IaaS devices which have no CRN. Id of Classic IaaS device. This is deprecated in favor
   * of the crn field.
   *
   * @return the id
   */
  public Double id() {
    return id;
  }

  /**
   * Gets the note.
   *
   * A note about this resource.
   *
   * @return the note
   */
  public String note() {
    return note;
  }
}

