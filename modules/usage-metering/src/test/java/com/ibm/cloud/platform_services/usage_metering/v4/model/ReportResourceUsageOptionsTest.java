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

package com.ibm.cloud.platform_services.usage_metering.v4.model;

import com.ibm.cloud.platform_services.usage_metering.v4.model.MeasureAndQuantity;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ReportResourceUsageOptions;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResourceInstanceUsage;
import com.ibm.cloud.platform_services.usage_metering.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReportResourceUsageOptions model.
 */
public class ReportResourceUsageOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReportResourceUsageOptions() throws Throwable {
    MeasureAndQuantity measureAndQuantityModel = new MeasureAndQuantity.Builder()
      .measure("QUERIES")
      .quantity("100")
      .build();
    assertEquals(measureAndQuantityModel.measure(), "QUERIES");
    assertEquals(measureAndQuantityModel.quantity(), "100");

    ResourceInstanceUsage resourceInstanceUsageModel = new ResourceInstanceUsage.Builder()
      .resourceInstanceId("crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::")
      .planId("database-lite")
      .region("us-south")
      .start(Long.valueOf("1485907200001"))
      .end(Long.valueOf("1485910800000"))
      .measuredUsage(java.util.Arrays.asList(measureAndQuantityModel))
      .consumerId("cf-application:ed20abbe-8870-44e6-90f7-56d764c21127")
      .build();
    assertEquals(resourceInstanceUsageModel.resourceInstanceId(), "crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::");
    assertEquals(resourceInstanceUsageModel.planId(), "database-lite");
    assertEquals(resourceInstanceUsageModel.region(), "us-south");
    assertEquals(resourceInstanceUsageModel.start(), Long.valueOf("1485907200001"));
    assertEquals(resourceInstanceUsageModel.end(), Long.valueOf("1485910800000"));
    assertEquals(resourceInstanceUsageModel.measuredUsage(), java.util.Arrays.asList(measureAndQuantityModel));
    assertEquals(resourceInstanceUsageModel.consumerId(), "cf-application:ed20abbe-8870-44e6-90f7-56d764c21127");

    ReportResourceUsageOptions reportResourceUsageOptionsModel = new ReportResourceUsageOptions.Builder()
      .resourceId("93d21e40-aafd-451c-a393-5273d09d056a")
      .resourceUsage(java.util.Arrays.asList(resourceInstanceUsageModel))
      .build();
    assertEquals(reportResourceUsageOptionsModel.resourceId(), "93d21e40-aafd-451c-a393-5273d09d056a");
    assertEquals(reportResourceUsageOptionsModel.resourceUsage(), java.util.Arrays.asList(resourceInstanceUsageModel));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReportResourceUsageOptionsError() throws Throwable {
    new ReportResourceUsageOptions.Builder().build();
  }

}