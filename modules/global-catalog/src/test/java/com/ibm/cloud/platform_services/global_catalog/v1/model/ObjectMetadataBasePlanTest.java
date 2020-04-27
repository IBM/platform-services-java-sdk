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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBasePlan;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ObjectMetadataBasePlan model.
 */
public class ObjectMetadataBasePlanTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectMetadataBasePlan() throws Throwable {
    ObjectMetadataBasePlan objectMetadataBasePlanModel = new ObjectMetadataBasePlan.Builder()
      .bindable(true)
      .reservable(true)
      .allowInternalUsers(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .testCheckInterval(Long.valueOf("26"))
      .singleScopeInstance("testString")
      .serviceCheckEnabled(true)
      .cfGuid("testString")
      .build();
    assertEquals(objectMetadataBasePlanModel.bindable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.reservable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(objectMetadataBasePlanModel.singleScopeInstance(), "testString");
    assertEquals(objectMetadataBasePlanModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModel.cfGuid(), "testString");

    String json = TestUtilities.serialize(objectMetadataBasePlanModel);

    ObjectMetadataBasePlan objectMetadataBasePlanModelNew = TestUtilities.deserialize(json, ObjectMetadataBasePlan.class);
    assertTrue(objectMetadataBasePlanModelNew instanceof ObjectMetadataBasePlan);
    assertEquals(objectMetadataBasePlanModelNew.bindable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModelNew.reservable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModelNew.allowInternalUsers(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModelNew.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModelNew.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModelNew.testCheckInterval(), Long.valueOf("26"));
    assertEquals(objectMetadataBasePlanModelNew.singleScopeInstance(), "testString");
    assertEquals(objectMetadataBasePlanModelNew.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(objectMetadataBasePlanModelNew.cfGuid(), "testString");
  }
}