/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.context_based_restrictions.v1.model;

import com.ibm.cloud.platform_services.context_based_restrictions.v1.model.ResourceTagAttribute;
import com.ibm.cloud.platform_services.context_based_restrictions.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResourceTagAttribute model.
 */
public class ResourceTagAttributeTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResourceTagAttribute() throws Throwable {
    ResourceTagAttribute resourceTagAttributeModel = new ResourceTagAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(resourceTagAttributeModel.name(), "testString");
    assertEquals(resourceTagAttributeModel.value(), "testString");
    assertEquals(resourceTagAttributeModel.operator(), "testString");

    String json = TestUtilities.serialize(resourceTagAttributeModel);

    ResourceTagAttribute resourceTagAttributeModelNew = TestUtilities.deserialize(json, ResourceTagAttribute.class);
    assertTrue(resourceTagAttributeModelNew instanceof ResourceTagAttribute);
    assertEquals(resourceTagAttributeModelNew.name(), "testString");
    assertEquals(resourceTagAttributeModelNew.value(), "testString");
    assertEquals(resourceTagAttributeModelNew.operator(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testResourceTagAttributeError() throws Throwable {
    new ResourceTagAttribute.Builder().build();
  }

}