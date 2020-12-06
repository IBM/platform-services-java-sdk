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

package com.ibm.cloud.platform_services.usage_metering.v4.model;

import com.ibm.cloud.platform_services.usage_metering.v4.model.MeasureAndQuantity;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResourceInstanceUsage;
import com.ibm.cloud.platform_services.usage_metering.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResourceInstanceUsage model.
 */
public class ResourceInstanceUsageTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResourceInstanceUsage() throws Throwable {
    MeasureAndQuantity measureAndQuantityModel = new MeasureAndQuantity.Builder()
      .measure("STORAGE")
      .quantity("1")
      .build();
    assertEquals(measureAndQuantityModel.measure(), "STORAGE");
    assertEquals(measureAndQuantityModel.quantity(), "1");

    ResourceInstanceUsage resourceInstanceUsageModel = new ResourceInstanceUsage.Builder()
      .resourceInstanceId("crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::")
      .planId("database-lite")
      .region("us-south")
      .start(Long.valueOf("1485907200000"))
      .end(Long.valueOf("1485907200000"))
      .measuredUsage(new java.util.ArrayList<MeasureAndQuantity>(java.util.Arrays.asList(measureAndQuantityModel)))
      .consumerId("cf-application:ed20abbe-8870-44e6-90f7-56d764c21127")
      .build();
    assertEquals(resourceInstanceUsageModel.resourceInstanceId(), "crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::");
    assertEquals(resourceInstanceUsageModel.planId(), "database-lite");
    assertEquals(resourceInstanceUsageModel.region(), "us-south");
    assertEquals(resourceInstanceUsageModel.start(), Long.valueOf("1485907200000"));
    assertEquals(resourceInstanceUsageModel.end(), Long.valueOf("1485907200000"));
    assertEquals(resourceInstanceUsageModel.measuredUsage(), new java.util.ArrayList<MeasureAndQuantity>(java.util.Arrays.asList(measureAndQuantityModel)));
    assertEquals(resourceInstanceUsageModel.consumerId(), "cf-application:ed20abbe-8870-44e6-90f7-56d764c21127");

    String json = TestUtilities.serialize(resourceInstanceUsageModel);

    ResourceInstanceUsage resourceInstanceUsageModelNew = TestUtilities.deserialize(json, ResourceInstanceUsage.class);
    assertTrue(resourceInstanceUsageModelNew instanceof ResourceInstanceUsage);
    assertEquals(resourceInstanceUsageModelNew.resourceInstanceId(), "crn:v1:bluemix:staging:database-service:us-south:a/1c8ae972c35e470d994b6faff9494ce1:793ff3d3-9fe3-4329-9ea0-404703a3c371::");
    assertEquals(resourceInstanceUsageModelNew.planId(), "database-lite");
    assertEquals(resourceInstanceUsageModelNew.region(), "us-south");
    assertEquals(resourceInstanceUsageModelNew.start(), Long.valueOf("1485907200000"));
    assertEquals(resourceInstanceUsageModelNew.end(), Long.valueOf("1485907200000"));
    assertEquals(resourceInstanceUsageModelNew.consumerId(), "cf-application:ed20abbe-8870-44e6-90f7-56d764c21127");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResourceInstanceUsageError() throws Throwable {
    new ResourceInstanceUsage.Builder().build();
  }

}