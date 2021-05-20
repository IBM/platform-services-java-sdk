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
// import com.ibm.cloud.platform_services.catalog_management.v1.model.*;
// import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
// import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
// import com.ibm.cloud.sdk.core.http.Response;
// import com.ibm.cloud.sdk.core.security.IamAuthenticator;
// import com.ibm.cloud.sdk.core.security.IamToken;
// import com.ibm.cloud.sdk.core.service.exception.*;
// import com.ibm.cloud.sdk.core.util.CredentialUtils;
// import com.ibm.cloud.sdk.core.util.DateUtils;
//
// import java.util.*;
//
// import org.testng.annotations.*;
//
// import static org.testng.Assert.*;
//
// /**
//  * Integration test class for the CatalogManagement service.
//  */
// public class CatalogManagementIT extends SdkIntegrationTestBase {
//
//   public CatalogManagement service = null;
//   public CatalogManagement serviceNotAuthorizedShouldReturn403 = null;
//   public CatalogManagement serviceNotAuthenticatedShouldReturn401 = null;
//
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
//   private String authorizedRefreshToken = null;
//   private String notAuthorizedRefreshToken = null;
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
//     serviceNotAuthorizedShouldReturn403 = CatalogManagement.newInstance("NOT_AUTHORIZED");
//     assertNotNull(serviceNotAuthorizedShouldReturn403);
//     assertNotNull(serviceNotAuthorizedShouldReturn403.getServiceUrl());
//
//     IamAuthenticator notAuthorizedIamAuthenticator = (IamAuthenticator) serviceNotAuthorizedShouldReturn403
//         .getAuthenticator();
//     IamToken iamTokenNotAuthorized = notAuthorizedIamAuthenticator.requestToken();
//     notAuthorizedRefreshToken = iamTokenNotAuthorized.getRefreshToken();
//
//     serviceNotAuthenticatedShouldReturn401 = CatalogManagement.newInstance("NOT_AUTHENTICATED");
//     assertNotNull(serviceNotAuthenticatedShouldReturn401);
//     assertNotNull(serviceNotAuthenticatedShouldReturn401.getServiceUrl());
//
//     service = CatalogManagement.newInstance(CatalogManagement.DEFAULT_SERVICE_NAME);
//     assertNotNull(service);
//     assertNotNull(service.getServiceUrl());
//
//     IamAuthenticator iamAuthenticator = (IamAuthenticator) service.getAuthenticator();
//     IamToken iamToken = iamAuthenticator.requestToken();
//     authorizedRefreshToken = iamToken.getRefreshToken();
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
//       Response<Account> response = service.getCatalogAccount(getCatalogAccountOptions).execute();
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
//   // @Ignore
//   public void testGetCatalogAccountReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetCatalogAccountOptions getCatalogAccountOptions = new GetCatalogAccountOptions();
//
//     // Invoke operation
//     Response<Account> response = serviceNotAuthorizedShouldReturn403.getCatalogAccount(getCatalogAccountOptions)
//         .execute();
//
//     assertNotNull(response);
//     assertEquals(response.getStatusCode(), 200);
//   }
//
//   @Test
//   // @Ignore
//   public void testGetCatalogAccountReturns401WhenUserIsNotAuthenticated() throws Exception {
//     GetCatalogAccountOptions getCatalogAccountOptions = new GetCatalogAccountOptions();
//
//     // Invoke operation
//     Response<Account> response = serviceNotAuthenticatedShouldReturn401.getCatalogAccount(getCatalogAccountOptions)
//         .execute();
//     assertNotNull(response);
//     assertEquals(response.getStatusCode(), 200);
//   }
//
//   @Test
//   @Ignore
//   public void testUpdateCatalogAccount() throws Exception {
//     try {
//       FilterTerms includedFilterTermsModel =
//           new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays
//               .asList("included " + "filter" + " term - 1", "included " + "filter term - 2"))).build();
//
//       CategoryFilter includedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//           .filter(includedFilterTermsModel)
//           .build();
//
//       FilterTerms excludedFilterTermsModel =
//           new FilterTerms.Builder().filterTerms(new ArrayList<String>(Arrays.asList("excluded filter term - 1",
//               "excluded filter term - 2")))
//               .build();
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
//       UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
//           .id(accountId)
//           .hideIbmCloudCatalog(false)
//           .accountFilters(filtersModel)
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.updateCatalogAccount(updateCatalogAccountOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testUpdateCatalogAccountReturns400WhenNoSuchCatalogAccount() throws Exception {
//     FilterTerms includedFilterTermsModel =
//         new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays
//             .asList("included " + "filter" + " term - 1", "included " + "filter term - 2"))).build();
//
//     CategoryFilter includedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//         .filter(includedFilterTermsModel)
//         .build();
//
//     FilterTerms excludedFilterTermsModel =
//         new FilterTerms.Builder().filterTerms(new ArrayList<String>(Arrays.asList("excluded filter term - 1",
//             "excluded filter term - 2")))
//             .build();
//
//     CategoryFilter excludedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//         .filter(excludedFilterTermsModel)
//         .build();
//
//     Filters filtersModel = new Filters.Builder().includeAll(true)
//         .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
//           {
//             put("included-category-filter", includedCategoryFilterModel);
//             put("excluded-category-filter", excludedCategoryFilterModel);
//           }
//         })
//         .build();
//
//     UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
//         .id("bogus-account-id")
//         .hideIbmCloudCatalog(false)
//         .accountFilters(filtersModel)
//         .build();
//
//     // Invoke operation
//     Response<Void> response = service.updateCatalogAccount(updateCatalogAccountOptions).execute();
//     // Validate response
//     assertNotNull(response);
//     assertEquals(response.getStatusCode(), 200);
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testUpdateUpdateCatalogAccountReturns403WhenUserIsNotAuthorized() throws Exception {
//     FilterTerms includedFilterTermsModel =
//         new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays
//             .asList("included " + "filter" + " term - 1", "included " + "filter term - 2"))).build();
//
//     CategoryFilter includedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//         .filter(includedFilterTermsModel)
//         .build();
//
//     FilterTerms excludedFilterTermsModel =
//         new FilterTerms.Builder().filterTerms(new ArrayList<String>(Arrays.asList("excluded filter term - 1",
//             "excluded filter term - 2")))
//             .build();
//
//     CategoryFilter excludedCategoryFilterModel = new CategoryFilter.Builder().include(true)
//         .filter(excludedFilterTermsModel)
//         .build();
//
//     Filters filtersModel = new Filters.Builder().includeAll(true)
//         .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
//           {
//             put("included-category-filter", includedCategoryFilterModel);
//             put("excluded-category-filter", excludedCategoryFilterModel);
//           }
//         })
//         .build();
//
//     UpdateCatalogAccountOptions updateCatalogAccountOptions = new UpdateCatalogAccountOptions.Builder()
//         .id("bogus-account-id")
//         .hideIbmCloudCatalog(false)
//         .accountFilters(filtersModel)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.updateCatalogAccount(updateCatalogAccountOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testUpdateCatalogAccount"})
//   @Ignore
//   public void testGetUpdatedCatalogAccount() throws Exception {
//     try {
//       GetCatalogAccountOptions getCatalogAccountOptions = new GetCatalogAccountOptions();
//
//       // Invoke operation
//       Response<Account> response = service.getCatalogAccount(getCatalogAccountOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Account accountResult = response.getResult();
//
//       assertNotNull(accountResult);
//       assertEquals(accountResult.id(), accountId);
//
//       assertTrue(accountResult.accountFilters().categoryFilters().containsKey("included-category-filter"));
//       assertTrue(accountResult.accountFilters().categoryFilters().containsKey("excluded-category-filter"));
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
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetCatalogAccountFilters() throws Exception {
//     try {
//       GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
//           .catalog(catalogId)
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
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetCatalogAccountFiltersReturns404WhenNoSuchCatalog() throws Exception {
//     GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
//         .catalog("bogus-catalog-id")
//         .build();
//
//     // Invoke operation
//     service.getCatalogAccountFilters(getCatalogAccountFiltersOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetCatalogAccountFiltersReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetCatalogAccountFiltersOptions getCatalogAccountFiltersOptions = new GetCatalogAccountFiltersOptions.Builder()
//         .catalog(catalogId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getCatalogAccountFilters(getCatalogAccountFiltersOptions).execute();
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
//           new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays
//               .asList("filter terms"))).build();
//
//       CategoryFilter categoryFilterModel = new CategoryFilter.Builder().include(true).filter(filterTermsModel).build();
//
//       IDFilter idFilterModel = new IDFilter.Builder().include(filterTermsModel).exclude(filterTermsModel).build();
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
//           new SyndicationHistory.Builder().namespaces(new java.util.ArrayList<String>(java.util.Arrays
//               .asList("testString")))
//               .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//               .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//               .build();
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
//       ArrayList<String> catalogTags = new java.util.ArrayList<String>(java.util.Arrays.asList(
//           "java",
//           "sdk",
//           "tag-1",
//           "tag-2"
//       ));
//       ArrayList<Feature> catalogFeatures = new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel));
//
//       CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
//           // .id("testString")
//           // .rev("testString")
//           .label("catalog created by java sdk").shortDescription("catalog created by java sdk description")
//           // .catalogIconUrl("testString")
//           .tags(catalogTags).features(catalogFeatures)
//           // .disabled(true)
//           // .resourceGroupId("testString")
//           .owningAccount(accountId).catalogFilters(filtersModel)
//           // .syndicationSettings(syndicationResourceModel)
//           .kind("offering").build();
//
//       // Invoke operation
//       Response<Catalog> response = service.createCatalog(createCatalogOptions).execute();
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
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   public void testCreateCatalogReturns400WhenUserIsNotAuthorized() throws Exception {
//     Feature featureModel = new Feature.Builder().title("feature model")
//         .description("feature model description")
//         .build();
//
//     FilterTerms filterTermsModel =
//         new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays
//             .asList("filter terms"))).build();
//
//     CategoryFilter categoryFilterModel = new CategoryFilter.Builder().include(true).filter(filterTermsModel).build();
//
//     IDFilter idFilterModel = new IDFilter.Builder().include(filterTermsModel).exclude(filterTermsModel).build();
//
//     Filters filtersModel = new Filters.Builder().includeAll(true)
//         .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
//           {
//             put("foo", categoryFilterModel);
//           }
//         })
//         .idFilters(idFilterModel)
//         .build();
//
//     SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder().region("testString")
//         .id("testString")
//         .name("testString")
//         .resourceGroupName("testString")
//         .type("testString")
//         .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .allNamespaces(true)
//         .build();
//
//     SyndicationHistory syndicationHistoryModel =
//         new SyndicationHistory.Builder().namespaces(new java.util.ArrayList<String>(java.util.Arrays
//             .asList("testString")))
//             .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//             .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//             .build();
//
//     SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder().token(
//         "testString")
//         .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .build();
//
//     SyndicationResource syndicationResourceModel = new SyndicationResource.Builder().removeRelatedComponents(true)
//         .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
//         .history(syndicationHistoryModel)
//         .authorization(syndicationAuthorizationModel)
//         .build();
//
//     ArrayList<String> catalogTags = new java.util.ArrayList<String>(java.util.Arrays.asList("java", "sdk", "tag-1",
//         "tag-2"));
//     ArrayList<Feature> catalogFeatures = new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel));
//
//     CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
//         // .id("testString")
//         // .rev("testString")
//         .label("catalog created by java sdk").shortDescription("catalog created by java sdk description")
//         // .catalogIconUrl("testString")
//         .tags(catalogTags).features(catalogFeatures)
//         // .disabled(true)
//         // .resourceGroupId("testString")
//         .owningAccount(accountId).catalogFilters(filtersModel)
//         // .syndicationSettings(syndicationResourceModel)
//         .kind("offering").build();
//
//     // Invoke operation
//     Response<Catalog> response = serviceNotAuthorizedShouldReturn403.createCatalog(createCatalogOptions).execute();
//     // Validate response
//     assertNotNull(response);
//     assertEquals(response.getStatusCode(), 201);
//
//     Catalog catalogResult = response.getResult();
//
//     assertNotNull(catalogResult);
//     catalogId = catalogResult.id();
//     System.out.println(String.format("catalog id: %s", catalogId));
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   public void testCreateCatalogReturn400WhenValidationFails() throws Exception {
//     CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder().build();
//
//     // Invoke operation
//     service.createCatalog(createCatalogOptions).execute();
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
//       Response<CatalogSearchResult> response = service.listCatalogs(listCatalogsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       CatalogSearchResult catalogSearchResultResult = response.getResult();
//
//       assertNotNull(catalogSearchResultResult);
//       System.out.println(String.format("Result size: %d", response.getResult().getTotalCount()));
//       catalogSearchResultResult.getResources()
//           .stream()
//           .filter(p -> p.id().equals(catalogId))
//           .findAny()
//           .orElseThrow(() -> new RuntimeException(String.format("No catalog with id: %s", catalogId)));
//
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testListCatalogsWhenUserIsNotAuthorized() throws Exception {
//     try {
//       ListCatalogsOptions listCatalogsOptions = new ListCatalogsOptions();
//
//       // Invoke operation
//       Response<CatalogSearchResult> response = serviceNotAuthorizedShouldReturn403.
//           listCatalogs(listCatalogsOptions)
//           .execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       CatalogSearchResult catalogSearchResultResult = response.getResult();
//
//       assertNotNull(catalogSearchResultResult);
//
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = "testCreateCatalog")
//   public void testReplaceCatalog() throws Exception {
//     try {
//       List<String> tags = new java.util.ArrayList<String>(java.util.Arrays.asList(
//           "java",
//           "sdk",
//           "tag-1",
//           "tag-2",
//           "cloud",
//           "platform-services"
//       ));
//
//       ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .id(catalogId)
//           // .rev("testString")
//           .label("catalog updated by java sdk")
//           .shortDescription("catalog updated by java sdk")
//           // .catalogIconUrl("testString")
//           .tags(tags)
//           .owningAccount(accountId)
//           .build();
//
//       // Invoke operation
//       Response<Catalog> response = service.replaceCatalog(replaceCatalogOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Catalog catalogResult = response.getResult();
//
//       assertNotNull(catalogResult);
//
//       assertEquals(catalogResult.tags().equals(tags), true);
//
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   public void testReplaceCatalogReturns404NoSuchCatalog() throws Exception {
//     ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
//         .catalogIdentifier("bogus-catalog-id")
//         .id("bogus-catalog-id")
//         .build();
//
//     // Invoke operation
//     service.replaceCatalog(replaceCatalogOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   public void testReplaceCatalogReturns403UserIsNotAuthorized() throws Exception {
//     ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .id(catalogId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.replaceCatalog(replaceCatalogOptions).execute();
//   }
//
//   @Test(dependsOnMethods = "testCreateCatalog",
//       expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testReplaceCatalogReturns400WhenValidationFails() throws Exception {
//     ReplaceCatalogOptions replaceCatalogOptions = new ReplaceCatalogOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .id(catalogId)
//         .label("long long long long long long long long long long long long long long long long long long long long " +
//             "long long long long long long long long long long long long long label")
//         .shortDescription("long long long long long long long long long long long long long long long long long long " +
//             "long long long long long long long long long long long long long long long long long long long long long" +
//             " long long long long long long long long long long long long long long long long long long long long " +
//             "long long long long long long long long long long long long long short description")
//         .kind("kind kind kind kind kind")
//         .catalogIconUrl("some url")
//         .resourceGroupId("a fake resource group id")
//         .build();
//
//     // Invoke operation
//     service.replaceCatalog(replaceCatalogOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetCatalog() throws Exception {
//     try {
//       // What is catalog identifier and why I get 403 when I created the catalog?
//       GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .build();
//
//       // Invoke operation
//       Response<Catalog> response = service.getCatalog(getCatalogOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Catalog catalogResult = response.getResult();
//
//       assertNotNull(catalogResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetCatalogReturns404WhenNoSuchCatalog() throws Exception {
//     GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
//         .catalogIdentifier("boguscatalogid")
//         .build();
//
//     // Invoke operation
//     service.getCatalog(getCatalogOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetCatalogOptions getCatalogOptions = new GetCatalogOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getCatalog(getCatalogOptions).execute();
//   }
//
//   // it has to be the last one executed
//   @Test(priority = 1000)
//   // @Ignore
//   public void testDeleteCatalog() throws Exception {
//     try {
//       DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder().catalogIdentifier(catalogId)
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteCatalog(deleteCatalogOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testDeleteCatalogReturns404WhenNoSuchCatalog() throws Exception {
//     DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
//         .catalogIdentifier("bogus-catalog-id")
//         .build();
//
//     // Invoke operation
//     service.deleteCatalog(deleteCatalogOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testDeleteCatalogReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeleteCatalogOptions deleteCatalogOptions = new DeleteCatalogOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteCatalog(deleteCatalogOptions).execute();
//   }
//
//   @Test
//   // @Ignore
//   public void testGetCatalogAccountAudit() throws Exception {
//     try {
//       GetCatalogAccountAuditOptions getCatalogAccountAuditOptions = new GetCatalogAccountAuditOptions();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getCatalogAccountAudit(getCatalogAccountAuditOptions).execute();
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
//   @Test(expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetCatalogAccountAuditReturns403WhenUserIsNotAuthorized() {
//     GetCatalogAccountAuditOptions getCatalogAccountAuditOptions = new GetCatalogAccountAuditOptions();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getCatalogAccountAudit(getCatalogAccountAuditOptions).execute();
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
//       Response<AuditLog> response = service.getCatalogAudit(getCatalogAuditOptions).execute();
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
//   @Test(expectedExceptions = NotFoundException.class)
//   public void testGetCatalogAuditReturns404WhenNoSuchCatalog() throws Exception {
//     GetCatalogAuditOptions getCatalogAuditOptions =
//         new GetCatalogAuditOptions.Builder().catalogIdentifier(catalogId + "fake")
//             .build();
//
//     // Invoke operation
//     service.getCatalogAudit(getCatalogAuditOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   public void testGetCatalogAuditReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetCatalogAuditOptions getCatalogAuditOptions =
//         new GetCatalogAuditOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getCatalogAudit(getCatalogAuditOptions).execute();
//   }
//
//   //pager
//   @Test(dependsOnMethods = {"testCreateCatalog", "testReplaceCatalog"})
//   // @Ignore
//   public void testGetConsumptionOfferings() throws Exception {
//     try {
//       GetConsumptionOfferingsOptions getConsumptionOfferingsOptions =
//           new GetConsumptionOfferingsOptions.Builder()
//               .digest(true)
//               .catalog(catalogId)
//               .select("all")
//               .includeHidden(true)
//               // .limit(Long.valueOf("1000"))
//               // .offset(Long.valueOf("26"))
//               .build();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetConsumptionOfferingsReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetConsumptionOfferingsOptions getConsumptionOfferingsOptions = new GetConsumptionOfferingsOptions.Builder()
//         .digest(true)
//         .catalog(catalogId)
//         .select("all")
//         .includeHidden(true)
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getConsumptionOfferings(getConsumptionOfferingsOptions)
//         .execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetConsumptionOfferingsReturns404WhenNoSuchConsumptionOfferings() throws Exception {
//     GetConsumptionOfferingsOptions getConsumptionOfferingsOptions =
//         new GetConsumptionOfferingsOptions.Builder()
//             .digest(true)
//             .catalog("bogus-catalog-id")
//             .select("all")
//             .includeHidden(true)
//             // .limit(Long.valueOf("1000"))
//             // .offset(Long.valueOf("26"))
//             .build();
//
//     // Invoke operation
//     Response<OfferingSearchResult> response = service.getConsumptionOfferings(getConsumptionOfferingsOptions)
//         .execute();
//     // Validate response
//     assertNotNull(response);
//     assertEquals(response.getStatusCode(), 200);
//
//     OfferingSearchResult offeringSearchResultResult = response.getResult();
//
//     assertNotNull(offeringSearchResultResult);
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
//       Kind kindModel = new Kind.Builder().id("create-offering-java-sdk").formatKind("operator").targetKind("operator")
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
//       Response<Offering> response = service.createOffering(createOfferingOptions).execute();
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
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testCreateOfferingReturns404WhenCatalogDoesntExist() throws Exception {
//
//
//     CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
//         .catalogIdentifier("bogus-catalog-id")
//         // .id("testString")
//         // .rev("testString")
//         // .url("testString")
//         // .crn("testString")
//         // .label("testString")
//         .name("offering-created-by-java-sdk")
//         // .offeringIconUrl("testString")
//         // .offeringDocsUrl("testString")
//         // .offeringSupportUrl("testString")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .rating(ratingModel)
//         // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         // .shortDescription("testString")
//         // .longDescription("testString")
//         // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//         // .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
//         // .permitRequestIbmPublicPublish(true)
//         // .ibmPublishApproved(true)
//         // .publicPublishApproved(true)
//         // .publicOriginalCrn("testString")
//         // .publishPublicCrn("testString")
//         // .portalApprovalRecord("testString")
//         // .portalUiUrl("testString")
//         // .catalogId("testString")
//         // .catalogName("testString")
//         // .metadata(new java.util.HashMap<String, Object>() {
//         //   {
//         //     put("foo", "testString");
//         //   }
//         // })
//         // .disclaimer("testString")
//         // .hidden(true)
//         // .provider("testString")
//         // .repoInfo(repoInfoModel)
//         .build();
//
//     // Invoke operation
//     service.createOffering(createOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testCreateOfferingReturns400WhenInputIsInvalid() throws Exception {
//     CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .catalogId(catalogId)
//         // .id("testString")
//         // .rev("testString")
//         // .url("testString")
//         // .crn("testString")
//         // .label("testString")
//         .name("offering created by java sdk")
//         // .offeringIconUrl("testString")
//         // .offeringDocsUrl("testString")
//         // .offeringSupportUrl("testString")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .rating(ratingModel)
//         // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         // .shortDescription("testString")
//         // .longDescription("testString")
//         // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//         // .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
//         // .permitRequestIbmPublicPublish(true)
//         // .ibmPublishApproved(true)
//         // .publicPublishApproved(true)
//         // .publicOriginalCrn("testString")
//         // .publishPublicCrn("testString")
//         // .portalApprovalRecord("testString")
//         // .portalUiUrl("testString")
//         // .catalogName("testString")
//         // .metadata(new java.util.HashMap<String, Object>() {
//         //   {
//         //     put("foo", "testString");
//         //   }
//         // })
//         // .disclaimer("testString")
//         // .hidden(true)
//         // .provider("testString")
//         // .repoInfo(repoInfoModel)
//         .build();
//
//     // Invoke operation
//     service.createOffering(createOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testCreateOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
//     CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .catalogId(catalogId)
//         // .id("testString")
//         // .rev("testString")
//         // .url("testString")
//         // .crn("testString")
//         // .label("testString")
//         .name("offering created by java sdk")
//         // .offeringIconUrl("testString")
//         // .offeringDocsUrl("testString")
//         // .offeringSupportUrl("testString")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .rating(ratingModel)
//         // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         // .shortDescription("testString")
//         // .longDescription("testString")
//         // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
//         // .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
//         // .permitRequestIbmPublicPublish(true)
//         // .ibmPublishApproved(true)
//         // .publicPublishApproved(true)
//         // .publicOriginalCrn("testString")
//         // .publishPublicCrn("testString")
//         // .portalApprovalRecord("testString")
//         // .portalUiUrl("testString")
//         // .catalogName("testString")
//         // .metadata(new java.util.HashMap<String, Object>() {
//         //   {
//         //     put("foo", "testString");
//         //   }
//         // })
//         // .disclaimer("testString")
//         // .hidden(true)
//         // .provider("testString")
//         // .repoInfo(repoInfoModel)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.createOffering(createOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateOffering", "testCreateCatalog"})
//   @Ignore
//   public void testGetOffering() throws Exception {
//     try {
//       GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId(offeringId)
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.getOffering(getOfferingOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetOfferingReturns404WhenNoSuchOffering() throws Exception {
//     GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .build();
//
//     // Invoke operation
//     service.getOffering(getOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingOptions getOfferingOptions = new GetOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOffering(getOfferingOptions).execute();
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
//       Response<Offering> response = service.replaceOffering(replaceOfferingOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering"}, expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testReplaceOfferingFailsWhenNoSuchOfferings() throws Exception {
//     ReplaceOfferingOptions replaceOfferingOptions = new ReplaceOfferingOptions.Builder()
//         .catalogIdentifier("bogus-catalog-id")
//         .offeringId("bogus-offering-id")
//         .id("bogus-offering-id")
//         .build();
//
//     // Invoke operation
//     service.replaceOffering(replaceOfferingOptions).execute();
//   }
//
//   //pager
//   // @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering"})
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testListOfferings() throws Exception {
//     try {
//       ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .digest(true)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           // .name("testString")
//           // .sort("testString")
//           .build();
//
//       // Invoke operation
//       Response<OfferingSearchResult> response = service.listOfferings(listOfferingsOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testListOfferingsReturns403WhenUserIsNotAuthorized() throws Exception {
//     ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .digest(true)
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         // .name("testString")
//         // .sort("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.listOfferings(listOfferingsOptions).execute();
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testListOfferingsReturns400WhenInputIsInvalid() throws Exception {
//     ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .digest(true)
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         // .name("testString")
//         .sort("testString")
//         .build();
//
//     // Invoke operation
//     service.listOfferings(listOfferingsOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testListOfferingsReturns404WhenNoSuchOfferings() throws Exception {
//     ListOfferingsOptions listOfferingsOptions = new ListOfferingsOptions.Builder()
//         .catalogIdentifier("bogus-catalog-id")
//         .digest(true)
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         // .name("testString")
//         // .sort("testString")
//         .build();
//
//     // Invoke operation
//     service.listOfferings(listOfferingsOptions).execute();
//   }
//
//   // offeringid!
//   @Test(dependsOnMethods = {"testCreateOffering", "testGetOffering", "testListOfferings"})
//   @Ignore
//   public void testDeleteOffering() throws Exception {
//     try {
//       DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .offeringId(offeringId)
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOffering(deleteOfferingOptions).execute();
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
//   // @Ignore
//   public void testDeleteOfferingReturns404WhenNoSuchOfferings() throws Exception {
//     try {
//       DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId("bogus-offering-id")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOffering(deleteOfferingOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testDeleteOfferingReturns403WhenNoSuchOfferings() throws Exception {
//     DeleteOfferingOptions deleteOfferingOptions = new DeleteOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteOffering(deleteOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering"})
//   @Ignore
//   public void testImportOfferingVersion() throws Exception {
//     try {
//       ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId(offeringId)
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
//       Response<Offering> response = service.importOfferingVersion(importOfferingVersionOptions).execute();
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
//   // requires offering
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testImportOfferingVersionReturns400WhenInputIsInvalid() throws Exception {
//     ImportOfferingVersionOptions importOfferingVersionOptions =
//         new ImportOfferingVersionOptions.Builder()
//             .catalogIdentifier("testString")
//             .offeringId("testString")
//             .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//             .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//             .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//             .zipurl("testString")
//             .targetVersion("testString")
//             .includeConfig(true)
//             .isVsi(true)
//             .repoType("testString")
//             .build();
//
//     // Invoke operation
//     Response<Offering> response = service.importOfferingVersion(importOfferingVersionOptions).execute();
//     // Validate response
//     assertNotNull(response);
//     assertEquals(response.getStatusCode(), 201);
//
//     Offering offeringResult = response.getResult();
//
//     assertNotNull(offeringResult);
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testImportOfferingVersionReturns404WhenNoSuchOfferings() throws Exception {
//     ImportOfferingVersionOptions importOfferingVersionOptions =
//         new ImportOfferingVersionOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .offeringId("bogus-offering-id")
//             // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//             // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//             // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//             // .zipurl("testString")
//             // .targetVersion("testString")
//             // .includeConfig(true)
//             // .isVsi(true)
//             // .repoType("testString")
//             .build();
//
//     // Invoke operation
//     service.importOfferingVersion(importOfferingVersionOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testImportOfferingVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     ImportOfferingVersionOptions importOfferingVersionOptions = new ImportOfferingVersionOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         // .zipurl("testString")
//         // .targetVersion("testString")
//         // .includeConfig(true)
//         // .isVsi(true)
//         // .repoType("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.importOfferingVersion(importOfferingVersionOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testImportOffering() throws Exception {
//     try {
//       ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogId)
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
//               "java",
//               "sdk",
//               "example-tag-1",
//               "example-tag-2")))
//           .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("roks")))
//           // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//           .zipurl("https://github.com/rhm-samples/node-red-operator/blob/nodered-1.2.8/node-red-operator/bundle/0.0" +
//               ".2/manifests/node-red-operator.v0.0.2.clusterserviceversion.yaml")
//           // .offeringId("java-sdk-created-id-1")
//           .targetVersion("1")
//           .includeConfig(true)
//           .isVsi(true)
//           .repoType("helm")
//           // .xAuthToken("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.importOffering(importOfferingOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testImportOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
//     ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
//             "java",
//             "sdk",
//             "example-tag-1",
//             "example-tag-2")))
//         .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("roks")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .zipurl("https://github.com/rhm-samples/node-red-operator/blob/nodered-1.2.8/node-red-operator/bundle/0.0" +
//             ".2/manifests/node-red-operator.v0.0.2.clusterserviceversion.yaml")
//         // .offeringId("java-sdk-created-id-1")
//         .targetVersion("1")
//         .includeConfig(true)
//         .isVsi(true)
//         .repoType("helm")
//         // .xAuthToken("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.importOffering(importOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testImportOfferingReturns400WhenInputValidationFails() throws Exception {
//     ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("java", "sdk", "example-tag-1",
//         //     "example-tag" + "-2")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("roks")))
//         // // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .zipurl("https://github.com/rhm-samples/node-red-operator/blob/nodered-1.2.8/node-red-operator/bundle/0.0" +
//             ".2/manifests/node-red-operator.v0.0.2.clusterserviceversion.yaml")
//         // .offeringId("java-sdk-created-id-1")
//         // .targetVersion("1")
//         // .includeConfig(true)
//         // .isVsi(true)
//         // .repoType("helm")
//         .xAuthToken(authorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     service.importOffering(importOfferingOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testImportOfferingReturns400WhenNoSuchOffering() throws Exception {
//     ImportOfferingOptions importOfferingOptions = new ImportOfferingOptions.Builder().catalogIdentifier(catalogId)
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList(
//         //     "java",
//         //     "sdk",
//         //     "example-tag-1",
//         //     "example-tag-2")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList(
//         //     "roks")))
//         // // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .zipurl("https://github.com/operator-framework/community-operators/blob/master/community-operators/jenkins" +
//             "-operator/0.4.0/jenkins-operator.v0.4.0.clusterserviceversion.yaml")
//         // .offeringId("java-sdk-created-id-1")
//         // .targetVersion("1")
//         // .includeConfig(true)
//         // .isVsi(true)
//         // .repoType("helm")
//         // .xAuthToken("testString")
//         .build();
//
//     // Invoke operation
//     service.importOffering(importOfferingOptions).execute();
//   }
//
//   // offeringId!
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testReloadOffering() throws Exception {
//     try {
//       ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
//           .catalogIdentifier(catalogId)
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
//       Response<Offering> response = service.reloadOffering(reloadOfferingOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testReloadOfferingReturns404WhenNoSuchOffering() throws Exception {
//     ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .targetVersion("0.0.2")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         // .zipurl("testString")
//         // .repoType("testString")
//         .build();
//
//     // Invoke operation
//     service.reloadOffering(reloadOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testReloadOfferingReturns403WhenUserIsNotAuthorized() throws Exception {
//     ReloadOfferingOptions reloadOfferingOptions = new ReloadOfferingOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .targetVersion("0.0.2")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         // .zipurl("testString")
//         // .repoType("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.reloadOffering(reloadOfferingOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetOfferingAuditReturns200WhenNoSuchOfferings() throws Exception {
//     try {
//       GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId("random offering name")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getOfferingAudit(getOfferingAuditOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetOfferingAudit() throws Exception {
//     try {
//       GetOfferingAuditOptions getOfferingAuditOptions = new GetOfferingAuditOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId("random offering name")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getOfferingAudit(getOfferingAuditOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetOfferingAuditReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingAuditOptions getOfferingAuditOptions =
//         new GetOfferingAuditOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .offeringId("random offering name")
//             .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOfferingAudit(getOfferingAuditOptions).execute();
//   }
//
//   // offeringId
//   @Test
//   @Ignore
//   public void testReplaceOfferingIcon() throws Exception {
//     try {
//       ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
//           .catalogIdentifier("testString")
//           .offeringId("testString")
//           .fileName("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.replaceOfferingIcon(replaceOfferingIconOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering"},
//       expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testReplaceOfferingIconReturns404WhenNoSuchOffering() throws Exception {
//     ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId(offeringId)
//         .fileName("testString")
//         .build();
//
//     // Invoke operation
//     service.replaceOfferingIcon(replaceOfferingIconOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testReplaceOfferingIconReturns403WhenUserIsNotAuthorized() throws Exception {
//     ReplaceOfferingIconOptions replaceOfferingIconOptions = new ReplaceOfferingIconOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("some offering id")
//         .fileName("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.replaceOfferingIcon(replaceOfferingIconOptions).execute();
//   }
//
//   //offeringid
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testUpdateOfferingIbm() throws Exception {
//     try {
//       UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId("testString")
//           .approvalType("allow_request")
//           .approved("true")
//           .build();
//
//       // Invoke operation
//       Response<ApprovalResult> response = service.updateOfferingIbm(updateOfferingIbmOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ApprovalResult approvalResultResult = response.getResult();
//
//       assertNotNull(approvalResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testUpdateOfferingIbmReturns404WhenNoSuchOffering() throws Exception {
//     UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .approvalType("allow_request")
//         .approved("true")
//         .build();
//
//     // Invoke operation
//     service.updateOfferingIbm(updateOfferingIbmOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testUpdateOfferingIbmReturns403WhenUserIsNotAuthorized() throws Exception {
//     UpdateOfferingIbmOptions updateOfferingIbmOptions = new UpdateOfferingIbmOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offering-id")
//         .approvalType("allow_request")
//         .approved("true")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.updateOfferingIbm(updateOfferingIbmOptions).execute();
//   }
//
//   // offeringid!
//   @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering"})
//   @Ignore
//   public void testGetOfferingUpdates() throws Exception {
//     try {
//       GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .offeringId(offeringId)
//           .kind("testString")
//           .version("testString")
//           .clusterId(clusterId)
//           .region("us-south")
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
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetOfferingUpdatesReturns400WhenValidationFails() throws Exception {
//     GetOfferingUpdatesOptions getOfferingUpdatesOptions =
//         new GetOfferingUpdatesOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .offeringId("testString")
//             .kind("testString")
//             .version("testString")
//             .clusterId("testString")
//             .region("testString")
//             .resourceGroupId("testString")
//             .namespace("testString")
//             .build();
//
//     // Invoke operation
//     service.getOfferingUpdates(getOfferingUpdatesOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetOfferingUpdatesReturns400WhenNoSuchOfferings() throws Exception {
//     GetOfferingUpdatesOptions getOfferingUpdatesOptions =
//         new GetOfferingUpdatesOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .offeringId("bogus-offerings-id")
//             .kind("offering")
//             // .version("testString")
//             // .clusterId("testString")
//             // .region("testString")
//             // .resourceGroupId("testString")
//             // .namespace("testString")
//             .build();
//
//     // Invoke operation
//     service.getOfferingUpdates(getOfferingUpdatesOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetOfferingUpdatesReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingUpdatesOptions getOfferingUpdatesOptions = new GetOfferingUpdatesOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .offeringId("bogus-offerings-id")
//         .kind("offering")
//         // .version("testString")
//         // .clusterId("testString")
//         // .region("testString")
//         // .resourceGroupId("testString")
//         // .namespace("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOfferingUpdates(getOfferingUpdatesOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingAbout() throws Exception {
//     try {
//       GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<String> response = service.getOfferingAbout(getOfferingAboutOptions).execute();
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
//   @Test(expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testGetOfferingAboutReturns400WhenValidationFails() throws Exception {
//     GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
//         .versionLocId("bogus-versionLoc-id")
//         .build();
//
//     // Invoke operation
//     service.getOfferingAbout(getOfferingAboutOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetOfferingAboutReturns404WhenNoSuchOfferingAbout() throws Exception {
//     GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
//         .versionLocId("bogus-versionLoc-id")
//         .build();
//
//     // Invoke operation
//     service.getOfferingAbout(getOfferingAboutOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetOfferingAboutReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingAboutOptions getOfferingAboutOptions = new GetOfferingAboutOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOfferingAbout(getOfferingAboutOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingLicense() throws Exception {
//     try {
//       GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
//           .versionLocId("testString")
//           .licenseId("testString")
//           .build();
//
//       // Invoke operation
//       Response<String> response = service.getOfferingLicense(getOfferingLicenseOptions).execute();
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
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetOfferingLicenseReturns400WhenInputIsInvalid() throws Exception {
//     GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
//         .versionLocId("testString")
//         .licenseId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOfferingLicense(getOfferingLicenseOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetOfferingLicenseReturns404WhenNoSuchOfferingLicense() throws Exception {
//     GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
//         .versionLocId("testString")
//         .licenseId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOfferingLicense(getOfferingLicenseOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetOfferingLicenseReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingLicenseOptions getOfferingLicenseOptions = new GetOfferingLicenseOptions.Builder()
//         .versionLocId("testString")
//         .licenseId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOfferingLicense(getOfferingLicenseOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingContainerImages() throws Exception {
//     try {
//       GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
//           new GetOfferingContainerImagesOptions.Builder()
//               .versionLocId("testString")
//               .build();
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
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetOfferingContainerImagesReturns400WhenInputIsInvalid() throws Exception {
//     GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
//         new GetOfferingContainerImagesOptions.Builder()
//             .versionLocId("testString")
//             .build();
//
//     // Invoke operation
//     service.getOfferingContainerImages(getOfferingContainerImagesOptions)
//         .execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetOfferingContainerImagesReturns404WhenNoSuchVersionLocId() throws Exception {
//     GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
//         new GetOfferingContainerImagesOptions.Builder()
//             .versionLocId("testString")
//             .build();
//
//     // Invoke operation
//     service.getOfferingContainerImages(getOfferingContainerImagesOptions)
//         .execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetOfferingContainerImagesReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingContainerImagesOptions getOfferingContainerImagesOptions =
//         new GetOfferingContainerImagesOptions.Builder()
//             .versionLocId("testString")
//             .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOfferingContainerImages(getOfferingContainerImagesOptions)
//         .execute();
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
//       Response<Void> response = service.deprecateVersion(deprecateVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testDeprecateVersionReturns400WhenInputIsInvalid() throws Exception {
//     DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//     // Invoke operation
//     service.deprecateVersion(deprecateVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testDeprecateVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deprecateVersion(deprecateVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testDeprecateVersionReturns404WhenNoSuchVersion() throws Exception {
//     DeprecateVersionOptions deprecateVersionOptions = new DeprecateVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//     // Invoke operation
//     service.deprecateVersion(deprecateVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testAccountPublishVersion() throws Exception {
//     try {
//       AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.accountPublishVersion(accountPublishVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testAccountPublishVersionReturns400WhenInputValidationFails() throws Exception {
//     AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.accountPublishVersion(accountPublishVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testAccountPublishVersionReturns404WhenNoSuchVersion() throws Exception {
//     AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.accountPublishVersion(accountPublishVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testAccountPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     AccountPublishVersionOptions accountPublishVersionOptions = new AccountPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.accountPublishVersion(accountPublishVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testIbmPublishVersion() throws Exception {
//     try {
//       IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.ibmPublishVersion(ibmPublishVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testIbmPublishVersionReturns400WhenValidationFails() throws Exception {
//     IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.ibmPublishVersion(ibmPublishVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testIbmPublishVersionReturns404WhenNoSuchVersion() throws Exception {
//     IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.ibmPublishVersion(ibmPublishVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testIbmPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     IbmPublishVersionOptions ibmPublishVersionOptions = new IbmPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.ibmPublishVersion(ibmPublishVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testPublicPublishVersion() throws Exception {
//     try {
//       PublicPublishVersionOptions publicPublishVersionOptions =
//           new PublicPublishVersionOptions.Builder().versionLocId("testString")
//               .build();
//
//       // Invoke operation
//       Response<Void> response = service.publicPublishVersion(publicPublishVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testPublicPublishVersionReturns400WhenValidationFails() throws Exception {
//     PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.publicPublishVersion(publicPublishVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testPublicPublishVersionReturns404WhenNoSuchVersion() throws Exception {
//     PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.publicPublishVersion(publicPublishVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testPublicPublishVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     PublicPublishVersionOptions publicPublishVersionOptions = new PublicPublishVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.publicPublishVersion(publicPublishVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testCommitVersion() throws Exception {
//     try {
//       CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.commitVersion(commitVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testCommitVersionReturns400WhenValidationFails() throws Exception {
//     CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.commitVersion(commitVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testCommitVersionReturns404WhenNoSuchVersion() throws Exception {
//     CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.commitVersion(commitVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testCommitVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     CommitVersionOptions commitVersionOptions = new CommitVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.commitVersion(commitVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testCopyVersion() throws Exception {
//     try {
//       CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
//           .versionLocId("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.copyVersion(copyVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testCopyVersionReturns400WhenValidationFails() throws Exception {
//     CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder().versionLocId("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .build();
//
//     // Invoke operation
//     service.copyVersion(copyVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testCopyVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
//         .versionLocId("testString")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("offering")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.copyVersion(copyVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testCopyVersionReturns404WhenNoSuchCopy() throws Exception {
//     CopyVersionOptions copyVersionOptions = new CopyVersionOptions.Builder()
//         .versionLocId("testString")
//         // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         // .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("offering")))
//         // .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
//         .build();
//
//     // Invoke operation
//     service.copyVersion(copyVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingWorkingCopy() throws Exception {
//     try {
//       GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions =
//           new GetOfferingWorkingCopyOptions.Builder()
//               .versionLocId("testString")
//               .build();
//
//       // Invoke operation
//       Response<Version> response = service.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Version versionResult = response.getResult();
//
//       assertNotNull(versionResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetOfferingWorkingCopyReturns400WhenValidationFails() throws Exception {
//     GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetOfferingWorkingCopyReturns404WhenNoSuchCopy() throws Exception {
//     GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetOfferingWorkingCopyReturns403WhenValidationFails() throws Exception {
//     GetOfferingWorkingCopyOptions getOfferingWorkingCopyOptions = new GetOfferingWorkingCopyOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOfferingWorkingCopy(getOfferingWorkingCopyOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetVersion() throws Exception {
//     try {
//       GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Offering> response = service.getVersion(getVersionOptions).execute();
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
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetVersionReturns400WhenValidationFails() throws Exception {
//     GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getVersion(getVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetVersionReturns404WhenNoSuchVersion() throws Exception {
//     GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getVersion(getVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetVersionOptions getVersionOptions = new GetVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getVersion(getVersionOptions).execute();
//   }
//
//   @Test
//   public void testGetCluster() throws Exception {
//     try {
//       GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
//           .clusterId(clusterId)
//           .region("us-south")
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .build();
//
//       // Invoke operation
//       Response<ClusterInfo> response = service.getCluster(getClusterOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ClusterInfo clusterInfoResult = response.getResult();
//
//       assertNotNull(clusterInfoResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   public void testGetClusterReturns404WhenNoSuchCluster() throws Exception {
//     GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
//         .clusterId("bogus-clusterId")
//         .region("us-south")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     service.getCluster(getClusterOptions).execute();
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testGetClusterReturns400WhenValidationFails() throws Exception {
//     GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
//         .clusterId("a")
//         .region("us-south")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     service.getCluster(getClusterOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetClusterReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetClusterOptions getClusterOptions = new GetClusterOptions.Builder()
//         .clusterId("clusterId")
//         .region("us-south")
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getCluster(getClusterOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetNamespaces() throws Exception {
//     try {
//       GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
//           .clusterId(clusterId)
//           .region("us-south")
//           .xAuthRefreshToken(authorizedRefreshToken)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           .build();
//
//       // Invoke operation
//       Response<NamespaceSearchResult> response = service.getNamespaces(getNamespacesOptions).execute();
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
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetNamespacesReturns404WhenNoSuchCluster() throws Exception {
//     GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
//         .clusterId("bogus-cluster-id")
//         .region("us-south")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         .build();
//
//     // Invoke operation
//     service.getNamespaces(getNamespacesOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetNamespacesReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetNamespacesOptions getNamespacesOptions = new GetNamespacesOptions.Builder()
//         .clusterId("bogus-cluster-id")
//         .region("us-south")
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getNamespaces(getNamespacesOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCluster"})
//   @Ignore
//   public void testDeployOperators() throws Exception {
//     try {
//       DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
//           .region("us-south")
//           .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .allNamespaces(true)
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<OperatorDeployResult>> response = service.deployOperators(deployOperatorsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
//
//       assertNotNull(listOperatorDeployResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testDeployOperatorsReturns400WhenNoSuchStuffNeededForDeploy() throws Exception {
//     DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("testString")
//         .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .allNamespaces(true)
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     service.deployOperators(deployOperatorsOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testDeployOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeployOperatorsOptions deployOperatorsOptions = new DeployOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("testString")
//         // .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .allNamespaces(true)
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deployOperators(deployOperatorsOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testListOperators() throws Exception {
//     try {
//       ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
//           .region("us-south")
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<OperatorDeployResult>> response = service.listOperators(listOperatorsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
//
//       assertNotNull(listOperatorDeployResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testListOperatorsReturns400WhenInputIsInvalid() throws Exception {
//     ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     service.listOperators(listOperatorsOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testListOperatorsReturns403WhenUSerIsNotAuthorized() throws Exception {
//     ListOperatorsOptions listOperatorsOptions = new ListOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.listOperators(listOperatorsOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testReplaceOperators() throws Exception {
//     try {
//       ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
//           .region("testString")
//           .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .allNamespaces(true)
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<List<OperatorDeployResult>> response = service.replaceOperators(replaceOperatorsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       List<OperatorDeployResult> listOperatorDeployResultResult = response.getResult();
//
//       assertNotNull(listOperatorDeployResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testReplaceOperatorsReturns400WhenInputIsInvalid() throws Exception {
//     ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .allNamespaces(true)
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     service.replaceOperators(replaceOperatorsOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testReplaceOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
//     ReplaceOperatorsOptions replaceOperatorsOptions = new ReplaceOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         // .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .allNamespaces(true)
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.replaceOperators(replaceOperatorsOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testInstallVersion() throws Exception {
//     try {
//       DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//           .name(          "testString")
//           .description("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .resourceGroupId("testString")
//           .build();
//
//       InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
//           .versionLocId("testString")
//           .versionLocatorId("testString") // !!! Duplicate???
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
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
//           .vcenterId("testString")
//           .vcenterUser("testString")
//           .vcenterPassword("testString")
//           .vcenterLocation("testString")
//           .vcenterDatastore("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.installVersion(installVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testInstallVersionReturns400WhenInputIsInvalid() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     service.installVersion(installVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testInstallVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     InstallVersionOptions installVersionOptions = new InstallVersionOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.installVersion(installVersionOptions).execute();
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
//       Response<Void> response = service.preinstallVersion(preinstallVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testPreinstallVersionReturns400WhenInputIsInvalid() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     service.preinstallVersion(preinstallVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testPreinstallVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     PreinstallVersionOptions preinstallVersionOptions = new PreinstallVersionOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.preinstallVersion(preinstallVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetPreinstall() throws Exception {
//     try {
//       GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
//           .versionLocId("testString")
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
//           .region("us-south")
//           // .namespace("testString")
//           .build();
//
//       // Invoke operation
//       Response<InstallStatus> response = service.getPreinstall(getPreinstallOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       InstallStatus installStatusResult = response.getResult();
//
//       assertNotNull(installStatusResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetPreinstallReturns400WhenValidationFails() throws Exception {
//     GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .build();
//
//     // Invoke operation
//     service.getPreinstall(getPreinstallOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetPreinstallReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getPreinstall(getPreinstallOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetPreinstallReturns404WhenNoSuchThingWhichIsNeededForExecutio() throws Exception {
//     GetPreinstallOptions getPreinstallOptions = new GetPreinstallOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .build();
//
//     // Invoke operation
//     service.getPreinstall(getPreinstallOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testValidateInstall() throws Exception {
//     try {
//       DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//           .name("testString")
//           .description("testString")
//           .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .resourceGroupId("testString")
//           .build();
//
//       ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder().versionLocId("testString")
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
//           .region("us-south")
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
//       Response<Void> response = service.validateInstall(validateInstallOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testValidateInstallReturns400WhenValidationFails() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     service.validateInstall(validateInstallOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testValidateInstallReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.validateInstall(validateInstallOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testValidateInstallReturns404WhenNoSuchResource() throws Exception {
//     DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
//         .name("testString")
//         .description("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .resourceGroupId("testString")
//         .build();
//
//     ValidateInstallOptions validateInstallOptions = new ValidateInstallOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .namespace("testString")
//         .overrideValues(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .entitlementApikey("testString")
//         .schematics(deployRequestBodySchematicsModel)
//         .script("testString")
//         .scriptId("testString")
//         .versionLocatorId("testString")
//         .vcenterId("testString")
//         .vcenterUser("testString")
//         .vcenterPassword("testString")
//         .vcenterLocation("testString")
//         .vcenterDatastore("testString")
//         .build();
//
//     // Invoke operation
//     service.validateInstall(validateInstallOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetValidationStatus() throws Exception {
//     try {
//       GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
//           .versionLocId("testString")
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .build();
//
//       // Invoke operation
//       Response<Validation> response = service.getValidationStatus(getValidationStatusOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       Validation validationResult = response.getResult();
//
//       assertNotNull(validationResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetValidationStatusReturns400WhenValidationFails() throws Exception {
//     GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     service.getValidationStatus(getValidationStatusOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetValidationStatusReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getValidationStatus(getValidationStatusOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetValidationStatusReturns404WhenNoSuchResource() throws Exception {
//     GetValidationStatusOptions getValidationStatusOptions = new GetValidationStatusOptions.Builder()
//         .versionLocId("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .build();
//
//     // Invoke operation
//     service.getValidationStatus(getValidationStatusOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetOverrideValues() throws Exception {
//     try {
//       GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Map<String, Object>> response = service.getOverrideValues(getOverrideValuesOptions).execute();
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
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetOverrideValuesReturns400WhenValidationFails() throws Exception {
//     GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOverrideValues(getOverrideValuesOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetOverrideValuesReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOverrideValues(getOverrideValuesOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetOverrideValuesReturns404WhenNoSuchResource() throws Exception {
//     GetOverrideValuesOptions getOverrideValuesOptions = new GetOverrideValuesOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.getOverrideValues(getOverrideValuesOptions).execute();
//   }
//
//   // objects!
//   @Test
//   @Ignore
//   public void testSearchObjects() throws Exception {
//     try {
//       SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
//           .query("testString")
//           .limit(Long.valueOf("1000"))
//           .offset(Long.valueOf("26"))
//           .collapse(true)
//           .digest(true)
//           .build();
//
//       // Invoke operation
//       Response<ObjectSearchResult> response = service.searchObjects(searchObjectsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectSearchResult objectSearchResultResult = response.getResult();
//
//       assertNotNull(objectSearchResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testSearchObjectsReturns400WhenValidationFails() throws Exception {
//     SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
//         .query("")
//         .limit(Long.valueOf("1000"))
//         .offset(Long.valueOf("26"))
//         .collapse(true)
//         .digest(true)
//         .build();
//
//     // Invoke operation
//     service.searchObjects(searchObjectsOptions).execute();
//   }
//
//   @Test
//   // @Ignore
//   public void testSearchObjectsWhenUserIsNotAuthorized() throws Exception {
//     try {
//       SearchObjectsOptions searchObjectsOptions = new SearchObjectsOptions.Builder()
//           .query("query")
//           .limit(Long.valueOf("1000"))
//           .offset(Long.valueOf("26"))
//           .collapse(true)
//           .digest(true)
//           .build();
//
//       // Invoke operation
//       Response<ObjectSearchResult> response = serviceNotAuthorizedShouldReturn403.searchObjects(searchObjectsOptions)
//           .execute();
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testReplaceCatalog"})
//   // @Ignore
//   public void testListObjects() throws Exception {
//     try {
//       ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
//           .catalogIdentifier(catalogId)
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           // .name("testString")
//           // .sort("testString")
//           .build();
//
//       // Invoke operation
//       Response<ObjectListResult> response = service.listObjects(listObjectsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectListResult objectListResultResult = response.getResult();
//
//       assertNotNull(objectListResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testListObjectsReturns400WhenValidationFails() throws Exception {
//     ListObjectsOptions listObjectsOptions = new ListObjectsOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .limit(Long.valueOf("1000"))
//         .offset(Long.valueOf("26"))
//         .name("testString")
//         .sort("")
//         .build();
//
//     // Invoke operation
//     service.listObjects(listObjectsOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testCreateObject() throws Exception {
//     try {
//       PublishObject publishObjectModel = new PublishObject.Builder()
//           .permitIbmPublicPublish(true)
//           .ibmApproved(true)
//           .publicApproved(true)
//           .portalApprovalRecord("testString")
//           .portalUrl("testString")
//           .build();
//
//       State stateModel = new State.Builder()
//           .current("testString")
//           .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .pending("testString")
//           .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .previous("testString")
//           .build();
//
//       CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
//           .catalogIdentifier("testString")
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
//       Response<CatalogObject> response = service.createObject(createObjectOptions).execute();
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
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testCreateObjectReturns400WhenValidationFails() throws Exception {
//     PublishObject publishObjectModel = new PublishObject.Builder()
//         .permitIbmPublicPublish(true)
//         .ibmApproved(true)
//         .publicApproved(true)
//         .portalApprovalRecord("testString")
//         .portalUrl("testString")
//         .build();
//
//     State stateModel = new State.Builder()
//         .current("testString")
//         .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .pending("testString")
//         .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .previous("testString")
//         .build();
//
//     CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
//         .catalogIdentifier("testString")
//         .id("testString")
//         .name("testString")
//         .rev("testString")
//         .crn("testString")
//         .url("testString")
//         .parentId("testString")
//         .labelI18n("testString")
//         .label("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .shortDescription("testString")
//         .shortDescriptionI18n("testString")
//         .kind("testString")
//         .publish(publishObjectModel)
//         .state(stateModel)
//         .catalogId("testString")
//         .catalogName("testString")
//         .data(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .build();
//
//     // Invoke operation
//     service.createObject(createObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testCreateObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     // PublishObject publishObjectModel = new PublishObject.Builder()
//     //     .permitIbmPublicPublish(true)
//     //     .ibmApproved(true)
//     //     .publicApproved(true)
//     //     .portalApprovalRecord("testString")
//     //     .portalUrl("testString")
//     //     .build();
//     //
//     // State stateModel = new State.Builder()
//     //     .current("testString")
//     //     .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//     //     .pending("testString")
//     //     .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//     //     .previous("testString")
//     //     .build();
//
//     CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .id("testString")
//         .name("testString")
//         .rev("testString")
//         .crn("testString")
//         .url("testString")
//         .parentId("testString")
//         .labelI18n("testString")
//         .label("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .shortDescription("testString")
//         .shortDescriptionI18n("testString")
//         .kind("testString")
//         // .publish(publishObjectModel)
//         // .state(stateModel)
//         .catalogId(catalogId)
//         .catalogName("testString")
//         .data(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.createObject(createObjectOptions).execute();
//   }
//
//   // object id!
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testGetObject() throws Exception {
//     try {
//       GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<CatalogObject> response = service.getObject(getObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testGetObjectReturns400WhenNoSuchObject() throws Exception {
//     GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .build();
//
//     // Invoke operation
//     service.getObject(getObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetObjectOptions getObjectOptions = new GetObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getObject(getObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testReplaceObject() throws Exception {
//     try {
//       PublishObject publishObjectModel = new PublishObject.Builder()
//           .permitIbmPublicPublish(true)
//           .ibmApproved(true)
//           .publicApproved(true)
//           .portalApprovalRecord("testString")
//           .portalUrl("testString")
//           .build();
//
//       State stateModel = new State.Builder()
//           .current("testString")
//           .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .pending("testString")
//           .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .previous("testString")
//           .build();
//
//       ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
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
//           .catalogId(catalogId)
//           .catalogName("testString")
//           .data(new java.util.HashMap<String, Object>() {
//             {
//               put("foo", "testString");
//             }
//           })
//           .build();
//
//       // Invoke operation
//       Response<CatalogObject> response = service.replaceObject(replaceObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testReplaceObjectReturns400WhenNoSuchObject() throws Exception {
//     PublishObject publishObjectModel = new PublishObject.Builder()
//         .permitIbmPublicPublish(true)
//         .ibmApproved(true)
//         .publicApproved(true)
//         .portalApprovalRecord("testString")
//         .portalUrl("testString")
//         .build();
//
//     State stateModel = new State.Builder()
//         .current("testString")
//         .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .pending("testString")
//         .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .previous("testString")
//         .build();
//
//     ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .id("testString")
//         .name("testString")
//         .rev("testString")
//         .crn("testString")
//         .url("testString")
//         .parentId("testString")
//         .labelI18n("testString")
//         .label("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .shortDescription("testString")
//         .shortDescriptionI18n("testString")
//         .kind("testString")
//         .publish(publishObjectModel)
//         .state(stateModel)
//         .catalogId("testString")
//         .catalogName("testString")
//         .data(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .build();
//
//     // Invoke operation
//     service.replaceObject(replaceObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testReplaceObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     PublishObject publishObjectModel = new PublishObject.Builder()
//         .permitIbmPublicPublish(true)
//         .ibmApproved(true)
//         .publicApproved(true)
//         .portalApprovalRecord("testString")
//         .portalUrl("testString")
//         .build();
//
//     State stateModel = new State.Builder()
//         .current("testString")
//         .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .pending("testString")
//         .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .previous("testString")
//         .build();
//
//     ReplaceObjectOptions replaceObjectOptions = new ReplaceObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .id("testString")
//         .name("testString")
//         .rev("testString")
//         .crn("testString")
//         .url("testString")
//         .parentId("testString")
//         .labelI18n("testString")
//         .label("testString")
//         .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//         .shortDescription("testString")
//         .shortDescriptionI18n("testString")
//         .kind("testString")
//         .publish(publishObjectModel)
//         .state(stateModel)
//         .catalogId(catalogId)
//         .catalogName("testString")
//         .data(new java.util.HashMap<String, Object>() {
//           {
//             put("foo", "testString");
//           }
//         })
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.replaceObject(replaceObjectOptions).execute();
//   }
//
//   // object id
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testGetObjectAudit() throws Exception {
//     try {
//       GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getObjectAudit(getObjectAuditOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetObjectAuditReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getObjectAudit(getObjectAuditOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetObjectAuditReturns200WhenNoSuchObject() throws Exception {
//     try {
//       GetObjectAuditOptions getObjectAuditOptions = new GetObjectAuditOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<AuditLog> response = service.getObjectAudit(getObjectAuditOptions).execute();
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
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testAccountPublishObject() throws Exception {
//     try {
//       AccountPublishObjectOptions accountPublishObjectOptions = new AccountPublishObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.accountPublishObject(accountPublishObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testAccountPublishObjectReturns404WhenNoSuchObject() throws Exception {
//     AccountPublishObjectOptions accountPublishObjectOptions =
//         new AccountPublishObjectOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .objectIdentifier("bogus-object-id")
//             .build();
//
//     // Invoke operation
//     service.accountPublishObject(accountPublishObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testAccountPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     AccountPublishObjectOptions accountPublishObjectOptions =
//         new AccountPublishObjectOptions.Builder()
//             .catalogIdentifier(catalogId)
//             .objectIdentifier("bogus-object-id")
//             .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.accountPublishObject(accountPublishObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testSharedPublishObject() throws Exception {
//     try {
//       SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.sharedPublishObject(sharedPublishObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testSharedPublishObjectReturns404WhenNoSuchObject() throws Exception {
//     SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .build();
//
//     // Invoke operation
//     service.sharedPublishObject(sharedPublishObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testSharedPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     SharedPublishObjectOptions sharedPublishObjectOptions = new SharedPublishObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.sharedPublishObject(sharedPublishObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testIbmPublishObject() throws Exception {
//     try {
//       IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.ibmPublishObject(ibmPublishObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testIbmPublishObjectReturns404WhenNoSuchObject() throws Exception {
//     IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .build();
//
//     // Invoke operation
//     service.ibmPublishObject(ibmPublishObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testIbmPublishObjectReturns403WhenUSerISNotAuthorized() throws Exception {
//     IbmPublishObjectOptions ibmPublishObjectOptions = new IbmPublishObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.ibmPublishObject(ibmPublishObjectOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testPublicPublishObject() throws Exception {
//     try {
//       PublicPublishObjectOptions publicPublishObjectOptions =
//           new PublicPublishObjectOptions.Builder().catalogIdentifier("testString")
//               .objectIdentifier("testString")
//               .build();
//
//       // Invoke operation
//       Response<Void> response = service.publicPublishObject(publicPublishObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 202);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testPublicPublishObjectReturns404WhenNoSuchObject() throws Exception {
//     PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .build();
//
//     // Invoke operation
//     service.publicPublishObject(publicPublishObjectOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testPublicPublishObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     PublicPublishObjectOptions publicPublishObjectOptions = new PublicPublishObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.publicPublishObject(publicPublishObjectOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testCreateObjectAccess() throws Exception {
//     try {
//       CreateObjectAccessOptions createObjectAccessOptions =
//           new CreateObjectAccessOptions.Builder().catalogIdentifier("testString")
//               .objectIdentifier("testString")
//               .accountIdentifier("testString")
//               .build();
//
//       // Invoke operation
//       Response<Void> response = service.createObjectAccess(createObjectAccessOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 201);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testCreateObjectAccessReturns400WhenNoSuchObject() throws Exception {
//     CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .accountIdentifier(accountId)
//         .build();
//
//     // Invoke operation
//     service.createObjectAccess(createObjectAccessOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testCreateObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
//     CreateObjectAccessOptions createObjectAccessOptions = new CreateObjectAccessOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .accountIdentifier(accountId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.createObjectAccess(createObjectAccessOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testGetObjectAccess() throws Exception {
//     try {
//       GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .accountIdentifier(accountId)
//           .build();
//
//       // Invoke operation
//       Response<ObjectAccess> response = service.getObjectAccess(getObjectAccessOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectAccess objectAccessResult = response.getResult();
//
//       assertNotNull(objectAccessResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testGetObjectAccessReturns404WhenNoSuchObjectAccess() throws Exception {
//     GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accountIdentifier(accountId)
//         .build();
//
//     // Invoke operation
//     service.getObjectAccess(getObjectAccessOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetObjectAccessOptions getObjectAccessOptions = new GetObjectAccessOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accountIdentifier(accountId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getObjectAccess(getObjectAccessOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testGetObjectAccessList() throws Exception {
//     try {
//       GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .limit(Long.valueOf("1000"))
//           .offset(Long.valueOf("26"))
//           .build();
//
//       // Invoke operation
//       Response<ObjectAccessListResult> response = service.getObjectAccessList(getObjectAccessListOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       ObjectAccessListResult objectAccessListResultResult = response.getResult();
//
//       assertNotNull(objectAccessListResultResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testGetObjectAccessListReturns200WhenNoSuchObject() throws Exception {
//     try {
//       GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           // .limit(Long.valueOf("1000"))
//           // .offset(Long.valueOf("26"))
//           .build();
//
//       // Invoke operation
//       Response<ObjectAccessListResult> response = service.getObjectAccessList(getObjectAccessListOptions).execute();
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testGetObjectAccessListReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetObjectAccessListOptions getObjectAccessListOptions = new GetObjectAccessListOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         // .limit(Long.valueOf("1000"))
//         // .offset(Long.valueOf("26"))
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getObjectAccessList(getObjectAccessListOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testAddObjectAccessList() throws Exception {
//     try {
//       AddObjectAccessListOptions addObjectAccessListOptions =
//           new AddObjectAccessListOptions.Builder()
//               .catalogIdentifier("testString")
//               .objectIdentifier("testString")
//               .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//               .build();
//
//       // Invoke operation
//       Response<AccessListBulkResponse> response = service.addObjectAccessList(addObjectAccessListOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       AccessListBulkResponse accessListBulkResponseResult = response.getResult();
//
//       assertNotNull(accessListBulkResponseResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testAddObjectAccessListReturns400WhenValidationFails() throws Exception {
//     AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .build();
//
//     // Invoke operation
//     service.addObjectAccessList(addObjectAccessListOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testAddObjectAccessListReturns404WhenNoSuchObject() throws Exception {
//     AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
//         .build();
//
//     // Invoke operation
//     service.addObjectAccessList(addObjectAccessListOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testAddObjectAccessListReturns403WhenUserIsNotAuthorized() throws Exception {
//     AddObjectAccessListOptions addObjectAccessListOptions = new AddObjectAccessListOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
//         .build();
//
//     // Invoke operation
//     service.addObjectAccessList(addObjectAccessListOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog", "testCreateOffering"})
//   @Ignore
//   public void testCreateOfferingInstance() throws Exception {
//     try {
//       CreateOfferingInstanceOptions createOfferingInstanceOptions =
//           new CreateOfferingInstanceOptions.Builder().xAuthRefreshToken(authorizedRefreshToken)
//               .id("offering-instance-created-by-java-sdk")
//               // .url("testString")
//               // .crn("testString")
//               .label("offering-instance-created-by-java-sdk-label")
//               .catalogId(catalogId)
//               .offeringId(offeringId)
//               .kindFormat("operator")
//               .version("0.0.3")
//               .clusterId(clusterId)
//               .clusterRegion("us-south")
//               .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("java-sdk-test")))
//               // .clusterAllNamespaces(true)
//               .build();
//
//       // Invoke operation
//       Response<OfferingInstance> response = service.createOfferingInstance(createOfferingInstanceOptions).execute();
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
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testCreateOfferingInstanceReturns400WhenValidationFails() throws Exception {
//     CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .id("offering-instance-created-by-java-sdk")
//         // .url("testString")
//         // .crn("testString")
//         .label("offering-instance-created-by-java-sdk-label")
//         .catalogId(catalogId)
//         .offeringId(offeringId)
//         .kindFormat("operator")
//         .version("0.0.3")
//         .clusterId(clusterId)
//         .clusterRegion("us-south")
//         .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("java-sdk-test")))
//         // .clusterAllNamespaces(true)
//         .build();
//
//     // Invoke operation
//     service.createOfferingInstance(createOfferingInstanceOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testCreateOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
//     CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         .id("offering-instance-created-by-java-sdk")
//         // .url("testString")
//         // .crn("testString")
//         .label("offering-instance-created-by-java-sdk-label")
//         .catalogId(catalogId)
//         .offeringId(offeringId)
//         .kindFormat("operator")
//         .version("0.0.3")
//         .clusterId(clusterId)
//         .clusterRegion("us-south")
//         .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("java-sdk-test")))
//         // .clusterAllNamespaces(true)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.createOfferingInstance(createOfferingInstanceOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testCreateOfferingInstanceReturns404WhenNoSuchResource() throws Exception {
//     CreateOfferingInstanceOptions createOfferingInstanceOptions = new CreateOfferingInstanceOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .id("offering-instance-created-by-java-sdk")
//         // .url("testString")
//         // .crn("testString")
//         .label("offering-instance-created-by-java-sdk-label")
//         .catalogId(catalogId)
//         .offeringId(offeringId)
//         .kindFormat("operator")
//         .version("0.0.3")
//         .clusterId(clusterId)
//         .clusterRegion("us-south")
//         .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("java-sdk-test")))
//         // .clusterAllNamespaces(true)
//         .build();
//
//     // Invoke operation
//     service.createOfferingInstance(createOfferingInstanceOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testGetOfferingInstance() throws Exception {
//     try {
//       GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
//           .instanceIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<OfferingInstance> response = service.getOfferingInstance(getOfferingInstanceOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       OfferingInstance offeringInstanceResult = response.getResult();
//
//       assertNotNull(offeringInstanceResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testGetOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
//     GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
//         .instanceIdentifier("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.getOfferingInstance(getOfferingInstanceOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   // @Ignore
//   public void testGetOfferingInstanceReturns404WhenSuchResource() throws Exception {
//     GetOfferingInstanceOptions getOfferingInstanceOptions = new GetOfferingInstanceOptions.Builder()
//         .instanceIdentifier("testString")
//         .build();
//
//     // Invoke operation
//     service.getOfferingInstance(getOfferingInstanceOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testPutOfferingInstance() throws Exception {
//     try {
//       PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
//           .instanceIdentifier("testString")
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .id("testString")
//           .url("testString")
//           .crn("testString")
//           .label("testString")
//           .catalogId(catalogId)
//           .offeringId("testString")
//           .kindFormat("testString")
//           .version("testString")
//           .clusterId(clusterId)
//           .clusterRegion("us-south")
//           .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .clusterAllNamespaces(true)
//           .build();
//
//       // Invoke operation
//       Response<OfferingInstance> response = service.putOfferingInstance(putOfferingInstanceOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//
//       OfferingInstance offeringInstanceResult = response.getResult();
//
//       assertNotNull(offeringInstanceResult);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testPutOfferingInstanceReturns400WhenValidationFails() throws Exception {
//     PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
//         .instanceIdentifier("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .id("testString")
//         .url("testString")
//         .crn("testString")
//         .label("testString")
//         .catalogId(catalogId)
//         .offeringId("testString")
//         .kindFormat("testString")
//         .version("testString")
//         .clusterId(clusterId)
//         .clusterRegion("us-south")
//         // .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .clusterAllNamespaces(true)
//         .build();
//
//     // Invoke operation
//     service.putOfferingInstance(putOfferingInstanceOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testPutOfferingInstanceReturns403WhenUserIsNotAuthorized() throws Exception {
//     PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
//         .instanceIdentifier("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .id("testString")
//         .url("testString")
//         .crn("testString")
//         .label("testString")
//         .catalogId(catalogId)
//         .offeringId("testString")
//         .kindFormat("testString")
//         .version("testString")
//         .clusterId(clusterId)
//         .clusterRegion("us-south")
//         // .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .clusterAllNamespaces(true)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.putOfferingInstance(putOfferingInstanceOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testPutOfferingInstanceReturns404WhenNoSuchResource() throws Exception {
//     PutOfferingInstanceOptions putOfferingInstanceOptions = new PutOfferingInstanceOptions.Builder()
//         .instanceIdentifier("testString")
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .id("testString")
//         .url("testString")
//         .crn("testString")
//         .label("testString")
//         .catalogId(catalogId)
//         .offeringId("testString")
//         .kindFormat("testString")
//         .version("testString")
//         .clusterId(clusterId)
//         .clusterRegion("us-south")
//         // .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//         .clusterAllNamespaces(true)
//         .build();
//
//     // Invoke operation
//     service.putOfferingInstance(putOfferingInstanceOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteVersion() throws Exception {
//     try {
//       DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
//           .versionLocId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteVersion(deleteVersionOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testDeleteVersionReturns400WhenValidationFails() throws Exception {
//     DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.deleteVersion(deleteVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testDeleteVersionReturns404WhenValidationFails() throws Exception {
//     DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     service.deleteVersion(deleteVersionOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testDeleteVersionReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeleteVersionOptions deleteVersionOptions = new DeleteVersionOptions.Builder()
//         .versionLocId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteVersion(deleteVersionOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteOperators() throws Exception {
//     try {
//       DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
//           .xAuthRefreshToken(authorizedRefreshToken)
//           .clusterId(clusterId)
//           .region("us-south")
//           .versionLocatorId("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOperators(deleteOperatorsOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testDeleteOperatorsReturns400WhenValidationFails() throws Exception {
//     DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     service.deleteOperators(deleteOperatorsOptions).execute();
//   }
//
//   @Test(expectedExceptions = NotFoundException.class)
//   @Ignore
//   public void testDeleteOperatorsReturns404WhenNoSuchThingNeededForDeleteOperation() throws Exception {
//     DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
//         .xAuthRefreshToken(authorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     service.deleteOperators(deleteOperatorsOptions).execute();
//   }
//
//   @Test(expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testDeleteOperatorsReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeleteOperatorsOptions deleteOperatorsOptions = new DeleteOperatorsOptions.Builder()
//         .xAuthRefreshToken(notAuthorizedRefreshToken)
//         .clusterId(clusterId)
//         .region("us-south")
//         .versionLocatorId("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteOperators(deleteOperatorsOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteOfferingInstance() throws Exception {
//     try {
//       DeleteOfferingInstanceOptions deleteOfferingInstanceOptions =
//           new DeleteOfferingInstanceOptions.Builder().instanceIdentifier("testString")
//               .xAuthRefreshToken("testString")
//               .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteOfferingInstance(deleteOfferingInstanceOptions).execute();
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
//   public void testDeleteObjectAccessList() throws Exception {
//     try {
//       DeleteObjectAccessListOptions deleteObjectAccessListOptions =
//           new DeleteObjectAccessListOptions.Builder().catalogIdentifier("testString")
//               .objectIdentifier("testString")
//               .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//               .build();
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
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   // @Ignore
//   public void testDeleteObjectAccessListReturn400WhenNoSuchObject() throws Exception {
//     DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
//         .build();
//
//     // Invoke operation
//     service.deleteObjectAccessList(deleteObjectAccessListOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testDeleteObjectAccessListReturn403WhenUserIsNotAuthorized() throws Exception {
//     DeleteObjectAccessListOptions deleteObjectAccessListOptions = new DeleteObjectAccessListOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .accounts(new java.util.ArrayList<String>(java.util.Arrays.asList(accountId)))
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteObjectAccessList(deleteObjectAccessListOptions).execute();
//   }
//
//   @Test
//   @Ignore
//   public void testDeleteObjectAccess() throws Exception {
//     try {
//       DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
//           .catalogIdentifier("testString")
//           .objectIdentifier("testString")
//           .accountIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteObjectAccess(deleteObjectAccessOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = BadRequestException.class)
//   @Ignore
//   public void testDeleteObjectAccessReturns400WhenNoSuchObjectAccess() throws Exception {
//     DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accountIdentifier(accountId)
//         .build();
//
//     // Invoke operation
//     service.deleteObjectAccess(deleteObjectAccessOptions).execute();
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   // @Ignore
//   public void testDeleteObjectAccessReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeleteObjectAccessOptions deleteObjectAccessOptions = new DeleteObjectAccessOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("bogus-object-id")
//         .accountIdentifier(accountId)
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteObjectAccess(deleteObjectAccessOptions).execute();
//   }
//
//   // object id
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   @Ignore
//   public void testDeleteObject() throws Exception {
//     try {
//       DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("testString")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteObject(deleteObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"})
//   // @Ignore
//   public void testDeleteObjectReturns200WhenNoSuchObject() throws Exception {
//     try {
//       DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           .objectIdentifier("bogus-object-identifier")
//           .build();
//
//       // Invoke operation
//       Response<Void> response = service.deleteObject(deleteObjectOptions).execute();
//       // Validate response
//       assertNotNull(response);
//       assertEquals(response.getStatusCode(), 200);
//     } catch (ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
//   @Test(dependsOnMethods = {"testCreateCatalog"},
//       expectedExceptions = ForbiddenException.class)
//   @Ignore
//   public void testDeleteObjectReturns403WhenUserIsNotAuthorized() throws Exception {
//     DeleteObjectOptions deleteObjectOptions = new DeleteObjectOptions.Builder()
//         .catalogIdentifier(catalogId)
//         .objectIdentifier("testString")
//         .build();
//
//     // Invoke operation
//     serviceNotAuthorizedShouldReturn403.deleteObject(deleteObjectOptions).execute();
//   }
//
//   @AfterClass
//   public void tearDown() {
//     // Add any clean up logic here
//     System.out.println("Clean up complete.");
//   }
//
// }
