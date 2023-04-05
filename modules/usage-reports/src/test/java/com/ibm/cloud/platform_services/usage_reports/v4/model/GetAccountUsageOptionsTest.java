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

import com.ibm.cloud.platform_services.usage_reports.v4.model.GetAccountUsageOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetAccountUsageOptions model.
 */
public class GetAccountUsageOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetAccountUsageOptions() throws Throwable {
    GetAccountUsageOptions getAccountUsageOptionsModel = new GetAccountUsageOptions.Builder()
      .accountId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .build();
    assertEquals(getAccountUsageOptionsModel.accountId(), "testString");
    assertEquals(getAccountUsageOptionsModel.billingmonth(), "testString");
    assertEquals(getAccountUsageOptionsModel.names(), Boolean.valueOf(true));
    assertEquals(getAccountUsageOptionsModel.acceptLanguage(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetAccountUsageOptionsError() throws Throwable {
    new GetAccountUsageOptions.Builder().build();
  }

}