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
import com.ibm.cloud.platform_services.global_catalog.v1.model.I18N;
import com.ibm.cloud.platform_services.global_catalog.v1.model.Strings;
import com.ibm.cloud.platform_services.global_catalog.v1.model.UIMetaMedia;
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
 * Unit test class for the I18N model.
 */
public class I18NTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testI18N() throws Throwable {
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

    I18N i18NModel = new I18N();
    i18NModel.put("foo", stringsModel);
    assertEquals(i18NModel.get("foo"), stringsModel);

    String json = TestUtilities.serialize(i18NModel);

    I18N i18NModelNew = TestUtilities.deserialize(json, I18N.class);
    assertTrue(i18NModelNew instanceof I18N);
    assertEquals(i18NModelNew.get("foo"), stringsModel);
    assertNotNull(i18NModel);
  }
}