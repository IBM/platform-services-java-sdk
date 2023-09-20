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

package com.ibm.cloud.platform_services.global_tagging.v1.model;

import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the DetachTagOptions model.
 */
public class DetachTagOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testDetachTagOptions() throws Throwable {
    Resource resourceModel = new Resource.Builder()
      .resourceId("testString")
      .resourceType("testString")
      .build();
    assertEquals(resourceModel.resourceId(), "testString");
    assertEquals(resourceModel.resourceType(), "testString");

    DetachTagOptions detachTagOptionsModel = new DetachTagOptions.Builder()
      .resources(java.util.Arrays.asList(resourceModel))
      .tagName("testString")
      .tagNames(java.util.Arrays.asList("testString"))
      .xRequestId("testString")
      .xCorrelationId("testString")
      .transactionId("testString")
      .impersonateUser("testString")
      .accountId("testString")
      .tagType("user")
      .build();
    assertEquals(detachTagOptionsModel.resources(), java.util.Arrays.asList(resourceModel));
    assertEquals(detachTagOptionsModel.tagName(), "testString");
    assertEquals(detachTagOptionsModel.tagNames(), java.util.Arrays.asList("testString"));
    assertEquals(detachTagOptionsModel.xRequestId(), "testString");
    assertEquals(detachTagOptionsModel.xCorrelationId(), "testString");
    assertEquals(detachTagOptionsModel.transactionId(), "testString");
    assertEquals(detachTagOptionsModel.impersonateUser(), "testString");
    assertEquals(detachTagOptionsModel.accountId(), "testString");
    assertEquals(detachTagOptionsModel.tagType(), "user");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testDetachTagOptionsError() throws Throwable {
    new DetachTagOptions.Builder().build();
  }

}