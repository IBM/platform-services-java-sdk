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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserDomainRestriction;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateAccountSettingsTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAccountSettings;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAccountSettingsRestrictUserDomains;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserMfa;
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
    UserMfa userMfaModel = new UserMfa.Builder()
      .iamId("testString")
      .mfa("NONE")
      .build();
    assertEquals(userMfaModel.iamId(), "testString");
    assertEquals(userMfaModel.mfa(), "NONE");

    AccountSettingsUserDomainRestriction accountSettingsUserDomainRestrictionModel = new AccountSettingsUserDomainRestriction.Builder()
      .realmId("IBMid")
      .invitationEmailAllowPatterns(java.util.Arrays.asList("*.*@company.com"))
      .restrictInvitation(true)
      .build();
    assertEquals(accountSettingsUserDomainRestrictionModel.realmId(), "IBMid");
    assertEquals(accountSettingsUserDomainRestrictionModel.invitationEmailAllowPatterns(), java.util.Arrays.asList("*.*@company.com"));
    assertEquals(accountSettingsUserDomainRestrictionModel.restrictInvitation(), Boolean.valueOf(true));

    TemplateAccountSettingsRestrictUserDomains templateAccountSettingsRestrictUserDomainsModel = new TemplateAccountSettingsRestrictUserDomains.Builder()
      .accountSufficient(true)
      .restrictions(java.util.Arrays.asList(accountSettingsUserDomainRestrictionModel))
      .build();
    assertEquals(templateAccountSettingsRestrictUserDomainsModel.accountSufficient(), Boolean.valueOf(true));
    assertEquals(templateAccountSettingsRestrictUserDomainsModel.restrictions(), java.util.Arrays.asList(accountSettingsUserDomainRestrictionModel));

    TemplateAccountSettings templateAccountSettingsModel = new TemplateAccountSettings.Builder()
      .restrictCreateServiceId("NOT_SET")
      .restrictCreatePlatformApikey("NOT_SET")
      .allowedIpAddresses("testString")
      .mfa("NONE")
      .userMfa(java.util.Arrays.asList(userMfaModel))
      .sessionExpirationInSeconds("86400")
      .sessionInvalidationInSeconds("7200")
      .maxSessionsPerIdentity("testString")
      .systemAccessTokenExpirationInSeconds("3600")
      .systemRefreshTokenExpirationInSeconds("259200")
      .restrictUserListVisibility("RESTRICTED")
      .restrictUserDomains(templateAccountSettingsRestrictUserDomainsModel)
      .build();
    assertEquals(templateAccountSettingsModel.restrictCreateServiceId(), "NOT_SET");
    assertEquals(templateAccountSettingsModel.restrictCreatePlatformApikey(), "NOT_SET");
    assertEquals(templateAccountSettingsModel.allowedIpAddresses(), "testString");
    assertEquals(templateAccountSettingsModel.mfa(), "NONE");
    assertEquals(templateAccountSettingsModel.userMfa(), java.util.Arrays.asList(userMfaModel));
    assertEquals(templateAccountSettingsModel.sessionExpirationInSeconds(), "86400");
    assertEquals(templateAccountSettingsModel.sessionInvalidationInSeconds(), "7200");
    assertEquals(templateAccountSettingsModel.maxSessionsPerIdentity(), "testString");
    assertEquals(templateAccountSettingsModel.systemAccessTokenExpirationInSeconds(), "3600");
    assertEquals(templateAccountSettingsModel.systemRefreshTokenExpirationInSeconds(), "259200");
    assertEquals(templateAccountSettingsModel.restrictUserListVisibility(), "RESTRICTED");
    assertEquals(templateAccountSettingsModel.restrictUserDomains(), templateAccountSettingsRestrictUserDomainsModel);

    CreateAccountSettingsTemplateVersionOptions createAccountSettingsTemplateVersionOptionsModel = new CreateAccountSettingsTemplateVersionOptions.Builder()
      .templateId("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .accountSettings(templateAccountSettingsModel)
      .build();
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.templateId(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.accountId(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.name(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.description(), "testString");
    assertEquals(createAccountSettingsTemplateVersionOptionsModel.accountSettings(), templateAccountSettingsModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateAccountSettingsTemplateVersionOptionsError() throws Throwable {
    new CreateAccountSettingsTemplateVersionOptions.Builder().build();
  }

}