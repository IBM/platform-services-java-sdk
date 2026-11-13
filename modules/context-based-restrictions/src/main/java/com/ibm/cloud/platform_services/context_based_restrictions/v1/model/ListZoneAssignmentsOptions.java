/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listZoneAssignments options.
 */
public class ListZoneAssignmentsOptions extends GenericModel {

  /**
   * The type of the target enterprise entity (e.g. `Account`).
   */
  public interface TargetType {
    /** Account. */
    String ACCOUNT = "Account";
    /** AccountGroup. */
    String ACCOUNTGROUP = "AccountGroup";
    /** Enterprise. */
    String ENTERPRISE = "Enterprise";
  }

  /**
   * The status of the zone assignment.
   */
  public interface Status {
    /** accepted. */
    String ACCEPTED = "accepted";
    /** in_progress. */
    String IN_PROGRESS = "in_progress";
    /** succeeded. */
    String SUCCEEDED = "succeeded";
    /** failure. */
    String FAILURE = "failure";
    /** superseded. */
    String SUPERSEDED = "superseded";
  }

  protected String accountId;
  protected String xCorrelationId;
  protected String transactionId;
  protected String zoneId;
  protected String targetType;
  protected String targetId;
  protected String status;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String xCorrelationId;
    private String transactionId;
    private String zoneId;
    private String targetType;
    private String targetId;
    private String status;
    private String sort;

    /**
     * Instantiates a new Builder from an existing ListZoneAssignmentsOptions instance.
     *
     * @param listZoneAssignmentsOptions the instance to initialize the Builder with
     */
    private Builder(ListZoneAssignmentsOptions listZoneAssignmentsOptions) {
      this.accountId = listZoneAssignmentsOptions.accountId;
      this.xCorrelationId = listZoneAssignmentsOptions.xCorrelationId;
      this.transactionId = listZoneAssignmentsOptions.transactionId;
      this.zoneId = listZoneAssignmentsOptions.zoneId;
      this.targetType = listZoneAssignmentsOptions.targetType;
      this.targetId = listZoneAssignmentsOptions.targetId;
      this.status = listZoneAssignmentsOptions.status;
      this.sort = listZoneAssignmentsOptions.sort;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param accountId the accountId
     */
    public Builder(String accountId) {
      this.accountId = accountId;
    }

    /**
     * Builds a ListZoneAssignmentsOptions.
     *
     * @return the new ListZoneAssignmentsOptions instance
     */
    public ListZoneAssignmentsOptions build() {
      return new ListZoneAssignmentsOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the xCorrelationId.
     *
     * @param xCorrelationId the xCorrelationId
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder xCorrelationId(String xCorrelationId) {
      this.xCorrelationId = xCorrelationId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListZoneAssignmentsOptions builder
     * @deprecated this method is deprecated and may be removed in a future release
     */
    @Deprecated
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the zoneId.
     *
     * @param zoneId the zoneId
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder zoneId(String zoneId) {
      this.zoneId = zoneId;
      return this;
    }

    /**
     * Set the targetType.
     *
     * @param targetType the targetType
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder targetType(String targetType) {
      this.targetType = targetType;
      return this;
    }

    /**
     * Set the targetId.
     *
     * @param targetId the targetId
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder targetId(String targetId) {
      this.targetId = targetId;
      return this;
    }

    /**
     * Set the status.
     *
     * @param status the status
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder status(String status) {
      this.status = status;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListZoneAssignmentsOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListZoneAssignmentsOptions() { }

  protected ListZoneAssignmentsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    xCorrelationId = builder.xCorrelationId;
    transactionId = builder.transactionId;
    zoneId = builder.zoneId;
    targetType = builder.targetType;
    targetId = builder.targetId;
    status = builder.status;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListZoneAssignmentsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * The ID of the managing account.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the xCorrelationId.
   *
   * The supplied or generated value of this header is logged for a request and repeated in a response header for the
   * corresponding response. The same value is used for downstream requests and retries of those requests. If a value of
   * this headers is not supplied in a request, the service generates a random (version 4) UUID.
   *
   * @return the xCorrelationId
   */
  public String xCorrelationId() {
    return xCorrelationId;
  }

  /**
   * Gets the transactionId.
   *
   * The `Transaction-Id` header behaves as the `X-Correlation-Id` header. It is supported for backward compatibility
   * with other IBM platform services that support the `Transaction-Id` header only. If both `X-Correlation-Id` and
   * `Transaction-Id` are provided, `X-Correlation-Id` has the precedence over `Transaction-Id`.
   *
   * @return the transactionId
   * @deprecated this method is deprecated and may be removed in a future release
   */
  @Deprecated
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the zoneId.
   *
   * The globally unique ID of the zone.
   *
   * @return the zoneId
   */
  public String zoneId() {
    return zoneId;
  }

  /**
   * Gets the targetType.
   *
   * The type of the target enterprise entity (e.g. `Account`).
   *
   * @return the targetType
   */
  public String targetType() {
    return targetType;
  }

  /**
   * Gets the targetId.
   *
   * The ID of the target enterprise entity.
   *
   * @return the targetId
   */
  public String targetId() {
    return targetId;
  }

  /**
   * Gets the status.
   *
   * The status of the zone assignment.
   *
   * @return the status
   */
  public String status() {
    return status;
  }

  /**
   * Gets the sort.
   *
   * Sorts results by using a valid sort field. To learn more, see
   * [Sorting](https://cloud.ibm.com/docs/api-handbook?topic=api-handbook-sorting).
   *
   * @return the sort
   */
  public String sort() {
    return sort;
  }
}

