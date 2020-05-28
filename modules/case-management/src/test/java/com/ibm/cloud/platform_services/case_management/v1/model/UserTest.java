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

import com.ibm.cloud.platform_services.case_management.v1.model.User;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the User model.
 */
public class UserTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testUser() throws Throwable {
    User userModel = new User.Builder()
      .realm("IBMid")
      .userId("abc@ibm.com")
      .build();
    assertEquals(userModel.realm(), "IBMid");
    assertEquals(userModel.userId(), "abc@ibm.com");

    String json = TestUtilities.serialize(userModel);

    User userModelNew = TestUtilities.deserialize(json, User.class);
    assertTrue(userModelNew instanceof User);
    assertEquals(userModelNew.realm(), "IBMid");
    assertEquals(userModelNew.userId(), "abc@ibm.com");
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testUserError() throws Throwable {
    new User.Builder().build();
  }

}