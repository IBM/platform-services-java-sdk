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
 * IBM OpenAPI SDK Code Generator Version: 3.111.0-1bfb72c2-20260206-185521
 */

package com.ibm.cloud.platform_services.account_management.v4;

import com.ibm.cloud.platform_services.account_management.v4.model.AccountResponse;
import com.ibm.cloud.platform_services.account_management.v4.model.GetAccountOptions;
import com.ibm.cloud.platform_services.common.SdkCommon;
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
 * The Account Management API allows for the management of Account.
 *
 * API Version: 4.0.0
 */
public class AccountManagement extends BaseService {

  /**
   * Default service name used when configuring the `AccountManagement` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "account_management";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://accounts.test.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `AccountManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `AccountManagement` client using external configuration
   */
  public static AccountManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `AccountManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `AccountManagement` client using external configuration
   */
  public static AccountManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    AccountManagement service = new AccountManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `AccountManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public AccountManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get Account by Account ID.
   *
   * Returns the details of an account.
   *
   * @param getAccountOptions the {@link GetAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountResponse}
   */
  public ServiceCall<AccountResponse> getAccount(GetAccountOptions getAccountOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountOptions,
      "getAccountOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("account_id", getAccountOptions.accountId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/accounts/{account_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("account_management", "v4", "getAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AccountResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
