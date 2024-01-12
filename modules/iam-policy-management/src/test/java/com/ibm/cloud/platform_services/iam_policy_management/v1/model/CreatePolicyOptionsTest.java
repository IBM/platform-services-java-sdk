/*
 * (C) Copyright IBM Corp. 2024.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRole;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicySubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.SubjectAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreatePolicyOptions model.
 */
public class CreatePolicyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreatePolicyOptions() throws Throwable {
    SubjectAttribute subjectAttributeModel = new SubjectAttribute.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(subjectAttributeModel.name(), "testString");
    assertEquals(subjectAttributeModel.value(), "testString");

    PolicySubject policySubjectModel = new PolicySubject.Builder()
      .attributes(java.util.Arrays.asList(subjectAttributeModel))
      .build();
    assertEquals(policySubjectModel.attributes(), java.util.Arrays.asList(subjectAttributeModel));

    PolicyRole policyRoleModel = new PolicyRole.Builder()
      .roleId("testString")
      .build();
    assertEquals(policyRoleModel.roleId(), "testString");

    ResourceAttribute resourceAttributeModel = new ResourceAttribute.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(resourceAttributeModel.name(), "testString");
    assertEquals(resourceAttributeModel.value(), "testString");
    assertEquals(resourceAttributeModel.operator(), "testString");

    ResourceTag resourceTagModel = new ResourceTag.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(resourceTagModel.name(), "testString");
    assertEquals(resourceTagModel.value(), "testString");
    assertEquals(resourceTagModel.operator(), "testString");

    PolicyResource policyResourceModel = new PolicyResource.Builder()
      .attributes(java.util.Arrays.asList(resourceAttributeModel))
      .tags(java.util.Arrays.asList(resourceTagModel))
      .build();
    assertEquals(policyResourceModel.attributes(), java.util.Arrays.asList(resourceAttributeModel));
    assertEquals(policyResourceModel.tags(), java.util.Arrays.asList(resourceTagModel));

    CreatePolicyOptions createPolicyOptionsModel = new CreatePolicyOptions.Builder()
      .type("testString")
      .subjects(java.util.Arrays.asList(policySubjectModel))
      .roles(java.util.Arrays.asList(policyRoleModel))
      .resources(java.util.Arrays.asList(policyResourceModel))
      .description("testString")
      .acceptLanguage("default")
      .build();
    assertEquals(createPolicyOptionsModel.type(), "testString");
    assertEquals(createPolicyOptionsModel.subjects(), java.util.Arrays.asList(policySubjectModel));
    assertEquals(createPolicyOptionsModel.roles(), java.util.Arrays.asList(policyRoleModel));
    assertEquals(createPolicyOptionsModel.resources(), java.util.Arrays.asList(policyResourceModel));
    assertEquals(createPolicyOptionsModel.description(), "testString");
    assertEquals(createPolicyOptionsModel.acceptLanguage(), "default");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePolicyOptionsError() throws Throwable {
    new CreatePolicyOptions.Builder().build();
  }

}