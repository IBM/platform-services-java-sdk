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

package com.ibm.cloud.platform_services.configuration_governance.v1.model;

import com.ibm.cloud.platform_services.configuration_governance.v1.model.RuleScope;
import com.ibm.cloud.platform_services.configuration_governance.v1.model.UpdateAttachmentOptions;
import com.ibm.cloud.platform_services.configuration_governance.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateAttachmentOptions model.
 */
public class UpdateAttachmentOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateAttachmentOptions() throws Throwable {
    RuleScope ruleScopeModel = new RuleScope.Builder()
      .note("testString")
      .scopeId("testString")
      .scopeType("enterprise")
      .build();
    assertEquals(ruleScopeModel.note(), "testString");
    assertEquals(ruleScopeModel.scopeId(), "testString");
    assertEquals(ruleScopeModel.scopeType(), "enterprise");

    UpdateAttachmentOptions updateAttachmentOptionsModel = new UpdateAttachmentOptions.Builder()
      .ruleId("testString")
      .attachmentId("testString")
      .transactionId("testString")
      .ifMatch("testString")
      .accountId("testString")
      .includedScope(ruleScopeModel)
      .excludedScopes(new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)))
      .build();
    assertEquals(updateAttachmentOptionsModel.ruleId(), "testString");
    assertEquals(updateAttachmentOptionsModel.attachmentId(), "testString");
    assertEquals(updateAttachmentOptionsModel.transactionId(), "testString");
    assertEquals(updateAttachmentOptionsModel.ifMatch(), "testString");
    assertEquals(updateAttachmentOptionsModel.accountId(), "testString");
    assertEquals(updateAttachmentOptionsModel.includedScope(), ruleScopeModel);
    assertEquals(updateAttachmentOptionsModel.excludedScopes(), new java.util.ArrayList<RuleScope>(java.util.Arrays.asList(ruleScopeModel)));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateAttachmentOptionsError() throws Throwable {
    new UpdateAttachmentOptions.Builder().build();
  }

}