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
package com.ibm.cloud.platform_services.case_management.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The getCase options.
 */
public class GetCaseOptions extends GenericModel {

  public interface Fields {
    /** number. */
    String NUMBER = "number";
    /** short_description. */
    String SHORT_DESCRIPTION = "short_description";
    /** description. */
    String DESCRIPTION = "description";
    /** created_at. */
    String CREATED_AT = "created_at";
    /** created_by. */
    String CREATED_BY = "created_by";
    /** updated_at. */
    String UPDATED_AT = "updated_at";
    /** updated_by. */
    String UPDATED_BY = "updated_by";
    /** contact. */
    String CONTACT = "contact";
    /** contact_type. */
    String CONTACT_TYPE = "contact_type";
    /** status. */
    String STATUS = "status";
    /** severity. */
    String SEVERITY = "severity";
    /** support_tier. */
    String SUPPORT_TIER = "support_tier";
    /** resolution. */
    String RESOLUTION = "resolution";
    /** close_notes. */
    String CLOSE_NOTES = "close_notes";
    /** invoice_number. */
    String INVOICE_NUMBER = "invoice_number";
    /** agent_close_only. */
    String AGENT_CLOSE_ONLY = "agent_close_only";
    /** eu. */
    String EU = "eu";
    /** watchlist. */
    String WATCHLIST = "watchlist";
    /** attachments. */
    String ATTACHMENTS = "attachments";
    /** resources. */
    String RESOURCES = "resources";
    /** comments. */
    String COMMENTS = "comments";
    /** offering. */
    String OFFERING = "offering";
  }

  protected String caseNumber;
  protected List<String> fields;

  /**
   * Builder.
   */
  public static class Builder {
    private String caseNumber;
    private List<String> fields;

    private Builder(GetCaseOptions getCaseOptions) {
      this.caseNumber = getCaseOptions.caseNumber;
      this.fields = getCaseOptions.fields;
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
     * Builds a GetCaseOptions.
     *
     * @return the new GetCaseOptions instance
     */
    public GetCaseOptions build() {
      return new GetCaseOptions(this);
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the GetCaseOptions builder
     */
    public Builder addFields(String fields) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(fields,
        "fields cannot be null");
      if (this.fields == null) {
        this.fields = new ArrayList<String>();
      }
      this.fields.add(fields);
      return this;
    }

    /**
     * Set the caseNumber.
     *
     * @param caseNumber the caseNumber
     * @return the GetCaseOptions builder
     */
    public Builder caseNumber(String caseNumber) {
      this.caseNumber = caseNumber;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the GetCaseOptions builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected GetCaseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.caseNumber,
      "caseNumber cannot be empty");
    caseNumber = builder.caseNumber;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a GetCaseOptions builder
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
   * Gets the fields.
   *
   * Seleted fields of interest instead of the entire case information.
   *
   * @return the fields
   */
  public List<String> fields() {
    return fields;
  }
}

