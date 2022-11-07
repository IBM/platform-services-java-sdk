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

package com.ibm.cloud.platform_services.user_management.v1.model;

import com.ibm.cloud.platform_services.user_management.v1.model.Attribute;
import com.ibm.cloud.platform_services.user_management.v1.model.Resource;
import com.ibm.cloud.platform_services.user_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Resource model.
 */
public class ResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResource() throws Throwable {
    Attribute attributeModel = new Attribute.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(attributeModel.name(), "testString");
    assertEquals(attributeModel.value(), "testString");

    Resource resourceModel = new Resource.Builder()
      .attributes(java.util.Arrays.asList(attributeModel))
      .build();
    assertEquals(resourceModel.attributes(), java.util.Arrays.asList(attributeModel));

    String json = TestUtilities.serialize(resourceModel);

    Resource resourceModelNew = TestUtilities.deserialize(json, Resource.class);
    assertTrue(resourceModelNew instanceof Resource);
  }
}