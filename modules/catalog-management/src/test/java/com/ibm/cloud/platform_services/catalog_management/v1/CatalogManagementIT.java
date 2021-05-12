// /*
//  * (C) Copyright IBM Corp. 2021.
//  *
//  * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
//  * the License. You may obtain a copy of the License at
//  *
//  * http://www.apache.org/licenses/LICENSE-2.0
//  *
//  * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
//  * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
//  * specific language governing permissions and limitations under the License.
//  */
//
// package com.ibm.cloud.platform_services.catalog_management.v1;
//
// import com.ibm.cloud.platform_services.catalog_management.v1.model.AccessListBulkResponse;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Account;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.AccountPublishVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.AccumulatedFilters;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.AddObjectAccessListOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ApprovalResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.AuditLog;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogObject;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CatalogSearchResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CategoryFilter;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ClusterInfo;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CommitVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Configuration;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CopyVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateCatalogOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectAccessOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingInstanceOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteCatalogOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessListOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectAccessOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingInstanceOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOfferingOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteOperatorsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeleteVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployOperatorsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployRequestBodySchematics;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Deployment;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.DeprecateVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Feature;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.FilterTerms;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Filters;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountAuditOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountFiltersOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAccountOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogAuditOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetCatalogOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetClusterOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetConsumptionOfferingsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetNamespacesOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessListOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAccessOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectAuditOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAboutOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingAuditOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingContainerImagesOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingInstanceOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingLicenseOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingUpdatesOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingWorkingCopyOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOverrideValuesOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetPreinstallOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetValidationStatusOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.GetVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.IDFilter;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.IbmPublishVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ImageManifest;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallStatus;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Kind;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.License;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ListCatalogsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ListObjectsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOfferingsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ListOperatorsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.NamespaceSearchResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccess;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectAccessListResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectListResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ObjectSearchResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Offering;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingInstance;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingSearchResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.OperatorDeployResult;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Plan;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.PreinstallVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.PublicPublishVersionOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.PublishObject;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.PutOfferingInstanceOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Rating;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceCatalogOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingIconOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOfferingOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ReplaceOperatorsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.RepoInfo;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Resource;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Script;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.SearchObjectsOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.SharedPublishObjectOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.State;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationAuthorization;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationResource;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateCatalogAccountOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.UpdateOfferingIbmOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.ValidateInstallOptions;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Validation;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.Version;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionEntitlement;
// import com.ibm.cloud.platform_services.catalog_management.v1.model.VersionUpdateDescriptor;
// import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
// import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
// import com.ibm.cloud.sdk.core.http.Response;
// import com.ibm.cloud.sdk.core.security.Authenticator;
// import com.ibm.cloud.sdk.core.security.IamAuthenticator;
// import com.ibm.cloud.sdk.core.security.IamToken;
// import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
// import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
// import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
// import com.ibm.cloud.sdk.core.util.CredentialUtils;
// import com.ibm.cloud.sdk.core.util.DateUtils;
//
// import java.util.*;
//
// import org.testng.ITestContext;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Ignore;
// import org.testng.annotations.Test;
//
// import static org.testng.Assert.*;
//
// /**
//  * Integration test class for the CatalogManagement service.
//  */
// public class CatalogManagementIT extends SdkIntegrationTestBase {
//
//   public CatalogManagement service = null;
//   public static Map<String, String> config = null;
//   // final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
//   // final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
//
//   /**
//    * This method provides our config filename to the base class.
//    */
//
//   public String getConfigFilename() {
//     return "../../catalog_mgmt.env";
//   }
//
//   private String accountId = null;
//   private String clusterId = null;
//
//   private String refreshToken = null;
//
//   private String catalogId = null;
//   private String offeringId = null;
//   private String offeringInstance = null;
//
//   @BeforeClass
//   public void constructService() {
//     // Ask super if we should skip the tests.
//     if (skipTests()) {
//       return;
//     }
//
//     service = CatalogManagement.newInstance(CatalogManagement.DEFAULT_SERVICE_NAME);
//     assertNotNull(service);
//     assertNotNull(service.getServiceUrl());
//
//     IamAuthenticator iamAuthenticator = (IamAuthenticator) service.getAuthenticator();
//     IamToken iamToken = iamAuthenticator.requestToken();
//     refreshToken = iamToken.getRefreshToken();
//
//     // Load up our test-specific config properties.
//     config = CredentialUtils.getServiceProperties(CatalogManagement.DEFAULT_SERVICE_NAME);
//     assertNotNull(config);
//     assertFalse(config.isEmpty());
//     assertEquals(service.getServiceUrl(), config.get("URL"));
//
//     accountId = config.get("ACCOUNT_ID");
//     assertNotNull(accountId);
//
//     clusterId = config.get("CLUSTER_ID");
//     assertNotNull(clusterId);
//
//     System.out.println("Setup complete.");
//   }
//
//   @Test
//   // @Ignore
//   public void testGetCatalogAccount() throws Exception {
//     try {
//       GetCatalogAccountOptions getCatalogAccountOptions = new GetCatalogAccountOptions();
//
//       // Invoke operation
//       Response<Account> response = service.getCatalogAccount(getCatalogAccountOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Account accountResult = response.getResult();
//
//       assertNotNull(accountResult);
//       assertEquals(accountResult.id(), accountId);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testUpdateCatalogAccount() throws Exception {
//     try {
//       FilterTerms includedFilterTermsModel =
//  new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("included " +
//            "filter" + " term - 1", "included " + "filter term - 2")))
//           .build();
//
//       CategoryFilter includedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//           .filter(includedFilterTermsModel)
//           .build();
//
//       FilterTerms excludedFilterTermsModel =
//           new FilterTerms.Builder().filterTerms(new ArrayList<String>(Arrays.asList("excluded filter term - 1",
//        "excluded filter term - 2")))
//           .build();
//
//       CategoryFilter excludedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//           .filter(excludedFilterTermsModel)
//           .build();
//
//       Filters filtersModel = new Filters.Builder().includeAll(true)
//           .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
//             {
//               put("included-category-filter", includedCategoryFilterModel);
//               put("excluded-category-filter", excludedCategoryFilterModel);
//             }
//           })
//           .build();
//
//       UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder().id(accountId)
//           .hideIbmCloudCatalog(false)
//           .accountFilters(filtersModel)
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.updateCatalogAccount(updateCatalogAccountOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testUpdateCatalogAccount"})
//   @Ignore
//   public void testGetUpdatedCatalogAccount() throws Exception {
//     try {
//       GetCatalogAccountOptions getCatalogAccountOptions = new GetCatalogAccountOptions();
//
//       // Invoke operation
//       Response<Account> response = service.getCatalogAccount(getCatalogAccountOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Account accountResult = response.getResult();
//
//       assertNotNull(accountResult);
//       assertEquals(accountResult.id(), accountId);
//
//       assertTrue(accountResult.accountFilters()
//           .categoryFilters()
//           .containsKey("included-category-filter"));
//       assertTrue(accountResult.accountFilters()
//           .categoryFilters()
//           .containsKey("excluded-category-filter"));
//
//       accountResult.accountFilters()
//           .categoryFilters()
//           .get("included-category-filter")
//           .filter()
//           .filterTerms()
//           .stream()
//           .filter(p -> p.equals("included filter term - 1"))
//           .findAny()
//           .orElseThrow(() -> new RuntimeException(String.format("No filter with name: %s",
//               "included filter term - 1")));
//
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   // @Ignore
//   public void testGetCatalogAccountFilters() throws Exception {
//     try {
//       GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
//           // .catalog("testString")
//           .build();
//
//       // Invoke operation
//       Response<AccumulatedFilters> response = service.getCatalogAccountFilters(getCatalogAccountFiltersOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AccumulatedFilters accumulatedFiltersResult = response.getResult();
//
//       assertNotNull(accumulatedFiltersResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   //=== Catalog
//
//   @Test
//   public void testCreateCatalog() throws Exception {
//     try {
//       Feature featureModel = new Feature.Builder().title("feature model")
//           .description("feature model description")
//           .build();
//
//       FilterTerms filterTermsModel =
//           new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("filter terms")))
//           .build();
//
//       CategoryFilter categoryFilterModel = new CategoryFilter.Builder().include(true)
//           .filter(filterTermsModel)
//           .build();
//
//       IDFilter idFilterModel = new IDFilter.Builder().include(filterTermsModel)
//           .exclude(filterTermsModel)
//           .build();
//
//       Filters filtersModel = new Filters.Builder().includeAll(true)
//           .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
//             {
//               put("foo", categoryFilterModel);
//             }
//           })
//           .idFilters(idFilterModel)
//           .build();
//
//       SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder().region("testString")
//           .id("testString")
//           .name("testString")
//           .resourceGroupName("testString")
//           .type("testString")
//           .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .allNamespaces(true)
//           .build();
//
//       SyndicationHistory syndicationHistoryModel =
//           new SyndicationHistory.Builder().namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList(
//            "testString")))
//           .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//           .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .build();
//
//       SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder().token(
//           "testString")
//           .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .build();
//
//       SyndicationResource syndicationResourceModel = new SyndicationResource.Builder().removeRelatedComponents(true)
//           .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//           .history(syndicationHistoryModel)
//           .authorization(syndicationAuthorizationModel)
//           .build();
//
//       ArrayList<String> catalogTags = new java.util.ArrayList<String>(java.util.Arrays.asList("java", "sdk", "tag-1",
//           "tag-2"));
//       ArrayList<Feature> catalogFeatures = new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel));
//
//       CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
//           // .id("testString")
//           // .rev("testString")
//           .label("catalog created by java sdk")
//           .shortDescription("catalog created by java sdk description")
//           // .catalogIconUrl("testString")
//           .tags(catalogTags)
//           .features(catalogFeatures)
//           // .disabled(true)
//           // .resourceGroupId("testString")
//           .owningAccount(accountId)
//           .catalogFilters(filtersModel)
//           // .syndicationSettings(syndicationResourceModel)
//           .kind("offering")
//           .build();
//
//       // Invoke operation
//       Response<Catalog> response = service.createCatalog(createCatalogOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       Catalog catalogResult = response.getResult();
//
//       assertNotNull(catalogResult);
//       catalogId = catalogResult.id();
//       System.out.println(String.format("catalog id: %s", catalogId));
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   public void testCreateCatalogFailsWhenValidationFails() throws Exception {
//     CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder().build();
//
//     // Invoke operation
//     Response<Catalog> response = service.createCatalog(createCatalogOptions)
//         .execute();
//     // Validate response
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testListCatalogs() throws Exception {
//     try {
//       ListCatalogsOptions listCatalogsOptions = new ListCatalogsOptions();
//
//       // Invoke operation
//       Response<CatalogSearchResult> response = service.listCatalogs(listCatalogsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       CatalogSearchResult catalogSearchResultResult = response.getResult();
//
//       assertNotNull(catalogSearchResultResult);
//       System.out.println(String.format("Result size: %d", response.getResult()
//           .getTotalCount()));
//       catalogSearchResultResult.getResources()
//           .stream()
//           .filter(p -> p.id().equals(catalogId))
//           .findAny()
//           .orElseThrow(() -> new RuntimeException(String.format("No catalog with id: %s", catalogId)));
//
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = "testCreateCatalog")
//   public void testReplaceCatalog() throws Exception {
//     try {
//       // Feature featureModel = new Feature.Builder()
//       //     .title("testString")
//       //     .description("testString")
//       //     .build();
//       //
//       // FilterTerms filterTermsModel = new FilterTerms.Builder()
//       //     .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .build();
//       //
//       // CategoryFilter categoryFilterModel = new CategoryFilter.Builder()
//       //     .include(true)
//       //     .filter(filterTermsModel)
//       //     .build();
//       //
//       // IDFilter idFilterModel = new IDFilter.Builder()
//       //     .include(filterTermsModel)
//       //     .exclude(filterTermsModel)
//       //     .build();
//       //
//       // Filters filtersModel = new Filters.Builder()
//       //     .includeAll(true)
//       //     .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
//       //       {
//       //         put("foo", categoryFilterModel);
//       //       }
//       //     })
//       //     .idFilters(idFilterModel)
//       //     .build();
//       //
//       // SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder()
//       //     .region("testString")
//       //     .id("testString")
//       //     .name("testString")
//       //     .resourceGroupName("testString")
//       //     .type("testString")
//       //     .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .allNamespaces(true)
//       //     .build();
//       //
//       // SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
//       //     .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//       //     .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .build();
//       //
//       // SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
//       //     .token("testString")
//       //     .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .build();
//       //
//       // SyndicationResource syndicationResourceModel = new SyndicationResource.Builder()
//       //     .removeRelatedComponents(true)
//       //     .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//       //     .history(syndicationHistoryModel)
//       //     .authorization(syndicationAuthorizationModel)
//       //     .build();
//
//       ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder().catalogIdentifier(catalogId)
//           .id(catalogId)
//           // .rev("testString")
//           .label("catalog updated by java sdk")
//           .shortDescription("catalog updated by java sdk")
//           // .catalogIconUrl("testString")
//           // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//           // .disabled(true)
//           // .resourceGroupId("testString")
//           .owningAccount(accountId)
//           // .catalogFilters(filtersModel)
//           // .syndicationSettings(syndicationResourceModel)
//           // .kind("testString")
//           .build();
//
//       // Invoke operation
//       Response<Catalog> response = service.replaceCatalog(replaceCatalogOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Catalog catalogResult = response.getResult();
//
//       assertNotNull(catalogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = "testCreateCatalog", expectedExceptions = NotFoundException.class)
//   public void testReplaceCatalogFailsWhenThereIsNoSuchCatalog() throws Exception {
//     ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder().catalogIdentifier(catalogId +
//         "fake")
//         .id(catalogId + "fake")
//         .build();
//
//     // Invoke operation
//     Response<Catalog> response = service.replaceCatalog(replaceCatalogOptions)
//         .execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetCatalog() throws Exception {
//     try {
//       // What is catalog identifier and why I get 403 when I created the catalog?
//       GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder().catalogIdentifier(catalogId)
//           .build();
//
//       // Invoke operation
//       Response<Catalog> response = service.getCatalog(getCatalogOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Catalog catalogResult = response.getResult();
//
//       assertNotNull(catalogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"}, expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetCatalogFailsWhenNoSuchCatalog() throws Exception {
//     GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder().catalogIdentifier(catalogId + "extrastring")
//         .build();
//
//     // Invoke operation
//     Response<Catalog> response = service.getCatalog(getCatalogOptions)
//         .execute();
//   }
//
//   @Test(priority = 1000)
//   // @Ignore
//   public void testDeleteCatalog() throws Exception {
//     try {
//       DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogId)
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteCatalog(deleteCatalogOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   public void testDeleteCatalogFailsWhenThereIsNoSuchCatalog() throws Exception {
//     try {
//       DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogId +
//           "fake")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteCatalog(deleteCatalogOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   // @Ignore
//   public void testGetCatalogAccountAudit() throws Exception {
//     try {
//       GetCatalogAccountAuditOptions getCatalogAccountAuditOptions = new GetCatalogAccountAuditOptions();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getCatalogAccountAudit(getCatalogAccountAuditOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AuditLog auditLogResult = response.getResult();
//
//       assertNotNull(auditLogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testReplaceCatalog"})
//   // @Ignore
//   public void testGetCatalogAudit() throws Exception {
//     try {
//       GetCatalogAuditOptions getCatalogAuditOptions = new GetCatalogAuditOptions.Builder().catalogIdentifier(catalogId)
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getCatalogAudit(getCatalogAuditOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AuditLog auditLogResult = response.getResult();
//
//       assertNotNull(auditLogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   public void testGetCatalogAuditFailsWhenNoSuchCatalog() throws Exception {
//     GetCatalogAuditOptions getCatalogAuditOptions =
//      new GetCatalogAuditOptions.Builder().catalogIdentifier(catalogId + "fake")
//         .build();
//
//     // Invoke operation
//     Response<AuditLog> catalogAuditResponse = service.getCatalogAudit(getCatalogAuditOptions)
//         .execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testReplaceCatalog"})
//   // @Ignore
//   public void testGetConsumptionOfferings() throws Exception {
//     try {
//       GetConsumptionOfferingsOptions getConsumptionOfferingsOptions =
//           new GetConsumptionOfferingsOptions.Builder().digest(true)
//           .catalog(catalogId)
//           .select("all")
//           .includeHidden(true)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           .build();
//
//       // Invoke operation
//       Response<OfferingSearchResult> response = service.getConsumptionOfferings(getConsumptionOfferingsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       OfferingSearchResult offeringSearchResultResult = response.getResult();
//
//       assertNotNull(offeringSearchResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testCreateOffering() throws Exception {
//     try {
//       // Rating ratingModel = new Rating.Builder()
//       //     .oneStarCount(Long.valueOf("26"))
//       //     .twoStarCount(Long.valueOf("26"))
//       //     .threeStarCount(Long.valueOf("26"))
//       //     .fourStarCount(Long.valueOf("26"))
//       //     .build();
//       //
//       // Feature featureModel = new Feature.Builder()
//       //     .title("testString")
//       //     .description("testString")
//       //     .build();
//       //
//       // Configuration configurationModel = new Configuration.Builder()
//       //     .key("testString")
//       //     .type("testString")
//       //     .defaultValue("testString")
//       //     .valueConstraint("testString")
//       //     .description("testString")
//       //     .required(true)
//       //     .options(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
//       //     .hidden(true)
//       //     .build();
//       //
//       // Validation validationModel = new Validation.Builder()
//       //     .validated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .requested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .state("testString")
//       //     .lastOperation("testString")
//       //     .target(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .build();
//       //
//       // Resource resourceModel = new Resource.Builder()
//       //     .type("mem")
//       //     .value("testString")
//       //     .build();
//       //
//       // Script scriptModel = new Script.Builder()
//       //     .instructions("testString")
//       //     .script("testString")
//       //     .scriptPermission("testString")
//       //     .deleteScript("testString")
//       //     .scope("testString")
//       //     .build();
//       //
//       // VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
//       //     .providerName("testString")
//       //     .providerId("testString")
//       //     .productId("testString")
//       //     .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .imageRepoName("testString")
//       //     .build();
//       //
//       // License licenseModel = new License.Builder()
//       //     .id("testString")
//       //     .name("testString")
//       //     .type("testString")
//       //     .url("testString")
//       //     .description("testString")
//       //     .build();
//       //
//       // State stateModel = new State.Builder()
//       //     .current("testString")
//       //     .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .pending("testString")
//       //     .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .previous("testString")
//       //     .build();
//       //
//       // Version versionModel = new Version.Builder()
//       //     .id("testString")
//       //     .rev("testString")
//       //     .crn("testString")
//       //     .version("testString")
//       //     .sha("testString")
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .offeringId("testString")
//       //     .catalogId("testString")
//       //     .kindId("testString")
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .repoUrl("testString")
//       //     .sourceUrl("testString")
//       //     .tgzUrl("testString")
//       //     .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .validation(validationModel)
//       //     .requiredResources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
//       //     .singleInstance(true)
//       //     .install(scriptModel)
//       //     .preInstall(new java.util.ArrayList<Script>(java.util.Arrays.asList(scriptModel)))
//       //     .entitlement(versionEntitlementModel)
//       //     .licenses(new java.util.ArrayList<License>(java.util.Arrays.asList(licenseModel)))
//       //     .imageManifestUrl("testString")
//       //     .deprecated(true)
//       //     .packageVersion("testString")
//       //     .state(stateModel)
//       //     .versionLocator("testString")
//       //     .consoleUrl("testString")
//       //     .longDescription("testString")
//       //     .whitelistedAccounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .build();
//       //
//       // Deployment deploymentModel = new Deployment.Builder()
//       //     .id("testString")
//       //     .label("testString")
//       //     .name("testString")
//       //     .shortDescription("testString")
//       //     .longDescription("testString")
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .build();
//       //
//       // Plan planModel = new Plan.Builder()
//       //     .id("testString")
//       //     .label("testString")
//       //     .name("testString")
//       //     .shortDescription("testString")
//       //     .longDescription("testString")
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
//       //     .build();
//       //
//       Kind kindModel = new Kind.Builder().id("create-offering-java-sdk")
//           .formatKind("operator")
//           .targetKind("operator")
//           // .metadata(new java.util.HashMap<String, Object>() {
//           //   {
//           //     put("foo", "testString");
//           //   }
//           // })
//           // .installDescription("testString")
//           // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           // .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//           // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
//           // .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
//           .build();
//       //
//       // RepoInfo repoInfoModel = new RepoInfo.Builder()
//       //     .token("testString")
//       //     .type("testString")
//       //     .build();
//
//       CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogId)
//           // .id("testString")
//           // .rev("testString")
//           // .url("testString")
//           // .crn("testString")
//           // .label("testString")
//           .name("offering-created-by-java-sdk")
//           // .offeringIconUrl("testString")
//           // .offeringDocsUrl("testString")
//           // .offeringSupportUrl("testString")
//           // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           // .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           // .rating(ratingModel)
//           // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .shortDescription("testString")
//           // .longDescription("testString")
//           // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//           .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
//           // .permitRequestIbmPublicPublish(true)
//           // .ibmPublishApproved(true)
//           // .publicPublishApproved(true)
//           // .publicOriginalCrn("testString")
//           // .publishPublicCrn("testString")
//           // .portalApprovalRecord("testString")
//           // .portalUiUrl("testString")
//           // .catalogId("testString")
//           // .catalogName("testString")
//           // .metadata(new java.util.HashMap<String, Object>() {
//           //   {
//           //     put("foo", "testString");
//           //   }
//           // })
//           // .disclaimer("testString")
//           // .hidden(true)
//           // .provider("testString")
//           // .repoInfo(repoInfoModel)
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.createOffering(createOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//       offeringId = offeringResult.id();
//       System.out.println("Offering: " + offeringId);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateOffering", "testCreateCatalog"})
//   // @Ignore
//   public void testGetOffering() throws Exception {
//     try {
//       GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId(offeringId)
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.getOffering(getOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering", "testGetOffering"})
//   public void testGetOfferingFailsWhenNoSuchOffering() throws Exception {
//     GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder().catalogIdentifier(catalogId)
//         .offeringId("bogusid")
//         .build();
//
//     // Invoke operation
//     Response<Offering> response = service.getOffering(getOfferingOptions)
//         .execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering"})
//   @Ignore
//   public void testReplaceOffering() throws Exception {
//     try {
//       // Rating ratingModel = new Rating.Builder()
//       //     .oneStarCount(Long.valueOf("26"))
//       //     .twoStarCount(Long.valueOf("26"))
//       //     .threeStarCount(Long.valueOf("26"))
//       //     .fourStarCount(Long.valueOf("26"))
//       //     .build();
//       //
//       // Feature featureModel = new Feature.Builder()
//       //     .title("testString")
//       //     .description("testString")
//       //     .build();
//       //
//       // Configuration configurationModel = new Configuration.Builder()
//       //     .key("testString")
//       //     .type("testString")
//       //     .defaultValue("testString")
//       //     .valueConstraint("testString")
//       //     .description("testString")
//       //     .required(true)
//       //     .options(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
//       //     .hidden(true)
//       //     .build();
//       //
//       // Validation validationModel = new Validation.Builder()
//       //     .validated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .requested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .state("testString")
//       //     .lastOperation("testString")
//       //     .target(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .build();
//       //
//       // Resource resourceModel = new Resource.Builder()
//       //     .type("mem")
//       //     .value("testString")
//       //     .build();
//       //
//       // Script scriptModel = new Script.Builder()
//       //     .instructions("testString")
//       //     .script("testString")
//       //     .scriptPermission("testString")
//       //     .deleteScript("testString")
//       //     .scope("testString")
//       //     .build();
//       //
//       // VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
//       //     .providerName("testString")
//       //     .providerId("testString")
//       //     .productId("testString")
//       //     .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .imageRepoName("testString")
//       //     .build();
//       //
//       // License licenseModel = new License.Builder()
//       //     .id("testString")
//       //     .name("testString")
//       //     .type("testString")
//       //     .url("testString")
//       //     .description("testString")
//       //     .build();
//       //
//       // State stateModel = new State.Builder()
//       //     .current("testString")
//       //     .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .pending("testString")
//       //     .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .previous("testString")
//       //     .build();
//       //
//       // Version versionModel = new Version.Builder()
//       //     .id("testString")
//       //     .rev("testString")
//       //     .crn("testString")
//       //     .version("testString")
//       //     .sha("testString")
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .offeringId("testString")
//       //     .catalogId("testString")
//       //     .kindId("testString")
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .repoUrl("testString")
//       //     .sourceUrl("testString")
//       //     .tgzUrl("testString")
//       //     .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .validation(validationModel)
//       //     .requiredResources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
//       //     .singleInstance(true)
//       //     .install(scriptModel)
//       //     .preInstall(new java.util.ArrayList<Script>(java.util.Arrays.asList(scriptModel)))
//       //     .entitlement(versionEntitlementModel)
//       //     .licenses(new java.util.ArrayList<License>(java.util.Arrays.asList(licenseModel)))
//       //     .imageManifestUrl("testString")
//       //     .deprecated(true)
//       //     .packageVersion("testString")
//       //     .state(stateModel)
//       //     .versionLocator("testString")
//       //     .consoleUrl("testString")
//       //     .longDescription("testString")
//       //     .whitelistedAccounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .build();
//       //
//       // Deployment deploymentModel = new Deployment.Builder()
//       //     .id("testString")
//       //     .label("testString")
//       //     .name("testString")
//       //     .shortDescription("testString")
//       //     .longDescription("testString")
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .build();
//       //
//       // Plan planModel = new Plan.Builder()
//       //     .id("testString")
//       //     .label("testString")
//       //     .name("testString")
//       //     .shortDescription("testString")
//       //     .longDescription("testString")
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
//       //     .build();
//       //
//       // Kind kindModel = new Kind.Builder()
//       //     .id("testString")
//       //     .formatKind("testString")
//       //     .targetKind("testString")
//       //     .metadata(new java.util.HashMap<String, Object>() {
//       //       {
//       //         put("foo", "testString");
//       //       }
//       //     })
//       //     .installDescription("testString")
//       //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//       //     .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//       //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//       //     .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
//       //     .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
//       //     .build();
//       //
//       // RepoInfo repoInfoModel = new RepoInfo.Builder()
//       //     .token("testString")
//       //     .type("testString")
//       //     .build();
//
//       ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId(offeringId)
//           .id(offeringId)
//           // .rev("")
//           // .url("testString")
//           // .crn("testString")
//           // .label("testString")
//           .name("updated-offering")
//           // .offeringIconUrl("testString")
//           // .offeringDocsUrl("testString")
//           // .offeringSupportUrl("testString")
//           // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           // .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           // .rating(ratingModel)
//           // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .shortDescription("updated short description")
//           .longDescription("updated long description")
//           // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//           // .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
//           // .permitRequestIbmPublicPublish(true)
//           // .ibmPublishApproved(true)
//           // .publicPublishApproved(true)
//           // .publicOriginalCrn("testString")
//           // .publishPublicCrn("testString")
//           // .portalApprovalRecord("testString")
//           // .portalUiUrl("testString")
//           // .catalogId("testString")
//           // .catalogName("testString")
//           // .metadata(new java.util.HashMap<String, Object>() {
//           //   {
//           //     put("foo", "testString");
//           //   }
//           // })
//           // .disclaimer("testString")
//           // .hidden(true)
//           // .provider("testString")
//           // .repoInfo(repoInfoModel)
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.replaceOffering(replaceOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering"}, expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testReplaceOfferingFailsWhenNoSuchOfferings() throws Exception {
//     ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder().catalogIdentifier("bogus" +
//         "-catalog-id")
//         .offeringId("bogus-offering-id")
//         .id("bogus-offering-id")
//         .build();
//
//     // Invoke operation
//     Response<Offering> response = service.replaceOffering(replaceOfferingOptions)
//         .execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering"})
//   @Ignore
//   public void testListOfferings() throws Exception {
//     try {
//       ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder().catalogIdentifier(catalogId)
//           // .digest(true)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           // .name("testString")
//           // .sort("testString")
//           .build();
//
//       // Invoke operation
//       Response<OfferingSearchResult> response = service.listOfferings(listOfferingsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       OfferingSearchResult offeringSearchResultResult = response.getResult();
//
//       assertNotNull(offeringSearchResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering", "testListOfferings"})
//   // @Ignore
//   public void testDeleteOffering() throws Exception {
//     try {
//       DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId(offeringId)
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOffering(deleteOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   // @Ignore
//   public void testDeleteOfferingFailsWhenNoSuchOfferings() throws Exception {
//     try {
//       DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId("bogus-offeringid")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOffering(deleteOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testImportOfferingVersion() throws Exception {
//     try {
//       ImportOfferingVersionOptions importOfferingVersionOptions =
//        new ImportOfferingVersionOptions.Builder().catalogIdentifier("testString")
//           .offeringId("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//           .zipurl("testString")
//           .targetVersion("testString")
//           .includeConfig(true)
//           .isVsi(true)
//           .repoType("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.importOfferingVersion(importOfferingVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testImportOffering() throws Exception {
//     try {
//       ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("java", "sdk", "example-tag-1",
//               "example-tag" + "-2")))
//           .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("roks")))
//           // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//           .zipurl("https://github.com/rhm-samples/node-red-operator/blob/nodered-1.2.8/node-red-operator/bundle/0.0" + ".2/manifests/node-red-operator.v0.0.2.clusterserviceversion.yaml")
//           // .offeringId("java-sdk-created-id-1")
//           .targetVersion("1")
//           .includeConfig(true)
//           .isVsi(true)
//           .repoType("helm")
//           // .xAuthToken("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.importOffering(importOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testImportOfferingFailsWhenNoSuchOffering() throws Exception {
//     ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogId)
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
//         //     "java",
//         //     "sdk",
//         //     "example-tag-1",
//         //     "example-tag-2")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(
//         //     "roks")))
//         // // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .zipurl("https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins" + "-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml")
//         // .offeringId("java-sdk-created-id-1")
//         // .targetVersion("1")
//         // .includeConfig(true)
//         // .isVsi(true)
//         // .repoType("helm")
//         // .xAuthToken("testString")
//         .build();
//
//     // Invoke operation
//     Response<Offering> response = service.importOffering(importOfferingOptions)
//         .execute();
//   }
//
//   @Test
//   @Ignore
//   public void testReloadOffering() throws Exception {
//     try {
//       ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder().catalogIdentifier("testString")
//           .offeringId("testString")
//           .targetVersion("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//           .zipurl("testString")
//           .repoType("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.reloadOffering(reloadOfferingOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = "testCreateCatalog", expectedExceptions = NotFoundException.class)
//   public void testReloadOfferingFailsWhenNoSuchOffering() throws Exception {
//     ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder().catalogIdentifier(catalogId)
//         .offeringId("fakeofferingid")
//         .targetVersion("targetversion")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .zipurl("testString")
//         // .repoType("testString")
//         .build();
//
//     // Invoke operation
//     Response<Offering> response = service.reloadOffering(reloadOfferingOptions)
//         .execute();
//     // Validate response
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetOfferingAuditReturns200WhenNoSuchOfferings() throws Exception {
//     try {
//       GetOfferingAuditOptions getOfferingAuditOptions =
//           new GetOfferingAuditOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId("random offering name")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getOfferingAudit(getOfferingAuditOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AuditLog auditLogResult = response.getResult();
//
//       assertNotNull(auditLogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetOfferingAudit() throws Exception {
//     try {
//       GetOfferingAuditOptions getOfferingAuditOptions =
//           new GetOfferingAuditOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId("random offering name")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getOfferingAudit(getOfferingAuditOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AuditLog auditLogResult = response.getResult();
//
//       assertNotNull(auditLogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testReplaceOfferingIcon() throws Exception {
//     try {
//       ReplaceOfferingIconOptions replaceOfferingIconOptions =
//        new ReplaceOfferingIconOptions.Builder().catalogIdentifier("testString")
//           .offeringId("testString")
//           .fileName("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.replaceOfferingIcon(replaceOfferingIconOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testUpdateOfferingIbm() throws Exception {
//     try {
//       UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder().catalogIdentifier(
//           "testString")
//           .offeringId("testString")
//           .approvalType("allow_request")
//           .approved("true")
//           .build();
//
//       // Invoke operation
//       Response<ApprovalResult> response = service.updateOfferingIbm(updateOfferingIbmOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ApprovalResult approvalResultResult = response.getResult();
//
//       assertNotNull(approvalResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingUpdates() throws Exception {
//     try {
//       GetOfferingUpdatesOptions getOfferingUpdatesOptions =
//           new GetOfferingUpdatesOptions.Builder().catalogIdentifier("testString")
//           .offeringId("testString")
//           .kind("testString")
//           .version("testString")
//           .clusterId("testString")
//           .region("testString")
//           .resourceGroupId("testString")
//           .namespace("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<VersionUpdateDescriptor>> response = service.getOfferingUpdates(getOfferingUpdatesOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<VersionUpdateDescriptor> listVersionUpdateDescriptorResult = response.getResult();
//
//       assertNotNull(listVersionUpdateDescriptorResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingAbout() throws Exception {
//     try {
//       GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<String> response = service.getOfferingAbout(getOfferingAboutOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       String resultResult = response.getResult();
//
//       assertNotNull(resultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingLicense() throws Exception {
//     try {
//       GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder().versionLocId(
//           "testString")
//           .licenseId("testString")
//           .build();
//
//       // Invoke operation
//       Response<String> response = service.getOfferingLicense(getOfferingLicenseOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       String resultResult = response.getResult();
//
//       assertNotNull(resultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingContainerImages() throws Exception {
//     try {
//       GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
//           new GetOfferingContainerImagesOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<ImageManifest> response = service.getOfferingContainerImages(getOfferingContainerImagesOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ImageManifest imageManifestResult = response.getResult();
//
//       assertNotNull(imageManifestResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeprecateVersion() throws Exception {
//     try {
//       DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deprecateVersion(deprecateVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testAccountPublishVersion() throws Exception {
//     try {
//       AccountPublishVersionOptions accountPublishVersionOptions =
//           new AccountPublishVersionOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.accountPublishVersion(accountPublishVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testIbmPublishVersion() throws Exception {
//     try {
//       IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder().versionLocId(
//           "testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.ibmPublishVersion(ibmPublishVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testPublicPublishVersion() throws Exception {
//     try {
//       PublicPublishVersionOptions publicPublishVersionOptions =
//        new PublicPublishVersionOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.publicPublishVersion(publicPublishVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testCommitVersion() throws Exception {
//     try {
//       CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.commitVersion(commitVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testCopyVersion() throws Exception {
//     try {
//       CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder().versionLocId("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.copyVersion(copyVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingWorkingCopy() throws Exception {
//     try {
//       GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions =
//           new GetOfferingWorkingCopyOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Version> response = service.getOfferingWorkingCopy(getOfferingWorkingCopyOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Version versionResult = response.getResult();
//
//       assertNotNull(versionResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetVersion() throws Exception {
//     try {
//       GetVersionOptions getVersionOptions = new GetVersionOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.getVersion(getVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Offering offeringResult = response.getResult();
//
//       assertNotNull(offeringResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   public void testGetCluster() throws Exception {
//     try {
//       GetClusterOptions getClusterOptions = new GetClusterOptions.Builder().clusterId(clusterId)
//           .region("us-south")
//           .xAuthRefreshToken(refreshToken)
//           .build();
//
//       // Invoke operation
//       Response<ClusterInfo> response = service.getCluster(getClusterOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ClusterInfo clusterInfoResult = response.getResult();
//
//       assertNotNull(clusterInfoResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetNamespaces() throws Exception {
//     try {
//       GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder().clusterId(clusterId)
//           .region("us-south")
//           .xAuthRefreshToken(refreshToken)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           .build();
//
//       // Invoke operation
//       Response<NamespaceSearchResult> response = service.getNamespaces(getNamespacesOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       NamespaceSearchResult namespaceSearchResultResult = response.getResult();
//
//       assertNotNull(namespaceSearchResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeployOperators() throws Exception {
//     try {
//       DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder().xAuthRefreshToken(
//           "testString")
//           .clusterId("testString")
//           .region("testString")
//           .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .allNamespaces(true)
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<OperatorDeployResult>> response = service.deployOperators(deployOperatorsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
//
//       assertNotNull(listOperatorDeployResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testListOperators() throws Exception {
//     try {
//       ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder().xAuthRefreshToken(refreshToken)
//           .clusterId(clusterId)
//           .region("us-south")
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<OperatorDeployResult>> response = service.listOperators(listOperatorsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
//
//       assertNotNull(listOperatorDeployResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testReplaceOperators() throws Exception {
//     try {
//       ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder().xAuthRefreshToken(
//           "testString")
//           .clusterId("testString")
//           .region("testString")
//           .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .allNamespaces(true)
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<OperatorDeployResult>> response = service.replaceOperators(replaceOperatorsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
//
//       assertNotNull(listOperatorDeployResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testInstallVersion() throws Exception {
//     try {
//       DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder().name(
//           "testString")
//           .description("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .resourceGroupId("testString")
//           .build();
//
//       InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder().versionLocId("testString")
//           .xAuthRefreshToken("testString")
//           .clusterId("testString")
//           .region("testString")
//           .namespace("testString")
//           .overrideValues(new java.util.HashMap<String, Object>() {
//             {
//               put("foo", "testString");
//             }
//           })
//           .entitlementApikey("testString")
//           .schematics(deployRequestBodySchematicsModel)
//           .script("testString")
//           .scriptId("testString")
//           .versionLocatorId("testString")
//           .vcenterId("testString")
//           .vcenterUser("testString")
//           .vcenterPassword("testString")
//           .vcenterLocation("testString")
//           .vcenterDatastore("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.installVersion(installVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testPreinstallVersion() throws Exception {
//     try {
//       DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder().name(
//           "testString")
//           .description("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .resourceGroupId("testString")
//           .build();
//
//       PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder().versionLocId(
//           "testString")
//           .xAuthRefreshToken("testString")
//           .clusterId("testString")
//           .region("testString")
//           .namespace("testString")
//           .overrideValues(new java.util.HashMap<String, Object>() {
//             {
//               put("foo", "testString");
//             }
//           })
//           .entitlementApikey("testString")
//           .schematics(deployRequestBodySchematicsModel)
//           .script("testString")
//           .scriptId("testString")
//           .versionLocatorId("testString")
//           .vcenterId("testString")
//           .vcenterUser("testString")
//           .vcenterPassword("testString")
//           .vcenterLocation("testString")
//           .vcenterDatastore("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.preinstallVersion(preinstallVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetPreinstall() throws Exception {
//     try {
//       GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder().versionLocId("testString")
//           .xAuthRefreshToken("testString")
//           .clusterId("testString")
//           .region("testString")
//           .namespace("testString")
//           .build();
//
//       // Invoke operation
//       Response<InstallStatus> response = service.getPreinstall(getPreinstallOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       InstallStatus installStatusResult = response.getResult();
//
//       assertNotNull(installStatusResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testValidateInstall() throws Exception {
//     try {
//       DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder().name(
//           "testString")
//           .description("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .resourceGroupId("testString")
//           .build();
//
//       ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder().versionLocId("testString")
//           .xAuthRefreshToken("testString")
//           .clusterId("testString")
//           .region("testString")
//           .namespace("testString")
//           .overrideValues(new java.util.HashMap<String, Object>() {
//             {
//               put("foo", "testString");
//             }
//           })
//           .entitlementApikey("testString")
//           .schematics(deployRequestBodySchematicsModel)
//           .script("testString")
//           .scriptId("testString")
//           .versionLocatorId("testString")
//           .vcenterId("testString")
//           .vcenterUser("testString")
//           .vcenterPassword("testString")
//           .vcenterLocation("testString")
//           .vcenterDatastore("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.validateInstall(validateInstallOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetValidationStatus() throws Exception {
//     try {
//       GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder().versionLocId(
//           "testString")
//           .xAuthRefreshToken("testString")
//           .build();
//
//       // Invoke operation
//       Response<Validation> response = service.getValidationStatus(getValidationStatusOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Validation validationResult = response.getResult();
//
//       assertNotNull(validationResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOverrideValues() throws Exception {
//     try {
//       GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder().versionLocId(
//           "testString")
//           .build();
//
//       // Invoke operation
//       Response<Map<String, Object>> response = service.getOverrideValues(getOverrideValuesOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Map<String, Object> resultResult = response.getResult();
//
//       assertNotNull(resultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testSearchObjects() throws Exception {
//     try {
//       SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder().query("testString")
//           .limit(Long.valueOf("1000"))
//           .offset(Long.valueOf("26"))
//           .collapse(true)
//           .digest(true)
//           .build();
//
//       // Invoke operation
//       Response<ObjectSearchResult> response = service.searchObjects(searchObjectsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectSearchResult objectSearchResultResult = response.getResult();
//
//       assertNotNull(objectSearchResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testReplaceCatalog"})
//   // @Ignore
//   public void testListObjects() throws Exception {
//     try {
//       ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder().catalogIdentifier(catalogId)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           // .name("testString")
//           // .sort("testString")
//           .build();
//
//       // Invoke operation
//       Response<ObjectListResult> response = service.listObjects(listObjectsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectListResult objectListResultResult = response.getResult();
//
//       assertNotNull(objectListResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testCreateObject() throws Exception {
//     try {
//       PublishObject publishObjectModel = new PublishObject.Builder().permitIbmPublicPublish(true)
//           .ibmApproved(true)
//           .publicApproved(true)
//           .portalApprovalRecord("testString")
//           .portalUrl("testString")
//           .build();
//
//       State stateModel = new State.Builder().current("testString")
//           .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .pending("testString")
//           .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .previous("testString")
//           .build();
//
//       CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder().catalogIdentifier("testString")
//           .id("testString")
//           .name("testString")
//           .rev("testString")
//           .crn("testString")
//           .url("testString")
//           .parentId("testString")
//           .labelI18n("testString")
//           .label("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .shortDescription("testString")
//           .shortDescriptionI18n("testString")
//           .kind("testString")
//           .publish(publishObjectModel)
//           .state(stateModel)
//           .catalogId("testString")
//           .catalogName("testString")
//           .data(new java.util.HashMap<String, Object>() {
//             {
//               put("foo", "testString");
//             }
//           })
//           .build();
//
//       // Invoke operation
//       Response<CatalogObject> response = service.createObject(createObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       CatalogObject catalogObjectResult = response.getResult();
//
//       assertNotNull(catalogObjectResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetObject() throws Exception {
//     try {
//       GetObjectOptions getObjectOptions = new GetObjectOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<CatalogObject> response = service.getObject(getObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       CatalogObject catalogObjectResult = response.getResult();
//
//       assertNotNull(catalogObjectResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testReplaceObject() throws Exception {
//     try {
//       PublishObject publishObjectModel = new PublishObject.Builder().permitIbmPublicPublish(true)
//           .ibmApproved(true)
//           .publicApproved(true)
//           .portalApprovalRecord("testString")
//           .portalUrl("testString")
//           .build();
//
//       State stateModel = new State.Builder().current("testString")
//           .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .pending("testString")
//           .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .previous("testString")
//           .build();
//
//       ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .id("testString")
//           .name("testString")
//           .rev("testString")
//           .crn("testString")
//           .url("testString")
//           .parentId("testString")
//           .labelI18n("testString")
//           .label("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .shortDescription("testString")
//           .shortDescriptionI18n("testString")
//           .kind("testString")
//           .publish(publishObjectModel)
//           .state(stateModel)
//           .catalogId("testString")
//           .catalogName("testString")
//           .data(new java.util.HashMap<String, Object>() {
//             {
//               put("foo", "testString");
//             }
//           })
//           .build();
//
//       // Invoke operation
//       Response<CatalogObject> response = service.replaceObject(replaceObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       CatalogObject catalogObjectResult = response.getResult();
//
//       assertNotNull(catalogObjectResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetObjectAudit() throws Exception {
//     try {
//       GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getObjectAudit(getObjectAuditOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AuditLog auditLogResult = response.getResult();
//
//       assertNotNull(auditLogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testAccountPublishObject() throws Exception {
//     try {
//       AccountPublishObjectOptions accountPublishObjectOptions =
//  new AccountPublishObjectOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.accountPublishObject(accountPublishObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testSharedPublishObject() throws Exception {
//     try {
//       SharedPublishObjectOptions sharedPublishObjectOptions =
//           new SharedPublishObjectOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.sharedPublishObject(sharedPublishObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testIbmPublishObject() throws Exception {
//     try {
//       IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder().catalogIdentifier(
//           "testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.ibmPublishObject(ibmPublishObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testPublicPublishObject() throws Exception {
//     try {
//       PublicPublishObjectOptions publicPublishObjectOptions =
//           new PublicPublishObjectOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.publicPublishObject(publicPublishObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testCreateObjectAccess() throws Exception {
//     try {
//       CreateObjectAccessOptions createObjectAccessOptions =
//  new CreateObjectAccessOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .accountIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.createObjectAccess(createObjectAccessOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetObjectAccess() throws Exception {
//     try {
//       GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder().catalogIdentifier(
//           "testString")
//           .objectIdentifier("testString")
//           .accountIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<ObjectAccess> response = service.getObjectAccess(getObjectAccessOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectAccess objectAccessResult = response.getResult();
//
//       assertNotNull(objectAccessResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetObjectAccessList() throws Exception {
//     try {
//       GetObjectAccessListOptions getObjectAccessListOptions =
//        new GetObjectAccessListOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .limit(Long.valueOf("1000"))
//           .offset(Long.valueOf("26"))
//           .build();
//
//       // Invoke operation
//       Response<ObjectAccessListResult> response = service.getObjectAccessList(getObjectAccessListOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectAccessListResult objectAccessListResultResult = response.getResult();
//
//       assertNotNull(objectAccessListResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testAddObjectAccessList() throws Exception {
//     try {
//       AddObjectAccessListOptions addObjectAccessListOptions =
//        new AddObjectAccessListOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .build();
//
//       // Invoke operation
//       Response<AccessListBulkResponse> response = service.addObjectAccessList(addObjectAccessListOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AccessListBulkResponse accessListBulkResponseResult = response.getResult();
//
//       assertNotNull(accessListBulkResponseResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering"})
//   @Ignore
//   public void testCreateOfferingInstance() throws Exception {
//     try {
//       CreateOfferingInstanceOptions createOfferingInstanceOptions =
//           new CreateOfferingInstanceOptions.Builder().xAuthRefreshToken(refreshToken)
//           .id("offering-instance-created-by-java-sdk")
//           // .url("testString")
//           // .crn("testString")
//           .label("offering-instance-created-by-java-sdk-label")
//           .catalogId(catalogId)
//           .offeringId(offeringId)
//           .kindFormat("operator")
//           .version("0.0.3")
//           .clusterId(clusterId)
//           .clusterRegion("us-south")
//           .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("java-sdk-test")))
//           // .clusterAllNamespaces(true)
//           .build();
//
//       // Invoke operation
//       Response<OfferingInstance> response = service.createOfferingInstance(createOfferingInstanceOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//
//       OfferingInstance offeringInstanceResult = response.getResult();
//
//       assertNotNull(offeringInstanceResult);
//       offeringInstance = offeringInstanceResult.id();
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingInstance() throws Exception {
//     try {
//       GetOfferingInstanceOptions getOfferingInstanceOptions =
//        new GetOfferingInstanceOptions.Builder().instanceIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<OfferingInstance> response = service.getOfferingInstance(getOfferingInstanceOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       OfferingInstance offeringInstanceResult = response.getResult();
//
//       assertNotNull(offeringInstanceResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testPutOfferingInstance() throws Exception {
//     try {
//       PutOfferingInstanceOptions putOfferingInstanceOptions =
//           new PutOfferingInstanceOptions.Builder().instanceIdentifier("testString")
//           .xAuthRefreshToken("testString")
//           .id("testString")
//           .url("testString")
//           .crn("testString")
//           .label("testString")
//           .catalogId("testString")
//           .offeringId("testString")
//           .kindFormat("testString")
//           .version("testString")
//           .clusterId("testString")
//           .clusterRegion("testString")
//           .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .clusterAllNamespaces(true)
//           .build();
//
//       // Invoke operation
//       Response<OfferingInstance> response = service.putOfferingInstance(putOfferingInstanceOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       OfferingInstance offeringInstanceResult = response.getResult();
//
//       assertNotNull(offeringInstanceResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteVersion() throws Exception {
//     try {
//       DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder().versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteVersion(deleteVersionOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteOperators() throws Exception {
//     try {
//       DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder().xAuthRefreshToken(
//           "testString")
//           .clusterId("testString")
//           .region("testString")
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOperators(deleteOperatorsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteOfferingInstance() throws Exception {
//     try {
//       DeleteOfferingInstanceOptions deleteOfferingInstanceOptions =
//        new DeleteOfferingInstanceOptions.Builder().instanceIdentifier("testString")
//           .xAuthRefreshToken("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOfferingInstance(deleteOfferingInstanceOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//
//   @Test
//   @Ignore
//   public void testDeleteObjectAccessList() throws Exception {
//     try {
//       DeleteObjectAccessListOptions deleteObjectAccessListOptions =
//           new DeleteObjectAccessListOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .build();
//
//       // Invoke operation
//       Response<AccessListBulkResponse> response = service.deleteObjectAccessList(deleteObjectAccessListOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AccessListBulkResponse accessListBulkResponseResult = response.getResult();
//
//       assertNotNull(accessListBulkResponseResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteObjectAccess() throws Exception {
//     try {
//       DeleteObjectAccessOptions deleteObjectAccessOptions =
//        new DeleteObjectAccessOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .accountIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteObjectAccess(deleteObjectAccessOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//        e.getDebuggingInfo()));
//     }
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteObject() throws Exception {
//     try {
//       DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder().catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteObject(deleteObjectOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
// e.getDebuggingInfo()));
//     }
//   }
//
//   @AfterClass
//   public void tearDown() {
//     // Add any clean up logic here
//     System.out.println("Clean up complete.");
//   }
//
// }
