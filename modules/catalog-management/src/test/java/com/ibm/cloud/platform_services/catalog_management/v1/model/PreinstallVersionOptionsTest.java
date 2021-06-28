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
 * Unit test class for the PreinstallVersionOptions model.
 */
public class PreinstallVersionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPreinstallVersionOptions() throws Throwable {
    DeployRequestBodySchematics deployRequestBodySchematicsModel = new DeployRequestBodySchematics.Builder()
      .name("testString")
      .description("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .resourceGroupId("testString")
      .build();
    assertEquals(deployRequestBodySchematicsModel.name(), "testString");
    assertEquals(deployRequestBodySchematicsModel.description(), "testString");
    assertEquals(deployRequestBodySchematicsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(deployRequestBodySchematicsModel.resourceGroupId(), "testString");

    PreinstallVersionOptions preinstallVersionOptionsModel = new PreinstallVersionOptions.Builder()
      .versionLocId("testString")
      .xAuthRefreshToken("testString")
      .clusterId("testString")
      .region("testString")
      .namespace("testString")
      .overrideValues(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .entitlementApikey("testString")
      .schematics(deployRequestBodySchematicsModel)
      .script("testString")
      .scriptId("testString")
      .versionLocatorId("testString")
      .vcenterId("testString")
      .vcenterUser("testString")
      .vcenterPassword("testString")
      .vcenterLocation("testString")
      .vcenterDatastore("testString")
      .build();
    assertEquals(preinstallVersionOptionsModel.versionLocId(), "testString");
    assertEquals(preinstallVersionOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(preinstallVersionOptionsModel.clusterId(), "testString");
    assertEquals(preinstallVersionOptionsModel.region(), "testString");
    assertEquals(preinstallVersionOptionsModel.namespace(), "testString");
    assertEquals(preinstallVersionOptionsModel.overrideValues(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
    assertEquals(preinstallVersionOptionsModel.entitlementApikey(), "testString");
    assertEquals(preinstallVersionOptionsModel.schematics(), deployRequestBodySchematicsModel);
    assertEquals(preinstallVersionOptionsModel.script(), "testString");
    assertEquals(preinstallVersionOptionsModel.scriptId(), "testString");
    assertEquals(preinstallVersionOptionsModel.versionLocatorId(), "testString");
    assertEquals(preinstallVersionOptionsModel.vcenterId(), "testString");
    assertEquals(preinstallVersionOptionsModel.vcenterUser(), "testString");
    assertEquals(preinstallVersionOptionsModel.vcenterPassword(), "testString");
    assertEquals(preinstallVersionOptionsModel.vcenterLocation(), "testString");
    assertEquals(preinstallVersionOptionsModel.vcenterDatastore(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testPreinstallVersionOptionsError() throws Throwable {
    new PreinstallVersionOptions.Builder().build();
  }

}