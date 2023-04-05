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
package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about a discount that is associated with a metric.
 */
public class Discount extends GenericModel {

  protected String ref;
  protected String name;
  @SerializedName("display_name")
  protected String displayName;
  protected Double discount;

  protected Discount() { }

  /**
   * Gets the ref.
   *
   * The reference ID of the discount.
   *
   * @return the ref
   */
  public String getRef() {
    return ref;
  }

  /**
   * Gets the name.
   *
   * The name of the discount indicating category.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the displayName.
   *
   * The name of the discount.
   *
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * Gets the discount.
   *
   * The discount percentage.
   *
   * @return the discount
   */
  public Double getDiscount() {
    return discount;
  }
}

