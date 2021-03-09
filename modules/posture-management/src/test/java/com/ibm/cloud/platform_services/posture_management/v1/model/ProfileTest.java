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

package com.ibm.cloud.platform_services.posture_management.v1.model;

import com.ibm.cloud.platform_services.posture_management.v1.model.ApplicabilityCriteria;
import com.ibm.cloud.platform_services.posture_management.v1.model.Profile;
import com.ibm.cloud.platform_services.posture_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Profile model.
 */
public class ProfileTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProfile() throws Throwable {
    Profile profileModel = new Profile();
    assertNull(profileModel.getName());
    assertNull(profileModel.getNoOfGoals());
    assertNull(profileModel.getDescription());
    assertNull(profileModel.getVersion());
    assertNull(profileModel.getCreatedBy());
    assertNull(profileModel.getModifiedBy());
    assertNull(profileModel.getReasonForDelete());
    assertNull(profileModel.getApplicabilityCriteria());
    assertNull(profileModel.getProfileId());
    assertNull(profileModel.getBaseProfile());
    assertNull(profileModel.getProfileType());
    assertNull(profileModel.getCreatedTime());
    assertNull(profileModel.getModifiedTime());
    assertNull(profileModel.isEnabled());
  }
}