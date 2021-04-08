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
import com.ibm.cloud.platform_services.enterprise_management.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.io.InputStream;
import java.net.URI;
import java.util.*;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Integration test class for the EnterpriseManagement service.
 */
public class EnterpriseManagementIT extends SdkIntegrationTestBase {

  public EnterpriseManagement service = null;
  public static Map<String, String> config = null;
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  private Random rnd = new Random();

  String authType = null;
  String authUrl = null;
  String apiKey = null;
  String enterpriseId = null;
  String accountId = null;
  String accountIamId = null;
  String firstExampleAccountGroupName = "First Example Account Group Name";
  String updatedFirstExampleAccountGroupName = "Updated First Example Account Group Name";
  String secondExampleAccountGroupName = "Second Example Account Group Name";
  String exampleAccountName = "Example Account Name";
  String exampleAccountId = null;
  String exampleEnterpriseId = null;
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

    authType = config.get("AUTHTYPE");
    assertNotNull(authType);

    authUrl = config.get("AUTH_URL");
    assertNotNull(authUrl);

    apiKey = config.get("APIKEY");
    assertNotNull(apiKey);

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
      String parent = String.format(createAccountGroupCrn, accountId, enterpriseId);
      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
          .parent(parent)
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
      String parent = String.format(createAccountGroupCrn, accountId, enterpriseId);
      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
          .parent(parent)
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

  @Test
  public void testListAccountGroups() throws Exception {
    try {
      ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
          .enterpriseId(enterpriseId)
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

      // at this point we took two account group from the list
      // due to that they needed for later operations in test cases depending on this test case
      firstExampleAccountGroupId = listAccountGroupsResponseResult
          .getResources()
          .get(rnd.nextInt(listAccountGroupsResponseResult
              .getRowsCount()
              .intValue()))
          .getId();
      secondExampleAccountGroupId = listAccountGroupsResponseResult
          .getResources()
          .get(rnd.nextInt(listAccountGroupsResponseResult
              .getRowsCount()
              .intValue()))
          .getId();

    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListAccountGroupsWithPaging() throws Exception {
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

        nextDocId = getNextDocId(listAccountGroupsResponseResult.getNextUrl());
      } while (nextDocId != null);

      log(String.format("Received a total of %d account groups.%n", accountGroupsList.size()));
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testListAccountGroups"})
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
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testListAccountGroups"})
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

  // @Test
  // public void testImportAccountToEnterprise() throws Exception {
  //   try {
  //     ImportAccountToEnterpriseOptions importAccountToEnterpriseOptions = new ImportAccountToEnterpriseOptions
  //     .Builder()
  //     .enterpriseId("testString")
  //     .accountId("testString")
  //     .parent("testString")
  //     .billingUnitId("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<Void> response = service.importAccountToEnterprise(importAccountToEnterpriseOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 202);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s%nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  @Test(dependsOnMethods = {"testListAccountGroups"})
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

  @Test
  public void testListAccounts() throws Exception {
    try {
      ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
          .enterpriseId(enterpriseId)
          .build();

      // Invoke operation
      Response<ListAccountsResponse> response = service
          .listAccounts(listAccountsOptions)
          .execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ListAccountsResponse listAccountsResponseResult = response.getResult();

      assertNotNull(listAccountsResponseResult);
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListAccountsWithPaging() throws Exception {
    try {

      List<Account> listAccounts = new ArrayList<>();
      Integer limit = 1;
      String nextDocId = null;

      do {
        ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
            .enterpriseId(enterpriseId)
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
        nextDocId = getNextDocId(listAccountsResponseResult.getNextUrl());

      } while (nextDocId != null);
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
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test(dependsOnMethods = {"testCreateAccount", "testListAccountGroups"})
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

  // @Test
  // public void testCreateEnterprise() throws Exception {
  //   try {
  //     CreateEnterpriseOptions createEnterpriseOptions = new CreateEnterpriseOptions.Builder()
  //     .sourceAccountId("testString")
  //     .name("testString")
  //     .primaryContactIamId("testString")
  //     .domain("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<CreateEnterpriseResponse> response = service.createEnterprise(createEnterpriseOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 202);
  //
  //     CreateEnterpriseResponse createEnterpriseResponseResult = response.getResult();
  //
  //     assertNotNull(createEnterpriseResponseResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s%nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  @Test
  public void testListEnterprises() throws Exception {
    try {
      ListEnterprisesOptions listEnterprisesOptions = new ListEnterprisesOptions.Builder()
          .accountId(accountId)
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
    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s%nError details: %s", e.getStatusCode(), e.getMessage(),
          e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListEnterprisesWithPaging() throws Exception {
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

        nextDocId = getNextDocId(listEnterprisesResponseResult.getNextUrl());
        enterpriseList.addAll(listEnterprisesResponseResult.getResources());

        log(String.format("Received a total of %d enterprises.%n", enterpriseList.size()));
      } while (nextDocId != null);
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

  private String getNextDocId(String s) {
    try {
      if (s == null) {
        return null;
      }

      // Parse "s" as a URI and retrieve its decoded query string.
      URI uri = new URI(s);
      String query = uri.getQuery();
      if (query == null || query.isEmpty()) {
        return null;
      }

      // Parse the query string into a map of key/value pairs.
      Map<String, String> params = new LinkedHashMap<>();
      for (String param : query.split("&")) {
        String[] keyValue = param.split("=", 2);
        String value = keyValue.length > 1 ? keyValue[1] : null;
        if (!keyValue[0].isEmpty()) {
          params.put(keyValue[0], value);
        }
      }

      return params.get("next_docid");
    } catch (Throwable t) {

    }

    return null;
  }

}
