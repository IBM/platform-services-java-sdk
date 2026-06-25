/*
 * (C) Copyright IBM Corp. 2026.
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
 * IBM OpenAPI SDK Code Generator Version: 3.108.0-56772134-20251111-102802
 */

package com.ibm.cloud.platform_services.platform_notifications.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.Acknowledgement;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestination;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.AddDestinationCollection;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.CreateDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.CreatePreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.DeleteDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.DeleteNotificationPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetAcknowledgementOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ListDistributionListDestinationsOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ListNotificationsOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.NotificationCollection;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PreferencesObject;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationAcknowledgementOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDestinationResponseBody;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.TestDistributionListDestinationOptions;
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
 * API for IBM Cloud account notifications, providing capabilities to:
 * - View notifications
 * - Get and update acknowledgements
 * - Manage user communication preferences
 * - Manage notification distribution lists
 * .
 *
 * API Version: 1.0.0
 */
public class PlatformNotifications extends BaseService {

  /**
   * Default service name used when configuring the `PlatformNotifications` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "platform_notifications";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://notifications.cloud.ibm.com/api";

 /**
   * Class method which constructs an instance of the `PlatformNotifications` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `PlatformNotifications` client using external configuration
   */
  public static PlatformNotifications newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `PlatformNotifications` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `PlatformNotifications` client using external configuration
   */
  public static PlatformNotifications newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    PlatformNotifications service = new PlatformNotifications(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `PlatformNotifications` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public PlatformNotifications(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get user notifications.
   *
   * Retrieve all notifications for the requested user.
   *
   * @param listNotificationsOptions the {@link ListNotificationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link NotificationCollection}
   */
  public ServiceCall<NotificationCollection> listNotifications(ListNotificationsOptions listNotificationsOptions) {
    if (listNotificationsOptions == null) {
      listNotificationsOptions = new ListNotificationsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "listNotifications");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listNotificationsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listNotificationsOptions.accountId()));
    }
    if (listNotificationsOptions.start() != null) {
      builder.query("start", String.valueOf(listNotificationsOptions.start()));
    }
    if (listNotificationsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listNotificationsOptions.limit()));
    }
    ResponseConverter<NotificationCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<NotificationCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get user notifications.
   *
   * Retrieve all notifications for the requested user.
   *
   * @return a {@link ServiceCall} with a result of type {@link NotificationCollection}
   */
  public ServiceCall<NotificationCollection> listNotifications() {
    return listNotifications(null);
  }

  /**
   * Get acknowledgement.
   *
   * Retrieve the ID of the last notification acknowledged by the user for a specific account.
   *
   * @param getAcknowledgementOptions the {@link GetAcknowledgementOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Acknowledgement}
   */
  public ServiceCall<Acknowledgement> getAcknowledgement(GetAcknowledgementOptions getAcknowledgementOptions) {
    if (getAcknowledgementOptions == null) {
      getAcknowledgementOptions = new GetAcknowledgementOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications/acknowledgement"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "getAcknowledgement");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getAcknowledgementOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(getAcknowledgementOptions.accountId()));
    }
    ResponseConverter<Acknowledgement> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Acknowledgement>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get acknowledgement.
   *
   * Retrieve the ID of the last notification acknowledged by the user for a specific account.
   *
   * @return a {@link ServiceCall} with a result of type {@link Acknowledgement}
   */
  public ServiceCall<Acknowledgement> getAcknowledgement() {
    return getAcknowledgement(null);
  }

  /**
   * Update acknowledgement.
   *
   * Update the ID of the last notification acknowledged by the user for a specific account.
   *
   * @param replaceNotificationAcknowledgementOptions the {@link ReplaceNotificationAcknowledgementOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Acknowledgement}
   */
  public ServiceCall<Acknowledgement> replaceNotificationAcknowledgement(ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceNotificationAcknowledgementOptions,
      "replaceNotificationAcknowledgementOptions cannot be null");
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications/acknowledgement"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "replaceNotificationAcknowledgement");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceNotificationAcknowledgementOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(replaceNotificationAcknowledgementOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("last_acknowledged", replaceNotificationAcknowledgementOptions.lastAcknowledged());
    builder.bodyJson(contentJson);
    ResponseConverter<Acknowledgement> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Acknowledgement>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all destination entries.
   *
   * Retrieve all destinations in the distribution list for the specified account.
   *
   * @param listDistributionListDestinationsOptions the {@link ListDistributionListDestinationsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AddDestinationCollection}
   */
  public ServiceCall<AddDestinationCollection> listDistributionListDestinations(ListDistributionListDestinationsOptions listDistributionListDestinationsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listDistributionListDestinationsOptions,
      "listDistributionListDestinationsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", listDistributionListDestinationsOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/distribution_lists/{account_id}/destinations", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "listDistributionListDestinations");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AddDestinationCollection> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AddDestinationCollection>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a destination entry.
   *
   * Add a destination entry to the distribution list. A maximum of 10 destination entries per destination type. In
   * terms of enterprise accounts, you can provide an Event Notifications destination that is from a different account
   * than the distribution list account, provided these two accounts are from the same enterprise and the user has
   * permission to manage the Event Notifications destinations on both accounts.
   *
   * @param createDistributionListDestinationOptions the {@link CreateDistributionListDestinationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AddDestination}
   */
  public ServiceCall<AddDestination> createDistributionListDestination(CreateDistributionListDestinationOptions createDistributionListDestinationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createDistributionListDestinationOptions,
      "createDistributionListDestinationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", createDistributionListDestinationOptions.accountId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/distribution_lists/{account_id}/destinations", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "createDistributionListDestination");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(createDistributionListDestinationOptions.addDestinationPrototype()), "application/json");
    ResponseConverter<AddDestination> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AddDestination>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a destination entry.
   *
   * Retrieve a specific destination from the distribution list of the account.
   *
   * @param getDistributionListDestinationOptions the {@link GetDistributionListDestinationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AddDestination}
   */
  public ServiceCall<AddDestination> getDistributionListDestination(GetDistributionListDestinationOptions getDistributionListDestinationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getDistributionListDestinationOptions,
      "getDistributionListDestinationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getDistributionListDestinationOptions.accountId());
    pathParamsMap.put("destination_id", getDistributionListDestinationOptions.destinationId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/distribution_lists/{account_id}/destinations/{destination_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "getDistributionListDestination");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AddDestination> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AddDestination>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete a destination entry.
   *
   * Remove a destination entry.
   *
   * @param deleteDistributionListDestinationOptions the {@link DeleteDistributionListDestinationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteDistributionListDestination(DeleteDistributionListDestinationOptions deleteDistributionListDestinationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteDistributionListDestinationOptions,
      "deleteDistributionListDestinationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", deleteDistributionListDestinationOptions.accountId());
    pathParamsMap.put("destination_id", deleteDistributionListDestinationOptions.destinationId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/distribution_lists/{account_id}/destinations/{destination_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "deleteDistributionListDestination");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Test a destination entry.
   *
   * Send a test notification to a destination in the distribution list. This allows you to verify that the destination
   * is properly configured and can receive notifications.
   *
   * @param testDistributionListDestinationOptions the {@link TestDistributionListDestinationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TestDestinationResponseBody}
   */
  public ServiceCall<TestDestinationResponseBody> testDistributionListDestination(TestDistributionListDestinationOptions testDistributionListDestinationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(testDistributionListDestinationOptions,
      "testDistributionListDestinationOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", testDistributionListDestinationOptions.accountId());
    pathParamsMap.put("destination_id", testDistributionListDestinationOptions.destinationId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/distribution_lists/{account_id}/destinations/{destination_id}/test", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "testDistributionListDestination");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(testDistributionListDestinationOptions.testDestinationRequestBodyPrototype()), "application/json");
    ResponseConverter<TestDestinationResponseBody> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TestDestinationResponseBody>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all communication preferences.
   *
   * Retrieve all communication preferences of a user in an account.
   *
   * @param getPreferencesOptions the {@link GetPreferencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PreferencesObject}
   */
  public ServiceCall<PreferencesObject> getPreferences(GetPreferencesOptions getPreferencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getPreferencesOptions,
      "getPreferencesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("iam_id", getPreferencesOptions.iamId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications/{iam_id}/preferences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "getPreferences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getPreferencesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(getPreferencesOptions.accountId()));
    }
    ResponseConverter<PreferencesObject> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PreferencesObject>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create communication preferences.
   *
   * Create communication preferences for the specified account.
   *
   * @param createPreferencesOptions the {@link CreatePreferencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PreferencesObject}
   */
  public ServiceCall<PreferencesObject> createPreferences(CreatePreferencesOptions createPreferencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createPreferencesOptions,
      "createPreferencesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("iam_id", createPreferencesOptions.iamId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications/{iam_id}/preferences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "createPreferences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createPreferencesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(createPreferencesOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    if (createPreferencesOptions.incidentSeverity1() != null) {
      contentJson.add("incident_severity1", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.incidentSeverity1()));
    }
    if (createPreferencesOptions.incidentSeverity2() != null) {
      contentJson.add("incident_severity2", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.incidentSeverity2()));
    }
    if (createPreferencesOptions.incidentSeverity3() != null) {
      contentJson.add("incident_severity3", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.incidentSeverity3()));
    }
    if (createPreferencesOptions.incidentSeverity4() != null) {
      contentJson.add("incident_severity4", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.incidentSeverity4()));
    }
    if (createPreferencesOptions.maintenanceHigh() != null) {
      contentJson.add("maintenance_high", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.maintenanceHigh()));
    }
    if (createPreferencesOptions.maintenanceMedium() != null) {
      contentJson.add("maintenance_medium", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.maintenanceMedium()));
    }
    if (createPreferencesOptions.maintenanceLow() != null) {
      contentJson.add("maintenance_low", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.maintenanceLow()));
    }
    if (createPreferencesOptions.announcementsMajor() != null) {
      contentJson.add("announcements_major", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.announcementsMajor()));
    }
    if (createPreferencesOptions.announcementsMinor() != null) {
      contentJson.add("announcements_minor", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.announcementsMinor()));
    }
    if (createPreferencesOptions.securityNormal() != null) {
      contentJson.add("security_normal", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.securityNormal()));
    }
    if (createPreferencesOptions.accountNormal() != null) {
      contentJson.add("account_normal", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.accountNormal()));
    }
    if (createPreferencesOptions.billingAndUsageOrder() != null) {
      contentJson.add("billing_and_usage_order", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.billingAndUsageOrder()));
    }
    if (createPreferencesOptions.billingAndUsageInvoices() != null) {
      contentJson.add("billing_and_usage_invoices", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.billingAndUsageInvoices()));
    }
    if (createPreferencesOptions.billingAndUsagePayments() != null) {
      contentJson.add("billing_and_usage_payments", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.billingAndUsagePayments()));
    }
    if (createPreferencesOptions.billingAndUsageSubscriptionsAndPromoCodes() != null) {
      contentJson.add("billing_and_usage_subscriptions_and_promo_codes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.billingAndUsageSubscriptionsAndPromoCodes()));
    }
    if (createPreferencesOptions.billingAndUsageSpendingAlerts() != null) {
      contentJson.add("billing_and_usage_spending_alerts", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.billingAndUsageSpendingAlerts()));
    }
    if (createPreferencesOptions.resourceactivityNormal() != null) {
      contentJson.add("resourceactivity_normal", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.resourceactivityNormal()));
    }
    if (createPreferencesOptions.orderingReview() != null) {
      contentJson.add("ordering_review", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.orderingReview()));
    }
    if (createPreferencesOptions.orderingApproved() != null) {
      contentJson.add("ordering_approved", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.orderingApproved()));
    }
    if (createPreferencesOptions.orderingApprovedVsi() != null) {
      contentJson.add("ordering_approved_vsi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.orderingApprovedVsi()));
    }
    if (createPreferencesOptions.orderingApprovedServer() != null) {
      contentJson.add("ordering_approved_server", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.orderingApprovedServer()));
    }
    if (createPreferencesOptions.provisioningReloadComplete() != null) {
      contentJson.add("provisioning_reload_complete", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.provisioningReloadComplete()));
    }
    if (createPreferencesOptions.provisioningCompleteVsi() != null) {
      contentJson.add("provisioning_complete_vsi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.provisioningCompleteVsi()));
    }
    if (createPreferencesOptions.provisioningCompleteServer() != null) {
      contentJson.add("provisioning_complete_server", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createPreferencesOptions.provisioningCompleteServer()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PreferencesObject> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PreferencesObject>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update communication preferences.
   *
   * Update communication preferences for the specified account.
   *
   * @param replaceNotificationPreferencesOptions the {@link ReplaceNotificationPreferencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link PreferencesObject}
   */
  public ServiceCall<PreferencesObject> replaceNotificationPreferences(ReplaceNotificationPreferencesOptions replaceNotificationPreferencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceNotificationPreferencesOptions,
      "replaceNotificationPreferencesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("iam_id", replaceNotificationPreferencesOptions.iamId());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications/{iam_id}/preferences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "replaceNotificationPreferences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceNotificationPreferencesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(replaceNotificationPreferencesOptions.accountId()));
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceNotificationPreferencesOptions.incidentSeverity1() != null) {
      contentJson.add("incident_severity1", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.incidentSeverity1()));
    }
    if (replaceNotificationPreferencesOptions.incidentSeverity2() != null) {
      contentJson.add("incident_severity2", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.incidentSeverity2()));
    }
    if (replaceNotificationPreferencesOptions.incidentSeverity3() != null) {
      contentJson.add("incident_severity3", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.incidentSeverity3()));
    }
    if (replaceNotificationPreferencesOptions.incidentSeverity4() != null) {
      contentJson.add("incident_severity4", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.incidentSeverity4()));
    }
    if (replaceNotificationPreferencesOptions.maintenanceHigh() != null) {
      contentJson.add("maintenance_high", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.maintenanceHigh()));
    }
    if (replaceNotificationPreferencesOptions.maintenanceMedium() != null) {
      contentJson.add("maintenance_medium", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.maintenanceMedium()));
    }
    if (replaceNotificationPreferencesOptions.maintenanceLow() != null) {
      contentJson.add("maintenance_low", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.maintenanceLow()));
    }
    if (replaceNotificationPreferencesOptions.announcementsMajor() != null) {
      contentJson.add("announcements_major", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.announcementsMajor()));
    }
    if (replaceNotificationPreferencesOptions.announcementsMinor() != null) {
      contentJson.add("announcements_minor", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.announcementsMinor()));
    }
    if (replaceNotificationPreferencesOptions.securityNormal() != null) {
      contentJson.add("security_normal", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.securityNormal()));
    }
    if (replaceNotificationPreferencesOptions.accountNormal() != null) {
      contentJson.add("account_normal", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.accountNormal()));
    }
    if (replaceNotificationPreferencesOptions.billingAndUsageOrder() != null) {
      contentJson.add("billing_and_usage_order", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.billingAndUsageOrder()));
    }
    if (replaceNotificationPreferencesOptions.billingAndUsageInvoices() != null) {
      contentJson.add("billing_and_usage_invoices", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.billingAndUsageInvoices()));
    }
    if (replaceNotificationPreferencesOptions.billingAndUsagePayments() != null) {
      contentJson.add("billing_and_usage_payments", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.billingAndUsagePayments()));
    }
    if (replaceNotificationPreferencesOptions.billingAndUsageSubscriptionsAndPromoCodes() != null) {
      contentJson.add("billing_and_usage_subscriptions_and_promo_codes", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.billingAndUsageSubscriptionsAndPromoCodes()));
    }
    if (replaceNotificationPreferencesOptions.billingAndUsageSpendingAlerts() != null) {
      contentJson.add("billing_and_usage_spending_alerts", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.billingAndUsageSpendingAlerts()));
    }
    if (replaceNotificationPreferencesOptions.resourceactivityNormal() != null) {
      contentJson.add("resourceactivity_normal", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.resourceactivityNormal()));
    }
    if (replaceNotificationPreferencesOptions.orderingReview() != null) {
      contentJson.add("ordering_review", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.orderingReview()));
    }
    if (replaceNotificationPreferencesOptions.orderingApproved() != null) {
      contentJson.add("ordering_approved", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.orderingApproved()));
    }
    if (replaceNotificationPreferencesOptions.orderingApprovedVsi() != null) {
      contentJson.add("ordering_approved_vsi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.orderingApprovedVsi()));
    }
    if (replaceNotificationPreferencesOptions.orderingApprovedServer() != null) {
      contentJson.add("ordering_approved_server", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.orderingApprovedServer()));
    }
    if (replaceNotificationPreferencesOptions.provisioningReloadComplete() != null) {
      contentJson.add("provisioning_reload_complete", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.provisioningReloadComplete()));
    }
    if (replaceNotificationPreferencesOptions.provisioningCompleteVsi() != null) {
      contentJson.add("provisioning_complete_vsi", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.provisioningCompleteVsi()));
    }
    if (replaceNotificationPreferencesOptions.provisioningCompleteServer() != null) {
      contentJson.add("provisioning_complete_server", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceNotificationPreferencesOptions.provisioningCompleteServer()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<PreferencesObject> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<PreferencesObject>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Reset all preferences to their default values.
   *
   * Delete all communication preferences for the specified account, and reset all preferences to their default values.
   *
   * @param deleteNotificationPreferencesOptions the {@link DeleteNotificationPreferencesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteNotificationPreferences(DeleteNotificationPreferencesOptions deleteNotificationPreferencesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteNotificationPreferencesOptions,
      "deleteNotificationPreferencesOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("iam_id", deleteNotificationPreferencesOptions.iamId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v1/notifications/{iam_id}/preferences", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("platform_notifications", "v1", "deleteNotificationPreferences");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    if (deleteNotificationPreferencesOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(deleteNotificationPreferencesOptions.accountId()));
    }
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
