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
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-8d569e8f-20201030-111043
 */
 

import * as extend from 'extend';
import { IncomingHttpHeaders, OutgoingHttpHeaders } from 'http';
import { Authenticator, BaseService, getAuthenticatorFromEnvironment, getMissingParams, UserOptions } from 'ibm-cloud-sdk-core';
import { FileWithMetadata } from 'ibm-cloud-sdk-core';
import { getSdkHeaders } from '../lib/common';

/**
 * Case management API for creating cases, getting case statuses, adding comments to a case, adding and removing users
 * from a case watchlist, downloading and adding attachments, and more.
 */

class CaseManagementV1 extends BaseService {

  static DEFAULT_SERVICE_URL: string = 'https://support-center.cloud.ibm.com/case-management/v1';
  static DEFAULT_SERVICE_NAME: string = 'case_management';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of CaseManagementV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {CaseManagementV1}
   */

  public static newInstance(options: UserOptions): CaseManagementV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new CaseManagementV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }


  /**
   * Construct a CaseManagementV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net/case-management/v1'). The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {CaseManagementV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(CaseManagementV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * default
   ************************/

  /**
   * Get cases in account.
   *
   * Get cases in the account which is specified by the content of the IAM token.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {number} [params.offset] - Number of cases should be skipped.
   * @param {number} [params.limit] - Number of cases should be returned.
   * @param {string} [params.search] - String that a case might contain.
   * @param {string} [params.sort] - Sort field and direction. If omitted, default to descending of updated date. Prefix
   * "~" signifies sort in descending.
   * @param {string[]} [params.status] - Case status filter.
   * @param {string[]} [params.fields] - Seleted fields of interest instead of the entire case information.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.CaseList>>}
   */
  public getCases(params?: CaseManagementV1.GetCasesParams): Promise<CaseManagementV1.Response<CaseManagementV1.CaseList>> {
    const _params = Object.assign({}, params);

    const query = {
      'offset': _params.offset,
      'limit': _params.limit,
      'search': _params.search,
      'sort': _params.sort,
      'status': _params.status,
      'fields': _params.fields
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCases');

    const parameters = {
      options: {
        url: '/cases',
        method: 'GET',
        qs: query,
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
   * Create a case.
   *
   * Create a case in the account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.type - Case type.
   * @param {string} params.subject - Subject of the case.
   * @param {string} params.description - Detailed description of the issue.
   * @param {number} [params.severity] - Severity of the case. Smaller values mean higher severity.
   * @param {CasePayloadEu} [params.eu] - Specify if the case should be treated as EU regulated. Only one of the
   * following properties is required. Call EU support utility endpoint to determine which property must be specified
   * for your account.
   * @param {Offering} [params.offering] - Offering details.
   * @param {ResourcePayload[]} [params.resources] - List of resources to attach to case. If attaching Classic IaaS
   * devices use type and id fields if Cloud Resource Name (CRN) is unavialable. Otherwise pass the resource CRN. The
   * resource list must be consistent with the value selected for the resource offering.
   * @param {User[]} [params.watchlist] - Array of user IDs to add to the watchlist.
   * @param {string} [params.invoiceNumber] - Invoice number of "Billing and Invoice" case type.
   * @param {boolean} [params.slaCreditRequest] - Flag to indicate if case is for an Service Level Agreement (SLA)
   * credit request.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Case>>}
   */
  public createCase(params: CaseManagementV1.CreateCaseParams): Promise<CaseManagementV1.Response<CaseManagementV1.Case>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['type', 'subject', 'description'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'type': _params.type,
      'subject': _params.subject,
      'description': _params.description,
      'severity': _params.severity,
      'eu': _params.eu,
      'offering': _params.offering,
      'resources': _params.resources,
      'watchlist': _params.watchlist,
      'invoice_number': _params.invoiceNumber,
      'sla_credit_request': _params.slaCreditRequest
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'createCase');

    const parameters = {
      options: {
        url: '/cases',
        method: 'POST',
        body,
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
   * Get a case in account.
   *
   * Get a case in the account that is specified by the case number.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {string[]} [params.fields] - Seleted fields of interest instead of the entire case information.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Case>>}
   */
  public getCase(params: CaseManagementV1.GetCaseParams): Promise<CaseManagementV1.Response<CaseManagementV1.Case>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const query = {
      'fields': _params.fields
    };

    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'getCase');

    const parameters = {
      options: {
        url: '/cases/{case_number}',
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

  /**
   * Update case status.
   *
   * Mark the case as resolved or unresolved, or accept the provided resolution.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {StatusPayload} params.statusPayload -
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Case>>}
   */
  public updateCaseStatus(params: CaseManagementV1.UpdateCaseStatusParams): Promise<CaseManagementV1.Response<CaseManagementV1.Case>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber', 'statusPayload'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = _params.statusPayload;
    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'updateCaseStatus');

    const parameters = {
      options: {
        url: '/cases/{case_number}/status',
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
   * Add comment to case.
   *
   * Add a comment to a case.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {string} params.comment - Comment to add to the case.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Comment>>}
   */
  public addComment(params: CaseManagementV1.AddCommentParams): Promise<CaseManagementV1.Response<CaseManagementV1.Comment>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber', 'comment'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'comment': _params.comment
    };

    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'addComment');

    const parameters = {
      options: {
        url: '/cases/{case_number}/comments',
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
   * Add users to watchlist of case.
   *
   * Add users to the watchlist of case. By adding a user to the watchlist of the case, you are granting them read and
   * write permissions, so the user can view the case, receive updates, and make updates to the case. Note that the user
   * must be in the account to be added to the watchlist.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {User[]} [params.watchlist] - Array of user ID objects.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.WatchlistAddResponse>>}
   */
  public addWatchlist(params: CaseManagementV1.AddWatchlistParams): Promise<CaseManagementV1.Response<CaseManagementV1.WatchlistAddResponse>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'watchlist': _params.watchlist
    };

    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'addWatchlist');

    const parameters = {
      options: {
        url: '/cases/{case_number}/watchlist',
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
   * Remove users from watchlist of case.
   *
   * Remove users from the watchlist of a case.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {User[]} [params.watchlist] - Array of user ID objects.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Watchlist>>}
   */
  public removeWatchlist(params: CaseManagementV1.RemoveWatchlistParams): Promise<CaseManagementV1.Response<CaseManagementV1.Watchlist>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'watchlist': _params.watchlist
    };

    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'removeWatchlist');

    const parameters = {
      options: {
        url: '/cases/{case_number}/watchlist',
        method: 'DELETE',
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
   * Add a resource to case.
   *
   * Add a resource to case by specifying the Cloud Resource Name (CRN), or id and type if attaching a class iaaS
   * resource.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {string} [params.crn] - Cloud Resource Name of the resource.
   * @param {string} [params.type] - Only used to attach Classic IaaS devices which have no CRN.
   * @param {number} [params.id] - Only used to attach Classic IaaS devices which have no CRN. Id of Classic IaaS
   * device. This is deprecated in favor of the crn field.
   * @param {string} [params.note] - A note about this resource.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Resource>>}
   */
  public addResource(params: CaseManagementV1.AddResourceParams): Promise<CaseManagementV1.Response<CaseManagementV1.Resource>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'crn': _params.crn,
      'type': _params.type,
      'id': _params.id,
      'note': _params.note
    };

    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'addResource');

    const parameters = {
      options: {
        url: '/cases/{case_number}/resources',
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
   * Add attachment(s) to case.
   *
   * You can add attachments to a case to provide more information for the support team about the issue that you're
   * experiencing.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {FileWithMetadata[]} params.file - file of supported types, 8MB in size limit.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.Attachment>>}
   */
  public uploadFile(params: CaseManagementV1.UploadFileParams): Promise<CaseManagementV1.Response<CaseManagementV1.Attachment>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber', 'file'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const formData = {
      'file': _params.file
    };

    const path = {
      'case_number': _params.caseNumber
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'uploadFile');

    const parameters = {
      options: {
        url: '/cases/{case_number}/attachments',
        method: 'PUT',
        path,
        formData
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/json',
          'Content-Type': 'multipart/form-data',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Download an attachment.
   *
   * Download an attachment from a case.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {string} params.fileId - Unique identifier of a file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<NodeJS.ReadableStream|Buffer>>}
   */
  public downloadFile(params: CaseManagementV1.DownloadFileParams): Promise<CaseManagementV1.Response<NodeJS.ReadableStream|Buffer>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber', 'fileId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'case_number': _params.caseNumber,
      'file_id': _params.fileId
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'downloadFile');

    const parameters = {
      options: {
        url: '/cases/{case_number}/attachments/{file_id}',
        method: 'GET',
        path,
        responseType: 'stream',
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(true, sdkHeaders, {
          'Accept': 'application/octet-stream',
        }, _params.headers),
      }),
    };

    return this.createRequest(parameters);
  };

  /**
   * Remove attachment from case.
   *
   * Remove an attachment from a case.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.caseNumber - Unique identifier of a case.
   * @param {string} params.fileId - Unique identifier of a file.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<CaseManagementV1.Response<CaseManagementV1.AttachmentList>>}
   */
  public deleteFile(params: CaseManagementV1.DeleteFileParams): Promise<CaseManagementV1.Response<CaseManagementV1.AttachmentList>> {
    const _params = Object.assign({}, params);
    const requiredParams = ['caseNumber', 'fileId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'case_number': _params.caseNumber,
      'file_id': _params.fileId
    };

    const sdkHeaders = getSdkHeaders(CaseManagementV1.DEFAULT_SERVICE_NAME, 'v1', 'deleteFile');

    const parameters = {
      options: {
        url: '/cases/{case_number}/attachments/{file_id}',
        method: 'DELETE',
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

namespace CaseManagementV1 {

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

  /** Parameters for the `getCases` operation. */
  export interface GetCasesParams {
    /** Number of cases should be skipped. */
    offset?: number;
    /** Number of cases should be returned. */
    limit?: number;
    /** String that a case might contain. */
    search?: string;
    /** Sort field and direction. If omitted, default to descending of updated date. Prefix "~" signifies sort in
     *  descending.
     */
    sort?: string;
    /** Case status filter. */
    status?: GetCasesConstants.Status[] | string[];
    /** Seleted fields of interest instead of the entire case information. */
    fields?: GetCasesConstants.Fields[] | string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `getCases` operation. */
  export namespace GetCasesConstants {
    /** Case status filter. */
    export enum Status {
      NEW = 'new',
      IN_PROGRESS = 'in_progress',
      WAITING_ON_CLIENT = 'waiting_on_client',
      RESOLUTION_PROVIDED = 'resolution_provided',
      RESOLVED = 'resolved',
      CLOSED = 'closed',
    }
    /** Seleted fields of interest instead of the entire case information. */
    export enum Fields {
      NUMBER = 'number',
      SHORT_DESCRIPTION = 'short_description',
      DESCRIPTION = 'description',
      CREATED_AT = 'created_at',
      CREATED_BY = 'created_by',
      UPDATED_AT = 'updated_at',
      UPDATED_BY = 'updated_by',
      CONTACT = 'contact',
      CONTACT_TYPE = 'contact_type',
      STATUS = 'status',
      SEVERITY = 'severity',
      SUPPORT_TIER = 'support_tier',
      RESOLUTION = 'resolution',
      CLOSE_NOTES = 'close_notes',
      INVOICE_NUMBER = 'invoice_number',
      AGENT_CLOSE_ONLY = 'agent_close_only',
      EU = 'eu',
      WATCHLIST = 'watchlist',
      ATTACHMENTS = 'attachments',
      RESOURCES = 'resources',
      COMMENTS = 'comments',
      OFFERING = 'offering',
    }
  }

  /** Parameters for the `createCase` operation. */
  export interface CreateCaseParams {
    /** Case type. */
    type: CreateCaseConstants.Type | string;
    /** Subject of the case. */
    subject: string;
    /** Detailed description of the issue. */
    description: string;
    /** Severity of the case. Smaller values mean higher severity. */
    severity?: number;
    /** Specify if the case should be treated as EU regulated. Only one of the following properties is required.
     *  Call EU support utility endpoint to determine which property must be specified for your account.
     */
    eu?: CasePayloadEu;
    /** Offering details. */
    offering?: Offering;
    /** List of resources to attach to case. If attaching Classic IaaS devices use type and id fields if Cloud
     *  Resource Name (CRN) is unavialable. Otherwise pass the resource CRN. The resource list must be consistent with
     *  the value selected for the resource offering.
     */
    resources?: ResourcePayload[];
    /** Array of user IDs to add to the watchlist. */
    watchlist?: User[];
    /** Invoice number of "Billing and Invoice" case type. */
    invoiceNumber?: string;
    /** Flag to indicate if case is for an Service Level Agreement (SLA) credit request. */
    slaCreditRequest?: boolean;
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `createCase` operation. */
  export namespace CreateCaseConstants {
    /** Case type. */
    export enum Type {
      TECHNICAL = 'technical',
      ACCOUNT_AND_ACCESS = 'account_and_access',
      BILLING_AND_INVOICE = 'billing_and_invoice',
      SALES = 'sales',
    }
  }

  /** Parameters for the `getCase` operation. */
  export interface GetCaseParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Seleted fields of interest instead of the entire case information. */
    fields?: GetCaseConstants.Fields[] | string[];
    headers?: OutgoingHttpHeaders;
  }

  /** Constants for the `getCase` operation. */
  export namespace GetCaseConstants {
    /** Seleted fields of interest instead of the entire case information. */
    export enum Fields {
      NUMBER = 'number',
      SHORT_DESCRIPTION = 'short_description',
      DESCRIPTION = 'description',
      CREATED_AT = 'created_at',
      CREATED_BY = 'created_by',
      UPDATED_AT = 'updated_at',
      UPDATED_BY = 'updated_by',
      CONTACT = 'contact',
      CONTACT_TYPE = 'contact_type',
      STATUS = 'status',
      SEVERITY = 'severity',
      SUPPORT_TIER = 'support_tier',
      RESOLUTION = 'resolution',
      CLOSE_NOTES = 'close_notes',
      INVOICE_NUMBER = 'invoice_number',
      AGENT_CLOSE_ONLY = 'agent_close_only',
      EU = 'eu',
      WATCHLIST = 'watchlist',
      ATTACHMENTS = 'attachments',
      RESOURCES = 'resources',
      COMMENTS = 'comments',
      OFFERING = 'offering',
    }
  }

  /** Parameters for the `updateCaseStatus` operation. */
  export interface UpdateCaseStatusParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    statusPayload: StatusPayload;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `addComment` operation. */
  export interface AddCommentParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Comment to add to the case. */
    comment: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `addWatchlist` operation. */
  export interface AddWatchlistParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Array of user ID objects. */
    watchlist?: User[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `removeWatchlist` operation. */
  export interface RemoveWatchlistParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Array of user ID objects. */
    watchlist?: User[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `addResource` operation. */
  export interface AddResourceParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Cloud Resource Name of the resource. */
    crn?: string;
    /** Only used to attach Classic IaaS devices which have no CRN. */
    type?: string;
    /** Only used to attach Classic IaaS devices which have no CRN. Id of Classic IaaS device. This is deprecated in
     *  favor of the crn field.
     */
    id?: number;
    /** A note about this resource. */
    note?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `uploadFile` operation. */
  export interface UploadFileParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** file of supported types, 8MB in size limit. */
    file: FileWithMetadata[];
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `downloadFile` operation. */
  export interface DownloadFileParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Unique identifier of a file. */
    fileId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `deleteFile` operation. */
  export interface DeleteFileParams {
    /** Unique identifier of a case. */
    caseNumber: string;
    /** Unique identifier of a file. */
    fileId: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** Details of an attachment. */
  export interface Attachment {
    /** Unique identifier of the attachment in database. */
    id?: string;
    /** Name of the attachment. */
    filename?: string;
    /** Size of the attachment in bytes. */
    size_in_bytes?: number;
    /** Date time of uploading. */
    created_at?: string;
    /** URL of the attachment used to download. */
    url?: string;
  }

  /** List of attachments in the case. */
  export interface AttachmentList {
    /** New attachments array. */
    attachments?: Attachment[];
  }

  /** The support case. */
  export interface Case {
    /** Number/ID of the case. */
    number?: string;
    /** A short description of what the case is about. */
    short_description?: string;
    /** A full description of what the case is about. */
    description?: string;
    /** Date time of case creation in UTC. */
    created_at?: string;
    /** User info in a case. */
    created_by?: User;
    /** Date time of the last update on the case in UTC. */
    updated_at?: string;
    /** User info in a case. */
    updated_by?: User;
    /** Name of the console to interact with the contact. */
    contact_type?: string;
    /** User info in a case. */
    contact?: User;
    /** Status of the case. */
    status?: string;
    /** The severity of the case. */
    severity?: number;
    /** Support tier of the account. */
    support_tier?: string;
    /** Standard reasons of resolving case. */
    resolution?: string;
    /** Notes of case closing. */
    close_notes?: string;
    /** EU support. */
    eu?: CaseEu;
    /** List of users in the case watchlist. */
    watchlist?: User[];
    /** List of attachments/files of the case. */
    attachments?: Attachment[];
    /** Offering details. */
    offering?: Offering;
    /** List of attached resources. */
    resources?: Resource[];
    /** List of comments/updates sorted in chronological order. */
    comments?: Comment[];
  }

  /** EU support. */
  export interface CaseEu {
    /** Identifying whether the case has EU Support. */
    support?: boolean;
    /** Information about the data center. */
    data_center?: string;
  }

  /** Response of a GET /cases request. */
  export interface CaseList {
    /** Total number of cases satisfying the query. */
    total_count?: number;
    /** Container for URL pointer to related pages of cases. */
    first?: PaginationLink;
    /** Container for URL pointer to related pages of cases. */
    next?: PaginationLink;
    /** Container for URL pointer to related pages of cases. */
    previous?: PaginationLink;
    /** Container for URL pointer to related pages of cases. */
    last?: PaginationLink;
    /** List of cases. */
    cases?: Case[];
  }

  /** Specify if the case should be treated as EU regulated. Only one of the following properties is required. Call EU support utility endpoint to determine which property must be specified for your account. */
  export interface CasePayloadEu {
    /** indicating whether the case is EU supported. */
    supported?: boolean;
    /** If EU supported utility endpoint specifies datacenter then pass the datacenter id to mark a case as EU
     *  supported.
     */
    data_center?: number;
  }

  /** A comment in a case. */
  export interface Comment {
    /** The comment. */
    value?: string;
    /** Timestamp of when comment is added. */
    added_at?: string;
    /** User info in a case. */
    added_by?: User;
  }

  /** Offering details. */
  export interface Offering {
    /** Name of the offering. */
    name: string;
    /** Offering type. */
    type: OfferingType;
  }

  /** Offering type. */
  export interface OfferingType {
    /** Offering type group. "crn_service_name" is strongly prefered over "category" as the latter is legacy and
     *  will be deprecated in the future.
     */
    group: string;
    /** CRN service name of the offering. */
    key: string;
    /** Optional. Platform kind of the offering. */
    kind?: string;
    /** Offering id in the catalog. This alone is enough to identify the offering. */
    id?: string;
  }

  /** Container for URL pointer to related pages of cases. */
  export interface PaginationLink {
    /** URL to related pages of cases. */
    href?: string;
  }

  /** A resource record of a case. */
  export interface Resource {
    /** ID of the resource. */
    crn?: string;
    /** Name of the resource. */
    name?: string;
    /** Type of resource. */
    type?: string;
    /** URL of resource. */
    url?: string;
    /** Note about resource. */
    note?: string;
  }

  /** Payload to add a resource to a case. */
  export interface ResourcePayload {
    /** Cloud Resource Name of the resource. */
    crn?: string;
    /** Only used to attach Classic IaaS devices which have no CRN. */
    type?: string;
    /** Only used to attach Classic IaaS devices which have no CRN. Id of Classic IaaS device. This is deprecated in
     *  favor of the crn field.
     */
    id?: number;
    /** A note about this resource. */
    note?: string;
  }

  /** Payload to update status of the case. */
  export interface StatusPayload {
    /** action to perform on the case. */
    action: string;
  }

  /** User info in a case. */
  export interface User {
    /** Full name of the user. */
    name?: string;
    /** the ID realm. */
    realm: string;
    /** unique user ID in the realm specified by the type. */
    user_id: string;
  }

  /** Payload to add/remove users to/from the case watchlist. */
  export interface Watchlist {
    /** Array of user ID objects. */
    watchlist?: User[];
  }

  /** Response of a request adding to watchlist. */
  export interface WatchlistAddResponse {
    /** List of added user. */
    added?: User[];
    /** List of failed to add user. */
    failed?: User[];
  }

  /** Payload to accept the proposed resolution of the case. */
  export interface AcceptPayload extends StatusPayload {
    /** Comment about accepting the proposed resolution. */
    comment?: string;
  }

  /** Payload to resolve the case. */
  export interface ResolvePayload extends StatusPayload {
    /** comment of resolution. */
    comment?: string;
    /** * 1: Client error
     *  * 2: Defect found with Component/Service
     *  * 3: Documentation Error
     *  * 4: Sollution found in forums
     *  * 5: Solution found in public Documentation
     *  * 6: Solution no longer required
     *  * 7: Solution provided by IBM outside of support case
     *  * 8: Solution provided by IBM support engineer.
     */
    resolution_code: number;
  }

  /** Payload to unresolve the case. */
  export interface UnresolvePayload extends StatusPayload {
    /** Comment why the case should be unresolved. */
    comment: string;
  }

}

export = CaseManagementV1;
