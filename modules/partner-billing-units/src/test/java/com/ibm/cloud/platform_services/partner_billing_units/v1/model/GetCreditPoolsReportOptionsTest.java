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

package com.ibm.cloud.platform_services.partner_billing_units.v1.model;

import com.ibm.cloud.platform_services.partner_billing_units.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetCreditPoolsReportOptions model.
 */
public class GetCreditPoolsReportOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetCreditPoolsReportOptions() throws Throwable {
    GetCreditPoolsReportOptions getCreditPoolsReportOptionsModel = new GetCreditPoolsReportOptions.Builder()
      .partnerId("testString")
      .customerId("testString")
      .resellerId("testString")
      .date("2024-01")
      .limit(Long.valueOf("30"))
      .build();
    assertEquals(getCreditPoolsReportOptionsModel.partnerId(), "testString");
    assertEquals(getCreditPoolsReportOptionsModel.customerId(), "testString");
    assertEquals(getCreditPoolsReportOptionsModel.resellerId(), "testString");
    assertEquals(getCreditPoolsReportOptionsModel.date(), "2024-01");
    assertEquals(getCreditPoolsReportOptionsModel.limit(), Long.valueOf("30"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCreditPoolsReportOptionsError() throws Throwable {
    new GetCreditPoolsReportOptions.Builder().build();
  }

}