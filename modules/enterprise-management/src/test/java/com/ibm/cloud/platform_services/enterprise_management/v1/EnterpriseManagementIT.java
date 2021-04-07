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
import com.ibm.cloud.platform_services.enterprise_management.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  String authType = null;
  String authUrl = null;
  String apiKey = null;
  String enterpriseId = null;
  String accountId = null;
  String accountIamId = null;
  String exampleAccountGroupName = "Example Account Group Name";
  String createdAccountGroupId = null;

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
      String parent = String.format("crn:v1:bluemix:public:enterprise::a/%s::enterprise:%s",
              accountId,
              enterpriseId);
      CreateAccountGroupOptions createAccountGroupOptions = new CreateAccountGroupOptions.Builder()
      .parent(parent)
      .name(exampleAccountGroupName)
      .primaryContactIamId(accountIamId)
      .build();

      // Invoke operation
      Response<CreateAccountGroupResponse> response = service.createAccountGroup(createAccountGroupOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 201);

      CreateAccountGroupResponse createAccountGroupResponseResult = response.getResult();
      assertNotNull(createAccountGroupResponseResult);

      createdAccountGroupId = createAccountGroupResponseResult.getAccountGroupId();
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListAccountGroups() throws Exception {
    try {
      ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
      .enterpriseId(enterpriseId)
      .build();

      // Invoke operation
      Response<ListAccountGroupsResponse> response = service.listAccountGroups(listAccountGroupsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ListAccountGroupsResponse listAccountGroupsResponseResult = response.getResult();

      assertNotNull(listAccountGroupsResponseResult);
      System.out.println(listAccountGroupsResponseResult);
    } catch (ServiceResponseException e) {
        fail(String.format("Service returned status code %d: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  @Test
  public void testListAccountGroupsWithPaging() throws Exception{
    try {
      ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
              .enterpriseId(enterpriseId)
              .limit(1)
              .build();

      // Invoke operation
      Response<ListAccountGroupsResponse> response = service.listAccountGroups(listAccountGroupsOptions).execute();
      // Validate response
      assertNotNull(response);
      assertEquals(response.getStatusCode(), 200);

      ListAccountGroupsResponse listAccountGroupsResponseResult = response.getResult();

      assertNotNull(listAccountGroupsResponseResult);
      assertEquals(listAccountGroupsResponseResult.getResources().size(), 1);
      System.out.println("First page: " + listAccountGroupsResponseResult);
      System.out.println("nextdocid: " + listAccountGroupsOptions.nextDocid());

      ListAccountGroupsOptions listAccountGroupsOptionsPage2 = new ListAccountGroupsOptions.Builder()
              .nextDocid(listAccountGroupsOptions.nextDocid())
              .limit(1)
              .build();
      Response<ListAccountGroupsResponse> responsePage2 = service.listAccountGroups(listAccountGroupsOptionsPage2)
              .execute();
      assertNotNull(responsePage2);
      assertEquals(responsePage2.getStatusCode(), 200);

      ListAccountGroupsResponse listAccountGroupsResponsePage2 = responsePage2.getResult();
      assertNotNull(listAccountGroupsResponsePage2);
      assertEquals(listAccountGroupsResponsePage2.getResources().size(), 1);
      System.out.println("Second page: " + listAccountGroupsResponsePage2);

    } catch (ServiceResponseException e) {
      fail(String.format("Service returned status code %d: %s\nError details: %s",
              e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
    }
  }

  // @Test(dependsOnMethods = { "testCreateAccountGroup" }, alwaysRun = true)
  // public void testGetAccountGroup() throws Exception {
  //   try {
  //     GetAccountGroupOptions getAccountGroupOptions = new GetAccountGroupOptions.Builder()
  //     .accountGroupId(createdAccountGroupId)
  //     .build();
  //
  //     // Invoke operation
  //     Response<AccountGroup> response = service.getAccountGroup(getAccountGroupOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 200);
  //
  //     AccountGroup accountGroupResult = response.getResult();
  //
  //     assertNotNull(accountGroupResult);
  //     System.out.println(accountGroupResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testUpdateAccountGroup() throws Exception {
  //   try {
  //     UpdateAccountGroupOptions updateAccountGroupOptions = new UpdateAccountGroupOptions.Builder()
  //     .accountGroupId("testString")
  //     .name("testString")
  //     .primaryContactIamId("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<Void> response = service.updateAccountGroup(updateAccountGroupOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 204);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testImportAccountToEnterprise() throws Exception {
  //   try {
  //     ImportAccountToEnterpriseOptions importAccountToEnterpriseOptions = new ImportAccountToEnterpriseOptions.Builder()
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
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testCreateAccount() throws Exception {
  //   try {
  //     CreateAccountOptions createAccountOptions = new CreateAccountOptions.Builder()
  //     .parent("testString")
  //     .name("testString")
  //     .ownerIamId("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<CreateAccountResponse> response = service.createAccount(createAccountOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 201);
  //
  //     CreateAccountResponse createAccountResponseResult = response.getResult();
  //
  //     assertNotNull(createAccountResponseResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testListAccounts() throws Exception {
  //   try {
  //     ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
  //     .enterpriseId("testString")
  //     .accountGroupId("testString")
  //     .nextDocid("testString")
  //     .parent("testString")
  //     .limit(Long.valueOf("26"))
  //     .build();
  //
  //     // Invoke operation
  //     Response<ListAccountsResponse> response = service.listAccounts(listAccountsOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 200);
  //
  //     ListAccountsResponse listAccountsResponseResult = response.getResult();
  //
  //     assertNotNull(listAccountsResponseResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testGetAccount() throws Exception {
  //   try {
  //     GetAccountOptions getAccountOptions = new GetAccountOptions.Builder()
  //     .accountId("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<Account> response = service.getAccount(getAccountOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 200);
  //
  //     Account accountResult = response.getResult();
  //
  //     assertNotNull(accountResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testUpdateAccount() throws Exception {
  //   try {
  //     UpdateAccountOptions updateAccountOptions = new UpdateAccountOptions.Builder()
  //     .accountId("testString")
  //     .parent("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<Void> response = service.updateAccount(updateAccountOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 204);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
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
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testListEnterprises() throws Exception {
  //   try {
  //     ListEnterprisesOptions listEnterprisesOptions = new ListEnterprisesOptions.Builder()
  //     .accountId(accountId)
  //     .build();
  //
  //     // Invoke operation
  //     Response<ListEnterprisesResponse> response = service.listEnterprises(listEnterprisesOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 200);
  //
  //     ListEnterprisesResponse listEnterprisesResponseResult = response.getResult();
  //
  //     assertNotNull(listEnterprisesResponseResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testGetEnterprise() throws Exception {
  //   try {
  //     GetEnterpriseOptions getEnterpriseOptions = new GetEnterpriseOptions.Builder()
  //     .enterpriseId("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<Enterprise> response = service.getEnterprise(getEnterpriseOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 200);
  //
  //     Enterprise enterpriseResult = response.getResult();
  //
  //     assertNotNull(enterpriseResult);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }
  //
  // @Test
  // public void testUpdateEnterprise() throws Exception {
  //   try {
  //     UpdateEnterpriseOptions updateEnterpriseOptions = new UpdateEnterpriseOptions.Builder()
  //     .enterpriseId("testString")
  //     .name("testString")
  //     .domain("testString")
  //     .primaryContactIamId("testString")
  //     .build();
  //
  //     // Invoke operation
  //     Response<Void> response = service.updateEnterprise(updateEnterpriseOptions).execute();
  //     // Validate response
  //     assertNotNull(response);
  //     assertEquals(response.getStatusCode(), 204);
  //   } catch (ServiceResponseException e) {
  //       fail(String.format("Service returned status code %d: %s\nError details: %s",
  //         e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
  //   }
  // }

  @AfterClass
  public void tearDown() {
    // Add any clean up logic here
    System.out.println("Clean up complete.");
  }
 }
