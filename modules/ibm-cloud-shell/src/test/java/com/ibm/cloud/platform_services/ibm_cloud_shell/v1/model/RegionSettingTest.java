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

package com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model;

import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.RegionSetting;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the RegionSetting model.
 */
public class RegionSettingTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRegionSetting() throws Throwable {
    RegionSetting regionSettingModel = new RegionSetting.Builder()
      .enabled(true)
      .key("eu-de")
      .build();
    assertEquals(regionSettingModel.enabled(), Boolean.valueOf(true));
    assertEquals(regionSettingModel.key(), "eu-de");

    String json = TestUtilities.serialize(regionSettingModel);

    RegionSetting regionSettingModelNew = TestUtilities.deserialize(json, RegionSetting.class);
    assertTrue(regionSettingModelNew instanceof RegionSetting);
    assertEquals(regionSettingModelNew.enabled(), Boolean.valueOf(true));
    assertEquals(regionSettingModelNew.key(), "eu-de");
  }
}