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

import com.ibm.cloud.platform_services.global_catalog.v1.model.CFMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CFMetaData model.
 */
public class CFMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCFMetaData() throws Throwable {
    CFMetaData cfMetaDataModel = new CFMetaData.Builder()
      .type("testString")
      .iamCompatible(true)
      .uniqueApiKey(true)
      .provisionable(true)
      .bindable(true)
      .asyncProvisioningSupported(true)
      .asyncUnprovisioningSupported(true)
      .requires(java.util.Arrays.asList("testString"))
      .planUpdateable(true)
      .state("testString")
      .serviceCheckEnabled(true)
      .testCheckInterval(Long.valueOf("26"))
      .serviceKeySupported(true)
      .cfGuid(java.util.Collections.singletonMap("key1", "testString"))
      .build();
    assertEquals(cfMetaDataModel.type(), "testString");
    assertEquals(cfMetaDataModel.iamCompatible(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.provisionable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.bindable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.requires(), java.util.Arrays.asList("testString"));
    assertEquals(cfMetaDataModel.planUpdateable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.state(), "testString");
    assertEquals(cfMetaDataModel.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.testCheckInterval(), Long.valueOf("26"));
    assertEquals(cfMetaDataModel.serviceKeySupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModel.cfGuid(), java.util.Collections.singletonMap("key1", "testString"));

    String json = TestUtilities.serialize(cfMetaDataModel);

    CFMetaData cfMetaDataModelNew = TestUtilities.deserialize(json, CFMetaData.class);
    assertTrue(cfMetaDataModelNew instanceof CFMetaData);
    assertEquals(cfMetaDataModelNew.type(), "testString");
    assertEquals(cfMetaDataModelNew.iamCompatible(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.uniqueApiKey(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.provisionable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.bindable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.asyncProvisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.asyncUnprovisioningSupported(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.planUpdateable(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.state(), "testString");
    assertEquals(cfMetaDataModelNew.serviceCheckEnabled(), Boolean.valueOf(true));
    assertEquals(cfMetaDataModelNew.testCheckInterval(), Long.valueOf("26"));
    assertEquals(cfMetaDataModelNew.serviceKeySupported(), Boolean.valueOf(true));
  }
}