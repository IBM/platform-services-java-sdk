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
package com.ibm.cloud.platform_services.global_catalog.v1;

import com.ibm.cloud.platform_services.global_catalog.v1.GlobalCatalog;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Artifact;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Artifacts;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntry;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CreateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBaseBroker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetAuditLogsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetChildObjectsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetPricingOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.I18N;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListArtifactsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListCatalogEntriesOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Metrics;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseAlias;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBasePlan;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseService;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSla;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSlaDr;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplate;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateEnvironmentVariables;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateSource;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.OverviewUI;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingGet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.RestoreCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.SearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.StartingPrice;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaMedia;
import com.ibm.cloud.platform_services.global_catalog.v1.model.URLS;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UploadArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Visibility;
import com.ibm.cloud.platform_services.global_catalog.v1.model.VisibilityDetail;
import com.ibm.cloud.platform_services.global_catalog.v1.model.VisibilityDetailAccounts;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
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
 * Unit test class for the GlobalCatalog service.
 */
@PrepareForTest({ EnvironmentUtils.class })
@PowerMockIgnore("javax.net.ssl.*")
public class GlobalCatalogTest extends PowerMockTestCase {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();
  
  protected MockWebServer server;
  protected GlobalCatalog testService;

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

    testService = GlobalCatalog.newInstance(serviceName);
    String url = server.url("/").toString();
    testService.setServiceUrl(url);
  }

  /**
  * Negative Test - construct the service with a null authenticator.
  */
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";

    new GlobalCatalog(serviceName, null);
  }

  @Test
  public void testListCatalogEntriesWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"page\": \"page\", \"results_per_page\": \"resultsPerPage\", \"total_results\": \"totalResults\", \"resources\": [\"anyValue\"]}";
    String listCatalogEntriesPath = "/";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListCatalogEntriesOptions model
    ListCatalogEntriesOptions listCatalogEntriesOptionsModel = new ListCatalogEntriesOptions.Builder()
    .account("testString")
    .include("testString")
    .q("testString")
    .sortBy("testString")
    .descending("testString")
    .languages("testString")
    .complete("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SearchResult> response = testService.listCatalogEntries(listCatalogEntriesOptionsModel).execute();
    assertNotNull(response);
    SearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("include"), "testString");
    assertEquals(query.get("q"), "testString");
    assertEquals(query.get("sort-by"), "testString");
    assertEquals(query.get("descending"), "testString");
    assertEquals(query.get("languages"), "testString");
    assertEquals(query.get("complete"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCatalogEntriesPath);
  }

  @Test
  public void testCreateCatalogEntryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"metadata\": {\"rc_compatible\": true, \"ui\": {\"strings\": {}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"reservable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00\"}, \"compliance\": [\"compliance\"], \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"cf_guid\": \"cfGuid\", \"bindable\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": \"cfGuid\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"_key_\": \"key\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": \"provisioning\", \"responsiveness\": \"responsiveness\", \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"broker_utl\": \"brokerUtl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"service_staging_url\": \"serviceStagingUrl\", \"service_production_url\": \"serviceProductionUrl\"}, \"version\": \"version\", \"original_name\": \"originalName\", \"other\": {\"mapKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"amount\": [{\"counrty\": \"counrty\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"Price\": 5}]}]}}, \"deployment\": {\"location\": \"location\", \"target_crn\": \"targetCrn\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"anyValue\", \"url\": \"anyValue\", \"children_url\": \"anyValue\", \"geo_tags\": \"anyValue\", \"pricing_tags\": \"anyValue\", \"created\": \"anyValue\", \"updated\": \"anyValue\"}";
    String createCatalogEntryPath = "/";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(201)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Bullets model
    Bullets bulletsModel = new Bullets.Builder()
    .title("testString")
    .description("testString")
    .icon("testString")
    .quantity("testString")
    .build();

    // Construct an instance of the Price model
    Price priceModel = new Price.Builder()
    .quantityTier(Long.valueOf("26"))
    .price(Double.valueOf("72.5"))
    .build();

    // Construct an instance of the UIMetaMedia model
    UIMetaMedia uiMetaMediaModel = new UIMetaMedia.Builder()
    .caption("testString")
    .thumbnailUrl("testString")
    .type("testString")
    .url("testString")
    .source(bulletsModel)
    .build();

    // Construct an instance of the Amount model
    Amount amountModel = new Amount.Builder()
    .counrty("testString")
    .currency("testString")
    .prices(new ArrayList<Price>(Arrays.asList(priceModel)))
    .build();

    // Construct an instance of the Strings model
    Strings stringsModel = new Strings.Builder()
    .bullets(new ArrayList<Bullets>(Arrays.asList(bulletsModel)))
    .media(new ArrayList<UIMetaMedia>(Arrays.asList(uiMetaMediaModel)))
    .notCreatableMsg("testString")
    .notCreatableRobotMsg("testString")
    .deprecationWarning("testString")
    .popupWarningMessage("testString")
    .instruction("testString")
    .build();

    // Construct an instance of the DeploymentBaseBroker model
    DeploymentBaseBroker deploymentBaseBrokerModel = new DeploymentBaseBroker.Builder()
    .name("testString")
    .guid("testString")
    .build();

    // Construct an instance of the I18N model
    I18N i18NModel = new I18N();
    i18NModel.put("foo", stringsModel);

    // Construct an instance of the ObjectMetadataBaseSlaDr model
    ObjectMetadataBaseSlaDr objectMetadataBaseSlaDrModel = new ObjectMetadataBaseSlaDr.Builder()
    .dr(true)
    .description("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseTemplateEnvironmentVariables model
    ObjectMetadataBaseTemplateEnvironmentVariables objectMetadataBaseTemplateEnvironmentVariablesModel = new ObjectMetadataBaseTemplateEnvironmentVariables.Builder()
    .key("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseTemplateSource model
    ObjectMetadataBaseTemplateSource objectMetadataBaseTemplateSourceModel = new ObjectMetadataBaseTemplateSource.Builder()
    .path("testString")
    .type("testString")
    .url("testString")
    .build();

    // Construct an instance of the StartingPrice model
    StartingPrice startingPriceModel = new StartingPrice.Builder()
    .planId("testString")
    .deploymentId("testString")
    .amount(new ArrayList<Amount>(Arrays.asList(amountModel)))
    .build();

    // Construct an instance of the URLS model
    URLS urlsModel = new URLS.Builder()
    .docUrl("testString")
    .instructionsUrl("testString")
    .apiUrl("testString")
    .createUrl("testString")
    .sdkDownloadUrl("testString")
    .termsUrl("testString")
    .customCreatePageUrl("testString")
    .catalogDetailsUrl("testString")
    .deprecationDocUrl("testString")
    .build();

    // Construct an instance of the Callbacks model
    Callbacks callbacksModel = new Callbacks.Builder()
    .brokerUtl("testString")
    .brokerProxyUrl("testString")
    .dashboardUrl("testString")
    .dashboardDataUrl("testString")
    .dashboardDetailTabUrl("testString")
    .dashboardDetailTabExtUrl("testString")
    .serviceMonitorApi("testString")
    .serviceMonitorApp("testString")
    .serviceStagingUrl("testString")
    .serviceProductionUrl("testString")
    .build();

    // Construct an instance of the DeploymentBase model
    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
    .location("testString")
    .targetCrn("testString")
    .broker(deploymentBaseBrokerModel)
    .supportsRcMigration(true)
    .targetNetwork("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseAlias model
    ObjectMetadataBaseAlias objectMetadataBaseAliasModel = new ObjectMetadataBaseAlias.Builder()
    .type("testString")
    .planId("testString")
    .build();

    // Construct an instance of the ObjectMetadataBasePlan model
    ObjectMetadataBasePlan objectMetadataBasePlanModel = new ObjectMetadataBasePlan.Builder()
    .bindable(true)
    .reservable(true)
    .allowInternalUsers(true)
    .asyncProvisioningSupported(true)
    .asyncUnprovisioningSupported(true)
    .testCheckInterval(Long.valueOf("26"))
    .singleScopeInstance("testString")
    .serviceCheckEnabled(true)
    .cfGuid("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseService model
    ObjectMetadataBaseService objectMetadataBaseServiceModel = new ObjectMetadataBaseService.Builder()
    .type("testString")
    .iamCompatible(true)
    .uniqueApiKey(true)
    .provisionable(true)
    .asyncProvisioningSupported(true)
    .asyncUnprovisioningSupported(true)
    .cfGuid("testString")
    .bindable(true)
    .requires(new ArrayList<String>(Arrays.asList("testString")))
    .planUpdateable(true)
    .state("testString")
    .serviceCheckEnabled(true)
    .testCheckInterval(Long.valueOf("26"))
    .serviceKeySupported(true)
    .build();

    // Construct an instance of the ObjectMetadataBaseSla model
    ObjectMetadataBaseSla objectMetadataBaseSlaModel = new ObjectMetadataBaseSla.Builder()
    .terms("testString")
    .tenancy("testString")
    .provisioning("testString")
    .responsiveness("testString")
    .dr(objectMetadataBaseSlaDrModel)
    .build();

    // Construct an instance of the ObjectMetadataBaseTemplate model
    ObjectMetadataBaseTemplate objectMetadataBaseTemplateModel = new ObjectMetadataBaseTemplate.Builder()
    .services(new ArrayList<String>(Arrays.asList("testString")))
    .defaultMemory(Long.valueOf("26"))
    .startCmd("testString")
    .source(objectMetadataBaseTemplateSourceModel)
    .runtimeCatalogId("testString")
    .cfRuntimeId("testString")
    .templateId("testString")
    .executableFile("testString")
    .buildpack("testString")
    .environmentVariables(objectMetadataBaseTemplateEnvironmentVariablesModel)
    .build();

    // Construct an instance of the Overview model
    Overview overviewModel = new Overview.Builder()
    .displayName("testString")
    .longDescription("testString")
    .description("testString")
    .build();

    // Construct an instance of the PricingSet model
    PricingSet pricingSetModel = new PricingSet.Builder()
    .type("testString")
    .origin("testString")
    .startingPrice(startingPriceModel)
    .build();

    // Construct an instance of the UIMetaData model
    UIMetaData uiMetaDataModel = new UIMetaData.Builder()
    .strings(i18NModel)
    .urls(urlsModel)
    .embeddableDashboard("testString")
    .embeddableDashboardFullWidth(true)
    .navigationOrder(new ArrayList<String>(Arrays.asList("testString")))
    .notCreatable(true)
    .reservable(true)
    .primaryOfferingId("testString")
    .accessibleDuringProvision(true)
    .sideBySideIndex(Long.valueOf("26"))
    .endOfServiceTime(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the Image model
    Image imageModel = new Image.Builder()
    .image("testString")
    .smallImage("testString")
    .mediumImage("testString")
    .featureImage("testString")
    .build();

    // Construct an instance of the ObjectMetadataSet model
    ObjectMetadataSet objectMetadataSetModel = new ObjectMetadataSet.Builder()
    .rcCompatible(true)
    .ui(uiMetaDataModel)
    .compliance(new ArrayList<String>(Arrays.asList("testString")))
    .service(objectMetadataBaseServiceModel)
    .plan(objectMetadataBasePlanModel)
    .template(objectMetadataBaseTemplateModel)
    .alias(objectMetadataBaseAliasModel)
    .sla(objectMetadataBaseSlaModel)
    .callbacks(callbacksModel)
    .version("testString")
    .originalName("testString")
    .other(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .pricing(pricingSetModel)
    .deployment(deploymentBaseModel)
    .build();

    // Construct an instance of the OverviewUI model
    OverviewUI overviewUiModel = new OverviewUI();
    overviewUiModel.put("foo", overviewModel);

    // Construct an instance of the Provider model
    Provider providerModel = new Provider.Builder()
    .email("testString")
    .name("testString")
    .contact("testString")
    .supportEmail("testString")
    .phone("testString")
    .build();

    // Construct an instance of the CreateCatalogEntryOptions model
    CreateCatalogEntryOptions createCatalogEntryOptionsModel = new CreateCatalogEntryOptions.Builder()
    .name("testString")
    .kind("service")
    .overviewUi(overviewUiModel)
    .images(imageModel)
    .disabled(true)
    .tags(new ArrayList<String>(Arrays.asList("testString")))
    .provider(providerModel)
    .id("testString")
    .parentId("testString")
    .group(true)
    .active(true)
    .metadata(objectMetadataSetModel)
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogEntry> response = testService.createCatalogEntry(createCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    CatalogEntry responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCatalogEntryPath);
  }

  // Test the createCatalogEntry operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCatalogEntryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.createCatalogEntry(null).execute();
  }

  @Test
  public void testGetCatalogEntryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"metadata\": {\"rc_compatible\": true, \"ui\": {\"strings\": {}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"reservable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00\"}, \"compliance\": [\"compliance\"], \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"cf_guid\": \"cfGuid\", \"bindable\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": \"cfGuid\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"_key_\": \"key\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": \"provisioning\", \"responsiveness\": \"responsiveness\", \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"broker_utl\": \"brokerUtl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"service_staging_url\": \"serviceStagingUrl\", \"service_production_url\": \"serviceProductionUrl\"}, \"version\": \"version\", \"original_name\": \"originalName\", \"other\": {\"mapKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"amount\": [{\"counrty\": \"counrty\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"Price\": 5}]}]}}, \"deployment\": {\"location\": \"location\", \"target_crn\": \"targetCrn\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"anyValue\", \"url\": \"anyValue\", \"children_url\": \"anyValue\", \"geo_tags\": \"anyValue\", \"pricing_tags\": \"anyValue\", \"created\": \"anyValue\", \"updated\": \"anyValue\"}";
    String getCatalogEntryPath = "/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetCatalogEntryOptions model
    GetCatalogEntryOptions getCatalogEntryOptionsModel = new GetCatalogEntryOptions.Builder()
    .id("testString")
    .account("testString")
    .include("testString")
    .languages("testString")
    .complete("testString")
    .depth(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogEntry> response = testService.getCatalogEntry(getCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    CatalogEntry responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("include"), "testString");
    assertEquals(query.get("languages"), "testString");
    assertEquals(query.get("complete"), "testString");
    assertEquals(Long.valueOf(query.get("depth")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCatalogEntryPath);
  }

  // Test the getCatalogEntry operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCatalogEntryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getCatalogEntry(null).execute();
  }

  @Test
  public void testUpdateCatalogEntryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"metadata\": {\"rc_compatible\": true, \"ui\": {\"strings\": {}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"reservable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00\"}, \"compliance\": [\"compliance\"], \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"cf_guid\": \"cfGuid\", \"bindable\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": \"cfGuid\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"_key_\": \"key\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": \"provisioning\", \"responsiveness\": \"responsiveness\", \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"broker_utl\": \"brokerUtl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"service_staging_url\": \"serviceStagingUrl\", \"service_production_url\": \"serviceProductionUrl\"}, \"version\": \"version\", \"original_name\": \"originalName\", \"other\": {\"mapKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"amount\": [{\"counrty\": \"counrty\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"Price\": 5}]}]}}, \"deployment\": {\"location\": \"location\", \"target_crn\": \"targetCrn\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"anyValue\", \"url\": \"anyValue\", \"children_url\": \"anyValue\", \"geo_tags\": \"anyValue\", \"pricing_tags\": \"anyValue\", \"created\": \"anyValue\", \"updated\": \"anyValue\"}";
    String updateCatalogEntryPath = "/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the Bullets model
    Bullets bulletsModel = new Bullets.Builder()
    .title("testString")
    .description("testString")
    .icon("testString")
    .quantity("testString")
    .build();

    // Construct an instance of the Price model
    Price priceModel = new Price.Builder()
    .quantityTier(Long.valueOf("26"))
    .price(Double.valueOf("72.5"))
    .build();

    // Construct an instance of the UIMetaMedia model
    UIMetaMedia uiMetaMediaModel = new UIMetaMedia.Builder()
    .caption("testString")
    .thumbnailUrl("testString")
    .type("testString")
    .url("testString")
    .source(bulletsModel)
    .build();

    // Construct an instance of the Amount model
    Amount amountModel = new Amount.Builder()
    .counrty("testString")
    .currency("testString")
    .prices(new ArrayList<Price>(Arrays.asList(priceModel)))
    .build();

    // Construct an instance of the Strings model
    Strings stringsModel = new Strings.Builder()
    .bullets(new ArrayList<Bullets>(Arrays.asList(bulletsModel)))
    .media(new ArrayList<UIMetaMedia>(Arrays.asList(uiMetaMediaModel)))
    .notCreatableMsg("testString")
    .notCreatableRobotMsg("testString")
    .deprecationWarning("testString")
    .popupWarningMessage("testString")
    .instruction("testString")
    .build();

    // Construct an instance of the DeploymentBaseBroker model
    DeploymentBaseBroker deploymentBaseBrokerModel = new DeploymentBaseBroker.Builder()
    .name("testString")
    .guid("testString")
    .build();

    // Construct an instance of the I18N model
    I18N i18NModel = new I18N();
    i18NModel.put("foo", stringsModel);

    // Construct an instance of the ObjectMetadataBaseSlaDr model
    ObjectMetadataBaseSlaDr objectMetadataBaseSlaDrModel = new ObjectMetadataBaseSlaDr.Builder()
    .dr(true)
    .description("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseTemplateEnvironmentVariables model
    ObjectMetadataBaseTemplateEnvironmentVariables objectMetadataBaseTemplateEnvironmentVariablesModel = new ObjectMetadataBaseTemplateEnvironmentVariables.Builder()
    .key("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseTemplateSource model
    ObjectMetadataBaseTemplateSource objectMetadataBaseTemplateSourceModel = new ObjectMetadataBaseTemplateSource.Builder()
    .path("testString")
    .type("testString")
    .url("testString")
    .build();

    // Construct an instance of the StartingPrice model
    StartingPrice startingPriceModel = new StartingPrice.Builder()
    .planId("testString")
    .deploymentId("testString")
    .amount(new ArrayList<Amount>(Arrays.asList(amountModel)))
    .build();

    // Construct an instance of the URLS model
    URLS urlsModel = new URLS.Builder()
    .docUrl("testString")
    .instructionsUrl("testString")
    .apiUrl("testString")
    .createUrl("testString")
    .sdkDownloadUrl("testString")
    .termsUrl("testString")
    .customCreatePageUrl("testString")
    .catalogDetailsUrl("testString")
    .deprecationDocUrl("testString")
    .build();

    // Construct an instance of the Callbacks model
    Callbacks callbacksModel = new Callbacks.Builder()
    .brokerUtl("testString")
    .brokerProxyUrl("testString")
    .dashboardUrl("testString")
    .dashboardDataUrl("testString")
    .dashboardDetailTabUrl("testString")
    .dashboardDetailTabExtUrl("testString")
    .serviceMonitorApi("testString")
    .serviceMonitorApp("testString")
    .serviceStagingUrl("testString")
    .serviceProductionUrl("testString")
    .build();

    // Construct an instance of the DeploymentBase model
    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
    .location("testString")
    .targetCrn("testString")
    .broker(deploymentBaseBrokerModel)
    .supportsRcMigration(true)
    .targetNetwork("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseAlias model
    ObjectMetadataBaseAlias objectMetadataBaseAliasModel = new ObjectMetadataBaseAlias.Builder()
    .type("testString")
    .planId("testString")
    .build();

    // Construct an instance of the ObjectMetadataBasePlan model
    ObjectMetadataBasePlan objectMetadataBasePlanModel = new ObjectMetadataBasePlan.Builder()
    .bindable(true)
    .reservable(true)
    .allowInternalUsers(true)
    .asyncProvisioningSupported(true)
    .asyncUnprovisioningSupported(true)
    .testCheckInterval(Long.valueOf("26"))
    .singleScopeInstance("testString")
    .serviceCheckEnabled(true)
    .cfGuid("testString")
    .build();

    // Construct an instance of the ObjectMetadataBaseService model
    ObjectMetadataBaseService objectMetadataBaseServiceModel = new ObjectMetadataBaseService.Builder()
    .type("testString")
    .iamCompatible(true)
    .uniqueApiKey(true)
    .provisionable(true)
    .asyncProvisioningSupported(true)
    .asyncUnprovisioningSupported(true)
    .cfGuid("testString")
    .bindable(true)
    .requires(new ArrayList<String>(Arrays.asList("testString")))
    .planUpdateable(true)
    .state("testString")
    .serviceCheckEnabled(true)
    .testCheckInterval(Long.valueOf("26"))
    .serviceKeySupported(true)
    .build();

    // Construct an instance of the ObjectMetadataBaseSla model
    ObjectMetadataBaseSla objectMetadataBaseSlaModel = new ObjectMetadataBaseSla.Builder()
    .terms("testString")
    .tenancy("testString")
    .provisioning("testString")
    .responsiveness("testString")
    .dr(objectMetadataBaseSlaDrModel)
    .build();

    // Construct an instance of the ObjectMetadataBaseTemplate model
    ObjectMetadataBaseTemplate objectMetadataBaseTemplateModel = new ObjectMetadataBaseTemplate.Builder()
    .services(new ArrayList<String>(Arrays.asList("testString")))
    .defaultMemory(Long.valueOf("26"))
    .startCmd("testString")
    .source(objectMetadataBaseTemplateSourceModel)
    .runtimeCatalogId("testString")
    .cfRuntimeId("testString")
    .templateId("testString")
    .executableFile("testString")
    .buildpack("testString")
    .environmentVariables(objectMetadataBaseTemplateEnvironmentVariablesModel)
    .build();

    // Construct an instance of the Overview model
    Overview overviewModel = new Overview.Builder()
    .displayName("testString")
    .longDescription("testString")
    .description("testString")
    .build();

    // Construct an instance of the PricingSet model
    PricingSet pricingSetModel = new PricingSet.Builder()
    .type("testString")
    .origin("testString")
    .startingPrice(startingPriceModel)
    .build();

    // Construct an instance of the UIMetaData model
    UIMetaData uiMetaDataModel = new UIMetaData.Builder()
    .strings(i18NModel)
    .urls(urlsModel)
    .embeddableDashboard("testString")
    .embeddableDashboardFullWidth(true)
    .navigationOrder(new ArrayList<String>(Arrays.asList("testString")))
    .notCreatable(true)
    .reservable(true)
    .primaryOfferingId("testString")
    .accessibleDuringProvision(true)
    .sideBySideIndex(Long.valueOf("26"))
    .endOfServiceTime(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
    .build();

    // Construct an instance of the Image model
    Image imageModel = new Image.Builder()
    .image("testString")
    .smallImage("testString")
    .mediumImage("testString")
    .featureImage("testString")
    .build();

    // Construct an instance of the ObjectMetadataSet model
    ObjectMetadataSet objectMetadataSetModel = new ObjectMetadataSet.Builder()
    .rcCompatible(true)
    .ui(uiMetaDataModel)
    .compliance(new ArrayList<String>(Arrays.asList("testString")))
    .service(objectMetadataBaseServiceModel)
    .plan(objectMetadataBasePlanModel)
    .template(objectMetadataBaseTemplateModel)
    .alias(objectMetadataBaseAliasModel)
    .sla(objectMetadataBaseSlaModel)
    .callbacks(callbacksModel)
    .version("testString")
    .originalName("testString")
    .other(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
    .pricing(pricingSetModel)
    .deployment(deploymentBaseModel)
    .build();

    // Construct an instance of the OverviewUI model
    OverviewUI overviewUiModel = new OverviewUI();
    overviewUiModel.put("foo", overviewModel);

    // Construct an instance of the Provider model
    Provider providerModel = new Provider.Builder()
    .email("testString")
    .name("testString")
    .contact("testString")
    .supportEmail("testString")
    .phone("testString")
    .build();

    // Construct an instance of the UpdateCatalogEntryOptions model
    UpdateCatalogEntryOptions updateCatalogEntryOptionsModel = new UpdateCatalogEntryOptions.Builder()
    .id("testString")
    .name("testString")
    .kind("service")
    .overviewUi(overviewUiModel)
    .images(imageModel)
    .disabled(true)
    .tags(new ArrayList<String>(Arrays.asList("testString")))
    .provider(providerModel)
    .parentId("testString")
    .group(true)
    .active(true)
    .metadata(objectMetadataSetModel)
    .account("testString")
    .move("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<CatalogEntry> response = testService.updateCatalogEntry(updateCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    CatalogEntry responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("move"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCatalogEntryPath);
  }

  // Test the updateCatalogEntry operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCatalogEntryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateCatalogEntry(null).execute();
  }

  @Test
  public void testDeleteCatalogEntryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteCatalogEntryPath = "/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteCatalogEntryOptions model
    DeleteCatalogEntryOptions deleteCatalogEntryOptionsModel = new DeleteCatalogEntryOptions.Builder()
    .id("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteCatalogEntry(deleteCatalogEntryOptionsModel).execute();
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
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCatalogEntryPath);
  }

  // Test the deleteCatalogEntry operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCatalogEntryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteCatalogEntry(null).execute();
  }

  @Test
  public void testGetChildObjectsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "[{\"page\": \"page\", \"results_per_page\": \"resultsPerPage\", \"total_results\": \"totalResults\", \"resources\": [\"anyValue\"]}]";
    String getChildObjectsPath = "/testString/testString";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetChildObjectsOptions model
    GetChildObjectsOptions getChildObjectsOptionsModel = new GetChildObjectsOptions.Builder()
    .id("testString")
    .kind("testString")
    .account("testString")
    .include("testString")
    .q("testString")
    .sortBy("testString")
    .descending("testString")
    .languages("testString")
    .complete("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<List<SearchResult>> response = testService.getChildObjects(getChildObjectsOptionsModel).execute();
    assertNotNull(response);
    List<SearchResult> responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("include"), "testString");
    assertEquals(query.get("q"), "testString");
    assertEquals(query.get("sort-by"), "testString");
    assertEquals(query.get("descending"), "testString");
    assertEquals(query.get("languages"), "testString");
    assertEquals(query.get("complete"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getChildObjectsPath);
  }

  // Test the getChildObjects operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetChildObjectsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getChildObjects(null).execute();
  }

  @Test
  public void testRestoreCatalogEntryWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String restoreCatalogEntryPath = "/testString/restore";

    server.enqueue(new MockResponse()
    .setResponseCode(204)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the RestoreCatalogEntryOptions model
    RestoreCatalogEntryOptions restoreCatalogEntryOptionsModel = new RestoreCatalogEntryOptions.Builder()
    .id("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.restoreCatalogEntry(restoreCatalogEntryOptionsModel).execute();
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
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, restoreCatalogEntryPath);
  }

  // Test the restoreCatalogEntry operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRestoreCatalogEntryNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.restoreCatalogEntry(null).execute();
  }

  @Test
  public void testGetVisibilityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"restrictions\": \"restrictions\", \"owner\": \"owner\", \"include\": {\"accounts\": {\"_accountid_\": \"accountid\"}}, \"exclude\": {\"accounts\": {\"_accountid_\": \"accountid\"}}, \"approved\": true}";
    String getVisibilityPath = "/testString/visibility";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetVisibilityOptions model
    GetVisibilityOptions getVisibilityOptionsModel = new GetVisibilityOptions.Builder()
    .id("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Visibility> response = testService.getVisibility(getVisibilityOptionsModel).execute();
    assertNotNull(response);
    Visibility responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getVisibilityPath);
  }

  // Test the getVisibility operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVisibilityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getVisibility(null).execute();
  }

  @Test
  public void testUpdateVisibilityWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String updateVisibilityPath = "/testString/visibility";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the VisibilityDetailAccounts model
    VisibilityDetailAccounts visibilityDetailAccountsModel = new VisibilityDetailAccounts.Builder()
    .accountid("testString")
    .build();

    // Construct an instance of the VisibilityDetail model
    VisibilityDetail visibilityDetailModel = new VisibilityDetail.Builder()
    .accounts(visibilityDetailAccountsModel)
    .build();

    // Construct an instance of the UpdateVisibilityOptions model
    UpdateVisibilityOptions updateVisibilityOptionsModel = new UpdateVisibilityOptions.Builder()
    .id("testString")
    .include(visibilityDetailModel)
    .exclude(visibilityDetailModel)
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.updateVisibility(updateVisibilityOptionsModel).execute();
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
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateVisibilityPath);
  }

  // Test the updateVisibility operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateVisibilityNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.updateVisibility(null).execute();
  }

  @Test
  public void testGetPricingWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"amount\": [{\"counrty\": \"counrty\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"Price\": 5}]}]}, \"metrics\": [{\"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": \"chargeUnitQuantity\", \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"amounts\": [{\"counrty\": \"counrty\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"Price\": 5}]}]}]}";
    String getPricingPath = "/testString/pricing";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetPricingOptions model
    GetPricingOptions getPricingOptionsModel = new GetPricingOptions.Builder()
    .id("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<PricingGet> response = testService.getPricing(getPricingOptionsModel).execute();
    assertNotNull(response);
    PricingGet responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPricingPath);
  }

  // Test the getPricing operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPricingNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getPricing(null).execute();
  }

  @Test
  public void testGetAuditLogsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"page\": \"page\", \"results_per_page\": \"resultsPerPage\", \"total_results\": \"totalResults\", \"resources\": [\"anyValue\"]}";
    String getAuditLogsPath = "/testString/logs";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetAuditLogsOptions model
    GetAuditLogsOptions getAuditLogsOptionsModel = new GetAuditLogsOptions.Builder()
    .id("testString")
    .account("testString")
    .ascending("testString")
    .startat("testString")
    .offset(Long.valueOf("26"))
    .limit(Long.valueOf("26"))
    .build();

    // Invoke operation with valid options model (positive test)
    Response<SearchResult> response = testService.getAuditLogs(getAuditLogsOptionsModel).execute();
    assertNotNull(response);
    SearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("ascending"), "testString");
    assertEquals(query.get("startat"), "testString");
    assertEquals(Long.valueOf(query.get("_offset")), Long.valueOf("26"));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("26"));
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAuditLogsPath);
  }

  // Test the getAuditLogs operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAuditLogsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getAuditLogs(null).execute();
  }

  @Test
  public void testListArtifactsWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "{\"count\": 5, \"resources\": [{\"name\": \"name\", \"updated\": \"updated\", \"url\": \"url\", \"etag\": \"etag\", \"size\": 4}]}";
    String listArtifactsPath = "/testString/artifacts";

    server.enqueue(new MockResponse()
    .setHeader("Content-type", "application/json")
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the ListArtifactsOptions model
    ListArtifactsOptions listArtifactsOptionsModel = new ListArtifactsOptions.Builder()
    .objectId("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Artifacts> response = testService.listArtifacts(listArtifactsOptionsModel).execute();
    assertNotNull(response);
    Artifacts responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");

    // Check query
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listArtifactsPath);
  }

  // Test the listArtifacts operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListArtifactsNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.listArtifacts(null).execute();
  }

  @Test
  public void testGetArtifactWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String getArtifactPath = "/testString/artifacts/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the GetArtifactOptions model
    GetArtifactOptions getArtifactOptionsModel = new GetArtifactOptions.Builder()
    .objectId("testString")
    .artifactId("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.getArtifact(getArtifactOptionsModel).execute();
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
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getArtifactPath);
  }

  // Test the getArtifact operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetArtifactNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.getArtifact(null).execute();
  }

  @Test
  public void testUploadArtifactWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String uploadArtifactPath = "/testString/artifacts/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the UploadArtifactOptions model
    UploadArtifactOptions uploadArtifactOptionsModel = new UploadArtifactOptions.Builder()
    .objectId("testString")
    .artifactId("testString")
    .artifact(TestUtilities.createMockStream("This is a mock file."))
    .contentType("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.uploadArtifact(uploadArtifactOptionsModel).execute();
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
    assertNotNull(query);
    // Get query params
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, uploadArtifactPath);
  }

  // Test the uploadArtifact operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUploadArtifactNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.uploadArtifact(null).execute();
  }

  @Test
  public void testDeleteArtifactWOptions() throws Throwable {
    // Schedule some responses.
    String mockResponseBody = "";
    String deleteArtifactPath = "/testString/artifacts/testString";

    server.enqueue(new MockResponse()
    .setResponseCode(200)
    .setBody(mockResponseBody));

    constructClientService();

    // Construct an instance of the DeleteArtifactOptions model
    DeleteArtifactOptions deleteArtifactOptionsModel = new DeleteArtifactOptions.Builder()
    .objectId("testString")
    .artifactId("testString")
    .account("testString")
    .build();

    // Invoke operation with valid options model (positive test)
    Response<Void> response = testService.deleteArtifact(deleteArtifactOptionsModel).execute();
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
    assertEquals(query.get("account"), "testString");
    // Check request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteArtifactPath);
  }

  // Test the deleteArtifact operation with null options model parameter
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteArtifactNoOptions() throws Throwable {
    // construct the service
    constructClientService();

    server.enqueue(new MockResponse());

    // Invoke operation with null options model (negative test)
    testService.deleteArtifact(null).execute();
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