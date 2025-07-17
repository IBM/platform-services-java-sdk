/*
 * (C) Copyright IBM Corp. 2025.
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
import com.ibm.cloud.platform_services.global_catalog.v1.model.AliasMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Artifact;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Artifacts;
import com.ibm.cloud.platform_services.global_catalog.v1.model.AuditSearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Broker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CFMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntry;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadata;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadataDeployment;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CatalogEntryMetadataPricing;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CreateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DRMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.EntrySearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetArtifactOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetAuditLogsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetChildObjectsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetPricingDeploymentsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetPricingOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.GetVisibilityOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListArtifactsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ListCatalogEntriesOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Message;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Metrics;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PlanMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingGet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSearchResult;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.RestoreCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.SLAMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.SourceMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.StartingPrice;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.TemplateMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMediaSourceMetaData;
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
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.IOException;
import java.io.InputStream;
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
 * Unit test class for the GlobalCatalog service.
 */
public class GlobalCatalogTest {

  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  protected MockWebServer server;
  protected GlobalCatalog globalCatalogService;

  // Construct the service with a null authenticator (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testConstructorWithNullAuthenticator() throws Throwable {
    final String serviceName = "testService";
    new GlobalCatalog(serviceName, null);
  }

  // Test the listCatalogEntries operation with a valid options model parameter
  @Test
  public void testListCatalogEntriesWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"count\": 5, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {\"mapKey\": {\"display_name\": \"displayName\", \"long_description\": \"longDescription\", \"description\": \"description\", \"featured_description\": \"featuredDescription\"}}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"url\": \"url\", \"metadata\": {\"rc_compatible\": true, \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"bindable\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false, \"cf_guid\": {\"mapKey\": \"inner\"}, \"crn_mask\": \"crnMask\", \"paid_only\": true, \"custom_create_page_hybrid_enabled\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"provision_type\": \"provisionType\", \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": {\"mapKey\": \"inner\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"mapKey\": \"inner\"}}, \"ui\": {\"strings\": {\"mapKey\": {\"bullets\": [{\"title\": \"title\", \"description\": \"description\", \"icon\": \"icon\", \"quantity\": 8}], \"media\": [{\"caption\": \"caption\", \"thumbnail_url\": \"thumbnailUrl\", \"type\": \"type\", \"URL\": \"url\", \"source\": [{\"type\": \"type\", \"url\": \"url\"}]}], \"not_creatable_msg\": \"notCreatableMsg\", \"not_creatable__robot_msg\": \"notCreatableRobotMsg\", \"deprecation_warning\": \"deprecationWarning\", \"popup_warning_message\": \"popupWarningMessage\", \"instruction\": \"instruction\"}}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\", \"dashboard_url\": \"dashboardUrl\", \"registration_url\": \"registrationUrl\", \"apidocsurl\": \"apidocsurl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00.000Z\", \"hidden\": true, \"hide_lite_metering\": true, \"no_upgrade_next_step\": false}, \"compliance\": [\"compliance\"], \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": 12, \"responsiveness\": 14, \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"controller_url\": \"controllerUrl\", \"broker_url\": \"brokerUrl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"api_endpoint\": {\"mapKey\": \"inner\"}}, \"original_name\": \"originalName\", \"version\": \"version\", \"other\": {\"anyKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}, \"deployment\": {\"location\": \"location\", \"location_url\": \"locationUrl\", \"original_location\": \"originalLocation\", \"target_crn\": \"targetCrn\", \"service_crn\": \"serviceCrn\", \"mccp_id\": \"mccpId\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"catalogCrn\", \"children_url\": \"childrenUrl\", \"geo_tags\": [\"geoTags\"], \"pricing_tags\": [\"pricingTags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String listCatalogEntriesPath = "/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListCatalogEntriesOptions model
    ListCatalogEntriesOptions listCatalogEntriesOptionsModel = new ListCatalogEntriesOptions.Builder()
      .account("testString")
      .include("testString")
      .q("testString")
      .sortBy("testString")
      .descending("testString")
      .languages("testString")
      .catalog(true)
      .complete(true)
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("50"))
      .build();

    // Invoke listCatalogEntries() with a valid options model and verify the result
    Response<EntrySearchResult> response = globalCatalogService.listCatalogEntries(listCatalogEntriesOptionsModel).execute();
    assertNotNull(response);
    EntrySearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listCatalogEntriesPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("include"), "testString");
    assertEquals(query.get("q"), "testString");
    assertEquals(query.get("sort-by"), "testString");
    assertEquals(query.get("descending"), "testString");
    assertEquals(query.get("languages"), "testString");
    assertEquals(Boolean.valueOf(query.get("catalog")), Boolean.valueOf(true));
    assertEquals(Boolean.valueOf(query.get("complete")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_offset")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("50"));
  }

  // Test the listCatalogEntries operation with and without retries enabled
  @Test
  public void testListCatalogEntriesWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testListCatalogEntriesWOptions();

    globalCatalogService.disableRetries();
    testListCatalogEntriesWOptions();
  }

  // Test the createCatalogEntry operation with a valid options model parameter
  @Test
  public void testCreateCatalogEntryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {\"mapKey\": {\"display_name\": \"displayName\", \"long_description\": \"longDescription\", \"description\": \"description\", \"featured_description\": \"featuredDescription\"}}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"url\": \"url\", \"metadata\": {\"rc_compatible\": true, \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"bindable\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false, \"cf_guid\": {\"mapKey\": \"inner\"}, \"crn_mask\": \"crnMask\", \"paid_only\": true, \"custom_create_page_hybrid_enabled\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"provision_type\": \"provisionType\", \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": {\"mapKey\": \"inner\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"mapKey\": \"inner\"}}, \"ui\": {\"strings\": {\"mapKey\": {\"bullets\": [{\"title\": \"title\", \"description\": \"description\", \"icon\": \"icon\", \"quantity\": 8}], \"media\": [{\"caption\": \"caption\", \"thumbnail_url\": \"thumbnailUrl\", \"type\": \"type\", \"URL\": \"url\", \"source\": [{\"type\": \"type\", \"url\": \"url\"}]}], \"not_creatable_msg\": \"notCreatableMsg\", \"not_creatable__robot_msg\": \"notCreatableRobotMsg\", \"deprecation_warning\": \"deprecationWarning\", \"popup_warning_message\": \"popupWarningMessage\", \"instruction\": \"instruction\"}}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\", \"dashboard_url\": \"dashboardUrl\", \"registration_url\": \"registrationUrl\", \"apidocsurl\": \"apidocsurl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00.000Z\", \"hidden\": true, \"hide_lite_metering\": true, \"no_upgrade_next_step\": false}, \"compliance\": [\"compliance\"], \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": 12, \"responsiveness\": 14, \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"controller_url\": \"controllerUrl\", \"broker_url\": \"brokerUrl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"api_endpoint\": {\"mapKey\": \"inner\"}}, \"original_name\": \"originalName\", \"version\": \"version\", \"other\": {\"anyKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}, \"deployment\": {\"location\": \"location\", \"location_url\": \"locationUrl\", \"original_location\": \"originalLocation\", \"target_crn\": \"targetCrn\", \"service_crn\": \"serviceCrn\", \"mccp_id\": \"mccpId\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"catalogCrn\", \"children_url\": \"childrenUrl\", \"geo_tags\": [\"geoTags\"], \"pricing_tags\": [\"pricingTags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String createCatalogEntryPath = "/";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(201)
      .setBody(mockResponseBody));

    // Construct an instance of the Overview model
    Overview overviewModel = new Overview.Builder()
      .displayName("testString")
      .longDescription("testString")
      .description("testString")
      .featuredDescription("testString")
      .build();

    // Construct an instance of the Image model
    Image imageModel = new Image.Builder()
      .image("testString")
      .smallImage("testString")
      .mediumImage("testString")
      .featureImage("testString")
      .build();

    // Construct an instance of the Provider model
    Provider providerModel = new Provider.Builder()
      .email("testString")
      .name("testString")
      .contact("testString")
      .supportEmail("testString")
      .phone("testString")
      .build();

    // Construct an instance of the CFMetaData model
    CFMetaData cfMetaDataModel = new CFMetaData.Builder()
      .type("testString")
      .iamCompatible(true)
      .uniqueApiKey(true)
      .provisionable(true)
      .bindable(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .requires(java.util.Arrays.asList("testString"))
      .planUpdateable(true)
      .state("testString")
      .serviceCheckEnabled(true)
      .testCheckInterval(Long.valueOf("26"))
      .serviceKeySupported(true)
      .cfGuid(java.util.Collections.singletonMap("key1", "testString"))
      .crnMask("testString")
      .paidOnly(true)
      .customCreatePageHybridEnabled(true)
      .build();

    // Construct an instance of the PlanMetaData model
    PlanMetaData planMetaDataModel = new PlanMetaData.Builder()
      .bindable(true)
      .reservable(true)
      .allowInternalUsers(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .provisionType("testString")
      .testCheckInterval(Long.valueOf("26"))
      .singleScopeInstance("testString")
      .serviceCheckEnabled(true)
      .cfGuid(java.util.Collections.singletonMap("key1", "testString"))
      .build();

    // Construct an instance of the AliasMetaData model
    AliasMetaData aliasMetaDataModel = new AliasMetaData.Builder()
      .type("testString")
      .planId("testString")
      .build();

    // Construct an instance of the SourceMetaData model
    SourceMetaData sourceMetaDataModel = new SourceMetaData.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();

    // Construct an instance of the TemplateMetaData model
    TemplateMetaData templateMetaDataModel = new TemplateMetaData.Builder()
      .services(java.util.Arrays.asList("testString"))
      .defaultMemory(Long.valueOf("26"))
      .startCmd("testString")
      .source(sourceMetaDataModel)
      .runtimeCatalogId("testString")
      .cfRuntimeId("testString")
      .templateId("testString")
      .executableFile("testString")
      .buildpack("testString")
      .environmentVariables(java.util.Collections.singletonMap("key1", "testString"))
      .build();

    // Construct an instance of the Bullets model
    Bullets bulletsModel = new Bullets.Builder()
      .title("testString")
      .description("testString")
      .icon("testString")
      .quantity(Long.valueOf("26"))
      .build();

    // Construct an instance of the UIMediaSourceMetaData model
    UIMediaSourceMetaData uiMediaSourceMetaDataModel = new UIMediaSourceMetaData.Builder()
      .type("testString")
      .url("testString")
      .build();

    // Construct an instance of the UIMetaMedia model
    UIMetaMedia uiMetaMediaModel = new UIMetaMedia.Builder()
      .caption("testString")
      .thumbnailUrl("testString")
      .type("testString")
      .url("testString")
      .source(java.util.Arrays.asList(uiMediaSourceMetaDataModel))
      .build();

    // Construct an instance of the Strings model
    Strings stringsModel = new Strings.Builder()
      .bullets(java.util.Arrays.asList(bulletsModel))
      .media(java.util.Arrays.asList(uiMetaMediaModel))
      .notCreatableMsg("testString")
      .notCreatableRobotMsg("testString")
      .deprecationWarning("testString")
      .popupWarningMessage("testString")
      .instruction("testString")
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
      .dashboardUrl("testString")
      .registrationUrl("testString")
      .apidocsurl("testString")
      .build();

    // Construct an instance of the UIMetaData model
    UIMetaData uiMetaDataModel = new UIMetaData.Builder()
      .strings(java.util.Collections.singletonMap("key1", stringsModel))
      .urls(urlsModel)
      .embeddableDashboard("testString")
      .embeddableDashboardFullWidth(true)
      .navigationOrder(java.util.Arrays.asList("testString"))
      .notCreatable(true)
      .primaryOfferingId("testString")
      .accessibleDuringProvision(true)
      .sideBySideIndex(Long.valueOf("26"))
      .endOfServiceTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .hidden(true)
      .hideLiteMetering(true)
      .noUpgradeNextStep(true)
      .build();

    // Construct an instance of the DRMetaData model
    DRMetaData drMetaDataModel = new DRMetaData.Builder()
      .dr(true)
      .description("testString")
      .build();

    // Construct an instance of the SLAMetaData model
    SLAMetaData slaMetaDataModel = new SLAMetaData.Builder()
      .terms("testString")
      .tenancy("testString")
      .provisioning(Double.valueOf("72.5"))
      .responsiveness(Double.valueOf("72.5"))
      .dr(drMetaDataModel)
      .build();

    // Construct an instance of the Callbacks model
    Callbacks callbacksModel = new Callbacks.Builder()
      .controllerUrl("testString")
      .brokerUrl("testString")
      .brokerProxyUrl("testString")
      .dashboardUrl("testString")
      .dashboardDataUrl("testString")
      .dashboardDetailTabUrl("testString")
      .dashboardDetailTabExtUrl("testString")
      .serviceMonitorApi("testString")
      .serviceMonitorApp("testString")
      .apiEndpoint(java.util.Collections.singletonMap("key1", "testString"))
      .build();

    // Construct an instance of the Price model
    Price priceModel = new Price.Builder()
      .quantityTier(Long.valueOf("26"))
      .price(Double.valueOf("72.5"))
      .build();

    // Construct an instance of the Amount model
    Amount amountModel = new Amount.Builder()
      .country("testString")
      .currency("testString")
      .prices(java.util.Arrays.asList(priceModel))
      .build();

    // Construct an instance of the StartingPrice model
    StartingPrice startingPriceModel = new StartingPrice.Builder()
      .planId("testString")
      .deploymentId("testString")
      .unit("testString")
      .amount(java.util.Arrays.asList(amountModel))
      .build();

    // Construct an instance of the PricingSet model
    PricingSet pricingSetModel = new PricingSet.Builder()
      .type("testString")
      .origin("testString")
      .startingPrice(startingPriceModel)
      .build();

    // Construct an instance of the Broker model
    Broker brokerModel = new Broker.Builder()
      .name("testString")
      .guid("testString")
      .build();

    // Construct an instance of the DeploymentBase model
    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
      .location("testString")
      .locationUrl("testString")
      .originalLocation("testString")
      .targetCrn("testString")
      .serviceCrn("testString")
      .mccpId("testString")
      .broker(brokerModel)
      .supportsRcMigration(true)
      .targetNetwork("testString")
      .build();

    // Construct an instance of the ObjectMetadataSet model
    ObjectMetadataSet objectMetadataSetModel = new ObjectMetadataSet.Builder()
      .rcCompatible(true)
      .service(cfMetaDataModel)
      .plan(planMetaDataModel)
      .alias(aliasMetaDataModel)
      .template(templateMetaDataModel)
      .ui(uiMetaDataModel)
      .compliance(java.util.Arrays.asList("testString"))
      .sla(slaMetaDataModel)
      .callbacks(callbacksModel)
      .originalName("testString")
      .version("testString")
      .other(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .pricing(pricingSetModel)
      .deployment(deploymentBaseModel)
      .build();

    // Construct an instance of the CreateCatalogEntryOptions model
    CreateCatalogEntryOptions createCatalogEntryOptionsModel = new CreateCatalogEntryOptions.Builder()
      .name("testString")
      .kind("service")
      .overviewUi(java.util.Collections.singletonMap("key1", overviewModel))
      .images(imageModel)
      .disabled(true)
      .tags(java.util.Arrays.asList("testString"))
      .provider(providerModel)
      .id("testString")
      .parentId("testString")
      .group(true)
      .active(true)
      .url("testString")
      .metadata(objectMetadataSetModel)
      .account("testString")
      .build();

    // Invoke createCatalogEntry() with a valid options model and verify the result
    Response<CatalogEntry> response = globalCatalogService.createCatalogEntry(createCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    CatalogEntry responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "POST");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, createCatalogEntryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the createCatalogEntry operation with and without retries enabled
  @Test
  public void testCreateCatalogEntryWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testCreateCatalogEntryWOptions();

    globalCatalogService.disableRetries();
    testCreateCatalogEntryWOptions();
  }

  // Test the createCatalogEntry operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCatalogEntryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.createCatalogEntry(null).execute();
  }

  // Test the getCatalogEntry operation with a valid options model parameter
  @Test
  public void testGetCatalogEntryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {\"mapKey\": {\"display_name\": \"displayName\", \"long_description\": \"longDescription\", \"description\": \"description\", \"featured_description\": \"featuredDescription\"}}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"url\": \"url\", \"metadata\": {\"rc_compatible\": true, \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"bindable\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false, \"cf_guid\": {\"mapKey\": \"inner\"}, \"crn_mask\": \"crnMask\", \"paid_only\": true, \"custom_create_page_hybrid_enabled\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"provision_type\": \"provisionType\", \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": {\"mapKey\": \"inner\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"mapKey\": \"inner\"}}, \"ui\": {\"strings\": {\"mapKey\": {\"bullets\": [{\"title\": \"title\", \"description\": \"description\", \"icon\": \"icon\", \"quantity\": 8}], \"media\": [{\"caption\": \"caption\", \"thumbnail_url\": \"thumbnailUrl\", \"type\": \"type\", \"URL\": \"url\", \"source\": [{\"type\": \"type\", \"url\": \"url\"}]}], \"not_creatable_msg\": \"notCreatableMsg\", \"not_creatable__robot_msg\": \"notCreatableRobotMsg\", \"deprecation_warning\": \"deprecationWarning\", \"popup_warning_message\": \"popupWarningMessage\", \"instruction\": \"instruction\"}}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\", \"dashboard_url\": \"dashboardUrl\", \"registration_url\": \"registrationUrl\", \"apidocsurl\": \"apidocsurl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00.000Z\", \"hidden\": true, \"hide_lite_metering\": true, \"no_upgrade_next_step\": false}, \"compliance\": [\"compliance\"], \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": 12, \"responsiveness\": 14, \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"controller_url\": \"controllerUrl\", \"broker_url\": \"brokerUrl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"api_endpoint\": {\"mapKey\": \"inner\"}}, \"original_name\": \"originalName\", \"version\": \"version\", \"other\": {\"anyKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}, \"deployment\": {\"location\": \"location\", \"location_url\": \"locationUrl\", \"original_location\": \"originalLocation\", \"target_crn\": \"targetCrn\", \"service_crn\": \"serviceCrn\", \"mccp_id\": \"mccpId\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"catalogCrn\", \"children_url\": \"childrenUrl\", \"geo_tags\": [\"geoTags\"], \"pricing_tags\": [\"pricingTags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String getCatalogEntryPath = "/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetCatalogEntryOptions model
    GetCatalogEntryOptions getCatalogEntryOptionsModel = new GetCatalogEntryOptions.Builder()
      .id("testString")
      .account("testString")
      .include("testString")
      .languages("testString")
      .complete(true)
      .depth(Long.valueOf("26"))
      .build();

    // Invoke getCatalogEntry() with a valid options model and verify the result
    Response<CatalogEntry> response = globalCatalogService.getCatalogEntry(getCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    CatalogEntry responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getCatalogEntryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("include"), "testString");
    assertEquals(query.get("languages"), "testString");
    assertEquals(Boolean.valueOf(query.get("complete")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("depth")), Long.valueOf("26"));
  }

  // Test the getCatalogEntry operation with and without retries enabled
  @Test
  public void testGetCatalogEntryWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetCatalogEntryWOptions();

    globalCatalogService.disableRetries();
    testGetCatalogEntryWOptions();
  }

  // Test the getCatalogEntry operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCatalogEntryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getCatalogEntry(null).execute();
  }

  // Test the updateCatalogEntry operation with a valid options model parameter
  @Test
  public void testUpdateCatalogEntryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {\"mapKey\": {\"display_name\": \"displayName\", \"long_description\": \"longDescription\", \"description\": \"description\", \"featured_description\": \"featuredDescription\"}}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"url\": \"url\", \"metadata\": {\"rc_compatible\": true, \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"bindable\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false, \"cf_guid\": {\"mapKey\": \"inner\"}, \"crn_mask\": \"crnMask\", \"paid_only\": true, \"custom_create_page_hybrid_enabled\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"provision_type\": \"provisionType\", \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": {\"mapKey\": \"inner\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"mapKey\": \"inner\"}}, \"ui\": {\"strings\": {\"mapKey\": {\"bullets\": [{\"title\": \"title\", \"description\": \"description\", \"icon\": \"icon\", \"quantity\": 8}], \"media\": [{\"caption\": \"caption\", \"thumbnail_url\": \"thumbnailUrl\", \"type\": \"type\", \"URL\": \"url\", \"source\": [{\"type\": \"type\", \"url\": \"url\"}]}], \"not_creatable_msg\": \"notCreatableMsg\", \"not_creatable__robot_msg\": \"notCreatableRobotMsg\", \"deprecation_warning\": \"deprecationWarning\", \"popup_warning_message\": \"popupWarningMessage\", \"instruction\": \"instruction\"}}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\", \"dashboard_url\": \"dashboardUrl\", \"registration_url\": \"registrationUrl\", \"apidocsurl\": \"apidocsurl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00.000Z\", \"hidden\": true, \"hide_lite_metering\": true, \"no_upgrade_next_step\": false}, \"compliance\": [\"compliance\"], \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": 12, \"responsiveness\": 14, \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"controller_url\": \"controllerUrl\", \"broker_url\": \"brokerUrl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"api_endpoint\": {\"mapKey\": \"inner\"}}, \"original_name\": \"originalName\", \"version\": \"version\", \"other\": {\"anyKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}, \"deployment\": {\"location\": \"location\", \"location_url\": \"locationUrl\", \"original_location\": \"originalLocation\", \"target_crn\": \"targetCrn\", \"service_crn\": \"serviceCrn\", \"mccp_id\": \"mccpId\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"catalogCrn\", \"children_url\": \"childrenUrl\", \"geo_tags\": [\"geoTags\"], \"pricing_tags\": [\"pricingTags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}";
    String updateCatalogEntryPath = "/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the Overview model
    Overview overviewModel = new Overview.Builder()
      .displayName("testString")
      .longDescription("testString")
      .description("testString")
      .featuredDescription("testString")
      .build();

    // Construct an instance of the Image model
    Image imageModel = new Image.Builder()
      .image("testString")
      .smallImage("testString")
      .mediumImage("testString")
      .featureImage("testString")
      .build();

    // Construct an instance of the Provider model
    Provider providerModel = new Provider.Builder()
      .email("testString")
      .name("testString")
      .contact("testString")
      .supportEmail("testString")
      .phone("testString")
      .build();

    // Construct an instance of the CFMetaData model
    CFMetaData cfMetaDataModel = new CFMetaData.Builder()
      .type("testString")
      .iamCompatible(true)
      .uniqueApiKey(true)
      .provisionable(true)
      .bindable(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .requires(java.util.Arrays.asList("testString"))
      .planUpdateable(true)
      .state("testString")
      .serviceCheckEnabled(true)
      .testCheckInterval(Long.valueOf("26"))
      .serviceKeySupported(true)
      .cfGuid(java.util.Collections.singletonMap("key1", "testString"))
      .crnMask("testString")
      .paidOnly(true)
      .customCreatePageHybridEnabled(true)
      .build();

    // Construct an instance of the PlanMetaData model
    PlanMetaData planMetaDataModel = new PlanMetaData.Builder()
      .bindable(true)
      .reservable(true)
      .allowInternalUsers(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .provisionType("testString")
      .testCheckInterval(Long.valueOf("26"))
      .singleScopeInstance("testString")
      .serviceCheckEnabled(true)
      .cfGuid(java.util.Collections.singletonMap("key1", "testString"))
      .build();

    // Construct an instance of the AliasMetaData model
    AliasMetaData aliasMetaDataModel = new AliasMetaData.Builder()
      .type("testString")
      .planId("testString")
      .build();

    // Construct an instance of the SourceMetaData model
    SourceMetaData sourceMetaDataModel = new SourceMetaData.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();

    // Construct an instance of the TemplateMetaData model
    TemplateMetaData templateMetaDataModel = new TemplateMetaData.Builder()
      .services(java.util.Arrays.asList("testString"))
      .defaultMemory(Long.valueOf("26"))
      .startCmd("testString")
      .source(sourceMetaDataModel)
      .runtimeCatalogId("testString")
      .cfRuntimeId("testString")
      .templateId("testString")
      .executableFile("testString")
      .buildpack("testString")
      .environmentVariables(java.util.Collections.singletonMap("key1", "testString"))
      .build();

    // Construct an instance of the Bullets model
    Bullets bulletsModel = new Bullets.Builder()
      .title("testString")
      .description("testString")
      .icon("testString")
      .quantity(Long.valueOf("26"))
      .build();

    // Construct an instance of the UIMediaSourceMetaData model
    UIMediaSourceMetaData uiMediaSourceMetaDataModel = new UIMediaSourceMetaData.Builder()
      .type("testString")
      .url("testString")
      .build();

    // Construct an instance of the UIMetaMedia model
    UIMetaMedia uiMetaMediaModel = new UIMetaMedia.Builder()
      .caption("testString")
      .thumbnailUrl("testString")
      .type("testString")
      .url("testString")
      .source(java.util.Arrays.asList(uiMediaSourceMetaDataModel))
      .build();

    // Construct an instance of the Strings model
    Strings stringsModel = new Strings.Builder()
      .bullets(java.util.Arrays.asList(bulletsModel))
      .media(java.util.Arrays.asList(uiMetaMediaModel))
      .notCreatableMsg("testString")
      .notCreatableRobotMsg("testString")
      .deprecationWarning("testString")
      .popupWarningMessage("testString")
      .instruction("testString")
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
      .dashboardUrl("testString")
      .registrationUrl("testString")
      .apidocsurl("testString")
      .build();

    // Construct an instance of the UIMetaData model
    UIMetaData uiMetaDataModel = new UIMetaData.Builder()
      .strings(java.util.Collections.singletonMap("key1", stringsModel))
      .urls(urlsModel)
      .embeddableDashboard("testString")
      .embeddableDashboardFullWidth(true)
      .navigationOrder(java.util.Arrays.asList("testString"))
      .notCreatable(true)
      .primaryOfferingId("testString")
      .accessibleDuringProvision(true)
      .sideBySideIndex(Long.valueOf("26"))
      .endOfServiceTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .hidden(true)
      .hideLiteMetering(true)
      .noUpgradeNextStep(true)
      .build();

    // Construct an instance of the DRMetaData model
    DRMetaData drMetaDataModel = new DRMetaData.Builder()
      .dr(true)
      .description("testString")
      .build();

    // Construct an instance of the SLAMetaData model
    SLAMetaData slaMetaDataModel = new SLAMetaData.Builder()
      .terms("testString")
      .tenancy("testString")
      .provisioning(Double.valueOf("72.5"))
      .responsiveness(Double.valueOf("72.5"))
      .dr(drMetaDataModel)
      .build();

    // Construct an instance of the Callbacks model
    Callbacks callbacksModel = new Callbacks.Builder()
      .controllerUrl("testString")
      .brokerUrl("testString")
      .brokerProxyUrl("testString")
      .dashboardUrl("testString")
      .dashboardDataUrl("testString")
      .dashboardDetailTabUrl("testString")
      .dashboardDetailTabExtUrl("testString")
      .serviceMonitorApi("testString")
      .serviceMonitorApp("testString")
      .apiEndpoint(java.util.Collections.singletonMap("key1", "testString"))
      .build();

    // Construct an instance of the Price model
    Price priceModel = new Price.Builder()
      .quantityTier(Long.valueOf("26"))
      .price(Double.valueOf("72.5"))
      .build();

    // Construct an instance of the Amount model
    Amount amountModel = new Amount.Builder()
      .country("testString")
      .currency("testString")
      .prices(java.util.Arrays.asList(priceModel))
      .build();

    // Construct an instance of the StartingPrice model
    StartingPrice startingPriceModel = new StartingPrice.Builder()
      .planId("testString")
      .deploymentId("testString")
      .unit("testString")
      .amount(java.util.Arrays.asList(amountModel))
      .build();

    // Construct an instance of the PricingSet model
    PricingSet pricingSetModel = new PricingSet.Builder()
      .type("testString")
      .origin("testString")
      .startingPrice(startingPriceModel)
      .build();

    // Construct an instance of the Broker model
    Broker brokerModel = new Broker.Builder()
      .name("testString")
      .guid("testString")
      .build();

    // Construct an instance of the DeploymentBase model
    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
      .location("testString")
      .locationUrl("testString")
      .originalLocation("testString")
      .targetCrn("testString")
      .serviceCrn("testString")
      .mccpId("testString")
      .broker(brokerModel)
      .supportsRcMigration(true)
      .targetNetwork("testString")
      .build();

    // Construct an instance of the ObjectMetadataSet model
    ObjectMetadataSet objectMetadataSetModel = new ObjectMetadataSet.Builder()
      .rcCompatible(true)
      .service(cfMetaDataModel)
      .plan(planMetaDataModel)
      .alias(aliasMetaDataModel)
      .template(templateMetaDataModel)
      .ui(uiMetaDataModel)
      .compliance(java.util.Arrays.asList("testString"))
      .sla(slaMetaDataModel)
      .callbacks(callbacksModel)
      .originalName("testString")
      .version("testString")
      .other(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .pricing(pricingSetModel)
      .deployment(deploymentBaseModel)
      .build();

    // Construct an instance of the UpdateCatalogEntryOptions model
    UpdateCatalogEntryOptions updateCatalogEntryOptionsModel = new UpdateCatalogEntryOptions.Builder()
      .id("testString")
      .name("testString")
      .kind("service")
      .overviewUi(java.util.Collections.singletonMap("key1", overviewModel))
      .images(imageModel)
      .disabled(true)
      .tags(java.util.Arrays.asList("testString"))
      .provider(providerModel)
      .parentId("testString")
      .group(true)
      .active(true)
      .url("testString")
      .metadata(objectMetadataSetModel)
      .account("testString")
      .move("testString")
      .build();

    // Invoke updateCatalogEntry() with a valid options model and verify the result
    Response<CatalogEntry> response = globalCatalogService.updateCatalogEntry(updateCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    CatalogEntry responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateCatalogEntryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("move"), "testString");
  }

  // Test the updateCatalogEntry operation with and without retries enabled
  @Test
  public void testUpdateCatalogEntryWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testUpdateCatalogEntryWOptions();

    globalCatalogService.disableRetries();
    testUpdateCatalogEntryWOptions();
  }

  // Test the updateCatalogEntry operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCatalogEntryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.updateCatalogEntry(null).execute();
  }

  // Test the deleteCatalogEntry operation with a valid options model parameter
  @Test
  public void testDeleteCatalogEntryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteCatalogEntryPath = "/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteCatalogEntryOptions model
    DeleteCatalogEntryOptions deleteCatalogEntryOptionsModel = new DeleteCatalogEntryOptions.Builder()
      .id("testString")
      .account("testString")
      .force(true)
      .build();

    // Invoke deleteCatalogEntry() with a valid options model and verify the result
    Response<Void> response = globalCatalogService.deleteCatalogEntry(deleteCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteCatalogEntryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(Boolean.valueOf(query.get("force")), Boolean.valueOf(true));
  }

  // Test the deleteCatalogEntry operation with and without retries enabled
  @Test
  public void testDeleteCatalogEntryWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testDeleteCatalogEntryWOptions();

    globalCatalogService.disableRetries();
    testDeleteCatalogEntryWOptions();
  }

  // Test the deleteCatalogEntry operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCatalogEntryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.deleteCatalogEntry(null).execute();
  }

  // Test the getChildObjects operation with a valid options model parameter
  @Test
  public void testGetChildObjectsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"count\": 5, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"name\": \"name\", \"kind\": \"service\", \"overview_ui\": {\"mapKey\": {\"display_name\": \"displayName\", \"long_description\": \"longDescription\", \"description\": \"description\", \"featured_description\": \"featuredDescription\"}}, \"images\": {\"image\": \"image\", \"small_image\": \"smallImage\", \"medium_image\": \"mediumImage\", \"feature_image\": \"featureImage\"}, \"parent_id\": \"parentId\", \"disabled\": true, \"tags\": [\"tags\"], \"group\": false, \"provider\": {\"email\": \"email\", \"name\": \"name\", \"contact\": \"contact\", \"support_email\": \"supportEmail\", \"phone\": \"phone\"}, \"active\": true, \"url\": \"url\", \"metadata\": {\"rc_compatible\": true, \"service\": {\"type\": \"type\", \"iam_compatible\": false, \"unique_api_key\": true, \"provisionable\": false, \"bindable\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"requires\": [\"requires\"], \"plan_updateable\": true, \"state\": \"state\", \"service_check_enabled\": false, \"test_check_interval\": 17, \"service_key_supported\": false, \"cf_guid\": {\"mapKey\": \"inner\"}, \"crn_mask\": \"crnMask\", \"paid_only\": true, \"custom_create_page_hybrid_enabled\": false}, \"plan\": {\"bindable\": true, \"reservable\": true, \"allow_internal_users\": true, \"async_provisioning_supported\": true, \"async_unprovisioning_supported\": true, \"provision_type\": \"provisionType\", \"test_check_interval\": 17, \"single_scope_instance\": \"singleScopeInstance\", \"service_check_enabled\": false, \"cf_guid\": {\"mapKey\": \"inner\"}}, \"alias\": {\"type\": \"type\", \"plan_id\": \"planId\"}, \"template\": {\"services\": [\"services\"], \"default_memory\": 13, \"start_cmd\": \"startCmd\", \"source\": {\"path\": \"path\", \"type\": \"type\", \"url\": \"url\"}, \"runtime_catalog_id\": \"runtimeCatalogId\", \"cf_runtime_id\": \"cfRuntimeId\", \"template_id\": \"templateId\", \"executable_file\": \"executableFile\", \"buildpack\": \"buildpack\", \"environment_variables\": {\"mapKey\": \"inner\"}}, \"ui\": {\"strings\": {\"mapKey\": {\"bullets\": [{\"title\": \"title\", \"description\": \"description\", \"icon\": \"icon\", \"quantity\": 8}], \"media\": [{\"caption\": \"caption\", \"thumbnail_url\": \"thumbnailUrl\", \"type\": \"type\", \"URL\": \"url\", \"source\": [{\"type\": \"type\", \"url\": \"url\"}]}], \"not_creatable_msg\": \"notCreatableMsg\", \"not_creatable__robot_msg\": \"notCreatableRobotMsg\", \"deprecation_warning\": \"deprecationWarning\", \"popup_warning_message\": \"popupWarningMessage\", \"instruction\": \"instruction\"}}, \"urls\": {\"doc_url\": \"docUrl\", \"instructions_url\": \"instructionsUrl\", \"api_url\": \"apiUrl\", \"create_url\": \"createUrl\", \"sdk_download_url\": \"sdkDownloadUrl\", \"terms_url\": \"termsUrl\", \"custom_create_page_url\": \"customCreatePageUrl\", \"catalog_details_url\": \"catalogDetailsUrl\", \"deprecation_doc_url\": \"deprecationDocUrl\", \"dashboard_url\": \"dashboardUrl\", \"registration_url\": \"registrationUrl\", \"apidocsurl\": \"apidocsurl\"}, \"embeddable_dashboard\": \"embeddableDashboard\", \"embeddable_dashboard_full_width\": true, \"navigation_order\": [\"navigationOrder\"], \"not_creatable\": true, \"primary_offering_id\": \"primaryOfferingId\", \"accessible_during_provision\": false, \"side_by_side_index\": 15, \"end_of_service_time\": \"2019-01-01T12:00:00.000Z\", \"hidden\": true, \"hide_lite_metering\": true, \"no_upgrade_next_step\": false}, \"compliance\": [\"compliance\"], \"sla\": {\"terms\": \"terms\", \"tenancy\": \"tenancy\", \"provisioning\": 12, \"responsiveness\": 14, \"dr\": {\"dr\": true, \"description\": \"description\"}}, \"callbacks\": {\"controller_url\": \"controllerUrl\", \"broker_url\": \"brokerUrl\", \"broker_proxy_url\": \"brokerProxyUrl\", \"dashboard_url\": \"dashboardUrl\", \"dashboard_data_url\": \"dashboardDataUrl\", \"dashboard_detail_tab_url\": \"dashboardDetailTabUrl\", \"dashboard_detail_tab_ext_url\": \"dashboardDetailTabExtUrl\", \"service_monitor_api\": \"serviceMonitorApi\", \"service_monitor_app\": \"serviceMonitorApp\", \"api_endpoint\": {\"mapKey\": \"inner\"}}, \"original_name\": \"originalName\", \"version\": \"version\", \"other\": {\"anyKey\": \"anyValue\"}, \"pricing\": {\"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}, \"deployment\": {\"location\": \"location\", \"location_url\": \"locationUrl\", \"original_location\": \"originalLocation\", \"target_crn\": \"targetCrn\", \"service_crn\": \"serviceCrn\", \"mccp_id\": \"mccpId\", \"broker\": {\"name\": \"name\", \"guid\": \"guid\"}, \"supports_rc_migration\": false, \"target_network\": \"targetNetwork\"}}, \"id\": \"id\", \"catalog_crn\": \"catalogCrn\", \"children_url\": \"childrenUrl\", \"geo_tags\": [\"geoTags\"], \"pricing_tags\": [\"pricingTags\"], \"created\": \"2019-01-01T12:00:00.000Z\", \"updated\": \"2019-01-01T12:00:00.000Z\"}]}";
    String getChildObjectsPath = "/testString/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .complete(true)
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("50"))
      .build();

    // Invoke getChildObjects() with a valid options model and verify the result
    Response<EntrySearchResult> response = globalCatalogService.getChildObjects(getChildObjectsOptionsModel).execute();
    assertNotNull(response);
    EntrySearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getChildObjectsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("include"), "testString");
    assertEquals(query.get("q"), "testString");
    assertEquals(query.get("sort-by"), "testString");
    assertEquals(query.get("descending"), "testString");
    assertEquals(query.get("languages"), "testString");
    assertEquals(Boolean.valueOf(query.get("complete")), Boolean.valueOf(true));
    assertEquals(Long.valueOf(query.get("_offset")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("50"));
  }

  // Test the getChildObjects operation with and without retries enabled
  @Test
  public void testGetChildObjectsWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetChildObjectsWOptions();

    globalCatalogService.disableRetries();
    testGetChildObjectsWOptions();
  }

  // Test the getChildObjects operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetChildObjectsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getChildObjects(null).execute();
  }

  // Test the restoreCatalogEntry operation with a valid options model parameter
  @Test
  public void testRestoreCatalogEntryWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String restoreCatalogEntryPath = "/testString/restore";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the RestoreCatalogEntryOptions model
    RestoreCatalogEntryOptions restoreCatalogEntryOptionsModel = new RestoreCatalogEntryOptions.Builder()
      .id("testString")
      .account("testString")
      .build();

    // Invoke restoreCatalogEntry() with a valid options model and verify the result
    Response<Void> response = globalCatalogService.restoreCatalogEntry(restoreCatalogEntryOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, restoreCatalogEntryPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the restoreCatalogEntry operation with and without retries enabled
  @Test
  public void testRestoreCatalogEntryWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testRestoreCatalogEntryWOptions();

    globalCatalogService.disableRetries();
    testRestoreCatalogEntryWOptions();
  }

  // Test the restoreCatalogEntry operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testRestoreCatalogEntryNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.restoreCatalogEntry(null).execute();
  }

  // Test the getVisibility operation with a valid options model parameter
  @Test
  public void testGetVisibilityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"restrictions\": \"restrictions\", \"owner\": \"owner\", \"extendable\": true, \"include\": {\"accounts\": {\"_accountid_\": \"accountid\"}}, \"exclude\": {\"accounts\": {\"_accountid_\": \"accountid\"}}, \"approved\": true}";
    String getVisibilityPath = "/testString/visibility";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetVisibilityOptions model
    GetVisibilityOptions getVisibilityOptionsModel = new GetVisibilityOptions.Builder()
      .id("testString")
      .account("testString")
      .build();

    // Invoke getVisibility() with a valid options model and verify the result
    Response<Visibility> response = globalCatalogService.getVisibility(getVisibilityOptionsModel).execute();
    assertNotNull(response);
    Visibility responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getVisibilityPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the getVisibility operation with and without retries enabled
  @Test
  public void testGetVisibilityWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetVisibilityWOptions();

    globalCatalogService.disableRetries();
    testGetVisibilityWOptions();
  }

  // Test the getVisibility operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetVisibilityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getVisibility(null).execute();
  }

  // Test the updateVisibility operation with a valid options model parameter
  @Test
  public void testUpdateVisibilityWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String updateVisibilityPath = "/testString/visibility";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

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
      .restrictions("testString")
      .extendable(true)
      .include(visibilityDetailModel)
      .exclude(visibilityDetailModel)
      .account("testString")
      .build();

    // Invoke updateVisibility() with a valid options model and verify the result
    Response<Void> response = globalCatalogService.updateVisibility(updateVisibilityOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, updateVisibilityPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the updateVisibility operation with and without retries enabled
  @Test
  public void testUpdateVisibilityWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testUpdateVisibilityWOptions();

    globalCatalogService.disableRetries();
    testUpdateVisibilityWOptions();
  }

  // Test the updateVisibility operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateVisibilityNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.updateVisibility(null).execute();
  }

  // Test the getPricing operation with a valid options model parameter
  @Test
  public void testGetPricingWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}";
    String getPricingPath = "/testString/pricing";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPricingOptions model
    GetPricingOptions getPricingOptionsModel = new GetPricingOptions.Builder()
      .id("testString")
      .account("testString")
      .deploymentRegion("testString")
      .build();

    // Invoke getPricing() with a valid options model and verify the result
    Response<PricingGet> response = globalCatalogService.getPricing(getPricingOptionsModel).execute();
    assertNotNull(response);
    PricingGet responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPricingPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("deployment_region"), "testString");
  }

  // Test the getPricing operation with and without retries enabled
  @Test
  public void testGetPricingWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetPricingWOptions();

    globalCatalogService.disableRetries();
    testGetPricingWOptions();
  }

  // Test the getPricing operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPricingNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getPricing(null).execute();
  }

  // Test the getPricingDeployments operation with a valid options model parameter
  @Test
  public void testGetPricingDeploymentsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"count\": 5, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"deployment_id\": \"deploymentId\", \"deployment_location\": \"deploymentLocation\", \"deployment_region\": \"deploymentRegion\", \"deployment_location_no_price_available\": true, \"type\": \"type\", \"origin\": \"origin\", \"starting_price\": {\"plan_id\": \"planId\", \"deployment_id\": \"deploymentId\", \"unit\": \"unit\", \"amount\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}]}, \"metrics\": [{\"part_ref\": \"partRef\", \"metric_id\": \"metricId\", \"tier_model\": \"tierModel\", \"charge_unit\": \"chargeUnit\", \"charge_unit_name\": \"chargeUnitName\", \"charge_unit_quantity\": 18, \"resource_display_name\": \"resourceDisplayName\", \"charge_unit_display_name\": \"chargeUnitDisplayName\", \"usage_cap_qty\": 11, \"display_cap\": 10, \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"amounts\": [{\"country\": \"country\", \"currency\": \"currency\", \"prices\": [{\"quantity_tier\": 12, \"price\": 5}]}], \"additional_properties\": {\"anyKey\": \"anyValue\"}}], \"deployment_regions\": [\"deploymentRegions\"], \"effective_from\": \"2019-01-01T12:00:00.000Z\", \"effective_until\": \"2019-01-01T12:00:00.000Z\", \"require_login\": true, \"pricing_catalog_url\": \"pricingCatalogUrl\", \"sales_avenue\": [\"salesAvenue\"]}]}";
    String getPricingDeploymentsPath = "/testString/pricing/deployment";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetPricingDeploymentsOptions model
    GetPricingDeploymentsOptions getPricingDeploymentsOptionsModel = new GetPricingDeploymentsOptions.Builder()
      .id("testString")
      .account("testString")
      .build();

    // Invoke getPricingDeployments() with a valid options model and verify the result
    Response<PricingSearchResult> response = globalCatalogService.getPricingDeployments(getPricingDeploymentsOptionsModel).execute();
    assertNotNull(response);
    PricingSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getPricingDeploymentsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the getPricingDeployments operation with and without retries enabled
  @Test
  public void testGetPricingDeploymentsWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetPricingDeploymentsWOptions();

    globalCatalogService.disableRetries();
    testGetPricingDeploymentsWOptions();
  }

  // Test the getPricingDeployments operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPricingDeploymentsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getPricingDeployments(null).execute();
  }

  // Test the getAuditLogs operation with a valid options model parameter
  @Test
  public void testGetAuditLogsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"offset\": 6, \"limit\": 5, \"count\": 5, \"resource_count\": 13, \"first\": \"first\", \"last\": \"last\", \"prev\": \"prev\", \"next\": \"next\", \"resources\": [{\"id\": \"id\", \"effective\": {\"restrictions\": \"restrictions\", \"owner\": \"owner\", \"extendable\": true, \"include\": {\"accounts\": {\"_accountid_\": \"accountid\"}}, \"exclude\": {\"accounts\": {\"_accountid_\": \"accountid\"}}, \"approved\": true}, \"time\": \"2019-01-01T12:00:00.000Z\", \"who_id\": \"whoId\", \"who_name\": \"whoName\", \"who_email\": \"whoEmail\", \"instance\": \"instance\", \"gid\": \"gid\", \"type\": \"type\", \"message\": \"message\", \"data\": {\"anyKey\": \"anyValue\"}}]}";
    String getAuditLogsPath = "/testString/logs";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetAuditLogsOptions model
    GetAuditLogsOptions getAuditLogsOptionsModel = new GetAuditLogsOptions.Builder()
      .id("testString")
      .account("testString")
      .ascending("false")
      .startat("testString")
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("50"))
      .build();

    // Invoke getAuditLogs() with a valid options model and verify the result
    Response<AuditSearchResult> response = globalCatalogService.getAuditLogs(getAuditLogsOptionsModel).execute();
    assertNotNull(response);
    AuditSearchResult responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getAuditLogsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
    assertEquals(query.get("ascending"), "false");
    assertEquals(query.get("startat"), "testString");
    assertEquals(Long.valueOf(query.get("_offset")), Long.valueOf("0"));
    assertEquals(Long.valueOf(query.get("_limit")), Long.valueOf("50"));
  }

  // Test the getAuditLogs operation with and without retries enabled
  @Test
  public void testGetAuditLogsWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetAuditLogsWOptions();

    globalCatalogService.disableRetries();
    testGetAuditLogsWOptions();
  }

  // Test the getAuditLogs operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAuditLogsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getAuditLogs(null).execute();
  }

  // Test the listArtifacts operation with a valid options model parameter
  @Test
  public void testListArtifactsWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "{\"count\": 5, \"resources\": [{\"name\": \"name\", \"updated\": \"2019-01-01T12:00:00.000Z\", \"url\": \"url\", \"etag\": \"etag\", \"size\": 4}]}";
    String listArtifactsPath = "/testString/artifacts";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "application/json")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the ListArtifactsOptions model
    ListArtifactsOptions listArtifactsOptionsModel = new ListArtifactsOptions.Builder()
      .objectId("testString")
      .account("testString")
      .build();

    // Invoke listArtifacts() with a valid options model and verify the result
    Response<Artifacts> response = globalCatalogService.listArtifacts(listArtifactsOptionsModel).execute();
    assertNotNull(response);
    Artifacts responseObj = response.getResult();
    assertNotNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, listArtifactsPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the listArtifacts operation with and without retries enabled
  @Test
  public void testListArtifactsWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testListArtifactsWOptions();

    globalCatalogService.disableRetries();
    testListArtifactsWOptions();
  }

  // Test the listArtifacts operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListArtifactsNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.listArtifacts(null).execute();
  }

  // Test the getArtifact operation with a valid options model parameter
  @Test
  public void testGetArtifactWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "This is a mock binary response.";
    String getArtifactPath = "/testString/artifacts/testString";
    server.enqueue(new MockResponse()
      .setHeader("Content-type", "*/*")
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the GetArtifactOptions model
    GetArtifactOptions getArtifactOptionsModel = new GetArtifactOptions.Builder()
      .objectId("testString")
      .artifactId("testString")
      .accept("testString")
      .account("testString")
      .build();

    // Invoke getArtifact() with a valid options model and verify the result
    Response<InputStream> response = globalCatalogService.getArtifact(getArtifactOptionsModel).execute();
    assertNotNull(response);
    try (InputStream responseObj = response.getResult();) {
      assertNotNull(responseObj);
    }

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "GET");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, getArtifactPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the getArtifact operation with and without retries enabled
  @Test
  public void testGetArtifactWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testGetArtifactWOptions();

    globalCatalogService.disableRetries();
    testGetArtifactWOptions();
  }

  // Test the getArtifact operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetArtifactNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.getArtifact(null).execute();
  }

  // Test the uploadArtifact operation with a valid options model parameter
  @Test
  public void testUploadArtifactWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String uploadArtifactPath = "/testString/artifacts/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the UploadArtifactOptions model
    UploadArtifactOptions uploadArtifactOptionsModel = new UploadArtifactOptions.Builder()
      .objectId("testString")
      .artifactId("testString")
      .artifact(TestUtilities.createMockStream("This is a mock file."))
      .contentType("testString")
      .account("testString")
      .build();

    // Invoke uploadArtifact() with a valid options model and verify the result
    Response<Void> response = globalCatalogService.uploadArtifact(uploadArtifactOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "PUT");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, uploadArtifactPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the uploadArtifact operation with and without retries enabled
  @Test
  public void testUploadArtifactWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testUploadArtifactWOptions();

    globalCatalogService.disableRetries();
    testUploadArtifactWOptions();
  }

  // Test the uploadArtifact operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUploadArtifactNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.uploadArtifact(null).execute();
  }

  // Test the deleteArtifact operation with a valid options model parameter
  @Test
  public void testDeleteArtifactWOptions() throws Throwable {
    // Register a mock response
    String mockResponseBody = "";
    String deleteArtifactPath = "/testString/artifacts/testString";
    server.enqueue(new MockResponse()
      .setResponseCode(200)
      .setBody(mockResponseBody));

    // Construct an instance of the DeleteArtifactOptions model
    DeleteArtifactOptions deleteArtifactOptionsModel = new DeleteArtifactOptions.Builder()
      .objectId("testString")
      .artifactId("testString")
      .account("testString")
      .build();

    // Invoke deleteArtifact() with a valid options model and verify the result
    Response<Void> response = globalCatalogService.deleteArtifact(deleteArtifactOptionsModel).execute();
    assertNotNull(response);
    Void responseObj = response.getResult();
    assertNull(responseObj);

    // Verify the contents of the request sent to the mock server
    RecordedRequest request = server.takeRequest();
    assertNotNull(request);
    assertEquals(request.getMethod(), "DELETE");
    // Verify request path
    String parsedPath = TestUtilities.parseReqPath(request);
    assertEquals(parsedPath, deleteArtifactPath);
    // Verify query params
    Map<String, String> query = TestUtilities.parseQueryString(request);
    assertNotNull(query);
    assertEquals(query.get("account"), "testString");
  }

  // Test the deleteArtifact operation with and without retries enabled
  @Test
  public void testDeleteArtifactWRetries() throws Throwable {
    globalCatalogService.enableRetries(4, 30);
    testDeleteArtifactWOptions();

    globalCatalogService.disableRetries();
    testDeleteArtifactWOptions();
  }

  // Test the deleteArtifact operation with a null options model (negative test)
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteArtifactNoOptions() throws Throwable {
    server.enqueue(new MockResponse());
    globalCatalogService.deleteArtifact(null).execute();
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
    globalCatalogService = null;
  }

  // Constructs an instance of the service to be used by the tests
  public void constructClientService() {
    System.setProperty("TESTSERVICE_AUTH_TYPE", "noAuth");
    final String serviceName = "testService";

    globalCatalogService = GlobalCatalog.newInstance(serviceName);
    String url = server.url("/").toString();
    globalCatalogService.setServiceUrl(url);
  }
}