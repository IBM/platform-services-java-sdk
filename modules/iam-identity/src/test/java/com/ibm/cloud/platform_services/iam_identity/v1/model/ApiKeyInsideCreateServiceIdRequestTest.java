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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ApiKeyInsideCreateServiceIdRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ApiKeyInsideCreateServiceIdRequest model.
 */
public class ApiKeyInsideCreateServiceIdRequestTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testApiKeyInsideCreateServiceIdRequest() throws Throwable {
    ApiKeyInsideCreateServiceIdRequest apiKeyInsideCreateServiceIdRequestModel = new ApiKeyInsideCreateServiceIdRequest.Builder()
      .name("testString")
      .description("testString")
      .apikey("testString")
      .storeValue(true)
      .build();
    assertEquals(apiKeyInsideCreateServiceIdRequestModel.name(), "testString");
    assertEquals(apiKeyInsideCreateServiceIdRequestModel.description(), "testString");
    assertEquals(apiKeyInsideCreateServiceIdRequestModel.apikey(), "testString");
    assertEquals(apiKeyInsideCreateServiceIdRequestModel.storeValue(), Boolean.valueOf(true));

    String json = TestUtilities.serialize(apiKeyInsideCreateServiceIdRequestModel);

    ApiKeyInsideCreateServiceIdRequest apiKeyInsideCreateServiceIdRequestModelNew = TestUtilities.deserialize(json, ApiKeyInsideCreateServiceIdRequest.class);
    assertTrue(apiKeyInsideCreateServiceIdRequestModelNew instanceof ApiKeyInsideCreateServiceIdRequest);
    assertEquals(apiKeyInsideCreateServiceIdRequestModelNew.name(), "testString");
    assertEquals(apiKeyInsideCreateServiceIdRequestModelNew.description(), "testString");
    assertEquals(apiKeyInsideCreateServiceIdRequestModelNew.apikey(), "testString");
    assertEquals(apiKeyInsideCreateServiceIdRequestModelNew.storeValue(), Boolean.valueOf(true));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testApiKeyInsideCreateServiceIdRequestError() throws Throwable {
    new ApiKeyInsideCreateServiceIdRequest.Builder().build();
  }

}