/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.cloud.platform_services.usage_reports.v4.model;

import com.ibm.cloud.platform_services.usage_reports.v4.model.GetReportsSnapshotOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetReportsSnapshotOptions model.
 */
public class GetReportsSnapshotOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetReportsSnapshotOptions() throws Throwable {
    GetReportsSnapshotOptions getReportsSnapshotOptionsModel = new GetReportsSnapshotOptions.Builder()
      .accountId("abc")
      .month("2023-02")
      .dateFrom(Long.valueOf("1675209600000"))
      .dateTo(Long.valueOf("1675987200000"))
      .build();
    assertEquals(getReportsSnapshotOptionsModel.accountId(), "abc");
    assertEquals(getReportsSnapshotOptionsModel.month(), "2023-02");
    assertEquals(getReportsSnapshotOptionsModel.dateFrom(), Long.valueOf("1675209600000"));
    assertEquals(getReportsSnapshotOptionsModel.dateTo(), Long.valueOf("1675987200000"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetReportsSnapshotOptionsError() throws Throwable {
    new GetReportsSnapshotOptions.Builder().build();
  }

}