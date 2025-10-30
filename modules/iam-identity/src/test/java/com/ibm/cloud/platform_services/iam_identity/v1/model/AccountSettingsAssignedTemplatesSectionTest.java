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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsAssignedTemplatesSection;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserDomainRestriction;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountSettingsUserMFAResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.AssignedTemplatesAccountSettingsRestrictUserDomains;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the AccountSettingsAssignedTemplatesSection model.
 */
public class AccountSettingsAssignedTemplatesSectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testAccountSettingsAssignedTemplatesSection() throws Throwable {
    AccountSettingsAssignedTemplatesSection accountSettingsAssignedTemplatesSectionModel = new AccountSettingsAssignedTemplatesSection();
    assertNull(accountSettingsAssignedTemplatesSectionModel.getTemplateId());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getTemplateVersion());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getTemplateName());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getRestrictCreateServiceId());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getRestrictCreatePlatformApikey());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getAllowedIpAddresses());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getMfa());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getSessionExpirationInSeconds());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getSessionInvalidationInSeconds());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getMaxSessionsPerIdentity());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getSystemAccessTokenExpirationInSeconds());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getSystemRefreshTokenExpirationInSeconds());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getRestrictUserListVisibility());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getUserMfa());
    assertNull(accountSettingsAssignedTemplatesSectionModel.getRestrictUserDomains());
  }
}