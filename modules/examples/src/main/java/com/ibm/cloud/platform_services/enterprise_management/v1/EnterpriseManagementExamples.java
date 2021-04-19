/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.platform_services.enterprise_management.v1.model.Account;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountGroup;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.Enterprise;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetEnterpriseOptions;
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
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Enterprise Management service.
//
// The following configuration properties are assumed to be defined:
// ENTERPRISE_MANAGEMENT_URL=<service base url>
// ENTERPRISE_MANAGEMENT_AUTH_TYPE=iam
// ENTERPRISE_MANAGEMENT_APIKEY=<IAM apikey>
// ENTERPRISE_MANAGEMENT_AUTH_URL=<IAM token service base URL - omit this if using the production environment>
// ENTERPRISE_MANAGEMENT_ENTERPRISE_ID=<ID of the enterprise>
// ENTERPRISE_MANAGEMENT_ACCOUNT_ID=<enterprise account ID>
// ENTERPRISE_MANAGEMENT_ACCOUNT_IAM_ID=<IAM ID of the enterprise account>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class EnterpriseManagementExamples {

  private static final Logger logger = LoggerFactory.getLogger(EnterpriseManagementExamples.class);

  protected EnterpriseManagementExamples() {
  }

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../enterprise_management.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    EnterpriseManagement service = EnterpriseManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(EnterpriseManagement.DEFAULT_SERVICE_NAME);

    String enterpriseId = config.get("ENTERPRISE_ID");
    String enterpriseAccountId = config.get("ACCOUNT_ID");
    String enterpriseAccountIamId = config.get("ACCOUNT_IAM_ID");
    String accountGroupId = null;
    String newParentAccountGroupId = null;
    String accountId = null;

    try {
      System.out.println("createAccountGroup() result:");

      String parentCRN = String.format("crn:v1:bluemix:public:enterprise::a/%s::enterprise:%s", enterpriseAccountId,
              enterpriseId);

      // begin-create_account_group

      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
          .parent(parentCRN)
          .name("Example Account Group")
          .primaryContactIamId(enterpriseAccountIamId)
          .build();

      Response<CreateAccountGroupResponse> response = service.createAccountGroup(createAccountGroupOptions).execute();
      CreateAccountGroupResponse createAccountGroupResponse = response.getResult();

      System.out.println(createAccountGroupResponse);

      // end-create_account_group

      accountGroupId = createAccountGroupResponse.getAccountGroupId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createAccountGroup(new parent account group) result:");

      String parentCRN = String.format("crn:v1:bluemix:public:enterprise::a/%s::enterprise:%s", enterpriseAccountId,
          enterpriseId);

      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
          .parent(parentCRN)
          .name("New Parent Account Group")
          .primaryContactIamId(enterpriseAccountIamId)
          .build();

      Response<CreateAccountGroupResponse> response = service.createAccountGroup(createAccountGroupOptions).execute();
      CreateAccountGroupResponse createAccountGroupResponse = response.getResult();
      System.out.println(createAccountGroupResponse);

      newParentAccountGroupId = createAccountGroupResponse.getAccountGroupId();

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccountGroups() result:");

      // begin-list_account_groups

      ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
          .enterpriseId(enterpriseId)
          .build();

      Response<ListAccountGroupsResponse> response = service.listAccountGroups(listAccountGroupsOptions).execute();
      ListAccountGroupsResponse listAccountGroupsResponse = response.getResult();

      System.out.println(listAccountGroupsResponse);

      // end-list_account_groups

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccountGroup() result:");

      // begin-get_account_group

      GetAccountGroupOptions getAccountGroupOptions = new GetAccountGroupOptions.Builder()
          .accountGroupId(accountGroupId)
          .build();

      Response<AccountGroup> response = service.getAccountGroup(getAccountGroupOptions).execute();
      AccountGroup accountGroup = response.getResult();

      System.out.println(accountGroup);

      // end-get_account_group

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_account_group

      UpdateAccountGroupOptions updateAccountGroupOptions = new UpdateAccountGroupOptions.Builder()
          .accountGroupId(accountGroupId)
          .name("Updated Example Account Group")
          .build();

      Response<Void> response = service.updateAccountGroup(updateAccountGroupOptions).execute();

      // end-update_account_group

      System.out.printf("updateAccountGroup() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      String importAccountId = "<accountid_to_be_imported>";

      // begin-import_account_to_enterprise

      ImportAccountToEnterpriseOptions importAccountToEnterpriseOptions = new ImportAccountToEnterpriseOptions.Builder()
          .enterpriseId(enterpriseId)
          .accountId(importAccountId)
          .build();

      Response<Void> response = service.importAccountToEnterprise(importAccountToEnterpriseOptions).execute();

      // end-import_account_to_enterprise

      System.out.printf("importAccountToEnterprise() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("createAccount() result:");

      String parentCRN = String.format("crn:v1:bluemix:public:enterprise::a/%s::account-group:%s", enterpriseAccountId,
              accountGroupId);

      // begin-create_account

      CreateAccountOptions createAccountOptions = new CreateAccountOptions.Builder()
          .parent(parentCRN)
          .name("Example Account")
          .ownerIamId(enterpriseAccountIamId)
          .build();

      Response<CreateAccountResponse> response = service.createAccount(createAccountOptions).execute();
      CreateAccountResponse createAccountResponse = response.getResult();

      System.out.println(createAccountResponse);

      // end-create_account

      accountId = createAccountResponse.getAccountId();
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listAccounts() result:");

      // begin-list_accounts

      ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
          .enterpriseId(enterpriseId)
          .build();

      Response<ListAccountsResponse> response = service.listAccounts(listAccountsOptions).execute();
      ListAccountsResponse listAccountsResponse = response.getResult();

      System.out.println(listAccountsResponse);

      // end-list_accounts

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getAccount() result:");

      // begin-get_account

      GetAccountOptions getAccountOptions = new GetAccountOptions.Builder()
          .accountId(accountId)
          .build();

      Response<Account> response = service.getAccount(getAccountOptions).execute();
      Account account = response.getResult();

      System.out.println(account);

      // end-get_account

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      String newParentCRN = String.format("crn:v1:bluemix:public:enterprise::a/%s::account-group:%s",
              enterpriseAccountId, newParentAccountGroupId);

      // begin-update_account

      UpdateAccountOptions updateAccountOptions = new UpdateAccountOptions.Builder()
          .accountId(accountId)
          .parent(newParentCRN)
          .build();

      Response<Void> response = service.updateAccount(updateAccountOptions).execute();

      // end-update_account

      System.out.printf("updateAccount() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      String srcAccountId = "<standalone_account_id>";
      String contactIamId = "<standalone_account_iam_id>";

      System.out.println("createEnterprise() result:");

      // begin-create_enterprise

      CreateEnterpriseOptions createEnterpriseOptions = new CreateEnterpriseOptions.Builder()
          .sourceAccountId(srcAccountId)
          .name("Example Enterprise")
          .primaryContactIamId(contactIamId)
          .build();

      Response<CreateEnterpriseResponse> response = service.createEnterprise(createEnterpriseOptions).execute();
      CreateEnterpriseResponse createEnterpriseResponse = response.getResult();

      System.out.println(createEnterpriseResponse);

      // end-create_enterprise

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("listEnterprises() result:");

      // begin-list_enterprises

      ListEnterprisesOptions listEnterprisesOptions = new ListEnterprisesOptions.Builder()
          .enterpriseAccountId(enterpriseAccountId)
          .build();

      Response<ListEnterprisesResponse> response = service
          .listEnterprises(listEnterprisesOptions)
          .execute();
      ListEnterprisesResponse listEnterprisesResponse = response.getResult();

      System.out.println(listEnterprisesResponse);

      // end-list_enterprises

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      System.out.println("getEnterprise() result:");

      // begin-get_enterprise

      GetEnterpriseOptions getEnterpriseOptions = new GetEnterpriseOptions.Builder()
          .enterpriseId(enterpriseId)
          .build();

      Response<Enterprise> response = service
          .getEnterprise(getEnterpriseOptions)
          .execute();
      Enterprise enterprise = response.getResult();

      System.out.println(enterprise);

      // end-get_enterprise

    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-update_enterprise

      UpdateEnterpriseOptions updateEnterpriseOptions = new UpdateEnterpriseOptions.Builder()
          .enterpriseId(enterpriseId)
          .name("Updated Example Enterprise")
          .build();

      Response<Void> response = service.updateEnterprise(updateEnterpriseOptions)
          .execute();

      // end-update_enterprise

      System.out.printf("updateEnterprise() response status code: %d%n", response.getStatusCode());
    } catch (ServiceResponseException e) {
      logger.error(String.format("Service returned status code %s: %s%nError details: %s", e.getStatusCode(),
          e.getMessage(), e.getDebuggingInfo()), e);
    }
  }
}
