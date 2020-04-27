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

import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplate;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateEnvironmentVariables;
import com.ibm.cloud.platform_services.global_catalog.v1.model.ObjectMetadataBaseTemplateSource;
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
 * Unit test class for the ObjectMetadataBaseTemplate model.
 */
public class ObjectMetadataBaseTemplateTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testObjectMetadataBaseTemplate() throws Throwable {
    ObjectMetadataBaseTemplateEnvironmentVariables objectMetadataBaseTemplateEnvironmentVariablesModel = new ObjectMetadataBaseTemplateEnvironmentVariables.Builder()
      .key("testString")
      .build();
    assertEquals(objectMetadataBaseTemplateEnvironmentVariablesModel.key(), "testString");

    ObjectMetadataBaseTemplateSource objectMetadataBaseTemplateSourceModel = new ObjectMetadataBaseTemplateSource.Builder()
      .path("testString")
      .type("testString")
      .url("testString")
      .build();
    assertEquals(objectMetadataBaseTemplateSourceModel.path(), "testString");
    assertEquals(objectMetadataBaseTemplateSourceModel.type(), "testString");
    assertEquals(objectMetadataBaseTemplateSourceModel.url(), "testString");

    ObjectMetadataBaseTemplate objectMetadataBaseTemplateModel = new ObjectMetadataBaseTemplate.Builder()
      .services(new ArrayList<String>(Arrays.asList("testString")))
      .defaultMemory(Long.valueOf("26"))
      .startCmd("testString")
      .source(objectMetadataBaseTemplateSourceModel)
      .runtimeCatalogId("testString")
      .cfRuntimeId("testString")
      .templateId("testString")
      .executableFile("testString")
      .buildpack("testString")
      .environmentVariables(objectMetadataBaseTemplateEnvironmentVariablesModel)
      .build();
    assertEquals(objectMetadataBaseTemplateModel.services(), new ArrayList<String>(Arrays.asList("testString")));
    assertEquals(objectMetadataBaseTemplateModel.defaultMemory(), Long.valueOf("26"));
    assertEquals(objectMetadataBaseTemplateModel.startCmd(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.source(), objectMetadataBaseTemplateSourceModel);
    assertEquals(objectMetadataBaseTemplateModel.runtimeCatalogId(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.cfRuntimeId(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.templateId(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.executableFile(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.buildpack(), "testString");
    assertEquals(objectMetadataBaseTemplateModel.environmentVariables(), objectMetadataBaseTemplateEnvironmentVariablesModel);

    String json = TestUtilities.serialize(objectMetadataBaseTemplateModel);

    ObjectMetadataBaseTemplate objectMetadataBaseTemplateModelNew = TestUtilities.deserialize(json, ObjectMetadataBaseTemplate.class);
    assertTrue(objectMetadataBaseTemplateModelNew instanceof ObjectMetadataBaseTemplate);
    assertEquals(objectMetadataBaseTemplateModelNew.defaultMemory(), Long.valueOf("26"));
    assertEquals(objectMetadataBaseTemplateModelNew.startCmd(), "testString");
    assertEquals(objectMetadataBaseTemplateModelNew.source().toString(), objectMetadataBaseTemplateSourceModel.toString());
    assertEquals(objectMetadataBaseTemplateModelNew.runtimeCatalogId(), "testString");
    assertEquals(objectMetadataBaseTemplateModelNew.cfRuntimeId(), "testString");
    assertEquals(objectMetadataBaseTemplateModelNew.templateId(), "testString");
    assertEquals(objectMetadataBaseTemplateModelNew.executableFile(), "testString");
    assertEquals(objectMetadataBaseTemplateModelNew.buildpack(), "testString");
    assertEquals(objectMetadataBaseTemplateModelNew.environmentVariables().toString(), objectMetadataBaseTemplateEnvironmentVariablesModel.toString());
  }
}