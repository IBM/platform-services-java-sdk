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
package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * BSS License provider.
 */
public class LicenseProvider extends GenericModel {

  protected String name;
  @SerializedName("short_description")
  protected String shortDescription;
  protected String id;
  @SerializedName("licence_type")
  protected String licenceType;
  @SerializedName("offering_type")
  protected String offeringType;
  @SerializedName("create_url")
  protected String createUrl;
  @SerializedName("info_url")
  protected String infoUrl;
  protected String url;
  protected String crn;
  protected String state;

  /**
   * Gets the name.
   *
   * Provider name, eg. IBM Passport Advantage.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the shortDescription.
   *
   * Short description of license provider.
   *
   * @return the shortDescription
   */
  public String getShortDescription() {
    return shortDescription;
  }

  /**
   * Gets the id.
   *
   * Provider ID.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the licenceType.
   *
   * Type of license entitlement, e.g. ibm-ppa.
   *
   * @return the licenceType
   */
  public String getLicenceType() {
    return licenceType;
  }

  /**
   * Gets the offeringType.
   *
   * Type of offering.
   *
   * @return the offeringType
   */
  public String getOfferingType() {
    return offeringType;
  }

  /**
   * Gets the createUrl.
   *
   * URL of the license provider for where to create/get a license, e.g.
   * https://www.ibm.com/software/passportadvantage/aboutpassport.html.
   *
   * @return the createUrl
   */
  public String getCreateUrl() {
    return createUrl;
  }

  /**
   * Gets the infoUrl.
   *
   * URL of the license provider for additional info, e.g. https://www.ibm.com/software/passportadvantage.
   *
   * @return the infoUrl
   */
  public String getInfoUrl() {
    return infoUrl;
  }

  /**
   * Gets the url.
   *
   * URL for the BSS license provider, e.g. /v1/licensing/license_providers/:id.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * Gets the crn.
   *
   * Provider CRN.
   *
   * @return the crn
   */
  public String getCrn() {
    return crn;
  }

  /**
   * Gets the state.
   *
   * State of license provider.
   *
   * @return the state
   */
  public String getState() {
    return state;
  }
}

