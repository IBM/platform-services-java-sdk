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

import com.ibm.cloud.platform_services.usage_reports.v4.model.GetResourceUsageResourceGroupOptions;
import com.ibm.cloud.platform_services.usage_reports.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetResourceUsageResourceGroupOptions model.
 */
public class GetResourceUsageResourceGroupOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetResourceUsageResourceGroupOptions() throws Throwable {
    GetResourceUsageResourceGroupOptions getResourceUsageResourceGroupOptionsModel = new GetResourceUsageResourceGroupOptions.Builder()
      .accountId("testString")
      .resourceGroupId("testString")
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
    assertEquals(getResourceUsageResourceGroupOptionsModel.accountId(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.resourceGroupId(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.billingmonth(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.names(), Boolean.valueOf(true));
    assertEquals(getResourceUsageResourceGroupOptionsModel.acceptLanguage(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.limit(), Long.valueOf("1"));
    assertEquals(getResourceUsageResourceGroupOptionsModel.start(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.resourceInstanceId(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.resourceId(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.planId(), "testString");
    assertEquals(getResourceUsageResourceGroupOptionsModel.region(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetResourceUsageResourceGroupOptionsError() throws Throwable {
    new GetResourceUsageResourceGroupOptions.Builder().build();
  }

}