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

import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsAssignmentOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateAccountSettingsAssignmentOptions model.
 */
public class CreateAccountSettingsAssignmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateAccountSettingsAssignmentOptions() throws Throwable {
    CreateAccountSettingsAssignmentOptions createAccountSettingsAssignmentOptionsModel = new CreateAccountSettingsAssignmentOptions.Builder()
      .templateId("testString")
      .templateVersion(Long.valueOf("1"))
      .targetType("Account")
      .target("testString")
      .build();
    assertEquals(createAccountSettingsAssignmentOptionsModel.templateId(), "testString");
    assertEquals(createAccountSettingsAssignmentOptionsModel.templateVersion(), Long.valueOf("1"));
    assertEquals(createAccountSettingsAssignmentOptionsModel.targetType(), "Account");
    assertEquals(createAccountSettingsAssignmentOptionsModel.target(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountSettingsAssignmentOptionsError() throws Throwable {
    new CreateAccountSettingsAssignmentOptions.Builder().build();
  }

}