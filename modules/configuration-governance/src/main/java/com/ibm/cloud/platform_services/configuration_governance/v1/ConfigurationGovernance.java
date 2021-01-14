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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-c6db7f4a-20210114-141015
 */

package com.ibm.cloud.platform_services.configuration_governance.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Attachment;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.AttachmentList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateAttachmentsResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.CreateRulesResponse;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.DeleteRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.GetRuleOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListAttachmentsOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.ListRulesOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.Rule;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleList;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateRuleOptions;
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
 * API specification for the Configuration Governance service.
 *
 * @version v1
 */
public class ConfigurationGovernance extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "configuration_governance";

  public static final String DEFAULT_SERVICE_URL = "https://compliance.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `ConfigurationGovernance` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `ConfigurationGovernance` client using external configuration
   */
  public static ConfigurationGovernance newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `ConfigurationGovernance` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `ConfigurationGovernance` client using external configuration
   */
  public static ConfigurationGovernance newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    ConfigurationGovernance service = new ConfigurationGovernance(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `ConfigurationGovernance` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public ConfigurationGovernance(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Create rules.
   *
   * Creates one or more rules that you can use to govern the way that IBM Cloud resources can be provisioned and
   * configured.
   *
   * A successful `POST /config/rules` request defines a rule based on the target, conditions, and enforcement actions
   * that you specify. The response returns the ID value for your rule, along with other metadata.
   *
   * @param createRulesOptions the {@link CreateRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateRulesResponse}
   */
  public ServiceCall<CreateRulesResponse> createRules(CreateRulesOptions createRulesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createRulesOptions,
      "createRulesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "createRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createRulesOptions.transactionId() != null) {
      builder.header("Transaction-Id", createRulesOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("rules", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createRulesOptions.rules()));
    builder.bodyJson(contentJson);
    ResponseConverter<CreateRulesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateRulesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List rules.
   *
   * Retrieves a list of the rules that are available in your account.
   *
   * @param listRulesOptions the {@link ListRulesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link RuleList}
   */
  public ServiceCall<RuleList> listRules(ListRulesOptions listRulesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listRulesOptions,
      "listRulesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "listRules");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listRulesOptions.transactionId() != null) {
      builder.header("Transaction-Id", listRulesOptions.transactionId());
    }
    builder.query("account_id", String.valueOf(listRulesOptions.accountId()));
    if (listRulesOptions.attached() != null) {
      builder.query("attached", String.valueOf(listRulesOptions.attached()));
    }
    if (listRulesOptions.labels() != null) {
      builder.query("labels", String.valueOf(listRulesOptions.labels()));
    }
    if (listRulesOptions.scopes() != null) {
      builder.query("scopes", String.valueOf(listRulesOptions.scopes()));
    }
    if (listRulesOptions.limit() != null) {
      builder.query("limit", String.valueOf(listRulesOptions.limit()));
    }
    if (listRulesOptions.offset() != null) {
      builder.query("offset", String.valueOf(listRulesOptions.offset()));
    }
    ResponseConverter<RuleList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<RuleList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a rule.
   *
   * Retrieves an existing rule and its details.
   *
   * @param getRuleOptions the {@link GetRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> getRule(GetRuleOptions getRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getRuleOptions,
      "getRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", getRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "getRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", getRuleOptions.transactionId());
    }
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a rule.
   *
   * Updates an existing rule based on the properties that you specify.
   *
   * @param updateRuleOptions the {@link UpdateRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Rule}
   */
  public ServiceCall<Rule> updateRule(UpdateRuleOptions updateRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateRuleOptions,
      "updateRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", updateRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "updateRule");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateRuleOptions.ifMatch());
    if (updateRuleOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateRuleOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("name", updateRuleOptions.name());
    contentJson.addProperty("description", updateRuleOptions.description());
    contentJson.add("target", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRuleOptions.target()));
    contentJson.add("required_config", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRuleOptions.requiredConfig()));
    contentJson.add("enforcement_actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRuleOptions.enforcementActions()));
    if (updateRuleOptions.accountId() != null) {
      contentJson.addProperty("account_id", updateRuleOptions.accountId());
    }
    if (updateRuleOptions.ruleType() != null) {
      contentJson.addProperty("rule_type", updateRuleOptions.ruleType());
    }
    if (updateRuleOptions.labels() != null) {
      contentJson.add("labels", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateRuleOptions.labels()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Rule> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Rule>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a rule.
   *
   * Deletes an existing rule.
   *
   * @param deleteRuleOptions the {@link DeleteRuleOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteRule(DeleteRuleOptions deleteRuleOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteRuleOptions,
      "deleteRuleOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", deleteRuleOptions.ruleId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "deleteRule");
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
   * Create attachments.
   *
   * Creates one or more scope attachments for an existing rule.
   *
   * You can attach an existing rule to a scope, such as a specific IBM Cloud account, to start evaluating the rule for
   * compliance. A successful
   * `POST /config/v1/rules/{rule_id}/attachments` returns the ID value for the attachment, along with other metadata.
   *
   * @param createAttachmentsOptions the {@link CreateAttachmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateAttachmentsResponse}
   */
  public ServiceCall<CreateAttachmentsResponse> createAttachments(CreateAttachmentsOptions createAttachmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createAttachmentsOptions,
      "createAttachmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", createAttachmentsOptions.ruleId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "createAttachments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createAttachmentsOptions.transactionId() != null) {
      builder.header("Transaction-Id", createAttachmentsOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("attachments", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createAttachmentsOptions.attachments()));
    builder.bodyJson(contentJson);
    ResponseConverter<CreateAttachmentsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateAttachmentsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List attachments.
   *
   * Retrieves a list of scope attachments that are associated with the specified rule.
   *
   * @param listAttachmentsOptions the {@link ListAttachmentsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentList}
   */
  public ServiceCall<AttachmentList> listAttachments(ListAttachmentsOptions listAttachmentsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listAttachmentsOptions,
      "listAttachmentsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", listAttachmentsOptions.ruleId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "listAttachments");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAttachmentsOptions.transactionId() != null) {
      builder.header("Transaction-Id", listAttachmentsOptions.transactionId());
    }
    if (listAttachmentsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listAttachmentsOptions.limit()));
    }
    if (listAttachmentsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listAttachmentsOptions.offset()));
    }
    ResponseConverter<AttachmentList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get an attachment.
   *
   * Retrieves an existing scope attachment for a rule.
   *
   * @param getAttachmentOptions the {@link GetAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Attachment}
   */
  public ServiceCall<Attachment> getAttachment(GetAttachmentOptions getAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAttachmentOptions,
      "getAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", getAttachmentOptions.ruleId());
    pathParamsMap.put("attachment_id", getAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "getAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAttachmentOptions.transactionId() != null) {
      builder.header("Transaction-Id", getAttachmentOptions.transactionId());
    }
    ResponseConverter<Attachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Attachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an attachment.
   *
   * Updates an existing scope attachment based on the properties that you specify.
   *
   * @param updateAttachmentOptions the {@link UpdateAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Attachment}
   */
  public ServiceCall<Attachment> updateAttachment(UpdateAttachmentOptions updateAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAttachmentOptions,
      "updateAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", updateAttachmentOptions.ruleId());
    pathParamsMap.put("attachment_id", updateAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "updateAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.header("If-Match", updateAttachmentOptions.ifMatch());
    if (updateAttachmentOptions.transactionId() != null) {
      builder.header("Transaction-Id", updateAttachmentOptions.transactionId());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("account_id", updateAttachmentOptions.accountId());
    contentJson.add("included_scope", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateAttachmentOptions.includedScope()));
    if (updateAttachmentOptions.excludedScopes() != null) {
      contentJson.add("excluded_scopes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateAttachmentOptions.excludedScopes()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Attachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Attachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete an attachment.
   *
   * Deletes an existing scope attachment.
   *
   * @param deleteAttachmentOptions the {@link DeleteAttachmentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteAttachment(DeleteAttachmentOptions deleteAttachmentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteAttachmentOptions,
      "deleteAttachmentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("rule_id", deleteAttachmentOptions.ruleId());
    pathParamsMap.put("attachment_id", deleteAttachmentOptions.attachmentId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/config/v1/rules/{rule_id}/attachments/{attachment_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("configuration_governance", "v1", "deleteAttachment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteAttachmentOptions.transactionId() != null) {
      builder.header("Transaction-Id", deleteAttachmentOptions.transactionId());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
