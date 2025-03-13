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

import com.ibm.cloud.platform_services.global_catalog.v1.model.DeleteCatalogEntryOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeleteCatalogEntryOptions model.
 */
public class DeleteCatalogEntryOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeleteCatalogEntryOptions() throws Throwable {
    DeleteCatalogEntryOptions deleteCatalogEntryOptionsModel = new DeleteCatalogEntryOptions.Builder()
      .id("testString")
      .account("testString")
      .force(true)
      .build();
    assertEquals(deleteCatalogEntryOptionsModel.id(), "testString");
    assertEquals(deleteCatalogEntryOptionsModel.account(), "testString");
    assertEquals(deleteCatalogEntryOptionsModel.force(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeleteCatalogEntryOptionsError() throws Throwable {
    new DeleteCatalogEntryOptions.Builder().build();
  }

}