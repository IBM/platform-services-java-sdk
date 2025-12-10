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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.LimitData;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyTemplateLimitData;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.RoleTemplateReferencesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Roles;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateControl;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateCountData;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateGrant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplatePolicy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyRuleRuleAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicySubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicySubjectAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PolicyTemplateLimitData model.
 */
public class PolicyTemplateLimitDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicyTemplateLimitData() throws Throwable {
    PolicyTemplateLimitData policyTemplateLimitDataModel = new PolicyTemplateLimitData();
    assertNull(policyTemplateLimitDataModel.getName());
    assertNull(policyTemplateLimitDataModel.getDescription());
    assertNull(policyTemplateLimitDataModel.getAccountId());
    assertNull(policyTemplateLimitDataModel.getVersion());
    assertNull(policyTemplateLimitDataModel.isCommitted());
    assertNull(policyTemplateLimitDataModel.getPolicy());
    assertNull(policyTemplateLimitDataModel.getState());
    assertNull(policyTemplateLimitDataModel.getCounts());
  }
}