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
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateAccountSettingsRestrictUserDomains;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TemplateAccountSettingsRestrictUserDomains model.
 */
public class TemplateAccountSettingsRestrictUserDomainsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTemplateAccountSettingsRestrictUserDomains() throws Throwable {
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

    String json = TestUtilities.serialize(templateAccountSettingsRestrictUserDomainsModel);

    TemplateAccountSettingsRestrictUserDomains templateAccountSettingsRestrictUserDomainsModelNew = TestUtilities.deserialize(json, TemplateAccountSettingsRestrictUserDomains.class);
    assertTrue(templateAccountSettingsRestrictUserDomainsModelNew instanceof TemplateAccountSettingsRestrictUserDomains);
    assertEquals(templateAccountSettingsRestrictUserDomainsModelNew.accountSufficient(), Boolean.valueOf(true));
  }
}