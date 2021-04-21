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

import com.ibm.cloud.platform_services.resource_controller.v2.model.ListResourceBindingsForAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListResourceBindingsForAliasOptions model.
 */
public class ListResourceBindingsForAliasOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListResourceBindingsForAliasOptions() throws Throwable {
    ListResourceBindingsForAliasOptions listResourceBindingsForAliasOptionsModel = new ListResourceBindingsForAliasOptions.Builder()
      .id("testString")
      .limit(Long.valueOf("100"))
      .start("testString")
      .build();
    assertEquals(listResourceBindingsForAliasOptionsModel.id(), "testString");
    assertEquals(listResourceBindingsForAliasOptionsModel.limit(), Long.valueOf("100"));
    assertEquals(listResourceBindingsForAliasOptionsModel.start(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListResourceBindingsForAliasOptionsError() throws Throwable {
    new ListResourceBindingsForAliasOptions.Builder().build();
  }

}