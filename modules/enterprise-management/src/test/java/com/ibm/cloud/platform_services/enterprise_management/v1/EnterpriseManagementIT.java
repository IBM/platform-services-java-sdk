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

import com.ibm.cloud.platform_services.enterprise_management.v1.model.*;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.util.*;

import com.ibm.cloud.sdk.core.util.UrlHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Integration test class for the EnterpriseManagement service.
 */
public class EnterpriseManagementIT extends SdkIntegrationTestBase {

  public EnterpriseManagement service = null;
  public static Map<String, String> config = null;

  String enterpriseId = null;
  String accountId = null;
  String accountIamId = null;
  String firstExampleAccountGroupName = "First Example Account Group Name";
  String updatedFirstExampleAccountGroupName = "Updated First Example Account Group Name";
  String secondExampleAccountGroupName = "Second Example Account Group Name";
  String exampleAccountName = "Example Account Name";
  String exampleAccountId = null;
  String updatedExampleEnterpriseName = "Updated Example Enterprise Name";
  String firstExampleAccountGroupId = null;
  String secondExampleAccountGroupId = null;
  String createAccountGroupCrn = "crn:v1:bluemix:public:enterprise::a/%s::enterprise:%s";
  String createAccountCrn = "crn:v1:bluemix:public:enterprise::a/%s::account-group:%s";

  /**
   * This method provides our config filename to the base class.
   */

  public String getConfigFilename() {
    return "../../enterprise_management.env";
  }

  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }

    service = EnterpriseManagement.newInstance();
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());

    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(EnterpriseManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));

    enterpriseId = config.get("ENTERPRISE_ID");
    assertNotNull(enterpriseId);

    accountId = config.get("ACCOUNT_ID");
    assertNotNull(accountId);

    accountIamId = config.get("ACCOUNT_IAM_ID");
    assertNotNull(accountIamId);

    System.out.println("Setup complete.");
  }

  @Test
  public void testCreateAccountGroup() throws Exception {
    try {
      String parentCrn = String.format(createAccountGroupCrn, accountId, enterpriseId);
      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
          .parent(parentCrn)
          .name(firstExampleAccountGroupName)
          .primaryContactIamId(accountIamId)
          .build();

      // Invoke operation
      Response<CreateAccountGroupResponse> response = service
          .createAccountGroup(createAccountGroupOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      CreateAccountGroupResponse createAccountGroupResponseResult = response.getResult();
      assertNotNull(createAccountGroupResponseResult);

      firstExampleAccountGroupId = createAccountGroupResponseResult.getAccountGroupId();
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testCreateAnotherAccountGroup() throws Exception {
    try {
      String parentCrn = String.format(createAccountGroupCrn, accountId, enterpriseId);
      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
          .parent(parentCrn)
          .name(secondExampleAccountGroupName)
          .primaryContactIamId(accountIamId)
          .build();

      // Invoke operation
      Response<CreateAccountGroupResponse> response = service
          .createAccountGroup(createAccountGroupOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      CreateAccountGroupResponse createAccountGroupResponseResult = response.getResult();
      assertNotNull(createAccountGroupResponseResult);

      secondExampleAccountGroupId = createAccountGroupResponseResult.getAccountGroupId();
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccountGroup", "testCreateAnotherAccountGroup"})
  public void testListAccountGroups() throws Exception {
    try {
      List<AccountGroup> accountGroupsList = new ArrayList<>();
      String nextDocId = null;
      Integer limit = 10;
      do {
        ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
            .enterpriseId(enterpriseId)
            .nextDocid(nextDocId)
            .limit(limit)
            .build();

        // Invoke operation
        Response<ListAccountGroupsResponse> response = service
            .listAccountGroups(listAccountGroupsOptions)
            .execute();
        // Validate response
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ListAccountGroupsResponse listAccountGroupsResponseResult = response.getResult();

        assertNotNull(listAccountGroupsResponseResult);
        assertNotNull(listAccountGroupsResponseResult.getResources());
        accountGroupsList.addAll(listAccountGroupsResponseResult.getResources());

        nextDocId = UrlHelper.getQueryParam(listAccountGroupsResponseResult.getNextUrl(), "next_docid");
      } while (nextDocId != null);

      AccountGroup accountGroupResultFirst = accountGroupsList
          .stream()
          .filter(ac -> ac.getId().equals(firstExampleAccountGroupId))
          .findAny()
          .orElse(null);
      assertNotNull(accountGroupResultFirst);
      AccountGroup accountGroupResultSecond = accountGroupsList
          .stream()
          .filter(ac -> ac.getId().equals(secondExampleAccountGroupId))
          .findAny()
          .orElse(null);
      assertNotNull(accountGroupResultSecond);

      log(String.format("Received a total of %d account groups.%n", accountGroupsList.size()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccountGroup"})
  public void testGetAccountGroup() throws Exception {
    try {
      GetAccountGroupOptions getAccountGroupOptions = new GetAccountGroupOptions.Builder()
          .accountGroupId(firstExampleAccountGroupId)
          .build();

      // Invoke operation
      Response<AccountGroup> response = service
          .getAccountGroup(getAccountGroupOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      AccountGroup accountGroupResult = response.getResult();
      assertNotNull(accountGroupResult);
      assertEquals(accountGroupResult.getId(), firstExampleAccountGroupId);

    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccountGroup"})
  public void testUpdateAccountGroup() throws Exception {
    try {
      UpdateAccountGroupOptions updateAccountGroupOptions = new UpdateAccountGroupOptions.Builder()
          .accountGroupId(firstExampleAccountGroupId)
          .name(updatedFirstExampleAccountGroupName)
          .primaryContactIamId(accountIamId)
          .build();

      // Invoke operation
      Response<Void> response = service
          .updateAccountGroup(updateAccountGroupOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccountGroup"})
  public void testCreateAccount() throws Exception {
    try {
      CreateAccountOptions createAccountOptions = new CreateAccountOptions.Builder()
          .parent(String.format(createAccountCrn, accountId, firstExampleAccountGroupId))
          .name(exampleAccountName)
          .ownerIamId(accountIamId)
          .build();

      // Invoke operation
      Response<CreateAccountResponse> response = service
          .createAccount(createAccountOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);

      CreateAccountResponse createAccountResponseResult = response.getResult();
      assertNotNull(createAccountResponseResult);
      exampleAccountId = createAccountResponseResult.getAccountId();
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccount", "testCreateAccountGroup"})
  public void testListAccounts() throws Exception {
    try {

      List<Account> listAccounts = new ArrayList<>();
      Integer limit = 1;
      String nextDocId = null;

      do {
        ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
            .accountGroupId(firstExampleAccountGroupId)
            .limit(limit)
            .nextDocid(nextDocId)
            .build();

        // Invoke operation
        Response<ListAccountsResponse> response = service
            .listAccounts(listAccountsOptions)
            .execute();
        // Validate response
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ListAccountsResponse listAccountsResponseResult = response.getResult();
        listAccounts.addAll(listAccountsResponseResult.getResources());
        assertNotNull(listAccountsResponseResult);
        nextDocId = UrlHelper.getQueryParam(listAccountsResponseResult.getNextUrl(), "next_docid");

      } while (nextDocId != null);

      Account accountResult = listAccounts
          .stream()
          .filter(account -> account.getId().equals(exampleAccountId))
          .findAny()
          .orElse(null);
      assertNotNull(accountResult);

      log(String.format("Received a total of %d accounts.%n", listAccounts.size()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccount"})
  public void testGetAccount() throws Exception {
    try {
      GetAccountOptions getAccountOptions = new GetAccountOptions.Builder()
          .accountId(exampleAccountId)
          .build();

      // Invoke operation
      Response<Account> response = service
          .getAccount(getAccountOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Account accountResult = response.getResult();
      assertNotNull(accountResult);
      assertEquals(accountResult.getId(), exampleAccountId);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccount", "testCreateAnotherAccountGroup"})
  public void testUpdateAccount() throws Exception {
    try {
      UpdateAccountOptions updateAccountOptions = new UpdateAccountOptions.Builder()
          .accountId(exampleAccountId)
          .parent(String.format(createAccountCrn, accountId, secondExampleAccountGroupId))
          .build();

      // Invoke operation
      Response<Void> response = service
          .updateAccount(updateAccountOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 202);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListEnterprises() throws Exception {
    try {
      List<Enterprise> enterpriseList = new ArrayList<>();
      Integer limit = 1;
      String nextDocId = null;

      do {
        ListEnterprisesOptions listEnterprisesOptions = new ListEnterprisesOptions.Builder()
            .accountId(accountId)
            .limit(limit)
            .nextDocid(nextDocId)
            .build();

        // Invoke operation
        Response<ListEnterprisesResponse> response = service
            .listEnterprises(listEnterprisesOptions)
            .execute();
        // Validate response
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);

        ListEnterprisesResponse listEnterprisesResponseResult = response.getResult();
        assertNotNull(listEnterprisesResponseResult);

        nextDocId = UrlHelper.getQueryParam(listEnterprisesResponseResult.getNextUrl(), "next_docid");
        enterpriseList.addAll(listEnterprisesResponseResult.getResources());
      } while (nextDocId != null);

      Enterprise enterpriseResult = enterpriseList
          .stream()
          .filter(e -> e.getId().equals(enterpriseId))
          .findAny()
          .orElse(null);
      assertNotNull(enterpriseResult);

      log(String.format("Received a total of %d enterprises.%n", enterpriseList.size()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testGetEnterprise() throws Exception {
    try {
      GetEnterpriseOptions getEnterpriseOptions = new GetEnterpriseOptions.Builder()
          .enterpriseId(enterpriseId)
          .build();

      // Invoke operation
      Response<Enterprise> response = service
          .getEnterprise(getEnterpriseOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      Enterprise enterpriseResult = response.getResult();

      assertNotNull(enterpriseResult);
      assertEquals(enterpriseResult.getId(), enterpriseId);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testUpdateEnterprise() throws Exception {
    try {
      UpdateEnterpriseOptions updateEnterpriseOptions = new UpdateEnterpriseOptions.Builder()
          .enterpriseId(enterpriseId)
          .name(updatedExampleEnterpriseName)
          .primaryContactIamId(accountIamId)
          .build();

      // Invoke operation
      Response<Void> response = service
          .updateEnterprise(updateEnterpriseOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 204);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }

}
