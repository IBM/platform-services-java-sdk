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

/*
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-cfe3553a-20200914-135527
 */

package com.ibm.cloud.platform_services.global_search.v2;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.global_search.v2.model.GetSupportedTypesOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.SupportedTypesList;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Search for resources with the global and shared resource properties repository integrated in the IBM Cloud Platform.
 * The search repository stores and searches cloud resources attributes, which categorize or classify resources. A
 * resource is a physical or logical component that can be provisioned or reserved for an application or service
 * instance and is owned by resource providers, such as Cloud Foundry, IBM containers, or Resource Controller, in the
 * IBM Cloud platform. Resources are uniquely identified by a CRN (Cloud Resource Naming identifier) or by an IMS ID.
 * The properties of a resource include tags and system properties. Both properties are defined in an IBM Cloud billing
 * account, and span across many regions.
 *
 * @version v2
 */
public class GlobalSearch extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "global_search";

  public static final String DEFAULT_SERVICE_URL = "https://api.global-search-tagging.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `GlobalSearch` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `GlobalSearch` client using external configuration
   */
  public static GlobalSearch newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `GlobalSearch` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `GlobalSearch` client using external configuration
   */
  public static GlobalSearch newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    GlobalSearch service = new GlobalSearch(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `GlobalSearch` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public GlobalSearch(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Find instances of resources.
   *
   * 'Find cloud foundry resources, resource controlled enabled resources, or storage and network resources running on
   * classic infrastructure in a specific account ID. You can apply query strings if necessary. To filter results, you
   * can insert a string using the Lucene syntax and the query string is parsed into a series of terms and operators. A
   * term can be a single word or a phrase, in which case the search is performed for all the words, in the same order.
   * To filter for a specific value regardless of the property that contains it, use an asterisk as the key name. Only
   * resources that belong to the account ID and that are accessible by the client are returned. You must use this
   * operation when you need to fetch more than `10000` resource items. The `/v2/resources/search` prohibits paginating
   * through such a big number. On the first call, the operation returns a live cursor on the data that you must use on
   * all the subsequent calls to get the next batch of results until you get the empty result set. By default, the
   * fields returned for every resources are: "crn", "name", "family", "type", "account_id". You can specify the subset
   * of the fields you want in your request.''.
   *
   * @param searchOptions the {@link SearchOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ScanResult}
   */
  public ServiceCall<ScanResult> search(SearchOptions searchOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(searchOptions,
      "searchOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/resources/search"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_search", "v2", "search");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (searchOptions.transactionId() != null) {
      builder.header("transaction-id", searchOptions.transactionId());
    }
    if (searchOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(searchOptions.accountId()));
    }
    if (searchOptions.limit() != null) {
      builder.query("limit", String.valueOf(searchOptions.limit()));
    }
    if (searchOptions.timeout() != null) {
      builder.query("timeout", String.valueOf(searchOptions.timeout()));
    }
    if (searchOptions.sort() != null) {
      builder.query("sort", RequestUtils.join(searchOptions.sort(), ","));
    }
    final JsonObject contentJson = new JsonObject();
    if (searchOptions.query() != null) {
      contentJson.addProperty("query", searchOptions.query());
    }
    if (searchOptions.fields() != null) {
      contentJson.add("fields", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(searchOptions.fields()));
    }
    if (searchOptions.searchCursor() != null) {
      contentJson.addProperty("search_cursor", searchOptions.searchCursor());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<ScanResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ScanResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Find instances of resources.
   *
   * 'Find cloud foundry resources, resource controlled enabled resources, or storage and network resources running on
   * classic infrastructure in a specific account ID. You can apply query strings if necessary. To filter results, you
   * can insert a string using the Lucene syntax and the query string is parsed into a series of terms and operators. A
   * term can be a single word or a phrase, in which case the search is performed for all the words, in the same order.
   * To filter for a specific value regardless of the property that contains it, use an asterisk as the key name. Only
   * resources that belong to the account ID and that are accessible by the client are returned. You must use this
   * operation when you need to fetch more than `10000` resource items. The `/v2/resources/search` prohibits paginating
   * through such a big number. On the first call, the operation returns a live cursor on the data that you must use on
   * all the subsequent calls to get the next batch of results until you get the empty result set. By default, the
   * fields returned for every resources are: "crn", "name", "family", "type", "account_id". You can specify the subset
   * of the fields you want in your request.''.
   *
   * @return a {@link ServiceCall} with a result of type {@link ScanResult}
   */
  public ServiceCall<ScanResult> search() {
    return search(null);
  }

  /**
   * Get all supported resource types.
   *
   * Retrieves a list of all the resource types supported by GhoST.
   *
   * @param getSupportedTypesOptions the {@link GetSupportedTypesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link SupportedTypesList}
   */
  public ServiceCall<SupportedTypesList> getSupportedTypes(GetSupportedTypesOptions getSupportedTypesOptions) {
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v2/resources/supported_types"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_search", "v2", "getSupportedTypes");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<SupportedTypesList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<SupportedTypesList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all supported resource types.
   *
   * Retrieves a list of all the resource types supported by GhoST.
   *
   * @return a {@link ServiceCall} with a result of type {@link SupportedTypesList}
   */
  public ServiceCall<SupportedTypesList> getSupportedTypes() {
    return getSupportedTypes(null);
  }

}
