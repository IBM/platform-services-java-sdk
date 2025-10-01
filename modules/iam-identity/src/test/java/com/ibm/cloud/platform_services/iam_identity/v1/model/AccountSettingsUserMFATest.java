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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AccountSettingsUserMFA model.
 */
public class AccountSettingsUserMFATest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccountSettingsUserMFA() throws Throwable {
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .name("testString")
      .userName("testString")
      .email("testString")
      .description("testString")
      .build();
    assertEquals(accountSettingsUserMfaModel.iamId(), "testString");
    assertEquals(accountSettingsUserMfaModel.mfa(), "NONE");
    assertEquals(accountSettingsUserMfaModel.name(), "testString");
    assertEquals(accountSettingsUserMfaModel.userName(), "testString");
    assertEquals(accountSettingsUserMfaModel.email(), "testString");
    assertEquals(accountSettingsUserMfaModel.description(), "testString");

    String json = TestUtilities.serialize(accountSettingsUserMfaModel);

    AccountSettingsUserMFA accountSettingsUserMfaModelNew = TestUtilities.deserialize(json, AccountSettingsUserMFA.class);
    assertTrue(accountSettingsUserMfaModelNew instanceof AccountSettingsUserMFA);
    assertEquals(accountSettingsUserMfaModelNew.iamId(), "testString");
    assertEquals(accountSettingsUserMfaModelNew.mfa(), "NONE");
    assertEquals(accountSettingsUserMfaModelNew.name(), "testString");
    assertEquals(accountSettingsUserMfaModelNew.userName(), "testString");
    assertEquals(accountSettingsUserMfaModelNew.email(), "testString");
    assertEquals(accountSettingsUserMfaModelNew.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testAccountSettingsUserMFAError() throws Throwable {
    new AccountSettingsUserMFA.Builder().build();
  }

}