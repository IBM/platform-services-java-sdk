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

package com.ibm.cloud.platform_services.iam_policy_management.v1.model;

import com.ibm.cloud.platform_services.iam_policy_management.v1.model.ControlResponseControl;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Grant;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.Roles;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.TemplateMetadata;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResource;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyResourceTag;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyRuleRuleAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicySubject;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicySubjectAttribute;
import com.ibm.cloud.platform_services.iam_policy_management.v1.model.V2PolicyTemplateMetaData;
import com.ibm.cloud.platform_services.iam_policy_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the V2PolicyTemplateMetaData model.
 */
public class V2PolicyTemplateMetaDataTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testV2PolicyTemplateMetaData() throws Throwable {
    V2PolicyTemplateMetaData v2PolicyTemplateMetaDataModel = new V2PolicyTemplateMetaData();
    assertNull(v2PolicyTemplateMetaDataModel.getType());
    assertNull(v2PolicyTemplateMetaDataModel.getDescription());
    assertNull(v2PolicyTemplateMetaDataModel.getSubject());
    assertNull(v2PolicyTemplateMetaDataModel.getResource());
    assertNull(v2PolicyTemplateMetaDataModel.getPattern());
    assertNull(v2PolicyTemplateMetaDataModel.getRule());
    assertNull(v2PolicyTemplateMetaDataModel.getControl());
    assertNull(v2PolicyTemplateMetaDataModel.getState());
    assertNull(v2PolicyTemplateMetaDataModel.getLastPermitAt());
    assertNull(v2PolicyTemplateMetaDataModel.getLastPermitFrequency());
    assertNull(v2PolicyTemplateMetaDataModel.getTemplate());
  }
}