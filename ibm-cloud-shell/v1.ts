/**
 * (C) Copyright IBM Corp. 2021.
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
 * IBM OpenAPI SDK Code Generator Version: 3.33.0-caf29bd0-20210603-225214
 */

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import {
  Authenticator,
  BaseService,
  getAuthenticatorFromEnvironment,
  getMissingParams,
  UserOptions,
} from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * API docs for IBM Cloud Shell repository
 */

class IbmCloudShellV1 extends BaseService {
  static DEFAULT_SERVICE_URL: string = 'https://api.shell.cloud.ibm.com';

  static DEFAULT_SERVICE_NAME: string = 'ibm_cloud_shell';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of IbmCloudShellV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {IbmCloudShellV1}
   */

  public static newInstance(options: UserOptions): IbmCloudShellV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new IbmCloudShellV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a IbmCloudShellV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {IbmCloudShellV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(IbmCloudShellV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * accountSettings
   ************************/

  /**
   * Get account settings.
   *
   * Retrieve account settings for the given account ID. Call this method to get details about a particular account
   * setting, whether Cloud Shell is enabled, the list of enabled regions and the list of enabled features. Users need
   * to be an account owner or users need to be assigned an IAM policy with the Administrator role for the Cloud Shell
   * account management service.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account ID in which the account settings belong to.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IbmCloudShellV1.Response<IbmCloudShellV1.AccountSettings>>}
   */
  public getAccountSettings(
    params: IbmCloudShellV1.GetAccountSettingsParams
  ): Promise<IbmCloudShellV1.Response<IbmCloudShellV1.AccountSettings>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      IbmCloudShellV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getAccountSettings'
    );

    const parameters = {
      options: {
        url: '/api/v1/user/accounts/{account_id}/settings',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Update account settings.
   *
   * Update account settings for the given account ID. Call this method to update account settings configuration, you
   * can enable or disable Cloud Shell, enable or disable available regions and enable and disable features. To update
   * account settings, users need to be an account owner or users need to be assigned an IAM policy with the
   * Administrator role for the Cloud Shell account management service.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The account ID in which the account settings belong to.
   * @param {string} [params.rev] - Unique revision number for the settings object.
   * @param {boolean} [params.defaultEnableNewFeatures] - You can choose which Cloud Shell features are available in the
   * account and whether any new features are enabled as they become available. The feature settings apply only to the
   * enabled Cloud Shell locations.
   * @param {boolean} [params.defaultEnableNewRegions] - Set whether Cloud Shell is enabled in a specific location for
   * the account. The location determines where user and session data are stored. By default, users are routed to the
   * nearest available location.
   * @param {boolean} [params.enabled] - When enabled, Cloud Shell is available to all users in the account.
   * @param {Feature[]} [params.features] - List of Cloud Shell features.
   * @param {RegionSetting[]} [params.regions] - List of Cloud Shell region settings.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<IbmCloudShellV1.Response<IbmCloudShellV1.AccountSettings>>}
   */
  public updateAccountSettings(
    params: IbmCloudShellV1.UpdateAccountSettingsParams
  ): Promise<IbmCloudShellV1.Response<IbmCloudShellV1.AccountSettings>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      '_rev': _params.rev,
      'default_enable_new_features': _params.defaultEnableNewFeatures,
      'default_enable_new_regions': _params.defaultEnableNewRegions,
      'enabled': _params.enabled,
      'features': _params.features,
      'regions': _params.regions,
    };

    const path = {
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      IbmCloudShellV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateAccountSettings'
    );

    const parameters = {
      options: {
        url: '/api/v1/user/accounts/{account_id}/settings',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }
}

/*************************
 * interfaces
 ************************/

namespace IbmCloudShellV1 {
  /** An operation response. */
  export interface Response<T = any> {
    result: T;
    status: number;
    statusText: string;
    headers: IncomingHttpHeaders;
  }

  /** The callback for a service request. */
  export type Callback<T> = (error: any, response?: Response<T>) => void;

  /** The body of a service request that returns no response data. */
  export interface Empty {}

  /** A standard JS object, defined to avoid the limitations of `Object` and `object` */
  export interface JsonObject {
    [key: string]: any;
  }

  /*************************
   * request interfaces
   ************************/

  /** Parameters for the `getAccountSettings` operation. */
  export interface GetAccountSettingsParams {
    /** The account ID in which the account settings belong to. */
    accountId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateAccountSettings` operation. */
  export interface UpdateAccountSettingsParams {
    /** The account ID in which the account settings belong to. */
    accountId: string;
    /** Unique revision number for the settings object. */
    rev?: string;
    /** You can choose which Cloud Shell features are available in the account and whether any new features are
     *  enabled as they become available. The feature settings apply only to the enabled Cloud Shell locations.
     */
    defaultEnableNewFeatures?: boolean;
    /** Set whether Cloud Shell is enabled in a specific location for the account. The location determines where
     *  user and session data are stored. By default, users are routed to the nearest available location.
     */
    defaultEnableNewRegions?: boolean;
    /** When enabled, Cloud Shell is available to all users in the account. */
    enabled?: boolean;
    /** List of Cloud Shell features. */
    features?: Feature[];
    /** List of Cloud Shell region settings. */
    regions?: RegionSetting[];
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Definition of Cloud Shell account settings. */
  export interface AccountSettings {
    /** Unique id of the settings object. */
    _id?: string;
    /** Unique revision number for the settings object. */
    _rev?: string;
    /** The id of the account the settings belong to. */
    account_id?: string;
    /** Creation timestamp. */
    created_at?: string;
    /** IAM ID of creator. */
    created_by?: string;
    /** You can choose which Cloud Shell features are available in the account and whether any new features are
     *  enabled as they become available. The feature settings apply only to the enabled Cloud Shell locations.
     */
    default_enable_new_features?: boolean;
    /** Set whether Cloud Shell is enabled in a specific location for the account. The location determines where
     *  user and session data are stored. By default, users are routed to the nearest available location.
     */
    default_enable_new_regions?: boolean;
    /** When enabled, Cloud Shell is available to all users in the account. */
    enabled?: boolean;
    /** List of Cloud Shell features. */
    features?: Feature[];
    /** List of Cloud Shell region settings. */
    regions?: RegionSetting[];
    /** Type of api response object. */
    type?: string;
    /** Timestamp of last update. */
    updated_at?: string;
    /** IAM ID of last updater. */
    updated_by?: string;
  }

  /** Describes a Cloud Shell feature. */
  export interface Feature {
    /** State of the feature. */
    enabled?: boolean;
    /** Name of the feature. */
    key?: string;
  }

  /** Describes a Cloud Shell region setting. */
  export interface RegionSetting {
    /** State of the region. */
    enabled?: boolean;
    /** Name of the region. */
    key?: string;
  }
}

export = IbmCloudShellV1;
