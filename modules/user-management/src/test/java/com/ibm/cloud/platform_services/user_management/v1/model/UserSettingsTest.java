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

package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.platform_services.user_management.v1.model.UserSettings;
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UserSettings model.
 */
public class UserSettingsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUserSettings() throws Throwable {
    UserSettings userSettingsModel = new UserSettings.Builder()
      .language("testString")
      .notificationLanguage("testString")
      .allowedIpAddresses("32.96.110.50,172.16.254.1")
      .selfManage(true)
      .build();
    assertEquals(userSettingsModel.language(), "testString");
    assertEquals(userSettingsModel.notificationLanguage(), "testString");
    assertEquals(userSettingsModel.allowedIpAddresses(), "32.96.110.50,172.16.254.1");
    assertEquals(userSettingsModel.selfManage(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(userSettingsModel);

    UserSettings userSettingsModelNew = TestUtilities.deserialize(json, UserSettings.class);
    assertTrue(userSettingsModelNew instanceof UserSettings);
    assertEquals(userSettingsModelNew.language(), "testString");
    assertEquals(userSettingsModelNew.notificationLanguage(), "testString");
    assertEquals(userSettingsModelNew.allowedIpAddresses(), "32.96.110.50,172.16.254.1");
    assertEquals(userSettingsModelNew.selfManage(), Boolean.valueOf(true));
  }
}