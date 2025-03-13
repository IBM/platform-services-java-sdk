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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.ListCatalogEntriesOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListCatalogEntriesOptions model.
 */
public class ListCatalogEntriesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListCatalogEntriesOptions() throws Throwable {
    ListCatalogEntriesOptions listCatalogEntriesOptionsModel = new ListCatalogEntriesOptions.Builder()
      .account("testString")
      .include("testString")
      .q("testString")
      .sortBy("testString")
      .descending("testString")
      .languages("testString")
      .catalog(true)
      .complete(true)
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("50"))
      .build();
    assertEquals(listCatalogEntriesOptionsModel.account(), "testString");
    assertEquals(listCatalogEntriesOptionsModel.include(), "testString");
    assertEquals(listCatalogEntriesOptionsModel.q(), "testString");
    assertEquals(listCatalogEntriesOptionsModel.sortBy(), "testString");
    assertEquals(listCatalogEntriesOptionsModel.descending(), "testString");
    assertEquals(listCatalogEntriesOptionsModel.languages(), "testString");
    assertEquals(listCatalogEntriesOptionsModel.catalog(), Boolean.valueOf(true));
    assertEquals(listCatalogEntriesOptionsModel.complete(), Boolean.valueOf(true));
    assertEquals(listCatalogEntriesOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(listCatalogEntriesOptionsModel.limit(), Long.valueOf("50"));
  }
}