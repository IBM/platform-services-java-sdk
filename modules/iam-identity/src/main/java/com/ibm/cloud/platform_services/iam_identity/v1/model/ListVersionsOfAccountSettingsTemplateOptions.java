/*
 * (C) Copyright IBM Corp. 2023.
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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listVersionsOfAccountSettingsTemplate options.
 */
public class ListVersionsOfAccountSettingsTemplateOptions extends GenericModel {

  /**
   * Optional sort property. If specified, the returned templated are sorted according to this property.
   */
  public interface Sort {
    /** created_at. */
    String CREATED_AT = "created_at";
    /** last_modified_at. */
    String LAST_MODIFIED_AT = "last_modified_at";
    /** name. */
    String NAME = "name";
  }

  /**
   * Optional sort order.
   */
  public interface Order {
    /** asc. */
    String ASC = "asc";
    /** desc. */
    String DESC = "desc";
  }

  protected String templateId;
  protected String limit;
  protected String pagetoken;
  protected String sort;
  protected String order;
  protected String includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String templateId;
    private String limit;
    private String pagetoken;
    private String sort;
    private String order;
    private String includeHistory;

    /**
     * Instantiates a new Builder from an existing ListVersionsOfAccountSettingsTemplateOptions instance.
     *
     * @param listVersionsOfAccountSettingsTemplateOptions the instance to initialize the Builder with
     */
    private Builder(ListVersionsOfAccountSettingsTemplateOptions listVersionsOfAccountSettingsTemplateOptions) {
      this.templateId = listVersionsOfAccountSettingsTemplateOptions.templateId;
      this.limit = listVersionsOfAccountSettingsTemplateOptions.limit;
      this.pagetoken = listVersionsOfAccountSettingsTemplateOptions.pagetoken;
      this.sort = listVersionsOfAccountSettingsTemplateOptions.sort;
      this.order = listVersionsOfAccountSettingsTemplateOptions.order;
      this.includeHistory = listVersionsOfAccountSettingsTemplateOptions.includeHistory;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param templateId the templateId
     */
    public Builder(String templateId) {
      this.templateId = templateId;
    }

    /**
     * Builds a ListVersionsOfAccountSettingsTemplateOptions.
     *
     * @return the new ListVersionsOfAccountSettingsTemplateOptions instance
     */
    public ListVersionsOfAccountSettingsTemplateOptions build() {
      return new ListVersionsOfAccountSettingsTemplateOptions(this);
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ListVersionsOfAccountSettingsTemplateOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListVersionsOfAccountSettingsTemplateOptions builder
     */
    public Builder limit(String limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListVersionsOfAccountSettingsTemplateOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListVersionsOfAccountSettingsTemplateOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListVersionsOfAccountSettingsTemplateOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListVersionsOfAccountSettingsTemplateOptions builder
     */
    public Builder includeHistory(String includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected ListVersionsOfAccountSettingsTemplateOptions() { }

  protected ListVersionsOfAccountSettingsTemplateOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.templateId,
      "templateId cannot be empty");
    templateId = builder.templateId;
    limit = builder.limit;
    pagetoken = builder.pagetoken;
    sort = builder.sort;
    order = builder.order;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a ListVersionsOfAccountSettingsTemplateOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the templateId.
   *
   * ID of the account settings template.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the limit.
   *
   * Optional size of a single page.
   *
   * @return the limit
   */
  public String limit() {
    return limit;
  }

  /**
   * Gets the pagetoken.
   *
   * Optional Prev or Next page token returned from a previous query execution. Default is start with first page.
   *
   * @return the pagetoken
   */
  public String pagetoken() {
    return pagetoken;
  }

  /**
   * Gets the sort.
   *
   * Optional sort property. If specified, the returned templated are sorted according to this property.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the order.
   *
   * Optional sort order.
   *
   * @return the order
   */
  public String order() {
    return order;
  }

  /**
   * Gets the includeHistory.
   *
   * Defines if the entity history is included in the response.
   *
   * @return the includeHistory
   */
  public String includeHistory() {
    return includeHistory;
  }
}

