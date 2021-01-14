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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-c6db7f4a-20210114-141015
 */


import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * API specification for the Configuration Governance service.
 */

class ConfigurationGovernanceV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://compliance.cloud.ibm.com';
  static DEFAULT_SERVICE_NAME: string = 'configuration_governance';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of ConfigurationGovernanceV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {ConfigurationGovernanceV1}
   */

  public static newInstance(options: UserOptions): ConfigurationGovernanceV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new ConfigurationGovernanceV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a ConfigurationGovernanceV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {ConfigurationGovernanceV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(ConfigurationGovernanceV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * rules
   ************************/

  /**
   * Create rules.
   *
   * Creates one or more rules that you can use to govern the way that IBM Cloud resources can be provisioned and
   * configured.
   *
   * A successful `POST /config/rules` request defines a rule based on the target, conditions, and enforcement actions
   * that you specify. The response returns the ID value for your rule, along with other metadata.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {CreateRuleRequest[]} params.rules - A list of rules to be created.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.CreateRulesResponse>>}
   */
  public createRules(params: ConfigurationGovernanceV1.CreateRulesParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.CreateRulesResponse>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['rules'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'rules': _params.rules
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'createRules');

    const parameters = {
      options: {
        url: '/config/v1/rules',
        method: 'POST',
        body,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * List rules.
   *
   * Retrieves a list of the rules that are available in your account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - Your IBM Cloud account ID.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {boolean} [params.attached] - Retrieves a list of rules that have scope attachments.
   * @param {string} [params.labels] - Retrieves a list of rules that match the labels that you specify.
   * @param {string} [params.scopes] - Retrieves a list of rules that match the scope ID that you specify.
   * @param {number} [params.limit] - The number of resources to retrieve. By default, list operations return the first
   * 100 items. To retrieve a different set of items, use `limit` with `offset` to page through your available
   * resources.
   *
   * **Usage:** If you have 20 rules, and you want to retrieve only the first 5 rules, use
   * `../rules?account_id={account_id}&limit=5`.
   * @param {number} [params.offset] - The number of resources to skip. By specifying `offset`, you retrieve a subset of
   * resources that starts with the `offset` value. Use `offset` with `limit` to page through your available resources.
   *
   * **Usage:** If you have 100 rules, and you want to retrieve rules 26 through 50, use
   * `../rules?account_id={account_id}&offset=25&limit=5`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.RuleList>>}
   */
  public listRules(params: ConfigurationGovernanceV1.ListRulesParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.RuleList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'account_id': _params.accountId,
      'attached': _params.attached,
      'labels': _params.labels,
      'scopes': _params.scopes,
      'limit': _params.limit,
      'offset': _params.offset
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'listRules');

    const parameters = {
      options: {
        url: '/config/v1/rules',
        method: 'GET',
        qs: query,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get a rule.
   *
   * Retrieves an existing rule and its details.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Rule>>}
   */
  public getRule(params: ConfigurationGovernanceV1.GetRuleParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Rule>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'getRule');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update a rule.
   *
   * Updates an existing rule based on the properties that you specify.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} params.ifMatch - Compares a supplied `Etag` value with the version that is stored for the requested
   * resource. If the values match, the server allows the request method to continue.
   *
   * To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
   * headers.
   * @param {string} params.name - A human-readable alias to assign to your rule.
   * @param {string} params.description - An extended description of your rule.
   * @param {TargetResource} params.target - The properties that describe the resource that you want to target
   * with the rule.
   * @param {RuleRequiredConfig} params.requiredConfig -
   * @param {EnforcementAction[]} params.enforcementActions - The actions that the service must run on your behalf when
   * a request to create or modify the target resource does not comply with your conditions.
   * @param {string} [params.accountId] - Your IBM Cloud account ID.
   * @param {string} [params.ruleType] - The type of rule. Rules that you create are `user_defined`.
   * @param {string[]} [params.labels] - Labels that you can use to group and search for similar rules, such as those
   * that help you to meet a specific organization guideline.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Rule>>}
   */
  public updateRule(params: ConfigurationGovernanceV1.UpdateRuleParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Rule>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId', 'ifMatch', 'name', 'description', 'target', 'requiredConfig', 'enforcementActions'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'description': _params.description,
      'target': _params.target,
      'required_config': _params.requiredConfig,
      'enforcement_actions': _params.enforcementActions,
      'account_id': _params.accountId,
      'rule_type': _params.ruleType,
      'labels': _params.labels
    };

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'updateRule');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'If-Match': _params.ifMatch,
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete a rule.
   *
   * Deletes an existing rule.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Empty>>}
   */
  public deleteRule(params: ConfigurationGovernanceV1.DeleteRuleParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteRule');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Create attachments.
   *
   * Creates one or more scope attachments for an existing rule.
   *
   * You can attach an existing rule to a scope, such as a specific IBM Cloud account, to start evaluating the rule for
   * compliance. A successful
   * `POST /config/v1/rules/{rule_id}/attachments` returns the ID value for the attachment, along with other metadata.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {AttachmentRequest[]} params.attachments -
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.CreateAttachmentsResponse>>}
   */
  public createAttachments(params: ConfigurationGovernanceV1.CreateAttachmentsParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.CreateAttachmentsResponse>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId', 'attachments'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'attachments': _params.attachments
    };

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'createAttachments');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}/attachments',
        method: 'POST',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * List attachments.
   *
   * Retrieves a list of scope attachments that are associated with the specified rule.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {number} [params.limit] - The number of resources to retrieve. By default, list operations return the first
   * 100 items. To retrieve a different set of items, use `limit` with `offset` to page through your available
   * resources.
   *
   * **Usage:** If you have 20 rules, and you want to retrieve only the first 5 rules, use
   * `../rules?account_id={account_id}&limit=5`.
   * @param {number} [params.offset] - The number of resources to skip. By specifying `offset`, you retrieve a subset of
   * resources that starts with the `offset` value. Use `offset` with `limit` to page through your available resources.
   *
   * **Usage:** If you have 100 rules, and you want to retrieve rules 26 through 50, use
   * `../rules?account_id={account_id}&offset=25&limit=5`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.AttachmentList>>}
   */
  public listAttachments(params: ConfigurationGovernanceV1.ListAttachmentsParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.AttachmentList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'limit': _params.limit,
      'offset': _params.offset
    };

    const path = {
      'rule_id': _params.ruleId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'listAttachments');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}/attachments',
        method: 'GET',
        qs: query,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Get an attachment.
   *
   * Retrieves an existing scope attachment for a rule.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} params.attachmentId - The UUID that uniquely identifies the attachment.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Attachment>>}
   */
  public getAttachment(params: ConfigurationGovernanceV1.GetAttachmentParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Attachment>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId', 'attachmentId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'rule_id': _params.ruleId,
      'attachment_id': _params.attachmentId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'getAttachment');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}/attachments/{attachment_id}',
        method: 'GET',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Update an attachment.
   *
   * Updates an existing scope attachment based on the properties that you specify.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} params.attachmentId - The UUID that uniquely identifies the attachment.
   * @param {string} params.ifMatch - Compares a supplied `Etag` value with the version that is stored for the requested
   * resource. If the values match, the server allows the request method to continue.
   *
   * To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
   * headers.
   * @param {string} params.accountId - Your IBM Cloud account ID.
   * @param {RuleScope} params.includedScope - The extent at which the rule can be attached across your accounts.
   * @param {RuleScope[]} [params.excludedScopes] - The extent at which the rule can be excluded from the included
   * scope.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Attachment>>}
   */
  public updateAttachment(params: ConfigurationGovernanceV1.UpdateAttachmentParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Attachment>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId', 'attachmentId', 'ifMatch', 'accountId', 'includedScope'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'account_id': _params.accountId,
      'included_scope': _params.includedScope,
      'excluded_scopes': _params.excludedScopes
    };

    const path = {
      'rule_id': _params.ruleId,
      'attachment_id': _params.attachmentId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'updateAttachment');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}/attachments/{attachment_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'If-Match': _params.ifMatch,
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Delete an attachment.
   *
   * Deletes an existing scope attachment.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.ruleId - The UUID that uniquely identifies the rule.
   * @param {string} params.attachmentId - The UUID that uniquely identifies the attachment.
   * @param {string} [params.transactionId] - The unique identifier that is used to trace an entire request. If you omit
   * this field, the service generates and sends a transaction ID as a response header of the request. In the case of an
   * error, the transaction ID is set in the `trace` field of the response body.
   *
   * **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `Transaction-Id`
   * with each request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Empty>>}
   */
  public deleteAttachment(params: ConfigurationGovernanceV1.DeleteAttachmentParams): Promise<ConfigurationGovernanceV1.Response<ConfigurationGovernanceV1.Empty>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['ruleId', 'attachmentId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'rule_id': _params.ruleId,
      'attachment_id': _params.attachmentId
    };

    const sdkHeaders = getSdkHeaders(ConfigurationGovernanceV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteAttachment');

    const parameters = {
      options: {
        url: '/config/v1/rules/{rule_id}/attachments/{attachment_id}',
        method: 'DELETE',
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Transaction-Id': _params.transactionId
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

}

/*************************
 * interfaces
 ************************/

namespace ConfigurationGovernanceV1 {

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

  /** Parameters for the `createRules` operation. */
  export interface CreateRulesParams {
    /** A list of rules to be created. */
    rules: CreateRuleRequest[];
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listRules` operation. */
  export interface ListRulesParams {
    /** Your IBM Cloud account ID. */
    accountId: string;
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    /** Retrieves a list of rules that have scope attachments. */
    attached?: boolean;
    /** Retrieves a list of rules that match the labels that you specify. */
    labels?: string;
    /** Retrieves a list of rules that match the scope ID that you specify. */
    scopes?: string;
    /** The number of resources to retrieve. By default, list operations return the first 100 items. To retrieve a
     *  different set of items, use `limit` with `offset` to page through your available resources.
     *
     *  **Usage:** If you have 20 rules, and you want to retrieve only the first 5 rules, use
     *  `../rules?account_id={account_id}&limit=5`.
     */
    limit?: number;
    /** The number of resources to skip. By specifying `offset`, you retrieve a subset of resources that starts with
     *  the `offset` value. Use `offset` with `limit` to page through your available resources.
     *
     *  **Usage:** If you have 100 rules, and you want to retrieve rules 26 through 50, use
     *  `../rules?account_id={account_id}&offset=25&limit=5`.
     */
    offset?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getRule` operation. */
  export interface GetRuleParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateRule` operation. */
  export interface UpdateRuleParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** Compares a supplied `Etag` value with the version that is stored for the requested resource. If the values
     *  match, the server allows the request method to continue.
     *
     *  To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
     *  headers.
     */
    ifMatch: string;
    /** A human-readable alias to assign to your rule. */
    name: string;
    /** An extended description of your rule. */
    description: string;
    /** The properties that describe the resource that you want to target with the rule. */
    target: TargetResource;
    requiredConfig: RuleRequiredConfig;
    /** The actions that the service must run on your behalf when a request to create or modify the target resource
     *  does not comply with your conditions.
     */
    enforcementActions: EnforcementAction[];
    /** Your IBM Cloud account ID. */
    accountId?: string;
    /** The type of rule. Rules that you create are `user_defined`. */
    ruleType?: UpdateRuleConstants.RuleType | string;
    /** Labels that you can use to group and search for similar rules, such as those that help you to meet a
     *  specific organization guideline.
     */
    labels?: string[];
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `updateRule` operation. */
  export namespace UpdateRuleConstants {
    /** The type of rule. Rules that you create are `user_defined`. */
    export enum RuleType {
      USER_DEFINED = 'user_defined',
    }
  }

  /** Parameters for the `deleteRule` operation. */
  export interface DeleteRuleParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createAttachments` operation. */
  export interface CreateAttachmentsParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    attachments: AttachmentRequest[];
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listAttachments` operation. */
  export interface ListAttachmentsParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    /** The number of resources to retrieve. By default, list operations return the first 100 items. To retrieve a
     *  different set of items, use `limit` with `offset` to page through your available resources.
     *
     *  **Usage:** If you have 20 rules, and you want to retrieve only the first 5 rules, use
     *  `../rules?account_id={account_id}&limit=5`.
     */
    limit?: number;
    /** The number of resources to skip. By specifying `offset`, you retrieve a subset of resources that starts with
     *  the `offset` value. Use `offset` with `limit` to page through your available resources.
     *
     *  **Usage:** If you have 100 rules, and you want to retrieve rules 26 through 50, use
     *  `../rules?account_id={account_id}&offset=25&limit=5`.
     */
    offset?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAttachment` operation. */
  export interface GetAttachmentParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** The UUID that uniquely identifies the attachment. */
    attachmentId: string;
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateAttachment` operation. */
  export interface UpdateAttachmentParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** The UUID that uniquely identifies the attachment. */
    attachmentId: string;
    /** Compares a supplied `Etag` value with the version that is stored for the requested resource. If the values
     *  match, the server allows the request method to continue.
     *
     *  To find the `Etag` value, run a GET request on the resource that you want to modify, and check the response
     *  headers.
     */
    ifMatch: string;
    /** Your IBM Cloud account ID. */
    accountId: string;
    /** The extent at which the rule can be attached across your accounts. */
    includedScope: RuleScope;
    /** The extent at which the rule can be excluded from the included scope. */
    excludedScopes?: RuleScope[];
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteAttachment` operation. */
  export interface DeleteAttachmentParams {
    /** The UUID that uniquely identifies the rule. */
    ruleId: string;
    /** The UUID that uniquely identifies the attachment. */
    attachmentId: string;
    /** The unique identifier that is used to trace an entire request. If you omit this field, the service generates
     *  and sends a transaction ID as a response header of the request. In the case of an error, the transaction ID is
     *  set in the `trace` field of the response body.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a
     *  `Transaction-Id` with each request.
     */
    transactionId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** The scopes to attach to the rule. */
  export interface Attachment {
    /** The UUID that uniquely identifies the attachment. */
    attachment_id: string;
    /** The UUID that uniquely identifies the rule. */
    rule_id: string;
    /** Your IBM Cloud account ID. */
    account_id: string;
    /** The extent at which the rule can be attached across your accounts. */
    included_scope: RuleScope;
    /** The extent at which the rule can be excluded from the included scope. */
    excluded_scopes?: RuleScope[];
  }

  /** A list of attachments. */
  export interface AttachmentList {
    /** The requested offset for the returned items. */
    offset: number;
    /** The requested limit for the returned items. */
    limit: number;
    /** The total number of available items. */
    total_count: number;
    /** The first page of available items. */
    first: Link;
    /** The last page of available items. */
    last: Link;
    attachments: Attachment[];
  }

  /** The scopes to attach to the rule. */
  export interface AttachmentRequest {
    /** Your IBM Cloud account ID. */
    account_id: string;
    /** The extent at which the rule can be attached across your accounts. */
    included_scope: RuleScope;
    /** The extent at which the rule can be excluded from the included scope. */
    excluded_scopes?: RuleScope[];
  }

  /** CreateAttachmentsResponse. */
  export interface CreateAttachmentsResponse {
    attachments: Attachment[];
  }

  /** A rule to be created. */
  export interface CreateRuleRequest {
    /** A field that you can use in bulk operations to store a custom identifier for an individual request. If you
     *  omit this field, the service generates and sends a `request_id` string for each new rule. The generated string
     *  corresponds with the numerical order of the rules request array. For example, `"request_id": "1"`,
     *  `"request_id": "2"`.
     *
     *  **Note:** To help with debugging logs, it is strongly recommended that you generate and supply a `request_id`
     *  with each request.
     */
    request_id?: string;
    /** User-settable properties associated with a rule to be created or updated. */
    rule: RuleRequest;
  }

  /** Response information for a rule request. If the 'status_code' property indicates success, the 'request_id' and 'rule' properties will be present.   If the 'status_code' property indicates an error, the 'request_id', 'errors', and 'trace' fields will be present. */
  export interface CreateRuleResponse {
    /** The identifier that is used to correlate an individual request.
     *
     *  To assist with debugging, you can use this ID to identify and inspect only one request that was made as part of
     *  a bulk operation.
     */
    request_id?: string;
    /** The HTTP response status code. */
    status_code?: number;
    /** Information about a newly-created rule.
     *
     *  This field will be present for a successful request.
     */
    rule?: Rule;
    /** The error contents of the multi-status response.
     *
     *  This field will be present for a failed rule request.
     */
    errors?: RuleResponseError[];
    /** The UUID that uniquely identifies the request.
     *
     *  This field will be present for a failed rule request.
     */
    trace?: string;
  }

  /** The response associated with a request to create one or more rules. */
  export interface CreateRulesResponse {
    /** An array of rule responses. */
    rules: CreateRuleResponse[];
  }

  /** EnforcementAction. */
  export interface EnforcementAction {
    /** To block a request from completing, use `disallow`. To log the request to Activity Tracker with LogDNA, use
     *  `audit_log`.
     */
    action: string;
  }

  /** A link that is used to paginate through available resources. */
  export interface Link {
    /** The URL for the first, previous, next, or last page of resources. */
    href: string;
  }

  /** Properties associated with a rule, including both user-settable and server-populated properties. */
  export interface Rule {
    /** Your IBM Cloud account ID. */
    account_id?: string;
    /** A human-readable alias to assign to your rule. */
    name: string;
    /** An extended description of your rule. */
    description: string;
    /** The type of rule. Rules that you create are `user_defined`. */
    rule_type?: string;
    /** The properties that describe the resource that you want to target with the rule. */
    target: TargetResource;
    required_config: RuleRequiredConfig;
    /** The actions that the service must run on your behalf when a request to create or modify the target resource
     *  does not comply with your conditions.
     */
    enforcement_actions: EnforcementAction[];
    /** Labels that you can use to group and search for similar rules, such as those that help you to meet a
     *  specific organization guideline.
     */
    labels?: string[];
    /** The UUID that uniquely identifies the rule. */
    rule_id?: string;
    /** The date the resource was created. */
    creation_date?: string;
    /** The unique identifier for the user or application that created the resource. */
    created_by?: string;
    /** The date the resource was last modified. */
    modification_date?: string;
    /** The unique identifier for the user or application that last modified the resource. */
    modified_by?: string;
    /** The number of scope attachments that are associated with the rule. */
    number_of_attachments?: number;
  }

  /** RuleCondition. */
  export interface RuleCondition {
  }

  /** A list of rules. */
  export interface RuleList {
    /** The requested offset for the returned items. */
    offset: number;
    /** The requested limit for the returned items. */
    limit: number;
    /** The total number of available items. */
    total_count: number;
    /** The first page of available items. */
    first: Link;
    /** The last page of available items. */
    last: Link;
    /** An array of rules. */
    rules: Rule[];
  }

  /** User-settable properties associated with a rule to be created or updated. */
  export interface RuleRequest {
    /** Your IBM Cloud account ID. */
    account_id?: string;
    /** A human-readable alias to assign to your rule. */
    name: string;
    /** An extended description of your rule. */
    description: string;
    /** The type of rule. Rules that you create are `user_defined`. */
    rule_type?: string;
    /** The properties that describe the resource that you want to target with the rule. */
    target: TargetResource;
    required_config: RuleRequiredConfig;
    /** The actions that the service must run on your behalf when a request to create or modify the target resource
     *  does not comply with your conditions.
     */
    enforcement_actions: EnforcementAction[];
    /** Labels that you can use to group and search for similar rules, such as those that help you to meet a
     *  specific organization guideline.
     */
    labels?: string[];
  }

  /** RuleRequiredConfig. */
  export interface RuleRequiredConfig {
  }

  /** RuleResponseError. */
  export interface RuleResponseError {
    /** Specifies the problem that caused the error. */
    code: string;
    /** Describes the problem. */
    message: string;
  }

  /** The extent at which the rule can be attached across your accounts. */
  export interface RuleScope {
    /** A short description or alias to assign to the scope. */
    note?: string;
    /** The ID of the scope, such as an enterprise, account, or account group, that you want to evaluate. */
    scope_id: string;
    /** The type of scope that you want to evaluate. */
    scope_type: string;
  }

  /** The requirement that must be met to determine the resource's level of compliance in accordance with the rule. To apply a single property check, define a configuration property and the desired value that you want to check against. */
  export interface RuleSingleProperty {
    description?: string;
    /** A resource configuration variable that describes the property that you want to apply to the target resource.
     *
     *  Available options depend on the target service and resource.
     */
    property: string;
    /** The way in which the `property` field is compared to its value.
     *
     *  There are three types of operators: string, numeric, and boolean.
     */
    operator: string;
    /** The way in which you want your property to be applied.
     *
     *  Value options differ depending on the rule that you configure. If you use a boolean operator, you do not need to
     *  input a value.
     */
    value?: string;
  }

  /** The attributes that are associated with a rule target. */
  export interface RuleTargetAttribute {
    name: string;
    /** The way in which the `name` field is compared to its value.
     *
     *  There are three types of operators: string, numeric, and boolean.
     */
    operator: string;
    /** The way in which you want your property to be applied.
     *
     *  Value options differ depending on the rule that you configure. If you use a boolean operator, you do not need to
     *  input a value.
     */
    value?: string;
  }

  /** The properties that describe the resource that you want to target with the rule. */
  export interface TargetResource {
    /** The programmatic name of the IBM Cloud service that you want to target with the rule. */
    service_name: string;
    /** The type of resource that you want to target. */
    resource_kind: string;
    /** An extra qualifier for the resource kind. When you include additional attributes, only the resources that
     *  match the definition are included in the rule.
     */
    additional_target_attributes?: RuleTargetAttribute[];
  }

  /** A condition with the `and` logical operator. */
  export interface RuleConditionAndLvl2 extends RuleCondition {
    description?: string;
    and: RuleSingleProperty[];
  }

  /** A condition with the `or` logical operator. */
  export interface RuleConditionOrLvl2 extends RuleCondition {
    description?: string;
    or: RuleSingleProperty[];
  }

  /** The requirement that must be met to determine the resource's level of compliance in accordance with the rule. To apply a single property check, define a configuration property and the desired value that you want to check against. */
  export interface RuleConditionSingleProperty extends RuleCondition {
    description?: string;
    /** A resource configuration variable that describes the property that you want to apply to the target resource.
     *
     *  Available options depend on the target service and resource.
     */
    property: string;
    /** The way in which the `property` field is compared to its value.
     *
     *  There are three types of operators: string, numeric, and boolean.
     */
    operator: string;
    /** The way in which you want your property to be applied.
     *
     *  Value options differ depending on the rule that you configure. If you use a boolean operator, you do not need to
     *  input a value.
     */
    value?: string;
  }

  /** The requirements that must be met to determine the resource's level of compliance in accordance with the rule. Use logical operators (`and`/`or`) to define multiple property checks and conditions. To define requirements for a rule, list one or more property check objects in the `and` array. To add conditions to a property check, use `or`. */
  export interface RuleRequiredConfigMultipleProperties extends RuleRequiredConfig {
  }

  /** The requirement that must be met to determine the resource's level of compliance in accordance with the rule. To apply a single property check, define a configuration property and the desired value that you want to check against. */
  export interface RuleRequiredConfigSingleProperty extends RuleRequiredConfig {
    description?: string;
    /** A resource configuration variable that describes the property that you want to apply to the target resource.
     *
     *  Available options depend on the target service and resource.
     */
    property: string;
    /** The way in which the `property` field is compared to its value.
     *
     *  There are three types of operators: string, numeric, and boolean.
     */
    operator: string;
    /** The way in which you want your property to be applied.
     *
     *  Value options differ depending on the rule that you configure. If you use a boolean operator, you do not need to
     *  input a value.
     */
    value?: string;
  }

  /** A condition with the `and` logical operator. */
  export interface RuleRequiredConfigMultiplePropertiesConditionAnd extends RuleRequiredConfigMultipleProperties {
    description?: string;
    and: RuleCondition[];
  }

  /** A condition with the `or` logical operator. */
  export interface RuleRequiredConfigMultiplePropertiesConditionOr extends RuleRequiredConfigMultipleProperties {
    description?: string;
    or: RuleCondition[];
  }

}

export = ConfigurationGovernanceV1;
