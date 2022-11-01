/*
 * (C) Copyright IBM Corp. 2022.
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

package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.platform_services.resource_controller.v2.model.UpdateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateResourceInstanceOptions model.
 */
public class UpdateResourceInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateResourceInstanceOptions() throws Throwable {
    UpdateResourceInstanceOptions updateResourceInstanceOptionsModel = new UpdateResourceInstanceOptions.Builder()
      .id("testString")
      .name("my-new-instance-name")
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .resourcePlanId("a8dff6d3-d287-4668-a81d-c87c55c2656d")
      .allowCleanup(true)
      .build();
    assertEquals(updateResourceInstanceOptionsModel.id(), "testString");
    assertEquals(updateResourceInstanceOptionsModel.name(), "my-new-instance-name");
    assertEquals(updateResourceInstanceOptionsModel.parameters(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(updateResourceInstanceOptionsModel.resourcePlanId(), "a8dff6d3-d287-4668-a81d-c87c55c2656d");
    assertEquals(updateResourceInstanceOptionsModel.allowCleanup(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateResourceInstanceOptionsError() throws Throwable {
    new UpdateResourceInstanceOptions.Builder().build();
  }

}