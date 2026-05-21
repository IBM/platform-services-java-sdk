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

import com.ibm.cloud.platform_services.platform_notifications.v1.model.DeleteDistributionListDestinationOptions;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteDistributionListDestinationOptions model.
 */
public class DeleteDistributionListDestinationOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteDistributionListDestinationOptions() throws Throwable {
    DeleteDistributionListDestinationOptions deleteDistributionListDestinationOptionsModel = new DeleteDistributionListDestinationOptions.Builder()
      .accountId("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6")
      .destinationId("12345678-1234-1234-1234-123456789012")
      .build();
    assertEquals(deleteDistributionListDestinationOptionsModel.accountId(), "a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6");
    assertEquals(deleteDistributionListDestinationOptionsModel.destinationId(), "12345678-1234-1234-1234-123456789012");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteDistributionListDestinationOptionsError() throws Throwable {
    new DeleteDistributionListDestinationOptions.Builder().build();
  }

}