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

import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.AccountSettings;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.Feature;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.model.RegionSetting;
import com.ibm.cloud.platform_services.ibm_cloud_shell.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AccountSettings model.
 */
public class AccountSettingsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccountSettings() throws Throwable {
    Feature featureModel = new Feature.Builder()
      .enabled(true)
      .key("server.file_manager")
      .build();
    assertEquals(featureModel.enabled(), Boolean.valueOf(true));
    assertEquals(featureModel.key(), "server.file_manager");

    RegionSetting regionSettingModel = new RegionSetting.Builder()
      .enabled(true)
      .key("eu-de")
      .build();
    assertEquals(regionSettingModel.enabled(), Boolean.valueOf(true));
    assertEquals(regionSettingModel.key(), "eu-de");

    AccountSettings accountSettingsModel = new AccountSettings.Builder()
      .rev("130-12345678-abcd-1a2b-a1b2-1234567890ab")
      .defaultEnableNewFeatures(true)
      .defaultEnableNewRegions(true)
      .enabled(true)
      .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
      .regions(new java.util.ArrayList<RegionSetting>(java.util.Arrays.asList(regionSettingModel)))
      .build();
    assertEquals(accountSettingsModel.rev(), "130-12345678-abcd-1a2b-a1b2-1234567890ab");
    assertEquals(accountSettingsModel.defaultEnableNewFeatures(), Boolean.valueOf(true));
    assertEquals(accountSettingsModel.defaultEnableNewRegions(), Boolean.valueOf(true));
    assertEquals(accountSettingsModel.enabled(), Boolean.valueOf(true));
    assertEquals(accountSettingsModel.features(), new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)));
    assertEquals(accountSettingsModel.regions(), new java.util.ArrayList<RegionSetting>(java.util.Arrays.asList(regionSettingModel)));

    String json = TestUtilities.serialize(accountSettingsModel);

    AccountSettings accountSettingsModelNew = TestUtilities.deserialize(json, AccountSettings.class);
    assertTrue(accountSettingsModelNew instanceof AccountSettings);
    assertEquals(accountSettingsModelNew.rev(), "130-12345678-abcd-1a2b-a1b2-1234567890ab");
    assertEquals(accountSettingsModelNew.defaultEnableNewFeatures(), Boolean.valueOf(true));
    assertEquals(accountSettingsModelNew.defaultEnableNewRegions(), Boolean.valueOf(true));
    assertEquals(accountSettingsModelNew.enabled(), Boolean.valueOf(true));
  }
}