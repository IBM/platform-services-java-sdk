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

package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.platform_services.case_management.v1.model.ResourcePayload;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResourcePayload model.
 */
public class ResourcePayloadTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResourcePayload() throws Throwable {
    ResourcePayload resourcePayloadModel = new ResourcePayload.Builder()
      .crn("testString")
      .type("testString")
      .id(Double.valueOf("72.5"))
      .note("testString")
      .build();
    assertEquals(resourcePayloadModel.crn(), "testString");
    assertEquals(resourcePayloadModel.type(), "testString");
    assertEquals(resourcePayloadModel.id(), Double.valueOf("72.5"));
    assertEquals(resourcePayloadModel.note(), "testString");

    String json = TestUtilities.serialize(resourcePayloadModel);

    ResourcePayload resourcePayloadModelNew = TestUtilities.deserialize(json, ResourcePayload.class);
    assertTrue(resourcePayloadModelNew instanceof ResourcePayload);
    assertEquals(resourcePayloadModelNew.crn(), "testString");
    assertEquals(resourcePayloadModelNew.type(), "testString");
    assertEquals(resourcePayloadModelNew.id(), Double.valueOf("72.5"));
    assertEquals(resourcePayloadModelNew.note(), "testString");
  }
}