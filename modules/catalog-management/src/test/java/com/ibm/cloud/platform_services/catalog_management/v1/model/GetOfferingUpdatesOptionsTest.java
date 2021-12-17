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

import com.ibm.cloud.platform_services.catalog_management.v1.model.GetOfferingUpdatesOptions;
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
 * Unit test class for the GetOfferingUpdatesOptions model.
 */
public class GetOfferingUpdatesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetOfferingUpdatesOptions() throws Throwable {
    GetOfferingUpdatesOptions getOfferingUpdatesOptionsModel = new GetOfferingUpdatesOptions.Builder()
      .catalogIdentifier("testString")
      .offeringId("testString")
      .kind("testString")
      .xAuthRefreshToken("testString")
      .target("testString")
      .version("testString")
      .clusterId("testString")
      .region("testString")
      .resourceGroupId("testString")
      .namespace("testString")
      .sha("testString")
      .channel("testString")
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .allNamespaces(true)
      .build();
    assertEquals(getOfferingUpdatesOptionsModel.catalogIdentifier(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.offeringId(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.kind(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.target(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.version(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.clusterId(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.region(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.resourceGroupId(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.namespace(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.sha(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.channel(), "testString");
    assertEquals(getOfferingUpdatesOptionsModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(getOfferingUpdatesOptionsModel.allNamespaces(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetOfferingUpdatesOptionsError() throws Throwable {
    new GetOfferingUpdatesOptions.Builder().build();
  }

}