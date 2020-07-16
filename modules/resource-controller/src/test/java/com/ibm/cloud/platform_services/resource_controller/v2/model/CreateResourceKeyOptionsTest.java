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

package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceKeyOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.model.ResourceKeyPostParameters;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateResourceKeyOptions model.
 */
public class CreateResourceKeyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateResourceKeyOptions() throws Throwable {
    ResourceKeyPostParameters resourceKeyPostParametersModel = new ResourceKeyPostParameters.Builder()
      .serviceidCrn("crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393")
      .build();
    assertEquals(resourceKeyPostParametersModel.serviceidCrn(), "crn:v1:bluemix:public:iam-identity::a/9fceaa56d1ab84893af6b9eec5ab81bb::serviceid:ServiceId-fe4c29b5-db13-410a-bacc-b5779a03d393");

    CreateResourceKeyOptions createResourceKeyOptionsModel = new CreateResourceKeyOptions.Builder()
      .name("my-key")
      .source("25eba2a9-beef-450b-82cf-f5ad5e36c6dd")
      .parameters(resourceKeyPostParametersModel)
      .role("Writer")
      .build();
    assertEquals(createResourceKeyOptionsModel.name(), "my-key");
    assertEquals(createResourceKeyOptionsModel.source(), "25eba2a9-beef-450b-82cf-f5ad5e36c6dd");
    assertEquals(createResourceKeyOptionsModel.parameters(), resourceKeyPostParametersModel);
    assertEquals(createResourceKeyOptionsModel.role(), "Writer");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceKeyOptionsError() throws Throwable {
    new CreateResourceKeyOptions.Builder().build();
  }

}