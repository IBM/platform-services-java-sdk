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
 * Unit test class for the ReplaceOperatorsOptions model.
 */
public class ReplaceOperatorsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReplaceOperatorsOptions() throws Throwable {
    ReplaceOperatorsOptions replaceOperatorsOptionsModel = new ReplaceOperatorsOptions.Builder()
      .xAuthRefreshToken("testString")
      .clusterId("testString")
      .region("testString")
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .allNamespaces(true)
      .versionLocatorId("testString")
      .build();
    assertEquals(replaceOperatorsOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(replaceOperatorsOptionsModel.clusterId(), "testString");
    assertEquals(replaceOperatorsOptionsModel.region(), "testString");
    assertEquals(replaceOperatorsOptionsModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(replaceOperatorsOptionsModel.allNamespaces(), Boolean.valueOf(true));
    assertEquals(replaceOperatorsOptionsModel.versionLocatorId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testReplaceOperatorsOptionsError() throws Throwable {
    new ReplaceOperatorsOptions.Builder().build();
  }

}