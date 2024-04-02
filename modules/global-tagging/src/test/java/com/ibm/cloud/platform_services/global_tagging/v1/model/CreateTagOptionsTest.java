/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateTagOptions model.
 */
public class CreateTagOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateTagOptions() throws Throwable {
    CreateTagOptions createTagOptionsModel = new CreateTagOptions.Builder()
      .tagNames(java.util.Arrays.asList("testString"))
      .xRequestId("testString")
      .xCorrelationId("testString")
      .accountId("testString")
      .tagType("access")
      .build();
    assertEquals(createTagOptionsModel.tagNames(), java.util.Arrays.asList("testString"));
    assertEquals(createTagOptionsModel.xRequestId(), "testString");
    assertEquals(createTagOptionsModel.xCorrelationId(), "testString");
    assertEquals(createTagOptionsModel.accountId(), "testString");
    assertEquals(createTagOptionsModel.tagType(), "access");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateTagOptionsError() throws Throwable {
    new CreateTagOptions.Builder().build();
  }

}