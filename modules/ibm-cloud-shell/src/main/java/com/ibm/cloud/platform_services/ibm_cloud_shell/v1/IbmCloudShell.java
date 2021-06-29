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
 * IBM OpenAPI SDK Code Generator Version: 3.33.0-caf29bd0-20210603-225214
 */

package com.ibm.cloud.platform_services.ibm_cloud_shell.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.GetAccountSettingsOptions;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.UpdateAccountSettingsOptions;
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
 * API docs for IBM Cloud Shell repository.
 *
 * @version v1
 */
public class IbmCloudShell extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "ibm_cloud_shell";

  public static final String DEFAULT_SERVICE_URL = "https://api.shell.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `IbmCloudShell` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `IbmCloudShell` client using external configuration
   */
  public static IbmCloudShell newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `IbmCloudShell` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `IbmCloudShell` client using external configuration
   */
  public static IbmCloudShell newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    IbmCloudShell service = new IbmCloudShell(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `IbmCloudShell` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public IbmCloudShell(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get account settings.
   *
   * Retrieve account settings for the given account ID. Call this method to get details about a particular account
   * setting, whether Cloud Shell is enabled, the list of enabled regions and the list of enabled features. Users need
   * to be an account owner or users need to be assigned an IAM policy with the Administrator role for the Cloud Shell
   * account management service.
   *
   * @param getAccountSettingsOptions the {@link GetAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSettings}
   */
  public ServiceCall<AccountSettings> getAccountSettings(GetAccountSettingsOptions getAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountSettingsOptions,
      "getAccountSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getAccountSettingsOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v1/user/accounts/{account_id}/settings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_cloud_shell", "v1", "getAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AccountSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update account settings.
   *
   * Update account settings for the given account ID. Call this method to update account settings configuration, you
   * can enable or disable Cloud Shell, enable or disable available regions and enable and disable features. To update
   * account settings, users need to be an account owner or users need to be assigned an IAM policy with the
   * Administrator role for the Cloud Shell account management service.
   *
   * @param updateAccountSettingsOptions the {@link UpdateAccountSettingsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountSettings}
   */
  public ServiceCall<AccountSettings> updateAccountSettings(UpdateAccountSettingsOptions updateAccountSettingsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAccountSettingsOptions,
      "updateAccountSettingsOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", updateAccountSettingsOptions.accountId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/api/v1/user/accounts/{account_id}/settings", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("ibm_cloud_shell", "v1", "updateAccountSettings");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (updateAccountSettingsOptions.rev() != null) {
      contentJson.addProperty("_rev", updateAccountSettingsOptions.rev());
    }
    if (updateAccountSettingsOptions.defaultEnableNewFeatures() != null) {
      contentJson.addProperty("default_enable_new_features", updateAccountSettingsOptions.defaultEnableNewFeatures());
    }
    if (updateAccountSettingsOptions.defaultEnableNewRegions() != null) {
      contentJson.addProperty("default_enable_new_regions", updateAccountSettingsOptions.defaultEnableNewRegions());
    }
    if (updateAccountSettingsOptions.enabled() != null) {
      contentJson.addProperty("enabled", updateAccountSettingsOptions.enabled());
    }
    if (updateAccountSettingsOptions.features() != null) {
      contentJson.add("features", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateAccountSettingsOptions.features()));
    }
    if (updateAccountSettingsOptions.regions() != null) {
      contentJson.add("regions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateAccountSettingsOptions.regions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<AccountSettings> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountSettings>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
