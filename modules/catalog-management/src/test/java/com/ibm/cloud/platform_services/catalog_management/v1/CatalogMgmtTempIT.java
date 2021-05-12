package com.ibm.cloud.platform_services.catalog_management.v1;

import com.ibm.cloud.platform_services.catalog_management.v1.model.*;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.IamToken;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import com.ibm.cloud.sdk.core.util.DateUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

public class CatalogMgmtTempIT extends SdkIntegrationTestBase {
  
  public CatalogManagement service = null;
  public static Map<String, String> config = null;
  // final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  // final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  /**
   * This method provides our config filename to the base class.
   */
  
  public String getConfigFilename() {
    return "../../catalog_mgmt.env";
  }
  
  private String accountId = null;
  private String clusterId = null;
  
  private String refreshToken = null;
  
  private String catalogId = null;
  private String offeringId = null;
  private String offeringInstance = null;
  
  @BeforeClass
  public void constructService() {
    // Ask super if we should skip the tests.
    if (skipTests()) {
      return;
    }
    
    service = CatalogManagement.newInstance(CatalogManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(service);
    assertNotNull(service.getServiceUrl());
    
    IamAuthenticator iamAuthenticator = (IamAuthenticator) service.getAuthenticator();
    IamToken iamToken = iamAuthenticator.requestToken();
    refreshToken = iamToken.getRefreshToken();
    
    // Load up our test-specific config properties.
    config = CredentialUtils.getServiceProperties(CatalogManagement.DEFAULT_SERVICE_NAME);
    assertNotNull(config);
    assertFalse(config.isEmpty());
    assertEquals(service.getServiceUrl(), config.get("URL"));
    
    accountId = config.get("ACCOUNT_ID");
    assertNotNull(accountId);
    
    clusterId = config.get("CLUSTER_ID");
    assertNotNull(clusterId);
    
    System.out.println("Setup complete.");
  }
  
  @Test
  // @Test(expectedExceptions = NotFoundException.class)
  // @Ignore
  public void testTemporaryTest() throws Exception {
  
    Feature featureModel = new Feature.Builder().title("feature model")
        .description("feature model description")
        .build();
  
    FilterTerms filterTermsModel =
        new FilterTerms.Builder().filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("filter terms")))
            .build();
  
    CategoryFilter categoryFilterModel = new CategoryFilter.Builder().include(true)
        .filter(filterTermsModel)
        .build();
  
    IDFilter idFilterModel = new IDFilter.Builder().include(filterTermsModel)
        .exclude(filterTermsModel)
        .build();
  
    Filters filtersModel = new Filters.Builder().includeAll(true)
        .categoryFilters(new java.util.HashMap<String, CategoryFilter>() {
          {
            put("foo", categoryFilterModel);
          }
        })
        .idFilters(idFilterModel)
        .build();
  
    SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder().region("testString")
        .id("testString")
        .name("testString")
        .resourceGroupName("testString")
        .type("testString")
        .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        .allNamespaces(true)
        .build();
  
    SyndicationHistory syndicationHistoryModel =
        new SyndicationHistory.Builder().namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList(
            "testString")))
            .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
            .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
            .build();
  
    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder().token(
        "testString")
        .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        .build();
  
    SyndicationResource syndicationResourceModel = new SyndicationResource.Builder().removeRelatedComponents(true)
        .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
        .history(syndicationHistoryModel)
        .authorization(syndicationAuthorizationModel)
        .build();
  
    ArrayList<String> catalogTags = new java.util.ArrayList<String>(java.util.Arrays.asList("java", "sdk", "tag-1",
        "tag-2"));
    ArrayList<Feature> catalogFeatures = new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel));
  
    CreateCatalogOptions createCatalogOptions = new CreateCatalogOptions.Builder()
        // .id("testString")
        // .rev("testString")
        .label("catalog created by java sdk")
        .shortDescription("catalog created by java sdk description")
        // .catalogIconUrl("testString")
        .tags(catalogTags)
        .features(catalogFeatures)
        // .disabled(true)
        // .resourceGroupId("testString")
        .owningAccount(accountId)
        .catalogFilters(filtersModel)
        // .syndicationSettings(syndicationResourceModel)
        .kind("offering")
        .build();
  
    // Invoke operation
    Response<Catalog> catalogResponse = service.createCatalog(createCatalogOptions)
        .execute();
    // Validate response
    assertNotNull(catalogResponse);
    assertEquals(catalogResponse.getStatusCode(), 201);
  
    Catalog catalogResult = catalogResponse.getResult();
  
    assertNotNull(catalogResult);
    catalogId = catalogResult.id();
    System.out.println("Catalog Id: " + catalogId);
  
    // Rating ratingModel = new Rating.Builder()
    //     .oneStarCount(Long.valueOf("26"))
    //     .twoStarCount(Long.valueOf("26"))
    //     .threeStarCount(Long.valueOf("26"))
    //     .fourStarCount(Long.valueOf("26"))
    //     .build();
    //
    // Feature featureModel = new Feature.Builder()
    //     .title("testString")
    //     .description("testString")
    //     .build();
    //
    // Configuration configurationModel = new Configuration.Builder()
    //     .key("testString")
    //     .type("testString")
    //     .defaultValue("testString")
    //     .valueConstraint("testString")
    //     .description("testString")
    //     .required(true)
    //     .options(new java.util.ArrayList<Object>(java.util.Arrays.asList("testString")))
    //     .hidden(true)
    //     .build();
    //
    // Validation validationModel = new Validation.Builder()
    //     .validated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .requested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .state("testString")
    //     .lastOperation("testString")
    //     .target(new java.util.HashMap<String, Object>() {
    //       {
    //         put("foo", "testString");
    //       }
    //     })
    //     .build();
    //
    // Resource resourceModel = new Resource.Builder()
    //     .type("mem")
    //     .value("testString")
    //     .build();
    //
    // Script scriptModel = new Script.Builder()
    //     .instructions("testString")
    //     .script("testString")
    //     .scriptPermission("testString")
    //     .deleteScript("testString")
    //     .scope("testString")
    //     .build();
    //
    // VersionEntitlement versionEntitlementModel = new VersionEntitlement.Builder()
    //     .providerName("testString")
    //     .providerId("testString")
    //     .productId("testString")
    //     .partNumbers(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    //     .imageRepoName("testString")
    //     .build();
    //
    // License licenseModel = new License.Builder()
    //     .id("testString")
    //     .name("testString")
    //     .type("testString")
    //     .url("testString")
    //     .description("testString")
    //     .build();
    //
    // State stateModel = new State.Builder()
    //     .current("testString")
    //     .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .pending("testString")
    //     .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .previous("testString")
    //     .build();
    //
    // Version versionModel = new Version.Builder()
    //     .id("testString")
    //     .rev("testString")
    //     .crn("testString")
    //     .version("testString")
    //     .sha("testString")
    //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .offeringId("testString")
    //     .catalogId("testString")
    //     .kindId("testString")
    //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    //     .repoUrl("testString")
    //     .sourceUrl("testString")
    //     .tgzUrl("testString")
    //     .configuration(new java.util.ArrayList<Configuration>(java.util.Arrays.asList(configurationModel)))
    //     .metadata(new java.util.HashMap<String, Object>() {
    //       {
    //         put("foo", "testString");
    //       }
    //     })
    //     .validation(validationModel)
    //     .requiredResources(new java.util.ArrayList<Resource>(java.util.Arrays.asList(resourceModel)))
    //     .singleInstance(true)
    //     .install(scriptModel)
    //     .preInstall(new java.util.ArrayList<Script>(java.util.Arrays.asList(scriptModel)))
    //     .entitlement(versionEntitlementModel)
    //     .licenses(new java.util.ArrayList<License>(java.util.Arrays.asList(licenseModel)))
    //     .imageManifestUrl("testString")
    //     .deprecated(true)
    //     .packageVersion("testString")
    //     .state(stateModel)
    //     .versionLocator("testString")
    //     .consoleUrl("testString")
    //     .longDescription("testString")
    //     .whitelistedAccounts(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    //     .build();
    //
    // Deployment deploymentModel = new Deployment.Builder()
    //     .id("testString")
    //     .label("testString")
    //     .name("testString")
    //     .shortDescription("testString")
    //     .longDescription("testString")
    //     .metadata(new java.util.HashMap<String, Object>() {
    //       {
    //         put("foo", "testString");
    //       }
    //     })
    //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .build();
    //
    // Plan planModel = new Plan.Builder()
    //     .id("testString")
    //     .label("testString")
    //     .name("testString")
    //     .shortDescription("testString")
    //     .longDescription("testString")
    //     .metadata(new java.util.HashMap<String, Object>() {
    //       {
    //         put("foo", "testString");
    //       }
    //     })
    //     .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
    //     .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
    //     .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
    //     .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
    //     .build();
    //
    Kind kindModel = new Kind.Builder().id("create-offering-java-sdk")
        .formatKind("operator")
        .targetKind("operator")
        // .metadata(new java.util.HashMap<String, Object>() {
        //   {
        //     put("foo", "testString");
        //   }
        // })
        // .installDescription("testString")
        // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        // .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
        // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        // .versions(new java.util.ArrayList<Version>(java.util.Arrays.asList(versionModel)))
        // .plans(new java.util.ArrayList<Plan>(java.util.Arrays.asList(planModel)))
        .build();
    //
    // RepoInfo repoInfoModel = new RepoInfo.Builder()
    //     .token("testString")
    //     .type("testString")
    //     .build();
  
    CreateOfferingOptions createOfferingOptions = new CreateOfferingOptions.Builder().catalogIdentifier(catalogId)
        // .id("testString")
        // .rev("testString")
        // .url("testString")
        // .crn("testString")
        // .label("testString")
        .name("offering-created-by-java-sdk")
        // .offeringIconUrl("testString")
        // .offeringDocsUrl("testString")
        // .offeringSupportUrl("testString")
        // .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        // .keywords(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
        // .rating(ratingModel)
        // .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        // .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
        // .shortDescription("testString")
        // .longDescription("testString")
        // .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
        .kinds(new java.util.ArrayList<Kind>(java.util.Arrays.asList(kindModel)))
        // .permitRequestIbmPublicPublish(true)
        // .ibmPublishApproved(true)
        // .publicPublishApproved(true)
        // .publicOriginalCrn("testString")
        // .publishPublicCrn("testString")
        // .portalApprovalRecord("testString")
        // .portalUiUrl("testString")
        // .catalogId("testString")
        // .catalogName("testString")
        // .metadata(new java.util.HashMap<String, Object>() {
        //   {
        //     put("foo", "testString");
        //   }
        // })
        // .disclaimer("testString")
        // .hidden(true)
        // .provider("testString")
        // .repoInfo(repoInfoModel)
        .build();
  
    // Invoke operation
    Response<Offering> offeringResponse = service.createOffering(createOfferingOptions)
        .execute();
    // Validate response
    assertNotNull(offeringResponse);
    assertEquals(offeringResponse.getStatusCode(), 201);
  
    Offering offeringResult = offeringResponse.getResult();
  
    assertNotNull(offeringResult);
    offeringId = offeringResult.id();
    System.out.println("Offering: " + offeringId);
  }
  
}
