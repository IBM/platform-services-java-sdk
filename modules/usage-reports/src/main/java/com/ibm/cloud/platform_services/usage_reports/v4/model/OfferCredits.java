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
 * Credit information related to an offer.
 */
public class OfferCredits extends GenericModel {

  @SerializedName("starting_balance")
  protected Double startingBalance;
  protected Double used;
  protected Double balance;

  protected OfferCredits() { }

  /**
   * Gets the startingBalance.
   *
   * The available credits in the offer at the beginning of the month.
   *
   * @return the startingBalance
   */
  public Double getStartingBalance() {
    return startingBalance;
  }

  /**
   * Gets the used.
   *
   * The credits used in this month.
   *
   * @return the used
   */
  public Double getUsed() {
    return used;
  }

  /**
   * Gets the balance.
   *
   * The remaining credits in the offer.
   *
   * @return the balance
   */
  public Double getBalance() {
    return balance;
  }
}

