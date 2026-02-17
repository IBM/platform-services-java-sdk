/*
 * (C) Copyright IBM Corp. 2025.
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
import com.ibm.cloud.platform_services.global_tagging.v1.model.QueryString;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
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

    QueryString queryStringModel = new QueryString.Builder()
      .queryString("testString")
      .build();
    assertEquals(queryStringModel.queryString(), "testString");

    AttachTagOptions attachTagOptionsModel = new AttachTagOptions.Builder()
      .tagName("testString")
      .tagNames(java.util.Arrays.asList("testString"))
      .resources(java.util.Arrays.asList(resourceModel))
      .query(queryStringModel)
      .xRequestId("testString")
      .xCorrelationId("testString")
      .accountId("testString")
      .tagType("user")
      .replace(false)
      .update(false)
      .build();
    assertEquals(attachTagOptionsModel.tagName(), "testString");
    assertEquals(attachTagOptionsModel.tagNames(), java.util.Arrays.asList("testString"));
    assertEquals(attachTagOptionsModel.resources(), java.util.Arrays.asList(resourceModel));
    assertEquals(attachTagOptionsModel.query(), queryStringModel);
    assertEquals(attachTagOptionsModel.xRequestId(), "testString");
    assertEquals(attachTagOptionsModel.xCorrelationId(), "testString");
    assertEquals(attachTagOptionsModel.accountId(), "testString");
    assertEquals(attachTagOptionsModel.tagType(), "user");
    assertEquals(attachTagOptionsModel.replace(), Boolean.valueOf(false));
    assertEquals(attachTagOptionsModel.update(), Boolean.valueOf(false));
  }
}