/*
 * (C) Copyright IBM Corp. 2024.
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

package com.ibm.cloud.platform_services.partner_usage_reports.v1.model;

import com.ibm.cloud.platform_services.partner_usage_reports.v1.utils.TestUtilities;
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
      .partnerId("testString")
      .resellerId("testString")
      .customerId("testString")
      .children(false)
      .month("2024-01")
      .viewpoint("DISTRIBUTOR")
      .recurse(false)
      .limit(Long.valueOf("30"))
      .offset("testString")
      .build();
    assertEquals(getResourceUsageReportOptionsModel.partnerId(), "testString");
    assertEquals(getResourceUsageReportOptionsModel.resellerId(), "testString");
    assertEquals(getResourceUsageReportOptionsModel.customerId(), "testString");
    assertEquals(getResourceUsageReportOptionsModel.children(), Boolean.valueOf(false));
    assertEquals(getResourceUsageReportOptionsModel.month(), "2024-01");
    assertEquals(getResourceUsageReportOptionsModel.viewpoint(), "DISTRIBUTOR");
    assertEquals(getResourceUsageReportOptionsModel.recurse(), Boolean.valueOf(false));
    assertEquals(getResourceUsageReportOptionsModel.limit(), Long.valueOf("30"));
    assertEquals(getResourceUsageReportOptionsModel.offset(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageReportOptionsError() throws Throwable {
    new GetResourceUsageReportOptions.Builder().build();
  }

}