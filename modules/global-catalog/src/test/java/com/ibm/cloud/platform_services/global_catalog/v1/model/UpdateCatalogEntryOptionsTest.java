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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBaseBroker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.I18N;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
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
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.StartingPrice;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaMedia;
import com.ibm.cloud.platform_services.global_catalog.v1.model.URLS;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UpdateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateCatalogEntryOptions model.
 */
public class UpdateCatalogEntryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateCatalogEntryOptions() throws Throwable {
    Bullets bulletsModel = new Bullets.Builder()
      .title("testString")
      .description("testString")
      .icon("testString")
      .quantity("testString")
      .build();
    assertEquals(bulletsModel.title(), "testString");
    assertEquals(bulletsModel.description(), "testString");
    assertEquals(bulletsModel.icon(), "testString");
    assertEquals(bulletsModel.quantity(), "testString");

    Price priceModel = new Price.Builder()
      .quantityTier(Long.valueOf("26"))
      .price(Double.valueOf("72.5"))
      .build();
    assertEquals(priceModel.quantityTier(), Long.valueOf("26"));
    assertEquals(priceModel.price(), Double.valueOf("72.5"));

    UIMetaMedia uiMetaMediaModel = new UIMetaMedia.Builder()
      .caption("testString")
      .thumbnailUrl("testString")
      .type("testString")
      .url("testString")
      .source(bulletsModel)
      .build();
    assertEquals(uiMetaMediaModel.caption(), "testString");
    assertEquals(uiMetaMediaModel.thumbnailUrl(), "testString");
    assertEquals(uiMetaMediaModel.type(), "testString");
    assertEquals(uiMetaMediaModel.url(), "testString");
    assertEquals(uiMetaMediaModel.source(), bulletsModel);

    Amount amountModel = new Amount.Builder()
      .country("testString")
      .currency("testString")
      .prices(new ArrayList<Price>(Arrays.asList(priceModel)))
      .build();
    assertEquals(amountModel.country(), "testString");
    assertEquals(amountModel.currency(), "testString");
    assertEquals(amountModel.prices(), new ArrayList<Price>(Arrays.asList(priceModel)));

    Strings stringsModel = new Strings.Builder()
      .bullets(new ArrayList<Bullets>(Arrays.asList(bulletsModel)))
      .media(new ArrayList<UIMetaMedia>(Arrays.asList(uiMetaMediaModel)))
      .notCreatableMsg("testString")
      .notCreatableRobotMsg("testString")
      .deprecationWarning("testString")
      .popupWarningMessage("testString")
      .instruction("testString")
      .build();
    assertEquals(stringsModel.bullets(), new ArrayList<Bullets>(Arrays.asList(bulletsModel)));
    assertEquals(stringsModel.media(), new ArrayList<UIMetaMedia>(Arrays.asList(uiMetaMediaModel)));
    assertEquals(stringsModel.notCreatableMsg(), "testString");
    assertEquals(stringsModel.notCreatableRobotMsg(), "testString");
    assertEquals(stringsModel.deprecationWarning(), "testString");
    assertEquals(stringsModel.popupWarningMessage(), "testString");
    assertEquals(stringsModel.instruction(), "testString");

    DeploymentBaseBroker deploymentBaseBrokerModel = new DeploymentBaseBroker.Builder()
      .name("testString")
      .guid("testString")
      .build();
    assertEquals(deploymentBaseBrokerModel.name(), "testString");
    assertEquals(deploymentBaseBrokerModel.guid(), "testString");

    I18N i18NModel = new I18N();
    i18NModel.put("foo", stringsModel);
    assertEquals(i18NModel.get("foo"), stringsModel);

    ObjectMetadataBaseSlaDr objectMetadataBaseSlaDrModel = new ObjectMetadataBaseSlaDr.Builder()
      .dr(true)
      .description("testString")
      .build();
    assertEquals(objectMetadataBaseSlaDrModel.dr(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseSlaDrModel.description(), "testString");

    ObjectMetadataBaseTemplateEnvironmentVariables objectMetadataBaseTemplateEnvironmentVariablesModel = new ObjectMetadataBaseTemplateEnvironmentVariables.Builder()
      .key("testString")
      .build();
    assertEquals(objectMetadataBaseTemplateEnvironmentVariablesModel.key(), "testString");

    ObjectMetadataBaseTemplateSource objectMetadataBaseTemplateSourceModel = new ObjectMetadataBaseTemplateSource.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();
    assertEquals(objectMetadataBaseTemplateSourceModel.path(), "testString");
    assertEquals(objectMetadataBaseTemplateSourceModel.type(), "testString");
    assertEquals(objectMetadataBaseTemplateSourceModel.url(), "testString");

    StartingPrice startingPriceModel = new StartingPrice.Builder()
      .planId("testString")
      .deploymentId("testString")
      .amount(new ArrayList<Amount>(Arrays.asList(amountModel)))
      .build();
    assertEquals(startingPriceModel.planId(), "testString");
    assertEquals(startingPriceModel.deploymentId(), "testString");
    assertEquals(startingPriceModel.amount(), new ArrayList<Amount>(Arrays.asList(amountModel)));

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
    assertEquals(urlsModel.docUrl(), "testString");
    assertEquals(urlsModel.instructionsUrl(), "testString");
    assertEquals(urlsModel.apiUrl(), "testString");
    assertEquals(urlsModel.createUrl(), "testString");
    assertEquals(urlsModel.sdkDownloadUrl(), "testString");
    assertEquals(urlsModel.termsUrl(), "testString");
    assertEquals(urlsModel.customCreatePageUrl(), "testString");
    assertEquals(urlsModel.catalogDetailsUrl(), "testString");
    assertEquals(urlsModel.deprecationDocUrl(), "testString");

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
    assertEquals(callbacksModel.brokerUtl(), "testString");
    assertEquals(callbacksModel.brokerProxyUrl(), "testString");
    assertEquals(callbacksModel.dashboardUrl(), "testString");
    assertEquals(callbacksModel.dashboardDataUrl(), "testString");
    assertEquals(callbacksModel.dashboardDetailTabUrl(), "testString");
    assertEquals(callbacksModel.dashboardDetailTabExtUrl(), "testString");
    assertEquals(callbacksModel.serviceMonitorApi(), "testString");
    assertEquals(callbacksModel.serviceMonitorApp(), "testString");
    assertEquals(callbacksModel.serviceStagingUrl(), "testString");
    assertEquals(callbacksModel.serviceProductionUrl(), "testString");

    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
      .location("testString")
      .targetCrn("testString")
      .broker(deploymentBaseBrokerModel)
      .supportsRcMigration(true)
      .targetNetwork("testString")
      .build();
    assertEquals(deploymentBaseModel.location(), "testString");
    assertEquals(deploymentBaseModel.targetCrn(), "testString");
    assertEquals(deploymentBaseModel.broker(), deploymentBaseBrokerModel);
    assertEquals(deploymentBaseModel.supportsRcMigration(), Boolean.valueOf(true));
    assertEquals(deploymentBaseModel.targetNetwork(), "testString");

    ObjectMetadataBaseAlias objectMetadataBaseAliasModel = new ObjectMetadataBaseAlias.Builder()
      .type("testString")
      .planId("testString")
      .build();
    assertEquals(objectMetadataBaseAliasModel.type(), "testString");
    assertEquals(objectMetadataBaseAliasModel.planId(), "testString");

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
    assertEquals(objectMetadataBasePlanModel.bindable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.reservable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(objectMetadataBasePlanModel.singleScopeInstance(), "testString");
    assertEquals(objectMetadataBasePlanModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.cfGuid(), "testString");

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
    assertEquals(objectMetadataBaseServiceModel.type(), "testString");
    assertEquals(objectMetadataBaseServiceModel.iamCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.provisionable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.cfGuid(), "testString");
    assertEquals(objectMetadataBaseServiceModel.bindable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.requires(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(objectMetadataBaseServiceModel.planUpdateable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.state(), "testString");
    assertEquals(objectMetadataBaseServiceModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(objectMetadataBaseServiceModel.serviceKeySupported(), Boolean.valueOf(true));

    ObjectMetadataBaseSla objectMetadataBaseSlaModel = new ObjectMetadataBaseSla.Builder()
      .terms("testString")
      .tenancy("testString")
      .provisioning("testString")
      .responsiveness("testString")
      .dr(objectMetadataBaseSlaDrModel)
      .build();
    assertEquals(objectMetadataBaseSlaModel.terms(), "testString");
    assertEquals(objectMetadataBaseSlaModel.tenancy(), "testString");
    assertEquals(objectMetadataBaseSlaModel.provisioning(), "testString");
    assertEquals(objectMetadataBaseSlaModel.responsiveness(), "testString");
    assertEquals(objectMetadataBaseSlaModel.dr(), objectMetadataBaseSlaDrModel);

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
    assertEquals(objectMetadataBaseTemplateModel.services(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(objectMetadataBaseTemplateModel.defaultMemory(), Long.valueOf("26"));
    assertEquals(objectMetadataBaseTemplateModel.startCmd(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.source(), objectMetadataBaseTemplateSourceModel);
    assertEquals(objectMetadataBaseTemplateModel.runtimeCatalogId(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.cfRuntimeId(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.templateId(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.executableFile(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.buildpack(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.environmentVariables(), objectMetadataBaseTemplateEnvironmentVariablesModel);

    Overview overviewModel = new Overview.Builder()
      .displayName("testString")
      .longDescription("testString")
      .description("testString")
      .build();
    assertEquals(overviewModel.displayName(), "testString");
    assertEquals(overviewModel.longDescription(), "testString");
    assertEquals(overviewModel.description(), "testString");

    PricingSet pricingSetModel = new PricingSet.Builder()
      .type("testString")
      .origin("testString")
      .startingPrice(startingPriceModel)
      .build();
    assertEquals(pricingSetModel.type(), "testString");
    assertEquals(pricingSetModel.origin(), "testString");
    assertEquals(pricingSetModel.startingPrice(), startingPriceModel);

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
    assertEquals(uiMetaDataModel.strings(), i18NModel);
    assertEquals(uiMetaDataModel.urls(), urlsModel);
    assertEquals(uiMetaDataModel.embeddableDashboard(), "testString");
    assertEquals(uiMetaDataModel.embeddableDashboardFullWidth(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.navigationOrder(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(uiMetaDataModel.notCreatable(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.reservable(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.primaryOfferingId(), "testString");
    assertEquals(uiMetaDataModel.accessibleDuringProvision(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.sideBySideIndex(), Long.valueOf("26"));
    assertEquals(uiMetaDataModel.endOfServiceTime(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));

    Image imageModel = new Image.Builder()
      .image("testString")
      .smallImage("testString")
      .mediumImage("testString")
      .featureImage("testString")
      .build();
    assertEquals(imageModel.image(), "testString");
    assertEquals(imageModel.smallImage(), "testString");
    assertEquals(imageModel.mediumImage(), "testString");
    assertEquals(imageModel.featureImage(), "testString");

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
    assertEquals(objectMetadataSetModel.rcCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataSetModel.ui(), uiMetaDataModel);
    assertEquals(objectMetadataSetModel.compliance(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(objectMetadataSetModel.service(), objectMetadataBaseServiceModel);
    assertEquals(objectMetadataSetModel.plan(), objectMetadataBasePlanModel);
    assertEquals(objectMetadataSetModel.template(), objectMetadataBaseTemplateModel);
    assertEquals(objectMetadataSetModel.alias(), objectMetadataBaseAliasModel);
    assertEquals(objectMetadataSetModel.sla(), objectMetadataBaseSlaModel);
    assertEquals(objectMetadataSetModel.callbacks(), callbacksModel);
    assertEquals(objectMetadataSetModel.version(), "testString");
    assertEquals(objectMetadataSetModel.originalName(), "testString");
    assertEquals(objectMetadataSetModel.other(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
    assertEquals(objectMetadataSetModel.pricing(), pricingSetModel);
    assertEquals(objectMetadataSetModel.deployment(), deploymentBaseModel);

    OverviewUI overviewUiModel = new OverviewUI();
    overviewUiModel.put("foo", overviewModel);
    assertEquals(overviewUiModel.get("foo"), overviewModel);

    Provider providerModel = new Provider.Builder()
      .email("testString")
      .name("testString")
      .contact("testString")
      .supportEmail("testString")
      .phone("testString")
      .build();
    assertEquals(providerModel.email(), "testString");
    assertEquals(providerModel.name(), "testString");
    assertEquals(providerModel.contact(), "testString");
    assertEquals(providerModel.supportEmail(), "testString");
    assertEquals(providerModel.phone(), "testString");

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
    assertEquals(updateCatalogEntryOptionsModel.id(), "testString");
    assertEquals(updateCatalogEntryOptionsModel.name(), "testString");
    assertEquals(updateCatalogEntryOptionsModel.kind(), "service");
    assertEquals(updateCatalogEntryOptionsModel.overviewUi(), overviewUiModel);
    assertEquals(updateCatalogEntryOptionsModel.images(), imageModel);
    assertEquals(updateCatalogEntryOptionsModel.disabled(), Boolean.valueOf(true));
    assertEquals(updateCatalogEntryOptionsModel.tags(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(updateCatalogEntryOptionsModel.provider(), providerModel);
    assertEquals(updateCatalogEntryOptionsModel.parentId(), "testString");
    assertEquals(updateCatalogEntryOptionsModel.group(), Boolean.valueOf(true));
    assertEquals(updateCatalogEntryOptionsModel.active(), Boolean.valueOf(true));
    assertEquals(updateCatalogEntryOptionsModel.metadata(), objectMetadataSetModel);
    assertEquals(updateCatalogEntryOptionsModel.account(), "testString");
    assertEquals(updateCatalogEntryOptionsModel.move(), "testString");
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCatalogEntryOptionsError() throws Throwable {
    new UpdateCatalogEntryOptions.Builder().build();
  }

}