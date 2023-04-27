/*
 * (C) Copyright IBM Corp. 2023.
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
import com.ibm.cloud.platform_services.enterprise_management.v1.model.Account;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountGroup;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountGroupsPager;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountsPager;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountRequestTraits;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.DeleteAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.DeleteAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.Enterprise;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.EnterprisesPager;
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
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the EnterpriseManagement service.
 */
public class EnterpriseManagementTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected EnterpriseManagement enterpriseManagementService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new EnterpriseManagement(serviceName, null);
  }

  // Test the createEnterprise operation with a valid options model parameter
  @Test
  public void testCreateEnterpriseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"enterprise_id\": \"enterpriseId\", \"enterprise_account_id\": \"enterpriseAccountId\"}";
    String createEnterprisePath = "/enterprises";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateEnterpriseOptions model
    CreateEnterpriseOptions createEnterpriseOptionsModel = new CreateEnterpriseOptions.Builder()
      .sourceAccountId("testString")
      .name("testString")
      .primaryContactIamId("testString")
      .domain("testString")
      .build();

    // Invoke createEnterprise() with a valid options model and verify the result
    Response<CreateEnterpriseResponse> response = enterpriseManagementService.createEnterprise(createEnterpriseOptionsModel).execute();
    assertNotNull(response);
    CreateEnterpriseResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createEnterprisePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createEnterprise operation with and without retries enabled
  @Test
  public void testCreateEnterpriseWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testCreateEnterpriseWOptions();

    enterpriseManagementService.disableRetries();
    testCreateEnterpriseWOptions();
  }

  // Test the createEnterprise operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateEnterpriseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.createEnterprise(null).execute();
  }

  // Test the listEnterprises operation with a valid options model parameter
  @Test
  public void testListEnterprisesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"url\": \"url\", \"id\": \"id\", \"enterprise_account_id\": \"enterpriseAccountId\", \"crn\": \"crn\", \"name\": \"name\", \"domain\": \"domain\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}]}";
    String listEnterprisesPath = "/enterprises";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListEnterprisesOptions model
    ListEnterprisesOptions listEnterprisesOptionsModel = new ListEnterprisesOptions.Builder()
      .enterpriseAccountId("testString")
      .accountGroupId("testString")
      .accountId("testString")
      .nextDocid("testString")
      .limit(Long.valueOf("10"))
      .build();

    // Invoke listEnterprises() with a valid options model and verify the result
    Response<ListEnterprisesResponse> response = enterpriseManagementService.listEnterprises(listEnterprisesOptionsModel).execute();
    assertNotNull(response);
    ListEnterprisesResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listEnterprisesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("enterprise_account_id"), "testString");
    assertEquals(query.get("account_group_id"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("next_docid"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
  }

  // Test the listEnterprises operation with and without retries enabled
  @Test
  public void testListEnterprisesWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testListEnterprisesWOptions();

    enterpriseManagementService.disableRetries();
    testListEnterprisesWOptions();
  }

  // Test the listEnterprises operation using the EnterprisesPager.getNext() method
  @Test
  public void testListEnterprisesWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?next_docid=1\",\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"enterprise_account_id\":\"enterpriseAccountId\",\"crn\":\"crn\",\"name\":\"name\",\"domain\":\"domain\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"enterprise_account_id\":\"enterpriseAccountId\",\"crn\":\"crn\",\"name\":\"name\",\"domain\":\"domain\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListEnterprisesOptions listEnterprisesOptions = new ListEnterprisesOptions.Builder()
      .enterpriseAccountId("testString")
      .accountGroupId("testString")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .build();

    List<Enterprise> allResults = new ArrayList<>();
    EnterprisesPager pager = new EnterprisesPager(enterpriseManagementService, listEnterprisesOptions);
    while (pager.hasNext()) {
      List<Enterprise> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listEnterprises operation using the EnterprisesPager.getAll() method
  @Test
  public void testListEnterprisesWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?next_docid=1\",\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"enterprise_account_id\":\"enterpriseAccountId\",\"crn\":\"crn\",\"name\":\"name\",\"domain\":\"domain\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"enterprise_account_id\":\"enterpriseAccountId\",\"crn\":\"crn\",\"name\":\"name\",\"domain\":\"domain\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListEnterprisesOptions listEnterprisesOptions = new ListEnterprisesOptions.Builder()
      .enterpriseAccountId("testString")
      .accountGroupId("testString")
      .accountId("testString")
      .limit(Long.valueOf("10"))
      .build();

    EnterprisesPager pager = new EnterprisesPager(enterpriseManagementService, listEnterprisesOptions);
    List<Enterprise> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getEnterprise operation with a valid options model parameter
  @Test
  public void testGetEnterpriseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"url\": \"url\", \"id\": \"id\", \"enterprise_account_id\": \"enterpriseAccountId\", \"crn\": \"crn\", \"name\": \"name\", \"domain\": \"domain\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}";
    String getEnterprisePath = "/enterprises/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetEnterpriseOptions model
    GetEnterpriseOptions getEnterpriseOptionsModel = new GetEnterpriseOptions.Builder()
      .enterpriseId("testString")
      .build();

    // Invoke getEnterprise() with a valid options model and verify the result
    Response<Enterprise> response = enterpriseManagementService.getEnterprise(getEnterpriseOptionsModel).execute();
    assertNotNull(response);
    Enterprise responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getEnterprisePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getEnterprise operation with and without retries enabled
  @Test
  public void testGetEnterpriseWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testGetEnterpriseWOptions();

    enterpriseManagementService.disableRetries();
    testGetEnterpriseWOptions();
  }

  // Test the getEnterprise operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetEnterpriseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.getEnterprise(null).execute();
  }

  // Test the updateEnterprise operation with a valid options model parameter
  @Test
  public void testUpdateEnterpriseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateEnterprisePath = "/enterprises/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateEnterpriseOptions model
    UpdateEnterpriseOptions updateEnterpriseOptionsModel = new UpdateEnterpriseOptions.Builder()
      .enterpriseId("testString")
      .name("testString")
      .domain("testString")
      .primaryContactIamId("testString")
      .build();

    // Invoke updateEnterprise() with a valid options model and verify the result
    Response<Void> response = enterpriseManagementService.updateEnterprise(updateEnterpriseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateEnterprisePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateEnterprise operation with and without retries enabled
  @Test
  public void testUpdateEnterpriseWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testUpdateEnterpriseWOptions();

    enterpriseManagementService.disableRetries();
    testUpdateEnterpriseWOptions();
  }

  // Test the updateEnterprise operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateEnterpriseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.updateEnterprise(null).execute();
  }

  // Test the importAccountToEnterprise operation with a valid options model parameter
  @Test
  public void testImportAccountToEnterpriseWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String importAccountToEnterprisePath = "/enterprises/testString/import/accounts/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the ImportAccountToEnterpriseOptions model
    ImportAccountToEnterpriseOptions importAccountToEnterpriseOptionsModel = new ImportAccountToEnterpriseOptions.Builder()
      .enterpriseId("testString")
      .accountId("testString")
      .parent("testString")
      .billingUnitId("testString")
      .build();

    // Invoke importAccountToEnterprise() with a valid options model and verify the result
    Response<Void> response = enterpriseManagementService.importAccountToEnterprise(importAccountToEnterpriseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importAccountToEnterprisePath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the importAccountToEnterprise operation with and without retries enabled
  @Test
  public void testImportAccountToEnterpriseWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testImportAccountToEnterpriseWOptions();

    enterpriseManagementService.disableRetries();
    testImportAccountToEnterpriseWOptions();
  }

  // Test the importAccountToEnterprise operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportAccountToEnterpriseNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.importAccountToEnterprise(null).execute();
  }

  // Test the createAccount operation with a valid options model parameter
  @Test
  public void testCreateAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_id\": \"accountId\"}";
    String createAccountPath = "/accounts";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateAccountRequestTraits model
    CreateAccountRequestTraits createAccountRequestTraitsModel = new CreateAccountRequestTraits.Builder()
      .mfa("testString")
      .build();

    // Construct an instance of the CreateAccountOptions model
    CreateAccountOptions createAccountOptionsModel = new CreateAccountOptions.Builder()
      .parent("testString")
      .name("testString")
      .ownerIamId("testString")
      .traits(createAccountRequestTraitsModel)
      .build();

    // Invoke createAccount() with a valid options model and verify the result
    Response<CreateAccountResponse> response = enterpriseManagementService.createAccount(createAccountOptionsModel).execute();
    assertNotNull(response);
    CreateAccountResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAccount operation with and without retries enabled
  @Test
  public void testCreateAccountWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testCreateAccountWOptions();

    enterpriseManagementService.disableRetries();
    testCreateAccountWOptions();
  }

  // Test the createAccount operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.createAccount(null).execute();
  }

  // Test the listAccounts operation with a valid options model parameter
  @Test
  public void testListAccountsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"owner_iam_id\": \"ownerIamId\", \"paid\": true, \"owner_email\": \"ownerEmail\", \"is_enterprise_account\": false, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}]}";
    String listAccountsPath = "/accounts";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccountsOptions model
    ListAccountsOptions listAccountsOptionsModel = new ListAccountsOptions.Builder()
      .enterpriseId("testString")
      .accountGroupId("testString")
      .nextDocid("testString")
      .parent("testString")
      .limit(Long.valueOf("10"))
      .includeDeleted(true)
      .build();

    // Invoke listAccounts() with a valid options model and verify the result
    Response<ListAccountsResponse> response = enterpriseManagementService.listAccounts(listAccountsOptionsModel).execute();
    assertNotNull(response);
    ListAccountsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccountsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("enterprise_id"), "testString");
    assertEquals(query.get("account_group_id"), "testString");
    assertEquals(query.get("next_docid"), "testString");
    assertEquals(query.get("parent"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Boolean.valueOf(query.get("include_deleted")), Boolean.valueOf(true));
  }

  // Test the listAccounts operation with and without retries enabled
  @Test
  public void testListAccountsWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testListAccountsWOptions();

    enterpriseManagementService.disableRetries();
    testListAccountsWOptions();
  }

  // Test the listAccounts operation using the AccountsPager.getNext() method
  @Test
  public void testListAccountsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?next_docid=1\",\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"owner_iam_id\":\"ownerIamId\",\"paid\":true,\"owner_email\":\"ownerEmail\",\"is_enterprise_account\":false,\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"owner_iam_id\":\"ownerIamId\",\"paid\":true,\"owner_email\":\"ownerEmail\",\"is_enterprise_account\":false,\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
      .enterpriseId("testString")
      .accountGroupId("testString")
      .parent("testString")
      .limit(Long.valueOf("10"))
      .includeDeleted(true)
      .build();

    List<Account> allResults = new ArrayList<>();
    AccountsPager pager = new AccountsPager(enterpriseManagementService, listAccountsOptions);
    while (pager.hasNext()) {
      List<Account> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listAccounts operation using the AccountsPager.getAll() method
  @Test
  public void testListAccountsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?next_docid=1\",\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"owner_iam_id\":\"ownerIamId\",\"paid\":true,\"owner_email\":\"ownerEmail\",\"is_enterprise_account\":false,\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"owner_iam_id\":\"ownerIamId\",\"paid\":true,\"owner_email\":\"ownerEmail\",\"is_enterprise_account\":false,\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
      .enterpriseId("testString")
      .accountGroupId("testString")
      .parent("testString")
      .limit(Long.valueOf("10"))
      .includeDeleted(true)
      .build();

    AccountsPager pager = new AccountsPager(enterpriseManagementService, listAccountsOptions);
    List<Account> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getAccount operation with a valid options model parameter
  @Test
  public void testGetAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"owner_iam_id\": \"ownerIamId\", \"paid\": true, \"owner_email\": \"ownerEmail\", \"is_enterprise_account\": false, \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}";
    String getAccountPath = "/accounts/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountOptions model
    GetAccountOptions getAccountOptionsModel = new GetAccountOptions.Builder()
      .accountId("testString")
      .build();

    // Invoke getAccount() with a valid options model and verify the result
    Response<Account> response = enterpriseManagementService.getAccount(getAccountOptionsModel).execute();
    assertNotNull(response);
    Account responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAccount operation with and without retries enabled
  @Test
  public void testGetAccountWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testGetAccountWOptions();

    enterpriseManagementService.disableRetries();
    testGetAccountWOptions();
  }

  // Test the getAccount operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.getAccount(null).execute();
  }

  // Test the updateAccount operation with a valid options model parameter
  @Test
  public void testUpdateAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateAccountPath = "/accounts/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(202)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateAccountOptions model
    UpdateAccountOptions updateAccountOptionsModel = new UpdateAccountOptions.Builder()
      .accountId("testString")
      .parent("testString")
      .build();

    // Invoke updateAccount() with a valid options model and verify the result
    Response<Void> response = enterpriseManagementService.updateAccount(updateAccountOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAccount operation with and without retries enabled
  @Test
  public void testUpdateAccountWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testUpdateAccountWOptions();

    enterpriseManagementService.disableRetries();
    testUpdateAccountWOptions();
  }

  // Test the updateAccount operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.updateAccount(null).execute();
  }

  // Test the deleteAccount operation with a valid options model parameter
  @Test
  public void testDeleteAccountWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAccountPath = "/accounts/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAccountOptions model
    DeleteAccountOptions deleteAccountOptionsModel = new DeleteAccountOptions.Builder()
      .accountId("testString")
      .build();

    // Invoke deleteAccount() with a valid options model and verify the result
    Response<Void> response = enterpriseManagementService.deleteAccount(deleteAccountOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAccountPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAccount operation with and without retries enabled
  @Test
  public void testDeleteAccountWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testDeleteAccountWOptions();

    enterpriseManagementService.disableRetries();
    testDeleteAccountWOptions();
  }

  // Test the deleteAccount operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAccountNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.deleteAccount(null).execute();
  }

  // Test the createAccountGroup operation with a valid options model parameter
  @Test
  public void testCreateAccountGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"account_group_id\": \"accountGroupId\"}";
    String createAccountGroupPath = "/account-groups";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the CreateAccountGroupOptions model
    CreateAccountGroupOptions createAccountGroupOptionsModel = new CreateAccountGroupOptions.Builder()
      .parent("testString")
      .name("testString")
      .primaryContactIamId("testString")
      .build();

    // Invoke createAccountGroup() with a valid options model and verify the result
    Response<CreateAccountGroupResponse> response = enterpriseManagementService.createAccountGroup(createAccountGroupOptionsModel).execute();
    assertNotNull(response);
    CreateAccountGroupResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createAccountGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the createAccountGroup operation with and without retries enabled
  @Test
  public void testCreateAccountGroupWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testCreateAccountGroupWOptions();

    enterpriseManagementService.disableRetries();
    testCreateAccountGroupWOptions();
  }

  // Test the createAccountGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.createAccountGroup(null).execute();
  }

  // Test the listAccountGroups operation with a valid options model parameter
  @Test
  public void testListAccountGroupsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"rows_count\": 9, \"next_url\": \"nextUrl\", \"resources\": [{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}]}";
    String listAccountGroupsPath = "/account-groups";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListAccountGroupsOptions model
    ListAccountGroupsOptions listAccountGroupsOptionsModel = new ListAccountGroupsOptions.Builder()
      .enterpriseId("testString")
      .parentAccountGroupId("testString")
      .nextDocid("testString")
      .parent("testString")
      .limit(Long.valueOf("10"))
      .includeDeleted(true)
      .build();

    // Invoke listAccountGroups() with a valid options model and verify the result
    Response<ListAccountGroupsResponse> response = enterpriseManagementService.listAccountGroups(listAccountGroupsOptionsModel).execute();
    assertNotNull(response);
    ListAccountGroupsResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listAccountGroupsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("enterprise_id"), "testString");
    assertEquals(query.get("parent_account_group_id"), "testString");
    assertEquals(query.get("next_docid"), "testString");
    assertEquals(query.get("parent"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("10"));
    assertEquals(Boolean.valueOf(query.get("include_deleted")), Boolean.valueOf(true));
  }

  // Test the listAccountGroups operation with and without retries enabled
  @Test
  public void testListAccountGroupsWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testListAccountGroupsWOptions();

    enterpriseManagementService.disableRetries();
    testListAccountGroupsWOptions();
  }

  // Test the listAccountGroups operation using the AccountGroupsPager.getNext() method
  @Test
  public void testListAccountGroupsWithPagerGetNext() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?next_docid=1\",\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
      .enterpriseId("testString")
      .parentAccountGroupId("testString")
      .parent("testString")
      .limit(Long.valueOf("10"))
      .includeDeleted(true)
      .build();

    List<AccountGroup> allResults = new ArrayList<>();
    AccountGroupsPager pager = new AccountGroupsPager(enterpriseManagementService, listAccountGroupsOptions);
    while (pager.hasNext()) {
      List<AccountGroup> nextPage = pager.getNext();
      assertNotNull(nextPage);
      allResults.addAll(nextPage);
    }
    assertEquals(allResults.size(), 2);
  }
  
  // Test the listAccountGroups operation using the AccountGroupsPager.getAll() method
  @Test
  public void testListAccountGroupsWithPagerGetAll() throws Throwable {
    // Set up the two-page mock response.
    String mockResponsePage1 = "{\"total_count\":2,\"limit\":1,\"next_url\":\"https://myhost.com/somePath?next_docid=1\",\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    String mockResponsePage2 = "{\"total_count\":2,\"limit\":1,\"resources\":[{\"url\":\"url\",\"id\":\"id\",\"crn\":\"crn\",\"parent\":\"parent\",\"enterprise_account_id\":\"enterpriseAccountId\",\"enterprise_id\":\"enterpriseId\",\"enterprise_path\":\"enterprisePath\",\"name\":\"name\",\"state\":\"state\",\"primary_contact_iam_id\":\"primaryContactIamId\",\"primary_contact_email\":\"primaryContactEmail\",\"created_at\":\"2019-01-01T12:00:00.000Z\",\"created_by\":\"createdBy\",\"updated_at\":\"2019-01-01T12:00:00.000Z\",\"updated_by\":\"updatedBy\"}]}";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage1));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponsePage2));
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(400)
      .setBody("{\"message\": \"No more results available!\"}"));

    ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder()
      .enterpriseId("testString")
      .parentAccountGroupId("testString")
      .parent("testString")
      .limit(Long.valueOf("10"))
      .includeDeleted(true)
      .build();

    AccountGroupsPager pager = new AccountGroupsPager(enterpriseManagementService, listAccountGroupsOptions);
    List<AccountGroup> allResults = pager.getAll();
    assertNotNull(allResults);
    assertEquals(allResults.size(), 2);
  }
  
  // Test the getAccountGroup operation with a valid options model parameter
  @Test
  public void testGetAccountGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"url\": \"url\", \"id\": \"id\", \"crn\": \"crn\", \"parent\": \"parent\", \"enterprise_account_id\": \"enterpriseAccountId\", \"enterprise_id\": \"enterpriseId\", \"enterprise_path\": \"enterprisePath\", \"name\": \"name\", \"state\": \"state\", \"primary_contact_iam_id\": \"primaryContactIamId\", \"primary_contact_email\": \"primaryContactEmail\", \"created_at\": \"2019-01-01T12:00:00.000Z\", \"created_by\": \"createdBy\", \"updated_at\": \"2019-01-01T12:00:00.000Z\", \"updated_by\": \"updatedBy\"}";
    String getAccountGroupPath = "/account-groups/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAccountGroupOptions model
    GetAccountGroupOptions getAccountGroupOptionsModel = new GetAccountGroupOptions.Builder()
      .accountGroupId("testString")
      .build();

    // Invoke getAccountGroup() with a valid options model and verify the result
    Response<AccountGroup> response = enterpriseManagementService.getAccountGroup(getAccountGroupOptionsModel).execute();
    assertNotNull(response);
    AccountGroup responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAccountGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the getAccountGroup operation with and without retries enabled
  @Test
  public void testGetAccountGroupWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testGetAccountGroupWOptions();

    enterpriseManagementService.disableRetries();
    testGetAccountGroupWOptions();
  }

  // Test the getAccountGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.getAccountGroup(null).execute();
  }

  // Test the updateAccountGroup operation with a valid options model parameter
  @Test
  public void testUpdateAccountGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateAccountGroupPath = "/account-groups/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the UpdateAccountGroupOptions model
    UpdateAccountGroupOptions updateAccountGroupOptionsModel = new UpdateAccountGroupOptions.Builder()
      .accountGroupId("testString")
      .name("testString")
      .primaryContactIamId("testString")
      .build();

    // Invoke updateAccountGroup() with a valid options model and verify the result
    Response<Void> response = enterpriseManagementService.updateAccountGroup(updateAccountGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateAccountGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the updateAccountGroup operation with and without retries enabled
  @Test
  public void testUpdateAccountGroupWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testUpdateAccountGroupWOptions();

    enterpriseManagementService.disableRetries();
    testUpdateAccountGroupWOptions();
  }

  // Test the updateAccountGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.updateAccountGroup(null).execute();
  }

  // Test the deleteAccountGroup operation with a valid options model parameter
  @Test
  public void testDeleteAccountGroupWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteAccountGroupPath = "/account-groups/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(204)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteAccountGroupOptions model
    DeleteAccountGroupOptions deleteAccountGroupOptionsModel = new DeleteAccountGroupOptions.Builder()
      .accountGroupId("testString")
      .build();

    // Invoke deleteAccountGroup() with a valid options model and verify the result
    Response<Void> response = enterpriseManagementService.deleteAccountGroup(deleteAccountGroupOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteAccountGroupPath);
    // Verify that there is no query string
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);
  }

  // Test the deleteAccountGroup operation with and without retries enabled
  @Test
  public void testDeleteAccountGroupWRetries() throws Throwable {
    enterpriseManagementService.enableRetries(4, 30);
    testDeleteAccountGroupWOptions();

    enterpriseManagementService.disableRetries();
    testDeleteAccountGroupWOptions();
  }

  // Test the deleteAccountGroup operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteAccountGroupNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    enterpriseManagementService.deleteAccountGroup(null).execute();
  }

  // Perform setup needed before each test method
  @BeforeMethod
  public void beforeEachTest() {
    // Start the mock server.
    try {
      server = new MockWebServer();
      server.start();
    } catch (IOException err) {
      fail("Failed to instantiate mock web server");
    }

    // Construct an instance of the service
    constructClientService();
  }

  // Perform tear down after each test method
  @AfterMethod
  public void afterEachTest() throws IOException {
    server.shutdown();
    enterpriseManagementService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    enterpriseManagementService = EnterpriseManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    enterpriseManagementService.setServiceUrl(url);
  }
}