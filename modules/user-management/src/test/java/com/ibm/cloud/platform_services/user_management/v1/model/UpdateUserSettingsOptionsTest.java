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

import com.ibm.cloud.platform_services.user_management.v1.model.UpdateUserSettingsOptions;
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateUserSettingsOptions model.
 */
public class UpdateUserSettingsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateUserSettingsOptions() throws Throwable {
    UpdateUserSettingsOptions updateUserSettingsOptionsModel = new UpdateUserSettingsOptions.Builder()
      .accountId("testString")
      .iamId("testString")
      .language("testString")
      .notificationLanguage("testString")
      .allowedIpAddresses("32.96.110.50,172.16.254.1")
      .selfManage(true)
      .build();
    assertEquals(updateUserSettingsOptionsModel.accountId(), "testString");
    assertEquals(updateUserSettingsOptionsModel.iamId(), "testString");
    assertEquals(updateUserSettingsOptionsModel.language(), "testString");
    assertEquals(updateUserSettingsOptionsModel.notificationLanguage(), "testString");
    assertEquals(updateUserSettingsOptionsModel.allowedIpAddresses(), "32.96.110.50,172.16.254.1");
    assertEquals(updateUserSettingsOptionsModel.selfManage(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateUserSettingsOptionsError() throws Throwable {
    new UpdateUserSettingsOptions.Builder().build();
  }

}