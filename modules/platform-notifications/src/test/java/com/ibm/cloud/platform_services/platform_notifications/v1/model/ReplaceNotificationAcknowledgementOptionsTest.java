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

import com.ibm.cloud.platform_services.platform_notifications.v1.model.ReplaceNotificationAcknowledgementOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReplaceNotificationAcknowledgementOptions model.
 */
public class ReplaceNotificationAcknowledgementOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceNotificationAcknowledgementOptions() throws Throwable {
    ReplaceNotificationAcknowledgementOptions replaceNotificationAcknowledgementOptionsModel = new ReplaceNotificationAcknowledgementOptions.Builder()
      .lastAcknowledgedId("1772804159452")
      .accountId("1369339417d906e5620b8d861d40cfd7")
      .build();
    assertEquals(replaceNotificationAcknowledgementOptionsModel.lastAcknowledgedId(), "1772804159452");
    assertEquals(replaceNotificationAcknowledgementOptionsModel.accountId(), "1369339417d906e5620b8d861d40cfd7");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceNotificationAcknowledgementOptionsError() throws Throwable {
    new ReplaceNotificationAcknowledgementOptions.Builder().build();
  }

}