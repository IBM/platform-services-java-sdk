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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.ImportOfferingOptions;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ImportOfferingOptions model.
 */
public class ImportOfferingOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImportOfferingOptions() throws Throwable {
    ImportOfferingOptions importOfferingOptionsModel = new ImportOfferingOptions.Builder()
      .catalogIdentifier("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
      .zipurl("testString")
      .offeringId("testString")
      .targetVersion("testString")
      .includeConfig(true)
      .isVsi(true)
      .repoType("testString")
      .xAuthToken("testString")
      .build();
    assertEquals(importOfferingOptionsModel.catalogIdentifier(), "testString");
    assertEquals(importOfferingOptionsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(importOfferingOptionsModel.targetKinds(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(importOfferingOptionsModel.content(), TestUtilities.createMockByteArray("This is a mock byte array value."));
    assertEquals(importOfferingOptionsModel.zipurl(), "testString");
    assertEquals(importOfferingOptionsModel.offeringId(), "testString");
    assertEquals(importOfferingOptionsModel.targetVersion(), "testString");
    assertEquals(importOfferingOptionsModel.includeConfig(), Boolean.valueOf(true));
    assertEquals(importOfferingOptionsModel.isVsi(), Boolean.valueOf(true));
    assertEquals(importOfferingOptionsModel.repoType(), "testString");
    assertEquals(importOfferingOptionsModel.xAuthToken(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportOfferingOptionsError() throws Throwable {
    new ImportOfferingOptions.Builder().build();
  }

}