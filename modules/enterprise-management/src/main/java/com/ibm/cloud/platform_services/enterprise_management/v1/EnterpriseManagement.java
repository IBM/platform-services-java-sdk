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
package com.ibm.cloud.platform_services.enterprise_management.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountGroupResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.EnterpriseResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountByIdOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountGroupByIdOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountGroupPermissibleActionsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountPermissibleActionsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetEnterprisePermissibleActionsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ImportAccountToEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountGroupsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountGroupsResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountsResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListEnterprisesOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListEnterprisesResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateEnterpriseOptions;
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
 * The Enterprise Management API enables you to create and manage an enterprise, account groups, and accounts within the
 * enterprise.
 *
 * @version v1
 */
public class EnterpriseManagement extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "enterprise_management";

  public static final String DEFAULT_SERVICE_URL = "https://enterprise.test.cloud.ibm.com/v1";

 /**
   * Class method which constructs an instance of the `EnterpriseManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `EnterpriseManagement` client using external configuration
   */
  public static EnterpriseManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `EnterpriseManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `EnterpriseManagement` client using external configuration
   */
  public static EnterpriseManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    EnterpriseManagement service = new EnterpriseManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `EnterpriseManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public EnterpriseManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Create an account group.
   *
   * Create a new account group, which can be used to group together multiple accounts. To create an account group, you
   * must have an existing enterprise. The API creates an account group entity under the parent that is specified in the
   * payload of the request. The request also takes in the name and the primary contact of this new account group.
   *
   * @param createAccountGroupOptions the {@link CreateAccountGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateAccountGroupResponse}
   */
  public ServiceCall<CreateAccountGroupResponse> createAccountGroup(CreateAccountGroupOptions createAccountGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createAccountGroupOptions,
      "createAccountGroupOptions cannot be null");
    String[] pathSegments = { "account-groups" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "createAccountGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("parent", createAccountGroupOptions.parent());
    contentJson.addProperty("name", createAccountGroupOptions.name());
    contentJson.addProperty("primary_contact_iam_id", createAccountGroupOptions.primaryContactIamId());
    builder.bodyJson(contentJson);
    ResponseConverter<CreateAccountGroupResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateAccountGroupResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get account groups by query parameter.
   *
   * Retrieve all account groups based on the values that are passed in the query parameters. If no query parameter is
   * passed, all of the account groups in the enterprise for which the calling identity has access are returned.
   * &lt;br/&gt;&lt;br/&gt;You can use pagination parameters to filter the results. The `limit` field can be used to
   * limit the number of results that are displayed for this method.&lt;br/&gt;&lt;br/&gt;This method ensures that only
   * the account groups that the user has access to are returned. Access can be controlled either through a policy on a
   * specific account group, or account-level platform services access roles, such as Administrator, Editor, Operator,
   * or Viewer. When you call the method with the `enterprise_id`, `parent_account_group_id` or `parent` query
   * parameter, all of the account groups that are immediate children of this entity are returned. Authentication is
   * performed on all account groups before they are returned to the user to ensure that only those account groups are
   * returned to which the calling identity has access.
   *
   * @param listAccountGroupsOptions the {@link ListAccountGroupsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListAccountGroupsResponse}
   */
  public ServiceCall<ListAccountGroupsResponse> listAccountGroups(ListAccountGroupsOptions listAccountGroupsOptions) {
    String[] pathSegments = { "account-groups" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "listAccountGroups");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAccountGroupsOptions != null) {
      if (listAccountGroupsOptions.enterpriseId() != null) {
        builder.query("enterprise_id", listAccountGroupsOptions.enterpriseId());
      }
      if (listAccountGroupsOptions.parentAccountGroupId() != null) {
        builder.query("parent_account_group_id", listAccountGroupsOptions.parentAccountGroupId());
      }
      if (listAccountGroupsOptions.parent() != null) {
        builder.query("parent", listAccountGroupsOptions.parent());
      }
      if (listAccountGroupsOptions.limit() != null) {
        builder.query("limit", String.valueOf(listAccountGroupsOptions.limit()));
      }
    }
    ResponseConverter<ListAccountGroupsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListAccountGroupsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get account groups by query parameter.
   *
   * Retrieve all account groups based on the values that are passed in the query parameters. If no query parameter is
   * passed, all of the account groups in the enterprise for which the calling identity has access are returned.
   * &lt;br/&gt;&lt;br/&gt;You can use pagination parameters to filter the results. The `limit` field can be used to
   * limit the number of results that are displayed for this method.&lt;br/&gt;&lt;br/&gt;This method ensures that only
   * the account groups that the user has access to are returned. Access can be controlled either through a policy on a
   * specific account group, or account-level platform services access roles, such as Administrator, Editor, Operator,
   * or Viewer. When you call the method with the `enterprise_id`, `parent_account_group_id` or `parent` query
   * parameter, all of the account groups that are immediate children of this entity are returned. Authentication is
   * performed on all account groups before they are returned to the user to ensure that only those account groups are
   * returned to which the calling identity has access.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListAccountGroupsResponse}
   */
  public ServiceCall<ListAccountGroupsResponse> listAccountGroups() {
    return listAccountGroups(null);
  }

  /**
   * Get account group by ID.
   *
   * Retrieve an account by the `account_group_id` parameter. All data related to the account group is returned only if
   * the caller has access to retrieve the account group.
   *
   * @param getAccountGroupByIdOptions the {@link GetAccountGroupByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountGroupResponse}
   */
  public ServiceCall<AccountGroupResponse> getAccountGroupById(GetAccountGroupByIdOptions getAccountGroupByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountGroupByIdOptions,
      "getAccountGroupByIdOptions cannot be null");
    String[] pathSegments = { "account-groups" };
    String[] pathParameters = { getAccountGroupByIdOptions.accountGroupId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "getAccountGroupById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AccountGroupResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountGroupResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an account group.
   *
   * Update the name or IAM ID of the primary contact for an existing account group. The new primary contact must
   * already be a user in the enterprise account.
   *
   * @param updateAccountGroupOptions the {@link UpdateAccountGroupOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateAccountGroup(UpdateAccountGroupOptions updateAccountGroupOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAccountGroupOptions,
      "updateAccountGroupOptions cannot be null");
    String[] pathSegments = { "account-groups" };
    String[] pathParameters = { updateAccountGroupOptions.accountGroupId() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "updateAccountGroup");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateAccountGroupOptions.name() != null) {
      contentJson.addProperty("name", updateAccountGroupOptions.name());
    }
    if (updateAccountGroupOptions.primaryContactIamId() != null) {
      contentJson.addProperty("primary_contact_iam_id", updateAccountGroupOptions.primaryContactIamId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get permissible actions for an account group.
   *
   * Return all the actions that are allowed on a particular account group. This method takes an array of IAM actions in
   * the body of the request and returns those actions that can be performed by the caller. An authentication check is
   * performed for each action that is passed in the payload.
   *
   * @param getAccountGroupPermissibleActionsOptions the {@link GetAccountGroupPermissibleActionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getAccountGroupPermissibleActions(GetAccountGroupPermissibleActionsOptions getAccountGroupPermissibleActionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountGroupPermissibleActionsOptions,
      "getAccountGroupPermissibleActionsOptions cannot be null");
    String[] pathSegments = { "account-groups", "permissible-actions" };
    String[] pathParameters = { getAccountGroupPermissibleActionsOptions.accountGroupId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "getAccountGroupPermissibleActions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (getAccountGroupPermissibleActionsOptions.actions() != null) {
      contentJson.add("actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(getAccountGroupPermissibleActionsOptions.actions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Import an account into an enterprise.
   *
   * Import an existing stand-alone account into an enterprise. The existing account can be any type: trial (`TRIAL`),
   * Lite (`STANDARD`), Pay-As-You-Go (`PAYG`), or Subscription (`SUBSCRIPTION`). In the case of a `SUBSCRIPTION`
   * account, the credits, promotional offers, and discounts are migrated to the billing unit of the enterprise. For a
   * billable account (`PAYG` or `SUBSCRIPTION`), the country and currency code of the existing account and the billing
   * unit of the enterprise must match. The API returns a `202` response and performs asynchronous operations to import
   * the account into the enterprise. &lt;br/&gt;&lt;/br&gt;For more information about impacts to the account, see
   * [Adding accounts to an enterprise](https://{DomainName}/docs/account?topic=account-enterprise-add).
   *
   * @param importAccountToEnterpriseOptions the {@link ImportAccountToEnterpriseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> importAccountToEnterprise(ImportAccountToEnterpriseOptions importAccountToEnterpriseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(importAccountToEnterpriseOptions,
      "importAccountToEnterpriseOptions cannot be null");
    String[] pathSegments = { "enterprises", "import/accounts" };
    String[] pathParameters = { importAccountToEnterpriseOptions.enterpriseId(), importAccountToEnterpriseOptions.accountId() };
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "importAccountToEnterprise");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (importAccountToEnterpriseOptions.parent() != null) {
      contentJson.addProperty("parent", importAccountToEnterpriseOptions.parent());
    }
    if (importAccountToEnterpriseOptions.billingUnitId() != null) {
      contentJson.addProperty("billing_unit_id", importAccountToEnterpriseOptions.billingUnitId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create a new account in an enterprise.
   *
   * Create a new account as a part of an existing enterprise. The API creates an account entity under the parent that
   * is specified in the payload of the request. The request also takes in the name and the owner of this new account.
   * The owner must have a valid IBMid that's registered with {{site.data.keyword.cloud_notm}}, but they don't need to
   * be a user in the enterprise account.
   *
   * @param createAccountOptions the {@link CreateAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateAccountResponse}
   */
  public ServiceCall<CreateAccountResponse> createAccount(CreateAccountOptions createAccountOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createAccountOptions,
      "createAccountOptions cannot be null");
    String[] pathSegments = { "accounts" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "createAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("parent", createAccountOptions.parent());
    contentJson.addProperty("name", createAccountOptions.name());
    contentJson.addProperty("owner_iam_id", createAccountOptions.ownerIamId());
    builder.bodyJson(contentJson);
    ResponseConverter<CreateAccountResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateAccountResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get accounts by query parameter.
   *
   * Retrieve all accounts based on the values that are passed in the query parameters. If no query parameter is passed,
   * all of the accounts in the enterprise for which the calling identity has access are returned.
   * &lt;br/&gt;&lt;br/&gt;You can use pagination parameters to filter the results. The `limit` field can be used to
   * limit the number of results that are displayed for this method.&lt;br/&gt;&lt;br/&gt;This method ensures that only
   * the accounts that the user has access to are returned. Access can be controlled either through a policy on a
   * specific account, or account-level platform services access roles, such as Administrator, Editor, Operator, or
   * Viewer. When you call the method with the `enterprise_id`, `account_group_id` or `parent` query parameter, all of
   * the accounts that are immediate children of this entity are returned. Authentication is performed on all the
   * accounts before they are returned to the user to ensure that only those accounts are returned to which the calling
   * identity has access to.
   *
   * @param listAccountsOptions the {@link ListAccountsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListAccountsResponse}
   */
  public ServiceCall<ListAccountsResponse> listAccounts(ListAccountsOptions listAccountsOptions) {
    String[] pathSegments = { "accounts" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "listAccounts");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listAccountsOptions != null) {
      if (listAccountsOptions.enterpriseId() != null) {
        builder.query("enterprise_id", listAccountsOptions.enterpriseId());
      }
      if (listAccountsOptions.accountGroupId() != null) {
        builder.query("account_group_id", listAccountsOptions.accountGroupId());
      }
      if (listAccountsOptions.parent() != null) {
        builder.query("parent", listAccountsOptions.parent());
      }
      if (listAccountsOptions.limit() != null) {
        builder.query("limit", String.valueOf(listAccountsOptions.limit()));
      }
    }
    ResponseConverter<ListAccountsResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListAccountsResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get accounts by query parameter.
   *
   * Retrieve all accounts based on the values that are passed in the query parameters. If no query parameter is passed,
   * all of the accounts in the enterprise for which the calling identity has access are returned.
   * &lt;br/&gt;&lt;br/&gt;You can use pagination parameters to filter the results. The `limit` field can be used to
   * limit the number of results that are displayed for this method.&lt;br/&gt;&lt;br/&gt;This method ensures that only
   * the accounts that the user has access to are returned. Access can be controlled either through a policy on a
   * specific account, or account-level platform services access roles, such as Administrator, Editor, Operator, or
   * Viewer. When you call the method with the `enterprise_id`, `account_group_id` or `parent` query parameter, all of
   * the accounts that are immediate children of this entity are returned. Authentication is performed on all the
   * accounts before they are returned to the user to ensure that only those accounts are returned to which the calling
   * identity has access to.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListAccountsResponse}
   */
  public ServiceCall<ListAccountsResponse> listAccounts() {
    return listAccounts(null);
  }

  /**
   * Get account by ID.
   *
   * Retrieve an account by the `account_id` parameter. All data related to the account is returned only if the caller
   * has access to retrieve the account.
   *
   * @param getAccountByIdOptions the {@link GetAccountByIdOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AccountResponse}
   */
  public ServiceCall<AccountResponse> getAccountById(GetAccountByIdOptions getAccountByIdOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountByIdOptions,
      "getAccountByIdOptions cannot be null");
    String[] pathSegments = { "accounts" };
    String[] pathParameters = { getAccountByIdOptions.accountId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "getAccountById");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<AccountResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AccountResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Move an account with the enterprise.
   *
   * Move an account to a different parent within the same enterprise.
   *
   * @param updateAccountOptions the {@link UpdateAccountOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateAccount(UpdateAccountOptions updateAccountOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateAccountOptions,
      "updateAccountOptions cannot be null");
    String[] pathSegments = { "accounts" };
    String[] pathParameters = { updateAccountOptions.accountId() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "updateAccount");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("parent", updateAccountOptions.parent());
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get permissible actions for an account.
   *
   * Return all the actions that are allowed on a particular account. This method takes an array of IAM actions in the
   * body of the request and returns those actions which can be performed by the caller. An authentication check is
   * performed for each action that is passed in the payload.
   *
   * @param getAccountPermissibleActionsOptions the {@link GetAccountPermissibleActionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getAccountPermissibleActions(GetAccountPermissibleActionsOptions getAccountPermissibleActionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getAccountPermissibleActionsOptions,
      "getAccountPermissibleActionsOptions cannot be null");
    String[] pathSegments = { "accounts", "permissible-actions" };
    String[] pathParameters = { getAccountPermissibleActionsOptions.accountId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "getAccountPermissibleActions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (getAccountPermissibleActionsOptions.actions() != null) {
      contentJson.add("actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(getAccountPermissibleActionsOptions.actions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Create an enterprise.
   *
   * Create a new enterprise, which you can use to centrally manage multiple accounts. To create an enterprise, you must
   * have an active Subscription account. &lt;br/&gt;&lt;br/&gt;The API creates an enterprise entity, which is the root
   * of the enterprise hierarchy. It also creates a new enterprise account that is used to manage the enterprise. All
   * subscriptions, support entitlements, credits, and discounts from the source subscription account are migrated to
   * the enterprise account, and the source account becomes a child account in the hierarchy. The user that you assign
   * as the enterprise primary contact is also assigned as the owner of the enterprise account.
   *
   * @param createEnterpriseOptions the {@link CreateEnterpriseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateEnterpriseResponse}
   */
  public ServiceCall<CreateEnterpriseResponse> createEnterprise(CreateEnterpriseOptions createEnterpriseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createEnterpriseOptions,
      "createEnterpriseOptions cannot be null");
    String[] pathSegments = { "enterprises" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "createEnterprise");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("source_account_id", createEnterpriseOptions.sourceAccountId());
    contentJson.addProperty("name", createEnterpriseOptions.name());
    contentJson.addProperty("primary_contact_iam_id", createEnterpriseOptions.primaryContactIamId());
    if (createEnterpriseOptions.domain() != null) {
      contentJson.addProperty("domain", createEnterpriseOptions.domain());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<CreateEnterpriseResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateEnterpriseResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get enterprise by query parameter.
   *
   * Retrieve all enterprises for a given ID by passing the IDs on query parameters. If no ID is passed, the enterprises
   * for which the calling identity is the primary contact are returned. You can use pagination parameters to filter the
   * results. &lt;br/&gt;&lt;br/&gt;This method ensures that only the enterprises that the user has access to are
   * returned. Access can be controlled either through a policy on a specific enterprise, or account-level platform
   * services access roles, such as Administrator, Editor, Operator, or Viewer. When you call the method with the
   * `enterprise_account_id` or `account_id` query parameter, the account ID in the token is compared with that in the
   * query parameter. If these account IDs match, authentication isn't performed and the enterprise information is
   * returned. If the account IDs don't match, authentication is performed and only then is the enterprise information
   * returned in the response.
   *
   * @param listEnterprisesOptions the {@link ListEnterprisesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link ListEnterprisesResponse}
   */
  public ServiceCall<ListEnterprisesResponse> listEnterprises(ListEnterprisesOptions listEnterprisesOptions) {
    String[] pathSegments = { "enterprises" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "listEnterprises");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listEnterprisesOptions != null) {
      if (listEnterprisesOptions.enterpriseAccountId() != null) {
        builder.query("enterprise_account_id", listEnterprisesOptions.enterpriseAccountId());
      }
      if (listEnterprisesOptions.accountGroupId() != null) {
        builder.query("account_group_id", listEnterprisesOptions.accountGroupId());
      }
      if (listEnterprisesOptions.accountId() != null) {
        builder.query("account_id", listEnterprisesOptions.accountId());
      }
      if (listEnterprisesOptions.limit() != null) {
        builder.query("limit", String.valueOf(listEnterprisesOptions.limit()));
      }
    }
    ResponseConverter<ListEnterprisesResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<ListEnterprisesResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get enterprise by query parameter.
   *
   * Retrieve all enterprises for a given ID by passing the IDs on query parameters. If no ID is passed, the enterprises
   * for which the calling identity is the primary contact are returned. You can use pagination parameters to filter the
   * results. &lt;br/&gt;&lt;br/&gt;This method ensures that only the enterprises that the user has access to are
   * returned. Access can be controlled either through a policy on a specific enterprise, or account-level platform
   * services access roles, such as Administrator, Editor, Operator, or Viewer. When you call the method with the
   * `enterprise_account_id` or `account_id` query parameter, the account ID in the token is compared with that in the
   * query parameter. If these account IDs match, authentication isn't performed and the enterprise information is
   * returned. If the account IDs don't match, authentication is performed and only then is the enterprise information
   * returned in the response.
   *
   * @return a {@link ServiceCall} with a result of type {@link ListEnterprisesResponse}
   */
  public ServiceCall<ListEnterprisesResponse> listEnterprises() {
    return listEnterprises(null);
  }

  /**
   * Get enterprise by ID.
   *
   * Retrieve an enterprise by the `enterprise_id` parameter. All data related to the enterprise is returned only if the
   * caller has access to retrieve the enterprise.
   *
   * @param getEnterpriseOptions the {@link GetEnterpriseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link EnterpriseResponse}
   */
  public ServiceCall<EnterpriseResponse> getEnterprise(GetEnterpriseOptions getEnterpriseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getEnterpriseOptions,
      "getEnterpriseOptions cannot be null");
    String[] pathSegments = { "enterprises" };
    String[] pathParameters = { getEnterpriseOptions.enterpriseId() };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "getEnterprise");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");

    ResponseConverter<EnterpriseResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<EnterpriseResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update an enterprise.
   *
   * Update the name, domain, or IAM ID of the primary contact for an existing enterprise. The new primary contact must
   * already be a user in the enterprise account.
   *
   * @param updateEnterpriseOptions the {@link UpdateEnterpriseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> updateEnterprise(UpdateEnterpriseOptions updateEnterpriseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateEnterpriseOptions,
      "updateEnterpriseOptions cannot be null");
    String[] pathSegments = { "enterprises" };
    String[] pathParameters = { updateEnterpriseOptions.enterpriseId() };
    RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "updateEnterprise");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (updateEnterpriseOptions.name() != null) {
      contentJson.addProperty("name", updateEnterpriseOptions.name());
    }
    if (updateEnterpriseOptions.domain() != null) {
      contentJson.addProperty("domain", updateEnterpriseOptions.domain());
    }
    if (updateEnterpriseOptions.primaryContactIamId() != null) {
      contentJson.addProperty("primary_contact_iam_id", updateEnterpriseOptions.primaryContactIamId());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get permissible actions for an enterprise.
   *
   * Return all the actions that are allowed on a particular enterprise. This method takes an array of IAM actions in
   * the body of the request and returns those actions which can be performed by the caller. An authentication check is
   * performed for each action that is passed in the payload.
   *
   * @param getEnterprisePermissibleActionsOptions the {@link GetEnterprisePermissibleActionsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a void result
   */
  public ServiceCall<Void> getEnterprisePermissibleActions(GetEnterprisePermissibleActionsOptions getEnterprisePermissibleActionsOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getEnterprisePermissibleActionsOptions,
      "getEnterprisePermissibleActionsOptions cannot be null");
    String[] pathSegments = { "enterprises", "permissible-actions" };
    String[] pathParameters = { getEnterprisePermissibleActionsOptions.enterpriseId() };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("enterprise_management", "v1", "getEnterprisePermissibleActions");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    final JsonObject contentJson = new JsonObject();
    if (getEnterprisePermissibleActionsOptions.actions() != null) {
      contentJson.add("actions", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(getEnterprisePermissibleActionsOptions.actions()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Void> responseConverter = ResponseConverterUtils.getVoid();
    return createServiceCall(builder.build(), responseConverter);
  }

}
