/*
 * (C) Copyright IBM Corp. 2025.
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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.Broker;
import com.ibm.cloud.platform_services.global_catalog.v1.model.DeploymentBase;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DeploymentBase model.
 */
public class DeploymentBaseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDeploymentBase() throws Throwable {
    Broker brokerModel = new Broker.Builder()
      .name("testString")
      .guid("testString")
      .build();
    assertEquals(brokerModel.name(), "testString");
    assertEquals(brokerModel.guid(), "testString");

    DeploymentBase deploymentBaseModel = new DeploymentBase.Builder()
      .location("testString")
      .locationUrl("testString")
      .originalLocation("testString")
      .targetCrn("testString")
      .serviceCrn("testString")
      .mccpId("testString")
      .broker(brokerModel)
      .supportsRcMigration(true)
      .targetNetwork("testString")
      .build();
    assertEquals(deploymentBaseModel.location(), "testString");
    assertEquals(deploymentBaseModel.locationUrl(), "testString");
    assertEquals(deploymentBaseModel.originalLocation(), "testString");
    assertEquals(deploymentBaseModel.targetCrn(), "testString");
    assertEquals(deploymentBaseModel.serviceCrn(), "testString");
    assertEquals(deploymentBaseModel.mccpId(), "testString");
    assertEquals(deploymentBaseModel.broker(), brokerModel);
    assertEquals(deploymentBaseModel.supportsRcMigration(), Boolean.valueOf(true));
    assertEquals(deploymentBaseModel.targetNetwork(), "testString");

    String json = TestUtilities.serialize(deploymentBaseModel);

    DeploymentBase deploymentBaseModelNew = TestUtilities.deserialize(json, DeploymentBase.class);
    assertTrue(deploymentBaseModelNew instanceof DeploymentBase);
    assertEquals(deploymentBaseModelNew.location(), "testString");
    assertEquals(deploymentBaseModelNew.locationUrl(), "testString");
    assertEquals(deploymentBaseModelNew.originalLocation(), "testString");
    assertEquals(deploymentBaseModelNew.targetCrn(), "testString");
    assertEquals(deploymentBaseModelNew.serviceCrn(), "testString");
    assertEquals(deploymentBaseModelNew.mccpId(), "testString");
    assertEquals(deploymentBaseModelNew.broker().toString(), brokerModel.toString());
    assertEquals(deploymentBaseModelNew.supportsRcMigration(), Boolean.valueOf(true));
    assertEquals(deploymentBaseModelNew.targetNetwork(), "testString");
  }
}