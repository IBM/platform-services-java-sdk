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
 * The getCases options.
 */
public class GetCasesOptions extends GenericModel {

  public interface Status {
    /** new. */
    String X_NEW = "new";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** waiting_on_client. */
    String WAITING_ON_CLIENT = "waiting_on_client";
    /** resolution_provided. */
    String RESOLUTION_PROVIDED = "resolution_provided";
    /** resolved. */
    String RESOLVED = "resolved";
    /** closed. */
    String CLOSED = "closed";
  }

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

  protected Long offset;
  protected Long limit;
  protected String search;
  protected String sort;
  protected List<String> status;
  protected List<String> fields;

  /**
   * Builder.
   */
  public static class Builder {
    private Long offset;
    private Long limit;
    private String search;
    private String sort;
    private List<String> status;
    private List<String> fields;

    private Builder(GetCasesOptions getCasesOptions) {
      this.offset = getCasesOptions.offset;
      this.limit = getCasesOptions.limit;
      this.search = getCasesOptions.search;
      this.sort = getCasesOptions.sort;
      this.status = getCasesOptions.status;
      this.fields = getCasesOptions.fields;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a GetCasesOptions.
     *
     * @return the new GetCasesOptions instance
     */
    public GetCasesOptions build() {
      return new GetCasesOptions(this);
    }

    /**
     * Adds an status to status.
     *
     * @param status the new status
     * @return the GetCasesOptions builder
     */
    public Builder addStatus(String status) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(status,
        "status cannot be null");
      if (this.status == null) {
        this.status = new ArrayList<String>();
      }
      this.status.add(status);
      return this;
    }

    /**
     * Adds an fields to fields.
     *
     * @param fields the new fields
     * @return the GetCasesOptions builder
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
     * Set the offset.
     *
     * @param offset the offset
     * @return the GetCasesOptions builder
     */
    public Builder offset(long offset) {
      this.offset = offset;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the GetCasesOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the search.
     *
     * @param search the search
     * @return the GetCasesOptions builder
     */
    public Builder search(String search) {
      this.search = search;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the GetCasesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the status.
     * Existing status will be replaced.
     *
     * @param status the status
     * @return the GetCasesOptions builder
     */
    public Builder status(List<String> status) {
      this.status = status;
      return this;
    }

    /**
     * Set the fields.
     * Existing fields will be replaced.
     *
     * @param fields the fields
     * @return the GetCasesOptions builder
     */
    public Builder fields(List<String> fields) {
      this.fields = fields;
      return this;
    }
  }

  protected GetCasesOptions(Builder builder) {
    offset = builder.offset;
    limit = builder.limit;
    search = builder.search;
    sort = builder.sort;
    status = builder.status;
    fields = builder.fields;
  }

  /**
   * New builder.
   *
   * @return a GetCasesOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the offset.
   *
   * Number of cases should be skipped.
   *
   * @return the offset
   */
  public Long offset() {
    return offset;
  }

  /**
   * Gets the limit.
   *
   * Number of cases should be returned.
   *
   * @return the limit
   */
  public Long limit() {
    return limit;
  }

  /**
   * Gets the search.
   *
   * String that a case might contain.
   *
   * @return the search
   */
  public String search() {
    return search;
  }

  /**
   * Gets the sort.
   *
   * Sort field and direction. If omitted, default to descending of updated date. Prefix "~" signifies sort in
   * descending.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the status.
   *
   * Case status filter.
   *
   * @return the status
   */
  public List<String> status() {
    return status;
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

