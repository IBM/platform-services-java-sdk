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

import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageOrgOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetResourceUsageOrgOptions model.
 */
public class GetResourceUsageOrgOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetResourceUsageOrgOptions() throws Throwable {
    GetResourceUsageOrgOptions getResourceUsageOrgOptionsModel = new GetResourceUsageOrgOptions.Builder()
      .accountId("testString")
      .organizationId("testString")
      .billingmonth("testString")
      .names(true)
      .acceptLanguage("testString")
      .limit(Long.valueOf("1"))
      .start("testString")
      .resourceInstanceId("testString")
      .resourceId("testString")
      .planId("testString")
      .region("testString")
      .build();
    assertEquals(getResourceUsageOrgOptionsModel.accountId(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.organizationId(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.billingmonth(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.names(), Boolean.valueOf(true));
    assertEquals(getResourceUsageOrgOptionsModel.acceptLanguage(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.limit(), Long.valueOf("1"));
    assertEquals(getResourceUsageOrgOptionsModel.start(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.resourceInstanceId(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.resourceId(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.planId(), "testString");
    assertEquals(getResourceUsageOrgOptionsModel.region(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageOrgOptionsError() throws Throwable {
    new GetResourceUsageOrgOptions.Builder().build();
  }

}