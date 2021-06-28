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

import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Unit test class for the ValidationInstallOptions model.
 */
public class ValidationInstallOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testValidationInstallOptions() throws Throwable {
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

    ValidationInstallOptions validationInstallOptionsModel = new ValidationInstallOptions.Builder()
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
    assertEquals(validationInstallOptionsModel.versionLocId(), "testString");
    assertEquals(validationInstallOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(validationInstallOptionsModel.clusterId(), "testString");
    assertEquals(validationInstallOptionsModel.region(), "testString");
    assertEquals(validationInstallOptionsModel.namespace(), "testString");
    assertEquals(validationInstallOptionsModel.overrideValues(), new java.util.HashMap<String,Object>(){{put("foo", "testString"); }});
    assertEquals(validationInstallOptionsModel.entitlementApikey(), "testString");
    assertEquals(validationInstallOptionsModel.schematics(), deployRequestBodySchematicsModel);
    assertEquals(validationInstallOptionsModel.script(), "testString");
    assertEquals(validationInstallOptionsModel.scriptId(), "testString");
    assertEquals(validationInstallOptionsModel.versionLocatorId(), "testString");
    assertEquals(validationInstallOptionsModel.vcenterId(), "testString");
    assertEquals(validationInstallOptionsModel.vcenterPassword(), "testString");
    assertEquals(validationInstallOptionsModel.vcenterLocation(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testValidationInstallOptionsError() throws Throwable {
    new ValidationInstallOptions.Builder().build();
  }

}