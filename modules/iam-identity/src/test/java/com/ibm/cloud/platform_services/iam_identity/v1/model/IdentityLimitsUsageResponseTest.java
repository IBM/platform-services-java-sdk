/*
 * (C) Copyright IBM Corp. 2026.
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

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccessGroupCount;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityCount;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponse;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseApikeysPerIdentity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseClaimRulesPerGroup;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseClaimRulesPerProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseCrLinksPerProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseCrRulesPerProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseServiceidsPerGroup;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdentityLimitsUsageResponseTemplateVersionsPerTemplate;
import com.ibm.cloud.platform_services.iam_identity.v1.model.LimitCount;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileCount;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ServiceIdGroupCount;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateCount;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the IdentityLimitsUsageResponse model.
 */
public class IdentityLimitsUsageResponseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testIdentityLimitsUsageResponse() throws Throwable {
    IdentityLimitsUsageResponse identityLimitsUsageResponseModel = new IdentityLimitsUsageResponse();
    assertNull(identityLimitsUsageResponseModel.getServiceidGroups());
    assertNull(identityLimitsUsageResponseModel.getServiceidsPerGroup());
    assertNull(identityLimitsUsageResponseModel.getProfiles());
    assertNull(identityLimitsUsageResponseModel.getApikeysPerIdentity());
    assertNull(identityLimitsUsageResponseModel.getProfileTemplates());
    assertNull(identityLimitsUsageResponseModel.getAccountSettingsTemplates());
    assertNull(identityLimitsUsageResponseModel.getTemplateVersionsPerTemplate());
    assertNull(identityLimitsUsageResponseModel.getIdps());
    assertNull(identityLimitsUsageResponseModel.getClaimRulesPerGroup());
    assertNull(identityLimitsUsageResponseModel.getClaimRulesPerProfile());
    assertNull(identityLimitsUsageResponseModel.getCrLinks());
    assertNull(identityLimitsUsageResponseModel.getCrLinksPerProfile());
    assertNull(identityLimitsUsageResponseModel.getCrRules());
    assertNull(identityLimitsUsageResponseModel.getCrRulesPerProfile());
  }
}