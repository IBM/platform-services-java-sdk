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

import com.ibm.cloud.platform_services.iam_identity.v1.model.GetServiceIdOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the GetServiceIdOptions model.
 */
public class GetServiceIdOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testGetServiceIdOptions() throws Throwable {
    GetServiceIdOptions getServiceIdOptionsModel = new GetServiceIdOptions.Builder()
      .id("testString")
      .includeHistory(false)
      .includeActivity(false)
      .showGroupId("testString")
      .build();
    assertEquals(getServiceIdOptionsModel.id(), "testString");
    assertEquals(getServiceIdOptionsModel.includeHistory(), Boolean.valueOf(false));
    assertEquals(getServiceIdOptionsModel.includeActivity(), Boolean.valueOf(false));
    assertEquals(getServiceIdOptionsModel.showGroupId(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testGetServiceIdOptionsError() throws Throwable {
    new GetServiceIdOptions.Builder().build();
  }

}