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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Bullets;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMediaSourceMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaMedia;
import com.ibm.cloud.platform_services.global_catalog.v1.model.URLS;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
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

    UIMediaSourceMetaData uiMediaSourceMetaDataModel = new UIMediaSourceMetaData.Builder()
      .type("testString")
      .url("testString")
      .build();
    assertEquals(uiMediaSourceMetaDataModel.type(), "testString");
    assertEquals(uiMediaSourceMetaDataModel.url(), "testString");

    UIMetaMedia uiMetaMediaModel = new UIMetaMedia.Builder()
      .caption("testString")
      .thumbnailUrl("testString")
      .type("testString")
      .url("testString")
      .source(java.util.Arrays.asList(uiMediaSourceMetaDataModel))
      .build();
    assertEquals(uiMetaMediaModel.caption(), "testString");
    assertEquals(uiMetaMediaModel.thumbnailUrl(), "testString");
    assertEquals(uiMetaMediaModel.type(), "testString");
    assertEquals(uiMetaMediaModel.url(), "testString");
    assertEquals(uiMetaMediaModel.source(), java.util.Arrays.asList(uiMediaSourceMetaDataModel));

    Strings stringsModel = new Strings.Builder()
      .bullets(java.util.Arrays.asList(bulletsModel))
      .media(java.util.Arrays.asList(uiMetaMediaModel))
      .notCreatableMsg("testString")
      .notCreatableRobotMsg("testString")
      .deprecationWarning("testString")
      .popupWarningMessage("testString")
      .instruction("testString")
      .build();
    assertEquals(stringsModel.bullets(), java.util.Arrays.asList(bulletsModel));
    assertEquals(stringsModel.media(), java.util.Arrays.asList(uiMetaMediaModel));
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
    assertEquals(uiMetaDataModel.strings(), java.util.Collections.singletonMap("key1", stringsModel));
    assertEquals(uiMetaDataModel.urls(), urlsModel);
    assertEquals(uiMetaDataModel.embeddableDashboard(), "testString");
    assertEquals(uiMetaDataModel.embeddableDashboardFullWidth(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.navigationOrder(), java.util.Arrays.asList("testString"));
    assertEquals(uiMetaDataModel.notCreatable(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.primaryOfferingId(), "testString");
    assertEquals(uiMetaDataModel.accessibleDuringProvision(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModel.sideBySideIndex(), Long.valueOf("26"));
    assertEquals(uiMetaDataModel.endOfServiceTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
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
    assertEquals(uiMetaDataModelNew.endOfServiceTime(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(uiMetaDataModelNew.hidden(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.hideLiteMetering(), Boolean.valueOf(true));
    assertEquals(uiMetaDataModelNew.noUpgradeNextStep(), Boolean.valueOf(true));
  }
}