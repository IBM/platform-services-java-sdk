"use strict";
/**
 * (C) Copyright IBM Corp. 2019.
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
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var extend = require("extend");
var ibm_cloud_sdk_core_1 = require("ibm-cloud-sdk-core");
var common_1 = require("../lib/common");
/**
 * Manage lifecycle of your Cloud resource groups using Resource Manager APIs.
 */
var ResourceManagerV2 = /** @class */ (function (_super) {
    __extends(ResourceManagerV2, _super);
    /**
     * Construct a ResourceManagerV2 object.
     *
     * @param {Object} options - Options for the service.
     * @param {string} [options.serviceUrl] - The base url to use when contacting the service (e.g. 'https://gateway.watsonplatform.net/v2'). The base url may differ between IBM Cloud regions.
     * @param {OutgoingHttpHeaders} [options.headers] - Default headers that shall be included with every request to the service.
     * @param {Authenticator} options.authenticator - The Authenticator object used to authenticate requests to the service
     * @constructor
     * @returns {ResourceManagerV2}
     */
    function ResourceManagerV2(options) {
        var _this = _super.call(this, options) || this;
        if (options.serviceUrl) {
            _this.setServiceUrl(options.serviceUrl);
        }
        else {
            _this.setServiceUrl(ResourceManagerV2.DEFAULT_SERVICE_URL);
        }
        return _this;
    }
    /*************************
     * Factory method
     ************************/
    /**
     * Constructs an instance of ResourceManagerV2 with passed in options and external configuration.
     *
     * @param {UserOptions} [options] - The parameters to send to the service.
     * @param {string} [options.serviceName] - The name of the service to configure
     * @param {Authenticator} [options.authenticator] - The Authenticator object used to authenticate requests to the service
     * @param {string} [options.serviceUrl] - The URL for the service
     * @returns {ResourceManagerV2}
     */
    ResourceManagerV2.newInstance = function (options) {
        if (!options.serviceName) {
            options.serviceName = this.DEFAULT_SERVICE_NAME;
        }
        if (!options.authenticator) {
            options.authenticator = ibm_cloud_sdk_core_1.getAuthenticatorFromEnvironment(options.serviceName);
        }
        var service = new ResourceManagerV2(options);
        service.configureService(options.serviceName);
        if (options.serviceUrl) {
            service.setServiceUrl(options.serviceUrl);
        }
        return service;
    };
    /*************************
     * resourceGroup
     ************************/
    /**
     * Get a list of all resource groups.
     *
     * Get a list of all resource groups in an account.
     *
     * @param {Object} [params] - The parameters to send to the service.
     * @param {string} [params.accountId] - The ID of the account that contains the resource groups that you want to get.
     * @param {string} [params.date] - The date would be in a format of YYYY-MM which returns resource groups exclude the
     * deleted ones before this month.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroupsList>>}
     */
    ResourceManagerV2.prototype.listResourceGroups = function (params) {
        var _this = this;
        var _params = extend({}, params);
        return new Promise(function (resolve, reject) {
            var query = {
                'account_id': _params.accountId,
                'date': _params.date
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'listResourceGroups');
            var parameters = {
                options: {
                    url: '/resource_groups',
                    method: 'GET',
                    qs: query
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Create a new resource group.
     *
     * Create a new resource group in an account.
     *
     * @param {Object} [params] - The parameters to send to the service.
     * @param {string} [params.name] - The new name of the resource group.
     * @param {string} [params.accountId] - The account id of the resource group.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>>}
     */
    ResourceManagerV2.prototype.createResourceGroup = function (params) {
        var _this = this;
        var _params = extend({}, params);
        return new Promise(function (resolve, reject) {
            var body = {
                'name': _params.name,
                'account_id': _params.accountId
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'createResourceGroup');
            var parameters = {
                options: {
                    url: '/resource_groups',
                    method: 'POST',
                    body: body
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Get a resource group.
     *
     * Retrieve a resource group by ID.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.id - The short or long ID of the alias.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>>}
     */
    ResourceManagerV2.prototype.getResourceGroup = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['id'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'id': _params.id
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceGroup');
            var parameters = {
                options: {
                    url: '/resource_groups/{id}',
                    method: 'GET',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Update a resource group.
     *
     * Update a resource group by ID.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.id - The short or long ID of the alias.
     * @param {string} [params.name] - The new name of the resource group.
     * @param {string} [params.state] - The state of the resource group.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceGroup>>}
     */
    ResourceManagerV2.prototype.updateResourceGroup = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['id'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var body = {
                'name': _params.name,
                'state': _params.state
            };
            var path = {
                'id': _params.id
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceGroup');
            var parameters = {
                options: {
                    url: '/resource_groups/{id}',
                    method: 'PATCH',
                    body: body,
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Delete a resource group.
     *
     * Delete a resource group by ID.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.id - The short or long ID of the alias.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.Empty>>}
     */
    ResourceManagerV2.prototype.deleteResourceGroup = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['id'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'id': _params.id
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceGroup');
            var parameters = {
                options: {
                    url: '/resource_groups/{id}',
                    method: 'DELETE',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {}, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /*************************
     * quotaDefinition
     ************************/
    /**
     * Get a list of all quota definitions.
     *
     * Get a list of all quota definitions.
     *
     * @param {Object} [params] - The parameters to send to the service.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinitionsList>>}
     */
    ResourceManagerV2.prototype.listQuotaDefinitions = function (params) {
        var _this = this;
        var _params = extend({}, params);
        return new Promise(function (resolve, reject) {
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'listQuotaDefinitions');
            var parameters = {
                options: {
                    url: '/quota_definitions',
                    method: 'GET'
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Get a quota definition.
     *
     * Get a a quota definition.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.id - The id of the quota.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinitions>>}
     */
    ResourceManagerV2.prototype.getQuotaDefinition = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['id'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'id': _params.id
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getQuotaDefinition');
            var parameters = {
                options: {
                    url: '/quota_definitions/{id}',
                    method: 'GET',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /*************************
     * accountQuotas
     ************************/
    /**
     * Retrieve a list of quotas in an account.
     *
     * Retrieve a list of all "merged" quota definition for the specified account.You can use the IAM service token or a
     * user token for authorization. To use this method, the requesting user or service ID must have at least the viewer,
     * editor, operator, or administrator role on the Resource Controller service. The merge operation takes the default
     * quota definition for each resource type, and if there is a delta override quota definition defined for the
     * specified account, the override values will replace any corresponding values in the default quota specification.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.accountId - The account ID.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.QuotaDefinitions>>}
     */
    ResourceManagerV2.prototype.getQuotaDefinitions = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['accountId'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'account_id': _params.accountId
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getQuotaDefinitions');
            var parameters = {
                options: {
                    url: '/quota_definitions/accounts/{account_id}',
                    method: 'GET',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Retrieve a quota of a resource in an account.
     *
     * Retrieve a "merged" quota definition for the specified account and type of resource. You can use the IAM service
     * token or a user token for authorization. To use this method, the requesting user or service ID must have at least
     * the viewer, editor, operator, or administrator role on the Resource Controller service. The merge operation takes
     * the default quota definition for the specified resource type, and if there is a delta override quota definition
     * defined for the specified account, the override values will replace any corresponding values in the default quota
     * specification.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.accountId - The account ID.
     * @param {string} params.resourceType - The type of resource.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceQuota>>}
     */
    ResourceManagerV2.prototype.getResourceQuota = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['accountId', 'resourceType'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'account_id': _params.accountId,
                'resource_type': _params.resourceType
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getResourceQuota');
            var parameters = {
                options: {
                    url: '/quota_definitions/accounts/{account_id}/resource_types/{resource_type}',
                    method: 'GET',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Update a quota for a resource in an account.
     *
     * Override a quota definition for a specified account and type of resource, replacing any previous quota definition
     * defined for the account and resource type. You can use the IAM service token or a user token for authorization. To
     * use this method, the requesting user or service ID must have at least editor or administrator role on the Resource
     * Controller service.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.accountId - The account ID.
     * @param {string} params.resourceType - The type of resource.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ErrorCollection>>}
     */
    ResourceManagerV2.prototype.updateResourceQuota = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['accountId', 'resourceType'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'account_id': _params.accountId,
                'resource_type': _params.resourceType
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'updateResourceQuota');
            var parameters = {
                options: {
                    url: '/quota_definitions/accounts/{account_id}/resource_types/{resource_type}',
                    method: 'PUT',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Delete a quota for a resource in an account.
     *
     * Deletes a quota definition if one has been defined for a specified account and type of resource, the default quota
     * values for the resource type will still be effective. You can use the IAM service token or a user token for
     * authorization. To use this method, the requesting user or service ID must have administrator role on the Resource
     * Controller service.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.accountId - The account ID.
     * @param {string} params.resourceType - The type of resource.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ErrorCollection>>}
     */
    ResourceManagerV2.prototype.deleteResourceQuota = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['accountId', 'resourceType'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'account_id': _params.accountId,
                'resource_type': _params.resourceType
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'deleteResourceQuota');
            var parameters = {
                options: {
                    url: '/quota_definitions/accounts/{account_id}/resource_types/{resource_type}',
                    method: 'DELETE',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Create a default resource quota for a resource type.
     *
     * Create a default resource quota for a resource type. You can use the IAM service token or a user token for
     * authorization. To use this method, the requesting user or service ID must have at least editor or administrator
     * role on the Resource Controller service.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.resourceType - The resource type.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ErrorCollection>>}
     */
    ResourceManagerV2.prototype.createDefaultResourceQuota = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['resourceType'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'resource_type': _params.resourceType
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'createDefaultResourceQuota');
            var parameters = {
                options: {
                    url: '/quota_definitions/resource_types/{resource_type}',
                    method: 'POST',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Create a schema for a resource type.
     *
     * Create a schema for a resource type. You can use the IAM service token or a user token for authorization. To use
     * this method, the requesting user or service ID must have at least editor or administrator role on the Resource
     * Controller service.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.resourceType - The resource type.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ErrorCollection>>}
     */
    ResourceManagerV2.prototype.createSchema = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['resourceType'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'resource_type': _params.resourceType
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'createSchema');
            var parameters = {
                options: {
                    url: '/quota_definitions/resource_types/{resource_type}/schemas',
                    method: 'POST',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    /**
     * Retrieve a schema for a resource type.
     *
     * Retrieve a schema for a resource type. You can use the IAM service token or a user token for authorization. To use
     * this method, the requesting user or service ID must have at least editor or administrator role on the Resource
     * Controller service.
     *
     * @param {Object} params - The parameters to send to the service.
     * @param {string} params.resourceType - The resource type.
     * @param {OutgoingHttpHeaders} [params.headers] - Custom request headers
     * @returns {Promise<ResourceManagerV2.Response<ResourceManagerV2.ResourceQuota>>}
     */
    ResourceManagerV2.prototype.getSchema = function (params) {
        var _this = this;
        var _params = extend({}, params);
        var requiredParams = ['resourceType'];
        return new Promise(function (resolve, reject) {
            var missingParams = ibm_cloud_sdk_core_1.getMissingParams(_params, requiredParams);
            if (missingParams) {
                return reject(missingParams);
            }
            var path = {
                'resource_type': _params.resourceType
            };
            var sdkHeaders = common_1.getSdkHeaders(ResourceManagerV2.DEFAULT_SERVICE_NAME, 'v2', 'getSchema');
            var parameters = {
                options: {
                    url: '/quota_definitions/resource_types/{resource_type}/schemas',
                    method: 'GET',
                    path: path
                },
                defaultOptions: extend(true, {}, _this.baseOptions, {
                    headers: extend(true, sdkHeaders, {
                        'Accept': 'application/json'
                    }, _params.headers)
                })
            };
            return resolve(_this.createRequest(parameters));
        });
    };
    ;
    ResourceManagerV2.DEFAULT_SERVICE_URL = 'https://resource-controller.test.cloud.ibm.com/v2';
    ResourceManagerV2.DEFAULT_SERVICE_NAME = 'resource_manager';
    return ResourceManagerV2;
}(ibm_cloud_sdk_core_1.BaseService));
module.exports = ResourceManagerV2;
