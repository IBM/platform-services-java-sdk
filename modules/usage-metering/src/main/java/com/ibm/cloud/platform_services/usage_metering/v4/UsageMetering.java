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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-2dc02c80-20201206-075555
 */

package com.ibm.cloud.platform_services.usage_metering.v4;

import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ReportResourceUsageOptions;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResponseAccepted;
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
 * IBM Cloud Usage Metering is a platform service that enables service providers to submit metrics collected for
 * resource instances provisioned by IBM Cloud users. IBM and third-party service providers that are delivering  an
 * integrated billing service in IBM Cloud are required to submit usage for all active service instances every hour.
 * This is important because inability to report usage can lead to loss of revenue collection for IBM,  in turn causing
 * loss of revenue share for the service providers.
 *
 * @version v4
 */
public class UsageMetering extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "usage_metering";

  public static final String DEFAULT_SERVICE_URL = "https://billing.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `UsageMetering` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `UsageMetering` client using external configuration
   */
  public static UsageMetering newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `UsageMetering` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `UsageMetering` client using external configuration
   */
  public static UsageMetering newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    UsageMetering service = new UsageMetering(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `UsageMetering` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public UsageMetering(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Report Resource Controller resource usage.
   *
   * Report usage for resource instances that were provisioned through the resource controller.
   *
   * @param reportResourceUsageOptions the {@link ReportResourceUsageOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ResponseAccepted}
   */
  public ServiceCall<ResponseAccepted> reportResourceUsage(ReportResourceUsageOptions reportResourceUsageOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(reportResourceUsageOptions,
      "reportResourceUsageOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("resource_id", reportResourceUsageOptions.resourceId());
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v4/metering/resources/{resource_id}/usage", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("usage_metering", "v4", "reportResourceUsage");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(reportResourceUsageOptions.resourceUsage()), "application/json");
    ResponseConverter<ResponseAccepted> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ResponseAccepted>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
