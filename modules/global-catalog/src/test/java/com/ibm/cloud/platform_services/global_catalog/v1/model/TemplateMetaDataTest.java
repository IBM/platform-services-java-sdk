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

import com.ibm.cloud.platform_services.global_catalog.v1.model.SourceMetaData;
import com.ibm.cloud.platform_services.global_catalog.v1.model.TemplateMetaData;
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
 * Unit test class for the TemplateMetaData model.
 */
public class TemplateMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTemplateMetaData() throws Throwable {
    SourceMetaData sourceMetaDataModel = new SourceMetaData.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();
    assertEquals(sourceMetaDataModel.path(), "testString");
    assertEquals(sourceMetaDataModel.type(), "testString");
    assertEquals(sourceMetaDataModel.url(), "testString");

    TemplateMetaData templateMetaDataModel = new TemplateMetaData.Builder()
      .services(new ArrayList<String>(Arrays.asList("testString")))
      .defaultMemory(Long.valueOf("26"))
      .startCmd("testString")
      .source(sourceMetaDataModel)
      .runtimeCatalogId("testString")
      .cfRuntimeId("testString")
      .templateId("testString")
      .executableFile("testString")
      .buildpack("testString")
      .environmentVariables(new java.util.HashMap<String,String>(){{put("foo", "testString"); }})
      .build();
    assertEquals(templateMetaDataModel.services(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(templateMetaDataModel.defaultMemory(), Long.valueOf("26"));
    assertEquals(templateMetaDataModel.startCmd(), "testString");
    assertEquals(templateMetaDataModel.source(), sourceMetaDataModel);
    assertEquals(templateMetaDataModel.runtimeCatalogId(), "testString");
    assertEquals(templateMetaDataModel.cfRuntimeId(), "testString");
    assertEquals(templateMetaDataModel.templateId(), "testString");
    assertEquals(templateMetaDataModel.executableFile(), "testString");
    assertEquals(templateMetaDataModel.buildpack(), "testString");
    assertEquals(templateMetaDataModel.environmentVariables(), new java.util.HashMap<String,String>(){{put("foo", "testString"); }});

    String json = TestUtilities.serialize(templateMetaDataModel);

    TemplateMetaData templateMetaDataModelNew = TestUtilities.deserialize(json, TemplateMetaData.class);
    assertTrue(templateMetaDataModelNew instanceof TemplateMetaData);
    assertEquals(templateMetaDataModelNew.defaultMemory(), Long.valueOf("26"));
    assertEquals(templateMetaDataModelNew.startCmd(), "testString");
    assertEquals(templateMetaDataModelNew.source().toString(), sourceMetaDataModel.toString());
    assertEquals(templateMetaDataModelNew.runtimeCatalogId(), "testString");
    assertEquals(templateMetaDataModelNew.cfRuntimeId(), "testString");
    assertEquals(templateMetaDataModelNew.templateId(), "testString");
    assertEquals(templateMetaDataModelNew.executableFile(), "testString");
    assertEquals(templateMetaDataModelNew.buildpack(), "testString");
  }
}