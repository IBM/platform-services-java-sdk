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

import com.ibm.cloud.platform_services.case_management.v1.model.AcceptPayload;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AcceptPayload model.
 */
public class AcceptPayloadTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAcceptPayload() throws Throwable {
    AcceptPayload acceptPayloadModel = new AcceptPayload.Builder()
      .action("accept")
      .comment("testString")
      .build();
    assertEquals(acceptPayloadModel.action(), "accept");
    assertEquals(acceptPayloadModel.comment(), "testString");

    String json = TestUtilities.serialize(acceptPayloadModel);

    AcceptPayload acceptPayloadModelNew = TestUtilities.deserialize(json, AcceptPayload.class);
    assertTrue(acceptPayloadModelNew instanceof AcceptPayload);
    assertEquals(acceptPayloadModelNew.action(), "accept");
    assertEquals(acceptPayloadModelNew.comment(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAcceptPayloadError() throws Throwable {
    new AcceptPayload.Builder().build();
  }

}