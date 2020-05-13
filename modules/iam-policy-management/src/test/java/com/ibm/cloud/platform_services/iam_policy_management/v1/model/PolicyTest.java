/*
 * (C) Copyright IBM Corp. 2020.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Policy;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyBaseResourcesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyBaseResourcesItemAttributesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyBaseSubjectsItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyBaseSubjectsItemAttributesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRolesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Policy model.
 */
public class PolicyTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testPolicy() throws Throwable {
    Policy policyModel = new Policy();
    assertNull(policyModel.getId());
    assertNull(policyModel.getType());
    assertNull(policyModel.getSubjects());
    assertNull(policyModel.getRoles());
    assertNull(policyModel.getResources());
    assertNull(policyModel.getHref());
    assertNull(policyModel.getCreatedAt());
    assertNull(policyModel.getCreatedById());
    assertNull(policyModel.getLastModifiedAt());
    assertNull(policyModel.getLastModifiedById());
  }
}