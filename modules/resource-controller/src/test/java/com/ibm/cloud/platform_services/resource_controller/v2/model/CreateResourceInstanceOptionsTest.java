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

import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceInstanceOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateResourceInstanceOptions model.
 */
public class CreateResourceInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateResourceInstanceOptions() throws Throwable {
    CreateResourceInstanceOptions createResourceInstanceOptionsModel = new CreateResourceInstanceOptions.Builder()
      .name("my-instance")
      .target("us-south")
      .resourceGroup("5c49eabc-f5e8-5881-a37e-2d100a33b3df")
      .resourcePlanId("cloudant-standard")
      .tags(java.util.Arrays.asList("testString"))
      .allowCleanup(false)
      .parameters(java.util.Collections.singletonMap("anyKey", "anyValue"))
      .entityLock(false)
      .build();
    assertEquals(createResourceInstanceOptionsModel.name(), "my-instance");
    assertEquals(createResourceInstanceOptionsModel.target(), "us-south");
    assertEquals(createResourceInstanceOptionsModel.resourceGroup(), "5c49eabc-f5e8-5881-a37e-2d100a33b3df");
    assertEquals(createResourceInstanceOptionsModel.resourcePlanId(), "cloudant-standard");
    assertEquals(createResourceInstanceOptionsModel.tags(), java.util.Arrays.asList("testString"));
    assertEquals(createResourceInstanceOptionsModel.allowCleanup(), Boolean.valueOf(false));
    assertEquals(createResourceInstanceOptionsModel.parameters(), java.util.Collections.singletonMap("anyKey", "anyValue"));
    assertEquals(createResourceInstanceOptionsModel.entityLock(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceInstanceOptionsError() throws Throwable {
    new CreateResourceInstanceOptions.Builder().build();
  }

}