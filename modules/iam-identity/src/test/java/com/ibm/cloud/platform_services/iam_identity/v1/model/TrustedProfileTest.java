/*
 * (C) Copyright IBM Corp. 2025.
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

import com.ibm.cloud.platform_services.iam_identity.v1.model.Activity;
import com.ibm.cloud.platform_services.iam_identity.v1.model.EnityHistoryRecord;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.model.TrustedProfile;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the TrustedProfile model.
 */
public class TrustedProfileTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testTrustedProfile() throws Throwable {
    TrustedProfile trustedProfileModel = new TrustedProfile();
    assertNull(trustedProfileModel.getContext());
    assertNull(trustedProfileModel.getId());
    assertNull(trustedProfileModel.getEntityTag());
    assertNull(trustedProfileModel.getCrn());
    assertNull(trustedProfileModel.getName());
    assertNull(trustedProfileModel.getDescription());
    assertNull(trustedProfileModel.getEmail());
    assertNull(trustedProfileModel.getCreatedAt());
    assertNull(trustedProfileModel.getModifiedAt());
    assertNull(trustedProfileModel.getIamId());
    assertNull(trustedProfileModel.getAccountId());
    assertNull(trustedProfileModel.getTemplateId());
    assertNull(trustedProfileModel.getAssignmentId());
    assertNull(trustedProfileModel.getImsAccountId());
    assertNull(trustedProfileModel.getImsUserId());
    assertNull(trustedProfileModel.getHistory());
    assertNull(trustedProfileModel.getActivity());
  }
}