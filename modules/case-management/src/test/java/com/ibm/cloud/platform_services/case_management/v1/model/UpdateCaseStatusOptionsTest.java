/*
 * (C) Copyright IBM Corp. 2021.
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

package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.platform_services.case_management.v1.model.ResolvePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.UpdateCaseStatusOptions;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the UpdateCaseStatusOptions model.
 */
public class UpdateCaseStatusOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUpdateCaseStatusOptions() throws Throwable {
    ResolvePayload statusPayloadModel = new ResolvePayload.Builder()
      .action("resolve")
      .comment("testString")
      .resolutionCode(Long.valueOf("1"))
      .build();
    assertEquals(statusPayloadModel.action(), "resolve");
    assertEquals(statusPayloadModel.comment(), "testString");
    assertEquals(statusPayloadModel.resolutionCode(), Long.valueOf("1"));

    UpdateCaseStatusOptions updateCaseStatusOptionsModel = new UpdateCaseStatusOptions.Builder()
      .caseNumber("testString")
      .statusPayload(statusPayloadModel)
      .build();
    assertEquals(updateCaseStatusOptionsModel.caseNumber(), "testString");
    assertEquals(updateCaseStatusOptionsModel.statusPayload(), statusPayloadModel);
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUpdateCaseStatusOptionsError() throws Throwable {
    new UpdateCaseStatusOptions.Builder().build();
  }

}