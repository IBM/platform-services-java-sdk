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
 * The listTrustedProfileAssignments options.
 */
public class ListTrustedProfileAssignmentsOptions extends GenericModel {

  /**
   * Filter results by the assignment's target type.
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
  }

  /**
   * If specified, the items are sorted by the value of this property.
   */
  public interface Sort {
    /** template_id. */
    String TEMPLATE_ID = "template_id";
    /** created_at. */
    String CREATED_AT = "created_at";
    /** last_modified_at. */
    String LAST_MODIFIED_AT = "last_modified_at";
  }

  /**
   * Sort order.
   */
  public interface Order {
    /** asc. */
    String ASC = "asc";
    /** desc. */
    String DESC = "desc";
  }

  protected String accountId;
  protected String templateId;
  protected String templateVersion;
  protected String target;
  protected String targetType;
  protected Long limit;
  protected String pagetoken;
  protected String sort;
  protected String order;
  protected Boolean includeHistory;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String templateId;
    private String templateVersion;
    private String target;
    private String targetType;
    private Long limit;
    private String pagetoken;
    private String sort;
    private String order;
    private Boolean includeHistory;

    /**
     * Instantiates a new Builder from an existing ListTrustedProfileAssignmentsOptions instance.
     *
     * @param listTrustedProfileAssignmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListTrustedProfileAssignmentsOptions listTrustedProfileAssignmentsOptions) {
      this.accountId = listTrustedProfileAssignmentsOptions.accountId;
      this.templateId = listTrustedProfileAssignmentsOptions.templateId;
      this.templateVersion = listTrustedProfileAssignmentsOptions.templateVersion;
      this.target = listTrustedProfileAssignmentsOptions.target;
      this.targetType = listTrustedProfileAssignmentsOptions.targetType;
      this.limit = listTrustedProfileAssignmentsOptions.limit;
      this.pagetoken = listTrustedProfileAssignmentsOptions.pagetoken;
      this.sort = listTrustedProfileAssignmentsOptions.sort;
      this.order = listTrustedProfileAssignmentsOptions.order;
      this.includeHistory = listTrustedProfileAssignmentsOptions.includeHistory;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a ListTrustedProfileAssignmentsOptions.
     *
     * @return the new ListTrustedProfileAssignmentsOptions instance
     */
    public ListTrustedProfileAssignmentsOptions build() {
      return new ListTrustedProfileAssignmentsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the templateId.
     *
     * @param templateId the templateId
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder templateId(String templateId) {
      this.templateId = templateId;
      return this;
    }

    /**
     * Set the templateVersion.
     *
     * @param templateVersion the templateVersion
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder templateVersion(String templateVersion) {
      this.templateVersion = templateVersion;
      return this;
    }

    /**
     * Set the target.
     *
     * @param target the target
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder target(String target) {
      this.target = target;
      return this;
    }

    /**
     * Set the targetType.
     *
     * @param targetType the targetType
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder targetType(String targetType) {
      this.targetType = targetType;
      return this;
    }

    /**
     * Set the limit.
     *
     * @param limit the limit
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    /**
     * Set the pagetoken.
     *
     * @param pagetoken the pagetoken
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder pagetoken(String pagetoken) {
      this.pagetoken = pagetoken;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }

    /**
     * Set the order.
     *
     * @param order the order
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder order(String order) {
      this.order = order;
      return this;
    }

    /**
     * Set the includeHistory.
     *
     * @param includeHistory the includeHistory
     * @return the ListTrustedProfileAssignmentsOptions builder
     */
    public Builder includeHistory(Boolean includeHistory) {
      this.includeHistory = includeHistory;
      return this;
    }
  }

  protected ListTrustedProfileAssignmentsOptions() { }

  protected ListTrustedProfileAssignmentsOptions(Builder builder) {
    accountId = builder.accountId;
    templateId = builder.templateId;
    templateVersion = builder.templateVersion;
    target = builder.target;
    targetType = builder.targetType;
    limit = builder.limit;
    pagetoken = builder.pagetoken;
    sort = builder.sort;
    order = builder.order;
    includeHistory = builder.includeHistory;
  }

  /**
   * New builder.
   *
   * @return a ListTrustedProfileAssignmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the Assignments to query. This parameter is required unless using a pagetoken.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the templateId.
   *
   * Filter results by Template Id.
   *
   * @return the templateId
   */
  public String templateId() {
    return templateId;
  }

  /**
   * Gets the templateVersion.
   *
   * Filter results Template Version.
   *
   * @return the templateVersion
   */
  public String templateVersion() {
    return templateVersion;
  }

  /**
   * Gets the target.
   *
   * Filter results by the assignment target.
   *
   * @return the target
   */
  public String target() {
    return target;
  }

  /**
   * Gets the targetType.
   *
   * Filter results by the assignment's target type.
   *
   * @return the targetType
   */
  public String targetType() {
    return targetType;
  }

  /**
   * Gets the limit.
   *
   * Optional size of a single page. Default is 20 items per page. Valid range is 1 to 100.
   *
   * @return the limit
   */
  public Long limit() {
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
   * If specified, the items are sorted by the value of this property.
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }

  /**
   * Gets the order.
   *
   * Sort order.
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
  public Boolean includeHistory() {
    return includeHistory;
  }
}

