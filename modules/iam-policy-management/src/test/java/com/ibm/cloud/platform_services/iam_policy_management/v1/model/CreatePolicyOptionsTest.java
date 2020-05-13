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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.CreatePolicyOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRequestResourcesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRequestResourcesItemAttributesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRequestRolesItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRequestSubjectsItem;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.PolicyRequestSubjectsItemAttributesItem;
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
 * Unit test class for the CreatePolicyOptions model.
 */
public class CreatePolicyOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreatePolicyOptions() throws Throwable {
    PolicyRequestResourcesItemAttributesItem policyRequestResourcesItemAttributesItemModel = new PolicyRequestResourcesItemAttributesItem.Builder()
      .name("testString")
      .value("testString")
      .operator("testString")
      .build();
    assertEquals(policyRequestResourcesItemAttributesItemModel.name(), "testString");
    assertEquals(policyRequestResourcesItemAttributesItemModel.value(), "testString");
    assertEquals(policyRequestResourcesItemAttributesItemModel.operator(), "testString");

    PolicyRequestSubjectsItemAttributesItem policyRequestSubjectsItemAttributesItemModel = new PolicyRequestSubjectsItemAttributesItem.Builder()
      .name("testString")
      .value("testString")
      .build();
    assertEquals(policyRequestSubjectsItemAttributesItemModel.name(), "testString");
    assertEquals(policyRequestSubjectsItemAttributesItemModel.value(), "testString");

    PolicyRequestResourcesItem policyRequestResourcesItemModel = new PolicyRequestResourcesItem.Builder()
      .attributes(new ArrayList<PolicyRequestResourcesItemAttributesItem>(Arrays.asList(policyRequestResourcesItemAttributesItemModel)))
      .build();
    assertEquals(policyRequestResourcesItemModel.attributes(), new ArrayList<PolicyRequestResourcesItemAttributesItem>(Arrays.asList(policyRequestResourcesItemAttributesItemModel)));

    PolicyRequestRolesItem policyRequestRolesItemModel = new PolicyRequestRolesItem.Builder()
      .roleId("testString")
      .build();
    assertEquals(policyRequestRolesItemModel.roleId(), "testString");

    PolicyRequestSubjectsItem policyRequestSubjectsItemModel = new PolicyRequestSubjectsItem.Builder()
      .attributes(new ArrayList<PolicyRequestSubjectsItemAttributesItem>(Arrays.asList(policyRequestSubjectsItemAttributesItemModel)))
      .build();
    assertEquals(policyRequestSubjectsItemModel.attributes(), new ArrayList<PolicyRequestSubjectsItemAttributesItem>(Arrays.asList(policyRequestSubjectsItemAttributesItemModel)));

    CreatePolicyOptions createPolicyOptionsModel = new CreatePolicyOptions.Builder()
      .type("testString")
      .subjects(new ArrayList<PolicyRequestSubjectsItem>(Arrays.asList(policyRequestSubjectsItemModel)))
      .roles(new ArrayList<PolicyRequestRolesItem>(Arrays.asList(policyRequestRolesItemModel)))
      .resources(new ArrayList<PolicyRequestResourcesItem>(Arrays.asList(policyRequestResourcesItemModel)))
      .acceptLanguage("testString")
      .build();
    assertEquals(createPolicyOptionsModel.type(), "testString");
    assertEquals(createPolicyOptionsModel.subjects(), new ArrayList<PolicyRequestSubjectsItem>(Arrays.asList(policyRequestSubjectsItemModel)));
    assertEquals(createPolicyOptionsModel.roles(), new ArrayList<PolicyRequestRolesItem>(Arrays.asList(policyRequestRolesItemModel)));
    assertEquals(createPolicyOptionsModel.resources(), new ArrayList<PolicyRequestResourcesItem>(Arrays.asList(policyRequestResourcesItemModel)));
    assertEquals(createPolicyOptionsModel.acceptLanguage(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreatePolicyOptionsError() throws Throwable {
    new CreatePolicyOptions.Builder().build();
  }

}