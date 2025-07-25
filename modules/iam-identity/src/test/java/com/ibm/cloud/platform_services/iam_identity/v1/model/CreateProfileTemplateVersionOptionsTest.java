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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControls;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsIdentities;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsPolicies;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ActionControlsRules;
import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateProfileTemplateVersionOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.PolicyTemplateReference;
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
 * Unit test class for the CreateProfileTemplateVersionOptions model.
 */
public class CreateProfileTemplateVersionOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateProfileTemplateVersionOptions() throws Throwable {
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

    PolicyTemplateReference policyTemplateReferenceModel = new PolicyTemplateReference.Builder()
      .id("testString")
      .version("testString")
      .build();
    assertEquals(policyTemplateReferenceModel.id(), "testString");
    assertEquals(policyTemplateReferenceModel.version(), "testString");

    ActionControlsIdentities actionControlsIdentitiesModel = new ActionControlsIdentities.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsIdentitiesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsIdentitiesModel.remove(), Boolean.valueOf(true));

    ActionControlsRules actionControlsRulesModel = new ActionControlsRules.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsRulesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsRulesModel.remove(), Boolean.valueOf(true));

    ActionControlsPolicies actionControlsPoliciesModel = new ActionControlsPolicies.Builder()
      .add(true)
      .remove(true)
      .build();
    assertEquals(actionControlsPoliciesModel.add(), Boolean.valueOf(true));
    assertEquals(actionControlsPoliciesModel.remove(), Boolean.valueOf(true));

    ActionControls actionControlsModel = new ActionControls.Builder()
      .identities(actionControlsIdentitiesModel)
      .rules(actionControlsRulesModel)
      .policies(actionControlsPoliciesModel)
      .build();
    assertEquals(actionControlsModel.identities(), actionControlsIdentitiesModel);
    assertEquals(actionControlsModel.rules(), actionControlsRulesModel);
    assertEquals(actionControlsModel.policies(), actionControlsPoliciesModel);

    CreateProfileTemplateVersionOptions createProfileTemplateVersionOptionsModel = new CreateProfileTemplateVersionOptions.Builder()
      .templateId("testString")
      .accountId("testString")
      .name("testString")
      .description("testString")
      .profile(templateProfileComponentRequestModel)
      .policyTemplateReferences(java.util.Arrays.asList(policyTemplateReferenceModel))
      .actionControls(actionControlsModel)
      .build();
    assertEquals(createProfileTemplateVersionOptionsModel.templateId(), "testString");
    assertEquals(createProfileTemplateVersionOptionsModel.accountId(), "testString");
    assertEquals(createProfileTemplateVersionOptionsModel.name(), "testString");
    assertEquals(createProfileTemplateVersionOptionsModel.description(), "testString");
    assertEquals(createProfileTemplateVersionOptionsModel.profile(), templateProfileComponentRequestModel);
    assertEquals(createProfileTemplateVersionOptionsModel.policyTemplateReferences(), java.util.Arrays.asList(policyTemplateReferenceModel));
    assertEquals(createProfileTemplateVersionOptionsModel.actionControls(), actionControlsModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateProfileTemplateVersionOptionsError() throws Throwable {
    new CreateProfileTemplateVersionOptions.Builder().build();
  }

}