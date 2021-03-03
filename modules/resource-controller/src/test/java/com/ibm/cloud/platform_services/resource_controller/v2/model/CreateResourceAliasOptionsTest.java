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

package com.ibm.cloud.platform_services.resource_controller.v2.model;

import com.ibm.cloud.platform_services.resource_controller.v2.model.CreateResourceAliasOptions;
import com.ibm.cloud.platform_services.resource_controller.v2.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateResourceAliasOptions model.
 */
public class CreateResourceAliasOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateResourceAliasOptions() throws Throwable {
    CreateResourceAliasOptions createResourceAliasOptionsModel = new CreateResourceAliasOptions.Builder()
      .name("my-alias")
      .source("a8dff6d3-d287-4668-a81d-c87c55c2656d")
      .target("crn:v1:bluemix:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5")
      .build();
    assertEquals(createResourceAliasOptionsModel.name(), "my-alias");
    assertEquals(createResourceAliasOptionsModel.source(), "a8dff6d3-d287-4668-a81d-c87c55c2656d");
    assertEquals(createResourceAliasOptionsModel.target(), "crn:v1:bluemix:public:cf:us-south:o/5e939cd5-6377-4383-b9e0-9db22cd11753::cf-space:66c8b915-101a-406c-a784-e6636676e4f5");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateResourceAliasOptionsError() throws Throwable {
    new CreateResourceAliasOptions.Builder().build();
  }

}