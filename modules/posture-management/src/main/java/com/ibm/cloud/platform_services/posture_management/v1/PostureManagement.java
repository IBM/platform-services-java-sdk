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
 * IBM OpenAPI SDK Code Generator Version: 3.29.1-b338fb38-20210313-010605
 */

package com.ibm.cloud.platform_services.posture_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.posture_management.v1.model.CreateValidationOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListProfilesOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ListScopesOptions;
import com.ibm.cloud.platform_services.posture_management.v1.model.ProfilesList;
import com.ibm.cloud.platform_services.posture_management.v1.model.Result;
import com.ibm.cloud.platform_services.posture_management.v1.model.ScopesList;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Map;
import java.util.Map.Entry;

/**
 * With IBM Cloud® Security and Compliance Center, you can embed checks into your every day workflows to help manage
 * your current security and compliance posture. By monitoring for risks, you can identify security vulnerabilities and
 * quickly work to mitigate the impact.
 *
 * @version v1
 */
public class PostureManagement extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "posture_management";


 /**
   * Class method which constructs an instance of the `PostureManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `PostureManagement` client using external configuration
   */
  public static PostureManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `PostureManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `PostureManagement` client using external configuration
   */
  public static PostureManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    PostureManagement service = new PostureManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `PostureManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public PostureManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
  }

  /**
   * Initiate a validations scan.
   *
   * Validations scans determine a specified scope's adherence to regulatory controls by validating the configuration of
   * the resources in your scope to the attached profile. To initiate a scan, you must have configured a collector,
   * provided credentials, and completed both a fact collection and discovery scan. [Learn
   * more](/docs/security-compliance?topic=security-compliance-schedule-scan).
   *
   * @param createValidationOptions the {@link CreateValidationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Result}
   */
  public ServiceCall<Result> createValidation(CreateValidationOptions createValidationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createValidationOptions,
      "createValidationOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/posture/v1/scans/validations"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("posture_management", "v1", "createValidation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("account_id", String.valueOf(createValidationOptions.accountId()));
    final JsonObject contentJson = new JsonObject();
    if (createValidationOptions.scopeId() != null) {
      contentJson.addProperty("scope_id", createValidationOptions.scopeId());
    }
    if (createValidationOptions.profileId() != null) {
      contentJson.addProperty("profile_id", createValidationOptions.profileId());
    }
    if (createValidationOptions.groupProfileId() != null) {
      contentJson.addProperty("group_profile_id", createValidationOptions.groupProfileId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Result> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Result>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List profiles.
   *
   * List all of the profiles that are available in your account. To view a specific profile, you can filter by name.
   *
   * @param listProfilesOptions the {@link ListProfilesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ProfilesList}
   */
  public ServiceCall<ProfilesList> listProfiles(ListProfilesOptions listProfilesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listProfilesOptions,
      "listProfilesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/posture/v1/profiles"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("posture_management", "v1", "listProfiles");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("account_id", String.valueOf(listProfilesOptions.accountId()));
    if (listProfilesOptions.name() != null) {
      builder.query("name", String.valueOf(listProfilesOptions.name()));
    }
    ResponseConverter<ProfilesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ProfilesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * List scopes.
   *
   * List all of the scopes that are available in your account. To view a specific scope, you can filter by name.
   *
   * @param listScopesOptions the {@link ListScopesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ScopesList}
   */
  public ServiceCall<ScopesList> listScopes(ListScopesOptions listScopesOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(listScopesOptions,
      "listScopesOptions cannot be null");
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/posture/v1/scopes"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("posture_management", "v1", "listScopes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("account_id", String.valueOf(listScopesOptions.accountId()));
    if (listScopesOptions.name() != null) {
      builder.query("name", String.valueOf(listScopesOptions.name()));
    }
    ResponseConverter<ScopesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ScopesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
