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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UpdateAccountSettingsOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateAccountSettingsOptions model.
 */
public class UpdateAccountSettingsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateAccountSettingsOptions() throws Throwable {
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();
    assertEquals(accountSettingsUserMfaModel.iamId(), "testString");
    assertEquals(accountSettingsUserMfaModel.mfa(), "NONE");

    UpdateAccountSettingsOptions updateAccountSettingsOptionsModel = new UpdateAccountSettingsOptions.Builder()
      .ifMatch("testString")
      .accountId("testString")
      .restrictCreateServiceId("RESTRICTED")
      .restrictCreatePlatformApikey("RESTRICTED")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(accountSettingsUserMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("259200")
      .build();
    assertEquals(updateAccountSettingsOptionsModel.ifMatch(), "testString");
    assertEquals(updateAccountSettingsOptionsModel.accountId(), "testString");
    assertEquals(updateAccountSettingsOptionsModel.restrictCreateServiceId(), "RESTRICTED");
    assertEquals(updateAccountSettingsOptionsModel.restrictCreatePlatformApikey(), "RESTRICTED");
    assertEquals(updateAccountSettingsOptionsModel.allowedIpAddresses(), "testString");
    assertEquals(updateAccountSettingsOptionsModel.mfa(), "NONE");
    assertEquals(updateAccountSettingsOptionsModel.userMfa(), java.util.Arrays.asList(accountSettingsUserMfaModel));
    assertEquals(updateAccountSettingsOptionsModel.sessionExpirationInSeconds(), "86400");
    assertEquals(updateAccountSettingsOptionsModel.sessionInvalidationInSeconds(), "7200");
    assertEquals(updateAccountSettingsOptionsModel.maxSessionsPerIdentity(), "testString");
    assertEquals(updateAccountSettingsOptionsModel.systemAccessTokenExpirationInSeconds(), "3600");
    assertEquals(updateAccountSettingsOptionsModel.systemRefreshTokenExpirationInSeconds(), "259200");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAccountSettingsOptionsError() throws Throwable {
    new UpdateAccountSettingsOptions.Builder().build();
  }

}