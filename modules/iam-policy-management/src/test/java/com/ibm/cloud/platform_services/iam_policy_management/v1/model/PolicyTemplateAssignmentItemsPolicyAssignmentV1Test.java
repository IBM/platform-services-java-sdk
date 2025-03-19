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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.AssignmentResourceCreated;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.AssignmentTargetDetails;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.AssignmentTemplateDetails;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ConflictsWith;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ErrorDetails;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ErrorObject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ErrorResponse;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentResourcePolicy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentV1Resources;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentV1Subject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyTemplateAssignmentItemsPolicyAssignmentV1;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PolicyTemplateAssignmentItemsPolicyAssignmentV1 model.
 */
public class PolicyTemplateAssignmentItemsPolicyAssignmentV1Test {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicyTemplateAssignmentItemsPolicyAssignmentV1() throws Throwable {
    PolicyTemplateAssignmentItemsPolicyAssignmentV1 policyTemplateAssignmentItemsPolicyAssignmentV1Model = new PolicyTemplateAssignmentItemsPolicyAssignmentV1();
    assertNull(policyTemplateAssignmentItemsPolicyAssignmentV1Model.getTarget());
    assertNull(policyTemplateAssignmentItemsPolicyAssignmentV1Model.getResources());
    assertNull(policyTemplateAssignmentItemsPolicyAssignmentV1Model.getSubject());
    assertNull(policyTemplateAssignmentItemsPolicyAssignmentV1Model.getTemplate());
    assertNull(policyTemplateAssignmentItemsPolicyAssignmentV1Model.getStatus());
  }
}