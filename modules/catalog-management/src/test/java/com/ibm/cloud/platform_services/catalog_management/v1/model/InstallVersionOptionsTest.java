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

import com.ibm.cloud.platform_services.catalog_management.v1.model.DeployRequestBodySchematics;
import com.ibm.cloud.platform_services.catalog_management.v1.model.InstallVersionOptions;
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
 * Unit test class for the InstallVersionOptions model.
 */
public class InstallVersionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testInstallVersionOptions() throws Throwable {
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

    InstallVersionOptions installVersionOptionsModel = new InstallVersionOptions.Builder()
      .versionLocId("testString")
      .xAuthRefreshToken("testString")
      .clusterId("testString")
      .region("testString")
      .namespace("testString")
      .overrideValues(new java.util.HashMap<String,Object>(){{put("foo", "testString"); }})
      .entitlementApikey("testString")
      .schematics(deployRequestBodySchematicsModel)
      .script("testString")
      .scriptId("testString")
      .versionLocatorId("testString")
      .vcenterId("testString")
      .vcenterPassword("testString")
      .vcenterLocation("testString")
      .build();
    assertEquals(installVersionOptionsModel.versionLocId(), "testString");
    assertEquals(installVersionOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(installVersionOptionsModel.clusterId(), "testString");
    assertEquals(installVersionOptionsModel.region(), "testString");
    assertEquals(installVersionOptionsModel.namespace(), "testString");
    assertEquals(installVersionOptionsModel.overrideValues(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
    assertEquals(installVersionOptionsModel.entitlementApikey(), "testString");
    assertEquals(installVersionOptionsModel.schematics(), deployRequestBodySchematicsModel);
    assertEquals(installVersionOptionsModel.script(), "testString");
    assertEquals(installVersionOptionsModel.scriptId(), "testString");
    assertEquals(installVersionOptionsModel.versionLocatorId(), "testString");
    assertEquals(installVersionOptionsModel.vcenterId(), "testString");
    assertEquals(installVersionOptionsModel.vcenterPassword(), "testString");
    assertEquals(installVersionOptionsModel.vcenterLocation(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testInstallVersionOptionsError() throws Throwable {
    new InstallVersionOptions.Builder().build();
  }

}