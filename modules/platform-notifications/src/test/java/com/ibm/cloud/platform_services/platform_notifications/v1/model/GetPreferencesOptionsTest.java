/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.platform_services.platform_notifications.v1.model.GetPreferencesOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetPreferencesOptions model.
 */
public class GetPreferencesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetPreferencesOptions() throws Throwable {
    GetPreferencesOptions getPreferencesOptionsModel = new GetPreferencesOptions.Builder()
      .iamId("IBMid-1234567890")
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .build();
    assertEquals(getPreferencesOptionsModel.iamId(), "IBMid-1234567890");
    assertEquals(getPreferencesOptionsModel.accountId(), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetPreferencesOptionsError() throws Throwable {
    new GetPreferencesOptions.Builder().build();
  }

}