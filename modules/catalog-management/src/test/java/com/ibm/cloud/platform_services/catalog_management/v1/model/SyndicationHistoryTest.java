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

import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
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
 * Unit test class for the SyndicationHistory model.
 */
public class SyndicationHistoryTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSyndicationHistory() throws Throwable {
    SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder()
      .region("testString")
      .id("testString")
      .name("testString")
      .resourceGroupName("testString")
      .type("testString")
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .allNamespaces(true)
      .build();
    assertEquals(syndicationClusterModel.region(), "testString");
    assertEquals(syndicationClusterModel.id(), "testString");
    assertEquals(syndicationClusterModel.name(), "testString");
    assertEquals(syndicationClusterModel.resourceGroupName(), "testString");
    assertEquals(syndicationClusterModel.type(), "testString");
    assertEquals(syndicationClusterModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationClusterModel.allNamespaces(), Boolean.valueOf(true));

    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
      .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .build();
    assertEquals(syndicationHistoryModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationHistoryModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationHistoryModel.lastRun(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));

    String json = TestUtilities.serialize(syndicationHistoryModel);

    SyndicationHistory syndicationHistoryModelNew = TestUtilities.deserialize(json, SyndicationHistory.class);
    assertTrue(syndicationHistoryModelNew instanceof SyndicationHistory);
    assertEquals(syndicationHistoryModelNew.lastRun().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
  }
}