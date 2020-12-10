/**
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-d753183b-20201209-163011
 */


import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Contribute resources to the IBM Cloud catalog by implementing a `service broker` that conforms to the [Open Service
 * Broker API](https://github.com/openservicebrokerapi/servicebroker/blob/master/spec.md) version 2.12  specification
 * and provides enablement extensions for integration with IBM Cloud and the Resource Controller provisioning model.
 */

class OpenServiceBrokerV1 extends BaseService {

  static DEFAULT_SERVICE_NAME: string = 'open_service_broker';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of OpenServiceBrokerV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {OpenServiceBrokerV1}
   */

  public static newInstance(options: UserOptions): OpenServiceBrokerV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new OpenServiceBrokerV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a OpenServiceBrokerV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {OpenServiceBrokerV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    }
  }

  /*************************
   * enableAndDisableInstances
   ************************/

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceId - The `instance_id` of a service instance is provided by the IBM Cloud platform.
   * This ID will be used for future requests to bind and deprovision, so the broker can use it to correlate the
   * resource it creates.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp1874644Root>>}
   */
  public getServiceInstanceState(params: OpenServiceBrokerV1.GetServiceInstanceStateParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp1874644Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'getServiceInstanceState');

    const parameters = {
      options: {
        url: '/bluemix_v1/service_instances/{instance_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceId - The `instance_id` of a service instance is provided by the IBM Cloud platform.
   * This ID will be used for future requests to bind and deprovision, so the broker can use it to correlate the
   * resource it creates.
   * @param {boolean} [params.enabled] - Indicates the current state of the service instance.
   * @param {string} [params.initiatorId] - Optional string that shows the user ID that is initiating the call.
   * @param {string} [params.reasonCode] - Optional string that states the reason code for the service instance state
   * change. Valid values are `IBMCLOUD_ACCT_ACTIVATE`, `IBMCLOUD_RECLAMATION_RESTORE`, or
   * `IBMCLOUD_SERVICE_INSTANCE_BELOW_CAP` for enable calls; `IBMCLOUD_ACCT_SUSPEND`, `IBMCLOUD_RECLAMATION_SCHEDULE`,
   * or `IBMCLOUD_SERVICE_INSTANCE_ABOVE_CAP` for disable calls; and `IBMCLOUD_ADMIN_REQUEST` for enable and disable
   * calls.<br/><br/>Previously accepted values had a `BMX_` prefix, such as `BMX_ACCT_ACTIVATE`. These values are
   * deprecated.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2448145Root>>}
   */
  public replaceServiceInstanceState(params: OpenServiceBrokerV1.ReplaceServiceInstanceStateParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2448145Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'enabled': _params.enabled,
      'initiator_id': _params.initiatorId,
      'reason_code': _params.reasonCode
    };

    const path = {
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceServiceInstanceState');

    const parameters = {
      options: {
        url: '/bluemix_v1/service_instances/{instance_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * resourceInstances
   ************************/

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceId - The `instance_id` of a service instance is provided by the IBM Cloud platform.
   * This ID will be used for future requests to bind and deprovision, so the broker can use it to correlate the
   * resource it creates.
   * @param {string} [params.organizationGuid] - Deprecated in favor of `context`. The IBM Cloud platform GUID for the
   * organization under which the service instance is to be provisioned. Although most brokers will not use this field,
   * it might be helpful for executing operations on a user's behalf. It MUST be a non-empty string.
   * @param {string} [params.planId] - The ID of the plan for which the service instance has been requested, which is
   * stored in the catalog.json of your broker. This value should be a GUID and it MUST be unique to a service.
   * @param {string} [params.serviceId] - The ID of the service stored in the catalog.json of your broker. This value
   * should be a GUID and it MUST be a non-empty string.
   * @param {string} [params.spaceGuid] - Deprecated in favor of `context`. The identifier for the project space within
   * the IBM Cloud platform organization. Although most brokers will not use this field, it might be helpful for
   * executing operations on a user's behalf. It MUST be a non-empty string.
   * @param {Context} [params.context] - Platform specific contextual information under which the service instance is to
   * be provisioned.
   * @param {JsonObject} [params.parameters] - Configuration options for the service instance. An opaque object,
   * controller treats this as a blob. Brokers should ensure that the client has provided valid configuration parameters
   * and values for the operation. If this field is not present in the request message, then the broker MUST NOT change
   * the parameters of the instance as a result of this request.
   * @param {boolean} [params.acceptsIncomplete] - A value of true indicates that both the IBM Cloud platform and the
   * requesting client support asynchronous deprovisioning. If this parameter is not included in the request, and the
   * broker can only deprovision a service instance of the requested plan asynchronously, the broker MUST reject the
   * request with a `422` Unprocessable Entity.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079872Root>>}
   */
  public replaceServiceInstance(params: OpenServiceBrokerV1.ReplaceServiceInstanceParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079872Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'organization_guid': _params.organizationGuid,
      'plan_id': _params.planId,
      'service_id': _params.serviceId,
      'space_guid': _params.spaceGuid,
      'context': _params.context,
      'parameters': _params.parameters
    };

    const query = {
      'accepts_incomplete': _params.acceptsIncomplete
    };

    const path = {
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceServiceInstance');

    const parameters = {
      options: {
        url: '/v2/service_instances/{instance_id}',
        method: 'PUT',
        body,
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceId - The ID of a previously provisioned service instance.
   * @param {string} [params.serviceId] - The ID of the service stored in the catalog.json of your broker. This value
   * should be a GUID. It MUST be a non-empty string.
   * @param {Context} [params.context] - Platform specific contextual information under which the service instance is to
   * be provisioned.
   * @param {JsonObject} [params.parameters] - Configuration options for the service instance. An opaque object,
   * controller treats this as a blob. Brokers should ensure that the client has provided valid configuration parameters
   * and values for the operation. If this field is not present in the request message, then the broker MUST NOT change
   * the parameters of the instance as a result of this request.
   * @param {string} [params.planId] - The ID of the plan for which the service instance has been requested, which is
   * stored in the catalog.json of your broker. This value should be a GUID. MUST be unique to a service. If present,
   * MUST be a non-empty string. If this field is not present in the request message, then the broker MUST NOT change
   * the plan of the instance as a result of this request.
   * @param {JsonObject} [params.previousValues] - Information about the service instance prior to the update.
   * @param {boolean} [params.acceptsIncomplete] - A value of true indicates that both the IBM Cloud platform and the
   * requesting client support asynchronous deprovisioning. If this parameter is not included in the request, and the
   * broker can only deprovision a service instance of the requested plan asynchronously, the broker MUST reject the
   * request with a `422` Unprocessable Entity.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079874Root>>}
   */
  public updateServiceInstance(params: OpenServiceBrokerV1.UpdateServiceInstanceParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079874Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'service_id': _params.serviceId,
      'context': _params.context,
      'parameters': _params.parameters,
      'plan_id': _params.planId,
      'previous_values': _params.previousValues
    };

    const query = {
      'accepts_incomplete': _params.acceptsIncomplete
    };

    const path = {
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'updateServiceInstance');

    const parameters = {
      options: {
        url: '/v2/service_instances/{instance_id}',
        method: 'PATCH',
        body,
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete (deprovision) a service instance.
   *
   * Delete (deprovision) a service instance by GUID. When a service broker receives a deprovision request from the IBM
   * Cloud platform, it MUST delete any resources it created during the provision. Usually this means that all resources
   * are immediately reclaimed for future provisions.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.serviceId - The ID of the service stored in the catalog.json of your broker. This value
   * should be a GUID. MUST be a non-empty string.
   * @param {string} params.planId - The ID of the plan for which the service instance has been requested, which is
   * stored in the catalog.json of your broker. This value should be a GUID. MUST be a non-empty string.
   * @param {string} params.instanceId - The ID of a previously provisioned service instance.
   * @param {boolean} [params.acceptsIncomplete] - A value of true indicates that both the IBM Cloud platform and the
   * requesting client support asynchronous deprovisioning. If this parameter is not included in the request, and the
   * broker can only deprovision a service instance of the requested plan asynchronously, the broker MUST reject the
   * request with a `422` Unprocessable Entity.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079874Root>>}
   */
  public deleteServiceInstance(params: OpenServiceBrokerV1.DeleteServiceInstanceParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079874Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['serviceId', 'planId', 'instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'service_id': _params.serviceId,
      'plan_id': _params.planId,
      'accepts_incomplete': _params.acceptsIncomplete
    };

    const path = {
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteServiceInstance');

    const parameters = {
      options: {
        url: '/v2/service_instances/{instance_id}',
        method: 'DELETE',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * catalog
   ************************/

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
   * @param {Object} [params] - The parameters to send to the service.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp1874650Root>>}
   */
  public listCatalog(params?: OpenServiceBrokerV1.ListCatalogParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp1874650Root>> {
    const _params = Object.assign({}, params);

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'listCatalog');

    const parameters = {
      options: {
        url: '/v2/catalog',
        method: 'GET',
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * lastOperationAsync
   ************************/

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.instanceId - The unique instance ID generated during provisioning by the IBM Cloud platform.
   * @param {string} [params.operation] - A broker-provided identifier for the operation. When a value for operation is
   * included with asynchronous responses for provision and update, and deprovision requests, the IBM Cloud platform
   * will provide the same value using this query parameter as a URL-encoded string. If present, MUST be a non-empty
   * string.
   * @param {string} [params.planId] - ID of the plan from the catalog.json in your broker. If present, MUST be a
   * non-empty string.
   * @param {string} [params.serviceId] - ID of the service from the catalog.json in your service broker. If present,
   * MUST be a non-empty string.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079894Root>>}
   */
  public getLastOperation(params: OpenServiceBrokerV1.GetLastOperationParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079894Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'operation': _params.operation,
      'plan_id': _params.planId,
      'service_id': _params.serviceId
    };

    const path = {
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'getLastOperation');

    const parameters = {
      options: {
        url: '/v2/service_instances/{instance_id}/last_operation',
        method: 'GET',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /*************************
   * bindingsAndCredentials
   ************************/

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.bindingId - The `binding_id` is provided by the IBM Cloud platform. This ID will be used for
   * future unbind requests, so the broker can use it to correlate the resource it creates.
   * @param {string} params.instanceId - The :`instance_id` is the ID of a previously provisioned service instance.
   * @param {string} [params.planId] - The ID of the plan from the catalog.json in your broker. If present, it MUST be a
   * non-empty string.
   * @param {string} [params.serviceId] - The ID of the service from the catalog.json in your broker. If present, it
   * MUST be a non-empty string.
   * @param {BindResource} [params.bindResource] - A JSON object that contains data for platform resources associated
   * with the binding to be created.
   * @param {JsonObject} [params.parameters] - Configuration options for the service instance. An opaque object,
   * controller treats this as a blob. Brokers should ensure that the client has provided valid configuration parameters
   * and values for the operation. If this field is not present in the request message, then the broker MUST NOT change
   * the parameters of the instance as a result of this request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079876Root>>}
   */
  public replaceServiceBinding(params: OpenServiceBrokerV1.ReplaceServiceBindingParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Resp2079876Root>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['bindingId', 'instanceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'plan_id': _params.planId,
      'service_id': _params.serviceId,
      'bind_resource': _params.bindResource,
      'parameters': _params.parameters
    };

    const path = {
      'binding_id': _params.bindingId,
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'replaceServiceBinding');

    const parameters = {
      options: {
        url: '/v2/service_instances/{instance_id}/service_bindings/{binding_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

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
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.bindingId - The `binding_id` is the ID of a previously provisioned binding for that service
   * instance.
   * @param {string} params.instanceId - The `instance_id` is the ID of a previously provisioned service instance.
   * @param {string} params.planId - The ID of the plan from the catalog.json in the broker. It MUST be a non-empty
   * string and should be a GUID.
   * @param {string} params.serviceId - The ID of the service from the catalog.json in the broker. It MUST be a
   * non-empty string and should be a GUID.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Empty>>}
   */
  public deleteServiceBinding(params: OpenServiceBrokerV1.DeleteServiceBindingParams): Promise<OpenServiceBrokerV1.Response<OpenServiceBrokerV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['bindingId', 'instanceId', 'planId', 'serviceId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'plan_id': _params.planId,
      'service_id': _params.serviceId
    };

    const path = {
      'binding_id': _params.bindingId,
      'instance_id': _params.instanceId
    };

    const sdkHeaders = getSdkHeaders(OpenServiceBrokerV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteServiceBinding');

    const parameters = {
      options: {
        url: '/v2/service_instances/{instance_id}/service_bindings/{binding_id}',
        method: 'DELETE',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

}

/*************************
 * interfaces
 ************************/

namespace OpenServiceBrokerV1 {

  /** An operation response. */
  export interface Response<T = any>  {
    result: T;
    status: number;
    statusText: string;
    headers: IncomingHttpHeaders;
  }

  /** The callback for a service request. */
  export type Callback<T> = (error: any, response?: Response<T>) => void;

  /** The body of a service request that returns no response data. */
  export interface Empty { }

  /** A standard JS object, defined to avoid the limitations of `Object` and `object` */
  export interface JsonObject {
    [key: string]: any;
  }

  /*************************
   * request interfaces
   ************************/

  /** Parameters for the `getServiceInstanceState` operation. */
  export interface GetServiceInstanceStateParams {
    /** The `instance_id` of a service instance is provided by the IBM Cloud platform. This ID will be used for
     *  future requests to bind and deprovision, so the broker can use it to correlate the resource it creates.
     */
    instanceId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceServiceInstanceState` operation. */
  export interface ReplaceServiceInstanceStateParams {
    /** The `instance_id` of a service instance is provided by the IBM Cloud platform. This ID will be used for
     *  future requests to bind and deprovision, so the broker can use it to correlate the resource it creates.
     */
    instanceId: string;
    /** Indicates the current state of the service instance. */
    enabled?: boolean;
    /** Optional string that shows the user ID that is initiating the call. */
    initiatorId?: string;
    /** Optional string that states the reason code for the service instance state change. Valid values are
     *  `IBMCLOUD_ACCT_ACTIVATE`, `IBMCLOUD_RECLAMATION_RESTORE`, or `IBMCLOUD_SERVICE_INSTANCE_BELOW_CAP` for enable
     *  calls; `IBMCLOUD_ACCT_SUSPEND`, `IBMCLOUD_RECLAMATION_SCHEDULE`, or `IBMCLOUD_SERVICE_INSTANCE_ABOVE_CAP` for
     *  disable calls; and `IBMCLOUD_ADMIN_REQUEST` for enable and disable calls.<br/><br/>Previously accepted values
     *  had a `BMX_` prefix, such as `BMX_ACCT_ACTIVATE`. These values are deprecated.
     */
    reasonCode?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceServiceInstance` operation. */
  export interface ReplaceServiceInstanceParams {
    /** The `instance_id` of a service instance is provided by the IBM Cloud platform. This ID will be used for
     *  future requests to bind and deprovision, so the broker can use it to correlate the resource it creates.
     */
    instanceId: string;
    /** Deprecated in favor of `context`. The IBM Cloud platform GUID for the organization under which the service
     *  instance is to be provisioned. Although most brokers will not use this field, it might be helpful for executing
     *  operations on a user's behalf. It MUST be a non-empty string.
     */
    organizationGuid?: string;
    /** The ID of the plan for which the service instance has been requested, which is stored in the catalog.json of
     *  your broker. This value should be a GUID and it MUST be unique to a service.
     */
    planId?: string;
    /** The ID of the service stored in the catalog.json of your broker. This value should be a GUID and it MUST be
     *  a non-empty string.
     */
    serviceId?: string;
    /** Deprecated in favor of `context`. The identifier for the project space within the IBM Cloud platform
     *  organization. Although most brokers will not use this field, it might be helpful for executing operations on a
     *  user's behalf. It MUST be a non-empty string.
     */
    spaceGuid?: string;
    /** Platform specific contextual information under which the service instance is to be provisioned. */
    context?: Context;
    /** Configuration options for the service instance. An opaque object, controller treats this as a blob. Brokers
     *  should ensure that the client has provided valid configuration parameters and values for the operation. If this
     *  field is not present in the request message, then the broker MUST NOT change the parameters of the instance as a
     *  result of this request.
     */
    parameters?: JsonObject;
    /** A value of true indicates that both the IBM Cloud platform and the requesting client support asynchronous
     *  deprovisioning. If this parameter is not included in the request, and the broker can only deprovision a service
     *  instance of the requested plan asynchronously, the broker MUST reject the request with a `422` Unprocessable
     *  Entity.
     */
    acceptsIncomplete?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateServiceInstance` operation. */
  export interface UpdateServiceInstanceParams {
    /** The ID of a previously provisioned service instance. */
    instanceId: string;
    /** The ID of the service stored in the catalog.json of your broker. This value should be a GUID. It MUST be a
     *  non-empty string.
     */
    serviceId?: string;
    /** Platform specific contextual information under which the service instance is to be provisioned. */
    context?: Context;
    /** Configuration options for the service instance. An opaque object, controller treats this as a blob. Brokers
     *  should ensure that the client has provided valid configuration parameters and values for the operation. If this
     *  field is not present in the request message, then the broker MUST NOT change the parameters of the instance as a
     *  result of this request.
     */
    parameters?: JsonObject;
    /** The ID of the plan for which the service instance has been requested, which is stored in the catalog.json of
     *  your broker. This value should be a GUID. MUST be unique to a service. If present, MUST be a non-empty string.
     *  If this field is not present in the request message, then the broker MUST NOT change the plan of the instance as
     *  a result of this request.
     */
    planId?: string;
    /** Information about the service instance prior to the update. */
    previousValues?: JsonObject;
    /** A value of true indicates that both the IBM Cloud platform and the requesting client support asynchronous
     *  deprovisioning. If this parameter is not included in the request, and the broker can only deprovision a service
     *  instance of the requested plan asynchronously, the broker MUST reject the request with a `422` Unprocessable
     *  Entity.
     */
    acceptsIncomplete?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteServiceInstance` operation. */
  export interface DeleteServiceInstanceParams {
    /** The ID of the service stored in the catalog.json of your broker. This value should be a GUID. MUST be a
     *  non-empty string.
     */
    serviceId: string;
    /** The ID of the plan for which the service instance has been requested, which is stored in the catalog.json of
     *  your broker. This value should be a GUID. MUST be a non-empty string.
     */
    planId: string;
    /** The ID of a previously provisioned service instance. */
    instanceId: string;
    /** A value of true indicates that both the IBM Cloud platform and the requesting client support asynchronous
     *  deprovisioning. If this parameter is not included in the request, and the broker can only deprovision a service
     *  instance of the requested plan asynchronously, the broker MUST reject the request with a `422` Unprocessable
     *  Entity.
     */
    acceptsIncomplete?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listCatalog` operation. */
  export interface ListCatalogParams {
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getLastOperation` operation. */
  export interface GetLastOperationParams {
    /** The unique instance ID generated during provisioning by the IBM Cloud platform. */
    instanceId: string;
    /** A broker-provided identifier for the operation. When a value for operation is included with asynchronous
     *  responses for provision and update, and deprovision requests, the IBM Cloud platform will provide the same value
     *  using this query parameter as a URL-encoded string. If present, MUST be a non-empty string.
     */
    operation?: string;
    /** ID of the plan from the catalog.json in your broker. If present, MUST be a non-empty string. */
    planId?: string;
    /** ID of the service from the catalog.json in your service broker. If present, MUST be a non-empty string. */
    serviceId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `replaceServiceBinding` operation. */
  export interface ReplaceServiceBindingParams {
    /** The `binding_id` is provided by the IBM Cloud platform. This ID will be used for future unbind requests, so
     *  the broker can use it to correlate the resource it creates.
     */
    bindingId: string;
    /** The :`instance_id` is the ID of a previously provisioned service instance. */
    instanceId: string;
    /** The ID of the plan from the catalog.json in your broker. If present, it MUST be a non-empty string. */
    planId?: string;
    /** The ID of the service from the catalog.json in your broker. If present, it MUST be a non-empty string. */
    serviceId?: string;
    /** A JSON object that contains data for platform resources associated with the binding to be created. */
    bindResource?: BindResource;
    /** Configuration options for the service instance. An opaque object, controller treats this as a blob. Brokers
     *  should ensure that the client has provided valid configuration parameters and values for the operation. If this
     *  field is not present in the request message, then the broker MUST NOT change the parameters of the instance as a
     *  result of this request.
     */
    parameters?: JsonObject;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteServiceBinding` operation. */
  export interface DeleteServiceBindingParams {
    /** The `binding_id` is the ID of a previously provisioned binding for that service instance. */
    bindingId: string;
    /** The `instance_id` is the ID of a previously provisioned service instance. */
    instanceId: string;
    /** The ID of the plan from the catalog.json in the broker. It MUST be a non-empty string and should be a GUID. */
    planId: string;
    /** The ID of the service from the catalog.json in the broker. It MUST be a non-empty string and should be a
     *  GUID.
     */
    serviceId: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Check the active status of an enabled service. */
  export interface Resp1874644Root {
    /** Indicates (from the viewpoint of the provider) whether the service instance is active and is meaningful if
     *  enabled is true. The default value is true if not specified.
     */
    active?: boolean;
    /** Indicates the current state of the service instance. */
    enabled?: boolean;
    /** Indicates when the service instance was last accessed/modified/etc., and is meaningful if enabled is true
     *  AND active is false. Represented as milliseconds since the epoch, but does not need to be accurate to the
     *  second/hour.
     */
    last_active?: number;
  }

  /** Resp1874650Root. */
  export interface Resp1874650Root {
    /** List of services. */
    services?: Services[];
  }

  /** OK - MUST be returned if the service instance already exists, is fully provisioned, and the requested parameters are identical to the existing service instance. */
  export interface Resp2079872Root {
    /** The URL of a web-based management user interface for the service instance; we refer to this as a service
     *  dashboard. The URL MUST contain enough information for the dashboard to identify the resource being accessed.
     *  Note: a broker that wishes to return `dashboard_url` for a service instance MUST return it with the initial
     *  response to the provision request, even if the service is provisioned asynchronously. If present, it MUST be a
     *  non-empty string.
     */
    dashboard_url?: string;
    /** For asynchronous responses, service brokers MAY return an identifier representing the operation. The value
     *  of this field MUST be provided by the platform with requests to the `last_operation` endpoint in a URL encoded
     *  query parameter. If present, MUST be a non-empty string.
     */
    operation?: string;
  }

  /** Accepted - MUST be returned if the service instance provisioning is in progress. This triggers the IBM Cloud platform to poll the Service Instance `last_operation` Endpoint for operation status. Note that a re-sent `PUT` request MUST return a `202 Accepted`, not a `200 OK`, if the service instance is not yet fully provisioned. */
  export interface Resp2079874Root {
    /** For asynchronous responses, service brokers MAY return an identifier representing the operation. The value
     *  of this field MUST be provided by the platform with requests to the Last Operation endpoint in a URL encoded
     *  query parameter. If present, MUST be a non-empty string.
     */
    operation?: string;
  }

  /** Resp2079876Root. */
  export interface Resp2079876Root {
    /** A free-form hash of credentials that can be used by applications or users to access the service. */
    credentials?: JsonObject;
    /** A URL to which logs MUST be streamed. 'requires':['syslog_drain'] MUST be declared in the Catalog endpoint
     *  or the platform MUST consider the response invalid.
     */
    syslog_drain_url?: string;
    /** A URL to which the platform MUST proxy requests for the address sent with bind_resource.route in the request
     *  body. 'requires':['route_forwarding'] MUST be declared in the Catalog endpoint or the platform can consider the
     *  response invalid.
     */
    route_service_url?: string;
    /** An array of configuration for remote storage devices to be mounted into an application container filesystem.
     *  'requires':['volume_mount'] MUST be declared in the Catalog endpoint or the platform can consider the response
     *  invalid.
     */
    volume_mounts?: VolumeMount[];
  }

  /** OK - MUST be returned upon successful processing of this request. */
  export interface Resp2079894Root {
    /** A user-facing message displayed to the platform API client. Can be used to tell the user details about the
     *  status of the operation. If present, MUST be a non-empty string.
     */
    description?: string;
    /** Valid values are `in progress`, `succeeded`, and `failed`. While `â€ state": "in progressâ€ `, the platform
     *  SHOULD continue polling. A response with `â€ state": "succeededâ€ ` or `â€ state": "failedâ€ ` MUST cause the
     *  platform to cease polling.
     */
    state: string;
  }

  /** Check the enabled status of active service. */
  export interface Resp2448145Root {
    /** Indicates (from the viewpoint of the provider) whether the service instance is active and is meaningful if
     *  `enabled` is true.  The default value is true if not specified.
     */
    active?: boolean;
    /** Indicates the current state of the service instance. */
    enabled: boolean;
    /** Indicates when the service instance was last accessed or modified, and is meaningful if `enabled` is true
     *  AND `active` is false.  Represented as milliseconds since the epoch, but does not need to be accurate to the
     *  second/hour.
     */
    last_active?: number;
  }

  /** A JSON object that contains data for platform resources associated with the binding to be created. */
  export interface BindResource {
    /** Account owner of resource to bind. */
    account_id?: string;
    /** Service ID of resource to bind. */
    serviceid_crn?: string;
    /** Target ID of resource to bind. */
    target_crn?: string;
    /** GUID of an application associated with the binding. For credentials bindings. */
    app_guid?: string;
    /** URL of the application to be intermediated. For route services bindings. */
    route?: string;
  }

  /** Platform specific contextual information under which the service instance is to be provisioned. */
  export interface Context {
    /** Returns the ID of the account in IBM Cloud that is provisioning the service instance. */
    account_id?: string;
    /** When a customer provisions your service in IBM Cloud, a service instance is created and this instance is
     *  identified by its IBM Cloud Resource Name (CRN). The CRN is utilized in all aspects of the interaction with IBM
     *  Cloud including provisioning, binding (creating credentials and endpoints), metering, dashboard display, and
     *  access control. From a service provider perspective, the CRN can largely be treated as an opaque string to be
     *  utilized with the IBM Cloud APIs, but it can also be decomposed via the following structure:
     *  `crn:version:cname:ctype:service-name:location:scope:service-instance:resource-type:resource`.
     */
    crn?: string;
    /** Identifies the platform as "ibmcloud". */
    platform?: string;
  }

  /** Where is this in the source?. */
  export interface Plans {
    /** A short description of the plan. It MUST be a non-empty string. The description is NOT displayed in the IBM
     *  Cloud catalog or IBM Cloud CLI.
     */
    description: string;
    /** When false, service instances of this plan have a cost. The default is true. */
    free?: boolean;
    /** An identifier used to correlate this plan in future requests to the broker.  This MUST be globally unique
     *  within a platform marketplace. It MUST be a non-empty string and using a GUID is RECOMMENDED. If you define your
     *  service in the RMC, it will create a unique GUID for you to use. It is recommended to use the RMC to define and
     *  generate these values and then use them in your catalog.json metadata in your broker. This value is NOT
     *  displayed in the IBM Cloud catalog or IBM Cloud CLI.
     */
    id: string;
    /** The programmatic name of the plan. It MUST be unique within the service. All lowercase, no spaces. It MUST
     *  be a non-empty string, and it's NOT displayed in the IBM Cloud catalog or IBM Cloud CLI.
     */
    name: string;
  }

  /** The service object that describes the properties of your service. */
  export interface Services {
    /** Specifies whether or not your service can be bound to applications in IBM Cloud. If bindable, it must be
     *  able to return API endpoints and credentials to your service consumers.
     */
    bindable: boolean;
    /** A short description of the service. It MUST be a non-empty string. Note that this description is not
     *  displayed by the the IBM Cloud console or IBM Cloud CLI.
     */
    description: string;
    /** An identifier used to correlate this service in future requests to the broker. This MUST be globally unique
     *  within the IBM Cloud platform. It MUST be a non-empty string, and using a GUID is recommended. Recommended: If
     *  you define your service in the RMC, the RMC will generate a globally unique GUID service ID that you can use in
     *  your service broker.
     */
    id: string;
    /** The service name is not your display name. Your service name must follow the follow these rules:
     *   - It must be all lowercase.
     *   - It can't include spaces but may include hyphens (`-`).
     *   - It must be less than 32 characters.
     *   Your service name should include your company name. If your company has more then one offering your service
     *  name should include both company and offering as part of the name. For example, the Compose company has
     *  offerings for Redis and Elasticsearch. Sample service names on IBM Cloud for these offerings would be
     *  `compose-redis` and `compose-elasticsearch`.  Each of these service names have associated display names that are
     *  shown in the IBM Cloud catalog: *Compose Redis* and *Compose Elasticsearch*. Another company (e.g. FastJetMail)
     *  may only have the single JetMail offering, in which case the service name should be `fastjetmail`. Recommended:
     *  If you define your service in RMC, you can export a catalog.json that will include the service name you defined
     *  within the RMC.
     */
    name: string;
    /** The Default is false. This specifices whether or not you support plan changes for provisioned instances. If
     *  your offering supports multiple plans, and you want users to be able to change plans for a provisioned instance,
     *  you will need to enable the ability for users to update their service instance by using
     *  /v2/service_instances/{instance_id} PATCH.
     */
    plan_updateable?: boolean;
    /** A list of plans for this service that must contain at least one plan. */
    plans: Plans[];
  }

  /** VolumeMount. */
  export interface VolumeMount {
    /** A free-form hash of credentials that can be used by applications or users to access the service. */
    driver: string;
    /** The path in the application container onto which the volume will be mounted. This specification does not
     *  mandate what action the platform is to take if the path specified already exists in the container.
     */
    container_dir: string;
    /** 'r' to mount the volume read-only or 'rw' to mount it read-write. */
    mode: string;
    /** A string specifying the type of device to mount. Currently the only supported value is 'shared'. */
    device_type: string;
    /** Device object containing device_type specific details. Currently only shared devices are supported. */
    device: string;
  }

}

export = OpenServiceBrokerV1;
