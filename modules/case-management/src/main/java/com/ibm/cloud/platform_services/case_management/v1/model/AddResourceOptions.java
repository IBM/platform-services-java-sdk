/*
 * (C) Copyright IBM Corp. 2022.
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
 * The addResource options.
 */
public class AddResourceOptions extends GenericModel {

  protected String caseNumber;
  protected String crn;
  protected String type;
  protected Double id;
  protected String note;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private String crn;
    private String type;
    private Double id;
    private String note;

    /**
     * Instantiates a new Builder from an existing AddResourceOptions instance.
     *
     * @param addResourceOptions the instance to initialize the Builder with
     */
    private Builder(AddResourceOptions addResourceOptions) {
      this.caseNumber = addResourceOptions.caseNumber;
      this.crn = addResourceOptions.crn;
      this.type = addResourceOptions.type;
      this.id = addResourceOptions.id;
      this.note = addResourceOptions.note;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param caseNumber the caseNumber
     */
    public Builder(String caseNumber) {
      this.caseNumber = caseNumber;
    }

    /**
     * Builds a AddResourceOptions.
     *
     * @return the new AddResourceOptions instance
     */
    public AddResourceOptions build() {
      return new AddResourceOptions(this);
    }

    /**
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the AddResourceOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the crn.
     *
     * @param crn the crn
     * @return the AddResourceOptions builder
     */
    public Builder crn(String crn) {
      this.crn = crn;
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the AddResourceOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the id.
     *
     * @param id the id
     * @return the AddResourceOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder id(Double id) {
      this.id = id;
      return this;
    }

    /**
     * Set the note.
     *
     * @param note the note
     * @return the AddResourceOptions builder
     */
    public Builder note(String note) {
      this.note = note;
      return this;
    }
  }

  protected AddResourceOptions() { }

  protected AddResourceOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    caseNumber = builder.caseNumber;
    crn = builder.crn;
    type = builder.type;
    id = builder.id;
    note = builder.note;
  }

  /**
   * New builder.
   *
   * @return a AddResourceOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the caseNumber.
   *
   * Unique identifier of a case.
   *
   * @return the caseNumber
   */
  public String caseNumber() {
    return caseNumber;
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
   * Only used to attach Classic IaaS devices that have no CRN.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the id.
   *
   * Only used to attach Classic IaaS devices that have no CRN. Id of Classic IaaS device. This is deprecated in favor
   * of the crn field.
   *
   * @return the id
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
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

