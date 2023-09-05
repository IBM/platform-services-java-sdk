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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TrustedProfileTemplateClaimRule model.
 */
public class TrustedProfileTemplateClaimRuleTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTrustedProfileTemplateClaimRule() throws Throwable {
    ProfileClaimRuleConditions profileClaimRuleConditionsModel = new ProfileClaimRuleConditions.Builder()
      .claim("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(profileClaimRuleConditionsModel.claim(), "testString");
    assertEquals(profileClaimRuleConditionsModel.operator(), "testString");
    assertEquals(profileClaimRuleConditionsModel.value(), "testString");

    TrustedProfileTemplateClaimRule trustedProfileTemplateClaimRuleModel = new TrustedProfileTemplateClaimRule.Builder()
      .name("testString")
      .type("Profile-SAML")
      .realmName("testString")
      .expiration(Long.valueOf("26"))
      .conditions(java.util.Arrays.asList(profileClaimRuleConditionsModel))
      .build();
    assertEquals(trustedProfileTemplateClaimRuleModel.name(), "testString");
    assertEquals(trustedProfileTemplateClaimRuleModel.type(), "Profile-SAML");
    assertEquals(trustedProfileTemplateClaimRuleModel.realmName(), "testString");
    assertEquals(trustedProfileTemplateClaimRuleModel.expiration(), Long.valueOf("26"));
    assertEquals(trustedProfileTemplateClaimRuleModel.conditions(), java.util.Arrays.asList(profileClaimRuleConditionsModel));

    String json = TestUtilities.serialize(trustedProfileTemplateClaimRuleModel);

    TrustedProfileTemplateClaimRule trustedProfileTemplateClaimRuleModelNew = TestUtilities.deserialize(json, TrustedProfileTemplateClaimRule.class);
    assertTrue(trustedProfileTemplateClaimRuleModelNew instanceof TrustedProfileTemplateClaimRule);
    assertEquals(trustedProfileTemplateClaimRuleModelNew.name(), "testString");
    assertEquals(trustedProfileTemplateClaimRuleModelNew.type(), "Profile-SAML");
    assertEquals(trustedProfileTemplateClaimRuleModelNew.realmName(), "testString");
    assertEquals(trustedProfileTemplateClaimRuleModelNew.expiration(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTrustedProfileTemplateClaimRuleError() throws Throwable {
    new TrustedProfileTemplateClaimRule.Builder().build();
  }

}