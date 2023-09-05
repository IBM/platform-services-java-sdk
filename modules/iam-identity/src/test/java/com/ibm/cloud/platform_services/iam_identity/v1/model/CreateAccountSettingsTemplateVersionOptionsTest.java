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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsComponent;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFA;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateAccountSettingsTemplateVersionOptions model.
 */
public class CreateAccountSettingsTemplateVersionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateAccountSettingsTemplateVersionOptions() throws Throwable {
    AccountSettingsUserMFA accountSettingsUserMfaModel = new AccountSettingsUserMFA.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();
    assertEquals(accountSettingsUserMfaModel.iamId(), "testString");
    assertEquals(accountSettingsUserMfaModel.mfa(), "NONE");

    AccountSettingsComponent accountSettingsComponentModel = new AccountSettingsComponent.Builder()
      .restrictCreateServiceId("NOT_SET")
      .restrictCreatePlatformApikey("NOT_SET")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(accountSettingsUserMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("259200")
      .build();
    assertEquals(accountSettingsComponentModel.restrictCreateServiceId(), "NOT_SET");
    assertEquals(accountSettingsComponentModel.restrictCreatePlatformApikey(), "NOT_SET");
    assertEquals(accountSettingsComponentModel.allowedIpAddresses(), "testString");
    assertEquals(accountSettingsComponentModel.mfa(), "NONE");
    assertEquals(accountSettingsComponentModel.userMfa(), java.util.Arrays.asList(accountSettingsUserMfaModel));
    assertEquals(accountSettingsComponentModel.sessionExpirationInSeconds(), "86400");
    assertEquals(accountSettingsComponentModel.sessionInvalidationInSeconds(), "7200");
    assertEquals(accountSettingsComponentModel.maxSessionsPerIdentity(), "testString");
    assertEquals(accountSettingsComponentModel.systemAccessTokenExpirationInSeconds(), "3600");
    assertEquals(accountSettingsComponentModel.systemRefreshTokenExpirationInSeconds(), "259200");

    CreateAccountSettingsTemplateVersionOptions createAccountSettingsTemplateVersionOptionsModel = new CreateAccountSettingsTemplateVersionOptions.Builder()
      .templateId("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .accountSettings(accountSettingsComponentModel)
      .build();
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.templateId(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.accountId(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.name(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.description(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.accountSettings(), accountSettingsComponentModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountSettingsTemplateVersionOptionsError() throws Throwable {
    new CreateAccountSettingsTemplateVersionOptions.Builder().build();
  }

}