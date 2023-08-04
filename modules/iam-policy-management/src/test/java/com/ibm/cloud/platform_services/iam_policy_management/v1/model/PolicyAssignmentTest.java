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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.AssignmentResourceCreated;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ConflictsWith;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ErrorDetails;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ErrorObject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ErrorResponse;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignment;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentRequestOptionsItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentResources;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyAssignmentResourcesPolicy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the PolicyAssignment model.
 */
public class PolicyAssignmentTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicyAssignment() throws Throwable {
    PolicyAssignment policyAssignmentModel = new PolicyAssignment();
    assertNull(policyAssignmentModel.getTemplateId());
    assertNull(policyAssignmentModel.getTemplateVersion());
    assertNull(policyAssignmentModel.getAssignmentId());
    assertNull(policyAssignmentModel.getTargetType());
    assertNull(policyAssignmentModel.getTarget());
    assertNull(policyAssignmentModel.getOptions());
    assertNull(policyAssignmentModel.getResources());
    assertNull(policyAssignmentModel.getStatus());
  }
}