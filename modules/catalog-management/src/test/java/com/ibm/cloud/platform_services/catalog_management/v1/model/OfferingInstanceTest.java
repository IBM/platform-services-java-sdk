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

import com.ibm.cloud.platform_services.catalog_management.v1.model.OfferingInstance;
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
 * Unit test class for the OfferingInstance model.
 */
public class OfferingInstanceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testOfferingInstance() throws Throwable {
    OfferingInstance offeringInstanceModel = new OfferingInstance.Builder()
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
    assertEquals(offeringInstanceModel.id(), "testString");
    assertEquals(offeringInstanceModel.url(), "testString");
    assertEquals(offeringInstanceModel.crn(), "testString");
    assertEquals(offeringInstanceModel.label(), "testString");
    assertEquals(offeringInstanceModel.catalogId(), "testString");
    assertEquals(offeringInstanceModel.offeringId(), "testString");
    assertEquals(offeringInstanceModel.kindFormat(), "testString");
    assertEquals(offeringInstanceModel.version(), "testString");
    assertEquals(offeringInstanceModel.clusterId(), "testString");
    assertEquals(offeringInstanceModel.clusterRegion(), "testString");
    assertEquals(offeringInstanceModel.clusterNamespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(offeringInstanceModel.clusterAllNamespaces(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(offeringInstanceModel);

    OfferingInstance offeringInstanceModelNew = TestUtilities.deserialize(json, OfferingInstance.class);
    assertTrue(offeringInstanceModelNew instanceof OfferingInstance);
    assertEquals(offeringInstanceModelNew.id(), "testString");
    assertEquals(offeringInstanceModelNew.url(), "testString");
    assertEquals(offeringInstanceModelNew.crn(), "testString");
    assertEquals(offeringInstanceModelNew.label(), "testString");
    assertEquals(offeringInstanceModelNew.catalogId(), "testString");
    assertEquals(offeringInstanceModelNew.offeringId(), "testString");
    assertEquals(offeringInstanceModelNew.kindFormat(), "testString");
    assertEquals(offeringInstanceModelNew.version(), "testString");
    assertEquals(offeringInstanceModelNew.clusterId(), "testString");
    assertEquals(offeringInstanceModelNew.clusterRegion(), "testString");
    assertEquals(offeringInstanceModelNew.clusterAllNamespaces(), Boolean.valueOf(true));
  }
}