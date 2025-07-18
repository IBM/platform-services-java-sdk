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

import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateServiceIdGroupOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateServiceIdGroupOptions model.
 */
public class UpdateServiceIdGroupOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateServiceIdGroupOptions() throws Throwable {
    UpdateServiceIdGroupOptions updateServiceIdGroupOptionsModel = new UpdateServiceIdGroupOptions.Builder()
      .id("testString")
      .ifMatch("testString")
      .name("testString")
      .description("testString")
      .build();
    assertEquals(updateServiceIdGroupOptionsModel.id(), "testString");
    assertEquals(updateServiceIdGroupOptionsModel.ifMatch(), "testString");
    assertEquals(updateServiceIdGroupOptionsModel.name(), "testString");
    assertEquals(updateServiceIdGroupOptionsModel.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateServiceIdGroupOptionsError() throws Throwable {
    new UpdateServiceIdGroupOptions.Builder().build();
  }

}