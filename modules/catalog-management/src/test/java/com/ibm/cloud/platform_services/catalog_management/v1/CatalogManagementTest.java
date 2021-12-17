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
package com.ibm.cloud.platform_services.catalog_management.v1;

import com.ibm.cloud.platform_services.catalog_management.v1.CatalogManagement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccessListBulkResponse;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFiltersCatalogFiltersItem;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFiltersCatalogFiltersItemCatalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AddObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ApprovalResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AuditLog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AuditRecord;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CategoryFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CommitVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Configuration;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CopyVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployRequestBodySchematics;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Deployment;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Feature;
import com.ibm.cloud.platform_services.catalog_management.v1.model.FilterTerms;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Filters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountFiltersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetClusterOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetConsumptionOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessListOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAboutOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAuditOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingContainerImagesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingLicenseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingSourceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingUpdatesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingWorkingCopyOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOverrideValuesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetPreinstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetValidationStatusOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IDFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Image;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImageManifest;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatus;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatusContentMgmt;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatusMetadata;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatusRelease;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.JsonPatchOperation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Kind;
import com.ibm.cloud.platform_services.catalog_management.v1.model.License;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListCatalogsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListObjectsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.MediaItem;
import com.ibm.cloud.platform_services.catalog_management.v1.model.NamespaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccess;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccessListResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectListResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingInstance;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingInstanceLastOperation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OperatorDeployResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Plan;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PreinstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ProviderInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublishObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PutOfferingInstanceOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Rating;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingIconOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.RepoInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Resource;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Script;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchObjectsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SetDeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SharedPublishObjectOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Support;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationAuthorization;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationResource;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingIbmOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ValidateInstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionEntitlement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.NoAuthAuthenticator;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import com.ibm.cloud.sdk.core.util.EnvironmentUtils;
import com.ibm.cloud.sdk.core.util.RequestUtils;
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
 * Unit test class for the CatalogManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore({"javax.net.ssl.*", "org.mockito.*"})
public class CatalogManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected CatalogManagement catalogManagementService;

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

    catalogManagementService = CatalogManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    catalogManagementService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new CatalogManagement(serviceName, null);
  }

  @Test
  public void testGetCatalogAccountWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"hide_IBM_cloud_catalog\": false, \"account_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}}";
    String getCatalogAccountPath = "/catalogaccount";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogAccountOptions model
    GetCatalogAccountOptions getCatalogAccountOptionsModel = new GetCatalogAccountOptions();

    // Invoke operation with valid options model (positive test)
    Response<Account> response = catalogManagementService.getCatalogAccount(getCatalogAccountOptionsModel).execute();
    assertNotNull(response);
    Account responseObj = response.getResult();
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
    assertEquals(parsedPath, getCatalogAccountPath);
  }
  
  public void testGetCatalogAccountWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCatalogAccountWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetCatalogAccountWOptions();

    // Disable retries and run testGetCatalogAccountWOptions.
    catalogManagementService.disableRetries();
    testGetCatalogAccountWOptions();
  }  

  @Test
  public void testUpdateCatalogAccountWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateCatalogAccountPath = "/catalogaccount";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FilterTerms model
    FilterTerms filterTermsModel = new FilterTerms.Builder()
    .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the CategoryFilter model
    CategoryFilter categoryFilterModel = new CategoryFilter.Builder()
    .include(true)
    .filter(filterTermsModel)
    .build();

    // Construct an instance of the IDFilter model
    IDFilter idFilterModel = new IDFilter.Builder()
    .include(filterTermsModel)
    .exclude(filterTermsModel)
    .build();

    // Construct an instance of the Filters model
    Filters filtersModel = new Filters.Builder()
    .includeAll(true)
    .categoryFilters(new java.util.HashMap<String, CategoryFilter>() { { put("foo", categoryFilterModel); } })
    .idFilters(idFilterModel)
    .build();

    // Construct an instance of the UpdateCatalogAccountOptions model
    UpdateCatalogAccountOptions updateCatalogAccountOptionsModel = new UpdateCatalogAccountOptions.Builder()
    .id("testString")
    .hideIbmCloudCatalog(true)
    .accountFilters(filtersModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.updateCatalogAccount(updateCatalogAccountOptionsModel).execute();
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
    assertEquals(parsedPath, updateCatalogAccountPath);
  }
  
  public void testUpdateCatalogAccountWOptionsWRetries() throws Throwable {
    // Enable retries and run testUpdateCatalogAccountWOptions.
    catalogManagementService.enableRetries(4, 30);
    testUpdateCatalogAccountWOptions();

    // Disable retries and run testUpdateCatalogAccountWOptions.
    catalogManagementService.disableRetries();
    testUpdateCatalogAccountWOptions();
  }  

  @Test
  public void testGetCatalogAccountAuditWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"list\": [{\"id\": \"id\", \"created\": \"2019-01-01T12:00:00.000Z\", \"change_type\": \"changeType\", \"target_type\": \"targetType\", \"target_id\": \"targetId\", \"who_delegate_email\": \"whoDelegateEmail\", \"message\": \"message\"}]}";
    String getCatalogAccountAuditPath = "/catalogaccount/audit";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogAccountAuditOptions model
    GetCatalogAccountAuditOptions getCatalogAccountAuditOptionsModel = new GetCatalogAccountAuditOptions();

    // Invoke operation with valid options model (positive test)
    Response<AuditLog> response = catalogManagementService.getCatalogAccountAudit(getCatalogAccountAuditOptionsModel).execute();
    assertNotNull(response);
    AuditLog responseObj = response.getResult();
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
    assertEquals(parsedPath, getCatalogAccountAuditPath);
  }
  
  public void testGetCatalogAccountAuditWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCatalogAccountAuditWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetCatalogAccountAuditWOptions();

    // Disable retries and run testGetCatalogAccountAuditWOptions.
    catalogManagementService.disableRetries();
    testGetCatalogAccountAuditWOptions();
  }  

  @Test
  public void testGetCatalogAccountFiltersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"account_filters\": [{\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}], \"catalog_filters\": [{\"catalog\": {\"id\": \"id\", \"name\": \"name\"}, \"filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}}]}";
    String getCatalogAccountFiltersPath = "/catalogaccount/filters";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogAccountFiltersOptions model
    GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptionsModel = new GetCatalogAccountFiltersOptions.Builder()
    .catalog("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccumulatedFilters> response = catalogManagementService.getCatalogAccountFilters(getCatalogAccountFiltersOptionsModel).execute();
    assertNotNull(response);
    AccumulatedFilters responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("catalog"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCatalogAccountFiltersPath);
  }
  
  public void testGetCatalogAccountFiltersWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCatalogAccountFiltersWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetCatalogAccountFiltersWOptions();

    // Disable retries and run testGetCatalogAccountFiltersWOptions.
    catalogManagementService.disableRetries();
    testGetCatalogAccountFiltersWOptions();
  }  

  @Test
  public void testListCatalogsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_count\": 10, \"resources\": [{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00.000Z\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00.000Z\"}}, \"kind\": \"kind\"}]}";
    String listCatalogsPath = "/catalogs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCatalogsOptions model
    ListCatalogsOptions listCatalogsOptionsModel = new ListCatalogsOptions();

    // Invoke operation with valid options model (positive test)
    Response<CatalogSearchResult> response = catalogManagementService.listCatalogs(listCatalogsOptionsModel).execute();
    assertNotNull(response);
    CatalogSearchResult responseObj = response.getResult();
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
    assertEquals(parsedPath, listCatalogsPath);
  }
  
  public void testListCatalogsWOptionsWRetries() throws Throwable {
    // Enable retries and run testListCatalogsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testListCatalogsWOptions();

    // Disable retries and run testListCatalogsWOptions.
    catalogManagementService.disableRetries();
    testListCatalogsWOptions();
  }  

  @Test
  public void testCreateCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00.000Z\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00.000Z\"}}, \"kind\": \"kind\"}";
    String createCatalogPath = "/catalogs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the FilterTerms model
    FilterTerms filterTermsModel = new FilterTerms.Builder()
    .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the CategoryFilter model
    CategoryFilter categoryFilterModel = new CategoryFilter.Builder()
    .include(true)
    .filter(filterTermsModel)
    .build();

    // Construct an instance of the IDFilter model
    IDFilter idFilterModel = new IDFilter.Builder()
    .include(filterTermsModel)
    .exclude(filterTermsModel)
    .build();

    // Construct an instance of the Filters model
    Filters filtersModel = new Filters.Builder()
    .includeAll(true)
    .categoryFilters(new java.util.HashMap<String, CategoryFilter>() { { put("foo", categoryFilterModel); } })
    .idFilters(idFilterModel)
    .build();

    // Construct an instance of the SyndicationCluster model
    SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder()
    .region("testString")
    .id("testString")
    .name("testString")
    .resourceGroupName("testString")
    .type("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allNamespaces(true)
    .build();

    // Construct an instance of the SyndicationHistory model
    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
    .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .build();

    // Construct an instance of the SyndicationAuthorization model
    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
    .token("testString")
    .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .build();

    // Construct an instance of the SyndicationResource model
    SyndicationResource syndicationResourceModel = new SyndicationResource.Builder()
    .removeRelatedComponents(true)
    .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
    .history(syndicationHistoryModel)
    .authorization(syndicationAuthorizationModel)
    .build();

    // Construct an instance of the CreateCatalogOptions model
    CreateCatalogOptions createCatalogOptionsModel = new CreateCatalogOptions.Builder()
    .id("testString")
    .rev("testString")
    .label("testString")
    .shortDescription("testString")
    .catalogIconUrl("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .disabled(true)
    .resourceGroupId("testString")
    .owningAccount("testString")
    .catalogFilters(filtersModel)
    .syndicationSettings(syndicationResourceModel)
    .kind("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Catalog> response = catalogManagementService.createCatalog(createCatalogOptionsModel).execute();
    assertNotNull(response);
    Catalog responseObj = response.getResult();
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
    assertEquals(parsedPath, createCatalogPath);
  }
  
  public void testCreateCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateCatalogWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCreateCatalogWOptions();

    // Disable retries and run testCreateCatalogWOptions.
    catalogManagementService.disableRetries();
    testCreateCatalogWOptions();
  }  

  @Test
  public void testGetCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00.000Z\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00.000Z\"}}, \"kind\": \"kind\"}";
    String getCatalogPath = "/catalogs/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogOptions model
    GetCatalogOptions getCatalogOptionsModel = new GetCatalogOptions.Builder()
    .catalogIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Catalog> response = catalogManagementService.getCatalog(getCatalogOptionsModel).execute();
    assertNotNull(response);
    Catalog responseObj = response.getResult();
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
    assertEquals(parsedPath, getCatalogPath);
  }
  
  public void testGetCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCatalogWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetCatalogWOptions();

    // Disable retries and run testGetCatalogWOptions.
    catalogManagementService.disableRetries();
    testGetCatalogWOptions();
  }  

  // Test the getCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getCatalog(null).execute();
  }

  @Test
  public void testReplaceCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00.000Z\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00.000Z\"}}, \"kind\": \"kind\"}";
    String replaceCatalogPath = "/catalogs/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the FilterTerms model
    FilterTerms filterTermsModel = new FilterTerms.Builder()
    .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the CategoryFilter model
    CategoryFilter categoryFilterModel = new CategoryFilter.Builder()
    .include(true)
    .filter(filterTermsModel)
    .build();

    // Construct an instance of the IDFilter model
    IDFilter idFilterModel = new IDFilter.Builder()
    .include(filterTermsModel)
    .exclude(filterTermsModel)
    .build();

    // Construct an instance of the Filters model
    Filters filtersModel = new Filters.Builder()
    .includeAll(true)
    .categoryFilters(new java.util.HashMap<String, CategoryFilter>() { { put("foo", categoryFilterModel); } })
    .idFilters(idFilterModel)
    .build();

    // Construct an instance of the SyndicationCluster model
    SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder()
    .region("testString")
    .id("testString")
    .name("testString")
    .resourceGroupName("testString")
    .type("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allNamespaces(true)
    .build();

    // Construct an instance of the SyndicationHistory model
    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
    .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .build();

    // Construct an instance of the SyndicationAuthorization model
    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
    .token("testString")
    .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .build();

    // Construct an instance of the SyndicationResource model
    SyndicationResource syndicationResourceModel = new SyndicationResource.Builder()
    .removeRelatedComponents(true)
    .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
    .history(syndicationHistoryModel)
    .authorization(syndicationAuthorizationModel)
    .build();

    // Construct an instance of the ReplaceCatalogOptions model
    ReplaceCatalogOptions replaceCatalogOptionsModel = new ReplaceCatalogOptions.Builder()
    .catalogIdentifier("testString")
    .id("testString")
    .rev("testString")
    .label("testString")
    .shortDescription("testString")
    .catalogIconUrl("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .disabled(true)
    .resourceGroupId("testString")
    .owningAccount("testString")
    .catalogFilters(filtersModel)
    .syndicationSettings(syndicationResourceModel)
    .kind("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Catalog> response = catalogManagementService.replaceCatalog(replaceCatalogOptionsModel).execute();
    assertNotNull(response);
    Catalog responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceCatalogPath);
  }
  
  public void testReplaceCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testReplaceCatalogWOptions.
    catalogManagementService.enableRetries(4, 30);
    testReplaceCatalogWOptions();

    // Disable retries and run testReplaceCatalogWOptions.
    catalogManagementService.disableRetries();
    testReplaceCatalogWOptions();
  }  

  // Test the replaceCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.replaceCatalog(null).execute();
  }

  @Test
  public void testDeleteCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCatalogPath = "/catalogs/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCatalogOptions model
    DeleteCatalogOptions deleteCatalogOptionsModel = new DeleteCatalogOptions.Builder()
    .catalogIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteCatalog(deleteCatalogOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCatalogPath);
  }
  
  public void testDeleteCatalogWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteCatalogWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteCatalogWOptions();

    // Disable retries and run testDeleteCatalogWOptions.
    catalogManagementService.disableRetries();
    testDeleteCatalogWOptions();
  }  

  // Test the deleteCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteCatalog(null).execute();
  }

  @Test
  public void testGetCatalogAuditWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"list\": [{\"id\": \"id\", \"created\": \"2019-01-01T12:00:00.000Z\", \"change_type\": \"changeType\", \"target_type\": \"targetType\", \"target_id\": \"targetId\", \"who_delegate_email\": \"whoDelegateEmail\", \"message\": \"message\"}]}";
    String getCatalogAuditPath = "/catalogs/testString/audit";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogAuditOptions model
    GetCatalogAuditOptions getCatalogAuditOptionsModel = new GetCatalogAuditOptions.Builder()
    .catalogIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AuditLog> response = catalogManagementService.getCatalogAudit(getCatalogAuditOptionsModel).execute();
    assertNotNull(response);
    AuditLog responseObj = response.getResult();
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
    assertEquals(parsedPath, getCatalogAuditPath);
  }
  
  public void testGetCatalogAuditWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetCatalogAuditWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetCatalogAuditWOptions();

    // Disable retries and run testGetCatalogAuditWOptions.
    catalogManagementService.disableRetries();
    testGetCatalogAuditWOptions();
  }  

  // Test the getCatalogAudit operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCatalogAuditNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getCatalogAudit(null).execute();
  }

  @Test
  public void testGetConsumptionOfferingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}]}";
    String getConsumptionOfferingsPath = "/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetConsumptionOfferingsOptions model
    GetConsumptionOfferingsOptions getConsumptionOfferingsOptionsModel = new GetConsumptionOfferingsOptions.Builder()
    .digest(true)
    .catalog("testString")
    .select("all")
    .includeHidden(true)
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingSearchResult> response = catalogManagementService.getConsumptionOfferings(getConsumptionOfferingsOptionsModel).execute();
    assertNotNull(response);
    OfferingSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("digest")), Boolean.valueOf(true));
    assertEquals(query.get("catalog"), "testString");
    assertEquals(query.get("select"), "all");
    assertEquals(Boolean.valueOf(query.get("includeHidden")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getConsumptionOfferingsPath);
  }
  
  public void testGetConsumptionOfferingsWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetConsumptionOfferingsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetConsumptionOfferingsWOptions();

    // Disable retries and run testGetConsumptionOfferingsWOptions.
    catalogManagementService.disableRetries();
    testGetConsumptionOfferingsWOptions();
  }  

  @Test
  public void testListOfferingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}]}";
    String listOfferingsPath = "/catalogs/testString/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListOfferingsOptions model
    ListOfferingsOptions listOfferingsOptionsModel = new ListOfferingsOptions.Builder()
    .catalogIdentifier("testString")
    .digest(true)
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .name("testString")
    .sort("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingSearchResult> response = catalogManagementService.listOfferings(listOfferingsOptionsModel).execute();
    assertNotNull(response);
    OfferingSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Boolean.valueOf(query.get("digest")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("sort"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listOfferingsPath);
  }
  
  public void testListOfferingsWOptionsWRetries() throws Throwable {
    // Enable retries and run testListOfferingsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testListOfferingsWOptions();

    // Disable retries and run testListOfferingsWOptions.
    catalogManagementService.disableRetries();
    testListOfferingsWOptions();
  }  

  // Test the listOfferings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListOfferingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.listOfferings(null).execute();
  }

  @Test
  public void testCreateOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String createOfferingPath = "/catalogs/testString/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Rating model
    Rating ratingModel = new Rating.Builder()
    .oneStarCount(Long.valueOf("26"))
    .twoStarCount(Long.valueOf("26"))
    .threeStarCount(Long.valueOf("26"))
    .fourStarCount(Long.valueOf("26"))
    .build();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the Configuration model
    Configuration configurationModel = new Configuration.Builder()
    .key("testString")
    .type("testString")
    .defaultValue("testString")
    .valueConstraint("testString")
    .description("testString")
    .required(true)
    .options(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
    .hidden(true)
    .build();

    // Construct an instance of the Validation model
    Validation validationModel = new Validation.Builder()
    .validated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .requested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .state("testString")
    .lastOperation("testString")
    .target(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
    .type("mem")
    .value("testString")
    .build();

    // Construct an instance of the Script model
    Script scriptModel = new Script.Builder()
    .instructions("testString")
    .script("testString")
    .scriptPermission("testString")
    .deleteScript("testString")
    .scope("testString")
    .build();

    // Construct an instance of the VersionEntitlement model
    VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
    .providerName("testString")
    .providerId("testString")
    .productId("testString")
    .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .imageRepoName("testString")
    .build();

    // Construct an instance of the License model
    License licenseModel = new License.Builder()
    .id("testString")
    .name("testString")
    .type("testString")
    .url("testString")
    .description("testString")
    .build();

    // Construct an instance of the State model
    State stateModel = new State.Builder()
    .current("testString")
    .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .pending("testString")
    .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .previous("testString")
    .build();

    // Construct an instance of the Version model
    Version versionModel = new Version.Builder()
    .id("testString")
    .rev("testString")
    .crn("testString")
    .version("testString")
    .sha("testString")
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .offeringId("testString")
    .catalogId("testString")
    .kindId("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .repoUrl("testString")
    .sourceUrl("testString")
    .tgzUrl("testString")
    .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .validation(validationModel)
    .requiredResources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .singleInstance(true)
    .install(scriptModel)
    .preInstall(new java.util.ArrayList<Script>(java.util.Arrays.asList(scriptModel)))
    .entitlement(versionEntitlementModel)
    .licenses(new java.util.ArrayList<License>(java.util.Arrays.asList(licenseModel)))
    .imageManifestUrl("testString")
    .deprecated(true)
    .packageVersion("testString")
    .state(stateModel)
    .versionLocator("testString")
    .consoleUrl("testString")
    .longDescription("testString")
    .whitelistedAccounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the Deployment model
    Deployment deploymentModel = new Deployment.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .build();

    // Construct an instance of the Plan model
    Plan planModel = new Plan.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
    .build();

    // Construct an instance of the Kind model
    Kind kindModel = new Kind.Builder()
    .id("testString")
    .formatKind("testString")
    .targetKind("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .installDescription("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
    .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
    .build();

    // Construct an instance of the ProviderInfo model
    ProviderInfo providerInfoModel = new ProviderInfo.Builder()
    .id("testString")
    .name("testString")
    .build();

    // Construct an instance of the RepoInfo model
    RepoInfo repoInfoModel = new RepoInfo.Builder()
    .token("testString")
    .type("testString")
    .build();

    // Construct an instance of the Support model
    Support supportModel = new Support.Builder()
    .url("testString")
    .process("testString")
    .locations(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the MediaItem model
    MediaItem mediaItemModel = new MediaItem.Builder()
    .url("testString")
    .caption("testString")
    .type("testString")
    .thumbnailUrl("testString")
    .build();

    // Construct an instance of the CreateOfferingOptions model
    CreateOfferingOptions createOfferingOptionsModel = new CreateOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .id("testString")
    .rev("testString")
    .url("testString")
    .crn("testString")
    .label("testString")
    .name("testString")
    .offeringIconUrl("testString")
    .offeringDocsUrl("testString")
    .offeringSupportUrl("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .rating(ratingModel)
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .shortDescription("testString")
    .longDescription("testString")
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
    .permitRequestIbmPublicPublish(true)
    .ibmPublishApproved(true)
    .publicPublishApproved(true)
    .publicOriginalCrn("testString")
    .publishPublicCrn("testString")
    .portalApprovalRecord("testString")
    .portalUiUrl("testString")
    .catalogId("testString")
    .catalogName("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .disclaimer("testString")
    .hidden(true)
    .provider("testString")
    .providerInfo(providerInfoModel)
    .repoInfo(repoInfoModel)
    .support(supportModel)
    .media(new java.util.ArrayList<MediaItem>(java.util.Arrays.asList(mediaItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.createOffering(createOfferingOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
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
    assertEquals(parsedPath, createOfferingPath);
  }
  
  public void testCreateOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCreateOfferingWOptions();

    // Disable retries and run testCreateOfferingWOptions.
    catalogManagementService.disableRetries();
    testCreateOfferingWOptions();
  }  

  // Test the createOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.createOffering(null).execute();
  }

  @Test
  public void testImportOfferingVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String importOfferingVersionPath = "/catalogs/testString/offerings/testString/version";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ImportOfferingVersionOptions model
    ImportOfferingVersionOptions importOfferingVersionOptionsModel = new ImportOfferingVersionOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .zipurl("testString")
    .targetVersion("testString")
    .includeConfig(true)
    .isVsi(true)
    .repoType("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.importOfferingVersion(importOfferingVersionOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("zipurl"), "testString");
    assertEquals(query.get("targetVersion"), "testString");
    assertEquals(Boolean.valueOf(query.get("includeConfig")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("isVSI")), Boolean.valueOf(true));
    assertEquals(query.get("repoType"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importOfferingVersionPath);
  }
  
  public void testImportOfferingVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testImportOfferingVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testImportOfferingVersionWOptions();

    // Disable retries and run testImportOfferingVersionWOptions.
    catalogManagementService.disableRetries();
    testImportOfferingVersionWOptions();
  }  

  // Test the importOfferingVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportOfferingVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.importOfferingVersion(null).execute();
  }

  @Test
  public void testImportOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String importOfferingPath = "/catalogs/testString/import/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ImportOfferingOptions model
    ImportOfferingOptions importOfferingOptionsModel = new ImportOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .zipurl("testString")
    .offeringId("testString")
    .targetVersion("testString")
    .includeConfig(true)
    .isVsi(true)
    .repoType("testString")
    .xAuthToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.importOffering(importOfferingOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("zipurl"), "testString");
    assertEquals(query.get("offeringID"), "testString");
    assertEquals(query.get("targetVersion"), "testString");
    assertEquals(Boolean.valueOf(query.get("includeConfig")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("isVSI")), Boolean.valueOf(true));
    assertEquals(query.get("repoType"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importOfferingPath);
  }
  
  public void testImportOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testImportOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testImportOfferingWOptions();

    // Disable retries and run testImportOfferingWOptions.
    catalogManagementService.disableRetries();
    testImportOfferingWOptions();
  }  

  // Test the importOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.importOffering(null).execute();
  }

  @Test
  public void testReloadOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String reloadOfferingPath = "/catalogs/testString/offerings/testString/reload";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ReloadOfferingOptions model
    ReloadOfferingOptions reloadOfferingOptionsModel = new ReloadOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .targetVersion("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .zipurl("testString")
    .repoType("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.reloadOffering(reloadOfferingOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("targetVersion"), "testString");
    assertEquals(query.get("zipurl"), "testString");
    assertEquals(query.get("repoType"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, reloadOfferingPath);
  }
  
  public void testReloadOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testReloadOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testReloadOfferingWOptions();

    // Disable retries and run testReloadOfferingWOptions.
    catalogManagementService.disableRetries();
    testReloadOfferingWOptions();
  }  

  // Test the reloadOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReloadOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.reloadOffering(null).execute();
  }

  @Test
  public void testGetOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String getOfferingPath = "/catalogs/testString/offerings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingOptions model
    GetOfferingOptions getOfferingOptionsModel = new GetOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .type("testString")
    .digest(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.getOffering(getOfferingOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("type"), "testString");
    assertEquals(Boolean.valueOf(query.get("digest")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOfferingPath);
  }
  
  public void testGetOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingWOptions();

    // Disable retries and run testGetOfferingWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingWOptions();
  }  

  // Test the getOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOffering(null).execute();
  }

  @Test
  public void testReplaceOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String replaceOfferingPath = "/catalogs/testString/offerings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Rating model
    Rating ratingModel = new Rating.Builder()
    .oneStarCount(Long.valueOf("26"))
    .twoStarCount(Long.valueOf("26"))
    .threeStarCount(Long.valueOf("26"))
    .fourStarCount(Long.valueOf("26"))
    .build();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the Configuration model
    Configuration configurationModel = new Configuration.Builder()
    .key("testString")
    .type("testString")
    .defaultValue("testString")
    .valueConstraint("testString")
    .description("testString")
    .required(true)
    .options(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
    .hidden(true)
    .build();

    // Construct an instance of the Validation model
    Validation validationModel = new Validation.Builder()
    .validated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .requested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .state("testString")
    .lastOperation("testString")
    .target(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Construct an instance of the Resource model
    Resource resourceModel = new Resource.Builder()
    .type("mem")
    .value("testString")
    .build();

    // Construct an instance of the Script model
    Script scriptModel = new Script.Builder()
    .instructions("testString")
    .script("testString")
    .scriptPermission("testString")
    .deleteScript("testString")
    .scope("testString")
    .build();

    // Construct an instance of the VersionEntitlement model
    VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
    .providerName("testString")
    .providerId("testString")
    .productId("testString")
    .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .imageRepoName("testString")
    .build();

    // Construct an instance of the License model
    License licenseModel = new License.Builder()
    .id("testString")
    .name("testString")
    .type("testString")
    .url("testString")
    .description("testString")
    .build();

    // Construct an instance of the State model
    State stateModel = new State.Builder()
    .current("testString")
    .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .pending("testString")
    .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .previous("testString")
    .build();

    // Construct an instance of the Version model
    Version versionModel = new Version.Builder()
    .id("testString")
    .rev("testString")
    .crn("testString")
    .version("testString")
    .sha("testString")
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .offeringId("testString")
    .catalogId("testString")
    .kindId("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .repoUrl("testString")
    .sourceUrl("testString")
    .tgzUrl("testString")
    .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .validation(validationModel)
    .requiredResources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    .singleInstance(true)
    .install(scriptModel)
    .preInstall(new java.util.ArrayList<Script>(java.util.Arrays.asList(scriptModel)))
    .entitlement(versionEntitlementModel)
    .licenses(new java.util.ArrayList<License>(java.util.Arrays.asList(licenseModel)))
    .imageManifestUrl("testString")
    .deprecated(true)
    .packageVersion("testString")
    .state(stateModel)
    .versionLocator("testString")
    .consoleUrl("testString")
    .longDescription("testString")
    .whitelistedAccounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the Deployment model
    Deployment deploymentModel = new Deployment.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .build();

    // Construct an instance of the Plan model
    Plan planModel = new Plan.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
    .build();

    // Construct an instance of the Kind model
    Kind kindModel = new Kind.Builder()
    .id("testString")
    .formatKind("testString")
    .targetKind("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .installDescription("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
    .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
    .build();

    // Construct an instance of the ProviderInfo model
    ProviderInfo providerInfoModel = new ProviderInfo.Builder()
    .id("testString")
    .name("testString")
    .build();

    // Construct an instance of the RepoInfo model
    RepoInfo repoInfoModel = new RepoInfo.Builder()
    .token("testString")
    .type("testString")
    .build();

    // Construct an instance of the Support model
    Support supportModel = new Support.Builder()
    .url("testString")
    .process("testString")
    .locations(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Construct an instance of the MediaItem model
    MediaItem mediaItemModel = new MediaItem.Builder()
    .url("testString")
    .caption("testString")
    .type("testString")
    .thumbnailUrl("testString")
    .build();

    // Construct an instance of the ReplaceOfferingOptions model
    ReplaceOfferingOptions replaceOfferingOptionsModel = new ReplaceOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .id("testString")
    .rev("testString")
    .url("testString")
    .crn("testString")
    .label("testString")
    .name("testString")
    .offeringIconUrl("testString")
    .offeringDocsUrl("testString")
    .offeringSupportUrl("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .rating(ratingModel)
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .shortDescription("testString")
    .longDescription("testString")
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
    .permitRequestIbmPublicPublish(true)
    .ibmPublishApproved(true)
    .publicPublishApproved(true)
    .publicOriginalCrn("testString")
    .publishPublicCrn("testString")
    .portalApprovalRecord("testString")
    .portalUiUrl("testString")
    .catalogId("testString")
    .catalogName("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .disclaimer("testString")
    .hidden(true)
    .provider("testString")
    .providerInfo(providerInfoModel)
    .repoInfo(repoInfoModel)
    .support(supportModel)
    .media(new java.util.ArrayList<MediaItem>(java.util.Arrays.asList(mediaItemModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.replaceOffering(replaceOfferingOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceOfferingPath);
  }
  
  public void testReplaceOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testReplaceOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testReplaceOfferingWOptions();

    // Disable retries and run testReplaceOfferingWOptions.
    catalogManagementService.disableRetries();
    testReplaceOfferingWOptions();
  }  

  // Test the replaceOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.replaceOffering(null).execute();
  }

  @Test
  public void testUpdateOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String updateOfferingPath = "/catalogs/testString/offerings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the JsonPatchOperation model
    JsonPatchOperation jsonPatchOperationModel = new JsonPatchOperation.Builder()
    .op("add")
    .path("testString")
    .from("testString")
    .value("testString")
    .build();

    // Construct an instance of the UpdateOfferingOptions model
    UpdateOfferingOptions updateOfferingOptionsModel = new UpdateOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .ifMatch("testString")
    .updates(new java.util.ArrayList<JsonPatchOperation>(java.util.Arrays.asList(jsonPatchOperationModel)))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.updateOffering(updateOfferingOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PATCH");
    assertEquals(request.getHeader("If-Match"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateOfferingPath);
  }
  
  public void testUpdateOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testUpdateOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testUpdateOfferingWOptions();

    // Disable retries and run testUpdateOfferingWOptions.
    catalogManagementService.disableRetries();
    testUpdateOfferingWOptions();
  }  

  // Test the updateOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.updateOffering(null).execute();
  }

  @Test
  public void testDeleteOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteOfferingPath = "/catalogs/testString/offerings/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteOfferingOptions model
    DeleteOfferingOptions deleteOfferingOptionsModel = new DeleteOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteOffering(deleteOfferingOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteOfferingPath);
  }
  
  public void testDeleteOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteOfferingWOptions();

    // Disable retries and run testDeleteOfferingWOptions.
    catalogManagementService.disableRetries();
    testDeleteOfferingWOptions();
  }  

  // Test the deleteOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteOffering(null).execute();
  }

  @Test
  public void testGetOfferingAuditWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"list\": [{\"id\": \"id\", \"created\": \"2019-01-01T12:00:00.000Z\", \"change_type\": \"changeType\", \"target_type\": \"targetType\", \"target_id\": \"targetId\", \"who_delegate_email\": \"whoDelegateEmail\", \"message\": \"message\"}]}";
    String getOfferingAuditPath = "/catalogs/testString/offerings/testString/audit";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingAuditOptions model
    GetOfferingAuditOptions getOfferingAuditOptionsModel = new GetOfferingAuditOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AuditLog> response = catalogManagementService.getOfferingAudit(getOfferingAuditOptionsModel).execute();
    assertNotNull(response);
    AuditLog responseObj = response.getResult();
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
    assertEquals(parsedPath, getOfferingAuditPath);
  }
  
  public void testGetOfferingAuditWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingAuditWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingAuditWOptions();

    // Disable retries and run testGetOfferingAuditWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingAuditWOptions();
  }  

  // Test the getOfferingAudit operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingAuditNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingAudit(null).execute();
  }

  @Test
  public void testReplaceOfferingIconWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String replaceOfferingIconPath = "/catalogs/testString/offerings/testString/icon/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ReplaceOfferingIconOptions model
    ReplaceOfferingIconOptions replaceOfferingIconOptionsModel = new ReplaceOfferingIconOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .fileName("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.replaceOfferingIcon(replaceOfferingIconOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceOfferingIconPath);
  }
  
  public void testReplaceOfferingIconWOptionsWRetries() throws Throwable {
    // Enable retries and run testReplaceOfferingIconWOptions.
    catalogManagementService.enableRetries(4, 30);
    testReplaceOfferingIconWOptions();

    // Disable retries and run testReplaceOfferingIconWOptions.
    catalogManagementService.disableRetries();
    testReplaceOfferingIconWOptions();
  }  

  // Test the replaceOfferingIcon operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOfferingIconNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.replaceOfferingIcon(null).execute();
  }

  @Test
  public void testUpdateOfferingIbmWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"allow_request\": true, \"ibm\": false, \"public\": false, \"changed\": false}";
    String updateOfferingIbmPath = "/catalogs/testString/offerings/testString/publish/pc_managed/true";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateOfferingIbmOptions model
    UpdateOfferingIbmOptions updateOfferingIbmOptionsModel = new UpdateOfferingIbmOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .approvalType("pc_managed")
    .approved("true")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApprovalResult> response = catalogManagementService.updateOfferingIbm(updateOfferingIbmOptionsModel).execute();
    assertNotNull(response);
    ApprovalResult responseObj = response.getResult();
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
    assertEquals(parsedPath, updateOfferingIbmPath);
  }
  
  public void testUpdateOfferingIbmWOptionsWRetries() throws Throwable {
    // Enable retries and run testUpdateOfferingIbmWOptions.
    catalogManagementService.enableRetries(4, 30);
    testUpdateOfferingIbmWOptions();

    // Disable retries and run testUpdateOfferingIbmWOptions.
    catalogManagementService.disableRetries();
    testUpdateOfferingIbmWOptions();
  }  

  // Test the updateOfferingIbm operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateOfferingIbmNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.updateOfferingIbm(null).execute();
  }

  @Test
  public void testDeprecateOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deprecateOfferingPath = "/catalogs/testString/offerings/testString/deprecate/%7Bapproved%7D";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeprecateOfferingOptions model
    DeprecateOfferingOptions deprecateOfferingOptionsModel = new DeprecateOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .setting("true")
    .description("testString")
    .daysUntilDeprecate(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deprecateOffering(deprecateOfferingOptionsModel).execute();
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
    assertEquals(parsedPath, deprecateOfferingPath);
  }
  
  public void testDeprecateOfferingWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeprecateOfferingWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeprecateOfferingWOptions();

    // Disable retries and run testDeprecateOfferingWOptions.
    catalogManagementService.disableRetries();
    testDeprecateOfferingWOptions();
  }  

  // Test the deprecateOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeprecateOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deprecateOffering(null).execute();
  }

  @Test
  public void testGetOfferingUpdatesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"version_locator\": \"versionLocator\", \"version\": \"version\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"package_version\": \"packageVersion\", \"sha\": \"sha\", \"can_update\": false, \"messages\": {\"mapKey\": \"inner\"}}]";
    String getOfferingUpdatesPath = "/catalogs/testString/offerings/testString/updates";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingUpdatesOptions model
    GetOfferingUpdatesOptions getOfferingUpdatesOptionsModel = new GetOfferingUpdatesOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .kind("testString")
    .xAuthRefreshToken("testString")
    .target("testString")
    .version("testString")
    .clusterId("testString")
    .region("testString")
    .resourceGroupId("testString")
    .namespace("testString")
    .sha("testString")
    .channel("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allNamespaces(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<VersionUpdateDescriptor>> response = catalogManagementService.getOfferingUpdates(getOfferingUpdatesOptionsModel).execute();
    assertNotNull(response);
    List<VersionUpdateDescriptor> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("kind"), "testString");
    assertEquals(query.get("target"), "testString");
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("cluster_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("namespace"), "testString");
    assertEquals(query.get("sha"), "testString");
    assertEquals(query.get("channel"), "testString");
    assertEquals(query.get("namespaces"), RequestUtils.join(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")), ","));
    assertEquals(Boolean.valueOf(query.get("all_namespaces")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOfferingUpdatesPath);
  }
  
  public void testGetOfferingUpdatesWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingUpdatesWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingUpdatesWOptions();

    // Disable retries and run testGetOfferingUpdatesWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingUpdatesWOptions();
  }  

  // Test the getOfferingUpdates operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingUpdatesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingUpdates(null).execute();
  }

  @Test
  public void testGetOfferingSourceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "This is a mock binary response.";
    String getOfferingSourcePath = "/offering/source";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/yaml")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingSourceOptions model
    GetOfferingSourceOptions getOfferingSourceOptionsModel = new GetOfferingSourceOptions.Builder()
    .version("testString")
    .accept("application/yaml")
    .catalogId("testString")
    .name("testString")
    .id("testString")
    .kind("testString")
    .channel("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InputStream> response = catalogManagementService.getOfferingSource(getOfferingSourceOptionsModel).execute();
    assertNotNull(response);
    InputStream responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("version"), "testString");
    assertEquals(query.get("catalogID"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("id"), "testString");
    assertEquals(query.get("kind"), "testString");
    assertEquals(query.get("channel"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getOfferingSourcePath);
  }
  
  public void testGetOfferingSourceWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingSourceWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingSourceWOptions();

    // Disable retries and run testGetOfferingSourceWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingSourceWOptions();
  }  

  // Test the getOfferingSource operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingSourceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingSource(null).execute();
  }

  @Test
  public void testGetOfferingAboutWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "\"operationResponse\"";
    String getOfferingAboutPath = "/versions/testString/about";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "text/markdown")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingAboutOptions model
    GetOfferingAboutOptions getOfferingAboutOptionsModel = new GetOfferingAboutOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<String> response = catalogManagementService.getOfferingAbout(getOfferingAboutOptionsModel).execute();
    assertNotNull(response);
    String responseObj = response.getResult();
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
    assertEquals(parsedPath, getOfferingAboutPath);
  }
  
  public void testGetOfferingAboutWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingAboutWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingAboutWOptions();

    // Disable retries and run testGetOfferingAboutWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingAboutWOptions();
  }  

  // Test the getOfferingAbout operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingAboutNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingAbout(null).execute();
  }

  @Test
  public void testGetOfferingLicenseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "\"operationResponse\"";
    String getOfferingLicensePath = "/versions/testString/licenses/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "text/plain")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingLicenseOptions model
    GetOfferingLicenseOptions getOfferingLicenseOptionsModel = new GetOfferingLicenseOptions.Builder()
    .versionLocId("testString")
    .licenseId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<String> response = catalogManagementService.getOfferingLicense(getOfferingLicenseOptionsModel).execute();
    assertNotNull(response);
    String responseObj = response.getResult();
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
    assertEquals(parsedPath, getOfferingLicensePath);
  }
  
  public void testGetOfferingLicenseWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingLicenseWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingLicenseWOptions();

    // Disable retries and run testGetOfferingLicenseWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingLicenseWOptions();
  }  

  // Test the getOfferingLicense operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingLicenseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingLicense(null).execute();
  }

  @Test
  public void testGetOfferingContainerImagesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"description\": \"description\", \"images\": [{\"image\": \"image\"}]}";
    String getOfferingContainerImagesPath = "/versions/testString/containerImages";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingContainerImagesOptions model
    GetOfferingContainerImagesOptions getOfferingContainerImagesOptionsModel = new GetOfferingContainerImagesOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ImageManifest> response = catalogManagementService.getOfferingContainerImages(getOfferingContainerImagesOptionsModel).execute();
    assertNotNull(response);
    ImageManifest responseObj = response.getResult();
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
    assertEquals(parsedPath, getOfferingContainerImagesPath);
  }
  
  public void testGetOfferingContainerImagesWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingContainerImagesWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingContainerImagesWOptions();

    // Disable retries and run testGetOfferingContainerImagesWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingContainerImagesWOptions();
  }  

  // Test the getOfferingContainerImages operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingContainerImagesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingContainerImages(null).execute();
  }

  @Test
  public void testDeprecateVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deprecateVersionPath = "/versions/testString/deprecate";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeprecateVersionOptions model
    DeprecateVersionOptions deprecateVersionOptionsModel = new DeprecateVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deprecateVersion(deprecateVersionOptionsModel).execute();
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
    assertEquals(parsedPath, deprecateVersionPath);
  }
  
  public void testDeprecateVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeprecateVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeprecateVersionWOptions();

    // Disable retries and run testDeprecateVersionWOptions.
    catalogManagementService.disableRetries();
    testDeprecateVersionWOptions();
  }  

  // Test the deprecateVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeprecateVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deprecateVersion(null).execute();
  }

  @Test
  public void testSetDeprecateVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String setDeprecateVersionPath = "/versions/testString/deprecate/true";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SetDeprecateVersionOptions model
    SetDeprecateVersionOptions setDeprecateVersionOptionsModel = new SetDeprecateVersionOptions.Builder()
    .versionLocId("testString")
    .setting("true")
    .description("testString")
    .daysUntilDeprecate(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.setDeprecateVersion(setDeprecateVersionOptionsModel).execute();
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
    assertEquals(parsedPath, setDeprecateVersionPath);
  }
  
  public void testSetDeprecateVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testSetDeprecateVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testSetDeprecateVersionWOptions();

    // Disable retries and run testSetDeprecateVersionWOptions.
    catalogManagementService.disableRetries();
    testSetDeprecateVersionWOptions();
  }  

  // Test the setDeprecateVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetDeprecateVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.setDeprecateVersion(null).execute();
  }

  @Test
  public void testAccountPublishVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String accountPublishVersionPath = "/versions/testString/account-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AccountPublishVersionOptions model
    AccountPublishVersionOptions accountPublishVersionOptionsModel = new AccountPublishVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.accountPublishVersion(accountPublishVersionOptionsModel).execute();
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
    assertEquals(parsedPath, accountPublishVersionPath);
  }
  
  public void testAccountPublishVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testAccountPublishVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testAccountPublishVersionWOptions();

    // Disable retries and run testAccountPublishVersionWOptions.
    catalogManagementService.disableRetries();
    testAccountPublishVersionWOptions();
  }  

  // Test the accountPublishVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAccountPublishVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.accountPublishVersion(null).execute();
  }

  @Test
  public void testIbmPublishVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String ibmPublishVersionPath = "/versions/testString/ibm-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the IbmPublishVersionOptions model
    IbmPublishVersionOptions ibmPublishVersionOptionsModel = new IbmPublishVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.ibmPublishVersion(ibmPublishVersionOptionsModel).execute();
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
    assertEquals(parsedPath, ibmPublishVersionPath);
  }
  
  public void testIbmPublishVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testIbmPublishVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testIbmPublishVersionWOptions();

    // Disable retries and run testIbmPublishVersionWOptions.
    catalogManagementService.disableRetries();
    testIbmPublishVersionWOptions();
  }  

  // Test the ibmPublishVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIbmPublishVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.ibmPublishVersion(null).execute();
  }

  @Test
  public void testPublicPublishVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String publicPublishVersionPath = "/versions/testString/public-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PublicPublishVersionOptions model
    PublicPublishVersionOptions publicPublishVersionOptionsModel = new PublicPublishVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.publicPublishVersion(publicPublishVersionOptionsModel).execute();
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
    assertEquals(parsedPath, publicPublishVersionPath);
  }
  
  public void testPublicPublishVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testPublicPublishVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testPublicPublishVersionWOptions();

    // Disable retries and run testPublicPublishVersionWOptions.
    catalogManagementService.disableRetries();
    testPublicPublishVersionWOptions();
  }  

  // Test the publicPublishVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPublicPublishVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.publicPublishVersion(null).execute();
  }

  @Test
  public void testCommitVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String commitVersionPath = "/versions/testString/commit";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CommitVersionOptions model
    CommitVersionOptions commitVersionOptionsModel = new CommitVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.commitVersion(commitVersionOptionsModel).execute();
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
    assertEquals(parsedPath, commitVersionPath);
  }
  
  public void testCommitVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testCommitVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCommitVersionWOptions();

    // Disable retries and run testCommitVersionWOptions.
    catalogManagementService.disableRetries();
    testCommitVersionWOptions();
  }  

  // Test the commitVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCommitVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.commitVersion(null).execute();
  }

  @Test
  public void testCopyVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String copyVersionPath = "/versions/testString/copy";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CopyVersionOptions model
    CopyVersionOptions copyVersionOptionsModel = new CopyVersionOptions.Builder()
    .versionLocId("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.copyVersion(copyVersionOptionsModel).execute();
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
    assertEquals(parsedPath, copyVersionPath);
  }
  
  public void testCopyVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testCopyVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCopyVersionWOptions();

    // Disable retries and run testCopyVersionWOptions.
    catalogManagementService.disableRetries();
    testCopyVersionWOptions();
  }  

  // Test the copyVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCopyVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.copyVersion(null).execute();
  }

  @Test
  public void testGetOfferingWorkingCopyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}";
    String getOfferingWorkingCopyPath = "/versions/testString/workingcopy";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingWorkingCopyOptions model
    GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptionsModel = new GetOfferingWorkingCopyOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Version> response = catalogManagementService.getOfferingWorkingCopy(getOfferingWorkingCopyOptionsModel).execute();
    assertNotNull(response);
    Version responseObj = response.getResult();
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
    assertEquals(parsedPath, getOfferingWorkingCopyPath);
  }
  
  public void testGetOfferingWorkingCopyWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingWorkingCopyWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingWorkingCopyWOptions();

    // Disable retries and run testGetOfferingWorkingCopyWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingWorkingCopyWOptions();
  }  

  // Test the getOfferingWorkingCopy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingWorkingCopyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingWorkingCopy(null).execute();
  }

  @Test
  public void testGetVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"keywords\": [\"keywords\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"provider_info\": {\"id\": \"id\", \"name\": \"name\"}, \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}, \"support\": {\"url\": \"url\", \"process\": \"process\", \"locations\": [\"locations\"]}, \"media\": [{\"url\": \"url\", \"caption\": \"caption\", \"type\": \"type\", \"thumbnail_url\": \"thumbnailUrl\"}]}";
    String getVersionPath = "/versions/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVersionOptions model
    GetVersionOptions getVersionOptionsModel = new GetVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = catalogManagementService.getVersion(getVersionOptionsModel).execute();
    assertNotNull(response);
    Offering responseObj = response.getResult();
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
    assertEquals(parsedPath, getVersionPath);
  }
  
  public void testGetVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetVersionWOptions();

    // Disable retries and run testGetVersionWOptions.
    catalogManagementService.disableRetries();
    testGetVersionWOptions();
  }  

  // Test the getVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getVersion(null).execute();
  }

  @Test
  public void testDeleteVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteVersionPath = "/versions/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteVersionOptions model
    DeleteVersionOptions deleteVersionOptionsModel = new DeleteVersionOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteVersion(deleteVersionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteVersionPath);
  }
  
  public void testDeleteVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteVersionWOptions();

    // Disable retries and run testDeleteVersionWOptions.
    catalogManagementService.disableRetries();
    testDeleteVersionWOptions();
  }  

  // Test the deleteVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteVersion(null).execute();
  }

  @Test
  public void testGetClusterWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"resource_group_id\": \"resourceGroupId\", \"resource_group_name\": \"resourceGroupName\", \"id\": \"id\", \"name\": \"name\", \"region\": \"region\"}";
    String getClusterPath = "/deploy/kubernetes/clusters/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetClusterOptions model
    GetClusterOptions getClusterOptionsModel = new GetClusterOptions.Builder()
    .clusterId("testString")
    .region("testString")
    .xAuthRefreshToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ClusterInfo> response = catalogManagementService.getCluster(getClusterOptionsModel).execute();
    assertNotNull(response);
    ClusterInfo responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("region"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getClusterPath);
  }
  
  public void testGetClusterWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetClusterWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetClusterWOptions();

    // Disable retries and run testGetClusterWOptions.
    catalogManagementService.disableRetries();
    testGetClusterWOptions();
  }  

  // Test the getCluster operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClusterNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getCluster(null).execute();
  }

  @Test
  public void testGetNamespacesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [\"resources\"]}";
    String getNamespacesPath = "/deploy/kubernetes/clusters/testString/namespaces";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetNamespacesOptions model
    GetNamespacesOptions getNamespacesOptionsModel = new GetNamespacesOptions.Builder()
    .clusterId("testString")
    .region("testString")
    .xAuthRefreshToken("testString")
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<NamespaceSearchResult> response = catalogManagementService.getNamespaces(getNamespacesOptionsModel).execute();
    assertNotNull(response);
    NamespaceSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("region"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getNamespacesPath);
  }
  
  public void testGetNamespacesWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetNamespacesWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetNamespacesWOptions();

    // Disable retries and run testGetNamespacesWOptions.
    catalogManagementService.disableRetries();
    testGetNamespacesWOptions();
  }  

  // Test the getNamespaces operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetNamespacesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getNamespaces(null).execute();
  }

  @Test
  public void testDeployOperatorsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"phase\": \"phase\", \"message\": \"message\", \"link\": \"link\", \"name\": \"name\", \"version\": \"version\", \"namespace\": \"namespace\", \"package_name\": \"packageName\", \"catalog_id\": \"catalogId\"}]";
    String deployOperatorsPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeployOperatorsOptions model
    DeployOperatorsOptions deployOperatorsOptionsModel = new DeployOperatorsOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allNamespaces(true)
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<OperatorDeployResult>> response = catalogManagementService.deployOperators(deployOperatorsOptionsModel).execute();
    assertNotNull(response);
    List<OperatorDeployResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deployOperatorsPath);
  }
  
  public void testDeployOperatorsWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeployOperatorsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeployOperatorsWOptions();

    // Disable retries and run testDeployOperatorsWOptions.
    catalogManagementService.disableRetries();
    testDeployOperatorsWOptions();
  }  

  // Test the deployOperators operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeployOperatorsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deployOperators(null).execute();
  }

  @Test
  public void testListOperatorsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"phase\": \"phase\", \"message\": \"message\", \"link\": \"link\", \"name\": \"name\", \"version\": \"version\", \"namespace\": \"namespace\", \"package_name\": \"packageName\", \"catalog_id\": \"catalogId\"}]";
    String listOperatorsPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListOperatorsOptions model
    ListOperatorsOptions listOperatorsOptionsModel = new ListOperatorsOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<OperatorDeployResult>> response = catalogManagementService.listOperators(listOperatorsOptionsModel).execute();
    assertNotNull(response);
    List<OperatorDeployResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("cluster_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("version_locator_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listOperatorsPath);
  }
  
  public void testListOperatorsWOptionsWRetries() throws Throwable {
    // Enable retries and run testListOperatorsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testListOperatorsWOptions();

    // Disable retries and run testListOperatorsWOptions.
    catalogManagementService.disableRetries();
    testListOperatorsWOptions();
  }  

  // Test the listOperators operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListOperatorsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.listOperators(null).execute();
  }

  @Test
  public void testReplaceOperatorsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"phase\": \"phase\", \"message\": \"message\", \"link\": \"link\", \"name\": \"name\", \"version\": \"version\", \"namespace\": \"namespace\", \"package_name\": \"packageName\", \"catalog_id\": \"catalogId\"}]";
    String replaceOperatorsPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ReplaceOperatorsOptions model
    ReplaceOperatorsOptions replaceOperatorsOptionsModel = new ReplaceOperatorsOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .allNamespaces(true)
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<OperatorDeployResult>> response = catalogManagementService.replaceOperators(replaceOperatorsOptionsModel).execute();
    assertNotNull(response);
    List<OperatorDeployResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceOperatorsPath);
  }
  
  public void testReplaceOperatorsWOptionsWRetries() throws Throwable {
    // Enable retries and run testReplaceOperatorsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testReplaceOperatorsWOptions();

    // Disable retries and run testReplaceOperatorsWOptions.
    catalogManagementService.disableRetries();
    testReplaceOperatorsWOptions();
  }  

  // Test the replaceOperators operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOperatorsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.replaceOperators(null).execute();
  }

  @Test
  public void testDeleteOperatorsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteOperatorsPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteOperatorsOptions model
    DeleteOperatorsOptions deleteOperatorsOptionsModel = new DeleteOperatorsOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteOperators(deleteOperatorsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("cluster_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("version_locator_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteOperatorsPath);
  }
  
  public void testDeleteOperatorsWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteOperatorsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteOperatorsWOptions();

    // Disable retries and run testDeleteOperatorsWOptions.
    catalogManagementService.disableRetries();
    testDeleteOperatorsWOptions();
  }  

  // Test the deleteOperators operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOperatorsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteOperators(null).execute();
  }

  @Test
  public void testInstallVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String installVersionPath = "/versions/testString/install";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeployRequestBodySchematics model
    DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
    .name("testString")
    .description("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .resourceGroupId("testString")
    .build();

    // Construct an instance of the InstallVersionOptions model
    InstallVersionOptions installVersionOptionsModel = new InstallVersionOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespace("testString")
    .overrideValues(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .entitlementApikey("testString")
    .schematics(deployRequestBodySchematicsModel)
    .script("testString")
    .scriptId("testString")
    .versionLocatorId("testString")
    .vcenterId("testString")
    .vcenterUser("testString")
    .vcenterPassword("testString")
    .vcenterLocation("testString")
    .vcenterDatastore("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.installVersion(installVersionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, installVersionPath);
  }
  
  public void testInstallVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testInstallVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testInstallVersionWOptions();

    // Disable retries and run testInstallVersionWOptions.
    catalogManagementService.disableRetries();
    testInstallVersionWOptions();
  }  

  // Test the installVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInstallVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.installVersion(null).execute();
  }

  @Test
  public void testPreinstallVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String preinstallVersionPath = "/versions/testString/preinstall";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeployRequestBodySchematics model
    DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
    .name("testString")
    .description("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .resourceGroupId("testString")
    .build();

    // Construct an instance of the PreinstallVersionOptions model
    PreinstallVersionOptions preinstallVersionOptionsModel = new PreinstallVersionOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespace("testString")
    .overrideValues(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .entitlementApikey("testString")
    .schematics(deployRequestBodySchematicsModel)
    .script("testString")
    .scriptId("testString")
    .versionLocatorId("testString")
    .vcenterId("testString")
    .vcenterUser("testString")
    .vcenterPassword("testString")
    .vcenterLocation("testString")
    .vcenterDatastore("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.preinstallVersion(preinstallVersionOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, preinstallVersionPath);
  }
  
  public void testPreinstallVersionWOptionsWRetries() throws Throwable {
    // Enable retries and run testPreinstallVersionWOptions.
    catalogManagementService.enableRetries(4, 30);
    testPreinstallVersionWOptions();

    // Disable retries and run testPreinstallVersionWOptions.
    catalogManagementService.disableRetries();
    testPreinstallVersionWOptions();
  }  

  // Test the preinstallVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPreinstallVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.preinstallVersion(null).execute();
  }

  @Test
  public void testGetPreinstallWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"cluster_id\": \"clusterId\", \"region\": \"region\", \"namespace\": \"namespace\", \"workspace_id\": \"workspaceId\", \"workspace_name\": \"workspaceName\"}, \"release\": {\"deployments\": [{\"mapKey\": \"anyValue\"}], \"replicasets\": [{\"mapKey\": \"anyValue\"}], \"statefulsets\": [{\"mapKey\": \"anyValue\"}], \"pods\": [{\"mapKey\": \"anyValue\"}], \"errors\": [{\"mapKey\": \"inner\"}]}, \"content_mgmt\": {\"pods\": [{\"mapKey\": \"inner\"}], \"errors\": [{\"mapKey\": \"inner\"}]}}";
    String getPreinstallPath = "/versions/testString/preinstall";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPreinstallOptions model
    GetPreinstallOptions getPreinstallOptionsModel = new GetPreinstallOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespace("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<InstallStatus> response = catalogManagementService.getPreinstall(getPreinstallOptionsModel).execute();
    assertNotNull(response);
    InstallStatus responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("cluster_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("namespace"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPreinstallPath);
  }
  
  public void testGetPreinstallWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetPreinstallWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetPreinstallWOptions();

    // Disable retries and run testGetPreinstallWOptions.
    catalogManagementService.disableRetries();
    testGetPreinstallWOptions();
  }  

  // Test the getPreinstall operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPreinstallNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getPreinstall(null).execute();
  }

  @Test
  public void testValidateInstallWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String validateInstallPath = "/versions/testString/validation/install";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeployRequestBodySchematics model
    DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
    .name("testString")
    .description("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .resourceGroupId("testString")
    .build();

    // Construct an instance of the ValidateInstallOptions model
    ValidateInstallOptions validateInstallOptionsModel = new ValidateInstallOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespace("testString")
    .overrideValues(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .entitlementApikey("testString")
    .schematics(deployRequestBodySchematicsModel)
    .script("testString")
    .scriptId("testString")
    .versionLocatorId("testString")
    .vcenterId("testString")
    .vcenterUser("testString")
    .vcenterPassword("testString")
    .vcenterLocation("testString")
    .vcenterDatastore("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.validateInstall(validateInstallOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, validateInstallPath);
  }
  
  public void testValidateInstallWOptionsWRetries() throws Throwable {
    // Enable retries and run testValidateInstallWOptions.
    catalogManagementService.enableRetries(4, 30);
    testValidateInstallWOptions();

    // Disable retries and run testValidateInstallWOptions.
    catalogManagementService.disableRetries();
    testValidateInstallWOptions();
  }  

  // Test the validateInstall operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testValidateInstallNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.validateInstall(null).execute();
  }

  @Test
  public void testGetValidationStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"validated\": \"2019-01-01T12:00:00.000Z\", \"requested\": \"2019-01-01T12:00:00.000Z\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}";
    String getValidationStatusPath = "/versions/testString/validation/install";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetValidationStatusOptions model
    GetValidationStatusOptions getValidationStatusOptionsModel = new GetValidationStatusOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Validation> response = catalogManagementService.getValidationStatus(getValidationStatusOptionsModel).execute();
    assertNotNull(response);
    Validation responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getValidationStatusPath);
  }
  
  public void testGetValidationStatusWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetValidationStatusWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetValidationStatusWOptions();

    // Disable retries and run testGetValidationStatusWOptions.
    catalogManagementService.disableRetries();
    testGetValidationStatusWOptions();
  }  

  // Test the getValidationStatus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetValidationStatusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getValidationStatus(null).execute();
  }

  @Test
  public void testGetOverrideValuesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"mapKey\": \"anyValue\"}";
    String getOverrideValuesPath = "/versions/testString/validation/overridevalues";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOverrideValuesOptions model
    GetOverrideValuesOptions getOverrideValuesOptionsModel = new GetOverrideValuesOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Map<String, Object>> response = catalogManagementService.getOverrideValues(getOverrideValuesOptionsModel).execute();
    assertNotNull(response);
    Map<String, Object> responseObj = response.getResult();
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
    assertEquals(parsedPath, getOverrideValuesPath);
  }
  
  public void testGetOverrideValuesWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOverrideValuesWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOverrideValuesWOptions();

    // Disable retries and run testGetOverrideValuesWOptions.
    catalogManagementService.disableRetries();
    testGetOverrideValuesWOptions();
  }  

  // Test the getOverrideValues operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOverrideValuesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOverrideValues(null).execute();
  }

  @Test
  public void testSearchObjectsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"_rev\": \"rev\", \"crn\": \"crn\", \"url\": \"url\", \"parent_id\": \"parentId\", \"label_i18n\": \"labelI18n\", \"label\": \"label\", \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"short_description_i18n\": \"shortDescriptionI18n\", \"kind\": \"kind\", \"publish\": {\"permit_ibm_public_publish\": true, \"ibm_approved\": false, \"public_approved\": true, \"portal_approval_record\": \"portalApprovalRecord\", \"portal_url\": \"portalUrl\"}, \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"data\": {\"mapKey\": \"anyValue\"}}]}";
    String searchObjectsPath = "/objects";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SearchObjectsOptions model
    SearchObjectsOptions searchObjectsOptionsModel = new SearchObjectsOptions.Builder()
    .query("testString")
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .collapse(true)
    .digest(true)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectSearchResult> response = catalogManagementService.searchObjects(searchObjectsOptionsModel).execute();
    assertNotNull(response);
    ObjectSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("query"), "testString");
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(Boolean.valueOf(query.get("collapse")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("digest")), Boolean.valueOf(true));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, searchObjectsPath);
  }
  
  public void testSearchObjectsWOptionsWRetries() throws Throwable {
    // Enable retries and run testSearchObjectsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testSearchObjectsWOptions();

    // Disable retries and run testSearchObjectsWOptions.
    catalogManagementService.disableRetries();
    testSearchObjectsWOptions();
  }  

  // Test the searchObjects operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchObjectsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.searchObjects(null).execute();
  }

  @Test
  public void testListObjectsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"_rev\": \"rev\", \"crn\": \"crn\", \"url\": \"url\", \"parent_id\": \"parentId\", \"label_i18n\": \"labelI18n\", \"label\": \"label\", \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"short_description_i18n\": \"shortDescriptionI18n\", \"kind\": \"kind\", \"publish\": {\"permit_ibm_public_publish\": true, \"ibm_approved\": false, \"public_approved\": true, \"portal_approval_record\": \"portalApprovalRecord\", \"portal_url\": \"portalUrl\"}, \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"data\": {\"mapKey\": \"anyValue\"}}]}";
    String listObjectsPath = "/catalogs/testString/objects";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListObjectsOptions model
    ListObjectsOptions listObjectsOptionsModel = new ListObjectsOptions.Builder()
    .catalogIdentifier("testString")
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .name("testString")
    .sort("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectListResult> response = catalogManagementService.listObjects(listObjectsOptionsModel).execute();
    assertNotNull(response);
    ObjectListResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("sort"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listObjectsPath);
  }
  
  public void testListObjectsWOptionsWRetries() throws Throwable {
    // Enable retries and run testListObjectsWOptions.
    catalogManagementService.enableRetries(4, 30);
    testListObjectsWOptions();

    // Disable retries and run testListObjectsWOptions.
    catalogManagementService.disableRetries();
    testListObjectsWOptions();
  }  

  // Test the listObjects operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListObjectsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.listObjects(null).execute();
  }

  @Test
  public void testCreateObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"_rev\": \"rev\", \"crn\": \"crn\", \"url\": \"url\", \"parent_id\": \"parentId\", \"label_i18n\": \"labelI18n\", \"label\": \"label\", \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"short_description_i18n\": \"shortDescriptionI18n\", \"kind\": \"kind\", \"publish\": {\"permit_ibm_public_publish\": true, \"ibm_approved\": false, \"public_approved\": true, \"portal_approval_record\": \"portalApprovalRecord\", \"portal_url\": \"portalUrl\"}, \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"data\": {\"mapKey\": \"anyValue\"}}";
    String createObjectPath = "/catalogs/testString/objects";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PublishObject model
    PublishObject publishObjectModel = new PublishObject.Builder()
    .permitIbmPublicPublish(true)
    .ibmApproved(true)
    .publicApproved(true)
    .portalApprovalRecord("testString")
    .portalUrl("testString")
    .build();

    // Construct an instance of the State model
    State stateModel = new State.Builder()
    .current("testString")
    .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .pending("testString")
    .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .previous("testString")
    .build();

    // Construct an instance of the CreateObjectOptions model
    CreateObjectOptions createObjectOptionsModel = new CreateObjectOptions.Builder()
    .catalogIdentifier("testString")
    .id("testString")
    .name("testString")
    .rev("testString")
    .crn("testString")
    .url("testString")
    .parentId("testString")
    .labelI18n("testString")
    .label("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .shortDescription("testString")
    .shortDescriptionI18n("testString")
    .kind("testString")
    .publish(publishObjectModel)
    .state(stateModel)
    .catalogId("testString")
    .catalogName("testString")
    .data(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogObject> response = catalogManagementService.createObject(createObjectOptionsModel).execute();
    assertNotNull(response);
    CatalogObject responseObj = response.getResult();
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
    assertEquals(parsedPath, createObjectPath);
  }
  
  public void testCreateObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCreateObjectWOptions();

    // Disable retries and run testCreateObjectWOptions.
    catalogManagementService.disableRetries();
    testCreateObjectWOptions();
  }  

  // Test the createObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.createObject(null).execute();
  }

  @Test
  public void testGetObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"_rev\": \"rev\", \"crn\": \"crn\", \"url\": \"url\", \"parent_id\": \"parentId\", \"label_i18n\": \"labelI18n\", \"label\": \"label\", \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"short_description_i18n\": \"shortDescriptionI18n\", \"kind\": \"kind\", \"publish\": {\"permit_ibm_public_publish\": true, \"ibm_approved\": false, \"public_approved\": true, \"portal_approval_record\": \"portalApprovalRecord\", \"portal_url\": \"portalUrl\"}, \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"data\": {\"mapKey\": \"anyValue\"}}";
    String getObjectPath = "/catalogs/testString/objects/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectOptions model
    GetObjectOptions getObjectOptionsModel = new GetObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogObject> response = catalogManagementService.getObject(getObjectOptionsModel).execute();
    assertNotNull(response);
    CatalogObject responseObj = response.getResult();
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
    assertEquals(parsedPath, getObjectPath);
  }
  
  public void testGetObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetObjectWOptions();

    // Disable retries and run testGetObjectWOptions.
    catalogManagementService.disableRetries();
    testGetObjectWOptions();
  }  

  // Test the getObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getObject(null).execute();
  }

  @Test
  public void testReplaceObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"name\": \"name\", \"_rev\": \"rev\", \"crn\": \"crn\", \"url\": \"url\", \"parent_id\": \"parentId\", \"label_i18n\": \"labelI18n\", \"label\": \"label\", \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"short_description\": \"shortDescription\", \"short_description_i18n\": \"shortDescriptionI18n\", \"kind\": \"kind\", \"publish\": {\"permit_ibm_public_publish\": true, \"ibm_approved\": false, \"public_approved\": true, \"portal_approval_record\": \"portalApprovalRecord\", \"portal_url\": \"portalUrl\"}, \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00.000Z\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00.000Z\", \"previous\": \"previous\"}, \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"data\": {\"mapKey\": \"anyValue\"}}";
    String replaceObjectPath = "/catalogs/testString/objects/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PublishObject model
    PublishObject publishObjectModel = new PublishObject.Builder()
    .permitIbmPublicPublish(true)
    .ibmApproved(true)
    .publicApproved(true)
    .portalApprovalRecord("testString")
    .portalUrl("testString")
    .build();

    // Construct an instance of the State model
    State stateModel = new State.Builder()
    .current("testString")
    .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .pending("testString")
    .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .previous("testString")
    .build();

    // Construct an instance of the ReplaceObjectOptions model
    ReplaceObjectOptions replaceObjectOptionsModel = new ReplaceObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .id("testString")
    .name("testString")
    .rev("testString")
    .crn("testString")
    .url("testString")
    .parentId("testString")
    .labelI18n("testString")
    .label("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    .shortDescription("testString")
    .shortDescriptionI18n("testString")
    .kind("testString")
    .publish(publishObjectModel)
    .state(stateModel)
    .catalogId("testString")
    .catalogName("testString")
    .data(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogObject> response = catalogManagementService.replaceObject(replaceObjectOptionsModel).execute();
    assertNotNull(response);
    CatalogObject responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, replaceObjectPath);
  }
  
  public void testReplaceObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testReplaceObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testReplaceObjectWOptions();

    // Disable retries and run testReplaceObjectWOptions.
    catalogManagementService.disableRetries();
    testReplaceObjectWOptions();
  }  

  // Test the replaceObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.replaceObject(null).execute();
  }

  @Test
  public void testDeleteObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteObjectPath = "/catalogs/testString/objects/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteObjectOptions model
    DeleteObjectOptions deleteObjectOptionsModel = new DeleteObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteObject(deleteObjectOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteObjectPath);
  }
  
  public void testDeleteObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteObjectWOptions();

    // Disable retries and run testDeleteObjectWOptions.
    catalogManagementService.disableRetries();
    testDeleteObjectWOptions();
  }  

  // Test the deleteObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteObject(null).execute();
  }

  @Test
  public void testGetObjectAuditWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"list\": [{\"id\": \"id\", \"created\": \"2019-01-01T12:00:00.000Z\", \"change_type\": \"changeType\", \"target_type\": \"targetType\", \"target_id\": \"targetId\", \"who_delegate_email\": \"whoDelegateEmail\", \"message\": \"message\"}]}";
    String getObjectAuditPath = "/catalogs/testString/objects/testString/audit";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectAuditOptions model
    GetObjectAuditOptions getObjectAuditOptionsModel = new GetObjectAuditOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AuditLog> response = catalogManagementService.getObjectAudit(getObjectAuditOptionsModel).execute();
    assertNotNull(response);
    AuditLog responseObj = response.getResult();
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
    assertEquals(parsedPath, getObjectAuditPath);
  }
  
  public void testGetObjectAuditWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetObjectAuditWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetObjectAuditWOptions();

    // Disable retries and run testGetObjectAuditWOptions.
    catalogManagementService.disableRetries();
    testGetObjectAuditWOptions();
  }  

  // Test the getObjectAudit operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetObjectAuditNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getObjectAudit(null).execute();
  }

  @Test
  public void testAccountPublishObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String accountPublishObjectPath = "/catalogs/testString/objects/testString/account-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AccountPublishObjectOptions model
    AccountPublishObjectOptions accountPublishObjectOptionsModel = new AccountPublishObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.accountPublishObject(accountPublishObjectOptionsModel).execute();
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
    assertEquals(parsedPath, accountPublishObjectPath);
  }
  
  public void testAccountPublishObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testAccountPublishObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testAccountPublishObjectWOptions();

    // Disable retries and run testAccountPublishObjectWOptions.
    catalogManagementService.disableRetries();
    testAccountPublishObjectWOptions();
  }  

  // Test the accountPublishObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAccountPublishObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.accountPublishObject(null).execute();
  }

  @Test
  public void testSharedPublishObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String sharedPublishObjectPath = "/catalogs/testString/objects/testString/shared-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SharedPublishObjectOptions model
    SharedPublishObjectOptions sharedPublishObjectOptionsModel = new SharedPublishObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.sharedPublishObject(sharedPublishObjectOptionsModel).execute();
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
    assertEquals(parsedPath, sharedPublishObjectPath);
  }
  
  public void testSharedPublishObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testSharedPublishObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testSharedPublishObjectWOptions();

    // Disable retries and run testSharedPublishObjectWOptions.
    catalogManagementService.disableRetries();
    testSharedPublishObjectWOptions();
  }  

  // Test the sharedPublishObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSharedPublishObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.sharedPublishObject(null).execute();
  }

  @Test
  public void testIbmPublishObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String ibmPublishObjectPath = "/catalogs/testString/objects/testString/ibm-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the IbmPublishObjectOptions model
    IbmPublishObjectOptions ibmPublishObjectOptionsModel = new IbmPublishObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.ibmPublishObject(ibmPublishObjectOptionsModel).execute();
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
    assertEquals(parsedPath, ibmPublishObjectPath);
  }
  
  public void testIbmPublishObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testIbmPublishObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testIbmPublishObjectWOptions();

    // Disable retries and run testIbmPublishObjectWOptions.
    catalogManagementService.disableRetries();
    testIbmPublishObjectWOptions();
  }  

  // Test the ibmPublishObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIbmPublishObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.ibmPublishObject(null).execute();
  }

  @Test
  public void testPublicPublishObjectWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String publicPublishObjectPath = "/catalogs/testString/objects/testString/public-publish";

    server.enqueue(new MockResponse()
    .setResponseCode(202)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the PublicPublishObjectOptions model
    PublicPublishObjectOptions publicPublishObjectOptionsModel = new PublicPublishObjectOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.publicPublishObject(publicPublishObjectOptionsModel).execute();
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
    assertEquals(parsedPath, publicPublishObjectPath);
  }
  
  public void testPublicPublishObjectWOptionsWRetries() throws Throwable {
    // Enable retries and run testPublicPublishObjectWOptions.
    catalogManagementService.enableRetries(4, 30);
    testPublicPublishObjectWOptions();

    // Disable retries and run testPublicPublishObjectWOptions.
    catalogManagementService.disableRetries();
    testPublicPublishObjectWOptions();
  }  

  // Test the publicPublishObject operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPublicPublishObjectNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.publicPublishObject(null).execute();
  }

  @Test
  public void testCreateObjectAccessWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String createObjectAccessPath = "/catalogs/testString/objects/testString/access/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateObjectAccessOptions model
    CreateObjectAccessOptions createObjectAccessOptionsModel = new CreateObjectAccessOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .accountIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.createObjectAccess(createObjectAccessOptionsModel).execute();
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
    assertEquals(parsedPath, createObjectAccessPath);
  }
  
  public void testCreateObjectAccessWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateObjectAccessWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCreateObjectAccessWOptions();

    // Disable retries and run testCreateObjectAccessWOptions.
    catalogManagementService.disableRetries();
    testCreateObjectAccessWOptions();
  }  

  // Test the createObjectAccess operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateObjectAccessNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.createObjectAccess(null).execute();
  }

  @Test
  public void testGetObjectAccessWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"account\": \"account\", \"catalog_id\": \"catalogId\", \"target_id\": \"targetId\", \"create\": \"2019-01-01T12:00:00.000Z\"}";
    String getObjectAccessPath = "/catalogs/testString/objects/testString/access/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectAccessOptions model
    GetObjectAccessOptions getObjectAccessOptionsModel = new GetObjectAccessOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .accountIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectAccess> response = catalogManagementService.getObjectAccess(getObjectAccessOptionsModel).execute();
    assertNotNull(response);
    ObjectAccess responseObj = response.getResult();
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
    assertEquals(parsedPath, getObjectAccessPath);
  }
  
  public void testGetObjectAccessWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetObjectAccessWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetObjectAccessWOptions();

    // Disable retries and run testGetObjectAccessWOptions.
    catalogManagementService.disableRetries();
    testGetObjectAccessWOptions();
  }  

  // Test the getObjectAccess operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetObjectAccessNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getObjectAccess(null).execute();
  }

  @Test
  public void testDeleteObjectAccessWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteObjectAccessPath = "/catalogs/testString/objects/testString/access/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteObjectAccessOptions model
    DeleteObjectAccessOptions deleteObjectAccessOptionsModel = new DeleteObjectAccessOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .accountIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteObjectAccess(deleteObjectAccessOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteObjectAccessPath);
  }
  
  public void testDeleteObjectAccessWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteObjectAccessWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteObjectAccessWOptions();

    // Disable retries and run testDeleteObjectAccessWOptions.
    catalogManagementService.disableRetries();
    testDeleteObjectAccessWOptions();
  }  

  // Test the deleteObjectAccess operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteObjectAccessNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteObjectAccess(null).execute();
  }

  @Test
  public void testGetObjectAccessListWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"account\": \"account\", \"catalog_id\": \"catalogId\", \"target_id\": \"targetId\", \"create\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getObjectAccessListPath = "/catalogs/testString/objects/testString/access";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetObjectAccessListOptions model
    GetObjectAccessListOptions getObjectAccessListOptionsModel = new GetObjectAccessListOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .limit(Long.valueOf("1000"))
    .offset(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ObjectAccessListResult> response = catalogManagementService.getObjectAccessList(getObjectAccessListOptionsModel).execute();
    assertNotNull(response);
    ObjectAccessListResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("1000"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getObjectAccessListPath);
  }
  
  public void testGetObjectAccessListWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetObjectAccessListWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetObjectAccessListWOptions();

    // Disable retries and run testGetObjectAccessListWOptions.
    catalogManagementService.disableRetries();
    testGetObjectAccessListWOptions();
  }  

  // Test the getObjectAccessList operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetObjectAccessListNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getObjectAccessList(null).execute();
  }

  @Test
  public void testDeleteObjectAccessListWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"errors\": {\"mapKey\": \"inner\"}}";
    String deleteObjectAccessListPath = "/catalogs/testString/objects/testString/access";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteObjectAccessListOptions model
    DeleteObjectAccessListOptions deleteObjectAccessListOptionsModel = new DeleteObjectAccessListOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccessListBulkResponse> response = catalogManagementService.deleteObjectAccessList(deleteObjectAccessListOptionsModel).execute();
    assertNotNull(response);
    AccessListBulkResponse responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteObjectAccessListPath);
  }
  
  public void testDeleteObjectAccessListWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteObjectAccessListWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteObjectAccessListWOptions();

    // Disable retries and run testDeleteObjectAccessListWOptions.
    catalogManagementService.disableRetries();
    testDeleteObjectAccessListWOptions();
  }  

  // Test the deleteObjectAccessList operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteObjectAccessListNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteObjectAccessList(null).execute();
  }

  @Test
  public void testAddObjectAccessListWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"errors\": {\"mapKey\": \"inner\"}}";
    String addObjectAccessListPath = "/catalogs/testString/objects/testString/access";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the AddObjectAccessListOptions model
    AddObjectAccessListOptions addObjectAccessListOptionsModel = new AddObjectAccessListOptions.Builder()
    .catalogIdentifier("testString")
    .objectIdentifier("testString")
    .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<AccessListBulkResponse> response = catalogManagementService.addObjectAccessList(addObjectAccessListOptionsModel).execute();
    assertNotNull(response);
    AccessListBulkResponse responseObj = response.getResult();
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
    assertEquals(parsedPath, addObjectAccessListPath);
  }
  
  public void testAddObjectAccessListWOptionsWRetries() throws Throwable {
    // Enable retries and run testAddObjectAccessListWOptions.
    catalogManagementService.enableRetries(4, 30);
    testAddObjectAccessListWOptions();

    // Disable retries and run testAddObjectAccessListWOptions.
    catalogManagementService.disableRetries();
    testAddObjectAccessListWOptions();
  }  

  // Test the addObjectAccessList operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAddObjectAccessListNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.addObjectAccessList(null).execute();
  }

  @Test
  public void testCreateOfferingInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"catalog_id\": \"catalogId\", \"offering_id\": \"offeringId\", \"kind_format\": \"kindFormat\", \"version\": \"version\", \"cluster_id\": \"clusterId\", \"cluster_region\": \"clusterRegion\", \"cluster_namespaces\": [\"clusterNamespaces\"], \"cluster_all_namespaces\": true, \"schematics_workspace_id\": \"schematicsWorkspaceId\", \"resource_group_id\": \"resourceGroupId\", \"install_plan\": \"installPlan\", \"channel\": \"channel\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"last_operation\": {\"operation\": \"operation\", \"state\": \"state\", \"message\": \"message\", \"transaction_id\": \"transactionId\", \"updated\": \"updated\"}}";
    String createOfferingInstancePath = "/instances/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the OfferingInstanceLastOperation model
    OfferingInstanceLastOperation offeringInstanceLastOperationModel = new OfferingInstanceLastOperation.Builder()
    .operation("testString")
    .state("testString")
    .message("testString")
    .transactionId("testString")
    .updated("testString")
    .build();

    // Construct an instance of the CreateOfferingInstanceOptions model
    CreateOfferingInstanceOptions createOfferingInstanceOptionsModel = new CreateOfferingInstanceOptions.Builder()
    .xAuthRefreshToken("testString")
    .id("testString")
    .rev("testString")
    .url("testString")
    .crn("testString")
    .label("testString")
    .catalogId("testString")
    .offeringId("testString")
    .kindFormat("testString")
    .version("testString")
    .clusterId("testString")
    .clusterRegion("testString")
    .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .clusterAllNamespaces(true)
    .schematicsWorkspaceId("testString")
    .resourceGroupId("testString")
    .installPlan("testString")
    .channel("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .lastOperation(offeringInstanceLastOperationModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingInstance> response = catalogManagementService.createOfferingInstance(createOfferingInstanceOptionsModel).execute();
    assertNotNull(response);
    OfferingInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createOfferingInstancePath);
  }
  
  public void testCreateOfferingInstanceWOptionsWRetries() throws Throwable {
    // Enable retries and run testCreateOfferingInstanceWOptions.
    catalogManagementService.enableRetries(4, 30);
    testCreateOfferingInstanceWOptions();

    // Disable retries and run testCreateOfferingInstanceWOptions.
    catalogManagementService.disableRetries();
    testCreateOfferingInstanceWOptions();
  }  

  // Test the createOfferingInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOfferingInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.createOfferingInstance(null).execute();
  }

  @Test
  public void testGetOfferingInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"catalog_id\": \"catalogId\", \"offering_id\": \"offeringId\", \"kind_format\": \"kindFormat\", \"version\": \"version\", \"cluster_id\": \"clusterId\", \"cluster_region\": \"clusterRegion\", \"cluster_namespaces\": [\"clusterNamespaces\"], \"cluster_all_namespaces\": true, \"schematics_workspace_id\": \"schematicsWorkspaceId\", \"resource_group_id\": \"resourceGroupId\", \"install_plan\": \"installPlan\", \"channel\": \"channel\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"last_operation\": {\"operation\": \"operation\", \"state\": \"state\", \"message\": \"message\", \"transaction_id\": \"transactionId\", \"updated\": \"updated\"}}";
    String getOfferingInstancePath = "/instances/offerings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetOfferingInstanceOptions model
    GetOfferingInstanceOptions getOfferingInstanceOptionsModel = new GetOfferingInstanceOptions.Builder()
    .instanceIdentifier("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingInstance> response = catalogManagementService.getOfferingInstance(getOfferingInstanceOptionsModel).execute();
    assertNotNull(response);
    OfferingInstance responseObj = response.getResult();
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
    assertEquals(parsedPath, getOfferingInstancePath);
  }
  
  public void testGetOfferingInstanceWOptionsWRetries() throws Throwable {
    // Enable retries and run testGetOfferingInstanceWOptions.
    catalogManagementService.enableRetries(4, 30);
    testGetOfferingInstanceWOptions();

    // Disable retries and run testGetOfferingInstanceWOptions.
    catalogManagementService.disableRetries();
    testGetOfferingInstanceWOptions();
  }  

  // Test the getOfferingInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.getOfferingInstance(null).execute();
  }

  @Test
  public void testPutOfferingInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"catalog_id\": \"catalogId\", \"offering_id\": \"offeringId\", \"kind_format\": \"kindFormat\", \"version\": \"version\", \"cluster_id\": \"clusterId\", \"cluster_region\": \"clusterRegion\", \"cluster_namespaces\": [\"clusterNamespaces\"], \"cluster_all_namespaces\": true, \"schematics_workspace_id\": \"schematicsWorkspaceId\", \"resource_group_id\": \"resourceGroupId\", \"install_plan\": \"installPlan\", \"channel\": \"channel\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"last_operation\": {\"operation\": \"operation\", \"state\": \"state\", \"message\": \"message\", \"transaction_id\": \"transactionId\", \"updated\": \"updated\"}}";
    String putOfferingInstancePath = "/instances/offerings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the OfferingInstanceLastOperation model
    OfferingInstanceLastOperation offeringInstanceLastOperationModel = new OfferingInstanceLastOperation.Builder()
    .operation("testString")
    .state("testString")
    .message("testString")
    .transactionId("testString")
    .updated("testString")
    .build();

    // Construct an instance of the PutOfferingInstanceOptions model
    PutOfferingInstanceOptions putOfferingInstanceOptionsModel = new PutOfferingInstanceOptions.Builder()
    .instanceIdentifier("testString")
    .xAuthRefreshToken("testString")
    .id("testString")
    .rev("testString")
    .url("testString")
    .crn("testString")
    .label("testString")
    .catalogId("testString")
    .offeringId("testString")
    .kindFormat("testString")
    .version("testString")
    .clusterId("testString")
    .clusterRegion("testString")
    .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .clusterAllNamespaces(true)
    .schematicsWorkspaceId("testString")
    .resourceGroupId("testString")
    .installPlan("testString")
    .channel("testString")
    .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
    .lastOperation(offeringInstanceLastOperationModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingInstance> response = catalogManagementService.putOfferingInstance(putOfferingInstanceOptionsModel).execute();
    assertNotNull(response);
    OfferingInstance responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, putOfferingInstancePath);
  }
  
  public void testPutOfferingInstanceWOptionsWRetries() throws Throwable {
    // Enable retries and run testPutOfferingInstanceWOptions.
    catalogManagementService.enableRetries(4, 30);
    testPutOfferingInstanceWOptions();

    // Disable retries and run testPutOfferingInstanceWOptions.
    catalogManagementService.disableRetries();
    testPutOfferingInstanceWOptions();
  }  

  // Test the putOfferingInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutOfferingInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.putOfferingInstance(null).execute();
  }

  @Test
  public void testDeleteOfferingInstanceWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteOfferingInstancePath = "/instances/offerings/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteOfferingInstanceOptions model
    DeleteOfferingInstanceOptions deleteOfferingInstanceOptionsModel = new DeleteOfferingInstanceOptions.Builder()
    .instanceIdentifier("testString")
    .xAuthRefreshToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = catalogManagementService.deleteOfferingInstance(deleteOfferingInstanceOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    assertEquals(request.getHeader("X-Auth-Refresh-Token"), "testString");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteOfferingInstancePath);
  }
  
  public void testDeleteOfferingInstanceWOptionsWRetries() throws Throwable {
    // Enable retries and run testDeleteOfferingInstanceWOptions.
    catalogManagementService.enableRetries(4, 30);
    testDeleteOfferingInstanceWOptions();

    // Disable retries and run testDeleteOfferingInstanceWOptions.
    catalogManagementService.disableRetries();
    testDeleteOfferingInstanceWOptions();
  }  

  // Test the deleteOfferingInstance operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOfferingInstanceNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    catalogManagementService.deleteOfferingInstance(null).execute();
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
    catalogManagementService = null;
  }
}