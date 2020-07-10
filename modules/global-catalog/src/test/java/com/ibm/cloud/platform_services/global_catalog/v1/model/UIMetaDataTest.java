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

import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
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
 * Unit test class for the UIMetaData model.
 */
public class UIMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUIMetaData() throws Throwable {
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
      .strings(new java.util.HashMap<String,Strings>(){{put("foo", stringsModel); }})
      .urls(urlsModel)
      .embeddableDashboard("testString")
      .embeddableDashboardFullWidth(true)
      .navigationOrder(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .notCreatable(true)
      .primaryOfferingId("testString")
      .accessibleDuringProvision(true)
      .sideBySideIndex(Long.valueOf("26"))
      .endOfServiceTime(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .hidden(true)
      .hideLiteMetering(true)
      .noUpgradeNextStep(true)
      .build();
    assertEquals(uiMetaDataModel.strings(), new java.util.HashMap<String,Strings>(){{put("foo", stringsModel); }});
    assertEquals(uiMetaDataModel.urls(), urlsModel);
    assertEquals(uiMetaDataModel.embeddableDashboard(), "testString");
    assertEquals(uiMetaDataModel.embeddableDashboardFullWidth(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.navigationOrder(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(uiMetaDataModel.notCreatable(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.primaryOfferingId(), "testString");
    assertEquals(uiMetaDataModel.accessibleDuringProvision(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.sideBySideIndex(), Long.valueOf("26"));
    assertEquals(uiMetaDataModel.endOfServiceTime(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));
    assertEquals(uiMetaDataModel.hidden(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.hideLiteMetering(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.noUpgradeNextStep(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(uiMetaDataModel);

    UIMetaData uiMetaDataModelNew = TestUtilities.deserialize(json, UIMetaData.class);
    assertTrue(uiMetaDataModelNew instanceof UIMetaData);
    assertEquals(uiMetaDataModelNew.urls().toString(), urlsModel.toString());
    assertEquals(uiMetaDataModelNew.embeddableDashboard(), "testString");
    assertEquals(uiMetaDataModelNew.embeddableDashboardFullWidth(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.notCreatable(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.primaryOfferingId(), "testString");
    assertEquals(uiMetaDataModelNew.accessibleDuringProvision(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.sideBySideIndex(), Long.valueOf("26"));
    assertEquals(uiMetaDataModelNew.endOfServiceTime().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
    assertEquals(uiMetaDataModelNew.hidden(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.hideLiteMetering(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.noUpgradeNextStep(), Boolean.valueOf(true));
  }
}