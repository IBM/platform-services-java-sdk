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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.GetCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetCatalogEntryOptions model.
 */
public class GetCatalogEntryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetCatalogEntryOptions() throws Throwable {
    GetCatalogEntryOptions getCatalogEntryOptionsModel = new GetCatalogEntryOptions.Builder()
      .id("testString")
      .account("testString")
      .include("testString")
      .languages("testString")
      .complete("testString")
      .depth(Long.valueOf("26"))
      .build();
    assertEquals(getCatalogEntryOptionsModel.id(), "testString");
    assertEquals(getCatalogEntryOptionsModel.account(), "testString");
    assertEquals(getCatalogEntryOptionsModel.include(), "testString");
    assertEquals(getCatalogEntryOptionsModel.languages(), "testString");
    assertEquals(getCatalogEntryOptionsModel.complete(), "testString");
    assertEquals(getCatalogEntryOptionsModel.depth(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetCatalogEntryOptionsError() throws Throwable {
    new GetCatalogEntryOptions.Builder().build();
  }

}