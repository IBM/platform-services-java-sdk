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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.DateUtils;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * Unit test class for the CreateObjectOptions model.
 */
public class CreateObjectOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateObjectOptions() throws Throwable {
    PublishObject publishObjectModel = new PublishObject.Builder()
      .permitIbmPublicPublish(true)
      .ibmApproved(true)
      .publicApproved(true)
      .portalApprovalRecord("testString")
      .portalUrl("testString")
      .build();
    assertEquals(publishObjectModel.permitIbmPublicPublish(), Boolean.valueOf(true));
    assertEquals(publishObjectModel.ibmApproved(), Boolean.valueOf(true));
    assertEquals(publishObjectModel.publicApproved(), Boolean.valueOf(true));
    assertEquals(publishObjectModel.portalApprovalRecord(), "testString");
    assertEquals(publishObjectModel.portalUrl(), "testString");

    State stateModel = new State.Builder()
      .current("testString")
      .currentEntered(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .pending("testString")
      .pendingRequested(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .previous("testString")
      .build();
    assertEquals(stateModel.current(), "testString");
    assertEquals(stateModel.currentEntered(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(stateModel.pending(), "testString");
    assertEquals(stateModel.pendingRequested(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(stateModel.previous(), "testString");

    CreateObjectOptions createObjectOptionsModel = new CreateObjectOptions.Builder()
      .catalogIdentifier("testString")
      .id("testString")
      .name("testString")
      .rev("testString")
      .crn("testString")
      .url("testString")
      .parentId("testString")
      .labelI18n("testString")
      .label("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .created(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .updated(DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"))
      .shortDescription("testString")
      .shortDescriptionI18n("testString")
      .kind("testString")
      .publish(publishObjectModel)
      .state(stateModel)
      .catalogId("testString")
      .catalogName("testString")
      .data(new java.util.HashMap<String, Object>() { { put("foo", "testString"); } })
      .build();
    assertEquals(createObjectOptionsModel.catalogIdentifier(), "testString");
    assertEquals(createObjectOptionsModel.id(), "testString");
    assertEquals(createObjectOptionsModel.name(), "testString");
    assertEquals(createObjectOptionsModel.rev(), "testString");
    assertEquals(createObjectOptionsModel.crn(), "testString");
    assertEquals(createObjectOptionsModel.url(), "testString");
    assertEquals(createObjectOptionsModel.parentId(), "testString");
    assertEquals(createObjectOptionsModel.labelI18n(), "testString");
    assertEquals(createObjectOptionsModel.label(), "testString");
    assertEquals(createObjectOptionsModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(createObjectOptionsModel.created(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createObjectOptionsModel.updated(), DateUtils.parseAsDateTime("2019-01-01T12:00:00.000Z"));
    assertEquals(createObjectOptionsModel.shortDescription(), "testString");
    assertEquals(createObjectOptionsModel.shortDescriptionI18n(), "testString");
    assertEquals(createObjectOptionsModel.kind(), "testString");
    assertEquals(createObjectOptionsModel.publish(), publishObjectModel);
    assertEquals(createObjectOptionsModel.state(), stateModel);
    assertEquals(createObjectOptionsModel.catalogId(), "testString");
    assertEquals(createObjectOptionsModel.catalogName(), "testString");
    assertEquals(createObjectOptionsModel.data(), new java.util.HashMap<String, Object>() { { put("foo", "testString"); } });
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateObjectOptionsError() throws Throwable {
    new CreateObjectOptions.Builder().build();
  }

}