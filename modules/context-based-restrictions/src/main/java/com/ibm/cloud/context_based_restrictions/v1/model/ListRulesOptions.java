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
package com.ibm.cloud.context_based_restrictions.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listRules options.
 */
public class ListRulesOptions extends GenericModel {

  protected String accountId;
  protected String transactionId;
  protected String region;
  protected String resource;
  protected String resourceType;
  protected String serviceInstance;
  protected String serviceName;
  protected String serviceType;
  protected String zoneId;
  protected String sort;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String transactionId;
    private String region;
    private String resource;
    private String resourceType;
    private String serviceInstance;
    private String serviceName;
    private String serviceType;
    private String zoneId;
    private String sort;

    private Builder(ListRulesOptions listRulesOptions) {
      this.accountId = listRulesOptions.accountId;
      this.transactionId = listRulesOptions.transactionId;
      this.region = listRulesOptions.region;
      this.resource = listRulesOptions.resource;
      this.resourceType = listRulesOptions.resourceType;
      this.serviceInstance = listRulesOptions.serviceInstance;
      this.serviceName = listRulesOptions.serviceName;
      this.serviceType = listRulesOptions.serviceType;
      this.zoneId = listRulesOptions.zoneId;
      this.sort = listRulesOptions.sort;
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
     * Builds a ListRulesOptions.
     *
     * @return the new ListRulesOptions instance
     */
    public ListRulesOptions build() {
      return new ListRulesOptions(this);
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the ListRulesOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the transactionId.
     *
     * @param transactionId the transactionId
     * @return the ListRulesOptions builder
     */
    public Builder transactionId(String transactionId) {
      this.transactionId = transactionId;
      return this;
    }

    /**
     * Set the region.
     *
     * @param region the region
     * @return the ListRulesOptions builder
     */
    public Builder region(String region) {
      this.region = region;
      return this;
    }

    /**
     * Set the resource.
     *
     * @param resource the resource
     * @return the ListRulesOptions builder
     */
    public Builder resource(String resource) {
      this.resource = resource;
      return this;
    }

    /**
     * Set the resourceType.
     *
     * @param resourceType the resourceType
     * @return the ListRulesOptions builder
     */
    public Builder resourceType(String resourceType) {
      this.resourceType = resourceType;
      return this;
    }

    /**
     * Set the serviceInstance.
     *
     * @param serviceInstance the serviceInstance
     * @return the ListRulesOptions builder
     */
    public Builder serviceInstance(String serviceInstance) {
      this.serviceInstance = serviceInstance;
      return this;
    }

    /**
     * Set the serviceName.
     *
     * @param serviceName the serviceName
     * @return the ListRulesOptions builder
     */
    public Builder serviceName(String serviceName) {
      this.serviceName = serviceName;
      return this;
    }

    /**
     * Set the serviceType.
     *
     * @param serviceType the serviceType
     * @return the ListRulesOptions builder
     */
    public Builder serviceType(String serviceType) {
      this.serviceType = serviceType;
      return this;
    }

    /**
     * Set the zoneId.
     *
     * @param zoneId the zoneId
     * @return the ListRulesOptions builder
     */
    public Builder zoneId(String zoneId) {
      this.zoneId = zoneId;
      return this;
    }

    /**
     * Set the sort.
     *
     * @param sort the sort
     * @return the ListRulesOptions builder
     */
    public Builder sort(String sort) {
      this.sort = sort;
      return this;
    }
  }

  protected ListRulesOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.accountId,
      "accountId cannot be null");
    accountId = builder.accountId;
    transactionId = builder.transactionId;
    region = builder.region;
    resource = builder.resource;
    resourceType = builder.resourceType;
    serviceInstance = builder.serviceInstance;
    serviceName = builder.serviceName;
    serviceType = builder.serviceType;
    zoneId = builder.zoneId;
    sort = builder.sort;
  }

  /**
   * New builder.
   *
   * @return a ListRulesOptions builder
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
   * Gets the transactionId.
   *
   * The UUID that is used to correlate and track transactions. If you omit this field, the service generates and sends
   * a transaction ID in the response.
   * **Note:** To help with debugging, we strongly recommend that you generate and supply a `Transaction-Id` with each
   * request.
   *
   * @return the transactionId
   */
  public String transactionId() {
    return transactionId;
  }

  /**
   * Gets the region.
   *
   * The `region` resource attribute.
   *
   * @return the region
   */
  public String region() {
    return region;
  }

  /**
   * Gets the resource.
   *
   * The `resource` resource attribute.
   *
   * @return the resource
   */
  public String resource() {
    return resource;
  }

  /**
   * Gets the resourceType.
   *
   * The `resourceType` resource attribute.
   *
   * @return the resourceType
   */
  public String resourceType() {
    return resourceType;
  }

  /**
   * Gets the serviceInstance.
   *
   * The `serviceInstance` resource attribute.
   *
   * @return the serviceInstance
   */
  public String serviceInstance() {
    return serviceInstance;
  }

  /**
   * Gets the serviceName.
   *
   * The `serviceName` resource attribute.
   *
   * @return the serviceName
   */
  public String serviceName() {
    return serviceName;
  }

  /**
   * Gets the serviceType.
   *
   * The rule's `serviceType` resource attribute.
   *
   * @return the serviceType
   */
  public String serviceType() {
    return serviceType;
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

