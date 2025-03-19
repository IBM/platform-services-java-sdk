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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ExternalAccountIdentityInteractionPatch;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.IdentityTypesBase;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.IdentityTypesPatch;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.UpdateSettingsOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateSettingsOptions model.
 */
public class UpdateSettingsOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateSettingsOptions() throws Throwable {
    IdentityTypesBase identityTypesBaseModel = new IdentityTypesBase.Builder()
      .state("enabled")
      .externalAllowedAccounts(java.util.Arrays.asList("testString"))
      .build();
    assertEquals(identityTypesBaseModel.state(), "enabled");
    assertEquals(identityTypesBaseModel.externalAllowedAccounts(), java.util.Arrays.asList("testString"));

    IdentityTypesPatch identityTypesPatchModel = new IdentityTypesPatch.Builder()
      .user(identityTypesBaseModel)
      .serviceId(identityTypesBaseModel)
      .service(identityTypesBaseModel)
      .build();
    assertEquals(identityTypesPatchModel.user(), identityTypesBaseModel);
    assertEquals(identityTypesPatchModel.serviceId(), identityTypesBaseModel);
    assertEquals(identityTypesPatchModel.service(), identityTypesBaseModel);

    ExternalAccountIdentityInteractionPatch externalAccountIdentityInteractionPatchModel = new ExternalAccountIdentityInteractionPatch.Builder()
      .identityTypes(identityTypesPatchModel)
      .build();
    assertEquals(externalAccountIdentityInteractionPatchModel.identityTypes(), identityTypesPatchModel);

    UpdateSettingsOptions updateSettingsOptionsModel = new UpdateSettingsOptions.Builder()
      .accountId("testString")
      .ifMatch("testString")
      .externalAccountIdentityInteraction(externalAccountIdentityInteractionPatchModel)
      .acceptLanguage("default")
      .build();
    assertEquals(updateSettingsOptionsModel.accountId(), "testString");
    assertEquals(updateSettingsOptionsModel.ifMatch(), "testString");
    assertEquals(updateSettingsOptionsModel.externalAccountIdentityInteraction(), externalAccountIdentityInteractionPatchModel);
    assertEquals(updateSettingsOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateSettingsOptionsError() throws Throwable {
    new UpdateSettingsOptions.Builder().build();
  }

}