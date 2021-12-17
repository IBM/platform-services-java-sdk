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

import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationAuthorization;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationResource;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SyndicationResource model.
 */
public class SyndicationResourceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSyndicationResource() throws Throwable {
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
      .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(syndicationHistoryModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationHistoryModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationHistoryModel.lastRun(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
      .token("testString")
      .lastRun(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(syndicationAuthorizationModel.token(), "testString");
    assertEquals(syndicationAuthorizationModel.lastRun(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    SyndicationResource syndicationResourceModel = new SyndicationResource.Builder()
      .removeRelatedComponents(true)
      .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
      .history(syndicationHistoryModel)
      .authorization(syndicationAuthorizationModel)
      .build();
    assertEquals(syndicationResourceModel.removeRelatedComponents(), Boolean.valueOf(true));
    assertEquals(syndicationResourceModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationResourceModel.history(), syndicationHistoryModel);
    assertEquals(syndicationResourceModel.authorization(), syndicationAuthorizationModel);

    String json = TestUtilities.serialize(syndicationResourceModel);

    SyndicationResource syndicationResourceModelNew = TestUtilities.deserialize(json, SyndicationResource.class);
    assertTrue(syndicationResourceModelNew instanceof SyndicationResource);
    assertEquals(syndicationResourceModelNew.removeRelatedComponents(), Boolean.valueOf(true));
    assertEquals(syndicationResourceModelNew.history().toString(), syndicationHistoryModel.toString());
    assertEquals(syndicationResourceModelNew.authorization().toString(), syndicationAuthorizationModel.toString());
  }
}