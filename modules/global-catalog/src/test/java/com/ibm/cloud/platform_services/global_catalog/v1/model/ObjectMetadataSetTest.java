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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.AliasMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Amount;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Broker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.CFMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Callbacks;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DRMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataSet;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PlanMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Price;
import com.ibm.cloud.platform_services.global_catalog.v1.model.PricingSet;
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
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ObjectMetadataSet model.
 */
public class ObjectMetadataSetTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectMetadataSet() throws Throwable {
    CFMetaData cfMetaDataModel = new CFMetaData.Builder()
      .type("testString")
      .iamCompatible(true)
      .uniqueApiKey(true)
      .provisionable(true)
      .bindable(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .requires(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .planUpdateable(true)
      .state("testString")
      .serviceCheckEnabled(true)
      .testCheckInterval(Long.valueOf("26"))
      .serviceKeySupported(true)
      .cfGuid(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
      .build();
    assertEquals(cfMetaDataModel.type(), "testString");
    assertEquals(cfMetaDataModel.iamCompatible(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.provisionable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.bindable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.requires(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(cfMetaDataModel.planUpdateable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.state(), "testString");
    assertEquals(cfMetaDataModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(cfMetaDataModel.serviceKeySupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.cfGuid(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });

    PlanMetaData planMetaDataModel = new PlanMetaData.Builder()
      .bindable(true)
      .reservable(true)
      .allowInternalUsers(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .testCheckInterval(Long.valueOf("26"))
      .singleScopeInstance("testString")
      .serviceCheckEnabled(true)
      .cfGuid(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
      .build();
    assertEquals(planMetaDataModel.bindable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.reservable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(planMetaDataModel.singleScopeInstance(), "testString");
    assertEquals(planMetaDataModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.cfGuid(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });

    AliasMetaData aliasMetaDataModel = new AliasMetaData.Builder()
      .type("testString")
      .planId("testString")
      .build();
    assertEquals(aliasMetaDataModel.type(), "testString");
    assertEquals(aliasMetaDataModel.planId(), "testString");

    SourceMetaData sourceMetaDataModel = new SourceMetaData.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();
    assertEquals(sourceMetaDataModel.path(), "testString");
    assertEquals(sourceMetaDataModel.type(), "testString");
    assertEquals(sourceMetaDataModel.url(), "testString");

    TemplateMetaData templateMetaDataModel = new TemplateMetaData.Builder()
      .services(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .defaultMemory(Long.valueOf("26"))
      .startCmd("testString")
      .source(sourceMetaDataModel)
      .runtimeCatalogId("testString")
      .cfRuntimeId("testString")
      .templateId("testString")
      .executableFile("testString")
      .buildpack("testString")
      .environmentVariables(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
      .build();
    assertEquals(templateMetaDataModel.services(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(templateMetaDataModel.defaultMemory(), Long.valueOf("26"));
    assertEquals(templateMetaDataModel.startCmd(), "testString");
    assertEquals(templateMetaDataModel.source(), sourceMetaDataModel);
    assertEquals(templateMetaDataModel.runtimeCatalogId(), "testString");
    assertEquals(templateMetaDataModel.cfRuntimeId(), "testString");
    assertEquals(templateMetaDataModel.templateId(), "testString");
    assertEquals(templateMetaDataModel.executableFile(), "testString");
    assertEquals(templateMetaDataModel.buildpack(), "testString");
    assertEquals(templateMetaDataModel.environmentVariables(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });

    Bullets bulletsModel = new Bullets.Builder()
      .title("testString")
      .description("testString")
      .icon("testString")
      .quantity(Long.valueOf("26"))
      .build();
    assertEquals(bulletsModel.title(), "testString");
    assertEquals(bulletsModel.description(), "testString");
    assertEquals(bulletsModel.icon(), "testString");
    assertEquals(bulletsModel.quantity(), Long.valueOf("26"));

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

    Strings stringsModel = new Strings.Builder()
      .bullets(new java.util.ArrayList<Bullets>(java.util.Arrays.asList(bulletsModel)))
      .media(new java.util.ArrayList<UIMetaMedia>(java.util.Arrays.asList(uiMetaMediaModel)))
      .notCreatableMsg("testString")
      .notCreatableRobotMsg("testString")
      .deprecationWarning("testString")
      .popupWarningMessage("testString")
      .instruction("testString")
      .build();
    assertEquals(stringsModel.bullets(), new java.util.ArrayList<Bullets>(java.util.Arrays.asList(bulletsModel)));
    assertEquals(stringsModel.media(), new java.util.ArrayList<UIMetaMedia>(java.util.Arrays.asList(uiMetaMediaModel)));
    assertEquals(stringsModel.notCreatableMsg(), "testString");
    assertEquals(stringsModel.notCreatableRobotMsg(), "testString");
    assertEquals(stringsModel.deprecationWarning(), "testString");
    assertEquals(stringsModel.popupWarningMessage(), "testString");
    assertEquals(stringsModel.instruction(), "testString");

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
    assertEquals(urlsModel.docUrl(), "testString");
    assertEquals(urlsModel.instructionsUrl(), "testString");
    assertEquals(urlsModel.apiUrl(), "testString");
    assertEquals(urlsModel.createUrl(), "testString");
    assertEquals(urlsModel.sdkDownloadUrl(), "testString");
    assertEquals(urlsModel.termsUrl(), "testString");
    assertEquals(urlsModel.customCreatePageUrl(), "testString");
    assertEquals(urlsModel.catalogDetailsUrl(), "testString");
    assertEquals(urlsModel.deprecationDocUrl(), "testString");
    assertEquals(urlsModel.dashboardUrl(), "testString");
    assertEquals(urlsModel.registrationUrl(), "testString");
    assertEquals(urlsModel.apidocsurl(), "testString");

    UIMetaData uiMetaDataModel = new UIMetaData.Builder()
      .strings(new java.util.HashMap<String, Strings>() { { put("foo", stringsModel); } })
      .urls(urlsModel)
      .embeddableDashboard("testString")
      .embeddableDashboardFullWidth(true)
      .navigationOrder(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .notCreatable(true)
      .primaryOfferingId("testString")
      .accessibleDuringProvision(true)
      .sideBySideIndex(Long.valueOf("26"))
      .endOfServiceTime(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .hidden(true)
      .hideLiteMetering(true)
      .noUpgradeNextStep(true)
      .build();
    assertEquals(uiMetaDataModel.strings(), new java.util.HashMap<String, Strings>() { { put("foo", stringsModel); } });
    assertEquals(uiMetaDataModel.urls(), urlsModel);
    assertEquals(uiMetaDataModel.embeddableDashboard(), "testString");
    assertEquals(uiMetaDataModel.embeddableDashboardFullWidth(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.navigationOrder(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(uiMetaDataModel.notCreatable(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.primaryOfferingId(), "testString");
    assertEquals(uiMetaDataModel.accessibleDuringProvision(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.sideBySideIndex(), Long.valueOf("26"));
    assertEquals(uiMetaDataModel.endOfServiceTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(uiMetaDataModel.hidden(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.hideLiteMetering(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.noUpgradeNextStep(), Boolean.valueOf(true));

    DRMetaData drMetaDataModel = new DRMetaData.Builder()
      .dr(true)
      .description("testString")
      .build();
    assertEquals(drMetaDataModel.dr(), Boolean.valueOf(true));
    assertEquals(drMetaDataModel.description(), "testString");

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
      .apiEndpoint(new java.util.HashMap<String, String>() { { put("foo", "testString"); } })
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
    assertEquals(callbacksModel.apiEndpoint(), new java.util.HashMap<String, String>() { { put("foo", "testString"); } });

    Price priceModel = new Price.Builder()
      .quantityTier(Long.valueOf("26"))
      .price(Double.valueOf("72.5"))
      .build();
    assertEquals(priceModel.quantityTier(), Long.valueOf("26"));
    assertEquals(priceModel.price(), Double.valueOf("72.5"));

    Amount amountModel = new Amount.Builder()
      .country("testString")
      .currency("testString")
      .prices(new java.util.ArrayList<Price>(java.util.Arrays.asList(priceModel)))
      .build();
    assertEquals(amountModel.country(), "testString");
    assertEquals(amountModel.currency(), "testString");
    assertEquals(amountModel.prices(), new java.util.ArrayList<Price>(java.util.Arrays.asList(priceModel)));

    StartingPrice startingPriceModel = new StartingPrice.Builder()
      .planId("testString")
      .deploymentId("testString")
      .unit("testString")
      .amount(new java.util.ArrayList<Amount>(java.util.Arrays.asList(amountModel)))
      .build();
    assertEquals(startingPriceModel.planId(), "testString");
    assertEquals(startingPriceModel.deploymentId(), "testString");
    assertEquals(startingPriceModel.unit(), "testString");
    assertEquals(startingPriceModel.amount(), new java.util.ArrayList<Amount>(java.util.Arrays.asList(amountModel)));

    PricingSet pricingSetModel = new PricingSet.Builder()
      .type("testString")
      .origin("testString")
      .startingPrice(startingPriceModel)
      .build();
    assertEquals(pricingSetModel.type(), "testString");
    assertEquals(pricingSetModel.origin(), "testString");
    assertEquals(pricingSetModel.startingPrice(), startingPriceModel);

    Broker brokerModel = new Broker.Builder()
      .name("testString")
      .guid("testString")
      .build();
    assertEquals(brokerModel.name(), "testString");
    assertEquals(brokerModel.guid(), "testString");

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
    assertEquals(deploymentBaseModel.location(), "testString");
    assertEquals(deploymentBaseModel.locationUrl(), "testString");
    assertEquals(deploymentBaseModel.originalLocation(), "testString");
    assertEquals(deploymentBaseModel.targetCrn(), "testString");
    assertEquals(deploymentBaseModel.serviceCrn(), "testString");
    assertEquals(deploymentBaseModel.mccpId(), "testString");
    assertEquals(deploymentBaseModel.broker(), brokerModel);
    assertEquals(deploymentBaseModel.supportsRcMigration(), Boolean.valueOf(true));
    assertEquals(deploymentBaseModel.targetNetwork(), "testString");

    ObjectMetadataSet objectMetadataSetModel = new ObjectMetadataSet.Builder()
      .rcCompatible(true)
      .service(cfMetaDataModel)
      .plan(planMetaDataModel)
      .alias(aliasMetaDataModel)
      .template(templateMetaDataModel)
      .ui(uiMetaDataModel)
      .compliance(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .sla(slaMetaDataModel)
      .callbacks(callbacksModel)
      .originalName("testString")
      .version("testString")
      .other(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .pricing(pricingSetModel)
      .deployment(deploymentBaseModel)
      .build();
    assertEquals(objectMetadataSetModel.rcCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataSetModel.service(), cfMetaDataModel);
    assertEquals(objectMetadataSetModel.plan(), planMetaDataModel);
    assertEquals(objectMetadataSetModel.alias(), aliasMetaDataModel);
    assertEquals(objectMetadataSetModel.template(), templateMetaDataModel);
    assertEquals(objectMetadataSetModel.ui(), uiMetaDataModel);
    assertEquals(objectMetadataSetModel.compliance(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(objectMetadataSetModel.sla(), slaMetaDataModel);
    assertEquals(objectMetadataSetModel.callbacks(), callbacksModel);
    assertEquals(objectMetadataSetModel.originalName(), "testString");
    assertEquals(objectMetadataSetModel.version(), "testString");
    assertEquals(objectMetadataSetModel.other(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(objectMetadataSetModel.pricing(), pricingSetModel);
    assertEquals(objectMetadataSetModel.deployment(), deploymentBaseModel);

    String json = TestUtilities.serialize(objectMetadataSetModel);

    ObjectMetadataSet objectMetadataSetModelNew = TestUtilities.deserialize(json, ObjectMetadataSet.class);
    assertTrue(objectMetadataSetModelNew instanceof ObjectMetadataSet);
    assertEquals(objectMetadataSetModelNew.rcCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataSetModelNew.service().toString(), cfMetaDataModel.toString());
    assertEquals(objectMetadataSetModelNew.plan().toString(), planMetaDataModel.toString());
    assertEquals(objectMetadataSetModelNew.alias().toString(), aliasMetaDataModel.toString());
    assertEquals(objectMetadataSetModelNew.template().toString(), templateMetaDataModel.toString());
    assertEquals(objectMetadataSetModelNew.ui().toString(), uiMetaDataModel.toString());
    assertEquals(objectMetadataSetModelNew.sla().toString(), slaMetaDataModel.toString());
    assertEquals(objectMetadataSetModelNew.callbacks().toString(), callbacksModel.toString());
    assertEquals(objectMetadataSetModelNew.originalName(), "testString");
    assertEquals(objectMetadataSetModelNew.version(), "testString");
    assertEquals(objectMetadataSetModelNew.pricing().toString(), pricingSetModel.toString());
    assertEquals(objectMetadataSetModelNew.deployment().toString(), deploymentBaseModel.toString());
  }
}