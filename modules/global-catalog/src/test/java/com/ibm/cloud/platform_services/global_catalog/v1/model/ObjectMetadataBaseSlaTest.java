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

import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSla;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseSlaDr;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ObjectMetadataBaseSla model.
 */
public class ObjectMetadataBaseSlaTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectMetadataBaseSla() throws Throwable {
    ObjectMetadataBaseSlaDr objectMetadataBaseSlaDrModel = new ObjectMetadataBaseSlaDr.Builder()
      .dr(true)
      .description("testString")
      .build();
    assertEquals(objectMetadataBaseSlaDrModel.dr(), Boolean.valueOf(true));
    assertEquals(objectMetadataBaseSlaDrModel.description(), "testString");

    ObjectMetadataBaseSla objectMetadataBaseSlaModel = new ObjectMetadataBaseSla.Builder()
      .terms("testString")
      .tenancy("testString")
      .provisioning("testString")
      .responsiveness("testString")
      .dr(objectMetadataBaseSlaDrModel)
      .build();
    assertEquals(objectMetadataBaseSlaModel.terms(), "testString");
    assertEquals(objectMetadataBaseSlaModel.tenancy(), "testString");
    assertEquals(objectMetadataBaseSlaModel.provisioning(), "testString");
    assertEquals(objectMetadataBaseSlaModel.responsiveness(), "testString");
    assertEquals(objectMetadataBaseSlaModel.dr(), objectMetadataBaseSlaDrModel);

    String json = TestUtilities.serialize(objectMetadataBaseSlaModel);

    ObjectMetadataBaseSla objectMetadataBaseSlaModelNew = TestUtilities.deserialize(json, ObjectMetadataBaseSla.class);
    assertTrue(objectMetadataBaseSlaModelNew instanceof ObjectMetadataBaseSla);
    assertEquals(objectMetadataBaseSlaModelNew.terms(), "testString");
    assertEquals(objectMetadataBaseSlaModelNew.tenancy(), "testString");
    assertEquals(objectMetadataBaseSlaModelNew.provisioning(), "testString");
    assertEquals(objectMetadataBaseSlaModelNew.responsiveness(), "testString");
    assertEquals(objectMetadataBaseSlaModelNew.dr().toString(), objectMetadataBaseSlaDrModel.toString());
  }
}