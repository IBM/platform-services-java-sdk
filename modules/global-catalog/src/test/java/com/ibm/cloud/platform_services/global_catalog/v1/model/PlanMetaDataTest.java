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

import com.ibm.cloud.platform_services.global_catalog.v1.model.PlanMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PlanMetaData model.
 */
public class PlanMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPlanMetaData() throws Throwable {
    PlanMetaData planMetaDataModel = new PlanMetaData.Builder()
      .bindable(true)
      .reservable(true)
      .allowInternalUsers(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .testCheckInterval(Long.valueOf("26"))
      .singleScopeInstance("testString")
      .serviceCheckEnabled(true)
      .cfGuid(java.util.Collections.singletonMap("key1", "testString"))
      .build();
    assertEquals(planMetaDataModel.bindable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.reservable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(planMetaDataModel.singleScopeInstance(), "testString");
    assertEquals(planMetaDataModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(planMetaDataModel.cfGuid(), java.util.Collections.singletonMap("key1", "testString"));

    String json = TestUtilities.serialize(planMetaDataModel);

    PlanMetaData planMetaDataModelNew = TestUtilities.deserialize(json, PlanMetaData.class);
    assertTrue(planMetaDataModelNew instanceof PlanMetaData);
    assertEquals(planMetaDataModelNew.bindable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModelNew.reservable(), Boolean.valueOf(true));
    assertEquals(planMetaDataModelNew.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(planMetaDataModelNew.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModelNew.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(planMetaDataModelNew.testCheckInterval(), Long.valueOf("26"));
    assertEquals(planMetaDataModelNew.singleScopeInstance(), "testString");
    assertEquals(planMetaDataModelNew.serviceCheckEnabled(), Boolean.valueOf(true));
  }
}