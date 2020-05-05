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

import com.ibm.cloud.platform_services.global_catalog.v1.model.AliasMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Broker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CFMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CreateCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DRMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.I18N;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Image;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.OverviewUI;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PlanMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Provider;
import com.ibm.cloud.platform_services.global_catalog.v1.model.SLAMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.SourceMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.StartingPrice;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.TemplateMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaMedia;
import com.ibm.cloud.platform_services.global_catalog.v1.model.URLS;
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
 * Unit test class for the CreateCatalogEntryOptions model.
 */
public class CreateCatalogEntryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateCatalogEntryOptions() throws Throwable {
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

    Broker brokerModel = new Broker.Builder()
      .name("testString")
      .guid("testString")
      .build();
    assertEquals(brokerModel.name(), "testString");
    assertEquals(brokerModel.guid(), "testString");

    DRMetaData drMetaDataModel = new DRMetaData.Builder()
      .dr(true)
      .description("testString")
      .build();
    assertEquals(drMetaDataModel.dr(), Boolean.valueOf(true));
    assertEquals(drMetaDataModel.description(), "testString");

    I18N i18NModel = new I18N();
    i18NModel.put("foo", stringsModel);
    assertEquals(i18NModel.get("foo"), stringsModel);

    SourceMetaData sourceMetaDataModel = new SourceMetaData.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();
    assertEquals(sourceMetaDataModel.path(), "testString");
    assertEquals(sourceMetaDataModel.type(), "testString");
    assertEquals(sourceMetaDataModel.url(), "testString");

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

    AliasMetaData aliasMetaDataModel = new AliasMetaData.Builder()
      .type("testString")
      .planId("testString")
      .build();
    assertEquals(aliasMetaDataModel.type(), "testString");
    assertEquals(aliasMetaDataModel.planId(), "testString");

    CFMetaData cfMetaDataModel = new CFMetaData.Builder()
      .type("testString")
      .iamCompatible(true)
      .uniqueApiKey(true)
      .provisionable(true)
      .bindable(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .requires(new ArrayList<String>(Arrays.asList("testString")))
      .planUpdateable(true)
      .state("testString")
      .serviceCheckEnabled(true)
      .testCheckInterval(Long.valueOf("26"))
      .serviceKeySupported(true)
      .cfGuid(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .build();
    assertEquals(cfMetaDataModel.type(), "testString");
    assertEquals(cfMetaDataModel.iamCompatible(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.provisionable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.bindable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.requires(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(cfMetaDataModel.planUpdateable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.state(), "testString");
    assertEquals(cfMetaDataModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(cfMetaDataModel.serviceKeySupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.cfGuid(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});

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
      .apiEndpoint(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .build();
    assertEquals(callbacksModel.controllerUrl(), "testString");
    assertEquals(callbacksModel.brokerUrl(), "testString");
    assertEquals(callbacksModel.brokerProxyUrl(), "testString");
    assertEquals(callbacksModel.dashboardUrl(), "testString");
    assertEquals(callbacksModel.dashboardDataUrl(), "testString");
    assertEquals(callbacksModel.dashboardDetailTabUrl(), "testString");
    assertEquals(callbacksModel.dashboardDetailTabExtUrl(), "testString");
    assertEquals(callbacksModel.serviceMonitorApi(), "testString");
    assertEquals(callbacksModel.serviceMonitorApp(), "testString");
    assertEquals(callbacksModel.apiEndpoint(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});

    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
      .location("testString")
      .targetCrn("testString")
      .broker(brokerModel)
      .supportsRcMigration(true)
      .targetNetwork("testString")
      .build();
    assertEquals(deploymentBaseModel.location(), "testString");
    assertEquals(deploymentBaseModel.targetCrn(), "testString");
    assertEquals(deploymentBaseModel.broker(), brokerModel);
    assertEquals(deploymentBaseModel.supportsRcMigration(), Boolean.valueOf(true));
    assertEquals(deploymentBaseModel.targetNetwork(), "testString");

    Overview overviewModel = new Overview.Builder()
      .displayName("testString")
      .longDescription("testString")
      .description("testString")
      .build();
    assertEquals(overviewModel.displayName(), "testString");
    assertEquals(overviewModel.longDescription(), "testString");
    assertEquals(overviewModel.description(), "testString");

    PlanMetaData planMetaDataModel = new PlanMetaData.Builder()
      .bindable(true)
      .reservable(true)
      .allowInternalUsers(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .testCheckInterval(Long.valueOf("26"))
      .singleScopeInstance("testString")
      .serviceCheckEnabled(true)
      .cfGuid(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .build();
    assertEquals(planMetaDataModel.bindable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.reservable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(planMetaDataModel.singleScopeInstance(), "testString");
    assertEquals(planMetaDataModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.cfGuid(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});

    PricingSet pricingSetModel = new PricingSet.Builder()
      .type("testString")
      .origin("testString")
      .startingPrice(startingPriceModel)
      .build();
    assertEquals(pricingSetModel.type(), "testString");
    assertEquals(pricingSetModel.origin(), "testString");
    assertEquals(pricingSetModel.startingPrice(), startingPriceModel);

    SLAMetaData slaMetaDataModel = new SLAMetaData.Builder()
      .terms("testString")
      .tenancy("testString")
      .provisioning("testString")
      .responsiveness("testString")
      .dr(drMetaDataModel)
      .build();
    assertEquals(slaMetaDataModel.terms(), "testString");
    assertEquals(slaMetaDataModel.tenancy(), "testString");
    assertEquals(slaMetaDataModel.provisioning(), "testString");
    assertEquals(slaMetaDataModel.responsiveness(), "testString");
    assertEquals(slaMetaDataModel.dr(), drMetaDataModel);

    TemplateMetaData templateMetaDataModel = new TemplateMetaData.Builder()
      .services(new ArrayList<String>(Arrays.asList("testString")))
      .defaultMemory(Long.valueOf("26"))
      .startCmd("testString")
      .source(sourceMetaDataModel)
      .runtimeCatalogId("testString")
      .cfRuntimeId("testString")
      .templateId("testString")
      .executableFile("testString")
      .buildpack("testString")
      .environmentVariables(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .build();
    assertEquals(templateMetaDataModel.services(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(templateMetaDataModel.defaultMemory(), Long.valueOf("26"));
    assertEquals(templateMetaDataModel.startCmd(), "testString");
    assertEquals(templateMetaDataModel.source(), sourceMetaDataModel);
    assertEquals(templateMetaDataModel.runtimeCatalogId(), "testString");
    assertEquals(templateMetaDataModel.cfRuntimeId(), "testString");
    assertEquals(templateMetaDataModel.templateId(), "testString");
    assertEquals(templateMetaDataModel.executableFile(), "testString");
    assertEquals(templateMetaDataModel.buildpack(), "testString");
    assertEquals(templateMetaDataModel.environmentVariables(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});

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
      .service(cfMetaDataModel)
      .plan(planMetaDataModel)
      .alias(aliasMetaDataModel)
      .template(templateMetaDataModel)
      .ui(uiMetaDataModel)
      .compliance(new ArrayList<String>(Arrays.asList("testString")))
      .sla(slaMetaDataModel)
      .callbacks(callbacksModel)
      .originalName("testString")
      .version("testString")
      .other(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
      .pricing(pricingSetModel)
      .deployment(deploymentBaseModel)
      .build();
    assertEquals(objectMetadataSetModel.rcCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataSetModel.service(), cfMetaDataModel);
    assertEquals(objectMetadataSetModel.plan(), planMetaDataModel);
    assertEquals(objectMetadataSetModel.alias(), aliasMetaDataModel);
    assertEquals(objectMetadataSetModel.template(), templateMetaDataModel);
    assertEquals(objectMetadataSetModel.ui(), uiMetaDataModel);
    assertEquals(objectMetadataSetModel.compliance(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(objectMetadataSetModel.sla(), slaMetaDataModel);
    assertEquals(objectMetadataSetModel.callbacks(), callbacksModel);
    assertEquals(objectMetadataSetModel.originalName(), "testString");
    assertEquals(objectMetadataSetModel.version(), "testString");
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
    assertEquals(createCatalogEntryOptionsModel.name(), "testString");
    assertEquals(createCatalogEntryOptionsModel.kind(), "service");
    assertEquals(createCatalogEntryOptionsModel.overviewUi(), overviewUiModel);
    assertEquals(createCatalogEntryOptionsModel.images(), imageModel);
    assertEquals(createCatalogEntryOptionsModel.disabled(), Boolean.valueOf(true));
    assertEquals(createCatalogEntryOptionsModel.tags(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(createCatalogEntryOptionsModel.provider(), providerModel);
    assertEquals(createCatalogEntryOptionsModel.id(), "testString");
    assertEquals(createCatalogEntryOptionsModel.parentId(), "testString");
    assertEquals(createCatalogEntryOptionsModel.group(), Boolean.valueOf(true));
    assertEquals(createCatalogEntryOptionsModel.active(), Boolean.valueOf(true));
    assertEquals(createCatalogEntryOptionsModel.metadata(), objectMetadataSetModel);
    assertEquals(createCatalogEntryOptionsModel.account(), "testString");
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCatalogEntryOptionsError() throws Throwable {
    new CreateCatalogEntryOptions.Builder().build();
  }

}