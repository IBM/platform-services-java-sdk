/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.platform_services.posture_management.v1.model;

import com.ibm.cloud.platform_services.posture_management.v1.model.CreateValidationScanOptions;
import com.ibm.cloud.platform_services.posture_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateValidationScanOptions model.
 */
public class CreateValidationScanOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateValidationScanOptions() throws Throwable {
    CreateValidationScanOptions createValidationScanOptionsModel = new CreateValidationScanOptions.Builder()
      .accountId("testString")
      .scopeId(Long.valueOf("1"))
      .profileId(Long.valueOf("6"))
      .groupProfileId(Long.valueOf("13"))
      .build();
    assertEquals(createValidationScanOptionsModel.accountId(), "testString");
    assertEquals(createValidationScanOptionsModel.scopeId(), Long.valueOf("1"));
    assertEquals(createValidationScanOptionsModel.profileId(), Long.valueOf("6"));
    assertEquals(createValidationScanOptionsModel.groupProfileId(), Long.valueOf("13"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateValidationScanOptionsError() throws Throwable {
    new CreateValidationScanOptions.Builder().build();
  }

}