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
package com.ibm.cloud.platform_services.enterprise_billing_units.v1.model;

import java.util.List;
import java.util.Map;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Overage that was generated on the credit pool.
 */
public class CreditPoolOverage extends GenericModel {

  protected Double cost;
  protected List<Map<String, Object>> resources;

  protected CreditPoolOverage() { }

  /**
   * Gets the cost.
   *
   * The number of credits used as overage.
   *
   * @return the cost
   */
  public Double getCost() {
    return cost;
  }

  /**
   * Gets the resources.
   *
   * A list of resources that generated overage.
   *
   * @return the resources
   */
  public List<Map<String, Object>> getResources() {
    return resources;
  }
}

