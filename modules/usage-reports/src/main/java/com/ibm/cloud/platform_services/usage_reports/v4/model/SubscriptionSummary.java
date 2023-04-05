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

import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A summary of charges and credits related to a subscription.
 */
public class SubscriptionSummary extends GenericModel {

  protected Double overage;
  protected List<Subscription> subscriptions;

  protected SubscriptionSummary() { }

  /**
   * Gets the overage.
   *
   * The charges after exhausting subscription credits and offers credits.
   *
   * @return the overage
   */
  public Double getOverage() {
    return overage;
  }

  /**
   * Gets the subscriptions.
   *
   * The list of subscriptions applicable for the month.
   *
   * @return the subscriptions
   */
  public List<Subscription> getSubscriptions() {
    return subscriptions;
  }
}

