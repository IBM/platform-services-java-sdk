/*
 * (C) Copyright IBM Corp. 2023.
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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ResponseContext model.
 */
public class ResponseContextTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testResponseContext() throws Throwable {
    ResponseContext responseContextModel = new ResponseContext.Builder()
      .transactionId("testString")
      .operation("testString")
      .userAgent("testString")
      .url("testString")
      .instanceId("testString")
      .threadId("testString")
      .host("testString")
      .startTime("testString")
      .endTime("testString")
      .elapsedTime("testString")
      .clusterName("testString")
      .build();
    assertEquals(responseContextModel.transactionId(), "testString");
    assertEquals(responseContextModel.operation(), "testString");
    assertEquals(responseContextModel.userAgent(), "testString");
    assertEquals(responseContextModel.url(), "testString");
    assertEquals(responseContextModel.instanceId(), "testString");
    assertEquals(responseContextModel.threadId(), "testString");
    assertEquals(responseContextModel.host(), "testString");
    assertEquals(responseContextModel.startTime(), "testString");
    assertEquals(responseContextModel.endTime(), "testString");
    assertEquals(responseContextModel.elapsedTime(), "testString");
    assertEquals(responseContextModel.clusterName(), "testString");

    String json = TestUtilities.serialize(responseContextModel);

    ResponseContext responseContextModelNew = TestUtilities.deserialize(json, ResponseContext.class);
    assertTrue(responseContextModelNew instanceof ResponseContext);
    assertEquals(responseContextModelNew.transactionId(), "testString");
    assertEquals(responseContextModelNew.operation(), "testString");
    assertEquals(responseContextModelNew.userAgent(), "testString");
    assertEquals(responseContextModelNew.url(), "testString");
    assertEquals(responseContextModelNew.instanceId(), "testString");
    assertEquals(responseContextModelNew.threadId(), "testString");
    assertEquals(responseContextModelNew.host(), "testString");
    assertEquals(responseContextModelNew.startTime(), "testString");
    assertEquals(responseContextModelNew.endTime(), "testString");
    assertEquals(responseContextModelNew.elapsedTime(), "testString");
    assertEquals(responseContextModelNew.clusterName(), "testString");
  }
}