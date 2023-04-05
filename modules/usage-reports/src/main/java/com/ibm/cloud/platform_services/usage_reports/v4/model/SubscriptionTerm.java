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

import java.util.Date;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * SubscriptionTerm.
 */
public class SubscriptionTerm extends GenericModel {

  protected Date start;
  protected Date end;
  protected SubscriptionTermCredits credits;

  protected SubscriptionTerm() { }

  /**
   * Gets the start.
   *
   * The start date of the term.
   *
   * @return the start
   */
  public Date getStart() {
    return start;
  }

  /**
   * Gets the end.
   *
   * The end date of the term.
   *
   * @return the end
   */
  public Date getEnd() {
    return end;
  }

  /**
   * Gets the credits.
   *
   * Information about credits related to a subscription.
   *
   * @return the credits
   */
  public SubscriptionTermCredits getCredits() {
    return credits;
  }
}

