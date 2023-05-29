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

import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileIdentity;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the ProfileIdentity model.
 */
public class ProfileIdentityTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testProfileIdentity() throws Throwable {
    ProfileIdentity profileIdentityModel = new ProfileIdentity.Builder()
      .iamId("testString")
      .identifier("testString")
      .type("user")
      .accounts(java.util.Arrays.asList("testString"))
      .description("testString")
      .build();
    assertEquals(profileIdentityModel.iamId(), "testString");
    assertEquals(profileIdentityModel.identifier(), "testString");
    assertEquals(profileIdentityModel.type(), "user");
    assertEquals(profileIdentityModel.accounts(), java.util.Arrays.asList("testString"));
    assertEquals(profileIdentityModel.description(), "testString");

    String json = TestUtilities.serialize(profileIdentityModel);

    ProfileIdentity profileIdentityModelNew = TestUtilities.deserialize(json, ProfileIdentity.class);
    assertTrue(profileIdentityModelNew instanceof ProfileIdentity);
    assertEquals(profileIdentityModelNew.iamId(), "testString");
    assertEquals(profileIdentityModelNew.identifier(), "testString");
    assertEquals(profileIdentityModelNew.type(), "user");
    assertEquals(profileIdentityModelNew.description(), "testString");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testProfileIdentityError() throws Throwable {
    new ProfileIdentity.Builder().build();
  }

}