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

package com.ibm.cloud.platform_services.case_management.v1.model;

import com.ibm.cloud.platform_services.case_management.v1.model.Attachment;
import com.ibm.cloud.platform_services.case_management.v1.model.Case;
import com.ibm.cloud.platform_services.case_management.v1.model.CaseEu;
import com.ibm.cloud.platform_services.case_management.v1.model.Comment;
import com.ibm.cloud.platform_services.case_management.v1.model.Offering;
import com.ibm.cloud.platform_services.case_management.v1.model.OfferingType;
import com.ibm.cloud.platform_services.case_management.v1.model.Resource;
import com.ibm.cloud.platform_services.case_management.v1.model.User;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Case model.
 */
public class CaseTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCase() throws Throwable {
    Case caseModel = new Case();
    assertNull(caseModel.getNumber());
    assertNull(caseModel.getShortDescription());
    assertNull(caseModel.getDescription());
    assertNull(caseModel.getCreatedAt());
    assertNull(caseModel.getCreatedBy());
    assertNull(caseModel.getUpdatedAt());
    assertNull(caseModel.getUpdatedBy());
    assertNull(caseModel.getContactType());
    assertNull(caseModel.getContact());
    assertNull(caseModel.getStatus());
    assertNull(caseModel.getSeverity());
    assertNull(caseModel.getSupportTier());
    assertNull(caseModel.getResolution());
    assertNull(caseModel.getCloseNotes());
    assertNull(caseModel.getEu());
    assertNull(caseModel.getWatchlist());
    assertNull(caseModel.getAttachments());
    assertNull(caseModel.getOffering());
    assertNull(caseModel.getResources());
    assertNull(caseModel.getComments());
  }
}