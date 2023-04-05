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

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information about an individual offer.
 */
public class Offer extends GenericModel {

  @SerializedName("offer_id")
  protected String offerId;
  @SerializedName("credits_total")
  protected Double creditsTotal;
  @SerializedName("offer_template")
  protected String offerTemplate;
  @SerializedName("valid_from")
  protected Date validFrom;
  @SerializedName("expires_on")
  protected Date expiresOn;
  protected OfferCredits credits;

  protected Offer() { }

  /**
   * Gets the offerId.
   *
   * The ID of the offer.
   *
   * @return the offerId
   */
  public String getOfferId() {
    return offerId;
  }

  /**
   * Gets the creditsTotal.
   *
   * The total credits before applying the offer.
   *
   * @return the creditsTotal
   */
  public Double getCreditsTotal() {
    return creditsTotal;
  }

  /**
   * Gets the offerTemplate.
   *
   * The template with which the offer was generated.
   *
   * @return the offerTemplate
   */
  public String getOfferTemplate() {
    return offerTemplate;
  }

  /**
   * Gets the validFrom.
   *
   * The date from which the offer is valid.
   *
   * @return the validFrom
   */
  public Date getValidFrom() {
    return validFrom;
  }

  /**
   * Gets the expiresOn.
   *
   * The date until the offer is valid.
   *
   * @return the expiresOn
   */
  public Date getExpiresOn() {
    return expiresOn;
  }

  /**
   * Gets the credits.
   *
   * Credit information related to an offer.
   *
   * @return the credits
   */
  public OfferCredits getCredits() {
    return credits;
  }
}

