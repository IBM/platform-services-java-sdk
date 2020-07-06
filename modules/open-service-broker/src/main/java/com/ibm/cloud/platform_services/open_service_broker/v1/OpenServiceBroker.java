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
package com.ibm.cloud.platform_services.open_service_broker.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.DeleteServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.GetLastOperationOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.GetServiceInstanceStateOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ListCatalogOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceBindingOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.ReplaceServiceInstanceStateOptions;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp1874644Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp1874650Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079872Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079874Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079876Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2079894Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.Resp2448145Root;
import com.ibm.cloud.platform_services.open_service_broker.v1.model.UpdateServiceInstanceOptions;
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
 * Contribute resources to the IBM Cloud catalog by implementing a `service broker` that conforms to the [Open Service
 * Broker API](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md) version 2.12  specification
 * and provides enablement extensions for integration with IBM Cloud and the Resource Controller provisioning model.
 *
 * @version v1
 */
public class OpenServiceBroker extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "open_service_broker";


 /**
   * Class method which constructs an instance of the `OpenServiceBroker` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `OpenServiceBroker` client using external configuration
   */
  public static OpenServiceBroker newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `OpenServiceBroker` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `OpenServiceBroker` client using external configuration
   */
  public static OpenServiceBroker newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    OpenServiceBroker service = new OpenServiceBroker(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `OpenServiceBroker` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public OpenServiceBroker(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
  }

  /**
   * Get the current state of the service instance.
   *
   * Get the current state information associated with the service instance.
   *
   * As a service provider you need a way to manage provisioned service instances.  If an account comes past due, you
   * may need a to disable the service (without deleting it), and when the account is settled re-enable the service.
   *
   * This endpoint allows both the provider and IBM Cloud to query for the state of a provisioned service instance.  For
   * example, IBM Cloud may query the provider to figure out if a given service is disabled or not and present that
   * state to the user.
   *
   * @param getServiceInstanceStateOptions the {@link GetServiceInstanceStateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp1874644Root}
   */
  public ServiceCall<Resp1874644Root> getServiceInstanceState(GetServiceInstanceStateOptions getServiceInstanceStateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getServiceInstanceStateOptions,
      "getServiceInstanceStateOptions cannot be null");
    String[] pathSegments = { "bluemix_v1/service_instances" };
    String[] pathParameters = { getServiceInstanceStateOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "getServiceInstanceState");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<Resp1874644Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp1874644Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update the state of a provisioned service instance.
   *
   * Update (disable or enable) the state of a provisioned service instance. As a service provider you need a way to
   * manage provisioned service instances. If an account comes past due, you may need a to disable the service (without
   * deleting it), and when the account is settled re-enable the service. This endpoint allows the provider to enable or
   * disable the state of a provisioned service instance. It is the service provider's responsibility to disable access
   * to the service instance when the disable endpoint is invoked and to re-enable that access when the enable endpoint
   * is invoked. When your service broker receives an enable / disable request, it should take whatever action is
   * necessary to enable / disable (respectively) the service.  Additionally, If a bind request comes in for a disabled
   * service, the broker should reject that request with any code other than `204`, and provide a user-facing message in
   * the description.
   *
   * @param replaceServiceInstanceStateOptions the {@link ReplaceServiceInstanceStateOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp2448145Root}
   */
  public ServiceCall<Resp2448145Root> replaceServiceInstanceState(ReplaceServiceInstanceStateOptions replaceServiceInstanceStateOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceServiceInstanceStateOptions,
      "replaceServiceInstanceStateOptions cannot be null");
    String[] pathSegments = { "bluemix_v1/service_instances" };
    String[] pathParameters = { replaceServiceInstanceStateOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "replaceServiceInstanceState");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceServiceInstanceStateOptions.enabled() != null) {
      contentJson.addProperty("enabled", replaceServiceInstanceStateOptions.enabled());
    }
    if (replaceServiceInstanceStateOptions.initiatorId() != null) {
      contentJson.addProperty("initiator_id", replaceServiceInstanceStateOptions.initiatorId());
    }
    if (replaceServiceInstanceStateOptions.reasonCode() != null) {
      contentJson.addProperty("reason_code", replaceServiceInstanceStateOptions.reasonCode());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Resp2448145Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp2448145Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create (provision) a service instance.
   *
   * Create a service instance with GUID. When your service broker receives a provision request from the IBM Cloud
   * platform, it MUST take whatever action is necessary to create a new resource.
   *
   * When a user creates a service instance from the IBM Cloud console or the IBM Cloud CLI, the IBM Cloud platform
   * validates that the user has permission to create the service instance using IBM Cloud IAM. After this validation
   * occurs, your service broker's provision endpoint (PUT /v2/resource_instances/:instance_id) will be invoked. When
   * provisioning occurs, the IBM Cloud platform provides the following values:
   *
   * - The IBM Cloud context is included in the context variable
   * - The X-Broker-API-Originating-Identity will have the IBM IAM ID of the user that initiated the request
   * - The parameters section will include the requested location (and additional parameters required by your service).
   *
   * @param replaceServiceInstanceOptions the {@link ReplaceServiceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp2079872Root}
   */
  public ServiceCall<Resp2079872Root> replaceServiceInstance(ReplaceServiceInstanceOptions replaceServiceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceServiceInstanceOptions,
      "replaceServiceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/service_instances" };
    String[] pathParameters = { replaceServiceInstanceOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "replaceServiceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (replaceServiceInstanceOptions.acceptsIncomplete() != null) {
      builder.query("accepts_incomplete", String.valueOf(replaceServiceInstanceOptions.acceptsIncomplete()));
    }
    final JsonObject contentJson = new JsonObject();
    if (replaceServiceInstanceOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceServiceInstanceOptions.context()));
    }
    if (replaceServiceInstanceOptions.organizationGuid() != null) {
      contentJson.addProperty("organization_guid", replaceServiceInstanceOptions.organizationGuid());
    }
    if (replaceServiceInstanceOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceServiceInstanceOptions.parameters()));
    }
    if (replaceServiceInstanceOptions.planId() != null) {
      contentJson.addProperty("plan_id", replaceServiceInstanceOptions.planId());
    }
    if (replaceServiceInstanceOptions.serviceId() != null) {
      contentJson.addProperty("service_id", replaceServiceInstanceOptions.serviceId());
    }
    if (replaceServiceInstanceOptions.spaceGuid() != null) {
      contentJson.addProperty("space_guid", replaceServiceInstanceOptions.spaceGuid());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Resp2079872Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp2079872Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update a service instance.
   *
   * Patch an instance by GUID. Enabling this endpoint allows your user to change plans and service parameters in a
   * provisioned service instance. If your offering supports multiple plans, and you want users to be able to change
   * plans for a provisioned instance, you will need to enable the ability for users to update their service instance.
   *
   * To enable support for the update of the plan, a broker MUST declare support per service by specifying
   * `"plan_updateable": true` in your brokers' catalog.json.
   *
   * @param updateServiceInstanceOptions the {@link UpdateServiceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp2079874Root}
   */
  public ServiceCall<Resp2079874Root> updateServiceInstance(UpdateServiceInstanceOptions updateServiceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateServiceInstanceOptions,
      "updateServiceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/service_instances" };
    String[] pathParameters = { updateServiceInstanceOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "updateServiceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (updateServiceInstanceOptions.acceptsIncomplete() != null) {
      builder.query("accepts_incomplete", String.valueOf(updateServiceInstanceOptions.acceptsIncomplete()));
    }
    final JsonObject contentJson = new JsonObject();
    if (updateServiceInstanceOptions.context() != null) {
      contentJson.add("context", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateServiceInstanceOptions.context()));
    }
    if (updateServiceInstanceOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateServiceInstanceOptions.parameters()));
    }
    if (updateServiceInstanceOptions.planId() != null) {
      contentJson.addProperty("plan_id", updateServiceInstanceOptions.planId());
    }
    if (updateServiceInstanceOptions.previousValues() != null) {
      contentJson.add("previous_values", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(updateServiceInstanceOptions.previousValues()));
    }
    if (updateServiceInstanceOptions.serviceId() != null) {
      contentJson.addProperty("service_id", updateServiceInstanceOptions.serviceId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Resp2079874Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp2079874Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete (deprovision) a service instance.
   *
   * Delete (deprovision) a service instance by GUID. When a service broker receives a deprovision request from the IBM
   * Cloud platform, it MUST delete any resources it created during the provision. Usually this means that all resources
   * are immediately reclaimed for future provisions.
   *
   * @param deleteServiceInstanceOptions the {@link DeleteServiceInstanceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp2079874Root}
   */
  public ServiceCall<Resp2079874Root> deleteServiceInstance(DeleteServiceInstanceOptions deleteServiceInstanceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteServiceInstanceOptions,
      "deleteServiceInstanceOptions cannot be null");
    String[] pathSegments = { "v2/service_instances" };
    String[] pathParameters = { deleteServiceInstanceOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "deleteServiceInstance");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("service_id", deleteServiceInstanceOptions.serviceId());
    builder.query("plan_id", deleteServiceInstanceOptions.planId());
    if (deleteServiceInstanceOptions.acceptsIncomplete() != null) {
      builder.query("accepts_incomplete", String.valueOf(deleteServiceInstanceOptions.acceptsIncomplete()));
    }
    ResponseConverter<Resp2079874Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp2079874Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the catalog metadata stored within the broker.
   *
   * This endpoints defines the contract between the broker and the IBM Cloud platform for the services and plans that
   * the broker supports. This endpoint returns the catalog metadata stored within your broker. These values define the
   * minimal provisioning contract between your service and the IBM Cloud platform. All additional catalog metadata that
   * is not required for provisioning is stored within the IBM Cloud catalog, and any updates to catalog display values
   * that are used to render your dashboard like links, icons, and i18n translated metadata should be updated in the
   * Resource Management Console (RMC), and not housed in your broker. None of metadata stored in your broker is
   * displayed in the IBM Cloud console or the IBM Cloud CLI; the console and CLI will return what was set withn RMC and
   * stored in the IBM Cloud catalog.
   *
   * @param listCatalogOptions the {@link ListCatalogOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp1874650Root}
   */
  public ServiceCall<Resp1874650Root> listCatalog(ListCatalogOptions listCatalogOptions) {
    String[] pathSegments = { "v2/catalog" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "listCatalog");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<Resp1874650Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp1874650Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get the catalog metadata stored within the broker.
   *
   * This endpoints defines the contract between the broker and the IBM Cloud platform for the services and plans that
   * the broker supports. This endpoint returns the catalog metadata stored within your broker. These values define the
   * minimal provisioning contract between your service and the IBM Cloud platform. All additional catalog metadata that
   * is not required for provisioning is stored within the IBM Cloud catalog, and any updates to catalog display values
   * that are used to render your dashboard like links, icons, and i18n translated metadata should be updated in the
   * Resource Management Console (RMC), and not housed in your broker. None of metadata stored in your broker is
   * displayed in the IBM Cloud console or the IBM Cloud CLI; the console and CLI will return what was set withn RMC and
   * stored in the IBM Cloud catalog.
   *
   * @return a {@link ServiceCall} with a result of type {@link Resp1874650Root}
   */
  public ServiceCall<Resp1874650Root> listCatalog() {
    return listCatalog(null);
  }

  /**
   * Get the current status of a provision in-progress for a service instance.
   *
   * Get `last_operation` for instance by GUID (for asynchronous provision calls). When a broker returns status code
   * `202 Accepted` during a provision, update, or deprovision call, the IBM Cloud platform will begin polling the
   * `last_operation` endpoint to obtain the state of the last requested operation. The broker response MUST contain the
   * field `state` and MAY contain the field `description`.
   *
   * Valid values for `state` are `in progress`, `succeeded`, and `failed`. The platform will poll the `last_operation
   * `endpoint as long as the broker returns "state": "in progress". Returning "state": "succeeded" or "state": "failed"
   * will cause the platform to cease polling. The value provided for description will be passed through to the platform
   * API client and can be used to provide additional detail for users about the progress of the operation.
   *
   * @param getLastOperationOptions the {@link GetLastOperationOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp2079894Root}
   */
  public ServiceCall<Resp2079894Root> getLastOperation(GetLastOperationOptions getLastOperationOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getLastOperationOptions,
      "getLastOperationOptions cannot be null");
    String[] pathSegments = { "v2/service_instances", "last_operation" };
    String[] pathParameters = { getLastOperationOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "getLastOperation");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getLastOperationOptions.operation() != null) {
      builder.query("operation", getLastOperationOptions.operation());
    }
    if (getLastOperationOptions.planId() != null) {
      builder.query("plan_id", getLastOperationOptions.planId());
    }
    if (getLastOperationOptions.serviceId() != null) {
      builder.query("service_id", getLastOperationOptions.serviceId());
    }
    ResponseConverter<Resp2079894Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp2079894Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Bind a service instance to another resource.
   *
   * Create binding by GUID on service instance.
   *
   * If your service can be bound to applications in IBM Cloud, `bindable:true` must be specified in the catalog.json of
   * your service broker. If bindable, it must be able to return API endpoints and credentials to your service
   * consumers.
   *
   * **Note:** Brokers that do not offer any bindable services do not need to implement the endpoint for bind requests.
   *
   * See the OSB 2.12 spec for more details on
   * [binding](https://github.com/openservicebrokerapi/servicebroker/blob/v2.12/spec.md#binding).
   *
   * @param replaceServiceBindingOptions the {@link ReplaceServiceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resp2079876Root}
   */
  public ServiceCall<Resp2079876Root> replaceServiceBinding(ReplaceServiceBindingOptions replaceServiceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(replaceServiceBindingOptions,
      "replaceServiceBindingOptions cannot be null");
    String[] pathSegments = { "v2/service_instances", "service_bindings" };
    String[] pathParameters = { replaceServiceBindingOptions.bindingId(), replaceServiceBindingOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "replaceServiceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (replaceServiceBindingOptions.bindResource() != null) {
      contentJson.add("bind_resource", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceServiceBindingOptions.bindResource()));
    }
    if (replaceServiceBindingOptions.parameters() != null) {
      contentJson.add("parameters", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(replaceServiceBindingOptions.parameters()));
    }
    if (replaceServiceBindingOptions.planId() != null) {
      contentJson.addProperty("plan_id", replaceServiceBindingOptions.planId());
    }
    if (replaceServiceBindingOptions.serviceId() != null) {
      contentJson.addProperty("service_id", replaceServiceBindingOptions.serviceId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Resp2079876Root> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resp2079876Root>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete (unbind) the credentials bound to a resource.
   *
   * Delete instance binding by GUID.
   *
   * When a broker receives an unbind request from the IBM Cloud platform, it MUST delete any resources associated with
   * the binding. In the case where credentials were generated, this might result in requests to the service instance
   * failing to authenticate.
   *
   * **Note**: Brokers that do not provide any bindable services or plans do not need to implement this endpoint.
   *
   * @param deleteServiceBindingOptions the {@link DeleteServiceBindingOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> deleteServiceBinding(DeleteServiceBindingOptions deleteServiceBindingOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteServiceBindingOptions,
      "deleteServiceBindingOptions cannot be null");
    String[] pathSegments = { "v2/service_instances", "service_bindings" };
    String[] pathParameters = { deleteServiceBindingOptions.bindingId(), deleteServiceBindingOptions.instanceId() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("open_service_broker", "v1", "deleteServiceBinding");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.query("plan_id", deleteServiceBindingOptions.planId());
    builder.query("service_id", deleteServiceBindingOptions.serviceId());
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
