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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.AccountBasedMfaEnrollment;
import com.ibm.cloud.platform_services.iam_identity.v1.model.IdBasedMfaEnrollment;
import com.ibm.cloud.platform_services.iam_identity.v1.model.MfaEnrollmentTypeStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.model.MfaEnrollments;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ReportMfaEnrollmentStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.model.UserReportMfaEnrollmentStatus;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ReportMfaEnrollmentStatus model.
 */
public class ReportMfaEnrollmentStatusTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testReportMfaEnrollmentStatus() throws Throwable {
    ReportMfaEnrollmentStatus reportMfaEnrollmentStatusModel = new ReportMfaEnrollmentStatus();
    assertNull(reportMfaEnrollmentStatusModel.getCreatedBy());
    assertNull(reportMfaEnrollmentStatusModel.getReference());
    assertNull(reportMfaEnrollmentStatusModel.getReportTime());
    assertNull(reportMfaEnrollmentStatusModel.getAccountId());
    assertNull(reportMfaEnrollmentStatusModel.getImsAccountId());
    assertNull(reportMfaEnrollmentStatusModel.getUsers());
  }
}