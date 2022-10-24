/*
 * (C) Copyright IBM Corp. 2022.
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

import com.ibm.cloud.platform_services.case_management.v1.model.CasePayloadEu;
import com.ibm.cloud.platform_services.case_management.v1.model.CreateCaseOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Offering;
import com.ibm.cloud.platform_services.case_management.v1.model.OfferingType;
import com.ibm.cloud.platform_services.case_management.v1.model.ResourcePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.User;
import com.ibm.cloud.platform_services.case_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the CreateCaseOptions model.
 */
public class CreateCaseOptionsTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCreateCaseOptions() throws Throwable {
    CasePayloadEu casePayloadEuModel = new CasePayloadEu.Builder()
      .supported(true)
      .dataCenter(Long.valueOf("26"))
      .build();
    assertEquals(casePayloadEuModel.supported(), Boolean.valueOf(true));
    assertEquals(casePayloadEuModel.dataCenter(), Long.valueOf("26"));

    OfferingType offeringTypeModel = new OfferingType.Builder()
      .group("crn_service_name")
      .key("testString")
      .kind("testString")
      .id("testString")
      .build();
    assertEquals(offeringTypeModel.group(), "crn_service_name");
    assertEquals(offeringTypeModel.key(), "testString");
    assertEquals(offeringTypeModel.kind(), "testString");
    assertEquals(offeringTypeModel.id(), "testString");

    Offering offeringModel = new Offering.Builder()
      .name("testString")
      .type(offeringTypeModel)
      .build();
    assertEquals(offeringModel.name(), "testString");
    assertEquals(offeringModel.type(), offeringTypeModel);

    ResourcePayload resourcePayloadModel = new ResourcePayload.Builder()
      .crn("testString")
      .type("testString")
      .id(Double.valueOf("72.5"))
      .note("testString")
      .build();
    assertEquals(resourcePayloadModel.crn(), "testString");
    assertEquals(resourcePayloadModel.type(), "testString");
    assertEquals(resourcePayloadModel.id(), Double.valueOf("72.5"));
    assertEquals(resourcePayloadModel.note(), "testString");

    User userModel = new User.Builder()
      .realm("IBMid")
      .userId("abc@ibm.com")
      .build();
    assertEquals(userModel.realm(), "IBMid");
    assertEquals(userModel.userId(), "abc@ibm.com");

    CreateCaseOptions createCaseOptionsModel = new CreateCaseOptions.Builder()
      .type("technical")
      .subject("testString")
      .description("testString")
      .severity(Long.valueOf("1"))
      .eu(casePayloadEuModel)
      .offering(offeringModel)
      .resources(java.util.Arrays.asList(resourcePayloadModel))
      .watchlist(java.util.Arrays.asList(userModel))
      .invoiceNumber("testString")
      .slaCreditRequest(false)
      .build();
    assertEquals(createCaseOptionsModel.type(), "technical");
    assertEquals(createCaseOptionsModel.subject(), "testString");
    assertEquals(createCaseOptionsModel.description(), "testString");
    assertEquals(createCaseOptionsModel.severity(), Long.valueOf("1"));
    assertEquals(createCaseOptionsModel.eu(), casePayloadEuModel);
    assertEquals(createCaseOptionsModel.offering(), offeringModel);
    assertEquals(createCaseOptionsModel.resources(), java.util.Arrays.asList(resourcePayloadModel));
    assertEquals(createCaseOptionsModel.watchlist(), java.util.Arrays.asList(userModel));
    assertEquals(createCaseOptionsModel.invoiceNumber(), "testString");
    assertEquals(createCaseOptionsModel.slaCreditRequest(), Boolean.valueOf(false));
  }

  @Test(expectedExceptions = IllegalArgumentException.class)
  public void testCreateCaseOptionsError() throws Throwable {
    new CreateCaseOptions.Builder().build();
  }

}