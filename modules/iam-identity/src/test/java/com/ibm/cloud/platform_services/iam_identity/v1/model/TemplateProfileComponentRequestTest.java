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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentityRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TemplateProfileComponentRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfileTemplateClaimRule;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TemplateProfileComponentRequest model.
 */
public class TemplateProfileComponentRequestTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTemplateProfileComponentRequest() throws Throwable {
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

    ProfileIdentityRequest profileIdentityRequestModel = new ProfileIdentityRequest.Builder()
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();
    assertEquals(profileIdentityRequestModel.identifier(), "testString");
    assertEquals(profileIdentityRequestModel.type(), "user");
    assertEquals(profileIdentityRequestModel.accounts(), java.util.Arrays.asList("testString"));
    assertEquals(profileIdentityRequestModel.description(), "testString");

    TemplateProfileComponentRequest templateProfileComponentRequestModel = new TemplateProfileComponentRequest.Builder()
      .name("testString")
      .description("testString")
      .email("testString")
      .rules(java.util.Arrays.asList(trustedProfileTemplateClaimRuleModel))
      .identities(java.util.Arrays.asList(profileIdentityRequestModel))
      .build();
    assertEquals(templateProfileComponentRequestModel.name(), "testString");
    assertEquals(templateProfileComponentRequestModel.description(), "testString");
    assertEquals(templateProfileComponentRequestModel.email(), "testString");
    assertEquals(templateProfileComponentRequestModel.rules(), java.util.Arrays.asList(trustedProfileTemplateClaimRuleModel));
    assertEquals(templateProfileComponentRequestModel.identities(), java.util.Arrays.asList(profileIdentityRequestModel));

    String json = TestUtilities.serialize(templateProfileComponentRequestModel);

    TemplateProfileComponentRequest templateProfileComponentRequestModelNew = TestUtilities.deserialize(json, TemplateProfileComponentRequest.class);
    assertTrue(templateProfileComponentRequestModelNew instanceof TemplateProfileComponentRequest);
    assertEquals(templateProfileComponentRequestModelNew.name(), "testString");
    assertEquals(templateProfileComponentRequestModelNew.description(), "testString");
    assertEquals(templateProfileComponentRequestModelNew.email(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testTemplateProfileComponentRequestError() throws Throwable {
    new TemplateProfileComponentRequest.Builder().build();
  }

}