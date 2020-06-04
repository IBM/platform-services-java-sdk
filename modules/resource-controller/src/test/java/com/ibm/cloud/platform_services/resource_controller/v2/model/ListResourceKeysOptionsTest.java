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

package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceKeysOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListResourceKeysOptions model.
 */
public class ListResourceKeysOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListResourceKeysOptions() throws Throwable {
    ListResourceKeysOptions listResourceKeysOptionsModel = new ListResourceKeysOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceGroupId("testString")
      .resourceId("testString")
      .limit("testString")
      .updatedFrom("2019-01-08T00:00:00.000Z")
      .updatedTo("2019-01-08T00:00:00.000Z")
      .build();
    assertEquals(listResourceKeysOptionsModel.guid(), "testString");
    assertEquals(listResourceKeysOptionsModel.name(), "testString");
    assertEquals(listResourceKeysOptionsModel.resourceGroupId(), "testString");
    assertEquals(listResourceKeysOptionsModel.resourceId(), "testString");
    assertEquals(listResourceKeysOptionsModel.limit(), "testString");
    assertEquals(listResourceKeysOptionsModel.updatedFrom(), "2019-01-08T00:00:00.000Z");
    assertEquals(listResourceKeysOptionsModel.updatedTo(), "2019-01-08T00:00:00.000Z");
  }
}