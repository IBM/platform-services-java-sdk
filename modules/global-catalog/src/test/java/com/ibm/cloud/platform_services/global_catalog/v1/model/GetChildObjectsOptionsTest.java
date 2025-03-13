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

import com.ibm.cloud.platform_services.global_catalog.v1.model.GetChildObjectsOptions;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetChildObjectsOptions model.
 */
public class GetChildObjectsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetChildObjectsOptions() throws Throwable {
    GetChildObjectsOptions getChildObjectsOptionsModel = new GetChildObjectsOptions.Builder()
      .id("testString")
      .kind("testString")
      .account("testString")
      .include("testString")
      .q("testString")
      .sortBy("testString")
      .descending("testString")
      .languages("testString")
      .complete(true)
      .offset(Long.valueOf("0"))
      .limit(Long.valueOf("50"))
      .build();
    assertEquals(getChildObjectsOptionsModel.id(), "testString");
    assertEquals(getChildObjectsOptionsModel.kind(), "testString");
    assertEquals(getChildObjectsOptionsModel.account(), "testString");
    assertEquals(getChildObjectsOptionsModel.include(), "testString");
    assertEquals(getChildObjectsOptionsModel.q(), "testString");
    assertEquals(getChildObjectsOptionsModel.sortBy(), "testString");
    assertEquals(getChildObjectsOptionsModel.descending(), "testString");
    assertEquals(getChildObjectsOptionsModel.languages(), "testString");
    assertEquals(getChildObjectsOptionsModel.complete(), Boolean.valueOf(true));
    assertEquals(getChildObjectsOptionsModel.offset(), Long.valueOf("0"));
    assertEquals(getChildObjectsOptionsModel.limit(), Long.valueOf("50"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetChildObjectsOptionsError() throws Throwable {
    new GetChildObjectsOptions.Builder().build();
  }

}