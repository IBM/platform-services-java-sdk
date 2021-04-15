/*
 * (C) Copyright IBM Corp. 2021.
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

import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceAliasesOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListResourceAliasesOptions model.
 */
public class ListResourceAliasesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListResourceAliasesOptions() throws Throwable {
    ListResourceAliasesOptions listResourceAliasesOptionsModel = new ListResourceAliasesOptions.Builder()
      .guid("testString")
      .name("testString")
      .resourceInstanceId("testString")
      .regionInstanceId("testString")
      .resourceId("testString")
      .resourceGroupId("testString")
      .limit(Long.valueOf("100"))
      .start("testString")
      .updatedFrom("2019-01-08T00:00:00.000Z")
      .updatedTo("2019-01-08T00:00:00.000Z")
      .build();
    assertEquals(listResourceAliasesOptionsModel.guid(), "testString");
    assertEquals(listResourceAliasesOptionsModel.name(), "testString");
    assertEquals(listResourceAliasesOptionsModel.resourceInstanceId(), "testString");
    assertEquals(listResourceAliasesOptionsModel.regionInstanceId(), "testString");
    assertEquals(listResourceAliasesOptionsModel.resourceId(), "testString");
    assertEquals(listResourceAliasesOptionsModel.resourceGroupId(), "testString");
    assertEquals(listResourceAliasesOptionsModel.limit(), Long.valueOf("100"));
    assertEquals(listResourceAliasesOptionsModel.start(), "testString");
    assertEquals(listResourceAliasesOptionsModel.updatedFrom(), "2019-01-08T00:00:00.000Z");
    assertEquals(listResourceAliasesOptionsModel.updatedTo(), "2019-01-08T00:00:00.000Z");
  }
}