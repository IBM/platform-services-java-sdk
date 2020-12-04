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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The listBillingOptions options.
 */
public class ListBillingOptionsOptions extends GenericModel {

  protected String billingUnitId;

  /**
   * Builder.
   */
  public static class Builder {
    private String billingUnitId;

    private Builder(ListBillingOptionsOptions listBillingOptionsOptions) {
      this.billingUnitId = listBillingOptionsOptions.billingUnitId;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param billingUnitId the billingUnitId
     */
    public Builder(String billingUnitId) {
      this.billingUnitId = billingUnitId;
    }

    /**
     * Builds a ListBillingOptionsOptions.
     *
     * @return the new ListBillingOptionsOptions instance
     */
    public ListBillingOptionsOptions build() {
      return new ListBillingOptionsOptions(this);
    }

    /**
     * Set the billingUnitId.
     *
     * @param billingUnitId the billingUnitId
     * @return the ListBillingOptionsOptions builder
     */
    public Builder billingUnitId(String billingUnitId) {
      this.billingUnitId = billingUnitId;
      return this;
    }
  }

  protected ListBillingOptionsOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.billingUnitId,
      "billingUnitId cannot be null");
    billingUnitId = builder.billingUnitId;
  }

  /**
   * New builder.
   *
   * @return a ListBillingOptionsOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the billingUnitId.
   *
   * The billing unit ID.
   *
   * @return the billingUnitId
   */
  public String billingUnitId() {
    return billingUnitId;
  }
}

