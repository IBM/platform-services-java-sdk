// package com.ibm.cloud.platform_services.catalog_management.v1;
//
// import com.ibm.cloud.platform_services.catalog_management.v1.model.*;
// import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
// import com.ibm.cloud.sdk.core.http.Response;
// import com.ibm.cloud.sdk.core.security.IamAuthenticator;
// import com.ibm.cloud.sdk.core.security.IamToken;
// import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
// import com.ibm.cloud.sdk.core.util.CredentialUtils;
// import com.ibm.cloud.sdk.core.util.DateUtils;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.Test;
//
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Map;
//
// import static org.testng.Assert.*;
// import static org.testng.Assert.assertNotNull;
//
// public class CatalogManagementObjectsIT extends SdkIntegrationTestBase {
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
//   public void testCatalog() throws Exception {
//     try {
//
//       // === create catalog
//
//       Feature featureModel = new Feature.Builder().title("feature model")
//           .description("feature model description")
//           .build();
//
//       FilterTerms filterTermsModel = new FilterTerms.Builder()
//           .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("filter terms")))
//           .build();
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
//       SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
//           .token("testString")
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
//           .label("catalog created by java sdk")
//           .shortDescription("catalog created by java sdk description")
//           // .catalogIconUrl("testString")
//           .tags(catalogTags)
//           .features(catalogFeatures)
//           .disabled(false)
//           // .resourceGroupId("testString")
//           .owningAccount(accountId)
//           .catalogFilters(filtersModel)
//           // .syndicationSettings(syndicationResourceModel)
//           .kind("offering")
//           .build();
//
//       // Invoke operation
//       Response<Catalog> createResponse = service.createCatalog(createCatalogOptions).execute();
//       // Validate response
//       assertNotNull(createResponse);
//       assertEquals(createResponse.getStatusCode(), 201);
//
//       Catalog catalogResult = createResponse.getResult();
//
//       assertNotNull(catalogResult);
//       catalogId = catalogResult.id();
//       System.out.println(String.format("catalog id: %s", catalogId));
//
//       // === create object
//       /*
//       Issues:
//       - kind is a mandatory field, but we don't know what value it can has
//       - what other mandatory fields are regarding objects? seemingly validation fails with the first issue
//
//       Goal:
//       - create object
//       - modify object
//       - delete object
//        */
//
//       PublishObject publishObjectModel = new PublishObject.Builder()
//           .permitIbmPublicPublish(true)
//           .ibmApproved(true)
//           .publicApproved(true)
//           .portalApprovalRecord("portal approver record")
//           .portalUrl("https://cloud.ibm.com")
//           .build();
//
//       State stateModel = new State.Builder()
//           .current("published")
//           .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .pending("testString")
//           // .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           // .previous("testString")
//           .build();
//
//       CreateObjectOptions createObjectOptions = new CreateObjectOptions.Builder()
//           .catalogIdentifier(catalogId)
//           // .id("testString")
//           .name("java_sdk_object")
//           .rev("0.0.1")
//           // .crn("testString")
//           // .url("testString")
//           // .parentId("testString")
//           // .labelI18n("en")
//           // .label("testString")
//           // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
//           .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
//           .shortDescription("java-sdk-object")
//           // .shortDescriptionI18n("java-sdk-object")
//           .kind("operator")
//           .publish(publishObjectModel)
//           .state(stateModel)
//           .catalogId(catalogId)
//           // .catalogName("testString")
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
//
//
//
//     } catch (
//         ServiceResponseException e) {
//       fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(), e.getMessage(),
//           e.getDebuggingInfo()));
//     }
//   }
//
// }
