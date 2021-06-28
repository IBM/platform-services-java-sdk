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
 * Unit test class for the DeployOperatorsOptions model.
 */
public class DeployOperatorsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeployOperatorsOptions() throws Throwable {
    DeployOperatorsOptions deployOperatorsOptionsModel = new DeployOperatorsOptions.Builder()
      .xAuthRefreshToken("testString")
      .clusterId("testString")
      .region("testString")
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .allNamespaces(true)
      .versionLocatorId("testString")
      .build();
    assertEquals(deployOperatorsOptionsModel.xAuthRefreshToken(), "testString");
    assertEquals(deployOperatorsOptionsModel.clusterId(), "testString");
    assertEquals(deployOperatorsOptionsModel.region(), "testString");
    assertEquals(deployOperatorsOptionsModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(deployOperatorsOptionsModel.allNamespaces(), Boolean.valueOf(true));
    assertEquals(deployOperatorsOptionsModel.versionLocatorId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDeployOperatorsOptionsError() throws Throwable {
    new DeployOperatorsOptions.Builder().build();
  }

}