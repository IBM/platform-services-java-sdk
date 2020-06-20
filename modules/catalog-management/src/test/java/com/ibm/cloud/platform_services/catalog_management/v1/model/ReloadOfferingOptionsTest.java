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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.ReloadOfferingOptions;
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
 * Unit test class for the ReloadOfferingOptions model.
 */
public class ReloadOfferingOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReloadOfferingOptions() throws Throwable {
    ReloadOfferingOptions reloadOfferingOptionsModel = new ReloadOfferingOptions.Builder()
      .catalogIdentifier("testString")
      .offeringId("testString")
      .zipurl("testString")
      .targetVersion("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .targetKinds(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .repoType("testString")
      .xAuthToken("testString")
      .build();
    assertEquals(reloadOfferingOptionsModel.catalogIdentifier(), "testString");
    assertEquals(reloadOfferingOptionsModel.offeringId(), "testString");
    assertEquals(reloadOfferingOptionsModel.zipurl(), "testString");
    assertEquals(reloadOfferingOptionsModel.targetVersion(), "testString");
    assertEquals(reloadOfferingOptionsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(reloadOfferingOptionsModel.targetKinds(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(reloadOfferingOptionsModel.repoType(), "testString");
    assertEquals(reloadOfferingOptionsModel.xAuthToken(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReloadOfferingOptionsError() throws Throwable {
    new ReloadOfferingOptions.Builder().build();
  }

}