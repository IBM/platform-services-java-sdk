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

import com.ibm.cloud.platform_services.enterprise_management.v1.EnterpriseManagement;
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
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountGroupsResources;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountGroupsResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountResources;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountsResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListEnterpriseResources;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListEnterprisesOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListEnterprisesResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import com.ibm.cloud.sdk.core.util.EnvironmentUtils;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the EnterpriseManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class EnterpriseManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  protected MockWebServer server;
  protected EnterpriseManagement testService;

  // Creates a mock set of environment variables that are returned by EnvironmentUtils.getenv().
  private Map<String, String> getTestProcessEnvironment() {
    Map<String, String> env = new HashMap<>();
    env.put("TESTSERVICE_AUTH_TYPE", "noAuth");
    return env;
  }

  public void constructClientService() throws Throwable {
    PowerMockito.spy(EnvironmentUtils.class);
    PowerMockito.when(EnvironmentUtils.getenv()).thenReturn(getTestProcessEnvironment());
    final String serviceName = "testService";

    testService = EnterpriseManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new EnterpriseManagement(serviceName, null);
  }

  @Test
  public void testCreateAccountGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_group_id\": \"accountGroupId\"}";
    String createAccountGroupPath = "/account-groups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateAccountGroupOptions model
    CreateAccountGroupOptions createAccountGroupOptionsModel = new CreateAccountGroupOptions.Builder()
    .parent("testString")
    .name("testString")
    .primaryContactIamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateAccountGroupResponse> response = testService.createAccountGroup(createAccountGroupOptionsModel).execute();
    assertNotNull(response);
    CreateAccountGroupResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountGroupPath);
  }

  // Test the createAccountGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createAccountGroup(null).execute();
  }

  @Test
  public void testListAccountGroupsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"createdAt\", \"created_by\": \"createdBy\", \"updated_at\": \"updatedAt\", \"updated_by\": \"updatedBy\"}]}";
    String listAccountGroupsPath = "/account-groups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAccountGroupsOptions model
    ListAccountGroupsOptions listAccountGroupsOptionsModel = new ListAccountGroupsOptions.Builder()
    .enterpriseId("testString")
    .parentAccountGroupId("testString")
    .parent("testString")
    .limit(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListAccountGroupsResponse> response = testService.listAccountGroups(listAccountGroupsOptionsModel).execute();
    assertNotNull(response);
    ListAccountGroupsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("enterprise_id"), "testString");
    assertEquals(query.get("parent_account_group_id"), "testString");
    assertEquals(query.get("parent"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccountGroupsPath);
  }

  @Test
  public void testGetAccountGroupByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"createdAt\", \"created_by\": \"createdBy\", \"updated_at\": \"updatedAt\", \"updated_by\": \"updatedBy\"}";
    String getAccountGroupByIdPath = "/account-groups/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountGroupByIdOptions model
    GetAccountGroupByIdOptions getAccountGroupByIdOptionsModel = new GetAccountGroupByIdOptions.Builder()
    .accountGroupId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountGroupResponse> response = testService.getAccountGroupById(getAccountGroupByIdOptionsModel).execute();
    assertNotNull(response);
    AccountGroupResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountGroupByIdPath);
  }

  // Test the getAccountGroupById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountGroupByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAccountGroupById(null).execute();
  }

  @Test
  public void testUpdateAccountGroupWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateAccountGroupPath = "/account-groups/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateAccountGroupOptions model
    UpdateAccountGroupOptions updateAccountGroupOptionsModel = new UpdateAccountGroupOptions.Builder()
    .accountGroupId("testString")
    .name("testString")
    .primaryContactIamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateAccountGroup(updateAccountGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountGroupPath);
  }

  // Test the updateAccountGroup operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountGroupNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateAccountGroup(null).execute();
  }

  @Test
  public void testGetAccountGroupPermissibleActionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getAccountGroupPermissibleActionsPath = "/account-groups/testString/permissible-actions";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountGroupPermissibleActionsOptions model
    GetAccountGroupPermissibleActionsOptions getAccountGroupPermissibleActionsOptionsModel = new GetAccountGroupPermissibleActionsOptions.Builder()
    .accountGroupId("testString")
    .actions(new ArrayList<String>(Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getAccountGroupPermissibleActions(getAccountGroupPermissibleActionsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountGroupPermissibleActionsPath);
  }

  // Test the getAccountGroupPermissibleActions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountGroupPermissibleActionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAccountGroupPermissibleActions(null).execute();
  }

  @Test
  public void testImportAccountToEnterpriseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String importAccountToEnterprisePath = "/enterprises/testString/import/accounts/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ImportAccountToEnterpriseOptions model
    ImportAccountToEnterpriseOptions importAccountToEnterpriseOptionsModel = new ImportAccountToEnterpriseOptions.Builder()
    .enterpriseId("testString")
    .accountId("testString")
    .parent("testString")
    .billingUnitId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.importAccountToEnterprise(importAccountToEnterpriseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importAccountToEnterprisePath);
  }

  // Test the importAccountToEnterprise operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportAccountToEnterpriseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.importAccountToEnterprise(null).execute();
  }

  @Test
  public void testCreateAccountWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_group_id\": \"accountGroupId\"}";
    String createAccountPath = "/accounts";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateAccountOptions model
    CreateAccountOptions createAccountOptionsModel = new CreateAccountOptions.Builder()
    .parent("testString")
    .name("testString")
    .ownerIamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateAccountResponse> response = testService.createAccount(createAccountOptionsModel).execute();
    assertNotNull(response);
    CreateAccountResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountPath);
  }

  // Test the createAccount operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createAccount(null).execute();
  }

  @Test
  public void testListAccountsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"owner_iam_id\": \"ownerIamId\", \"paid\": true, \"owner_email\": \"ownerEmail\", \"is_enterprise_account\": false, \"created_at\": \"createdAt\", \"created_by\": \"createdBy\", \"updated_at\": \"updatedAt\", \"updated_by\": \"updatedBy\"}]}";
    String listAccountsPath = "/accounts";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListAccountsOptions model
    ListAccountsOptions listAccountsOptionsModel = new ListAccountsOptions.Builder()
    .enterpriseId("testString")
    .accountGroupId("testString")
    .parent("testString")
    .limit(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListAccountsResponse> response = testService.listAccounts(listAccountsOptionsModel).execute();
    assertNotNull(response);
    ListAccountsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("enterprise_id"), "testString");
    assertEquals(query.get("account_group_id"), "testString");
    assertEquals(query.get("parent"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccountsPath);
  }

  @Test
  public void testGetAccountByIdWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"owner_iam_id\": \"ownerIamId\", \"paid\": true, \"owner_email\": \"ownerEmail\", \"is_enterprise_account\": false, \"created_at\": \"createdAt\", \"created_by\": \"createdBy\", \"updated_at\": \"updatedAt\", \"updated_by\": \"updatedBy\"}";
    String getAccountByIdPath = "/accounts/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountByIdOptions model
    GetAccountByIdOptions getAccountByIdOptionsModel = new GetAccountByIdOptions.Builder()
    .accountId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccountResponse> response = testService.getAccountById(getAccountByIdOptionsModel).execute();
    assertNotNull(response);
    AccountResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountByIdPath);
  }

  // Test the getAccountById operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountByIdNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAccountById(null).execute();
  }

  @Test
  public void testUpdateAccountWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateAccountPath = "/accounts/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateAccountOptions model
    UpdateAccountOptions updateAccountOptionsModel = new UpdateAccountOptions.Builder()
    .accountId("testString")
    .parent("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateAccount(updateAccountOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountPath);
  }

  // Test the updateAccount operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateAccount(null).execute();
  }

  @Test
  public void testGetAccountPermissibleActionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getAccountPermissibleActionsPath = "/accounts/testString/permissible-actions";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAccountPermissibleActionsOptions model
    GetAccountPermissibleActionsOptions getAccountPermissibleActionsOptionsModel = new GetAccountPermissibleActionsOptions.Builder()
    .accountId("testString")
    .actions(new ArrayList<String>(Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getAccountPermissibleActions(getAccountPermissibleActionsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountPermissibleActionsPath);
  }

  // Test the getAccountPermissibleActions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountPermissibleActionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAccountPermissibleActions(null).execute();
  }

  @Test
  public void testCreateEnterpriseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"enterprise_id\": \"enterpriseId\", \"enterprise_account_id\": \"enterpriseAccountId\"}";
    String createEnterprisePath = "/enterprises";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateEnterpriseOptions model
    CreateEnterpriseOptions createEnterpriseOptionsModel = new CreateEnterpriseOptions.Builder()
    .sourceAccountId("testString")
    .name("testString")
    .primaryContactIamId("testString")
    .domain("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CreateEnterpriseResponse> response = testService.createEnterprise(createEnterpriseOptionsModel).execute();
    assertNotNull(response);
    CreateEnterpriseResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createEnterprisePath);
  }

  // Test the createEnterprise operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnterpriseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createEnterprise(null).execute();
  }

  @Test
  public void testListEnterprisesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"url\": \"url\", \"id\": \"id\", \"enterprise_account_id\": \"enterpriseAccountId\", \"crn\": \"crn\", \"name\": \"name\", \"domain\": \"domain\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"createdAt\", \"created_by\": \"createdBy\", \"updated_at\": \"updatedAt\", \"updated_by\": \"updatedBy\"}]}";
    String listEnterprisesPath = "/enterprises";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListEnterprisesOptions model
    ListEnterprisesOptions listEnterprisesOptionsModel = new ListEnterprisesOptions.Builder()
    .enterpriseAccountId("testString")
    .accountGroupId("testString")
    .accountId("testString")
    .limit(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ListEnterprisesResponse> response = testService.listEnterprises(listEnterprisesOptionsModel).execute();
    assertNotNull(response);
    ListEnterprisesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("enterprise_account_id"), "testString");
    assertEquals(query.get("account_group_id"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEnterprisesPath);
  }

  @Test
  public void testGetEnterpriseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"url\": \"url\", \"id\": \"id\", \"enterprise_account_id\": \"enterpriseAccountId\", \"crn\": \"crn\", \"name\": \"name\", \"domain\": \"domain\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"createdAt\", \"created_by\": \"createdBy\", \"updated_at\": \"updatedAt\", \"updated_by\": \"updatedBy\"}";
    String getEnterprisePath = "/enterprises/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetEnterpriseOptions model
    GetEnterpriseOptions getEnterpriseOptionsModel = new GetEnterpriseOptions.Builder()
    .enterpriseId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<EnterpriseResponse> response = testService.getEnterprise(getEnterpriseOptionsModel).execute();
    assertNotNull(response);
    EnterpriseResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEnterprisePath);
  }

  // Test the getEnterprise operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnterpriseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getEnterprise(null).execute();
  }

  @Test
  public void testUpdateEnterpriseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateEnterprisePath = "/enterprises/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateEnterpriseOptions model
    UpdateEnterpriseOptions updateEnterpriseOptionsModel = new UpdateEnterpriseOptions.Builder()
    .enterpriseId("testString")
    .name("testString")
    .domain("testString")
    .primaryContactIamId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateEnterprise(updateEnterpriseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEnterprisePath);
  }

  // Test the updateEnterprise operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnterpriseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateEnterprise(null).execute();
  }

  @Test
  public void testGetEnterprisePermissibleActionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getEnterprisePermissibleActionsPath = "/enterprises/testString/permissible-actions";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetEnterprisePermissibleActionsOptions model
    GetEnterprisePermissibleActionsOptions getEnterprisePermissibleActionsOptionsModel = new GetEnterprisePermissibleActionsOptions.Builder()
    .enterpriseId("testString")
    .actions(new ArrayList<String>(Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getEnterprisePermissibleActions(getEnterprisePermissibleActionsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEnterprisePermissibleActionsPath);
  }

  // Test the getEnterprisePermissibleActions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnterprisePermissibleActionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getEnterprisePermissibleActions(null).execute();
  }

  /** Initialize the server */
  @BeforeMethod
  public void setUpMockServer() {
    try {
        server = new MockWebServer();
        // register handler
        server.start();
        }
    catch (IOException err) {
        fail("Failed to instantiate mock web server");
    }
  }

  @AfterMethod
  public void tearDownMockServer() throws IOException {
    server.shutdown();
    testService = null;
  }
}