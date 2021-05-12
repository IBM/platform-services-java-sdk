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

import com.ibm.cloud.platform_services.catalog_management.v1.model.CreateOfferingInstanceOptions;
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
 * Unit test class for the CreateOfferingInstanceOptions model.
 */
public class CreateOfferingInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateOfferingInstanceOptions() throws Throwable {
    CreateOfferingInstanceOptions createOfferingInstanceOptionsModel = new CreateOfferingInstanceOptions.Builder()
      .xAuthRefreshToken("testString")
      .id("testString")
      .url("testString")
      .crn("testString")
      .label("testString")
      .catalogId("testString")
      .offeringId("testString")
      .kindFormat("testString")
      .version("testString")
      .clusterId("testString")
      .clusterRegion("testString")
      .clusterNamespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .clusterAllNamespaces(true)
      .build();
    assertEquals(createOfferingInstanceOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.id(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.url(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.crn(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.label(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.catalogId(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.offeringId(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.kindFormat(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.version(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.clusterId(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.clusterRegion(), "testString");
    assertEquals(createOfferingInstanceOptionsModel.clusterNamespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(createOfferingInstanceOptionsModel.clusterAllNamespaces(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateOfferingInstanceOptionsError() throws Throwable {
    new CreateOfferingInstanceOptions.Builder().build();
  }

}