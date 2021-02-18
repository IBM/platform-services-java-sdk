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

package com.ibm.cloud.platform_services.global_catalog.v1.model;

import com.ibm.cloud.platform_services.global_catalog.v1.model.DRMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.SLAMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SLAMetaData model.
 */
public class SLAMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSLAMetaData() throws Throwable {
    DRMetaData drMetaDataModel = new DRMetaData.Builder()
      .dr(true)
      .description("testString")
      .build();
    assertEquals(drMetaDataModel.dr(), Boolean.valueOf(true));
    assertEquals(drMetaDataModel.description(), "testString");

    SLAMetaData slaMetaDataModel = new SLAMetaData.Builder()
      .terms("testString")
      .tenancy("testString")
      .provisioning("testString")
      .responsiveness("testString")
      .dr(drMetaDataModel)
      .build();
    assertEquals(slaMetaDataModel.terms(), "testString");
    assertEquals(slaMetaDataModel.tenancy(), "testString");
    assertEquals(slaMetaDataModel.provisioning(), "testString");
    assertEquals(slaMetaDataModel.responsiveness(), "testString");
    assertEquals(slaMetaDataModel.dr(), drMetaDataModel);

    String json = TestUtilities.serialize(slaMetaDataModel);

    SLAMetaData slaMetaDataModelNew = TestUtilities.deserialize(json, SLAMetaData.class);
    assertTrue(slaMetaDataModelNew instanceof SLAMetaData);
    assertEquals(slaMetaDataModelNew.terms(), "testString");
    assertEquals(slaMetaDataModelNew.tenancy(), "testString");
    assertEquals(slaMetaDataModelNew.provisioning(), "testString");
    assertEquals(slaMetaDataModelNew.responsiveness(), "testString");
    assertEquals(slaMetaDataModelNew.dr().toString(), drMetaDataModel.toString());
  }
}