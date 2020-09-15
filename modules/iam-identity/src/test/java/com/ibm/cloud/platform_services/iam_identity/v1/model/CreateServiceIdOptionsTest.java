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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateApiKeyRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateServiceIdOptions model.
 */
public class CreateServiceIdOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateServiceIdOptions() throws Throwable {
    CreateApiKeyRequest createApiKeyRequestModel = new CreateApiKeyRequest.Builder()
      .name("testString")
      .description("testString")
      .iamId("testString")
      .accountId("testString")
      .apikey("testString")
      .storeValue(true)
      .build();
    assertEquals(createApiKeyRequestModel.name(), "testString");
    assertEquals(createApiKeyRequestModel.description(), "testString");
    assertEquals(createApiKeyRequestModel.iamId(), "testString");
    assertEquals(createApiKeyRequestModel.accountId(), "testString");
    assertEquals(createApiKeyRequestModel.apikey(), "testString");
    assertEquals(createApiKeyRequestModel.storeValue(), Boolean.valueOf(true));

    CreateServiceIdOptions createServiceIdOptionsModel = new CreateServiceIdOptions.Builder()
      .accountId("testString")
      .name("testString")
      .description("testString")
      .uniqueInstanceCrns(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .apikey(createApiKeyRequestModel)
      .entityLock("testString")
      .build();
    assertEquals(createServiceIdOptionsModel.accountId(), "testString");
    assertEquals(createServiceIdOptionsModel.name(), "testString");
    assertEquals(createServiceIdOptionsModel.description(), "testString");
    assertEquals(createServiceIdOptionsModel.uniqueInstanceCrns(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(createServiceIdOptionsModel.apikey(), createApiKeyRequestModel);
    assertEquals(createServiceIdOptionsModel.entityLock(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateServiceIdOptionsError() throws Throwable {
    new CreateServiceIdOptions.Builder().build();
  }

}