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

package com.ibm.cloud.platform_services.iam_identity.v1.model;

import com.ibm.cloud.platform_services.iam_identity.v1.model.CreateClaimRuleOptions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ProfileClaimRuleConditions;
import com.ibm.cloud.platform_services.iam_identity.v1.model.ResponseContext;
import com.ibm.cloud.platform_services.iam_identity.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateClaimRuleOptions model.
 */
public class CreateClaimRuleOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateClaimRuleOptions() throws Throwable {
    ProfileClaimRuleConditions profileClaimRuleConditionsModel = new ProfileClaimRuleConditions.Builder()
      .claim("testString")
      .operator("testString")
      .value("testString")
      .build();
    assertEquals(profileClaimRuleConditionsModel.claim(), "testString");
    assertEquals(profileClaimRuleConditionsModel.operator(), "testString");
    assertEquals(profileClaimRuleConditionsModel.value(), "testString");

    ResponseContext responseContextModel = new ResponseContext.Builder()
      .transactionId("testString")
      .operation("testString")
      .userAgent("testString")
      .url("testString")
      .instanceId("testString")
      .threadId("testString")
      .host("testString")
      .startTime("testString")
      .endTime("testString")
      .elapsedTime("testString")
      .clusterName("testString")
      .build();
    assertEquals(responseContextModel.transactionId(), "testString");
    assertEquals(responseContextModel.operation(), "testString");
    assertEquals(responseContextModel.userAgent(), "testString");
    assertEquals(responseContextModel.url(), "testString");
    assertEquals(responseContextModel.instanceId(), "testString");
    assertEquals(responseContextModel.threadId(), "testString");
    assertEquals(responseContextModel.host(), "testString");
    assertEquals(responseContextModel.startTime(), "testString");
    assertEquals(responseContextModel.endTime(), "testString");
    assertEquals(responseContextModel.elapsedTime(), "testString");
    assertEquals(responseContextModel.clusterName(), "testString");

    CreateClaimRuleOptions createClaimRuleOptionsModel = new CreateClaimRuleOptions.Builder()
      .profileId("testString")
      .type("testString")
      .conditions(new java.util.ArrayList<ProfileClaimRuleConditions>(java.util.Arrays.asList(profileClaimRuleConditionsModel)))
      .context(responseContextModel)
      .name("testString")
      .realmName("testString")
      .crType("testString")
      .expiration(Long.valueOf("26"))
      .build();
    assertEquals(createClaimRuleOptionsModel.profileId(), "testString");
    assertEquals(createClaimRuleOptionsModel.type(), "testString");
    assertEquals(createClaimRuleOptionsModel.conditions(), new java.util.ArrayList<ProfileClaimRuleConditions>(java.util.Arrays.asList(profileClaimRuleConditionsModel)));
    assertEquals(createClaimRuleOptionsModel.context(), responseContextModel);
    assertEquals(createClaimRuleOptionsModel.name(), "testString");
    assertEquals(createClaimRuleOptionsModel.realmName(), "testString");
    assertEquals(createClaimRuleOptionsModel.crType(), "testString");
    assertEquals(createClaimRuleOptionsModel.expiration(), Long.valueOf("26"));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateClaimRuleOptionsError() throws Throwable {
    new CreateClaimRuleOptions.Builder().build();
  }

}