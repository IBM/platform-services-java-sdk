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

import com.ibm.cloud.platform_services.catalog_management.v1.model.Deployment;
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
 * Unit test class for the Deployment model.
 */
public class DeploymentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeployment() throws Throwable {
    Deployment deploymentModel = new Deployment.Builder()
      .id("testString")
      .label("testString")
      .name("testString")
      .shortDescription("testString")
      .longDescription("testString")
      .metadata(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .build();
    assertEquals(deploymentModel.id(), "testString");
    assertEquals(deploymentModel.label(), "testString");
    assertEquals(deploymentModel.name(), "testString");
    assertEquals(deploymentModel.shortDescription(), "testString");
    assertEquals(deploymentModel.longDescription(), "testString");
    assertEquals(deploymentModel.metadata(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
    assertEquals(deploymentModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(deploymentModel.created(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));
    assertEquals(deploymentModel.updated(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));

    String json = TestUtilities.serialize(deploymentModel);

    Deployment deploymentModelNew = TestUtilities.deserialize(json, Deployment.class);
    assertTrue(deploymentModelNew instanceof Deployment);
    assertEquals(deploymentModelNew.id(), "testString");
    assertEquals(deploymentModelNew.label(), "testString");
    assertEquals(deploymentModelNew.name(), "testString");
    assertEquals(deploymentModelNew.shortDescription(), "testString");
    assertEquals(deploymentModelNew.longDescription(), "testString");
    assertEquals(deploymentModelNew.metadata().toString(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }}.toString());
    assertEquals(deploymentModelNew.created().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
    assertEquals(deploymentModelNew.updated().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
  }
}