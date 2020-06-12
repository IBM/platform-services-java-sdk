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
package com.ibm.cloud.platform_services.catalog_management.v1;

import com.ibm.cloud.platform_services.catalog_management.v1.CatalogManagement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountGroup;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFiltersCatalogFiltersItem;
import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFiltersCatalogFiltersItemCatalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ApprovalResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CanDeploySchematicsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CategoryFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CommitVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Configuration;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateLicenseEntitlementOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOperatorOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteLicenseEntitlementOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOperatorOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployRequestBodySchematics;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployRequirementsCheck;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Deployment;
import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Enterprise;
import com.ibm.cloud.platform_services.catalog_management.v1.model.EnterpriseAccountGroups;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Feature;
import com.ibm.cloud.platform_services.catalog_management.v1.model.FilterTerms;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Filters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountFiltersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetClusterOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetConsumptionOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetEnterpriseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetLicenseEntitlementsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetLicenseProvidersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetLicensesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOverrideValuesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetPreinstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetRepoOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetReposOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetResourceGroupsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetSchematicsWorkspacesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetValidationStatusOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionAboutOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionContainerImagesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionLicenseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionUpdatesOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionWorkingCopyOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmChart;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmPackage;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmPackageChart;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmRepoList;
import com.ibm.cloud.platform_services.catalog_management.v1.model.HelmRepoListChart;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IDFilter;
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
import com.ibm.cloud.platform_services.catalog_management.v1.model.Kind;
import com.ibm.cloud.platform_services.catalog_management.v1.model.License;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlementHistoryItem;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseEntitlements;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseObject;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseOfferingReference;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseProvider;
import com.ibm.cloud.platform_services.catalog_management.v1.model.LicenseProviders;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Licenses;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListCatalogsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListClustersOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListLicenseEntitlementsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOperatorsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ListVersionsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Maintainers;
import com.ibm.cloud.platform_services.catalog_management.v1.model.NamespaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.OperatorDeployResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Plan;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PreinstallVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishVersionOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Rating;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceEnterpriseOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingIconOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOperatorOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.RepoInfo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Resource;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ResourceGroup;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ResourceGroups;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspace;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceCatalogRef;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceRuntimeData;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceSearchResult;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceTemplateRepo;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SchematicsWorkspaceWorkspaceStatus;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Script;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchLicenseOfferingsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchLicenseVersionsOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationAuthorization;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationResource;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateCatalogAccountOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingIbmOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
import com.ibm.cloud.platform_services.catalog_management.v1.model.ValidationInstallOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionEntitlement;
import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
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
 * Unit test class for the CatalogManagement service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class CatalogManagementTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected CatalogManagement testService;

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

    testService = CatalogManagement.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
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
    String mockResponseBody = "{\"id\": \"id\", \"account_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}}";
    String getCatalogAccountPath = "/catalogaccount";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogAccountOptions model
    GetCatalogAccountOptions getCatalogAccountOptionsModel = new GetCatalogAccountOptions();

    // Invoke operation with valid options model (positive test)
    Response<Account> response = testService.getCatalogAccount(getCatalogAccountOptionsModel).execute();
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
    .categoryFilters(new java.util.HashMap<String,CategoryFilter>(){{put("foo", categoryFilterModel); }})
    .idFilters(idFilterModel)
    .build();

    // Construct an instance of the UpdateCatalogAccountOptions model
    UpdateCatalogAccountOptions updateCatalogAccountOptionsModel = new UpdateCatalogAccountOptions.Builder()
    .id("testString")
    .accountFilters(filtersModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateCatalogAccount(updateCatalogAccountOptionsModel).execute();
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
    Response<AccumulatedFilters> response = testService.getCatalogAccountFilters(getCatalogAccountFiltersOptionsModel).execute();
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

  @Test
  public void testListCatalogsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00\"}}}]}";
    String listCatalogsPath = "/catalogs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCatalogsOptions model
    ListCatalogsOptions listCatalogsOptionsModel = new ListCatalogsOptions();

    // Invoke operation with valid options model (positive test)
    Response<CatalogSearchResult> response = testService.listCatalogs(listCatalogsOptionsModel).execute();
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

  @Test
  public void testCreateCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00\"}}}";
    String createCatalogPath = "/catalogs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FilterTerms model
    FilterTerms filterTermsModel = new FilterTerms.Builder()
    .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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

    // Construct an instance of the SyndicationAuthorization model
    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
    .token("testString")
    .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the SyndicationHistory model
    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
    .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the Filters model
    Filters filtersModel = new Filters.Builder()
    .includeAll(true)
    .categoryFilters(new java.util.HashMap<String,CategoryFilter>(){{put("foo", categoryFilterModel); }})
    .idFilters(idFilterModel)
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
    .url("testString")
    .crn("testString")
    .offeringsUrl("testString")
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .disabled(true)
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .resourceGroupId("testString")
    .owningAccount("testString")
    .catalogFilters(filtersModel)
    .syndicationSettings(syndicationResourceModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Catalog> response = testService.createCatalog(createCatalogOptionsModel).execute();
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

  @Test
  public void testGetCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00\"}}}";
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
    Response<Catalog> response = testService.getCatalog(getCatalogOptionsModel).execute();
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

  // Test the getCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getCatalog(null).execute();
  }

  @Test
  public void testReplaceCatalogWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00\"}}}";
    String replaceCatalogPath = "/catalogs/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the FilterTerms model
    FilterTerms filterTermsModel = new FilterTerms.Builder()
    .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
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

    // Construct an instance of the SyndicationAuthorization model
    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
    .token("testString")
    .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the SyndicationHistory model
    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
    .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the Filters model
    Filters filtersModel = new Filters.Builder()
    .includeAll(true)
    .categoryFilters(new java.util.HashMap<String,CategoryFilter>(){{put("foo", categoryFilterModel); }})
    .idFilters(idFilterModel)
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
    .url("testString")
    .crn("testString")
    .offeringsUrl("testString")
    .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .disabled(true)
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .resourceGroupId("testString")
    .owningAccount("testString")
    .catalogFilters(filtersModel)
    .syndicationSettings(syndicationResourceModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Catalog> response = testService.replaceCatalog(replaceCatalogOptionsModel).execute();
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

  // Test the replaceCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceCatalog(null).execute();
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
    Response<Void> response = testService.deleteCatalog(deleteCatalogOptionsModel).execute();
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

  // Test the deleteCatalog operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCatalogNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteCatalog(null).execute();
  }

  @Test
  public void testGetEnterpriseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"account_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"account_groups\": {\"keys\": {\"id\": \"id\", \"account_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}}}}";
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
    Response<Enterprise> response = testService.getEnterprise(getEnterpriseOptionsModel).execute();
    assertNotNull(response);
    Enterprise responseObj = response.getResult();
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
  public void testReplaceEnterpriseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String replaceEnterprisePath = "/enterprises/testString";

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
    .categoryFilters(new java.util.HashMap<String,CategoryFilter>(){{put("foo", categoryFilterModel); }})
    .idFilters(idFilterModel)
    .build();

    // Construct an instance of the AccountGroup model
    AccountGroup accountGroupModel = new AccountGroup.Builder()
    .id("testString")
    .accountFilters(filtersModel)
    .build();

    // Construct an instance of the EnterpriseAccountGroups model
    EnterpriseAccountGroups enterpriseAccountGroupsModel = new EnterpriseAccountGroups.Builder()
    .keys(accountGroupModel)
    .build();

    // Construct an instance of the ReplaceEnterpriseOptions model
    ReplaceEnterpriseOptions replaceEnterpriseOptionsModel = new ReplaceEnterpriseOptions.Builder()
    .enterpriseId("testString")
    .id("testString")
    .rev("testString")
    .accountFilters(filtersModel)
    .accountGroups(enterpriseAccountGroupsModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.replaceEnterprise(replaceEnterpriseOptionsModel).execute();
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
    assertEquals(parsedPath, replaceEnterprisePath);
  }

  // Test the replaceEnterprise operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceEnterpriseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceEnterprise(null).execute();
  }

  @Test
  public void testGetConsumptionOfferingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}]}";
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
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingSearchResult> response = testService.getConsumptionOfferings(getConsumptionOfferingsOptionsModel).execute();
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
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getConsumptionOfferingsPath);
  }

  @Test
  public void testListOfferingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}]}";
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
    .build();

    // Invoke operation with valid options model (positive test)
    Response<OfferingSearchResult> response = testService.listOfferings(listOfferingsOptionsModel).execute();
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
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listOfferingsPath);
  }

  // Test the listOfferings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListOfferingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listOfferings(null).execute();
  }

  @Test
  public void testCreateOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
    String createOfferingPath = "/catalogs/testString/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

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

    // Construct an instance of the Deployment model
    Deployment deploymentModel = new Deployment.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the License model
    License licenseModel = new License.Builder()
    .id("testString")
    .name("testString")
    .type("testString")
    .url("testString")
    .description("testString")
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

    // Construct an instance of the State model
    State stateModel = new State.Builder()
    .current("testString")
    .currentEntered(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .pending("testString")
    .pendingRequested(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .previous("testString")
    .build();

    // Construct an instance of the Validation model
    Validation validationModel = new Validation.Builder()
    .validated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .requested(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .state("testString")
    .lastOperation("testString")
    .target(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .build();

    // Construct an instance of the VersionEntitlement model
    VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
    .providerName("testString")
    .providerId("testString")
    .productId("testString")
    .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .imageRepoName("testString")
    .build();

    // Construct an instance of the Plan model
    Plan planModel = new Plan.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
    .build();

    // Construct an instance of the Version model
    Version versionModel = new Version.Builder()
    .id("testString")
    .rev("testString")
    .crn("testString")
    .version("testString")
    .sha("testString")
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .offeringId("testString")
    .catalogId("testString")
    .kindId("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .repoUrl("testString")
    .sourceUrl("testString")
    .tgzUrl("testString")
    .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
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

    // Construct an instance of the Kind model
    Kind kindModel = new Kind.Builder()
    .id("testString")
    .formatKind("testString")
    .targetKind("testString")
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .installDescription("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
    .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
    .build();

    // Construct an instance of the Rating model
    Rating ratingModel = new Rating.Builder()
    .oneStarCount(Long.valueOf("26"))
    .twoStarCount(Long.valueOf("26"))
    .threeStarCount(Long.valueOf("26"))
    .fourStarCount(Long.valueOf("26"))
    .build();

    // Construct an instance of the RepoInfo model
    RepoInfo repoInfoModel = new RepoInfo.Builder()
    .token("testString")
    .type("testString")
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
    .rating(ratingModel)
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
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
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .disclaimer("testString")
    .hidden(true)
    .provider("testString")
    .repoInfo(repoInfoModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = testService.createOffering(createOfferingOptionsModel).execute();
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

  // Test the createOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createOffering(null).execute();
  }

  @Test
  public void testImportOfferingVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
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
    .zipurl("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetVersion("testString")
    .includeConfig(true)
    .repoType("testString")
    .xAuthToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = testService.importOfferingVersion(importOfferingVersionOptionsModel).execute();
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
    assertEquals(query.get("repoType"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importOfferingVersionPath);
  }

  // Test the importOfferingVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportOfferingVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.importOfferingVersion(null).execute();
  }

  @Test
  public void testImportOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
    String importOfferingPath = "/catalogs/testString/import/offerings";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ImportOfferingOptions model
    ImportOfferingOptions importOfferingOptionsModel = new ImportOfferingOptions.Builder()
    .catalogIdentifier("testString")
    .zipurl("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .offeringId("testString")
    .includeConfig(true)
    .repoType("testString")
    .xAuthToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = testService.importOffering(importOfferingOptionsModel).execute();
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
    assertEquals(Boolean.valueOf(query.get("includeConfig")), Boolean.valueOf(true));
    assertEquals(query.get("repoType"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, importOfferingPath);
  }

  // Test the importOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.importOffering(null).execute();
  }

  @Test
  public void testReloadOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
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
    .zipurl("testString")
    .targetVersion("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .repoType("testString")
    .xAuthToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = testService.reloadOffering(reloadOfferingOptionsModel).execute();
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
    assertEquals(query.get("zipurl"), "testString");
    assertEquals(query.get("targetVersion"), "testString");
    assertEquals(query.get("repoType"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, reloadOfferingPath);
  }

  // Test the reloadOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReloadOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.reloadOffering(null).execute();
  }

  @Test
  public void testGetOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
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
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Offering> response = testService.getOffering(getOfferingOptionsModel).execute();
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
    assertEquals(parsedPath, getOfferingPath);
  }

  // Test the getOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getOffering(null).execute();
  }

  @Test
  public void testReplaceOfferingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"label\": \"label\", \"short_description\": \"shortDescription\", \"catalog_icon_url\": \"catalogIconUrl\", \"tags\": [\"tags\"], \"url\": \"url\", \"crn\": \"crn\", \"offerings_url\": \"offeringsUrl\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"disabled\": true, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"resource_group_id\": \"resourceGroupId\", \"owning_account\": \"owningAccount\", \"catalog_filters\": {\"include_all\": true, \"category_filters\": {\"mapKey\": {\"include\": false, \"filter\": {\"filter_terms\": [\"filterTerms\"]}}}, \"id_filters\": {\"include\": {\"filter_terms\": [\"filterTerms\"]}, \"exclude\": {\"filter_terms\": [\"filterTerms\"]}}}, \"syndication_settings\": {\"remove_related_components\": false, \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"history\": {\"namespaces\": [\"namespaces\"], \"clusters\": [{\"region\": \"region\", \"id\": \"id\", \"name\": \"name\", \"resource_group_name\": \"resourceGroupName\", \"type\": \"type\", \"namespaces\": [\"namespaces\"], \"all_namespaces\": false}], \"last_run\": \"2019-01-01T12:00:00\"}, \"authorization\": {\"token\": \"token\", \"last_run\": \"2019-01-01T12:00:00\"}}}";
    String replaceOfferingPath = "/catalogs/testString/offerings/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

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

    // Construct an instance of the Deployment model
    Deployment deploymentModel = new Deployment.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the Feature model
    Feature featureModel = new Feature.Builder()
    .title("testString")
    .description("testString")
    .build();

    // Construct an instance of the License model
    License licenseModel = new License.Builder()
    .id("testString")
    .name("testString")
    .type("testString")
    .url("testString")
    .description("testString")
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

    // Construct an instance of the State model
    State stateModel = new State.Builder()
    .current("testString")
    .currentEntered(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .pending("testString")
    .pendingRequested(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .previous("testString")
    .build();

    // Construct an instance of the Validation model
    Validation validationModel = new Validation.Builder()
    .validated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .requested(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .state("testString")
    .lastOperation("testString")
    .target(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .build();

    // Construct an instance of the VersionEntitlement model
    VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
    .providerName("testString")
    .providerId("testString")
    .productId("testString")
    .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .imageRepoName("testString")
    .build();

    // Construct an instance of the Plan model
    Plan planModel = new Plan.Builder()
    .id("testString")
    .label("testString")
    .name("testString")
    .shortDescription("testString")
    .longDescription("testString")
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
    .build();

    // Construct an instance of the Version model
    Version versionModel = new Version.Builder()
    .id("testString")
    .rev("testString")
    .crn("testString")
    .version("testString")
    .sha("testString")
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .offeringId("testString")
    .catalogId("testString")
    .kindId("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .repoUrl("testString")
    .sourceUrl("testString")
    .tgzUrl("testString")
    .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
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

    // Construct an instance of the Kind model
    Kind kindModel = new Kind.Builder()
    .id("testString")
    .formatKind("testString")
    .targetKind("testString")
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .installDescription("testString")
    .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
    .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
    .build();

    // Construct an instance of the Rating model
    Rating ratingModel = new Rating.Builder()
    .oneStarCount(Long.valueOf("26"))
    .twoStarCount(Long.valueOf("26"))
    .threeStarCount(Long.valueOf("26"))
    .fourStarCount(Long.valueOf("26"))
    .build();

    // Construct an instance of the RepoInfo model
    RepoInfo repoInfoModel = new RepoInfo.Builder()
    .token("testString")
    .type("testString")
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
    .rating(ratingModel)
    .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
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
    .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .disclaimer("testString")
    .hidden(true)
    .provider("testString")
    .repoInfo(repoInfoModel)
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Catalog> response = testService.replaceOffering(replaceOfferingOptionsModel).execute();
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
    assertEquals(parsedPath, replaceOfferingPath);
  }

  // Test the replaceOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceOffering(null).execute();
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
    Response<Void> response = testService.deleteOffering(deleteOfferingOptionsModel).execute();
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

  // Test the deleteOffering operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOfferingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteOffering(null).execute();
  }

  @Test
  public void testReplaceOfferingIconWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
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
    Response<Offering> response = testService.replaceOfferingIcon(replaceOfferingIconOptionsModel).execute();
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

  // Test the replaceOfferingIcon operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOfferingIconNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceOfferingIcon(null).execute();
  }

  @Test
  public void testUpdateOfferingIbmWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"ibm\": false, \"public\": false, \"changed\": false}";
    String updateOfferingIbmPath = "/catalogs/testString/offerings/testString/publish/ibm/true";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UpdateOfferingIbmOptions model
    UpdateOfferingIbmOptions updateOfferingIbmOptionsModel = new UpdateOfferingIbmOptions.Builder()
    .catalogIdentifier("testString")
    .offeringId("testString")
    .approvalType("ibm")
    .approved("true")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ApprovalResult> response = testService.updateOfferingIbm(updateOfferingIbmOptionsModel).execute();
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

  // Test the updateOfferingIbm operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateOfferingIbmNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateOfferingIbm(null).execute();
  }

  @Test
  public void testGetVersionAboutWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "\"operationResponse\"";
    String getVersionAboutPath = "/versions/testString/about";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "text/markdown")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVersionAboutOptions model
    GetVersionAboutOptions getVersionAboutOptionsModel = new GetVersionAboutOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<String> response = testService.getVersionAbout(getVersionAboutOptionsModel).execute();
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
    assertEquals(parsedPath, getVersionAboutPath);
  }

  // Test the getVersionAbout operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionAboutNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVersionAbout(null).execute();
  }

  @Test
  public void testGetVersionLicenseWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getVersionLicensePath = "/versions/testString/licenses/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVersionLicenseOptions model
    GetVersionLicenseOptions getVersionLicenseOptionsModel = new GetVersionLicenseOptions.Builder()
    .versionLocId("testString")
    .licenseId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getVersionLicense(getVersionLicenseOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNull(query);

    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getVersionLicensePath);
  }

  // Test the getVersionLicense operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionLicenseNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVersionLicense(null).execute();
  }

  @Test
  public void testGetVersionContainerImagesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"description\": \"description\", \"images\": [{\"image\": \"image\"}]}";
    String getVersionContainerImagesPath = "/versions/testString/containerImages";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVersionContainerImagesOptions model
    GetVersionContainerImagesOptions getVersionContainerImagesOptionsModel = new GetVersionContainerImagesOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ImageManifest> response = testService.getVersionContainerImages(getVersionContainerImagesOptionsModel).execute();
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
    assertEquals(parsedPath, getVersionContainerImagesPath);
  }

  // Test the getVersionContainerImages operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionContainerImagesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVersionContainerImages(null).execute();
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
    Response<Void> response = testService.deprecateVersion(deprecateVersionOptionsModel).execute();
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

  // Test the deprecateVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeprecateVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deprecateVersion(null).execute();
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
    Response<Void> response = testService.accountPublishVersion(accountPublishVersionOptionsModel).execute();
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

  // Test the accountPublishVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAccountPublishVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.accountPublishVersion(null).execute();
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
    Response<Void> response = testService.ibmPublishVersion(ibmPublishVersionOptionsModel).execute();
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

  // Test the ibmPublishVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testIbmPublishVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.ibmPublishVersion(null).execute();
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
    Response<Void> response = testService.publicPublishVersion(publicPublishVersionOptionsModel).execute();
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

  // Test the publicPublishVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPublicPublishVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.publicPublishVersion(null).execute();
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
    Response<Void> response = testService.commitVersion(commitVersionOptionsModel).execute();
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

  // Test the commitVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCommitVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.commitVersion(null).execute();
  }

  @Test
  public void testGetVersionWorkingCopyWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}";
    String getVersionWorkingCopyPath = "/versions/testString/workingcopy";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVersionWorkingCopyOptions model
    GetVersionWorkingCopyOptions getVersionWorkingCopyOptionsModel = new GetVersionWorkingCopyOptions.Builder()
    .versionLocId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Version> response = testService.getVersionWorkingCopy(getVersionWorkingCopyOptionsModel).execute();
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
    assertEquals(parsedPath, getVersionWorkingCopyPath);
  }

  // Test the getVersionWorkingCopy operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionWorkingCopyNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVersionWorkingCopy(null).execute();
  }

  @Test
  public void testGetVersionUpdatesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"version_locator\": \"versionLocator\", \"version\": \"version\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"package_version\": \"packageVersion\", \"can_update\": false, \"messages\": {\"mapKey\": \"anyValue\"}}]";
    String getVersionUpdatesPath = "/versions/testString/updates";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVersionUpdatesOptions model
    GetVersionUpdatesOptions getVersionUpdatesOptionsModel = new GetVersionUpdatesOptions.Builder()
    .versionLocId("testString")
    .clusterId("testString")
    .region("testString")
    .resourceGroupId("testString")
    .namespace("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<VersionUpdateDescriptor>> response = testService.getVersionUpdates(getVersionUpdatesOptionsModel).execute();
    assertNotNull(response);
    List<VersionUpdateDescriptor> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("cluster_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    assertEquals(query.get("namespace"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getVersionUpdatesPath);
  }

  // Test the getVersionUpdates operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionUpdatesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVersionUpdates(null).execute();
  }

  @Test
  public void testGetVersionWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"id\": \"id\", \"_rev\": \"rev\", \"url\": \"url\", \"crn\": \"crn\", \"label\": \"label\", \"name\": \"name\", \"offering_icon_url\": \"offeringIconUrl\", \"offering_docs_url\": \"offeringDocsUrl\", \"offering_support_url\": \"offeringSupportUrl\", \"tags\": [\"tags\"], \"rating\": {\"one_star_count\": 12, \"two_star_count\": 12, \"three_star_count\": 14, \"four_star_count\": 13}, \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"features\": [{\"title\": \"title\", \"description\": \"description\"}], \"kinds\": [{\"id\": \"id\", \"format_kind\": \"formatKind\", \"target_kind\": \"targetKind\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"install_description\": \"installDescription\", \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"versions\": [{\"id\": \"id\", \"_rev\": \"rev\", \"crn\": \"crn\", \"version\": \"version\", \"sha\": \"sha\", \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"offering_id\": \"offeringId\", \"catalog_id\": \"catalogId\", \"kind_id\": \"kindId\", \"tags\": [\"tags\"], \"repo_url\": \"repoUrl\", \"source_url\": \"sourceUrl\", \"tgz_url\": \"tgzUrl\", \"configuration\": [{\"key\": \"key\", \"type\": \"type\", \"default_value\": \"anyValue\", \"value_constraint\": \"valueConstraint\", \"description\": \"description\", \"required\": true, \"options\": [\"anyValue\"], \"hidden\": true}], \"metadata\": {\"mapKey\": \"anyValue\"}, \"validation\": {\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}, \"required_resources\": [{\"type\": \"mem\", \"value\": \"anyValue\"}], \"single_instance\": true, \"install\": {\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}, \"pre_install\": [{\"instructions\": \"instructions\", \"script\": \"script\", \"script_permission\": \"scriptPermission\", \"delete_script\": \"deleteScript\", \"scope\": \"scope\"}], \"entitlement\": {\"provider_name\": \"providerName\", \"provider_id\": \"providerId\", \"product_id\": \"productId\", \"part_numbers\": [\"partNumbers\"], \"image_repo_name\": \"imageRepoName\"}, \"licenses\": [{\"id\": \"id\", \"name\": \"name\", \"type\": \"type\", \"url\": \"url\", \"description\": \"description\"}], \"image_manifest_url\": \"imageManifestUrl\", \"deprecated\": true, \"package_version\": \"packageVersion\", \"state\": {\"current\": \"current\", \"current_entered\": \"2019-01-01T12:00:00\", \"pending\": \"pending\", \"pending_requested\": \"2019-01-01T12:00:00\", \"previous\": \"previous\"}, \"version_locator\": \"versionLocator\", \"console_url\": \"consoleUrl\", \"long_description\": \"longDescription\", \"whitelisted_accounts\": [\"whitelistedAccounts\"]}], \"plans\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"additional_features\": [{\"title\": \"title\", \"description\": \"description\"}], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\", \"deployments\": [{\"id\": \"id\", \"label\": \"label\", \"name\": \"name\", \"short_description\": \"shortDescription\", \"long_description\": \"longDescription\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"tags\": [\"tags\"], \"created\": \"2019-01-01T12:00:00\", \"updated\": \"2019-01-01T12:00:00\"}]}]}], \"permit_request_ibm_public_publish\": false, \"ibm_publish_approved\": true, \"public_publish_approved\": false, \"public_original_crn\": \"publicOriginalCrn\", \"publish_public_crn\": \"publishPublicCrn\", \"portal_approval_record\": \"portalApprovalRecord\", \"portal_ui_url\": \"portalUiUrl\", \"catalog_id\": \"catalogId\", \"catalog_name\": \"catalogName\", \"metadata\": {\"mapKey\": \"anyValue\"}, \"disclaimer\": \"disclaimer\", \"hidden\": true, \"provider\": \"provider\", \"repo_info\": {\"token\": \"token\", \"type\": \"type\"}}";
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
    Response<Offering> response = testService.getVersion(getVersionOptionsModel).execute();
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

  // Test the getVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVersion(null).execute();
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
    Response<Void> response = testService.deleteVersion(deleteVersionOptionsModel).execute();
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

  // Test the deleteVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteVersion(null).execute();
  }

  @Test
  public void testListVersionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String listVersionsPath = "/versions";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListVersionsOptions model
    ListVersionsOptions listVersionsOptionsModel = new ListVersionsOptions.Builder()
    .q("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.listVersions(listVersionsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("q"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listVersionsPath);
  }

  // Test the listVersions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListVersionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listVersions(null).execute();
  }

  @Test
  public void testGetReposWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"chart\": {\"api_version\": \"apiVersion\", \"created\": \"2019-01-01T12:00:00\", \"description\": \"description\", \"deprecated\": true, \"digest\": \"digest\", \"home\": \"home\", \"icon\": \"icon\", \"keywords\": [\"keywords\"], \"maintainers\": [{\"email\": \"email\", \"name\": \"name\"}], \"name\": \"name\", \"tiller_version\": \"tillerVersion\", \"urls\": [\"urls\"], \"sources\": [\"sources\"], \"version\": \"version\", \"appVersion\": \"appVersion\"}}";
    String getReposPath = "/repo/testString/entries";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetReposOptions model
    GetReposOptions getReposOptionsModel = new GetReposOptions.Builder()
    .type("testString")
    .repourl("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<HelmRepoList> response = testService.getRepos(getReposOptionsModel).execute();
    assertNotNull(response);
    HelmRepoList responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("repourl"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getReposPath);
  }

  // Test the getRepos operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReposNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getRepos(null).execute();
  }

  @Test
  public void testGetRepoWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"chart\": {\"Chart.yaml\": {\"name\": \"name\", \"description\": \"description\", \"icon\": \"icon\", \"version\": \"version\", \"appVersion\": \"appVersion\"}, \"sha\": {\"mapKey\": \"anyValue\"}, \"README.md\": \"readmeMd\", \"values-metadata\": {\"mapKey\": \"anyValue\"}, \"license-metadata\": {\"mapKey\": \"anyValue\"}}}";
    String getRepoPath = "/repo/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetRepoOptions model
    GetRepoOptions getRepoOptionsModel = new GetRepoOptions.Builder()
    .type("testString")
    .charturl("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<HelmPackage> response = testService.getRepo(getRepoOptionsModel).execute();
    assertNotNull(response);
    HelmPackage responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("charturl"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getRepoPath);
  }

  // Test the getRepo operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetRepoNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getRepo(null).execute();
  }

  @Test
  public void testListClustersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"resource_group_id\": \"resourceGroupId\", \"resource_group_name\": \"resourceGroupName\", \"id\": \"id\", \"name\": \"name\", \"region\": \"region\"}]}";
    String listClustersPath = "/deploy/kubernetes/clusters";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListClustersOptions model
    ListClustersOptions listClustersOptionsModel = new ListClustersOptions.Builder()
    .limit(Long.valueOf("26"))
    .offset(Long.valueOf("26"))
    .type("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<ClusterSearchResult> response = testService.listClusters(listClustersOptionsModel).execute();
    assertNotNull(response);
    ClusterSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    assertEquals(query.get("type"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listClustersPath);
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
    Response<ClusterInfo> response = testService.getCluster(getClusterOptionsModel).execute();
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

  // Test the getCluster operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetClusterNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getCluster(null).execute();
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
    .limit(Long.valueOf("26"))
    .offset(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<NamespaceSearchResult> response = testService.getNamespaces(getNamespacesOptionsModel).execute();
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
    assertEquals(Long.valueOf(query.get("limit")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("offset")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getNamespacesPath);
  }

  // Test the getNamespaces operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetNamespacesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getNamespaces(null).execute();
  }

  @Test
  public void testCreateOperatorWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"phase\": \"phase\", \"message\": \"message\", \"link\": \"link\", \"name\": \"name\", \"version\": \"version\", \"namespace\": \"namespace\", \"package_name\": \"packageName\", \"catalog_id\": \"catalogId\"}]";
    String createOperatorPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateOperatorOptions model
    CreateOperatorOptions createOperatorOptionsModel = new CreateOperatorOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<OperatorDeployResult>> response = testService.createOperator(createOperatorOptionsModel).execute();
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
    assertEquals(parsedPath, createOperatorPath);
  }

  // Test the createOperator operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOperatorNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createOperator(null).execute();
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
    Response<List<OperatorDeployResult>> response = testService.listOperators(listOperatorsOptionsModel).execute();
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

  // Test the listOperators operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListOperatorsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listOperators(null).execute();
  }

  @Test
  public void testReplaceOperatorWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"phase\": \"phase\", \"message\": \"message\", \"link\": \"link\", \"name\": \"name\", \"version\": \"version\", \"namespace\": \"namespace\", \"package_name\": \"packageName\", \"catalog_id\": \"catalogId\"}]";
    String replaceOperatorPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ReplaceOperatorOptions model
    ReplaceOperatorOptions replaceOperatorOptionsModel = new ReplaceOperatorOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<OperatorDeployResult>> response = testService.replaceOperator(replaceOperatorOptionsModel).execute();
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
    assertEquals(parsedPath, replaceOperatorPath);
  }

  // Test the replaceOperator operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOperatorNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.replaceOperator(null).execute();
  }

  @Test
  public void testDeleteOperatorWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteOperatorPath = "/deploy/kubernetes/olm/operator";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteOperatorOptions model
    DeleteOperatorOptions deleteOperatorOptionsModel = new DeleteOperatorOptions.Builder()
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .versionLocatorId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteOperator(deleteOperatorOptionsModel).execute();
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
    assertEquals(parsedPath, deleteOperatorPath);
  }

  // Test the deleteOperator operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteOperatorNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteOperator(null).execute();
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
    .overrideValues(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .entitlementApikey("testString")
    .schematics(deployRequestBodySchematicsModel)
    .script("testString")
    .scriptId("testString")
    .versionLocatorId("testString")
    .vcenterId("testString")
    .vcenterPassword("testString")
    .vcenterLocation("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.installVersion(installVersionOptionsModel).execute();
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

  // Test the installVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInstallVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.installVersion(null).execute();
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
    .overrideValues(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .entitlementApikey("testString")
    .schematics(deployRequestBodySchematicsModel)
    .script("testString")
    .scriptId("testString")
    .versionLocatorId("testString")
    .vcenterId("testString")
    .vcenterPassword("testString")
    .vcenterLocation("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.preinstallVersion(preinstallVersionOptionsModel).execute();
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

  // Test the preinstallVersion operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPreinstallVersionNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.preinstallVersion(null).execute();
  }

  @Test
  public void testGetPreinstallWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"metadata\": {\"cluster_id\": \"clusterId\", \"region\": \"region\", \"namespace\": \"namespace\", \"workspace_id\": \"workspaceId\", \"workspace_name\": \"workspaceName\"}, \"release\": {\"deployments\": [\"anyValue\"], \"replicasets\": [\"anyValue\"], \"statefulsets\": [\"anyValue\"], \"pods\": [\"anyValue\"], \"errors\": [\"anyValue\"]}, \"content_mgmt\": {\"pods\": [\"anyValue\"], \"errors\": [\"anyValue\"]}}";
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
    Response<InstallStatus> response = testService.getPreinstall(getPreinstallOptionsModel).execute();
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

  // Test the getPreinstall operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPreinstallNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getPreinstall(null).execute();
  }

  @Test
  public void testValidationInstallWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String validationInstallPath = "/versions/testString/validation/install";

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

    // Construct an instance of the ValidationInstallOptions model
    ValidationInstallOptions validationInstallOptionsModel = new ValidationInstallOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .clusterId("testString")
    .region("testString")
    .namespace("testString")
    .overrideValues(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .entitlementApikey("testString")
    .schematics(deployRequestBodySchematicsModel)
    .script("testString")
    .scriptId("testString")
    .versionLocatorId("testString")
    .vcenterId("testString")
    .vcenterPassword("testString")
    .vcenterLocation("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.validationInstall(validationInstallOptionsModel).execute();
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
    assertEquals(parsedPath, validationInstallPath);
  }

  // Test the validationInstall operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testValidationInstallNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.validationInstall(null).execute();
  }

  @Test
  public void testGetValidationStatusWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"validated\": \"2019-01-01T12:00:00\", \"requested\": \"2019-01-01T12:00:00\", \"state\": \"state\", \"last_operation\": \"lastOperation\", \"target\": {\"mapKey\": \"anyValue\"}}";
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
    Response<Validation> response = testService.getValidationStatus(getValidationStatusOptionsModel).execute();
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

  // Test the getValidationStatus operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetValidationStatusNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getValidationStatus(null).execute();
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
    Response<Map<String, Object>> response = testService.getOverrideValues(getOverrideValuesOptionsModel).execute();
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

  // Test the getOverrideValues operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOverrideValuesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getOverrideValues(null).execute();
  }

  @Test
  public void testGetSchematicsWorkspacesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"type\": [\"type\"], \"description\": \"description\", \"tags\": [\"tags\"], \"created_at\": \"2019-01-01T12:00:00\", \"created_by\": \"createdBy\", \"status\": \"status\", \"workspace_status\": {\"frozen\": true, \"locked\": true}, \"template_ref\": \"templateRef\", \"template_repo\": {\"repo_url\": \"repoUrl\", \"chart_name\": \"chartName\", \"script_name\": \"scriptName\", \"uninstall_script_name\": \"uninstallScriptName\", \"folder_name\": \"folderName\", \"repo_sha_value\": \"repoShaValue\"}, \"template_data\": [\"anyValue\"], \"runtime_data\": {\"id\": \"id\", \"engine_name\": \"engineName\", \"engine_version\": \"engineVersion\", \"state_store_url\": \"stateStoreUrl\", \"log_store_url\": \"logStoreUrl\"}, \"shared_data\": {\"mapKey\": \"anyValue\"}, \"catalog_ref\": {\"item_id\": \"itemId\", \"item_name\": \"itemName\", \"item_url\": \"itemUrl\"}}]}";
    String getSchematicsWorkspacesPath = "/versions/testString/workspaces";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetSchematicsWorkspacesOptions model
    GetSchematicsWorkspacesOptions getSchematicsWorkspacesOptionsModel = new GetSchematicsWorkspacesOptions.Builder()
    .versionLocId("testString")
    .xAuthRefreshToken("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SchematicsWorkspaceSearchResult> response = testService.getSchematicsWorkspaces(getSchematicsWorkspacesOptionsModel).execute();
    assertNotNull(response);
    SchematicsWorkspaceSearchResult responseObj = response.getResult();
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
    assertEquals(parsedPath, getSchematicsWorkspacesPath);
  }

  // Test the getSchematicsWorkspaces operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetSchematicsWorkspacesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getSchematicsWorkspaces(null).execute();
  }

  @Test
  public void testCanDeploySchematicsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"pre_install\": {\"mapKey\": \"anyValue\"}, \"install\": {\"mapKey\": \"anyValue\"}}";
    String canDeploySchematicsPath = "/versions/testString/candeploy";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CanDeploySchematicsOptions model
    CanDeploySchematicsOptions canDeploySchematicsOptionsModel = new CanDeploySchematicsOptions.Builder()
    .versionLocId("testString")
    .clusterId("testString")
    .region("testString")
    .namespace("testString")
    .resourceGroupId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<DeployRequirementsCheck> response = testService.canDeploySchematics(canDeploySchematicsOptionsModel).execute();
    assertNotNull(response);
    DeployRequirementsCheck responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("cluster_id"), "testString");
    assertEquals(query.get("region"), "testString");
    assertEquals(query.get("namespace"), "testString");
    assertEquals(query.get("resource_group_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, canDeploySchematicsPath);
  }

  // Test the canDeploySchematics operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCanDeploySchematicsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.canDeploySchematics(null).execute();
  }

  @Test
  public void testGetResourceGroupsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"total_count\": 10, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"name\": \"name\", \"crn\": \"crn\", \"account_id\": \"accountId\", \"state\": \"state\", \"default\": true}]}";
    String getResourceGroupsPath = "/deploy/schematics/resourcegroups";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetResourceGroupsOptions model
    GetResourceGroupsOptions getResourceGroupsOptionsModel = new GetResourceGroupsOptions();

    // Invoke operation with valid options model (positive test)
    Response<ResourceGroups> response = testService.getResourceGroups(getResourceGroupsOptionsModel).execute();
    assertNotNull(response);
    ResourceGroups responseObj = response.getResult();
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
    assertEquals(parsedPath, getResourceGroupsPath);
  }

  @Test
  public void testGetLicenseProvidersWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_results\": 12, \"total_pages\": 10, \"prev_url\": \"prevUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"name\": \"name\", \"short_description\": \"shortDescription\", \"id\": \"id\", \"licence_type\": \"licenceType\", \"offering_type\": \"offeringType\", \"create_url\": \"createUrl\", \"info_url\": \"infoUrl\", \"url\": \"url\", \"crn\": \"crn\", \"state\": \"state\"}]}";
    String getLicenseProvidersPath = "/license/license_providers";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLicenseProvidersOptions model
    GetLicenseProvidersOptions getLicenseProvidersOptionsModel = new GetLicenseProvidersOptions();

    // Invoke operation with valid options model (positive test)
    Response<LicenseProviders> response = testService.getLicenseProviders(getLicenseProvidersOptionsModel).execute();
    assertNotNull(response);
    LicenseProviders responseObj = response.getResult();
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
    assertEquals(parsedPath, getLicenseProvidersPath);
  }

  @Test
  public void testListLicenseEntitlementsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_results\": 12, \"total_pages\": 10, \"prev_url\": \"prevUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"name\": \"name\", \"id\": \"id\", \"crn\": \"crn\", \"url\": \"url\", \"offering_type\": \"offeringType\", \"state\": \"state\", \"effective_from\": \"effectiveFrom\", \"effective_until\": \"effectiveUntil\", \"account_id\": \"accountId\", \"owner_id\": \"ownerId\", \"version_id\": \"versionId\", \"license_offering_id\": \"licenseOfferingId\", \"license_id\": \"licenseId\", \"license_owner_id\": \"licenseOwnerId\", \"license_type\": \"licenseType\", \"license_provider_id\": \"licenseProviderId\", \"license_provider_url\": \"licenseProviderUrl\", \"license_product_id\": \"licenseProductId\", \"namespace_repository\": \"namespaceRepository\", \"apikey\": \"apikey\", \"create_by\": \"createBy\", \"update_by\": \"updateBy\", \"create_at\": \"createAt\", \"updated_at\": \"updatedAt\", \"history\": [{\"action\": \"action\", \"user\": \"user\", \"date\": \"date\"}], \"offering_list\": [{\"id\": \"id\", \"name\": \"name\", \"label\": \"label\", \"offering_icon_url\": \"offeringIconUrl\", \"account_id\": \"accountId\", \"catalog_id\": \"catalogId\"}]}]}";
    String listLicenseEntitlementsPath = "/license/entitlements";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListLicenseEntitlementsOptions model
    ListLicenseEntitlementsOptions listLicenseEntitlementsOptionsModel = new ListLicenseEntitlementsOptions.Builder()
    .accountId("testString")
    .licenseProductId("testString")
    .versionId("testString")
    .state("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<LicenseEntitlements> response = testService.listLicenseEntitlements(listLicenseEntitlementsOptionsModel).execute();
    assertNotNull(response);
    LicenseEntitlements responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("license_product_id"), "testString");
    assertEquals(query.get("version_id"), "testString");
    assertEquals(query.get("state"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listLicenseEntitlementsPath);
  }

  @Test
  public void testCreateLicenseEntitlementWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"id\": \"id\", \"crn\": \"crn\", \"url\": \"url\", \"offering_type\": \"offeringType\", \"state\": \"state\", \"effective_from\": \"effectiveFrom\", \"effective_until\": \"effectiveUntil\", \"account_id\": \"accountId\", \"owner_id\": \"ownerId\", \"version_id\": \"versionId\", \"license_offering_id\": \"licenseOfferingId\", \"license_id\": \"licenseId\", \"license_owner_id\": \"licenseOwnerId\", \"license_type\": \"licenseType\", \"license_provider_id\": \"licenseProviderId\", \"license_provider_url\": \"licenseProviderUrl\", \"license_product_id\": \"licenseProductId\", \"namespace_repository\": \"namespaceRepository\", \"apikey\": \"apikey\", \"create_by\": \"createBy\", \"update_by\": \"updateBy\", \"create_at\": \"createAt\", \"updated_at\": \"updatedAt\", \"history\": [{\"action\": \"action\", \"user\": \"user\", \"date\": \"date\"}], \"offering_list\": [{\"id\": \"id\", \"name\": \"name\", \"label\": \"label\", \"offering_icon_url\": \"offeringIconUrl\", \"account_id\": \"accountId\", \"catalog_id\": \"catalogId\"}]}";
    String createLicenseEntitlementPath = "/license/entitlements";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the CreateLicenseEntitlementOptions model
    CreateLicenseEntitlementOptions createLicenseEntitlementOptionsModel = new CreateLicenseEntitlementOptions.Builder()
    .name("testString")
    .effectiveFrom("testString")
    .effectiveUntil("testString")
    .versionId("testString")
    .licenseId("testString")
    .licenseOwnerId("testString")
    .licenseProviderId("testString")
    .licenseProductId("testString")
    .accountId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<LicenseEntitlement> response = testService.createLicenseEntitlement(createLicenseEntitlementOptionsModel).execute();
    assertNotNull(response);
    LicenseEntitlement responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createLicenseEntitlementPath);
  }

  @Test
  public void testGetLicenseEntitlementsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_results\": 12, \"total_pages\": 10, \"prev_url\": \"prevUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"name\": \"name\", \"id\": \"id\", \"crn\": \"crn\", \"url\": \"url\", \"offering_type\": \"offeringType\", \"state\": \"state\", \"effective_from\": \"effectiveFrom\", \"effective_until\": \"effectiveUntil\", \"account_id\": \"accountId\", \"owner_id\": \"ownerId\", \"version_id\": \"versionId\", \"license_offering_id\": \"licenseOfferingId\", \"license_id\": \"licenseId\", \"license_owner_id\": \"licenseOwnerId\", \"license_type\": \"licenseType\", \"license_provider_id\": \"licenseProviderId\", \"license_provider_url\": \"licenseProviderUrl\", \"license_product_id\": \"licenseProductId\", \"namespace_repository\": \"namespaceRepository\", \"apikey\": \"apikey\", \"create_by\": \"createBy\", \"update_by\": \"updateBy\", \"create_at\": \"createAt\", \"updated_at\": \"updatedAt\", \"history\": [{\"action\": \"action\", \"user\": \"user\", \"date\": \"date\"}], \"offering_list\": [{\"id\": \"id\", \"name\": \"name\", \"label\": \"label\", \"offering_icon_url\": \"offeringIconUrl\", \"account_id\": \"accountId\", \"catalog_id\": \"catalogId\"}]}]}";
    String getLicenseEntitlementsPath = "/license/entitlements/productID/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLicenseEntitlementsOptions model
    GetLicenseEntitlementsOptions getLicenseEntitlementsOptionsModel = new GetLicenseEntitlementsOptions.Builder()
    .licenseProductId("testString")
    .accountId("testString")
    .versionId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<LicenseEntitlements> response = testService.getLicenseEntitlements(getLicenseEntitlementsOptionsModel).execute();
    assertNotNull(response);
    LicenseEntitlements responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("version_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLicenseEntitlementsPath);
  }

  // Test the getLicenseEntitlements operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLicenseEntitlementsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getLicenseEntitlements(null).execute();
  }

  @Test
  public void testDeleteLicenseEntitlementWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteLicenseEntitlementPath = "/license/entitlements/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteLicenseEntitlementOptions model
    DeleteLicenseEntitlementOptions deleteLicenseEntitlementOptionsModel = new DeleteLicenseEntitlementOptions.Builder()
    .entitlementId("testString")
    .accountId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteLicenseEntitlement(deleteLicenseEntitlementOptionsModel).execute();
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
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteLicenseEntitlementPath);
  }

  // Test the deleteLicenseEntitlement operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteLicenseEntitlementNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteLicenseEntitlement(null).execute();
  }

  @Test
  public void testGetLicensesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"total_results\": 12, \"total_pages\": 10, \"prev_url\": \"prevUrl\", \"next_url\": \"nextUrl\", \"resources\": [{\"name\": \"name\", \"offering_type\": \"offeringType\", \"seats_allowed\": \"seatsAllowed\", \"seats_used\": \"seatsUsed\", \"owner_id\": \"ownerId\", \"license_offering_id\": \"licenseOfferingId\", \"license_id\": \"licenseId\", \"license_owner_id\": \"licenseOwnerId\", \"license_type\": \"licenseType\", \"license_provider_id\": \"licenseProviderId\", \"license_product_id\": \"licenseProductId\", \"license_provider_url\": \"licenseProviderUrl\", \"effective_from\": \"effectiveFrom\", \"effective_until\": \"effectiveUntil\", \"internal\": true, \"offering_list\": [{\"id\": \"id\", \"name\": \"name\", \"label\": \"label\", \"offering_icon_url\": \"offeringIconUrl\", \"account_id\": \"accountId\", \"catalog_id\": \"catalogId\"}]}]}";
    String getLicensesPath = "/license/licenses";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetLicensesOptions model
    GetLicensesOptions getLicensesOptionsModel = new GetLicensesOptions.Builder()
    .licenseProviderId("testString")
    .accountId("testString")
    .name("testString")
    .licenseType("testString")
    .licenseProductId("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Licenses> response = testService.getLicenses(getLicensesOptionsModel).execute();
    assertNotNull(response);
    Licenses responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("license_provider_id"), "testString");
    assertEquals(query.get("account_id"), "testString");
    assertEquals(query.get("name"), "testString");
    assertEquals(query.get("license_type"), "testString");
    assertEquals(query.get("license_product_id"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getLicensesPath);
  }

  // Test the getLicenses operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetLicensesNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getLicenses(null).execute();
  }

  @Test
  public void testSearchLicenseVersionsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String searchLicenseVersionsPath = "/search/license/versions";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SearchLicenseVersionsOptions model
    SearchLicenseVersionsOptions searchLicenseVersionsOptionsModel = new SearchLicenseVersionsOptions.Builder()
    .q("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.searchLicenseVersions(searchLicenseVersionsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("q"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, searchLicenseVersionsPath);
  }

  // Test the searchLicenseVersions operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchLicenseVersionsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.searchLicenseVersions(null).execute();
  }

  @Test
  public void testSearchLicenseOfferingsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String searchLicenseOfferingsPath = "/search/license/offerings";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the SearchLicenseOfferingsOptions model
    SearchLicenseOfferingsOptions searchLicenseOfferingsOptionsModel = new SearchLicenseOfferingsOptions.Builder()
    .q("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.searchLicenseOfferings(searchLicenseOfferingsOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    // Response does not have a return type. Check that the result is null.
    assertNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("q"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, searchLicenseOfferingsPath);
  }

  // Test the searchLicenseOfferings operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSearchLicenseOfferingsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.searchLicenseOfferings(null).execute();
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