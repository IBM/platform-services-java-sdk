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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateApiKeyOptions model.
 */
public class CreateApiKeyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateApiKeyOptions() throws Throwable {
    CreateApiKeyOptions createApiKeyOptionsModel = new CreateApiKeyOptions.Builder()
      .name("testString")
      .iamId("testString")
      .description("testString")
      .accountId("testString")
      .apikey("testString")
      .storeValue(true)
      .supportSessions(true)
      .actionWhenLeaked("testString")
      .entityLock("false")
      .entityDisable("false")
      .build();
    assertEquals(createApiKeyOptionsModel.name(), "testString");
    assertEquals(createApiKeyOptionsModel.iamId(), "testString");
    assertEquals(createApiKeyOptionsModel.description(), "testString");
    assertEquals(createApiKeyOptionsModel.accountId(), "testString");
    assertEquals(createApiKeyOptionsModel.apikey(), "testString");
    assertEquals(createApiKeyOptionsModel.storeValue(), Boolean.valueOf(true));
    assertEquals(createApiKeyOptionsModel.supportSessions(), Boolean.valueOf(true));
    assertEquals(createApiKeyOptionsModel.actionWhenLeaked(), "testString");
    assertEquals(createApiKeyOptionsModel.entityLock(), "false");
    assertEquals(createApiKeyOptionsModel.entityDisable(), "false");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateApiKeyOptionsError() throws Throwable {
    new CreateApiKeyOptions.Builder().build();
  }

}