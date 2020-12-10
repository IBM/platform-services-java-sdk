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
 * IBM Cloud Usage Metering is a platform service that enables service providers to submit metrics collected for
 * resource instances provisioned by IBM Cloud users. IBM and third-party service providers that are delivering  an
 * integrated billing service in IBM Cloud are required to submit usage for all active service instances every hour.
 * This is important because inability to report usage can lead to loss of revenue collection for IBM,  in turn causing
 * loss of revenue share for the service providers.
 */

class UsageMeteringV4 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://billing.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'usage_metering';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of UsageMeteringV4 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {UsageMeteringV4}
   */

  public static newInstance(options: UserOptions): UsageMeteringV4 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new UsageMeteringV4(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a UsageMeteringV4 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {UsageMeteringV4}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(UsageMeteringV4.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * resourceUsage
   ************************/

  /**
   * Report Resource Controller resource usage.
   *
   * Report usage for resource instances that were provisioned through the resource controller.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.resourceId - The resource for which the usage is submitted.
   * @param {ResourceInstanceUsage[]} params.resourceUsage -
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<UsageMeteringV4.Response<UsageMeteringV4.ResponseAccepted>>}
   */
  public reportResourceUsage(params: UsageMeteringV4.ReportResourceUsageParams): Promise<UsageMeteringV4.Response<UsageMeteringV4.ResponseAccepted>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['resourceId', 'resourceUsage'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = _params.resourceUsage;
    const path = {
      'resource_id': _params.resourceId
    };

    const sdkHeaders = getSdkHeaders(UsageMeteringV4.DEFAULT_SERVICE_NAME, 'v4', 'reportResourceUsage');

    const parameters = {
      options: {
        url: '/v4/metering/resources/{resource_id}/usage',
        method: 'POST',
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

}

/*************************
 * interfaces
 ************************/

namespace UsageMeteringV4 {

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

  /** Parameters for the `reportResourceUsage` operation. */
  export interface ReportResourceUsageParams {
    /** The resource for which the usage is submitted. */
    resourceId: string;
    resourceUsage: ResourceInstanceUsage[];
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** A usage measurement. */
  export interface MeasureAndQuantity {
    /** The name of the measure. */
    measure: string;
    /** For consumption-based submissions, `quantity` can be a double or integer value. For event-based submissions
     *  that do not have binary states, previous and current values are required, such as `{ "previous": 1, "current": 2
     *  }`.
     */
    quantity: any;
  }

  /** Usage information for a resource instance. */
  export interface ResourceInstanceUsage {
    /** The ID of the instance that incurred the usage. The ID is a CRN for instances that are provisioned with the
     *  resource controller.
     */
    resource_instance_id: string;
    /** The plan with which the instance's usage should be metered. */
    plan_id: string;
    /** The pricing region to which the usage must be aggregated. This field is required if the ID is not a CRN or
     *  if the CRN does not have a region.
     */
    region?: string;
    /** The time from which the resource instance was metered in the format milliseconds since epoch. */
    start: number;
    /** The time until which the resource instance was metered in the format milliseconds since epoch. This value is
     *  the same as start value for event-based submissions.
     */
    end: number;
    /** Usage measurements for the resource instance. */
    measured_usage: MeasureAndQuantity[];
    /** If an instance's usage should be aggregated at the consumer level, specify the ID of the consumer. Usage is
     *  accumulated to the instance-consumer combination.
     */
    consumer_id?: string;
  }

  /** Resource usage details. */
  export interface ResourceUsageDetails {
    /** A response code similar to HTTP status codes. */
    status: number;
    /** The location of the usage. */
    location: string;
    /** The error code that was encountered. */
    code?: string;
    /** A description of the error. */
    message?: string;
  }

  /** Response when usage submitted is accepted. */
  export interface ResponseAccepted {
    /** Response body that contains the status of each submitted usage record. */
    resources: ResourceUsageDetails[];
  }

}

export = UsageMeteringV4;
