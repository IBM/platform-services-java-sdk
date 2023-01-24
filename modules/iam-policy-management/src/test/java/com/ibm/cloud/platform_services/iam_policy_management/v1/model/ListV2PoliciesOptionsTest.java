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

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ListV2PoliciesOptions;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ListV2PoliciesOptions model.
 */
public class ListV2PoliciesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testListV2PoliciesOptions() throws Throwable {
    ListV2PoliciesOptions listV2PoliciesOptionsModel = new ListV2PoliciesOptions.Builder()
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
    assertEquals(listV2PoliciesOptionsModel.accountId(), "testString");
    assertEquals(listV2PoliciesOptionsModel.acceptLanguage(), "default");
    assertEquals(listV2PoliciesOptionsModel.iamId(), "testString");
    assertEquals(listV2PoliciesOptionsModel.accessGroupId(), "testString");
    assertEquals(listV2PoliciesOptionsModel.type(), "access");
    assertEquals(listV2PoliciesOptionsModel.serviceType(), "service");
    assertEquals(listV2PoliciesOptionsModel.serviceName(), "testString");
    assertEquals(listV2PoliciesOptionsModel.serviceGroupId(), "testString");
    assertEquals(listV2PoliciesOptionsModel.format(), "include_last_permit");
    assertEquals(listV2PoliciesOptionsModel.state(), "active");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testListV2PoliciesOptionsError() throws Throwable {
    new ListV2PoliciesOptions.Builder().build();
  }

}