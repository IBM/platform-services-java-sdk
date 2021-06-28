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
import static org.testng.Assert.assertTrue;

/**
 * Unit test class for the OfferingInstance model.
 */
public class OfferingInstanceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testOfferingInstance() throws Throwable {
    OfferingInstanceLastOperation offeringInstanceLastOperationModel = new OfferingInstanceLastOperation.Builder()
      .operation("testString")
      .state("testString")
      .message("testString")
      .transactionId("testString")
      .updated("testString")
      .build();
    assertEquals(offeringInstanceLastOperationModel.operation(), "testString");
    assertEquals(offeringInstanceLastOperationModel.state(), "testString");
    assertEquals(offeringInstanceLastOperationModel.message(), "testString");
    assertEquals(offeringInstanceLastOperationModel.transactionId(), "testString");
    assertEquals(offeringInstanceLastOperationModel.updated(), "testString");

    OfferingInstance offeringInstanceModel = new OfferingInstance.Builder()
      .id("testString")
      .rev("testString")
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
      .schematicsWorkspaceId("testString")
      .resourceGroupId("testString")
      .installPlan("testString")
      .channel("testString")
      .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .lastOperation(offeringInstanceLastOperationModel)
      .build();
    assertEquals(offeringInstanceModel.id(), "testString");
    assertEquals(offeringInstanceModel.rev(), "testString");
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
    assertEquals(offeringInstanceModel.schematicsWorkspaceId(), "testString");
    assertEquals(offeringInstanceModel.resourceGroupId(), "testString");
    assertEquals(offeringInstanceModel.installPlan(), "testString");
    assertEquals(offeringInstanceModel.channel(), "testString");
    assertEquals(offeringInstanceModel.metadata(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(offeringInstanceModel.lastOperation(), offeringInstanceLastOperationModel);

    String json = TestUtilities.serialize(offeringInstanceModel);

    OfferingInstance offeringInstanceModelNew = TestUtilities.deserialize(json, OfferingInstance.class);
    assertTrue(offeringInstanceModelNew instanceof OfferingInstance);
    assertEquals(offeringInstanceModelNew.id(), "testString");
    assertEquals(offeringInstanceModelNew.rev(), "testString");
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
    assertEquals(offeringInstanceModelNew.schematicsWorkspaceId(), "testString");
    assertEquals(offeringInstanceModelNew.resourceGroupId(), "testString");
    assertEquals(offeringInstanceModelNew.installPlan(), "testString");
    assertEquals(offeringInstanceModelNew.channel(), "testString");
    assertEquals(offeringInstanceModelNew.lastOperation().toString(), offeringInstanceLastOperationModel.toString());
  }
}