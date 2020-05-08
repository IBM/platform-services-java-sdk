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

import com.ibm.cloud.platform_services.global_catalog.v1.model.DRMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DRMetaData model.
 */
public class DRMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDRMetaData() throws Throwable {
    DRMetaData drMetaDataModel = new DRMetaData.Builder()
      .dr(true)
      .description("testString")
      .build();
    assertEquals(drMetaDataModel.dr(), Boolean.valueOf(true));
    assertEquals(drMetaDataModel.description(), "testString");

    String json = TestUtilities.serialize(drMetaDataModel);

    DRMetaData drMetaDataModelNew = TestUtilities.deserialize(json, DRMetaData.class);
    assertTrue(drMetaDataModelNew instanceof DRMetaData);
    assertEquals(drMetaDataModelNew.dr(), Boolean.valueOf(true));
    assertEquals(drMetaDataModelNew.description(), "testString");
  }
}