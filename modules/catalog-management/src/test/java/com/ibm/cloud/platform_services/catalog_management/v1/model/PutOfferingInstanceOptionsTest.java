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
 * Unit test class for the PutOfferingInstanceOptions model.
 */
public class PutOfferingInstanceOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPutOfferingInstanceOptions() throws Throwable {
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

    PutOfferingInstanceOptions putOfferingInstanceOptionsModel = new PutOfferingInstanceOptions.Builder()
      .instanceIdentifier("testString")
      .xAuthRefreshToken("testString")
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
    assertEquals(putOfferingInstanceOptionsModel.instanceIdentifier(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.id(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.rev(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.url(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.crn(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.label(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.catalogId(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.offeringId(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.kindFormat(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.version(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.clusterId(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.clusterRegion(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.clusterNamespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(putOfferingInstanceOptionsModel.clusterAllNamespaces(), Boolean.valueOf(true));
    assertEquals(putOfferingInstanceOptionsModel.schematicsWorkspaceId(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.resourceGroupId(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.installPlan(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.channel(), "testString");
    assertEquals(putOfferingInstanceOptionsModel.metadata(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(putOfferingInstanceOptionsModel.lastOperation(), offeringInstanceLastOperationModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPutOfferingInstanceOptionsError() throws Throwable {
    new PutOfferingInstanceOptions.Builder().build();
  }

}