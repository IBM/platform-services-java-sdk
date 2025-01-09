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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The updatePreferenceOnScopeAccount options.
 */
public class UpdatePreferenceOnScopeAccountOptions extends GenericModel {

  protected String accountId;
  protected String iamId;
  protected String service;
  protected String preferenceId;
  protected String valueString;
  protected List<String> valueListOfStrings;

  /**
   * Builder.
   */
  public static class Builder {
    private String accountId;
    private String iamId;
    private String service;
    private String preferenceId;
    private String valueString;
    private List<String> valueListOfStrings;

    /**
     * Instantiates a new Builder from an existing UpdatePreferenceOnScopeAccountOptions instance.
     *
     * @param updatePreferenceOnScopeAccountOptions the instance to initialize the Builder with
     */
    private Builder(UpdatePreferenceOnScopeAccountOptions updatePreferenceOnScopeAccountOptions) {
      this.accountId = updatePreferenceOnScopeAccountOptions.accountId;
      this.iamId = updatePreferenceOnScopeAccountOptions.iamId;
      this.service = updatePreferenceOnScopeAccountOptions.service;
      this.preferenceId = updatePreferenceOnScopeAccountOptions.preferenceId;
      this.valueString = updatePreferenceOnScopeAccountOptions.valueString;
      this.valueListOfStrings = updatePreferenceOnScopeAccountOptions.valueListOfStrings;
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
     * @param iamId the iamId
     * @param service the service
     * @param preferenceId the preferenceId
     * @param valueString the valueString
     */
    public Builder(String accountId, String iamId, String service, String preferenceId, String valueString) {
      this.accountId = accountId;
      this.iamId = iamId;
      this.service = service;
      this.preferenceId = preferenceId;
      this.valueString = valueString;
    }

    /**
     * Builds a UpdatePreferenceOnScopeAccountOptions.
     *
     * @return the new UpdatePreferenceOnScopeAccountOptions instance
     */
    public UpdatePreferenceOnScopeAccountOptions build() {
      return new UpdatePreferenceOnScopeAccountOptions(this);
    }

    /**
     * Adds a new element to valueListOfStrings.
     *
     * @param valueListOfStrings the new element to be added
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder addValueListOfStrings(String valueListOfStrings) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(valueListOfStrings,
        "valueListOfStrings cannot be null");
      if (this.valueListOfStrings == null) {
        this.valueListOfStrings = new ArrayList<String>();
      }
      this.valueListOfStrings.add(valueListOfStrings);
      return this;
    }

    /**
     * Set the accountId.
     *
     * @param accountId the accountId
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder accountId(String accountId) {
      this.accountId = accountId;
      return this;
    }

    /**
     * Set the iamId.
     *
     * @param iamId the iamId
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder iamId(String iamId) {
      this.iamId = iamId;
      return this;
    }

    /**
     * Set the service.
     *
     * @param service the service
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder service(String service) {
      this.service = service;
      return this;
    }

    /**
     * Set the preferenceId.
     *
     * @param preferenceId the preferenceId
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder preferenceId(String preferenceId) {
      this.preferenceId = preferenceId;
      return this;
    }

    /**
     * Set the valueString.
     *
     * @param valueString the valueString
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder valueString(String valueString) {
      this.valueString = valueString;
      return this;
    }

    /**
     * Set the valueListOfStrings.
     * Existing valueListOfStrings will be replaced.
     *
     * @param valueListOfStrings the valueListOfStrings
     * @return the UpdatePreferenceOnScopeAccountOptions builder
     */
    public Builder valueListOfStrings(List<String> valueListOfStrings) {
      this.valueListOfStrings = valueListOfStrings;
      return this;
    }
  }

  protected UpdatePreferenceOnScopeAccountOptions() { }

  protected UpdatePreferenceOnScopeAccountOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.accountId,
      "accountId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.iamId,
      "iamId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.service,
      "service cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.preferenceId,
      "preferenceId cannot be empty");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.valueString,
      "valueString cannot be null");
    accountId = builder.accountId;
    iamId = builder.iamId;
    service = builder.service;
    preferenceId = builder.preferenceId;
    valueString = builder.valueString;
    valueListOfStrings = builder.valueListOfStrings;
  }

  /**
   * New builder.
   *
   * @return a UpdatePreferenceOnScopeAccountOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the accountId.
   *
   * Account id to update preference for.
   *
   * @return the accountId
   */
  public String accountId() {
    return accountId;
  }

  /**
   * Gets the iamId.
   *
   * IAM id to update the preference for.
   *
   * @return the iamId
   */
  public String iamId() {
    return iamId;
  }

  /**
   * Gets the service.
   *
   * Service of the preference to be updated.
   *
   * @return the service
   */
  public String service() {
    return service;
  }

  /**
   * Gets the preferenceId.
   *
   * Identifier of preference to be updated.
   *
   * @return the preferenceId
   */
  public String preferenceId() {
    return preferenceId;
  }

  /**
   * Gets the valueString.
   *
   * contains a string value of the preference. only one value property is set, either 'value_string' or
   * 'value_list_of_strings' is present.
   *
   * @return the valueString
   */
  public String valueString() {
    return valueString;
  }

  /**
   * Gets the valueListOfStrings.
   *
   * contains a list of string values of the preference. only one value property is set, either 'value_string' or
   * 'value_list_of_strings' is present.
   *
   * @return the valueListOfStrings
   */
  public List<String> valueListOfStrings() {
    return valueListOfStrings;
  }
}

