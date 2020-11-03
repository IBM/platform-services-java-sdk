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

package com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model;

import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.model.GetResourceUsageReportOptions;
import com.ibm.cloud.platform_services.enterprise_usage_reports.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetResourceUsageReportOptions model.
 */
public class GetResourceUsageReportOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetResourceUsageReportOptions() throws Throwable {
    GetResourceUsageReportOptions getResourceUsageReportOptionsModel = new GetResourceUsageReportOptions.Builder()
      .enterpriseId("abc12340d4bf4e36b0423d209b286f24")
      .accountGroupId("def456a237b94b9a9238ef024e204c9f")
      .accountId("987abcba31834216b8c726a7dd9eb8d6")
      .children(true)
      .month("2019-06")
      .billingUnitId("testString")
      .limit(Long.valueOf("10"))
      .offset("testString")
      .build();
    assertEquals(getResourceUsageReportOptionsModel.enterpriseId(), "abc12340d4bf4e36b0423d209b286f24");
    assertEquals(getResourceUsageReportOptionsModel.accountGroupId(), "def456a237b94b9a9238ef024e204c9f");
    assertEquals(getResourceUsageReportOptionsModel.accountId(), "987abcba31834216b8c726a7dd9eb8d6");
    assertEquals(getResourceUsageReportOptionsModel.children(), Boolean.valueOf(true));
    assertEquals(getResourceUsageReportOptionsModel.month(), "2019-06");
    assertEquals(getResourceUsageReportOptionsModel.billingUnitId(), "testString");
    assertEquals(getResourceUsageReportOptionsModel.limit(), Long.valueOf("10"));
    assertEquals(getResourceUsageReportOptionsModel.offset(), "testString");
  }
}