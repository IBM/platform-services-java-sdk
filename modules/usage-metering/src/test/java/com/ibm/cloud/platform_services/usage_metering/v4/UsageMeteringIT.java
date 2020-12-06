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

package com.ibm.cloud.platform_services.usage_metering.v4;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.platform_services.usage_metering.v4.model.MeasureAndQuantity;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ReportResourceUsageOptions;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResourceInstanceUsage;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResponseAccepted;
import com.ibm.cloud.platform_services.usage_metering.v4.utils.TestUtilities;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * Integration test class for the UsageMetering service.
 */
public class UsageMeteringIT extends SdkIntegrationTestBase {
    public UsageMetering service = null;
    public static Map<String, String> config = null;
    final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
    final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

    @Override
    public String getConfigFilename() {
        return "../../usage_metering.env";
    }

    @Override
    public boolean loggingEnabled() {
        return true;
    }

    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = UsageMetering.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        config = CredentialUtils.getServiceProperties(UsageMetering.DEFAULT_SERVICE_NAME);
        assertNotNull(config);
        assertFalse(config.isEmpty());
        assertEquals(service.getServiceUrl(), config.get("URL"));

        log("Setup complete.");
    }

    @Test
    public void testReportResourceUsage() throws Exception {
        try {
            // We'll use the same start and end time since we're reporting events.
            long startTime = System.currentTimeMillis();
            long endTime = startTime;

            String resourceId = "cloudant";
            String resourceInstanceId = "crn:v1:staging:public:cloudantnosqldb:us-south:a/f5086e3df886495991303628d21da513:3aafbbee-88e2-4d29-b144-9d267d97064c::";
            String planId = "cloudant-standard";
            String region = "us-south";

            MeasureAndQuantity lookupMeasure = new MeasureAndQuantity.Builder()
                    .measure("LOOKUP")
                    .quantity(Long.valueOf(0))
                    .build();
            MeasureAndQuantity writeMeasure = new MeasureAndQuantity.Builder().measure("WRITE")
                    .quantity(Long.valueOf(0))
                    .build();
            MeasureAndQuantity queryMeasure = new MeasureAndQuantity.Builder().measure("QUERY")
                    .quantity(Long.valueOf(0))
                    .build();
            MeasureAndQuantity gbMeasure = new MeasureAndQuantity.Builder().measure("GIGABYTE")
                    .quantity(Long.valueOf(0))
                    .build();
            List<MeasureAndQuantity> measures = new ArrayList<>();
            measures.add(lookupMeasure);
            measures.add(writeMeasure);
            measures.add(queryMeasure);
            measures.add(gbMeasure);

            ResourceInstanceUsage resourceInstanceUsageModel = new ResourceInstanceUsage.Builder()
                    .resourceInstanceId(resourceInstanceId)
                    .planId(planId).region(region)
                    .start(startTime)
                    .end(endTime)
                    .measuredUsage(measures)
                    .build();

            ReportResourceUsageOptions reportResourceUsageOptions = new ReportResourceUsageOptions.Builder()
                    .resourceId(resourceId)
                    .resourceUsage(new java.util.ArrayList<ResourceInstanceUsage>(
                            java.util.Arrays.asList(resourceInstanceUsageModel)))
                    .build();

            // Invoke operation
            Response<ResponseAccepted> response = service.reportResourceUsage(reportResourceUsageOptions).execute();

            // Validate response
            assertNotNull(response);
            assertEquals(response.getStatusCode(), 202);

            ResponseAccepted responseAcceptedResult = response.getResult();
            assertNotNull(responseAcceptedResult);
            log(String.format(">>> reportResourceUsage response:\n%s", responseAcceptedResult.toString()));
        } catch (ServiceResponseException e) {
            fail(String.format("Service returned status code %d: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()));
        }
    }
}
