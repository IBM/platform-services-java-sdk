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

/*
 * IBM OpenAPI SDK Code Generator Version: 3.64.1-cee95189-20230124-211647
 */

package com.ibm.cloud.platform_services.enterprise_billing_units.v1;

import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingOptionsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnit;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.BillingUnitsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.CreditPoolsList;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetBillingUnitOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.GetCreditPoolsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingOptionsOptions;
import com.ibm.cloud.platform_services.enterprise_billing_units.v1.model.ListBillingUnitsOptions;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Billing units for IBM Cloud enterprises.
 *
 * API Version: 1.0.0
 */
public class EnterpriseBillingUnits extends BaseService {

  /**
   * Default service name used when configuring the `EnterpriseBillingUnits` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "enterprise_billing_units";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://billing.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `EnterpriseBillingUnits` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `EnterpriseBillingUnits` client using external configuration
   */
  public static EnterpriseBillingUnits newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `EnterpriseBillingUnits` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `EnterpriseBillingUnits` client using external configuration
   */
  public static EnterpriseBillingUnits newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    EnterpriseBillingUnits service = new EnterpriseBillingUnits(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `EnterpriseBillingUnits` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public EnterpriseBillingUnits(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get billing unit by ID.
   *
   * Return the billing unit information if it exists.
   *
   * @param getBillingUnitOptions the {@link GetBillingUnitOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BillingUnit}
   */
  public ServiceCall<BillingUnit> getBillingUnit(GetBillingUnitOptions getBillingUnitOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getBillingUnitOptions,
      "getBillingUnitOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("billing_unit_id", getBillingUnitOptions.billingUnitId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-units/{billing_unit_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_billing_units", "v1", "getBillingUnit");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<BillingUnit> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BillingUnit>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List billing units.
   *
   * Return matching billing unit information if any exists. Omits internal properties and enterprise account ID from
   * the billing unit.
   *
   * @param listBillingUnitsOptions the {@link ListBillingUnitsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BillingUnitsList}
   */
  public ServiceCall<BillingUnitsList> listBillingUnits(ListBillingUnitsOptions listBillingUnitsOptions) {
    if (listBillingUnitsOptions == null) {
      listBillingUnitsOptions = new ListBillingUnitsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-units"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_billing_units", "v1", "listBillingUnits");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listBillingUnitsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listBillingUnitsOptions.accountId()));
    }
    if (listBillingUnitsOptions.enterpriseId() != null) {
      builder.query("enterprise_id", String.valueOf(listBillingUnitsOptions.enterpriseId()));
    }
    if (listBillingUnitsOptions.accountGroupId() != null) {
      builder.query("account_group_id", String.valueOf(listBillingUnitsOptions.accountGroupId()));
    }
    if (listBillingUnitsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listBillingUnitsOptions.limit()));
    }
    if (listBillingUnitsOptions.start() != null) {
      builder.query("start", String.valueOf(listBillingUnitsOptions.start()));
    }
    ResponseConverter<BillingUnitsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BillingUnitsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List billing units.
   *
   * Return matching billing unit information if any exists. Omits internal properties and enterprise account ID from
   * the billing unit.
   *
   * @return a {@link ServiceCall} with a result of type {@link BillingUnitsList}
   */
  public ServiceCall<BillingUnitsList> listBillingUnits() {
    return listBillingUnits(null);
  }

  /**
   * List billing options.
   *
   * Return matching billing options if any exist. Show subscriptions and promotional offers that are available to a
   * billing unit.
   *
   * @param listBillingOptionsOptions the {@link ListBillingOptionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link BillingOptionsList}
   */
  public ServiceCall<BillingOptionsList> listBillingOptions(ListBillingOptionsOptions listBillingOptionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listBillingOptionsOptions,
      "listBillingOptionsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/billing-options"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_billing_units", "v1", "listBillingOptions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("billing_unit_id", String.valueOf(listBillingOptionsOptions.billingUnitId()));
    if (listBillingOptionsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listBillingOptionsOptions.limit()));
    }
    if (listBillingOptionsOptions.start() != null) {
      builder.query("start", String.valueOf(listBillingOptionsOptions.start()));
    }
    ResponseConverter<BillingOptionsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<BillingOptionsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get credit pools.
   *
   * Get credit pools for a billing unit. Credit pools can be either platform or support credit pools. The platform
   * credit pool contains credit from platform subscriptions and promotional offers. The support credit pool contains
   * credit from support subscriptions.
   *
   * @param getCreditPoolsOptions the {@link GetCreditPoolsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreditPoolsList}
   */
  public ServiceCall<CreditPoolsList> getCreditPools(GetCreditPoolsOptions getCreditPoolsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCreditPoolsOptions,
      "getCreditPoolsOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/credit-pools"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_billing_units", "v1", "getCreditPools");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("billing_unit_id", String.valueOf(getCreditPoolsOptions.billingUnitId()));
    if (getCreditPoolsOptions.date() != null) {
      builder.query("date", String.valueOf(getCreditPoolsOptions.date()));
    }
    if (getCreditPoolsOptions.type() != null) {
      builder.query("type", String.valueOf(getCreditPoolsOptions.type()));
    }
    if (getCreditPoolsOptions.limit() != null) {
      builder.query("limit", String.valueOf(getCreditPoolsOptions.limit()));
    }
    if (getCreditPoolsOptions.start() != null) {
      builder.query("start", String.valueOf(getCreditPoolsOptions.start()));
    }
    ResponseConverter<CreditPoolsList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreditPoolsList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
