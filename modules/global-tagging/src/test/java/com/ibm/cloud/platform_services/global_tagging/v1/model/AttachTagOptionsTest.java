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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AttachTagOptions model.
 */
public class AttachTagOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAttachTagOptions() throws Throwable {
    Resource resourceModel = new Resource.Builder()
      .resourceId("testString")
      .resourceType("testString")
      .build();
    assertEquals(resourceModel.resourceId(), "testString");
    assertEquals(resourceModel.resourceType(), "testString");

    AttachTagOptions attachTagOptionsModel = new AttachTagOptions.Builder()
      .resources(new ArrayList<Resource>(Arrays.asList(resourceModel)))
      .tagName("testString")
      .tagNames(new ArrayList<String>(Arrays.asList("testString")))
      .build();
    assertEquals(attachTagOptionsModel.resources(), new ArrayList<Resource>(Arrays.asList(resourceModel)));
    assertEquals(attachTagOptionsModel.tagName(), "testString");
    assertEquals(attachTagOptionsModel.tagNames(), new ArrayList<String>(Arrays.asList("testString")));
  }
  
  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAttachTagOptionsError() throws Throwable {
    new AttachTagOptions.Builder().build();
  }

}