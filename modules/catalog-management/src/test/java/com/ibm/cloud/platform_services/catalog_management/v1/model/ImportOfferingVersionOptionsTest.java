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

import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Unit test class for the ImportOfferingVersionOptions model.
 */
public class ImportOfferingVersionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testImportOfferingVersionOptions() throws Throwable {
    ImportOfferingVersionOptions importOfferingVersionOptionsModel = new ImportOfferingVersionOptions.Builder()
      .catalogIdentifier("testString")
      .offeringId("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .content(TestUtilities.createMockByteArray("This is a mock byte array value."))
      .zipurl("testString")
      .targetVersion("testString")
      .includeConfig(true)
      .isVsi(true)
      .repoType("testString")
      .build();
    assertEquals(importOfferingVersionOptionsModel.catalogIdentifier(), "testString");
    assertEquals(importOfferingVersionOptionsModel.offeringId(), "testString");
    assertEquals(importOfferingVersionOptionsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(importOfferingVersionOptionsModel.targetKinds(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(importOfferingVersionOptionsModel.content(), TestUtilities.createMockByteArray("This is a mock byte array value."));
    assertEquals(importOfferingVersionOptionsModel.zipurl(), "testString");
    assertEquals(importOfferingVersionOptionsModel.targetVersion(), "testString");
    assertEquals(importOfferingVersionOptionsModel.includeConfig(), Boolean.valueOf(true));
    assertEquals(importOfferingVersionOptionsModel.isVsi(), Boolean.valueOf(true));
    assertEquals(importOfferingVersionOptionsModel.repoType(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testImportOfferingVersionOptionsError() throws Throwable {
    new ImportOfferingVersionOptions.Builder().build();
  }

}