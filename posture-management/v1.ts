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
 * IBM OpenAPI SDK Code Generator Version: 3.29.1-b338fb38-20210313-010605
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
 * With IBM Cloud® Security and Compliance Center, you can embed checks into your every day workflows to help manage
 * your current security and compliance posture. By monitoring for risks, you can identify security vulnerabilities and
 * quickly work to mitigate the impact.
 */

class PostureManagementV1 extends BaseService {
  static DEFAULT_SERVICE_NAME: string = 'posture_management';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of PostureManagementV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {PostureManagementV1}
   */

  public static newInstance(options: UserOptions): PostureManagementV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new PostureManagementV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a PostureManagementV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {PostureManagementV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    }
  }

  /*************************
   * scans
   ************************/

  /**
   * Initiate a validations scan.
   *
   * Validations scans determine a specified scope's adherence to regulatory controls by validating the configuration of
   * the resources in your scope to the attached profile. To initiate a scan, you must have configured a collector,
   * provided credentials, and completed both a fact collection and discovery scan. [Learn
   * more](/docs/security-compliance?topic=security-compliance-schedule-scan).
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Your IBM Cloud account ID.
   * @param {string} [params.scopeId] - The unique ID of the scope.
   * @param {string} [params.profileId] - The unique ID of the profile.
   * @param {string} [params.groupProfileId] - The ID of the profile group.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<PostureManagementV1.Response<PostureManagementV1.Result>>}
   */
  public createValidation(
    params: PostureManagementV1.CreateValidationParams
  ): Promise<PostureManagementV1.Response<PostureManagementV1.Result>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'scope_id': _params.scopeId,
      'profile_id': _params.profileId,
      'group_profile_id': _params.groupProfileId,
    };

    const query = {
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      PostureManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createValidation'
    );

    const parameters = {
      options: {
        url: '/posture/v1/scans/validations',
        method: 'POST',
        body,
        qs: query,
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

  /*************************
   * profiles
   ************************/

  /**
   * List profiles.
   *
   * List all of the profiles that are available in your account. To view a specific profile, you can filter by name.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Your account ID.
   * @param {string} [params.name] - The name of the profile.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<PostureManagementV1.Response<PostureManagementV1.ProfilesList>>}
   */
  public listProfiles(
    params: PostureManagementV1.ListProfilesParams
  ): Promise<PostureManagementV1.Response<PostureManagementV1.ProfilesList>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'name': _params.name,
    };

    const sdkHeaders = getSdkHeaders(
      PostureManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listProfiles'
    );

    const parameters = {
      options: {
        url: '/posture/v1/profiles',
        method: 'GET',
        qs: query,
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

  /*************************
   * scopes
   ************************/

  /**
   * List scopes.
   *
   * List all of the scopes that are available in your account. To view a specific scope, you can filter by name.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Your IBM Cloud account ID.
   * @param {string} [params.name] - The name of the scope.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<PostureManagementV1.Response<PostureManagementV1.ScopesList>>}
   */
  public listScopes(
    params: PostureManagementV1.ListScopesParams
  ): Promise<PostureManagementV1.Response<PostureManagementV1.ScopesList>> {
    const _params = { ...params };
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'name': _params.name,
    };

    const sdkHeaders = getSdkHeaders(PostureManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'listScopes');

    const parameters = {
      options: {
        url: '/posture/v1/scopes',
        method: 'GET',
        qs: query,
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
}

/*************************
 * interfaces
 ************************/

namespace PostureManagementV1 {
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

  /** Parameters for the `createValidation` operation. */
  export interface CreateValidationParams {
    /** Your IBM Cloud account ID. */
    accountId: string;
    /** The unique ID of the scope. */
    scopeId?: string;
    /** The unique ID of the profile. */
    profileId?: string;
    /** The ID of the profile group. */
    groupProfileId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listProfiles` operation. */
  export interface ListProfilesParams {
    /** Your account ID. */
    accountId: string;
    /** The name of the profile. */
    name?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listScopes` operation. */
  export interface ListScopesParams {
    /** Your IBM Cloud account ID. */
    accountId: string;
    /** The name of the scope. */
    name?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** The criteria that defines how a profile applies. */
  export interface ApplicabilityCriteria {
    /** A list of environments that a profile can be applied to. */
    environment?: string[];
    /** A list of resources that a profile can be used with. */
    resource?: string[];
    /** The type of environment that a profile is able to be applied to. */
    environment_category?: string[];
    /** The type of resource that a profile is able to be applied to. */
    resource_category?: string[];
    /** The resource type that the profile applies to. */
    resource_type?: string[];
    /** The software that the profile applies to. */
    software_details?: JsonObject;
    /** The operatoring system that the profile applies to. */
    os_details?: JsonObject;
    /** Any additional details about the profile. */
    additional_details?: JsonObject;
    /** The type of environment that your scope is targeted to. */
    environment_category_description?: JsonObject;
    /** The environment that your scope is targeted to. */
    environment_description?: JsonObject;
    /** The type of resource that your scope is targeted to. */
    resource_category_description?: JsonObject;
    /** A further classification of the type of resource that your scope is targeted to. */
    resource_type_description?: JsonObject;
    /** The resource that is scanned as part of your scope. */
    resource_description?: JsonObject;
  }

  /** Profile. */
  export interface Profile {
    /** The name of the profile. */
    name?: string;
    /** A description of the profile. */
    description?: string;
    /** The version of the profile. */
    version?: number;
    /** The user who created the profile. */
    created_by?: string;
    /** The user who last modified the profile. */
    modified_by?: string;
    /** A reason that you want to delete a profile. */
    reason_for_delete?: string;
    /** The criteria that defines how a profile applies. */
    applicability_criteria?: ApplicabilityCriteria;
    /** An auto-generated unique identifying number of the profile. */
    profile_id?: string;
    /** The base profile that the controls are pulled from. */
    base_profile?: string;
    /** The type of profile. */
    profile_type?: string;
    /** The time that the profile was created in UTC. */
    created_time?: string;
    /** The time that the profile was most recently modified in UTC. */
    modified_time?: string;
    /** The profile status. If the profile is enabled, the value is true. If the profile is disabled, the value is
     *  false.
     */
    enabled?: boolean;
  }

  /** A list of profiles. */
  export interface ProfilesList {
    /** Profiles. */
    profiles?: Profile[];
  }

  /** Result. */
  export interface Result {
    /** Result. */
    result?: boolean;
    /** A message is returned. */
    message?: string;
  }

  /** Scan. */
  export interface Scan {
    /** An auto-generated unique identifier for the scan. */
    scan_id?: string;
    /** An auto-generated unique identifier for discovery. */
    discover_id?: string;
    /** The status of the collector as it completes a scan. */
    status?: string;
    /** The current status of the collector. */
    status_message?: string;
  }

  /** Scope. */
  export interface Scope {
    /** A detailed description of the scope. */
    description?: string;
    /** The user who created the scope. */
    created_by?: string;
    /** The user who most recently modified the scope. */
    modified_by?: string;
    /** An auto-generated unique identifier for the scope. */
    scope_id?: string;
    /** A unique name for your scope. */
    name?: string;
    /** Indicates whether scope is enabled/disabled. */
    enabled?: boolean;
    /** The environment that the scope is targeted to. */
    environment_type?: string;
    /** The time that the scope was created in UTC. */
    created_time?: string;
    /** The time that the scope was last modified in UTC. */
    modified_time?: string;
    /** The last type of scan that was run on the scope. */
    last_scan_type?: string;
    /** A description of the last scan type. */
    last_scan_type_description?: string;
    /** The last time that a scan status for a scope was updated in UTC. */
    last_scan_status_updated_time?: string;
    /** The unique IDs of the collectors that are attached to the scope. */
    collectors_id?: string[];
    /** A list of the scans that have been run on the scope. */
    scans?: Scan[];
  }

  /** Scopes list. */
  export interface ScopesList {
    /** Scopes. */
    scopes?: Scope[];
  }
}

export = PostureManagementV1;
