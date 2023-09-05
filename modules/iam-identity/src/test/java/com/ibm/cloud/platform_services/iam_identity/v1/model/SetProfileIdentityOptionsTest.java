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

import com.ibm.cloud.platform_services.iam_identity.v1.model.SetProfileIdentityOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the SetProfileIdentityOptions model.
 */
public class SetProfileIdentityOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testSetProfileIdentityOptions() throws Throwable {
    SetProfileIdentityOptions setProfileIdentityOptionsModel = new SetProfileIdentityOptions.Builder()
      .profileId("testString")
      .identityType("user")
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();
    assertEquals(setProfileIdentityOptionsModel.profileId(), "testString");
    assertEquals(setProfileIdentityOptionsModel.identityType(), "user");
    assertEquals(setProfileIdentityOptionsModel.identifier(), "testString");
    assertEquals(setProfileIdentityOptionsModel.type(), "user");
    assertEquals(setProfileIdentityOptionsModel.accounts(), java.util.Arrays.asList("testString"));
    assertEquals(setProfileIdentityOptionsModel.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testSetProfileIdentityOptionsError() throws Throwable {
    new SetProfileIdentityOptions.Builder().build();
  }

}