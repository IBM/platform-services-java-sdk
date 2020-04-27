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

import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseService;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ObjectMetadataBaseService model.
 */
public class ObjectMetadataBaseServiceTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectMetadataBaseService() throws Throwable {
    ObjectMetadataBaseService objectMetadataBaseServiceModel = new ObjectMetadataBaseService.Builder()
      .type("testString")
      .iamCompatible(true)
      .uniqueApiKey(true)
      .provisionable(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .cfGuid("testString")
      .bindable(true)
      .requires(new ArrayList<String>(Arrays.asList("testString")))
      .planUpdateable(true)
      .state("testString")
      .serviceCheckEnabled(true)
      .testCheckInterval(Long.valueOf("26"))
      .serviceKeySupported(true)
      .build();
    assertEquals(objectMetadataBaseServiceModel.type(), "testString");
    assertEquals(objectMetadataBaseServiceModel.iamCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.provisionable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.cfGuid(), "testString");
    assertEquals(objectMetadataBaseServiceModel.bindable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.requires(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(objectMetadataBaseServiceModel.planUpdateable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.state(), "testString");
    assertEquals(objectMetadataBaseServiceModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(objectMetadataBaseServiceModel.serviceKeySupported(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(objectMetadataBaseServiceModel);

    ObjectMetadataBaseService objectMetadataBaseServiceModelNew = TestUtilities.deserialize(json, ObjectMetadataBaseService.class);
    assertTrue(objectMetadataBaseServiceModelNew instanceof ObjectMetadataBaseService);
    assertEquals(objectMetadataBaseServiceModelNew.type(), "testString");
    assertEquals(objectMetadataBaseServiceModelNew.iamCompatible(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.provisionable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.cfGuid(), "testString");
    assertEquals(objectMetadataBaseServiceModelNew.bindable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.planUpdateable(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.state(), "testString");
    assertEquals(objectMetadataBaseServiceModelNew.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseServiceModelNew.testCheckInterval(), Long.valueOf("26"));
    assertEquals(objectMetadataBaseServiceModelNew.serviceKeySupported(), Boolean.valueOf(true));
  }
}