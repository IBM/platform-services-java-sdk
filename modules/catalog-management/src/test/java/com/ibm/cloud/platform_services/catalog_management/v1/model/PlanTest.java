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
import com.ibm.cloud.sdk.core.util.DateUtils;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Unit test class for the Plan model.
 */
public class PlanTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPlan() throws Throwable {
    Feature featureModel = new Feature.Builder()
      .title("testString")
      .description("testString")
      .build();
    assertEquals(featureModel.title(), "testString");
    assertEquals(featureModel.description(), "testString");

    Deployment deploymentModel = new Deployment.Builder()
      .id("testString")
      .label("testString")
      .name("testString")
      .shortDescription("testString")
      .longDescription("testString")
      .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .build();
    assertEquals(deploymentModel.id(), "testString");
    assertEquals(deploymentModel.label(), "testString");
    assertEquals(deploymentModel.name(), "testString");
    assertEquals(deploymentModel.shortDescription(), "testString");
    assertEquals(deploymentModel.longDescription(), "testString");
    assertEquals(deploymentModel.metadata(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(deploymentModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(deploymentModel.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(deploymentModel.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));

    Plan planModel = new Plan.Builder()
      .id("testString")
      .label("testString")
      .name("testString")
      .shortDescription("testString")
      .longDescription("testString")
      .metadata(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .additionalFeatures(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
      .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .deployments(new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)))
      .build();
    assertEquals(planModel.id(), "testString");
    assertEquals(planModel.label(), "testString");
    assertEquals(planModel.name(), "testString");
    assertEquals(planModel.shortDescription(), "testString");
    assertEquals(planModel.longDescription(), "testString");
    assertEquals(planModel.metadata(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(planModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(planModel.additionalFeatures(), new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)));
    assertEquals(planModel.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(planModel.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(planModel.deployments(), new java.util.ArrayList<Deployment>(java.util.Arrays.asList(deploymentModel)));

    String json = TestUtilities.serialize(planModel);

    Plan planModelNew = TestUtilities.deserialize(json, Plan.class);
    assertTrue(planModelNew instanceof Plan);
    assertEquals(planModelNew.id(), "testString");
    assertEquals(planModelNew.label(), "testString");
    assertEquals(planModelNew.name(), "testString");
    assertEquals(planModelNew.shortDescription(), "testString");
    assertEquals(planModelNew.longDescription(), "testString");
    assertEquals(planModelNew.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(planModelNew.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
  }
}