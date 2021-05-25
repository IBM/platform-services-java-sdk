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
 * IBM OpenAPI SDK Code Generator Version: 3.30.0-bd714324-20210406-200538
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
 * The Enterprise Management API enables you to create and manage an enterprise, account groups, and accounts within the
 * enterprise.
 */

class EnterpriseManagementV1 extends BaseService {
  static DEFAULT_SERVICE_URL: string = 'https://enterprise.cloud.ibm.com/v1';

  static DEFAULT_SERVICE_NAME: string = 'enterprise_management';

  /*************************
   * Factory method
   ************************/

  /**
   * Constructs an instance of EnterpriseManagementV1 with passed in options and external configuration.
   *
   * @param {UserOptions} [options] - The parameters to send to the service.
   * @param {string} [options.serviceName] - The name of the service to configure
   * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
   * @param {string} [options.serviceUrl] - The URL for the service
   * @returns {EnterpriseManagementV1}
   */

  public static newInstance(options: UserOptions): EnterpriseManagementV1 {
    options = options || {};

    if (!options.serviceName) {
      options.serviceName = this.DEFAULT_SERVICE_NAME;
    }
    if (!options.authenticator) {
      options.authenticator = getAuthenticatorFromEnvironment(options.serviceName);
    }
    const service = new EnterpriseManagementV1(options);
    service.configureService(options.serviceName);
    if (options.serviceUrl) {
      service.setServiceUrl(options.serviceUrl);
    }
    return service;
  }

  /**
   * Construct a EnterpriseManagementV1 object.
   *
   * @param {Object} options - Options for the service.
   * @param {string} [options.serviceUrl] - The base url to use when contacting the service. The base url may differ between IBM Cloud regions.
   * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
   * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
   * @constructor
   * @returns {EnterpriseManagementV1}
   */
  constructor(options: UserOptions) {
    options = options || {};

    super(options);
    if (options.serviceUrl) {
      this.setServiceUrl(options.serviceUrl);
    } else {
      this.setServiceUrl(EnterpriseManagementV1.DEFAULT_SERVICE_URL);
    }
  }

  /*************************
   * enterpriseOperations
   ************************/

  /**
   * Create an enterprise.
   *
   * Create a new enterprise, which you can use to centrally manage multiple accounts. To create an enterprise, you must
   * have an active Subscription account. <br/><br/>The API creates an enterprise entity, which is the root of the
   * enterprise hierarchy. It also creates a new enterprise account that is used to manage the enterprise. All
   * subscriptions, support entitlements, credits, and discounts from the source subscription account are migrated to
   * the enterprise account, and the source account becomes a child account in the hierarchy. The user that you assign
   * as the enterprise primary contact is also assigned as the owner of the enterprise account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.sourceAccountId - The ID of the account that is used to create the enterprise.
   * @param {string} params.name - The name of the enterprise. This field must have 3 - 60 characters.
   * @param {string} params.primaryContactIamId - The IAM ID of the enterprise primary contact, such as `IBMid-0123ABC`.
   * The IAM ID must already exist.
   * @param {string} [params.domain] - A domain or subdomain for the enterprise, such as `example.com` or
   * `my.example.com`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.CreateEnterpriseResponse>>}
   */
  public createEnterprise(
    params: EnterpriseManagementV1.CreateEnterpriseParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.CreateEnterpriseResponse>> {
    const _params = { ...params };
    const requiredParams = ['sourceAccountId', 'name', 'primaryContactIamId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'source_account_id': _params.sourceAccountId,
      'name': _params.name,
      'primary_contact_iam_id': _params.primaryContactIamId,
      'domain': _params.domain,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createEnterprise'
    );

    const parameters = {
      options: {
        url: '/enterprises',
        method: 'POST',
        body,
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

  /**
   * List enterprises.
   *
   * Retrieve all enterprises for a given ID by passing the IDs on query parameters. If no ID is passed, the enterprises
   * for which the calling identity is the primary contact are returned. You can use pagination parameters to filter the
   * results. <br/><br/>This method ensures that only the enterprises that the user has access to are returned. Access
   * can be controlled either through a policy on a specific enterprise, or account-level platform services access
   * roles, such as Administrator, Editor, Operator, or Viewer. When you call the method with the
   * `enterprise_account_id` or `account_id` query parameter, the account ID in the token is compared with that in the
   * query parameter. If these account IDs match, authentication isn't performed and the enterprise information is
   * returned. If the account IDs don't match, authentication is performed and only then is the enterprise information
   * returned in the response.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.enterpriseAccountId] - Get enterprises for a given enterprise account ID.
   * @param {string} [params.accountGroupId] - Get enterprises for a given account group ID.
   * @param {string} [params.accountId] - Get enterprises for a given account ID.
   * @param {string} [params.nextDocid] - The first item to be returned in the page of results. This value can be
   * obtained from the next_url property from the previous call of the operation. If not specified, then the first page
   * of results is returned.
   * @param {number} [params.limit] - Return results up to this limit. Valid values are between `0` and `100`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.ListEnterprisesResponse>>}
   */
  public listEnterprises(
    params?: EnterpriseManagementV1.ListEnterprisesParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.ListEnterprisesResponse>> {
    const _params = { ...params };

    const query = {
      'enterprise_account_id': _params.enterpriseAccountId,
      'account_group_id': _params.accountGroupId,
      'account_id': _params.accountId,
      'next_docid': _params.nextDocid,
      'limit': _params.limit,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listEnterprises'
    );

    const parameters = {
      options: {
        url: '/enterprises',
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

  /**
   * Get enterprise by ID.
   *
   * Retrieve an enterprise by the `enterprise_id` parameter. All data related to the enterprise is returned only if the
   * caller has access to retrieve the enterprise.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.enterpriseId - The ID of the enterprise to retrieve.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Enterprise>>}
   */
  public getEnterprise(
    params: EnterpriseManagementV1.GetEnterpriseParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Enterprise>> {
    const _params = { ...params };
    const requiredParams = ['enterpriseId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'enterprise_id': _params.enterpriseId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getEnterprise'
    );

    const parameters = {
      options: {
        url: '/enterprises/{enterprise_id}',
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
   * Update an enterprise.
   *
   * Update the name, domain, or IAM ID of the primary contact for an existing enterprise. The new primary contact must
   * already be a user in the enterprise account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.enterpriseId - The ID of the enterprise to retrieve.
   * @param {string} [params.name] - The new name of the enterprise. This field must have 3 - 60 characters.
   * @param {string} [params.domain] - The new domain of the enterprise. This field has a limit of 60 characters.
   * @param {string} [params.primaryContactIamId] - The IAM ID of the user to be the new primary contact for the
   * enterprise.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>>}
   */
  public updateEnterprise(
    params: EnterpriseManagementV1.UpdateEnterpriseParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['enterpriseId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'domain': _params.domain,
      'primary_contact_iam_id': _params.primaryContactIamId,
    };

    const path = {
      'enterprise_id': _params.enterpriseId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateEnterprise'
    );

    const parameters = {
      options: {
        url: '/enterprises/{enterprise_id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * accountOperations
   ************************/

  /**
   * Import an account into an enterprise.
   *
   * Import an existing stand-alone account into an enterprise. The existing account can be any type: trial (`TRIAL`),
   * Lite (`STANDARD`), Pay-As-You-Go (`PAYG`), or Subscription (`SUBSCRIPTION`). In the case of a `SUBSCRIPTION`
   * account, the credits, promotional offers, and discounts are migrated to the billing unit of the enterprise. For a
   * billable account (`PAYG` or `SUBSCRIPTION`), the country and currency code of the existing account and the billing
   * unit of the enterprise must match. The API returns a `202` response and performs asynchronous operations to import
   * the account into the enterprise. <br/></br>For more information about impacts to the account, see [Adding accounts
   * to an enterprise](https://{DomainName}/docs/account?topic=account-enterprise-add).
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.enterpriseId - The ID of the enterprise to import the stand-alone account into.
   * @param {string} params.accountId - The ID of the existing stand-alone account to be imported.
   * @param {string} [params.parent] - The CRN of the expected parent of the imported account. The parent is the
   * enterprise or account group that the account is added to.
   * @param {string} [params.billingUnitId] - The ID of the [billing unit](/apidocs/enterprise-apis/billing-unit) to use
   * for billing this account in the enterprise.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>>}
   */
  public importAccountToEnterprise(
    params: EnterpriseManagementV1.ImportAccountToEnterpriseParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['enterpriseId', 'accountId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'parent': _params.parent,
      'billing_unit_id': _params.billingUnitId,
    };

    const path = {
      'enterprise_id': _params.enterpriseId,
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'importAccountToEnterprise'
    );

    const parameters = {
      options: {
        url: '/enterprises/{enterprise_id}/import/accounts/{account_id}',
        method: 'PUT',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /**
   * Create a new account in an enterprise.
   *
   * Create a new account as a part of an existing enterprise. The API creates an account entity under the parent that
   * is specified in the payload of the request. The request also takes in the name and the owner of this new account.
   * The owner must have a valid IBMid that's registered with IBM Cloud, but they don't need to be a user in the
   * enterprise account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.parent - The CRN of the parent under which the account will be created. The parent can be an
   * existing account group or the enterprise itself.
   * @param {string} params.name - The name of the account. This field must have 3 - 60 characters.
   * @param {string} params.ownerIamId - The IAM ID of the account owner, such as `IBMid-0123ABC`. The IAM ID must
   * already exist.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.CreateAccountResponse>>}
   */
  public createAccount(
    params: EnterpriseManagementV1.CreateAccountParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.CreateAccountResponse>> {
    const _params = { ...params };
    const requiredParams = ['parent', 'name', 'ownerIamId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'parent': _params.parent,
      'name': _params.name,
      'owner_iam_id': _params.ownerIamId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createAccount'
    );

    const parameters = {
      options: {
        url: '/accounts',
        method: 'POST',
        body,
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

  /**
   * List accounts.
   *
   * Retrieve all accounts based on the values that are passed in the query parameters. If no query parameter is passed,
   * all of the accounts in the enterprise for which the calling identity has access are returned. <br/><br/>You can use
   * pagination parameters to filter the results. The `limit` field can be used to limit the number of results that are
   * displayed for this method.<br/><br/>This method ensures that only the accounts that the user has access to are
   * returned. Access can be controlled either through a policy on a specific account, or account-level platform
   * services access roles, such as Administrator, Editor, Operator, or Viewer. When you call the method with the
   * `enterprise_id`, `account_group_id` or `parent` query parameter, all of the accounts that are immediate children of
   * this entity are returned. Authentication is performed on all the accounts before they are returned to the user to
   * ensure that only those accounts are returned to which the calling identity has access to.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.enterpriseId] - Get accounts that are either immediate children or are a part of the
   * hierarchy for a given enterprise ID.
   * @param {string} [params.accountGroupId] - Get accounts that are either immediate children or are a part of the
   * hierarchy for a given account group ID.
   * @param {string} [params.nextDocid] - The first item to be returned in the page of results. This value can be
   * obtained from the next_url property from the previous call of the operation. If not specified, then the first page
   * of results is returned.
   * @param {string} [params.parent] - Get accounts that are either immediate children or are a part of the hierarchy
   * for a given parent CRN.
   * @param {number} [params.limit] - Return results up to this limit. Valid values are between `0` and `100`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.ListAccountsResponse>>}
   */
  public listAccounts(
    params?: EnterpriseManagementV1.ListAccountsParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.ListAccountsResponse>> {
    const _params = { ...params };

    const query = {
      'enterprise_id': _params.enterpriseId,
      'account_group_id': _params.accountGroupId,
      'next_docid': _params.nextDocid,
      'parent': _params.parent,
      'limit': _params.limit,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listAccounts'
    );

    const parameters = {
      options: {
        url: '/accounts',
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

  /**
   * Get account by ID.
   *
   * Retrieve an account by the `account_id` parameter. All data related to the account is returned only if the caller
   * has access to retrieve the account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The ID of the account to retrieve.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Account>>}
   */
  public getAccount(
    params: EnterpriseManagementV1.GetAccountParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Account>> {
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
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getAccount'
    );

    const parameters = {
      options: {
        url: '/accounts/{account_id}',
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
   * Move an account within the enterprise.
   *
   * Move an account to a different parent within the same enterprise.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountId - The ID of the account to retrieve.
   * @param {string} params.parent - The CRN of the new parent within the enterprise.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>>}
   */
  public updateAccount(
    params: EnterpriseManagementV1.UpdateAccountParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['accountId', 'parent'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'parent': _params.parent,
    };

    const path = {
      'account_id': _params.accountId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateAccount'
    );

    const parameters = {
      options: {
        url: '/accounts/{account_id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
            'Content-Type': 'application/json',
          },
          _params.headers
        ),
      }),
    };

    return this.createRequest(parameters);
  }

  /*************************
   * accountGroupOperations
   ************************/

  /**
   * Create an account group.
   *
   * Create a new account group, which can be used to group together multiple accounts. To create an account group, you
   * must have an existing enterprise. The API creates an account group entity under the parent that is specified in the
   * payload of the request. The request also takes in the name and the primary contact of this new account group.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.parent - The CRN of the parent under which the account group will be created. The parent can
   * be an existing account group or the enterprise itself.
   * @param {string} params.name - The name of the account group. This field must have 3 - 60 characters.
   * @param {string} params.primaryContactIamId - The IAM ID of the primary contact for this account group, such as
   * `IBMid-0123ABC`. The IAM ID must already exist.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.CreateAccountGroupResponse>>}
   */
  public createAccountGroup(
    params: EnterpriseManagementV1.CreateAccountGroupParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.CreateAccountGroupResponse>> {
    const _params = { ...params };
    const requiredParams = ['parent', 'name', 'primaryContactIamId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'parent': _params.parent,
      'name': _params.name,
      'primary_contact_iam_id': _params.primaryContactIamId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'createAccountGroup'
    );

    const parameters = {
      options: {
        url: '/account-groups',
        method: 'POST',
        body,
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

  /**
   * List account groups.
   *
   * Retrieve all account groups based on the values that are passed in the query parameters. If no query parameter is
   * passed, all of the account groups in the enterprise for which the calling identity has access are returned.
   * <br/><br/>You can use pagination parameters to filter the results. The `limit` field can be used to limit the
   * number of results that are displayed for this method.<br/><br/>This method ensures that only the account groups
   * that the user has access to are returned. Access can be controlled either through a policy on a specific account
   * group, or account-level platform services access roles, such as Administrator, Editor, Operator, or Viewer. When
   * you call the method with the `enterprise_id`, `parent_account_group_id` or `parent` query parameter, all of the
   * account groups that are immediate children of this entity are returned. Authentication is performed on all account
   * groups before they are returned to the user to ensure that only those account groups are returned to which the
   * calling identity has access.
   *
   * @param {Object} [params] - The parameters to send to the service.
   * @param {string} [params.enterpriseId] - Get account groups that are either immediate children or are a part of the
   * hierarchy for a given enterprise ID.
   * @param {string} [params.parentAccountGroupId] - Get account groups that are either immediate children or are a part
   * of the hierarchy for a given account group ID.
   * @param {string} [params.nextDocid] - The first item to be returned in the page of results. This value can be
   * obtained from the next_url property from the previous call of the operation. If not specified, then the first page
   * of results is returned.
   * @param {string} [params.parent] - Get account groups that are either immediate children or are a part of the
   * hierarchy for a given parent CRN.
   * @param {number} [params.limit] - Return results up to this limit. Valid values are between `0` and `100`.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.ListAccountGroupsResponse>>}
   */
  public listAccountGroups(
    params?: EnterpriseManagementV1.ListAccountGroupsParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.ListAccountGroupsResponse>> {
    const _params = { ...params };

    const query = {
      'enterprise_id': _params.enterpriseId,
      'parent_account_group_id': _params.parentAccountGroupId,
      'next_docid': _params.nextDocid,
      'parent': _params.parent,
      'limit': _params.limit,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'listAccountGroups'
    );

    const parameters = {
      options: {
        url: '/account-groups',
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

  /**
   * Get account group by ID.
   *
   * Retrieve an account by the `account_group_id` parameter. All data related to the account group is returned only if
   * the caller has access to retrieve the account group.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountGroupId - The ID of the account group to retrieve.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.AccountGroup>>}
   */
  public getAccountGroup(
    params: EnterpriseManagementV1.GetAccountGroupParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.AccountGroup>> {
    const _params = { ...params };
    const requiredParams = ['accountGroupId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const path = {
      'account_group_id': _params.accountGroupId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'getAccountGroup'
    );

    const parameters = {
      options: {
        url: '/account-groups/{account_group_id}',
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
   * Update an account group.
   *
   * Update the name or IAM ID of the primary contact for an existing account group. The new primary contact must
   * already be a user in the enterprise account.
   *
   * @param {Object} params - The parameters to send to the service.
   * @param {string} params.accountGroupId - The ID of the account group to retrieve.
   * @param {string} [params.name] - The new name of the account group. This field must have 3 - 60 characters.
   * @param {string} [params.primaryContactIamId] - The IAM ID of the user to be the new primary contact for the account
   * group.
   * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
   * @returns {Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>>}
   */
  public updateAccountGroup(
    params: EnterpriseManagementV1.UpdateAccountGroupParams
  ): Promise<EnterpriseManagementV1.Response<EnterpriseManagementV1.Empty>> {
    const _params = { ...params };
    const requiredParams = ['accountGroupId'];

    const missingParams = getMissingParams(_params, requiredParams);
    if (missingParams) {
      return Promise.reject(missingParams);
    }

    const body = {
      'name': _params.name,
      'primary_contact_iam_id': _params.primaryContactIamId,
    };

    const path = {
      'account_group_id': _params.accountGroupId,
    };

    const sdkHeaders = getSdkHeaders(
      EnterpriseManagementV1.DEFAULT_SERVICE_NAME,
      'v1',
      'updateAccountGroup'
    );

    const parameters = {
      options: {
        url: '/account-groups/{account_group_id}',
        method: 'PATCH',
        body,
        path,
      },
      defaultOptions: extend(true, {}, this.baseOptions, {
        headers: extend(
          true,
          sdkHeaders,
          {
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

namespace EnterpriseManagementV1 {
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

  /** Parameters for the `createEnterprise` operation. */
  export interface CreateEnterpriseParams {
    /** The ID of the account that is used to create the enterprise. */
    sourceAccountId: string;
    /** The name of the enterprise. This field must have 3 - 60 characters. */
    name: string;
    /** The IAM ID of the enterprise primary contact, such as `IBMid-0123ABC`. The IAM ID must already exist. */
    primaryContactIamId: string;
    /** A domain or subdomain for the enterprise, such as `example.com` or `my.example.com`. */
    domain?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listEnterprises` operation. */
  export interface ListEnterprisesParams {
    /** Get enterprises for a given enterprise account ID. */
    enterpriseAccountId?: string;
    /** Get enterprises for a given account group ID. */
    accountGroupId?: string;
    /** Get enterprises for a given account ID. */
    accountId?: string;
    /** The first item to be returned in the page of results. This value can be obtained from the next_url property
     *  from the previous call of the operation. If not specified, then the first page of results is returned.
     */
    nextDocid?: string;
    /** Return results up to this limit. Valid values are between `0` and `100`. */
    limit?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getEnterprise` operation. */
  export interface GetEnterpriseParams {
    /** The ID of the enterprise to retrieve. */
    enterpriseId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateEnterprise` operation. */
  export interface UpdateEnterpriseParams {
    /** The ID of the enterprise to retrieve. */
    enterpriseId: string;
    /** The new name of the enterprise. This field must have 3 - 60 characters. */
    name?: string;
    /** The new domain of the enterprise. This field has a limit of 60 characters. */
    domain?: string;
    /** The IAM ID of the user to be the new primary contact for the enterprise. */
    primaryContactIamId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `importAccountToEnterprise` operation. */
  export interface ImportAccountToEnterpriseParams {
    /** The ID of the enterprise to import the stand-alone account into. */
    enterpriseId: string;
    /** The ID of the existing stand-alone account to be imported. */
    accountId: string;
    /** The CRN of the expected parent of the imported account. The parent is the enterprise or account group that
     *  the account is added to.
     */
    parent?: string;
    /** The ID of the [billing unit](/apidocs/enterprise-apis/billing-unit) to use for billing this account in the
     *  enterprise.
     */
    billingUnitId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createAccount` operation. */
  export interface CreateAccountParams {
    /** The CRN of the parent under which the account will be created. The parent can be an existing account group
     *  or the enterprise itself.
     */
    parent: string;
    /** The name of the account. This field must have 3 - 60 characters. */
    name: string;
    /** The IAM ID of the account owner, such as `IBMid-0123ABC`. The IAM ID must already exist. */
    ownerIamId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listAccounts` operation. */
  export interface ListAccountsParams {
    /** Get accounts that are either immediate children or are a part of the hierarchy for a given enterprise ID. */
    enterpriseId?: string;
    /** Get accounts that are either immediate children or are a part of the hierarchy for a given account group ID. */
    accountGroupId?: string;
    /** The first item to be returned in the page of results. This value can be obtained from the next_url property
     *  from the previous call of the operation. If not specified, then the first page of results is returned.
     */
    nextDocid?: string;
    /** Get accounts that are either immediate children or are a part of the hierarchy for a given parent CRN. */
    parent?: string;
    /** Return results up to this limit. Valid values are between `0` and `100`. */
    limit?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccount` operation. */
  export interface GetAccountParams {
    /** The ID of the account to retrieve. */
    accountId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateAccount` operation. */
  export interface UpdateAccountParams {
    /** The ID of the account to retrieve. */
    accountId: string;
    /** The CRN of the new parent within the enterprise. */
    parent: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `createAccountGroup` operation. */
  export interface CreateAccountGroupParams {
    /** The CRN of the parent under which the account group will be created. The parent can be an existing account
     *  group or the enterprise itself.
     */
    parent: string;
    /** The name of the account group. This field must have 3 - 60 characters. */
    name: string;
    /** The IAM ID of the primary contact for this account group, such as `IBMid-0123ABC`. The IAM ID must already
     *  exist.
     */
    primaryContactIamId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `listAccountGroups` operation. */
  export interface ListAccountGroupsParams {
    /** Get account groups that are either immediate children or are a part of the hierarchy for a given enterprise
     *  ID.
     */
    enterpriseId?: string;
    /** Get account groups that are either immediate children or are a part of the hierarchy for a given account
     *  group ID.
     */
    parentAccountGroupId?: string;
    /** The first item to be returned in the page of results. This value can be obtained from the next_url property
     *  from the previous call of the operation. If not specified, then the first page of results is returned.
     */
    nextDocid?: string;
    /** Get account groups that are either immediate children or are a part of the hierarchy for a given parent CRN. */
    parent?: string;
    /** Return results up to this limit. Valid values are between `0` and `100`. */
    limit?: number;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `getAccountGroup` operation. */
  export interface GetAccountGroupParams {
    /** The ID of the account group to retrieve. */
    accountGroupId: string;
    headers?: OutgoingHttpHeaders;
  }

  /** Parameters for the `updateAccountGroup` operation. */
  export interface UpdateAccountGroupParams {
    /** The ID of the account group to retrieve. */
    accountGroupId: string;
    /** The new name of the account group. This field must have 3 - 60 characters. */
    name?: string;
    /** The IAM ID of the user to be the new primary contact for the account group. */
    primaryContactIamId?: string;
    headers?: OutgoingHttpHeaders;
  }

  /*************************
   * model interfaces
   ************************/

  /** An account resource. */
  export interface Account {
    /** The URL of the account. */
    url?: string;
    /** The account ID. */
    id?: string;
    /** The Cloud Resource Name (CRN) of the account. */
    crn?: string;
    /** The CRN of the parent of the account. */
    parent?: string;
    /** The enterprise account ID. */
    enterprise_account_id?: string;
    /** The enterprise ID that the account is a part of. */
    enterprise_id?: string;
    /** The path from the enterprise to this particular account. */
    enterprise_path?: string;
    /** The name of the account. */
    name?: string;
    /** The state of the account. */
    state?: string;
    /** The IAM ID of the owner of the account. */
    owner_iam_id?: string;
    /** The type of account - whether it is free or paid. */
    paid?: boolean;
    /** The email address of the owner of the account. */
    owner_email?: string;
    /** The flag to indicate whether the account is an enterprise account or not. */
    is_enterprise_account?: boolean;
    /** The time stamp at which the account was created. */
    created_at?: string;
    /** The IAM ID of the user or service that created the account. */
    created_by?: string;
    /** The time stamp at which the account was last updated. */
    updated_at?: string;
    /** The IAM ID of the user or service that updated the account. */
    updated_by?: string;
  }

  /** An account group resource. */
  export interface AccountGroup {
    /** The URL of the account group. */
    url?: string;
    /** The account group ID. */
    id?: string;
    /** The Cloud Resource Name (CRN) of the account group. */
    crn?: string;
    /** The CRN of the parent of the account group. */
    parent?: string;
    /** The enterprise account ID. */
    enterprise_account_id?: string;
    /** The enterprise ID that the account group is a part of. */
    enterprise_id?: string;
    /** The path from the enterprise to this particular account group. */
    enterprise_path?: string;
    /** The name of the account group. */
    name?: string;
    /** The state of the account group. */
    state?: string;
    /** The IAM ID of the primary contact of the account group. */
    primary_contact_iam_id?: string;
    /** The email address of the primary contact of the account group. */
    primary_contact_email?: string;
    /** The time stamp at which the account group was created. */
    created_at?: string;
    /** The IAM ID of the user or service that created the account group. */
    created_by?: string;
    /** The time stamp at which the account group was last updated. */
    updated_at?: string;
    /** The IAM ID of the user or service that updated the account group. */
    updated_by?: string;
  }

  /** A newly-created account group. */
  export interface CreateAccountGroupResponse {
    /** The ID of the account group entity that was created. */
    account_group_id?: string;
  }

  /** A newly-created account. */
  export interface CreateAccountResponse {
    /** The ID of the account entity that was created. */
    account_id?: string;
  }

  /** The response from calling create enterprise. */
  export interface CreateEnterpriseResponse {
    /** The ID of the enterprise entity that was created. This entity is the root of the hierarchy. */
    enterprise_id?: string;
    /** The ID of the enterprise account that was created. The enterprise account is used to manage billing and
     *  access to the enterprise management.
     */
    enterprise_account_id?: string;
  }

  /** An enterprise resource. */
  export interface Enterprise {
    /** The URL of the enterprise. */
    url?: string;
    /** The enterprise ID. */
    id?: string;
    /** The enterprise account ID. */
    enterprise_account_id?: string;
    /** The Cloud Resource Name (CRN) of the enterprise. */
    crn?: string;
    /** The name of the enterprise. */
    name?: string;
    /** The domain of the enterprise. */
    domain?: string;
    /** The state of the enterprise. */
    state?: string;
    /** The IAM ID of the primary contact of the enterprise, such as `IBMid-0123ABC`. */
    primary_contact_iam_id?: string;
    /** The email of the primary contact of the enterprise. */
    primary_contact_email?: string;
    /** The time stamp at which the enterprise was created. */
    created_at?: string;
    /** The IAM ID of the user or service that created the enterprise. */
    created_by?: string;
    /** The time stamp at which the enterprise was last updated. */
    updated_at?: string;
    /** The IAM ID of the user or service that updated the enterprise. */
    updated_by?: string;
  }

  /** The list_account_groups operation response. */
  export interface ListAccountGroupsResponse {
    /** The number of enterprises returned from calling list account groups. */
    rows_count?: number;
    /** A string that represents the link to the next page of results. */
    next_url?: string;
    /** A list of account groups. */
    resources?: AccountGroup[];
  }

  /** The list_accounts operation response. */
  export interface ListAccountsResponse {
    /** The number of enterprises returned from calling list accounts. */
    rows_count?: number;
    /** A string that represents the link to the next page of results. */
    next_url?: string;
    /** A list of accounts. */
    resources?: Account[];
  }

  /** The response from calling list enterprises. */
  export interface ListEnterprisesResponse {
    /** The number of enterprises returned from calling list enterprise. */
    rows_count?: number;
    /** A string that represents the link to the next page of results. */
    next_url?: string;
    /** A list of enterprise objects. */
    resources?: Enterprise[];
  }
}

export = EnterpriseManagementV1;
