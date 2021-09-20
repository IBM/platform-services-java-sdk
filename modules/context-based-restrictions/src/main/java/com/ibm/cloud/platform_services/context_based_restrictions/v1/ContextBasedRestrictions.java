/*
 * (C) Copyright IBM Corp. 2021.
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
 * IBM OpenAPI SDK Code Generator Version: 3.36.0-6f5b0381-20210716-180747
 */

package com.ibm.cloud.platform_services.context_based_restrictions.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.CreateZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.DeleteZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.GetZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListAvailableServicerefTargetsOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ListZonesOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutAccountSettings;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutRule;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutRulePage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZone;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.OutZonePage;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceRuleOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ReplaceZoneOptions;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ServiceRefTargetPage;
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
 * With the Context Based Restrictions API, you can:
 * * Create, list, get, update, and delete network zones
 * * Create, list, get, update, and delete context-based restriction rules
 * * Get account settings
 * .
 *
 * @version v1
 */
public class ContextBasedRestrictions extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "context_based_restrictions";

  public static final String DEFAULT_SERVICE_URL = "https://cbr.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `ContextBasedRestrictions` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ContextBasedRestrictions` client using external configuration
   */
  public static ContextBasedRestrictions newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ContextBasedRestrictions` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ContextBasedRestrictions` client using external configuration
   */
  public static ContextBasedRestrictions newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ContextBasedRestrictions service = new ContextBasedRestrictions(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ContextBasedRestrictions` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ContextBasedRestrictions(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Create a zone.
   *
   * This operation creates a network zone for the specified account.
   *
   * @param createZoneOptions the {@link CreateZoneOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutZone}
   */
  public ServiceCall<OutZone> createZone(CreateZoneOptions createZoneOptions) {
    boolean skipBody = false;
    if (createZoneOptions == null) {
      createZoneOptions = new CreateZoneOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/zones"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "createZone");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createZoneOptions.transactionId() != null) {
      builder.header("Transaction-Id", createZoneOptions.transactionId());
    }
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createZoneOptions.name() != null) {
        contentJson.addProperty("name", createZoneOptions.name());
      }
      if (createZoneOptions.accountId() != null) {
        contentJson.addProperty("account_id", createZoneOptions.accountId());
      }
      if (createZoneOptions.description() != null) {
        contentJson.addProperty("description", createZoneOptions.description());
      }
      if (createZoneOptions.addresses() != null) {
        contentJson.add("addresses", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createZoneOptions.addresses()));
      }
      if (createZoneOptions.excluded() != null) {
        contentJson.add("excluded", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createZoneOptions.excluded()));
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<OutZone> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutZone>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a zone.
   *
   * This operation creates a network zone for the specified account.
   *
   * @return a {@link ServiceCall} with a result of type {@link OutZone}
   */
  public ServiceCall<OutZone> createZone() {
    return createZone(null);
  }

  /**
   * List network zones.
   *
   * This operation lists network zones in the specified account.
   *
   * @param listZonesOptions the {@link ListZonesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutZonePage}
   */
  public ServiceCall<OutZonePage> listZones(ListZonesOptions listZonesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listZonesOptions,
      "listZonesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/zones"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "listZones");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listZonesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listZonesOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(listZonesOptions.accountId()));
    if (listZonesOptions.name() != null) {
      builder.query("name", String.valueOf(listZonesOptions.name()));
    }
    if (listZonesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listZonesOptions.sort()));
    }
    ResponseConverter<OutZonePage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutZonePage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the specified network zone.
   *
   * This operation returns the network zone for the specified ID.
   *
   * @param getZoneOptions the {@link GetZoneOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutZone}
   */
  public ServiceCall<OutZone> getZone(GetZoneOptions getZoneOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getZoneOptions,
      "getZoneOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("zone_id", getZoneOptions.zoneId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/zones/{zone_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "getZone");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getZoneOptions.transactionId() != null) {
      builder.header("Transaction-Id", getZoneOptions.transactionId());
    }
    ResponseConverter<OutZone> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutZone>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update the specified network zone.
   *
   * This operation updates the network zone with the specified ID.
   *
   * @param replaceZoneOptions the {@link ReplaceZoneOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutZone}
   */
  public ServiceCall<OutZone> replaceZone(ReplaceZoneOptions replaceZoneOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceZoneOptions,
      "replaceZoneOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("zone_id", replaceZoneOptions.zoneId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/zones/{zone_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "replaceZone");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceZoneOptions.ifMatch());
    if (replaceZoneOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceZoneOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceZoneOptions.name() != null) {
      contentJson.addProperty("name", replaceZoneOptions.name());
    }
    if (replaceZoneOptions.accountId() != null) {
      contentJson.addProperty("account_id", replaceZoneOptions.accountId());
    }
    if (replaceZoneOptions.description() != null) {
      contentJson.addProperty("description", replaceZoneOptions.description());
    }
    if (replaceZoneOptions.addresses() != null) {
      contentJson.add("addresses", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceZoneOptions.addresses()));
    }
    if (replaceZoneOptions.excluded() != null) {
      contentJson.add("excluded", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceZoneOptions.excluded()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<OutZone> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutZone>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete the specified network zone.
   *
   * This operation deletes the network zone with the specified home ID.
   *
   * @param deleteZoneOptions the {@link DeleteZoneOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteZone(DeleteZoneOptions deleteZoneOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteZoneOptions,
      "deleteZoneOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("zone_id", deleteZoneOptions.zoneId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/zones/{zone_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "deleteZone");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteZoneOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteZoneOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List available service reference targets.
   *
   * This operation lists all available service reference targets.
   *
   * @param listAvailableServicerefTargetsOptions the {@link ListAvailableServicerefTargetsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ServiceRefTargetPage}
   */
  public ServiceCall<ServiceRefTargetPage> listAvailableServicerefTargets(ListAvailableServicerefTargetsOptions listAvailableServicerefTargetsOptions) {
    if (listAvailableServicerefTargetsOptions == null) {
      listAvailableServicerefTargetsOptions = new ListAvailableServicerefTargetsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/zones/serviceref_targets"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "listAvailableServicerefTargets");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAvailableServicerefTargetsOptions.type() != null) {
      builder.query("type", String.valueOf(listAvailableServicerefTargetsOptions.type()));
    }
    ResponseConverter<ServiceRefTargetPage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ServiceRefTargetPage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List available service reference targets.
   *
   * This operation lists all available service reference targets.
   *
   * @return a {@link ServiceCall} with a result of type {@link ServiceRefTargetPage}
   */
  public ServiceCall<ServiceRefTargetPage> listAvailableServicerefTargets() {
    return listAvailableServicerefTargets(null);
  }

  /**
   * Create a rule.
   *
   * This operation creates a rule for the specified account.
   *
   * @param createRuleOptions the {@link CreateRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutRule}
   */
  public ServiceCall<OutRule> createRule(CreateRuleOptions createRuleOptions) {
    boolean skipBody = false;
    if (createRuleOptions == null) {
      createRuleOptions = new CreateRuleOptions.Builder().build();
      skipBody = true;
    }
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/rules"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "createRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", createRuleOptions.transactionId());
    }
    if (!skipBody) {
      final JsonObject contentJson = new JsonObject();
      if (createRuleOptions.description() != null) {
        contentJson.addProperty("description", createRuleOptions.description());
      }
      if (createRuleOptions.contexts() != null) {
        contentJson.add("contexts", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.contexts()));
      }
      if (createRuleOptions.resources() != null) {
        contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRuleOptions.resources()));
      }
      builder.bodyJson(contentJson);
    }
    ResponseConverter<OutRule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutRule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a rule.
   *
   * This operation creates a rule for the specified account.
   *
   * @return a {@link ServiceCall} with a result of type {@link OutRule}
   */
  public ServiceCall<OutRule> createRule() {
    return createRule(null);
  }

  /**
   * List rules.
   *
   * This operation lists rules for the specified account.
   *
   * @param listRulesOptions the {@link ListRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutRulePage}
   */
  public ServiceCall<OutRulePage> listRules(ListRulesOptions listRulesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listRulesOptions,
      "listRulesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/rules"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "listRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRulesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listRulesOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(listRulesOptions.accountId()));
    if (listRulesOptions.region() != null) {
      builder.query("region", String.valueOf(listRulesOptions.region()));
    }
    if (listRulesOptions.resource() != null) {
      builder.query("resource", String.valueOf(listRulesOptions.resource()));
    }
    if (listRulesOptions.resourceType() != null) {
      builder.query("resource_type", String.valueOf(listRulesOptions.resourceType()));
    }
    if (listRulesOptions.serviceInstance() != null) {
      builder.query("service_instance", String.valueOf(listRulesOptions.serviceInstance()));
    }
    if (listRulesOptions.serviceName() != null) {
      builder.query("service_name", String.valueOf(listRulesOptions.serviceName()));
    }
    if (listRulesOptions.serviceType() != null) {
      builder.query("service_type", String.valueOf(listRulesOptions.serviceType()));
    }
    if (listRulesOptions.zoneId() != null) {
      builder.query("zone_id", String.valueOf(listRulesOptions.zoneId()));
    }
    if (listRulesOptions.sort() != null) {
      builder.query("sort", String.valueOf(listRulesOptions.sort()));
    }
    ResponseConverter<OutRulePage> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutRulePage>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the specified rule.
   *
   * This operation gets the rule for the specified ID.
   *
   * @param getRuleOptions the {@link GetRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutRule}
   */
  public ServiceCall<OutRule> getRule(GetRuleOptions getRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRuleOptions,
      "getRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", getRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "getRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", getRuleOptions.transactionId());
    }
    ResponseConverter<OutRule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutRule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update the specified rule.
   *
   * This operation updates the rule for the specified ID.
   *
   * @param replaceRuleOptions the {@link ReplaceRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutRule}
   */
  public ServiceCall<OutRule> replaceRule(ReplaceRuleOptions replaceRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceRuleOptions,
      "replaceRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", replaceRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "replaceRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", replaceRuleOptions.ifMatch());
    if (replaceRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", replaceRuleOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceRuleOptions.description() != null) {
      contentJson.addProperty("description", replaceRuleOptions.description());
    }
    if (replaceRuleOptions.contexts() != null) {
      contentJson.add("contexts", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.contexts()));
    }
    if (replaceRuleOptions.resources() != null) {
      contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceRuleOptions.resources()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<OutRule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutRule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete the specified rule.
   *
   * This operation deletes the rule for the specified home ID.
   *
   * @param deleteRuleOptions the {@link DeleteRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteRule(DeleteRuleOptions deleteRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteRuleOptions,
      "deleteRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", deleteRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "deleteRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteRuleOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the specified account settings.
   *
   * This operation gets the settings for the specified account ID.
   *
   * @param getAccountSettingsOptions the {@link GetAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link OutAccountSettings}
   */
  public ServiceCall<OutAccountSettings> getAccountSettings(GetAccountSettingsOptions getAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountSettingsOptions,
      "getAccountSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getAccountSettingsOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/account_settings/{account_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("context_based_restrictions", "v1", "getAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAccountSettingsOptions.transactionId() != null) {
      builder.header("Transaction-Id", getAccountSettingsOptions.transactionId());
    }
    ResponseConverter<OutAccountSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<OutAccountSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
