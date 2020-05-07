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

import com.ibm.cloud.platform_services.global_catalog.v1.model.Overview;
import com.ibm.cloud.platform_services.global_catalog.v1.model.OverviewUI;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the OverviewUI model.
 */
public class OverviewUITest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testOverviewUI() throws Throwable {
    Overview overviewModel = new Overview.Builder()
      .displayName("testString")
      .longDescription("testString")
      .description("testString")
      .featuredDescription("testString")
      .build();
    assertEquals(overviewModel.displayName(), "testString");
    assertEquals(overviewModel.longDescription(), "testString");
    assertEquals(overviewModel.description(), "testString");
    assertEquals(overviewModel.featuredDescription(), "testString");

    OverviewUI overviewUiModel = new OverviewUI();
    overviewUiModel.put("foo", overviewModel);
    assertEquals(overviewUiModel.get("foo"), overviewModel);

    String json = TestUtilities.serialize(overviewUiModel);

    OverviewUI overviewUiModelNew = TestUtilities.deserialize(json, OverviewUI.class);
    assertTrue(overviewUiModelNew instanceof OverviewUI);
    assertEquals(overviewUiModelNew.get("foo"), overviewModel);
    assertNotNull(overviewUiModel);
  }
}