/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2ListPoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2ListPoliciesOptions model.
 */
public class V2ListPoliciesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2ListPoliciesOptions() throws Throwable {
    V2ListPoliciesOptions v2ListPoliciesOptionsModel = new V2ListPoliciesOptions.Builder()
      .accountId("testString")
      .acceptLanguage("default")
      .iamId("testString")
      .accessGroupId("testString")
      .type("access")
      .serviceType("service")
      .serviceName("testString")
      .serviceGroupId("testString")
      .format("include_last_permit")
      .state("active")
      .build();
    assertEquals(v2ListPoliciesOptionsModel.accountId(), "testString");
    assertEquals(v2ListPoliciesOptionsModel.acceptLanguage(), "default");
    assertEquals(v2ListPoliciesOptionsModel.iamId(), "testString");
    assertEquals(v2ListPoliciesOptionsModel.accessGroupId(), "testString");
    assertEquals(v2ListPoliciesOptionsModel.type(), "access");
    assertEquals(v2ListPoliciesOptionsModel.serviceType(), "service");
    assertEquals(v2ListPoliciesOptionsModel.serviceName(), "testString");
    assertEquals(v2ListPoliciesOptionsModel.serviceGroupId(), "testString");
    assertEquals(v2ListPoliciesOptionsModel.format(), "include_last_permit");
    assertEquals(v2ListPoliciesOptionsModel.state(), "active");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testV2ListPoliciesOptionsError() throws Throwable {
    new V2ListPoliciesOptions.Builder().build();
  }

}