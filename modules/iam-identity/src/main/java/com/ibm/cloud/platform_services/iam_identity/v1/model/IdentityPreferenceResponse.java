/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * IdentityPreferenceResponse.
 */
public class IdentityPreferenceResponse extends GenericModel {

  protected String service;
  protected String id;
  @SerializedName("account_id")
  protected String accountId;
  protected String scope;
  @SerializedName("value_string")
  protected String valueString;
  @SerializedName("value_list_of_strings")
  protected List<String> valueListOfStrings;

  protected IdentityPreferenceResponse() { }

  /**
   * Gets the service.
   *
   * Service of the preference.
   *
   * @return the service
   */
  public String getService() {
    return service;
  }

  /**
   * Gets the id.
   *
   * Unique ID of the preference.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the accountId.
   *
   * Account ID of the preference, only present for scope 'account'.
   *
   * @return the accountId
   */
  public String getAccountId() {
    return accountId;
  }

  /**
   * Gets the scope.
   *
   * Scope of the preference, 'global' or 'account'.
   *
   * @return the scope
   */
  public String getScope() {
    return scope;
  }

  /**
   * Gets the valueString.
   *
   * String value of the preference, only one value property is set, either 'value_string' or 'value_list_of_strings' is
   * present.
   *
   * @return the valueString
   */
  public String getValueString() {
    return valueString;
  }

  /**
   * Gets the valueListOfStrings.
   *
   * List of value of the preference, only one value property is set, either 'value_string' or 'value_list_of_strings'
   * is present.
   *
   * @return the valueListOfStrings
   */
  public List<String> getValueListOfStrings() {
    return valueListOfStrings;
  }
}

