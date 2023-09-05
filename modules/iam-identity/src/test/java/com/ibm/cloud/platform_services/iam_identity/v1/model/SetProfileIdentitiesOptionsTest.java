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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentityRequest;
import com.ibm.cloud.platform_services.iam_identity.v1.model.SetProfileIdentitiesOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetProfileIdentitiesOptions model.
 */
public class SetProfileIdentitiesOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetProfileIdentitiesOptions() throws Throwable {
    ProfileIdentityRequest profileIdentityRequestModel = new ProfileIdentityRequest.Builder()
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();
    assertEquals(profileIdentityRequestModel.identifier(), "testString");
    assertEquals(profileIdentityRequestModel.type(), "user");
    assertEquals(profileIdentityRequestModel.accounts(), java.util.Arrays.asList("testString"));
    assertEquals(profileIdentityRequestModel.description(), "testString");

    SetProfileIdentitiesOptions setProfileIdentitiesOptionsModel = new SetProfileIdentitiesOptions.Builder()
      .profileId("testString")
      .ifMatch("testString")
      .identities(java.util.Arrays.asList(profileIdentityRequestModel))
      .build();
    assertEquals(setProfileIdentitiesOptionsModel.profileId(), "testString");
    assertEquals(setProfileIdentitiesOptionsModel.ifMatch(), "testString");
    assertEquals(setProfileIdentitiesOptionsModel.identities(), java.util.Arrays.asList(profileIdentityRequestModel));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetProfileIdentitiesOptionsError() throws Throwable {
    new SetProfileIdentitiesOptions.Builder().build();
  }

}