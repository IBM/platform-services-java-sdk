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

import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateAccountSettingsAssignmentOptions model.
 */
public class UpdateAccountSettingsAssignmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateAccountSettingsAssignmentOptions() throws Throwable {
    UpdateAccountSettingsAssignmentOptions updateAccountSettingsAssignmentOptionsModel = new UpdateAccountSettingsAssignmentOptions.Builder()
      .assignmentId("testString")
      .ifMatch("testString")
      .templateVersion(Long.valueOf("1"))
      .build();
    assertEquals(updateAccountSettingsAssignmentOptionsModel.assignmentId(), "testString");
    assertEquals(updateAccountSettingsAssignmentOptionsModel.ifMatch(), "testString");
    assertEquals(updateAccountSettingsAssignmentOptionsModel.templateVersion(), Long.valueOf("1"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsAssignmentOptionsError() throws Throwable {
    new UpdateAccountSettingsAssignmentOptions.Builder().build();
  }

}